// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityAIBase, EntityOcelot, PathNavigate, EntityAISit, 
//            World, Block, TileEntityChest, BlockBed

public class EntityAIOcelotSit extends EntityAIBase
{

    private final EntityOcelot field_75406_a;
    private final float field_75404_b;
    private int field_75405_c;
    private int field_75402_d;
    private int field_75403_e;
    private int field_75400_f;
    private int field_75401_g;
    private int field_75407_h;

    public EntityAIOcelotSit(EntityOcelot p_i3482_1_, float p_i3482_2_)
    {
        field_75405_c = 0;
        field_75402_d = 0;
        field_75403_e = 0;
        field_75400_f = 0;
        field_75401_g = 0;
        field_75407_h = 0;
        field_75406_a = p_i3482_1_;
        field_75404_b = p_i3482_2_;
        func_75248_a(5);
    }

    public boolean func_75250_a()
    {
        return field_75406_a.func_70909_n() && !field_75406_a.func_70906_o() && field_75406_a.func_70681_au().nextDouble() <= 0.0065000001341104507D && func_75399_f();
    }

    public boolean func_75253_b()
    {
        return field_75405_c <= field_75403_e && field_75402_d <= 60 && func_75398_a(field_75406_a.field_70170_p, field_75400_f, field_75401_g, field_75407_h);
    }

    public void func_75249_e()
    {
        field_75406_a.func_70661_as().func_75492_a((double)(float)field_75400_f + 0.5D, field_75401_g + 1, (double)(float)field_75407_h + 0.5D, field_75404_b);
        field_75405_c = 0;
        field_75402_d = 0;
        field_75403_e = field_75406_a.func_70681_au().nextInt(field_75406_a.func_70681_au().nextInt(1200) + 1200) + 1200;
        field_75406_a.func_70907_r().func_75270_a(false);
    }

    public void func_75251_c()
    {
        field_75406_a.func_70904_g(false);
    }

    public void func_75246_d()
    {
        field_75405_c++;
        field_75406_a.func_70907_r().func_75270_a(false);
        if(field_75406_a.func_70092_e(field_75400_f, field_75401_g + 1, field_75407_h) > 1.0D)
        {
            field_75406_a.func_70904_g(false);
            field_75406_a.func_70661_as().func_75492_a((double)(float)field_75400_f + 0.5D, field_75401_g + 1, (double)(float)field_75407_h + 0.5D, field_75404_b);
            field_75402_d++;
        } else
        if(!field_75406_a.func_70906_o())
        {
            field_75406_a.func_70904_g(true);
        } else
        {
            field_75402_d--;
        }
    }

    private boolean func_75399_f()
    {
        int i = (int)field_75406_a.field_70163_u;
        double d = 2147483647D;
        for(int j = (int)field_75406_a.field_70165_t - 8; (double)j < field_75406_a.field_70165_t + 8D; j++)
        {
            for(int k = (int)field_75406_a.field_70161_v - 8; (double)k < field_75406_a.field_70161_v + 8D; k++)
            {
                if(!func_75398_a(field_75406_a.field_70170_p, j, i, k) || !field_75406_a.field_70170_p.func_72799_c(j, i + 1, k))
                {
                    continue;
                }
                double d1 = field_75406_a.func_70092_e(j, i, k);
                if(d1 < d)
                {
                    field_75400_f = j;
                    field_75401_g = i;
                    field_75407_h = k;
                    d = d1;
                }
            }

        }

        return d < 2147483647D;
    }

    private boolean func_75398_a(World p_75398_1_, int p_75398_2_, int p_75398_3_, int p_75398_4_)
    {
        int i = p_75398_1_.func_72798_a(p_75398_2_, p_75398_3_, p_75398_4_);
        int j = p_75398_1_.func_72805_g(p_75398_2_, p_75398_3_, p_75398_4_);
        if(i == Block.field_72077_au.field_71990_ca)
        {
            TileEntityChest tileentitychest = (TileEntityChest)p_75398_1_.func_72796_p(p_75398_2_, p_75398_3_, p_75398_4_);
            if(tileentitychest.field_70427_h < 1)
            {
                return true;
            }
        } else
        {
            if(i == Block.field_72052_aC.field_71990_ca)
            {
                return true;
            }
            if(i == Block.field_71959_S.field_71990_ca && !BlockBed.func_72229_a_(j))
            {
                return true;
            }
        }
        return false;
    }
}
