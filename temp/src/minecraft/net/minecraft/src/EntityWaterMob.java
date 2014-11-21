// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityCreature, IAnimals, World, EntityPlayer

public abstract class EntityWaterMob extends EntityCreature
    implements IAnimals
{

    public EntityWaterMob(World p_i3525_1_)
    {
        super(p_i3525_1_);
    }

    public boolean func_70648_aU()
    {
        return true;
    }

    public boolean func_70601_bi()
    {
        return field_70170_p.func_72855_b(field_70121_D);
    }

    public int func_70627_aG()
    {
        return 120;
    }

    protected boolean func_70692_ba()
    {
        return true;
    }

    protected int func_70693_a(EntityPlayer p_70693_1_)
    {
        return 1 + field_70170_p.field_73012_v.nextInt(3);
    }
}
