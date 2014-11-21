// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentVillageWell, WorldChunkManager, BiomeGenBase, StructureVillagePieceWeight

public class ComponentVillageStartPiece extends ComponentVillageWell
{

    public final WorldChunkManager field_74929_a;
    public final boolean field_74927_b;
    public final int field_74928_c;
    public StructureVillagePieceWeight field_74926_d;
    public ArrayList field_74931_h;
    public ArrayList field_74932_i;
    public ArrayList field_74930_j;

    public ComponentVillageStartPiece(WorldChunkManager p_i3870_1_, int p_i3870_2_, Random p_i3870_3_, int p_i3870_4_, int p_i3870_5_, ArrayList p_i3870_6_, int p_i3870_7_)
    {
        super(null, 0, p_i3870_3_, p_i3870_4_, p_i3870_5_);
        field_74932_i = new ArrayList();
        field_74930_j = new ArrayList();
        field_74929_a = p_i3870_1_;
        field_74931_h = p_i3870_6_;
        field_74928_c = p_i3870_7_;
        BiomeGenBase biomegenbase = p_i3870_1_.func_76935_a(p_i3870_4_, p_i3870_5_);
        field_74927_b = biomegenbase == BiomeGenBase.field_76769_d || biomegenbase == BiomeGenBase.field_76786_s;
        field_74897_k = this;
    }

    public WorldChunkManager func_74925_d()
    {
        return field_74929_a;
    }
}
