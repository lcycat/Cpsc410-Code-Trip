// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, CreativeTabs, Facing, 
//            EntityPlayer, World, TileEntityPiston, BlockPistonMoving, 
//            IBlockAccess, MathHelper, BlockContainer, BlockPistonExtension, 
//            EntityLiving, AxisAlignedBB, Entity

public class BlockPistonBase extends Block
{

    private boolean field_72119_a;

    public BlockPistonBase(int p_i4025_1_, int p_i4025_2_, boolean p_i4025_3_)
    {
        super(p_i4025_1_, p_i4025_2_, Material.field_76233_E);
        field_72119_a = p_i4025_3_;
        func_71884_a(field_71976_h);
        func_71848_c(0.5F);
        func_71849_a(CreativeTabs.field_78028_d);
    }

    public int func_72118_n()
    {
        return !field_72119_a ? 107 : 106;
    }

    public int func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        int i = func_72117_e(p_71858_2_);
        if(i > 5)
        {
            return field_72059_bZ;
        }
        if(p_71858_1_ == i)
        {
            if(func_72114_f(p_71858_2_) || field_72026_ch > 0.0D || field_72023_ci > 0.0D || field_72024_cj > 0.0D || field_72021_ck < 1.0D || field_72022_cl < 1.0D || field_72019_cm < 1.0D)
            {
                return 110;
            } else
            {
                return field_72059_bZ;
            }
        }
        return p_71858_1_ != Facing.field_71588_a[i] ? 108 : 109;
    }

    public int func_71857_b()
    {
        return 16;
    }

    public boolean func_71926_d()
    {
        return false;
    }

    public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int i, EntityPlayer entityplayer, int j, float f, 
            float f1, float f2)
    {
        return false;
    }

    public void func_71860_a(World p_71860_1_, int p_71860_2_, int p_71860_3_, int p_71860_4_, EntityLiving p_71860_5_)
    {
        int i = func_72116_b(p_71860_1_, p_71860_2_, p_71860_3_, p_71860_4_, (EntityPlayer)p_71860_5_);
        p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, i);
        if(!p_71860_1_.field_72995_K)
        {
            func_72110_l(p_71860_1_, p_71860_2_, p_71860_3_, p_71860_4_);
        }
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        if(!p_71863_1_.field_72995_K)
        {
            func_72110_l(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_);
        }
    }

    public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_)
    {
        if(!p_71861_1_.field_72995_K && p_71861_1_.func_72796_p(p_71861_2_, p_71861_3_, p_71861_4_) == null)
        {
            func_72110_l(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
        }
    }

    private void func_72110_l(World p_72110_1_, int p_72110_2_, int p_72110_3_, int p_72110_4_)
    {
        int i = p_72110_1_.func_72805_g(p_72110_2_, p_72110_3_, p_72110_4_);
        int j = func_72117_e(i);
        if(j == 7)
        {
            return;
        }
        boolean flag = func_72113_e(p_72110_1_, p_72110_2_, p_72110_3_, p_72110_4_, j);
        if(flag && !func_72114_f(i))
        {
            if(func_72112_i(p_72110_1_, p_72110_2_, p_72110_3_, p_72110_4_, j))
            {
                p_72110_1_.func_72965_b(p_72110_2_, p_72110_3_, p_72110_4_, field_71990_ca, 0, j);
            }
        } else
        if(!flag && func_72114_f(i))
        {
            p_72110_1_.func_72965_b(p_72110_2_, p_72110_3_, p_72110_4_, field_71990_ca, 1, j);
        }
    }

    private boolean func_72113_e(World p_72113_1_, int p_72113_2_, int p_72113_3_, int p_72113_4_, int p_72113_5_)
    {
        if(p_72113_5_ != 0 && p_72113_1_.func_72878_l(p_72113_2_, p_72113_3_ - 1, p_72113_4_, 0))
        {
            return true;
        }
        if(p_72113_5_ != 1 && p_72113_1_.func_72878_l(p_72113_2_, p_72113_3_ + 1, p_72113_4_, 1))
        {
            return true;
        }
        if(p_72113_5_ != 2 && p_72113_1_.func_72878_l(p_72113_2_, p_72113_3_, p_72113_4_ - 1, 2))
        {
            return true;
        }
        if(p_72113_5_ != 3 && p_72113_1_.func_72878_l(p_72113_2_, p_72113_3_, p_72113_4_ + 1, 3))
        {
            return true;
        }
        if(p_72113_5_ != 5 && p_72113_1_.func_72878_l(p_72113_2_ + 1, p_72113_3_, p_72113_4_, 5))
        {
            return true;
        }
        if(p_72113_5_ != 4 && p_72113_1_.func_72878_l(p_72113_2_ - 1, p_72113_3_, p_72113_4_, 4))
        {
            return true;
        }
        if(p_72113_1_.func_72878_l(p_72113_2_, p_72113_3_, p_72113_4_, 0))
        {
            return true;
        }
        if(p_72113_1_.func_72878_l(p_72113_2_, p_72113_3_ + 2, p_72113_4_, 1))
        {
            return true;
        }
        if(p_72113_1_.func_72878_l(p_72113_2_, p_72113_3_ + 1, p_72113_4_ - 1, 2))
        {
            return true;
        }
        if(p_72113_1_.func_72878_l(p_72113_2_, p_72113_3_ + 1, p_72113_4_ + 1, 3))
        {
            return true;
        }
        if(p_72113_1_.func_72878_l(p_72113_2_ - 1, p_72113_3_ + 1, p_72113_4_, 4))
        {
            return true;
        }
        return p_72113_1_.func_72878_l(p_72113_2_ + 1, p_72113_3_ + 1, p_72113_4_, 5);
    }

    public void func_71883_b(World p_71883_1_, int p_71883_2_, int p_71883_3_, int p_71883_4_, int p_71883_5_, int p_71883_6_)
    {
        if(p_71883_5_ == 0)
        {
            p_71883_1_.func_72881_d(p_71883_2_, p_71883_3_, p_71883_4_, p_71883_6_ | 8);
        } else
        {
            p_71883_1_.func_72881_d(p_71883_2_, p_71883_3_, p_71883_4_, p_71883_6_);
        }
        if(p_71883_5_ == 0)
        {
            if(func_72115_j(p_71883_1_, p_71883_2_, p_71883_3_, p_71883_4_, p_71883_6_))
            {
                p_71883_1_.func_72921_c(p_71883_2_, p_71883_3_, p_71883_4_, p_71883_6_ | 8);
                p_71883_1_.func_72908_a((double)p_71883_2_ + 0.5D, (double)p_71883_3_ + 0.5D, (double)p_71883_4_ + 0.5D, "tile.piston.out", 0.5F, p_71883_1_.field_73012_v.nextFloat() * 0.25F + 0.6F);
            } else
            {
                p_71883_1_.func_72881_d(p_71883_2_, p_71883_3_, p_71883_4_, p_71883_6_);
            }
        } else
        if(p_71883_5_ == 1)
        {
            TileEntity tileentity = p_71883_1_.func_72796_p(p_71883_2_ + Facing.field_71586_b[p_71883_6_], p_71883_3_ + Facing.field_71587_c[p_71883_6_], p_71883_4_ + Facing.field_71585_d[p_71883_6_]);
            if(tileentity instanceof TileEntityPiston)
            {
                ((TileEntityPiston)tileentity).func_70339_i();
            }
            p_71883_1_.func_72961_c(p_71883_2_, p_71883_3_, p_71883_4_, Block.field_72095_ac.field_71990_ca, p_71883_6_);
            p_71883_1_.func_72837_a(p_71883_2_, p_71883_3_, p_71883_4_, BlockPistonMoving.func_72297_a(field_71990_ca, p_71883_6_, p_71883_6_, false, true));
            if(field_72119_a)
            {
                int i = p_71883_2_ + Facing.field_71586_b[p_71883_6_] * 2;
                int j = p_71883_3_ + Facing.field_71587_c[p_71883_6_] * 2;
                int k = p_71883_4_ + Facing.field_71585_d[p_71883_6_] * 2;
                int l = p_71883_1_.func_72798_a(i, j, k);
                int i1 = p_71883_1_.func_72805_g(i, j, k);
                boolean flag = false;
                if(l == Block.field_72095_ac.field_71990_ca)
                {
                    TileEntity tileentity1 = p_71883_1_.func_72796_p(i, j, k);
                    if(tileentity1 instanceof TileEntityPiston)
                    {
                        TileEntityPiston tileentitypiston = (TileEntityPiston)tileentity1;
                        if(tileentitypiston.func_70336_c() == p_71883_6_ && tileentitypiston.func_70341_b())
                        {
                            tileentitypiston.func_70339_i();
                            l = tileentitypiston.func_70340_a();
                            i1 = tileentitypiston.func_70322_n();
                            flag = true;
                        }
                    }
                }
                if(!flag && l > 0 && func_72111_a(l, p_71883_1_, i, j, k, false) && (Block.field_71973_m[l].func_71915_e() == 0 || l == Block.field_71963_Z.field_71990_ca || l == Block.field_71956_V.field_71990_ca))
                {
                    p_71883_2_ += Facing.field_71586_b[p_71883_6_];
                    p_71883_3_ += Facing.field_71587_c[p_71883_6_];
                    p_71883_4_ += Facing.field_71585_d[p_71883_6_];
                    p_71883_1_.func_72961_c(p_71883_2_, p_71883_3_, p_71883_4_, Block.field_72095_ac.field_71990_ca, i1);
                    p_71883_1_.func_72837_a(p_71883_2_, p_71883_3_, p_71883_4_, BlockPistonMoving.func_72297_a(l, i1, p_71883_6_, false, false));
                    p_71883_1_.func_72859_e(i, j, k, 0);
                } else
                if(!flag)
                {
                    p_71883_1_.func_72859_e(p_71883_2_ + Facing.field_71586_b[p_71883_6_], p_71883_3_ + Facing.field_71587_c[p_71883_6_], p_71883_4_ + Facing.field_71585_d[p_71883_6_], 0);
                }
            } else
            {
                p_71883_1_.func_72859_e(p_71883_2_ + Facing.field_71586_b[p_71883_6_], p_71883_3_ + Facing.field_71587_c[p_71883_6_], p_71883_4_ + Facing.field_71585_d[p_71883_6_], 0);
            }
            p_71883_1_.func_72908_a((double)p_71883_2_ + 0.5D, (double)p_71883_3_ + 0.5D, (double)p_71883_4_ + 0.5D, "tile.piston.in", 0.5F, p_71883_1_.field_73012_v.nextFloat() * 0.15F + 0.6F);
        }
    }

    public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_)
    {
        int i = p_71902_1_.func_72805_g(p_71902_2_, p_71902_3_, p_71902_4_);
        if(func_72114_f(i))
        {
            switch(func_72117_e(i))
            {
            case 0: // '\0'
                func_71905_a(0.0F, 0.25F, 0.0F, 1.0F, 1.0F, 1.0F);
                break;

            case 1: // '\001'
                func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
                break;

            case 2: // '\002'
                func_71905_a(0.0F, 0.0F, 0.25F, 1.0F, 1.0F, 1.0F);
                break;

            case 3: // '\003'
                func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.75F);
                break;

            case 4: // '\004'
                func_71905_a(0.25F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
                break;

            case 5: // '\005'
                func_71905_a(0.0F, 0.0F, 0.0F, 0.75F, 1.0F, 1.0F);
                break;
            }
        } else
        {
            func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }
    }

    public void func_71919_f()
    {
        func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public void func_71871_a(World p_71871_1_, int p_71871_2_, int p_71871_3_, int p_71871_4_, AxisAlignedBB p_71871_5_, List p_71871_6_, Entity p_71871_7_)
    {
        func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
    }

    public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_)
    {
        func_71902_a(p_71872_1_, p_71872_2_, p_71872_3_, p_71872_4_);
        return super.func_71872_e(p_71872_1_, p_71872_2_, p_71872_3_, p_71872_4_);
    }

    public boolean func_71886_c()
    {
        return false;
    }

    public static int func_72117_e(int p_72117_0_)
    {
        return p_72117_0_ & 7;
    }

    public static boolean func_72114_f(int p_72114_0_)
    {
        return (p_72114_0_ & 8) != 0;
    }

    public static int func_72116_b(World p_72116_0_, int p_72116_1_, int p_72116_2_, int p_72116_3_, EntityPlayer p_72116_4_)
    {
        if(MathHelper.func_76135_e((float)p_72116_4_.field_70165_t - (float)p_72116_1_) < 2.0F && MathHelper.func_76135_e((float)p_72116_4_.field_70161_v - (float)p_72116_3_) < 2.0F)
        {
            double d = (p_72116_4_.field_70163_u + 1.8200000000000001D) - (double)p_72116_4_.field_70129_M;
            if(d - (double)p_72116_2_ > 2D)
            {
                return 1;
            }
            if((double)p_72116_2_ - d > 0.0D)
            {
                return 0;
            }
        }
        int i = MathHelper.func_76128_c((double)((p_72116_4_.field_70177_z * 4F) / 360F) + 0.5D) & 3;
        if(i == 0)
        {
            return 2;
        }
        if(i == 1)
        {
            return 5;
        }
        if(i == 2)
        {
            return 3;
        }
        return i != 3 ? 0 : 4;
    }

    private static boolean func_72111_a(int p_72111_0_, World p_72111_1_, int p_72111_2_, int p_72111_3_, int p_72111_4_, boolean p_72111_5_)
    {
        if(p_72111_0_ == Block.field_72089_ap.field_71990_ca)
        {
            return false;
        }
        if(p_72111_0_ == Block.field_71963_Z.field_71990_ca || p_72111_0_ == Block.field_71956_V.field_71990_ca)
        {
            if(func_72114_f(p_72111_1_.func_72805_g(p_72111_2_, p_72111_3_, p_72111_4_)))
            {
                return false;
            }
        } else
        {
            if(Block.field_71973_m[p_72111_0_].func_71934_m(p_72111_1_, p_72111_2_, p_72111_3_, p_72111_4_) == -1F)
            {
                return false;
            }
            if(Block.field_71973_m[p_72111_0_].func_71915_e() == 2)
            {
                return false;
            }
            if(!p_72111_5_ && Block.field_71973_m[p_72111_0_].func_71915_e() == 1)
            {
                return false;
            }
        }
        return !(Block.field_71973_m[p_72111_0_] instanceof BlockContainer);
    }

    private static boolean func_72112_i(World p_72112_0_, int p_72112_1_, int p_72112_2_, int p_72112_3_, int p_72112_4_)
    {
        int i = p_72112_1_ + Facing.field_71586_b[p_72112_4_];
        int j = p_72112_2_ + Facing.field_71587_c[p_72112_4_];
        int k = p_72112_3_ + Facing.field_71585_d[p_72112_4_];
        int l = 0;
        do
        {
            if(l >= 13)
            {
                break;
            }
            if(j <= 0 || j >= 255)
            {
                return false;
            }
            int i1 = p_72112_0_.func_72798_a(i, j, k);
            if(i1 == 0)
            {
                break;
            }
            if(!func_72111_a(i1, p_72112_0_, i, j, k, true))
            {
                return false;
            }
            if(Block.field_71973_m[i1].func_71915_e() == 1)
            {
                break;
            }
            if(l == 12)
            {
                return false;
            }
            i += Facing.field_71586_b[p_72112_4_];
            j += Facing.field_71587_c[p_72112_4_];
            k += Facing.field_71585_d[p_72112_4_];
            l++;
        } while(true);
        return true;
    }

    private boolean func_72115_j(World p_72115_1_, int p_72115_2_, int p_72115_3_, int p_72115_4_, int p_72115_5_)
    {
        int i = p_72115_2_ + Facing.field_71586_b[p_72115_5_];
        int j = p_72115_3_ + Facing.field_71587_c[p_72115_5_];
        int k = p_72115_4_ + Facing.field_71585_d[p_72115_5_];
        int l = 0;
        do
        {
            if(l >= 13)
            {
                break;
            }
            if(j <= 0 || j >= 255)
            {
                return false;
            }
            int j1 = p_72115_1_.func_72798_a(i, j, k);
            if(j1 == 0)
            {
                break;
            }
            if(!func_72111_a(j1, p_72115_1_, i, j, k, true))
            {
                return false;
            }
            if(Block.field_71973_m[j1].func_71915_e() == 1)
            {
                Block.field_71973_m[j1].func_71897_c(p_72115_1_, i, j, k, p_72115_1_.func_72805_g(i, j, k), 0);
                p_72115_1_.func_72859_e(i, j, k, 0);
                break;
            }
            if(l == 12)
            {
                return false;
            }
            i += Facing.field_71586_b[p_72115_5_];
            j += Facing.field_71587_c[p_72115_5_];
            k += Facing.field_71585_d[p_72115_5_];
            l++;
        } while(true);
        int l1;
        for(; i != p_72115_2_ || j != p_72115_3_ || k != p_72115_4_; k = l1)
        {
            int i1 = i - Facing.field_71586_b[p_72115_5_];
            int k1 = j - Facing.field_71587_c[p_72115_5_];
            l1 = k - Facing.field_71585_d[p_72115_5_];
            int i2 = p_72115_1_.func_72798_a(i1, k1, l1);
            int j2 = p_72115_1_.func_72805_g(i1, k1, l1);
            if(i2 == field_71990_ca && i1 == p_72115_2_ && k1 == p_72115_3_ && l1 == p_72115_4_)
            {
                p_72115_1_.func_72930_a(i, j, k, Block.field_72095_ac.field_71990_ca, p_72115_5_ | (field_72119_a ? 8 : 0), false);
                p_72115_1_.func_72837_a(i, j, k, BlockPistonMoving.func_72297_a(Block.field_72099_aa.field_71990_ca, p_72115_5_ | (field_72119_a ? 8 : 0), p_72115_5_, true, false));
            } else
            {
                p_72115_1_.func_72930_a(i, j, k, Block.field_72095_ac.field_71990_ca, j2, false);
                p_72115_1_.func_72837_a(i, j, k, BlockPistonMoving.func_72297_a(i2, j2, p_72115_5_, true, false));
            }
            i = i1;
            j = k1;
        }

        return true;
    }
}
