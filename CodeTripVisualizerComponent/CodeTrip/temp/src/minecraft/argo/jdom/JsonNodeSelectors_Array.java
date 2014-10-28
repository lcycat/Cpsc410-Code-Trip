// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package argo.jdom;

import java.util.List;

// Referenced classes of package argo.jdom:
//            LeafFunctor, JsonNodeType, JsonNode

final class JsonNodeSelectors_Array extends LeafFunctor
{

    JsonNodeSelectors_Array()
    {
    }

    public boolean func_74638_a(JsonNode p_74638_1_)
    {
        return JsonNodeType.ARRAY == p_74638_1_.func_74616_a();
    }

    public String func_74628_a()
    {
        return "A short form array";
    }

    public List func_74637_b(JsonNode p_74637_1_)
    {
        return p_74637_1_.func_74610_b();
    }

    public String toString()
    {
        return "an array";
    }

    public Object func_74633_c(Object p_74633_1_)
    {
        return func_74637_b((JsonNode)p_74633_1_);
    }

    public boolean func_74630_a(Object p_74630_1_)
    {
        return func_74638_a((JsonNode)p_74630_1_);
    }
}
