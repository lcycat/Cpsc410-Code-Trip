// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, World, Chunk, NetHandler

public class Packet52MultiBlockChange extends Packet
{

    public int field_73452_a;
    public int field_73450_b;
    public byte field_73451_c[];
    public int field_73448_d;
    private static byte field_73449_e[] = new byte[0];

    public Packet52MultiBlockChange()
    {
        field_73287_r = true;
    }

    public Packet52MultiBlockChange(int p_i3302_1_, int p_i3302_2_, short p_i3302_3_[], int p_i3302_4_, World p_i3302_5_)
    {
        field_73287_r = true;
        field_73452_a = p_i3302_1_;
        field_73450_b = p_i3302_2_;
        field_73448_d = p_i3302_4_;
        int i = 4 * p_i3302_4_;
        Chunk chunk = p_i3302_5_.func_72964_e(p_i3302_1_, p_i3302_2_);
        try
        {
            if(p_i3302_4_ >= 64)
            {
                System.out.println((new StringBuilder()).append("ChunkTilesUpdatePacket compress ").append(p_i3302_4_).toString());
                if(field_73449_e.length < i)
                {
                    field_73449_e = new byte[i];
                }
            } else
            {
                ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream(i);
                DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);
                for(int j = 0; j < p_i3302_4_; j++)
                {
                    int k = p_i3302_3_[j] >> 12 & 0xf;
                    int l = p_i3302_3_[j] >> 8 & 0xf;
                    int i1 = p_i3302_3_[j] & 0xff;
                    dataoutputstream.writeShort(p_i3302_3_[j]);
                    dataoutputstream.writeShort((short)((chunk.func_76610_a(k, i1, l) & 0xfff) << 4 | chunk.func_76628_c(k, i1, l) & 0xf));
                }

                field_73451_c = bytearrayoutputstream.toByteArray();
                if(field_73451_c.length != i)
                {
                    throw new RuntimeException((new StringBuilder()).append("Expected length ").append(i).append(" doesn't match received length ").append(field_73451_c.length).toString());
                }
            }
        }
        catch(IOException ioexception)
        {
            System.err.println(ioexception.getMessage());
            field_73451_c = null;
        }
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73452_a = p_73267_1_.readInt();
        field_73450_b = p_73267_1_.readInt();
        field_73448_d = p_73267_1_.readShort() & 0xffff;
        int i = p_73267_1_.readInt();
        if(i > 0)
        {
            field_73451_c = new byte[i];
            p_73267_1_.readFully(field_73451_c);
        }
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeInt(field_73452_a);
        p_73273_1_.writeInt(field_73450_b);
        p_73273_1_.writeShort((short)field_73448_d);
        if(field_73451_c != null)
        {
            p_73273_1_.writeInt(field_73451_c.length);
            p_73273_1_.write(field_73451_c);
        } else
        {
            p_73273_1_.writeInt(0);
        }
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72496_a(this);
    }

    public int func_73284_a()
    {
        return 10 + field_73448_d * 4;
    }

}
