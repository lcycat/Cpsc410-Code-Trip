// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;

public class ParametersWithIV
    implements CipherParameters
{

    private byte field_71782_a[];
    private CipherParameters field_71781_b;

    public ParametersWithIV(CipherParameters p_i4047_1_, byte p_i4047_2_[], int p_i4047_3_, int p_i4047_4_)
    {
        field_71782_a = new byte[p_i4047_4_];
        field_71781_b = p_i4047_1_;
        System.arraycopy(p_i4047_2_, p_i4047_3_, field_71782_a, 0, p_i4047_4_);
    }

    public byte[] func_71779_a()
    {
        return field_71782_a;
    }

    public CipherParameters func_71780_b()
    {
        return field_71781_b;
    }
}
