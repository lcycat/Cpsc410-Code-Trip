// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Entity, EntityLiving, AxisAlignedBB, MathHelper, 
//            PathNavigate

public class EntityLookHelper
{

    private EntityLiving field_75659_a;
    private float field_75657_b;
    private float field_75658_c;
    private boolean field_75655_d;
    private double field_75656_e;
    private double field_75653_f;
    private double field_75654_g;

    public EntityLookHelper(EntityLiving p_i3455_1_)
    {
        field_75655_d = false;
        field_75659_a = p_i3455_1_;
    }

    public void func_75651_a(Entity p_75651_1_, float p_75651_2_, float p_75651_3_)
    {
        field_75656_e = p_75651_1_.field_70165_t;
        if(p_75651_1_ instanceof EntityLiving)
        {
            field_75653_f = p_75651_1_.field_70163_u + (double)p_75651_1_.func_70047_e();
        } else
        {
            field_75653_f = (p_75651_1_.field_70121_D.field_72338_b + p_75651_1_.field_70121_D.field_72337_e) / 2D;
        }
        field_75654_g = p_75651_1_.field_70161_v;
        field_75657_b = p_75651_2_;
        field_75658_c = p_75651_3_;
        field_75655_d = true;
    }

    public void func_75650_a(double p_75650_1_, double p_75650_3_, double p_75650_5_, float p_75650_7_, 
            float p_75650_8_)
    {
        field_75656_e = p_75650_1_;
        field_75653_f = p_75650_3_;
        field_75654_g = p_75650_5_;
        field_75657_b = p_75650_7_;
        field_75658_c = p_75650_8_;
        field_75655_d = true;
    }

    public void func_75649_a()
    {
        field_75659_a.field_70125_A = 0.0F;
        if(field_75655_d)
        {
            field_75655_d = false;
            double d = field_75656_e - field_75659_a.field_70165_t;
            double d1 = field_75653_f - (field_75659_a.field_70163_u + (double)field_75659_a.func_70047_e());
            double d2 = field_75654_g - field_75659_a.field_70161_v;
            double d3 = MathHelper.func_76133_a(d * d + d2 * d2);
            float f1 = (float)((Math.atan2(d2, d) * 180D) / 3.1415927410125732D) - 90F;
            float f2 = (float)(-((Math.atan2(d1, d3) * 180D) / 3.1415927410125732D));
            field_75659_a.field_70125_A = func_75652_a(field_75659_a.field_70125_A, f2, field_75658_c);
            field_75659_a.field_70759_as = func_75652_a(field_75659_a.field_70759_as, f1, field_75657_b);
        } else
        {
            field_75659_a.field_70759_as = func_75652_a(field_75659_a.field_70759_as, field_75659_a.field_70761_aq, 10F);
        }
        float f = MathHelper.func_76142_g(field_75659_a.field_70759_as - field_75659_a.field_70761_aq);
        if(!field_75659_a.func_70661_as().func_75500_f())
        {
            if(f < -75F)
            {
                field_75659_a.field_70759_as = field_75659_a.field_70761_aq - 75F;
            }
            if(f > 75F)
            {
                field_75659_a.field_70759_as = field_75659_a.field_70761_aq + 75F;
            }
        }
    }

    private float func_75652_a(float p_75652_1_, float p_75652_2_, float p_75652_3_)
    {
        float f = MathHelper.func_76142_g(p_75652_2_ - p_75652_1_);
        if(f > p_75652_3_)
        {
            f = p_75652_3_;
        }
        if(f < -p_75652_3_)
        {
            f = -p_75652_3_;
        }
        return p_75652_1_ + f;
    }
}
