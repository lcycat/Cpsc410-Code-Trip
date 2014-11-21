// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityAIBase, EntityWolf, World, EntityPlayer, 
//            EntityLookHelper, InventoryPlayer, ItemStack, Item

public class EntityAIBeg extends EntityAIBase
{

    private EntityWolf field_75387_a;
    private EntityPlayer field_75385_b;
    private World field_75386_c;
    private float field_75383_d;
    private int field_75384_e;

    public EntityAIBeg(EntityWolf p_i3459_1_, float p_i3459_2_)
    {
        field_75387_a = p_i3459_1_;
        field_75386_c = p_i3459_1_.field_70170_p;
        field_75383_d = p_i3459_2_;
        func_75248_a(2);
    }

    public boolean func_75250_a()
    {
        field_75385_b = field_75386_c.func_72890_a(field_75387_a, field_75383_d);
        if(field_75385_b == null)
        {
            return false;
        } else
        {
            return func_75382_a(field_75385_b);
        }
    }

    public boolean func_75253_b()
    {
        if(!field_75385_b.func_70089_S())
        {
            return false;
        }
        if(field_75387_a.func_70068_e(field_75385_b) > (double)(field_75383_d * field_75383_d))
        {
            return false;
        } else
        {
            return field_75384_e > 0 && func_75382_a(field_75385_b);
        }
    }

    public void func_75249_e()
    {
        field_75387_a.func_70918_i(true);
        field_75384_e = 40 + field_75387_a.func_70681_au().nextInt(40);
    }

    public void func_75251_c()
    {
        field_75387_a.func_70918_i(false);
        field_75385_b = null;
    }

    public void func_75246_d()
    {
        field_75387_a.func_70671_ap().func_75650_a(field_75385_b.field_70165_t, field_75385_b.field_70163_u + (double)field_75385_b.func_70047_e(), field_75385_b.field_70161_v, 10F, field_75387_a.func_70646_bf());
        field_75384_e--;
    }

    private boolean func_75382_a(EntityPlayer p_75382_1_)
    {
        ItemStack itemstack = p_75382_1_.field_71071_by.func_70448_g();
        if(itemstack == null)
        {
            return false;
        }
        if(!field_75387_a.func_70909_n() && itemstack.field_77993_c == Item.field_77755_aX.field_77779_bT)
        {
            return true;
        } else
        {
            return field_75387_a.func_70877_b(itemstack);
        }
    }
}
