// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            World, IChunkProvider

public class MapGenBase
{

    protected int field_75040_a;
    protected Random field_75038_b;
    protected World field_75039_c;

    public MapGenBase()
    {
        field_75040_a = 8;
        field_75038_b = new Random();
    }

    public void func_75036_a(IChunkProvider p_75036_1_, World p_75036_2_, int p_75036_3_, int p_75036_4_, byte p_75036_5_[])
    {
        int i = field_75040_a;
        field_75039_c = p_75036_2_;
        field_75038_b.setSeed(p_75036_2_.func_72905_C());
        long l = field_75038_b.nextLong();
        long l1 = field_75038_b.nextLong();
        for(int j = p_75036_3_ - i; j <= p_75036_3_ + i; j++)
        {
            for(int k = p_75036_4_ - i; k <= p_75036_4_ + i; k++)
            {
                long l2 = (long)j * l;
                long l3 = (long)k * l1;
                field_75038_b.setSeed(l2 ^ l3 ^ p_75036_2_.func_72905_C());
                func_75037_a(p_75036_2_, j, k, p_75036_3_, p_75036_4_, p_75036_5_);
            }

        }

    }

    protected void func_75037_a(World world, int i, int j, int k, int l, byte abyte0[])
    {
    }
}
