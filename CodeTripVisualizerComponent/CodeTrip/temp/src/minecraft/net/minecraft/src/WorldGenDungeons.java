// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.PrintStream;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, World, Material, Block, 
//            TileEntityChest, TileEntityMobSpawner, ItemStack, Item

public class WorldGenDungeons extends WorldGenerator
{

    public WorldGenDungeons()
    {
    }

    public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
    {
        byte byte0 = 3;
        int i = p_76484_2_.nextInt(2) + 2;
        int j = p_76484_2_.nextInt(2) + 2;
        int k = 0;
        for(int l = p_76484_3_ - i - 1; l <= p_76484_3_ + i + 1; l++)
        {
            for(int k1 = p_76484_4_ - 1; k1 <= p_76484_4_ + byte0 + 1; k1++)
            {
                for(int j2 = p_76484_5_ - j - 1; j2 <= p_76484_5_ + j + 1; j2++)
                {
                    Material material = p_76484_1_.func_72803_f(l, k1, j2);
                    if(k1 == p_76484_4_ - 1 && !material.func_76220_a())
                    {
                        return false;
                    }
                    if(k1 == p_76484_4_ + byte0 + 1 && !material.func_76220_a())
                    {
                        return false;
                    }
                    if((l == p_76484_3_ - i - 1 || l == p_76484_3_ + i + 1 || j2 == p_76484_5_ - j - 1 || j2 == p_76484_5_ + j + 1) && k1 == p_76484_4_ && p_76484_1_.func_72799_c(l, k1, j2) && p_76484_1_.func_72799_c(l, k1 + 1, j2))
                    {
                        k++;
                    }
                }

            }

        }

        if(k < 1 || k > 5)
        {
            return false;
        }
        for(int i1 = p_76484_3_ - i - 1; i1 <= p_76484_3_ + i + 1; i1++)
        {
            for(int l1 = p_76484_4_ + byte0; l1 >= p_76484_4_ - 1; l1--)
            {
                for(int k2 = p_76484_5_ - j - 1; k2 <= p_76484_5_ + j + 1; k2++)
                {
                    if(i1 == p_76484_3_ - i - 1 || l1 == p_76484_4_ - 1 || k2 == p_76484_5_ - j - 1 || i1 == p_76484_3_ + i + 1 || l1 == p_76484_4_ + byte0 + 1 || k2 == p_76484_5_ + j + 1)
                    {
                        if(l1 >= 0 && !p_76484_1_.func_72803_f(i1, l1 - 1, k2).func_76220_a())
                        {
                            p_76484_1_.func_72859_e(i1, l1, k2, 0);
                            continue;
                        }
                        if(!p_76484_1_.func_72803_f(i1, l1, k2).func_76220_a())
                        {
                            continue;
                        }
                        if(l1 == p_76484_4_ - 1 && p_76484_2_.nextInt(4) != 0)
                        {
                            p_76484_1_.func_72859_e(i1, l1, k2, Block.field_72087_ao.field_71990_ca);
                        } else
                        {
                            p_76484_1_.func_72859_e(i1, l1, k2, Block.field_71978_w.field_71990_ca);
                        }
                    } else
                    {
                        p_76484_1_.func_72859_e(i1, l1, k2, 0);
                    }
                }

            }

        }

        for(int j1 = 0; j1 < 2; j1++)
        {
label0:
            for(int i2 = 0; i2 < 3; i2++)
            {
                int l2 = (p_76484_3_ + p_76484_2_.nextInt(i * 2 + 1)) - i;
                int i3 = p_76484_4_;
                int j3 = (p_76484_5_ + p_76484_2_.nextInt(j * 2 + 1)) - j;
                if(!p_76484_1_.func_72799_c(l2, i3, j3))
                {
                    continue;
                }
                int k3 = 0;
                if(p_76484_1_.func_72803_f(l2 - 1, i3, j3).func_76220_a())
                {
                    k3++;
                }
                if(p_76484_1_.func_72803_f(l2 + 1, i3, j3).func_76220_a())
                {
                    k3++;
                }
                if(p_76484_1_.func_72803_f(l2, i3, j3 - 1).func_76220_a())
                {
                    k3++;
                }
                if(p_76484_1_.func_72803_f(l2, i3, j3 + 1).func_76220_a())
                {
                    k3++;
                }
                if(k3 != 1)
                {
                    continue;
                }
                p_76484_1_.func_72859_e(l2, i3, j3, Block.field_72077_au.field_71990_ca);
                TileEntityChest tileentitychest = (TileEntityChest)p_76484_1_.func_72796_p(l2, i3, j3);
                if(tileentitychest == null)
                {
                    break;
                }
                int l3 = 0;
                do
                {
                    if(l3 >= 8)
                    {
                        break label0;
                    }
                    ItemStack itemstack = func_76544_a(p_76484_2_);
                    if(itemstack != null)
                    {
                        tileentitychest.func_70299_a(p_76484_2_.nextInt(tileentitychest.func_70302_i_()), itemstack);
                    }
                    l3++;
                } while(true);
            }

        }

        p_76484_1_.func_72859_e(p_76484_3_, p_76484_4_, p_76484_5_, Block.field_72065_as.field_71990_ca);
        TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)p_76484_1_.func_72796_p(p_76484_3_, p_76484_4_, p_76484_5_);
        if(tileentitymobspawner != null)
        {
            tileentitymobspawner.func_70385_a(func_76543_b(p_76484_2_));
        } else
        {
            System.err.println((new StringBuilder()).append("Failed to fetch mob spawner entity at (").append(p_76484_3_).append(", ").append(p_76484_4_).append(", ").append(p_76484_5_).append(")").toString());
        }
        return true;
    }

    private ItemStack func_76544_a(Random p_76544_1_)
    {
        int i = p_76544_1_.nextInt(11);
        if(i == 0)
        {
            return new ItemStack(Item.field_77765_aA);
        }
        if(i == 1)
        {
            return new ItemStack(Item.field_77703_o, p_76544_1_.nextInt(4) + 1);
        }
        if(i == 2)
        {
            return new ItemStack(Item.field_77684_U);
        }
        if(i == 3)
        {
            return new ItemStack(Item.field_77685_T, p_76544_1_.nextInt(4) + 1);
        }
        if(i == 4)
        {
            return new ItemStack(Item.field_77677_M, p_76544_1_.nextInt(4) + 1);
        }
        if(i == 5)
        {
            return new ItemStack(Item.field_77683_K, p_76544_1_.nextInt(4) + 1);
        }
        if(i == 6)
        {
            return new ItemStack(Item.field_77788_aw);
        }
        if(i == 7 && p_76544_1_.nextInt(100) == 0)
        {
            return new ItemStack(Item.field_77778_at);
        }
        if(i == 8 && p_76544_1_.nextInt(2) == 0)
        {
            return new ItemStack(Item.field_77767_aC, p_76544_1_.nextInt(4) + 1);
        }
        if(i == 9 && p_76544_1_.nextInt(10) == 0)
        {
            return new ItemStack(Item.field_77698_e[Item.field_77819_bI.field_77779_bT + p_76544_1_.nextInt(2)]);
        }
        if(i == 10)
        {
            return new ItemStack(Item.field_77756_aW, 1, 3);
        } else
        {
            return null;
        }
    }

    private String func_76543_b(Random p_76543_1_)
    {
        int i = p_76543_1_.nextInt(4);
        if(i == 0)
        {
            return "Skeleton";
        }
        if(i == 1)
        {
            return "Zombie";
        }
        if(i == 2)
        {
            return "Zombie";
        }
        if(i == 3)
        {
            return "Spider";
        } else
        {
            return "";
        }
    }
}
