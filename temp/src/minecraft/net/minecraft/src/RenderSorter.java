// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Comparator;

// Referenced classes of package net.minecraft.src:
//            WorldRenderer, EntityLiving

public class RenderSorter
    implements Comparator
{

    private EntityLiving field_78945_a;

    public RenderSorter(EntityLiving p_i3190_1_)
    {
        field_78945_a = p_i3190_1_;
    }

    public int func_78944_a(WorldRenderer p_78944_1_, WorldRenderer p_78944_2_)
    {
        if(p_78944_1_.field_78927_l && !p_78944_2_.field_78927_l)
        {
            return 1;
        }
        if(p_78944_2_.field_78927_l && !p_78944_1_.field_78927_l)
        {
            return -1;
        }
        double d = p_78944_1_.func_78912_a(field_78945_a);
        double d1 = p_78944_2_.func_78912_a(field_78945_a);
        if(d < d1)
        {
            return 1;
        }
        if(d > d1)
        {
            return -1;
        } else
        {
            return p_78944_1_.field_78937_s >= p_78944_2_.field_78937_s ? -1 : 1;
        }
    }

    public int compare(Object p_compare_1_, Object p_compare_2_)
    {
        return func_78944_a((WorldRenderer)p_compare_1_, (WorldRenderer)p_compare_2_);
    }
}
