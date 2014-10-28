// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, Block, World, BlockTallGrass, 
//            BlockDeadBush, ItemStack, EntityPlayer, Material, 
//            StepSound

public class ItemBlock extends Item
{

    private int field_77885_a;

    public ItemBlock(int p_i3690_1_)
    {
        super(p_i3690_1_);
        field_77885_a = p_i3690_1_ + 256;
        func_77665_c(Block.field_71973_m[p_i3690_1_ + 256].func_71851_a(2));
    }

    public int func_77883_f()
    {
        return field_77885_a;
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
        if(p_77648_1_.field_77994_a == 0)
        {
            return false;
        }
        if(!p_77648_2_.func_71031_e(p_77648_4_, p_77648_5_, p_77648_6_))
        {
            return false;
        }
        if(p_77648_5_ == 255 && Block.field_71973_m[field_77885_a].field_72018_cp.func_76220_a())
        {
            return false;
        }
        if(p_77648_3_.func_72931_a(field_77885_a, p_77648_4_, p_77648_5_, p_77648_6_, false, p_77648_7_, p_77648_2_))
        {
            Block block = Block.field_71973_m[field_77885_a];
            if(p_77648_3_.func_72832_d(p_77648_4_, p_77648_5_, p_77648_6_, field_77885_a, func_77647_b(p_77648_1_.func_77960_j())))
            {
                if(p_77648_3_.func_72798_a(p_77648_4_, p_77648_5_, p_77648_6_) == field_77885_a)
                {
                    Block.field_71973_m[field_77885_a].func_71909_a(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_8_, p_77648_9_, p_77648_10_);
                    Block.field_71973_m[field_77885_a].func_71860_a(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_2_);
                }
                p_77648_3_.func_72908_a((float)p_77648_4_ + 0.5F, (float)p_77648_5_ + 0.5F, (float)p_77648_6_ + 0.5F, block.field_72020_cn.func_72675_d(), (block.field_72020_cn.func_72677_b() + 1.0F) / 2.0F, block.field_72020_cn.func_72678_c() * 0.8F);
                p_77648_1_.field_77994_a--;
            }
            return true;
        } else
        {
            return false;
        }
    }

    public String func_77667_c(ItemStack p_77667_1_)
    {
        return Block.field_71973_m[field_77885_a].func_71917_a();
    }

    public String func_77658_a()
    {
        return Block.field_71973_m[field_77885_a].func_71917_a();
    }
}
