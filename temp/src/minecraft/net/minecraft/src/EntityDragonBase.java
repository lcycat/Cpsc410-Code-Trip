// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityLiving, World, EntityDragonPart, DamageSource

public class EntityDragonBase extends EntityLiving
{

    protected int field_70966_a;

    public EntityDragonBase(World p_i3527_1_)
    {
        super(p_i3527_1_);
        field_70966_a = 100;
    }

    public int func_70667_aM()
    {
        return field_70966_a;
    }

    public boolean func_70965_a(EntityDragonPart p_70965_1_, DamageSource p_70965_2_, int p_70965_3_)
    {
        return func_70097_a(p_70965_2_, p_70965_3_);
    }

    public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_)
    {
        return false;
    }

    protected boolean func_70964_e(DamageSource p_70964_1_, int p_70964_2_)
    {
        return super.func_70097_a(p_70964_1_, p_70964_2_);
    }
}
