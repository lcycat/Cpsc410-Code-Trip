// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Item, CreativeTabs, World, EntityPlayer, 
//            Block, BlockEndPortalFrame, ItemStack, Direction, 
//            MovingObjectPosition, EnumMovingObjectType, EntityEnderEye, ChunkPosition, 
//            PlayerCapabilities

public class ItemEnderEye extends Item
{

    public ItemEnderEye(int p_i3647_1_)
    {
        super(p_i3647_1_);
        func_77637_a(CreativeTabs.field_78026_f);
    }

    public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, 
            float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        int i = p_77648_3_.func_72798_a(p_77648_4_, p_77648_5_, p_77648_6_);
        int j = p_77648_3_.func_72805_g(p_77648_4_, p_77648_5_, p_77648_6_);
        if(p_77648_2_.func_71031_e(p_77648_4_, p_77648_5_, p_77648_6_) && i == Block.field_72104_bI.field_71990_ca && !BlockEndPortalFrame.func_72165_e(j))
        {
            if(p_77648_3_.field_72995_K)
            {
                return true;
            }
            p_77648_3_.func_72921_c(p_77648_4_, p_77648_5_, p_77648_6_, j + 4);
            p_77648_1_.field_77994_a--;
            for(int k = 0; k < 16; k++)
            {
                double d = (float)p_77648_4_ + (5F + field_77697_d.nextFloat() * 6F) / 16F;
                double d1 = (float)p_77648_5_ + 0.8125F;
                double d2 = (float)p_77648_6_ + (5F + field_77697_d.nextFloat() * 6F) / 16F;
                double d3 = 0.0D;
                double d4 = 0.0D;
                double d5 = 0.0D;
                p_77648_3_.func_72869_a("smoke", d, d1, d2, d3, d4, d5);
            }

            int l = j & 3;
            int i1 = 0;
            int j1 = 0;
            boolean flag = false;
            boolean flag1 = true;
            int k1 = Direction.field_71577_f[l];
            for(int l1 = -2; l1 <= 2; l1++)
            {
                int l2 = p_77648_4_ + Direction.field_71583_a[k1] * l1;
                int l3 = p_77648_6_ + Direction.field_71581_b[k1] * l1;
                int l4 = p_77648_3_.func_72798_a(l2, p_77648_5_, l3);
                if(l4 != Block.field_72104_bI.field_71990_ca)
                {
                    continue;
                }
                int l5 = p_77648_3_.func_72805_g(l2, p_77648_5_, l3);
                if(!BlockEndPortalFrame.func_72165_e(l5))
                {
                    flag1 = false;
                    break;
                }
                j1 = l1;
                if(!flag)
                {
                    i1 = l1;
                    flag = true;
                }
            }

            if(flag1 && j1 == i1 + 2)
            {
                int i2 = i1;
                do
                {
                    if(i2 > j1)
                    {
                        break;
                    }
                    int i3 = p_77648_4_ + Direction.field_71583_a[k1] * i2;
                    int i4 = p_77648_6_ + Direction.field_71581_b[k1] * i2;
                    i3 += Direction.field_71583_a[l] * 4;
                    i4 += Direction.field_71581_b[l] * 4;
                    int i5 = p_77648_3_.func_72798_a(i3, p_77648_5_, i4);
                    int i6 = p_77648_3_.func_72805_g(i3, p_77648_5_, i4);
                    if(i5 != Block.field_72104_bI.field_71990_ca || !BlockEndPortalFrame.func_72165_e(i6))
                    {
                        flag1 = false;
                        break;
                    }
                    i2++;
                } while(true);
label0:
                for(int j2 = i1 - 1; j2 <= j1 + 1; j2 += 4)
                {
                    int j3 = 1;
                    do
                    {
                        if(j3 > 3)
                        {
                            continue label0;
                        }
                        int j4 = p_77648_4_ + Direction.field_71583_a[k1] * j2;
                        int j5 = p_77648_6_ + Direction.field_71581_b[k1] * j2;
                        j4 += Direction.field_71583_a[l] * j3;
                        j5 += Direction.field_71581_b[l] * j3;
                        int j6 = p_77648_3_.func_72798_a(j4, p_77648_5_, j5);
                        int k6 = p_77648_3_.func_72805_g(j4, p_77648_5_, j5);
                        if(j6 != Block.field_72104_bI.field_71990_ca || !BlockEndPortalFrame.func_72165_e(k6))
                        {
                            flag1 = false;
                            continue label0;
                        }
                        j3++;
                    } while(true);
                }

                if(flag1)
                {
                    for(int k2 = i1; k2 <= j1; k2++)
                    {
                        for(int k3 = 1; k3 <= 3; k3++)
                        {
                            int k4 = p_77648_4_ + Direction.field_71583_a[k1] * k2;
                            int k5 = p_77648_6_ + Direction.field_71581_b[k1] * k2;
                            k4 += Direction.field_71583_a[l] * k3;
                            k5 += Direction.field_71581_b[l] * k3;
                            p_77648_3_.func_72859_e(k4, p_77648_5_, k5, Block.field_72102_bH.field_71990_ca);
                        }

                    }

                }
            }
            return true;
        } else
        {
            return false;
        }
    }

    public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
        MovingObjectPosition movingobjectposition = func_77621_a(p_77659_2_, p_77659_3_, false);
        if(movingobjectposition != null && movingobjectposition.field_72313_a == EnumMovingObjectType.TILE)
        {
            int i = p_77659_2_.func_72798_a(movingobjectposition.field_72311_b, movingobjectposition.field_72312_c, movingobjectposition.field_72309_d);
            if(i == Block.field_72104_bI.field_71990_ca)
            {
                return p_77659_1_;
            }
        }
        if(!p_77659_2_.field_72995_K)
        {
            ChunkPosition chunkposition = p_77659_2_.func_72946_b("Stronghold", (int)p_77659_3_.field_70165_t, (int)p_77659_3_.field_70163_u, (int)p_77659_3_.field_70161_v);
            if(chunkposition != null)
            {
                EntityEnderEye entityendereye = new EntityEnderEye(p_77659_2_, p_77659_3_.field_70165_t, (p_77659_3_.field_70163_u + 1.6200000000000001D) - (double)p_77659_3_.field_70129_M, p_77659_3_.field_70161_v);
                entityendereye.func_70220_a(chunkposition.field_76930_a, chunkposition.field_76928_b, chunkposition.field_76929_c);
                p_77659_2_.func_72838_d(entityendereye);
                p_77659_2_.func_72956_a(p_77659_3_, "random.bow", 0.5F, 0.4F / (field_77697_d.nextFloat() * 0.4F + 0.8F));
                p_77659_2_.func_72889_a(null, 1002, (int)p_77659_3_.field_70165_t, (int)p_77659_3_.field_70163_u, (int)p_77659_3_.field_70161_v, 0);
                if(!p_77659_3_.field_71075_bZ.field_75098_d)
                {
                    p_77659_1_.field_77994_a--;
                }
            }
        }
        return p_77659_1_;
    }
}
