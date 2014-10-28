// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityDamageSource, EntityPlayer, Entity, StatCollector

public class EntityDamageSourceIndirect extends EntityDamageSource
{

    private Entity field_76387_p;

    public EntityDamageSourceIndirect(String p_i3431_1_, Entity p_i3431_2_, Entity p_i3431_3_)
    {
        super(p_i3431_1_, p_i3431_2_);
        field_76387_p = p_i3431_3_;
    }

    public Entity func_76364_f()
    {
        return field_76386_o;
    }

    public Entity func_76346_g()
    {
        return field_76387_p;
    }

    public String func_76360_b(EntityPlayer p_76360_1_)
    {
        return StatCollector.func_74837_a((new StringBuilder()).append("death.").append(field_76373_n).toString(), new Object[] {
            p_76360_1_.field_71092_bJ, field_76387_p.func_70023_ak()
        });
    }
}
