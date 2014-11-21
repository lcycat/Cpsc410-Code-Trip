// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public class NibbleArray
{

    public final byte field_76585_a[];
    private final int field_76583_b;
    private final int field_76584_c;

    public NibbleArray(int p_i3768_1_, int p_i3768_2_)
    {
        field_76585_a = new byte[p_i3768_1_ >> 1];
        field_76583_b = p_i3768_2_;
        field_76584_c = p_i3768_2_ + 4;
    }

    public NibbleArray(byte p_i3769_1_[], int p_i3769_2_)
    {
        field_76585_a = p_i3769_1_;
        field_76583_b = p_i3769_2_;
        field_76584_c = p_i3769_2_ + 4;
    }

    public int func_76582_a(int p_76582_1_, int p_76582_2_, int p_76582_3_)
    {
        int i = p_76582_2_ << field_76584_c | p_76582_3_ << field_76583_b | p_76582_1_;
        int j = i >> 1;
        int k = i & 1;
        if(k == 0)
        {
            return field_76585_a[j] & 0xf;
        } else
        {
            return field_76585_a[j] >> 4 & 0xf;
        }
    }

    public void func_76581_a(int p_76581_1_, int p_76581_2_, int p_76581_3_, int p_76581_4_)
    {
        int i = p_76581_2_ << field_76584_c | p_76581_3_ << field_76583_b | p_76581_1_;
        int j = i >> 1;
        int k = i & 1;
        if(k == 0)
        {
            field_76585_a[j] = (byte)(field_76585_a[j] & 0xf0 | p_76581_4_ & 0xf);
        } else
        {
            field_76585_a[j] = (byte)(field_76585_a[j] & 0xf | (p_76581_4_ & 0xf) << 4);
        }
    }
}
