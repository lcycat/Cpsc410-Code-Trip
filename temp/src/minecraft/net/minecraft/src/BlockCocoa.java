// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockDirectional, Material, World, Direction, 
//            Block, BlockLog, IBlockAccess, EntityLiving, 
//            MathHelper, ItemStack, Item, AxisAlignedBB

public class BlockCocoa extends BlockDirectional
{

    public BlockCocoa(int p_i3930_1_)
    {
        super(p_i3930_1_, 168, Material.field_76254_j);
        func_71907_b(true);
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_)
    {
        if(!func_71854_d(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_))
        {
            func_71897_c(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_, p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_), 0);
            p_71847_1_.func_72859_e(p_71847_2_, p_71847_3_, p_71847_4_, 0);
        } else
        if(p_71847_1_.field_73012_v.nextInt(5) == 0)
        {
            int i = p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_);
            int j = func_72219_c(i);
            if(j < 2)
            {
                j++;
                p_71847_1_.func_72921_c(p_71847_2_, p_71847_3_, p_71847_4_, j << 2 | func_72217_d(i));
            }
        }
    }

    public boolean func_71854_d(World p_71854_1_, int p_71854_2_, int p_71854_3_, int p_71854_4_)
    {
        int i = func_72217_d(p_71854_1_.func_72805_g(p_71854_2_, p_71854_3_, p_71854_4_));
        p_71854_2_ += Direction.field_71583_a[i];
        p_71854_4_ += Direction.field_71581_b[i];
        int j = p_71854_1_.func_72798_a(p_71854_2_, p_71854_3_, p_71854_4_);
        return j == Block.field_71951_J.field_71990_ca && BlockLog.func_72141_e(p_71854_1_.func_72805_g(p_71854_2_, p_71854_3_, p_71854_4_)) == 3;
    }

    public int func_71857_b()
    {
        return 28;
    }

    public boolean func_71886_c()
    {
        return false;
    }

    public boolean func_71926_d()
    {
        return false;
    }

    public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_)
    {
        func_71902_a(p_71872_1_, p_71872_2_, p_71872_3_, p_71872_4_);
        return super.func_71872_e(p_71872_1_, p_71872_2_, p_71872_3_, p_71872_4_);
    }

    public AxisAlignedBB func_71911_a_(World p_71911_1_, int p_71911_2_, int p_71911_3_, int p_71911_4_)
    {
        func_71902_a(p_71911_1_, p_71911_2_, p_71911_3_, p_71911_4_);
        return super.func_71911_a_(p_71911_1_, p_71911_2_, p_71911_3_, p_71911_4_);
    }

    public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_)
    {
        int i = p_71902_1_.func_72805_g(p_71902_2_, p_71902_3_, p_71902_4_);
        int j = func_72217_d(i);
        int k = func_72219_c(i);
        int l = 4 + k * 2;
        int i1 = 5 + k * 2;
        float f = (float)l / 2.0F;
        switch(j)
        {
        case 0: // '\0'
            func_71905_a((8F - f) / 16F, (12F - (float)i1) / 16F, (15F - (float)l) / 16F, (8F + f) / 16F, 0.75F, 0.9375F);
            break;

        case 2: // '\002'
            func_71905_a((8F - f) / 16F, (12F - (float)i1) / 16F, 0.0625F, (8F + f) / 16F, 0.75F, (1.0F + (float)l) / 16F);
            break;

        case 1: // '\001'
            func_71905_a(0.0625F, (12F - (float)i1) / 16F, (8F - f) / 16F, (1.0F + (float)l) / 16F, 0.75F, (8F + f) / 16F);
            break;

        case 3: // '\003'
            func_71905_a((15F - (float)l) / 16F, (12F - (float)i1) / 16F, (8F - f) / 16F, 0.9375F, 0.75F, (8F + f) / 16F);
            break;
        }
    }

    public void func_71860_a(World p_71860_1_, int p_71860_2_, int p_71860_3_, int p_71860_4_, EntityLiving p_71860_5_)
    {
        int i = ((MathHelper.func_76128_c((double)((p_71860_5_.field_70177_z * 4F) / 360F) + 0.5D) & 3) + 0) % 4;
        p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, i);
    }

    public void func_71909_a(World p_71909_1_, int p_71909_2_, int p_71909_3_, int p_71909_4_, int p_71909_5_, float p_71909_6_, float p_71909_7_, 
            float p_71909_8_)
    {
        if(p_71909_5_ == 1 || p_71909_5_ == 0)
        {
            p_71909_5_ = 2;
        }
        int i = Direction.field_71580_e[Direction.field_71579_d[p_71909_5_]];
        p_71909_1_.func_72921_c(p_71909_2_, p_71909_3_, p_71909_4_, i);
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        if(!func_71854_d(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_))
        {
            func_71897_c(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_), 0);
            p_71863_1_.func_72859_e(p_71863_2_, p_71863_3_, p_71863_4_, 0);
        }
    }

    public static int func_72219_c(int p_72219_0_)
    {
        return (p_72219_0_ & 0xc) >> 2;
    }

    public void func_71914_a(World p_71914_1_, int p_71914_2_, int p_71914_3_, int p_71914_4_, int p_71914_5_, float p_71914_6_, int p_71914_7_)
    {
        int i = func_72219_c(p_71914_5_);
        byte byte0 = 1;
        if(i >= 2)
        {
            byte0 = 3;
        }
        for(int j = 0; j < byte0; j++)
        {
            func_71929_a(p_71914_1_, p_71914_2_, p_71914_3_, p_71914_4_, new ItemStack(Item.field_77756_aW, 1, 3));
        }

    }

    public int func_71922_a(World p_71922_1_, int p_71922_2_, int p_71922_3_, int p_71922_4_)
    {
        return Item.field_77756_aW.field_77779_bT;
    }

    public int func_71873_h(World p_71873_1_, int p_71873_2_, int p_71873_3_, int i)
    {
        return 3;
    }
}
