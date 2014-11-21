// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package argo.jdom;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package argo.jdom:
//            JsonNode, JsonNodeType

final class JsonNumberNode extends JsonNode
{

    private static final Pattern field_74621_a = Pattern.compile("(-?)(0|([1-9]([0-9]*)))(\\.[0-9]+)?((e|E)(\\+|-)?[0-9]+)?");
    private final String field_74620_b;

    JsonNumberNode(String p_i3235_1_)
    {
        if(p_i3235_1_ == null)
        {
            throw new NullPointerException("Attempt to construct a JsonNumber with a null value.");
        }
        if(!field_74621_a.matcher(p_i3235_1_).matches())
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Attempt to construct a JsonNumber with a String [").append(p_i3235_1_).append("] that does not match the JSON number specification.").toString());
        } else
        {
            field_74620_b = p_i3235_1_;
            return;
        }
    }

    public JsonNodeType func_74616_a()
    {
        return JsonNodeType.NUMBER;
    }

    public String getText()
    {
        return field_74620_b;
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
            JsonNumberNode jsonnumbernode = (JsonNumberNode)p_equals_1_;
            return field_74620_b.equals(jsonnumbernode.field_74620_b);
        }
    }

    public int hashCode()
    {
        return field_74620_b.hashCode();
    }

    public String toString()
    {
        return (new StringBuilder()).append("JsonNumberNode value:[").append(field_74620_b).append("]").toString();
    }

}
