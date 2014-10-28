// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityFX, World, Tessellator

public class EntityLavaFX extends EntityFX
{

    private float field_70586_a;

    public EntityLavaFX(World p_i3169_1_, double p_i3169_2_, double p_i3169_4_, double p_i3169_6_)
    {
        super(p_i3169_1_, p_i3169_2_, p_i3169_4_, p_i3169_6_, 0.0D, 0.0D, 0.0D);
        field_70159_w *= 0.80000001192092896D;
        field_70181_x *= 0.80000001192092896D;
        field_70179_y *= 0.80000001192092896D;
        field_70181_x = field_70146_Z.nextFloat() * 0.4F + 0.05F;
        field_70552_h = field_70553_i = field_70551_j = 1.0F;
        field_70544_f *= field_70146_Z.nextFloat() * 2.0F + 0.2F;
        field_70586_a = field_70544_f;
        field_70547_e = (int)(16D / (Math.random() * 0.80000000000000004D + 0.20000000000000001D));
        field_70145_X = false;
        func_70536_a(49);
    }

    public int func_70070_b(float p_70070_1_)
    {
        float f = ((float)field_70546_d + p_70070_1_) / (float)field_70547_e;
        if(f < 0.0F)
        {
            f = 0.0F;
        }
        if(f > 1.0F)
        {
            f = 1.0F;
        }
        int i = super.func_70070_b(p_70070_1_);
        char c = '\360';
        int j = i >> 16 & 0xff;
        return c | j << 16;
    }

    public float func_70013_c(float p_70013_1_)
    {
        return 1.0F;
    }

    public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_)
    {
        float f = ((float)field_70546_d + p_70539_2_) / (float)field_70547_e;
        field_70544_f = field_70586_a * (1.0F - f * f);
        super.func_70539_a(p_70539_1_, p_70539_2_, p_70539_3_, p_70539_4_, p_70539_5_, p_70539_6_, p_70539_7_);
    }

    public void func_70071_h_()
    {
        field_70169_q = field_70165_t;
        field_70167_r = field_70163_u;
        field_70166_s = field_70161_v;
        if(field_70546_d++ >= field_70547_e)
        {
            func_70106_y();
        }
        float f = (float)field_70546_d / (float)field_70547_e;
        if(field_70146_Z.nextFloat() > f)
        {
            field_70170_p.func_72869_a("smoke", field_70165_t, field_70163_u, field_70161_v, field_70159_w, field_70181_x, field_70179_y);
        }
        field_70181_x -= 0.029999999999999999D;
        func_70091_d(field_70159_w, field_70181_x, field_70179_y);
        field_70159_w *= 0.99900001287460327D;
        field_70181_x *= 0.99900001287460327D;
        field_70179_y *= 0.99900001287460327D;
        if(field_70122_E)
        {
            field_70159_w *= 0.69999998807907104D;
            field_70179_y *= 0.69999998807907104D;
        }
    }
}
