// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityMob, DataWatcher, World, Entity, 
//            MathHelper, Item, EnumCreatureAttribute, PotionEffect, 
//            Potion

public class EntitySpider extends EntityMob
{

    public EntitySpider(World p_i3557_1_)
    {
        super(p_i3557_1_);
        field_70750_az = "/mob/spider.png";
        func_70105_a(1.4F, 0.9F);
        field_70697_bw = 0.8F;
    }

    protected void func_70088_a()
    {
        super.func_70088_a();
        field_70180_af.func_75682_a(16, new Byte((byte)0));
    }

    public void func_70071_h_()
    {
        super.func_70071_h_();
        if(!field_70170_p.field_72995_K)
        {
            func_70839_e(field_70123_F);
        }
    }

    public int func_70667_aM()
    {
        return 16;
    }

    public double func_70042_X()
    {
        return (double)field_70131_O * 0.75D - 0.5D;
    }

    protected boolean func_70041_e_()
    {
        return false;
    }

    protected Entity func_70782_k()
    {
        float f = func_70013_c(1.0F);
        if(f < 0.5F)
        {
            double d = 16D;
            return field_70170_p.func_72856_b(this, d);
        } else
        {
            return null;
        }
    }

    protected String func_70639_aQ()
    {
        return "mob.spider";
    }

    protected String func_70621_aR()
    {
        return "mob.spider";
    }

    protected String func_70673_aS()
    {
        return "mob.spiderdeath";
    }

    protected void func_70785_a(Entity p_70785_1_, float p_70785_2_)
    {
        float f = func_70013_c(1.0F);
        if(f > 0.5F && field_70146_Z.nextInt(100) == 0)
        {
            field_70789_a = null;
            return;
        }
        if(p_70785_2_ > 2.0F && p_70785_2_ < 6F && field_70146_Z.nextInt(10) == 0)
        {
            if(field_70122_E)
            {
                double d = p_70785_1_.field_70165_t - field_70165_t;
                double d1 = p_70785_1_.field_70161_v - field_70161_v;
                float f1 = MathHelper.func_76133_a(d * d + d1 * d1);
                field_70159_w = (d / (double)f1) * 0.5D * 0.80000001192092896D + field_70159_w * 0.20000000298023224D;
                field_70179_y = (d1 / (double)f1) * 0.5D * 0.80000001192092896D + field_70179_y * 0.20000000298023224D;
                field_70181_x = 0.40000000596046448D;
            }
        } else
        {
            super.func_70785_a(p_70785_1_, p_70785_2_);
        }
    }

    protected int func_70633_aT()
    {
        return Item.field_77683_K.field_77779_bT;
    }

    protected void func_70628_a(boolean p_70628_1_, int p_70628_2_)
    {
        super.func_70628_a(p_70628_1_, p_70628_2_);
        if(p_70628_1_ && (field_70146_Z.nextInt(3) == 0 || field_70146_Z.nextInt(1 + p_70628_2_) > 0))
        {
            func_70025_b(Item.field_77728_bu.field_77779_bT, 1);
        }
    }

    public boolean func_70617_f_()
    {
        return func_70841_p();
    }

    public void func_70110_aj()
    {
    }

    public float func_70840_n()
    {
        return 1.0F;
    }

    public EnumCreatureAttribute func_70668_bt()
    {
        return EnumCreatureAttribute.ARTHROPOD;
    }

    public boolean func_70687_e(PotionEffect p_70687_1_)
    {
        if(p_70687_1_.func_76456_a() == Potion.field_76436_u.field_76415_H)
        {
            return false;
        } else
        {
            return super.func_70687_e(p_70687_1_);
        }
    }

    public boolean func_70841_p()
    {
        return (field_70180_af.func_75683_a(16) & 1) != 0;
    }

    public void func_70839_e(boolean p_70839_1_)
    {
        byte byte0 = field_70180_af.func_75683_a(16);
        if(p_70839_1_)
        {
            byte0 |= 1;
        } else
        {
            byte0 &= 0xfe;
        }
        field_70180_af.func_75692_b(16, Byte.valueOf(byte0));
    }
}
