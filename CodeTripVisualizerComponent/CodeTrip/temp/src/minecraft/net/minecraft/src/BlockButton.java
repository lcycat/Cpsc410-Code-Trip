// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, CreativeTabs, World, 
//            IBlockAccess, AxisAlignedBB, EntityPlayer

public class BlockButton extends Block
{

    protected BlockButton(int p_i3924_1_, int p_i3924_2_)
    {
        super(p_i3924_1_, p_i3924_2_, Material.field_76265_p);
        func_71907_b(true);
        func_71849_a(CreativeTabs.field_78028_d);
    }

    public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int i)
    {
        return null;
    }

    public int func_71859_p_()
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
        int i = p_71909_1_.func_72805_g(p_71909_2_, p_71909_3_, p_71909_4_);
        int j = i & 8;
        i &= 7;
        if(p_71909_5_ == 2 && p_71909_1_.func_72809_s(p_71909_2_, p_71909_3_, p_71909_4_ + 1))
        {
            i = 4;
        } else
        if(p_71909_5_ == 3 && p_71909_1_.func_72809_s(p_71909_2_, p_71909_3_, p_71909_4_ - 1))
        {
            i = 3;
        } else
        if(p_71909_5_ == 4 && p_71909_1_.func_72809_s(p_71909_2_ + 1, p_71909_3_, p_71909_4_))
        {
            i = 2;
        } else
        if(p_71909_5_ == 5 && p_71909_1_.func_72809_s(p_71909_2_ - 1, p_71909_3_, p_71909_4_))
        {
            i = 1;
        } else
        {
            i = func_72260_l(p_71909_1_, p_71909_2_, p_71909_3_, p_71909_4_);
        }
        p_71909_1_.func_72921_c(p_71909_2_, p_71909_3_, p_71909_4_, i + j);
    }

    private int func_72260_l(World p_72260_1_, int p_72260_2_, int p_72260_3_, int p_72260_4_)
    {
        if(p_72260_1_.func_72809_s(p_72260_2_ - 1, p_72260_3_, p_72260_4_))
        {
            return 1;
        }
        if(p_72260_1_.func_72809_s(p_72260_2_ + 1, p_72260_3_, p_72260_4_))
        {
            return 2;
        }
        if(p_72260_1_.func_72809_s(p_72260_2_, p_72260_3_, p_72260_4_ - 1))
        {
            return 3;
        }
        return !p_72260_1_.func_72809_s(p_72260_2_, p_72260_3_, p_72260_4_ + 1) ? 1 : 4;
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        if(func_72261_n(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_))
        {
            int i = p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_) & 7;
            boolean flag = false;
            if(!p_71863_1_.func_72809_s(p_71863_2_ - 1, p_71863_3_, p_71863_4_) && i == 1)
            {
                flag = true;
            }
            if(!p_71863_1_.func_72809_s(p_71863_2_ + 1, p_71863_3_, p_71863_4_) && i == 2)
            {
                flag = true;
            }
            if(!p_71863_1_.func_72809_s(p_71863_2_, p_71863_3_, p_71863_4_ - 1) && i == 3)
            {
                flag = true;
            }
            if(!p_71863_1_.func_72809_s(p_71863_2_, p_71863_3_, p_71863_4_ + 1) && i == 4)
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

    private boolean func_72261_n(World p_72261_1_, int p_72261_2_, int p_72261_3_, int p_72261_4_)
    {
        if(!func_71930_b(p_72261_1_, p_72261_2_, p_72261_3_, p_72261_4_))
        {
            func_71897_c(p_72261_1_, p_72261_2_, p_72261_3_, p_72261_4_, p_72261_1_.func_72805_g(p_72261_2_, p_72261_3_, p_72261_4_), 0);
            p_72261_1_.func_72859_e(p_72261_2_, p_72261_3_, p_72261_4_, 0);
            return false;
        } else
        {
            return true;
        }
    }

    public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_)
    {
        int i = p_71902_1_.func_72805_g(p_71902_2_, p_71902_3_, p_71902_4_);
        int j = i & 7;
        boolean flag = (i & 8) > 0;
        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.1875F;
        float f3 = 0.125F;
        if(flag)
        {
            f3 = 0.0625F;
        }
        if(j == 1)
        {
            func_71905_a(0.0F, f, 0.5F - f2, f3, f1, 0.5F + f2);
        } else
        if(j == 2)
        {
            func_71905_a(1.0F - f3, f, 0.5F - f2, 1.0F, f1, 0.5F + f2);
        } else
        if(j == 3)
        {
            func_71905_a(0.5F - f2, f, 0.0F, 0.5F + f2, f1, f3);
        } else
        if(j == 4)
        {
            func_71905_a(0.5F - f2, f, 1.0F - f3, 0.5F + f2, f1, 1.0F);
        }
    }

    public void func_71921_a(World p_71921_1_, int p_71921_2_, int p_71921_3_, int p_71921_4_, EntityPlayer p_71921_5_)
    {
        func_71903_a(p_71921_1_, p_71921_2_, p_71921_3_, p_71921_4_, p_71921_5_, 0, 0.0F, 0.0F, 0.0F);
    }

    public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, 
            float p_71903_8_, float p_71903_9_)
    {
        int i = p_71903_1_.func_72805_g(p_71903_2_, p_71903_3_, p_71903_4_);
        int j = i & 7;
        int k = 8 - (i & 8);
        if(k == 0)
        {
            return true;
        }
        p_71903_1_.func_72921_c(p_71903_2_, p_71903_3_, p_71903_4_, j + k);
        p_71903_1_.func_72909_d(p_71903_2_, p_71903_3_, p_71903_4_, p_71903_2_, p_71903_3_, p_71903_4_);
        p_71903_1_.func_72908_a((double)p_71903_2_ + 0.5D, (double)p_71903_3_ + 0.5D, (double)p_71903_4_ + 0.5D, "random.click", 0.3F, 0.6F);
        p_71903_1_.func_72898_h(p_71903_2_, p_71903_3_, p_71903_4_, field_71990_ca);
        if(j == 1)
        {
            p_71903_1_.func_72898_h(p_71903_2_ - 1, p_71903_3_, p_71903_4_, field_71990_ca);
        } else
        if(j == 2)
        {
            p_71903_1_.func_72898_h(p_71903_2_ + 1, p_71903_3_, p_71903_4_, field_71990_ca);
        } else
        if(j == 3)
        {
            p_71903_1_.func_72898_h(p_71903_2_, p_71903_3_, p_71903_4_ - 1, field_71990_ca);
        } else
        if(j == 4)
        {
            p_71903_1_.func_72898_h(p_71903_2_, p_71903_3_, p_71903_4_ + 1, field_71990_ca);
        } else
        {
            p_71903_1_.func_72898_h(p_71903_2_, p_71903_3_ - 1, p_71903_4_, field_71990_ca);
        }
        p_71903_1_.func_72836_a(p_71903_2_, p_71903_3_, p_71903_4_, field_71990_ca, func_71859_p_());
        return true;
    }

    public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_)
    {
        if((p_71852_6_ & 8) > 0)
        {
            p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_, p_71852_4_, field_71990_ca);
            int i = p_71852_6_ & 7;
            if(i == 1)
            {
                p_71852_1_.func_72898_h(p_71852_2_ - 1, p_71852_3_, p_71852_4_, field_71990_ca);
            } else
            if(i == 2)
            {
                p_71852_1_.func_72898_h(p_71852_2_ + 1, p_71852_3_, p_71852_4_, field_71990_ca);
            } else
            if(i == 3)
            {
                p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_, p_71852_4_ - 1, field_71990_ca);
            } else
            if(i == 4)
            {
                p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_, p_71852_4_ + 1, field_71990_ca);
            } else
            {
                p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_ - 1, p_71852_4_, field_71990_ca);
            }
        }
        super.func_71852_a(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_, p_71852_5_, p_71852_6_);
    }

    public boolean func_71865_a(IBlockAccess p_71865_1_, int p_71865_2_, int p_71865_3_, int p_71865_4_, int p_71865_5_)
    {
        return (p_71865_1_.func_72805_g(p_71865_2_, p_71865_3_, p_71865_4_) & 8) > 0;
    }

    public boolean func_71855_c(World p_71855_1_, int p_71855_2_, int p_71855_3_, int p_71855_4_, int p_71855_5_)
    {
        int i = p_71855_1_.func_72805_g(p_71855_2_, p_71855_3_, p_71855_4_);
        if((i & 8) == 0)
        {
            return false;
        }
        int j = i & 7;
        if(j == 5 && p_71855_5_ == 1)
        {
            return true;
        }
        if(j == 4 && p_71855_5_ == 2)
        {
            return true;
        }
        if(j == 3 && p_71855_5_ == 3)
        {
            return true;
        }
        if(j == 2 && p_71855_5_ == 4)
        {
            return true;
        }
        return j == 1 && p_71855_5_ == 5;
    }

    public boolean func_71853_i()
    {
        return true;
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_)
    {
        if(p_71847_1_.field_72995_K)
        {
            return;
        }
        int i = p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_);
        if((i & 8) == 0)
        {
            return;
        }
        p_71847_1_.func_72921_c(p_71847_2_, p_71847_3_, p_71847_4_, i & 7);
        p_71847_1_.func_72898_h(p_71847_2_, p_71847_3_, p_71847_4_, field_71990_ca);
        int j = i & 7;
        if(j == 1)
        {
            p_71847_1_.func_72898_h(p_71847_2_ - 1, p_71847_3_, p_71847_4_, field_71990_ca);
        } else
        if(j == 2)
        {
            p_71847_1_.func_72898_h(p_71847_2_ + 1, p_71847_3_, p_71847_4_, field_71990_ca);
        } else
        if(j == 3)
        {
            p_71847_1_.func_72898_h(p_71847_2_, p_71847_3_, p_71847_4_ - 1, field_71990_ca);
        } else
        if(j == 4)
        {
            p_71847_1_.func_72898_h(p_71847_2_, p_71847_3_, p_71847_4_ + 1, field_71990_ca);
        } else
        {
            p_71847_1_.func_72898_h(p_71847_2_, p_71847_3_ - 1, p_71847_4_, field_71990_ca);
        }
        p_71847_1_.func_72908_a((double)p_71847_2_ + 0.5D, (double)p_71847_3_ + 0.5D, (double)p_71847_4_ + 0.5D, "random.click", 0.3F, 0.5F);
        p_71847_1_.func_72909_d(p_71847_2_, p_71847_3_, p_71847_4_, p_71847_2_, p_71847_3_, p_71847_4_);
    }

    public void func_71919_f()
    {
        float f = 0.1875F;
        float f1 = 0.125F;
        float f2 = 0.125F;
        func_71905_a(0.5F - f, 0.5F - f1, 0.5F - f2, 0.5F + f, 0.5F + f1, 0.5F + f2);
    }
}
