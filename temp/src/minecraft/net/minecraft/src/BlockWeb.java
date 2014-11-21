// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, CreativeTabs, Entity, 
//            Item, World, AxisAlignedBB

public class BlockWeb extends Block
{

    public BlockWeb(int p_i4021_1_, int p_i4021_2_)
    {
        super(p_i4021_1_, p_i4021_2_, Material.field_76232_D);
        func_71849_a(CreativeTabs.field_78031_c);
    }

    public void func_71869_a(World p_71869_1_, int p_71869_2_, int p_71869_3_, int p_71869_4_, Entity p_71869_5_)
    {
        p_71869_5_.func_70110_aj();
    }

    public boolean func_71926_d()
    {
        return false;
    }

    public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int i)
    {
        return null;
    }

    public int func_71857_b()
    {
        return 1;
    }

    public boolean func_71886_c()
    {
        return false;
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        return Item.field_77683_K.field_77779_bT;
    }
}
