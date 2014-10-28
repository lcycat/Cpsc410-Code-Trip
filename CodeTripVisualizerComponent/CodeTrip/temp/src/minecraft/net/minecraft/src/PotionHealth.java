// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Potion

public class PotionHealth extends Potion
{

    public PotionHealth(int p_i3432_1_, boolean p_i3432_2_, int p_i3432_3_)
    {
        super(p_i3432_1_, p_i3432_2_, p_i3432_3_);
    }

    public boolean func_76403_b()
    {
        return true;
    }

    public boolean func_76397_a(int p_76397_1_, int p_76397_2_)
    {
        return p_76397_1_ >= 1;
    }
}
