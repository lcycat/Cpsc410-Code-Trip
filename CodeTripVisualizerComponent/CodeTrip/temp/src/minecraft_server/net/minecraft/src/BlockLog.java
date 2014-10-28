// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, CreativeTabs, World, 
//            BlockLeaves, EntityPlayer, BlockPistonBase, ItemStack, 
//            EntityLiving

public class BlockLog extends Block
{

    public static final String field_72142_a[] = {
        "oak", "spruce", "birch", "jungle"
    };

    protected BlockLog(int p_i4016_1_)
    {
        super(p_i4016_1_, Material.field_76245_d);
        field_72059_bZ = 20;
        func_71849_a(CreativeTabs.field_78030_b);
    }

    public int func_71857_b()
    {
        return 31;
    }

    public int func_71925_a(Random p_71925_1_)
    {
        return 1;
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        return Block.field_71951_J.field_71990_ca;
    }

    public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_)
    {
        byte byte0 = 4;
        int i = byte0 + 1;
        if(p_71852_1_.func_72904_c(p_71852_2_ - i, p_71852_3_ - i, p_71852_4_ - i, p_71852_2_ + i, p_71852_3_ + i, p_71852_4_ + i))
        {
            for(int j = -byte0; j <= byte0; j++)
            {
                for(int k = -byte0; k <= byte0; k++)
                {
                    for(int l = -byte0; l <= byte0; l++)
                    {
                        int i1 = p_71852_1_.func_72798_a(p_71852_2_ + j, p_71852_3_ + k, p_71852_4_ + l);
                        if(i1 != Block.field_71952_K.field_71990_ca)
                        {
                            continue;
                        }
                        int j1 = p_71852_1_.func_72805_g(p_71852_2_ + j, p_71852_3_ + k, p_71852_4_ + l);
                        if((j1 & 8) == 0)
                        {
                            p_71852_1_.func_72881_d(p_71852_2_ + j, p_71852_3_ + k, p_71852_4_ + l, j1 | 8);
                        }
                    }

                }

            }

        }
    }

    public void func_71860_a(World p_71860_1_, int p_71860_2_, int p_71860_3_, int p_71860_4_, EntityLiving p_71860_5_)
    {
        int i = p_71860_1_.func_72805_g(p_71860_2_, p_71860_3_, p_71860_4_) & 3;
        int j = BlockPistonBase.func_72116_b(p_71860_1_, p_71860_2_, p_71860_3_, p_71860_4_, (EntityPlayer)p_71860_5_);
        byte byte0 = 0;
        switch(j)
        {
        case 2: // '\002'
        case 3: // '\003'
            byte0 = 8;
            break;

        case 4: // '\004'
        case 5: // '\005'
            byte0 = 4;
            break;

        case 0: // '\0'
        case 1: // '\001'
            byte0 = 0;
            break;
        }
        p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, i | byte0);
    }

    public int func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        int i = p_71858_2_ & 0xc;
        int j = p_71858_2_ & 3;
        if(i == 0 && (p_71858_1_ == 1 || p_71858_1_ == 0))
        {
            return 21;
        }
        if(i == 4 && (p_71858_1_ == 5 || p_71858_1_ == 4))
        {
            return 21;
        }
        if(i == 8 && (p_71858_1_ == 2 || p_71858_1_ == 3))
        {
            return 21;
        }
        if(j == 1)
        {
            return 116;
        }
        if(j == 2)
        {
            return 117;
        }
        return j != 3 ? 20 : 153;
    }

    protected int func_71899_b(int p_71899_1_)
    {
        return p_71899_1_ & 3;
    }

    public static int func_72141_e(int p_72141_0_)
    {
        return p_72141_0_ & 3;
    }

    protected ItemStack func_71880_c_(int p_71880_1_)
    {
        return new ItemStack(field_71990_ca, 1, func_72141_e(p_71880_1_));
    }

}
