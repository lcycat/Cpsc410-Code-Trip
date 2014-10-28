// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            IntHashMap

public class KeyBinding
{

    public static List field_74516_a = new ArrayList();
    public static IntHashMap field_74514_b = new IntHashMap();
    public String field_74515_c;
    public int field_74512_d;
    public boolean field_74513_e;
    public int field_74511_f;

    public static void func_74507_a(int p_74507_0_)
    {
        KeyBinding keybinding = (KeyBinding)field_74514_b.func_76041_a(p_74507_0_);
        if(keybinding != null)
        {
            keybinding.field_74511_f++;
        }
    }

    public static void func_74510_a(int p_74510_0_, boolean p_74510_1_)
    {
        KeyBinding keybinding = (KeyBinding)field_74514_b.func_76041_a(p_74510_0_);
        if(keybinding != null)
        {
            keybinding.field_74513_e = p_74510_1_;
        }
    }

    public static void func_74506_a()
    {
        KeyBinding keybinding;
        for(Iterator iterator = field_74516_a.iterator(); iterator.hasNext(); keybinding.func_74505_d())
        {
            keybinding = (KeyBinding)iterator.next();
        }

    }

    public static void func_74508_b()
    {
        field_74514_b.func_76046_c();
        KeyBinding keybinding;
        for(Iterator iterator = field_74516_a.iterator(); iterator.hasNext(); field_74514_b.func_76038_a(keybinding.field_74512_d, keybinding))
        {
            keybinding = (KeyBinding)iterator.next();
        }

    }

    public KeyBinding(String p_i3003_1_, int p_i3003_2_)
    {
        field_74511_f = 0;
        field_74515_c = p_i3003_1_;
        field_74512_d = p_i3003_2_;
        field_74516_a.add(this);
        field_74514_b.func_76038_a(p_i3003_2_, this);
    }

    public boolean func_74509_c()
    {
        if(field_74511_f == 0)
        {
            return false;
        } else
        {
            field_74511_f--;
            return true;
        }
    }

    private void func_74505_d()
    {
        field_74511_f = 0;
        field_74513_e = false;
    }

}
