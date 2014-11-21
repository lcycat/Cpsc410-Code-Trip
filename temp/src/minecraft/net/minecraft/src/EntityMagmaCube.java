// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntitySlime, World, Item

public class EntityMagmaCube extends EntitySlime
{

    public EntityMagmaCube(World p_i3551_1_)
    {
        super(p_i3551_1_);
        field_70750_az = "/mob/lava.png";
        field_70178_ae = true;
        field_70746_aG = 0.2F;
    }

    public boolean func_70601_bi()
    {
        return field_70170_p.field_73013_u > 0 && field_70170_p.func_72855_b(field_70121_D) && field_70170_p.func_72945_a(this, field_70121_D).isEmpty() && !field_70170_p.func_72953_d(field_70121_D);
    }

    public int func_70658_aO()
    {
        return func_70809_q() * 3;
    }

    public int func_70070_b(float p_70070_1_)
    {
        return 0xf000f0;
    }

    public float func_70013_c(float p_70013_1_)
    {
        return 1.0F;
    }

    protected String func_70801_i()
    {
        return "flame";
    }

    protected EntitySlime func_70802_j()
    {
        return new EntityMagmaCube(field_70170_p);
    }

    protected int func_70633_aT()
    {
        return Item.field_77725_bx.field_77779_bT;
    }

    protected void func_70628_a(boolean p_70628_1_, int p_70628_2_)
    {
        int i = func_70633_aT();
        if(i > 0 && func_70809_q() > 1)
        {
            int j = field_70146_Z.nextInt(4) - 2;
            if(p_70628_2_ > 0)
            {
                j += field_70146_Z.nextInt(p_70628_2_ + 1);
            }
            for(int k = 0; k < j; k++)
            {
                func_70025_b(i, 1);
            }

        }
    }

    public boolean func_70027_ad()
    {
        return false;
    }

    protected int func_70806_k()
    {
        return super.func_70806_k() * 4;
    }

    protected void func_70808_l()
    {
        field_70813_a *= 0.9F;
    }

    protected void func_70664_aZ()
    {
        field_70181_x = 0.42F + (float)func_70809_q() * 0.1F;
        field_70160_al = true;
    }

    protected void func_70069_a(float f)
    {
    }

    protected boolean func_70800_m()
    {
        return true;
    }

    protected int func_70805_n()
    {
        return super.func_70805_n() + 2;
    }

    protected String func_70621_aR()
    {
        return "mob.slime";
    }

    protected String func_70673_aS()
    {
        return "mob.slime";
    }

    protected String func_70803_o()
    {
        if(func_70809_q() > 1)
        {
            return "mob.magmacube.big";
        } else
        {
            return "mob.magmacube.small";
        }
    }

    public boolean func_70058_J()
    {
        return false;
    }

    protected boolean func_70804_p()
    {
        return true;
    }
}
