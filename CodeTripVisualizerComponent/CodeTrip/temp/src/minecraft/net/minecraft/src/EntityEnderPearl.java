// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityThrowable, MovingObjectPosition, DamageSource, Entity, 
//            World, EntityPlayerMP, NetServerHandler, EntityLiving

public class EntityEnderPearl extends EntityThrowable
{

    public EntityEnderPearl(World p_i3589_1_)
    {
        super(p_i3589_1_);
    }

    public EntityEnderPearl(World p_i3590_1_, EntityLiving p_i3590_2_)
    {
        super(p_i3590_1_, p_i3590_2_);
    }

    public EntityEnderPearl(World p_i3591_1_, double p_i3591_2_, double p_i3591_4_, double p_i3591_6_)
    {
        super(p_i3591_1_, p_i3591_2_, p_i3591_4_, p_i3591_6_);
    }

    protected void func_70184_a(MovingObjectPosition p_70184_1_)
    {
        if(p_70184_1_.field_72308_g != null)
        {
            p_70184_1_.field_72308_g.func_70097_a(DamageSource.func_76356_a(this, field_70192_c), 0);
        }
        for(int i = 0; i < 32; i++)
        {
            field_70170_p.func_72869_a("portal", field_70165_t, field_70163_u + field_70146_Z.nextDouble() * 2D, field_70161_v, field_70146_Z.nextGaussian(), 0.0D, field_70146_Z.nextGaussian());
        }

        if(!field_70170_p.field_72995_K)
        {
            if(field_70192_c != null && (field_70192_c instanceof EntityPlayerMP))
            {
                EntityPlayerMP entityplayermp = (EntityPlayerMP)field_70192_c;
                if(!entityplayermp.field_71135_a.field_72576_c && entityplayermp.field_70170_p == field_70170_p)
                {
                    field_70192_c.func_70634_a(field_70165_t, field_70163_u, field_70161_v);
                    field_70192_c.field_70143_R = 0.0F;
                    field_70192_c.func_70097_a(DamageSource.field_76379_h, 5);
                }
            }
            func_70106_y();
        }
    }
}
