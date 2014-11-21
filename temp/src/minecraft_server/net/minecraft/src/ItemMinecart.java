// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, CreativeTabs, World, BlockRail, 
//            EntityMinecart, ItemStack, EntityPlayer

public class ItemMinecart extends Item
{

    public int field_77841_a;

    public ItemMinecart(int p_i3670_1_, int p_i3670_2_)
    {
        super(p_i3670_1_);
        field_77777_bU = 1;
        field_77841_a = p_i3670_2_;
        func_77637_a(CreativeTabs.field_78029_e);
    }

    public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, 
            float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        int i = p_77648_3_.func_72798_a(p_77648_4_, p_77648_5_, p_77648_6_);
        if(BlockRail.func_72184_d(i))
        {
            if(!p_77648_3_.field_72995_K)
            {
                p_77648_3_.func_72838_d(new EntityMinecart(p_77648_3_, (float)p_77648_4_ + 0.5F, (float)p_77648_5_ + 0.5F, (float)p_77648_6_ + 0.5F, field_77841_a));
            }
            p_77648_1_.field_77994_a--;
            return true;
        } else
        {
            return false;
        }
    }
}
