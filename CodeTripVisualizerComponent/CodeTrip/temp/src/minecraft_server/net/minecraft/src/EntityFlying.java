// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityLiving, MathHelper, AxisAlignedBB, World, 
//            Block

public abstract class EntityFlying extends EntityLiving
{

    public EntityFlying(World p_i3442_1_)
    {
        super(p_i3442_1_);
    }

    protected void func_70069_a(float f)
    {
    }

    public void func_70612_e(float p_70612_1_, float p_70612_2_)
    {
        if(func_70090_H())
        {
            func_70060_a(p_70612_1_, p_70612_2_, 0.02F);
            func_70091_d(field_70159_w, field_70181_x, field_70179_y);
            field_70159_w *= 0.80000001192092896D;
            field_70181_x *= 0.80000001192092896D;
            field_70179_y *= 0.80000001192092896D;
        } else
        if(func_70058_J())
        {
            func_70060_a(p_70612_1_, p_70612_2_, 0.02F);
            func_70091_d(field_70159_w, field_70181_x, field_70179_y);
            field_70159_w *= 0.5D;
            field_70181_x *= 0.5D;
            field_70179_y *= 0.5D;
        } else
        {
            float f = 0.91F;
            if(field_70122_E)
            {
                f = 0.5460001F;
                int i = field_70170_p.func_72798_a(MathHelper.func_76128_c(field_70165_t), MathHelper.func_76128_c(field_70121_D.field_72338_b) - 1, MathHelper.func_76128_c(field_70161_v));
                if(i > 0)
                {
                    f = Block.field_71973_m[i].field_72016_cq * 0.91F;
                }
            }
            float f1 = 0.1627714F / (f * f * f);
            func_70060_a(p_70612_1_, p_70612_2_, field_70122_E ? 0.1F * f1 : 0.02F);
            f = 0.91F;
            if(field_70122_E)
            {
                f = 0.5460001F;
                int j = field_70170_p.func_72798_a(MathHelper.func_76128_c(field_70165_t), MathHelper.func_76128_c(field_70121_D.field_72338_b) - 1, MathHelper.func_76128_c(field_70161_v));
                if(j > 0)
                {
                    f = Block.field_71973_m[j].field_72016_cq * 0.91F;
                }
            }
            func_70091_d(field_70159_w, field_70181_x, field_70179_y);
            field_70159_w *= f;
            field_70181_x *= f;
            field_70179_y *= f;
        }
        field_70722_aY = field_70721_aZ;
        double d = field_70165_t - field_70169_q;
        double d1 = field_70161_v - field_70166_s;
        float f2 = MathHelper.func_76133_a(d * d + d1 * d1) * 4F;
        if(f2 > 1.0F)
        {
            f2 = 1.0F;
        }
        field_70721_aZ += (f2 - field_70721_aZ) * 0.4F;
        field_70754_ba += field_70721_aZ;
    }

    public boolean func_70617_f_()
    {
        return false;
    }
}
