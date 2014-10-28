// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package argo.format;

import argo.jdom.*;
import java.io.*;
import java.util.*;

// Referenced classes of package argo.format:
//            JsonFormatter, CompactJsonFormatter_JsonNodeType, JsonEscapedString

public final class CompactJsonFormatter
    implements JsonFormatter
{

    public CompactJsonFormatter()
    {
    }

    public String func_74785_a(JsonRootNode p_74785_1_)
    {
        StringWriter stringwriter = new StringWriter();
        try
        {
            func_74787_a(p_74785_1_, stringwriter);
        }
        catch(IOException ioexception)
        {
            throw new RuntimeException("Coding failure in Argo:  StringWriter gave an IOException", ioexception);
        }
        return stringwriter.toString();
    }

    public void func_74787_a(JsonRootNode p_74787_1_, Writer p_74787_2_)
        throws IOException
    {
        func_74786_a(p_74787_1_, p_74787_2_);
    }

    private void func_74786_a(JsonNode p_74786_1_, Writer p_74786_2_)
        throws IOException
    {
        boolean flag = true;
        switch(CompactJsonFormatter_JsonNodeType.field_74790_a[p_74786_1_.func_74616_a().ordinal()])
        {
        case 1: // '\001'
            p_74786_2_.append('[');
            JsonNode jsonnode;
            for(Iterator iterator = p_74786_1_.func_74610_b().iterator(); iterator.hasNext(); func_74786_a(jsonnode, p_74786_2_))
            {
                jsonnode = (JsonNode)iterator.next();
                if(!flag)
                {
                    p_74786_2_.append(',');
                }
                flag = false;
            }

            p_74786_2_.append(']');
            break;

        case 2: // '\002'
            p_74786_2_.append('{');
            JsonStringNode jsonstringnode;
            for(Iterator iterator1 = (new TreeSet(p_74786_1_.getFields().keySet())).iterator(); iterator1.hasNext(); func_74786_a((JsonNode)p_74786_1_.getFields().get(jsonstringnode), p_74786_2_))
            {
                jsonstringnode = (JsonStringNode)iterator1.next();
                if(!flag)
                {
                    p_74786_2_.append(',');
                }
                flag = false;
                func_74786_a(((JsonNode) (jsonstringnode)), p_74786_2_);
                p_74786_2_.append(':');
            }

            p_74786_2_.append('}');
            break;

        case 3: // '\003'
            p_74786_2_.append('"').append((new JsonEscapedString(p_74786_1_.getText())).toString()).append('"');
            break;

        case 4: // '\004'
            p_74786_2_.append(p_74786_1_.getText());
            break;

        case 5: // '\005'
            p_74786_2_.append("false");
            break;

        case 6: // '\006'
            p_74786_2_.append("true");
            break;

        case 7: // '\007'
            p_74786_2_.append("null");
            break;

        default:
            throw new RuntimeException((new StringBuilder()).append("Coding failure in Argo:  Attempt to format a JsonNode of unknown type [").append(p_74786_1_.func_74616_a()).append("];").toString());
        }
    }
}
