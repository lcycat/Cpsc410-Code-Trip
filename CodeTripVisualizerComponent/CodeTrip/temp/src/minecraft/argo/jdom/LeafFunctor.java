// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package argo.jdom;


// Referenced classes of package argo.jdom:
//            Functor, JsonNodeDoesNotMatchChainedJsonNodeSelectorException

abstract class LeafFunctor
    implements Functor
{

    LeafFunctor()
    {
    }

    public final Object func_74629_b(Object p_74629_1_)
    {
        if(!func_74630_a(p_74629_1_))
        {
            throw JsonNodeDoesNotMatchChainedJsonNodeSelectorException.func_74701_a(this);
        } else
        {
            return func_74633_c(p_74629_1_);
        }
    }

    protected abstract Object func_74633_c(Object obj);
}
