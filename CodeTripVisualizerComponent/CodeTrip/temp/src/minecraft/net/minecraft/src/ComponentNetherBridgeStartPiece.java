// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            ComponentNetherBridgeCrossing3, StructureNetherBridgePieces, StructureNetherBridgePieceWeight

public class ComponentNetherBridgeStartPiece extends ComponentNetherBridgeCrossing3
{

    public StructureNetherBridgePieceWeight field_74970_a;
    public List field_74968_b;
    public List field_74969_c;
    public ArrayList field_74967_d;

    public ComponentNetherBridgeStartPiece(Random p_i3831_1_, int p_i3831_2_, int p_i3831_3_)
    {
        super(p_i3831_1_, p_i3831_2_, p_i3831_3_);
        field_74967_d = new ArrayList();
        field_74968_b = new ArrayList();
        StructureNetherBridgePieceWeight astructurenetherbridgepieceweight[] = StructureNetherBridgePieces.func_78739_a();
        int i = astructurenetherbridgepieceweight.length;
        for(int j = 0; j < i; j++)
        {
            StructureNetherBridgePieceWeight structurenetherbridgepieceweight = astructurenetherbridgepieceweight[j];
            structurenetherbridgepieceweight.field_78827_c = 0;
            field_74968_b.add(structurenetherbridgepieceweight);
        }

        field_74969_c = new ArrayList();
        astructurenetherbridgepieceweight = StructureNetherBridgePieces.func_78737_b();
        i = astructurenetherbridgepieceweight.length;
        for(int k = 0; k < i; k++)
        {
            StructureNetherBridgePieceWeight structurenetherbridgepieceweight1 = astructurenetherbridgepieceweight[k];
            structurenetherbridgepieceweight1.field_78827_c = 0;
            field_74969_c.add(structurenetherbridgepieceweight1);
        }

    }
}
