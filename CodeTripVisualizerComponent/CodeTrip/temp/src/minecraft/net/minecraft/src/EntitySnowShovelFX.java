// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityFX, World, Tessellator

public class EntitySnowShovelFX extends EntityFX
{

    float field_70588_a;

    public EntitySnowShovelFX(World p_i3160_1_, double p_i3160_2_, double p_i3160_4_, double p_i3160_6_, 
            double p_i3160_8_, double p_i3160_10_, double p_i3160_12_)
    {
        this(p_i3160_1_, p_i3160_2_, p_i3160_4_, p_i3160_6_, p_i3160_8_, p_i3160_10_, p_i3160_12_, 1.0F);
    }

    public EntitySnowShovelFX(World p_i3161_1_, double p_i3161_2_, double p_i3161_4_, double p_i3161_6_, 
            double p_i3161_8_, double p_i3161_10_, double p_i3161_12_, float p_i3161_14_)
    {
        super(p_i3161_1_, p_i3161_2_, p_i3161_4_, p_i3161_6_, p_i3161_8_, p_i3161_10_, p_i3161_12_);
        field_70159_w *= 0.10000000149011612D;
        field_70181_x *= 0.10000000149011612D;
        field_70179_y *= 0.10000000149011612D;
        field_70159_w += p_i3161_8_;
        field_70181_x += p_i3161_10_;
        field_70179_y += p_i3161_12_;
        field_70552_h = field_70553_i = field_70551_j = 1.0F - (float)(Math.random() * 0.30000001192092896D);
        field_70544_f *= 0.75F;
        field_70544_f *= p_i3161_14_;
        field_70588_a = field_70544_f;
        field_70547_e = (int)(8D / (Math.random() * 0.80000000000000004D + 0.20000000000000001D));
        field_70547_e *= p_i3161_14_;
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
        field_70544_f = field_70588_a * f;
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
        field_70181_x -= 0.029999999999999999D;
        func_70091_d(field_70159_w, field_70181_x, field_70179_y);
        field_70159_w *= 0.99000000953674316D;
        field_70181_x *= 0.99000000953674316D;
        field_70179_y *= 0.99000000953674316D;
        if(field_70122_E)
        {
            field_70159_w *= 0.69999998807907104D;
            field_70179_y *= 0.69999998807907104D;
        }
    }
}
