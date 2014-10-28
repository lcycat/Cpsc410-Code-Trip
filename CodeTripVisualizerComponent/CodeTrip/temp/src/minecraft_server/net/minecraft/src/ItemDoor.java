// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, CreativeTabs, Material, Block, 
//            EntityPlayer, MathHelper, ItemStack, World

public class ItemDoor extends Item
{

    private Material field_77870_a;

    public ItemDoor(int p_i3644_1_, Material p_i3644_2_)
    {
        super(p_i3644_1_);
        field_77870_a = p_i3644_2_;
        field_77777_bU = 1;
        func_77637_a(CreativeTabs.field_78028_d);
    }

    public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, 
            float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if(p_77648_7_ != 1)
        {
            return false;
        }
        p_77648_5_++;
        Block block;
        if(field_77870_a == Material.field_76245_d)
        {
            block = Block.field_72054_aE;
        } else
        {
            block = Block.field_72045_aL;
        }
        if(!p_77648_2_.func_71031_e(p_77648_4_, p_77648_5_, p_77648_6_) || !p_77648_2_.func_71031_e(p_77648_4_, p_77648_5_ + 1, p_77648_6_))
        {
            return false;
        }
        if(!block.func_71930_b(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_))
        {
            return false;
        } else
        {
            int i = MathHelper.func_76128_c((double)(((p_77648_2_.field_70177_z + 180F) * 4F) / 360F) - 0.5D) & 3;
            func_77869_a(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, i, block);
            p_77648_1_.field_77994_a--;
            return true;
        }
    }

    public static void func_77869_a(World p_77869_0_, int p_77869_1_, int p_77869_2_, int p_77869_3_, int p_77869_4_, Block p_77869_5_)
    {
        byte byte0 = 0;
        byte byte1 = 0;
        if(p_77869_4_ == 0)
        {
            byte1 = 1;
        }
        if(p_77869_4_ == 1)
        {
            byte0 = -1;
        }
        if(p_77869_4_ == 2)
        {
            byte1 = -1;
        }
        if(p_77869_4_ == 3)
        {
            byte0 = 1;
        }
        int i = (p_77869_0_.func_72809_s(p_77869_1_ - byte0, p_77869_2_, p_77869_3_ - byte1) ? 1 : 0) + (p_77869_0_.func_72809_s(p_77869_1_ - byte0, p_77869_2_ + 1, p_77869_3_ - byte1) ? 1 : 0);
        int j = (p_77869_0_.func_72809_s(p_77869_1_ + byte0, p_77869_2_, p_77869_3_ + byte1) ? 1 : 0) + (p_77869_0_.func_72809_s(p_77869_1_ + byte0, p_77869_2_ + 1, p_77869_3_ + byte1) ? 1 : 0);
        boolean flag = p_77869_0_.func_72798_a(p_77869_1_ - byte0, p_77869_2_, p_77869_3_ - byte1) == p_77869_5_.field_71990_ca || p_77869_0_.func_72798_a(p_77869_1_ - byte0, p_77869_2_ + 1, p_77869_3_ - byte1) == p_77869_5_.field_71990_ca;
        boolean flag1 = p_77869_0_.func_72798_a(p_77869_1_ + byte0, p_77869_2_, p_77869_3_ + byte1) == p_77869_5_.field_71990_ca || p_77869_0_.func_72798_a(p_77869_1_ + byte0, p_77869_2_ + 1, p_77869_3_ + byte1) == p_77869_5_.field_71990_ca;
        boolean flag2 = false;
        if(flag && !flag1)
        {
            flag2 = true;
        } else
        if(j > i)
        {
            flag2 = true;
        }
        p_77869_0_.field_73014_t = true;
        p_77869_0_.func_72832_d(p_77869_1_, p_77869_2_, p_77869_3_, p_77869_5_.field_71990_ca, p_77869_4_);
        p_77869_0_.func_72832_d(p_77869_1_, p_77869_2_ + 1, p_77869_3_, p_77869_5_.field_71990_ca, 8 | (flag2 ? 1 : 0));
        p_77869_0_.field_73014_t = false;
        p_77869_0_.func_72898_h(p_77869_1_, p_77869_2_, p_77869_3_, p_77869_5_.field_71990_ca);
        p_77869_0_.func_72898_h(p_77869_1_, p_77869_2_ + 1, p_77869_3_, p_77869_5_.field_71990_ca);
    }
}
