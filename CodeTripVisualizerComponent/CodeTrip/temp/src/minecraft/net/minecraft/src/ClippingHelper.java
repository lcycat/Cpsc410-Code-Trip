// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public class ClippingHelper
{

    public float field_78557_a[][];
    public float field_78555_b[];
    public float field_78556_c[];
    public float field_78554_d[];

    public ClippingHelper()
    {
        field_78557_a = new float[16][16];
        field_78555_b = new float[16];
        field_78556_c = new float[16];
        field_78554_d = new float[16];
    }

    public boolean func_78553_b(double p_78553_1_, double p_78553_3_, double p_78553_5_, double p_78553_7_, double p_78553_9_, double p_78553_11_)
    {
        for(int i = 0; i < 6; i++)
        {
            if((double)field_78557_a[i][0] * p_78553_1_ + (double)field_78557_a[i][1] * p_78553_3_ + (double)field_78557_a[i][2] * p_78553_5_ + (double)field_78557_a[i][3] <= 0.0D && (double)field_78557_a[i][0] * p_78553_7_ + (double)field_78557_a[i][1] * p_78553_3_ + (double)field_78557_a[i][2] * p_78553_5_ + (double)field_78557_a[i][3] <= 0.0D && (double)field_78557_a[i][0] * p_78553_1_ + (double)field_78557_a[i][1] * p_78553_9_ + (double)field_78557_a[i][2] * p_78553_5_ + (double)field_78557_a[i][3] <= 0.0D && (double)field_78557_a[i][0] * p_78553_7_ + (double)field_78557_a[i][1] * p_78553_9_ + (double)field_78557_a[i][2] * p_78553_5_ + (double)field_78557_a[i][3] <= 0.0D && (double)field_78557_a[i][0] * p_78553_1_ + (double)field_78557_a[i][1] * p_78553_3_ + (double)field_78557_a[i][2] * p_78553_11_ + (double)field_78557_a[i][3] <= 0.0D && (double)field_78557_a[i][0] * p_78553_7_ + (double)field_78557_a[i][1] * p_78553_3_ + (double)field_78557_a[i][2] * p_78553_11_ + (double)field_78557_a[i][3] <= 0.0D && (double)field_78557_a[i][0] * p_78553_1_ + (double)field_78557_a[i][1] * p_78553_9_ + (double)field_78557_a[i][2] * p_78553_11_ + (double)field_78557_a[i][3] <= 0.0D && (double)field_78557_a[i][0] * p_78553_7_ + (double)field_78557_a[i][1] * p_78553_9_ + (double)field_78557_a[i][2] * p_78553_11_ + (double)field_78557_a[i][3] <= 0.0D)
            {
                return false;
            }
        }

        return true;
    }
}
