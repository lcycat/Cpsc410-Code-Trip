// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityFX, World, Tessellator

public class EntityHugeExplodeFX extends EntityFX
{

    private int field_70579_a;
    private int field_70580_aq;

    public EntityHugeExplodeFX(World p_i3184_1_, double p_i3184_2_, double p_i3184_4_, double p_i3184_6_, 
            double p_i3184_8_, double p_i3184_10_, double p_i3184_12_)
    {
        super(p_i3184_1_, p_i3184_2_, p_i3184_4_, p_i3184_6_, 0.0D, 0.0D, 0.0D);
        field_70579_a = 0;
        field_70580_aq = 0;
        field_70580_aq = 8;
    }

    public void func_70539_a(Tessellator tessellator, float f, float f1, float f2, float f3, float f4, float f5)
    {
    }

    public void func_70071_h_()
    {
        for(int i = 0; i < 6; i++)
        {
            double d = field_70165_t + (field_70146_Z.nextDouble() - field_70146_Z.nextDouble()) * 4D;
            double d1 = field_70163_u + (field_70146_Z.nextDouble() - field_70146_Z.nextDouble()) * 4D;
            double d2 = field_70161_v + (field_70146_Z.nextDouble() - field_70146_Z.nextDouble()) * 4D;
            field_70170_p.func_72869_a("largeexplode", d, d1, d2, (float)field_70579_a / (float)field_70580_aq, 0.0D, 0.0D);
        }

        field_70579_a++;
        if(field_70579_a == field_70580_aq)
        {
            func_70106_y();
        }
    }

    public int func_70537_b()
    {
        return 1;
    }
}
