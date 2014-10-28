// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemFood, EntityPlayer, World, DamageSource, 
//            NBTTagCompound

public class FoodStats
{

    private int field_75127_a;
    private float field_75125_b;
    private float field_75126_c;
    private int field_75123_d;
    private int field_75124_e;

    public FoodStats()
    {
        field_75123_d = 0;
        field_75127_a = 20;
        field_75124_e = 20;
        field_75125_b = 5F;
    }

    public void func_75122_a(int p_75122_1_, float p_75122_2_)
    {
        field_75127_a = Math.min(p_75122_1_ + field_75127_a, 20);
        field_75125_b = Math.min(field_75125_b + (float)p_75122_1_ * p_75122_2_ * 2.0F, field_75127_a);
    }

    public void func_75111_a(ItemFood p_75111_1_)
    {
        func_75122_a(p_75111_1_.func_77847_f(), p_75111_1_.func_77846_g());
    }

    public void func_75118_a(EntityPlayer p_75118_1_)
    {
        int i = p_75118_1_.field_70170_p.field_73013_u;
        field_75124_e = field_75127_a;
        if(field_75126_c > 4F)
        {
            field_75126_c -= 4F;
            if(field_75125_b > 0.0F)
            {
                field_75125_b = Math.max(field_75125_b - 1.0F, 0.0F);
            } else
            if(i > 0)
            {
                field_75127_a = Math.max(field_75127_a - 1, 0);
            }
        }
        if(field_75127_a >= 18 && p_75118_1_.func_70996_bM())
        {
            field_75123_d++;
            if(field_75123_d >= 80)
            {
                p_75118_1_.func_70691_i(1);
                field_75123_d = 0;
            }
        } else
        if(field_75127_a <= 0)
        {
            field_75123_d++;
            if(field_75123_d >= 80)
            {
                if(p_75118_1_.func_70630_aN() > 10 || i >= 3 || p_75118_1_.func_70630_aN() > 1 && i >= 2)
                {
                    p_75118_1_.func_70097_a(DamageSource.field_76366_f, 1);
                }
                field_75123_d = 0;
            }
        } else
        {
            field_75123_d = 0;
        }
    }

    public void func_75112_a(NBTTagCompound p_75112_1_)
    {
        if(p_75112_1_.func_74764_b("foodLevel"))
        {
            field_75127_a = p_75112_1_.func_74762_e("foodLevel");
            field_75123_d = p_75112_1_.func_74762_e("foodTickTimer");
            field_75125_b = p_75112_1_.func_74760_g("foodSaturationLevel");
            field_75126_c = p_75112_1_.func_74760_g("foodExhaustionLevel");
        }
    }

    public void func_75117_b(NBTTagCompound p_75117_1_)
    {
        p_75117_1_.func_74768_a("foodLevel", field_75127_a);
        p_75117_1_.func_74768_a("foodTickTimer", field_75123_d);
        p_75117_1_.func_74776_a("foodSaturationLevel", field_75125_b);
        p_75117_1_.func_74776_a("foodExhaustionLevel", field_75126_c);
    }

    public int func_75116_a()
    {
        return field_75127_a;
    }

    public boolean func_75121_c()
    {
        return field_75127_a < 20;
    }

    public void func_75113_a(float p_75113_1_)
    {
        field_75126_c = Math.min(field_75126_c + p_75113_1_, 40F);
    }

    public float func_75115_e()
    {
        return field_75125_b;
    }
}
