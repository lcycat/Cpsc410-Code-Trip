// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.awt.Component;
import org.lwjgl.input.Mouse;

public class MouseHelper
{

    private Component field_74376_c;
    public int field_74377_a;
    public int field_74375_b;

    public MouseHelper(Component p_i3015_1_)
    {
        field_74376_c = p_i3015_1_;
    }

    public void func_74372_a()
    {
        Mouse.setGrabbed(true);
        field_74377_a = 0;
        field_74375_b = 0;
    }

    public void func_74373_b()
    {
        Mouse.setCursorPosition(field_74376_c.getWidth() / 2, field_74376_c.getHeight() / 2);
        Mouse.setGrabbed(false);
    }

    public void func_74374_c()
    {
        field_74377_a = Mouse.getDX();
        field_74375_b = Mouse.getDY();
    }
}
