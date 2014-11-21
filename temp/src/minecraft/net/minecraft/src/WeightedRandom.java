// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            WeightedRandomItem

public class WeightedRandom
{

    public static int func_76272_a(Collection p_76272_0_)
    {
        int i = 0;
        for(Iterator iterator = p_76272_0_.iterator(); iterator.hasNext();)
        {
            WeightedRandomItem weightedrandomitem = (WeightedRandomItem)iterator.next();
            i += weightedrandomitem.field_76292_a;
        }

        return i;
    }

    public static WeightedRandomItem func_76273_a(Random p_76273_0_, Collection p_76273_1_, int p_76273_2_)
    {
        if(p_76273_2_ <= 0)
        {
            throw new IllegalArgumentException();
        }
        int i = p_76273_0_.nextInt(p_76273_2_);
        for(Iterator iterator = p_76273_1_.iterator(); iterator.hasNext();)
        {
            WeightedRandomItem weightedrandomitem = (WeightedRandomItem)iterator.next();
            i -= weightedrandomitem.field_76292_a;
            if(i < 0)
            {
                return weightedrandomitem;
            }
        }

        return null;
    }

    public static WeightedRandomItem func_76271_a(Random p_76271_0_, Collection p_76271_1_)
    {
        return func_76273_a(p_76271_0_, p_76271_1_, func_76272_a(p_76271_1_));
    }

    public static int func_76270_a(WeightedRandomItem p_76270_0_[])
    {
        int i = 0;
        WeightedRandomItem aweightedrandomitem[] = p_76270_0_;
        int j = aweightedrandomitem.length;
        for(int k = 0; k < j; k++)
        {
            WeightedRandomItem weightedrandomitem = aweightedrandomitem[k];
            i += weightedrandomitem.field_76292_a;
        }

        return i;
    }

    public static WeightedRandomItem func_76269_a(Random p_76269_0_, WeightedRandomItem p_76269_1_[], int p_76269_2_)
    {
        if(p_76269_2_ <= 0)
        {
            throw new IllegalArgumentException();
        }
        int i = p_76269_0_.nextInt(p_76269_2_);
        WeightedRandomItem aweightedrandomitem[] = p_76269_1_;
        int j = aweightedrandomitem.length;
        for(int k = 0; k < j; k++)
        {
            WeightedRandomItem weightedrandomitem = aweightedrandomitem[k];
            i -= weightedrandomitem.field_76292_a;
            if(i < 0)
            {
                return weightedrandomitem;
            }
        }

        return null;
    }

    public static WeightedRandomItem func_76274_a(Random p_76274_0_, WeightedRandomItem p_76274_1_[])
    {
        return func_76269_a(p_76274_0_, p_76274_1_, func_76270_a(p_76274_1_));
    }
}
