// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            BlockDirectional, Material, World, WorldProvider, 
//            EntityPlayer, ChunkCoordinates, EnumStatus, Block, 
//            Direction, Item, IBlockAccess

public class BlockBed extends BlockDirectional
{

    public static final int field_72230_a[][] = {
        {
            0, 1
        }, {
            -1, 0
        }, {
            0, -1
        }, {
            1, 0
        }
    };

    public BlockBed(int p_i3919_1_)
    {
        super(p_i3919_1_, 134, Material.field_76253_m);
        func_72227_n();
    }

    public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, 
            float p_71903_8_, float p_71903_9_)
    {
        if(p_71903_1_.field_72995_K)
        {
            return true;
        }
        int i = p_71903_1_.func_72805_g(p_71903_2_, p_71903_3_, p_71903_4_);
        if(!func_72229_a_(i))
        {
            int j = func_72217_d(i);
            p_71903_2_ += field_72230_a[j][0];
            p_71903_4_ += field_72230_a[j][1];
            if(p_71903_1_.func_72798_a(p_71903_2_, p_71903_3_, p_71903_4_) != field_71990_ca)
            {
                return true;
            }
            i = p_71903_1_.func_72805_g(p_71903_2_, p_71903_3_, p_71903_4_);
        }
        if(!p_71903_1_.field_73011_w.func_76567_e())
        {
            double d = (double)p_71903_2_ + 0.5D;
            double d1 = (double)p_71903_3_ + 0.5D;
            double d2 = (double)p_71903_4_ + 0.5D;
            p_71903_1_.func_72859_e(p_71903_2_, p_71903_3_, p_71903_4_, 0);
            int k = func_72217_d(i);
            p_71903_2_ += field_72230_a[k][0];
            p_71903_4_ += field_72230_a[k][1];
            if(p_71903_1_.func_72798_a(p_71903_2_, p_71903_3_, p_71903_4_) == field_71990_ca)
            {
                p_71903_1_.func_72859_e(p_71903_2_, p_71903_3_, p_71903_4_, 0);
                d = (d + (double)p_71903_2_ + 0.5D) / 2D;
                d1 = (d1 + (double)p_71903_3_ + 0.5D) / 2D;
                d2 = (d2 + (double)p_71903_4_ + 0.5D) / 2D;
            }
            p_71903_1_.func_72885_a(null, (float)p_71903_2_ + 0.5F, (float)p_71903_3_ + 0.5F, (float)p_71903_4_ + 0.5F, 5F, true);
            return true;
        }
        if(func_72225_b_(i))
        {
            EntityPlayer entityplayer = null;
            Iterator iterator = p_71903_1_.field_73010_i.iterator();
            do
            {
                if(!iterator.hasNext())
                {
                    break;
                }
                EntityPlayer entityplayer1 = (EntityPlayer)iterator.next();
                if(entityplayer1.func_70608_bn())
                {
                    ChunkCoordinates chunkcoordinates = entityplayer1.field_71081_bT;
                    if(chunkcoordinates.field_71574_a == p_71903_2_ && chunkcoordinates.field_71572_b == p_71903_3_ && chunkcoordinates.field_71573_c == p_71903_4_)
                    {
                        entityplayer = entityplayer1;
                    }
                }
            } while(true);
            if(entityplayer == null)
            {
                func_72228_a(p_71903_1_, p_71903_2_, p_71903_3_, p_71903_4_, false);
            } else
            {
                p_71903_5_.func_71035_c("tile.bed.occupied");
                return true;
            }
        }
        EnumStatus enumstatus = p_71903_5_.func_71018_a(p_71903_2_, p_71903_3_, p_71903_4_);
        if(enumstatus == EnumStatus.OK)
        {
            func_72228_a(p_71903_1_, p_71903_2_, p_71903_3_, p_71903_4_, true);
            return true;
        }
        if(enumstatus == EnumStatus.NOT_POSSIBLE_NOW)
        {
            p_71903_5_.func_71035_c("tile.bed.noSleep");
        } else
        if(enumstatus == EnumStatus.NOT_SAFE)
        {
            p_71903_5_.func_71035_c("tile.bed.notSafe");
        }
        return true;
    }

    public int func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        if(p_71858_1_ == 0)
        {
            return Block.field_71988_x.field_72059_bZ;
        }
        int i = func_72217_d(p_71858_2_);
        int j = Direction.field_71584_h[i][p_71858_1_];
        if(func_72229_a_(p_71858_2_))
        {
            if(j == 2)
            {
                return field_72059_bZ + 2 + 16;
            }
            if(j == 5 || j == 4)
            {
                return field_72059_bZ + 1 + 16;
            } else
            {
                return field_72059_bZ + 1;
            }
        }
        if(j == 3)
        {
            return (field_72059_bZ - 1) + 16;
        }
        if(j == 5 || j == 4)
        {
            return field_72059_bZ + 16;
        } else
        {
            return field_72059_bZ;
        }
    }

    public int func_71857_b()
    {
        return 14;
    }

    public boolean func_71886_c()
    {
        return false;
    }

    public boolean func_71926_d()
    {
        return false;
    }

    public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_)
    {
        func_72227_n();
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        int i = p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_);
        int j = func_72217_d(i);
        if(func_72229_a_(i))
        {
            if(p_71863_1_.func_72798_a(p_71863_2_ - field_72230_a[j][0], p_71863_3_, p_71863_4_ - field_72230_a[j][1]) != field_71990_ca)
            {
                p_71863_1_.func_72859_e(p_71863_2_, p_71863_3_, p_71863_4_, 0);
            }
        } else
        if(p_71863_1_.func_72798_a(p_71863_2_ + field_72230_a[j][0], p_71863_3_, p_71863_4_ + field_72230_a[j][1]) != field_71990_ca)
        {
            p_71863_1_.func_72859_e(p_71863_2_, p_71863_3_, p_71863_4_, 0);
            if(!p_71863_1_.field_72995_K)
            {
                func_71897_c(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, i, 0);
            }
        }
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        if(func_72229_a_(p_71885_1_))
        {
            return 0;
        } else
        {
            return Item.field_77776_ba.field_77779_bT;
        }
    }

    private void func_72227_n()
    {
        func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5625F, 1.0F);
    }

    public static boolean func_72229_a_(int p_72229_0_)
    {
        return (p_72229_0_ & 8) != 0;
    }

    public static boolean func_72225_b_(int p_72225_0_)
    {
        return (p_72225_0_ & 4) != 0;
    }

    public static void func_72228_a(World p_72228_0_, int p_72228_1_, int p_72228_2_, int p_72228_3_, boolean p_72228_4_)
    {
        int i = p_72228_0_.func_72805_g(p_72228_1_, p_72228_2_, p_72228_3_);
        if(p_72228_4_)
        {
            i |= 4;
        } else
        {
            i &= -5;
        }
        p_72228_0_.func_72921_c(p_72228_1_, p_72228_2_, p_72228_3_, i);
    }

    public static ChunkCoordinates func_72226_b(World p_72226_0_, int p_72226_1_, int p_72226_2_, int p_72226_3_, int p_72226_4_)
    {
        int i = p_72226_0_.func_72805_g(p_72226_1_, p_72226_2_, p_72226_3_);
        int j = BlockDirectional.func_72217_d(i);
        for(int k = 0; k <= 1; k++)
        {
            int l = p_72226_1_ - field_72230_a[j][0] * k - 1;
            int i1 = p_72226_3_ - field_72230_a[j][1] * k - 1;
            int j1 = l + 2;
            int k1 = i1 + 2;
            for(int l1 = l; l1 <= j1; l1++)
            {
                for(int i2 = i1; i2 <= k1; i2++)
                {
                    if(!p_72226_0_.func_72797_t(l1, p_72226_2_ - 1, i2) || !p_72226_0_.func_72799_c(l1, p_72226_2_, i2) || !p_72226_0_.func_72799_c(l1, p_72226_2_ + 1, i2))
                    {
                        continue;
                    }
                    if(p_72226_4_ > 0)
                    {
                        p_72226_4_--;
                    } else
                    {
                        return new ChunkCoordinates(l1, p_72226_2_, i2);
                    }
                }

            }

        }

        return null;
    }

    public void func_71914_a(World p_71914_1_, int p_71914_2_, int p_71914_3_, int p_71914_4_, int p_71914_5_, float p_71914_6_, int p_71914_7_)
    {
        if(!func_72229_a_(p_71914_5_))
        {
            super.func_71914_a(p_71914_1_, p_71914_2_, p_71914_3_, p_71914_4_, p_71914_5_, p_71914_6_, 0);
        }
    }

    public int func_71915_e()
    {
        return 1;
    }

    public int func_71922_a(World p_71922_1_, int p_71922_2_, int p_71922_3_, int p_71922_4_)
    {
        return Item.field_77776_ba.field_77779_bT;
    }

}
