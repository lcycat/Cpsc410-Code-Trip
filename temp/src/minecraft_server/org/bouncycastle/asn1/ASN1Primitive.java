// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package org.bouncycastle.asn1;


// Referenced classes of package org.bouncycastle.asn1:
//            ASN1Object, ASN1Encodable

public abstract class ASN1Primitive extends ASN1Object
{

    ASN1Primitive()
    {
    }

    public final boolean equals(Object p_equals_1_)
    {
        if(this == p_equals_1_)
        {
            return true;
        } else
        {
            return (p_equals_1_ instanceof ASN1Encodable) && func_71607_a(((ASN1Encodable)p_equals_1_).func_71606_a());
        }
    }

    public ASN1Primitive func_71606_a()
    {
        return this;
    }

    public abstract int hashCode();

    abstract boolean func_71607_a(ASN1Primitive asn1primitive);
}
