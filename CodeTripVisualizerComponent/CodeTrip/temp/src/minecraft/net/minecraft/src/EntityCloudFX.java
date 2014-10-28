// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityFX, World, EntityPlayer, AxisAlignedBB, 
//            Tessellator

public class EntityCloudFX extends EntityFX
{

    float field_70569_a;

    public EntityCloudFX(World p_i3173_1_, double p_i3173_2_, double p_i3173_4_, double p_i3173_6_, 
            double p_i3173_8_, double p_i3173_10_, double p_i3173_12_)
    {
        super(p_i3173_1_, p_i3173_2_, p_i3173_4_, p_i3173_6_, 0.0D, 0.0D, 0.0D);
        float f = 2.5F;
        field_70159_w *= 0.10000000149011612D;
        field_70181_x *= 0.10000000149011612D;
        field_70179_y *= 0.10000000149011612D;
        field_70159_w += p_i3173_8_;
        field_70181_x += p_i3173_10_;
        field_70179_y += p_i3173_12_;
        field_70552_h = field_70553_i = field_70551_j = 1.0F - (float)(Math.random() * 0.30000001192092896D);
        field_70544_f *= 0.75F;
        field_70544_f *= f;
        field_70569_a = field_70544_f;
        field_70547_e = (int)(8D / (Math.random() * 0.80000000000000004D + 0.29999999999999999D));
        field_70547_e *= f;
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
        field_70544_f = field_70569_a * f;
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
        field_70159_w *= 0.95999997854232788D;
        field_70181_x *= 0.95999997854232788D;
        field_70179_y *= 0.95999997854232788D;
        EntityPlayer entityplayer = field_70170_p.func_72890_a(this, 2D);
        if(entityplayer != null && field_70163_u > entityplayer.field_70121_D.field_72338_b)
        {
            field_70163_u += (entityplayer.field_70121_D.field_72338_b - field_70163_u) * 0.20000000000000001D;
            field_70181_x += (entityplayer.field_70181_x - field_70181_x) * 0.20000000000000001D;
            func_70107_b(field_70165_t, field_70163_u, field_70161_v);
        }
        if(field_70122_E)
        {
            field_70159_w *= 0.69999998807907104D;
            field_70179_y *= 0.69999998807907104D;
        }
    }
}
