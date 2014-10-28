// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, CreativeTabs, IBlockAccess, 
//            World, Direction, ColorizerFoliage, BiomeGenBase, 
//            EntityPlayer, ItemStack, Item, ItemShears, 
//            StatList, AxisAlignedBB

public class BlockVine extends Block
{

    public BlockVine(int p_i4019_1_)
    {
        super(p_i4019_1_, 143, Material.field_76255_k);
        func_71907_b(true);
        func_71849_a(CreativeTabs.field_78031_c);
    }

    public void func_71919_f()
    {
        func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public int func_71857_b()
    {
        return 20;
    }

    public boolean func_71926_d()
    {
        return false;
    }

    public boolean func_71886_c()
    {
        return false;
    }

    public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_)
    {
        int i = p_71902_1_.func_72805_g(p_71902_2_, p_71902_3_, p_71902_4_);
        float f = 1.0F;
        float f1 = 1.0F;
        float f2 = 1.0F;
        float f3 = 0.0F;
        float f4 = 0.0F;
        float f5 = 0.0F;
        boolean flag = i > 0;
        if((i & 2) != 0)
        {
            f3 = Math.max(f3, 0.0625F);
            f = 0.0F;
            f1 = 0.0F;
            f4 = 1.0F;
            f2 = 0.0F;
            f5 = 1.0F;
            flag = true;
        }
        if((i & 8) != 0)
        {
            f = Math.min(f, 0.9375F);
            f3 = 1.0F;
            f1 = 0.0F;
            f4 = 1.0F;
            f2 = 0.0F;
            f5 = 1.0F;
            flag = true;
        }
        if((i & 4) != 0)
        {
            f5 = Math.max(f5, 0.0625F);
            f2 = 0.0F;
            f = 0.0F;
            f3 = 1.0F;
            f1 = 0.0F;
            f4 = 1.0F;
            flag = true;
        }
        if((i & 1) != 0)
        {
            f2 = Math.min(f2, 0.9375F);
            f5 = 1.0F;
            f = 0.0F;
            f3 = 1.0F;
            f1 = 0.0F;
            f4 = 1.0F;
            flag = true;
        }
        if(!flag && func_72151_e(p_71902_1_.func_72798_a(p_71902_2_, p_71902_3_ + 1, p_71902_4_)))
        {
            f1 = Math.min(f1, 0.9375F);
            f4 = 1.0F;
            f = 0.0F;
            f3 = 1.0F;
            f2 = 0.0F;
            f5 = 1.0F;
        }
        func_71905_a(f, f1, f2, f3, f4, f5);
    }

    public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int i)
    {
        return null;
    }

    public boolean func_71850_a_(World p_71850_1_, int p_71850_2_, int p_71850_3_, int p_71850_4_, int p_71850_5_)
    {
        switch(p_71850_5_)
        {
        default:
            return false;

        case 1: // '\001'
            return func_72151_e(p_71850_1_.func_72798_a(p_71850_2_, p_71850_3_ + 1, p_71850_4_));

        case 2: // '\002'
            return func_72151_e(p_71850_1_.func_72798_a(p_71850_2_, p_71850_3_, p_71850_4_ + 1));

        case 3: // '\003'
            return func_72151_e(p_71850_1_.func_72798_a(p_71850_2_, p_71850_3_, p_71850_4_ - 1));

        case 5: // '\005'
            return func_72151_e(p_71850_1_.func_72798_a(p_71850_2_ - 1, p_71850_3_, p_71850_4_));

        case 4: // '\004'
            return func_72151_e(p_71850_1_.func_72798_a(p_71850_2_ + 1, p_71850_3_, p_71850_4_));
        }
    }

    private boolean func_72151_e(int p_72151_1_)
    {
        if(p_72151_1_ == 0)
        {
            return false;
        }
        Block block = Block.field_71973_m[p_72151_1_];
        return block.func_71886_c() && block.field_72018_cp.func_76230_c();
    }

    private boolean func_72150_l(World p_72150_1_, int p_72150_2_, int p_72150_3_, int p_72150_4_)
    {
        int i = p_72150_1_.func_72805_g(p_72150_2_, p_72150_3_, p_72150_4_);
        int j = i;
        if(j > 0)
        {
            for(int k = 0; k <= 3; k++)
            {
                int l = 1 << k;
                if((i & l) != 0 && !func_72151_e(p_72150_1_.func_72798_a(p_72150_2_ + Direction.field_71583_a[k], p_72150_3_, p_72150_4_ + Direction.field_71581_b[k])) && (p_72150_1_.func_72798_a(p_72150_2_, p_72150_3_ + 1, p_72150_4_) != field_71990_ca || (p_72150_1_.func_72805_g(p_72150_2_, p_72150_3_ + 1, p_72150_4_) & l) == 0))
                {
                    j &= ~l;
                }
            }

        }
        if(j == 0 && !func_72151_e(p_72150_1_.func_72798_a(p_72150_2_, p_72150_3_ + 1, p_72150_4_)))
        {
            return false;
        }
        if(j != i)
        {
            p_72150_1_.func_72921_c(p_72150_2_, p_72150_3_, p_72150_4_, j);
        }
        return true;
    }

    public int func_71933_m()
    {
        return ColorizerFoliage.func_77468_c();
    }

    public int func_71889_f_(int p_71889_1_)
    {
        return ColorizerFoliage.func_77468_c();
    }

    public int func_71920_b(IBlockAccess p_71920_1_, int p_71920_2_, int p_71920_3_, int p_71920_4_)
    {
        return p_71920_1_.func_72807_a(p_71920_2_, p_71920_4_).func_76726_l();
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        if(!p_71863_1_.field_72995_K && !func_72150_l(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_))
        {
            func_71897_c(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_), 0);
            p_71863_1_.func_72859_e(p_71863_2_, p_71863_3_, p_71863_4_, 0);
        }
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_)
    {
        if(!p_71847_1_.field_72995_K && p_71847_1_.field_73012_v.nextInt(4) == 0)
        {
            byte byte0 = 4;
            int i = 5;
            boolean flag = false;
            int j = p_71847_2_ - byte0;
label0:
            do
            {
                if(j > p_71847_2_ + byte0)
                {
                    break;
                }
label1:
                for(int k = p_71847_4_ - byte0; k <= p_71847_4_ + byte0; k++)
                {
                    int i1 = p_71847_3_ - 1;
                    do
                    {
                        if(i1 > p_71847_3_ + 1)
                        {
                            continue label1;
                        }
                        if(p_71847_1_.func_72798_a(j, i1, k) == field_71990_ca && --i <= 0)
                        {
                            flag = true;
                            break label0;
                        }
                        i1++;
                    } while(true);
                }

                j++;
            } while(true);
            j = p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_);
            int l = p_71847_1_.field_73012_v.nextInt(6);
            int j1 = Direction.field_71579_d[l];
            if(l == 1 && p_71847_3_ < 255 && p_71847_1_.func_72799_c(p_71847_2_, p_71847_3_ + 1, p_71847_4_))
            {
                if(flag)
                {
                    return;
                }
                int k1 = p_71847_1_.field_73012_v.nextInt(16) & j;
                if(k1 > 0)
                {
                    for(int j2 = 0; j2 <= 3; j2++)
                    {
                        if(!func_72151_e(p_71847_1_.func_72798_a(p_71847_2_ + Direction.field_71583_a[j2], p_71847_3_ + 1, p_71847_4_ + Direction.field_71581_b[j2])))
                        {
                            k1 &= ~(1 << j2);
                        }
                    }

                    if(k1 > 0)
                    {
                        p_71847_1_.func_72832_d(p_71847_2_, p_71847_3_ + 1, p_71847_4_, field_71990_ca, k1);
                    }
                }
            } else
            if(l >= 2 && l <= 5 && (j & 1 << j1) == 0)
            {
                if(flag)
                {
                    return;
                }
                int l1 = p_71847_1_.func_72798_a(p_71847_2_ + Direction.field_71583_a[j1], p_71847_3_, p_71847_4_ + Direction.field_71581_b[j1]);
                if(l1 == 0 || Block.field_71973_m[l1] == null)
                {
                    int k2 = j1 + 1 & 3;
                    int j3 = j1 + 3 & 3;
                    if((j & 1 << k2) != 0 && func_72151_e(p_71847_1_.func_72798_a(p_71847_2_ + Direction.field_71583_a[j1] + Direction.field_71583_a[k2], p_71847_3_, p_71847_4_ + Direction.field_71581_b[j1] + Direction.field_71581_b[k2])))
                    {
                        p_71847_1_.func_72832_d(p_71847_2_ + Direction.field_71583_a[j1], p_71847_3_, p_71847_4_ + Direction.field_71581_b[j1], field_71990_ca, 1 << k2);
                    } else
                    if((j & 1 << j3) != 0 && func_72151_e(p_71847_1_.func_72798_a(p_71847_2_ + Direction.field_71583_a[j1] + Direction.field_71583_a[j3], p_71847_3_, p_71847_4_ + Direction.field_71581_b[j1] + Direction.field_71581_b[j3])))
                    {
                        p_71847_1_.func_72832_d(p_71847_2_ + Direction.field_71583_a[j1], p_71847_3_, p_71847_4_ + Direction.field_71581_b[j1], field_71990_ca, 1 << j3);
                    } else
                    if((j & 1 << k2) != 0 && p_71847_1_.func_72799_c(p_71847_2_ + Direction.field_71583_a[j1] + Direction.field_71583_a[k2], p_71847_3_, p_71847_4_ + Direction.field_71581_b[j1] + Direction.field_71581_b[k2]) && func_72151_e(p_71847_1_.func_72798_a(p_71847_2_ + Direction.field_71583_a[k2], p_71847_3_, p_71847_4_ + Direction.field_71581_b[k2])))
                    {
                        p_71847_1_.func_72832_d(p_71847_2_ + Direction.field_71583_a[j1] + Direction.field_71583_a[k2], p_71847_3_, p_71847_4_ + Direction.field_71581_b[j1] + Direction.field_71581_b[k2], field_71990_ca, 1 << (j1 + 2 & 3));
                    } else
                    if((j & 1 << j3) != 0 && p_71847_1_.func_72799_c(p_71847_2_ + Direction.field_71583_a[j1] + Direction.field_71583_a[j3], p_71847_3_, p_71847_4_ + Direction.field_71581_b[j1] + Direction.field_71581_b[j3]) && func_72151_e(p_71847_1_.func_72798_a(p_71847_2_ + Direction.field_71583_a[j3], p_71847_3_, p_71847_4_ + Direction.field_71581_b[j3])))
                    {
                        p_71847_1_.func_72832_d(p_71847_2_ + Direction.field_71583_a[j1] + Direction.field_71583_a[j3], p_71847_3_, p_71847_4_ + Direction.field_71581_b[j1] + Direction.field_71581_b[j3], field_71990_ca, 1 << (j1 + 2 & 3));
                    } else
                    if(func_72151_e(p_71847_1_.func_72798_a(p_71847_2_ + Direction.field_71583_a[j1], p_71847_3_ + 1, p_71847_4_ + Direction.field_71581_b[j1])))
                    {
                        p_71847_1_.func_72832_d(p_71847_2_ + Direction.field_71583_a[j1], p_71847_3_, p_71847_4_ + Direction.field_71581_b[j1], field_71990_ca, 0);
                    }
                } else
                if(Block.field_71973_m[l1].field_72018_cp.func_76218_k() && Block.field_71973_m[l1].func_71886_c())
                {
                    p_71847_1_.func_72921_c(p_71847_2_, p_71847_3_, p_71847_4_, j | 1 << j1);
                }
            } else
            if(p_71847_3_ > 1)
            {
                int i2 = p_71847_1_.func_72798_a(p_71847_2_, p_71847_3_ - 1, p_71847_4_);
                if(i2 == 0)
                {
                    int l2 = p_71847_1_.field_73012_v.nextInt(16) & j;
                    if(l2 > 0)
                    {
                        p_71847_1_.func_72832_d(p_71847_2_, p_71847_3_ - 1, p_71847_4_, field_71990_ca, l2);
                    }
                } else
                if(i2 == field_71990_ca)
                {
                    int i3 = p_71847_1_.field_73012_v.nextInt(16) & j;
                    int k3 = p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_ - 1, p_71847_4_);
                    if(k3 != (k3 | i3))
                    {
                        p_71847_1_.func_72921_c(p_71847_2_, p_71847_3_ - 1, p_71847_4_, k3 | i3);
                    }
                }
            }
        }
    }

    public void func_71909_a(World p_71909_1_, int p_71909_2_, int p_71909_3_, int p_71909_4_, int p_71909_5_, float p_71909_6_, float p_71909_7_, 
            float p_71909_8_)
    {
        byte byte0 = 0;
        switch(p_71909_5_)
        {
        case 2: // '\002'
            byte0 = 1;
            break;

        case 3: // '\003'
            byte0 = 4;
            break;

        case 4: // '\004'
            byte0 = 8;
            break;

        case 5: // '\005'
            byte0 = 2;
            break;
        }
        if(byte0 != 0)
        {
            p_71909_1_.func_72921_c(p_71909_2_, p_71909_3_, p_71909_4_, byte0);
        }
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        return 0;
    }

    public int func_71925_a(Random p_71925_1_)
    {
        return 0;
    }

    public void func_71893_a(World p_71893_1_, EntityPlayer p_71893_2_, int p_71893_3_, int p_71893_4_, int p_71893_5_, int p_71893_6_)
    {
        if(!p_71893_1_.field_72995_K && p_71893_2_.func_71045_bC() != null && p_71893_2_.func_71045_bC().field_77993_c == Item.field_77745_be.field_77779_bT)
        {
            p_71893_2_.func_71064_a(StatList.field_75934_C[field_71990_ca], 1);
            func_71929_a(p_71893_1_, p_71893_3_, p_71893_4_, p_71893_5_, new ItemStack(Block.field_71998_bu, 1, 0));
        } else
        {
            super.func_71893_a(p_71893_1_, p_71893_2_, p_71893_3_, p_71893_4_, p_71893_5_, p_71893_6_);
        }
    }
}
