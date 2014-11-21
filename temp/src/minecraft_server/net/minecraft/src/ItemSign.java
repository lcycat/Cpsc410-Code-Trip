// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, CreativeTabs, World, Material, 
//            EntityPlayer, Block, MathHelper, ItemStack, 
//            TileEntitySign

public class ItemSign extends Item
{

    public ItemSign(int p_i3685_1_)
    {
        super(p_i3685_1_);
        field_77777_bU = 16;
        func_77637_a(CreativeTabs.field_78031_c);
    }

    public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, 
            float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if(p_77648_7_ == 0)
        {
            return false;
        }
        if(!p_77648_3_.func_72803_f(p_77648_4_, p_77648_5_, p_77648_6_).func_76220_a())
        {
            return false;
        }
        if(p_77648_7_ == 1)
        {
            p_77648_5_++;
        }
        if(p_77648_7_ == 2)
        {
            p_77648_6_--;
        }
        if(p_77648_7_ == 3)
        {
            p_77648_6_++;
        }
        if(p_77648_7_ == 4)
        {
            p_77648_4_--;
        }
        if(p_77648_7_ == 5)
        {
            p_77648_4_++;
        }
        if(!p_77648_2_.func_71031_e(p_77648_4_, p_77648_5_, p_77648_6_))
        {
            return false;
        }
        if(!Block.field_72053_aD.func_71930_b(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_))
        {
            return false;
        }
        if(p_77648_7_ == 1)
        {
            int i = MathHelper.func_76128_c((double)(((p_77648_2_.field_70177_z + 180F) * 16F) / 360F) + 0.5D) & 0xf;
            p_77648_3_.func_72832_d(p_77648_4_, p_77648_5_, p_77648_6_, Block.field_72053_aD.field_71990_ca, i);
        } else
        {
            p_77648_3_.func_72832_d(p_77648_4_, p_77648_5_, p_77648_6_, Block.field_72042_aI.field_71990_ca, p_77648_7_);
        }
        p_77648_1_.field_77994_a--;
        TileEntitySign tileentitysign = (TileEntitySign)p_77648_3_.func_72796_p(p_77648_4_, p_77648_5_, p_77648_6_);
        if(tileentitysign != null)
        {
            p_77648_2_.func_71014_a(tileentitysign);
        }
        return true;
    }
}
