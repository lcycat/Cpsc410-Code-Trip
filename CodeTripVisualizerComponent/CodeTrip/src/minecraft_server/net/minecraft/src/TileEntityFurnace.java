package net.minecraft.src;

public class TileEntityFurnace extends TileEntity implements IInventory
{
    private ItemStack furnaceItemStacks[];

    /** The number of ticks that the furnace will keep burning */
    public int furnaceBurnTime;

    /**
     * The number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for
     */
    public int currentItemBurnTime;

    /** The number of ticks that the current item has been cooking for */
    public int furnaceCookTime;

    public TileEntityFurnace()
    {
        furnaceItemStacks = new ItemStack[3];
        furnaceBurnTime = 0;
        currentItemBurnTime = 0;
        furnaceCookTime = 0;
    }

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return furnaceItemStacks.length;
    }

    /**
     * Returns the stack in slot i
     */
    public ItemStack getStackInSlot(int par1)
    {
        return furnaceItemStacks[par1];
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
    public ItemStack decrStackSize(int par1, int par2)
    {
        if (furnaceItemStacks[par1] != null)
        {
            if (furnaceItemStacks[par1].stackSize <= par2)
            {
                ItemStack itemstack = furnaceItemStacks[par1];
                furnaceItemStacks[par1] = null;
                return itemstack;
            }

            ItemStack itemstack1 = furnaceItemStacks[par1].splitStack(par2);

            if (furnaceItemStacks[par1].stackSize == 0)
            {
                furnaceItemStacks[par1] = null;
            }

            return itemstack1;
        }
        else
        {
            return null;
        }
    }

    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
    public ItemStack getStackInSlotOnClosing(int par1)
    {
        if (furnaceItemStacks[par1] != null)
        {
            ItemStack itemstack = furnaceItemStacks[par1];
            furnaceItemStacks[par1] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
    {
        furnaceItemStacks[par1] = par2ItemStack;

        if (par2ItemStack != null && par2ItemStack.stackSize > getInventoryStackLimit())
        {
            par2ItemStack.stackSize = getInventoryStackLimit();
        }
    }

    /**
     * Returns the name of the inventory.
     */
    public String getInvName()
    {
        return "container.furnace";
    }

    /**
     * Reads a tile entity from NBT.
     */
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items");
        furnaceItemStacks = new ItemStack[getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); i++)
        {
            NBTTagCompound nbttagcompound = (NBTTagCompound)nbttaglist.tagAt(i);
            byte byte0 = nbttagcompound.getByte("Slot");

            if (byte0 >= 0 && byte0 < furnaceItemStacks.length)
            {
                furnaceItemStacks[byte0] = ItemStack.loadItemStackFromNBT(nbttagcompound);
            }
        }

        furnaceBurnTime = par1NBTTagCompound.getShort("BurnTime");
        furnaceCookTime = par1NBTTagCompound.getShort("CookTime");
        currentItemBurnTime = getItemBurnTime(furnaceItemStacks[1]);
    }

    /**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("BurnTime", (short)furnaceBurnTime);
        par1NBTTagCompound.setShort("CookTime", (short)furnaceCookTime);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < furnaceItemStacks.length; i++)
        {
            if (furnaceItemStacks[i] != null)
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setByte("Slot", (byte)i);
                furnaceItemStacks[i].writeToNBT(nbttagcompound);
                nbttaglist.appendTag(nbttagcompound);
            }
        }

        par1NBTTagCompound.setTag("Items", nbttaglist);
    }

    /**
     * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended. *Isn't
     * this more of a set than a get?*
     */
    public int getInventoryStackLimit()
    {
        return 64;
    }

    /**
     * Returns true if the furnace is currently burning
     */
    public boolean isBurning()
    {
        return furnaceBurnTime > 0;
    }

    /**
     * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
     * ticks and creates a new spawn inside its implementation.
     */
    public void updateEntity()
    {
        boolean flag = furnaceBurnTime > 0;
        boolean flag1 = false;

        if (furnaceBurnTime > 0)
        {
            furnaceBurnTime--;
        }

        if (!worldObj.isRemote)
        {
            if (furnaceBurnTime == 0 && canSmelt())
            {
                currentItemBurnTime = furnaceBurnTime = getItemBurnTime(furnaceItemStacks[1]);

                if (furnaceBurnTime > 0)
                {
                    flag1 = true;

                    if (furnaceItemStacks[1] != null)
                    {
                        furnaceItemStacks[1].stackSize--;

                        if (furnaceItemStacks[1].stackSize == 0)
                        {
                            Item item = furnaceItemStacks[1].getItem().getContainerItem();
                            furnaceItemStacks[1] = item == null ? null : new ItemStack(item);
                        }
                    }
                }
            }

            if (isBurning() && canSmelt())
            {
                furnaceCookTime++;

                if (furnaceCookTime == 200)
                {
                    furnaceCookTime = 0;
                    smeltItem();
                    flag1 = true;
                }
            }
            else
            {
                furnaceCookTime = 0;
            }

            if (flag != (furnaceBurnTime > 0))
            {
                flag1 = true;
                BlockFurnace.updateFurnaceBlockState(furnaceBurnTime > 0, worldObj, xCoord, yCoord, zCoord);
            }
        }

        if (flag1)
        {
            onInventoryChanged();
        }
    }

    /**
     * Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    private boolean canSmelt()
    {
        if (furnaceItemStacks[0] == null)
        {
            return false;
        }
        else
        {
            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(furnaceItemStacks[0].getItem().shiftedIndex);
            return itemstack != null ? furnaceItemStacks[2] != null ? furnaceItemStacks[2].isItemEqual(itemstack) ? furnaceItemStacks[2].stackSize >= getInventoryStackLimit() || furnaceItemStacks[2].stackSize >= furnaceItemStacks[2].getMaxStackSize() ? furnaceItemStacks[2].stackSize < itemstack.getMaxStackSize() : true : false : true : false;
        }
    }

    /**
     * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
     */
    public void smeltItem()
    {
        if (canSmelt())
        {
            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(furnaceItemStacks[0].getItem().shiftedIndex);

            if (furnaceItemStacks[2] == null)
            {
                furnaceItemStacks[2] = itemstack.copy();
            }
            else if (furnaceItemStacks[2].itemID == itemstack.itemID)
            {
                furnaceItemStacks[2].stackSize++;
            }

            furnaceItemStacks[0].stackSize--;

            if (furnaceItemStacks[0].stackSize <= 0)
            {
                furnaceItemStacks[0] = null;
            }
        }
    }

    /**
     * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
     * fuel
     */
    public static int getItemBurnTime(ItemStack par0ItemStack)
    {
        if (par0ItemStack == null)
        {
            return 0;
        }

        int i = par0ItemStack.getItem().shiftedIndex;
        Item item = par0ItemStack.getItem();

        if (i < 256 && Block.blocksList[i] != null)
        {
            Block block = Block.blocksList[i];

            if (block == Block.woodSingleSlab)
            {
                return 150;
            }

            if (block.blockMaterial == Material.wood)
            {
                return 300;
            }
        }

        return !(item instanceof ItemTool) || !((ItemTool)item).func_77861_e().equals("WOOD") ? !(item instanceof ItemSword) || !((ItemSword)item).func_77825_f().equals("WOOD") ? !(item instanceof ItemHoe) || !((ItemHoe)item).func_77842_f().equals("WOOD") ? i != Item.stick.shiftedIndex ? i != Item.coal.shiftedIndex ? i != Item.bucketLava.shiftedIndex ? i != Block.sapling.blockID ? i != Item.blazeRod.shiftedIndex ? ModLoader.addAllFuel(par0ItemStack.itemID, par0ItemStack.getItemDamage()) : 2400 : 100 : 20000 : 1600 : 100 : 200 : 200 : 200;
    }

    /**
     * Return true if item is a fuel source (getItemBurnTime() > 0).
     */
    public static boolean isItemFuel(ItemStack par0ItemStack)
    {
        return getItemBurnTime(par0ItemStack) > 0;
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
    {
        return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this ? par1EntityPlayer.getDistanceSq((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 64D : false;
    }

    public void openChest()
    {
    }

    public void closeChest()
    {
    }
}
