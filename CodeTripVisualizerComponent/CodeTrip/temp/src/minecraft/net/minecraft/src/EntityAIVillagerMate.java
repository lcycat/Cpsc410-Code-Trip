// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityAIBase, EntityVillager, World, MathHelper, 
//            VillageCollection, AxisAlignedBB, EntityLookHelper, PathNavigate, 
//            Village

public class EntityAIVillagerMate extends EntityAIBase
{

    private EntityVillager field_75450_b;
    private EntityVillager field_75451_c;
    private World field_75448_d;
    private int field_75449_e;
    Village field_75452_a;

    public EntityAIVillagerMate(EntityVillager p_i3475_1_)
    {
        field_75449_e = 0;
        field_75450_b = p_i3475_1_;
        field_75448_d = p_i3475_1_.field_70170_p;
        func_75248_a(3);
    }

    public boolean func_75250_a()
    {
        if(field_75450_b.func_70874_b() != 0)
        {
            return false;
        }
        if(field_75450_b.func_70681_au().nextInt(500) != 0)
        {
            return false;
        }
        field_75452_a = field_75448_d.field_72982_D.func_75550_a(MathHelper.func_76128_c(field_75450_b.field_70165_t), MathHelper.func_76128_c(field_75450_b.field_70163_u), MathHelper.func_76128_c(field_75450_b.field_70161_v), 0);
        if(field_75452_a == null)
        {
            return false;
        }
        if(!func_75446_f())
        {
            return false;
        }
        Entity entity = field_75448_d.func_72857_a(net.minecraft.src.EntityVillager.class, field_75450_b.field_70121_D.func_72314_b(8D, 3D, 8D), field_75450_b);
        if(entity == null)
        {
            return false;
        }
        field_75451_c = (EntityVillager)entity;
        return field_75451_c.func_70874_b() == 0;
    }

    public void func_75249_e()
    {
        field_75449_e = 300;
        field_75450_b.func_70947_e(true);
    }

    public void func_75251_c()
    {
        field_75452_a = null;
        field_75451_c = null;
        field_75450_b.func_70947_e(false);
    }

    public boolean func_75253_b()
    {
        return field_75449_e >= 0 && func_75446_f() && field_75450_b.func_70874_b() == 0;
    }

    public void func_75246_d()
    {
        field_75449_e--;
        field_75450_b.func_70671_ap().func_75651_a(field_75451_c, 10F, 30F);
        if(field_75450_b.func_70068_e(field_75451_c) > 2.25D)
        {
            field_75450_b.func_70661_as().func_75497_a(field_75451_c, 0.25F);
        } else
        if(field_75449_e == 0 && field_75451_c.func_70941_o())
        {
            func_75447_i();
        }
        if(field_75450_b.func_70681_au().nextInt(35) == 0)
        {
            field_75448_d.func_72960_a(field_75450_b, (byte)12);
        }
    }

    private boolean func_75446_f()
    {
        int i = (int)((double)(float)field_75452_a.func_75567_c() * 0.34999999999999998D);
        return field_75452_a.func_75562_e() < i;
    }

    private void func_75447_i()
    {
        EntityVillager entityvillager = new EntityVillager(field_75448_d);
        field_75451_c.func_70873_a(6000);
        field_75450_b.func_70873_a(6000);
        entityvillager.func_70873_a(-24000);
        entityvillager.func_70938_b(field_75450_b.func_70681_au().nextInt(5));
        entityvillager.func_70012_b(field_75450_b.field_70165_t, field_75450_b.field_70163_u, field_75450_b.field_70161_v, 0.0F, 0.0F);
        field_75448_d.func_72838_d(entityvillager);
        field_75448_d.func_72960_a(entityvillager, (byte)12);
    }
}
