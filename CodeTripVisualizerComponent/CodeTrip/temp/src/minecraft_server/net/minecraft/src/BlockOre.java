// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, CreativeTabs, Item, 
//            World, MathHelper

public class BlockOre extends Block
{

    public BlockOre(int p_i3978_1_, int p_i3978_2_)
    {
        super(p_i3978_1_, p_i3978_2_, Material.field_76246_e);
        func_71849_a(CreativeTabs.field_78030_b);
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        if(field_71990_ca == Block.field_71950_I.field_71990_ca)
        {
            return Item.field_77705_m.field_77779_bT;
        }
        if(field_71990_ca == Block.field_72073_aw.field_71990_ca)
        {
            return Item.field_77702_n.field_77779_bT;
        }
        if(field_71990_ca == Block.field_71947_N.field_71990_ca)
        {
            return Item.field_77756_aW.field_77779_bT;
        }
        if(field_71990_ca == Block.field_72068_bR.field_71990_ca)
        {
            return Item.field_77817_bH.field_77779_bT;
        } else
        {
            return field_71990_ca;
        }
    }

    public int func_71925_a(Random p_71925_1_)
    {
        if(field_71990_ca == Block.field_71947_N.field_71990_ca)
        {
            return 4 + p_71925_1_.nextInt(5);
        } else
        {
            return 1;
        }
    }

    public int func_71910_a(int p_71910_1_, Random p_71910_2_)
    {
        if(p_71910_1_ > 0 && field_71990_ca != func_71885_a(0, p_71910_2_, p_71910_1_))
        {
            int i = p_71910_2_.nextInt(p_71910_1_ + 2) - 1;
            if(i < 0)
            {
                i = 0;
            }
            return func_71925_a(p_71910_2_) * (i + 1);
        } else
        {
            return func_71925_a(p_71910_2_);
        }
    }

    public void func_71914_a(World p_71914_1_, int p_71914_2_, int p_71914_3_, int p_71914_4_, int p_71914_5_, float p_71914_6_, int p_71914_7_)
    {
        super.func_71914_a(p_71914_1_, p_71914_2_, p_71914_3_, p_71914_4_, p_71914_5_, p_71914_6_, p_71914_7_);
        if(func_71885_a(p_71914_5_, p_71914_1_.field_73012_v, p_71914_7_) != field_71990_ca)
        {
            int i = 0;
            if(field_71990_ca == Block.field_71950_I.field_71990_ca)
            {
                i = MathHelper.func_76136_a(p_71914_1_.field_73012_v, 0, 2);
            } else
            if(field_71990_ca == Block.field_72073_aw.field_71990_ca)
            {
                i = MathHelper.func_76136_a(p_71914_1_.field_73012_v, 3, 7);
            } else
            if(field_71990_ca == Block.field_72068_bR.field_71990_ca)
            {
                i = MathHelper.func_76136_a(p_71914_1_.field_73012_v, 3, 7);
            } else
            if(field_71990_ca == Block.field_71947_N.field_71990_ca)
            {
                i = MathHelper.func_76136_a(p_71914_1_.field_73012_v, 2, 5);
            }
            func_71923_g(p_71914_1_, p_71914_2_, p_71914_3_, p_71914_4_, i);
        }
    }

    protected int func_71899_b(int p_71899_1_)
    {
        return field_71990_ca != Block.field_71947_N.field_71990_ca ? 0 : 4;
    }
}
