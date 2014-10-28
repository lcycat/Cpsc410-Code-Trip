// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package argo.jdom;

import argo.saj.InvalidSyntaxException;
import argo.saj.SajParser;
import java.io.*;

// Referenced classes of package argo.jdom:
//            JsonListenerToJdomAdapter, JsonRootNode

public final class JdomParser
{

    public JdomParser()
    {
    }

    public JsonRootNode func_74788_a(Reader p_74788_1_)
        throws IOException, InvalidSyntaxException
    {
        JsonListenerToJdomAdapter jsonlistenertojdomadapter = new JsonListenerToJdomAdapter();
        (new SajParser()).func_74552_a(p_74788_1_, jsonlistenertojdomadapter);
        return jsonlistenertojdomadapter.func_74660_a();
    }

    public JsonRootNode parse(String p_parse_1_)
        throws InvalidSyntaxException
    {
        JsonRootNode jsonrootnode;
        try
        {
            jsonrootnode = func_74788_a(new StringReader(p_parse_1_));
        }
        catch(IOException ioexception)
        {
            throw new RuntimeException("Coding failure in Argo:  StringWriter gave an IOException", ioexception);
        }
        return jsonrootnode;
    }
}
