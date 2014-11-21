// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package org.bouncycastle.crypto;

import java.security.SecureRandom;

public class KeyGenerationParameters
{

    private SecureRandom field_71845_a;
    private int field_71844_b;

    public KeyGenerationParameters(SecureRandom p_i4040_1_, int p_i4040_2_)
    {
        field_71845_a = p_i4040_1_;
        field_71844_b = p_i4040_2_;
    }

    public SecureRandom func_71843_a()
    {
        return field_71845_a;
    }

    public int func_71842_b()
    {
        return field_71844_b;
    }
}
