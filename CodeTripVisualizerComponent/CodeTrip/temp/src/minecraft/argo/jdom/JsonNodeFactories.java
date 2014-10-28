// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package argo.jdom;

import java.util.Arrays;
import java.util.Map;

// Referenced classes of package argo.jdom:
//            JsonConstants, JsonStringNode, JsonNumberNode, JsonArray, 
//            JsonObject, JsonNode, JsonRootNode

public final class JsonNodeFactories
{

    public static JsonNode func_74696_a()
    {
        return JsonConstants.field_74625_a;
    }

    public static JsonNode func_74693_b()
    {
        return JsonConstants.field_74623_b;
    }

    public static JsonNode func_74694_c()
    {
        return JsonConstants.field_74624_c;
    }

    public static JsonStringNode func_74697_a(String p_74697_0_)
    {
        return new JsonStringNode(p_74697_0_);
    }

    public static JsonNode func_74691_b(String p_74691_0_)
    {
        return new JsonNumberNode(p_74691_0_);
    }

    public static JsonRootNode func_74690_a(Iterable p_74690_0_)
    {
        return new JsonArray(p_74690_0_);
    }

    public static JsonRootNode func_74695_a(JsonNode p_74695_0_[])
    {
        return func_74690_a(Arrays.asList(p_74695_0_));
    }

    public static JsonRootNode func_74692_a(Map p_74692_0_)
    {
        return new JsonObject(p_74692_0_);
    }
}
