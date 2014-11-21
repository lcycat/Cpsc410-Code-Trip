// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package org.bouncycastle.asn1;


// Referenced classes of package org.bouncycastle.asn1:
//            ASN1Primitive, ASN1ObjectIdentifier

public class DERObjectIdentifier extends ASN1Primitive
{

    String field_71611_a;
    private static ASN1ObjectIdentifier field_71610_b[][] = new ASN1ObjectIdentifier[255][];

    public DERObjectIdentifier(String p_i4037_1_)
    {
        if(!func_71608_a(p_i4037_1_))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("string ").append(p_i4037_1_).append(" not an OID").toString());
        } else
        {
            field_71611_a = p_i4037_1_;
            return;
        }
    }

    public String func_71609_b()
    {
        return field_71611_a;
    }

    public int hashCode()
    {
        return field_71611_a.hashCode();
    }

    boolean func_71607_a(ASN1Primitive p_71607_1_)
    {
        if(!(p_71607_1_ instanceof DERObjectIdentifier))
        {
            return false;
        } else
        {
            return field_71611_a.equals(((DERObjectIdentifier)p_71607_1_).field_71611_a);
        }
    }

    public String toString()
    {
        return func_71609_b();
    }

    private static boolean func_71608_a(String p_71608_0_)
    {
        if(p_71608_0_.length() < 3 || p_71608_0_.charAt(1) != '.')
        {
            return false;
        }
        char c = p_71608_0_.charAt(0);
        if(c < '0' || c > '2')
        {
            return false;
        }
        boolean flag = false;
        for(int i = p_71608_0_.length() - 1; i >= 2; i--)
        {
            char c1 = p_71608_0_.charAt(i);
            if('0' <= c1 && c1 <= '9')
            {
                flag = true;
                continue;
            }
            if(c1 == '.')
            {
                if(!flag)
                {
                    return false;
                }
                flag = false;
            } else
            {
                return false;
            }
        }

        return flag;
    }

}
