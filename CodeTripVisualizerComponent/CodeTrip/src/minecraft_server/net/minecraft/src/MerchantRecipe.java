package net.minecraft.src;

public class MerchantRecipe
{
    /** Item the Villager buys. */
    private ItemStack itemToBuy;

    /** Second Item the Villager buys. */
    private ItemStack secondItemToBuy;

    /** Item the Villager sells. */
    private ItemStack itemToSell;

    /**
     * Saves how much has been tool used when put into to slot to be enchanted.
     */
    private int toolUses;

    public MerchantRecipe(NBTTagCompound par1NBTTagCompound)
    {
        func_77390_a(par1NBTTagCompound);
    }

    public MerchantRecipe(ItemStack par1ItemStack, ItemStack par2ItemStack, ItemStack par3ItemStack)
    {
        itemToBuy = par1ItemStack;
        secondItemToBuy = par2ItemStack;
        itemToSell = par3ItemStack;
    }

    public MerchantRecipe(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        this(par1ItemStack, null, par2ItemStack);
    }

    public MerchantRecipe(ItemStack par1ItemStack, Item par2Item)
    {
        this(par1ItemStack, new ItemStack(par2Item));
    }

    /**
     * Gets the itemToBuy.
     */
    public ItemStack getItemToBuy()
    {
        return itemToBuy;
    }

    /**
     * Gets secondItemToBuy.
     */
    public ItemStack getSecondItemToBuy()
    {
        return secondItemToBuy;
    }

    /**
     * Gets if Villager has secondItemToBuy.
     */
    public boolean hasSecondItemToBuy()
    {
        return secondItemToBuy != null;
    }

    /**
     * Gets itemToSell.
     */
    public ItemStack getItemToSell()
    {
        return itemToSell;
    }

    public boolean func_77393_a(MerchantRecipe par1MerchantRecipe)
    {
        if (itemToBuy.itemID != par1MerchantRecipe.itemToBuy.itemID || itemToSell.itemID != par1MerchantRecipe.itemToSell.itemID)
        {
            return false;
        }
        else
        {
            return secondItemToBuy == null && par1MerchantRecipe.secondItemToBuy == null || secondItemToBuy != null && par1MerchantRecipe.secondItemToBuy != null && secondItemToBuy.itemID == par1MerchantRecipe.secondItemToBuy.itemID;
        }
    }

    public boolean func_77391_b(MerchantRecipe par1MerchantRecipe)
    {
        return func_77393_a(par1MerchantRecipe) && (itemToBuy.stackSize < par1MerchantRecipe.itemToBuy.stackSize || secondItemToBuy != null && secondItemToBuy.stackSize < par1MerchantRecipe.secondItemToBuy.stackSize);
    }

    public int func_77392_e()
    {
        return toolUses;
    }

    public void func_77399_f()
    {
        toolUses++;
    }

    public void func_77390_a(NBTTagCompound par1NBTTagCompound)
    {
        NBTTagCompound nbttagcompound = par1NBTTagCompound.getCompoundTag("buy");
        itemToBuy = ItemStack.loadItemStackFromNBT(nbttagcompound);
        NBTTagCompound nbttagcompound1 = par1NBTTagCompound.getCompoundTag("sell");
        itemToSell = ItemStack.loadItemStackFromNBT(nbttagcompound1);

        if (par1NBTTagCompound.hasKey("buyB"))
        {
            secondItemToBuy = ItemStack.loadItemStackFromNBT(par1NBTTagCompound.getCompoundTag("buyB"));
        }

        if (par1NBTTagCompound.hasKey("uses"))
        {
            toolUses = par1NBTTagCompound.getInteger("uses");
        }
    }

    public NBTTagCompound func_77395_g()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        nbttagcompound.setCompoundTag("buy", itemToBuy.writeToNBT(new NBTTagCompound("buy")));
        nbttagcompound.setCompoundTag("sell", itemToSell.writeToNBT(new NBTTagCompound("sell")));

        if (secondItemToBuy != null)
        {
            nbttagcompound.setCompoundTag("buyB", secondItemToBuy.writeToNBT(new NBTTagCompound("buyB")));
        }

        nbttagcompound.setInteger("uses", toolUses);
        return nbttagcompound;
    }
}
