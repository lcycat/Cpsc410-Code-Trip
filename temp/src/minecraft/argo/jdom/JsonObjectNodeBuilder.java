// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package argo.jdom;

import java.util.LinkedList;
import java.util.List;

// Referenced classes of package argo.jdom:
//            JsonNodeBuilder, JsonObjectNodeBuilder_List, JsonNodeFactories, JsonFieldBuilder, 
//            JsonRootNode, JsonNode

public final class JsonObjectNodeBuilder
    implements JsonNodeBuilder
{

    private final List field_74609_a = new LinkedList();

    JsonObjectNodeBuilder()
    {
    }

    public JsonObjectNodeBuilder func_74608_a(JsonFieldBuilder p_74608_1_)
    {
        field_74609_a.add(p_74608_1_);
        return this;
    }

    public JsonRootNode func_74606_a()
    {
        return JsonNodeFactories.func_74692_a(new JsonObjectNodeBuilder_List(this));
    }

    public JsonNode func_74599_b()
    {
        return func_74606_a();
    }

    static List func_74607_a(JsonObjectNodeBuilder p_74607_0_)
    {
        return p_74607_0_.field_74609_a;
    }
}
