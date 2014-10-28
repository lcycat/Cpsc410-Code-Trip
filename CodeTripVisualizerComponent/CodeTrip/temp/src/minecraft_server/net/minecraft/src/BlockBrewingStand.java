// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockContainer, Material, TileEntityBrewingStand, World, 
//            EntityPlayer, ItemStack, EntityItem, Item, 
//            TileEntity, AxisAlignedBB, Entity

public class BlockBrewingStand extends BlockContainer
{

    private Random field_72294_a;

    public BlockBrewingStand(int p_i3921_1_)
    {
        super(p_i3921_1_, Material.field_76243_f);
        field_72294_a = new Random();
        field_72059_bZ = 157;
    }

    public boolean func_71926_d()
    {
        return false;
    }

    public int func_71857_b()
    {
        return 25;
    }

    public TileEntity func_72274_a(World p_72274_1_)
    {
        return new TileEntityBrewingStand();
    }

    public boolean func_71886_c()
    {
        return false;
    }

    public void func_71871_a(World p_71871_1_, int p_71871_2_, int p_71871_3_, int p_71871_4_, AxisAlignedBB p_71871_5_, List p_71871_6_, Entity p_71871_7_)
    {
        func_71905_a(0.4375F, 0.0F, 0.4375F, 0.5625F, 0.875F, 0.5625F);
        super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
        func_71919_f();
        super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
    }

    public void func_71919_f()
    {
        func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
    }

    public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, 
            float p_71903_8_, float p_71903_9_)
    {
        if(p_71903_1_.field_72995_K)
        {
            return true;
        }
        TileEntityBrewingStand tileentitybrewingstand = (TileEntityBrewingStand)p_71903_1_.func_72796_p(p_71903_2_, p_71903_3_, p_71903_4_);
        if(tileentitybrewingstand != null)
        {
            p_71903_5_.func_71017_a(tileentitybrewingstand);
        }
        return true;
    }

    public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_)
    {
        TileEntity tileentity = p_71852_1_.func_72796_p(p_71852_2_, p_71852_3_, p_71852_4_);
        if(tileentity instanceof TileEntityBrewingStand)
        {
            TileEntityBrewingStand tileentitybrewingstand = (TileEntityBrewingStand)tileentity;
label0:
            for(int i = 0; i < tileentitybrewingstand.func_70302_i_(); i++)
            {
                ItemStack itemstack = tileentitybrewingstand.func_70301_a(i);
                if(itemstack == null)
                {
                    continue;
                }
                float f = field_72294_a.nextFloat() * 0.8F + 0.1F;
                float f1 = field_72294_a.nextFloat() * 0.8F + 0.1F;
                float f2 = field_72294_a.nextFloat() * 0.8F + 0.1F;
                do
                {
                    if(itemstack.field_77994_a <= 0)
                    {
                        continue label0;
                    }
                    int j = field_72294_a.nextInt(21) + 10;
                    if(j > itemstack.field_77994_a)
                    {
                        j = itemstack.field_77994_a;
                    }
                    itemstack.field_77994_a -= j;
                    EntityItem entityitem = new EntityItem(p_71852_1_, (float)p_71852_2_ + f, (float)p_71852_3_ + f1, (float)p_71852_4_ + f2, new ItemStack(itemstack.field_77993_c, j, itemstack.func_77960_j()));
                    float f3 = 0.05F;
                    entityitem.field_70159_w = (float)field_72294_a.nextGaussian() * f3;
                    entityitem.field_70181_x = (float)field_72294_a.nextGaussian() * f3 + 0.2F;
                    entityitem.field_70179_y = (float)field_72294_a.nextGaussian() * f3;
                    p_71852_1_.func_72838_d(entityitem);
                } while(true);
            }

        }
        super.func_71852_a(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_, p_71852_5_, p_71852_6_);
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        return Item.field_77724_by.field_77779_bT;
    }
}
