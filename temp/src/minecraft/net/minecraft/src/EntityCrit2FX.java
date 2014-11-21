// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityFX, Entity, AxisAlignedBB, World, 
//            Tessellator

public class EntityCrit2FX extends EntityFX
{

    private Entity field_70557_a;
    private int field_70560_aq;
    private int field_70559_ar;
    private String field_70558_as;

    public EntityCrit2FX(World p_i3171_1_, Entity p_i3171_2_)
    {
        this(p_i3171_1_, p_i3171_2_, "crit");
    }

    public EntityCrit2FX(World p_i3172_1_, Entity p_i3172_2_, String p_i3172_3_)
    {
        super(p_i3172_1_, p_i3172_2_.field_70165_t, p_i3172_2_.field_70121_D.field_72338_b + (double)(p_i3172_2_.field_70131_O / 2.0F), p_i3172_2_.field_70161_v, p_i3172_2_.field_70159_w, p_i3172_2_.field_70181_x, p_i3172_2_.field_70179_y);
        field_70560_aq = 0;
        field_70559_ar = 0;
        field_70557_a = p_i3172_2_;
        field_70559_ar = 3;
        field_70558_as = p_i3172_3_;
        func_70071_h_();
    }

    public void func_70539_a(Tessellator tessellator, float f, float f1, float f2, float f3, float f4, float f5)
    {
    }

    public void func_70071_h_()
    {
        for(int i = 0; i < 16; i++)
        {
            double d = field_70146_Z.nextFloat() * 2.0F - 1.0F;
            double d1 = field_70146_Z.nextFloat() * 2.0F - 1.0F;
            double d2 = field_70146_Z.nextFloat() * 2.0F - 1.0F;
            if(d * d + d1 * d1 + d2 * d2 <= 1.0D)
            {
                double d3 = field_70557_a.field_70165_t + (d * (double)field_70557_a.field_70130_N) / 4D;
                double d4 = field_70557_a.field_70121_D.field_72338_b + (double)(field_70557_a.field_70131_O / 2.0F) + (d1 * (double)field_70557_a.field_70131_O) / 4D;
                double d5 = field_70557_a.field_70161_v + (d2 * (double)field_70557_a.field_70130_N) / 4D;
                field_70170_p.func_72869_a(field_70558_as, d3, d4, d5, d, d1 + 0.20000000000000001D, d2);
            }
        }

        field_70560_aq++;
        if(field_70560_aq >= field_70559_ar)
        {
            func_70106_y();
        }
    }

    public int func_70537_b()
    {
        return 3;
    }
}
