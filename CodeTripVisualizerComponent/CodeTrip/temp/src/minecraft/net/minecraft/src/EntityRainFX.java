// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityFX, MathHelper, World, Material, 
//            BlockFluid

public class EntityRainFX extends EntityFX
{

    public EntityRainFX(World p_i3157_1_, double p_i3157_2_, double p_i3157_4_, double p_i3157_6_)
    {
        super(p_i3157_1_, p_i3157_2_, p_i3157_4_, p_i3157_6_, 0.0D, 0.0D, 0.0D);
        field_70159_w *= 0.30000001192092896D;
        field_70181_x = (float)Math.random() * 0.2F + 0.1F;
        field_70179_y *= 0.30000001192092896D;
        field_70552_h = 1.0F;
        field_70553_i = 1.0F;
        field_70551_j = 1.0F;
        func_70536_a(19 + field_70146_Z.nextInt(4));
        func_70105_a(0.01F, 0.01F);
        field_70545_g = 0.06F;
        field_70547_e = (int)(8D / (Math.random() * 0.80000000000000004D + 0.20000000000000001D));
    }

    public void func_70071_h_()
    {
        field_70169_q = field_70165_t;
        field_70167_r = field_70163_u;
        field_70166_s = field_70161_v;
        field_70181_x -= field_70545_g;
        func_70091_d(field_70159_w, field_70181_x, field_70179_y);
        field_70159_w *= 0.98000001907348633D;
        field_70181_x *= 0.98000001907348633D;
        field_70179_y *= 0.98000001907348633D;
        if(field_70547_e-- <= 0)
        {
            func_70106_y();
        }
        if(field_70122_E)
        {
            if(Math.random() < 0.5D)
            {
                func_70106_y();
            }
            field_70159_w *= 0.69999998807907104D;
            field_70179_y *= 0.69999998807907104D;
        }
        Material material = field_70170_p.func_72803_f(MathHelper.func_76128_c(field_70165_t), MathHelper.func_76128_c(field_70163_u), MathHelper.func_76128_c(field_70161_v));
        if(material.func_76224_d() || material.func_76220_a())
        {
            double d = (float)(MathHelper.func_76128_c(field_70163_u) + 1) - BlockFluid.func_72199_d(field_70170_p.func_72805_g(MathHelper.func_76128_c(field_70165_t), MathHelper.func_76128_c(field_70163_u), MathHelper.func_76128_c(field_70161_v)));
            if(field_70163_u < d)
            {
                func_70106_y();
            }
        }
    }
}
