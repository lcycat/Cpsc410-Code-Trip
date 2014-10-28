// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Entity, AxisAlignedBB, MathHelper, World, 
//            EntityItem, ItemStack, Item, NBTTagCompound

public class EntityEnderEye extends Entity
{

    public int field_70226_a;
    private double field_70224_b;
    private double field_70225_c;
    private double field_70222_d;
    private int field_70223_e;
    private boolean field_70221_f;

    public EntityEnderEye(World p_i3569_1_)
    {
        super(p_i3569_1_);
        field_70226_a = 0;
        func_70105_a(0.25F, 0.25F);
    }

    protected void func_70088_a()
    {
    }

    public boolean func_70112_a(double p_70112_1_)
    {
        double d = field_70121_D.func_72320_b() * 4D;
        d *= 64D;
        return p_70112_1_ < d * d;
    }

    public EntityEnderEye(World p_i3570_1_, double p_i3570_2_, double p_i3570_4_, double p_i3570_6_)
    {
        super(p_i3570_1_);
        field_70226_a = 0;
        field_70223_e = 0;
        func_70105_a(0.25F, 0.25F);
        func_70107_b(p_i3570_2_, p_i3570_4_, p_i3570_6_);
        field_70129_M = 0.0F;
    }

    public void func_70220_a(double p_70220_1_, int p_70220_3_, double p_70220_4_)
    {
        double d = p_70220_1_ - field_70165_t;
        double d1 = p_70220_4_ - field_70161_v;
        float f = MathHelper.func_76133_a(d * d + d1 * d1);
        if(f > 12F)
        {
            field_70224_b = field_70165_t + (d / (double)f) * 12D;
            field_70222_d = field_70161_v + (d1 / (double)f) * 12D;
            field_70225_c = field_70163_u + 8D;
        } else
        {
            field_70224_b = p_70220_1_;
            field_70225_c = p_70220_3_;
            field_70222_d = p_70220_4_;
        }
        field_70223_e = 0;
        field_70221_f = field_70146_Z.nextInt(5) > 0;
    }

    public void func_70016_h(double p_70016_1_, double p_70016_3_, double p_70016_5_)
    {
        field_70159_w = p_70016_1_;
        field_70181_x = p_70016_3_;
        field_70179_y = p_70016_5_;
        if(field_70127_C == 0.0F && field_70126_B == 0.0F)
        {
            float f = MathHelper.func_76133_a(p_70016_1_ * p_70016_1_ + p_70016_5_ * p_70016_5_);
            field_70126_B = field_70177_z = (float)((Math.atan2(p_70016_1_, p_70016_5_) * 180D) / 3.1415927410125732D);
            field_70127_C = field_70125_A = (float)((Math.atan2(p_70016_3_, f) * 180D) / 3.1415927410125732D);
        }
    }

    public void func_70071_h_()
    {
        field_70142_S = field_70165_t;
        field_70137_T = field_70163_u;
        field_70136_U = field_70161_v;
        super.func_70071_h_();
        field_70165_t += field_70159_w;
        field_70163_u += field_70181_x;
        field_70161_v += field_70179_y;
        float f = MathHelper.func_76133_a(field_70159_w * field_70159_w + field_70179_y * field_70179_y);
        field_70177_z = (float)((Math.atan2(field_70159_w, field_70179_y) * 180D) / 3.1415927410125732D);
        for(field_70125_A = (float)((Math.atan2(field_70181_x, f) * 180D) / 3.1415927410125732D); field_70125_A - field_70127_C < -180F; field_70127_C -= 360F) { }
        for(; field_70125_A - field_70127_C >= 180F; field_70127_C += 360F) { }
        for(; field_70177_z - field_70126_B < -180F; field_70126_B -= 360F) { }
        for(; field_70177_z - field_70126_B >= 180F; field_70126_B += 360F) { }
        field_70125_A = field_70127_C + (field_70125_A - field_70127_C) * 0.2F;
        field_70177_z = field_70126_B + (field_70177_z - field_70126_B) * 0.2F;
        if(!field_70170_p.field_72995_K)
        {
            double d = field_70224_b - field_70165_t;
            double d1 = field_70222_d - field_70161_v;
            float f2 = (float)Math.sqrt(d * d + d1 * d1);
            float f3 = (float)Math.atan2(d1, d);
            double d2 = (double)f + (double)(f2 - f) * 0.0025000000000000001D;
            if(f2 < 1.0F)
            {
                d2 *= 0.80000000000000004D;
                field_70181_x *= 0.80000000000000004D;
            }
            field_70159_w = Math.cos(f3) * d2;
            field_70179_y = Math.sin(f3) * d2;
            if(field_70163_u < field_70225_c)
            {
                field_70181_x += (1.0D - field_70181_x) * 0.014999999664723873D;
            } else
            {
                field_70181_x += (-1D - field_70181_x) * 0.014999999664723873D;
            }
        }
        float f1 = 0.25F;
        if(func_70090_H())
        {
            for(int i = 0; i < 4; i++)
            {
                field_70170_p.func_72869_a("bubble", field_70165_t - field_70159_w * (double)f1, field_70163_u - field_70181_x * (double)f1, field_70161_v - field_70179_y * (double)f1, field_70159_w, field_70181_x, field_70179_y);
            }

        } else
        {
            field_70170_p.func_72869_a("portal", ((field_70165_t - field_70159_w * (double)f1) + field_70146_Z.nextDouble() * 0.59999999999999998D) - 0.29999999999999999D, field_70163_u - field_70181_x * (double)f1 - 0.5D, ((field_70161_v - field_70179_y * (double)f1) + field_70146_Z.nextDouble() * 0.59999999999999998D) - 0.29999999999999999D, field_70159_w, field_70181_x, field_70179_y);
        }
        if(!field_70170_p.field_72995_K)
        {
            func_70107_b(field_70165_t, field_70163_u, field_70161_v);
            field_70223_e++;
            if(field_70223_e > 80 && !field_70170_p.field_72995_K)
            {
                func_70106_y();
                if(field_70221_f)
                {
                    field_70170_p.func_72838_d(new EntityItem(field_70170_p, field_70165_t, field_70163_u, field_70161_v, new ItemStack(Item.field_77748_bA)));
                } else
                {
                    field_70170_p.func_72926_e(2003, (int)Math.round(field_70165_t), (int)Math.round(field_70163_u), (int)Math.round(field_70161_v), 0);
                }
            }
        }
    }

    public void func_70014_b(NBTTagCompound nbttagcompound)
    {
    }

    public void func_70037_a(NBTTagCompound nbttagcompound)
    {
    }

    public float func_70053_R()
    {
        return 0.0F;
    }

    public float func_70013_c(float p_70013_1_)
    {
        return 1.0F;
    }

    public int func_70070_b(float p_70070_1_)
    {
        return 0xf000f0;
    }

    public boolean func_70075_an()
    {
        return false;
    }
}
