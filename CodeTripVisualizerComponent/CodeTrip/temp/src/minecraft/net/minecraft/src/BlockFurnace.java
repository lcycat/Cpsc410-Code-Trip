// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockContainer, Material, Block, World, 
//            IBlockAccess, TileEntityFurnace, EntityPlayer, TileEntity, 
//            EntityLiving, MathHelper, IInventory, ItemStack, 
//            EntityItem, NBTTagCompound

public class BlockFurnace extends BlockContainer
{

    private Random field_72289_a;
    private final boolean field_72287_b;
    private static boolean field_72288_c = false;

    protected BlockFurnace(int p_i3950_1_, boolean p_i3950_2_)
    {
        super(p_i3950_1_, Material.field_76246_e);
        field_72289_a = new Random();
        field_72287_b = p_i3950_2_;
        field_72059_bZ = 45;
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        return Block.field_72051_aB.field_71990_ca;
    }

    public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_)
    {
        super.func_71861_g(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
        func_72285_l(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
    }

    private void func_72285_l(World p_72285_1_, int p_72285_2_, int p_72285_3_, int p_72285_4_)
    {
        if(p_72285_1_.field_72995_K)
        {
            return;
        }
        int i = p_72285_1_.func_72798_a(p_72285_2_, p_72285_3_, p_72285_4_ - 1);
        int j = p_72285_1_.func_72798_a(p_72285_2_, p_72285_3_, p_72285_4_ + 1);
        int k = p_72285_1_.func_72798_a(p_72285_2_ - 1, p_72285_3_, p_72285_4_);
        int l = p_72285_1_.func_72798_a(p_72285_2_ + 1, p_72285_3_, p_72285_4_);
        byte byte0 = 3;
        if(Block.field_71970_n[i] && !Block.field_71970_n[j])
        {
            byte0 = 3;
        }
        if(Block.field_71970_n[j] && !Block.field_71970_n[i])
        {
            byte0 = 2;
        }
        if(Block.field_71970_n[k] && !Block.field_71970_n[l])
        {
            byte0 = 5;
        }
        if(Block.field_71970_n[l] && !Block.field_71970_n[k])
        {
            byte0 = 4;
        }
        p_72285_1_.func_72921_c(p_72285_2_, p_72285_3_, p_72285_4_, byte0);
    }

    public int func_71895_b(IBlockAccess p_71895_1_, int p_71895_2_, int p_71895_3_, int p_71895_4_, int p_71895_5_)
    {
        if(p_71895_5_ == 1)
        {
            return field_72059_bZ + 17;
        }
        if(p_71895_5_ == 0)
        {
            return field_72059_bZ + 17;
        }
        int i = p_71895_1_.func_72805_g(p_71895_2_, p_71895_3_, p_71895_4_);
        if(p_71895_5_ != i)
        {
            return field_72059_bZ;
        }
        if(field_72287_b)
        {
            return field_72059_bZ + 16;
        } else
        {
            return field_72059_bZ - 1;
        }
    }

    public void func_71862_a(World p_71862_1_, int p_71862_2_, int p_71862_3_, int p_71862_4_, Random p_71862_5_)
    {
        if(!field_72287_b)
        {
            return;
        }
        int i = p_71862_1_.func_72805_g(p_71862_2_, p_71862_3_, p_71862_4_);
        float f = (float)p_71862_2_ + 0.5F;
        float f1 = (float)p_71862_3_ + 0.0F + (p_71862_5_.nextFloat() * 6F) / 16F;
        float f2 = (float)p_71862_4_ + 0.5F;
        float f3 = 0.52F;
        float f4 = p_71862_5_.nextFloat() * 0.6F - 0.3F;
        if(i == 4)
        {
            p_71862_1_.func_72869_a("smoke", f - f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
            p_71862_1_.func_72869_a("flame", f - f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
        } else
        if(i == 5)
        {
            p_71862_1_.func_72869_a("smoke", f + f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
            p_71862_1_.func_72869_a("flame", f + f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
        } else
        if(i == 2)
        {
            p_71862_1_.func_72869_a("smoke", f + f4, f1, f2 - f3, 0.0D, 0.0D, 0.0D);
            p_71862_1_.func_72869_a("flame", f + f4, f1, f2 - f3, 0.0D, 0.0D, 0.0D);
        } else
        if(i == 3)
        {
            p_71862_1_.func_72869_a("smoke", f + f4, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
            p_71862_1_.func_72869_a("flame", f + f4, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
        }
    }

    public int func_71851_a(int p_71851_1_)
    {
        if(p_71851_1_ == 1)
        {
            return field_72059_bZ + 17;
        }
        if(p_71851_1_ == 0)
        {
            return field_72059_bZ + 17;
        }
        if(p_71851_1_ == 3)
        {
            return field_72059_bZ - 1;
        } else
        {
            return field_72059_bZ;
        }
    }

    public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, 
            float p_71903_8_, float p_71903_9_)
    {
        if(p_71903_1_.field_72995_K)
        {
            return true;
        }
        TileEntityFurnace tileentityfurnace = (TileEntityFurnace)p_71903_1_.func_72796_p(p_71903_2_, p_71903_3_, p_71903_4_);
        if(tileentityfurnace != null)
        {
            p_71903_5_.func_71042_a(tileentityfurnace);
        }
        return true;
    }

    public static void func_72286_a(boolean p_72286_0_, World p_72286_1_, int p_72286_2_, int p_72286_3_, int p_72286_4_)
    {
        int i = p_72286_1_.func_72805_g(p_72286_2_, p_72286_3_, p_72286_4_);
        TileEntity tileentity = p_72286_1_.func_72796_p(p_72286_2_, p_72286_3_, p_72286_4_);
        field_72288_c = true;
        if(p_72286_0_)
        {
            p_72286_1_.func_72859_e(p_72286_2_, p_72286_3_, p_72286_4_, Block.field_72052_aC.field_71990_ca);
        } else
        {
            p_72286_1_.func_72859_e(p_72286_2_, p_72286_3_, p_72286_4_, Block.field_72051_aB.field_71990_ca);
        }
        field_72288_c = false;
        p_72286_1_.func_72921_c(p_72286_2_, p_72286_3_, p_72286_4_, i);
        if(tileentity != null)
        {
            tileentity.func_70312_q();
            p_72286_1_.func_72837_a(p_72286_2_, p_72286_3_, p_72286_4_, tileentity);
        }
    }

    public TileEntity func_72274_a(World p_72274_1_)
    {
        return new TileEntityFurnace();
    }

    public void func_71860_a(World p_71860_1_, int p_71860_2_, int p_71860_3_, int p_71860_4_, EntityLiving p_71860_5_)
    {
        int i = MathHelper.func_76128_c((double)((p_71860_5_.field_70177_z * 4F) / 360F) + 0.5D) & 3;
        if(i == 0)
        {
            p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, 2);
        }
        if(i == 1)
        {
            p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, 5);
        }
        if(i == 2)
        {
            p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, 3);
        }
        if(i == 3)
        {
            p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, 4);
        }
    }

    public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_)
    {
        if(!field_72288_c)
        {
            TileEntityFurnace tileentityfurnace = (TileEntityFurnace)p_71852_1_.func_72796_p(p_71852_2_, p_71852_3_, p_71852_4_);
            if(tileentityfurnace != null)
            {
label0:
                for(int i = 0; i < tileentityfurnace.func_70302_i_(); i++)
                {
                    ItemStack itemstack = tileentityfurnace.func_70301_a(i);
                    if(itemstack == null)
                    {
                        continue;
                    }
                    float f = field_72289_a.nextFloat() * 0.8F + 0.1F;
                    float f1 = field_72289_a.nextFloat() * 0.8F + 0.1F;
                    float f2 = field_72289_a.nextFloat() * 0.8F + 0.1F;
                    do
                    {
                        if(itemstack.field_77994_a <= 0)
                        {
                            continue label0;
                        }
                        int j = field_72289_a.nextInt(21) + 10;
                        if(j > itemstack.field_77994_a)
                        {
                            j = itemstack.field_77994_a;
                        }
                        itemstack.field_77994_a -= j;
                        EntityItem entityitem = new EntityItem(p_71852_1_, (float)p_71852_2_ + f, (float)p_71852_3_ + f1, (float)p_71852_4_ + f2, new ItemStack(itemstack.field_77993_c, j, itemstack.func_77960_j()));
                        if(itemstack.func_77942_o())
                        {
                            entityitem.field_70294_a.func_77982_d((NBTTagCompound)itemstack.func_77978_p().func_74737_b());
                        }
                        float f3 = 0.05F;
                        entityitem.field_70159_w = (float)field_72289_a.nextGaussian() * f3;
                        entityitem.field_70181_x = (float)field_72289_a.nextGaussian() * f3 + 0.2F;
                        entityitem.field_70179_y = (float)field_72289_a.nextGaussian() * f3;
                        p_71852_1_.func_72838_d(entityitem);
                    } while(true);
                }

            }
        }
        super.func_71852_a(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_, p_71852_5_, p_71852_6_);
    }

}
