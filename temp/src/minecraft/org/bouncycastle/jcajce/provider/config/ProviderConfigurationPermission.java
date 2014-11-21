// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package org.bouncycastle.jcajce.provider.config;

import java.security.BasicPermission;
import java.security.Permission;
import java.util.StringTokenizer;
import org.bouncycastle.util.Strings;

public class ProviderConfigurationPermission extends BasicPermission
{

    private final String field_74843_a;
    private final int field_74842_b;

    public ProviderConfigurationPermission(String p_i4048_1_)
    {
        super(p_i4048_1_);
        field_74843_a = "all";
        field_74842_b = 15;
    }

    public ProviderConfigurationPermission(String p_i4049_1_, String p_i4049_2_)
    {
        super(p_i4049_1_, p_i4049_2_);
        field_74843_a = p_i4049_2_;
        field_74842_b = func_74841_a(p_i4049_2_);
    }

    private int func_74841_a(String p_74841_1_)
    {
        StringTokenizer stringtokenizer = new StringTokenizer(Strings.func_74830_a(p_74841_1_), " ,");
        int i = 0;
        do
        {
            if(!stringtokenizer.hasMoreTokens())
            {
                break;
            }
            String s = stringtokenizer.nextToken();
            if(s.equals("threadlocalecimplicitlyca"))
            {
                i |= 1;
            } else
            if(s.equals("ecimplicitlyca"))
            {
                i |= 2;
            } else
            if(s.equals("threadlocaldhdefaultparams"))
            {
                i |= 4;
            } else
            if(s.equals("dhdefaultparams"))
            {
                i |= 8;
            } else
            if(s.equals("all"))
            {
                i |= 0xf;
            }
        } while(true);
        if(i == 0)
        {
            throw new IllegalArgumentException("unknown permissions passed to mask");
        } else
        {
            return i;
        }
    }

    public String getActions()
    {
        return field_74843_a;
    }

    public boolean implies(Permission p_implies_1_)
    {
        if(!(p_implies_1_ instanceof ProviderConfigurationPermission))
        {
            return false;
        }
        if(!getName().equals(p_implies_1_.getName()))
        {
            return false;
        } else
        {
            ProviderConfigurationPermission providerconfigurationpermission = (ProviderConfigurationPermission)p_implies_1_;
            return (field_74842_b & providerconfigurationpermission.field_74842_b) == providerconfigurationpermission.field_74842_b;
        }
    }

    public boolean equals(Object p_equals_1_)
    {
        if(p_equals_1_ == this)
        {
            return true;
        }
        if(p_equals_1_ instanceof ProviderConfigurationPermission)
        {
            ProviderConfigurationPermission providerconfigurationpermission = (ProviderConfigurationPermission)p_equals_1_;
            return field_74842_b == providerconfigurationpermission.field_74842_b && getName().equals(providerconfigurationpermission.getName());
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return getName().hashCode() + field_74842_b;
    }
}
