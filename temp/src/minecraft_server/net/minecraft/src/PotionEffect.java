// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.PrintStream;

// Referenced classes of package net.minecraft.src:
//            Potion, EntityLiving

public class PotionEffect
{

    private int field_76462_a;
    private int field_76460_b;
    private int field_76461_c;

    public PotionEffect(int p_i3434_1_, int p_i3434_2_, int p_i3434_3_)
    {
        field_76462_a = p_i3434_1_;
        field_76460_b = p_i3434_2_;
        field_76461_c = p_i3434_3_;
    }

    public PotionEffect(PotionEffect p_i3435_1_)
    {
        field_76462_a = p_i3435_1_.field_76462_a;
        field_76460_b = p_i3435_1_.field_76460_b;
        field_76461_c = p_i3435_1_.field_76461_c;
    }

    public void func_76452_a(PotionEffect p_76452_1_)
    {
        if(field_76462_a != p_76452_1_.field_76462_a)
        {
            System.err.println("This method should only be called for matching effects!");
        }
        if(p_76452_1_.field_76461_c > field_76461_c)
        {
            field_76461_c = p_76452_1_.field_76461_c;
            field_76460_b = p_76452_1_.field_76460_b;
        } else
        if(p_76452_1_.field_76461_c == field_76461_c && field_76460_b < p_76452_1_.field_76460_b)
        {
            field_76460_b = p_76452_1_.field_76460_b;
        }
    }

    public int func_76456_a()
    {
        return field_76462_a;
    }

    public int func_76459_b()
    {
        return field_76460_b;
    }

    public int func_76458_c()
    {
        return field_76461_c;
    }

    public boolean func_76455_a(EntityLiving p_76455_1_)
    {
        if(field_76460_b > 0)
        {
            if(Potion.field_76425_a[field_76462_a].func_76397_a(field_76460_b, field_76461_c))
            {
                func_76457_b(p_76455_1_);
            }
            func_76454_e();
        }
        return field_76460_b > 0;
    }

    private int func_76454_e()
    {
        return --field_76460_b;
    }

    public void func_76457_b(EntityLiving p_76457_1_)
    {
        if(field_76460_b > 0)
        {
            Potion.field_76425_a[field_76462_a].func_76394_a(p_76457_1_, field_76461_c);
        }
    }

    public String func_76453_d()
    {
        return Potion.field_76425_a[field_76462_a].func_76393_a();
    }

    public int hashCode()
    {
        return field_76462_a;
    }

    public String toString()
    {
        String s = "";
        if(func_76458_c() > 0)
        {
            s = (new StringBuilder()).append(func_76453_d()).append(" x ").append(func_76458_c() + 1).append(", Duration: ").append(func_76459_b()).toString();
        } else
        {
            s = (new StringBuilder()).append(func_76453_d()).append(", Duration: ").append(func_76459_b()).toString();
        }
        if(Potion.field_76425_a[field_76462_a].func_76395_i())
        {
            return (new StringBuilder()).append("(").append(s).append(")").toString();
        } else
        {
            return s;
        }
    }

    public boolean equals(Object p_equals_1_)
    {
        if(!(p_equals_1_ instanceof PotionEffect))
        {
            return false;
        } else
        {
            PotionEffect potioneffect = (PotionEffect)p_equals_1_;
            return field_76462_a == potioneffect.field_76462_a && field_76461_c == potioneffect.field_76461_c && field_76460_b == potioneffect.field_76460_b;
        }
    }
}
