// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, World, Block

public class WorldGenLiquids extends WorldGenerator
{

    private int field_76537_a;

    public WorldGenLiquids(int p_i3799_1_)
    {
        field_76537_a = p_i3799_1_;
    }

    public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
    {
        if(p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_ + 1, p_76484_5_) != Block.field_71981_t.field_71990_ca)
        {
            return false;
        }
        if(p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_ - 1, p_76484_5_) != Block.field_71981_t.field_71990_ca)
        {
            return false;
        }
        if(p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_, p_76484_5_) != 0 && p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_, p_76484_5_) != Block.field_71981_t.field_71990_ca)
        {
            return false;
        }
        int i = 0;
        if(p_76484_1_.func_72798_a(p_76484_3_ - 1, p_76484_4_, p_76484_5_) == Block.field_71981_t.field_71990_ca)
        {
            i++;
        }
        if(p_76484_1_.func_72798_a(p_76484_3_ + 1, p_76484_4_, p_76484_5_) == Block.field_71981_t.field_71990_ca)
        {
            i++;
        }
        if(p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_, p_76484_5_ - 1) == Block.field_71981_t.field_71990_ca)
        {
            i++;
        }
        if(p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_, p_76484_5_ + 1) == Block.field_71981_t.field_71990_ca)
        {
            i++;
        }
        int j = 0;
        if(p_76484_1_.func_72799_c(p_76484_3_ - 1, p_76484_4_, p_76484_5_))
        {
            j++;
        }
        if(p_76484_1_.func_72799_c(p_76484_3_ + 1, p_76484_4_, p_76484_5_))
        {
            j++;
        }
        if(p_76484_1_.func_72799_c(p_76484_3_, p_76484_4_, p_76484_5_ - 1))
        {
            j++;
        }
        if(p_76484_1_.func_72799_c(p_76484_3_, p_76484_4_, p_76484_5_ + 1))
        {
            j++;
        }
        if(i == 3 && j == 1)
        {
            p_76484_1_.func_72859_e(p_76484_3_, p_76484_4_, p_76484_5_, field_76537_a);
            p_76484_1_.field_72999_e = true;
            Block.field_71973_m[field_76537_a].func_71847_b(p_76484_1_, p_76484_3_, p_76484_4_, p_76484_5_, p_76484_2_);
            p_76484_1_.field_72999_e = false;
        }
        return true;
    }
}
