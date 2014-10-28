// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            TileEntity, Block, BlockPistonMoving, World, 
//            Entity, Facing, NBTTagCompound

public class TileEntityPiston extends TileEntity
{

    private int field_70348_a;
    private int field_70346_b;
    private int field_70347_c;
    private boolean field_70344_d;
    private boolean field_70345_e;
    private float field_70342_f;
    private float field_70343_g;
    private List field_70349_h;

    public TileEntityPiston()
    {
        field_70349_h = new ArrayList();
    }

    public TileEntityPiston(int p_i4028_1_, int p_i4028_2_, int p_i4028_3_, boolean p_i4028_4_, boolean p_i4028_5_)
    {
        field_70349_h = new ArrayList();
        field_70348_a = p_i4028_1_;
        field_70346_b = p_i4028_2_;
        field_70347_c = p_i4028_3_;
        field_70344_d = p_i4028_4_;
        field_70345_e = p_i4028_5_;
    }

    public int func_70340_a()
    {
        return field_70348_a;
    }

    public int func_70322_n()
    {
        return field_70346_b;
    }

    public boolean func_70341_b()
    {
        return field_70344_d;
    }

    public int func_70336_c()
    {
        return field_70347_c;
    }

    public float func_70333_a(float p_70333_1_)
    {
        if(p_70333_1_ > 1.0F)
        {
            p_70333_1_ = 1.0F;
        }
        return field_70343_g + (field_70342_f - field_70343_g) * p_70333_1_;
    }

    private void func_70335_a(float p_70335_1_, float p_70335_2_)
    {
        if(field_70344_d)
        {
            p_70335_1_ = 1.0F - p_70335_1_;
        } else
        {
            p_70335_1_--;
        }
        AxisAlignedBB axisalignedbb = Block.field_72095_ac.func_72296_b(field_70331_k, field_70329_l, field_70330_m, field_70327_n, field_70348_a, p_70335_1_, field_70347_c);
        if(axisalignedbb != null)
        {
            List list = field_70331_k.func_72839_b(null, axisalignedbb);
            if(!list.isEmpty())
            {
                field_70349_h.addAll(list);
                Entity entity;
                for(Iterator iterator = field_70349_h.iterator(); iterator.hasNext(); entity.func_70091_d(p_70335_2_ * (float)Facing.field_71586_b[field_70347_c], p_70335_2_ * (float)Facing.field_71587_c[field_70347_c], p_70335_2_ * (float)Facing.field_71585_d[field_70347_c]))
                {
                    entity = (Entity)iterator.next();
                }

                field_70349_h.clear();
            }
        }
    }

    public void func_70339_i()
    {
        if(field_70343_g < 1.0F && field_70331_k != null)
        {
            field_70343_g = field_70342_f = 1.0F;
            field_70331_k.func_72932_q(field_70329_l, field_70330_m, field_70327_n);
            func_70313_j();
            if(field_70331_k.func_72798_a(field_70329_l, field_70330_m, field_70327_n) == Block.field_72095_ac.field_71990_ca)
            {
                field_70331_k.func_72832_d(field_70329_l, field_70330_m, field_70327_n, field_70348_a, field_70346_b);
            }
        }
    }

    public void func_70316_g()
    {
        field_70343_g = field_70342_f;
        if(field_70343_g >= 1.0F)
        {
            func_70335_a(1.0F, 0.25F);
            field_70331_k.func_72932_q(field_70329_l, field_70330_m, field_70327_n);
            func_70313_j();
            if(field_70331_k.func_72798_a(field_70329_l, field_70330_m, field_70327_n) == Block.field_72095_ac.field_71990_ca)
            {
                field_70331_k.func_72832_d(field_70329_l, field_70330_m, field_70327_n, field_70348_a, field_70346_b);
            }
            return;
        }
        field_70342_f += 0.5F;
        if(field_70342_f >= 1.0F)
        {
            field_70342_f = 1.0F;
        }
        if(field_70344_d)
        {
            func_70335_a(field_70342_f, (field_70342_f - field_70343_g) + 0.0625F);
        }
    }

    public void func_70307_a(NBTTagCompound p_70307_1_)
    {
        super.func_70307_a(p_70307_1_);
        field_70348_a = p_70307_1_.func_74762_e("blockId");
        field_70346_b = p_70307_1_.func_74762_e("blockData");
        field_70347_c = p_70307_1_.func_74762_e("facing");
        field_70343_g = field_70342_f = p_70307_1_.func_74760_g("progress");
        field_70344_d = p_70307_1_.func_74767_n("extending");
    }

    public void func_70310_b(NBTTagCompound p_70310_1_)
    {
        super.func_70310_b(p_70310_1_);
        p_70310_1_.func_74768_a("blockId", field_70348_a);
        p_70310_1_.func_74768_a("blockData", field_70346_b);
        p_70310_1_.func_74768_a("facing", field_70347_c);
        p_70310_1_.func_74776_a("progress", field_70343_g);
        p_70310_1_.func_74757_a("extending", field_70344_d);
    }
}
