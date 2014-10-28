// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityFX, MathHelper, World, Material

public class EntitySuspendFX extends EntityFX
{

    public EntitySuspendFX(World p_i3167_1_, double p_i3167_2_, double p_i3167_4_, double p_i3167_6_, 
            double p_i3167_8_, double p_i3167_10_, double p_i3167_12_)
    {
        super(p_i3167_1_, p_i3167_2_, p_i3167_4_ - 0.125D, p_i3167_6_, p_i3167_8_, p_i3167_10_, p_i3167_12_);
        field_70552_h = 0.4F;
        field_70553_i = 0.4F;
        field_70551_j = 0.7F;
        func_70536_a(0);
        func_70105_a(0.01F, 0.01F);
        field_70544_f *= field_70146_Z.nextFloat() * 0.6F + 0.2F;
        field_70159_w = p_i3167_8_ * 0.0D;
        field_70181_x = p_i3167_10_ * 0.0D;
        field_70179_y = p_i3167_12_ * 0.0D;
        field_70547_e = (int)(16D / (Math.random() * 0.80000000000000004D + 0.20000000000000001D));
    }

    public void func_70071_h_()
    {
        field_70169_q = field_70165_t;
        field_70167_r = field_70163_u;
        field_70166_s = field_70161_v;
        func_70091_d(field_70159_w, field_70181_x, field_70179_y);
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
