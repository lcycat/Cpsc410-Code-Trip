// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package argo.jdom;

import java.util.Map;

// Referenced classes of package argo.jdom:
//            LeafFunctor, JsonStringNode, JsonNode

final class JsonNodeSelectors_Field extends LeafFunctor
{

    final JsonStringNode field_74643_a; /* synthetic field */

    JsonNodeSelectors_Field(JsonStringNode p_i3232_1_)
    {
        field_74643_a = p_i3232_1_;
        super();
    }

    public boolean func_74641_a(Map p_74641_1_)
    {
        return p_74641_1_.containsKey(field_74643_a);
    }

    public String func_74628_a()
    {
        return (new StringBuilder()).append("\"").append(field_74643_a.getText()).append("\"").toString();
    }

    public JsonNode func_74642_b(Map p_74642_1_)
    {
        return (JsonNode)p_74642_1_.get(field_74643_a);
    }

    public String toString()
    {
        return (new StringBuilder()).append("a field called [\"").append(field_74643_a.getText()).append("\"]").toString();
    }

    public Object func_74633_c(Object p_74633_1_)
    {
        return func_74642_b((Map)p_74633_1_);
    }

    public boolean func_74630_a(Object p_74630_1_)
    {
        return func_74641_a((Map)p_74630_1_);
    }
}
