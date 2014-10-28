// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package org.bouncycastle.asn1;


// Referenced classes of package org.bouncycastle.asn1:
//            ASN1Encodable, ASN1Primitive

public abstract class ASN1Object
    implements ASN1Encodable
{

    public ASN1Object()
    {
    }

    public int hashCode()
    {
        return func_71606_a().hashCode();
    }

    public boolean equals(Object p_equals_1_)
    {
        if(this == p_equals_1_)
        {
            return true;
        }
        if(!(p_equals_1_ instanceof ASN1Encodable))
        {
            return false;
        } else
        {
            ASN1Encodable asn1encodable = (ASN1Encodable)p_equals_1_;
            return func_71606_a().equals(asn1encodable.func_71606_a());
        }
    }

    public abstract ASN1Primitive func_71606_a();
}
