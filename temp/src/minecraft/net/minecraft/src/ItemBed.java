// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, CreativeTabs, Block, BlockBed, 
//            EntityPlayer, MathHelper, World, ItemStack

public class ItemBed extends Item
{

    public ItemBed(int p_i3620_1_)
    {
        super(p_i3620_1_);
        func_77637_a(CreativeTabs.field_78031_c);
    }

    public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, 
            float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if(p_77648_7_ != 1)
        {
            return false;
        }
        p_77648_5_++;
        BlockBed blockbed = (BlockBed)Block.field_71959_S;
        int i = MathHelper.func_76128_c((double)((p_77648_2_.field_70177_z * 4F) / 360F) + 0.5D) & 3;
        byte byte0 = 0;
        byte byte1 = 0;
        if(i == 0)
        {
            byte1 = 1;
        }
        if(i == 1)
        {
            byte0 = -1;
        }
        if(i == 2)
        {
            byte1 = -1;
        }
        if(i == 3)
        {
            byte0 = 1;
        }
        if(!p_77648_2_.func_71031_e(p_77648_4_, p_77648_5_, p_77648_6_) || !p_77648_2_.func_71031_e(p_77648_4_ + byte0, p_77648_5_, p_77648_6_ + byte1))
        {
            return false;
        }
        if(p_77648_3_.func_72799_c(p_77648_4_, p_77648_5_, p_77648_6_) && p_77648_3_.func_72799_c(p_77648_4_ + byte0, p_77648_5_, p_77648_6_ + byte1) && p_77648_3_.func_72797_t(p_77648_4_, p_77648_5_ - 1, p_77648_6_) && p_77648_3_.func_72797_t(p_77648_4_ + byte0, p_77648_5_ - 1, p_77648_6_ + byte1))
        {
            p_77648_3_.func_72832_d(p_77648_4_, p_77648_5_, p_77648_6_, blockbed.field_71990_ca, i);
            if(p_77648_3_.func_72798_a(p_77648_4_, p_77648_5_, p_77648_6_) == blockbed.field_71990_ca)
            {
                p_77648_3_.func_72832_d(p_77648_4_ + byte0, p_77648_5_, p_77648_6_ + byte1, blockbed.field_71990_ca, i + 8);
            }
            p_77648_1_.field_77994_a--;
            return true;
        } else
        {
            return false;
        }
    }
}
