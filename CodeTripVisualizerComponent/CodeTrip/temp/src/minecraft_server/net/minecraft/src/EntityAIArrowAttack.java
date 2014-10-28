// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityAIBase, EntityLiving, PathNavigate, AxisAlignedBB, 
//            EntitySenses, EntityLookHelper, EntityArrow, World, 
//            EntitySnowball, MathHelper

public class EntityAIArrowAttack extends EntityAIBase
{

    World field_75324_a;
    EntityLiving field_75322_b;
    EntityLiving field_75323_c;
    int field_75320_d;
    float field_75321_e;
    int field_75318_f;
    int field_75319_g;
    int field_75325_h;

    public EntityAIArrowAttack(EntityLiving p_i3457_1_, float p_i3457_2_, int p_i3457_3_, int p_i3457_4_)
    {
        field_75320_d = 0;
        field_75318_f = 0;
        field_75322_b = p_i3457_1_;
        field_75324_a = p_i3457_1_.field_70170_p;
        field_75321_e = p_i3457_2_;
        field_75319_g = p_i3457_3_;
        field_75325_h = p_i3457_4_;
        func_75248_a(3);
    }

    public boolean func_75250_a()
    {
        EntityLiving entityliving = field_75322_b.func_70638_az();
        if(entityliving == null)
        {
            return false;
        } else
        {
            field_75323_c = entityliving;
            return true;
        }
    }

    public boolean func_75253_b()
    {
        return func_75250_a() || !field_75322_b.func_70661_as().func_75500_f();
    }

    public void func_75251_c()
    {
        field_75323_c = null;
    }

    public void func_75246_d()
    {
        double d = 100D;
        double d1 = field_75322_b.func_70092_e(field_75323_c.field_70165_t, field_75323_c.field_70121_D.field_72338_b, field_75323_c.field_70161_v);
        boolean flag = field_75322_b.func_70635_at().func_75522_a(field_75323_c);
        if(flag)
        {
            field_75318_f++;
        } else
        {
            field_75318_f = 0;
        }
        if(d1 > d || field_75318_f < 20)
        {
            field_75322_b.func_70661_as().func_75497_a(field_75323_c, field_75321_e);
        } else
        {
            field_75322_b.func_70661_as().func_75499_g();
        }
        field_75322_b.func_70671_ap().func_75651_a(field_75323_c, 30F, 30F);
        field_75320_d = Math.max(field_75320_d - 1, 0);
        if(field_75320_d > 0)
        {
            return;
        }
        if(d1 > d || !flag)
        {
            return;
        } else
        {
            func_75317_f();
            field_75320_d = field_75325_h;
            return;
        }
    }

    private void func_75317_f()
    {
        if(field_75319_g == 1)
        {
            EntityArrow entityarrow = new EntityArrow(field_75324_a, field_75322_b, field_75323_c, 1.6F, 12F);
            field_75324_a.func_72956_a(field_75322_b, "random.bow", 1.0F, 1.0F / (field_75322_b.func_70681_au().nextFloat() * 0.4F + 0.8F));
            field_75324_a.func_72838_d(entityarrow);
        } else
        if(field_75319_g == 2)
        {
            EntitySnowball entitysnowball = new EntitySnowball(field_75324_a, field_75322_b);
            double d = field_75323_c.field_70165_t - field_75322_b.field_70165_t;
            double d1 = (field_75323_c.field_70163_u + (double)field_75323_c.func_70047_e()) - 1.1000000238418579D - entitysnowball.field_70163_u;
            double d2 = field_75323_c.field_70161_v - field_75322_b.field_70161_v;
            float f = MathHelper.func_76133_a(d * d + d2 * d2) * 0.2F;
            entitysnowball.func_70186_c(d, d1 + (double)f, d2, 1.6F, 12F);
            field_75324_a.func_72956_a(field_75322_b, "random.bow", 1.0F, 1.0F / (field_75322_b.func_70681_au().nextFloat() * 0.4F + 0.8F));
            field_75324_a.func_72838_d(entitysnowball);
        }
    }
}
