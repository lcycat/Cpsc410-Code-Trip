// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.List;
import java.util.zip.*;

// Referenced classes of package net.minecraft.src:
//            Packet, Chunk, Packet51MapChunk, Packet51MapChunkData, 
//            NetHandler

public class Packet56MapChunks extends Packet
{

    private int field_73589_c[];
    private int field_73586_d[];
    public int field_73590_a[];
    public int field_73588_b[];
    private byte field_73587_e[];
    private byte field_73584_f[][];
    private int field_73585_g;
    private static byte field_73591_h[] = new byte[0];

    public Packet56MapChunks()
    {
    }

    public Packet56MapChunks(List p_i3324_1_)
    {
        int i = p_i3324_1_.size();
        field_73589_c = new int[i];
        field_73586_d = new int[i];
        field_73590_a = new int[i];
        field_73588_b = new int[i];
        field_73584_f = new byte[i][];
        int j = 0;
        for(int k = 0; k < i; k++)
        {
            Chunk chunk = (Chunk)p_i3324_1_.get(k);
            Packet51MapChunkData packet51mapchunkdata = Packet51MapChunk.func_73594_a(chunk, true, 65535);
            if(field_73591_h.length < j + packet51mapchunkdata.field_74582_a.length)
            {
                byte abyte0[] = new byte[j + packet51mapchunkdata.field_74582_a.length];
                System.arraycopy(field_73591_h, 0, abyte0, 0, field_73591_h.length);
                field_73591_h = abyte0;
            }
            System.arraycopy(packet51mapchunkdata.field_74582_a, 0, field_73591_h, j, packet51mapchunkdata.field_74582_a.length);
            j += packet51mapchunkdata.field_74582_a.length;
            field_73589_c[k] = chunk.field_76635_g;
            field_73586_d[k] = chunk.field_76647_h;
            field_73590_a[k] = packet51mapchunkdata.field_74580_b;
            field_73588_b[k] = packet51mapchunkdata.field_74581_c;
            field_73584_f[k] = packet51mapchunkdata.field_74582_a;
        }

        Deflater deflater = new Deflater(-1);
        try
        {
            deflater.setInput(field_73591_h, 0, j);
            deflater.finish();
            field_73587_e = new byte[j];
            field_73585_g = deflater.deflate(field_73587_e);
        }
        finally
        {
            deflater.end();
        }
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        short word0 = p_73267_1_.readShort();
        field_73585_g = p_73267_1_.readInt();
        field_73589_c = new int[word0];
        field_73586_d = new int[word0];
        field_73590_a = new int[word0];
        field_73588_b = new int[word0];
        field_73584_f = new byte[word0][];
        if(field_73591_h.length < field_73585_g)
        {
            field_73591_h = new byte[field_73585_g];
        }
        p_73267_1_.readFully(field_73591_h, 0, field_73585_g);
        byte abyte0[] = new byte[0x30100 * word0];
        Inflater inflater = new Inflater();
        inflater.setInput(field_73591_h, 0, field_73585_g);
        try
        {
            inflater.inflate(abyte0);
        }
        catch(DataFormatException dataformatexception)
        {
            throw new IOException("Bad compressed data format");
        }
        finally
        {
            inflater.end();
        }
        int i = 0;
        for(int j = 0; j < word0; j++)
        {
            field_73589_c[j] = p_73267_1_.readInt();
            field_73586_d[j] = p_73267_1_.readInt();
            field_73590_a[j] = p_73267_1_.readShort();
            field_73588_b[j] = p_73267_1_.readShort();
            int k = 0;
            for(int l = 0; l < 16; l++)
            {
                k += field_73590_a[j] >> l & 1;
            }

            int i1 = 2048 * (5 * k) + 256;
            field_73584_f[j] = new byte[i1];
            System.arraycopy(abyte0, i, field_73584_f[j], 0, i1);
            i += i1;
        }

    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeShort(field_73589_c.length);
        p_73273_1_.writeInt(field_73585_g);
        p_73273_1_.write(field_73587_e, 0, field_73585_g);
        for(int i = 0; i < field_73589_c.length; i++)
        {
            p_73273_1_.writeInt(field_73589_c[i]);
            p_73273_1_.writeInt(field_73586_d[i]);
            p_73273_1_.writeShort((short)(field_73590_a[i] & 0xffff));
            p_73273_1_.writeShort((short)(field_73588_b[i] & 0xffff));
        }

    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72453_a(this);
    }

    public int func_73284_a()
    {
        return 6 + field_73585_g + 12 * func_73581_d();
    }

    public int func_73581_d()
    {
        return field_73589_c.length;
    }

    public boolean func_73277_a_()
    {
        return true;
    }

}
