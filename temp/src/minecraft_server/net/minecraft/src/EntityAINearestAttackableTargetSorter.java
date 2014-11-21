// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Comparator;

// Referenced classes of package net.minecraft.src:
//            Entity, EntityAINearestAttackableTarget

public class EntityAINearestAttackableTargetSorter
    implements Comparator
{

    private Entity field_75459_b;
    final EntityAINearestAttackableTarget field_75460_a; /* synthetic field */

    public EntityAINearestAttackableTargetSorter(EntityAINearestAttackableTarget p_i3499_1_, Entity p_i3499_2_)
    {
        field_75460_a = p_i3499_1_;
        super();
        field_75459_b = p_i3499_2_;
    }

    public int func_75458_a(Entity p_75458_1_, Entity p_75458_2_)
    {
        double d = field_75459_b.func_70068_e(p_75458_1_);
        double d1 = field_75459_b.func_70068_e(p_75458_2_);
        if(d < d1)
        {
            return -1;
        }
        return d <= d1 ? 0 : 1;
    }

    public int compare(Object p_compare_1_, Object p_compare_2_)
    {
        return func_75458_a((Entity)p_compare_1_, (Entity)p_compare_2_);
    }
}
