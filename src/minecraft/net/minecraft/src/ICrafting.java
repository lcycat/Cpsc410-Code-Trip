package net.minecraft.src;

import java.util.List;

public interface ICrafting
{
    public abstract void sendContainerAndContentsToPlayer(Container container, List list);

    /**
     * inform the player of a change in a single slot
     */
    public abstract void updateCraftingInventorySlot(Container container, int i, ItemStack itemstack);

    /**
     * send information about the crafting inventory to the client(currently only for furnace times)
     */
    public abstract void updateCraftingInventoryInfo(Container container, int i, int j);
}
