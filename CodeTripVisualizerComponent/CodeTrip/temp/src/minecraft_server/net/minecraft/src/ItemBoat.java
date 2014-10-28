// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            Item, CreativeTabs, EntityPlayer, Vec3, 
//            Vec3Pool, MathHelper, World, AxisAlignedBB, 
//            Entity, MovingObjectPosition, EnumMovingObjectType, Block, 
//            EntityBoat, PlayerCapabilities, ItemStack

public class ItemBoat extends Item
{

    public ItemBoat(int p_i3621_1_)
    {
        super(p_i3621_1_);
        field_77777_bU = 1;
        func_77637_a(CreativeTabs.field_78029_e);
    }

    public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
        float f = 1.0F;
        float f1 = p_77659_3_.field_70127_C + (p_77659_3_.field_70125_A - p_77659_3_.field_70127_C) * f;
        float f2 = p_77659_3_.field_70126_B + (p_77659_3_.field_70177_z - p_77659_3_.field_70126_B) * f;
        double d = p_77659_3_.field_70169_q + (p_77659_3_.field_70165_t - p_77659_3_.field_70169_q) * (double)f;
        double d1 = (p_77659_3_.field_70167_r + (p_77659_3_.field_70163_u - p_77659_3_.field_70167_r) * (double)f + 1.6200000000000001D) - (double)p_77659_3_.field_70129_M;
        double d2 = p_77659_3_.field_70166_s + (p_77659_3_.field_70161_v - p_77659_3_.field_70166_s) * (double)f;
        Vec3 vec3 = Vec3.func_72437_a().func_72345_a(d, d1, d2);
        float f3 = MathHelper.func_76134_b(-f2 * 0.01745329F - 3.141593F);
        float f4 = MathHelper.func_76126_a(-f2 * 0.01745329F - 3.141593F);
        float f5 = -MathHelper.func_76134_b(-f1 * 0.01745329F);
        float f6 = MathHelper.func_76126_a(-f1 * 0.01745329F);
        float f7 = f4 * f5;
        float f8 = f6;
        float f9 = f3 * f5;
        double d3 = 5D;
        Vec3 vec3_1 = vec3.func_72441_c((double)f7 * d3, (double)f8 * d3, (double)f9 * d3);
        MovingObjectPosition movingobjectposition = p_77659_2_.func_72901_a(vec3, vec3_1, true);
        if(movingobjectposition == null)
        {
            return p_77659_1_;
        }
        Vec3 vec3_2 = p_77659_3_.func_70676_i(f);
        boolean flag = false;
        float f10 = 1.0F;
        List list = p_77659_2_.func_72839_b(p_77659_3_, p_77659_3_.field_70121_D.func_72321_a(vec3_2.field_72450_a * d3, vec3_2.field_72448_b * d3, vec3_2.field_72449_c * d3).func_72314_b(f10, f10, f10));
        Iterator iterator = list.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            Entity entity = (Entity)iterator.next();
            if(entity.func_70067_L())
            {
                float f11 = entity.func_70111_Y();
                AxisAlignedBB axisalignedbb = entity.field_70121_D.func_72314_b(f11, f11, f11);
                if(axisalignedbb.func_72318_a(vec3))
                {
                    flag = true;
                }
            }
        } while(true);
        if(flag)
        {
            return p_77659_1_;
        }
        if(movingobjectposition.field_72313_a == EnumMovingObjectType.TILE)
        {
            int i = movingobjectposition.field_72311_b;
            int j = movingobjectposition.field_72312_c;
            int k = movingobjectposition.field_72309_d;
            if(!p_77659_2_.field_72995_K)
            {
                if(p_77659_2_.func_72798_a(i, j, k) == Block.field_72037_aS.field_71990_ca)
                {
                    j--;
                }
                p_77659_2_.func_72838_d(new EntityBoat(p_77659_2_, (float)i + 0.5F, (float)j + 1.0F, (float)k + 0.5F));
            }
            if(!p_77659_3_.field_71075_bZ.field_75098_d)
            {
                p_77659_1_.field_77994_a--;
            }
        }
        return p_77659_1_;
    }
}
