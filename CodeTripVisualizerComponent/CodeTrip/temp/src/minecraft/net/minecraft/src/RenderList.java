// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.nio.IntBuffer;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GLAllocation

public class RenderList
{

    private int field_78429_a;
    private int field_78427_b;
    private int field_78428_c;
    private double field_78425_d;
    private double field_78426_e;
    private double field_78423_f;
    private IntBuffer field_78424_g;
    private boolean field_78430_h;
    private boolean field_78431_i;

    public RenderList()
    {
        field_78424_g = GLAllocation.func_74527_f(0x10000);
        field_78430_h = false;
        field_78431_i = false;
    }

    public void func_78422_a(int p_78422_1_, int p_78422_2_, int p_78422_3_, double p_78422_4_, double p_78422_6_, 
            double p_78422_8_)
    {
        field_78430_h = true;
        field_78424_g.clear();
        field_78429_a = p_78422_1_;
        field_78427_b = p_78422_2_;
        field_78428_c = p_78422_3_;
        field_78425_d = p_78422_4_;
        field_78426_e = p_78422_6_;
        field_78423_f = p_78422_8_;
    }

    public boolean func_78418_a(int p_78418_1_, int p_78418_2_, int p_78418_3_)
    {
        if(!field_78430_h)
        {
            return false;
        } else
        {
            return p_78418_1_ == field_78429_a && p_78418_2_ == field_78427_b && p_78418_3_ == field_78428_c;
        }
    }

    public void func_78420_a(int p_78420_1_)
    {
        field_78424_g.put(p_78420_1_);
        if(field_78424_g.remaining() == 0)
        {
            func_78419_a();
        }
    }

    public void func_78419_a()
    {
        if(!field_78430_h)
        {
            return;
        }
        if(!field_78431_i)
        {
            field_78424_g.flip();
            field_78431_i = true;
        }
        if(field_78424_g.remaining() > 0)
        {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)((double)field_78429_a - field_78425_d), (float)((double)field_78427_b - field_78426_e), (float)((double)field_78428_c - field_78423_f));
            GL11.glCallLists(field_78424_g);
            GL11.glPopMatrix();
        }
    }

    public void func_78421_b()
    {
        field_78430_h = false;
        field_78431_i = false;
    }
}
