// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package org.bouncycastle.jce.provider;

import java.security.Permission;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jcajce.provider.config.ProviderConfigurationPermission;

// Referenced classes of package org.bouncycastle.jce.provider:
//            BouncyCastleProvider

class BouncyCastleProviderConfiguration
    implements ProviderConfiguration
{

    private static Permission field_74836_a;
    private static Permission field_74834_b;
    private static Permission field_74835_c;
    private static Permission field_74832_d;
    private ThreadLocal field_74833_e;
    private ThreadLocal field_74831_f;

    BouncyCastleProviderConfiguration()
    {
        field_74833_e = new ThreadLocal();
        field_74831_f = new ThreadLocal();
    }

    static 
    {
        field_74836_a = new ProviderConfigurationPermission(BouncyCastleProvider.field_74828_a, "threadLocalEcImplicitlyCa");
        field_74834_b = new ProviderConfigurationPermission(BouncyCastleProvider.field_74828_a, "ecImplicitlyCa");
        field_74835_c = new ProviderConfigurationPermission(BouncyCastleProvider.field_74828_a, "threadLocalDhDefaultParams");
        field_74832_d = new ProviderConfigurationPermission(BouncyCastleProvider.field_74828_a, "DhDefaultParams");
    }
}
