package minneo.sparkmod.block.entity;

import minneo.sparkmod.item.ModItems;
import minneo.sparkmod.screen.HeavyWorkbenchScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class HeavyWorkbenchBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {

    private final DefaultedList<ItemStack> inventory =
            DefaultedList.ofSize(22, ItemStack.EMPTY);

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;

    public HeavyWorkbenchBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.HEAVY_WORKBENCH_BE, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> HeavyWorkbenchBlockEntity.this.progress;
                    case 1 -> HeavyWorkbenchBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0: HeavyWorkbenchBlockEntity.this.progress = value;
                    case 1: HeavyWorkbenchBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Heavy Workbench");
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("heavy_workbench.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        progress = nbt.getInt("heavy_workbench.progress");
        super.readNbt(nbt);
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new HeavyWorkbenchScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    public static void tick(World world, BlockPos blockPos, BlockState state, HeavyWorkbenchBlockEntity entity) {

        if(world.isClient()) { return; }

        if(hasRecipe(entity)) {
            entity.progress++;
            markDirty(world, blockPos, state);
            if(entity.progress >= entity.maxProgress) {
                craftItem(entity);
            }
        }
        else {
            entity.resetProgress();
            markDirty(world, blockPos, state);
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static void craftItem(HeavyWorkbenchBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for(int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        if(hasRecipe(entity)) {
            entity.removeStack(1, 1);

            entity.setStack(22, new ItemStack(ModItems.TUNGSTEN,
                    entity.getStack(2).getCount() + 1));

            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(HeavyWorkbenchBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for(int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        boolean hasIngotInFirstSlot = entity.getStack(1).getItem() == ModItems.RAW_TUNGSTEN;

        return hasIngotInFirstSlot && canInsertAmountIntoOutpuSlot(inventory, 1) && canInsertItemIntoOutputSlot(inventory, ModItems.TUNGSTEN);
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, Item output) {
        return inventory.getStack(22).getItem() == output || inventory.getStack(22).isEmpty();
    }

    private static boolean canInsertAmountIntoOutpuSlot(SimpleInventory inventory, int count) {
        return inventory.getStack(22).getMaxCount() > inventory.getStack(22).getCount();
    }
}
