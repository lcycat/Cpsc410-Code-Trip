// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package argo.jdom;

import java.util.List;

// Referenced classes of package argo.jdom:
//            LeafFunctor, JsonNode

final class JsonNodeSelectors_Element extends LeafFunctor
{

    final int field_74636_a; /* synthetic field */

    JsonNodeSelectors_Element(int p_i3233_1_)
    {
        field_74636_a = p_i3233_1_;
        super();
    }

    public boolean func_74634_a(List p_74634_1_)
    {
        return p_74634_1_.size() > field_74636_a;
    }

    public String func_74628_a()
    {
        return Integer.toString(field_74636_a);
    }

    public JsonNode func_74635_b(List p_74635_1_)
    {
        return (JsonNode)p_74635_1_.get(field_74636_a);
    }

    public String toString()
    {
        return (new StringBuilder()).append("an element at index [").append(field_74636_a).append("]").toString();
    }

    public Object func_74633_c(Object p_74633_1_)
    {
        return func_74635_b((List)p_74633_1_);
    }

    public boolean func_74630_a(Object p_74630_1_)
    {
        return func_74634_a((List)p_74630_1_);
    }
}
