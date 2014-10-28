// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemStack, EntityPlayer

public interface IInventory
{

    public abstract int func_70302_i_();

    public abstract ItemStack func_70301_a(int i);

    public abstract ItemStack func_70298_a(int i, int j);

    public abstract ItemStack func_70304_b(int i);

    public abstract void func_70299_a(int i, ItemStack itemstack);

    public abstract String func_70303_b();

    public abstract int func_70297_j_();

    public abstract void func_70296_d();

    public abstract boolean func_70300_a(EntityPlayer entityplayer);

    public abstract void func_70295_k_();

    public abstract void func_70305_f();
}
