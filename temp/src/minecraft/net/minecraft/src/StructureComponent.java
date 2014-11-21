// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            StructureBoundingBox, ChunkPosition, World, Block, 
//            Material, BlockTripWireSource, BlockDirectional, Direction, 
//            Facing, StructurePieceBlockSelector, TileEntityChest, WeightedRandomChestContent, 
//            TileEntityDispenser, ItemDoor

public abstract class StructureComponent
{

    protected StructureBoundingBox field_74887_e;
    protected int field_74885_f;
    protected int field_74886_g;

    protected StructureComponent(int p_i3857_1_)
    {
        field_74886_g = p_i3857_1_;
        field_74885_f = -1;
    }

    public void func_74861_a(StructureComponent structurecomponent, List list, Random random)
    {
    }

    public abstract boolean func_74875_a(World world, Random random, StructureBoundingBox structureboundingbox);

    public StructureBoundingBox func_74874_b()
    {
        return field_74887_e;
    }

    public int func_74877_c()
    {
        return field_74886_g;
    }

    public static StructureComponent func_74883_a(List p_74883_0_, StructureBoundingBox p_74883_1_)
    {
        for(Iterator iterator = p_74883_0_.iterator(); iterator.hasNext();)
        {
            StructureComponent structurecomponent = (StructureComponent)iterator.next();
            if(structurecomponent.func_74874_b() != null && structurecomponent.func_74874_b().func_78884_a(p_74883_1_))
            {
                return structurecomponent;
            }
        }

        return null;
    }

    public ChunkPosition func_74868_a()
    {
        return new ChunkPosition(field_74887_e.func_78881_e(), field_74887_e.func_78879_f(), field_74887_e.func_78891_g());
    }

    protected boolean func_74860_a(World p_74860_1_, StructureBoundingBox p_74860_2_)
    {
        int i = Math.max(field_74887_e.field_78897_a - 1, p_74860_2_.field_78897_a);
        int j = Math.max(field_74887_e.field_78895_b - 1, p_74860_2_.field_78895_b);
        int k = Math.max(field_74887_e.field_78896_c - 1, p_74860_2_.field_78896_c);
        int l = Math.min(field_74887_e.field_78893_d + 1, p_74860_2_.field_78893_d);
        int i1 = Math.min(field_74887_e.field_78894_e + 1, p_74860_2_.field_78894_e);
        int j1 = Math.min(field_74887_e.field_78892_f + 1, p_74860_2_.field_78892_f);
        for(int k1 = i; k1 <= l; k1++)
        {
            for(int j2 = k; j2 <= j1; j2++)
            {
                int i3 = p_74860_1_.func_72798_a(k1, j, j2);
                if(i3 > 0 && Block.field_71973_m[i3].field_72018_cp.func_76224_d())
                {
                    return true;
                }
                i3 = p_74860_1_.func_72798_a(k1, i1, j2);
                if(i3 > 0 && Block.field_71973_m[i3].field_72018_cp.func_76224_d())
                {
                    return true;
                }
            }

        }

        for(int l1 = i; l1 <= l; l1++)
        {
            for(int k2 = j; k2 <= i1; k2++)
            {
                int j3 = p_74860_1_.func_72798_a(l1, k2, k);
                if(j3 > 0 && Block.field_71973_m[j3].field_72018_cp.func_76224_d())
                {
                    return true;
                }
                j3 = p_74860_1_.func_72798_a(l1, k2, j1);
                if(j3 > 0 && Block.field_71973_m[j3].field_72018_cp.func_76224_d())
                {
                    return true;
                }
            }

        }

        for(int i2 = k; i2 <= j1; i2++)
        {
            for(int l2 = j; l2 <= i1; l2++)
            {
                int k3 = p_74860_1_.func_72798_a(i, l2, i2);
                if(k3 > 0 && Block.field_71973_m[k3].field_72018_cp.func_76224_d())
                {
                    return true;
                }
                k3 = p_74860_1_.func_72798_a(l, l2, i2);
                if(k3 > 0 && Block.field_71973_m[k3].field_72018_cp.func_76224_d())
                {
                    return true;
                }
            }

        }

        return false;
    }

    protected int func_74865_a(int p_74865_1_, int p_74865_2_)
    {
        switch(field_74885_f)
        {
        case 0: // '\0'
        case 2: // '\002'
            return field_74887_e.field_78897_a + p_74865_1_;

        case 1: // '\001'
            return field_74887_e.field_78893_d - p_74865_2_;

        case 3: // '\003'
            return field_74887_e.field_78897_a + p_74865_2_;
        }
        return p_74865_1_;
    }

    protected int func_74862_a(int p_74862_1_)
    {
        if(field_74885_f == -1)
        {
            return p_74862_1_;
        } else
        {
            return p_74862_1_ + field_74887_e.field_78895_b;
        }
    }

    protected int func_74873_b(int p_74873_1_, int p_74873_2_)
    {
        switch(field_74885_f)
        {
        case 2: // '\002'
            return field_74887_e.field_78892_f - p_74873_2_;

        case 0: // '\0'
            return field_74887_e.field_78896_c + p_74873_2_;

        case 1: // '\001'
        case 3: // '\003'
            return field_74887_e.field_78896_c + p_74873_1_;
        }
        return p_74873_2_;
    }

    protected int func_74863_c(int p_74863_1_, int p_74863_2_)
    {
        if(p_74863_1_ == Block.field_72056_aG.field_71990_ca)
        {
            if(field_74885_f == 1 || field_74885_f == 3)
            {
                return p_74863_2_ != 1 ? 1 : 0;
            }
        } else
        if(p_74863_1_ == Block.field_72054_aE.field_71990_ca || p_74863_1_ == Block.field_72045_aL.field_71990_ca)
        {
            if(field_74885_f == 0)
            {
                if(p_74863_2_ == 0)
                {
                    return 2;
                }
                if(p_74863_2_ == 2)
                {
                    return 0;
                }
            } else
            {
                if(field_74885_f == 1)
                {
                    return p_74863_2_ + 1 & 3;
                }
                if(field_74885_f == 3)
                {
                    return p_74863_2_ + 3 & 3;
                }
            }
        } else
        if(p_74863_1_ == Block.field_72057_aH.field_71990_ca || p_74863_1_ == Block.field_72063_at.field_71990_ca || p_74863_1_ == Block.field_72100_bC.field_71990_ca || p_74863_1_ == Block.field_71995_bx.field_71990_ca || p_74863_1_ == Block.field_72088_bQ.field_71990_ca)
        {
            if(field_74885_f == 0)
            {
                if(p_74863_2_ == 2)
                {
                    return 3;
                }
                if(p_74863_2_ == 3)
                {
                    return 2;
                }
            } else
            if(field_74885_f == 1)
            {
                if(p_74863_2_ == 0)
                {
                    return 2;
                }
                if(p_74863_2_ == 1)
                {
                    return 3;
                }
                if(p_74863_2_ == 2)
                {
                    return 0;
                }
                if(p_74863_2_ == 3)
                {
                    return 1;
                }
            } else
            if(field_74885_f == 3)
            {
                if(p_74863_2_ == 0)
                {
                    return 2;
                }
                if(p_74863_2_ == 1)
                {
                    return 3;
                }
                if(p_74863_2_ == 2)
                {
                    return 1;
                }
                if(p_74863_2_ == 3)
                {
                    return 0;
                }
            }
        } else
        if(p_74863_1_ == Block.field_72055_aF.field_71990_ca)
        {
            if(field_74885_f == 0)
            {
                if(p_74863_2_ == 2)
                {
                    return 3;
                }
                if(p_74863_2_ == 3)
                {
                    return 2;
                }
            } else
            if(field_74885_f == 1)
            {
                if(p_74863_2_ == 2)
                {
                    return 4;
                }
                if(p_74863_2_ == 3)
                {
                    return 5;
                }
                if(p_74863_2_ == 4)
                {
                    return 2;
                }
                if(p_74863_2_ == 5)
                {
                    return 3;
                }
            } else
            if(field_74885_f == 3)
            {
                if(p_74863_2_ == 2)
                {
                    return 5;
                }
                if(p_74863_2_ == 3)
                {
                    return 4;
                }
                if(p_74863_2_ == 4)
                {
                    return 2;
                }
                if(p_74863_2_ == 5)
                {
                    return 3;
                }
            }
        } else
        if(p_74863_1_ == Block.field_72034_aR.field_71990_ca)
        {
            if(field_74885_f == 0)
            {
                if(p_74863_2_ == 3)
                {
                    return 4;
                }
                if(p_74863_2_ == 4)
                {
                    return 3;
                }
            } else
            if(field_74885_f == 1)
            {
                if(p_74863_2_ == 3)
                {
                    return 1;
                }
                if(p_74863_2_ == 4)
                {
                    return 2;
                }
                if(p_74863_2_ == 2)
                {
                    return 3;
                }
                if(p_74863_2_ == 1)
                {
                    return 4;
                }
            } else
            if(field_74885_f == 3)
            {
                if(p_74863_2_ == 3)
                {
                    return 2;
                }
                if(p_74863_2_ == 4)
                {
                    return 1;
                }
                if(p_74863_2_ == 2)
                {
                    return 3;
                }
                if(p_74863_2_ == 1)
                {
                    return 4;
                }
            }
        } else
        if(p_74863_1_ == Block.field_72064_bT.field_71990_ca || Block.field_71973_m[p_74863_1_] != null && (Block.field_71973_m[p_74863_1_] instanceof BlockDirectional))
        {
            if(field_74885_f == 0)
            {
                if(p_74863_2_ == 0 || p_74863_2_ == 2)
                {
                    return Direction.field_71580_e[p_74863_2_];
                }
            } else
            if(field_74885_f == 1)
            {
                if(p_74863_2_ == 2)
                {
                    return 1;
                }
                if(p_74863_2_ == 0)
                {
                    return 3;
                }
                if(p_74863_2_ == 1)
                {
                    return 2;
                }
                if(p_74863_2_ == 3)
                {
                    return 0;
                }
            } else
            if(field_74885_f == 3)
            {
                if(p_74863_2_ == 2)
                {
                    return 3;
                }
                if(p_74863_2_ == 0)
                {
                    return 1;
                }
                if(p_74863_2_ == 1)
                {
                    return 2;
                }
                if(p_74863_2_ == 3)
                {
                    return 0;
                }
            }
        } else
        if(p_74863_1_ == Block.field_71963_Z.field_71990_ca || p_74863_1_ == Block.field_71956_V.field_71990_ca || p_74863_1_ == Block.field_72043_aJ.field_71990_ca || p_74863_1_ == Block.field_71958_P.field_71990_ca)
        {
            if(field_74885_f == 0)
            {
                if(p_74863_2_ == 2 || p_74863_2_ == 3)
                {
                    return Facing.field_71588_a[p_74863_2_];
                }
            } else
            if(field_74885_f == 1)
            {
                if(p_74863_2_ == 2)
                {
                    return 4;
                }
                if(p_74863_2_ == 3)
                {
                    return 5;
                }
                if(p_74863_2_ == 4)
                {
                    return 2;
                }
                if(p_74863_2_ == 5)
                {
                    return 3;
                }
            } else
            if(field_74885_f == 3)
            {
                if(p_74863_2_ == 2)
                {
                    return 5;
                }
                if(p_74863_2_ == 3)
                {
                    return 4;
                }
                if(p_74863_2_ == 4)
                {
                    return 2;
                }
                if(p_74863_2_ == 5)
                {
                    return 3;
                }
            }
        }
        return p_74863_2_;
    }

    protected void func_74864_a(World p_74864_1_, int p_74864_2_, int p_74864_3_, int p_74864_4_, int p_74864_5_, int p_74864_6_, StructureBoundingBox p_74864_7_)
    {
        int i = func_74865_a(p_74864_4_, p_74864_6_);
        int j = func_74862_a(p_74864_5_);
        int k = func_74873_b(p_74864_4_, p_74864_6_);
        if(!p_74864_7_.func_78890_b(i, j, k))
        {
            return;
        } else
        {
            p_74864_1_.func_72961_c(i, j, k, p_74864_2_, p_74864_3_);
            return;
        }
    }

    protected int func_74866_a(World p_74866_1_, int p_74866_2_, int p_74866_3_, int p_74866_4_, StructureBoundingBox p_74866_5_)
    {
        int i = func_74865_a(p_74866_2_, p_74866_4_);
        int j = func_74862_a(p_74866_3_);
        int k = func_74873_b(p_74866_2_, p_74866_4_);
        if(!p_74866_5_.func_78890_b(i, j, k))
        {
            return 0;
        } else
        {
            return p_74866_1_.func_72798_a(i, j, k);
        }
    }

    protected void func_74878_a(World p_74878_1_, StructureBoundingBox p_74878_2_, int p_74878_3_, int p_74878_4_, int p_74878_5_, int p_74878_6_, int p_74878_7_, 
            int p_74878_8_)
    {
        for(int i = p_74878_4_; i <= p_74878_7_; i++)
        {
            for(int j = p_74878_3_; j <= p_74878_6_; j++)
            {
                for(int k = p_74878_5_; k <= p_74878_8_; k++)
                {
                    func_74864_a(p_74878_1_, 0, 0, j, i, k, p_74878_2_);
                }

            }

        }

    }

    protected void func_74884_a(World p_74884_1_, StructureBoundingBox p_74884_2_, int p_74884_3_, int p_74884_4_, int p_74884_5_, int p_74884_6_, int p_74884_7_, 
            int p_74884_8_, int p_74884_9_, int p_74884_10_, boolean p_74884_11_)
    {
        for(int i = p_74884_4_; i <= p_74884_7_; i++)
        {
            for(int j = p_74884_3_; j <= p_74884_6_; j++)
            {
                for(int k = p_74884_5_; k <= p_74884_8_; k++)
                {
                    if(p_74884_11_ && func_74866_a(p_74884_1_, j, i, k, p_74884_2_) == 0)
                    {
                        continue;
                    }
                    if(i == p_74884_4_ || i == p_74884_7_ || j == p_74884_3_ || j == p_74884_6_ || k == p_74884_5_ || k == p_74884_8_)
                    {
                        func_74864_a(p_74884_1_, p_74884_9_, 0, j, i, k, p_74884_2_);
                    } else
                    {
                        func_74864_a(p_74884_1_, p_74884_10_, 0, j, i, k, p_74884_2_);
                    }
                }

            }

        }

    }

    protected void func_74872_a(World p_74872_1_, StructureBoundingBox p_74872_2_, int p_74872_3_, int p_74872_4_, int p_74872_5_, int p_74872_6_, int p_74872_7_, 
            int p_74872_8_, int p_74872_9_, int p_74872_10_, int p_74872_11_, int p_74872_12_, boolean p_74872_13_)
    {
        for(int i = p_74872_4_; i <= p_74872_7_; i++)
        {
            for(int j = p_74872_3_; j <= p_74872_6_; j++)
            {
                for(int k = p_74872_5_; k <= p_74872_8_; k++)
                {
                    if(p_74872_13_ && func_74866_a(p_74872_1_, j, i, k, p_74872_2_) == 0)
                    {
                        continue;
                    }
                    if(i == p_74872_4_ || i == p_74872_7_ || j == p_74872_3_ || j == p_74872_6_ || k == p_74872_5_ || k == p_74872_8_)
                    {
                        func_74864_a(p_74872_1_, p_74872_9_, p_74872_10_, j, i, k, p_74872_2_);
                    } else
                    {
                        func_74864_a(p_74872_1_, p_74872_11_, p_74872_12_, j, i, k, p_74872_2_);
                    }
                }

            }

        }

    }

    protected void func_74882_a(World p_74882_1_, StructureBoundingBox p_74882_2_, int p_74882_3_, int p_74882_4_, int p_74882_5_, int p_74882_6_, int p_74882_7_, 
            int p_74882_8_, boolean p_74882_9_, Random p_74882_10_, StructurePieceBlockSelector p_74882_11_)
    {
        for(int i = p_74882_4_; i <= p_74882_7_; i++)
        {
            for(int j = p_74882_3_; j <= p_74882_6_; j++)
            {
                for(int k = p_74882_5_; k <= p_74882_8_; k++)
                {
                    if(!p_74882_9_ || func_74866_a(p_74882_1_, j, i, k, p_74882_2_) != 0)
                    {
                        p_74882_11_.func_75062_a(p_74882_10_, j, i, k, i == p_74882_4_ || i == p_74882_7_ || j == p_74882_3_ || j == p_74882_6_ || k == p_74882_5_ || k == p_74882_8_);
                        func_74864_a(p_74882_1_, p_74882_11_.func_75063_a(), p_74882_11_.func_75064_b(), j, i, k, p_74882_2_);
                    }
                }

            }

        }

    }

    protected void func_74880_a(World p_74880_1_, StructureBoundingBox p_74880_2_, Random p_74880_3_, float p_74880_4_, int p_74880_5_, int p_74880_6_, int p_74880_7_, 
            int p_74880_8_, int p_74880_9_, int p_74880_10_, int p_74880_11_, int p_74880_12_, boolean p_74880_13_)
    {
        for(int i = p_74880_6_; i <= p_74880_9_; i++)
        {
            for(int j = p_74880_5_; j <= p_74880_8_; j++)
            {
                for(int k = p_74880_7_; k <= p_74880_10_; k++)
                {
                    if(p_74880_3_.nextFloat() > p_74880_4_ || p_74880_13_ && func_74866_a(p_74880_1_, j, i, k, p_74880_2_) == 0)
                    {
                        continue;
                    }
                    if(i == p_74880_6_ || i == p_74880_9_ || j == p_74880_5_ || j == p_74880_8_ || k == p_74880_7_ || k == p_74880_10_)
                    {
                        func_74864_a(p_74880_1_, p_74880_11_, 0, j, i, k, p_74880_2_);
                    } else
                    {
                        func_74864_a(p_74880_1_, p_74880_12_, 0, j, i, k, p_74880_2_);
                    }
                }

            }

        }

    }

    protected void func_74876_a(World p_74876_1_, StructureBoundingBox p_74876_2_, Random p_74876_3_, float p_74876_4_, int p_74876_5_, int p_74876_6_, int p_74876_7_, 
            int p_74876_8_, int p_74876_9_)
    {
        if(p_74876_3_.nextFloat() < p_74876_4_)
        {
            func_74864_a(p_74876_1_, p_74876_8_, p_74876_9_, p_74876_5_, p_74876_6_, p_74876_7_, p_74876_2_);
        }
    }

    protected void func_74867_a(World p_74867_1_, StructureBoundingBox p_74867_2_, int p_74867_3_, int p_74867_4_, int p_74867_5_, int p_74867_6_, int p_74867_7_, 
            int p_74867_8_, int p_74867_9_, boolean p_74867_10_)
    {
        float f = (p_74867_6_ - p_74867_3_) + 1;
        float f1 = (p_74867_7_ - p_74867_4_) + 1;
        float f2 = (p_74867_8_ - p_74867_5_) + 1;
        float f3 = (float)p_74867_3_ + f / 2.0F;
        float f4 = (float)p_74867_5_ + f2 / 2.0F;
        for(int i = p_74867_4_; i <= p_74867_7_; i++)
        {
            float f5 = (float)(i - p_74867_4_) / f1;
            for(int j = p_74867_3_; j <= p_74867_6_; j++)
            {
                float f6 = ((float)j - f3) / (f * 0.5F);
                for(int k = p_74867_5_; k <= p_74867_8_; k++)
                {
                    float f7 = ((float)k - f4) / (f2 * 0.5F);
                    if(p_74867_10_ && func_74866_a(p_74867_1_, j, i, k, p_74867_2_) == 0)
                    {
                        continue;
                    }
                    float f8 = f6 * f6 + f5 * f5 + f7 * f7;
                    if(f8 <= 1.05F)
                    {
                        func_74864_a(p_74867_1_, p_74867_9_, 0, j, i, k, p_74867_2_);
                    }
                }

            }

        }

    }

    protected void func_74871_b(World p_74871_1_, int p_74871_2_, int p_74871_3_, int p_74871_4_, StructureBoundingBox p_74871_5_)
    {
        int i = func_74865_a(p_74871_2_, p_74871_4_);
        int j = func_74862_a(p_74871_3_);
        int k = func_74873_b(p_74871_2_, p_74871_4_);
        if(!p_74871_5_.func_78890_b(i, j, k))
        {
            return;
        }
        for(; !p_74871_1_.func_72799_c(i, j, k) && j < 255; j++)
        {
            p_74871_1_.func_72961_c(i, j, k, 0, 0);
        }

    }

    protected void func_74870_b(World p_74870_1_, int p_74870_2_, int p_74870_3_, int p_74870_4_, int p_74870_5_, int p_74870_6_, StructureBoundingBox p_74870_7_)
    {
        int i = func_74865_a(p_74870_4_, p_74870_6_);
        int j = func_74862_a(p_74870_5_);
        int k = func_74873_b(p_74870_4_, p_74870_6_);
        if(!p_74870_7_.func_78890_b(i, j, k))
        {
            return;
        }
        for(; (p_74870_1_.func_72799_c(i, j, k) || p_74870_1_.func_72803_f(i, j, k).func_76224_d()) && j > 1; j--)
        {
            p_74870_1_.func_72961_c(i, j, k, p_74870_2_, p_74870_3_);
        }

    }

    protected boolean func_74879_a(World p_74879_1_, StructureBoundingBox p_74879_2_, Random p_74879_3_, int p_74879_4_, int p_74879_5_, int p_74879_6_, WeightedRandomChestContent p_74879_7_[], 
            int p_74879_8_)
    {
        int i = func_74865_a(p_74879_4_, p_74879_6_);
        int j = func_74862_a(p_74879_5_);
        int k = func_74873_b(p_74879_4_, p_74879_6_);
        if(p_74879_2_.func_78890_b(i, j, k) && p_74879_1_.func_72798_a(i, j, k) != Block.field_72077_au.field_71990_ca)
        {
            p_74879_1_.func_72859_e(i, j, k, Block.field_72077_au.field_71990_ca);
            TileEntityChest tileentitychest = (TileEntityChest)p_74879_1_.func_72796_p(i, j, k);
            if(tileentitychest != null)
            {
                WeightedRandomChestContent.func_76293_a(p_74879_3_, p_74879_7_, tileentitychest, p_74879_8_);
            }
            return true;
        } else
        {
            return false;
        }
    }

    protected boolean func_74869_a(World p_74869_1_, StructureBoundingBox p_74869_2_, Random p_74869_3_, int p_74869_4_, int p_74869_5_, int p_74869_6_, int p_74869_7_, 
            WeightedRandomChestContent p_74869_8_[], int p_74869_9_)
    {
        int i = func_74865_a(p_74869_4_, p_74869_6_);
        int j = func_74862_a(p_74869_5_);
        int k = func_74873_b(p_74869_4_, p_74869_6_);
        if(p_74869_2_.func_78890_b(i, j, k) && p_74869_1_.func_72798_a(i, j, k) != Block.field_71958_P.field_71990_ca)
        {
            p_74869_1_.func_72832_d(i, j, k, Block.field_71958_P.field_71990_ca, func_74863_c(Block.field_71958_P.field_71990_ca, p_74869_7_));
            TileEntityDispenser tileentitydispenser = (TileEntityDispenser)p_74869_1_.func_72796_p(i, j, k);
            if(tileentitydispenser != null)
            {
                WeightedRandomChestContent.func_76294_a(p_74869_3_, p_74869_8_, tileentitydispenser, p_74869_9_);
            }
            return true;
        } else
        {
            return false;
        }
    }

    protected void func_74881_a(World p_74881_1_, StructureBoundingBox p_74881_2_, Random p_74881_3_, int p_74881_4_, int p_74881_5_, int p_74881_6_, int p_74881_7_)
    {
        int i = func_74865_a(p_74881_4_, p_74881_6_);
        int j = func_74862_a(p_74881_5_);
        int k = func_74873_b(p_74881_4_, p_74881_6_);
        if(p_74881_2_.func_78890_b(i, j, k))
        {
            ItemDoor.func_77869_a(p_74881_1_, i, j, k, p_74881_7_, Block.field_72054_aE);
        }
    }
}
