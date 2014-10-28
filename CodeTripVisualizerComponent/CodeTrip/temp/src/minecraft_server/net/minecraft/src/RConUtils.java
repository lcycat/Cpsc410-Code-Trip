// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public class RConUtils
{

    public static char field_72666_a[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'a', 'b', 'c', 'd', 'e', 'f'
    };

    public static String func_72661_a(byte p_72661_0_[], int p_72661_1_, int p_72661_2_)
    {
        int i = p_72661_2_ - 1;
        int j;
        for(j = p_72661_1_ <= i ? p_72661_1_ : i; 0 != p_72661_0_[j] && j < i; j++) { }
        return new String(p_72661_0_, p_72661_1_, j - p_72661_1_);
    }

    public static int func_72662_b(byte p_72662_0_[], int p_72662_1_)
    {
        return func_72665_b(p_72662_0_, p_72662_1_, p_72662_0_.length);
    }

    public static int func_72665_b(byte p_72665_0_[], int p_72665_1_, int p_72665_2_)
    {
        if(0 > p_72665_2_ - p_72665_1_ - 4)
        {
            return 0;
        } else
        {
            return p_72665_0_[p_72665_1_ + 3] << 24 | (p_72665_0_[p_72665_1_ + 2] & 0xff) << 16 | (p_72665_0_[p_72665_1_ + 1] & 0xff) << 8 | p_72665_0_[p_72665_1_] & 0xff;
        }
    }

    public static int func_72664_c(byte p_72664_0_[], int p_72664_1_, int p_72664_2_)
    {
        if(0 > p_72664_2_ - p_72664_1_ - 4)
        {
            return 0;
        } else
        {
            return p_72664_0_[p_72664_1_] << 24 | (p_72664_0_[p_72664_1_ + 1] & 0xff) << 16 | (p_72664_0_[p_72664_1_ + 2] & 0xff) << 8 | p_72664_0_[p_72664_1_ + 3] & 0xff;
        }
    }

    public static String func_72663_a(byte p_72663_0_)
    {
        return (new StringBuilder()).append("").append(field_72666_a[(p_72663_0_ & 0xf0) >>> 4]).append(field_72666_a[p_72663_0_ & 0xf]).toString();
    }

}
