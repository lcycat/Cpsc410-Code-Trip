// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            IInventory, ItemStack, EntityPlayer

public class InventoryLargeChest
    implements IInventory
{

    private String field_70479_a;
    private IInventory field_70477_b;
    private IInventory field_70478_c;

    public InventoryLargeChest(String p_i3425_1_, IInventory p_i3425_2_, IInventory p_i3425_3_)
    {
        field_70479_a = p_i3425_1_;
        if(p_i3425_2_ == null)
        {
            p_i3425_2_ = p_i3425_3_;
        }
        if(p_i3425_3_ == null)
        {
            p_i3425_3_ = p_i3425_2_;
        }
        field_70477_b = p_i3425_2_;
        field_70478_c = p_i3425_3_;
    }

    public int func_70302_i_()
    {
        return field_70477_b.func_70302_i_() + field_70478_c.func_70302_i_();
    }

    public String func_70303_b()
    {
        return field_70479_a;
    }

    public ItemStack func_70301_a(int p_70301_1_)
    {
        if(p_70301_1_ >= field_70477_b.func_70302_i_())
        {
            return field_70478_c.func_70301_a(p_70301_1_ - field_70477_b.func_70302_i_());
        } else
        {
            return field_70477_b.func_70301_a(p_70301_1_);
        }
    }

    public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_)
    {
        if(p_70298_1_ >= field_70477_b.func_70302_i_())
        {
            return field_70478_c.func_70298_a(p_70298_1_ - field_70477_b.func_70302_i_(), p_70298_2_);
        } else
        {
            return field_70477_b.func_70298_a(p_70298_1_, p_70298_2_);
        }
    }

    public ItemStack func_70304_b(int p_70304_1_)
    {
        if(p_70304_1_ >= field_70477_b.func_70302_i_())
        {
            return field_70478_c.func_70304_b(p_70304_1_ - field_70477_b.func_70302_i_());
        } else
        {
            return field_70477_b.func_70304_b(p_70304_1_);
        }
    }

    public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_)
    {
        if(p_70299_1_ >= field_70477_b.func_70302_i_())
        {
            field_70478_c.func_70299_a(p_70299_1_ - field_70477_b.func_70302_i_(), p_70299_2_);
        } else
        {
            field_70477_b.func_70299_a(p_70299_1_, p_70299_2_);
        }
    }

    public int func_70297_j_()
    {
        return field_70477_b.func_70297_j_();
    }

    public void func_70296_d()
    {
        field_70477_b.func_70296_d();
        field_70478_c.func_70296_d();
    }

    public boolean func_70300_a(EntityPlayer p_70300_1_)
    {
        return field_70477_b.func_70300_a(p_70300_1_) && field_70478_c.func_70300_a(p_70300_1_);
    }

    public void func_70295_k_()
    {
        field_70477_b.func_70295_k_();
        field_70478_c.func_70295_k_();
    }

    public void func_70305_f()
    {
        field_70477_b.func_70305_f();
        field_70478_c.func_70305_f();
    }
}
