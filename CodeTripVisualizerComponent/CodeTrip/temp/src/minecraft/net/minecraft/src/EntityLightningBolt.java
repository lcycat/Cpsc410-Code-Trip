// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            EntityWeatherEffect, World, MathHelper, Block, 
//            BlockFire, AxisAlignedBB, AABBPool, Entity, 
//            NBTTagCompound, Vec3

public class EntityLightningBolt extends EntityWeatherEffect
{

    private int field_70262_b;
    public long field_70264_a;
    private int field_70263_c;

    public EntityLightningBolt(World p_i3533_1_, double p_i3533_2_, double p_i3533_4_, double p_i3533_6_)
    {
        super(p_i3533_1_);
        field_70264_a = 0L;
        func_70012_b(p_i3533_2_, p_i3533_4_, p_i3533_6_, 0.0F, 0.0F);
        field_70262_b = 2;
        field_70264_a = field_70146_Z.nextLong();
        field_70263_c = field_70146_Z.nextInt(3) + 1;
        if(p_i3533_1_.field_73013_u >= 2 && p_i3533_1_.func_72873_a(MathHelper.func_76128_c(p_i3533_2_), MathHelper.func_76128_c(p_i3533_4_), MathHelper.func_76128_c(p_i3533_6_), 10))
        {
            int i = MathHelper.func_76128_c(p_i3533_2_);
            int k = MathHelper.func_76128_c(p_i3533_4_);
            int i1 = MathHelper.func_76128_c(p_i3533_6_);
            if(p_i3533_1_.func_72798_a(i, k, i1) == 0 && Block.field_72067_ar.func_71930_b(p_i3533_1_, i, k, i1))
            {
                p_i3533_1_.func_72859_e(i, k, i1, Block.field_72067_ar.field_71990_ca);
            }
            for(int j = 0; j < 4; j++)
            {
                int l = (MathHelper.func_76128_c(p_i3533_2_) + field_70146_Z.nextInt(3)) - 1;
                int j1 = (MathHelper.func_76128_c(p_i3533_4_) + field_70146_Z.nextInt(3)) - 1;
                int k1 = (MathHelper.func_76128_c(p_i3533_6_) + field_70146_Z.nextInt(3)) - 1;
                if(p_i3533_1_.func_72798_a(l, j1, k1) == 0 && Block.field_72067_ar.func_71930_b(p_i3533_1_, l, j1, k1))
                {
                    p_i3533_1_.func_72859_e(l, j1, k1, Block.field_72067_ar.field_71990_ca);
                }
            }

        }
    }

    public void func_70071_h_()
    {
        super.func_70071_h_();
        if(field_70262_b == 2)
        {
            field_70170_p.func_72908_a(field_70165_t, field_70163_u, field_70161_v, "ambient.weather.thunder", 10000F, 0.8F + field_70146_Z.nextFloat() * 0.2F);
            field_70170_p.func_72908_a(field_70165_t, field_70163_u, field_70161_v, "random.explode", 2.0F, 0.5F + field_70146_Z.nextFloat() * 0.2F);
        }
        field_70262_b--;
        if(field_70262_b < 0)
        {
            if(field_70263_c == 0)
            {
                func_70106_y();
            } else
            if(field_70262_b < -field_70146_Z.nextInt(10))
            {
                field_70263_c--;
                field_70262_b = 1;
                field_70264_a = field_70146_Z.nextLong();
                if(field_70170_p.func_72873_a(MathHelper.func_76128_c(field_70165_t), MathHelper.func_76128_c(field_70163_u), MathHelper.func_76128_c(field_70161_v), 10))
                {
                    int i = MathHelper.func_76128_c(field_70165_t);
                    int j = MathHelper.func_76128_c(field_70163_u);
                    int k = MathHelper.func_76128_c(field_70161_v);
                    if(field_70170_p.func_72798_a(i, j, k) == 0 && Block.field_72067_ar.func_71930_b(field_70170_p, i, j, k))
                    {
                        field_70170_p.func_72859_e(i, j, k, Block.field_72067_ar.field_71990_ca);
                    }
                }
            }
        }
        if(field_70262_b >= 0)
        {
            double d = 3D;
            List list = field_70170_p.func_72839_b(this, AxisAlignedBB.func_72332_a().func_72299_a(field_70165_t - d, field_70163_u - d, field_70161_v - d, field_70165_t + d, field_70163_u + 6D + d, field_70161_v + d));
            Entity entity;
            for(Iterator iterator = list.iterator(); iterator.hasNext(); entity.func_70077_a(this))
            {
                entity = (Entity)iterator.next();
            }

            field_70170_p.field_73015_s = 2;
        }
    }

    protected void func_70088_a()
    {
    }

    protected void func_70037_a(NBTTagCompound nbttagcompound)
    {
    }

    protected void func_70014_b(NBTTagCompound nbttagcompound)
    {
    }

    public boolean func_70102_a(Vec3 p_70102_1_)
    {
        return field_70262_b >= 0;
    }
}
