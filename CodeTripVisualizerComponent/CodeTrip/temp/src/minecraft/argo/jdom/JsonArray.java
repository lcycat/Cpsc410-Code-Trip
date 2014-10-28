// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package argo.jdom;

import java.util.*;

// Referenced classes of package argo.jdom:
//            JsonRootNode, JsonNodeType, JsonArray_NodeList

final class JsonArray extends JsonRootNode
{

    private final List field_74619_a;

    JsonArray(Iterable p_i3223_1_)
    {
        field_74619_a = func_74618_a(p_i3223_1_);
    }

    public JsonNodeType func_74616_a()
    {
        return JsonNodeType.ARRAY;
    }

    public List func_74610_b()
    {
        return new ArrayList(field_74619_a);
    }

    public String getText()
    {
        throw new IllegalStateException("Attempt to get text on a JsonNode without text.");
    }

    public Map getFields()
    {
        throw new IllegalStateException("Attempt to get fields on a JsonNode without fields.");
    }

    public boolean equals(Object p_equals_1_)
    {
        if(this == p_equals_1_)
        {
            return true;
        }
        if(p_equals_1_ == null || getClass() != p_equals_1_.getClass())
        {
            return false;
        } else
        {
            JsonArray jsonarray = (JsonArray)p_equals_1_;
            return field_74619_a.equals(jsonarray.field_74619_a);
        }
    }

    public int hashCode()
    {
        return field_74619_a.hashCode();
    }

    public String toString()
    {
        return (new StringBuilder()).append("JsonArray elements:[").append(field_74619_a).append("]").toString();
    }

    private static List func_74618_a(Iterable p_74618_0_)
    {
        return new JsonArray_NodeList(p_74618_0_);
    }
}
