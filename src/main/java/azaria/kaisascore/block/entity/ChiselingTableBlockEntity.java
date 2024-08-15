package azaria.kaisascore.block.entity;

import azaria.kaisascore.recipe.ChiselingTableRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class ChiselingTableBlockEntity extends BlockEntity implements MenuProvider {
    public static final int CONTAINER_SIZE = 2;

    private Optional<ChiselingTableRecipe> _recipe = Optional.empty();

    private final ItemStackHandler _itemHandler = new ItemStackHandler(CONTAINER_SIZE) {
        @Override
        protected void onContentsChanged (int slot) {
            if (level.isClientSide()) return;

            setChanged();
        }
    };

    private LazyOptional<IItemHandler> _lazyItemHandler = LazyOptional.empty();

    public ChiselingTableBlockEntity (BlockPos pos, BlockState state) {
        super(ModBlockEntities.CHISELING_TABLE.get(), pos, state);
    }

    @Override
    public Component getDisplayName () {
        return null;
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu (int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return null;
    }

    public void dropContents () {

    }
}
