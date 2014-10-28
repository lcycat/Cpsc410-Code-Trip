// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, CreativeTabs, EntityPlayer, World, 
//            ItemStack

public class ItemSeeds extends Item
{

    private int field_77839_a;
    private int field_77838_b;

    public ItemSeeds(int p_i3682_1_, int p_i3682_2_, int p_i3682_3_)
    {
        super(p_i3682_1_);
        field_77839_a = p_i3682_2_;
        field_77838_b = p_i3682_3_;
        func_77637_a(CreativeTabs.field_78035_l);
    }

    public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, 
            float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if(p_77648_7_ != 1)
        {
            return false;
        }
        if(!p_77648_2_.func_71031_e(p_77648_4_, p_77648_5_, p_77648_6_) || !p_77648_2_.func_71031_e(p_77648_4_, p_77648_5_ + 1, p_77648_6_))
        {
            return false;
        }
        int i = p_77648_3_.func_72798_a(p_77648_4_, p_77648_5_, p_77648_6_);
        if(i == field_77838_b && p_77648_3_.func_72799_c(p_77648_4_, p_77648_5_ + 1, p_77648_6_))
        {
            p_77648_3_.func_72859_e(p_77648_4_, p_77648_5_ + 1, p_77648_6_, field_77839_a);
            p_77648_1_.field_77994_a--;
            return true;
        } else
        {
            return false;
        }
    }
}
