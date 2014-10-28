// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            NBTTagCompound, AnvilConverterData, NibbleArrayReader, NBTTagList, 
//            NibbleArray, WorldChunkManager, BiomeGenBase

public class ChunkLoader
{

    public static AnvilConverterData func_76691_a(NBTTagCompound p_76691_0_)
    {
        int i = p_76691_0_.func_74762_e("xPos");
        int j = p_76691_0_.func_74762_e("zPos");
        AnvilConverterData anvilconverterdata = new AnvilConverterData(i, j);
        anvilconverterdata.field_76693_g = p_76691_0_.func_74770_j("Blocks");
        anvilconverterdata.field_76692_f = new NibbleArrayReader(p_76691_0_.func_74770_j("Data"), 7);
        anvilconverterdata.field_76695_e = new NibbleArrayReader(p_76691_0_.func_74770_j("SkyLight"), 7);
        anvilconverterdata.field_76694_d = new NibbleArrayReader(p_76691_0_.func_74770_j("BlockLight"), 7);
        anvilconverterdata.field_76697_c = p_76691_0_.func_74770_j("HeightMap");
        anvilconverterdata.field_76696_b = p_76691_0_.func_74767_n("TerrainPopulated");
        anvilconverterdata.field_76702_h = p_76691_0_.func_74761_m("Entities");
        anvilconverterdata.field_76703_i = p_76691_0_.func_74761_m("TileEntities");
        anvilconverterdata.field_76700_j = p_76691_0_.func_74761_m("TileTicks");
        try
        {
            anvilconverterdata.field_76698_a = p_76691_0_.func_74763_f("LastUpdate");
        }
        catch(ClassCastException classcastexception)
        {
            anvilconverterdata.field_76698_a = p_76691_0_.func_74762_e("LastUpdate");
        }
        return anvilconverterdata;
    }

    public static void func_76690_a(AnvilConverterData p_76690_0_, NBTTagCompound p_76690_1_, WorldChunkManager p_76690_2_)
    {
        p_76690_1_.func_74768_a("xPos", p_76690_0_.field_76701_k);
        p_76690_1_.func_74768_a("zPos", p_76690_0_.field_76699_l);
        p_76690_1_.func_74772_a("LastUpdate", p_76690_0_.field_76698_a);
        int ai[] = new int[p_76690_0_.field_76697_c.length];
        for(int i = 0; i < p_76690_0_.field_76697_c.length; i++)
        {
            ai[i] = p_76690_0_.field_76697_c[i];
        }

        p_76690_1_.func_74783_a("HeightMap", ai);
        p_76690_1_.func_74757_a("TerrainPopulated", p_76690_0_.field_76696_b);
        NBTTagList nbttaglist = new NBTTagList("Sections");
        for(int j = 0; j < 8; j++)
        {
            boolean flag = true;
            for(int l = 0; l < 16 && flag; l++)
            {
label0:
                for(int j1 = 0; j1 < 16 && flag; j1++)
                {
                    int k1 = 0;
                    do
                    {
                        if(k1 >= 16)
                        {
                            continue label0;
                        }
                        int l1 = l << 11 | k1 << 7 | j1 + (j << 4);
                        byte byte0 = p_76690_0_.field_76693_g[l1];
                        if(byte0 != 0)
                        {
                            flag = false;
                            continue label0;
                        }
                        k1++;
                    } while(true);
                }

            }

            if(flag)
            {
                continue;
            }
            byte abyte1[] = new byte[4096];
            NibbleArray nibblearray = new NibbleArray(abyte1.length, 4);
            NibbleArray nibblearray1 = new NibbleArray(abyte1.length, 4);
            NibbleArray nibblearray2 = new NibbleArray(abyte1.length, 4);
            for(int i2 = 0; i2 < 16; i2++)
            {
                for(int j2 = 0; j2 < 16; j2++)
                {
                    for(int k2 = 0; k2 < 16; k2++)
                    {
                        int l2 = i2 << 11 | k2 << 7 | j2 + (j << 4);
                        byte byte1 = p_76690_0_.field_76693_g[l2];
                        abyte1[j2 << 8 | k2 << 4 | i2] = (byte)(byte1 & 0xff);
                        nibblearray.func_76581_a(i2, j2, k2, p_76690_0_.field_76692_f.func_76686_a(i2, j2 + (j << 4), k2));
                        nibblearray1.func_76581_a(i2, j2, k2, p_76690_0_.field_76695_e.func_76686_a(i2, j2 + (j << 4), k2));
                        nibblearray2.func_76581_a(i2, j2, k2, p_76690_0_.field_76694_d.func_76686_a(i2, j2 + (j << 4), k2));
                    }

                }

            }

            NBTTagCompound nbttagcompound = new NBTTagCompound();
            nbttagcompound.func_74774_a("Y", (byte)(j & 0xff));
            nbttagcompound.func_74773_a("Blocks", abyte1);
            nbttagcompound.func_74773_a("Data", nibblearray.field_76585_a);
            nbttagcompound.func_74773_a("SkyLight", nibblearray1.field_76585_a);
            nbttagcompound.func_74773_a("BlockLight", nibblearray2.field_76585_a);
            nbttaglist.func_74742_a(nbttagcompound);
        }

        p_76690_1_.func_74782_a("Sections", nbttaglist);
        byte abyte0[] = new byte[256];
        for(int k = 0; k < 16; k++)
        {
            for(int i1 = 0; i1 < 16; i1++)
            {
                abyte0[i1 << 4 | k] = (byte)(p_76690_2_.func_76935_a(p_76690_0_.field_76701_k << 4 | k, p_76690_0_.field_76699_l << 4 | i1).field_76756_M & 0xff);
            }

        }

        p_76690_1_.func_74773_a("Biomes", abyte0);
        p_76690_1_.func_74782_a("Entities", p_76690_0_.field_76702_h);
        p_76690_1_.func_74782_a("TileEntities", p_76690_0_.field_76703_i);
        if(p_76690_0_.field_76700_j != null)
        {
            p_76690_1_.func_74782_a("TileTicks", p_76690_0_.field_76700_j);
        }
    }
}
