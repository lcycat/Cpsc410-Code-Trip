// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, CreativeTabs, World, BlockFence, 
//            EnumMobType, AxisAlignedBB, AABBPool, EntityLiving, 
//            EntityPlayer, IBlockAccess, Material, Entity

public class BlockPressurePlate extends Block
{

    private EnumMobType field_72194_a;

    protected BlockPressurePlate(int p_i3981_1_, int p_i3981_2_, EnumMobType p_i3981_3_, Material p_i3981_4_)
    {
        super(p_i3981_1_, p_i3981_2_, p_i3981_4_);
        field_72194_a = p_i3981_3_;
        func_71849_a(CreativeTabs.field_78028_d);
        func_71907_b(true);
        float f = 0.0625F;
        func_71905_a(f, 0.0F, f, 1.0F - f, 0.03125F, 1.0F - f);
    }

    public int func_71859_p_()
    {
        return 20;
    }

    public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int i)
    {
        return null;
    }

    public boolean func_71926_d()
    {
        return false;
    }

    public boolean func_71886_c()
    {
        return false;
    }

    public boolean func_71918_c(IBlockAccess p_71918_1_, int p_71918_2_, int p_71918_3_, int i)
    {
        return true;
    }

    public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_)
    {
        return p_71930_1_.func_72797_t(p_71930_2_, p_71930_3_ - 1, p_71930_4_) || BlockFence.func_72249_c(p_71930_1_.func_72798_a(p_71930_2_, p_71930_3_ - 1, p_71930_4_));
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        boolean flag = false;
        if(!p_71863_1_.func_72797_t(p_71863_2_, p_71863_3_ - 1, p_71863_4_) && !BlockFence.func_72249_c(p_71863_1_.func_72798_a(p_71863_2_, p_71863_3_ - 1, p_71863_4_)))
        {
            flag = true;
        }
        if(flag)
        {
            func_71897_c(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_), 0);
            p_71863_1_.func_72859_e(p_71863_2_, p_71863_3_, p_71863_4_, 0);
        }
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_)
    {
        if(p_71847_1_.field_72995_K)
        {
            return;
        }
        if(p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_) == 0)
        {
            return;
        } else
        {
            func_72193_l(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_);
            return;
        }
    }

    public void func_71869_a(World p_71869_1_, int p_71869_2_, int p_71869_3_, int p_71869_4_, Entity p_71869_5_)
    {
        if(p_71869_1_.field_72995_K)
        {
            return;
        }
        if(p_71869_1_.func_72805_g(p_71869_2_, p_71869_3_, p_71869_4_) == 1)
        {
            return;
        } else
        {
            func_72193_l(p_71869_1_, p_71869_2_, p_71869_3_, p_71869_4_);
            return;
        }
    }

    private void func_72193_l(World p_72193_1_, int p_72193_2_, int p_72193_3_, int p_72193_4_)
    {
        boolean flag = p_72193_1_.func_72805_g(p_72193_2_, p_72193_3_, p_72193_4_) == 1;
        boolean flag1 = false;
        float f = 0.125F;
        List list = null;
        if(field_72194_a == EnumMobType.everything)
        {
            list = p_72193_1_.func_72839_b(null, AxisAlignedBB.func_72332_a().func_72299_a((float)p_72193_2_ + f, p_72193_3_, (float)p_72193_4_ + f, (float)(p_72193_2_ + 1) - f, (double)p_72193_3_ + 0.25D, (float)(p_72193_4_ + 1) - f));
        }
        if(field_72194_a == EnumMobType.mobs)
        {
            list = p_72193_1_.func_72872_a(net.minecraft.src.EntityLiving.class, AxisAlignedBB.func_72332_a().func_72299_a((float)p_72193_2_ + f, p_72193_3_, (float)p_72193_4_ + f, (float)(p_72193_2_ + 1) - f, (double)p_72193_3_ + 0.25D, (float)(p_72193_4_ + 1) - f));
        }
        if(field_72194_a == EnumMobType.players)
        {
            list = p_72193_1_.func_72872_a(net.minecraft.src.EntityPlayer.class, AxisAlignedBB.func_72332_a().func_72299_a((float)p_72193_2_ + f, p_72193_3_, (float)p_72193_4_ + f, (float)(p_72193_2_ + 1) - f, (double)p_72193_3_ + 0.25D, (float)(p_72193_4_ + 1) - f));
        }
        if(!list.isEmpty())
        {
            flag1 = true;
        }
        if(flag1 && !flag)
        {
            p_72193_1_.func_72921_c(p_72193_2_, p_72193_3_, p_72193_4_, 1);
            p_72193_1_.func_72898_h(p_72193_2_, p_72193_3_, p_72193_4_, field_71990_ca);
            p_72193_1_.func_72898_h(p_72193_2_, p_72193_3_ - 1, p_72193_4_, field_71990_ca);
            p_72193_1_.func_72909_d(p_72193_2_, p_72193_3_, p_72193_4_, p_72193_2_, p_72193_3_, p_72193_4_);
            p_72193_1_.func_72908_a((double)p_72193_2_ + 0.5D, (double)p_72193_3_ + 0.10000000000000001D, (double)p_72193_4_ + 0.5D, "random.click", 0.3F, 0.6F);
        }
        if(!flag1 && flag)
        {
            p_72193_1_.func_72921_c(p_72193_2_, p_72193_3_, p_72193_4_, 0);
            p_72193_1_.func_72898_h(p_72193_2_, p_72193_3_, p_72193_4_, field_71990_ca);
            p_72193_1_.func_72898_h(p_72193_2_, p_72193_3_ - 1, p_72193_4_, field_71990_ca);
            p_72193_1_.func_72909_d(p_72193_2_, p_72193_3_, p_72193_4_, p_72193_2_, p_72193_3_, p_72193_4_);
            p_72193_1_.func_72908_a((double)p_72193_2_ + 0.5D, (double)p_72193_3_ + 0.10000000000000001D, (double)p_72193_4_ + 0.5D, "random.click", 0.3F, 0.5F);
        }
        if(flag1)
        {
            p_72193_1_.func_72836_a(p_72193_2_, p_72193_3_, p_72193_4_, field_71990_ca, func_71859_p_());
        }
    }

    public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_)
    {
        if(p_71852_6_ > 0)
        {
            p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_, p_71852_4_, field_71990_ca);
            p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_ - 1, p_71852_4_, field_71990_ca);
        }
        super.func_71852_a(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_, p_71852_5_, p_71852_6_);
    }

    public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_)
    {
        boolean flag = p_71902_1_.func_72805_g(p_71902_2_, p_71902_3_, p_71902_4_) == 1;
        float f = 0.0625F;
        if(flag)
        {
            func_71905_a(f, 0.0F, f, 1.0F - f, 0.03125F, 1.0F - f);
        } else
        {
            func_71905_a(f, 0.0F, f, 1.0F - f, 0.0625F, 1.0F - f);
        }
    }

    public boolean func_71865_a(IBlockAccess p_71865_1_, int p_71865_2_, int p_71865_3_, int p_71865_4_, int p_71865_5_)
    {
        return p_71865_1_.func_72805_g(p_71865_2_, p_71865_3_, p_71865_4_) > 0;
    }

    public boolean func_71855_c(World p_71855_1_, int p_71855_2_, int p_71855_3_, int p_71855_4_, int p_71855_5_)
    {
        if(p_71855_1_.func_72805_g(p_71855_2_, p_71855_3_, p_71855_4_) == 0)
        {
            return false;
        } else
        {
            return p_71855_5_ == 1;
        }
    }

    public boolean func_71853_i()
    {
        return true;
    }

    public void func_71919_f()
    {
        float f = 0.5F;
        float f1 = 0.125F;
        float f2 = 0.5F;
        func_71905_a(0.5F - f, 0.5F - f1, 0.5F - f2, 0.5F + f, 0.5F + f1, 0.5F + f2);
    }

    public int func_71915_e()
    {
        return 1;
    }
}
