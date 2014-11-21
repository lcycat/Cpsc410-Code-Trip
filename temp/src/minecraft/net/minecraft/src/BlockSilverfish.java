// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, CreativeTabs, World, 
//            EntitySilverfish, ItemStack

public class BlockSilverfish extends Block
{

    public static final String field_72155_a[] = {
        "stone", "cobble", "brick"
    };

    public BlockSilverfish(int p_i3999_1_)
    {
        super(p_i3999_1_, 1, Material.field_76267_y);
        func_71848_c(0.0F);
        func_71849_a(CreativeTabs.field_78031_c);
    }

    public int func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        if(p_71858_2_ == 1)
        {
            return Block.field_71978_w.field_72059_bZ;
        }
        if(p_71858_2_ == 2)
        {
            return Block.field_72007_bm.field_72059_bZ;
        } else
        {
            return Block.field_71981_t.field_72059_bZ;
        }
    }

    public void func_71898_d(World p_71898_1_, int p_71898_2_, int p_71898_3_, int p_71898_4_, int p_71898_5_)
    {
        if(!p_71898_1_.field_72995_K)
        {
            EntitySilverfish entitysilverfish = new EntitySilverfish(p_71898_1_);
            entitysilverfish.func_70012_b((double)p_71898_2_ + 0.5D, p_71898_3_, (double)p_71898_4_ + 0.5D, 0.0F, 0.0F);
            p_71898_1_.func_72838_d(entitysilverfish);
            entitysilverfish.func_70656_aK();
        }
        super.func_71898_d(p_71898_1_, p_71898_2_, p_71898_3_, p_71898_4_, p_71898_5_);
    }

    public int func_71925_a(Random p_71925_1_)
    {
        return 0;
    }

    public static boolean func_72154_e(int p_72154_0_)
    {
        return p_72154_0_ == Block.field_71981_t.field_71990_ca || p_72154_0_ == Block.field_71978_w.field_71990_ca || p_72154_0_ == Block.field_72007_bm.field_71990_ca;
    }

    public static int func_72153_f(int p_72153_0_)
    {
        if(p_72153_0_ == Block.field_71978_w.field_71990_ca)
        {
            return 1;
        }
        return p_72153_0_ != Block.field_72007_bm.field_71990_ca ? 0 : 2;
    }

    protected ItemStack func_71880_c_(int p_71880_1_)
    {
        Block block = Block.field_71981_t;
        if(p_71880_1_ == 1)
        {
            block = Block.field_71978_w;
        }
        if(p_71880_1_ == 2)
        {
            block = Block.field_72007_bm;
        }
        return new ItemStack(block);
    }

    public int func_71873_h(World p_71873_1_, int p_71873_2_, int p_71873_3_, int p_71873_4_)
    {
        return p_71873_1_.func_72805_g(p_71873_2_, p_71873_3_, p_71873_4_);
    }

    public void func_71879_a(int p_71879_1_, CreativeTabs p_71879_2_, List p_71879_3_)
    {
        for(int i = 0; i < 3; i++)
        {
            p_71879_3_.add(new ItemStack(p_71879_1_, 1, i));
        }

    }

}
