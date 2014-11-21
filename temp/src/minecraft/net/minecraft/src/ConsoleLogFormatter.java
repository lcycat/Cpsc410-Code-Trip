// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.logging.*;

final class ConsoleLogFormatter extends Formatter
{

    private SimpleDateFormat field_74268_a;

    ConsoleLogFormatter()
    {
        field_74268_a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public String format(LogRecord p_format_1_)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(field_74268_a.format(Long.valueOf(p_format_1_.getMillis())));
        Level level = p_format_1_.getLevel();
        if(level == Level.FINEST)
        {
            stringbuilder.append(" [FINEST] ");
        } else
        if(level == Level.FINER)
        {
            stringbuilder.append(" [FINER] ");
        } else
        if(level == Level.FINE)
        {
            stringbuilder.append(" [FINE] ");
        } else
        if(level == Level.INFO)
        {
            stringbuilder.append(" [INFO] ");
        } else
        if(level == Level.WARNING)
        {
            stringbuilder.append(" [WARNING] ");
        } else
        if(level == Level.SEVERE)
        {
            stringbuilder.append(" [SEVERE] ");
        } else
        if(level == Level.SEVERE)
        {
            stringbuilder.append(" [").append(level.getLocalizedName()).append("] ");
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
