// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityGolem, PathNavigate, EntityAIArrowAttack, EntityAITasks, 
//            EntityAIWander, EntityAIWatchClosest, EntityPlayer, EntityAILookIdle, 
//            EntityAINearestAttackableTarget, EntityMob, DamageSource, MathHelper, 
//            World, BiomeGenBase, Block, Item

public class EntitySnowman extends EntityGolem
{

    public EntitySnowman(World p_i3522_1_)
    {
        super(p_i3522_1_);
        field_70750_az = "/mob/snowman.png";
        func_70105_a(0.4F, 1.8F);
        func_70661_as().func_75491_a(true);
        field_70714_bg.func_75776_a(1, new EntityAIArrowAttack(this, 0.25F, 2, 20));
        field_70714_bg.func_75776_a(2, new EntityAIWander(this, 0.2F));
        field_70714_bg.func_75776_a(3, new EntityAIWatchClosest(this, net.minecraft.src.EntityPlayer.class, 6F));
        field_70714_bg.func_75776_a(4, new EntityAILookIdle(this));
        field_70715_bh.func_75776_a(1, new EntityAINearestAttackableTarget(this, net.minecraft.src.EntityMob.class, 16F, 0, true));
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
        if(func_70026_G())
        {
            func_70097_a(DamageSource.field_76369_e, 1);
        }
        int i = MathHelper.func_76128_c(field_70165_t);
        int k = MathHelper.func_76128_c(field_70161_v);
        if(field_70170_p.func_72807_a(i, k).func_76743_j() > 1.0F)
        {
            func_70097_a(DamageSource.field_76370_b, 1);
        }
        for(int j = 0; j < 4; j++)
        {
            int l = MathHelper.func_76128_c(field_70165_t + (double)((float)((j % 2) * 2 - 1) * 0.25F));
            int i1 = MathHelper.func_76128_c(field_70163_u);
            int j1 = MathHelper.func_76128_c(field_70161_v + (double)((float)(((j / 2) % 2) * 2 - 1) * 0.25F));
            if(field_70170_p.func_72798_a(l, i1, j1) == 0 && field_70170_p.func_72807_a(l, j1).func_76743_j() < 0.8F && Block.field_72037_aS.func_71930_b(field_70170_p, l, i1, j1))
            {
                field_70170_p.func_72859_e(l, i1, j1, Block.field_72037_aS.field_71990_ca);
            }
        }

    }

    protected int func_70633_aT()
    {
        return Item.field_77768_aD.field_77779_bT;
    }

    protected void func_70628_a(boolean p_70628_1_, int p_70628_2_)
    {
        int i = field_70146_Z.nextInt(16);
        for(int j = 0; j < i; j++)
        {
            func_70025_b(Item.field_77768_aD.field_77779_bT, 1);
        }

    }
}
