// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, CreativeTabs, World, 
//            AxisAlignedBB, AABBPool, IBlockAccess, BlockLeaves, 
//            Item, EntityItem, ItemStack, StatList, 
//            EntityPlayer, EnumSkyBlock

public class BlockSnow extends Block
{

    protected BlockSnow(int p_i4012_1_, int p_i4012_2_)
    {
        super(p_i4012_1_, p_i4012_2_, Material.field_76259_v);
        func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
        func_71907_b(true);
        func_71849_a(CreativeTabs.field_78031_c);
    }

    public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_)
    {
        int i = p_71872_1_.func_72805_g(p_71872_2_, p_71872_3_, p_71872_4_) & 7;
        if(i >= 3)
        {
            return AxisAlignedBB.func_72332_a().func_72299_a((double)p_71872_2_ + field_72026_ch, (double)p_71872_3_ + field_72023_ci, (double)p_71872_4_ + field_72024_cj, (double)p_71872_2_ + field_72021_ck, (float)p_71872_3_ + 0.5F, (double)p_71872_4_ + field_72019_cm);
        } else
        {
            return null;
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

    public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_)
    {
        int i = p_71902_1_.func_72805_g(p_71902_2_, p_71902_3_, p_71902_4_) & 7;
        float f = (float)(2 * (1 + i)) / 16F;
        func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
    }

    public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_)
    {
        int i = p_71930_1_.func_72798_a(p_71930_2_, p_71930_3_ - 1, p_71930_4_);
        if(i == 0 || i != Block.field_71952_K.field_71990_ca && !Block.field_71973_m[i].func_71926_d())
        {
            return false;
        } else
        {
            return p_71930_1_.func_72803_f(p_71930_2_, p_71930_3_ - 1, p_71930_4_).func_76230_c();
        }
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        func_72124_n(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_);
    }

    private boolean func_72124_n(World p_72124_1_, int p_72124_2_, int p_72124_3_, int p_72124_4_)
    {
        if(!func_71930_b(p_72124_1_, p_72124_2_, p_72124_3_, p_72124_4_))
        {
            func_71897_c(p_72124_1_, p_72124_2_, p_72124_3_, p_72124_4_, p_72124_1_.func_72805_g(p_72124_2_, p_72124_3_, p_72124_4_), 0);
            p_72124_1_.func_72859_e(p_72124_2_, p_72124_3_, p_72124_4_, 0);
            return false;
        } else
        {
            return true;
        }
    }

    public void func_71893_a(World p_71893_1_, EntityPlayer p_71893_2_, int p_71893_3_, int p_71893_4_, int p_71893_5_, int p_71893_6_)
    {
        int i = Item.field_77768_aD.field_77779_bT;
        float f = 0.7F;
        double d = (double)(p_71893_1_.field_73012_v.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
        double d1 = (double)(p_71893_1_.field_73012_v.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
        double d2 = (double)(p_71893_1_.field_73012_v.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
        EntityItem entityitem = new EntityItem(p_71893_1_, (double)p_71893_3_ + d, (double)p_71893_4_ + d1, (double)p_71893_5_ + d2, new ItemStack(i, 1, 0));
        entityitem.field_70293_c = 10;
        p_71893_1_.func_72838_d(entityitem);
        p_71893_1_.func_72859_e(p_71893_3_, p_71893_4_, p_71893_5_, 0);
        p_71893_2_.func_71064_a(StatList.field_75934_C[field_71990_ca], 1);
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        return Item.field_77768_aD.field_77779_bT;
    }

    public int func_71925_a(Random p_71925_1_)
    {
        return 0;
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_)
    {
        if(p_71847_1_.func_72972_b(EnumSkyBlock.Block, p_71847_2_, p_71847_3_, p_71847_4_) > 11)
        {
            func_71897_c(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_, p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_), 0);
            p_71847_1_.func_72859_e(p_71847_2_, p_71847_3_, p_71847_4_, 0);
        }
    }
}
