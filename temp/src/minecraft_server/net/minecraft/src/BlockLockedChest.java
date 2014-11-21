// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, World

public class BlockLockedChest extends Block
{

    protected BlockLockedChest(int p_i3967_1_)
    {
        super(p_i3967_1_, Material.field_76245_d);
        field_72059_bZ = 26;
    }

    public int func_71851_a(int p_71851_1_)
    {
        if(p_71851_1_ == 1)
        {
            return field_72059_bZ - 1;
        }
        if(p_71851_1_ == 0)
        {
            return field_72059_bZ - 1;
        }
        if(p_71851_1_ == 3)
        {
            return field_72059_bZ + 1;
        } else
        {
            return field_72059_bZ;
        }
    }

    public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int i)
    {
        return true;
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_)
    {
        p_71847_1_.func_72859_e(p_71847_2_, p_71847_3_, p_71847_4_, 0);
    }
}
