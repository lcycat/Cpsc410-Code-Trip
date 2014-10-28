// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityAIBase, EntityCreature, World, EntityPlayer, 
//            ItemStack, PathNavigate, EntityLookHelper

public class EntityAITempt extends EntityAIBase
{

    private EntityCreature field_75284_a;
    private float field_75282_b;
    private double field_75283_c;
    private double field_75280_d;
    private double field_75281_e;
    private double field_75278_f;
    private double field_75279_g;
    private EntityPlayer field_75289_h;
    private int field_75290_i;
    private boolean field_75287_j;
    private int field_75288_k;
    private boolean field_75285_l;
    private boolean field_75286_m;

    public EntityAITempt(EntityCreature p_i3495_1_, float p_i3495_2_, int p_i3495_3_, boolean p_i3495_4_)
    {
        field_75290_i = 0;
        field_75284_a = p_i3495_1_;
        field_75282_b = p_i3495_2_;
        field_75288_k = p_i3495_3_;
        field_75285_l = p_i3495_4_;
        func_75248_a(3);
    }

    public boolean func_75250_a()
    {
        if(field_75290_i > 0)
        {
            field_75290_i--;
            return false;
        }
        field_75289_h = field_75284_a.field_70170_p.func_72890_a(field_75284_a, 10D);
        if(field_75289_h == null)
        {
            return false;
        }
        ItemStack itemstack = field_75289_h.func_71045_bC();
        if(itemstack == null)
        {
            return false;
        }
        return itemstack.field_77993_c == field_75288_k;
    }

    public boolean func_75253_b()
    {
        if(field_75285_l)
        {
            if(field_75284_a.func_70068_e(field_75289_h) < 36D)
            {
                if(field_75289_h.func_70092_e(field_75283_c, field_75280_d, field_75281_e) > 0.010000000000000002D)
                {
                    return false;
                }
                if(Math.abs((double)field_75289_h.field_70125_A - field_75278_f) > 5D || Math.abs((double)field_75289_h.field_70177_z - field_75279_g) > 5D)
                {
                    return false;
                }
            } else
            {
                field_75283_c = field_75289_h.field_70165_t;
                field_75280_d = field_75289_h.field_70163_u;
                field_75281_e = field_75289_h.field_70161_v;
            }
            field_75278_f = field_75289_h.field_70125_A;
            field_75279_g = field_75289_h.field_70177_z;
        }
        return func_75250_a();
    }

    public void func_75249_e()
    {
        field_75283_c = field_75289_h.field_70165_t;
        field_75280_d = field_75289_h.field_70163_u;
        field_75281_e = field_75289_h.field_70161_v;
        field_75287_j = true;
        field_75286_m = field_75284_a.func_70661_as().func_75486_a();
        field_75284_a.func_70661_as().func_75491_a(false);
    }

    public void func_75251_c()
    {
        field_75289_h = null;
        field_75284_a.func_70661_as().func_75499_g();
        field_75290_i = 100;
        field_75287_j = false;
        field_75284_a.func_70661_as().func_75491_a(field_75286_m);
    }

    public void func_75246_d()
    {
        field_75284_a.func_70671_ap().func_75651_a(field_75289_h, 30F, field_75284_a.func_70646_bf());
        if(field_75284_a.func_70068_e(field_75289_h) < 6.25D)
        {
            field_75284_a.func_70661_as().func_75499_g();
        } else
        {
            field_75284_a.func_70661_as().func_75497_a(field_75289_h, field_75282_b);
        }
    }

    public boolean func_75277_f()
    {
        return field_75287_j;
    }
}
