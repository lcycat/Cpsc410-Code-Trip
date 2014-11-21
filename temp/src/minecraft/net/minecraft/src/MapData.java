// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            WorldSavedData, NBTTagCompound, MapInfo, EntityPlayer, 
//            InventoryPlayer, MapCoord, ItemStack, World

public class MapData extends WorldSavedData
{

    public int field_76201_a;
    public int field_76199_b;
    public byte field_76200_c;
    public byte field_76197_d;
    public byte field_76198_e[];
    public int field_76195_f;
    public List field_76196_g;
    private Map field_76202_j;
    public List field_76203_h;

    public MapData(String p_i3906_1_)
    {
        super(p_i3906_1_);
        field_76198_e = new byte[16384];
        field_76196_g = new ArrayList();
        field_76202_j = new HashMap();
        field_76203_h = new ArrayList();
    }

    public void func_76184_a(NBTTagCompound p_76184_1_)
    {
        field_76200_c = p_76184_1_.func_74771_c("dimension");
        field_76201_a = p_76184_1_.func_74762_e("xCenter");
        field_76199_b = p_76184_1_.func_74762_e("zCenter");
        field_76197_d = p_76184_1_.func_74771_c("scale");
        if(field_76197_d < 0)
        {
            field_76197_d = 0;
        }
        if(field_76197_d > 4)
        {
            field_76197_d = 4;
        }
        short word0 = p_76184_1_.func_74765_d("width");
        short word1 = p_76184_1_.func_74765_d("height");
        if(word0 == 128 && word1 == 128)
        {
            field_76198_e = p_76184_1_.func_74770_j("colors");
        } else
        {
            byte abyte0[] = p_76184_1_.func_74770_j("colors");
            field_76198_e = new byte[16384];
            int i = (128 - word0) / 2;
            int j = (128 - word1) / 2;
            for(int k = 0; k < word1; k++)
            {
                int l = k + j;
                if(l < 0 && l >= 128)
                {
                    continue;
                }
                for(int i1 = 0; i1 < word0; i1++)
                {
                    int j1 = i1 + i;
                    if(j1 >= 0 || j1 < 128)
                    {
                        field_76198_e[j1 + l * 128] = abyte0[i1 + k * word0];
                    }
                }

            }

        }
    }

    public void func_76187_b(NBTTagCompound p_76187_1_)
    {
        p_76187_1_.func_74774_a("dimension", field_76200_c);
        p_76187_1_.func_74768_a("xCenter", field_76201_a);
        p_76187_1_.func_74768_a("zCenter", field_76199_b);
        p_76187_1_.func_74774_a("scale", field_76197_d);
        p_76187_1_.func_74777_a("width", (short)128);
        p_76187_1_.func_74777_a("height", (short)128);
        p_76187_1_.func_74773_a("colors", field_76198_e);
    }

    public void func_76191_a(EntityPlayer p_76191_1_, ItemStack p_76191_2_)
    {
        if(!field_76202_j.containsKey(p_76191_1_))
        {
            MapInfo mapinfo = new MapInfo(this, p_76191_1_);
            field_76202_j.put(p_76191_1_, mapinfo);
            field_76196_g.add(mapinfo);
        }
        field_76203_h.clear();
        for(int i = 0; i < field_76196_g.size(); i++)
        {
            MapInfo mapinfo1 = (MapInfo)field_76196_g.get(i);
            if(mapinfo1.field_76211_a.field_70128_L || !mapinfo1.field_76211_a.field_71071_by.func_70431_c(p_76191_2_))
            {
                field_76202_j.remove(mapinfo1.field_76211_a);
                field_76196_g.remove(mapinfo1);
                continue;
            }
            float f = (float)(mapinfo1.field_76211_a.field_70165_t - (double)field_76201_a) / (float)(1 << field_76197_d);
            float f1 = (float)(mapinfo1.field_76211_a.field_70161_v - (double)field_76199_b) / (float)(1 << field_76197_d);
            int j = 64;
            int k = 64;
            if(f < (float)(-j) || f1 < (float)(-k) || f > (float)j || f1 > (float)k)
            {
                continue;
            }
            byte byte0 = 0;
            byte byte1 = (byte)(int)((double)(f * 2.0F) + 0.5D);
            byte byte2 = (byte)(int)((double)(f1 * 2.0F) + 0.5D);
            byte byte3 = (byte)(int)(((double)mapinfo1.field_76211_a.field_70177_z * 16D) / 360D);
            if(field_76200_c < 0)
            {
                int l = field_76195_f / 10;
                byte3 = (byte)(l * l * 0x209a771 + l * 121 >> 15 & 0xf);
            }
            if(mapinfo1.field_76211_a.field_71093_bK == field_76200_c)
            {
                field_76203_h.add(new MapCoord(this, byte0, byte1, byte2, byte3));
            }
        }

    }

    public byte[] func_76193_a(ItemStack p_76193_1_, World p_76193_2_, EntityPlayer p_76193_3_)
    {
        MapInfo mapinfo = (MapInfo)field_76202_j.get(p_76193_3_);
        if(mapinfo == null)
        {
            return null;
        } else
        {
            return mapinfo.func_76204_a(p_76193_1_);
        }
    }

    public void func_76194_a(int p_76194_1_, int p_76194_2_, int p_76194_3_)
    {
        super.func_76185_a();
        for(int i = 0; i < field_76196_g.size(); i++)
        {
            MapInfo mapinfo = (MapInfo)field_76196_g.get(i);
            if(mapinfo.field_76209_b[p_76194_1_] < 0 || mapinfo.field_76209_b[p_76194_1_] > p_76194_2_)
            {
                mapinfo.field_76209_b[p_76194_1_] = p_76194_2_;
            }
            if(mapinfo.field_76210_c[p_76194_1_] < 0 || mapinfo.field_76210_c[p_76194_1_] < p_76194_3_)
            {
                mapinfo.field_76210_c[p_76194_1_] = p_76194_3_;
            }
        }

    }

    public void func_76192_a(byte p_76192_1_[])
    {
        if(p_76192_1_[0] == 0)
        {
            int i = p_76192_1_[1] & 0xff;
            int k = p_76192_1_[2] & 0xff;
            for(int l = 0; l < p_76192_1_.length - 3; l++)
            {
                field_76198_e[(l + k) * 128 + i] = p_76192_1_[l + 3];
            }

            func_76185_a();
        } else
        if(p_76192_1_[0] == 1)
        {
            field_76203_h.clear();
            for(int j = 0; j < (p_76192_1_.length - 1) / 3; j++)
            {
                byte byte0 = (byte)(p_76192_1_[j * 3 + 1] % 16);
                byte byte1 = p_76192_1_[j * 3 + 2];
                byte byte2 = p_76192_1_[j * 3 + 3];
                byte byte3 = (byte)(p_76192_1_[j * 3 + 1] / 16);
                field_76203_h.add(new MapCoord(this, byte0, byte1, byte2, byte3));
            }

        }
    }
}
