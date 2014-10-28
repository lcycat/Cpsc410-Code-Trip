// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockDirectional, Material, CreativeTabs, World, 
//            Block, EntitySnowman, EntityIronGolem, EntityLiving, 
//            MathHelper

public class BlockPumpkin extends BlockDirectional
{

    private boolean field_72218_a;

    protected BlockPumpkin(int p_i3982_1_, int p_i3982_2_, boolean p_i3982_3_)
    {
        super(p_i3982_1_, Material.field_76266_z);
        field_72059_bZ = p_i3982_2_;
        func_71907_b(true);
        field_72218_a = p_i3982_3_;
        func_71849_a(CreativeTabs.field_78030_b);
    }

    public int func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        if(p_71858_1_ == 1)
        {
            return field_72059_bZ;
        }
        if(p_71858_1_ == 0)
        {
            return field_72059_bZ;
        }
        int i = field_72059_bZ + 1 + 16;
        if(field_72218_a)
        {
            i++;
        }
        if(p_71858_2_ == 2 && p_71858_1_ == 2)
        {
            return i;
        }
        if(p_71858_2_ == 3 && p_71858_1_ == 5)
        {
            return i;
        }
        if(p_71858_2_ == 0 && p_71858_1_ == 3)
        {
            return i;
        }
        if(p_71858_2_ == 1 && p_71858_1_ == 4)
        {
            return i;
        } else
        {
            return field_72059_bZ + 16;
        }
    }

    public int func_71851_a(int p_71851_1_)
    {
        if(p_71851_1_ == 1)
        {
            return field_72059_bZ;
        }
        if(p_71851_1_ == 0)
        {
            return field_72059_bZ;
        }
        if(p_71851_1_ == 3)
        {
            return field_72059_bZ + 1 + 16;
        } else
        {
            return field_72059_bZ + 16;
        }
    }

    public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_)
    {
        super.func_71861_g(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
        if(p_71861_1_.func_72798_a(p_71861_2_, p_71861_3_ - 1, p_71861_4_) == Block.field_72039_aU.field_71990_ca && p_71861_1_.func_72798_a(p_71861_2_, p_71861_3_ - 2, p_71861_4_) == Block.field_72039_aU.field_71990_ca)
        {
            if(!p_71861_1_.field_72995_K)
            {
                p_71861_1_.func_72822_b(p_71861_2_, p_71861_3_, p_71861_4_, 0);
                p_71861_1_.func_72822_b(p_71861_2_, p_71861_3_ - 1, p_71861_4_, 0);
                p_71861_1_.func_72822_b(p_71861_2_, p_71861_3_ - 2, p_71861_4_, 0);
                EntitySnowman entitysnowman = new EntitySnowman(p_71861_1_);
                entitysnowman.func_70012_b((double)p_71861_2_ + 0.5D, (double)p_71861_3_ - 1.95D, (double)p_71861_4_ + 0.5D, 0.0F, 0.0F);
                p_71861_1_.func_72838_d(entitysnowman);
                p_71861_1_.func_72851_f(p_71861_2_, p_71861_3_, p_71861_4_, 0);
                p_71861_1_.func_72851_f(p_71861_2_, p_71861_3_ - 1, p_71861_4_, 0);
                p_71861_1_.func_72851_f(p_71861_2_, p_71861_3_ - 2, p_71861_4_, 0);
            }
            for(int i = 0; i < 120; i++)
            {
                p_71861_1_.func_72869_a("snowshovel", (double)p_71861_2_ + p_71861_1_.field_73012_v.nextDouble(), (double)(p_71861_3_ - 2) + p_71861_1_.field_73012_v.nextDouble() * 2.5D, (double)p_71861_4_ + p_71861_1_.field_73012_v.nextDouble(), 0.0D, 0.0D, 0.0D);
            }

        } else
        if(p_71861_1_.func_72798_a(p_71861_2_, p_71861_3_ - 1, p_71861_4_) == Block.field_72083_ai.field_71990_ca && p_71861_1_.func_72798_a(p_71861_2_, p_71861_3_ - 2, p_71861_4_) == Block.field_72083_ai.field_71990_ca)
        {
            boolean flag = p_71861_1_.func_72798_a(p_71861_2_ - 1, p_71861_3_ - 1, p_71861_4_) == Block.field_72083_ai.field_71990_ca && p_71861_1_.func_72798_a(p_71861_2_ + 1, p_71861_3_ - 1, p_71861_4_) == Block.field_72083_ai.field_71990_ca;
            boolean flag1 = p_71861_1_.func_72798_a(p_71861_2_, p_71861_3_ - 1, p_71861_4_ - 1) == Block.field_72083_ai.field_71990_ca && p_71861_1_.func_72798_a(p_71861_2_, p_71861_3_ - 1, p_71861_4_ + 1) == Block.field_72083_ai.field_71990_ca;
            if(flag || flag1)
            {
                p_71861_1_.func_72822_b(p_71861_2_, p_71861_3_, p_71861_4_, 0);
                p_71861_1_.func_72822_b(p_71861_2_, p_71861_3_ - 1, p_71861_4_, 0);
                p_71861_1_.func_72822_b(p_71861_2_, p_71861_3_ - 2, p_71861_4_, 0);
                if(flag)
                {
                    p_71861_1_.func_72822_b(p_71861_2_ - 1, p_71861_3_ - 1, p_71861_4_, 0);
                    p_71861_1_.func_72822_b(p_71861_2_ + 1, p_71861_3_ - 1, p_71861_4_, 0);
                } else
                {
                    p_71861_1_.func_72822_b(p_71861_2_, p_71861_3_ - 1, p_71861_4_ - 1, 0);
                    p_71861_1_.func_72822_b(p_71861_2_, p_71861_3_ - 1, p_71861_4_ + 1, 0);
                }
                EntityIronGolem entityirongolem = new EntityIronGolem(p_71861_1_);
                entityirongolem.func_70849_f(true);
                entityirongolem.func_70012_b((double)p_71861_2_ + 0.5D, (double)p_71861_3_ - 1.95D, (double)p_71861_4_ + 0.5D, 0.0F, 0.0F);
                p_71861_1_.func_72838_d(entityirongolem);
                for(int j = 0; j < 120; j++)
                {
                    p_71861_1_.func_72869_a("snowballpoof", (double)p_71861_2_ + p_71861_1_.field_73012_v.nextDouble(), (double)(p_71861_3_ - 2) + p_71861_1_.field_73012_v.nextDouble() * 3.8999999999999999D, (double)p_71861_4_ + p_71861_1_.field_73012_v.nextDouble(), 0.0D, 0.0D, 0.0D);
                }

                p_71861_1_.func_72851_f(p_71861_2_, p_71861_3_, p_71861_4_, 0);
                p_71861_1_.func_72851_f(p_71861_2_, p_71861_3_ - 1, p_71861_4_, 0);
                p_71861_1_.func_72851_f(p_71861_2_, p_71861_3_ - 2, p_71861_4_, 0);
                if(flag)
                {
                    p_71861_1_.func_72851_f(p_71861_2_ - 1, p_71861_3_ - 1, p_71861_4_, 0);
                    p_71861_1_.func_72851_f(p_71861_2_ + 1, p_71861_3_ - 1, p_71861_4_, 0);
                } else
                {
                    p_71861_1_.func_72851_f(p_71861_2_, p_71861_3_ - 1, p_71861_4_ - 1, 0);
                    p_71861_1_.func_72851_f(p_71861_2_, p_71861_3_ - 1, p_71861_4_ + 1, 0);
                }
            }
        }
    }

    public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_)
    {
        int i = p_71930_1_.func_72798_a(p_71930_2_, p_71930_3_, p_71930_4_);
        return (i == 0 || Block.field_71973_m[i].field_72018_cp.func_76222_j()) && p_71930_1_.func_72797_t(p_71930_2_, p_71930_3_ - 1, p_71930_4_);
    }

    public void func_71860_a(World p_71860_1_, int p_71860_2_, int p_71860_3_, int p_71860_4_, EntityLiving p_71860_5_)
    {
        int i = MathHelper.func_76128_c((double)((p_71860_5_.field_70177_z * 4F) / 360F) + 2.5D) & 3;
        p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, i);
    }
}
