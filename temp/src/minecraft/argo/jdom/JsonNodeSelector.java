// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package argo.jdom;


// Referenced classes of package argo.jdom:
//            Functor, ChainedFunctor

public final class JsonNodeSelector
{

    final Functor field_74689_a;

    JsonNodeSelector(Functor p_i3231_1_)
    {
        field_74689_a = p_i3231_1_;
    }

    public boolean func_74688_a(Object p_74688_1_)
    {
        return field_74689_a.func_74630_a(p_74688_1_);
    }

    public Object func_74687_b(Object p_74687_1_)
    {
        return field_74689_a.func_74629_b(p_74687_1_);
    }

    public JsonNodeSelector func_74686_a(JsonNodeSelector p_74686_1_)
    {
        return new JsonNodeSelector(new ChainedFunctor(this, p_74686_1_));
    }

    String func_74685_a()
    {
        return field_74689_a.func_74628_a();
    }

    public String toString()
    {
        return field_74689_a.toString();
    }
}
