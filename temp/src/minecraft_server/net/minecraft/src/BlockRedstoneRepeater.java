// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockDirectional, Material, World, Block, 
//            IBlockAccess, EntityLiving, MathHelper, Item, 
//            EntityPlayer

public class BlockRedstoneRepeater extends BlockDirectional
{

    public static final double field_72223_a[] = {
        -0.0625D, 0.0625D, 0.1875D, 0.3125D
    };
    private static final int field_72221_b[] = {
        1, 2, 3, 4
    };
    private final boolean field_72222_c;

    protected BlockRedstoneRepeater(int p_i3934_1_, boolean p_i3934_2_)
    {
        super(p_i3934_1_, 6, Material.field_76265_p);
        field_72222_c = p_i3934_2_;
        func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
    }

    public boolean func_71886_c()
    {
        return false;
    }

    public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_)
    {
        if(!p_71930_1_.func_72797_t(p_71930_2_, p_71930_3_ - 1, p_71930_4_))
        {
            return false;
        } else
        {
            return super.func_71930_b(p_71930_1_, p_71930_2_, p_71930_3_, p_71930_4_);
        }
    }

    public boolean func_71854_d(World p_71854_1_, int p_71854_2_, int p_71854_3_, int p_71854_4_)
    {
        if(!p_71854_1_.func_72797_t(p_71854_2_, p_71854_3_ - 1, p_71854_4_))
        {
            return false;
        } else
        {
            return super.func_71854_d(p_71854_1_, p_71854_2_, p_71854_3_, p_71854_4_);
        }
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_)
    {
        int i = p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_);
        boolean flag = func_72220_e(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_, i);
        if(field_72222_c && !flag)
        {
            p_71847_1_.func_72832_d(p_71847_2_, p_71847_3_, p_71847_4_, Block.field_72010_bh.field_71990_ca, i);
        } else
        if(!field_72222_c)
        {
            p_71847_1_.func_72832_d(p_71847_2_, p_71847_3_, p_71847_4_, Block.field_72011_bi.field_71990_ca, i);
            if(!flag)
            {
                int j = (i & 0xc) >> 2;
                p_71847_1_.func_72836_a(p_71847_2_, p_71847_3_, p_71847_4_, Block.field_72011_bi.field_71990_ca, field_72221_b[j] * 2);
            }
        }
    }

    public int func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        if(p_71858_1_ == 0)
        {
            return !field_72222_c ? 115 : 99;
        }
        if(p_71858_1_ == 1)
        {
            return !field_72222_c ? 131 : 147;
        } else
        {
            return 5;
        }
    }

    public int func_71857_b()
    {
        return 15;
    }

    public int func_71851_a(int p_71851_1_)
    {
        return func_71858_a(p_71851_1_, 0);
    }

    public boolean func_71855_c(World p_71855_1_, int p_71855_2_, int p_71855_3_, int p_71855_4_, int p_71855_5_)
    {
        return func_71865_a(p_71855_1_, p_71855_2_, p_71855_3_, p_71855_4_, p_71855_5_);
    }

    public boolean func_71865_a(IBlockAccess p_71865_1_, int p_71865_2_, int p_71865_3_, int p_71865_4_, int p_71865_5_)
    {
        if(!field_72222_c)
        {
            return false;
        }
        int i = func_72217_d(p_71865_1_.func_72805_g(p_71865_2_, p_71865_3_, p_71865_4_));
        if(i == 0 && p_71865_5_ == 3)
        {
            return true;
        }
        if(i == 1 && p_71865_5_ == 4)
        {
            return true;
        }
        if(i == 2 && p_71865_5_ == 2)
        {
            return true;
        }
        return i == 3 && p_71865_5_ == 5;
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        if(!func_71854_d(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_))
        {
            func_71897_c(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_), 0);
            p_71863_1_.func_72859_e(p_71863_2_, p_71863_3_, p_71863_4_, 0);
            p_71863_1_.func_72898_h(p_71863_2_ + 1, p_71863_3_, p_71863_4_, field_71990_ca);
            p_71863_1_.func_72898_h(p_71863_2_ - 1, p_71863_3_, p_71863_4_, field_71990_ca);
            p_71863_1_.func_72898_h(p_71863_2_, p_71863_3_, p_71863_4_ + 1, field_71990_ca);
            p_71863_1_.func_72898_h(p_71863_2_, p_71863_3_, p_71863_4_ - 1, field_71990_ca);
            p_71863_1_.func_72898_h(p_71863_2_, p_71863_3_ - 1, p_71863_4_, field_71990_ca);
            p_71863_1_.func_72898_h(p_71863_2_, p_71863_3_ + 1, p_71863_4_, field_71990_ca);
            return;
        }
        int i = p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_);
        boolean flag = func_72220_e(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, i);
        int j = (i & 0xc) >> 2;
        if(field_72222_c && !flag || !field_72222_c && flag)
        {
            p_71863_1_.func_72836_a(p_71863_2_, p_71863_3_, p_71863_4_, field_71990_ca, field_72221_b[j] * 2);
        }
    }

    private boolean func_72220_e(World p_72220_1_, int p_72220_2_, int p_72220_3_, int p_72220_4_, int p_72220_5_)
    {
        int i = func_72217_d(p_72220_5_);
        switch(i)
        {
        case 0: // '\0'
            return p_72220_1_.func_72878_l(p_72220_2_, p_72220_3_, p_72220_4_ + 1, 3) || p_72220_1_.func_72798_a(p_72220_2_, p_72220_3_, p_72220_4_ + 1) == Block.field_72075_av.field_71990_ca && p_72220_1_.func_72805_g(p_72220_2_, p_72220_3_, p_72220_4_ + 1) > 0;

        case 2: // '\002'
            return p_72220_1_.func_72878_l(p_72220_2_, p_72220_3_, p_72220_4_ - 1, 2) || p_72220_1_.func_72798_a(p_72220_2_, p_72220_3_, p_72220_4_ - 1) == Block.field_72075_av.field_71990_ca && p_72220_1_.func_72805_g(p_72220_2_, p_72220_3_, p_72220_4_ - 1) > 0;

        case 3: // '\003'
            return p_72220_1_.func_72878_l(p_72220_2_ + 1, p_72220_3_, p_72220_4_, 5) || p_72220_1_.func_72798_a(p_72220_2_ + 1, p_72220_3_, p_72220_4_) == Block.field_72075_av.field_71990_ca && p_72220_1_.func_72805_g(p_72220_2_ + 1, p_72220_3_, p_72220_4_) > 0;

        case 1: // '\001'
            return p_72220_1_.func_72878_l(p_72220_2_ - 1, p_72220_3_, p_72220_4_, 4) || p_72220_1_.func_72798_a(p_72220_2_ - 1, p_72220_3_, p_72220_4_) == Block.field_72075_av.field_71990_ca && p_72220_1_.func_72805_g(p_72220_2_ - 1, p_72220_3_, p_72220_4_) > 0;
        }
        return false;
    }

    public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, 
            float p_71903_8_, float p_71903_9_)
    {
        int i = p_71903_1_.func_72805_g(p_71903_2_, p_71903_3_, p_71903_4_);
        int j = (i & 0xc) >> 2;
        j = j + 1 << 2 & 0xc;
        p_71903_1_.func_72921_c(p_71903_2_, p_71903_3_, p_71903_4_, j | i & 3);
        return true;
    }

    public boolean func_71853_i()
    {
        return true;
    }

    public void func_71860_a(World p_71860_1_, int p_71860_2_, int p_71860_3_, int p_71860_4_, EntityLiving p_71860_5_)
    {
        int i = ((MathHelper.func_76128_c((double)((p_71860_5_.field_70177_z * 4F) / 360F) + 0.5D) & 3) + 2) % 4;
        p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, i);
        boolean flag = func_72220_e(p_71860_1_, p_71860_2_, p_71860_3_, p_71860_4_, i);
        if(flag)
        {
            p_71860_1_.func_72836_a(p_71860_2_, p_71860_3_, p_71860_4_, field_71990_ca, 1);
        }
    }

    public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_)
    {
        p_71861_1_.func_72898_h(p_71861_2_ + 1, p_71861_3_, p_71861_4_, field_71990_ca);
        p_71861_1_.func_72898_h(p_71861_2_ - 1, p_71861_3_, p_71861_4_, field_71990_ca);
        p_71861_1_.func_72898_h(p_71861_2_, p_71861_3_, p_71861_4_ + 1, field_71990_ca);
        p_71861_1_.func_72898_h(p_71861_2_, p_71861_3_, p_71861_4_ - 1, field_71990_ca);
        p_71861_1_.func_72898_h(p_71861_2_, p_71861_3_ - 1, p_71861_4_, field_71990_ca);
        p_71861_1_.func_72898_h(p_71861_2_, p_71861_3_ + 1, p_71861_4_, field_71990_ca);
    }

    public void func_71898_d(World p_71898_1_, int p_71898_2_, int p_71898_3_, int p_71898_4_, int p_71898_5_)
    {
        if(field_72222_c)
        {
            p_71898_1_.func_72898_h(p_71898_2_ + 1, p_71898_3_, p_71898_4_, field_71990_ca);
            p_71898_1_.func_72898_h(p_71898_2_ - 1, p_71898_3_, p_71898_4_, field_71990_ca);
            p_71898_1_.func_72898_h(p_71898_2_, p_71898_3_, p_71898_4_ + 1, field_71990_ca);
            p_71898_1_.func_72898_h(p_71898_2_, p_71898_3_, p_71898_4_ - 1, field_71990_ca);
            p_71898_1_.func_72898_h(p_71898_2_, p_71898_3_ - 1, p_71898_4_, field_71990_ca);
            p_71898_1_.func_72898_h(p_71898_2_, p_71898_3_ + 1, p_71898_4_, field_71990_ca);
        }
        super.func_71898_d(p_71898_1_, p_71898_2_, p_71898_3_, p_71898_4_, p_71898_5_);
    }

    public boolean func_71926_d()
    {
        return false;
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        return Item.field_77742_bb.field_77779_bT;
    }

}
