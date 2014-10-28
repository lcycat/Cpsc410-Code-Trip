// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, Material, CreativeTabs, AxisAlignedBB, 
//            AABBPool, IBlockAccess, World

public class BlockFence extends Block
{

    public BlockFence(int p_i3947_1_, int p_i3947_2_)
    {
        super(p_i3947_1_, p_i3947_2_, Material.field_76245_d);
        func_71849_a(CreativeTabs.field_78031_c);
    }

    public BlockFence(int p_i3948_1_, int p_i3948_2_, Material p_i3948_3_)
    {
        super(p_i3948_1_, p_i3948_2_, p_i3948_3_);
        func_71849_a(CreativeTabs.field_78031_c);
    }

    public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_)
    {
        boolean flag = func_72250_d(p_71872_1_, p_71872_2_, p_71872_3_, p_71872_4_ - 1);
        boolean flag1 = func_72250_d(p_71872_1_, p_71872_2_, p_71872_3_, p_71872_4_ + 1);
        boolean flag2 = func_72250_d(p_71872_1_, p_71872_2_ - 1, p_71872_3_, p_71872_4_);
        boolean flag3 = func_72250_d(p_71872_1_, p_71872_2_ + 1, p_71872_3_, p_71872_4_);
        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.375F;
        float f3 = 0.625F;
        if(flag)
        {
            f2 = 0.0F;
        }
        if(flag1)
        {
            f3 = 1.0F;
        }
        if(flag2)
        {
            f = 0.0F;
        }
        if(flag3)
        {
            f1 = 1.0F;
        }
        return AxisAlignedBB.func_72332_a().func_72299_a((float)p_71872_2_ + f, p_71872_3_, (float)p_71872_4_ + f2, (float)p_71872_2_ + f1, (float)p_71872_3_ + 1.5F, (float)p_71872_4_ + f3);
    }

    public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_)
    {
        boolean flag = func_72250_d(p_71902_1_, p_71902_2_, p_71902_3_, p_71902_4_ - 1);
        boolean flag1 = func_72250_d(p_71902_1_, p_71902_2_, p_71902_3_, p_71902_4_ + 1);
        boolean flag2 = func_72250_d(p_71902_1_, p_71902_2_ - 1, p_71902_3_, p_71902_4_);
        boolean flag3 = func_72250_d(p_71902_1_, p_71902_2_ + 1, p_71902_3_, p_71902_4_);
        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.375F;
        float f3 = 0.625F;
        if(flag)
        {
            f2 = 0.0F;
        }
        if(flag1)
        {
            f3 = 1.0F;
        }
        if(flag2)
        {
            f = 0.0F;
        }
        if(flag3)
        {
            f1 = 1.0F;
        }
        func_71905_a(f, 0.0F, f2, f1, 1.0F, f3);
    }

    public boolean func_71926_d()
    {
        return false;
    }

    public boolean func_71886_c()
    {
        return false;
    }

    public boolean func_71918_c(IBlockAccess p_71918_1_, int p_71918_2_, int p_71918_3_, int i)
    {
        return false;
    }

    public int func_71857_b()
    {
        return 11;
    }

    public boolean func_72250_d(IBlockAccess p_72250_1_, int p_72250_2_, int p_72250_3_, int p_72250_4_)
    {
        int i = p_72250_1_.func_72798_a(p_72250_2_, p_72250_3_, p_72250_4_);
        if(i == field_71990_ca || i == Block.field_71993_bv.field_71990_ca)
        {
            return true;
        }
        Block block = Block.field_71973_m[i];
        if(block != null && block.field_72018_cp.func_76218_k() && block.func_71886_c())
        {
            return block.field_72018_cp != Material.field_76266_z;
        } else
        {
            return false;
        }
    }

    public static boolean func_72249_c(int p_72249_0_)
    {
        return p_72249_0_ == Block.field_72031_aZ.field_71990_ca || p_72249_0_ == Block.field_72098_bB.field_71990_ca;
    }
}
