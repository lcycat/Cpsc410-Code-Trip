// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityLiving, MathHelper

public class EntityBodyHelper
{

    private EntityLiving field_75668_a;
    private int field_75666_b;
    private float field_75667_c;

    public EntityBodyHelper(EntityLiving p_i3453_1_)
    {
        field_75666_b = 0;
        field_75667_c = 0.0F;
        field_75668_a = p_i3453_1_;
    }

    public void func_75664_a()
    {
        double d = field_75668_a.field_70165_t - field_75668_a.field_70169_q;
        double d1 = field_75668_a.field_70161_v - field_75668_a.field_70166_s;
        if(d * d + d1 * d1 > 2.5000002779052011E-007D)
        {
            field_75668_a.field_70761_aq = field_75668_a.field_70177_z;
            field_75668_a.field_70759_as = func_75665_a(field_75668_a.field_70761_aq, field_75668_a.field_70759_as, 75F);
            field_75667_c = field_75668_a.field_70759_as;
            field_75666_b = 0;
            return;
        }
        float f = 75F;
        if(Math.abs(field_75668_a.field_70759_as - field_75667_c) > 15F)
        {
            field_75666_b = 0;
            field_75667_c = field_75668_a.field_70759_as;
        } else
        {
            field_75666_b++;
            if(field_75666_b > 10)
            {
                f = Math.max(1.0F - (float)(field_75666_b - 10) / 10F, 0.0F) * 75F;
            }
        }
        field_75668_a.field_70761_aq = func_75665_a(field_75668_a.field_70759_as, field_75668_a.field_70761_aq, f);
    }

    private float func_75665_a(float p_75665_1_, float p_75665_2_, float p_75665_3_)
    {
        float f = MathHelper.func_76142_g(p_75665_1_ - p_75665_2_);
        if(f < -p_75665_3_)
        {
            f = -p_75665_3_;
        }
        if(f >= p_75665_3_)
        {
            f = p_75665_3_;
        }
        return p_75665_1_ - f;
    }
}
