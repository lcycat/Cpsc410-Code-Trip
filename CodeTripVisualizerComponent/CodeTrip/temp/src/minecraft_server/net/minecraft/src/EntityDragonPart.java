// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Entity, EntityDragonBase, NBTTagCompound, DamageSource

public class EntityDragonPart extends Entity
{

    public final EntityDragonBase field_70259_a;
    public final String field_70258_b;

    public EntityDragonPart(EntityDragonBase p_i3528_1_, String p_i3528_2_, float p_i3528_3_, float p_i3528_4_)
    {
        super(p_i3528_1_.field_70170_p);
        func_70105_a(p_i3528_3_, p_i3528_4_);
        field_70259_a = p_i3528_1_;
        field_70258_b = p_i3528_2_;
    }

    protected void func_70088_a()
    {
    }

    protected void func_70037_a(NBTTagCompound nbttagcompound)
    {
    }

    protected void func_70014_b(NBTTagCompound nbttagcompound)
    {
    }

    public boolean func_70067_L()
    {
        return true;
    }

    public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_)
    {
        return field_70259_a.func_70965_a(this, p_70097_1_, p_70097_2_);
    }

    public boolean func_70028_i(Entity p_70028_1_)
    {
        return this == p_70028_1_ || field_70259_a == p_70028_1_;
    }
}
