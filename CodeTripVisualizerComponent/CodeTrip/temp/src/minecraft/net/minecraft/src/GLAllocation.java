// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.nio.*;
import java.util.*;
import org.lwjgl.opengl.GL11;

public class GLAllocation
{

    private static final Map field_74531_a = new HashMap();
    private static final List field_74530_b = new ArrayList();

    public static synchronized int func_74526_a(int p_74526_0_)
    {
        int i = GL11.glGenLists(p_74526_0_);
        field_74531_a.put(Integer.valueOf(i), Integer.valueOf(p_74526_0_));
        return i;
    }

    public static synchronized void func_74528_a(IntBuffer p_74528_0_)
    {
        GL11.glGenTextures(p_74528_0_);
        for(int i = p_74528_0_.position(); i < p_74528_0_.limit(); i++)
        {
            field_74530_b.add(Integer.valueOf(p_74528_0_.get(i)));
        }

    }

    public static synchronized void func_74523_b(int p_74523_0_)
    {
        GL11.glDeleteLists(p_74523_0_, ((Integer)field_74531_a.remove(Integer.valueOf(p_74523_0_))).intValue());
    }

    public static synchronized void func_74525_a()
    {
        java.util.Map.Entry entry;
        for(Iterator iterator = field_74531_a.entrySet().iterator(); iterator.hasNext(); GL11.glDeleteLists(((Integer)entry.getKey()).intValue(), ((Integer)entry.getValue()).intValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        field_74531_a.clear();
        int i;
        for(Iterator iterator1 = field_74530_b.iterator(); iterator1.hasNext(); GL11.glDeleteTextures(i))
        {
            i = ((Integer)iterator1.next()).intValue();
        }

        field_74530_b.clear();
    }

    public static synchronized ByteBuffer func_74524_c(int p_74524_0_)
    {
        return ByteBuffer.allocateDirect(p_74524_0_).order(ByteOrder.nativeOrder());
    }

    public static IntBuffer func_74527_f(int p_74527_0_)
    {
        return func_74524_c(p_74527_0_ << 2).asIntBuffer();
    }

    public static FloatBuffer func_74529_h(int p_74529_0_)
    {
        return func_74524_c(p_74529_0_ << 2).asFloatBuffer();
    }

}
