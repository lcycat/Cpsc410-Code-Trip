// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockRail, World, IBlockAccess, EntityMinecart, 
//            AxisAlignedBB, AABBPool, Entity

public class BlockDetectorRail extends BlockRail
{

    public BlockDetectorRail(int p_i3933_1_, int p_i3933_2_)
    {
        super(p_i3933_1_, p_i3933_2_, true);
        func_71907_b(true);
    }

    public int func_71859_p_()
    {
        return 20;
    }

    public boolean func_71853_i()
    {
        return true;
    }

    public void func_71869_a(World p_71869_1_, int p_71869_2_, int p_71869_3_, int p_71869_4_, Entity p_71869_5_)
    {
        if(p_71869_1_.field_72995_K)
        {
            return;
        }
        int i = p_71869_1_.func_72805_g(p_71869_2_, p_71869_3_, p_71869_4_);
        if((i & 8) != 0)
        {
            return;
        } else
        {
            func_72187_e(p_71869_1_, p_71869_2_, p_71869_3_, p_71869_4_, i);
            return;
        }
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_)
    {
        if(p_71847_1_.field_72995_K)
        {
            return;
        }
        int i = p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_);
        if((i & 8) == 0)
        {
            return;
        } else
        {
            func_72187_e(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_, i);
            return;
        }
    }

    public boolean func_71865_a(IBlockAccess p_71865_1_, int p_71865_2_, int p_71865_3_, int p_71865_4_, int p_71865_5_)
    {
        return (p_71865_1_.func_72805_g(p_71865_2_, p_71865_3_, p_71865_4_) & 8) != 0;
    }

    public boolean func_71855_c(World p_71855_1_, int p_71855_2_, int p_71855_3_, int p_71855_4_, int p_71855_5_)
    {
        if((p_71855_1_.func_72805_g(p_71855_2_, p_71855_3_, p_71855_4_) & 8) == 0)
        {
            return false;
        } else
        {
            return p_71855_5_ == 1;
        }
    }

    private void func_72187_e(World p_72187_1_, int p_72187_2_, int p_72187_3_, int p_72187_4_, int p_72187_5_)
    {
        boolean flag = (p_72187_5_ & 8) != 0;
        boolean flag1 = false;
        float f = 0.125F;
        List list = p_72187_1_.func_72872_a(net.minecraft.src.EntityMinecart.class, AxisAlignedBB.func_72332_a().func_72299_a((float)p_72187_2_ + f, p_72187_3_, (float)p_72187_4_ + f, (float)(p_72187_2_ + 1) - f, (float)(p_72187_3_ + 1) - f, (float)(p_72187_4_ + 1) - f));
        if(!list.isEmpty())
        {
            flag1 = true;
        }
        if(flag1 && !flag)
        {
            p_72187_1_.func_72921_c(p_72187_2_, p_72187_3_, p_72187_4_, p_72187_5_ | 8);
            p_72187_1_.func_72898_h(p_72187_2_, p_72187_3_, p_72187_4_, field_71990_ca);
            p_72187_1_.func_72898_h(p_72187_2_, p_72187_3_ - 1, p_72187_4_, field_71990_ca);
            p_72187_1_.func_72909_d(p_72187_2_, p_72187_3_, p_72187_4_, p_72187_2_, p_72187_3_, p_72187_4_);
        }
        if(!flag1 && flag)
        {
            p_72187_1_.func_72921_c(p_72187_2_, p_72187_3_, p_72187_4_, p_72187_5_ & 7);
            p_72187_1_.func_72898_h(p_72187_2_, p_72187_3_, p_72187_4_, field_71990_ca);
            p_72187_1_.func_72898_h(p_72187_2_, p_72187_3_ - 1, p_72187_4_, field_71990_ca);
            p_72187_1_.func_72909_d(p_72187_2_, p_72187_3_, p_72187_4_, p_72187_2_, p_72187_3_, p_72187_4_);
        }
        if(flag1)
        {
            p_72187_1_.func_72836_a(p_72187_2_, p_72187_3_, p_72187_4_, field_71990_ca, func_71859_p_());
        }
    }
}
