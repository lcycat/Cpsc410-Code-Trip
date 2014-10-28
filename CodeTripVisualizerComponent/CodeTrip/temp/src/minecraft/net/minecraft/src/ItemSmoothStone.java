// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemBlock, Block, ItemStack, BlockStoneBrick

public class ItemSmoothStone extends ItemBlock
{

    private Block field_77887_a;

    public ItemSmoothStone(int p_i3686_1_, Block p_i3686_2_)
    {
        super(p_i3686_1_);
        field_77887_a = p_i3686_2_;
        func_77656_e(0);
        func_77627_a(true);
    }

    public int func_77617_a(int p_77617_1_)
    {
        return field_77887_a.func_71858_a(2, p_77617_1_);
    }

    public int func_77647_b(int p_77647_1_)
    {
        return p_77647_1_;
    }

    public String func_77667_c(ItemStack p_77667_1_)
    {
        int i = p_77667_1_.func_77960_j();
        if(i < 0 || i >= BlockStoneBrick.field_72188_a.length)
        {
            i = 0;
        }
        return (new StringBuilder()).append(super.func_77658_a()).append(".").append(BlockStoneBrick.field_72188_a[i]).toString();
    }
}
