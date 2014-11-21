// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package argo.jdom;

import java.util.Arrays;

// Referenced classes of package argo.jdom:
//            JsonNodeSelector, JsonNodeSelectors_String, JsonNodeSelectors_Array, JsonNodeSelectors_Object, 
//            JsonNodeFactories, JsonNodeSelectors_Field, JsonNodeSelectors_Element, ChainedFunctor, 
//            JsonStringNode

public final class JsonNodeSelectors
{

    public static JsonNodeSelector func_74682_a(Object p_74682_0_[])
    {
        return func_74677_a(p_74682_0_, new JsonNodeSelector(new JsonNodeSelectors_String()));
    }

    public static JsonNodeSelector func_74683_b(Object p_74683_0_[])
    {
        return func_74677_a(p_74683_0_, new JsonNodeSelector(new JsonNodeSelectors_Array()));
    }

    public static JsonNodeSelector func_74681_c(Object p_74681_0_[])
    {
        return func_74677_a(p_74681_0_, new JsonNodeSelector(new JsonNodeSelectors_Object()));
    }

    public static JsonNodeSelector func_74675_a(String p_74675_0_)
    {
        return func_74680_a(JsonNodeFactories.func_74697_a(p_74675_0_));
    }

    public static JsonNodeSelector func_74680_a(JsonStringNode p_74680_0_)
    {
        return new JsonNodeSelector(new JsonNodeSelectors_Field(p_74680_0_));
    }

    public static JsonNodeSelector func_74684_b(String p_74684_0_)
    {
        return func_74681_c(new Object[0]).func_74686_a(func_74675_a(p_74684_0_));
    }

    public static JsonNodeSelector func_74678_a(int p_74678_0_)
    {
        return new JsonNodeSelector(new JsonNodeSelectors_Element(p_74678_0_));
    }

    public static JsonNodeSelector func_74679_b(int p_74679_0_)
    {
        return func_74683_b(new Object[0]).func_74686_a(func_74678_a(p_74679_0_));
    }

    private static JsonNodeSelector func_74677_a(Object p_74677_0_[], JsonNodeSelector p_74677_1_)
    {
        JsonNodeSelector jsonnodeselector = p_74677_1_;
        for(int i = p_74677_0_.length - 1; i >= 0; i--)
        {
            if(p_74677_0_[i] instanceof Integer)
            {
                jsonnodeselector = func_74676_a(func_74679_b(((Integer)p_74677_0_[i]).intValue()), jsonnodeselector);
                continue;
            }
            if(p_74677_0_[i] instanceof String)
            {
                jsonnodeselector = func_74676_a(func_74684_b((String)p_74677_0_[i]), jsonnodeselector);
            } else
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Element [").append(p_74677_0_[i]).append("] of path elements").append(" [").append(Arrays.toString(p_74677_0_)).append("] was of illegal type [").append(p_74677_0_[i].getClass().getCanonicalName()).append("]; only Integer and String are valid.").toString());
            }
        }

        return jsonnodeselector;
    }

    private static JsonNodeSelector func_74676_a(JsonNodeSelector p_74676_0_, JsonNodeSelector p_74676_1_)
    {
        return new JsonNodeSelector(new ChainedFunctor(p_74676_0_, p_74676_1_));
    }
}
