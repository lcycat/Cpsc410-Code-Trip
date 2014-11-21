// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, CreativeTabs, EntityPlayer, PlayerCapabilities, 
//            ItemStack, World, EnumAction

public class ItemBucketMilk extends Item
{

    public ItemBucketMilk(int p_i3669_1_)
    {
        super(p_i3669_1_);
        func_77625_d(1);
        func_77637_a(CreativeTabs.field_78026_f);
    }

    public ItemStack func_77654_b(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_)
    {
        if(!p_77654_3_.field_71075_bZ.field_75098_d)
        {
            p_77654_1_.field_77994_a--;
        }
        if(!p_77654_2_.field_72995_K)
        {
            p_77654_3_.func_70674_bp();
        }
        if(p_77654_1_.field_77994_a <= 0)
        {
            return new ItemStack(Item.field_77788_aw);
        } else
        {
            return p_77654_1_;
        }
    }

    public int func_77626_a(ItemStack p_77626_1_)
    {
        return 32;
    }

    public EnumAction func_77661_b(ItemStack p_77661_1_)
    {
        return EnumAction.drink;
    }

    public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
        p_77659_3_.func_71008_a(p_77659_1_, func_77626_a(p_77659_1_));
        return p_77659_1_;
    }
}
