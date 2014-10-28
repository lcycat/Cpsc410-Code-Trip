// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EnumMovingObjectType, Vec3, Vec3Pool, Entity

public class MovingObjectPosition
{

    public EnumMovingObjectType field_72313_a;
    public int field_72311_b;
    public int field_72312_c;
    public int field_72309_d;
    public int field_72310_e;
    public Vec3 field_72307_f;
    public Entity field_72308_g;

    public MovingObjectPosition(int p_i4032_1_, int p_i4032_2_, int p_i4032_3_, int p_i4032_4_, Vec3 p_i4032_5_)
    {
        field_72313_a = EnumMovingObjectType.TILE;
        field_72311_b = p_i4032_1_;
        field_72312_c = p_i4032_2_;
        field_72309_d = p_i4032_3_;
        field_72310_e = p_i4032_4_;
        field_72307_f = Vec3.func_72437_a().func_72345_a(p_i4032_5_.field_72450_a, p_i4032_5_.field_72448_b, p_i4032_5_.field_72449_c);
    }

    public MovingObjectPosition(Entity p_i4033_1_)
    {
        field_72313_a = EnumMovingObjectType.ENTITY;
        field_72308_g = p_i4033_1_;
        field_72307_f = Vec3.func_72437_a().func_72345_a(p_i4033_1_.field_70165_t, p_i4033_1_.field_70163_u, p_i4033_1_.field_70161_v);
    }
}
