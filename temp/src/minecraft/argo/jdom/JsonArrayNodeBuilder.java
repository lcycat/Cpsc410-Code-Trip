// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package argo.jdom;

import java.util.*;

// Referenced classes of package argo.jdom:
//            JsonNodeBuilder, JsonNodeFactories, JsonRootNode, JsonNode

public final class JsonArrayNodeBuilder
    implements JsonNodeBuilder
{

    private final List field_74605_a = new LinkedList();

    JsonArrayNodeBuilder()
    {
    }

    public JsonArrayNodeBuilder func_74603_a(JsonNodeBuilder p_74603_1_)
    {
        field_74605_a.add(p_74603_1_);
        return this;
    }

    public JsonRootNode func_74604_a()
    {
        LinkedList linkedlist = new LinkedList();
        JsonNodeBuilder jsonnodebuilder;
        for(Iterator iterator = field_74605_a.iterator(); iterator.hasNext(); linkedlist.add(jsonnodebuilder.func_74599_b()))
        {
            jsonnodebuilder = (JsonNodeBuilder)iterator.next();
        }

        return JsonNodeFactories.func_74690_a(linkedlist);
    }

    public JsonNode func_74599_b()
    {
        return func_74604_a();
    }
}
