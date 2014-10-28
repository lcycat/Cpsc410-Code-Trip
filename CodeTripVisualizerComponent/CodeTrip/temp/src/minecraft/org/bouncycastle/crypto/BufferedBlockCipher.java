// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package org.bouncycastle.crypto;


// Referenced classes of package org.bouncycastle.crypto:
//            BlockCipher, DataLengthException, CipherParameters

public class BufferedBlockCipher
{

    protected byte field_71801_a[];
    protected int field_71799_b;
    protected boolean field_71800_c;
    protected BlockCipher field_71797_d;
    protected boolean field_71798_e;
    protected boolean field_71796_f;

    protected BufferedBlockCipher()
    {
    }

    public BufferedBlockCipher(BlockCipher p_i4038_1_)
    {
        field_71797_d = p_i4038_1_;
        field_71801_a = new byte[p_i4038_1_.func_71804_b()];
        field_71799_b = 0;
        String s = p_i4038_1_.func_71802_a();
        int i = s.indexOf('/') + 1;
        field_71796_f = i > 0 && s.startsWith("PGP", i);
        if(field_71796_f)
        {
            field_71798_e = true;
        } else
        {
            field_71798_e = i > 0 && (s.startsWith("CFB", i) || s.startsWith("OFB", i) || s.startsWith("OpenPGP", i) || s.startsWith("SIC", i) || s.startsWith("GCTR", i));
        }
    }

    public void init(boolean p_init_1_, CipherParameters p_init_2_)
        throws IllegalArgumentException
    {
        field_71800_c = p_init_1_;
        func_71794_b();
        field_71797_d.func_71805_a(p_init_1_, p_init_2_);
    }

    public int func_71792_a()
    {
        return field_71797_d.func_71804_b();
    }

    public int func_71793_a(int p_71793_1_)
    {
        int i = p_71793_1_ + field_71799_b;
        int j;
        if(field_71796_f)
        {
            j = i % field_71801_a.length - (field_71797_d.func_71804_b() + 2);
        } else
        {
            j = i % field_71801_a.length;
        }
        return i - j;
    }

    public int func_71789_b(int p_71789_1_)
    {
        return p_71789_1_ + field_71799_b;
    }

    public int func_71791_a(byte p_71791_1_[], int p_71791_2_, int p_71791_3_, byte p_71791_4_[], int p_71791_5_)
        throws DataLengthException, IllegalStateException
    {
        if(p_71791_3_ < 0)
        {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        int i = func_71792_a();
        int j = func_71793_a(p_71791_3_);
        if(j > 0 && p_71791_5_ + j > p_71791_4_.length)
        {
            throw new DataLengthException("output buffer too short");
        }
        int k = 0;
        int l = field_71801_a.length - field_71799_b;
        if(p_71791_3_ > l)
        {
            System.arraycopy(p_71791_1_, p_71791_2_, field_71801_a, field_71799_b, l);
            k += field_71797_d.func_71806_a(field_71801_a, 0, p_71791_4_, p_71791_5_);
            field_71799_b = 0;
            p_71791_3_ -= l;
            for(p_71791_2_ += l; p_71791_3_ > field_71801_a.length; p_71791_2_ += i)
            {
                k += field_71797_d.func_71806_a(p_71791_1_, p_71791_2_, p_71791_4_, p_71791_5_ + k);
                p_71791_3_ -= i;
            }

        }
        System.arraycopy(p_71791_1_, p_71791_2_, field_71801_a, field_71799_b, p_71791_3_);
        field_71799_b += p_71791_3_;
        if(field_71799_b == field_71801_a.length)
        {
            k += field_71797_d.func_71806_a(field_71801_a, 0, p_71791_4_, p_71791_5_ + k);
            field_71799_b = 0;
        }
        return k;
    }

    public int func_71790_a(byte p_71790_1_[], int p_71790_2_)
        throws DataLengthException, IllegalStateException
    {
        try
        {
            int i = 0;
            if(p_71790_2_ + field_71799_b > p_71790_1_.length)
            {
                throw new DataLengthException("output buffer too short for doFinal()");
            }
            if(field_71799_b != 0)
            {
                if(!field_71798_e)
                {
                    throw new DataLengthException("data not block size aligned");
                }
                field_71797_d.func_71806_a(field_71801_a, 0, field_71801_a, 0);
                i = field_71799_b;
                field_71799_b = 0;
                System.arraycopy(field_71801_a, 0, p_71790_1_, p_71790_2_, i);
            }
            int j = i;
            return j;
        }
        finally
        {
            func_71794_b();
        }
    }

    public void func_71794_b()
    {
        for(int i = 0; i < field_71801_a.length; i++)
        {
            field_71801_a[i] = 0;
        }

        field_71799_b = 0;
        field_71797_d.func_71803_c();
    }
}
