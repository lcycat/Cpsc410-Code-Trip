// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            StructureVillagePieceWeight, ComponentVillageHouse4_Garden, MathHelper, ComponentVillageChurch, 
//            ComponentVillageHouse1, ComponentVillageWoodHut, ComponentVillageHall, ComponentVillageField, 
//            ComponentVillageField2, ComponentVillageHouse2, ComponentVillageHouse3, ComponentVillageStartPiece, 
//            ComponentVillageTorch, StructureBoundingBox, StructureComponent, MapGenVillage, 
//            WorldChunkManager, ComponentVillagePathGen, ComponentVillage

public class StructureVillagePieces
{

    public static ArrayList func_75084_a(Random p_75084_0_, int p_75084_1_)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new StructureVillagePieceWeight(net.minecraft.src.ComponentVillageHouse4_Garden.class, 4, MathHelper.func_76136_a(p_75084_0_, 2 + p_75084_1_, 4 + p_75084_1_ * 2)));
        arraylist.add(new StructureVillagePieceWeight(net.minecraft.src.ComponentVillageChurch.class, 20, MathHelper.func_76136_a(p_75084_0_, 0 + p_75084_1_, 1 + p_75084_1_)));
        arraylist.add(new StructureVillagePieceWeight(net.minecraft.src.ComponentVillageHouse1.class, 20, MathHelper.func_76136_a(p_75084_0_, 0 + p_75084_1_, 2 + p_75084_1_)));
        arraylist.add(new StructureVillagePieceWeight(net.minecraft.src.ComponentVillageWoodHut.class, 3, MathHelper.func_76136_a(p_75084_0_, 2 + p_75084_1_, 5 + p_75084_1_ * 3)));
        arraylist.add(new StructureVillagePieceWeight(net.minecraft.src.ComponentVillageHall.class, 15, MathHelper.func_76136_a(p_75084_0_, 0 + p_75084_1_, 2 + p_75084_1_)));
        arraylist.add(new StructureVillagePieceWeight(net.minecraft.src.ComponentVillageField.class, 3, MathHelper.func_76136_a(p_75084_0_, 1 + p_75084_1_, 4 + p_75084_1_)));
        arraylist.add(new StructureVillagePieceWeight(net.minecraft.src.ComponentVillageField2.class, 3, MathHelper.func_76136_a(p_75084_0_, 2 + p_75084_1_, 4 + p_75084_1_ * 2)));
        arraylist.add(new StructureVillagePieceWeight(net.minecraft.src.ComponentVillageHouse2.class, 15, MathHelper.func_76136_a(p_75084_0_, 0, 1 + p_75084_1_)));
        arraylist.add(new StructureVillagePieceWeight(net.minecraft.src.ComponentVillageHouse3.class, 8, MathHelper.func_76136_a(p_75084_0_, 0 + p_75084_1_, 3 + p_75084_1_ * 2)));
        Iterator iterator = arraylist.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            if(((StructureVillagePieceWeight)iterator.next()).field_75087_d == 0)
            {
                iterator.remove();
            }
        } while(true);
        return arraylist;
    }

    private static int func_75079_a(List p_75079_0_)
    {
        boolean flag = false;
        int i = 0;
        for(Iterator iterator = p_75079_0_.iterator(); iterator.hasNext();)
        {
            StructureVillagePieceWeight structurevillagepieceweight = (StructureVillagePieceWeight)iterator.next();
            if(structurevillagepieceweight.field_75087_d > 0 && structurevillagepieceweight.field_75089_c < structurevillagepieceweight.field_75087_d)
            {
                flag = true;
            }
            i += structurevillagepieceweight.field_75088_b;
        }

        return flag ? i : -1;
    }

    private static ComponentVillage func_75083_a(ComponentVillageStartPiece p_75083_0_, StructureVillagePieceWeight p_75083_1_, List p_75083_2_, Random p_75083_3_, int p_75083_4_, int p_75083_5_, int p_75083_6_, int p_75083_7_, 
            int p_75083_8_)
    {
        Class class1 = p_75083_1_.field_75090_a;
        Object obj = null;
        if(class1 == (net.minecraft.src.ComponentVillageHouse4_Garden.class))
        {
            obj = ComponentVillageHouse4_Garden.func_74912_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        } else
        if(class1 == (net.minecraft.src.ComponentVillageChurch.class))
        {
            obj = ComponentVillageChurch.func_74919_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        } else
        if(class1 == (net.minecraft.src.ComponentVillageHouse1.class))
        {
            obj = ComponentVillageHouse1.func_74898_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        } else
        if(class1 == (net.minecraft.src.ComponentVillageWoodHut.class))
        {
            obj = ComponentVillageWoodHut.func_74908_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        } else
        if(class1 == (net.minecraft.src.ComponentVillageHall.class))
        {
            obj = ComponentVillageHall.func_74906_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        } else
        if(class1 == (net.minecraft.src.ComponentVillageField.class))
        {
            obj = ComponentVillageField.func_74900_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        } else
        if(class1 == (net.minecraft.src.ComponentVillageField2.class))
        {
            obj = ComponentVillageField2.func_74902_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        } else
        if(class1 == (net.minecraft.src.ComponentVillageHouse2.class))
        {
            obj = ComponentVillageHouse2.func_74915_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        } else
        if(class1 == (net.minecraft.src.ComponentVillageHouse3.class))
        {
            obj = ComponentVillageHouse3.func_74921_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        }
        return ((ComponentVillage) (obj));
    }

    private static ComponentVillage func_75081_c(ComponentVillageStartPiece p_75081_0_, List p_75081_1_, Random p_75081_2_, int p_75081_3_, int p_75081_4_, int p_75081_5_, int p_75081_6_, int p_75081_7_)
    {
        int i;
        int j;
        i = func_75079_a(p_75081_0_.field_74931_h);
        if(i <= 0)
        {
            return null;
        }
        j = 0;
_L2:
        int k;
        Iterator iterator;
        if(j >= 5)
        {
            break MISSING_BLOCK_LABEL_183;
        }
        j++;
        k = p_75081_2_.nextInt(i);
        iterator = p_75081_0_.field_74931_h.iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        StructureVillagePieceWeight structurevillagepieceweight;
        structurevillagepieceweight = (StructureVillagePieceWeight)iterator.next();
        k -= structurevillagepieceweight.field_75088_b;
        if(k >= 0) goto _L4; else goto _L3
_L3:
        if(structurevillagepieceweight.func_75085_a(p_75081_7_) && (structurevillagepieceweight != p_75081_0_.field_74926_d || p_75081_0_.field_74931_h.size() <= 1)) goto _L5; else goto _L2
_L5:
        ComponentVillage componentvillage = func_75083_a(p_75081_0_, structurevillagepieceweight, p_75081_1_, p_75081_2_, p_75081_3_, p_75081_4_, p_75081_5_, p_75081_6_, p_75081_7_);
        if(componentvillage == null) goto _L4; else goto _L6
_L6:
        structurevillagepieceweight.field_75089_c++;
        p_75081_0_.field_74926_d = structurevillagepieceweight;
        if(!structurevillagepieceweight.func_75086_a())
        {
            p_75081_0_.field_74931_h.remove(structurevillagepieceweight);
        }
        return componentvillage;
        StructureBoundingBox structureboundingbox = ComponentVillageTorch.func_74904_a(p_75081_0_, p_75081_1_, p_75081_2_, p_75081_3_, p_75081_4_, p_75081_5_, p_75081_6_);
        if(structureboundingbox != null)
        {
            return new ComponentVillageTorch(p_75081_0_, p_75081_7_, p_75081_2_, structureboundingbox, p_75081_6_);
        } else
        {
            return null;
        }
    }

    private static StructureComponent func_75077_d(ComponentVillageStartPiece p_75077_0_, List p_75077_1_, Random p_75077_2_, int p_75077_3_, int p_75077_4_, int p_75077_5_, int p_75077_6_, int p_75077_7_)
    {
        if(p_75077_7_ > 50)
        {
            return null;
        }
        if(Math.abs(p_75077_3_ - p_75077_0_.func_74874_b().field_78897_a) > 112 || Math.abs(p_75077_5_ - p_75077_0_.func_74874_b().field_78896_c) > 112)
        {
            return null;
        }
        ComponentVillage componentvillage = func_75081_c(p_75077_0_, p_75077_1_, p_75077_2_, p_75077_3_, p_75077_4_, p_75077_5_, p_75077_6_, p_75077_7_ + 1);
        if(componentvillage != null)
        {
            int i = (((StructureComponent) (componentvillage)).field_74887_e.field_78897_a + ((StructureComponent) (componentvillage)).field_74887_e.field_78893_d) / 2;
            int j = (((StructureComponent) (componentvillage)).field_74887_e.field_78896_c + ((StructureComponent) (componentvillage)).field_74887_e.field_78892_f) / 2;
            int k = ((StructureComponent) (componentvillage)).field_74887_e.field_78893_d - ((StructureComponent) (componentvillage)).field_74887_e.field_78897_a;
            int l = ((StructureComponent) (componentvillage)).field_74887_e.field_78892_f - ((StructureComponent) (componentvillage)).field_74887_e.field_78896_c;
            int i1 = k <= l ? l : k;
            if(p_75077_0_.func_74925_d().func_76940_a(i, j, i1 / 2 + 4, MapGenVillage.field_75055_e))
            {
                p_75077_1_.add(componentvillage);
                p_75077_0_.field_74932_i.add(componentvillage);
                return componentvillage;
            }
        }
        return null;
    }

    private static StructureComponent func_75080_e(ComponentVillageStartPiece p_75080_0_, List p_75080_1_, Random p_75080_2_, int p_75080_3_, int p_75080_4_, int p_75080_5_, int p_75080_6_, int p_75080_7_)
    {
        if(p_75080_7_ > 3 + p_75080_0_.field_74928_c)
        {
            return null;
        }
        if(Math.abs(p_75080_3_ - p_75080_0_.func_74874_b().field_78897_a) > 112 || Math.abs(p_75080_5_ - p_75080_0_.func_74874_b().field_78896_c) > 112)
        {
            return null;
        }
        StructureBoundingBox structureboundingbox = ComponentVillagePathGen.func_74933_a(p_75080_0_, p_75080_1_, p_75080_2_, p_75080_3_, p_75080_4_, p_75080_5_, p_75080_6_);
        if(structureboundingbox != null && structureboundingbox.field_78895_b > 10)
        {
            ComponentVillagePathGen componentvillagepathgen = new ComponentVillagePathGen(p_75080_0_, p_75080_7_, p_75080_2_, structureboundingbox, p_75080_6_);
            int i = (((StructureComponent) (componentvillagepathgen)).field_74887_e.field_78897_a + ((StructureComponent) (componentvillagepathgen)).field_74887_e.field_78893_d) / 2;
            int j = (((StructureComponent) (componentvillagepathgen)).field_74887_e.field_78896_c + ((StructureComponent) (componentvillagepathgen)).field_74887_e.field_78892_f) / 2;
            int k = ((StructureComponent) (componentvillagepathgen)).field_74887_e.field_78893_d - ((StructureComponent) (componentvillagepathgen)).field_74887_e.field_78897_a;
            int l = ((StructureComponent) (componentvillagepathgen)).field_74887_e.field_78892_f - ((StructureComponent) (componentvillagepathgen)).field_74887_e.field_78896_c;
            int i1 = k <= l ? l : k;
            if(p_75080_0_.func_74925_d().func_76940_a(i, j, i1 / 2 + 4, MapGenVillage.field_75055_e))
            {
                p_75080_1_.add(componentvillagepathgen);
                p_75080_0_.field_74930_j.add(componentvillagepathgen);
                return componentvillagepathgen;
            }
        }
        return null;
    }

    static StructureComponent func_75078_a(ComponentVillageStartPiece p_75078_0_, List p_75078_1_, Random p_75078_2_, int p_75078_3_, int p_75078_4_, int p_75078_5_, int p_75078_6_, int p_75078_7_)
    {
        return func_75077_d(p_75078_0_, p_75078_1_, p_75078_2_, p_75078_3_, p_75078_4_, p_75078_5_, p_75078_6_, p_75078_7_);
    }

    static StructureComponent func_75082_b(ComponentVillageStartPiece p_75082_0_, List p_75082_1_, Random p_75082_2_, int p_75082_3_, int p_75082_4_, int p_75082_5_, int p_75082_6_, int p_75082_7_)
    {
        return func_75080_e(p_75082_0_, p_75082_1_, p_75082_2_, p_75082_3_, p_75082_4_, p_75082_5_, p_75082_6_, p_75082_7_);
    }
}
