// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityThrowable, World, EntityXPOrb, EntityLiving, 
//            MovingObjectPosition

public class EntityExpBottle extends EntityThrowable
{

    public EntityExpBottle(World p_i3592_1_)
    {
        super(p_i3592_1_);
    }

    public EntityExpBottle(World p_i3593_1_, EntityLiving p_i3593_2_)
    {
        super(p_i3593_1_, p_i3593_2_);
    }

    public EntityExpBottle(World p_i3594_1_, double p_i3594_2_, double p_i3594_4_, double p_i3594_6_)
    {
        super(p_i3594_1_, p_i3594_2_, p_i3594_4_, p_i3594_6_);
    }

    protected float func_70185_h()
    {
        return 0.07F;
    }

    protected float func_70182_d()
    {
        return 0.7F;
    }

    protected float func_70183_g()
    {
        return -20F;
    }

    protected void func_70184_a(MovingObjectPosition p_70184_1_)
    {
        if(!field_70170_p.field_72995_K)
        {
            field_70170_p.func_72926_e(2002, (int)Math.round(field_70165_t), (int)Math.round(field_70163_u), (int)Math.round(field_70161_v), 0);
            for(int i = 3 + field_70170_p.field_73012_v.nextInt(5) + field_70170_p.field_73012_v.nextInt(5); i > 0;)
            {
                int j = EntityXPOrb.func_70527_a(i);
                i -= j;
                field_70170_p.func_72838_d(new EntityXPOrb(field_70170_p, field_70165_t, field_70163_u, field_70161_v, j));
            }

            func_70106_y();
        }
    }
}
