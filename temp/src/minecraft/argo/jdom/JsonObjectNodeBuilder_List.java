// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package argo.jdom;

import java.util.*;

// Referenced classes of package argo.jdom:
//            JsonObjectNodeBuilder, JsonFieldBuilder

class JsonObjectNodeBuilder_List extends HashMap
{

    final JsonObjectNodeBuilder field_74598_a; /* synthetic field */

    JsonObjectNodeBuilder_List(JsonObjectNodeBuilder p_i3238_1_)
    {
        field_74598_a = p_i3238_1_;
        super();
        JsonFieldBuilder jsonfieldbuilder;
        for(Iterator iterator = JsonObjectNodeBuilder.func_74607_a(field_74598_a).iterator(); iterator.hasNext(); put(jsonfieldbuilder.func_74724_b(), jsonfieldbuilder.func_74725_c()))
        {
            jsonfieldbuilder = (JsonFieldBuilder)iterator.next();
        }

    }
}
