// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package org.bouncycastle.crypto.io;

import java.io.*;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.StreamCipher;

public class CipherInputStream extends FilterInputStream
{

    private BufferedBlockCipher field_74859_a;
    private StreamCipher field_74857_b;
    private byte field_74858_c[];
    private byte field_74855_d[];
    private int field_74856_e;
    private int field_74853_f;
    private boolean field_74854_g;

    public CipherInputStream(InputStream p_i4042_1_, BufferedBlockCipher p_i4042_2_)
    {
        super(p_i4042_1_);
        field_74859_a = p_i4042_2_;
        field_74858_c = new byte[p_i4042_2_.func_71789_b(2048)];
        field_74855_d = new byte[2048];
    }

    private int func_74852_a()
        throws IOException
    {
        int i = super.available();
        if(i <= 0)
        {
            i = 1;
        }
        if(i > field_74855_d.length)
        {
            i = super.read(field_74855_d, 0, field_74855_d.length);
        } else
        {
            i = super.read(field_74855_d, 0, i);
        }
        if(i < 0)
        {
            if(field_74854_g)
            {
                return -1;
            }
            try
            {
                if(field_74859_a != null)
                {
                    field_74853_f = field_74859_a.func_71790_a(field_74858_c, 0);
                } else
                {
                    field_74853_f = 0;
                }
            }
            catch(Exception exception)
            {
                throw new IOException((new StringBuilder()).append("error processing stream: ").append(exception.toString()).toString());
            }
            field_74856_e = 0;
            field_74854_g = true;
            if(field_74856_e == field_74853_f)
            {
                return -1;
            }
        } else
        {
            field_74856_e = 0;
            try
            {
                if(field_74859_a != null)
                {
                    field_74853_f = field_74859_a.func_71791_a(field_74855_d, 0, i, field_74858_c, 0);
                } else
                {
                    field_74857_b.func_74850_a(field_74855_d, 0, i, field_74858_c, 0);
                    field_74853_f = i;
                }
            }
            catch(Exception exception1)
            {
                throw new IOException((new StringBuilder()).append("error processing stream: ").append(exception1.toString()).toString());
            }
            if(field_74853_f == 0)
            {
                return func_74852_a();
            }
        }
        return field_74853_f;
    }

    public int read()
        throws IOException
    {
        if(field_74856_e == field_74853_f && func_74852_a() < 0)
        {
            return -1;
        } else
        {
            return field_74858_c[field_74856_e++] & 0xff;
        }
    }

    public int read(byte p_read_1_[])
        throws IOException
    {
        return read(p_read_1_, 0, p_read_1_.length);
    }

    public int read(byte p_read_1_[], int p_read_2_, int p_read_3_)
        throws IOException
    {
        if(field_74856_e == field_74853_f && func_74852_a() < 0)
        {
            return -1;
        }
        int i = field_74853_f - field_74856_e;
        if(p_read_3_ > i)
        {
            System.arraycopy(field_74858_c, field_74856_e, p_read_1_, p_read_2_, i);
            field_74856_e = field_74853_f;
            return i;
        } else
        {
            System.arraycopy(field_74858_c, field_74856_e, p_read_1_, p_read_2_, p_read_3_);
            field_74856_e += p_read_3_;
            return p_read_3_;
        }
    }

    public long skip(long p_skip_1_)
        throws IOException
    {
        if(p_skip_1_ <= 0L)
        {
            return 0L;
        }
        int i = field_74853_f - field_74856_e;
        if(p_skip_1_ > (long)i)
        {
            field_74856_e = field_74853_f;
            return (long)i;
        } else
        {
            field_74856_e += (int)p_skip_1_;
            return (long)(int)p_skip_1_;
        }
    }

    public int available()
        throws IOException
    {
        return field_74853_f - field_74856_e;
    }

    public void close()
        throws IOException
    {
        super.close();
    }

    public boolean markSupported()
    {
        return false;
    }
}
