// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityFX, MathHelper, World, Tessellator

public class EntityNoteFX extends EntityFX
{

    float field_70585_a;

    public EntityNoteFX(World p_i3158_1_, double p_i3158_2_, double p_i3158_4_, double p_i3158_6_, 
            double p_i3158_8_, double p_i3158_10_, double p_i3158_12_)
    {
        this(p_i3158_1_, p_i3158_2_, p_i3158_4_, p_i3158_6_, p_i3158_8_, p_i3158_10_, p_i3158_12_, 2.0F);
    }

    public EntityNoteFX(World p_i3159_1_, double p_i3159_2_, double p_i3159_4_, double p_i3159_6_, 
            double p_i3159_8_, double p_i3159_10_, double p_i3159_12_, float p_i3159_14_)
    {
        super(p_i3159_1_, p_i3159_2_, p_i3159_4_, p_i3159_6_, 0.0D, 0.0D, 0.0D);
        field_70159_w *= 0.0099999997764825821D;
        field_70181_x *= 0.0099999997764825821D;
        field_70179_y *= 0.0099999997764825821D;
        field_70181_x += 0.20000000000000001D;
        field_70552_h = MathHelper.func_76126_a(((float)p_i3159_8_ + 0.0F) * 3.141593F * 2.0F) * 0.65F + 0.35F;
        field_70553_i = MathHelper.func_76126_a(((float)p_i3159_8_ + 0.3333333F) * 3.141593F * 2.0F) * 0.65F + 0.35F;
        field_70551_j = MathHelper.func_76126_a(((float)p_i3159_8_ + 0.6666667F) * 3.141593F * 2.0F) * 0.65F + 0.35F;
        field_70544_f *= 0.75F;
        field_70544_f *= p_i3159_14_;
        field_70585_a = field_70544_f;
        field_70547_e = 6;
        field_70145_X = false;
        func_70536_a(64);
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
        field_70544_f = field_70585_a * f;
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
        func_70091_d(field_70159_w, field_70181_x, field_70179_y);
        if(field_70163_u == field_70167_r)
        {
            field_70159_w *= 1.1000000000000001D;
            field_70179_y *= 1.1000000000000001D;
        }
        field_70159_w *= 0.6600000262260437D;
        field_70181_x *= 0.6600000262260437D;
        field_70179_y *= 0.6600000262260437D;
        if(field_70122_E)
        {
            field_70159_w *= 0.69999998807907104D;
            field_70179_y *= 0.69999998807907104D;
        }
    }
}
