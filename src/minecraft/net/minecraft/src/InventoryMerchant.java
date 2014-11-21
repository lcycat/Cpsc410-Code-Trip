package net.minecraft.src;

public class InventoryMerchant implements IInventory
{
    private final IMerchant theMerchant;
    private ItemStack theInventory[];
    private final EntityPlayer thePlayer;
    private MerchantRecipe currentRecipe;
    private int currentRecipeIndex;

    public InventoryMerchant(EntityPlayer par1EntityPlayer, IMerchant par2IMerchant)
    {
        theInventory = new ItemStack[3];
        thePlayer = par1EntityPlayer;
        theMerchant = par2IMerchant;
    }

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return theInventory.length;
    }

    /**
     * Returns the stack in slot i
     */
    public ItemStack getStackInSlot(int par1)
    {
        return theInventory[par1];
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
    public ItemStack decrStackSize(int par1, int par2)
    {
        if (theInventory[par1] != null)
        {
            if (par1 == 2)
            {
                ItemStack itemstack = theInventory[par1];
                theInventory[par1] = null;
                return itemstack;
            }

            if (theInventory[par1].stackSize <= par2)
            {
                ItemStack itemstack1 = theInventory[par1];
                theInventory[par1] = null;

                if (inventoryResetNeededOnSlotChange(par1))
                {
                    resetRecipeAndSlots();
                }

                return itemstack1;
            }

            ItemStack itemstack2 = theInventory[par1].splitStack(par2);

            if (theInventory[par1].stackSize == 0)
            {
                theInventory[par1] = null;
            }

            if (inventoryResetNeededOnSlotChange(par1))
            {
                resetRecipeAndSlots();
            }

            return itemstack2;
        }
        else
        {
            return null;
        }
    }

    /**
     * if par1 slot has changed, does resetRecipeAndSlots need to be called?
     */
    private boolean inventoryResetNeededOnSlotChange(int par1)
    {
        return par1 == 0 || par1 == 1;
    }

    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
    public ItemStack getStackInSlotOnClosing(int par1)
    {
        if (theInventory[par1] != null)
        {
            ItemStack itemstack = theInventory[par1];
            theInventory[par1] = null;
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
        theInventory[par1] = par2ItemStack;

        if (par2ItemStack != null && par2ItemStack.stackSize > getInventoryStackLimit())
        {
            par2ItemStack.stackSize = getInventoryStackLimit();
        }

        if (inventoryResetNeededOnSlotChange(par1))
        {
            resetRecipeAndSlots();
        }
    }

    /**
     * Returns the name of the inventory.
     */
    public String getInvName()
    {
        return "mob.villager";
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
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
    {
        return theMerchant.getCustomer() == par1EntityPlayer;
    }

    public void openChest()
    {
    }

    public void closeChest()
    {
    }

    /**
     * Called when an the contents of an Inventory change, usually
     */
    public void onInventoryChanged()
    {
        resetRecipeAndSlots();
    }

    public void resetRecipeAndSlots()
    {
        currentRecipe = null;
        ItemStack itemstack = theInventory[0];
        ItemStack itemstack1 = theInventory[1];

        if (itemstack == null)
        {
            itemstack = itemstack1;
            itemstack1 = null;
        }

        if (itemstack == null)
        {
            setInventorySlotContents(2, null);
        }
        else
        {
            MerchantRecipeList merchantrecipelist = theMerchant.getRecipes(thePlayer);

            if (merchantrecipelist != null)
            {
                MerchantRecipe merchantrecipe = merchantrecipelist.canRecipeBeUsed(itemstack, itemstack1, currentRecipeIndex);

                if (merchantrecipe != null)
                {
                    currentRecipe = merchantrecipe;
                    setInventorySlotContents(2, merchantrecipe.getItemToSell().copy());
                }
                else if (itemstack1 != null)
                {
                    MerchantRecipe merchantrecipe1 = merchantrecipelist.canRecipeBeUsed(itemstack1, itemstack, currentRecipeIndex);

                    if (merchantrecipe1 != null)
                    {
                        currentRecipe = merchantrecipe1;
                        setInventorySlotContents(2, merchantrecipe1.getItemToSell().copy());
                    }
                    else
                    {
                        setInventorySlotContents(2, null);
                    }
                }
                else
                {
                    setInventorySlotContents(2, null);
                }
            }
        }
    }

    public MerchantRecipe getCurrentRecipe()
    {
        return currentRecipe;
    }

    public void setCurrentRecipeIndex(int par1)
    {
        currentRecipeIndex = par1;
        resetRecipeAndSlots();
    }
}
