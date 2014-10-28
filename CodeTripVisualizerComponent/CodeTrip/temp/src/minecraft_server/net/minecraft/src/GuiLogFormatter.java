// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.*;

// Referenced classes of package net.minecraft.src:
//            GuiLogOutputHandler

class GuiLogFormatter extends Formatter
{

    final GuiLogOutputHandler field_79029_a; /* synthetic field */

    GuiLogFormatter(GuiLogOutputHandler p_i4101_1_)
    {
        field_79029_a = p_i4101_1_;
        super();
    }

    public String format(LogRecord p_format_1_)
    {
        StringBuilder stringbuilder = new StringBuilder();
        Level level = p_format_1_.getLevel();
        if(level == Level.FINEST)
        {
            stringbuilder.append("[FINEST] ");
        } else
        if(level == Level.FINER)
        {
            stringbuilder.append("[FINER] ");
        } else
        if(level == Level.FINE)
        {
            stringbuilder.append("[FINE] ");
        } else
        if(level == Level.INFO)
        {
            stringbuilder.append("[INFO] ");
        } else
        if(level == Level.WARNING)
        {
            stringbuilder.append("[WARNING] ");
        } else
        if(level == Level.SEVERE)
        {
            stringbuilder.append("[SEVERE] ");
        } else
        if(level == Level.SEVERE)
        {
            stringbuilder.append("[").append(level.getLocalizedName()).append("] ");
        }
        stringbuilder.append(p_format_1_.getMessage());
        stringbuilder.append('\n');
        Throwable throwable = p_format_1_.getThrown();
        if(throwable != null)
        {
            StringWriter stringwriter = new StringWriter();
            throwable.printStackTrace(new PrintWriter(stringwriter));
            stringbuilder.append(stringwriter.toString());
        }
        return stringbuilder.toString();
    }
}
