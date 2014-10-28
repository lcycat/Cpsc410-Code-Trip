// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityAINearestAttackableTarget, EntityTameable

public class EntityAITargetNonTamed extends EntityAINearestAttackableTarget
{

    private EntityTameable field_75310_g;

    public EntityAITargetNonTamed(EntityTameable p_i3502_1_, Class p_i3502_2_, float p_i3502_3_, int p_i3502_4_, boolean p_i3502_5_)
    {
        super(p_i3502_1_, p_i3502_2_, p_i3502_3_, p_i3502_4_, p_i3502_5_);
        field_75310_g = p_i3502_1_;
    }

    public boolean func_75250_a()
    {
        if(field_75310_g.func_70909_n())
        {
            return false;
        } else
        {
            return super.func_75250_a();
        }
    }
}
