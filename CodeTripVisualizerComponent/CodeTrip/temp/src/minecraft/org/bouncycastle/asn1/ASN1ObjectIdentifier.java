// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package org.bouncycastle.asn1;


// Referenced classes of package org.bouncycastle.asn1:
//            DERObjectIdentifier

public class ASN1ObjectIdentifier extends DERObjectIdentifier
{

    public ASN1ObjectIdentifier(String p_i4036_1_)
    {
        super(p_i4036_1_);
    }

    public ASN1ObjectIdentifier func_71612_a(String p_71612_1_)
    {
        return new ASN1ObjectIdentifier((new StringBuilder()).append(func_71609_b()).append(".").append(p_71612_1_).toString());
    }
}
