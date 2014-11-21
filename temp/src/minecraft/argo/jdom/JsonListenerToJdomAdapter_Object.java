// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package argo.jdom;


// Referenced classes of package argo.jdom:
//            JsonListenerToJdomAdapter_NodeContainer, JsonObjectNodeBuilder, JsonListenerToJdomAdapter, JsonNodeBuilder, 
//            JsonFieldBuilder

class JsonListenerToJdomAdapter_Object
    implements JsonListenerToJdomAdapter_NodeContainer
{

    final JsonObjectNodeBuilder field_74720_a; /* synthetic field */
    final JsonListenerToJdomAdapter field_74719_b; /* synthetic field */

    JsonListenerToJdomAdapter_Object(JsonListenerToJdomAdapter p_i3226_1_, JsonObjectNodeBuilder p_i3226_2_)
    {
        field_74719_b = p_i3226_1_;
        field_74720_a = p_i3226_2_;
        super();
    }

    public void func_74715_a(JsonNodeBuilder p_74715_1_)
    {
        throw new RuntimeException("Coding failure in Argo:  Attempt to add a node to an object.");
    }

    public void func_74716_a(JsonFieldBuilder p_74716_1_)
    {
        field_74720_a.func_74608_a(p_74716_1_);
    }
}
