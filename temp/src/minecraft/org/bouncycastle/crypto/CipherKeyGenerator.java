// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package org.bouncycastle.crypto;

import java.security.SecureRandom;

// Referenced classes of package org.bouncycastle.crypto:
//            KeyGenerationParameters

public class CipherKeyGenerator
{

    protected SecureRandom field_71788_a;
    protected int field_71787_b;

    public CipherKeyGenerator()
    {
    }

    public void init(KeyGenerationParameters p_init_1_)
    {
        field_71788_a = p_init_1_.func_71843_a();
        field_71787_b = (p_init_1_.func_71842_b() + 7) / 8;
    }

    public byte[] generateKey()
    {
        byte abyte0[] = new byte[field_71787_b];
        field_71788_a.nextBytes(abyte0);
        return abyte0;
    }
}
