// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package argo.jdom;


// Referenced classes of package argo.jdom:
//            JsonListenerToJdomAdapter_NodeContainer, JsonFieldBuilder, JsonListenerToJdomAdapter, JsonNodeBuilder

class JsonListenerToJdomAdapter_Field
    implements JsonListenerToJdomAdapter_NodeContainer
{

    final JsonFieldBuilder field_74718_a; /* synthetic field */
    final JsonListenerToJdomAdapter field_74717_b; /* synthetic field */

    JsonListenerToJdomAdapter_Field(JsonListenerToJdomAdapter p_i3227_1_, JsonFieldBuilder p_i3227_2_)
    {
        field_74717_b = p_i3227_1_;
        field_74718_a = p_i3227_2_;
        super();
    }

    public void func_74715_a(JsonNodeBuilder p_74715_1_)
    {
        field_74718_a.func_74723_b(p_74715_1_);
    }

    public void func_74716_a(JsonFieldBuilder p_74716_1_)
    {
        throw new RuntimeException("Coding failure in Argo:  Attempt to add a field to a field.");
    }
}
