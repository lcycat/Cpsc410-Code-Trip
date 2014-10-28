// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityAIBase, EntityAITasks

class EntityAITaskEntry
{

    public EntityAIBase field_75733_a;
    public int field_75731_b;
    final EntityAITasks field_75732_c; /* synthetic field */

    public EntityAITaskEntry(EntityAITasks p_i3468_1_, int p_i3468_2_, EntityAIBase p_i3468_3_)
    {
        field_75732_c = p_i3468_1_;
        super();
        field_75731_b = p_i3468_2_;
        field_75733_a = p_i3468_3_;
    }
}
