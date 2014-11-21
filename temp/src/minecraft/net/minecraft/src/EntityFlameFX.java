// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityFX, World, Tessellator

public class EntityFlameFX extends EntityFX
{

    private float field_70562_a;

    public EntityFlameFX(World p_i3150_1_, double p_i3150_2_, double p_i3150_4_, double p_i3150_6_, 
            double p_i3150_8_, double p_i3150_10_, double p_i3150_12_)
    {
        super(p_i3150_1_, p_i3150_2_, p_i3150_4_, p_i3150_6_, p_i3150_8_, p_i3150_10_, p_i3150_12_);
        field_70159_w = field_70159_w * 0.0099999997764825821D + p_i3150_8_;
        field_70181_x = field_70181_x * 0.0099999997764825821D + p_i3150_10_;
        field_70179_y = field_70179_y * 0.0099999997764825821D + p_i3150_12_;
        p_i3150_2_ += (field_70146_Z.nextFloat() - field_70146_Z.nextFloat()) * 0.05F;
        p_i3150_4_ += (field_70146_Z.nextFloat() - field_70146_Z.nextFloat()) * 0.05F;
        p_i3150_6_ += (field_70146_Z.nextFloat() - field_70146_Z.nextFloat()) * 0.05F;
        field_70562_a = field_70544_f;
        field_70552_h = field_70553_i = field_70551_j = 1.0F;
        field_70547_e = (int)(8D / (Math.random() * 0.80000000000000004D + 0.20000000000000001D)) + 4;
        field_70145_X = true;
        func_70536_a(48);
    }

    public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_)
    {
        float f = ((float)field_70546_d + p_70539_2_) / (float)field_70547_e;
        field_70544_f = field_70562_a * (1.0F - f * f * 0.5F);
        super.func_70539_a(p_70539_1_, p_70539_2_, p_70539_3_, p_70539_4_, p_70539_5_, p_70539_6_, p_70539_7_);
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
        int j = i & 0xff;
        int k = i >> 16 & 0xff;
        j += (int)(f * 15F * 16F);
        if(j > 240)
        {
            j = 240;
        }
        return j | k << 16;
    }

    public float func_70013_c(float p_70013_1_)
    {
        float f = ((float)field_70546_d + p_70013_1_) / (float)field_70547_e;
        if(f < 0.0F)
        {
            f = 0.0F;
        }
        if(f > 1.0F)
        {
            f = 1.0F;
        }
        float f1 = super.func_70013_c(p_70013_1_);
        return f1 * f + (1.0F - f);
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
        func_70091_d(field_70159_w, field_70181_x, field_70179_y);
        field_70159_w *= 0.95999997854232788D;
        field_70181_x *= 0.95999997854232788D;
        field_70179_y *= 0.95999997854232788D;
        if(field_70122_E)
        {
            field_70159_w *= 0.69999998807907104D;
            field_70179_y *= 0.69999998807907104D;
        }
    }
}
