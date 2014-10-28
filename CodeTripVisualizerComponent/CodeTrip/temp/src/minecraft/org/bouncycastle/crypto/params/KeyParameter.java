// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;

public class KeyParameter
    implements CipherParameters
{

    private byte field_71784_a[];

    public KeyParameter(byte p_i4045_1_[])
    {
        this(p_i4045_1_, 0, p_i4045_1_.length);
    }

    public KeyParameter(byte p_i4046_1_[], int p_i4046_2_, int p_i4046_3_)
    {
        field_71784_a = new byte[p_i4046_3_];
        System.arraycopy(p_i4046_1_, p_i4046_2_, field_71784_a, 0, p_i4046_3_);
    }

    public byte[] func_71783_a()
    {
        return field_71784_a;
    }
}
