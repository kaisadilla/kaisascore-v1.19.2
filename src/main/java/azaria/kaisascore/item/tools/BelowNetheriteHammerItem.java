package azaria.kaisascore.item.tools;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundBlockUpdatePacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.level.BlockEvent;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

public class BelowNetheriteHammerItem extends HammerItem {
    private boolean _isEnchantable = true;

    public BelowNetheriteHammerItem (
        Tier pTier,
        int pAttackDamageModifier,
        float pAttackSpeedModifier,
        Properties pProperties
    ) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    public BelowNetheriteHammerItem setEnchantable (boolean enchantable) {
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
}
