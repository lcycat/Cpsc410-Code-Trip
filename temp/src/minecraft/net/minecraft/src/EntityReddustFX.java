// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityFX, World, Tessellator

public class EntityReddustFX extends EntityFX
{

    float field_70570_a;

    public EntityReddustFX(World p_i3178_1_, double p_i3178_2_, double p_i3178_4_, double p_i3178_6_, 
            float p_i3178_8_, float p_i3178_9_, float p_i3178_10_)
    {
        this(p_i3178_1_, p_i3178_2_, p_i3178_4_, p_i3178_6_, 1.0F, p_i3178_8_, p_i3178_9_, p_i3178_10_);
    }

    public EntityReddustFX(World p_i3179_1_, double p_i3179_2_, double p_i3179_4_, double p_i3179_6_, 
            float p_i3179_8_, float p_i3179_9_, float p_i3179_10_, float p_i3179_11_)
    {
        super(p_i3179_1_, p_i3179_2_, p_i3179_4_, p_i3179_6_, 0.0D, 0.0D, 0.0D);
        field_70159_w *= 0.10000000149011612D;
        field_70181_x *= 0.10000000149011612D;
        field_70179_y *= 0.10000000149011612D;
        if(p_i3179_9_ == 0.0F)
        {
            p_i3179_9_ = 1.0F;
        }
        float f = (float)Math.random() * 0.4F + 0.6F;
        field_70552_h = ((float)(Math.random() * 0.20000000298023224D) + 0.8F) * p_i3179_9_ * f;
        field_70553_i = ((float)(Math.random() * 0.20000000298023224D) + 0.8F) * p_i3179_10_ * f;
        field_70551_j = ((float)(Math.random() * 0.20000000298023224D) + 0.8F) * p_i3179_11_ * f;
        field_70544_f *= 0.75F;
        field_70544_f *= p_i3179_8_;
        field_70570_a = field_70544_f;
        field_70547_e = (int)(8D / (Math.random() * 0.80000000000000004D + 0.20000000000000001D));
        field_70547_e *= p_i3179_8_;
        field_70145_X = false;
    }

    public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_)
    {
        float f = (((float)field_70546_d + p_70539_2_) / (float)field_70547_e) * 32F;
        if(f < 0.0F)
        {
            f = 0.0F;
        }
        if(f > 1.0F)
        {
            f = 1.0F;
        }
        field_70544_f = field_70570_a * f;
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
        func_70536_a(7 - (field_70546_d * 8) / field_70547_e);
        func_70091_d(field_70159_w, field_70181_x, field_70179_y);
        if(field_70163_u == field_70167_r)
        {
            field_70159_w *= 1.1000000000000001D;
            field_70179_y *= 1.1000000000000001D;
        }
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
