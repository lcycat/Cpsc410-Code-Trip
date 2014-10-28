// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Item, CreativeTabs, ItemStack, MathHelper, 
//            EntityPlayer, World, Block, BlockSapling, 
//            BlockFlower, BlockMushroom, BlockStem, BlockCrops, 
//            BlockDirectional, BlockGrass, BlockTallGrass, BlockLog, 
//            PlayerCapabilities, EntitySheep, BlockCloth, EntityLiving

public class ItemDye extends Item
{

    public static final String field_77860_a[] = {
        "black", "red", "green", "brown", "blue", "purple", "cyan", "silver", "gray", "pink", 
        "lime", "yellow", "lightBlue", "magenta", "orange", "white"
    };
    public static final int field_77859_b[] = {
        0x1e1b1b, 0xb3312c, 0x3b511a, 0x51301a, 0x253192, 0x7b2fbe, 0x287697, 0x287697, 0x434343, 0xd88198, 
        0x41cd34, 0xdecf2a, 0x6689d3, 0xc354cd, 0xeb8844, 0xf0f0f0
    };

    public ItemDye(int p_i3645_1_)
    {
        super(p_i3645_1_);
        func_77627_a(true);
        func_77656_e(0);
        func_77637_a(CreativeTabs.field_78035_l);
    }

    public String func_77667_c(ItemStack p_77667_1_)
    {
        int i = MathHelper.func_76125_a(p_77667_1_.func_77960_j(), 0, 15);
        return (new StringBuilder()).append(super.func_77658_a()).append(".").append(field_77860_a[i]).toString();
    }

    public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, 
            float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if(!p_77648_2_.func_71031_e(p_77648_4_, p_77648_5_, p_77648_6_))
        {
            return false;
        }
        if(p_77648_1_.func_77960_j() == 15)
        {
            int i = p_77648_3_.func_72798_a(p_77648_4_, p_77648_5_, p_77648_6_);
            if(i == Block.field_71987_y.field_71990_ca)
            {
                if(!p_77648_3_.field_72995_K)
                {
                    ((BlockSapling)Block.field_71987_y).func_72269_c(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_3_.field_73012_v);
                    p_77648_1_.field_77994_a--;
                }
                return true;
            }
            if(i == Block.field_72109_af.field_71990_ca || i == Block.field_72103_ag.field_71990_ca)
            {
                if(!p_77648_3_.field_72995_K && ((BlockMushroom)Block.field_71973_m[i]).func_72271_c(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_3_.field_73012_v))
                {
                    p_77648_1_.field_77994_a--;
                }
                return true;
            }
            if(i == Block.field_71999_bt.field_71990_ca || i == Block.field_71996_bs.field_71990_ca)
            {
                if(p_77648_3_.func_72805_g(p_77648_4_, p_77648_5_, p_77648_6_) == 7)
                {
                    return false;
                }
                if(!p_77648_3_.field_72995_K)
                {
                    ((BlockStem)Block.field_71973_m[i]).func_72264_l(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_);
                    p_77648_1_.field_77994_a--;
                }
                return true;
            }
            if(i == Block.field_72058_az.field_71990_ca)
            {
                if(p_77648_3_.func_72805_g(p_77648_4_, p_77648_5_, p_77648_6_) == 7)
                {
                    return false;
                }
                if(!p_77648_3_.field_72995_K)
                {
                    ((BlockCrops)Block.field_72058_az).func_72272_c_(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_);
                    p_77648_1_.field_77994_a--;
                }
                return true;
            }
            if(i == Block.field_72086_bP.field_71990_ca)
            {
                if(!p_77648_3_.field_72995_K)
                {
                    p_77648_3_.func_72921_c(p_77648_4_, p_77648_5_, p_77648_6_, 8 | BlockDirectional.func_72217_d(p_77648_3_.func_72805_g(p_77648_4_, p_77648_5_, p_77648_6_)));
                    p_77648_1_.field_77994_a--;
                }
                return true;
            }
            if(i == Block.field_71980_u.field_71990_ca)
            {
                if(!p_77648_3_.field_72995_K)
                {
                    p_77648_1_.field_77994_a--;
label0:
                    for(int k = 0; k < 128; k++)
                    {
                        int i1 = p_77648_4_;
                        int j1 = p_77648_5_ + 1;
                        int k1 = p_77648_6_;
                        for(int l1 = 0; l1 < k / 16; l1++)
                        {
                            i1 += field_77697_d.nextInt(3) - 1;
                            j1 += ((field_77697_d.nextInt(3) - 1) * field_77697_d.nextInt(3)) / 2;
                            k1 += field_77697_d.nextInt(3) - 1;
                            if(p_77648_3_.func_72798_a(i1, j1 - 1, k1) != Block.field_71980_u.field_71990_ca || p_77648_3_.func_72809_s(i1, j1, k1))
                            {
                                continue label0;
                            }
                        }

                        if(p_77648_3_.func_72798_a(i1, j1, k1) != 0)
                        {
                            continue;
                        }
                        if(field_77697_d.nextInt(10) != 0)
                        {
                            if(Block.field_71962_X.func_71854_d(p_77648_3_, i1, j1, k1))
                            {
                                p_77648_3_.func_72832_d(i1, j1, k1, Block.field_71962_X.field_71990_ca, 1);
                            }
                            continue;
                        }
                        if(field_77697_d.nextInt(3) != 0)
                        {
                            if(Block.field_72097_ad.func_71854_d(p_77648_3_, i1, j1, k1))
                            {
                                p_77648_3_.func_72859_e(i1, j1, k1, Block.field_72097_ad.field_71990_ca);
                            }
                            continue;
                        }
                        if(Block.field_72107_ae.func_71854_d(p_77648_3_, i1, j1, k1))
                        {
                            p_77648_3_.func_72859_e(i1, j1, k1, Block.field_72107_ae.field_71990_ca);
                        }
                    }

                }
                return true;
            }
        } else
        if(p_77648_1_.func_77960_j() == 3)
        {
            int j = p_77648_3_.func_72798_a(p_77648_4_, p_77648_5_, p_77648_6_);
            int l = p_77648_3_.func_72805_g(p_77648_4_, p_77648_5_, p_77648_6_);
            if(j == Block.field_71951_J.field_71990_ca && BlockLog.func_72141_e(l) == 3)
            {
                if(p_77648_7_ == 0)
                {
                    return false;
                }
                if(p_77648_7_ == 1)
                {
                    return false;
                }
                if(p_77648_7_ == 2)
                {
                    p_77648_6_--;
                }
                if(p_77648_7_ == 3)
                {
                    p_77648_6_++;
                }
                if(p_77648_7_ == 4)
                {
                    p_77648_4_--;
                }
                if(p_77648_7_ == 5)
                {
                    p_77648_4_++;
                }
                if(p_77648_3_.func_72799_c(p_77648_4_, p_77648_5_, p_77648_6_))
                {
                    p_77648_3_.func_72859_e(p_77648_4_, p_77648_5_, p_77648_6_, Block.field_72086_bP.field_71990_ca);
                    if(p_77648_3_.func_72798_a(p_77648_4_, p_77648_5_, p_77648_6_) == Block.field_72086_bP.field_71990_ca)
                    {
                        Block.field_71973_m[Block.field_72086_bP.field_71990_ca].func_71909_a(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_8_, p_77648_9_, p_77648_10_);
                    }
                    if(!p_77648_2_.field_71075_bZ.field_75098_d)
                    {
                        p_77648_1_.field_77994_a--;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public boolean func_77646_a(ItemStack p_77646_1_, EntityLiving p_77646_2_)
    {
        if(p_77646_2_ instanceof EntitySheep)
        {
            EntitySheep entitysheep = (EntitySheep)p_77646_2_;
            int i = BlockCloth.func_72238_e_(p_77646_1_.func_77960_j());
            if(!entitysheep.func_70892_o() && entitysheep.func_70896_n() != i)
            {
                entitysheep.func_70891_b(i);
                p_77646_1_.field_77994_a--;
            }
            return true;
        } else
        {
            return false;
        }
    }

}
