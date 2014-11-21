// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, Material, CreativeTabs, AxisAlignedBB, 
//            AABBPool, Entity, World

public class BlockSoulSand extends Block
{

    public BlockSoulSand(int p_i3956_1_, int p_i3956_2_)
    {
        super(p_i3956_1_, p_i3956_2_, Material.field_76251_o);
        func_71849_a(CreativeTabs.field_78030_b);
    }

    public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_)
    {
        float f = 0.125F;
        return AxisAlignedBB.func_72332_a().func_72299_a(p_71872_2_, p_71872_3_, p_71872_4_, p_71872_2_ + 1, (float)(p_71872_3_ + 1) - f, p_71872_4_ + 1);
    }

    public void func_71869_a(World p_71869_1_, int p_71869_2_, int p_71869_3_, int p_71869_4_, Entity p_71869_5_)
    {
        p_71869_5_.field_70159_w *= 0.40000000000000002D;
        p_71869_5_.field_70179_y *= 0.40000000000000002D;
    }
}
