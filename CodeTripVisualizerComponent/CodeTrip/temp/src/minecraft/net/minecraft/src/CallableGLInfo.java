// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.concurrent.Callable;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class CallableGLInfo
    implements Callable
{

    final Minecraft field_74419_a; /* synthetic field */

    public CallableGLInfo(Minecraft p_i3016_1_)
    {
        field_74419_a = p_i3016_1_;
        super();
    }

    public String func_74418_a()
    {
        return (new StringBuilder()).append(GL11.glGetString(7937)).append(" GL version ").append(GL11.glGetString(7938)).append(", ").append(GL11.glGetString(7936)).toString();
    }

    public Object call()
    {
        return func_74418_a();
    }
}
