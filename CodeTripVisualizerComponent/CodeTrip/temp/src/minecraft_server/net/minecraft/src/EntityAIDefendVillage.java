// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityAITarget, EntityIronGolem, Village, EntityLiving

public class EntityAIDefendVillage extends EntityAITarget
{

    EntityIronGolem field_75305_a;
    EntityLiving field_75304_b;

    public EntityAIDefendVillage(EntityIronGolem p_i3497_1_)
    {
        super(p_i3497_1_, 16F, false, true);
        field_75305_a = p_i3497_1_;
        func_75248_a(1);
    }

    public boolean func_75250_a()
    {
        Village village = field_75305_a.func_70852_n();
        if(village == null)
        {
            return false;
        } else
        {
            field_75304_b = village.func_75571_b(field_75305_a);
            return func_75296_a(field_75304_b, false);
        }
    }

    public void func_75249_e()
    {
        field_75305_a.func_70624_b(field_75304_b);
        super.func_75249_e();
    }
}
