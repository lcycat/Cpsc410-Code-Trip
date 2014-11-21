package net.minecraft.src;

public interface IMerchant
{
    public abstract void setCustomer(EntityPlayer entityplayer);

    public abstract EntityPlayer getCustomer();

    public abstract MerchantRecipeList func_70934_b(EntityPlayer entityplayer);

    public abstract void func_70933_a(MerchantRecipe merchantrecipe);
}
