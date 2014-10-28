// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, CreativeTabs, World, 
//            EntityTNTPrimed, EntityPlayer, ItemStack, Item

public class BlockTNT extends Block
{

    public BlockTNT(int p_i4011_1_, int p_i4011_2_)
    {
        super(p_i4011_1_, p_i4011_2_, Material.field_76262_s);
        func_71849_a(CreativeTabs.field_78028_d);
    }

    public int func_71851_a(int p_71851_1_)
    {
        if(p_71851_1_ == 0)
        {
            return field_72059_bZ + 2;
        }
        if(p_71851_1_ == 1)
        {
            return field_72059_bZ + 1;
        } else
        {
            return field_72059_bZ;
        }
    }

    public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_)
    {
        super.func_71861_g(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
        if(p_71861_1_.func_72864_z(p_71861_2_, p_71861_3_, p_71861_4_))
        {
            func_71898_d(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_, 1);
            p_71861_1_.func_72859_e(p_71861_2_, p_71861_3_, p_71861_4_, 0);
        }
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        if(p_71863_5_ > 0 && Block.field_71973_m[p_71863_5_].func_71853_i() && p_71863_1_.func_72864_z(p_71863_2_, p_71863_3_, p_71863_4_))
        {
            func_71898_d(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, 1);
            p_71863_1_.func_72859_e(p_71863_2_, p_71863_3_, p_71863_4_, 0);
        }
    }

    public int func_71925_a(Random p_71925_1_)
    {
        return 1;
    }

    public void func_71867_k(World p_71867_1_, int p_71867_2_, int p_71867_3_, int p_71867_4_)
    {
        if(p_71867_1_.field_72995_K)
        {
            return;
        } else
        {
            EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(p_71867_1_, (float)p_71867_2_ + 0.5F, (float)p_71867_3_ + 0.5F, (float)p_71867_4_ + 0.5F);
            entitytntprimed.field_70516_a = p_71867_1_.field_73012_v.nextInt(entitytntprimed.field_70516_a / 4) + entitytntprimed.field_70516_a / 8;
            p_71867_1_.func_72838_d(entitytntprimed);
            return;
        }
    }

    public void func_71898_d(World p_71898_1_, int p_71898_2_, int p_71898_3_, int p_71898_4_, int p_71898_5_)
    {
        if(p_71898_1_.field_72995_K)
        {
            return;
        }
        if((p_71898_5_ & 1) == 1)
        {
            EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(p_71898_1_, (float)p_71898_2_ + 0.5F, (float)p_71898_3_ + 0.5F, (float)p_71898_4_ + 0.5F);
            p_71898_1_.func_72838_d(entitytntprimed);
            p_71898_1_.func_72956_a(entitytntprimed, "random.fuse", 1.0F, 1.0F);
        }
    }

    public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, 
            float p_71903_8_, float p_71903_9_)
    {
        if(p_71903_5_.func_71045_bC() != null && p_71903_5_.func_71045_bC().field_77993_c == Item.field_77709_i.field_77779_bT)
        {
            func_71898_d(p_71903_1_, p_71903_2_, p_71903_3_, p_71903_4_, 1);
            p_71903_1_.func_72859_e(p_71903_2_, p_71903_3_, p_71903_4_, 0);
            return true;
        } else
        {
            return super.func_71903_a(p_71903_1_, p_71903_2_, p_71903_3_, p_71903_4_, p_71903_5_, p_71903_6_, p_71903_7_, p_71903_8_, p_71903_9_);
        }
    }

    protected ItemStack func_71880_c_(int p_71880_1_)
    {
        return null;
    }
}
