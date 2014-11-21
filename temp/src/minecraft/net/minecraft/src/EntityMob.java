// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityCreature, IMob, World, DamageSource, 
//            Potion, PotionEffect, Entity, AxisAlignedBB, 
//            MathHelper, EnumSkyBlock

public abstract class EntityMob extends EntityCreature
    implements IMob
{

    protected int field_70815_f;

    public EntityMob(World p_i3552_1_)
    {
        super(p_i3552_1_);
        field_70815_f = 2;
        field_70728_aV = 5;
    }

    public void func_70636_d()
    {
        float f = func_70013_c(1.0F);
        if(f > 0.5F)
        {
            field_70708_bq += 2;
        }
        super.func_70636_d();
    }

    public void func_70071_h_()
    {
        super.func_70071_h_();
        if(!field_70170_p.field_72995_K && field_70170_p.field_73013_u == 0)
        {
            func_70106_y();
        }
    }

    protected Entity func_70782_k()
    {
        EntityPlayer entityplayer = field_70170_p.func_72856_b(this, 16D);
        if(entityplayer != null && func_70685_l(entityplayer))
        {
            return entityplayer;
        } else
        {
            return null;
        }
    }

    public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_)
    {
        if(super.func_70097_a(p_70097_1_, p_70097_2_))
        {
            Entity entity = p_70097_1_.func_76346_g();
            if(field_70153_n == entity || field_70154_o == entity)
            {
                return true;
            }
            if(entity != this)
            {
                field_70789_a = entity;
            }
            return true;
        } else
        {
            return false;
        }
    }

    public boolean func_70652_k(Entity p_70652_1_)
    {
        int i = field_70815_f;
        if(func_70644_a(Potion.field_76420_g))
        {
            i += 3 << func_70660_b(Potion.field_76420_g).func_76458_c();
        }
        if(func_70644_a(Potion.field_76437_t))
        {
            i -= 2 << func_70660_b(Potion.field_76437_t).func_76458_c();
        }
        return p_70652_1_.func_70097_a(DamageSource.func_76358_a(this), i);
    }

    protected void func_70785_a(Entity p_70785_1_, float p_70785_2_)
    {
        if(field_70724_aR <= 0 && p_70785_2_ < 2.0F && p_70785_1_.field_70121_D.field_72337_e > field_70121_D.field_72338_b && p_70785_1_.field_70121_D.field_72338_b < field_70121_D.field_72337_e)
        {
            field_70724_aR = 20;
            func_70652_k(p_70785_1_);
        }
    }

    public float func_70783_a(int p_70783_1_, int p_70783_2_, int p_70783_3_)
    {
        return 0.5F - field_70170_p.func_72801_o(p_70783_1_, p_70783_2_, p_70783_3_);
    }

    protected boolean func_70814_o()
    {
        int i = MathHelper.func_76128_c(field_70165_t);
        int j = MathHelper.func_76128_c(field_70121_D.field_72338_b);
        int k = MathHelper.func_76128_c(field_70161_v);
        if(field_70170_p.func_72972_b(EnumSkyBlock.Sky, i, j, k) > field_70146_Z.nextInt(32))
        {
            return false;
        }
        int l = field_70170_p.func_72957_l(i, j, k);
        if(field_70170_p.func_72911_I())
        {
            int i1 = field_70170_p.field_73008_k;
            field_70170_p.field_73008_k = 10;
            l = field_70170_p.func_72957_l(i, j, k);
            field_70170_p.field_73008_k = i1;
        }
        return l <= field_70146_Z.nextInt(8);
    }

    public boolean func_70601_bi()
    {
        return func_70814_o() && super.func_70601_bi();
    }
}
