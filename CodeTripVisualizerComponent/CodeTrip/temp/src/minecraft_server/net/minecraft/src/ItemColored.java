// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemBlock, Block, ItemStack

public class ItemColored extends ItemBlock
{

    private final Block field_77896_a;
    private String field_77895_b[];

    public ItemColored(int p_i3628_1_, boolean p_i3628_2_)
    {
        super(p_i3628_1_);
        field_77896_a = Block.field_71973_m[func_77883_f()];
        if(p_i3628_2_)
        {
            func_77656_e(0);
            func_77627_a(true);
        }
    }

    public int func_77647_b(int p_77647_1_)
    {
        return p_77647_1_;
    }

    public ItemColored func_77894_a(String p_77894_1_[])
    {
        field_77895_b = p_77894_1_;
        return this;
    }

    public String func_77667_c(ItemStack p_77667_1_)
    {
        if(field_77895_b == null)
        {
            return super.func_77667_c(p_77667_1_);
        }
        int i = p_77667_1_.func_77960_j();
        if(i >= 0 && i < field_77895_b.length)
        {
            return (new StringBuilder()).append(super.func_77667_c(p_77667_1_)).append(".").append(field_77895_b[i]).toString();
        } else
        {
            return super.func_77667_c(p_77667_1_);
        }
    }
}
