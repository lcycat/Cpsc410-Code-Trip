// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package org.bouncycastle.crypto;


// Referenced classes of package org.bouncycastle.crypto:
//            DataLengthException, CipherParameters

public interface BlockCipher
{

    public abstract void func_71805_a(boolean flag, CipherParameters cipherparameters)
        throws IllegalArgumentException;

    public abstract String func_71802_a();

    public abstract int func_71804_b();

    public abstract int func_71806_a(byte abyte0[], int i, byte abyte1[], int j)
        throws DataLengthException, IllegalStateException;

    public abstract void func_71803_c();
}
