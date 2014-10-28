package net.minecraft.src;

public class NpcMerchant implements IMerchant
{
    private InventoryMerchant field_70937_a;

    /** This merchant's current player customer. */
    private EntityPlayer customer;

    /** The MerchantRecipeList instance. */
    private MerchantRecipeList recipeList;

    public NpcMerchant(EntityPlayer par1EntityPlayer)
    {
        customer = par1EntityPlayer;
        field_70937_a = new InventoryMerchant(par1EntityPlayer, this);
    }

    public EntityPlayer getCustomer()
    {
        return customer;
    }

    public void setCustomer(EntityPlayer entityplayer)
    {
    }

    public MerchantRecipeList getRecipes(EntityPlayer par1EntityPlayer)
    {
        return recipeList;
    }

    public void setRecipes(MerchantRecipeList par1MerchantRecipeList)
    {
        recipeList = par1MerchantRecipeList;
    }

    public void useRecipe(MerchantRecipe merchantrecipe)
    {
    }
}
