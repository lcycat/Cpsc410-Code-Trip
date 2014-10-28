// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            EntityThrowable, World, Item, ItemPotion, 
//            AxisAlignedBB, EntityLiving, MovingObjectPosition, PotionEffect, 
//            Potion, NBTTagCompound

public class EntityPotion extends EntityThrowable
{

    private int field_70197_d;

    public EntityPotion(World p_i3595_1_)
    {
        super(p_i3595_1_);
    }

    public EntityPotion(World p_i3596_1_, EntityLiving p_i3596_2_, int p_i3596_3_)
    {
        super(p_i3596_1_, p_i3596_2_);
        field_70197_d = p_i3596_3_;
    }

    public EntityPotion(World p_i3597_1_, double p_i3597_2_, double p_i3597_4_, double p_i3597_6_, 
            int p_i3597_8_)
    {
        super(p_i3597_1_, p_i3597_2_, p_i3597_4_, p_i3597_6_);
        field_70197_d = p_i3597_8_;
    }

    protected float func_70185_h()
    {
        return 0.05F;
    }

    protected float func_70182_d()
    {
        return 0.5F;
    }

    protected float func_70183_g()
    {
        return -20F;
    }

    public int func_70196_i()
    {
        return field_70197_d;
    }

    protected void func_70184_a(MovingObjectPosition p_70184_1_)
    {
        if(!field_70170_p.field_72995_K)
        {
            List list = Item.field_77726_bs.func_77834_f(field_70197_d);
            if(list != null && !list.isEmpty())
            {
                AxisAlignedBB axisalignedbb = field_70121_D.func_72314_b(4D, 2D, 4D);
                List list1 = field_70170_p.func_72872_a(net.minecraft.src.EntityLiving.class, axisalignedbb);
                if(list1 != null && !list1.isEmpty())
                {
                    for(Iterator iterator = list1.iterator(); iterator.hasNext();)
                    {
                        EntityLiving entityliving = (EntityLiving)iterator.next();
                        double d = func_70068_e(entityliving);
                        if(d < 16D)
                        {
                            double d1 = 1.0D - Math.sqrt(d) / 4D;
                            if(entityliving == p_70184_1_.field_72308_g)
                            {
                                d1 = 1.0D;
                            }
                            Iterator iterator1 = list.iterator();
                            while(iterator1.hasNext()) 
                            {
                                PotionEffect potioneffect = (PotionEffect)iterator1.next();
                                int i = potioneffect.func_76456_a();
                                if(Potion.field_76425_a[i].func_76403_b())
                                {
                                    Potion.field_76425_a[i].func_76402_a(field_70192_c, entityliving, potioneffect.func_76458_c(), d1);
                                } else
                                {
                                    int j = (int)(d1 * (double)potioneffect.func_76459_b() + 0.5D);
                                    if(j > 20)
                                    {
                                        entityliving.func_70690_d(new PotionEffect(i, j, potioneffect.func_76458_c()));
                                    }
                                }
                            }
                        }
                    }

                }
            }
            field_70170_p.func_72926_e(2002, (int)Math.round(field_70165_t), (int)Math.round(field_70163_u), (int)Math.round(field_70161_v), field_70197_d);
            func_70106_y();
        }
    }

    public void func_70037_a(NBTTagCompound p_70037_1_)
    {
        super.func_70037_a(p_70037_1_);
        field_70197_d = p_70037_1_.func_74762_e("potionValue");
    }

    public void func_70014_b(NBTTagCompound p_70014_1_)
    {
        super.func_70014_b(p_70014_1_);
        p_70014_1_.func_74768_a("potionValue", field_70197_d);
    }
}
