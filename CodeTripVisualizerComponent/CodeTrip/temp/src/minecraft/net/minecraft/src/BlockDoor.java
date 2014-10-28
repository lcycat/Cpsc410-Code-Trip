// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, World, Item, 
//            IBlockAccess, AxisAlignedBB, EntityPlayer, Vec3, 
//            MovingObjectPosition

public class BlockDoor extends Block
{

    protected BlockDoor(int p_i3939_1_, Material p_i3939_2_)
    {
        super(p_i3939_1_, p_i3939_2_);
        field_72059_bZ = 97;
        if(p_i3939_2_ == Material.field_76243_f)
        {
            field_72059_bZ++;
        }
        float f = 0.5F;
        float f1 = 1.0F;
        func_71905_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
    }

    public int func_71895_b(IBlockAccess p_71895_1_, int p_71895_2_, int p_71895_3_, int p_71895_4_, int p_71895_5_)
    {
        if(p_71895_5_ == 0 || p_71895_5_ == 1)
        {
            return field_72059_bZ;
        }
        int i = func_72234_b_(p_71895_1_, p_71895_2_, p_71895_3_, p_71895_4_);
        int j = field_72059_bZ;
        if((i & 8) != 0)
        {
            j -= 16;
        }
        int k = i & 3;
        boolean flag = (i & 4) != 0;
        if(flag)
        {
            if(k == 0 && p_71895_5_ == 2)
            {
                j = -j;
            } else
            if(k == 1 && p_71895_5_ == 5)
            {
                j = -j;
            } else
            if(k == 2 && p_71895_5_ == 3)
            {
                j = -j;
            } else
            if(k == 3 && p_71895_5_ == 4)
            {
                j = -j;
            }
        } else
        {
            if(k == 0 && p_71895_5_ == 5)
            {
                j = -j;
            } else
            if(k == 1 && p_71895_5_ == 3)
            {
                j = -j;
            } else
            if(k == 2 && p_71895_5_ == 4)
            {
                j = -j;
            } else
            if(k == 3 && p_71895_5_ == 2)
            {
                j = -j;
            }
            if((i & 0x10) != 0)
            {
                j = -j;
            }
        }
        return j;
    }

    public boolean func_71926_d()
    {
        return false;
    }

    public boolean func_71918_c(IBlockAccess p_71918_1_, int p_71918_2_, int p_71918_3_, int p_71918_4_)
    {
        int i = func_72234_b_(p_71918_1_, p_71918_2_, p_71918_3_, p_71918_4_);
        return (i & 4) != 0;
    }

    public boolean func_71886_c()
    {
        return false;
    }

    public int func_71857_b()
    {
        return 7;
    }

    public AxisAlignedBB func_71911_a_(World p_71911_1_, int p_71911_2_, int p_71911_3_, int p_71911_4_)
    {
        func_71902_a(p_71911_1_, p_71911_2_, p_71911_3_, p_71911_4_);
        return super.func_71911_a_(p_71911_1_, p_71911_2_, p_71911_3_, p_71911_4_);
    }

    public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_)
    {
        func_71902_a(p_71872_1_, p_71872_2_, p_71872_3_, p_71872_4_);
        return super.func_71872_e(p_71872_1_, p_71872_2_, p_71872_3_, p_71872_4_);
    }

    public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_)
    {
        func_72232_e(func_72234_b_(p_71902_1_, p_71902_2_, p_71902_3_, p_71902_4_));
    }

    public int func_72235_d(IBlockAccess p_72235_1_, int p_72235_2_, int p_72235_3_, int p_72235_4_)
    {
        return func_72234_b_(p_72235_1_, p_72235_2_, p_72235_3_, p_72235_4_) & 3;
    }

    public boolean func_72233_a_(IBlockAccess p_72233_1_, int p_72233_2_, int p_72233_3_, int p_72233_4_)
    {
        return (func_72234_b_(p_72233_1_, p_72233_2_, p_72233_3_, p_72233_4_) & 4) != 0;
    }

    private void func_72232_e(int p_72232_1_)
    {
        float f = 0.1875F;
        func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
        int i = p_72232_1_ & 3;
        boolean flag = (p_72232_1_ & 4) != 0;
        boolean flag1 = (p_72232_1_ & 0x10) != 0;
        if(i == 0)
        {
            if(flag)
            {
                if(!flag1)
                {
                    func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
                } else
                {
                    func_71905_a(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
                }
            } else
            {
                func_71905_a(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
            }
        } else
        if(i == 1)
        {
            if(flag)
            {
                if(!flag1)
                {
                    func_71905_a(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
                } else
                {
                    func_71905_a(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
                }
            } else
            {
                func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
            }
        } else
        if(i == 2)
        {
            if(flag)
            {
                if(!flag1)
                {
                    func_71905_a(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
                } else
                {
                    func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
                }
            } else
            {
                func_71905_a(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            }
        } else
        if(i == 3)
        {
            if(flag)
            {
                if(!flag1)
                {
                    func_71905_a(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
                } else
                {
                    func_71905_a(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
                }
            } else
            {
                func_71905_a(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
            }
        }
    }

    public void func_71921_a(World p_71921_1_, int p_71921_2_, int p_71921_3_, int p_71921_4_, EntityPlayer p_71921_5_)
    {
        func_71903_a(p_71921_1_, p_71921_2_, p_71921_3_, p_71921_4_, p_71921_5_, 0, 0.0F, 0.0F, 0.0F);
    }

    public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, 
            float p_71903_8_, float p_71903_9_)
    {
        if(field_72018_cp == Material.field_76243_f)
        {
            return true;
        }
        int i = func_72234_b_(p_71903_1_, p_71903_2_, p_71903_3_, p_71903_4_);
        int j = i & 7;
        j ^= 4;
        if((i & 8) == 0)
        {
            p_71903_1_.func_72921_c(p_71903_2_, p_71903_3_, p_71903_4_, j);
            p_71903_1_.func_72909_d(p_71903_2_, p_71903_3_, p_71903_4_, p_71903_2_, p_71903_3_, p_71903_4_);
        } else
        {
            p_71903_1_.func_72921_c(p_71903_2_, p_71903_3_ - 1, p_71903_4_, j);
            p_71903_1_.func_72909_d(p_71903_2_, p_71903_3_ - 1, p_71903_4_, p_71903_2_, p_71903_3_, p_71903_4_);
        }
        p_71903_1_.func_72889_a(p_71903_5_, 1003, p_71903_2_, p_71903_3_, p_71903_4_, 0);
        return true;
    }

    public void func_72231_a(World p_72231_1_, int p_72231_2_, int p_72231_3_, int p_72231_4_, boolean p_72231_5_)
    {
        int i = func_72234_b_(p_72231_1_, p_72231_2_, p_72231_3_, p_72231_4_);
        boolean flag = (i & 4) != 0;
        if(flag == p_72231_5_)
        {
            return;
        }
        int j = i & 7;
        j ^= 4;
        if((i & 8) == 0)
        {
            p_72231_1_.func_72921_c(p_72231_2_, p_72231_3_, p_72231_4_, j);
            p_72231_1_.func_72909_d(p_72231_2_, p_72231_3_, p_72231_4_, p_72231_2_, p_72231_3_, p_72231_4_);
        } else
        {
            p_72231_1_.func_72921_c(p_72231_2_, p_72231_3_ - 1, p_72231_4_, j);
            p_72231_1_.func_72909_d(p_72231_2_, p_72231_3_ - 1, p_72231_4_, p_72231_2_, p_72231_3_, p_72231_4_);
        }
        p_72231_1_.func_72889_a(null, 1003, p_72231_2_, p_72231_3_, p_72231_4_, 0);
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        int i = p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_);
        if((i & 8) == 0)
        {
            boolean flag = false;
            if(p_71863_1_.func_72798_a(p_71863_2_, p_71863_3_ + 1, p_71863_4_) != field_71990_ca)
            {
                p_71863_1_.func_72859_e(p_71863_2_, p_71863_3_, p_71863_4_, 0);
                flag = true;
            }
            if(!p_71863_1_.func_72797_t(p_71863_2_, p_71863_3_ - 1, p_71863_4_))
            {
                p_71863_1_.func_72859_e(p_71863_2_, p_71863_3_, p_71863_4_, 0);
                flag = true;
                if(p_71863_1_.func_72798_a(p_71863_2_, p_71863_3_ + 1, p_71863_4_) == field_71990_ca)
                {
                    p_71863_1_.func_72859_e(p_71863_2_, p_71863_3_ + 1, p_71863_4_, 0);
                }
            }
            if(flag)
            {
                if(!p_71863_1_.field_72995_K)
                {
                    func_71897_c(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, i, 0);
                }
            } else
            {
                boolean flag1 = p_71863_1_.func_72864_z(p_71863_2_, p_71863_3_, p_71863_4_) || p_71863_1_.func_72864_z(p_71863_2_, p_71863_3_ + 1, p_71863_4_);
                if((flag1 || p_71863_5_ > 0 && Block.field_71973_m[p_71863_5_].func_71853_i() || p_71863_5_ == 0) && p_71863_5_ != field_71990_ca)
                {
                    func_72231_a(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, flag1);
                }
            }
        } else
        {
            if(p_71863_1_.func_72798_a(p_71863_2_, p_71863_3_ - 1, p_71863_4_) != field_71990_ca)
            {
                p_71863_1_.func_72859_e(p_71863_2_, p_71863_3_, p_71863_4_, 0);
            }
            if(p_71863_5_ > 0 && p_71863_5_ != field_71990_ca)
            {
                func_71863_a(p_71863_1_, p_71863_2_, p_71863_3_ - 1, p_71863_4_, p_71863_5_);
            }
        }
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        if((p_71885_1_ & 8) != 0)
        {
            return 0;
        }
        if(field_72018_cp == Material.field_76243_f)
        {
            return Item.field_77766_aB.field_77779_bT;
        } else
        {
            return Item.field_77790_av.field_77779_bT;
        }
    }

    public MovingObjectPosition func_71878_a(World p_71878_1_, int p_71878_2_, int p_71878_3_, int p_71878_4_, Vec3 p_71878_5_, Vec3 p_71878_6_)
    {
        func_71902_a(p_71878_1_, p_71878_2_, p_71878_3_, p_71878_4_);
        return super.func_71878_a(p_71878_1_, p_71878_2_, p_71878_3_, p_71878_4_, p_71878_5_, p_71878_6_);
    }

    public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_)
    {
        if(p_71930_3_ >= 255)
        {
            return false;
        } else
        {
            return p_71930_1_.func_72797_t(p_71930_2_, p_71930_3_ - 1, p_71930_4_) && super.func_71930_b(p_71930_1_, p_71930_2_, p_71930_3_, p_71930_4_) && super.func_71930_b(p_71930_1_, p_71930_2_, p_71930_3_ + 1, p_71930_4_);
        }
    }

    public int func_71915_e()
    {
        return 1;
    }

    public int func_72234_b_(IBlockAccess p_72234_1_, int p_72234_2_, int p_72234_3_, int p_72234_4_)
    {
        int i = p_72234_1_.func_72805_g(p_72234_2_, p_72234_3_, p_72234_4_);
        boolean flag = (i & 8) != 0;
        int j;
        int k;
        if(flag)
        {
            j = p_72234_1_.func_72805_g(p_72234_2_, p_72234_3_ - 1, p_72234_4_);
            k = i;
        } else
        {
            j = i;
            k = p_72234_1_.func_72805_g(p_72234_2_, p_72234_3_ + 1, p_72234_4_);
        }
        boolean flag1 = (k & 1) != 0;
        return j & 7 | (flag ? 8 : 0) | (flag1 ? 0x10 : 0);
    }

    public int func_71922_a(World p_71922_1_, int p_71922_2_, int p_71922_3_, int p_71922_4_)
    {
        return field_72018_cp != Material.field_76243_f ? Item.field_77790_av.field_77779_bT : Item.field_77766_aB.field_77779_bT;
    }
}
