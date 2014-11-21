// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityAIBase, EntityLiving, EntitySenses, AxisAlignedBB, 
//            EntityTameable, EntityPlayer, PlayerCapabilities, MathHelper, 
//            PathNavigate, PathEntity, PathPoint

public abstract class EntityAITarget extends EntityAIBase
{

    protected EntityLiving field_75299_d;
    protected float field_75300_e;
    protected boolean field_75297_f;
    private boolean field_75303_a;
    private int field_75301_b;
    private int field_75302_c;
    private int field_75298_g;

    public EntityAITarget(EntityLiving p_i3505_1_, float p_i3505_2_, boolean p_i3505_3_)
    {
        this(p_i3505_1_, p_i3505_2_, p_i3505_3_, false);
    }

    public EntityAITarget(EntityLiving p_i3506_1_, float p_i3506_2_, boolean p_i3506_3_, boolean p_i3506_4_)
    {
        field_75301_b = 0;
        field_75302_c = 0;
        field_75298_g = 0;
        field_75299_d = p_i3506_1_;
        field_75300_e = p_i3506_2_;
        field_75297_f = p_i3506_3_;
        field_75303_a = p_i3506_4_;
    }

    public boolean func_75253_b()
    {
        EntityLiving entityliving = field_75299_d.func_70638_az();
        if(entityliving == null)
        {
            return false;
        }
        if(!entityliving.func_70089_S())
        {
            return false;
        }
        if(field_75299_d.func_70068_e(entityliving) > (double)(field_75300_e * field_75300_e))
        {
            return false;
        }
        if(field_75297_f)
        {
            if(field_75299_d.func_70635_at().func_75522_a(entityliving))
            {
                field_75298_g = 0;
            } else
            if(++field_75298_g > 60)
            {
                return false;
            }
        }
        return true;
    }

    public void func_75249_e()
    {
        field_75301_b = 0;
        field_75302_c = 0;
        field_75298_g = 0;
    }

    public void func_75251_c()
    {
        field_75299_d.func_70624_b(null);
    }

    protected boolean func_75296_a(EntityLiving p_75296_1_, boolean p_75296_2_)
    {
        if(p_75296_1_ == null)
        {
            return false;
        }
        if(p_75296_1_ == field_75299_d)
        {
            return false;
        }
        if(!p_75296_1_.func_70089_S())
        {
            return false;
        }
        if(p_75296_1_.field_70121_D.field_72337_e <= field_75299_d.field_70121_D.field_72338_b || p_75296_1_.field_70121_D.field_72338_b >= field_75299_d.field_70121_D.field_72337_e)
        {
            return false;
        }
        if(!field_75299_d.func_70686_a(p_75296_1_.getClass()))
        {
            return false;
        }
        if((field_75299_d instanceof EntityTameable) && ((EntityTameable)field_75299_d).func_70909_n())
        {
            if((p_75296_1_ instanceof EntityTameable) && ((EntityTameable)p_75296_1_).func_70909_n())
            {
                return false;
            }
            if(p_75296_1_ == ((EntityTameable)field_75299_d).func_70902_q())
            {
                return false;
            }
        } else
        if((p_75296_1_ instanceof EntityPlayer) && !p_75296_2_ && ((EntityPlayer)p_75296_1_).field_71075_bZ.field_75102_a)
        {
            return false;
        }
        if(!field_75299_d.func_70649_d(MathHelper.func_76128_c(p_75296_1_.field_70165_t), MathHelper.func_76128_c(p_75296_1_.field_70163_u), MathHelper.func_76128_c(p_75296_1_.field_70161_v)))
        {
            return false;
        }
        if(field_75297_f && !field_75299_d.func_70635_at().func_75522_a(p_75296_1_))
        {
            return false;
        }
        if(field_75303_a)
        {
            if(--field_75302_c <= 0)
            {
                field_75301_b = 0;
            }
            if(field_75301_b == 0)
            {
                field_75301_b = func_75295_a(p_75296_1_) ? 1 : 2;
            }
            if(field_75301_b == 2)
            {
                return false;
            }
        }
        return true;
    }

    private boolean func_75295_a(EntityLiving p_75295_1_)
    {
        field_75302_c = 10 + field_75299_d.func_70681_au().nextInt(5);
        PathEntity pathentity = field_75299_d.func_70661_as().func_75494_a(p_75295_1_);
        if(pathentity == null)
        {
            return false;
        }
        PathPoint pathpoint = pathentity.func_75870_c();
        if(pathpoint == null)
        {
            return false;
        } else
        {
            int i = pathpoint.field_75839_a - MathHelper.func_76128_c(p_75295_1_.field_70165_t);
            int j = pathpoint.field_75838_c - MathHelper.func_76128_c(p_75295_1_.field_70161_v);
            return (double)(i * i + j * j) <= 2.25D;
        }
    }
}
