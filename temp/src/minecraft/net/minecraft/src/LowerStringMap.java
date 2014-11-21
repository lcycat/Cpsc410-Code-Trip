// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

public class LowerStringMap
    implements Map
{

    private final Map field_76117_a = new LinkedHashMap();

    public LowerStringMap()
    {
    }

    public int size()
    {
        return field_76117_a.size();
    }

    public boolean isEmpty()
    {
        return field_76117_a.isEmpty();
    }

    public boolean containsKey(Object p_containsKey_1_)
    {
        return field_76117_a.containsKey(p_containsKey_1_.toString().toLowerCase());
    }

    public boolean containsValue(Object p_containsValue_1_)
    {
        return field_76117_a.containsKey(p_containsValue_1_);
    }

    public Object get(Object p_get_1_)
    {
        return field_76117_a.get(p_get_1_.toString().toLowerCase());
    }

    public Object func_76116_a(String p_76116_1_, Object p_76116_2_)
    {
        return field_76117_a.put(p_76116_1_.toLowerCase(), p_76116_2_);
    }

    public Object remove(Object p_remove_1_)
    {
        return field_76117_a.remove(p_remove_1_.toString().toLowerCase());
    }

    public void putAll(Map p_putAll_1_)
    {
        java.util.Map.Entry entry;
        for(Iterator iterator = p_putAll_1_.entrySet().iterator(); iterator.hasNext(); func_76116_a((String)entry.getKey(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

    }

    public void clear()
    {
        field_76117_a.clear();
    }

    public Set keySet()
    {
        return field_76117_a.keySet();
    }

    public Collection values()
    {
        return field_76117_a.values();
    }

    public Set entrySet()
    {
        return field_76117_a.entrySet();
    }

    public Object put(Object p_put_1_, Object p_put_2_)
    {
        return func_76116_a((String)p_put_1_, p_put_2_);
    }
}
