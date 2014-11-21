// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, CreativeTabs, World, 
//            Direction, IBlockAccess, AxisAlignedBB

public class BlockTripWireSource extends Block
{

    public BlockTripWireSource(int p_i4017_1_)
    {
        super(p_i4017_1_, 172, Material.field_76265_p);
        func_71849_a(CreativeTabs.field_78028_d);
        func_71907_b(true);
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

    public int func_71857_b()
    {
        return 29;
    }

    public int func_71859_p_()
    {
        return 10;
    }

    public boolean func_71850_a_(World p_71850_1_, int p_71850_2_, int p_71850_3_, int p_71850_4_, int p_71850_5_)
    {
        if(p_71850_5_ == 2 && p_71850_1_.func_72809_s(p_71850_2_, p_71850_3_, p_71850_4_ + 1))
        {
            return true;
        }
        if(p_71850_5_ == 3 && p_71850_1_.func_72809_s(p_71850_2_, p_71850_3_, p_71850_4_ - 1))
        {
            return true;
        }
        if(p_71850_5_ == 4 && p_71850_1_.func_72809_s(p_71850_2_ + 1, p_71850_3_, p_71850_4_))
        {
            return true;
        }
        return p_71850_5_ == 5 && p_71850_1_.func_72809_s(p_71850_2_ - 1, p_71850_3_, p_71850_4_);
    }

    public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_)
    {
        if(p_71930_1_.func_72809_s(p_71930_2_ - 1, p_71930_3_, p_71930_4_))
        {
            return true;
        }
        if(p_71930_1_.func_72809_s(p_71930_2_ + 1, p_71930_3_, p_71930_4_))
        {
            return true;
        }
        if(p_71930_1_.func_72809_s(p_71930_2_, p_71930_3_, p_71930_4_ - 1))
        {
            return true;
        }
        return p_71930_1_.func_72809_s(p_71930_2_, p_71930_3_, p_71930_4_ + 1);
    }

    public void func_71909_a(World p_71909_1_, int p_71909_2_, int p_71909_3_, int p_71909_4_, int p_71909_5_, float p_71909_6_, float p_71909_7_, 
            float p_71909_8_)
    {
        byte byte0 = 0;
        if(p_71909_5_ == 2 && p_71909_1_.func_72887_b(p_71909_2_, p_71909_3_, p_71909_4_ + 1, true))
        {
            byte0 = 2;
        }
        if(p_71909_5_ == 3 && p_71909_1_.func_72887_b(p_71909_2_, p_71909_3_, p_71909_4_ - 1, true))
        {
            byte0 = 0;
        }
        if(p_71909_5_ == 4 && p_71909_1_.func_72887_b(p_71909_2_ + 1, p_71909_3_, p_71909_4_, true))
        {
            byte0 = 1;
        }
        if(p_71909_5_ == 5 && p_71909_1_.func_72887_b(p_71909_2_ - 1, p_71909_3_, p_71909_4_, true))
        {
            byte0 = 3;
        }
        func_72143_a(p_71909_1_, p_71909_2_, p_71909_3_, p_71909_4_, field_71990_ca, byte0, false, -1, 0);
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        if(p_71863_5_ == field_71990_ca)
        {
            return;
        }
        if(func_72144_l(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_))
        {
            int i = p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_);
            int j = i & 3;
            boolean flag = false;
            if(!p_71863_1_.func_72809_s(p_71863_2_ - 1, p_71863_3_, p_71863_4_) && j == 3)
            {
                flag = true;
            }
            if(!p_71863_1_.func_72809_s(p_71863_2_ + 1, p_71863_3_, p_71863_4_) && j == 1)
            {
                flag = true;
            }
            if(!p_71863_1_.func_72809_s(p_71863_2_, p_71863_3_, p_71863_4_ - 1) && j == 0)
            {
                flag = true;
            }
            if(!p_71863_1_.func_72809_s(p_71863_2_, p_71863_3_, p_71863_4_ + 1) && j == 2)
            {
                flag = true;
            }
            if(flag)
            {
                func_71897_c(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, i, 0);
                p_71863_1_.func_72859_e(p_71863_2_, p_71863_3_, p_71863_4_, 0);
            }
        }
    }

    public void func_72143_a(World p_72143_1_, int p_72143_2_, int p_72143_3_, int p_72143_4_, int p_72143_5_, int p_72143_6_, boolean p_72143_7_, 
            int p_72143_8_, int p_72143_9_)
    {
        int i = p_72143_6_ & 3;
        boolean flag = (p_72143_6_ & 4) == 4;
        boolean flag1 = (p_72143_6_ & 8) == 8;
        boolean flag2 = p_72143_5_ == Block.field_72064_bT.field_71990_ca;
        boolean flag3 = false;
        boolean flag4 = !p_72143_1_.func_72797_t(p_72143_2_, p_72143_3_ - 1, p_72143_4_);
        int j = Direction.field_71583_a[i];
        int k = Direction.field_71581_b[i];
        int l = 0;
        int ai[] = new int[42];
        for(int i1 = 1; i1 < 42; i1++)
        {
            int k1 = p_72143_2_ + j * i1;
            int j2 = p_72143_4_ + k * i1;
            int i3 = p_72143_1_.func_72798_a(k1, p_72143_3_, j2);
            if(i3 == Block.field_72064_bT.field_71990_ca)
            {
                int l3 = p_72143_1_.func_72805_g(k1, p_72143_3_, j2);
                if((l3 & 3) == Direction.field_71580_e[i])
                {
                    l = i1;
                }
                break;
            }
            if(i3 == Block.field_72062_bU.field_71990_ca || i1 == p_72143_8_)
            {
                int i4 = i1 != p_72143_8_ ? p_72143_1_.func_72805_g(k1, p_72143_3_, j2) : p_72143_9_;
                boolean flag5 = (i4 & 8) != 8;
                boolean flag6 = (i4 & 1) == 1;
                boolean flag7 = (i4 & 2) == 2;
                flag2 &= flag7 == flag4;
                flag3 |= flag5 && flag6;
                ai[i1] = i4;
                if(i1 == p_72143_8_)
                {
                    p_72143_1_.func_72836_a(p_72143_2_, p_72143_3_, p_72143_4_, p_72143_5_, func_71859_p_());
                    flag2 &= flag5;
                }
            } else
            {
                ai[i1] = -1;
                flag2 = false;
            }
        }

        flag2 &= l > 1;
        flag3 &= flag2;
        int j1 = (flag2 ? 4 : 0) | (flag3 ? 8 : 0);
        p_72143_6_ = i | j1;
        if(l > 0)
        {
            int l1 = p_72143_2_ + j * l;
            int k2 = p_72143_4_ + k * l;
            int j3 = Direction.field_71580_e[i];
            p_72143_1_.func_72921_c(l1, p_72143_3_, k2, j3 | j1);
            func_72146_e(p_72143_1_, l1, p_72143_3_, k2, j3);
            func_72145_a(p_72143_1_, l1, p_72143_3_, k2, flag2, flag3, flag, flag1);
        }
        func_72145_a(p_72143_1_, p_72143_2_, p_72143_3_, p_72143_4_, flag2, flag3, flag, flag1);
        if(p_72143_5_ > 0)
        {
            p_72143_1_.func_72921_c(p_72143_2_, p_72143_3_, p_72143_4_, p_72143_6_);
            if(p_72143_7_)
            {
                func_72146_e(p_72143_1_, p_72143_2_, p_72143_3_, p_72143_4_, i);
            }
        }
        if(flag != flag2)
        {
            for(int i2 = 1; i2 < l; i2++)
            {
                int l2 = p_72143_2_ + j * i2;
                int k3 = p_72143_4_ + k * i2;
                int j4 = ai[i2];
                if(j4 < 0)
                {
                    continue;
                }
                if(flag2)
                {
                    j4 |= 4;
                } else
                {
                    j4 &= -5;
                }
                p_72143_1_.func_72921_c(l2, p_72143_3_, k3, j4);
            }

        }
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_)
    {
        func_72143_a(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_, field_71990_ca, p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_), true, -1, 0);
    }

    private void func_72145_a(World p_72145_1_, int p_72145_2_, int p_72145_3_, int p_72145_4_, boolean p_72145_5_, boolean p_72145_6_, boolean p_72145_7_, 
            boolean p_72145_8_)
    {
        if(p_72145_6_ && !p_72145_8_)
        {
            p_72145_1_.func_72908_a((double)p_72145_2_ + 0.5D, (double)p_72145_3_ + 0.10000000000000001D, (double)p_72145_4_ + 0.5D, "random.click", 0.4F, 0.6F);
        } else
        if(!p_72145_6_ && p_72145_8_)
        {
            p_72145_1_.func_72908_a((double)p_72145_2_ + 0.5D, (double)p_72145_3_ + 0.10000000000000001D, (double)p_72145_4_ + 0.5D, "random.click", 0.4F, 0.5F);
        } else
        if(p_72145_5_ && !p_72145_7_)
        {
            p_72145_1_.func_72908_a((double)p_72145_2_ + 0.5D, (double)p_72145_3_ + 0.10000000000000001D, (double)p_72145_4_ + 0.5D, "random.click", 0.4F, 0.7F);
        } else
        if(!p_72145_5_ && p_72145_7_)
        {
            p_72145_1_.func_72908_a((double)p_72145_2_ + 0.5D, (double)p_72145_3_ + 0.10000000000000001D, (double)p_72145_4_ + 0.5D, "random.bowhit", 0.4F, 1.2F / (p_72145_1_.field_73012_v.nextFloat() * 0.2F + 0.9F));
        }
    }

    private void func_72146_e(World p_72146_1_, int p_72146_2_, int p_72146_3_, int p_72146_4_, int p_72146_5_)
    {
        p_72146_1_.func_72898_h(p_72146_2_, p_72146_3_, p_72146_4_, field_71990_ca);
        if(p_72146_5_ == 3)
        {
            p_72146_1_.func_72898_h(p_72146_2_ - 1, p_72146_3_, p_72146_4_, field_71990_ca);
        } else
        if(p_72146_5_ == 1)
        {
            p_72146_1_.func_72898_h(p_72146_2_ + 1, p_72146_3_, p_72146_4_, field_71990_ca);
        } else
        if(p_72146_5_ == 0)
        {
            p_72146_1_.func_72898_h(p_72146_2_, p_72146_3_, p_72146_4_ - 1, field_71990_ca);
        } else
        if(p_72146_5_ == 2)
        {
            p_72146_1_.func_72898_h(p_72146_2_, p_72146_3_, p_72146_4_ + 1, field_71990_ca);
        }
    }

    private boolean func_72144_l(World p_72144_1_, int p_72144_2_, int p_72144_3_, int p_72144_4_)
    {
        if(!func_71930_b(p_72144_1_, p_72144_2_, p_72144_3_, p_72144_4_))
        {
            func_71897_c(p_72144_1_, p_72144_2_, p_72144_3_, p_72144_4_, p_72144_1_.func_72805_g(p_72144_2_, p_72144_3_, p_72144_4_), 0);
            p_72144_1_.func_72859_e(p_72144_2_, p_72144_3_, p_72144_4_, 0);
            return false;
        } else
        {
            return true;
        }
    }

    public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_)
    {
        int i = p_71902_1_.func_72805_g(p_71902_2_, p_71902_3_, p_71902_4_) & 3;
        float f = 0.1875F;
        if(i == 3)
        {
            func_71905_a(0.0F, 0.2F, 0.5F - f, f * 2.0F, 0.8F, 0.5F + f);
        } else
        if(i == 1)
        {
            func_71905_a(1.0F - f * 2.0F, 0.2F, 0.5F - f, 1.0F, 0.8F, 0.5F + f);
        } else
        if(i == 0)
        {
            func_71905_a(0.5F - f, 0.2F, 0.0F, 0.5F + f, 0.8F, f * 2.0F);
        } else
        if(i == 2)
        {
            func_71905_a(0.5F - f, 0.2F, 1.0F - f * 2.0F, 0.5F + f, 0.8F, 1.0F);
        }
    }

    public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_)
    {
        boolean flag = (p_71852_6_ & 4) == 4;
        boolean flag1 = (p_71852_6_ & 8) == 8;
        if(flag || flag1)
        {
            func_72143_a(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_, 0, p_71852_6_, false, -1, 0);
        }
        if(flag1)
        {
            p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_, p_71852_4_, field_71990_ca);
            int i = p_71852_6_ & 3;
            if(i == 3)
            {
                p_71852_1_.func_72898_h(p_71852_2_ - 1, p_71852_3_, p_71852_4_, field_71990_ca);
            } else
            if(i == 1)
            {
                p_71852_1_.func_72898_h(p_71852_2_ + 1, p_71852_3_, p_71852_4_, field_71990_ca);
            } else
            if(i == 0)
            {
                p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_, p_71852_4_ - 1, field_71990_ca);
            } else
            if(i == 2)
            {
                p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_, p_71852_4_ + 1, field_71990_ca);
            }
        }
        super.func_71852_a(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_, p_71852_5_, p_71852_6_);
    }

    public boolean func_71865_a(IBlockAccess p_71865_1_, int p_71865_2_, int p_71865_3_, int p_71865_4_, int p_71865_5_)
    {
        return (p_71865_1_.func_72805_g(p_71865_2_, p_71865_3_, p_71865_4_) & 8) == 8;
    }

    public boolean func_71855_c(World p_71855_1_, int p_71855_2_, int p_71855_3_, int p_71855_4_, int p_71855_5_)
    {
        int i = p_71855_1_.func_72805_g(p_71855_2_, p_71855_3_, p_71855_4_);
        if((i & 8) != 8)
        {
            return false;
        }
        int j = i & 3;
        if(j == 2 && p_71855_5_ == 2)
        {
            return true;
        }
        if(j == 0 && p_71855_5_ == 3)
        {
            return true;
        }
        if(j == 1 && p_71855_5_ == 4)
        {
            return true;
        }
        return j == 3 && p_71855_5_ == 5;
    }

    public boolean func_71853_i()
    {
        return true;
    }
}
