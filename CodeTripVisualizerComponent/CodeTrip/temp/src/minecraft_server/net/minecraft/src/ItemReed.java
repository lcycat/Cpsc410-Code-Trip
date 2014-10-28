// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, Block, World, BlockTallGrass, 
//            BlockDeadBush, EntityPlayer, ItemStack, StepSound

public class ItemReed extends Item
{

    private int field_77830_a;

    public ItemReed(int p_i3691_1_, Block p_i3691_2_)
    {
        super(p_i3691_1_);
        field_77830_a = p_i3691_2_.field_71990_ca;
    }

    public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, 
            float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        int i = p_77648_3_.func_72798_a(p_77648_4_, p_77648_5_, p_77648_6_);
        if(i == Block.field_72037_aS.field_71990_ca)
        {
            p_77648_7_ = 1;
        } else
        if(i != Block.field_71998_bu.field_71990_ca && i != Block.field_71962_X.field_71990_ca && i != Block.field_71961_Y.field_71990_ca)
        {
            if(p_77648_7_ == 0)
            {
                p_77648_5_--;
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
        }
        if(!p_77648_2_.func_71031_e(p_77648_4_, p_77648_5_, p_77648_6_))
        {
            return false;
        }
        if(p_77648_1_.field_77994_a == 0)
        {
            return false;
        }
        if(p_77648_3_.func_72931_a(field_77830_a, p_77648_4_, p_77648_5_, p_77648_6_, false, p_77648_7_, null))
        {
            Block block = Block.field_71973_m[field_77830_a];
            if(p_77648_3_.func_72859_e(p_77648_4_, p_77648_5_, p_77648_6_, field_77830_a))
            {
                if(p_77648_3_.func_72798_a(p_77648_4_, p_77648_5_, p_77648_6_) == field_77830_a)
                {
                    Block.field_71973_m[field_77830_a].func_71909_a(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_8_, p_77648_9_, p_77648_10_);
                    Block.field_71973_m[field_77830_a].func_71860_a(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_2_);
                }
                p_77648_3_.func_72908_a((float)p_77648_4_ + 0.5F, (float)p_77648_5_ + 0.5F, (float)p_77648_6_ + 0.5F, block.field_72020_cn.func_72675_d(), (block.field_72020_cn.func_72677_b() + 1.0F) / 2.0F, block.field_72020_cn.func_72678_c() * 0.8F);
                p_77648_1_.field_77994_a--;
            }
        }
        return true;
    }
}
