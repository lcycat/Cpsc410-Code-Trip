// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public class NibbleArrayReader
{

    public final byte field_76689_a[];
    private final int field_76687_b;
    private final int field_76688_c;

    public NibbleArrayReader(byte p_i3774_1_[], int p_i3774_2_)
    {
        field_76689_a = p_i3774_1_;
        field_76687_b = p_i3774_2_;
        field_76688_c = p_i3774_2_ + 4;
    }

    public int func_76686_a(int p_76686_1_, int p_76686_2_, int p_76686_3_)
    {
        int i = p_76686_1_ << field_76688_c | p_76686_3_ << field_76687_b | p_76686_2_;
        int j = i >> 1;
        int k = i & 1;
        if(k == 0)
        {
            return field_76689_a[j] & 0xf;
        } else
        {
            return field_76689_a[j] >> 4 & 0xf;
        }
    }
}
