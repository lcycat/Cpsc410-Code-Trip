// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityMob, World

public class EntityGiantZombie extends EntityMob
{

    public EntityGiantZombie(World p_i3550_1_)
    {
        super(p_i3550_1_);
        field_70750_az = "/mob/zombie.png";
        field_70697_bw = 0.5F;
        field_70815_f = 50;
        field_70129_M *= 6F;
        func_70105_a(field_70130_N * 6F, field_70131_O * 6F);
    }

    public int func_70667_aM()
    {
        return 100;
    }

    public float func_70783_a(int p_70783_1_, int p_70783_2_, int p_70783_3_)
    {
        return field_70170_p.func_72801_o(p_70783_1_, p_70783_2_, p_70783_3_) - 0.5F;
    }
}
