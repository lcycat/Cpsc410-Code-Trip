// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemStack, IInventory

public class Slot
{

    private final int field_75225_a;
    public final IInventory field_75224_c;
    public int field_75222_d;
    public int field_75223_e;
    public int field_75221_f;

    public Slot(IInventory p_i3616_1_, int p_i3616_2_, int p_i3616_3_, int p_i3616_4_)
    {
        field_75224_c = p_i3616_1_;
        field_75225_a = p_i3616_2_;
        field_75223_e = p_i3616_3_;
        field_75221_f = p_i3616_4_;
    }

    public void func_75220_a(ItemStack p_75220_1_, ItemStack p_75220_2_)
    {
        if(p_75220_1_ == null || p_75220_2_ == null)
        {
            return;
        }
        if(p_75220_1_.field_77993_c != p_75220_2_.field_77993_c)
        {
            return;
        }
        int i = p_75220_2_.field_77994_a - p_75220_1_.field_77994_a;
        if(i > 0)
        {
            func_75210_a(p_75220_1_, i);
        }
    }

    protected void func_75210_a(ItemStack itemstack, int i)
    {
    }

    protected void func_75208_c(ItemStack itemstack)
    {
    }

    public void func_75213_b(ItemStack p_75213_1_)
    {
        func_75218_e();
    }

    public boolean func_75214_a(ItemStack p_75214_1_)
    {
        return true;
    }

    public ItemStack func_75211_c()
    {
        return field_75224_c.func_70301_a(field_75225_a);
    }

    public boolean func_75216_d()
    {
        return func_75211_c() != null;
    }

    public void func_75215_d(ItemStack p_75215_1_)
    {
        field_75224_c.func_70299_a(field_75225_a, p_75215_1_);
        func_75218_e();
    }

    public void func_75218_e()
    {
        field_75224_c.func_70296_d();
    }

    public int func_75219_a()
    {
        return field_75224_c.func_70297_j_();
    }

    public int func_75212_b()
    {
        return -1;
    }

    public ItemStack func_75209_a(int p_75209_1_)
    {
        return field_75224_c.func_70298_a(field_75225_a, p_75209_1_);
    }

    public boolean func_75217_a(IInventory p_75217_1_, int p_75217_2_)
    {
        return p_75217_1_ == field_75224_c && p_75217_2_ == field_75225_a;
    }
}
