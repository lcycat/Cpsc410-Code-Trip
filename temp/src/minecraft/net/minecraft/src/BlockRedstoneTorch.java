// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            BlockTorch, Block, RedstoneUpdateInfo, World, 
//            IBlockAccess

public class BlockRedstoneTorch extends BlockTorch
{

    private boolean field_72130_a;
    private static Map field_72129_b = new HashMap();

    public int func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        if(p_71858_1_ == 1)
        {
            return Block.field_72075_av.func_71858_a(p_71858_1_, p_71858_2_);
        } else
        {
            return super.func_71858_a(p_71858_1_, p_71858_2_);
        }
    }

    private boolean func_72127_a(World p_72127_1_, int p_72127_2_, int p_72127_3_, int p_72127_4_, boolean p_72127_5_)
    {
        if(!field_72129_b.containsKey(p_72127_1_))
        {
            field_72129_b.put(p_72127_1_, new ArrayList());
        }
        if(p_72127_5_)
        {
            ((List)field_72129_b.get(p_72127_1_)).add(new RedstoneUpdateInfo(p_72127_2_, p_72127_3_, p_72127_4_, p_72127_1_.func_72820_D()));
        }
        int i = 0;
        for(Iterator iterator = ((List)field_72129_b.get(p_72127_1_)).iterator(); iterator.hasNext();)
        {
            RedstoneUpdateInfo redstoneupdateinfo = (RedstoneUpdateInfo)iterator.next();
            if(redstoneupdateinfo.field_73664_a == p_72127_2_ && redstoneupdateinfo.field_73662_b == p_72127_3_ && redstoneupdateinfo.field_73663_c == p_72127_4_ && ++i >= 8)
            {
                return true;
            }
        }

        return false;
    }

    protected BlockRedstoneTorch(int p_i3976_1_, int p_i3976_2_, boolean p_i3976_3_)
    {
        super(p_i3976_1_, p_i3976_2_);
        field_72130_a = false;
        field_72130_a = p_i3976_3_;
        func_71907_b(true);
        func_71849_a(null);
    }

    public int func_71859_p_()
    {
        return 2;
    }

    public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_)
    {
        if(p_71861_1_.func_72805_g(p_71861_2_, p_71861_3_, p_71861_4_) == 0)
        {
            super.func_71861_g(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
        }
        if(field_72130_a)
        {
            p_71861_1_.func_72898_h(p_71861_2_, p_71861_3_ - 1, p_71861_4_, field_71990_ca);
            p_71861_1_.func_72898_h(p_71861_2_, p_71861_3_ + 1, p_71861_4_, field_71990_ca);
            p_71861_1_.func_72898_h(p_71861_2_ - 1, p_71861_3_, p_71861_4_, field_71990_ca);
            p_71861_1_.func_72898_h(p_71861_2_ + 1, p_71861_3_, p_71861_4_, field_71990_ca);
            p_71861_1_.func_72898_h(p_71861_2_, p_71861_3_, p_71861_4_ - 1, field_71990_ca);
            p_71861_1_.func_72898_h(p_71861_2_, p_71861_3_, p_71861_4_ + 1, field_71990_ca);
        }
    }

    public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_)
    {
        if(field_72130_a)
        {
            p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_ - 1, p_71852_4_, field_71990_ca);
            p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_ + 1, p_71852_4_, field_71990_ca);
            p_71852_1_.func_72898_h(p_71852_2_ - 1, p_71852_3_, p_71852_4_, field_71990_ca);
            p_71852_1_.func_72898_h(p_71852_2_ + 1, p_71852_3_, p_71852_4_, field_71990_ca);
            p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_, p_71852_4_ - 1, field_71990_ca);
            p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_, p_71852_4_ + 1, field_71990_ca);
        }
    }

    public boolean func_71865_a(IBlockAccess p_71865_1_, int p_71865_2_, int p_71865_3_, int p_71865_4_, int p_71865_5_)
    {
        if(!field_72130_a)
        {
            return false;
        }
        int i = p_71865_1_.func_72805_g(p_71865_2_, p_71865_3_, p_71865_4_);
        if(i == 5 && p_71865_5_ == 1)
        {
            return false;
        }
        if(i == 3 && p_71865_5_ == 3)
        {
            return false;
        }
        if(i == 4 && p_71865_5_ == 2)
        {
            return false;
        }
        if(i == 1 && p_71865_5_ == 5)
        {
            return false;
        }
        return i != 2 || p_71865_5_ != 4;
    }

    private boolean func_72128_l(World p_72128_1_, int p_72128_2_, int p_72128_3_, int p_72128_4_)
    {
        int i = p_72128_1_.func_72805_g(p_72128_2_, p_72128_3_, p_72128_4_);
        if(i == 5 && p_72128_1_.func_72878_l(p_72128_2_, p_72128_3_ - 1, p_72128_4_, 0))
        {
            return true;
        }
        if(i == 3 && p_72128_1_.func_72878_l(p_72128_2_, p_72128_3_, p_72128_4_ - 1, 2))
        {
            return true;
        }
        if(i == 4 && p_72128_1_.func_72878_l(p_72128_2_, p_72128_3_, p_72128_4_ + 1, 3))
        {
            return true;
        }
        if(i == 1 && p_72128_1_.func_72878_l(p_72128_2_ - 1, p_72128_3_, p_72128_4_, 4))
        {
            return true;
        }
        return i == 2 && p_72128_1_.func_72878_l(p_72128_2_ + 1, p_72128_3_, p_72128_4_, 5);
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_)
    {
        boolean flag = func_72128_l(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_);
        for(List list = (List)field_72129_b.get(p_71847_1_); list != null && !list.isEmpty() && p_71847_1_.func_72820_D() - ((RedstoneUpdateInfo)list.get(0)).field_73661_d > 60L; list.remove(0)) { }
        if(field_72130_a)
        {
            if(flag)
            {
                p_71847_1_.func_72832_d(p_71847_2_, p_71847_3_, p_71847_4_, Block.field_72049_aP.field_71990_ca, p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_));
                if(func_72127_a(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_, true))
                {
                    p_71847_1_.func_72908_a((float)p_71847_2_ + 0.5F, (float)p_71847_3_ + 0.5F, (float)p_71847_4_ + 0.5F, "random.fizz", 0.5F, 2.6F + (p_71847_1_.field_73012_v.nextFloat() - p_71847_1_.field_73012_v.nextFloat()) * 0.8F);
                    for(int i = 0; i < 5; i++)
                    {
                        double d = (double)p_71847_2_ + p_71847_5_.nextDouble() * 0.59999999999999998D + 0.20000000000000001D;
                        double d1 = (double)p_71847_3_ + p_71847_5_.nextDouble() * 0.59999999999999998D + 0.20000000000000001D;
                        double d2 = (double)p_71847_4_ + p_71847_5_.nextDouble() * 0.59999999999999998D + 0.20000000000000001D;
                        p_71847_1_.func_72869_a("smoke", d, d1, d2, 0.0D, 0.0D, 0.0D);
                    }

                }
            }
        } else
        if(!flag && !func_72127_a(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_, false))
        {
            p_71847_1_.func_72832_d(p_71847_2_, p_71847_3_, p_71847_4_, Block.field_72035_aQ.field_71990_ca, p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_));
        }
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        super.func_71863_a(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, p_71863_5_);
        p_71863_1_.func_72836_a(p_71863_2_, p_71863_3_, p_71863_4_, field_71990_ca, func_71859_p_());
    }

    public boolean func_71855_c(World p_71855_1_, int p_71855_2_, int p_71855_3_, int p_71855_4_, int p_71855_5_)
    {
        if(p_71855_5_ == 0)
        {
            return func_71865_a(p_71855_1_, p_71855_2_, p_71855_3_, p_71855_4_, p_71855_5_);
        } else
        {
            return false;
        }
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        return Block.field_72035_aQ.field_71990_ca;
    }

    public boolean func_71853_i()
    {
        return true;
    }

    public void func_71862_a(World p_71862_1_, int p_71862_2_, int p_71862_3_, int p_71862_4_, Random p_71862_5_)
    {
        if(!field_72130_a)
        {
            return;
        }
        int i = p_71862_1_.func_72805_g(p_71862_2_, p_71862_3_, p_71862_4_);
        double d = (double)((float)p_71862_2_ + 0.5F) + (double)(p_71862_5_.nextFloat() - 0.5F) * 0.20000000000000001D;
        double d1 = (double)((float)p_71862_3_ + 0.7F) + (double)(p_71862_5_.nextFloat() - 0.5F) * 0.20000000000000001D;
        double d2 = (double)((float)p_71862_4_ + 0.5F) + (double)(p_71862_5_.nextFloat() - 0.5F) * 0.20000000000000001D;
        double d3 = 0.2199999988079071D;
        double d4 = 0.27000001072883606D;
        if(i == 1)
        {
            p_71862_1_.func_72869_a("reddust", d - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
        } else
        if(i == 2)
        {
            p_71862_1_.func_72869_a("reddust", d + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
        } else
        if(i == 3)
        {
            p_71862_1_.func_72869_a("reddust", d, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
        } else
        if(i == 4)
        {
            p_71862_1_.func_72869_a("reddust", d, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
        } else
        {
            p_71862_1_.func_72869_a("reddust", d, d1, d2, 0.0D, 0.0D, 0.0D);
        }
    }

    public int func_71922_a(World p_71922_1_, int p_71922_2_, int p_71922_3_, int p_71922_4_)
    {
        return Block.field_72035_aQ.field_71990_ca;
    }

    public void func_71937_a(World p_71937_1_, long p_71937_2_, long p_71937_4_)
    {
        List list = (List)field_72129_b.get(p_71937_1_);
        if(list != null)
        {
            for(Iterator iterator = list.iterator(); iterator.hasNext();)
            {
                RedstoneUpdateInfo redstoneupdateinfo = (RedstoneUpdateInfo)iterator.next();
                redstoneupdateinfo.field_73661_d += p_71937_2_;
            }

        }
    }

}
