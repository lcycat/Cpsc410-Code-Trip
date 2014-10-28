// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package argo.jdom;

import java.util.Map;

// Referenced classes of package argo.jdom:
//            LeafFunctor, JsonNodeType, JsonNode

final class JsonNodeSelectors_Object extends LeafFunctor
{

    JsonNodeSelectors_Object()
    {
    }

    public boolean func_74640_a(JsonNode p_74640_1_)
    {
        return JsonNodeType.OBJECT == p_74640_1_.func_74616_a();
    }

    public String func_74628_a()
    {
        return "A short form object";
    }

    public Map func_74639_b(JsonNode p_74639_1_)
    {
        return p_74639_1_.getFields();
    }

    public String toString()
    {
        return "an object";
    }

    public Object func_74633_c(Object p_74633_1_)
    {
        return func_74639_b((JsonNode)p_74633_1_);
    }

    public boolean func_74630_a(Object p_74630_1_)
    {
        return func_74640_a((JsonNode)p_74630_1_);
    }
}
