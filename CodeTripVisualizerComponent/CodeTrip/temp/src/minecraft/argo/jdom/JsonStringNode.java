// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package argo.jdom;

import java.util.List;
import java.util.Map;

// Referenced classes of package argo.jdom:
//            JsonNode, JsonNodeType

public final class JsonStringNode extends JsonNode
    implements Comparable
{

    private final String field_74627_a;

    JsonStringNode(String p_i3239_1_)
    {
        if(p_i3239_1_ == null)
        {
            throw new NullPointerException("Attempt to construct a JsonString with a null value.");
        } else
        {
            field_74627_a = p_i3239_1_;
            return;
        }
    }

    public JsonNodeType func_74616_a()
    {
        return JsonNodeType.STRING;
    }

    public String getText()
    {
        return field_74627_a;
    }

    public Map getFields()
    {
        throw new IllegalStateException("Attempt to get fields on a JsonNode without fields.");
    }

    public List func_74610_b()
    {
        throw new IllegalStateException("Attempt to get elements on a JsonNode without elements.");
    }

    public boolean equals(Object p_equals_1_)
    {
        if(this == p_equals_1_)
        {
            return true;
        }
        if(p_equals_1_ == null || getClass() != p_equals_1_.getClass())
        {
            return false;
        } else
        {
            JsonStringNode jsonstringnode = (JsonStringNode)p_equals_1_;
            return field_74627_a.equals(jsonstringnode.field_74627_a);
        }
    }

    public int hashCode()
    {
        return field_74627_a.hashCode();
    }

    public String toString()
    {
        return (new StringBuilder()).append("JsonStringNode value:[").append(field_74627_a).append("]").toString();
    }

    public int func_74626_a(JsonStringNode p_74626_1_)
    {
        return field_74627_a.compareTo(p_74626_1_.field_74627_a);
    }

    public int compareTo(Object p_compareTo_1_)
    {
        return func_74626_a((JsonStringNode)p_compareTo_1_);
    }
}
