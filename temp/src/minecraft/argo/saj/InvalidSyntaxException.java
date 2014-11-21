// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package argo.saj;


// Referenced classes of package argo.saj:
//            ThingWithPosition

public final class InvalidSyntaxException extends Exception
{

    private final int field_74665_a;
    private final int field_74664_b;

    InvalidSyntaxException(String p_i3241_1_, ThingWithPosition p_i3241_2_)
    {
        super((new StringBuilder()).append("At line ").append(p_i3241_2_.func_74561_c()).append(", column ").append(p_i3241_2_.func_74562_b()).append(":  ").append(p_i3241_1_).toString());
        field_74665_a = p_i3241_2_.func_74562_b();
        field_74664_b = p_i3241_2_.func_74561_c();
    }

    InvalidSyntaxException(String p_i3242_1_, Throwable p_i3242_2_, ThingWithPosition p_i3242_3_)
    {
        super((new StringBuilder()).append("At line ").append(p_i3242_3_.func_74561_c()).append(", column ").append(p_i3242_3_.func_74562_b()).append(":  ").append(p_i3242_1_).toString(), p_i3242_2_);
        field_74665_a = p_i3242_3_.func_74562_b();
        field_74664_b = p_i3242_3_.func_74561_c();
    }
}
