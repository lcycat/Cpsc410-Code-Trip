// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            CommandException

public class SyntaxErrorException extends CommandException
{

    public SyntaxErrorException()
    {
        this("commands.generic.snytax", new Object[0]);
    }

    public SyntaxErrorException(String p_i3256_1_, Object p_i3256_2_[])
    {
        super(p_i3256_1_, p_i3256_2_);
    }
}
