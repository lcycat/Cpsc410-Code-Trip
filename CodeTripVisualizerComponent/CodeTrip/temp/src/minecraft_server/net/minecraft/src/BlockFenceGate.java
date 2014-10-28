// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            BlockDirectional, Material, CreativeTabs, World, 
//            AxisAlignedBB, AABBPool, IBlockAccess, EntityLiving, 
//            MathHelper, EntityPlayer, Block

public class BlockFenceGate extends BlockDirectional
{

    public BlockFenceGate(int p_i3946_1_, int p_i3946_2_)
    {
        super(p_i3946_1_, p_i3946_2_, Material.field_76245_d);
        func_71849_a(CreativeTabs.field_78028_d);
    }

    public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_)
    {
        if(!p_71930_1_.func_72803_f(p_71930_2_, p_71930_3_ - 1, p_71930_4_).func_76220_a())
        {
            return false;
        } else
        {
            return super.func_71930_b(p_71930_1_, p_71930_2_, p_71930_3_, p_71930_4_);
        }
    }

    public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_)
    {
        int i = p_71872_1_.func_72805_g(p_71872_2_, p_71872_3_, p_71872_4_);
        if(func_72224_c(i))
        {
            return null;
        }
        if(i == 2 || i == 0)
        {
            return AxisAlignedBB.func_72332_a().func_72299_a(p_71872_2_, p_71872_3_, (float)p_71872_4_ + 0.375F, p_71872_2_ + 1, (float)p_71872_3_ + 1.5F, (float)p_71872_4_ + 0.625F);
        } else
        {
            return AxisAlignedBB.func_72332_a().func_72299_a((float)p_71872_2_ + 0.375F, p_71872_3_, p_71872_4_, (float)p_71872_2_ + 0.625F, (float)p_71872_3_ + 1.5F, p_71872_4_ + 1);
        }
    }

    public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_)
    {
        int i = func_72217_d(p_71902_1_.func_72805_g(p_71902_2_, p_71902_3_, p_71902_4_));
        if(i == 2 || i == 0)
        {
            func_71905_a(0.0F, 0.0F, 0.375F, 1.0F, 1.0F, 0.625F);
        } else
        {
            func_71905_a(0.375F, 0.0F, 0.0F, 0.625F, 1.0F, 1.0F);
        }
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
        return func_72224_c(p_71918_1_.func_72805_g(p_71918_2_, p_71918_3_, p_71918_4_));
    }

    public int func_71857_b()
    {
        return 21;
    }

    public void func_71860_a(World p_71860_1_, int p_71860_2_, int p_71860_3_, int p_71860_4_, EntityLiving p_71860_5_)
    {
        int i = (MathHelper.func_76128_c((double)((p_71860_5_.field_70177_z * 4F) / 360F) + 0.5D) & 3) % 4;
        p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, i);
    }

    public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, 
            float p_71903_8_, float p_71903_9_)
    {
        int i = p_71903_1_.func_72805_g(p_71903_2_, p_71903_3_, p_71903_4_);
        if(func_72224_c(i))
        {
            p_71903_1_.func_72921_c(p_71903_2_, p_71903_3_, p_71903_4_, i & -5);
        } else
        {
            int j = (MathHelper.func_76128_c((double)((p_71903_5_.field_70177_z * 4F) / 360F) + 0.5D) & 3) % 4;
            int k = func_72217_d(i);
            if(k == (j + 2) % 4)
            {
                i = j;
            }
            p_71903_1_.func_72921_c(p_71903_2_, p_71903_3_, p_71903_4_, i | 4);
        }
        p_71903_1_.func_72889_a(p_71903_5_, 1003, p_71903_2_, p_71903_3_, p_71903_4_, 0);
        return true;
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        if(p_71863_1_.field_72995_K)
        {
            return;
        }
        int i = p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_);
        boolean flag = p_71863_1_.func_72864_z(p_71863_2_, p_71863_3_, p_71863_4_);
        if(flag || p_71863_5_ > 0 && Block.field_71973_m[p_71863_5_].func_71853_i() || p_71863_5_ == 0)
        {
            if(flag && !func_72224_c(i))
            {
                p_71863_1_.func_72921_c(p_71863_2_, p_71863_3_, p_71863_4_, i | 4);
                p_71863_1_.func_72889_a(null, 1003, p_71863_2_, p_71863_3_, p_71863_4_, 0);
            } else
            if(!flag && func_72224_c(i))
            {
                p_71863_1_.func_72921_c(p_71863_2_, p_71863_3_, p_71863_4_, i & -5);
                p_71863_1_.func_72889_a(null, 1003, p_71863_2_, p_71863_3_, p_71863_4_, 0);
            }
        }
    }

    public static boolean func_72224_c(int p_72224_0_)
    {
        return (p_72224_0_ & 4) != 0;
    }
}
