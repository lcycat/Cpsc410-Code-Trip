// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            StatList, AchievementMap, IStatType, StatCollector, 
//            StatTypeSimple, StatTypeTime, StatTypeDistance

public class StatBase
{

    public final int field_75975_e;
    private final String field_75978_a;
    public boolean field_75972_f;
    public String field_75973_g;
    private final IStatType field_75976_b;
    private static NumberFormat field_75977_c;
    public static IStatType field_75980_h = new StatTypeSimple();
    private static DecimalFormat field_75974_d = new DecimalFormat("########0.00");
    public static IStatType field_75981_i = new StatTypeTime();
    public static IStatType field_75979_j = new StatTypeDistance();

    public StatBase(int p_i3415_1_, String p_i3415_2_, IStatType p_i3415_3_)
    {
        field_75972_f = false;
        field_75975_e = p_i3415_1_;
        field_75978_a = p_i3415_2_;
        field_75976_b = p_i3415_3_;
    }

    public StatBase(int p_i3416_1_, String p_i3416_2_)
    {
        this(p_i3416_1_, p_i3416_2_, field_75980_h);
    }

    public StatBase func_75966_h()
    {
        field_75972_f = true;
        return this;
    }

    public StatBase func_75971_g()
    {
        if(StatList.field_75942_a.containsKey(Integer.valueOf(field_75975_e)))
        {
            throw new RuntimeException((new StringBuilder()).append("Duplicate stat id: \"").append(((StatBase)StatList.field_75942_a.get(Integer.valueOf(field_75975_e))).field_75978_a).append("\" and \"").append(field_75978_a).append("\" at id ").append(field_75975_e).toString());
        } else
        {
            StatList.field_75940_b.add(this);
            StatList.field_75942_a.put(Integer.valueOf(field_75975_e), this);
            field_75973_g = AchievementMap.func_75962_a(field_75975_e);
            return this;
        }
    }

    public boolean func_75967_d()
    {
        return false;
    }

    public String func_75968_a(int p_75968_1_)
    {
        return field_75976_b.func_75843_a(p_75968_1_);
    }

    public String func_75970_i()
    {
        return field_75978_a;
    }

    public String toString()
    {
        return StatCollector.func_74838_a(field_75978_a);
    }

    static NumberFormat func_75965_j()
    {
        return field_75977_c;
    }

    static DecimalFormat func_75969_k()
    {
        return field_75974_d;
    }

    static 
    {
        field_75977_c = NumberFormat.getIntegerInstance(Locale.US);
    }
}
