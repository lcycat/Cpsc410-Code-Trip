// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityLiving, AxisAlignedBB, MathHelper, EntityJumpHelper

public class EntityMoveHelper
{

    private EntityLiving field_75648_a;
    private double field_75646_b;
    private double field_75647_c;
    private double field_75644_d;
    private float field_75645_e;
    private boolean field_75643_f;

    public EntityMoveHelper(EntityLiving p_i3456_1_)
    {
        field_75643_f = false;
        field_75648_a = p_i3456_1_;
        field_75646_b = p_i3456_1_.field_70165_t;
        field_75647_c = p_i3456_1_.field_70163_u;
        field_75644_d = p_i3456_1_.field_70161_v;
    }

    public boolean func_75640_a()
    {
        return field_75643_f;
    }

    public float func_75638_b()
    {
        return field_75645_e;
    }

    public void func_75642_a(double p_75642_1_, double p_75642_3_, double p_75642_5_, float p_75642_7_)
    {
        field_75646_b = p_75642_1_;
        field_75647_c = p_75642_3_;
        field_75644_d = p_75642_5_;
        field_75645_e = p_75642_7_;
        field_75643_f = true;
    }

    public void func_75641_c()
    {
        field_75648_a.func_70657_f(0.0F);
        if(!field_75643_f)
        {
            return;
        }
        field_75643_f = false;
        int i = MathHelper.func_76128_c(field_75648_a.field_70121_D.field_72338_b + 0.5D);
        double d = field_75646_b - field_75648_a.field_70165_t;
        double d1 = field_75644_d - field_75648_a.field_70161_v;
        double d2 = field_75647_c - (double)i;
        double d3 = d * d + d2 * d2 + d1 * d1;
        if(d3 < 2.5000002779052011E-007D)
        {
            return;
        }
        float f = (float)((Math.atan2(d1, d) * 180D) / 3.1415927410125732D) - 90F;
        field_75648_a.field_70177_z = func_75639_a(field_75648_a.field_70177_z, f, 30F);
        field_75648_a.func_70659_e(field_75645_e);
        if(d2 > 0.0D && d * d + d1 * d1 < 1.0D)
        {
            field_75648_a.func_70683_ar().func_75660_a();
        }
    }

    private float func_75639_a(float p_75639_1_, float p_75639_2_, float p_75639_3_)
    {
        float f = MathHelper.func_76142_g(p_75639_2_ - p_75639_1_);
        if(f > p_75639_3_)
        {
            f = p_75639_3_;
        }
        if(f < -p_75639_3_)
        {
            f = -p_75639_3_;
        }
        return p_75639_1_ + f;
    }
}
