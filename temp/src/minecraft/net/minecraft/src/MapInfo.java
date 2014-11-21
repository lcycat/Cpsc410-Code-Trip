// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            MapData, MapCoord, EntityPlayer, ItemStack

public class MapInfo
{

    public final EntityPlayer field_76211_a;
    public int field_76209_b[];
    public int field_76210_c[];
    private int field_76208_e;
    private int field_76205_f;
    private byte field_76206_g[];
    final MapData field_76207_d; /* synthetic field */

    public MapInfo(MapData p_i3904_1_, EntityPlayer p_i3904_2_)
    {
        field_76207_d = p_i3904_1_;
        super();
        field_76209_b = new int[128];
        field_76210_c = new int[128];
        field_76208_e = 0;
        field_76205_f = 0;
        field_76211_a = p_i3904_2_;
        for(int i = 0; i < field_76209_b.length; i++)
        {
            field_76209_b[i] = 0;
            field_76210_c[i] = 127;
        }

    }

    public byte[] func_76204_a(ItemStack p_76204_1_)
    {
        if(--field_76205_f < 0)
        {
            field_76205_f = 4;
            byte abyte0[] = new byte[field_76207_d.field_76203_h.size() * 3 + 1];
            abyte0[0] = 1;
            for(int j = 0; j < field_76207_d.field_76203_h.size(); j++)
            {
                MapCoord mapcoord = (MapCoord)field_76207_d.field_76203_h.get(j);
                abyte0[j * 3 + 1] = (byte)(mapcoord.field_76216_a + (mapcoord.field_76212_d & 0xf) * 16);
                abyte0[j * 3 + 2] = mapcoord.field_76214_b;
                abyte0[j * 3 + 3] = mapcoord.field_76215_c;
            }

            boolean flag = true;
            if(field_76206_g == null || field_76206_g.length != abyte0.length)
            {
                flag = false;
            } else
            {
                int l = 0;
                do
                {
                    if(l >= abyte0.length)
                    {
                        break;
                    }
                    if(abyte0[l] != field_76206_g[l])
                    {
                        flag = false;
                        break;
                    }
                    l++;
                } while(true);
            }
            if(!flag)
            {
                field_76206_g = abyte0;
                return abyte0;
            }
        }
        for(int i = 0; i < 10; i++)
        {
            int k = (field_76208_e * 11) % 128;
            field_76208_e++;
            if(field_76209_b[k] >= 0)
            {
                int i1 = (field_76210_c[k] - field_76209_b[k]) + 1;
                int j1 = field_76209_b[k];
                byte abyte1[] = new byte[i1 + 3];
                abyte1[0] = 0;
                abyte1[1] = (byte)k;
                abyte1[2] = (byte)j1;
                for(int k1 = 0; k1 < abyte1.length - 3; k1++)
                {
                    abyte1[k1 + 3] = field_76207_d.field_76198_e[(k1 + j1) * 128 + k];
                }

                field_76210_c[k] = -1;
                field_76209_b[k] = -1;
                return abyte1;
            }
        }

        return null;
    }
}
