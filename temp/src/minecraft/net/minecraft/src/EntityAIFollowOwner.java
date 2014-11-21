// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityAIBase, EntityTameable, PathNavigate, EntityLookHelper, 
//            EntityLiving, MathHelper, AxisAlignedBB, World

public class EntityAIFollowOwner extends EntityAIBase
{

    private EntityTameable field_75338_d;
    private EntityLiving field_75339_e;
    World field_75342_a;
    private float field_75336_f;
    private PathNavigate field_75337_g;
    private int field_75343_h;
    float field_75340_b;
    float field_75341_c;
    private boolean field_75344_i;

    public EntityAIFollowOwner(EntityTameable p_i3466_1_, float p_i3466_2_, float p_i3466_3_, float p_i3466_4_)
    {
        field_75338_d = p_i3466_1_;
        field_75342_a = p_i3466_1_.field_70170_p;
        field_75336_f = p_i3466_2_;
        field_75337_g = p_i3466_1_.func_70661_as();
        field_75341_c = p_i3466_3_;
        field_75340_b = p_i3466_4_;
        func_75248_a(3);
    }

    public boolean func_75250_a()
    {
        EntityLiving entityliving = field_75338_d.func_70902_q();
        if(entityliving == null)
        {
            return false;
        }
        if(field_75338_d.func_70906_o())
        {
            return false;
        }
        if(field_75338_d.func_70068_e(entityliving) < (double)(field_75341_c * field_75341_c))
        {
            return false;
        } else
        {
            field_75339_e = entityliving;
            return true;
        }
    }

    public boolean func_75253_b()
    {
        return !field_75337_g.func_75500_f() && field_75338_d.func_70068_e(field_75339_e) > (double)(field_75340_b * field_75340_b) && !field_75338_d.func_70906_o();
    }

    public void func_75249_e()
    {
        field_75343_h = 0;
        field_75344_i = field_75338_d.func_70661_as().func_75486_a();
        field_75338_d.func_70661_as().func_75491_a(false);
    }

    public void func_75251_c()
    {
        field_75339_e = null;
        field_75337_g.func_75499_g();
        field_75338_d.func_70661_as().func_75491_a(field_75344_i);
    }

    public void func_75246_d()
    {
        field_75338_d.func_70671_ap().func_75651_a(field_75339_e, 10F, field_75338_d.func_70646_bf());
        if(field_75338_d.func_70906_o())
        {
            return;
        }
        if(--field_75343_h > 0)
        {
            return;
        }
        field_75343_h = 10;
        if(field_75337_g.func_75497_a(field_75339_e, field_75336_f))
        {
            return;
        }
        if(field_75338_d.func_70068_e(field_75339_e) < 144D)
        {
            return;
        }
        int i = MathHelper.func_76128_c(field_75339_e.field_70165_t) - 2;
        int j = MathHelper.func_76128_c(field_75339_e.field_70161_v) - 2;
        int k = MathHelper.func_76128_c(field_75339_e.field_70121_D.field_72338_b);
        for(int l = 0; l <= 4; l++)
        {
            for(int i1 = 0; i1 <= 4; i1++)
            {
                if((l < 1 || i1 < 1 || l > 3 || i1 > 3) && field_75342_a.func_72797_t(i + l, k - 1, j + i1) && !field_75342_a.func_72809_s(i + l, k, j + i1) && !field_75342_a.func_72809_s(i + l, k + 1, j + i1))
                {
                    field_75338_d.func_70012_b((float)(i + l) + 0.5F, k, (float)(j + i1) + 0.5F, field_75338_d.field_70177_z, field_75338_d.field_70125_A);
                    field_75337_g.func_75499_g();
                    return;
                }
            }

        }

    }
}
