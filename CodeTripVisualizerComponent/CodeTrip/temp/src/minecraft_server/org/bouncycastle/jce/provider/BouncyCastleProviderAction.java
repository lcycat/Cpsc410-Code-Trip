// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package org.bouncycastle.jce.provider;

import java.security.PrivilegedAction;

// Referenced classes of package org.bouncycastle.jce.provider:
//            BouncyCastleProvider

class BouncyCastleProviderAction
    implements PrivilegedAction
{

    final BouncyCastleProvider field_74801_a; /* synthetic field */

    BouncyCastleProviderAction(BouncyCastleProvider p_i4050_1_)
    {
        field_74801_a = p_i4050_1_;
        super();
    }

    public Object run()
    {
        BouncyCastleProvider.func_74821_a(field_74801_a);
        return null;
    }
}
