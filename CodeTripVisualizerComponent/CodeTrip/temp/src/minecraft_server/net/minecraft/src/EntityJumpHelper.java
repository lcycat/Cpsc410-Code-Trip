// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityLiving

public class EntityJumpHelper
{

    private EntityLiving field_75663_a;
    private boolean field_75662_b;

    public EntityJumpHelper(EntityLiving p_i3454_1_)
    {
        field_75662_b = false;
        field_75663_a = p_i3454_1_;
    }

    public void func_75660_a()
    {
        field_75662_b = true;
    }

    public void func_75661_b()
    {
        field_75663_a.func_70637_d(field_75662_b);
        field_75662_b = false;
    }
}
