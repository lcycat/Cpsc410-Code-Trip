// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockBreakable, Material, CreativeTabs, StatList, 
//            EntityPlayer, EnchantmentHelper, World, WorldProvider, 
//            Block, EnumSkyBlock, IBlockAccess

public class BlockIce extends BlockBreakable
{

    public BlockIce(int p_i3959_1_, int p_i3959_2_)
    {
        super(p_i3959_1_, p_i3959_2_, Material.field_76260_u, false);
        field_72016_cq = 0.98F;
        func_71907_b(true);
        func_71849_a(CreativeTabs.field_78030_b);
    }

    public int func_71856_s_()
    {
        return 1;
    }

    public boolean func_71877_c(IBlockAccess p_71877_1_, int p_71877_2_, int p_71877_3_, int p_71877_4_, int p_71877_5_)
    {
        return super.func_71877_c(p_71877_1_, p_71877_2_, p_71877_3_, p_71877_4_, 1 - p_71877_5_);
    }

    public void func_71893_a(World p_71893_1_, EntityPlayer p_71893_2_, int p_71893_3_, int p_71893_4_, int p_71893_5_, int p_71893_6_)
    {
        p_71893_2_.func_71064_a(StatList.field_75934_C[field_71990_ca], 1);
        p_71893_2_.func_71020_j(0.025F);
        if(func_71906_q_() && EnchantmentHelper.func_77502_d(p_71893_2_.field_71071_by))
        {
            ItemStack itemstack = func_71880_c_(p_71893_6_);
            if(itemstack != null)
            {
                func_71929_a(p_71893_1_, p_71893_3_, p_71893_4_, p_71893_5_, itemstack);
            }
        } else
        {
            if(p_71893_1_.field_73011_w.field_76575_d)
            {
                p_71893_1_.func_72859_e(p_71893_3_, p_71893_4_, p_71893_5_, 0);
                return;
            }
            int i = EnchantmentHelper.func_77517_e(p_71893_2_.field_71071_by);
            func_71897_c(p_71893_1_, p_71893_3_, p_71893_4_, p_71893_5_, p_71893_6_, i);
            Material material = p_71893_1_.func_72803_f(p_71893_3_, p_71893_4_ - 1, p_71893_5_);
            if(material.func_76230_c() || material.func_76224_d())
            {
                p_71893_1_.func_72859_e(p_71893_3_, p_71893_4_, p_71893_5_, Block.field_71942_A.field_71990_ca);
            }
        }
    }

    public int func_71925_a(Random p_71925_1_)
    {
        return 0;
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_)
    {
        if(p_71847_1_.func_72972_b(EnumSkyBlock.Block, p_71847_2_, p_71847_3_, p_71847_4_) > 11 - Block.field_71971_o[field_71990_ca])
        {
            if(p_71847_1_.field_73011_w.field_76575_d)
            {
                p_71847_1_.func_72859_e(p_71847_2_, p_71847_3_, p_71847_4_, 0);
                return;
            }
            func_71897_c(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_, p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_), 0);
            p_71847_1_.func_72859_e(p_71847_2_, p_71847_3_, p_71847_4_, Block.field_71943_B.field_71990_ca);
        }
    }

    public int func_71915_e()
    {
        return 0;
    }
}
