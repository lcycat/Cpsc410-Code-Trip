// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, CreativeTabs, EntityPlayer, EntityPainting, 
//            World, ItemStack

public class ItemPainting extends Item
{

    public ItemPainting(int p_i3672_1_)
    {
        super(p_i3672_1_);
        func_77637_a(CreativeTabs.field_78031_c);
    }

    public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, 
            float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if(p_77648_7_ == 0)
        {
            return false;
        }
        if(p_77648_7_ == 1)
        {
            return false;
        }
        byte byte0 = 0;
        if(p_77648_7_ == 4)
        {
            byte0 = 1;
        }
        if(p_77648_7_ == 3)
        {
            byte0 = 2;
        }
        if(p_77648_7_ == 5)
        {
            byte0 = 3;
        }
        if(!p_77648_2_.func_71031_e(p_77648_4_, p_77648_5_, p_77648_6_))
        {
            return false;
        }
        EntityPainting entitypainting = new EntityPainting(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, byte0);
        if(entitypainting.func_70518_d())
        {
            if(!p_77648_3_.field_72995_K)
            {
                p_77648_3_.func_72838_d(entitypainting);
            }
            p_77648_1_.field_77994_a--;
        }
        return true;
    }
}
