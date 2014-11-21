// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Slot, ItemStack, EntityPlayer, InventoryMerchant, 
//            IMerchant, MerchantRecipe

public class SlotMerchantResult extends Slot
{

    private final InventoryMerchant field_75233_a;
    private EntityPlayer field_75232_b;
    private int field_75231_g;
    private final IMerchant field_75234_h;

    public SlotMerchantResult(EntityPlayer p_i3614_1_, IMerchant p_i3614_2_, InventoryMerchant p_i3614_3_, int p_i3614_4_, int p_i3614_5_, int p_i3614_6_)
    {
        super(p_i3614_3_, p_i3614_4_, p_i3614_5_, p_i3614_6_);
        field_75232_b = p_i3614_1_;
        field_75234_h = p_i3614_2_;
        field_75233_a = p_i3614_3_;
    }

    public boolean func_75214_a(ItemStack p_75214_1_)
    {
        return false;
    }

    public ItemStack func_75209_a(int p_75209_1_)
    {
        if(func_75216_d())
        {
            field_75231_g += Math.min(p_75209_1_, func_75211_c().field_77994_a);
        }
        return super.func_75209_a(p_75209_1_);
    }

    protected void func_75210_a(ItemStack p_75210_1_, int p_75210_2_)
    {
        field_75231_g += p_75210_2_;
        func_75208_c(p_75210_1_);
    }

    protected void func_75208_c(ItemStack p_75208_1_)
    {
        p_75208_1_.func_77980_a(field_75232_b.field_70170_p, field_75232_b, field_75231_g);
        field_75231_g = 0;
    }

    public void func_75213_b(ItemStack p_75213_1_)
    {
        func_75208_c(p_75213_1_);
        MerchantRecipe merchantrecipe = field_75233_a.func_70468_h();
        if(merchantrecipe != null)
        {
            ItemStack itemstack = field_75233_a.func_70301_a(0);
            ItemStack itemstack1 = field_75233_a.func_70301_a(1);
            if(func_75230_a(merchantrecipe, itemstack, itemstack1) || func_75230_a(merchantrecipe, itemstack1, itemstack))
            {
                if(itemstack != null && itemstack.field_77994_a <= 0)
                {
                    itemstack = null;
                }
                if(itemstack1 != null && itemstack1.field_77994_a <= 0)
                {
                    itemstack1 = null;
                }
                field_75233_a.func_70299_a(0, itemstack);
                field_75233_a.func_70299_a(1, itemstack1);
                field_75234_h.func_70933_a(merchantrecipe);
            }
        }
    }

    private boolean func_75230_a(MerchantRecipe p_75230_1_, ItemStack p_75230_2_, ItemStack p_75230_3_)
    {
        ItemStack itemstack = p_75230_1_.func_77394_a();
        ItemStack itemstack1 = p_75230_1_.func_77396_b();
        if(p_75230_2_ != null && p_75230_2_.field_77993_c == itemstack.field_77993_c)
        {
            if(itemstack1 != null && p_75230_3_ != null && itemstack1.field_77993_c == p_75230_3_.field_77993_c)
            {
                p_75230_2_.field_77994_a -= itemstack.field_77994_a;
                p_75230_3_.field_77994_a -= itemstack1.field_77994_a;
                return true;
            }
            if(itemstack1 == null && p_75230_3_ == null)
            {
                p_75230_2_.field_77994_a -= itemstack.field_77994_a;
                return true;
            }
        }
        return false;
    }
}
