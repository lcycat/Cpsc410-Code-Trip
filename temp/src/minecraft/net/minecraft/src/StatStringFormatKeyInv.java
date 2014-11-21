// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            IStatStringFormat, GameSettings, KeyBinding

public class StatStringFormatKeyInv
    implements IStatStringFormat
{

    final Minecraft field_74536_a; /* synthetic field */

    public StatStringFormatKeyInv(Minecraft p_i3018_1_)
    {
        field_74536_a = p_i3018_1_;
        super();
    }

    public String func_74535_a(String p_74535_1_)
    {
        try
        {
            return String.format(p_74535_1_, new Object[] {
                GameSettings.func_74298_c(field_74536_a.field_71474_y.field_74315_B.field_74512_d)
            });
        }
        catch(Exception exception)
        {
            return (new StringBuilder()).append("Error: ").append(exception.getLocalizedMessage()).toString();
        }
    }
}
