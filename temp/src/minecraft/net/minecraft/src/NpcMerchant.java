// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            IMerchant, InventoryMerchant, EntityPlayer, MerchantRecipeList, 
//            MerchantRecipe

public class NpcMerchant
    implements IMerchant
{

    private InventoryMerchant field_70937_a;
    private EntityPlayer field_70935_b;
    private MerchantRecipeList field_70936_c;

    public NpcMerchant(EntityPlayer p_i3559_1_)
    {
        field_70935_b = p_i3559_1_;
        field_70937_a = new InventoryMerchant(p_i3559_1_, this);
    }

    public EntityPlayer func_70931_l_()
    {
        return field_70935_b;
    }

    public void func_70932_a_(EntityPlayer entityplayer)
    {
    }

    public MerchantRecipeList func_70934_b(EntityPlayer p_70934_1_)
    {
        return field_70936_c;
    }

    public void func_70930_a(MerchantRecipeList p_70930_1_)
    {
        field_70936_c = p_70930_1_;
    }

    public void func_70933_a(MerchantRecipe merchantrecipe)
    {
    }
}
