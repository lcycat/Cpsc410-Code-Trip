// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityPlayer, MerchantRecipeList, MerchantRecipe

public interface IMerchant
{

    public abstract void func_70932_a_(EntityPlayer entityplayer);

    public abstract EntityPlayer func_70931_l_();

    public abstract MerchantRecipeList func_70934_b(EntityPlayer entityplayer);

    public abstract void func_70933_a(MerchantRecipe merchantrecipe);
}
