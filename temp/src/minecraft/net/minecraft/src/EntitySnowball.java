// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityThrowable, MovingObjectPosition, EntityBlaze, DamageSource, 
//            Entity, World, EntityLiving

public class EntitySnowball extends EntityThrowable
{

    public EntitySnowball(World p_i3580_1_)
    {
        super(p_i3580_1_);
    }

    public EntitySnowball(World p_i3581_1_, EntityLiving p_i3581_2_)
    {
        super(p_i3581_1_, p_i3581_2_);
    }

    public EntitySnowball(World p_i3582_1_, double p_i3582_2_, double p_i3582_4_, double p_i3582_6_)
    {
        super(p_i3582_1_, p_i3582_2_, p_i3582_4_, p_i3582_6_);
    }

    protected void func_70184_a(MovingObjectPosition p_70184_1_)
    {
        if(p_70184_1_.field_72308_g != null)
        {
            byte byte0 = 0;
            if(p_70184_1_.field_72308_g instanceof EntityBlaze)
            {
                byte0 = 3;
            }
            p_70184_1_.field_72308_g.func_70097_a(DamageSource.func_76356_a(this, field_70192_c), byte0);
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
