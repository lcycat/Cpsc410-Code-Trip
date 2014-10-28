// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, World, Material, CreativeTabs, 
//            IBlockAccess, RailLogic, AxisAlignedBB, Vec3, 
//            MovingObjectPosition

public class BlockRail extends Block
{

    private final boolean field_72186_a;

    public static final boolean func_72180_d_(World p_72180_0_, int p_72180_1_, int p_72180_2_, int p_72180_3_)
    {
        int i = p_72180_0_.func_72798_a(p_72180_1_, p_72180_2_, p_72180_3_);
        return i == Block.field_72056_aG.field_71990_ca || i == Block.field_71954_T.field_71990_ca || i == Block.field_71953_U.field_71990_ca;
    }

    public static final boolean func_72184_d(int p_72184_0_)
    {
        return p_72184_0_ == Block.field_72056_aG.field_71990_ca || p_72184_0_ == Block.field_71954_T.field_71990_ca || p_72184_0_ == Block.field_71953_U.field_71990_ca;
    }

    protected BlockRail(int p_i3984_1_, int p_i3984_2_, boolean p_i3984_3_)
    {
        super(p_i3984_1_, p_i3984_2_, Material.field_76265_p);
        field_72186_a = p_i3984_3_;
        func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
        func_71849_a(CreativeTabs.field_78029_e);
    }

    public boolean func_72183_n()
    {
        return field_72186_a;
    }

    public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int i)
    {
        return null;
    }

    public boolean func_71926_d()
    {
        return false;
    }

    public MovingObjectPosition func_71878_a(World p_71878_1_, int p_71878_2_, int p_71878_3_, int p_71878_4_, Vec3 p_71878_5_, Vec3 p_71878_6_)
    {
        func_71902_a(p_71878_1_, p_71878_2_, p_71878_3_, p_71878_4_);
        return super.func_71878_a(p_71878_1_, p_71878_2_, p_71878_3_, p_71878_4_, p_71878_5_, p_71878_6_);
    }

    public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_)
    {
        int i = p_71902_1_.func_72805_g(p_71902_2_, p_71902_3_, p_71902_4_);
        if(i >= 2 && i <= 5)
        {
            func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.625F, 1.0F);
        } else
        {
            func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
        }
    }

    public int func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        if(field_72186_a)
        {
            if(field_71990_ca == Block.field_71954_T.field_71990_ca && (p_71858_2_ & 8) == 0)
            {
                return field_72059_bZ - 16;
            }
        } else
        if(p_71858_2_ >= 6)
        {
            return field_72059_bZ - 16;
        }
        return field_72059_bZ;
    }

    public boolean func_71886_c()
    {
        return false;
    }

    public int func_71857_b()
    {
        return 9;
    }

    public int func_71925_a(Random p_71925_1_)
    {
        return 1;
    }

    public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_)
    {
        return p_71930_1_.func_72797_t(p_71930_2_, p_71930_3_ - 1, p_71930_4_);
    }

    public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_)
    {
        if(!p_71861_1_.field_72995_K)
        {
            func_72181_a(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_, true);
            if(field_71990_ca == Block.field_71954_T.field_71990_ca)
            {
                func_71863_a(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_, field_71990_ca);
            }
        }
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        if(p_71863_1_.field_72995_K)
        {
            return;
        }
        int i = p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_);
        int j = i;
        if(field_72186_a)
        {
            j &= 7;
        }
        boolean flag = false;
        if(!p_71863_1_.func_72797_t(p_71863_2_, p_71863_3_ - 1, p_71863_4_))
        {
            flag = true;
        }
        if(j == 2 && !p_71863_1_.func_72797_t(p_71863_2_ + 1, p_71863_3_, p_71863_4_))
        {
            flag = true;
        }
        if(j == 3 && !p_71863_1_.func_72797_t(p_71863_2_ - 1, p_71863_3_, p_71863_4_))
        {
            flag = true;
        }
        if(j == 4 && !p_71863_1_.func_72797_t(p_71863_2_, p_71863_3_, p_71863_4_ - 1))
        {
            flag = true;
        }
        if(j == 5 && !p_71863_1_.func_72797_t(p_71863_2_, p_71863_3_, p_71863_4_ + 1))
        {
            flag = true;
        }
        if(flag)
        {
            func_71897_c(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_), 0);
            p_71863_1_.func_72859_e(p_71863_2_, p_71863_3_, p_71863_4_, 0);
        } else
        if(field_71990_ca == Block.field_71954_T.field_71990_ca)
        {
            boolean flag1 = p_71863_1_.func_72864_z(p_71863_2_, p_71863_3_, p_71863_4_);
            flag1 = flag1 || func_72182_a(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, i, true, 0) || func_72182_a(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, i, false, 0);
            boolean flag2 = false;
            if(flag1 && (i & 8) == 0)
            {
                p_71863_1_.func_72921_c(p_71863_2_, p_71863_3_, p_71863_4_, j | 8);
                flag2 = true;
            } else
            if(!flag1 && (i & 8) != 0)
            {
                p_71863_1_.func_72921_c(p_71863_2_, p_71863_3_, p_71863_4_, j);
                flag2 = true;
            }
            if(flag2)
            {
                p_71863_1_.func_72898_h(p_71863_2_, p_71863_3_ - 1, p_71863_4_, field_71990_ca);
                if(j == 2 || j == 3 || j == 4 || j == 5)
                {
                    p_71863_1_.func_72898_h(p_71863_2_, p_71863_3_ + 1, p_71863_4_, field_71990_ca);
                }
            }
        } else
        if(p_71863_5_ > 0 && Block.field_71973_m[p_71863_5_].func_71853_i() && !field_72186_a && RailLogic.func_73650_a(new RailLogic(this, p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_)) == 3)
        {
            func_72181_a(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, false);
        }
    }

    private void func_72181_a(World p_72181_1_, int p_72181_2_, int p_72181_3_, int p_72181_4_, boolean p_72181_5_)
    {
        if(p_72181_1_.field_72995_K)
        {
            return;
        } else
        {
            (new RailLogic(this, p_72181_1_, p_72181_2_, p_72181_3_, p_72181_4_)).func_73652_a(p_72181_1_.func_72864_z(p_72181_2_, p_72181_3_, p_72181_4_), p_72181_5_);
            return;
        }
    }

    private boolean func_72182_a(World p_72182_1_, int p_72182_2_, int p_72182_3_, int p_72182_4_, int p_72182_5_, boolean p_72182_6_, int p_72182_7_)
    {
        if(p_72182_7_ >= 8)
        {
            return false;
        }
        int i = p_72182_5_ & 7;
        boolean flag = true;
        switch(i)
        {
        case 0: // '\0'
            if(p_72182_6_)
            {
                p_72182_4_++;
            } else
            {
                p_72182_4_--;
            }
            break;

        case 1: // '\001'
            if(p_72182_6_)
            {
                p_72182_2_--;
            } else
            {
                p_72182_2_++;
            }
            break;

        case 2: // '\002'
            if(p_72182_6_)
            {
                p_72182_2_--;
            } else
            {
                p_72182_2_++;
                p_72182_3_++;
                flag = false;
            }
            i = 1;
            break;

        case 3: // '\003'
            if(p_72182_6_)
            {
                p_72182_2_--;
                p_72182_3_++;
                flag = false;
            } else
            {
                p_72182_2_++;
            }
            i = 1;
            break;

        case 4: // '\004'
            if(p_72182_6_)
            {
                p_72182_4_++;
            } else
            {
                p_72182_4_--;
                p_72182_3_++;
                flag = false;
            }
            i = 0;
            break;

        case 5: // '\005'
            if(p_72182_6_)
            {
                p_72182_4_++;
                p_72182_3_++;
                flag = false;
            } else
            {
                p_72182_4_--;
            }
            i = 0;
            break;
        }
        if(func_72185_a(p_72182_1_, p_72182_2_, p_72182_3_, p_72182_4_, p_72182_6_, p_72182_7_, i))
        {
            return true;
        }
        return flag && func_72185_a(p_72182_1_, p_72182_2_, p_72182_3_ - 1, p_72182_4_, p_72182_6_, p_72182_7_, i);
    }

    private boolean func_72185_a(World p_72185_1_, int p_72185_2_, int p_72185_3_, int p_72185_4_, boolean p_72185_5_, int p_72185_6_, int p_72185_7_)
    {
        int i = p_72185_1_.func_72798_a(p_72185_2_, p_72185_3_, p_72185_4_);
        if(i == Block.field_71954_T.field_71990_ca)
        {
            int j = p_72185_1_.func_72805_g(p_72185_2_, p_72185_3_, p_72185_4_);
            int k = j & 7;
            if(p_72185_7_ == 1 && (k == 0 || k == 4 || k == 5))
            {
                return false;
            }
            if(p_72185_7_ == 0 && (k == 1 || k == 2 || k == 3))
            {
                return false;
            }
            if((j & 8) != 0)
            {
                if(p_72185_1_.func_72864_z(p_72185_2_, p_72185_3_, p_72185_4_))
                {
                    return true;
                } else
                {
                    return func_72182_a(p_72185_1_, p_72185_2_, p_72185_3_, p_72185_4_, j, p_72185_5_, p_72185_6_ + 1);
                }
            }
        }
        return false;
    }

    public int func_71915_e()
    {
        return 0;
    }

    static boolean func_72179_a(BlockRail p_72179_0_)
    {
        return p_72179_0_.field_72186_a;
    }
}
