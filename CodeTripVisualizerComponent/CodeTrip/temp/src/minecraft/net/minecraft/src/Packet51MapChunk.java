// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.zip.*;

// Referenced classes of package net.minecraft.src:
//            Packet, Chunk, Packet51MapChunkData, NetHandler, 
//            ExtendedBlockStorage, NibbleArray

public class Packet51MapChunk extends Packet
{

    public int field_73601_a;
    public int field_73599_b;
    public int field_73600_c;
    public int field_73597_d;
    private byte field_73595_f[];
    private byte field_73596_g[];
    public boolean field_73598_e;
    private int field_73602_h;
    private static byte field_73603_i[] = new byte[0x30100];

    public Packet51MapChunk()
    {
        field_73287_r = true;
    }

    public Packet51MapChunk(Chunk p_i3323_1_, boolean p_i3323_2_, int p_i3323_3_)
    {
        field_73287_r = true;
        field_73601_a = p_i3323_1_.field_76635_g;
        field_73599_b = p_i3323_1_.field_76647_h;
        field_73598_e = p_i3323_2_;
        Packet51MapChunkData packet51mapchunkdata = func_73594_a(p_i3323_1_, p_i3323_2_, p_i3323_3_);
        Deflater deflater = new Deflater(-1);
        field_73597_d = packet51mapchunkdata.field_74581_c;
        field_73600_c = packet51mapchunkdata.field_74580_b;
        try
        {
            field_73596_g = packet51mapchunkdata.field_74582_a;
            deflater.setInput(packet51mapchunkdata.field_74582_a, 0, packet51mapchunkdata.field_74582_a.length);
            deflater.finish();
            field_73595_f = new byte[packet51mapchunkdata.field_74582_a.length];
            field_73602_h = deflater.deflate(field_73595_f);
        }
        finally
        {
            deflater.end();
        }
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73601_a = p_73267_1_.readInt();
        field_73599_b = p_73267_1_.readInt();
        field_73598_e = p_73267_1_.readBoolean();
        field_73600_c = p_73267_1_.readShort();
        field_73597_d = p_73267_1_.readShort();
        field_73602_h = p_73267_1_.readInt();
        if(field_73603_i.length < field_73602_h)
        {
            field_73603_i = new byte[field_73602_h];
        }
        p_73267_1_.readFully(field_73603_i, 0, field_73602_h);
        int i = 0;
        for(int j = 0; j < 16; j++)
        {
            i += field_73600_c >> j & 1;
        }

        int k = 12288 * i;
        if(field_73598_e)
        {
            k += 256;
        }
        field_73596_g = new byte[k];
        Inflater inflater = new Inflater();
        inflater.setInput(field_73603_i, 0, field_73602_h);
        try
        {
            inflater.inflate(field_73596_g);
        }
        catch(DataFormatException dataformatexception)
        {
            throw new IOException("Bad compressed data format");
        }
        finally
        {
            inflater.end();
        }
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeInt(field_73601_a);
        p_73273_1_.writeInt(field_73599_b);
        p_73273_1_.writeBoolean(field_73598_e);
        p_73273_1_.writeShort((short)(field_73600_c & 0xffff));
        p_73273_1_.writeShort((short)(field_73597_d & 0xffff));
        p_73273_1_.writeInt(field_73602_h);
        p_73273_1_.write(field_73595_f, 0, field_73602_h);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72463_a(this);
    }

    public int func_73284_a()
    {
        return 17 + field_73602_h;
    }

    public byte[] func_73593_d()
    {
        return field_73596_g;
    }

    public static Packet51MapChunkData func_73594_a(Chunk p_73594_0_, boolean p_73594_1_, int p_73594_2_)
    {
        int i = 0;
        ExtendedBlockStorage aextendedblockstorage[] = p_73594_0_.func_76587_i();
        int j = 0;
        Packet51MapChunkData packet51mapchunkdata = new Packet51MapChunkData();
        byte abyte0[] = field_73603_i;
        if(p_73594_1_)
        {
            p_73594_0_.field_76642_o = true;
        }
        for(int k = 0; k < aextendedblockstorage.length; k++)
        {
            if(aextendedblockstorage[k] == null || p_73594_1_ && aextendedblockstorage[k].func_76663_a() || (p_73594_2_ & 1 << k) == 0)
            {
                continue;
            }
            packet51mapchunkdata.field_74580_b |= 1 << k;
            if(aextendedblockstorage[k].func_76660_i() != null)
            {
                packet51mapchunkdata.field_74581_c |= 1 << k;
                j++;
            }
        }

        for(int l = 0; l < aextendedblockstorage.length; l++)
        {
            if(aextendedblockstorage[l] != null && (!p_73594_1_ || !aextendedblockstorage[l].func_76663_a()) && (p_73594_2_ & 1 << l) != 0)
            {
                byte abyte2[] = aextendedblockstorage[l].func_76658_g();
                System.arraycopy(abyte2, 0, abyte0, i, abyte2.length);
                i += abyte2.length;
            }
        }

        for(int i1 = 0; i1 < aextendedblockstorage.length; i1++)
        {
            if(aextendedblockstorage[i1] != null && (!p_73594_1_ || !aextendedblockstorage[i1].func_76663_a()) && (p_73594_2_ & 1 << i1) != 0)
            {
                NibbleArray nibblearray = aextendedblockstorage[i1].func_76669_j();
                System.arraycopy(nibblearray.field_76585_a, 0, abyte0, i, nibblearray.field_76585_a.length);
                i += nibblearray.field_76585_a.length;
            }
        }

        for(int j1 = 0; j1 < aextendedblockstorage.length; j1++)
        {
            if(aextendedblockstorage[j1] != null && (!p_73594_1_ || !aextendedblockstorage[j1].func_76663_a()) && (p_73594_2_ & 1 << j1) != 0)
            {
                NibbleArray nibblearray1 = aextendedblockstorage[j1].func_76661_k();
                System.arraycopy(nibblearray1.field_76585_a, 0, abyte0, i, nibblearray1.field_76585_a.length);
                i += nibblearray1.field_76585_a.length;
            }
        }

        for(int k1 = 0; k1 < aextendedblockstorage.length; k1++)
        {
            if(aextendedblockstorage[k1] != null && (!p_73594_1_ || !aextendedblockstorage[k1].func_76663_a()) && (p_73594_2_ & 1 << k1) != 0)
            {
                NibbleArray nibblearray2 = aextendedblockstorage[k1].func_76671_l();
                System.arraycopy(nibblearray2.field_76585_a, 0, abyte0, i, nibblearray2.field_76585_a.length);
                i += nibblearray2.field_76585_a.length;
            }
        }

        if(j > 0)
        {
            for(int l1 = 0; l1 < aextendedblockstorage.length; l1++)
            {
                if(aextendedblockstorage[l1] != null && (!p_73594_1_ || !aextendedblockstorage[l1].func_76663_a()) && aextendedblockstorage[l1].func_76660_i() != null && (p_73594_2_ & 1 << l1) != 0)
                {
                    NibbleArray nibblearray3 = aextendedblockstorage[l1].func_76660_i();
                    System.arraycopy(nibblearray3.field_76585_a, 0, abyte0, i, nibblearray3.field_76585_a.length);
                    i += nibblearray3.field_76585_a.length;
                }
            }

        }
        if(p_73594_1_)
        {
            byte abyte1[] = p_73594_0_.func_76605_m();
            System.arraycopy(abyte1, 0, abyte0, i, abyte1.length);
            i += abyte1.length;
        }
        packet51mapchunkdata.field_74582_a = new byte[i];
        System.arraycopy(abyte0, 0, packet51mapchunkdata.field_74582_a, 0, i);
        return packet51mapchunkdata;
    }

}
