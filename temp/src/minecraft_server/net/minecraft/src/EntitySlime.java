// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityLiving, IMob, DataWatcher, NBTTagCompound, 
//            World, MathHelper, AxisAlignedBB, DamageSource, 
//            EntityPlayer, Item, WorldInfo, WorldType, 
//            Chunk

public class EntitySlime extends EntityLiving
    implements IMob
{

    public float field_70813_a;
    public float field_70811_b;
    public float field_70812_c;
    private int field_70810_d;

    public EntitySlime(World p_i3556_1_)
    {
        super(p_i3556_1_);
        field_70810_d = 0;
        field_70750_az = "/mob/slime.png";
        int i = 1 << field_70146_Z.nextInt(3);
        field_70129_M = 0.0F;
        field_70810_d = field_70146_Z.nextInt(20) + 10;
        func_70799_a(i);
    }

    protected void func_70088_a()
    {
        super.func_70088_a();
        field_70180_af.func_75682_a(16, new Byte((byte)1));
    }

    public void func_70799_a(int p_70799_1_)
    {
        field_70180_af.func_75692_b(16, new Byte((byte)p_70799_1_));
        func_70105_a(0.6F * (float)p_70799_1_, 0.6F * (float)p_70799_1_);
        func_70107_b(field_70165_t, field_70163_u, field_70161_v);
        func_70606_j(func_70667_aM());
        field_70728_aV = p_70799_1_;
    }

    public int func_70667_aM()
    {
        int i = func_70809_q();
        return i * i;
    }

    public int func_70809_q()
    {
        return field_70180_af.func_75683_a(16);
    }

    public void func_70014_b(NBTTagCompound p_70014_1_)
    {
        super.func_70014_b(p_70014_1_);
        p_70014_1_.func_74768_a("Size", func_70809_q() - 1);
    }

    public void func_70037_a(NBTTagCompound p_70037_1_)
    {
        super.func_70037_a(p_70037_1_);
        func_70799_a(p_70037_1_.func_74762_e("Size") + 1);
    }

    protected String func_70801_i()
    {
        return "slime";
    }

    protected String func_70803_o()
    {
        return "mob.slime";
    }

    public void func_70071_h_()
    {
        if(!field_70170_p.field_72995_K && field_70170_p.field_73013_u == 0 && func_70809_q() > 0)
        {
            field_70128_L = true;
        }
        field_70811_b += (field_70813_a - field_70811_b) * 0.5F;
        field_70812_c = field_70811_b;
        boolean flag = field_70122_E;
        super.func_70071_h_();
        if(field_70122_E && !flag)
        {
            int i = func_70809_q();
            for(int j = 0; j < i * 8; j++)
            {
                float f = field_70146_Z.nextFloat() * 3.141593F * 2.0F;
                float f1 = field_70146_Z.nextFloat() * 0.5F + 0.5F;
                float f2 = MathHelper.func_76126_a(f) * (float)i * 0.5F * f1;
                float f3 = MathHelper.func_76134_b(f) * (float)i * 0.5F * f1;
                field_70170_p.func_72869_a(func_70801_i(), field_70165_t + (double)f2, field_70121_D.field_72338_b, field_70161_v + (double)f3, 0.0D, 0.0D, 0.0D);
            }

            if(func_70804_p())
            {
                field_70170_p.func_72956_a(this, func_70803_o(), func_70599_aP(), ((field_70146_Z.nextFloat() - field_70146_Z.nextFloat()) * 0.2F + 1.0F) / 0.8F);
            }
            field_70813_a = -0.5F;
        } else
        if(!field_70122_E && flag)
        {
            field_70813_a = 1.0F;
        }
        func_70808_l();
    }

    protected void func_70626_be()
    {
        func_70623_bb();
        EntityPlayer entityplayer = field_70170_p.func_72856_b(this, 16D);
        if(entityplayer != null)
        {
            func_70625_a(entityplayer, 10F, 20F);
        }
        if(field_70122_E && field_70810_d-- <= 0)
        {
            field_70810_d = func_70806_k();
            if(entityplayer != null)
            {
                field_70810_d /= 3;
            }
            field_70703_bu = true;
            if(func_70807_r())
            {
                field_70170_p.func_72956_a(this, func_70803_o(), func_70599_aP(), ((field_70146_Z.nextFloat() - field_70146_Z.nextFloat()) * 0.2F + 1.0F) * 0.8F);
            }
            field_70702_br = 1.0F - field_70146_Z.nextFloat() * 2.0F;
            field_70701_bs = 1 * func_70809_q();
        } else
        {
            field_70703_bu = false;
            if(field_70122_E)
            {
                field_70702_br = field_70701_bs = 0.0F;
            }
        }
    }

    protected void func_70808_l()
    {
        field_70813_a *= 0.6F;
    }

    protected int func_70806_k()
    {
        return field_70146_Z.nextInt(20) + 10;
    }

    protected EntitySlime func_70802_j()
    {
        return new EntitySlime(field_70170_p);
    }

    public void func_70106_y()
    {
        int i = func_70809_q();
        if(!field_70170_p.field_72995_K && i > 1 && func_70630_aN() <= 0)
        {
            int j = 2 + field_70146_Z.nextInt(3);
            for(int k = 0; k < j; k++)
            {
                float f = (((float)(k % 2) - 0.5F) * (float)i) / 4F;
                float f1 = (((float)(k / 2) - 0.5F) * (float)i) / 4F;
                EntitySlime entityslime = func_70802_j();
                entityslime.func_70799_a(i / 2);
                entityslime.func_70012_b(field_70165_t + (double)f, field_70163_u + 0.5D, field_70161_v + (double)f1, field_70146_Z.nextFloat() * 360F, 0.0F);
                field_70170_p.func_72838_d(entityslime);
            }

        }
        super.func_70106_y();
    }

    public void func_70100_b_(EntityPlayer p_70100_1_)
    {
        if(func_70800_m())
        {
            int i = func_70809_q();
            if(func_70685_l(p_70100_1_) && func_70068_e(p_70100_1_) < 0.59999999999999998D * (double)i * (0.59999999999999998D * (double)i) && p_70100_1_.func_70097_a(DamageSource.func_76358_a(this), func_70805_n()))
            {
                field_70170_p.func_72956_a(this, "mob.slimeattack", 1.0F, (field_70146_Z.nextFloat() - field_70146_Z.nextFloat()) * 0.2F + 1.0F);
            }
        }
    }

    protected boolean func_70800_m()
    {
        return func_70809_q() > 1;
    }

    protected int func_70805_n()
    {
        return func_70809_q();
    }

    protected String func_70621_aR()
    {
        return "mob.slime";
    }

    protected String func_70673_aS()
    {
        return "mob.slime";
    }

    protected int func_70633_aT()
    {
        if(func_70809_q() == 1)
        {
            return Item.field_77761_aM.field_77779_bT;
        } else
        {
            return 0;
        }
    }

    public boolean func_70601_bi()
    {
        Chunk chunk = field_70170_p.func_72938_d(MathHelper.func_76128_c(field_70165_t), MathHelper.func_76128_c(field_70161_v));
        if(field_70170_p.func_72912_H().func_76067_t() == WorldType.field_77138_c && field_70146_Z.nextInt(4) != 1)
        {
            return false;
        }
        if((func_70809_q() == 1 || field_70170_p.field_73013_u > 0) && field_70146_Z.nextInt(10) == 0 && chunk.func_76617_a(0x3ad8025fL).nextInt(10) == 0 && field_70163_u < 40D)
        {
            return super.func_70601_bi();
        } else
        {
            return false;
        }
    }

    protected float func_70599_aP()
    {
        return 0.4F * (float)func_70809_q();
    }

    public int func_70646_bf()
    {
        return 0;
    }

    protected boolean func_70807_r()
    {
        return func_70809_q() > 1;
    }

    protected boolean func_70804_p()
    {
        return func_70809_q() > 2;
    }
}
