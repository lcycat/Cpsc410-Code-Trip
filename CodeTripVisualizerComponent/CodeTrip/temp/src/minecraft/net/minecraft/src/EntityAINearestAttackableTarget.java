// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            EntityAITarget, EntityAINearestAttackableTargetSorter, EntityLiving, EntityPlayer, 
//            World, AxisAlignedBB, Entity

public class EntityAINearestAttackableTarget extends EntityAITarget
{

    EntityLiving field_75309_a;
    Class field_75307_b;
    int field_75308_c;
    private EntityAINearestAttackableTargetSorter field_75306_g;

    public EntityAINearestAttackableTarget(EntityLiving p_i3500_1_, Class p_i3500_2_, float p_i3500_3_, int p_i3500_4_, boolean p_i3500_5_)
    {
        this(p_i3500_1_, p_i3500_2_, p_i3500_3_, p_i3500_4_, p_i3500_5_, false);
    }

    public EntityAINearestAttackableTarget(EntityLiving p_i3501_1_, Class p_i3501_2_, float p_i3501_3_, int p_i3501_4_, boolean p_i3501_5_, boolean p_i3501_6_)
    {
        super(p_i3501_1_, p_i3501_3_, p_i3501_5_, p_i3501_6_);
        field_75307_b = p_i3501_2_;
        field_75300_e = p_i3501_3_;
        field_75308_c = p_i3501_4_;
        field_75306_g = new EntityAINearestAttackableTargetSorter(this, p_i3501_1_);
        func_75248_a(1);
    }

    public boolean func_75250_a()
    {
label0:
        {
            if(field_75308_c > 0 && field_75299_d.func_70681_au().nextInt(field_75308_c) != 0)
            {
                return false;
            }
            if(field_75307_b == (net.minecraft.src.EntityPlayer.class))
            {
                EntityPlayer entityplayer = field_75299_d.field_70170_p.func_72856_b(field_75299_d, field_75300_e);
                if(func_75296_a(entityplayer, false))
                {
                    field_75309_a = entityplayer;
                    return true;
                }
                break label0;
            }
            List list = field_75299_d.field_70170_p.func_72872_a(field_75307_b, field_75299_d.field_70121_D.func_72314_b(field_75300_e, 4D, field_75300_e));
            Collections.sort(list, field_75306_g);
            Iterator iterator = list.iterator();
            EntityLiving entityliving;
            do
            {
                if(!iterator.hasNext())
                {
                    break label0;
                }
                Entity entity = (Entity)iterator.next();
                entityliving = (EntityLiving)entity;
            } while(!func_75296_a(entityliving, false));
            field_75309_a = entityliving;
            return true;
        }
        return false;
    }

    public void func_75249_e()
    {
        field_75299_d.func_70624_b(field_75309_a);
        super.func_75249_e();
    }
}
