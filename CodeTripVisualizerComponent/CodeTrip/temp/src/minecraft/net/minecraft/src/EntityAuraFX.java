// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityFX, World

public class EntityAuraFX extends EntityFX
{

    public EntityAuraFX(World p_i3166_1_, double p_i3166_2_, double p_i3166_4_, double p_i3166_6_, 
            double p_i3166_8_, double p_i3166_10_, double p_i3166_12_)
    {
        super(p_i3166_1_, p_i3166_2_, p_i3166_4_, p_i3166_6_, p_i3166_8_, p_i3166_10_, p_i3166_12_);
        float f = field_70146_Z.nextFloat() * 0.1F + 0.2F;
        field_70552_h = f;
        field_70553_i = f;
        field_70551_j = f;
        func_70536_a(0);
        func_70105_a(0.02F, 0.02F);
        field_70544_f *= field_70146_Z.nextFloat() * 0.6F + 0.5F;
        field_70159_w *= 0.019999999552965164D;
        field_70181_x *= 0.019999999552965164D;
        field_70179_y *= 0.019999999552965164D;
        field_70547_e = (int)(20D / (Math.random() * 0.80000000000000004D + 0.20000000000000001D));
        field_70145_X = true;
    }

    public void func_70071_h_()
    {
        field_70169_q = field_70165_t;
        field_70167_r = field_70163_u;
        field_70166_s = field_70161_v;
        func_70091_d(field_70159_w, field_70181_x, field_70179_y);
        field_70159_w *= 0.98999999999999999D;
        field_70181_x *= 0.98999999999999999D;
        field_70179_y *= 0.98999999999999999D;
        if(field_70547_e-- <= 0)
        {
            func_70106_y();
        }
    }
}
