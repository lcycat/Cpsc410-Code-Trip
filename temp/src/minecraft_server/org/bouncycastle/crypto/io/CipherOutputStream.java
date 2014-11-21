// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package org.bouncycastle.crypto.io;

import java.io.*;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.StreamCipher;

public class CipherOutputStream extends FilterOutputStream
{

    private BufferedBlockCipher field_74849_a;
    private StreamCipher field_74847_b;
    private byte field_74848_c[];
    private byte field_74846_d[];

    public CipherOutputStream(OutputStream p_i4043_1_, BufferedBlockCipher p_i4043_2_)
    {
        super(p_i4043_1_);
        field_74848_c = new byte[1];
        field_74849_a = p_i4043_2_;
        field_74846_d = new byte[p_i4043_2_.func_71792_a()];
    }

    public void write(int p_write_1_)
        throws IOException
    {
        field_74848_c[0] = (byte)p_write_1_;
        if(field_74849_a != null)
        {
            int i = field_74849_a.func_71791_a(field_74848_c, 0, 1, field_74846_d, 0);
            if(i != 0)
            {
                out.write(field_74846_d, 0, i);
            }
        } else
        {
            out.write(field_74847_b.func_74851_a((byte)p_write_1_));
        }
    }

    public void write(byte p_write_1_[])
        throws IOException
    {
        write(p_write_1_, 0, p_write_1_.length);
    }

    public void write(byte p_write_1_[], int p_write_2_, int p_write_3_)
        throws IOException
    {
        if(field_74849_a != null)
        {
            byte abyte0[] = new byte[field_74849_a.func_71789_b(p_write_3_)];
            int i = field_74849_a.func_71791_a(p_write_1_, p_write_2_, p_write_3_, abyte0, 0);
            if(i != 0)
            {
                out.write(abyte0, 0, i);
            }
        } else
        {
            byte abyte1[] = new byte[p_write_3_];
            field_74847_b.func_74850_a(p_write_1_, p_write_2_, p_write_3_, abyte1, 0);
            out.write(abyte1, 0, p_write_3_);
        }
    }

    public void flush()
        throws IOException
    {
        super.flush();
    }

    public void close()
        throws IOException
    {
        try
        {
            if(field_74849_a != null)
            {
                byte abyte0[] = new byte[field_74849_a.func_71789_b(0)];
                int i = field_74849_a.func_71790_a(abyte0, 0);
                if(i != 0)
                {
                    out.write(abyte0, 0, i);
                }
            }
        }
        catch(Exception exception)
        {
            throw new IOException((new StringBuilder()).append("Error closing stream: ").append(exception.toString()).toString());
        }
        flush();
        super.close();
    }
}
