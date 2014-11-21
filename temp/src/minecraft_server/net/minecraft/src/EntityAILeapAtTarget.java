// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityAIBase, EntityLiving, MathHelper

public class EntityAILeapAtTarget extends EntityAIBase
{

    EntityLiving field_75328_a;
    EntityLiving field_75326_b;
    float field_75327_c;

    public EntityAILeapAtTarget(EntityLiving p_i3471_1_, float p_i3471_2_)
    {
        field_75328_a = p_i3471_1_;
        field_75327_c = p_i3471_2_;
        func_75248_a(5);
    }

    public boolean func_75250_a()
    {
        field_75326_b = field_75328_a.func_70638_az();
        if(field_75326_b == null)
        {
            return false;
        }
        double d = field_75328_a.func_70068_e(field_75326_b);
        if(d < 4D || d > 16D)
        {
            return false;
        }
        if(!field_75328_a.field_70122_E)
        {
            return false;
        }
        return field_75328_a.func_70681_au().nextInt(5) == 0;
    }

    public boolean func_75253_b()
    {
        return !field_75328_a.field_70122_E;
    }

    public void func_75249_e()
    {
        double d = field_75326_b.field_70165_t - field_75328_a.field_70165_t;
        double d1 = field_75326_b.field_70161_v - field_75328_a.field_70161_v;
        float f = MathHelper.func_76133_a(d * d + d1 * d1);
        field_75328_a.field_70159_w += (d / (double)f) * 0.5D * 0.80000001192092896D + field_75328_a.field_70159_w * 0.20000000298023224D;
        field_75328_a.field_70179_y += (d1 / (double)f) * 0.5D * 0.80000001192092896D + field_75328_a.field_70179_y * 0.20000000298023224D;
        field_75328_a.field_70181_x = field_75327_c;
    }
}
