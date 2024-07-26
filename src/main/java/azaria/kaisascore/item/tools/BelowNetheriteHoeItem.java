package azaria.kaisascore.item.tools;

import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.NotNull;

public class BelowNetheriteHoeItem extends HoeItem {
    private boolean _isEnchantable = true;

    public BelowNetheriteHoeItem (
        Tier pTier,
        int pAttackDamageModifier,
        float pAttackSpeedModifier,
        Properties pProperties
    ) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    public BelowNetheriteHoeItem setEnchantable (boolean enchantable) {
        _isEnchantable = enchantable;
        return this;
    }

    @Override
    public boolean isCorrectToolForDrops (ItemStack stack, @NotNull BlockState state) {
        if (state.is(Tags.Blocks.NEEDS_NETHERITE_TOOL)) {
            return false;
        }

        return super.isCorrectToolForDrops (stack, state);
    }

    @Override
    public boolean isEnchantable (ItemStack pStack) {
        if (_isEnchantable == false) {
            return false;
        }

        return super.isEnchantable(pStack);
    }

    @Override
    public int getEnchantmentValue () {
        return super.getEnchantmentValue();
    }
}
