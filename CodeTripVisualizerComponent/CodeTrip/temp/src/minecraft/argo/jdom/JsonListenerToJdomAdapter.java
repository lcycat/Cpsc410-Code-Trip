// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package argo.jdom;

import argo.saj.JsonListener;
import java.util.Stack;

// Referenced classes of package argo.jdom:
//            JsonNodeBuilder, JsonRootNode, JsonNodeBuilders, JsonListenerToJdomAdapter_Array, 
//            JsonListenerToJdomAdapter_Object, JsonFieldBuilder, JsonListenerToJdomAdapter_NodeContainer, JsonListenerToJdomAdapter_Field

final class JsonListenerToJdomAdapter
    implements JsonListener
{

    private final Stack field_74663_a = new Stack();
    private JsonNodeBuilder field_74662_b;

    JsonListenerToJdomAdapter()
    {
    }

    JsonRootNode func_74660_a()
    {
        return (JsonRootNode)field_74662_b.func_74599_b();
    }

    public void func_74656_b()
    {
    }

    public void func_74657_c()
    {
    }

    public void func_74652_d()
    {
        JsonArrayNodeBuilder jsonarraynodebuilder = JsonNodeBuilders.func_74708_e();
        func_74661_a(jsonarraynodebuilder);
        field_74663_a.push(new JsonListenerToJdomAdapter_Array(this, jsonarraynodebuilder));
    }

    public void func_74655_e()
    {
        field_74663_a.pop();
    }

    public void func_74651_f()
    {
        JsonObjectNodeBuilder jsonobjectnodebuilder = JsonNodeBuilders.func_74711_d();
        func_74661_a(jsonobjectnodebuilder);
        field_74663_a.push(new JsonListenerToJdomAdapter_Object(this, jsonobjectnodebuilder));
    }

    public void func_74653_g()
    {
        field_74663_a.pop();
    }

    public void func_74648_a(String p_74648_1_)
    {
        JsonFieldBuilder jsonfieldbuilder = JsonFieldBuilder.func_74727_a().func_74726_a(JsonNodeBuilders.func_74710_b(p_74648_1_));
        ((JsonListenerToJdomAdapter_NodeContainer)field_74663_a.peek()).func_74716_a(jsonfieldbuilder);
        field_74663_a.push(new JsonListenerToJdomAdapter_Field(this, jsonfieldbuilder));
    }

    public void func_74658_h()
    {
        field_74663_a.pop();
    }

    public void func_74650_b(String p_74650_1_)
    {
        func_74659_b(JsonNodeBuilders.func_74712_a(p_74650_1_));
    }

    public void func_74654_i()
    {
        func_74659_b(JsonNodeBuilders.func_74713_b());
    }

    public void func_74647_c(String p_74647_1_)
    {
        func_74659_b(JsonNodeBuilders.func_74710_b(p_74647_1_));
    }

    public void func_74649_j()
    {
        func_74659_b(JsonNodeBuilders.func_74709_c());
    }

    public void func_74646_k()
    {
        func_74659_b(JsonNodeBuilders.func_74714_a());
    }

    private void func_74661_a(JsonNodeBuilder p_74661_1_)
    {
        if(field_74662_b == null)
        {
            field_74662_b = p_74661_1_;
        } else
        {
            func_74659_b(p_74661_1_);
        }
    }

    private void func_74659_b(JsonNodeBuilder p_74659_1_)
    {
        ((JsonListenerToJdomAdapter_NodeContainer)field_74663_a.peek()).func_74715_a(p_74659_1_);
    }
}
