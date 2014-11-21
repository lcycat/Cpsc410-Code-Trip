// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockFlower, Block, World, BlockGrass, 
//            IBlockAccess, Item, EntityItem, ItemStack

public class BlockStem extends BlockFlower
{

    private Block field_72267_a;

    protected BlockStem(int p_i3998_1_, Block p_i3998_2_)
    {
        super(p_i3998_1_, 111);
        field_72267_a = p_i3998_2_;
        func_71907_b(true);
        float f = 0.125F;
        func_71905_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
        func_71849_a(null);
    }

    protected boolean func_72263_d_(int p_72263_1_)
    {
        return p_72263_1_ == Block.field_72050_aA.field_71990_ca;
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_)
    {
        super.func_71847_b(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_, p_71847_5_);
        if(p_71847_1_.func_72957_l(p_71847_2_, p_71847_3_ + 1, p_71847_4_) >= 9)
        {
            float f = func_72266_n(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_);
            if(p_71847_5_.nextInt((int)(25F / f) + 1) == 0)
            {
                int i = p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_);
                if(i < 7)
                {
                    i++;
                    p_71847_1_.func_72921_c(p_71847_2_, p_71847_3_, p_71847_4_, i);
                } else
                {
                    if(p_71847_1_.func_72798_a(p_71847_2_ - 1, p_71847_3_, p_71847_4_) == field_72267_a.field_71990_ca)
                    {
                        return;
                    }
                    if(p_71847_1_.func_72798_a(p_71847_2_ + 1, p_71847_3_, p_71847_4_) == field_72267_a.field_71990_ca)
                    {
                        return;
                    }
                    if(p_71847_1_.func_72798_a(p_71847_2_, p_71847_3_, p_71847_4_ - 1) == field_72267_a.field_71990_ca)
                    {
                        return;
                    }
                    if(p_71847_1_.func_72798_a(p_71847_2_, p_71847_3_, p_71847_4_ + 1) == field_72267_a.field_71990_ca)
                    {
                        return;
                    }
                    int j = p_71847_5_.nextInt(4);
                    int k = p_71847_2_;
                    int l = p_71847_4_;
                    if(j == 0)
                    {
                        k--;
                    }
                    if(j == 1)
                    {
                        k++;
                    }
                    if(j == 2)
                    {
                        l--;
                    }
                    if(j == 3)
                    {
                        l++;
                    }
                    int i1 = p_71847_1_.func_72798_a(k, p_71847_3_ - 1, l);
                    if(p_71847_1_.func_72798_a(k, p_71847_3_, l) == 0 && (i1 == Block.field_72050_aA.field_71990_ca || i1 == Block.field_71979_v.field_71990_ca || i1 == Block.field_71980_u.field_71990_ca))
                    {
                        p_71847_1_.func_72859_e(k, p_71847_3_, l, field_72267_a.field_71990_ca);
                    }
                }
            }
        }
    }

    public void func_72264_l(World p_72264_1_, int p_72264_2_, int p_72264_3_, int p_72264_4_)
    {
        p_72264_1_.func_72921_c(p_72264_2_, p_72264_3_, p_72264_4_, 7);
    }

    private float func_72266_n(World p_72266_1_, int p_72266_2_, int p_72266_3_, int p_72266_4_)
    {
        float f = 1.0F;
        int i = p_72266_1_.func_72798_a(p_72266_2_, p_72266_3_, p_72266_4_ - 1);
        int j = p_72266_1_.func_72798_a(p_72266_2_, p_72266_3_, p_72266_4_ + 1);
        int k = p_72266_1_.func_72798_a(p_72266_2_ - 1, p_72266_3_, p_72266_4_);
        int l = p_72266_1_.func_72798_a(p_72266_2_ + 1, p_72266_3_, p_72266_4_);
        int i1 = p_72266_1_.func_72798_a(p_72266_2_ - 1, p_72266_3_, p_72266_4_ - 1);
        int j1 = p_72266_1_.func_72798_a(p_72266_2_ + 1, p_72266_3_, p_72266_4_ - 1);
        int k1 = p_72266_1_.func_72798_a(p_72266_2_ + 1, p_72266_3_, p_72266_4_ + 1);
        int l1 = p_72266_1_.func_72798_a(p_72266_2_ - 1, p_72266_3_, p_72266_4_ + 1);
        boolean flag = k == field_71990_ca || l == field_71990_ca;
        boolean flag1 = i == field_71990_ca || j == field_71990_ca;
        boolean flag2 = i1 == field_71990_ca || j1 == field_71990_ca || k1 == field_71990_ca || l1 == field_71990_ca;
        for(int i2 = p_72266_2_ - 1; i2 <= p_72266_2_ + 1; i2++)
        {
            for(int j2 = p_72266_4_ - 1; j2 <= p_72266_4_ + 1; j2++)
            {
                int k2 = p_72266_1_.func_72798_a(i2, p_72266_3_ - 1, j2);
                float f1 = 0.0F;
                if(k2 == Block.field_72050_aA.field_71990_ca)
                {
                    f1 = 1.0F;
                    if(p_72266_1_.func_72805_g(i2, p_72266_3_ - 1, j2) > 0)
                    {
                        f1 = 3F;
                    }
                }
                if(i2 != p_72266_2_ || j2 != p_72266_4_)
                {
                    f1 /= 4F;
                }
                f += f1;
            }

        }

        if(flag2 || flag && flag1)
        {
            f /= 2.0F;
        }
        return f;
    }

    public int func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        return field_72059_bZ;
    }

    public void func_71919_f()
    {
        float f = 0.125F;
        func_71905_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
    }

    public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_)
    {
        field_72022_cl = (float)(p_71902_1_.func_72805_g(p_71902_2_, p_71902_3_, p_71902_4_) * 2 + 2) / 16F;
        float f = 0.125F;
        func_71905_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, (float)field_72022_cl, 0.5F + f);
    }

    public int func_71857_b()
    {
        return 19;
    }

    public void func_71914_a(World p_71914_1_, int p_71914_2_, int p_71914_3_, int p_71914_4_, int p_71914_5_, float p_71914_6_, int p_71914_7_)
    {
        super.func_71914_a(p_71914_1_, p_71914_2_, p_71914_3_, p_71914_4_, p_71914_5_, p_71914_6_, p_71914_7_);
        if(p_71914_1_.field_72995_K)
        {
            return;
        }
        Item item = null;
        if(field_72267_a == Block.field_72061_ba)
        {
            item = Item.field_77739_bg;
        }
        if(field_72267_a == Block.field_71997_br)
        {
            item = Item.field_77740_bh;
        }
        for(int i = 0; i < 3; i++)
        {
            if(p_71914_1_.field_73012_v.nextInt(15) <= p_71914_5_)
            {
                float f = 0.7F;
                float f1 = p_71914_1_.field_73012_v.nextFloat() * f + (1.0F - f) * 0.5F;
                float f2 = p_71914_1_.field_73012_v.nextFloat() * f + (1.0F - f) * 0.5F;
                float f3 = p_71914_1_.field_73012_v.nextFloat() * f + (1.0F - f) * 0.5F;
                EntityItem entityitem = new EntityItem(p_71914_1_, (float)p_71914_2_ + f1, (float)p_71914_3_ + f2, (float)p_71914_4_ + f3, new ItemStack(item));
                entityitem.field_70293_c = 10;
                p_71914_1_.func_72838_d(entityitem);
            }
        }

    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        return -1;
    }

    public int func_71925_a(Random p_71925_1_)
    {
        return 1;
    }
}
