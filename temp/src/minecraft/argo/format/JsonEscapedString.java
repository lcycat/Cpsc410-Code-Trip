// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package argo.format;


final class JsonEscapedString
{

    private final String field_74791_a;

    JsonEscapedString(String p_i3220_1_)
    {
        field_74791_a = p_i3220_1_.replace("\\", "\\\\").replace("\"", "\\\"").replace("\b", "\\b").replace("\f", "\\f").replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t");
    }

    public String toString()
    {
        return field_74791_a;
    }
}
