// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntitySpider, EntityLiving, World, PotionEffect, 
//            Potion, Entity

public class EntityCaveSpider extends EntitySpider
{

    public EntityCaveSpider(World p_i3546_1_)
    {
        super(p_i3546_1_);
        field_70750_az = "/mob/cavespider.png";
        func_70105_a(0.7F, 0.5F);
    }

    public int func_70667_aM()
    {
        return 12;
    }

    public boolean func_70652_k(Entity p_70652_1_)
    {
        if(super.func_70652_k(p_70652_1_))
        {
            if(p_70652_1_ instanceof EntityLiving)
            {
                byte byte0 = 0;
                if(field_70170_p.field_73013_u > 1)
                {
                    if(field_70170_p.field_73013_u == 2)
                    {
                        byte0 = 7;
                    } else
                    if(field_70170_p.field_73013_u == 3)
                    {
                        byte0 = 15;
                    }
                }
                if(byte0 > 0)
                {
                    ((EntityLiving)p_70652_1_).func_70690_d(new PotionEffect(Potion.field_76436_u.field_76415_H, byte0 * 20, 0));
                }
            }
            return true;
        } else
        {
            return false;
        }
    }
}
