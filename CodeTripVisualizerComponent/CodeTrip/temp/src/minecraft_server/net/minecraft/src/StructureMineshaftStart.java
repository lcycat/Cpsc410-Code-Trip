// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.LinkedList;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            StructureStart, ComponentMineshaftRoom, World

public class StructureMineshaftStart extends StructureStart
{

    public StructureMineshaftStart(World p_i3811_1_, Random p_i3811_2_, int p_i3811_3_, int p_i3811_4_)
    {
        ComponentMineshaftRoom componentmineshaftroom = new ComponentMineshaftRoom(0, p_i3811_2_, (p_i3811_3_ << 4) + 2, (p_i3811_4_ << 4) + 2);
        field_75075_a.add(componentmineshaftroom);
        componentmineshaftroom.func_74861_a(componentmineshaftroom, field_75075_a, p_i3811_2_);
        func_75072_c();
        func_75067_a(p_i3811_1_, p_i3811_2_, 10);
    }
}
