package net.minecraft.src;

public interface IMerchant
{
    public abstract void setCustomer(EntityPlayer entityplayer);

    public abstract EntityPlayer getCustomer();

    public abstract MerchantRecipeList getRecipes(EntityPlayer entityplayer);

    public abstract void setRecipes(MerchantRecipeList merchantrecipelist);

    public abstract void useRecipe(MerchantRecipe merchantrecipe);
}
