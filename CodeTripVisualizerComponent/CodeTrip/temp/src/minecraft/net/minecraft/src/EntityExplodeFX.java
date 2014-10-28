// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityFX, World

public class EntityExplodeFX extends EntityFX
{

    public EntityExplodeFX(World p_i3180_1_, double p_i3180_2_, double p_i3180_4_, double p_i3180_6_, 
            double p_i3180_8_, double p_i3180_10_, double p_i3180_12_)
    {
        super(p_i3180_1_, p_i3180_2_, p_i3180_4_, p_i3180_6_, p_i3180_8_, p_i3180_10_, p_i3180_12_);
        field_70159_w = p_i3180_8_ + (double)((float)(Math.random() * 2D - 1.0D) * 0.05F);
        field_70181_x = p_i3180_10_ + (double)((float)(Math.random() * 2D - 1.0D) * 0.05F);
        field_70179_y = p_i3180_12_ + (double)((float)(Math.random() * 2D - 1.0D) * 0.05F);
        field_70552_h = field_70553_i = field_70551_j = field_70146_Z.nextFloat() * 0.3F + 0.7F;
        field_70544_f = field_70146_Z.nextFloat() * field_70146_Z.nextFloat() * 6F + 1.0F;
        field_70547_e = (int)(16D / ((double)field_70146_Z.nextFloat() * 0.80000000000000004D + 0.20000000000000001D)) + 2;
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
        field_70181_x += 0.0040000000000000001D;
        func_70091_d(field_70159_w, field_70181_x, field_70179_y);
        field_70159_w *= 0.89999997615814209D;
        field_70181_x *= 0.89999997615814209D;
        field_70179_y *= 0.89999997615814209D;
        if(field_70122_E)
        {
            field_70159_w *= 0.69999998807907104D;
            field_70179_y *= 0.69999998807907104D;
        }
    }
}
