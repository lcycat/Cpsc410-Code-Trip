// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityAIBase, EntityIronGolem, World, EntityVillager, 
//            AxisAlignedBB, EntityLookHelper

public class EntityAILookAtVillager extends EntityAIBase
{

    private EntityIronGolem field_75397_a;
    private EntityVillager field_75395_b;
    private int field_75396_c;

    public EntityAILookAtVillager(EntityIronGolem p_i3483_1_)
    {
        field_75397_a = p_i3483_1_;
        func_75248_a(3);
    }

    public boolean func_75250_a()
    {
        if(!field_75397_a.field_70170_p.func_72935_r())
        {
            return false;
        }
        if(field_75397_a.func_70681_au().nextInt(8000) != 0)
        {
            return false;
        } else
        {
            field_75395_b = (EntityVillager)field_75397_a.field_70170_p.func_72857_a(net.minecraft.src.EntityVillager.class, field_75397_a.field_70121_D.func_72314_b(6D, 2D, 6D), field_75397_a);
            return field_75395_b != null;
        }
    }

    public boolean func_75253_b()
    {
        return field_75396_c > 0;
    }

    public void func_75249_e()
    {
        field_75396_c = 400;
        field_75397_a.func_70851_e(true);
    }

    public void func_75251_c()
    {
        field_75397_a.func_70851_e(false);
        field_75395_b = null;
    }

    public void func_75246_d()
    {
        field_75397_a.func_70671_ap().func_75651_a(field_75395_b, 30F, 30F);
        field_75396_c--;
    }
}
