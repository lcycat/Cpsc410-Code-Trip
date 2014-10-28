// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            TileEntity, Block, World, EntityPlayer

public class TileEntityEnderChest extends TileEntity
{

    public float field_70370_a;
    public float field_70368_b;
    public int field_70369_c;
    private int field_70367_d;

    public TileEntityEnderChest()
    {
    }

    public void func_70316_g()
    {
        super.func_70316_g();
        if((++field_70367_d % 20) * 4 == 0)
        {
            field_70331_k.func_72965_b(field_70329_l, field_70330_m, field_70327_n, Block.field_72066_bS.field_71990_ca, 1, field_70369_c);
        }
        field_70368_b = field_70370_a;
        float f = 0.1F;
        if(field_70369_c > 0 && field_70370_a == 0.0F)
        {
            double d = (double)field_70329_l + 0.5D;
            double d1 = (double)field_70327_n + 0.5D;
            field_70331_k.func_72908_a(d, (double)field_70330_m + 0.5D, d1, "random.chestopen", 0.5F, field_70331_k.field_73012_v.nextFloat() * 0.1F + 0.9F);
        }
        if(field_70369_c == 0 && field_70370_a > 0.0F || field_70369_c > 0 && field_70370_a < 1.0F)
        {
            float f1 = field_70370_a;
            if(field_70369_c > 0)
            {
                field_70370_a += f;
            } else
            {
                field_70370_a -= f;
            }
            if(field_70370_a > 1.0F)
            {
                field_70370_a = 1.0F;
            }
            float f2 = 0.5F;
            if(field_70370_a < f2 && f1 >= f2)
            {
                double d2 = (double)field_70329_l + 0.5D;
                double d3 = (double)field_70327_n + 0.5D;
                field_70331_k.func_72908_a(d2, (double)field_70330_m + 0.5D, d3, "random.chestclosed", 0.5F, field_70331_k.field_73012_v.nextFloat() * 0.1F + 0.9F);
            }
            if(field_70370_a < 0.0F)
            {
                field_70370_a = 0.0F;
            }
        }
    }

    public void func_70315_b(int p_70315_1_, int p_70315_2_)
    {
        if(p_70315_1_ == 1)
        {
            field_70369_c = p_70315_2_;
        }
    }

    public void func_70313_j()
    {
        func_70321_h();
        super.func_70313_j();
    }

    public void func_70364_a()
    {
        field_70369_c++;
        field_70331_k.func_72965_b(field_70329_l, field_70330_m, field_70327_n, Block.field_72066_bS.field_71990_ca, 1, field_70369_c);
    }

    public void func_70366_b()
    {
        field_70369_c--;
        field_70331_k.func_72965_b(field_70329_l, field_70330_m, field_70327_n, Block.field_72066_bS.field_71990_ca, 1, field_70369_c);
    }

    public boolean func_70365_a(EntityPlayer p_70365_1_)
    {
        if(field_70331_k.func_72796_p(field_70329_l, field_70330_m, field_70327_n) != this)
        {
            return false;
        }
        return p_70365_1_.func_70092_e((double)field_70329_l + 0.5D, (double)field_70330_m + 0.5D, (double)field_70327_n + 0.5D) <= 64D;
    }
}
