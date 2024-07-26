package azaria.kaisascore.item.tools;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class HammerItem extends PickaxeItem {
    public HammerItem (
        Tier pTier,
        int pAttackDamageModifier,
        float pAttackSpeedModifier,
        Properties pProperties
    ) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean canAttackBlock (BlockState state, Level level, BlockPos target, Player player) {
        int radius = player.isShiftKeyDown() ? 0 : 1;
        var targetBState = level.getBlockState(target);
        float targetHardness = targetBState.getDestroySpeed(level, target);

        // Breaks in a radius only when this tool is the correct one to mine its
        // direct target.
        if (player.getMainHandItem().isCorrectToolForDrops(targetBState)) {
            ToolHarvesting.breakInRadius(level, player, target, radius, 0, bState -> {
                boolean isEffective = player.getMainHandItem().isCorrectToolForDrops(bState);
                if (isEffective == false) return false;

                float hardness = bState.getDestroySpeed(level, target);
                if (hardness > targetHardness) return false;
                if (hardness <= 0) return false;

                return true;
            });
        }

        return true;
    }
}
