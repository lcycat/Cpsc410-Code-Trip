// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityFX, World, Tessellator

public class EntityPortalFX extends EntityFX
{

    private float field_70571_a;
    private double field_70574_aq;
    private double field_70573_ar;
    private double field_70572_as;

    public EntityPortalFX(World p_i3177_1_, double p_i3177_2_, double p_i3177_4_, double p_i3177_6_, 
            double p_i3177_8_, double p_i3177_10_, double p_i3177_12_)
    {
        super(p_i3177_1_, p_i3177_2_, p_i3177_4_, p_i3177_6_, p_i3177_8_, p_i3177_10_, p_i3177_12_);
        field_70159_w = p_i3177_8_;
        field_70181_x = p_i3177_10_;
        field_70179_y = p_i3177_12_;
        field_70574_aq = field_70165_t = p_i3177_2_;
        field_70573_ar = field_70163_u = p_i3177_4_;
        field_70572_as = field_70161_v = p_i3177_6_;
        float f = field_70146_Z.nextFloat() * 0.6F + 0.4F;
        field_70571_a = field_70544_f = field_70146_Z.nextFloat() * 0.2F + 0.5F;
        field_70552_h = field_70553_i = field_70551_j = 1.0F * f;
        field_70553_i *= 0.3F;
        field_70552_h *= 0.9F;
        field_70547_e = (int)(Math.random() * 10D) + 40;
        field_70145_X = true;
        func_70536_a((int)(Math.random() * 8D));
    }

    public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_)
    {
        float f = ((float)field_70546_d + p_70539_2_) / (float)field_70547_e;
        f = 1.0F - f;
        f *= f;
        f = 1.0F - f;
        field_70544_f = field_70571_a * f;
        super.func_70539_a(p_70539_1_, p_70539_2_, p_70539_3_, p_70539_4_, p_70539_5_, p_70539_6_, p_70539_7_);
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
        f1 = f1 * f1 * f1 * f1;
        return f * (1.0F - f1) + f1;
    }

    public void func_70071_h_()
    {
        field_70169_q = field_70165_t;
        field_70167_r = field_70163_u;
        field_70166_s = field_70161_v;
        float f = (float)field_70546_d / (float)field_70547_e;
        float f1 = f;
        f = -f + f * f * 2.0F;
        f = 1.0F - f;
        field_70165_t = field_70574_aq + field_70159_w * (double)f;
        field_70163_u = field_70573_ar + field_70181_x * (double)f + (double)(1.0F - f1);
        field_70161_v = field_70572_as + field_70179_y * (double)f;
        if(field_70546_d++ >= field_70547_e)
        {
            func_70106_y();
        }
    }
}
