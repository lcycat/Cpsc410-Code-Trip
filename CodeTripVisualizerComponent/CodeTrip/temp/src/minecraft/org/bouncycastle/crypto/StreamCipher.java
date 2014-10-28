// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package org.bouncycastle.crypto;


// Referenced classes of package org.bouncycastle.crypto:
//            DataLengthException

public interface StreamCipher
{

    public abstract byte func_74851_a(byte byte0);

    public abstract void func_74850_a(byte abyte0[], int i, int j, byte abyte1[], int k)
        throws DataLengthException;
}
