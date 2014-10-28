// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityWaterMob, ItemStack, Item, AxisAlignedBB, 
//            Material, World, MathHelper

public class EntitySquid extends EntityWaterMob
{

    public float field_70861_d;
    public float field_70862_e;
    public float field_70859_f;
    public float field_70860_g;
    public float field_70867_h;
    public float field_70868_i;
    public float field_70866_j;
    public float field_70865_by;
    private float field_70863_bz;
    private float field_70864_bA;
    private float field_70871_bB;
    private float field_70872_bC;
    private float field_70869_bD;
    private float field_70870_bE;

    public EntitySquid(World p_i3523_1_)
    {
        super(p_i3523_1_);
        field_70861_d = 0.0F;
        field_70862_e = 0.0F;
        field_70859_f = 0.0F;
        field_70860_g = 0.0F;
        field_70867_h = 0.0F;
        field_70868_i = 0.0F;
        field_70866_j = 0.0F;
        field_70865_by = 0.0F;
        field_70863_bz = 0.0F;
        field_70864_bA = 0.0F;
        field_70871_bB = 0.0F;
        field_70872_bC = 0.0F;
        field_70869_bD = 0.0F;
        field_70870_bE = 0.0F;
        field_70750_az = "/mob/squid.png";
        func_70105_a(0.95F, 0.95F);
        field_70864_bA = (1.0F / (field_70146_Z.nextFloat() + 1.0F)) * 0.2F;
    }

    public int func_70667_aM()
    {
        return 10;
    }

    protected String func_70639_aQ()
    {
        return null;
    }

    protected String func_70621_aR()
    {
        return null;
    }

    protected String func_70673_aS()
    {
        return null;
    }

    protected float func_70599_aP()
    {
        return 0.4F;
    }

    protected int func_70633_aT()
    {
        return 0;
    }

    protected void func_70628_a(boolean p_70628_1_, int p_70628_2_)
    {
        int i = field_70146_Z.nextInt(3 + p_70628_2_) + 1;
        for(int j = 0; j < i; j++)
        {
            func_70099_a(new ItemStack(Item.field_77756_aW, 1, 0), 0.0F);
        }

    }

    public boolean func_70090_H()
    {
        return field_70170_p.func_72918_a(field_70121_D.func_72314_b(0.0D, -0.60000002384185791D, 0.0D), Material.field_76244_g, this);
    }

    public void func_70636_d()
    {
        super.func_70636_d();
        field_70862_e = field_70861_d;
        field_70860_g = field_70859_f;
        field_70868_i = field_70867_h;
        field_70865_by = field_70866_j;
        field_70867_h += field_70864_bA;
        if(field_70867_h > 6.283185F)
        {
            field_70867_h -= 6.283185F;
            if(field_70146_Z.nextInt(10) == 0)
            {
                field_70864_bA = (1.0F / (field_70146_Z.nextFloat() + 1.0F)) * 0.2F;
            }
        }
        if(func_70090_H())
        {
            if(field_70867_h < 3.141593F)
            {
                float f = field_70867_h / 3.141593F;
                field_70866_j = MathHelper.func_76126_a(f * f * 3.141593F) * 3.141593F * 0.25F;
                if((double)f > 0.75D)
                {
                    field_70863_bz = 1.0F;
                    field_70871_bB = 1.0F;
                } else
                {
                    field_70871_bB *= 0.8F;
                }
            } else
            {
                field_70866_j = 0.0F;
                field_70863_bz *= 0.9F;
                field_70871_bB *= 0.99F;
            }
            if(!field_70170_p.field_72995_K)
            {
                field_70159_w = field_70872_bC * field_70863_bz;
                field_70181_x = field_70869_bD * field_70863_bz;
                field_70179_y = field_70870_bE * field_70863_bz;
            }
            float f1 = MathHelper.func_76133_a(field_70159_w * field_70159_w + field_70179_y * field_70179_y);
            field_70761_aq += ((-(float)Math.atan2(field_70159_w, field_70179_y) * 180F) / 3.141593F - field_70761_aq) * 0.1F;
            field_70177_z = field_70761_aq;
            field_70859_f += 3.141593F * field_70871_bB * 1.5F;
            field_70861_d += ((-(float)Math.atan2(f1, field_70181_x) * 180F) / 3.141593F - field_70861_d) * 0.1F;
        } else
        {
            field_70866_j = MathHelper.func_76135_e(MathHelper.func_76126_a(field_70867_h)) * 3.141593F * 0.25F;
            if(!field_70170_p.field_72995_K)
            {
                field_70159_w = 0.0D;
                field_70181_x -= 0.080000000000000002D;
                field_70181_x *= 0.98000001907348633D;
                field_70179_y = 0.0D;
            }
            field_70861_d += (double)(-90F - field_70861_d) * 0.02D;
        }
    }

    public void func_70612_e(float p_70612_1_, float p_70612_2_)
    {
        func_70091_d(field_70159_w, field_70181_x, field_70179_y);
    }

    protected void func_70626_be()
    {
        field_70708_bq++;
        if(field_70708_bq > 100)
        {
            field_70872_bC = field_70869_bD = field_70870_bE = 0.0F;
        } else
        if(field_70146_Z.nextInt(50) == 0 || !field_70171_ac || field_70872_bC == 0.0F && field_70869_bD == 0.0F && field_70870_bE == 0.0F)
        {
            float f = field_70146_Z.nextFloat() * 3.141593F * 2.0F;
            field_70872_bC = MathHelper.func_76134_b(f) * 0.2F;
            field_70869_bD = -0.1F + field_70146_Z.nextFloat() * 0.2F;
            field_70870_bE = MathHelper.func_76126_a(f) * 0.2F;
        }
        func_70623_bb();
    }

    public boolean func_70601_bi()
    {
        return field_70163_u > 45D && field_70163_u < 63D && super.func_70601_bi();
    }
}
