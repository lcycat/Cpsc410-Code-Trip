// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package argo.jdom;

import argo.format.CompactJsonFormatter;
import argo.format.JsonFormatter;

// Referenced classes of package argo.jdom:
//            JsonNodeDoesNotMatchJsonNodeSelectorException, JsonNodeDoesNotMatchChainedJsonNodeSelectorException, JsonRootNode

public final class JsonNodeDoesNotMatchPathElementsException extends JsonNodeDoesNotMatchJsonNodeSelectorException
{

    private static final JsonFormatter field_74707_a = new CompactJsonFormatter();

    static JsonNodeDoesNotMatchPathElementsException func_74704_a(JsonNodeDoesNotMatchChainedJsonNodeSelectorException p_74704_0_, Object p_74704_1_[], JsonRootNode p_74704_2_)
    {
        return new JsonNodeDoesNotMatchPathElementsException(p_74704_0_, p_74704_1_, p_74704_2_);
    }

    private JsonNodeDoesNotMatchPathElementsException(JsonNodeDoesNotMatchChainedJsonNodeSelectorException p_i3230_1_, Object p_i3230_2_[], JsonRootNode p_i3230_3_)
    {
        super(func_74706_b(p_i3230_1_, p_i3230_2_, p_i3230_3_));
    }

    private static String func_74706_b(JsonNodeDoesNotMatchChainedJsonNodeSelectorException p_74706_0_, Object p_74706_1_[], JsonRootNode p_74706_2_)
    {
        return (new StringBuilder()).append("Failed to find ").append(p_74706_0_.field_74703_a.toString()).append(" at [").append(JsonNodeDoesNotMatchChainedJsonNodeSelectorException.func_74700_a(p_74706_0_.field_74702_b)).append("] while resolving [").append(func_74705_a(p_74706_1_)).append("] in ").append(field_74707_a.func_74785_a(p_74706_2_)).append(".").toString();
    }

    private static String func_74705_a(Object p_74705_0_[])
    {
        StringBuilder stringbuilder = new StringBuilder();
        boolean flag = true;
        Object aobj[] = p_74705_0_;
        int i = aobj.length;
        for(int j = 0; j < i; j++)
        {
            Object obj = aobj[j];
            if(!flag)
            {
                stringbuilder.append(".");
            }
            flag = false;
            if(obj instanceof String)
            {
                stringbuilder.append("\"").append(obj).append("\"");
            } else
            {
                stringbuilder.append(obj);
            }
        }

        return stringbuilder.toString();
    }

}
