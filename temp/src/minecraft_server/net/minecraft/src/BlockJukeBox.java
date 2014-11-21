// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockContainer, Material, CreativeTabs, World, 
//            TileEntityRecordPlayer, EntityItem, ItemStack, EntityPlayer, 
//            TileEntity

public class BlockJukeBox extends BlockContainer
{

    protected BlockJukeBox(int p_i3985_1_, int p_i3985_2_)
    {
        super(p_i3985_1_, p_i3985_2_, Material.field_76245_d);
        func_71849_a(CreativeTabs.field_78031_c);
    }

    public int func_71851_a(int p_71851_1_)
    {
        return field_72059_bZ + (p_71851_1_ != 1 ? 0 : 1);
    }

    public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, 
            float p_71903_8_, float p_71903_9_)
    {
        if(p_71903_1_.func_72805_g(p_71903_2_, p_71903_3_, p_71903_4_) == 0)
        {
            return false;
        } else
        {
            func_72276_j_(p_71903_1_, p_71903_2_, p_71903_3_, p_71903_4_);
            return true;
        }
    }

    public void func_72277_e(World p_72277_1_, int p_72277_2_, int p_72277_3_, int p_72277_4_, int p_72277_5_)
    {
        if(p_72277_1_.field_72995_K)
        {
            return;
        }
        TileEntityRecordPlayer tileentityrecordplayer = (TileEntityRecordPlayer)p_72277_1_.func_72796_p(p_72277_2_, p_72277_3_, p_72277_4_);
        if(tileentityrecordplayer == null)
        {
            return;
        } else
        {
            tileentityrecordplayer.field_70417_a = p_72277_5_;
            tileentityrecordplayer.func_70296_d();
            p_72277_1_.func_72921_c(p_72277_2_, p_72277_3_, p_72277_4_, 1);
            return;
        }
    }

    public void func_72276_j_(World p_72276_1_, int p_72276_2_, int p_72276_3_, int p_72276_4_)
    {
        if(p_72276_1_.field_72995_K)
        {
            return;
        }
        TileEntityRecordPlayer tileentityrecordplayer = (TileEntityRecordPlayer)p_72276_1_.func_72796_p(p_72276_2_, p_72276_3_, p_72276_4_);
        if(tileentityrecordplayer == null)
        {
            return;
        }
        int i = tileentityrecordplayer.field_70417_a;
        if(i == 0)
        {
            return;
        } else
        {
            p_72276_1_.func_72926_e(1005, p_72276_2_, p_72276_3_, p_72276_4_, 0);
            p_72276_1_.func_72934_a(null, p_72276_2_, p_72276_3_, p_72276_4_);
            tileentityrecordplayer.field_70417_a = 0;
            tileentityrecordplayer.func_70296_d();
            p_72276_1_.func_72921_c(p_72276_2_, p_72276_3_, p_72276_4_, 0);
            float f = 0.7F;
            double d = (double)(p_72276_1_.field_73012_v.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
            double d1 = (double)(p_72276_1_.field_73012_v.nextFloat() * f) + (double)(1.0F - f) * 0.20000000000000001D + 0.59999999999999998D;
            double d2 = (double)(p_72276_1_.field_73012_v.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
            EntityItem entityitem = new EntityItem(p_72276_1_, (double)p_72276_2_ + d, (double)p_72276_3_ + d1, (double)p_72276_4_ + d2, new ItemStack(i, 1, 0));
            entityitem.field_70293_c = 10;
            p_72276_1_.func_72838_d(entityitem);
            return;
        }
    }

    public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_)
    {
        func_72276_j_(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_);
        super.func_71852_a(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_, p_71852_5_, p_71852_6_);
    }

    public void func_71914_a(World p_71914_1_, int p_71914_2_, int p_71914_3_, int p_71914_4_, int p_71914_5_, float p_71914_6_, int p_71914_7_)
    {
        if(p_71914_1_.field_72995_K)
        {
            return;
        } else
        {
            super.func_71914_a(p_71914_1_, p_71914_2_, p_71914_3_, p_71914_4_, p_71914_5_, p_71914_6_, 0);
            return;
        }
    }

    public TileEntity func_72274_a(World p_72274_1_)
    {
        return new TileEntityRecordPlayer();
    }
}
