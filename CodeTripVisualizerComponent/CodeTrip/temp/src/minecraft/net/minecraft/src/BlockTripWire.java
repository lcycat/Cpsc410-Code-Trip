// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, Item, World, 
//            IBlockAccess, EntityPlayer, ItemStack, ItemShears, 
//            Direction, BlockTripWireSource, AxisAlignedBB, AABBPool, 
//            Entity

public class BlockTripWire extends Block
{

    public BlockTripWire(int p_i4018_1_)
    {
        super(p_i4018_1_, 173, Material.field_76265_p);
        func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.15625F, 1.0F);
        func_71907_b(true);
    }

    public int func_71859_p_()
    {
        return 10;
    }

    public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int i)
    {
        return null;
    }

    public boolean func_71926_d()
    {
        return false;
    }

    public boolean func_71886_c()
    {
        return false;
    }

    public int func_71856_s_()
    {
        return 1;
    }

    public int func_71857_b()
    {
        return 30;
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        return Item.field_77683_K.field_77779_bT;
    }

    public int func_71922_a(World p_71922_1_, int p_71922_2_, int p_71922_3_, int p_71922_4_)
    {
        return Item.field_77683_K.field_77779_bT;
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        int i = p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_);
        boolean flag = (i & 2) == 2;
        boolean flag1 = !p_71863_1_.func_72797_t(p_71863_2_, p_71863_3_ - 1, p_71863_4_);
        if(flag != flag1)
        {
            func_71897_c(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, i, 0);
            p_71863_1_.func_72859_e(p_71863_2_, p_71863_3_, p_71863_4_, 0);
        }
    }

    public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_)
    {
        int i = p_71902_1_.func_72805_g(p_71902_2_, p_71902_3_, p_71902_4_);
        boolean flag = (i & 4) == 4;
        boolean flag1 = (i & 2) == 2;
        if(!flag1)
        {
            func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.09375F, 1.0F);
        } else
        if(!flag)
        {
            func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
        } else
        {
            func_71905_a(0.0F, 0.0625F, 0.0F, 1.0F, 0.15625F, 1.0F);
        }
    }

    public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_)
    {
        byte byte0 = ((byte)(p_71861_1_.func_72797_t(p_71861_2_, p_71861_3_ - 1, p_71861_4_) ? 0 : 2));
        p_71861_1_.func_72921_c(p_71861_2_, p_71861_3_, p_71861_4_, byte0);
        func_72149_e(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_, byte0);
    }

    public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_)
    {
        func_72149_e(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_, p_71852_6_ | 1);
    }

    public void func_71846_a(World p_71846_1_, int p_71846_2_, int p_71846_3_, int p_71846_4_, int p_71846_5_, EntityPlayer p_71846_6_)
    {
        if(p_71846_1_.field_72995_K)
        {
            return;
        }
        if(p_71846_6_.func_71045_bC() != null && p_71846_6_.func_71045_bC().field_77993_c == Item.field_77745_be.field_77779_bT)
        {
            p_71846_1_.func_72921_c(p_71846_2_, p_71846_3_, p_71846_4_, p_71846_5_ | 8);
        }
    }

    private void func_72149_e(World p_72149_1_, int p_72149_2_, int p_72149_3_, int p_72149_4_, int p_72149_5_)
    {
label0:
        for(int i = 0; i < 2; i++)
        {
            int j = 1;
            do
            {
                if(j >= 42)
                {
                    continue label0;
                }
                int k = p_72149_2_ + Direction.field_71583_a[i] * j;
                int l = p_72149_4_ + Direction.field_71581_b[i] * j;
                int i1 = p_72149_1_.func_72798_a(k, p_72149_3_, l);
                if(i1 == Block.field_72064_bT.field_71990_ca)
                {
                    int j1 = p_72149_1_.func_72805_g(k, p_72149_3_, l) & 3;
                    if(j1 == Direction.field_71580_e[i])
                    {
                        Block.field_72064_bT.func_72143_a(p_72149_1_, k, p_72149_3_, l, i1, p_72149_1_.func_72805_g(k, p_72149_3_, l), true, j, p_72149_5_);
                    }
                    continue label0;
                }
                if(i1 != Block.field_72062_bU.field_71990_ca)
                {
                    continue label0;
                }
                j++;
            } while(true);
        }

    }

    public void func_71869_a(World p_71869_1_, int p_71869_2_, int p_71869_3_, int p_71869_4_, Entity p_71869_5_)
    {
        if(p_71869_1_.field_72995_K)
        {
            return;
        }
        if((p_71869_1_.func_72805_g(p_71869_2_, p_71869_3_, p_71869_4_) & 1) == 1)
        {
            return;
        } else
        {
            func_72147_l(p_71869_1_, p_71869_2_, p_71869_3_, p_71869_4_);
            return;
        }
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_)
    {
        if(p_71847_1_.field_72995_K)
        {
            return;
        }
        if((p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_) & 1) != 1)
        {
            return;
        } else
        {
            func_72147_l(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_);
            return;
        }
    }

    private void func_72147_l(World p_72147_1_, int p_72147_2_, int p_72147_3_, int p_72147_4_)
    {
        int i = p_72147_1_.func_72805_g(p_72147_2_, p_72147_3_, p_72147_4_);
        boolean flag = (i & 1) == 1;
        boolean flag1 = false;
        List list = p_72147_1_.func_72839_b(null, AxisAlignedBB.func_72332_a().func_72299_a((double)p_72147_2_ + field_72026_ch, (double)p_72147_3_ + field_72023_ci, (double)p_72147_4_ + field_72024_cj, (double)p_72147_2_ + field_72021_ck, (double)p_72147_3_ + field_72022_cl, (double)p_72147_4_ + field_72019_cm));
        if(!list.isEmpty())
        {
            flag1 = true;
        }
        if(flag1 && !flag)
        {
            i |= 1;
        }
        if(!flag1 && flag)
        {
            i &= -2;
        }
        if(flag1 != flag)
        {
            p_72147_1_.func_72921_c(p_72147_2_, p_72147_3_, p_72147_4_, i);
            func_72149_e(p_72147_1_, p_72147_2_, p_72147_3_, p_72147_4_, i);
        }
        if(flag1)
        {
            p_72147_1_.func_72836_a(p_72147_2_, p_72147_3_, p_72147_4_, field_71990_ca, func_71859_p_());
        }
    }

    public static boolean func_72148_a(IBlockAccess p_72148_0_, int p_72148_1_, int p_72148_2_, int p_72148_3_, int p_72148_4_, int p_72148_5_)
    {
        int i = p_72148_1_ + Direction.field_71583_a[p_72148_5_];
        int j = p_72148_2_;
        int k = p_72148_3_ + Direction.field_71581_b[p_72148_5_];
        int l = p_72148_0_.func_72798_a(i, j, k);
        boolean flag = (p_72148_4_ & 2) == 2;
        if(l == Block.field_72064_bT.field_71990_ca)
        {
            int i1 = p_72148_0_.func_72805_g(i, j, k);
            int k1 = i1 & 3;
            return k1 == Direction.field_71580_e[p_72148_5_];
        }
        if(l == Block.field_72062_bU.field_71990_ca)
        {
            int j1 = p_72148_0_.func_72805_g(i, j, k);
            boolean flag1 = (j1 & 2) == 2;
            return flag == flag1;
        } else
        {
            return false;
        }
    }
}
