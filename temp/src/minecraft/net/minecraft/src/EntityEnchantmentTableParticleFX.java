// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityFX, World

public class EntityEnchantmentTableParticleFX extends EntityFX
{

    private float field_70565_a;
    private double field_70568_aq;
    private double field_70567_ar;
    private double field_70566_as;

    public EntityEnchantmentTableParticleFX(World p_i3155_1_, double p_i3155_2_, double p_i3155_4_, double p_i3155_6_, 
            double p_i3155_8_, double p_i3155_10_, double p_i3155_12_)
    {
        super(p_i3155_1_, p_i3155_2_, p_i3155_4_, p_i3155_6_, p_i3155_8_, p_i3155_10_, p_i3155_12_);
        field_70159_w = p_i3155_8_;
        field_70181_x = p_i3155_10_;
        field_70179_y = p_i3155_12_;
        field_70568_aq = field_70165_t = p_i3155_2_;
        field_70567_ar = field_70163_u = p_i3155_4_;
        field_70566_as = field_70161_v = p_i3155_6_;
        float f = field_70146_Z.nextFloat() * 0.6F + 0.4F;
        field_70565_a = field_70544_f = field_70146_Z.nextFloat() * 0.5F + 0.2F;
        field_70552_h = field_70553_i = field_70551_j = 1.0F * f;
        field_70553_i *= 0.9F;
        field_70552_h *= 0.9F;
        field_70547_e = (int)(Math.random() * 10D) + 30;
        field_70145_X = true;
        func_70536_a((int)(Math.random() * 26D + 1.0D + 224D));
    }

    public int func_70070_b(float p_70070_1_)
    {
        int i = super.func_70070_b(p_70070_1_);
        float f = (float)field_70546_d / (float)field_70547_e;
        f *= f;
        f *= f;
        int j = i & 0xff;
        int k = i >> 16 & 0xff;
        k += (int)(f * 15F * 16F);
        if(k > 240)
        {
            k = 240;
        }
        return j | k << 16;
    }

    public float func_70013_c(float p_70013_1_)
    {
        float f = super.func_70013_c(p_70013_1_);
        float f1 = (float)field_70546_d / (float)field_70547_e;
        f1 *= f1;
        f1 *= f1;
        return f * (1.0F - f1) + f1;
    }

    public void func_70071_h_()
    {
        field_70169_q = field_70165_t;
        field_70167_r = field_70163_u;
        field_70166_s = field_70161_v;
        float f = (float)field_70546_d / (float)field_70547_e;
        f = 1.0F - f;
        float f1 = 1.0F - f;
        f1 *= f1;
        f1 *= f1;
        field_70165_t = field_70568_aq + field_70159_w * (double)f;
        field_70163_u = (field_70567_ar + field_70181_x * (double)f) - (double)(f1 * 1.2F);
        field_70161_v = field_70566_as + field_70179_y * (double)f;
        if(field_70546_d++ >= field_70547_e)
        {
            func_70106_y();
        }
    }
}
