// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityAnimal, EntityAISwimming, EntityAITasks, EntityAIPanic, 
//            EntityAIMate, EntityAITempt, Item, EntityAIFollowParent, 
//            EntityAIWander, EntityAIWatchClosest, EntityPlayer, EntityAILookIdle, 
//            World

public class EntityChicken extends EntityAnimal
{

    public boolean field_70885_d;
    public float field_70886_e;
    public float field_70883_f;
    public float field_70884_g;
    public float field_70888_h;
    public float field_70889_i;
    public int field_70887_j;

    public EntityChicken(World p_i3515_1_)
    {
        super(p_i3515_1_);
        field_70885_d = false;
        field_70886_e = 0.0F;
        field_70883_f = 0.0F;
        field_70889_i = 1.0F;
        field_70750_az = "/mob/chicken.png";
        func_70105_a(0.3F, 0.7F);
        field_70887_j = field_70146_Z.nextInt(6000) + 6000;
        float f = 0.25F;
        field_70714_bg.func_75776_a(0, new EntityAISwimming(this));
        field_70714_bg.func_75776_a(1, new EntityAIPanic(this, 0.38F));
        field_70714_bg.func_75776_a(2, new EntityAIMate(this, f));
        field_70714_bg.func_75776_a(3, new EntityAITempt(this, 0.25F, Item.field_77685_T.field_77779_bT, false));
        field_70714_bg.func_75776_a(4, new EntityAIFollowParent(this, 0.28F));
        field_70714_bg.func_75776_a(5, new EntityAIWander(this, f));
        field_70714_bg.func_75776_a(6, new EntityAIWatchClosest(this, net.minecraft.src.EntityPlayer.class, 6F));
        field_70714_bg.func_75776_a(7, new EntityAILookIdle(this));
    }

    public boolean func_70650_aV()
    {
        return true;
    }

    public int func_70667_aM()
    {
        return 4;
    }

    public void func_70636_d()
    {
        super.func_70636_d();
        field_70888_h = field_70886_e;
        field_70884_g = field_70883_f;
        field_70883_f += (double)(field_70122_E ? -1 : 4) * 0.29999999999999999D;
        if(field_70883_f < 0.0F)
        {
            field_70883_f = 0.0F;
        }
        if(field_70883_f > 1.0F)
        {
            field_70883_f = 1.0F;
        }
        if(!field_70122_E && field_70889_i < 1.0F)
        {
            field_70889_i = 1.0F;
        }
        field_70889_i *= 0.90000000000000002D;
        if(!field_70122_E && field_70181_x < 0.0D)
        {
            field_70181_x *= 0.59999999999999998D;
        }
        field_70886_e += field_70889_i * 2.0F;
        if(!func_70631_g_() && !field_70170_p.field_72995_K && --field_70887_j <= 0)
        {
            field_70170_p.func_72956_a(this, "mob.chickenplop", 1.0F, (field_70146_Z.nextFloat() - field_70146_Z.nextFloat()) * 0.2F + 1.0F);
            func_70025_b(Item.field_77764_aP.field_77779_bT, 1);
            field_70887_j = field_70146_Z.nextInt(6000) + 6000;
        }
    }

    protected void func_70069_a(float f)
    {
    }

    protected String func_70639_aQ()
    {
        return "mob.chicken";
    }

    protected String func_70621_aR()
    {
        return "mob.chickenhurt";
    }

    protected String func_70673_aS()
    {
        return "mob.chickenhurt";
    }

    protected int func_70633_aT()
    {
        return Item.field_77676_L.field_77779_bT;
    }

    protected void func_70628_a(boolean p_70628_1_, int p_70628_2_)
    {
        int i = field_70146_Z.nextInt(3) + field_70146_Z.nextInt(1 + p_70628_2_);
        for(int j = 0; j < i; j++)
        {
            func_70025_b(Item.field_77676_L.field_77779_bT, 1);
        }

        if(func_70027_ad())
        {
            func_70025_b(Item.field_77736_bl.field_77779_bT, 1);
        } else
        {
            func_70025_b(Item.field_77735_bk.field_77779_bT, 1);
        }
    }

    public EntityAnimal func_70879_a(EntityAnimal p_70879_1_)
    {
        return new EntityChicken(field_70170_p);
    }
}
