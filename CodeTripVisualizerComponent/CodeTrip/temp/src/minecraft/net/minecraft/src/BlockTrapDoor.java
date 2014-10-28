// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, Material, CreativeTabs, IBlockAccess, 
//            World, AxisAlignedBB, EntityPlayer, Vec3, 
//            MovingObjectPosition

public class BlockTrapDoor extends Block
{

    protected BlockTrapDoor(int p_i4015_1_, Material p_i4015_2_)
    {
        super(p_i4015_1_, p_i4015_2_);
        field_72059_bZ = 84;
        if(p_i4015_2_ == Material.field_76243_f)
        {
            field_72059_bZ++;
        }
        float f = 0.5F;
        float f1 = 1.0F;
        func_71905_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
        func_71849_a(CreativeTabs.field_78028_d);
    }

    public boolean func_71926_d()
    {
        return false;
    }

    public boolean func_71886_c()
    {
        return false;
    }

    public boolean func_71918_c(IBlockAccess p_71918_1_, int p_71918_2_, int p_71918_3_, int p_71918_4_)
    {
        return !func_72137_g(p_71918_1_.func_72805_g(p_71918_2_, p_71918_3_, p_71918_4_));
    }

    public int func_71857_b()
    {
        return 0;
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
        func_72139_e(p_71902_1_.func_72805_g(p_71902_2_, p_71902_3_, p_71902_4_));
    }

    public void func_71919_f()
    {
        float f = 0.1875F;
        func_71905_a(0.0F, 0.5F - f / 2.0F, 0.0F, 1.0F, 0.5F + f / 2.0F, 1.0F);
    }

    public void func_72139_e(int p_72139_1_)
    {
        float f = 0.1875F;
        func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
        if(func_72137_g(p_72139_1_))
        {
            if((p_72139_1_ & 3) == 0)
            {
                func_71905_a(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
            }
            if((p_72139_1_ & 3) == 1)
            {
                func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
            }
            if((p_72139_1_ & 3) == 2)
            {
                func_71905_a(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            }
            if((p_72139_1_ & 3) == 3)
            {
                func_71905_a(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
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
        } else
        {
            int i = p_71903_1_.func_72805_g(p_71903_2_, p_71903_3_, p_71903_4_);
            p_71903_1_.func_72921_c(p_71903_2_, p_71903_3_, p_71903_4_, i ^ 4);
            p_71903_1_.func_72889_a(p_71903_5_, 1003, p_71903_2_, p_71903_3_, p_71903_4_, 0);
            return true;
        }
    }

    public void func_72138_a(World p_72138_1_, int p_72138_2_, int p_72138_3_, int p_72138_4_, boolean p_72138_5_)
    {
        int i = p_72138_1_.func_72805_g(p_72138_2_, p_72138_3_, p_72138_4_);
        boolean flag = (i & 4) > 0;
        if(flag == p_72138_5_)
        {
            return;
        } else
        {
            p_72138_1_.func_72921_c(p_72138_2_, p_72138_3_, p_72138_4_, i ^ 4);
            p_72138_1_.func_72889_a(null, 1003, p_72138_2_, p_72138_3_, p_72138_4_, 0);
            return;
        }
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        if(p_71863_1_.field_72995_K)
        {
            return;
        }
        int i = p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_);
        int j = p_71863_2_;
        int k = p_71863_4_;
        if((i & 3) == 0)
        {
            k++;
        }
        if((i & 3) == 1)
        {
            k--;
        }
        if((i & 3) == 2)
        {
            j++;
        }
        if((i & 3) == 3)
        {
            j--;
        }
        if(!func_72140_j(p_71863_1_.func_72798_a(j, p_71863_3_, k)))
        {
            p_71863_1_.func_72859_e(p_71863_2_, p_71863_3_, p_71863_4_, 0);
            func_71897_c(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, i, 0);
        }
        boolean flag = p_71863_1_.func_72864_z(p_71863_2_, p_71863_3_, p_71863_4_);
        if(flag || p_71863_5_ > 0 && Block.field_71973_m[p_71863_5_].func_71853_i() || p_71863_5_ == 0)
        {
            func_72138_a(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, flag);
        }
    }

    public MovingObjectPosition func_71878_a(World p_71878_1_, int p_71878_2_, int p_71878_3_, int p_71878_4_, Vec3 p_71878_5_, Vec3 p_71878_6_)
    {
        func_71902_a(p_71878_1_, p_71878_2_, p_71878_3_, p_71878_4_);
        return super.func_71878_a(p_71878_1_, p_71878_2_, p_71878_3_, p_71878_4_, p_71878_5_, p_71878_6_);
    }

    public void func_71909_a(World p_71909_1_, int p_71909_2_, int p_71909_3_, int p_71909_4_, int p_71909_5_, float p_71909_6_, float p_71909_7_, 
            float p_71909_8_)
    {
        byte byte0 = 0;
        if(p_71909_5_ == 2)
        {
            byte0 = 0;
        }
        if(p_71909_5_ == 3)
        {
            byte0 = 1;
        }
        if(p_71909_5_ == 4)
        {
            byte0 = 2;
        }
        if(p_71909_5_ == 5)
        {
            byte0 = 3;
        }
        p_71909_1_.func_72921_c(p_71909_2_, p_71909_3_, p_71909_4_, byte0);
    }

    public boolean func_71850_a_(World p_71850_1_, int p_71850_2_, int p_71850_3_, int p_71850_4_, int p_71850_5_)
    {
        if(p_71850_5_ == 0)
        {
            return false;
        }
        if(p_71850_5_ == 1)
        {
            return false;
        }
        if(p_71850_5_ == 2)
        {
            p_71850_4_++;
        }
        if(p_71850_5_ == 3)
        {
            p_71850_4_--;
        }
        if(p_71850_5_ == 4)
        {
            p_71850_2_++;
        }
        if(p_71850_5_ == 5)
        {
            p_71850_2_--;
        }
        return func_72140_j(p_71850_1_.func_72798_a(p_71850_2_, p_71850_3_, p_71850_4_));
    }

    public static boolean func_72137_g(int p_72137_0_)
    {
        return (p_72137_0_ & 4) != 0;
    }

    private static boolean func_72140_j(int p_72140_0_)
    {
        if(p_72140_0_ <= 0)
        {
            return false;
        } else
        {
            Block block = Block.field_71973_m[p_72140_0_];
            return block != null && block.field_72018_cp.func_76218_k() && block.func_71886_c() || block == Block.field_72014_bd;
        }
    }
}
