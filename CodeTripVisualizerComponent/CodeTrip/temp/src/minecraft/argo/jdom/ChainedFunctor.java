// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package argo.jdom;


// Referenced classes of package argo.jdom:
//            Functor, JsonNodeSelector, JsonNodeDoesNotMatchChainedJsonNodeSelectorException

final class ChainedFunctor
    implements Functor
{

    private final JsonNodeSelector field_74632_a;
    private final JsonNodeSelector field_74631_b;

    ChainedFunctor(JsonNodeSelector p_i3221_1_, JsonNodeSelector p_i3221_2_)
    {
        field_74632_a = p_i3221_1_;
        field_74631_b = p_i3221_2_;
    }

    public boolean func_74630_a(Object p_74630_1_)
    {
        return field_74632_a.func_74688_a(p_74630_1_) && field_74631_b.func_74688_a(field_74632_a.func_74687_b(p_74630_1_));
    }

    public Object func_74629_b(Object p_74629_1_)
    {
        Object obj;
        try
        {
            obj = field_74632_a.func_74687_b(p_74629_1_);
        }
        catch(JsonNodeDoesNotMatchChainedJsonNodeSelectorException jsonnodedoesnotmatchchainedjsonnodeselectorexception)
        {
            throw JsonNodeDoesNotMatchChainedJsonNodeSelectorException.func_74698_b(jsonnodedoesnotmatchchainedjsonnodeselectorexception, field_74632_a);
        }
        Object obj1;
        try
        {
            obj1 = field_74631_b.func_74687_b(obj);
        }
        catch(JsonNodeDoesNotMatchChainedJsonNodeSelectorException jsonnodedoesnotmatchchainedjsonnodeselectorexception1)
        {
            throw JsonNodeDoesNotMatchChainedJsonNodeSelectorException.func_74699_a(jsonnodedoesnotmatchchainedjsonnodeselectorexception1, field_74632_a);
        }
        return obj1;
    }

    public String func_74628_a()
    {
        return field_74631_b.func_74685_a();
    }

    public String toString()
    {
        return (new StringBuilder()).append(field_74632_a.toString()).append(", with ").append(field_74631_b.toString()).toString();
    }
}
