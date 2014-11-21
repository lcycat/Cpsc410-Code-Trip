// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            DamageSource, EntityPlayer, Entity, StatCollector, 
//            EntityLiving

public class EntityDamageSource extends DamageSource
{

    protected Entity field_76386_o;

    public EntityDamageSource(String p_i3430_1_, Entity p_i3430_2_)
    {
        super(p_i3430_1_);
        field_76386_o = p_i3430_2_;
    }

    public Entity func_76346_g()
    {
        return field_76386_o;
    }

    public String func_76360_b(EntityPlayer p_76360_1_)
    {
        return StatCollector.func_74837_a((new StringBuilder()).append("death.").append(field_76373_n).toString(), new Object[] {
            p_76360_1_.field_71092_bJ, field_76386_o.func_70023_ak()
        });
    }

    public boolean func_76350_n()
    {
        return field_76386_o != null && (field_76386_o instanceof EntityLiving) && !(field_76386_o instanceof EntityPlayer);
    }
}
