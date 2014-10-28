// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            Entity, EntityPlayer, EntityLiving, MathHelper, 
//            DataWatcher, World, Block, Vec3, 
//            Vec3Pool, AxisAlignedBB, MovingObjectPosition, DamageSource, 
//            NBTTagCompound, PlayerCapabilities, ItemStack, Item, 
//            InventoryPlayer

public class EntityArrow extends Entity
{

    private int field_70247_d;
    private int field_70248_e;
    private int field_70245_f;
    private int field_70246_g;
    private int field_70253_h;
    private boolean field_70254_i;
    public int field_70251_a;
    public int field_70249_b;
    public Entity field_70250_c;
    private int field_70252_j;
    private int field_70257_an;
    private double field_70255_ao;
    private int field_70256_ap;

    public EntityArrow(World p_i3565_1_)
    {
        super(p_i3565_1_);
        field_70247_d = -1;
        field_70248_e = -1;
        field_70245_f = -1;
        field_70246_g = 0;
        field_70253_h = 0;
        field_70254_i = false;
        field_70251_a = 0;
        field_70249_b = 0;
        field_70257_an = 0;
        field_70255_ao = 2D;
        func_70105_a(0.5F, 0.5F);
    }

    public EntityArrow(World p_i3566_1_, double p_i3566_2_, double p_i3566_4_, double p_i3566_6_)
    {
        super(p_i3566_1_);
        field_70247_d = -1;
        field_70248_e = -1;
        field_70245_f = -1;
        field_70246_g = 0;
        field_70253_h = 0;
        field_70254_i = false;
        field_70251_a = 0;
        field_70249_b = 0;
        field_70257_an = 0;
        field_70255_ao = 2D;
        func_70105_a(0.5F, 0.5F);
        func_70107_b(p_i3566_2_, p_i3566_4_, p_i3566_6_);
        field_70129_M = 0.0F;
    }

    public EntityArrow(World p_i3567_1_, EntityLiving p_i3567_2_, EntityLiving p_i3567_3_, float p_i3567_4_, float p_i3567_5_)
    {
        super(p_i3567_1_);
        field_70247_d = -1;
        field_70248_e = -1;
        field_70245_f = -1;
        field_70246_g = 0;
        field_70253_h = 0;
        field_70254_i = false;
        field_70251_a = 0;
        field_70249_b = 0;
        field_70257_an = 0;
        field_70255_ao = 2D;
        field_70250_c = p_i3567_2_;
        if(p_i3567_2_ instanceof EntityPlayer)
        {
            field_70251_a = 1;
        }
        field_70163_u = (p_i3567_2_.field_70163_u + (double)p_i3567_2_.func_70047_e()) - 0.10000000149011612D;
        double d = p_i3567_3_.field_70165_t - p_i3567_2_.field_70165_t;
        double d1 = (p_i3567_3_.field_70163_u + (double)p_i3567_3_.func_70047_e()) - 0.69999998807907104D - field_70163_u;
        double d2 = p_i3567_3_.field_70161_v - p_i3567_2_.field_70161_v;
        double d3 = MathHelper.func_76133_a(d * d + d2 * d2);
        if(d3 < 9.9999999999999995E-008D)
        {
            return;
        } else
        {
            float f = (float)((Math.atan2(d2, d) * 180D) / 3.1415927410125732D) - 90F;
            float f1 = (float)(-((Math.atan2(d1, d3) * 180D) / 3.1415927410125732D));
            double d4 = d / d3;
            double d5 = d2 / d3;
            func_70012_b(p_i3567_2_.field_70165_t + d4, field_70163_u, p_i3567_2_.field_70161_v + d5, f, f1);
            field_70129_M = 0.0F;
            float f2 = (float)d3 * 0.2F;
            func_70244_c(d, d1 + (double)f2, d2, p_i3567_4_, p_i3567_5_);
            return;
        }
    }

    public EntityArrow(World p_i3568_1_, EntityLiving p_i3568_2_, float p_i3568_3_)
    {
        super(p_i3568_1_);
        field_70247_d = -1;
        field_70248_e = -1;
        field_70245_f = -1;
        field_70246_g = 0;
        field_70253_h = 0;
        field_70254_i = false;
        field_70251_a = 0;
        field_70249_b = 0;
        field_70257_an = 0;
        field_70255_ao = 2D;
        field_70250_c = p_i3568_2_;
        if(p_i3568_2_ instanceof EntityPlayer)
        {
            field_70251_a = 1;
        }
        func_70105_a(0.5F, 0.5F);
        func_70012_b(p_i3568_2_.field_70165_t, p_i3568_2_.field_70163_u + (double)p_i3568_2_.func_70047_e(), p_i3568_2_.field_70161_v, p_i3568_2_.field_70177_z, p_i3568_2_.field_70125_A);
        field_70165_t -= MathHelper.func_76134_b((field_70177_z / 180F) * 3.141593F) * 0.16F;
        field_70163_u -= 0.10000000149011612D;
        field_70161_v -= MathHelper.func_76126_a((field_70177_z / 180F) * 3.141593F) * 0.16F;
        func_70107_b(field_70165_t, field_70163_u, field_70161_v);
        field_70129_M = 0.0F;
        field_70159_w = -MathHelper.func_76126_a((field_70177_z / 180F) * 3.141593F) * MathHelper.func_76134_b((field_70125_A / 180F) * 3.141593F);
        field_70179_y = MathHelper.func_76134_b((field_70177_z / 180F) * 3.141593F) * MathHelper.func_76134_b((field_70125_A / 180F) * 3.141593F);
        field_70181_x = -MathHelper.func_76126_a((field_70125_A / 180F) * 3.141593F);
        func_70244_c(field_70159_w, field_70181_x, field_70179_y, p_i3568_3_ * 1.5F, 1.0F);
    }

    protected void func_70088_a()
    {
        field_70180_af.func_75682_a(16, Byte.valueOf((byte)0));
    }

    public void func_70244_c(double p_70244_1_, double p_70244_3_, double p_70244_5_, float p_70244_7_, 
            float p_70244_8_)
    {
        float f = MathHelper.func_76133_a(p_70244_1_ * p_70244_1_ + p_70244_3_ * p_70244_3_ + p_70244_5_ * p_70244_5_);
        p_70244_1_ /= f;
        p_70244_3_ /= f;
        p_70244_5_ /= f;
        p_70244_1_ += field_70146_Z.nextGaussian() * 0.0074999998323619366D * (double)p_70244_8_;
        p_70244_3_ += field_70146_Z.nextGaussian() * 0.0074999998323619366D * (double)p_70244_8_;
        p_70244_5_ += field_70146_Z.nextGaussian() * 0.0074999998323619366D * (double)p_70244_8_;
        p_70244_1_ *= p_70244_7_;
        p_70244_3_ *= p_70244_7_;
        p_70244_5_ *= p_70244_7_;
        field_70159_w = p_70244_1_;
        field_70181_x = p_70244_3_;
        field_70179_y = p_70244_5_;
        float f1 = MathHelper.func_76133_a(p_70244_1_ * p_70244_1_ + p_70244_5_ * p_70244_5_);
        field_70126_B = field_70177_z = (float)((Math.atan2(p_70244_1_, p_70244_5_) * 180D) / 3.1415927410125732D);
        field_70127_C = field_70125_A = (float)((Math.atan2(p_70244_3_, f1) * 180D) / 3.1415927410125732D);
        field_70252_j = 0;
    }

    public void func_70071_h_()
    {
        super.func_70071_h_();
        if(field_70127_C == 0.0F && field_70126_B == 0.0F)
        {
            float f = MathHelper.func_76133_a(field_70159_w * field_70159_w + field_70179_y * field_70179_y);
            field_70126_B = field_70177_z = (float)((Math.atan2(field_70159_w, field_70179_y) * 180D) / 3.1415927410125732D);
            field_70127_C = field_70125_A = (float)((Math.atan2(field_70181_x, f) * 180D) / 3.1415927410125732D);
        }
        int i = field_70170_p.func_72798_a(field_70247_d, field_70248_e, field_70245_f);
        if(i > 0)
        {
            Block.field_71973_m[i].func_71902_a(field_70170_p, field_70247_d, field_70248_e, field_70245_f);
            AxisAlignedBB axisalignedbb = Block.field_71973_m[i].func_71872_e(field_70170_p, field_70247_d, field_70248_e, field_70245_f);
            if(axisalignedbb != null && axisalignedbb.func_72318_a(Vec3.func_72437_a().func_72345_a(field_70165_t, field_70163_u, field_70161_v)))
            {
                field_70254_i = true;
            }
        }
        if(field_70249_b > 0)
        {
            field_70249_b--;
        }
        if(field_70254_i)
        {
            int j = field_70170_p.func_72798_a(field_70247_d, field_70248_e, field_70245_f);
            int k = field_70170_p.func_72805_g(field_70247_d, field_70248_e, field_70245_f);
            if(j != field_70246_g || k != field_70253_h)
            {
                field_70254_i = false;
                field_70159_w *= field_70146_Z.nextFloat() * 0.2F;
                field_70181_x *= field_70146_Z.nextFloat() * 0.2F;
                field_70179_y *= field_70146_Z.nextFloat() * 0.2F;
                field_70252_j = 0;
                field_70257_an = 0;
                return;
            }
            field_70252_j++;
            if(field_70252_j == 1200)
            {
                func_70106_y();
            }
            return;
        }
        field_70257_an++;
        Vec3 vec3 = Vec3.func_72437_a().func_72345_a(field_70165_t, field_70163_u, field_70161_v);
        Vec3 vec3_1 = Vec3.func_72437_a().func_72345_a(field_70165_t + field_70159_w, field_70163_u + field_70181_x, field_70161_v + field_70179_y);
        MovingObjectPosition movingobjectposition = field_70170_p.func_72831_a(vec3, vec3_1, false, true);
        vec3 = Vec3.func_72437_a().func_72345_a(field_70165_t, field_70163_u, field_70161_v);
        vec3_1 = Vec3.func_72437_a().func_72345_a(field_70165_t + field_70159_w, field_70163_u + field_70181_x, field_70161_v + field_70179_y);
        if(movingobjectposition != null)
        {
            vec3_1 = Vec3.func_72437_a().func_72345_a(movingobjectposition.field_72307_f.field_72450_a, movingobjectposition.field_72307_f.field_72448_b, movingobjectposition.field_72307_f.field_72449_c);
        }
        Entity entity = null;
        List list = field_70170_p.func_72839_b(this, field_70121_D.func_72321_a(field_70159_w, field_70181_x, field_70179_y).func_72314_b(1.0D, 1.0D, 1.0D));
        double d = 0.0D;
        Iterator iterator = list.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            Entity entity1 = (Entity)iterator.next();
            if(entity1.func_70067_L() && (entity1 != field_70250_c || field_70257_an >= 5))
            {
                float f5 = 0.3F;
                AxisAlignedBB axisalignedbb1 = entity1.field_70121_D.func_72314_b(f5, f5, f5);
                MovingObjectPosition movingobjectposition1 = axisalignedbb1.func_72327_a(vec3, vec3_1);
                if(movingobjectposition1 != null)
                {
                    double d1 = vec3.func_72438_d(movingobjectposition1.field_72307_f);
                    if(d1 < d || d == 0.0D)
                    {
                        entity = entity1;
                        d = d1;
                    }
                }
            }
        } while(true);
        if(entity != null)
        {
            movingobjectposition = new MovingObjectPosition(entity);
        }
        if(movingobjectposition != null)
        {
            if(movingobjectposition.field_72308_g != null)
            {
                float f1 = MathHelper.func_76133_a(field_70159_w * field_70159_w + field_70181_x * field_70181_x + field_70179_y * field_70179_y);
                int i1 = MathHelper.func_76143_f((double)f1 * field_70255_ao);
                if(func_70241_g())
                {
                    i1 += field_70146_Z.nextInt(i1 / 2 + 2);
                }
                DamageSource damagesource = null;
                if(field_70250_c == null)
                {
                    damagesource = DamageSource.func_76353_a(this, this);
                } else
                {
                    damagesource = DamageSource.func_76353_a(this, field_70250_c);
                }
                if(func_70027_ad())
                {
                    movingobjectposition.field_72308_g.func_70015_d(5);
                }
                if(movingobjectposition.field_72308_g.func_70097_a(damagesource, i1))
                {
                    if(movingobjectposition.field_72308_g instanceof EntityLiving)
                    {
                        ((EntityLiving)movingobjectposition.field_72308_g).field_70719_bd++;
                        if(field_70256_ap > 0)
                        {
                            float f7 = MathHelper.func_76133_a(field_70159_w * field_70159_w + field_70179_y * field_70179_y);
                            if(f7 > 0.0F)
                            {
                                movingobjectposition.field_72308_g.func_70024_g((field_70159_w * (double)field_70256_ap * 0.60000002384185791D) / (double)f7, 0.10000000000000001D, (field_70179_y * (double)field_70256_ap * 0.60000002384185791D) / (double)f7);
                            }
                        }
                    }
                    field_70170_p.func_72956_a(this, "random.bowhit", 1.0F, 1.2F / (field_70146_Z.nextFloat() * 0.2F + 0.9F));
                    func_70106_y();
                } else
                {
                    field_70159_w *= -0.10000000149011612D;
                    field_70181_x *= -0.10000000149011612D;
                    field_70179_y *= -0.10000000149011612D;
                    field_70177_z += 180F;
                    field_70126_B += 180F;
                    field_70257_an = 0;
                }
            } else
            {
                field_70247_d = movingobjectposition.field_72311_b;
                field_70248_e = movingobjectposition.field_72312_c;
                field_70245_f = movingobjectposition.field_72309_d;
                field_70246_g = field_70170_p.func_72798_a(field_70247_d, field_70248_e, field_70245_f);
                field_70253_h = field_70170_p.func_72805_g(field_70247_d, field_70248_e, field_70245_f);
                field_70159_w = (float)(movingobjectposition.field_72307_f.field_72450_a - field_70165_t);
                field_70181_x = (float)(movingobjectposition.field_72307_f.field_72448_b - field_70163_u);
                field_70179_y = (float)(movingobjectposition.field_72307_f.field_72449_c - field_70161_v);
                float f2 = MathHelper.func_76133_a(field_70159_w * field_70159_w + field_70181_x * field_70181_x + field_70179_y * field_70179_y);
                field_70165_t -= (field_70159_w / (double)f2) * 0.05000000074505806D;
                field_70163_u -= (field_70181_x / (double)f2) * 0.05000000074505806D;
                field_70161_v -= (field_70179_y / (double)f2) * 0.05000000074505806D;
                field_70170_p.func_72956_a(this, "random.bowhit", 1.0F, 1.2F / (field_70146_Z.nextFloat() * 0.2F + 0.9F));
                field_70254_i = true;
                field_70249_b = 7;
                func_70243_d(false);
            }
        }
        if(func_70241_g())
        {
            for(int l = 0; l < 4; l++)
            {
                field_70170_p.func_72869_a("crit", field_70165_t + (field_70159_w * (double)l) / 4D, field_70163_u + (field_70181_x * (double)l) / 4D, field_70161_v + (field_70179_y * (double)l) / 4D, -field_70159_w, -field_70181_x + 0.20000000000000001D, -field_70179_y);
            }

        }
        field_70165_t += field_70159_w;
        field_70163_u += field_70181_x;
        field_70161_v += field_70179_y;
        float f3 = MathHelper.func_76133_a(field_70159_w * field_70159_w + field_70179_y * field_70179_y);
        field_70177_z = (float)((Math.atan2(field_70159_w, field_70179_y) * 180D) / 3.1415927410125732D);
        for(field_70125_A = (float)((Math.atan2(field_70181_x, f3) * 180D) / 3.1415927410125732D); field_70125_A - field_70127_C < -180F; field_70127_C -= 360F) { }
        for(; field_70125_A - field_70127_C >= 180F; field_70127_C += 360F) { }
        for(; field_70177_z - field_70126_B < -180F; field_70126_B -= 360F) { }
        for(; field_70177_z - field_70126_B >= 180F; field_70126_B += 360F) { }
        field_70125_A = field_70127_C + (field_70125_A - field_70127_C) * 0.2F;
        field_70177_z = field_70126_B + (field_70177_z - field_70126_B) * 0.2F;
        float f4 = 0.99F;
        float f6 = 0.05F;
        if(func_70090_H())
        {
            for(int j1 = 0; j1 < 4; j1++)
            {
                float f8 = 0.25F;
                field_70170_p.func_72869_a("bubble", field_70165_t - field_70159_w * (double)f8, field_70163_u - field_70181_x * (double)f8, field_70161_v - field_70179_y * (double)f8, field_70159_w, field_70181_x, field_70179_y);
            }

            f4 = 0.8F;
        }
        field_70159_w *= f4;
        field_70181_x *= f4;
        field_70179_y *= f4;
        field_70181_x -= f6;
        func_70107_b(field_70165_t, field_70163_u, field_70161_v);
        func_70017_D();
    }

    public void func_70014_b(NBTTagCompound p_70014_1_)
    {
        p_70014_1_.func_74777_a("xTile", (short)field_70247_d);
        p_70014_1_.func_74777_a("yTile", (short)field_70248_e);
        p_70014_1_.func_74777_a("zTile", (short)field_70245_f);
        p_70014_1_.func_74774_a("inTile", (byte)field_70246_g);
        p_70014_1_.func_74774_a("inData", (byte)field_70253_h);
        p_70014_1_.func_74774_a("shake", (byte)field_70249_b);
        p_70014_1_.func_74774_a("inGround", (byte)(field_70254_i ? 1 : 0));
        p_70014_1_.func_74774_a("pickup", (byte)field_70251_a);
        p_70014_1_.func_74780_a("damage", field_70255_ao);
    }

    public void func_70037_a(NBTTagCompound p_70037_1_)
    {
        field_70247_d = p_70037_1_.func_74765_d("xTile");
        field_70248_e = p_70037_1_.func_74765_d("yTile");
        field_70245_f = p_70037_1_.func_74765_d("zTile");
        field_70246_g = p_70037_1_.func_74771_c("inTile") & 0xff;
        field_70253_h = p_70037_1_.func_74771_c("inData") & 0xff;
        field_70249_b = p_70037_1_.func_74771_c("shake") & 0xff;
        field_70254_i = p_70037_1_.func_74771_c("inGround") == 1;
        if(p_70037_1_.func_74764_b("damage"))
        {
            field_70255_ao = p_70037_1_.func_74769_h("damage");
        }
        if(p_70037_1_.func_74764_b("pickup"))
        {
            field_70251_a = p_70037_1_.func_74771_c("pickup");
        } else
        if(p_70037_1_.func_74764_b("player"))
        {
            field_70251_a = p_70037_1_.func_74767_n("player") ? 1 : 0;
        }
    }

    public void func_70100_b_(EntityPlayer p_70100_1_)
    {
        if(field_70170_p.field_72995_K || !field_70254_i || field_70249_b > 0)
        {
            return;
        }
        boolean flag = field_70251_a == 1 || field_70251_a == 2 && p_70100_1_.field_71075_bZ.field_75098_d;
        if(field_70251_a == 1 && !p_70100_1_.field_71071_by.func_70441_a(new ItemStack(Item.field_77704_l, 1)))
        {
            flag = false;
        }
        if(flag)
        {
            field_70170_p.func_72956_a(this, "random.pop", 0.2F, ((field_70146_Z.nextFloat() - field_70146_Z.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            p_70100_1_.func_71001_a(this, 1);
            func_70106_y();
        }
    }

    public void func_70239_b(double p_70239_1_)
    {
        field_70255_ao = p_70239_1_;
    }

    public double func_70242_d()
    {
        return field_70255_ao;
    }

    public void func_70240_a(int p_70240_1_)
    {
        field_70256_ap = p_70240_1_;
    }

    public boolean func_70075_an()
    {
        return false;
    }

    public void func_70243_d(boolean p_70243_1_)
    {
        byte byte0 = field_70180_af.func_75683_a(16);
        if(p_70243_1_)
        {
            field_70180_af.func_75692_b(16, Byte.valueOf((byte)(byte0 | 1)));
        } else
        {
            field_70180_af.func_75692_b(16, Byte.valueOf((byte)(byte0 & -2)));
        }
    }

    public boolean func_70241_g()
    {
        byte byte0 = field_70180_af.func_75683_a(16);
        return (byte0 & 1) != 0;
    }
}
