// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package argo.jdom;


// Referenced classes of package argo.jdom:
//            JsonNodeBuilders_Null, JsonNodeBuilders_True, JsonNodeBuilders_False, JsonNumberNodeBuilder, 
//            JsonStringNodeBuilder, JsonObjectNodeBuilder, JsonArrayNodeBuilder, JsonNodeBuilder

public final class JsonNodeBuilders
{

    public static JsonNodeBuilder func_74714_a()
    {
        return new JsonNodeBuilders_Null();
    }

    public static JsonNodeBuilder func_74713_b()
    {
        return new JsonNodeBuilders_True();
    }

    public static JsonNodeBuilder func_74709_c()
    {
        return new JsonNodeBuilders_False();
    }

    public static JsonNodeBuilder func_74712_a(String p_74712_0_)
    {
        return new JsonNumberNodeBuilder(p_74712_0_);
    }

    public static JsonStringNodeBuilder func_74710_b(String p_74710_0_)
    {
        return new JsonStringNodeBuilder(p_74710_0_);
    }

    public static JsonObjectNodeBuilder func_74711_d()
    {
        return new JsonObjectNodeBuilder();
    }

    public static JsonArrayNodeBuilder func_74708_e()
    {
        return new JsonArrayNodeBuilder();
    }
}
