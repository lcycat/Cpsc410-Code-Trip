// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityAIBase, EntityLiving, EntityPlayer, World, 
//            AxisAlignedBB, Entity, EntityLookHelper

public class EntityAIWatchClosest extends EntityAIBase
{

    private EntityLiving field_75332_b;
    protected Entity field_75334_a;
    private float field_75333_c;
    private int field_75330_d;
    private float field_75331_e;
    private Class field_75329_f;

    public EntityAIWatchClosest(EntityLiving p_i3472_1_, Class p_i3472_2_, float p_i3472_3_)
    {
        field_75332_b = p_i3472_1_;
        field_75329_f = p_i3472_2_;
        field_75333_c = p_i3472_3_;
        field_75331_e = 0.02F;
        func_75248_a(2);
    }

    public EntityAIWatchClosest(EntityLiving p_i3473_1_, Class p_i3473_2_, float p_i3473_3_, float p_i3473_4_)
    {
        field_75332_b = p_i3473_1_;
        field_75329_f = p_i3473_2_;
        field_75333_c = p_i3473_3_;
        field_75331_e = p_i3473_4_;
        func_75248_a(2);
    }

    public boolean func_75250_a()
    {
        if(field_75332_b.func_70681_au().nextFloat() >= field_75331_e)
        {
            return false;
        }
        if(field_75329_f == (net.minecraft.src.EntityPlayer.class))
        {
            field_75334_a = field_75332_b.field_70170_p.func_72890_a(field_75332_b, field_75333_c);
        } else
        {
            field_75334_a = field_75332_b.field_70170_p.func_72857_a(field_75329_f, field_75332_b.field_70121_D.func_72314_b(field_75333_c, 3D, field_75333_c), field_75332_b);
        }
        return field_75334_a != null;
    }

    public boolean func_75253_b()
    {
        if(!field_75334_a.func_70089_S())
        {
            return false;
        }
        if(field_75332_b.func_70068_e(field_75334_a) > (double)(field_75333_c * field_75333_c))
        {
            return false;
        } else
        {
            return field_75330_d > 0;
        }
    }

    public void func_75249_e()
    {
        field_75330_d = 40 + field_75332_b.func_70681_au().nextInt(40);
    }

    public void func_75251_c()
    {
        field_75334_a = null;
    }

    public void func_75246_d()
    {
        field_75332_b.func_70671_ap().func_75650_a(field_75334_a.field_70165_t, field_75334_a.field_70163_u + (double)field_75334_a.func_70047_e(), field_75334_a.field_70161_v, 10F, field_75332_b.func_70646_bf());
        field_75330_d--;
    }
}
