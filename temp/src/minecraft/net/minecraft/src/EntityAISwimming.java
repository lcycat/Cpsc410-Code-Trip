// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityAIBase, EntityLiving, PathNavigate, EntityJumpHelper

public class EntityAISwimming extends EntityAIBase
{

    private EntityLiving field_75373_a;

    public EntityAISwimming(EntityLiving p_i3465_1_)
    {
        field_75373_a = p_i3465_1_;
        func_75248_a(4);
        p_i3465_1_.func_70661_as().func_75495_e(true);
    }

    public boolean func_75250_a()
    {
        return field_75373_a.func_70090_H() || field_75373_a.func_70058_J();
    }

    public void func_75246_d()
    {
        if(field_75373_a.func_70681_au().nextFloat() < 0.8F)
        {
            field_75373_a.func_70683_ar().func_75660_a();
        }
    }
}
