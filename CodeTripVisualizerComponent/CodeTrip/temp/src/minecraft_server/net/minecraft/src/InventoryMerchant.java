// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            IInventory, ItemStack, IMerchant, MerchantRecipeList, 
//            MerchantRecipe, EntityPlayer

public class InventoryMerchant
    implements IInventory
{

    private final IMerchant field_70476_a;
    private ItemStack field_70474_b[];
    private final EntityPlayer field_70475_c;
    private MerchantRecipe field_70472_d;
    private int field_70473_e;

    public InventoryMerchant(EntityPlayer p_i3612_1_, IMerchant p_i3612_2_)
    {
        field_70474_b = new ItemStack[3];
        field_70475_c = p_i3612_1_;
        field_70476_a = p_i3612_2_;
    }

    public int func_70302_i_()
    {
        return field_70474_b.length;
    }

    public ItemStack func_70301_a(int p_70301_1_)
    {
        return field_70474_b[p_70301_1_];
    }

    public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_)
    {
        if(field_70474_b[p_70298_1_] != null)
        {
            if(p_70298_1_ == 2)
            {
                ItemStack itemstack = field_70474_b[p_70298_1_];
                field_70474_b[p_70298_1_] = null;
                return itemstack;
            }
            if(field_70474_b[p_70298_1_].field_77994_a <= p_70298_2_)
            {
                ItemStack itemstack1 = field_70474_b[p_70298_1_];
                field_70474_b[p_70298_1_] = null;
                if(func_70469_d(p_70298_1_))
                {
                    func_70470_g();
                }
                return itemstack1;
            }
            ItemStack itemstack2 = field_70474_b[p_70298_1_].func_77979_a(p_70298_2_);
            if(field_70474_b[p_70298_1_].field_77994_a == 0)
            {
                field_70474_b[p_70298_1_] = null;
            }
            if(func_70469_d(p_70298_1_))
            {
                func_70470_g();
            }
            return itemstack2;
        } else
        {
            return null;
        }
    }

    private boolean func_70469_d(int p_70469_1_)
    {
        return p_70469_1_ == 0 || p_70469_1_ == 1;
    }

    public ItemStack func_70304_b(int p_70304_1_)
    {
        if(field_70474_b[p_70304_1_] != null)
        {
            ItemStack itemstack = field_70474_b[p_70304_1_];
            field_70474_b[p_70304_1_] = null;
            return itemstack;
        } else
        {
            return null;
        }
    }

    public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_)
    {
        field_70474_b[p_70299_1_] = p_70299_2_;
        if(p_70299_2_ != null && p_70299_2_.field_77994_a > func_70297_j_())
        {
            p_70299_2_.field_77994_a = func_70297_j_();
        }
        if(func_70469_d(p_70299_1_))
        {
            func_70470_g();
        }
    }

    public String func_70303_b()
    {
        return "mob.villager";
    }

    public int func_70297_j_()
    {
        return 64;
    }

    public boolean func_70300_a(EntityPlayer p_70300_1_)
    {
        return field_70476_a.func_70931_l_() == p_70300_1_;
    }

    public void func_70295_k_()
    {
    }

    public void func_70305_f()
    {
    }

    public void func_70296_d()
    {
        func_70470_g();
    }

    public void func_70470_g()
    {
        field_70472_d = null;
        ItemStack itemstack = field_70474_b[0];
        ItemStack itemstack1 = field_70474_b[1];
        if(itemstack == null)
        {
            itemstack = itemstack1;
            itemstack1 = null;
        }
        if(itemstack == null)
        {
            func_70299_a(2, null);
        } else
        {
            MerchantRecipeList merchantrecipelist = field_70476_a.func_70934_b(field_70475_c);
            if(merchantrecipelist != null)
            {
                MerchantRecipe merchantrecipe = merchantrecipelist.func_77203_a(itemstack, itemstack1, field_70473_e);
                if(merchantrecipe != null)
                {
                    field_70472_d = merchantrecipe;
                    func_70299_a(2, merchantrecipe.func_77397_d().func_77946_l());
                } else
                if(itemstack1 != null)
                {
                    MerchantRecipe merchantrecipe1 = merchantrecipelist.func_77203_a(itemstack1, itemstack, field_70473_e);
                    if(merchantrecipe1 != null)
                    {
                        field_70472_d = merchantrecipe1;
                        func_70299_a(2, merchantrecipe1.func_77397_d().func_77946_l());
                    } else
                    {
                        func_70299_a(2, null);
                    }
                } else
                {
                    func_70299_a(2, null);
                }
            }
        }
    }

    public MerchantRecipe func_70468_h()
    {
        return field_70472_d;
    }

    public void func_70471_c(int p_70471_1_)
    {
        field_70473_e = p_70471_1_;
        func_70470_g();
    }
}
