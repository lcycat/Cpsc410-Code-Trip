// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, CreativeTabs, World, 
//            AxisAlignedBB, Vec3, MovingObjectPosition

public class BlockTorch extends Block
{

    protected BlockTorch(int p_i4013_1_, int p_i4013_2_)
    {
        super(p_i4013_1_, p_i4013_2_, Material.field_76265_p);
        func_71907_b(true);
        func_71849_a(CreativeTabs.field_78031_c);
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
        return 2;
    }

    private boolean func_72125_l(World p_72125_1_, int p_72125_2_, int p_72125_3_, int p_72125_4_)
    {
        if(p_72125_1_.func_72797_t(p_72125_2_, p_72125_3_, p_72125_4_))
        {
            return true;
        }
        int i = p_72125_1_.func_72798_a(p_72125_2_, p_72125_3_, p_72125_4_);
        return i == Block.field_72031_aZ.field_71990_ca || i == Block.field_72098_bB.field_71990_ca || i == Block.field_71946_M.field_71990_ca;
    }

    public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_)
    {
        if(p_71930_1_.func_72887_b(p_71930_2_ - 1, p_71930_3_, p_71930_4_, true))
        {
            return true;
        }
        if(p_71930_1_.func_72887_b(p_71930_2_ + 1, p_71930_3_, p_71930_4_, true))
        {
            return true;
        }
        if(p_71930_1_.func_72887_b(p_71930_2_, p_71930_3_, p_71930_4_ - 1, true))
        {
            return true;
        }
        if(p_71930_1_.func_72887_b(p_71930_2_, p_71930_3_, p_71930_4_ + 1, true))
        {
            return true;
        }
        return func_72125_l(p_71930_1_, p_71930_2_, p_71930_3_ - 1, p_71930_4_);
    }

    public void func_71909_a(World p_71909_1_, int p_71909_2_, int p_71909_3_, int p_71909_4_, int p_71909_5_, float p_71909_6_, float p_71909_7_, 
            float p_71909_8_)
    {
        int i = p_71909_1_.func_72805_g(p_71909_2_, p_71909_3_, p_71909_4_);
        if(p_71909_5_ == 1 && func_72125_l(p_71909_1_, p_71909_2_, p_71909_3_ - 1, p_71909_4_))
        {
            i = 5;
        }
        if(p_71909_5_ == 2 && p_71909_1_.func_72887_b(p_71909_2_, p_71909_3_, p_71909_4_ + 1, true))
        {
            i = 4;
        }
        if(p_71909_5_ == 3 && p_71909_1_.func_72887_b(p_71909_2_, p_71909_3_, p_71909_4_ - 1, true))
        {
            i = 3;
        }
        if(p_71909_5_ == 4 && p_71909_1_.func_72887_b(p_71909_2_ + 1, p_71909_3_, p_71909_4_, true))
        {
            i = 2;
        }
        if(p_71909_5_ == 5 && p_71909_1_.func_72887_b(p_71909_2_ - 1, p_71909_3_, p_71909_4_, true))
        {
            i = 1;
        }
        p_71909_1_.func_72921_c(p_71909_2_, p_71909_3_, p_71909_4_, i);
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_)
    {
        super.func_71847_b(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_, p_71847_5_);
        if(p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_) == 0)
        {
            func_71861_g(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_);
        }
    }

    public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_)
    {
        if(p_71861_1_.func_72887_b(p_71861_2_ - 1, p_71861_3_, p_71861_4_, true))
        {
            p_71861_1_.func_72921_c(p_71861_2_, p_71861_3_, p_71861_4_, 1);
        } else
        if(p_71861_1_.func_72887_b(p_71861_2_ + 1, p_71861_3_, p_71861_4_, true))
        {
            p_71861_1_.func_72921_c(p_71861_2_, p_71861_3_, p_71861_4_, 2);
        } else
        if(p_71861_1_.func_72887_b(p_71861_2_, p_71861_3_, p_71861_4_ - 1, true))
        {
            p_71861_1_.func_72921_c(p_71861_2_, p_71861_3_, p_71861_4_, 3);
        } else
        if(p_71861_1_.func_72887_b(p_71861_2_, p_71861_3_, p_71861_4_ + 1, true))
        {
            p_71861_1_.func_72921_c(p_71861_2_, p_71861_3_, p_71861_4_, 4);
        } else
        if(func_72125_l(p_71861_1_, p_71861_2_, p_71861_3_ - 1, p_71861_4_))
        {
            p_71861_1_.func_72921_c(p_71861_2_, p_71861_3_, p_71861_4_, 5);
        }
        func_72126_n(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        if(func_72126_n(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_))
        {
            int i = p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_);
            boolean flag = false;
            if(!p_71863_1_.func_72887_b(p_71863_2_ - 1, p_71863_3_, p_71863_4_, true) && i == 1)
            {
                flag = true;
            }
            if(!p_71863_1_.func_72887_b(p_71863_2_ + 1, p_71863_3_, p_71863_4_, true) && i == 2)
            {
                flag = true;
            }
            if(!p_71863_1_.func_72887_b(p_71863_2_, p_71863_3_, p_71863_4_ - 1, true) && i == 3)
            {
                flag = true;
            }
            if(!p_71863_1_.func_72887_b(p_71863_2_, p_71863_3_, p_71863_4_ + 1, true) && i == 4)
            {
                flag = true;
            }
            if(!func_72125_l(p_71863_1_, p_71863_2_, p_71863_3_ - 1, p_71863_4_) && i == 5)
            {
                flag = true;
            }
            if(flag)
            {
                func_71897_c(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_), 0);
                p_71863_1_.func_72859_e(p_71863_2_, p_71863_3_, p_71863_4_, 0);
            }
        }
    }

    private boolean func_72126_n(World p_72126_1_, int p_72126_2_, int p_72126_3_, int p_72126_4_)
    {
        if(!func_71930_b(p_72126_1_, p_72126_2_, p_72126_3_, p_72126_4_))
        {
            if(p_72126_1_.func_72798_a(p_72126_2_, p_72126_3_, p_72126_4_) == field_71990_ca)
            {
                func_71897_c(p_72126_1_, p_72126_2_, p_72126_3_, p_72126_4_, p_72126_1_.func_72805_g(p_72126_2_, p_72126_3_, p_72126_4_), 0);
                p_72126_1_.func_72859_e(p_72126_2_, p_72126_3_, p_72126_4_, 0);
            }
            return false;
        } else
        {
            return true;
        }
    }

    public MovingObjectPosition func_71878_a(World p_71878_1_, int p_71878_2_, int p_71878_3_, int p_71878_4_, Vec3 p_71878_5_, Vec3 p_71878_6_)
    {
        int i = p_71878_1_.func_72805_g(p_71878_2_, p_71878_3_, p_71878_4_) & 7;
        float f = 0.15F;
        if(i == 1)
        {
            func_71905_a(0.0F, 0.2F, 0.5F - f, f * 2.0F, 0.8F, 0.5F + f);
        } else
        if(i == 2)
        {
            func_71905_a(1.0F - f * 2.0F, 0.2F, 0.5F - f, 1.0F, 0.8F, 0.5F + f);
        } else
        if(i == 3)
        {
            func_71905_a(0.5F - f, 0.2F, 0.0F, 0.5F + f, 0.8F, f * 2.0F);
        } else
        if(i == 4)
        {
            func_71905_a(0.5F - f, 0.2F, 1.0F - f * 2.0F, 0.5F + f, 0.8F, 1.0F);
        } else
        {
            float f1 = 0.1F;
            func_71905_a(0.5F - f1, 0.0F, 0.5F - f1, 0.5F + f1, 0.6F, 0.5F + f1);
        }
        return super.func_71878_a(p_71878_1_, p_71878_2_, p_71878_3_, p_71878_4_, p_71878_5_, p_71878_6_);
    }

    public void func_71862_a(World p_71862_1_, int p_71862_2_, int p_71862_3_, int p_71862_4_, Random p_71862_5_)
    {
        int i = p_71862_1_.func_72805_g(p_71862_2_, p_71862_3_, p_71862_4_);
        double d = (float)p_71862_2_ + 0.5F;
        double d1 = (float)p_71862_3_ + 0.7F;
        double d2 = (float)p_71862_4_ + 0.5F;
        double d3 = 0.2199999988079071D;
        double d4 = 0.27000001072883606D;
        if(i == 1)
        {
            p_71862_1_.func_72869_a("smoke", d - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
            p_71862_1_.func_72869_a("flame", d - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
        } else
        if(i == 2)
        {
            p_71862_1_.func_72869_a("smoke", d + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
            p_71862_1_.func_72869_a("flame", d + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
        } else
        if(i == 3)
        {
            p_71862_1_.func_72869_a("smoke", d, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
            p_71862_1_.func_72869_a("flame", d, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
        } else
        if(i == 4)
        {
            p_71862_1_.func_72869_a("smoke", d, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
            p_71862_1_.func_72869_a("flame", d, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
        } else
        {
            p_71862_1_.func_72869_a("smoke", d, d1, d2, 0.0D, 0.0D, 0.0D);
            p_71862_1_.func_72869_a("flame", d, d1, d2, 0.0D, 0.0D, 0.0D);
        }
    }
}
