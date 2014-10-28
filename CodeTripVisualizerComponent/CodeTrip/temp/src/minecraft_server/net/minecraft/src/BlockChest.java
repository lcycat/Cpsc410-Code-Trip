// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            BlockContainer, Material, CreativeTabs, World, 
//            EntityLiving, MathHelper, Block, TileEntityChest, 
//            IInventory, ItemStack, EntityItem, NBTTagCompound, 
//            InventoryLargeChest, EntityPlayer, EntityOcelot, AxisAlignedBB, 
//            AABBPool, TileEntity

public class BlockChest extends BlockContainer
{

    private Random field_72293_a;

    protected BlockChest(int p_i3928_1_)
    {
        super(p_i3928_1_, Material.field_76245_d);
        field_72293_a = new Random();
        field_72059_bZ = 26;
        func_71849_a(CreativeTabs.field_78031_c);
    }

    public boolean func_71926_d()
    {
        return false;
    }

    public boolean func_71886_c()
    {
        return false;
    }

    public int func_71857_b()
    {
        return 22;
    }

    public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_)
    {
        super.func_71861_g(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
        func_72290_b_(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
        int i = p_71861_1_.func_72798_a(p_71861_2_, p_71861_3_, p_71861_4_ - 1);
        int j = p_71861_1_.func_72798_a(p_71861_2_, p_71861_3_, p_71861_4_ + 1);
        int k = p_71861_1_.func_72798_a(p_71861_2_ - 1, p_71861_3_, p_71861_4_);
        int l = p_71861_1_.func_72798_a(p_71861_2_ + 1, p_71861_3_, p_71861_4_);
        if(i == field_71990_ca)
        {
            func_72290_b_(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_ - 1);
        }
        if(j == field_71990_ca)
        {
            func_72290_b_(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_ + 1);
        }
        if(k == field_71990_ca)
        {
            func_72290_b_(p_71861_1_, p_71861_2_ - 1, p_71861_3_, p_71861_4_);
        }
        if(l == field_71990_ca)
        {
            func_72290_b_(p_71861_1_, p_71861_2_ + 1, p_71861_3_, p_71861_4_);
        }
    }

    public void func_71860_a(World p_71860_1_, int p_71860_2_, int p_71860_3_, int p_71860_4_, EntityLiving p_71860_5_)
    {
        int i = p_71860_1_.func_72798_a(p_71860_2_, p_71860_3_, p_71860_4_ - 1);
        int j = p_71860_1_.func_72798_a(p_71860_2_, p_71860_3_, p_71860_4_ + 1);
        int k = p_71860_1_.func_72798_a(p_71860_2_ - 1, p_71860_3_, p_71860_4_);
        int l = p_71860_1_.func_72798_a(p_71860_2_ + 1, p_71860_3_, p_71860_4_);
        byte byte0 = 0;
        int i1 = MathHelper.func_76128_c((double)((p_71860_5_.field_70177_z * 4F) / 360F) + 0.5D) & 3;
        if(i1 == 0)
        {
            byte0 = 2;
        }
        if(i1 == 1)
        {
            byte0 = 5;
        }
        if(i1 == 2)
        {
            byte0 = 3;
        }
        if(i1 == 3)
        {
            byte0 = 4;
        }
        if(i != field_71990_ca && j != field_71990_ca && k != field_71990_ca && l != field_71990_ca)
        {
            p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, byte0);
        } else
        {
            if((i == field_71990_ca || j == field_71990_ca) && (byte0 == 4 || byte0 == 5))
            {
                if(i == field_71990_ca)
                {
                    p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_ - 1, byte0);
                } else
                {
                    p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_ + 1, byte0);
                }
                p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, byte0);
            }
            if((k == field_71990_ca || l == field_71990_ca) && (byte0 == 2 || byte0 == 3))
            {
                if(k == field_71990_ca)
                {
                    p_71860_1_.func_72921_c(p_71860_2_ - 1, p_71860_3_, p_71860_4_, byte0);
                } else
                {
                    p_71860_1_.func_72921_c(p_71860_2_ + 1, p_71860_3_, p_71860_4_, byte0);
                }
                p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, byte0);
            }
        }
    }

    public void func_72290_b_(World p_72290_1_, int p_72290_2_, int p_72290_3_, int p_72290_4_)
    {
        if(p_72290_1_.field_72995_K)
        {
            return;
        }
        int i = p_72290_1_.func_72798_a(p_72290_2_, p_72290_3_, p_72290_4_ - 1);
        int j = p_72290_1_.func_72798_a(p_72290_2_, p_72290_3_, p_72290_4_ + 1);
        int k = p_72290_1_.func_72798_a(p_72290_2_ - 1, p_72290_3_, p_72290_4_);
        int l = p_72290_1_.func_72798_a(p_72290_2_ + 1, p_72290_3_, p_72290_4_);
        byte byte0 = 4;
        if(i == field_71990_ca || j == field_71990_ca)
        {
            int i1 = p_72290_1_.func_72798_a(p_72290_2_ - 1, p_72290_3_, i != field_71990_ca ? p_72290_4_ + 1 : p_72290_4_ - 1);
            int k1 = p_72290_1_.func_72798_a(p_72290_2_ + 1, p_72290_3_, i != field_71990_ca ? p_72290_4_ + 1 : p_72290_4_ - 1);
            byte0 = 5;
            int i2 = -1;
            if(i == field_71990_ca)
            {
                i2 = p_72290_1_.func_72805_g(p_72290_2_, p_72290_3_, p_72290_4_ - 1);
            } else
            {
                i2 = p_72290_1_.func_72805_g(p_72290_2_, p_72290_3_, p_72290_4_ + 1);
            }
            if(i2 == 4)
            {
                byte0 = 4;
            }
            if((Block.field_71970_n[k] || Block.field_71970_n[i1]) && !Block.field_71970_n[l] && !Block.field_71970_n[k1])
            {
                byte0 = 5;
            }
            if((Block.field_71970_n[l] || Block.field_71970_n[k1]) && !Block.field_71970_n[k] && !Block.field_71970_n[i1])
            {
                byte0 = 4;
            }
        } else
        if(k == field_71990_ca || l == field_71990_ca)
        {
            int j1 = p_72290_1_.func_72798_a(k != field_71990_ca ? p_72290_2_ + 1 : p_72290_2_ - 1, p_72290_3_, p_72290_4_ - 1);
            int l1 = p_72290_1_.func_72798_a(k != field_71990_ca ? p_72290_2_ + 1 : p_72290_2_ - 1, p_72290_3_, p_72290_4_ + 1);
            byte0 = 3;
            int j2 = -1;
            if(k == field_71990_ca)
            {
                j2 = p_72290_1_.func_72805_g(p_72290_2_ - 1, p_72290_3_, p_72290_4_);
            } else
            {
                j2 = p_72290_1_.func_72805_g(p_72290_2_ + 1, p_72290_3_, p_72290_4_);
            }
            if(j2 == 2)
            {
                byte0 = 2;
            }
            if((Block.field_71970_n[i] || Block.field_71970_n[j1]) && !Block.field_71970_n[j] && !Block.field_71970_n[l1])
            {
                byte0 = 3;
            }
            if((Block.field_71970_n[j] || Block.field_71970_n[l1]) && !Block.field_71970_n[i] && !Block.field_71970_n[j1])
            {
                byte0 = 2;
            }
        } else
        {
            byte0 = 3;
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
        }
        p_72290_1_.func_72921_c(p_72290_2_, p_72290_3_, p_72290_4_, byte0);
    }

    public int func_71851_a(int p_71851_1_)
    {
        return 4;
    }

    public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_)
    {
        int i = 0;
        if(p_71930_1_.func_72798_a(p_71930_2_ - 1, p_71930_3_, p_71930_4_) == field_71990_ca)
        {
            i++;
        }
        if(p_71930_1_.func_72798_a(p_71930_2_ + 1, p_71930_3_, p_71930_4_) == field_71990_ca)
        {
            i++;
        }
        if(p_71930_1_.func_72798_a(p_71930_2_, p_71930_3_, p_71930_4_ - 1) == field_71990_ca)
        {
            i++;
        }
        if(p_71930_1_.func_72798_a(p_71930_2_, p_71930_3_, p_71930_4_ + 1) == field_71990_ca)
        {
            i++;
        }
        if(i > 1)
        {
            return false;
        }
        if(func_72291_l(p_71930_1_, p_71930_2_ - 1, p_71930_3_, p_71930_4_))
        {
            return false;
        }
        if(func_72291_l(p_71930_1_, p_71930_2_ + 1, p_71930_3_, p_71930_4_))
        {
            return false;
        }
        if(func_72291_l(p_71930_1_, p_71930_2_, p_71930_3_, p_71930_4_ - 1))
        {
            return false;
        }
        return !func_72291_l(p_71930_1_, p_71930_2_, p_71930_3_, p_71930_4_ + 1);
    }

    private boolean func_72291_l(World p_72291_1_, int p_72291_2_, int p_72291_3_, int p_72291_4_)
    {
        if(p_72291_1_.func_72798_a(p_72291_2_, p_72291_3_, p_72291_4_) != field_71990_ca)
        {
            return false;
        }
        if(p_72291_1_.func_72798_a(p_72291_2_ - 1, p_72291_3_, p_72291_4_) == field_71990_ca)
        {
            return true;
        }
        if(p_72291_1_.func_72798_a(p_72291_2_ + 1, p_72291_3_, p_72291_4_) == field_71990_ca)
        {
            return true;
        }
        if(p_72291_1_.func_72798_a(p_72291_2_, p_72291_3_, p_72291_4_ - 1) == field_71990_ca)
        {
            return true;
        }
        return p_72291_1_.func_72798_a(p_72291_2_, p_72291_3_, p_72291_4_ + 1) == field_71990_ca;
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        super.func_71863_a(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, p_71863_5_);
        TileEntityChest tileentitychest = (TileEntityChest)p_71863_1_.func_72796_p(p_71863_2_, p_71863_3_, p_71863_4_);
        if(tileentitychest != null)
        {
            tileentitychest.func_70321_h();
        }
    }

    public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_)
    {
        TileEntityChest tileentitychest = (TileEntityChest)p_71852_1_.func_72796_p(p_71852_2_, p_71852_3_, p_71852_4_);
        if(tileentitychest != null)
        {
            for(int i = 0; i < tileentitychest.func_70302_i_(); i++)
            {
                ItemStack itemstack = tileentitychest.func_70301_a(i);
                if(itemstack == null)
                {
                    continue;
                }
                float f = field_72293_a.nextFloat() * 0.8F + 0.1F;
                float f1 = field_72293_a.nextFloat() * 0.8F + 0.1F;
                float f2 = field_72293_a.nextFloat() * 0.8F + 0.1F;
                while(itemstack.field_77994_a > 0) 
                {
                    int j = field_72293_a.nextInt(21) + 10;
                    if(j > itemstack.field_77994_a)
                    {
                        j = itemstack.field_77994_a;
                    }
                    itemstack.field_77994_a -= j;
                    EntityItem entityitem = new EntityItem(p_71852_1_, (float)p_71852_2_ + f, (float)p_71852_3_ + f1, (float)p_71852_4_ + f2, new ItemStack(itemstack.field_77993_c, j, itemstack.func_77960_j()));
                    float f3 = 0.05F;
                    entityitem.field_70159_w = (float)field_72293_a.nextGaussian() * f3;
                    entityitem.field_70181_x = (float)field_72293_a.nextGaussian() * f3 + 0.2F;
                    entityitem.field_70179_y = (float)field_72293_a.nextGaussian() * f3;
                    if(itemstack.func_77942_o())
                    {
                        entityitem.field_70294_a.func_77982_d((NBTTagCompound)itemstack.func_77978_p().func_74737_b());
                    }
                    p_71852_1_.func_72838_d(entityitem);
                }
            }

        }
        super.func_71852_a(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_, p_71852_5_, p_71852_6_);
    }

    public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, 
            float p_71903_8_, float p_71903_9_)
    {
        Object obj = (TileEntityChest)p_71903_1_.func_72796_p(p_71903_2_, p_71903_3_, p_71903_4_);
        if(obj == null)
        {
            return true;
        }
        if(p_71903_1_.func_72809_s(p_71903_2_, p_71903_3_ + 1, p_71903_4_))
        {
            return true;
        }
        if(func_72292_n(p_71903_1_, p_71903_2_, p_71903_3_, p_71903_4_))
        {
            return true;
        }
        if(p_71903_1_.func_72798_a(p_71903_2_ - 1, p_71903_3_, p_71903_4_) == field_71990_ca && (p_71903_1_.func_72809_s(p_71903_2_ - 1, p_71903_3_ + 1, p_71903_4_) || func_72292_n(p_71903_1_, p_71903_2_ - 1, p_71903_3_, p_71903_4_)))
        {
            return true;
        }
        if(p_71903_1_.func_72798_a(p_71903_2_ + 1, p_71903_3_, p_71903_4_) == field_71990_ca && (p_71903_1_.func_72809_s(p_71903_2_ + 1, p_71903_3_ + 1, p_71903_4_) || func_72292_n(p_71903_1_, p_71903_2_ + 1, p_71903_3_, p_71903_4_)))
        {
            return true;
        }
        if(p_71903_1_.func_72798_a(p_71903_2_, p_71903_3_, p_71903_4_ - 1) == field_71990_ca && (p_71903_1_.func_72809_s(p_71903_2_, p_71903_3_ + 1, p_71903_4_ - 1) || func_72292_n(p_71903_1_, p_71903_2_, p_71903_3_, p_71903_4_ - 1)))
        {
            return true;
        }
        if(p_71903_1_.func_72798_a(p_71903_2_, p_71903_3_, p_71903_4_ + 1) == field_71990_ca && (p_71903_1_.func_72809_s(p_71903_2_, p_71903_3_ + 1, p_71903_4_ + 1) || func_72292_n(p_71903_1_, p_71903_2_, p_71903_3_, p_71903_4_ + 1)))
        {
            return true;
        }
        if(p_71903_1_.func_72798_a(p_71903_2_ - 1, p_71903_3_, p_71903_4_) == field_71990_ca)
        {
            obj = new InventoryLargeChest("container.chestDouble", (TileEntityChest)p_71903_1_.func_72796_p(p_71903_2_ - 1, p_71903_3_, p_71903_4_), ((IInventory) (obj)));
        }
        if(p_71903_1_.func_72798_a(p_71903_2_ + 1, p_71903_3_, p_71903_4_) == field_71990_ca)
        {
            obj = new InventoryLargeChest("container.chestDouble", ((IInventory) (obj)), (TileEntityChest)p_71903_1_.func_72796_p(p_71903_2_ + 1, p_71903_3_, p_71903_4_));
        }
        if(p_71903_1_.func_72798_a(p_71903_2_, p_71903_3_, p_71903_4_ - 1) == field_71990_ca)
        {
            obj = new InventoryLargeChest("container.chestDouble", (TileEntityChest)p_71903_1_.func_72796_p(p_71903_2_, p_71903_3_, p_71903_4_ - 1), ((IInventory) (obj)));
        }
        if(p_71903_1_.func_72798_a(p_71903_2_, p_71903_3_, p_71903_4_ + 1) == field_71990_ca)
        {
            obj = new InventoryLargeChest("container.chestDouble", ((IInventory) (obj)), (TileEntityChest)p_71903_1_.func_72796_p(p_71903_2_, p_71903_3_, p_71903_4_ + 1));
        }
        if(p_71903_1_.field_72995_K)
        {
            return true;
        } else
        {
            p_71903_5_.func_71007_a(((IInventory) (obj)));
            return true;
        }
    }

    public TileEntity func_72274_a(World p_72274_1_)
    {
        return new TileEntityChest();
    }

    private static boolean func_72292_n(World p_72292_0_, int p_72292_1_, int p_72292_2_, int p_72292_3_)
    {
        for(Iterator iterator = p_72292_0_.func_72872_a(net.minecraft.src.EntityOcelot.class, AxisAlignedBB.func_72332_a().func_72299_a(p_72292_1_, p_72292_2_ + 1, p_72292_3_, p_72292_1_ + 1, p_72292_2_ + 2, p_72292_3_ + 1)).iterator(); iterator.hasNext();)
        {
            EntityOcelot entityocelot = (EntityOcelot)iterator.next();
            EntityOcelot entityocelot1 = (EntityOcelot)entityocelot;
            if(entityocelot1.func_70906_o())
            {
                return true;
            }
        }

        return false;
    }
}
