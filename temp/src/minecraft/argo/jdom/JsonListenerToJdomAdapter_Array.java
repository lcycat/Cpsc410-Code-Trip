// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package argo.jdom;


// Referenced classes of package argo.jdom:
//            JsonListenerToJdomAdapter_NodeContainer, JsonArrayNodeBuilder, JsonListenerToJdomAdapter, JsonNodeBuilder, 
//            JsonFieldBuilder

class JsonListenerToJdomAdapter_Array
    implements JsonListenerToJdomAdapter_NodeContainer
{

    final JsonArrayNodeBuilder field_74722_a; /* synthetic field */
    final JsonListenerToJdomAdapter field_74721_b; /* synthetic field */

    JsonListenerToJdomAdapter_Array(JsonListenerToJdomAdapter p_i3225_1_, JsonArrayNodeBuilder p_i3225_2_)
    {
        field_74721_b = p_i3225_1_;
        field_74722_a = p_i3225_2_;
        super();
    }

    public void func_74715_a(JsonNodeBuilder p_74715_1_)
    {
        field_74722_a.func_74603_a(p_74715_1_);
    }

    public void func_74716_a(JsonFieldBuilder p_74716_1_)
    {
        throw new RuntimeException("Coding failure in Argo:  Attempt to add a field to an array.");
    }
}
