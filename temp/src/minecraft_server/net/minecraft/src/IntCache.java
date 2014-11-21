// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;

public class IntCache
{

    private static int field_76451_a = 256;
    private static List field_76449_b = new ArrayList();
    private static List field_76450_c = new ArrayList();
    private static List field_76447_d = new ArrayList();
    private static List field_76448_e = new ArrayList();

    public static synchronized int[] func_76445_a(int p_76445_0_)
    {
        if(p_76445_0_ <= 256)
        {
            if(field_76449_b.isEmpty())
            {
                int ai[] = new int[256];
                field_76450_c.add(ai);
                return ai;
            } else
            {
                int ai1[] = (int[])field_76449_b.remove(field_76449_b.size() - 1);
                field_76450_c.add(ai1);
                return ai1;
            }
        }
        if(p_76445_0_ > field_76451_a)
        {
            field_76451_a = p_76445_0_;
            field_76447_d.clear();
            field_76448_e.clear();
            int ai2[] = new int[field_76451_a];
            field_76448_e.add(ai2);
            return ai2;
        }
        if(field_76447_d.isEmpty())
        {
            int ai3[] = new int[field_76451_a];
            field_76448_e.add(ai3);
            return ai3;
        } else
        {
            int ai4[] = (int[])field_76447_d.remove(field_76447_d.size() - 1);
            field_76448_e.add(ai4);
            return ai4;
        }
    }

    public static synchronized void func_76446_a()
    {
        if(!field_76447_d.isEmpty())
        {
            field_76447_d.remove(field_76447_d.size() - 1);
        }
        if(!field_76449_b.isEmpty())
        {
            field_76449_b.remove(field_76449_b.size() - 1);
        }
        field_76447_d.addAll(field_76448_e);
        field_76449_b.addAll(field_76450_c);
        field_76448_e.clear();
        field_76450_c.clear();
    }

}
