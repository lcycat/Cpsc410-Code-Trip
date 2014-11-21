// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            World

public abstract class WorldGenerator
{

    private final boolean field_76488_a;

    public WorldGenerator()
    {
        field_76488_a = false;
    }

    public WorldGenerator(boolean p_i3789_1_)
    {
        field_76488_a = p_i3789_1_;
    }

    public abstract boolean func_76484_a(World world, Random random, int i, int j, int k);

    public void func_76487_a(double d, double d1, double d2)
    {
    }

    protected void func_76486_a(World p_76486_1_, int p_76486_2_, int p_76486_3_, int p_76486_4_, int p_76486_5_)
    {
        func_76485_a(p_76486_1_, p_76486_2_, p_76486_3_, p_76486_4_, p_76486_5_, 0);
    }

    protected void func_76485_a(World p_76485_1_, int p_76485_2_, int p_76485_3_, int p_76485_4_, int p_76485_5_, int p_76485_6_)
    {
        if(field_76488_a)
        {
            p_76485_1_.func_72832_d(p_76485_2_, p_76485_3_, p_76485_4_, p_76485_5_, p_76485_6_);
        } else
        {
            p_76485_1_.func_72961_c(p_76485_2_, p_76485_3_, p_76485_4_, p_76485_5_, p_76485_6_);
        }
    }
}
