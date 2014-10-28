// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EnumGameType

public class SaveFormatComparator
    implements Comparable
{

    private final String field_75797_a;
    private final String field_75795_b;
    private final long field_75796_c;
    private final long field_75793_d;
    private final boolean field_75794_e;
    private final EnumGameType field_75791_f;
    private final boolean field_75792_g;
    private final boolean field_75798_h;

    public SaveFormatComparator(String p_i3917_1_, String p_i3917_2_, long p_i3917_3_, long p_i3917_5_, EnumGameType p_i3917_7_, 
            boolean p_i3917_8_, boolean p_i3917_9_, boolean p_i3917_10_)
    {
        field_75797_a = p_i3917_1_;
        field_75795_b = p_i3917_2_;
        field_75796_c = p_i3917_3_;
        field_75793_d = p_i3917_5_;
        field_75791_f = p_i3917_7_;
        field_75794_e = p_i3917_8_;
        field_75792_g = p_i3917_9_;
        field_75798_h = p_i3917_10_;
    }

    public String func_75786_a()
    {
        return field_75797_a;
    }

    public String func_75788_b()
    {
        return field_75795_b;
    }

    public boolean func_75785_d()
    {
        return field_75794_e;
    }

    public long func_75784_e()
    {
        return field_75796_c;
    }

    public int func_75787_a(SaveFormatComparator p_75787_1_)
    {
        if(field_75796_c < p_75787_1_.field_75796_c)
        {
            return 1;
        }
        if(field_75796_c > p_75787_1_.field_75796_c)
        {
            return -1;
        } else
        {
            return field_75797_a.compareTo(p_75787_1_.field_75797_a);
        }
    }

    public EnumGameType func_75790_f()
    {
        return field_75791_f;
    }

    public boolean func_75789_g()
    {
        return field_75792_g;
    }

    public boolean func_75783_h()
    {
        return field_75798_h;
    }

    public int compareTo(Object p_compareTo_1_)
    {
        return func_75787_a((SaveFormatComparator)p_compareTo_1_);
    }
}
