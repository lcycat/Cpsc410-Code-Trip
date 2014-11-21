// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.*;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class CFBBlockCipher
    implements BlockCipher
{

    private byte field_71814_a[];
    private byte field_71812_b[];
    private byte field_71813_c[];
    private int field_71810_d;
    private BlockCipher field_71811_e;
    private boolean field_71809_f;

    public CFBBlockCipher(BlockCipher p_i4044_1_, int p_i4044_2_)
    {
        field_71811_e = null;
        field_71811_e = p_i4044_1_;
        field_71810_d = p_i4044_2_ / 8;
        field_71814_a = new byte[p_i4044_1_.func_71804_b()];
        field_71812_b = new byte[p_i4044_1_.func_71804_b()];
        field_71813_c = new byte[p_i4044_1_.func_71804_b()];
    }

    public void func_71805_a(boolean p_71805_1_, CipherParameters p_71805_2_)
        throws IllegalArgumentException
    {
        field_71809_f = p_71805_1_;
        if(p_71805_2_ instanceof ParametersWithIV)
        {
            ParametersWithIV parameterswithiv = (ParametersWithIV)p_71805_2_;
            byte abyte0[] = parameterswithiv.func_71779_a();
            if(abyte0.length < field_71814_a.length)
            {
                System.arraycopy(abyte0, 0, field_71814_a, field_71814_a.length - abyte0.length, abyte0.length);
                for(int i = 0; i < field_71814_a.length - abyte0.length; i++)
                {
                    field_71814_a[i] = 0;
                }

            } else
            {
                System.arraycopy(abyte0, 0, field_71814_a, 0, field_71814_a.length);
            }
            func_71803_c();
            if(parameterswithiv.func_71780_b() != null)
            {
                field_71811_e.func_71805_a(true, parameterswithiv.func_71780_b());
            }
        } else
        {
            func_71803_c();
            field_71811_e.func_71805_a(true, p_71805_2_);
        }
    }

    public String func_71802_a()
    {
        return (new StringBuilder()).append(field_71811_e.func_71802_a()).append("/CFB").append(field_71810_d * 8).toString();
    }

    public int func_71804_b()
    {
        return field_71810_d;
    }

    public int func_71806_a(byte p_71806_1_[], int p_71806_2_, byte p_71806_3_[], int p_71806_4_)
        throws DataLengthException, IllegalStateException
    {
        return field_71809_f ? func_71807_b(p_71806_1_, p_71806_2_, p_71806_3_, p_71806_4_) : func_71808_c(p_71806_1_, p_71806_2_, p_71806_3_, p_71806_4_);
    }

    public int func_71807_b(byte p_71807_1_[], int p_71807_2_, byte p_71807_3_[], int p_71807_4_)
        throws DataLengthException, IllegalStateException
    {
        if(p_71807_2_ + field_71810_d > p_71807_1_.length)
        {
            throw new DataLengthException("input buffer too short");
        }
        if(p_71807_4_ + field_71810_d > p_71807_3_.length)
        {
            throw new DataLengthException("output buffer too short");
        }
        field_71811_e.func_71806_a(field_71812_b, 0, field_71813_c, 0);
        for(int i = 0; i < field_71810_d; i++)
        {
            p_71807_3_[p_71807_4_ + i] = (byte)(field_71813_c[i] ^ p_71807_1_[p_71807_2_ + i]);
        }

        System.arraycopy(field_71812_b, field_71810_d, field_71812_b, 0, field_71812_b.length - field_71810_d);
        System.arraycopy(p_71807_3_, p_71807_4_, field_71812_b, field_71812_b.length - field_71810_d, field_71810_d);
        return field_71810_d;
    }

    public int func_71808_c(byte p_71808_1_[], int p_71808_2_, byte p_71808_3_[], int p_71808_4_)
        throws DataLengthException, IllegalStateException
    {
        if(p_71808_2_ + field_71810_d > p_71808_1_.length)
        {
            throw new DataLengthException("input buffer too short");
        }
        if(p_71808_4_ + field_71810_d > p_71808_3_.length)
        {
            throw new DataLengthException("output buffer too short");
        }
        field_71811_e.func_71806_a(field_71812_b, 0, field_71813_c, 0);
        System.arraycopy(field_71812_b, field_71810_d, field_71812_b, 0, field_71812_b.length - field_71810_d);
        System.arraycopy(p_71808_1_, p_71808_2_, field_71812_b, field_71812_b.length - field_71810_d, field_71810_d);
        for(int i = 0; i < field_71810_d; i++)
        {
            p_71808_3_[p_71808_4_ + i] = (byte)(field_71813_c[i] ^ p_71808_1_[p_71808_2_ + i]);
        }

        return field_71810_d;
    }

    public void func_71803_c()
    {
        System.arraycopy(field_71814_a, 0, field_71812_b, 0, field_71814_a.length);
        field_71811_e.func_71803_c();
    }
}
