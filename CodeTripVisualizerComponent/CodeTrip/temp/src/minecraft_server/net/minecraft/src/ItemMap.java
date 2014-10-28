// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemMapBase, CreativeTabs, ItemStack, MapData, 
//            World, WorldInfo, WorldProvider, Entity, 
//            MathHelper, Chunk, Block, Material, 
//            MapColor, EntityPlayer, Packet131MapData, Item, 
//            Packet

public class ItemMap extends ItemMapBase
{

    protected ItemMap(int p_i3668_1_)
    {
        super(p_i3668_1_);
        func_77625_d(1);
        func_77637_a(CreativeTabs.field_78026_f);
    }

    public MapData func_77873_a(ItemStack p_77873_1_, World p_77873_2_)
    {
        String s = (new StringBuilder()).append("map_").append(p_77873_1_.func_77960_j()).toString();
        MapData mapdata = (MapData)p_77873_2_.func_72943_a(net.minecraft.src.MapData.class, (new StringBuilder()).append("map_").append(p_77873_1_.func_77960_j()).toString());
        if(mapdata == null)
        {
            p_77873_1_.func_77964_b(p_77873_2_.func_72841_b("map"));
            String s1 = (new StringBuilder()).append("map_").append(p_77873_1_.func_77960_j()).toString();
            mapdata = new MapData(s1);
            mapdata.field_76201_a = p_77873_2_.func_72912_H().func_76079_c();
            mapdata.field_76199_b = p_77873_2_.func_72912_H().func_76074_e();
            mapdata.field_76197_d = 3;
            mapdata.field_76200_c = (byte)p_77873_2_.field_73011_w.field_76574_g;
            mapdata.func_76185_a();
            p_77873_2_.func_72823_a(s1, mapdata);
        }
        return mapdata;
    }

    public void func_77872_a(World p_77872_1_, Entity p_77872_2_, MapData p_77872_3_)
    {
        if(p_77872_1_.field_73011_w.field_76574_g != p_77872_3_.field_76200_c)
        {
            return;
        }
        char c = '\200';
        char c1 = '\200';
        int i = 1 << p_77872_3_.field_76197_d;
        int j = p_77872_3_.field_76201_a;
        int k = p_77872_3_.field_76199_b;
        int l = MathHelper.func_76128_c(p_77872_2_.field_70165_t - (double)j) / i + c / 2;
        int i1 = MathHelper.func_76128_c(p_77872_2_.field_70161_v - (double)k) / i + c1 / 2;
        int j1 = 128 / i;
        if(p_77872_1_.field_73011_w.field_76576_e)
        {
            j1 /= 2;
        }
        p_77872_3_.field_76195_f++;
        for(int k1 = (l - j1) + 1; k1 < l + j1; k1++)
        {
            if((k1 & 0xf) != (p_77872_3_.field_76195_f & 0xf))
            {
                continue;
            }
            int l1 = 255;
            int i2 = 0;
            double d = 0.0D;
            for(int j2 = i1 - j1 - 1; j2 < i1 + j1; j2++)
            {
                if(k1 < 0 || j2 < -1 || k1 >= c || j2 >= c1)
                {
                    continue;
                }
                int k2 = k1 - l;
                int l2 = j2 - i1;
                boolean flag = k2 * k2 + l2 * l2 > (j1 - 2) * (j1 - 2);
                int i3 = ((j / i + k1) - c / 2) * i;
                int j3 = ((k / i + j2) - c1 / 2) * i;
                int k3 = 0;
                int l3 = 0;
                int i4 = 0;
                int ai[] = new int[256];
                Chunk chunk = p_77872_1_.func_72938_d(i3, j3);
                if(chunk.func_76621_g())
                {
                    continue;
                }
                int j4 = i3 & 0xf;
                int k4 = j3 & 0xf;
                int l4 = 0;
                double d1 = 0.0D;
                if(p_77872_1_.field_73011_w.field_76576_e)
                {
                    int i5 = i3 + j3 * 0x389bf;
                    i5 = i5 * i5 * 0x1dd6751 + i5 * 11;
                    if((i5 >> 20 & 1) == 0)
                    {
                        ai[Block.field_71979_v.field_71990_ca] += 10;
                    } else
                    {
                        ai[Block.field_71981_t.field_71990_ca] += 10;
                    }
                    d1 = 100D;
                } else
                {
                    for(int j5 = 0; j5 < i; j5++)
                    {
                        for(int l5 = 0; l5 < i; l5++)
                        {
                            int j6 = chunk.func_76611_b(j5 + j4, l5 + k4) + 1;
                            int l6 = 0;
                            if(j6 > 1)
                            {
                                boolean flag1 = false;
                                do
                                {
                                    flag1 = true;
                                    l6 = chunk.func_76610_a(j5 + j4, j6 - 1, l5 + k4);
                                    if(l6 == 0)
                                    {
                                        flag1 = false;
                                    } else
                                    if(j6 > 0 && l6 > 0 && Block.field_71973_m[l6].field_72018_cp.field_76234_F == MapColor.field_76279_b)
                                    {
                                        flag1 = false;
                                    }
                                    if(flag1)
                                    {
                                        continue;
                                    }
                                    if(--j6 <= 0)
                                    {
                                        break;
                                    }
                                    l6 = chunk.func_76610_a(j5 + j4, j6 - 1, l5 + k4);
                                } while(j6 > 0 && !flag1);
                                if(j6 > 0 && l6 != 0 && Block.field_71973_m[l6].field_72018_cp.func_76224_d())
                                {
                                    int i7 = j6 - 1;
                                    int k7 = 0;
                                    do
                                    {
                                        k7 = chunk.func_76610_a(j5 + j4, i7--, l5 + k4);
                                        l4++;
                                    } while(i7 > 0 && k7 != 0 && Block.field_71973_m[k7].field_72018_cp.func_76224_d());
                                }
                            }
                            d1 += (double)j6 / (double)(i * i);
                            ai[l6]++;
                        }

                    }

                }
                l4 /= i * i;
                k3 /= i * i;
                l3 /= i * i;
                i4 /= i * i;
                int k5 = 0;
                int i6 = 0;
                for(int k6 = 0; k6 < 256; k6++)
                {
                    if(ai[k6] > k5)
                    {
                        i6 = k6;
                        k5 = ai[k6];
                    }
                }

                double d2 = ((d1 - d) * 4D) / (double)(i + 4) + ((double)(k1 + j2 & 1) - 0.5D) * 0.40000000000000002D;
                byte byte0 = 1;
                if(d2 > 0.59999999999999998D)
                {
                    byte0 = 2;
                }
                if(d2 < -0.59999999999999998D)
                {
                    byte0 = 0;
                }
                int j7 = 0;
                if(i6 > 0)
                {
                    MapColor mapcolor = Block.field_71973_m[i6].field_72018_cp.field_76234_F;
                    if(mapcolor == MapColor.field_76282_n)
                    {
                        double d3 = (double)l4 * 0.10000000000000001D + (double)(k1 + j2 & 1) * 0.20000000000000001D;
                        byte0 = 1;
                        if(d3 < 0.5D)
                        {
                            byte0 = 2;
                        }
                        if(d3 > 0.90000000000000002D)
                        {
                            byte0 = 0;
                        }
                    }
                    j7 = mapcolor.field_76290_q;
                }
                d = d1;
                if(j2 < 0 || k2 * k2 + l2 * l2 >= j1 * j1 || flag && (k1 + j2 & 1) == 0)
                {
                    continue;
                }
                byte byte1 = p_77872_3_.field_76198_e[k1 + j2 * c];
                byte byte2 = (byte)(j7 * 4 + byte0);
                if(byte1 == byte2)
                {
                    continue;
                }
                if(l1 > j2)
                {
                    l1 = j2;
                }
                if(i2 < j2)
                {
                    i2 = j2;
                }
                p_77872_3_.field_76198_e[k1 + j2 * c] = byte2;
            }

            if(l1 <= i2)
            {
                p_77872_3_.func_76194_a(k1, l1, i2);
            }
        }

    }

    public void func_77663_a(ItemStack p_77663_1_, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_)
    {
        if(p_77663_2_.field_72995_K)
        {
            return;
        }
        MapData mapdata = func_77873_a(p_77663_1_, p_77663_2_);
        if(p_77663_3_ instanceof EntityPlayer)
        {
            EntityPlayer entityplayer = (EntityPlayer)p_77663_3_;
            mapdata.func_76191_a(entityplayer, p_77663_1_);
        }
        if(p_77663_5_)
        {
            func_77872_a(p_77663_2_, p_77663_3_, mapdata);
        }
    }

    public void func_77622_d(ItemStack p_77622_1_, World p_77622_2_, EntityPlayer p_77622_3_)
    {
        p_77622_1_.func_77964_b(p_77622_2_.func_72841_b("map"));
        String s = (new StringBuilder()).append("map_").append(p_77622_1_.func_77960_j()).toString();
        MapData mapdata = new MapData(s);
        p_77622_2_.func_72823_a(s, mapdata);
        mapdata.field_76201_a = MathHelper.func_76128_c(p_77622_3_.field_70165_t);
        mapdata.field_76199_b = MathHelper.func_76128_c(p_77622_3_.field_70161_v);
        mapdata.field_76197_d = 3;
        mapdata.field_76200_c = (byte)p_77622_2_.field_73011_w.field_76574_g;
        mapdata.func_76185_a();
    }

    public Packet func_77871_c(ItemStack p_77871_1_, World p_77871_2_, EntityPlayer p_77871_3_)
    {
        byte abyte0[] = func_77873_a(p_77871_1_, p_77871_2_).func_76193_a(p_77871_1_, p_77871_2_, p_77871_3_);
        if(abyte0 == null)
        {
            return null;
        } else
        {
            return new Packet131MapData((short)Item.field_77744_bd.field_77779_bT, (short)p_77871_1_.func_77960_j(), abyte0);
        }
    }
}
