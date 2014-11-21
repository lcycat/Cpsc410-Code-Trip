// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityFlying, IMob, DamageSource, EntityPlayer, 
//            AchievementList, DataWatcher, World, MathHelper, 
//            Entity, AxisAlignedBB, EntityFireball, Vec3, 
//            Item

public class EntityGhast extends EntityFlying
    implements IMob
{

    public int field_70797_a;
    public double field_70795_b;
    public double field_70796_c;
    public double field_70793_d;
    private Entity field_70792_g;
    private int field_70798_h;
    public int field_70794_e;
    public int field_70791_f;

    public EntityGhast(World p_i3549_1_)
    {
        super(p_i3549_1_);
        field_70797_a = 0;
        field_70792_g = null;
        field_70798_h = 0;
        field_70794_e = 0;
        field_70791_f = 0;
        field_70750_az = "/mob/ghast.png";
        func_70105_a(4F, 4F);
        field_70178_ae = true;
        field_70728_aV = 5;
    }

    public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_)
    {
        if("fireball".equals(p_70097_1_.func_76355_l()) && (p_70097_1_.func_76346_g() instanceof EntityPlayer))
        {
            super.func_70097_a(p_70097_1_, 1000);
            ((EntityPlayer)p_70097_1_.func_76346_g()).func_71029_a(AchievementList.field_76028_y);
            return true;
        } else
        {
            return super.func_70097_a(p_70097_1_, p_70097_2_);
        }
    }

    protected void func_70088_a()
    {
        super.func_70088_a();
        field_70180_af.func_75682_a(16, Byte.valueOf((byte)0));
    }

    public int func_70667_aM()
    {
        return 10;
    }

    public void func_70071_h_()
    {
        super.func_70071_h_();
        byte byte0 = field_70180_af.func_75683_a(16);
        field_70750_az = byte0 != 1 ? "/mob/ghast.png" : "/mob/ghast_fire.png";
    }

    protected void func_70626_be()
    {
        if(!field_70170_p.field_72995_K && field_70170_p.field_73013_u == 0)
        {
            func_70106_y();
        }
        func_70623_bb();
        field_70794_e = field_70791_f;
        double d = field_70795_b - field_70165_t;
        double d1 = field_70796_c - field_70163_u;
        double d2 = field_70793_d - field_70161_v;
        double d3 = d * d + d1 * d1 + d2 * d2;
        if(d3 < 1.0D || d3 > 3600D)
        {
            field_70795_b = field_70165_t + (double)((field_70146_Z.nextFloat() * 2.0F - 1.0F) * 16F);
            field_70796_c = field_70163_u + (double)((field_70146_Z.nextFloat() * 2.0F - 1.0F) * 16F);
            field_70793_d = field_70161_v + (double)((field_70146_Z.nextFloat() * 2.0F - 1.0F) * 16F);
        }
        if(field_70797_a-- <= 0)
        {
            field_70797_a += field_70146_Z.nextInt(5) + 2;
            d3 = MathHelper.func_76133_a(d3);
            if(func_70790_a(field_70795_b, field_70796_c, field_70793_d, d3))
            {
                field_70159_w += (d / d3) * 0.10000000000000001D;
                field_70181_x += (d1 / d3) * 0.10000000000000001D;
                field_70179_y += (d2 / d3) * 0.10000000000000001D;
            } else
            {
                field_70795_b = field_70165_t;
                field_70796_c = field_70163_u;
                field_70793_d = field_70161_v;
            }
        }
        if(field_70792_g != null && field_70792_g.field_70128_L)
        {
            field_70792_g = null;
        }
        if(field_70792_g == null || field_70798_h-- <= 0)
        {
            field_70792_g = field_70170_p.func_72856_b(this, 100D);
            if(field_70792_g != null)
            {
                field_70798_h = 20;
            }
        }
        double d4 = 64D;
        if(field_70792_g != null && field_70792_g.func_70068_e(this) < d4 * d4)
        {
            double d5 = field_70792_g.field_70165_t - field_70165_t;
            double d6 = (field_70792_g.field_70121_D.field_72338_b + (double)(field_70792_g.field_70131_O / 2.0F)) - (field_70163_u + (double)(field_70131_O / 2.0F));
            double d7 = field_70792_g.field_70161_v - field_70161_v;
            field_70761_aq = field_70177_z = (-(float)Math.atan2(d5, d7) * 180F) / 3.141593F;
            if(func_70685_l(field_70792_g))
            {
                if(field_70791_f == 10)
                {
                    field_70170_p.func_72889_a(null, 1007, (int)field_70165_t, (int)field_70163_u, (int)field_70161_v, 0);
                }
                field_70791_f++;
                if(field_70791_f == 20)
                {
                    field_70170_p.func_72889_a(null, 1008, (int)field_70165_t, (int)field_70163_u, (int)field_70161_v, 0);
                    EntityFireball entityfireball = new EntityFireball(field_70170_p, this, d5, d6, d7);
                    double d8 = 4D;
                    Vec3 vec3 = func_70676_i(1.0F);
                    entityfireball.field_70165_t = field_70165_t + vec3.field_72450_a * d8;
                    entityfireball.field_70163_u = field_70163_u + (double)(field_70131_O / 2.0F) + 0.5D;
                    entityfireball.field_70161_v = field_70161_v + vec3.field_72449_c * d8;
                    field_70170_p.func_72838_d(entityfireball);
                    field_70791_f = -40;
                }
            } else
            if(field_70791_f > 0)
            {
                field_70791_f--;
            }
        } else
        {
            field_70761_aq = field_70177_z = (-(float)Math.atan2(field_70159_w, field_70179_y) * 180F) / 3.141593F;
            if(field_70791_f > 0)
            {
                field_70791_f--;
            }
        }
        if(!field_70170_p.field_72995_K)
        {
            byte byte0 = field_70180_af.func_75683_a(16);
            byte byte1 = (byte)(field_70791_f <= 10 ? 0 : 1);
            if(byte0 != byte1)
            {
                field_70180_af.func_75692_b(16, Byte.valueOf(byte1));
            }
        }
    }

    private boolean func_70790_a(double p_70790_1_, double p_70790_3_, double p_70790_5_, double p_70790_7_)
    {
        double d = (field_70795_b - field_70165_t) / p_70790_7_;
        double d1 = (field_70796_c - field_70163_u) / p_70790_7_;
        double d2 = (field_70793_d - field_70161_v) / p_70790_7_;
        AxisAlignedBB axisalignedbb = field_70121_D.func_72329_c();
        for(int i = 1; (double)i < p_70790_7_; i++)
        {
            axisalignedbb.func_72317_d(d, d1, d2);
            if(!field_70170_p.func_72945_a(this, axisalignedbb).isEmpty())
            {
                return false;
            }
        }

        return true;
    }

    protected String func_70639_aQ()
    {
        return "mob.ghast.moan";
    }

    protected String func_70621_aR()
    {
        return "mob.ghast.scream";
    }

    protected String func_70673_aS()
    {
        return "mob.ghast.death";
    }

    protected int func_70633_aT()
    {
        return Item.field_77677_M.field_77779_bT;
    }

    protected void func_70628_a(boolean p_70628_1_, int p_70628_2_)
    {
        int i = field_70146_Z.nextInt(2) + field_70146_Z.nextInt(1 + p_70628_2_);
        for(int j = 0; j < i; j++)
        {
            func_70025_b(Item.field_77732_bp.field_77779_bT, 1);
        }

        i = field_70146_Z.nextInt(3) + field_70146_Z.nextInt(1 + p_70628_2_);
        for(int k = 0; k < i; k++)
        {
            func_70025_b(Item.field_77677_M.field_77779_bT, 1);
        }

    }

    protected float func_70599_aP()
    {
        return 10F;
    }

    public boolean func_70601_bi()
    {
        return field_70146_Z.nextInt(20) == 0 && super.func_70601_bi() && field_70170_p.field_73013_u > 0;
    }

    public int func_70641_bl()
    {
        return 1;
    }
}
