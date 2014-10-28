// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityAIBase, EntityLiving, MathHelper, World, 
//            Block, BlockTallGrass, BlockGrass, PathNavigate

public class EntityAIEatGrass extends EntityAIBase
{

    private EntityLiving field_75363_b;
    private World field_75364_c;
    int field_75365_a;

    public EntityAIEatGrass(EntityLiving p_i3463_1_)
    {
        field_75365_a = 0;
        field_75363_b = p_i3463_1_;
        field_75364_c = p_i3463_1_.field_70170_p;
        func_75248_a(7);
    }

    public boolean func_75250_a()
    {
        if(field_75363_b.func_70681_au().nextInt(field_75363_b.func_70631_g_() ? 50 : 1000) != 0)
        {
            return false;
        }
        int i = MathHelper.func_76128_c(field_75363_b.field_70165_t);
        int j = MathHelper.func_76128_c(field_75363_b.field_70163_u);
        int k = MathHelper.func_76128_c(field_75363_b.field_70161_v);
        if(field_75364_c.func_72798_a(i, j, k) == Block.field_71962_X.field_71990_ca && field_75364_c.func_72805_g(i, j, k) == 1)
        {
            return true;
        }
        return field_75364_c.func_72798_a(i, j - 1, k) == Block.field_71980_u.field_71990_ca;
    }

    public void func_75249_e()
    {
        field_75365_a = 40;
        field_75364_c.func_72960_a(field_75363_b, (byte)10);
        field_75363_b.func_70661_as().func_75499_g();
    }

    public void func_75251_c()
    {
        field_75365_a = 0;
    }

    public boolean func_75253_b()
    {
        return field_75365_a > 0;
    }

    public int func_75362_f()
    {
        return field_75365_a;
    }

    public void func_75246_d()
    {
        field_75365_a = Math.max(0, field_75365_a - 1);
        if(field_75365_a != 4)
        {
            return;
        }
        int i = MathHelper.func_76128_c(field_75363_b.field_70165_t);
        int j = MathHelper.func_76128_c(field_75363_b.field_70163_u);
        int k = MathHelper.func_76128_c(field_75363_b.field_70161_v);
        if(field_75364_c.func_72798_a(i, j, k) == Block.field_71962_X.field_71990_ca)
        {
            field_75364_c.func_72926_e(2001, i, j, k, Block.field_71962_X.field_71990_ca + 4096);
            field_75364_c.func_72859_e(i, j, k, 0);
            field_75363_b.func_70615_aA();
        } else
        if(field_75364_c.func_72798_a(i, j - 1, k) == Block.field_71980_u.field_71990_ca)
        {
            field_75364_c.func_72926_e(2001, i, j - 1, k, Block.field_71980_u.field_71990_ca);
            field_75364_c.func_72859_e(i, j - 1, k, Block.field_71979_v.field_71990_ca);
            field_75363_b.func_70615_aA();
        }
    }
}
