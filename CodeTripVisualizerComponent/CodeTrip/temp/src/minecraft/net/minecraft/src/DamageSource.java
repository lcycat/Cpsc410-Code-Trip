// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityDamageSource, EntityDamageSourceIndirect, EntityPlayer, StatCollector, 
//            EntityLiving, EntityArrow, Entity, EntityFireball

public class DamageSource
{

    public static DamageSource field_76372_a = (new DamageSource("inFire")).func_76361_j();
    public static DamageSource field_76370_b = (new DamageSource("onFire")).func_76348_h().func_76361_j();
    public static DamageSource field_76371_c = (new DamageSource("lava")).func_76361_j();
    public static DamageSource field_76368_d = (new DamageSource("inWall")).func_76348_h();
    public static DamageSource field_76369_e = (new DamageSource("drown")).func_76348_h();
    public static DamageSource field_76366_f = (new DamageSource("starve")).func_76348_h();
    public static DamageSource field_76367_g = new DamageSource("cactus");
    public static DamageSource field_76379_h = (new DamageSource("fall")).func_76348_h();
    public static DamageSource field_76380_i = (new DamageSource("outOfWorld")).func_76348_h().func_76359_i();
    public static DamageSource field_76377_j = (new DamageSource("generic")).func_76348_h();
    public static DamageSource field_76378_k = (new DamageSource("explosion")).func_76351_m();
    public static DamageSource field_76375_l = new DamageSource("explosion");
    public static DamageSource field_76376_m = (new DamageSource("magic")).func_76348_h();
    private boolean field_76374_o;
    private boolean field_76385_p;
    private float field_76384_q;
    private boolean field_76383_r;
    private boolean field_76382_s;
    private boolean field_76381_t;
    public String field_76373_n;

    public static DamageSource func_76358_a(EntityLiving p_76358_0_)
    {
        return new EntityDamageSource("mob", p_76358_0_);
    }

    public static DamageSource func_76365_a(EntityPlayer p_76365_0_)
    {
        return new EntityDamageSource("player", p_76365_0_);
    }

    public static DamageSource func_76353_a(EntityArrow p_76353_0_, Entity p_76353_1_)
    {
        return (new EntityDamageSourceIndirect("arrow", p_76353_0_, p_76353_1_)).func_76349_b();
    }

    public static DamageSource func_76362_a(EntityFireball p_76362_0_, Entity p_76362_1_)
    {
        if(p_76362_1_ == null)
        {
            return (new EntityDamageSourceIndirect("onFire", p_76362_0_, p_76362_0_)).func_76361_j().func_76349_b();
        } else
        {
            return (new EntityDamageSourceIndirect("fireball", p_76362_0_, p_76362_1_)).func_76361_j().func_76349_b();
        }
    }

    public static DamageSource func_76356_a(Entity p_76356_0_, Entity p_76356_1_)
    {
        return (new EntityDamageSourceIndirect("thrown", p_76356_0_, p_76356_1_)).func_76349_b();
    }

    public static DamageSource func_76354_b(Entity p_76354_0_, Entity p_76354_1_)
    {
        return (new EntityDamageSourceIndirect("indirectMagic", p_76354_0_, p_76354_1_)).func_76348_h();
    }

    public boolean func_76352_a()
    {
        return field_76382_s;
    }

    public DamageSource func_76349_b()
    {
        field_76382_s = true;
        return this;
    }

    public boolean func_76363_c()
    {
        return field_76374_o;
    }

    public float func_76345_d()
    {
        return field_76384_q;
    }

    public boolean func_76357_e()
    {
        return field_76385_p;
    }

    protected DamageSource(String p_i3429_1_)
    {
        field_76374_o = false;
        field_76385_p = false;
        field_76384_q = 0.3F;
        field_76373_n = p_i3429_1_;
    }

    public Entity func_76364_f()
    {
        return func_76346_g();
    }

    public Entity func_76346_g()
    {
        return null;
    }

    protected DamageSource func_76348_h()
    {
        field_76374_o = true;
        field_76384_q = 0.0F;
        return this;
    }

    protected DamageSource func_76359_i()
    {
        field_76385_p = true;
        return this;
    }

    protected DamageSource func_76361_j()
    {
        field_76383_r = true;
        return this;
    }

    public String func_76360_b(EntityPlayer p_76360_1_)
    {
        return StatCollector.func_74837_a((new StringBuilder()).append("death.").append(field_76373_n).toString(), new Object[] {
            p_76360_1_.field_71092_bJ
        });
    }

    public boolean func_76347_k()
    {
        return field_76383_r;
    }

    public String func_76355_l()
    {
        return field_76373_n;
    }

    public DamageSource func_76351_m()
    {
        field_76381_t = true;
        return this;
    }

    public boolean func_76350_n()
    {
        return field_76381_t;
    }

}
