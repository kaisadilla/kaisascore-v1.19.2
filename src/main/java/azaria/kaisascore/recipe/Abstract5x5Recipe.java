package azaria.kaisascore.recipe;

import azaria.kaisascore.container.inventory.CraftingStationMatrixContainer;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;

public abstract class Abstract5x5Recipe implements Recipe<Container> {
    public static final int MATRIX_SIZE = 5;

    protected final ResourceLocation _id;
    protected final int _width;
    protected final int _height;
    protected final NonNullList<Ingredient> _ingredients;
    protected final ItemStack _result;

    public Abstract5x5Recipe (
        ResourceLocation id,
        int width,
        int height,
        NonNullList<Ingredient> ingredients,
        ItemStack result
    ) {
        _id = id;
        _width = width;
        _height = height;
        _ingredients = ingredients;
        _result = result;
    }

    public int getWidth () { return _width; }
    public int getHeight () { return _height; }

    @Override
    public ResourceLocation getId () {
        return _id;
    }

    @Override
    public NonNullList<Ingredient> getIngredients () {
        return _ingredients;
    }

    @Override
    public ItemStack getResultItem () {
        return _result;
    }

    @Override
    public boolean canCraftInDimensions (int width, int height) {
        return true;
        //return width >= MATRIX_SIZE && height >= MATRIX_SIZE;
    }

    @Override
    public boolean matches (Container container, Level level) {
        var craftContainer = (CraftingStationMatrixContainer)container;

        // check every possible position in the 5x5 grid where the pattern
        // can be. If any of these positions matches the pattern, then it's
        // a valid way to apply this recipe.
        for (int x = 0; x <= craftContainer.getWidth() - _width; x++) {
            for (int y = 0; y <= craftContainer.getHeight() - _height; y++) {
                if (matchesFromTopLeft(craftContainer, x, y)) return true;
            }
        }

        return false;
    }

    @Override
    public ItemStack assemble (Container pContainer) {
        return getResultItem().copy();
    }

    /**
     * Checks this recipe's pattern against a subarea of the container,
     * starting at the topleft position defined by the parameters.
     * @param container The container to try this recipe on.
     * @param left The x position of the topleft slot in the container.
     * @param top The y position of the topleft slot in the container.
     */
    private boolean matchesFromTopLeft (
        CraftingStationMatrixContainer container, int left, int top
    ) {
        // x and y are relative to the container's chosen top left, and
        // absolute to the recipe.
        for (int x = 0; x < _width; x++) {
            for (int y = 0; y < _height; y++) {
                // xAbs and yAbs are absolute to the container.
                int xAbs = x + left;
                int yAbs = y + top;

                if (xAbs < 0 || yAbs < 0 ||
                    xAbs >= container.getWidth() || yAbs >= container.getHeight()
                ) {
                    continue;
                }

                var ingr = _ingredients.get(x + (y * _width));
                var contItem = container.getItem(xAbs + (yAbs * container.getWidth()));

                if (ingr.test(contItem) == false) {
                    return false;
                }
            }
        }

        return true;
    }

    public interface Factory<T extends Abstract5x5Recipe> {
        T create (
            ResourceLocation recipeId,
            int width,
            int height,
            NonNullList<Ingredient> ingredients,
            ItemStack result
        );
    }
}
