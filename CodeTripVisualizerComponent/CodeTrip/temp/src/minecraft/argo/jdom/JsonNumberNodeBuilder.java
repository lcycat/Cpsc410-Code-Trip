// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package argo.jdom;


// Referenced classes of package argo.jdom:
//            JsonNodeBuilder, JsonNodeFactories, JsonNode

final class JsonNumberNodeBuilder
    implements JsonNodeBuilder
{

    private final JsonNode field_74602_a;

    JsonNumberNodeBuilder(String p_i3236_1_)
    {
        field_74602_a = JsonNodeFactories.func_74691_b(p_i3236_1_);
    }

    public JsonNode func_74599_b()
    {
        return field_74602_a;
    }
}
