// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityFX, MathHelper, World, Material

public class EntityBubbleFX extends EntityFX
{

    public EntityBubbleFX(World p_i3162_1_, double p_i3162_2_, double p_i3162_4_, double p_i3162_6_, 
            double p_i3162_8_, double p_i3162_10_, double p_i3162_12_)
    {
        super(p_i3162_1_, p_i3162_2_, p_i3162_4_, p_i3162_6_, p_i3162_8_, p_i3162_10_, p_i3162_12_);
        field_70552_h = 1.0F;
        field_70553_i = 1.0F;
        field_70551_j = 1.0F;
        func_70536_a(32);
        func_70105_a(0.02F, 0.02F);
        field_70544_f *= field_70146_Z.nextFloat() * 0.6F + 0.2F;
        field_70159_w = p_i3162_8_ * 0.20000000298023224D + (double)((float)(Math.random() * 2D - 1.0D) * 0.02F);
        field_70181_x = p_i3162_10_ * 0.20000000298023224D + (double)((float)(Math.random() * 2D - 1.0D) * 0.02F);
        field_70179_y = p_i3162_12_ * 0.20000000298023224D + (double)((float)(Math.random() * 2D - 1.0D) * 0.02F);
        field_70547_e = (int)(8D / (Math.random() * 0.80000000000000004D + 0.20000000000000001D));
    }

    public void func_70071_h_()
    {
        field_70169_q = field_70165_t;
        field_70167_r = field_70163_u;
        field_70166_s = field_70161_v;
        field_70181_x += 0.002D;
        func_70091_d(field_70159_w, field_70181_x, field_70179_y);
        field_70159_w *= 0.85000002384185791D;
        field_70181_x *= 0.85000002384185791D;
        field_70179_y *= 0.85000002384185791D;
        if(field_70170_p.func_72803_f(MathHelper.func_76128_c(field_70165_t), MathHelper.func_76128_c(field_70163_u), MathHelper.func_76128_c(field_70161_v)) != Material.field_76244_g)
        {
            func_70106_y();
        }
        if(field_70547_e-- <= 0)
        {
            func_70106_y();
        }
    }
}
