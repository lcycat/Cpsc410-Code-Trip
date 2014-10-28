// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityAIBase, EntityCreature, World, PathNavigate

public class EntityAIRestrictSun extends EntityAIBase
{

    private EntityCreature field_75273_a;

    public EntityAIRestrictSun(EntityCreature p_i3491_1_)
    {
        field_75273_a = p_i3491_1_;
    }

    public boolean func_75250_a()
    {
        return field_75273_a.field_70170_p.func_72935_r();
    }

    public void func_75249_e()
    {
        field_75273_a.func_70661_as().func_75504_d(true);
    }

    public void func_75251_c()
    {
        field_75273_a.func_70661_as().func_75504_d(false);
    }
}
