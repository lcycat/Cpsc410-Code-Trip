// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package argo.jdom;


// Referenced classes of package argo.jdom:
//            JsonNodeBuilder, JsonNodeFactories, JsonStringNode, JsonNode

public final class JsonStringNodeBuilder
    implements JsonNodeBuilder
{

    private final String field_74601_a;

    JsonStringNodeBuilder(String p_i3240_1_)
    {
        field_74601_a = p_i3240_1_;
    }

    public JsonStringNode func_74600_a()
    {
        return JsonNodeFactories.func_74697_a(field_74601_a);
    }

    public JsonNode func_74599_b()
    {
        return func_74600_a();
    }
}
