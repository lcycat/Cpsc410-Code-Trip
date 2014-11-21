// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package argo.jdom;


// Referenced classes of package argo.jdom:
//            LeafFunctor, JsonNodeType, JsonNode

final class JsonNodeSelectors_String extends LeafFunctor
{

    JsonNodeSelectors_String()
    {
    }

    public boolean func_74645_a(JsonNode p_74645_1_)
    {
        return JsonNodeType.STRING == p_74645_1_.func_74616_a();
    }

    public String func_74628_a()
    {
        return "A short form string";
    }

    public String func_74644_b(JsonNode p_74644_1_)
    {
        return p_74644_1_.getText();
    }

    public String toString()
    {
        return "a value that is a string";
    }

    public Object func_74633_c(Object p_74633_1_)
    {
        return func_74644_b((JsonNode)p_74633_1_);
    }

    public boolean func_74630_a(Object p_74630_1_)
    {
        return func_74645_a((JsonNode)p_74630_1_);
    }
}
