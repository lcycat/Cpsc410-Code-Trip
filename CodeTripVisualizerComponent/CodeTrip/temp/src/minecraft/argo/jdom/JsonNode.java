// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package argo.jdom;

import java.util.List;
import java.util.Map;

// Referenced classes of package argo.jdom:
//            JsonNodeSelectors, JsonNodeDoesNotMatchPathElementsException, JsonNodeDoesNotMatchChainedJsonNodeSelectorException, JsonNodeSelector, 
//            JsonNodeFactories, JsonNodeType

public abstract class JsonNode
{

    JsonNode()
    {
    }

    public abstract JsonNodeType func_74616_a();

    public abstract String getText();

    public abstract Map getFields();

    public abstract List func_74610_b();

    public final String getStringValue(Object p_getStringValue_1_[])
    {
        return (String)func_74613_a(JsonNodeSelectors.func_74682_a(p_getStringValue_1_), this, p_getStringValue_1_);
    }

    public final List getArrayNode(Object p_getArrayNode_1_[])
    {
        return (List)func_74613_a(JsonNodeSelectors.func_74683_b(p_getArrayNode_1_), this, p_getArrayNode_1_);
    }

    private Object func_74613_a(JsonNodeSelector p_74613_1_, JsonNode p_74613_2_, Object p_74613_3_[])
        throws JsonNodeDoesNotMatchPathElementsException
    {
        try
        {
            return p_74613_1_.func_74687_b(p_74613_2_);
        }
        catch(JsonNodeDoesNotMatchChainedJsonNodeSelectorException jsonnodedoesnotmatchchainedjsonnodeselectorexception)
        {
            throw JsonNodeDoesNotMatchPathElementsException.func_74704_a(jsonnodedoesnotmatchchainedjsonnodeselectorexception, p_74613_3_, JsonNodeFactories.func_74695_a(new JsonNode[] {
                p_74613_2_
            }));
        }
    }
}
