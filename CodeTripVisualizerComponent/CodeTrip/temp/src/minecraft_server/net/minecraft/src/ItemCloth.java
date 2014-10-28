// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemBlock, ItemDye, ItemStack, BlockCloth

public class ItemCloth extends ItemBlock
{

    public ItemCloth(int p_i3626_1_)
    {
        super(p_i3626_1_);
        func_77656_e(0);
        func_77627_a(true);
    }

    public int func_77647_b(int p_77647_1_)
    {
        return p_77647_1_;
    }

    public String func_77667_c(ItemStack p_77667_1_)
    {
        return (new StringBuilder()).append(super.func_77658_a()).append(".").append(ItemDye.field_77860_a[BlockCloth.func_72238_e_(p_77667_1_.func_77960_j())]).toString();
    }
}
