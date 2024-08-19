package azaria.kaisascore.recipe;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.common.crafting.CraftingHelper;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Set;

public abstract class Abstract5x5RecipeSerializer<T extends Abstract5x5Recipe>
    implements RecipeSerializer<T>
{
    protected Abstract5x5Recipe.Factory<T> _factory;

    public Abstract5x5RecipeSerializer (Abstract5x5Recipe.Factory<T> factory) {
        _factory = factory;
    }

    @Override
    public T fromJson (
        ResourceLocation recipeId, JsonObject jsonRecipe
    ) {
        Map<String, Ingredient> keyObj = keyFromJson(
            GsonHelper.getAsJsonObject(jsonRecipe, "key")
        );

        String[] pattern = trimPattern(patternFromJson(
            GsonHelper.getAsJsonArray(jsonRecipe, "pattern"))
        );

        int width = pattern[0].length();
        int height = pattern.length;

        var ingredients = createIngredientList(pattern, keyObj, width, height);
        var result = CraftingHelper.getItemStack(
            GsonHelper.getAsJsonObject(jsonRecipe, "result"), true, true
        );

        return _factory.create(
            recipeId, width, height, ingredients, result
        );
    }

    @Override
    public @Nullable T fromNetwork (
        ResourceLocation recipeId, FriendlyByteBuf buffer
    ) {
        int width = buffer.readInt();
        int height = buffer.readInt();

        NonNullList<Ingredient> ingredients = NonNullList.withSize(
            width * height, Ingredient.EMPTY
        );

        for (int i = 0; i < ingredients.size(); i++) {
            ingredients.set(i, Ingredient.fromNetwork(buffer));
        }

        var result = buffer.readItem();

        return _factory.create(
            recipeId, width, height, ingredients, result
        );
    }

    @Override
    public void toNetwork (
        FriendlyByteBuf buffer, T recipe
    ) {
        buffer.writeInt(recipe._width);
        buffer.writeInt(recipe._height);

        for (Ingredient ingredient : recipe._ingredients) {
            ingredient.toNetwork(buffer);
        }

        buffer.writeItem(recipe._result);
    }

    /**
     * Reads the 'key' object from the json and produces a dictionary of
     * characters and ingredients.
     * @param jsonKeyObj The 'key' object in the recipe's json.
     */
    private static Map<String, Ingredient> keyFromJson (JsonObject jsonKeyObj) {
        Map<String, Ingredient> map = Maps.newHashMap();

        for (Map.Entry<String, JsonElement> entry : jsonKeyObj.entrySet()) {
            // keys must be one single char, and that char cannot be a space.
            if (entry.getKey().length() != 1) {
                throw new JsonSyntaxException(
                    "Invalid key entry: '"
                        + (String)entry.getKey()
                        + "' is an invalid symbol (must be 1 character only)."
                );
            }
            if (entry.getKey().equals(" ")) {
                throw new JsonSyntaxException(
                    "Invalid key entry: ' ' is a reserved symbol."
                );
            }

            map.put(entry.getKey(), Ingredient.fromJson(entry.getValue()));
        }

        map.put(" ", Ingredient.EMPTY);
        return map;
    }

    private static String[] patternFromJson (JsonArray jsonPattern) {
        String[] patternLines = new String[jsonPattern.size()];

        throwIfLengthIsInvalid(patternLines.length);

        for (int y = 0; y < patternLines.length; y++) {
            String lineStr = GsonHelper.convertToString(
                jsonPattern.get(y), "pattern[" + y + "]"
            );

            throwIfLengthIsInvalid(lineStr.length());

            patternLines[y] = lineStr;
        }

        return patternLines;
    }

    /**
     * Removes rows and columns in the pattern that don't contain any
     * ingredient.
     * @param fullPattern An untrimmed pattern.
     */
    private static String[] trimPattern (String ... fullPattern) {
        int firstCol = Integer.MAX_VALUE;
        int lastCol = 0; // counting forward from the first column, the last column with something.
        int firstRow = 0; // counting forward from the first row, the last
        int firstRowFromEnd = 0; // counting backwards from the last row, the first row you'd find with something.

        for (int y = 0; y < fullPattern.length; ++y) {
            String row = fullPattern[y];
            firstCol = Math.min(firstCol, firstNonSpace(row));
            int lastColThisRow = lastNonSpace(row);
            lastCol = Math.max(lastCol, lastColThisRow);

            if (lastColThisRow < 0) {
                if (firstRow == y) {
                    firstRow++;
                }

                firstRowFromEnd++;
            }
            else {
                firstRowFromEnd = 0;
            }
        }

        if (fullPattern.length == firstRowFromEnd) {
            return new String[0];
        }
        else {
            String[] rows = new String[
                fullPattern.length - firstRowFromEnd - firstRow
                ];

            for (int y = 0; y < rows.length; ++y) {
                rows[y] = fullPattern[y + firstRow]
                    .substring(firstCol, lastCol + 1);
            }

            return rows;
        }
    }

    /**
     * Returns the first character in a pattern's row that isn't a space.
     * @param str The pattern's row.
     */
    private static int firstNonSpace (String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') return i;
        }
        return str.length();
    }

    /**
     * Returns the last character in a pattern's row that isn't a space.
     * @param str The pattern's row.
     */
    private static int lastNonSpace (String str) {
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) != ' ') return i;
        }
        return -1;
    }

    /**
     * Throws an error if the given length is 0 or less; or bigger than this
     * recipe's matrix size.
     * @param length The length to test.
     */
    private static void throwIfLengthIsInvalid (int length) {
        if (length > Abstract5x5Recipe.MATRIX_SIZE) {
            throw new JsonSyntaxException(
                "Invalid pattern: pattern grid size cannot be more than 5."
            );
        }
        if (length <= 0) {
            throw new JsonSyntaxException(
                "Invalid pattern: empty pattern and empty rows are not allowed."
            );
        }
    }

    /**
     * Builds a list of ingredients from a pattern and an object that maps
     * pattern characters to ingredients. The list contains the pattern
     * horizontally, where [1] is x=1, y=0.
     * @param pattern The pattern to use.
     * @param keyObj The object that maps characters to ingredients.
     * @param width The pattern's width.
     * @param height The pattern's height.
     * @return
     */
    private static NonNullList<Ingredient> createIngredientList (
        String[] pattern, Map<String, Ingredient> keyObj, int width, int height
    ) {
        NonNullList<Ingredient> ingredients = NonNullList.withSize(
            width * height, Ingredient.EMPTY
        );

        Set<String> keys = Sets.newHashSet(keyObj.keySet());
        keys.remove(" ");

        for (int y = 0; y < pattern.length; y++) {
            for (int x = 0; x < pattern[y].length(); x++) {
                var str = pattern[y].substring(x, x + 1); // char at x as string
                var ingredient = keyObj.get(str); // ingredient assigned to that char.

                if (ingredient == null) {
                    throw new JsonSyntaxException(
                        "Pattern references symbol '"
                            + str
                            + "' but it's not defined in the key"
                    );
                }

                keys.remove(str);
                ingredients.set(x + (width * y), ingredient);
            }
        }

        if (keys.isEmpty() == false) {
            throw new JsonSyntaxException(
                "Key defines symbols that aren't used in pattern: " + keys
            );
        }

        return ingredients;
    }
}
