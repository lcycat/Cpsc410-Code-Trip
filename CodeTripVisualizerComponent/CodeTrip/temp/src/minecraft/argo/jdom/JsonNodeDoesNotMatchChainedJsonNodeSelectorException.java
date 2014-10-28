// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package argo.jdom;

import java.util.LinkedList;
import java.util.List;

// Referenced classes of package argo.jdom:
//            JsonNodeDoesNotMatchJsonNodeSelectorException, JsonNodeSelector, Functor

public final class JsonNodeDoesNotMatchChainedJsonNodeSelectorException extends JsonNodeDoesNotMatchJsonNodeSelectorException
{

    final Functor field_74703_a;
    final List field_74702_b;

    static JsonNodeDoesNotMatchJsonNodeSelectorException func_74701_a(Functor p_74701_0_)
    {
        return new JsonNodeDoesNotMatchChainedJsonNodeSelectorException(p_74701_0_, new LinkedList());
    }

    static JsonNodeDoesNotMatchJsonNodeSelectorException func_74699_a(JsonNodeDoesNotMatchChainedJsonNodeSelectorException p_74699_0_, JsonNodeSelector p_74699_1_)
    {
        LinkedList linkedlist = new LinkedList(p_74699_0_.field_74702_b);
        linkedlist.add(p_74699_1_);
        return new JsonNodeDoesNotMatchChainedJsonNodeSelectorException(p_74699_0_.field_74703_a, linkedlist);
    }

    static JsonNodeDoesNotMatchJsonNodeSelectorException func_74698_b(JsonNodeDoesNotMatchChainedJsonNodeSelectorException p_74698_0_, JsonNodeSelector p_74698_1_)
    {
        LinkedList linkedlist = new LinkedList();
        linkedlist.add(p_74698_1_);
        return new JsonNodeDoesNotMatchChainedJsonNodeSelectorException(p_74698_0_.field_74703_a, linkedlist);
    }

    private JsonNodeDoesNotMatchChainedJsonNodeSelectorException(Functor p_i3228_1_, List p_i3228_2_)
    {
        super((new StringBuilder()).append("Failed to match any JSON node at [").append(func_74700_a(p_i3228_2_)).append("]").toString());
        field_74703_a = p_i3228_1_;
        field_74702_b = p_i3228_2_;
    }

    static String func_74700_a(List p_74700_0_)
    {
        StringBuilder stringbuilder = new StringBuilder();
        for(int i = p_74700_0_.size() - 1; i >= 0; i--)
        {
            stringbuilder.append(((JsonNodeSelector)p_74700_0_.get(i)).func_74685_a());
            if(i != 0)
            {
                stringbuilder.append(".");
            }
        }

        return stringbuilder.toString();
    }

    public String toString()
    {
        return (new StringBuilder()).append("JsonNodeDoesNotMatchJsonNodeSelectorException{failedNode=").append(field_74703_a).append(", failPath=").append(field_74702_b).append('}').toString();
    }
}
