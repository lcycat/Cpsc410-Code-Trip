// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.LinkedList;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            StructureStart, World, BiomeGenBase, ComponentScatteredFeatureJunglePyramid, 
//            ComponentScatteredFeatureDesertPyramid

public class StructureScatteredFeatureStart extends StructureStart
{

    public StructureScatteredFeatureStart(World p_i3832_1_, Random p_i3832_2_, int p_i3832_3_, int p_i3832_4_)
    {
        if(p_i3832_1_.func_72807_a(p_i3832_3_ * 16 + 8, p_i3832_4_ * 16 + 8) == BiomeGenBase.field_76782_w)
        {
            ComponentScatteredFeatureJunglePyramid componentscatteredfeaturejunglepyramid = new ComponentScatteredFeatureJunglePyramid(p_i3832_2_, p_i3832_3_ * 16, p_i3832_4_ * 16);
            field_75075_a.add(componentscatteredfeaturejunglepyramid);
        } else
        {
            ComponentScatteredFeatureDesertPyramid componentscatteredfeaturedesertpyramid = new ComponentScatteredFeatureDesertPyramid(p_i3832_2_, p_i3832_3_ * 16, p_i3832_4_ * 16);
            field_75075_a.add(componentscatteredfeaturedesertpyramid);
        }
        func_75072_c();
    }
}
