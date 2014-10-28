// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package argo.jdom;


// Referenced classes of package argo.jdom:
//            JsonNodeBuilder, JsonStringNode, JsonNode

final class JsonFieldBuilder
{

    private JsonNodeBuilder field_74729_a;
    private JsonNodeBuilder field_74728_b;

    private JsonFieldBuilder()
    {
    }

    static JsonFieldBuilder func_74727_a()
    {
        return new JsonFieldBuilder();
    }

    JsonFieldBuilder func_74726_a(JsonNodeBuilder p_74726_1_)
    {
        field_74729_a = p_74726_1_;
        return this;
    }

    JsonFieldBuilder func_74723_b(JsonNodeBuilder p_74723_1_)
    {
        field_74728_b = p_74723_1_;
        return this;
    }

    JsonStringNode func_74724_b()
    {
        return (JsonStringNode)field_74729_a.func_74599_b();
    }

    JsonNode func_74725_c()
    {
        return field_74728_b.func_74599_b();
    }
}
