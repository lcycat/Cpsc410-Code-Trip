// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityAIBase, EntityLiving, PathNavigate, PathEntity, 
//            PathPoint, MathHelper, World, Block, 
//            BlockDoor

public abstract class EntityAIDoorInteract extends EntityAIBase
{

    protected EntityLiving field_75356_a;
    protected int field_75354_b;
    protected int field_75355_c;
    protected int field_75352_d;
    protected BlockDoor field_75353_e;
    boolean field_75350_f;
    float field_75351_g;
    float field_75357_h;

    public EntityAIDoorInteract(EntityLiving p_i3462_1_)
    {
        field_75356_a = p_i3462_1_;
    }

    public boolean func_75250_a()
    {
        if(!field_75356_a.field_70123_F)
        {
            return false;
        }
        PathNavigate pathnavigate = field_75356_a.func_70661_as();
        PathEntity pathentity = pathnavigate.func_75505_d();
        if(pathentity == null || pathentity.func_75879_b() || !pathnavigate.func_75507_c())
        {
            return false;
        }
        for(int i = 0; i < Math.min(pathentity.func_75873_e() + 2, pathentity.func_75874_d()); i++)
        {
            PathPoint pathpoint = pathentity.func_75877_a(i);
            field_75354_b = pathpoint.field_75839_a;
            field_75355_c = pathpoint.field_75837_b + 1;
            field_75352_d = pathpoint.field_75838_c;
            if(field_75356_a.func_70092_e(field_75354_b, field_75356_a.field_70163_u, field_75352_d) > 2.25D)
            {
                continue;
            }
            field_75353_e = func_75349_a(field_75354_b, field_75355_c, field_75352_d);
            if(field_75353_e != null)
            {
                return true;
            }
        }

        field_75354_b = MathHelper.func_76128_c(field_75356_a.field_70165_t);
        field_75355_c = MathHelper.func_76128_c(field_75356_a.field_70163_u + 1.0D);
        field_75352_d = MathHelper.func_76128_c(field_75356_a.field_70161_v);
        field_75353_e = func_75349_a(field_75354_b, field_75355_c, field_75352_d);
        return field_75353_e != null;
    }

    public boolean func_75253_b()
    {
        return !field_75350_f;
    }

    public void func_75249_e()
    {
        field_75350_f = false;
        field_75351_g = (float)((double)((float)field_75354_b + 0.5F) - field_75356_a.field_70165_t);
        field_75357_h = (float)((double)((float)field_75352_d + 0.5F) - field_75356_a.field_70161_v);
    }

    public void func_75246_d()
    {
        float f = (float)((double)((float)field_75354_b + 0.5F) - field_75356_a.field_70165_t);
        float f1 = (float)((double)((float)field_75352_d + 0.5F) - field_75356_a.field_70161_v);
        float f2 = field_75351_g * f + field_75357_h * f1;
        if(f2 < 0.0F)
        {
            field_75350_f = true;
        }
    }

    private BlockDoor func_75349_a(int p_75349_1_, int p_75349_2_, int p_75349_3_)
    {
        int i = field_75356_a.field_70170_p.func_72798_a(p_75349_1_, p_75349_2_, p_75349_3_);
        if(i != Block.field_72054_aE.field_71990_ca)
        {
            return null;
        } else
        {
            return (BlockDoor)Block.field_71973_m[i];
        }
    }
}
