// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockLeavesBase, Material, CreativeTabs, ColorizerFoliage, 
//            IBlockAccess, BiomeGenBase, World, Block, 
//            ItemStack, Item, EntityPlayer, ItemShears, 
//            StatList

public class BlockLeaves extends BlockLeavesBase
{

    private int field_72134_cr;
    public static final String field_72136_a[] = {
        "oak", "spruce", "birch", "jungle"
    };
    int field_72135_b[];

    protected BlockLeaves(int p_i3961_1_, int p_i3961_2_)
    {
        super(p_i3961_1_, p_i3961_2_, Material.field_76257_i, false);
        field_72134_cr = p_i3961_2_;
        func_71907_b(true);
        func_71849_a(CreativeTabs.field_78031_c);
    }

    public int func_71933_m()
    {
        double d = 0.5D;
        double d1 = 1.0D;
        return ColorizerFoliage.func_77470_a(d, d1);
    }

    public int func_71889_f_(int p_71889_1_)
    {
        if((p_71889_1_ & 3) == 1)
        {
            return ColorizerFoliage.func_77466_a();
        }
        if((p_71889_1_ & 3) == 2)
        {
            return ColorizerFoliage.func_77469_b();
        } else
        {
            return ColorizerFoliage.func_77468_c();
        }
    }

    public int func_71920_b(IBlockAccess p_71920_1_, int p_71920_2_, int p_71920_3_, int p_71920_4_)
    {
        int i = p_71920_1_.func_72805_g(p_71920_2_, p_71920_3_, p_71920_4_);
        if((i & 3) == 1)
        {
            return ColorizerFoliage.func_77466_a();
        }
        if((i & 3) == 2)
        {
            return ColorizerFoliage.func_77469_b();
        }
        int j = 0;
        int k = 0;
        int l = 0;
        for(int i1 = -1; i1 <= 1; i1++)
        {
            for(int j1 = -1; j1 <= 1; j1++)
            {
                int k1 = p_71920_1_.func_72807_a(p_71920_2_ + j1, p_71920_4_ + i1).func_76726_l();
                j += (k1 & 0xff0000) >> 16;
                k += (k1 & 0xff00) >> 8;
                l += k1 & 0xff;
            }

        }

        return (j / 9 & 0xff) << 16 | (k / 9 & 0xff) << 8 | l / 9 & 0xff;
    }

    public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_)
    {
        int i = 1;
        int j = i + 1;
        if(p_71852_1_.func_72904_c(p_71852_2_ - j, p_71852_3_ - j, p_71852_4_ - j, p_71852_2_ + j, p_71852_3_ + j, p_71852_4_ + j))
        {
            for(int k = -i; k <= i; k++)
            {
                for(int l = -i; l <= i; l++)
                {
                    for(int i1 = -i; i1 <= i; i1++)
                    {
                        int j1 = p_71852_1_.func_72798_a(p_71852_2_ + k, p_71852_3_ + l, p_71852_4_ + i1);
                        if(j1 == Block.field_71952_K.field_71990_ca)
                        {
                            int k1 = p_71852_1_.func_72805_g(p_71852_2_ + k, p_71852_3_ + l, p_71852_4_ + i1);
                            p_71852_1_.func_72881_d(p_71852_2_ + k, p_71852_3_ + l, p_71852_4_ + i1, k1 | 8);
                        }
                    }

                }

            }

        }
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_)
    {
        if(p_71847_1_.field_72995_K)
        {
            return;
        }
        int i = p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_);
        if((i & 8) != 0 && (i & 4) == 0)
        {
            byte byte0 = 4;
            int j = byte0 + 1;
            byte byte1 = 32;
            int k = byte1 * byte1;
            int l = byte1 / 2;
            if(field_72135_b == null)
            {
                field_72135_b = new int[byte1 * byte1 * byte1];
            }
            if(p_71847_1_.func_72904_c(p_71847_2_ - j, p_71847_3_ - j, p_71847_4_ - j, p_71847_2_ + j, p_71847_3_ + j, p_71847_4_ + j))
            {
                for(int i1 = -byte0; i1 <= byte0; i1++)
                {
                    for(int l1 = -byte0; l1 <= byte0; l1++)
                    {
                        for(int j2 = -byte0; j2 <= byte0; j2++)
                        {
                            int l2 = p_71847_1_.func_72798_a(p_71847_2_ + i1, p_71847_3_ + l1, p_71847_4_ + j2);
                            if(l2 == Block.field_71951_J.field_71990_ca)
                            {
                                field_72135_b[(i1 + l) * k + (l1 + l) * byte1 + (j2 + l)] = 0;
                                continue;
                            }
                            if(l2 == Block.field_71952_K.field_71990_ca)
                            {
                                field_72135_b[(i1 + l) * k + (l1 + l) * byte1 + (j2 + l)] = -2;
                            } else
                            {
                                field_72135_b[(i1 + l) * k + (l1 + l) * byte1 + (j2 + l)] = -1;
                            }
                        }

                    }

                }

                for(int j1 = 1; j1 <= 4; j1++)
                {
                    for(int i2 = -byte0; i2 <= byte0; i2++)
                    {
                        for(int k2 = -byte0; k2 <= byte0; k2++)
                        {
                            for(int i3 = -byte0; i3 <= byte0; i3++)
                            {
                                if(field_72135_b[(i2 + l) * k + (k2 + l) * byte1 + (i3 + l)] != j1 - 1)
                                {
                                    continue;
                                }
                                if(field_72135_b[((i2 + l) - 1) * k + (k2 + l) * byte1 + (i3 + l)] == -2)
                                {
                                    field_72135_b[((i2 + l) - 1) * k + (k2 + l) * byte1 + (i3 + l)] = j1;
                                }
                                if(field_72135_b[(i2 + l + 1) * k + (k2 + l) * byte1 + (i3 + l)] == -2)
                                {
                                    field_72135_b[(i2 + l + 1) * k + (k2 + l) * byte1 + (i3 + l)] = j1;
                                }
                                if(field_72135_b[(i2 + l) * k + ((k2 + l) - 1) * byte1 + (i3 + l)] == -2)
                                {
                                    field_72135_b[(i2 + l) * k + ((k2 + l) - 1) * byte1 + (i3 + l)] = j1;
                                }
                                if(field_72135_b[(i2 + l) * k + (k2 + l + 1) * byte1 + (i3 + l)] == -2)
                                {
                                    field_72135_b[(i2 + l) * k + (k2 + l + 1) * byte1 + (i3 + l)] = j1;
                                }
                                if(field_72135_b[(i2 + l) * k + (k2 + l) * byte1 + ((i3 + l) - 1)] == -2)
                                {
                                    field_72135_b[(i2 + l) * k + (k2 + l) * byte1 + ((i3 + l) - 1)] = j1;
                                }
                                if(field_72135_b[(i2 + l) * k + (k2 + l) * byte1 + (i3 + l + 1)] == -2)
                                {
                                    field_72135_b[(i2 + l) * k + (k2 + l) * byte1 + (i3 + l + 1)] = j1;
                                }
                            }

                        }

                    }

                }

            }
            int k1 = field_72135_b[l * k + l * byte1 + l];
            if(k1 >= 0)
            {
                p_71847_1_.func_72881_d(p_71847_2_, p_71847_3_, p_71847_4_, i & -9);
            } else
            {
                func_72132_l(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_);
            }
        }
    }

    public void func_71862_a(World p_71862_1_, int p_71862_2_, int p_71862_3_, int p_71862_4_, Random p_71862_5_)
    {
        if(p_71862_1_.func_72951_B(p_71862_2_, p_71862_3_ + 1, p_71862_4_) && !p_71862_1_.func_72797_t(p_71862_2_, p_71862_3_ - 1, p_71862_4_) && p_71862_5_.nextInt(15) == 1)
        {
            double d = (float)p_71862_2_ + p_71862_5_.nextFloat();
            double d1 = (double)p_71862_3_ - 0.050000000000000003D;
            double d2 = (float)p_71862_4_ + p_71862_5_.nextFloat();
            p_71862_1_.func_72869_a("dripWater", d, d1, d2, 0.0D, 0.0D, 0.0D);
        }
    }

    private void func_72132_l(World p_72132_1_, int p_72132_2_, int p_72132_3_, int p_72132_4_)
    {
        func_71897_c(p_72132_1_, p_72132_2_, p_72132_3_, p_72132_4_, p_72132_1_.func_72805_g(p_72132_2_, p_72132_3_, p_72132_4_), 0);
        p_72132_1_.func_72859_e(p_72132_2_, p_72132_3_, p_72132_4_, 0);
    }

    public int func_71925_a(Random p_71925_1_)
    {
        return p_71925_1_.nextInt(20) != 0 ? 0 : 1;
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        return Block.field_71987_y.field_71990_ca;
    }

    public void func_71914_a(World p_71914_1_, int p_71914_2_, int p_71914_3_, int p_71914_4_, int p_71914_5_, float p_71914_6_, int p_71914_7_)
    {
        if(!p_71914_1_.field_72995_K)
        {
            byte byte0 = 20;
            if((p_71914_5_ & 3) == 3)
            {
                byte0 = 40;
            }
            if(p_71914_1_.field_73012_v.nextInt(byte0) == 0)
            {
                int i = func_71885_a(p_71914_5_, p_71914_1_.field_73012_v, p_71914_7_);
                func_71929_a(p_71914_1_, p_71914_2_, p_71914_3_, p_71914_4_, new ItemStack(i, 1, func_71899_b(p_71914_5_)));
            }
            if((p_71914_5_ & 3) == 0 && p_71914_1_.field_73012_v.nextInt(200) == 0)
            {
                func_71929_a(p_71914_1_, p_71914_2_, p_71914_3_, p_71914_4_, new ItemStack(Item.field_77706_j, 1, 0));
            }
        }
    }

    public void func_71893_a(World p_71893_1_, EntityPlayer p_71893_2_, int p_71893_3_, int p_71893_4_, int p_71893_5_, int p_71893_6_)
    {
        if(!p_71893_1_.field_72995_K && p_71893_2_.func_71045_bC() != null && p_71893_2_.func_71045_bC().field_77993_c == Item.field_77745_be.field_77779_bT)
        {
            p_71893_2_.func_71064_a(StatList.field_75934_C[field_71990_ca], 1);
            func_71929_a(p_71893_1_, p_71893_3_, p_71893_4_, p_71893_5_, new ItemStack(Block.field_71952_K.field_71990_ca, 1, p_71893_6_ & 3));
        } else
        {
            super.func_71893_a(p_71893_1_, p_71893_2_, p_71893_3_, p_71893_4_, p_71893_5_, p_71893_6_);
        }
    }

    protected int func_71899_b(int p_71899_1_)
    {
        return p_71899_1_ & 3;
    }

    public boolean func_71926_d()
    {
        return !field_72131_c;
    }

    public int func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        if((p_71858_2_ & 3) == 1)
        {
            return field_72059_bZ + 80;
        }
        if((p_71858_2_ & 3) == 3)
        {
            return field_72059_bZ + 144;
        } else
        {
            return field_72059_bZ;
        }
    }

    public void func_72133_a(boolean p_72133_1_)
    {
        field_72131_c = p_72133_1_;
        field_72059_bZ = field_72134_cr + (p_72133_1_ ? 0 : 1);
    }

    public void func_71879_a(int p_71879_1_, CreativeTabs p_71879_2_, List p_71879_3_)
    {
        p_71879_3_.add(new ItemStack(p_71879_1_, 1, 0));
        p_71879_3_.add(new ItemStack(p_71879_1_, 1, 1));
        p_71879_3_.add(new ItemStack(p_71879_1_, 1, 2));
        p_71879_3_.add(new ItemStack(p_71879_1_, 1, 3));
    }

}
