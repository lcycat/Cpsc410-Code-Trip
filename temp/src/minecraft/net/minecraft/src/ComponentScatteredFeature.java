// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            StructureComponent, StructureBoundingBox, World, WorldProvider

abstract class ComponentScatteredFeature extends StructureComponent
{

    protected final int field_74939_a;
    protected final int field_74937_b;
    protected final int field_74938_c;
    protected int field_74936_d;

    protected ComponentScatteredFeature(Random p_i3836_1_, int p_i3836_2_, int p_i3836_3_, int p_i3836_4_, int p_i3836_5_, int p_i3836_6_, int p_i3836_7_)
    {
        super(0);
        field_74936_d = -1;
        field_74939_a = p_i3836_5_;
        field_74937_b = p_i3836_6_;
        field_74938_c = p_i3836_7_;
        field_74885_f = p_i3836_1_.nextInt(4);
        switch(field_74885_f)
        {
        case 0: // '\0'
        case 2: // '\002'
            field_74887_e = new StructureBoundingBox(p_i3836_2_, p_i3836_3_, p_i3836_4_, (p_i3836_2_ + p_i3836_5_) - 1, (p_i3836_3_ + p_i3836_6_) - 1, (p_i3836_4_ + p_i3836_7_) - 1);
            break;

        default:
            field_74887_e = new StructureBoundingBox(p_i3836_2_, p_i3836_3_, p_i3836_4_, (p_i3836_2_ + p_i3836_7_) - 1, (p_i3836_3_ + p_i3836_6_) - 1, (p_i3836_4_ + p_i3836_5_) - 1);
            break;
        }
    }

    protected boolean func_74935_a(World p_74935_1_, StructureBoundingBox p_74935_2_, int p_74935_3_)
    {
        if(field_74936_d >= 0)
        {
            return true;
        }
        int i = 0;
        int j = 0;
        for(int k = field_74887_e.field_78896_c; k <= field_74887_e.field_78892_f; k++)
        {
            for(int l = field_74887_e.field_78897_a; l <= field_74887_e.field_78893_d; l++)
            {
                if(p_74935_2_.func_78890_b(l, 64, k))
                {
                    i += Math.max(p_74935_1_.func_72825_h(l, k), p_74935_1_.field_73011_w.func_76557_i());
                    j++;
                }
            }

        }

        if(j == 0)
        {
            return false;
        } else
        {
            field_74936_d = i / j;
            field_74887_e.func_78886_a(0, (field_74936_d - field_74887_e.field_78895_b) + p_74935_3_, 0);
            return true;
        }
    }
}
