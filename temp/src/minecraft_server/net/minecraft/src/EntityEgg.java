// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityThrowable, MovingObjectPosition, DamageSource, Entity, 
//            World, EntityChicken, EntityLiving

public class EntityEgg extends EntityThrowable
{

    public EntityEgg(World p_i3586_1_)
    {
        super(p_i3586_1_);
    }

    public EntityEgg(World p_i3587_1_, EntityLiving p_i3587_2_)
    {
        super(p_i3587_1_, p_i3587_2_);
    }

    public EntityEgg(World p_i3588_1_, double p_i3588_2_, double p_i3588_4_, double p_i3588_6_)
    {
        super(p_i3588_1_, p_i3588_2_, p_i3588_4_, p_i3588_6_);
    }

    protected void func_70184_a(MovingObjectPosition p_70184_1_)
    {
        if(p_70184_1_.field_72308_g != null)
        {
            p_70184_1_.field_72308_g.func_70097_a(DamageSource.func_76356_a(this, field_70192_c), 0);
        }
        if(!field_70170_p.field_72995_K && field_70146_Z.nextInt(8) == 0)
        {
            byte byte0 = 1;
            if(field_70146_Z.nextInt(32) == 0)
            {
                byte0 = 4;
            }
            for(int j = 0; j < byte0; j++)
            {
                EntityChicken entitychicken = new EntityChicken(field_70170_p);
                entitychicken.func_70873_a(-24000);
                entitychicken.func_70012_b(field_70165_t, field_70163_u, field_70161_v, field_70177_z, 0.0F);
                field_70170_p.func_72838_d(entitychicken);
            }

        }
        for(int i = 0; i < 8; i++)
        {
            field_70170_p.func_72869_a("snowballpoof", field_70165_t, field_70163_u, field_70161_v, 0.0D, 0.0D, 0.0D);
        }

        if(!field_70170_p.field_72995_K)
        {
            func_70106_y();
        }
    }
}
