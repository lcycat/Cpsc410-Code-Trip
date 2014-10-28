// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package argo.jdom;

import java.util.List;
import java.util.Map;

// Referenced classes of package argo.jdom:
//            JsonNode, JsonNodeType

final class JsonConstants extends JsonNode
{

    static final JsonConstants field_74625_a;
    static final JsonConstants field_74623_b;
    static final JsonConstants field_74624_c;
    private final JsonNodeType field_74622_d;

    private JsonConstants(JsonNodeType p_i3224_1_)
    {
        field_74622_d = p_i3224_1_;
    }

    public JsonNodeType func_74616_a()
    {
        return field_74622_d;
    }

    public String getText()
    {
        throw new IllegalStateException("Attempt to get text on a JsonNode without text.");
    }

    public Map getFields()
    {
        throw new IllegalStateException("Attempt to get fields on a JsonNode without fields.");
    }

    public List func_74610_b()
    {
        throw new IllegalStateException("Attempt to get elements on a JsonNode without elements.");
    }

    static 
    {
        field_74625_a = new JsonConstants(JsonNodeType.NULL);
        field_74623_b = new JsonConstants(JsonNodeType.TRUE);
        field_74624_c = new JsonConstants(JsonNodeType.FALSE);
    }
}
