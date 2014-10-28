// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityAIBase, EntityCreature, Vec3, ChunkCoordinates, 
//            Vec3Pool, RandomPositionGenerator, PathNavigate

public class EntityAIMoveTwardsRestriction extends EntityAIBase
{

    private EntityCreature field_75436_a;
    private double field_75434_b;
    private double field_75435_c;
    private double field_75432_d;
    private float field_75433_e;

    public EntityAIMoveTwardsRestriction(EntityCreature p_i3480_1_, float p_i3480_2_)
    {
        field_75436_a = p_i3480_1_;
        field_75433_e = p_i3480_2_;
        func_75248_a(1);
    }

    public boolean func_75250_a()
    {
        if(field_75436_a.func_70611_aB())
        {
            return false;
        }
        ChunkCoordinates chunkcoordinates = field_75436_a.func_70602_aC();
        Vec3 vec3 = RandomPositionGenerator.func_75464_a(field_75436_a, 16, 7, Vec3.func_72437_a().func_72345_a(chunkcoordinates.field_71574_a, chunkcoordinates.field_71572_b, chunkcoordinates.field_71573_c));
        if(vec3 == null)
        {
            return false;
        } else
        {
            field_75434_b = vec3.field_72450_a;
            field_75435_c = vec3.field_72448_b;
            field_75432_d = vec3.field_72449_c;
            return true;
        }
    }

    public boolean func_75253_b()
    {
        return !field_75436_a.func_70661_as().func_75500_f();
    }

    public void func_75249_e()
    {
        field_75436_a.func_70661_as().func_75492_a(field_75434_b, field_75435_c, field_75432_d, field_75433_e);
    }
}
