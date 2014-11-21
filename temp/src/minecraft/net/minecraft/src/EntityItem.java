// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            Entity, AxisAlignedBB, MathHelper, World, 
//            Material, Block, ItemStack, Item, 
//            DamageSource, NBTTagCompound, EntityPlayer, InventoryPlayer, 
//            AchievementList, ModLoader, StatCollector

public class EntityItem extends Entity
{

    public ItemStack field_70294_a;
    public int field_70292_b;
    public int field_70293_c;
    private int field_70291_e;
    public float field_70290_d;

    public EntityItem(World p_i3539_1_, double p_i3539_2_, double p_i3539_4_, double p_i3539_6_, 
            ItemStack p_i3539_8_)
    {
        super(p_i3539_1_);
        field_70292_b = 0;
        field_70291_e = 5;
        field_70290_d = (float)(Math.random() * 3.1415926535897931D * 2D);
        func_70105_a(0.25F, 0.25F);
        field_70129_M = field_70131_O / 2.0F;
        func_70107_b(p_i3539_2_, p_i3539_4_, p_i3539_6_);
        field_70294_a = p_i3539_8_;
        field_70177_z = (float)(Math.random() * 360D);
        field_70159_w = (float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D);
        field_70181_x = 0.20000000298023224D;
        field_70179_y = (float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D);
    }

    protected boolean func_70041_e_()
    {
        return false;
    }

    public EntityItem(World p_i3540_1_)
    {
        super(p_i3540_1_);
        field_70292_b = 0;
        field_70291_e = 5;
        field_70290_d = (float)(Math.random() * 3.1415926535897931D * 2D);
        func_70105_a(0.25F, 0.25F);
        field_70129_M = field_70131_O / 2.0F;
    }

    protected void func_70088_a()
    {
    }

    public void func_70071_h_()
    {
        super.func_70071_h_();
        if(field_70293_c > 0)
        {
            field_70293_c--;
        }
        field_70169_q = field_70165_t;
        field_70167_r = field_70163_u;
        field_70166_s = field_70161_v;
        field_70181_x -= 0.039999999105930328D;
        func_70048_i(field_70165_t, (field_70121_D.field_72338_b + field_70121_D.field_72337_e) / 2D, field_70161_v);
        func_70091_d(field_70159_w, field_70181_x, field_70179_y);
        boolean flag = (int)field_70169_q != (int)field_70165_t || (int)field_70167_r != (int)field_70163_u || (int)field_70166_s != (int)field_70161_v;
        if(flag)
        {
            if(field_70170_p.func_72803_f(MathHelper.func_76128_c(field_70165_t), MathHelper.func_76128_c(field_70163_u), MathHelper.func_76128_c(field_70161_v)) == Material.field_76256_h)
            {
                field_70181_x = 0.20000000298023224D;
                field_70159_w = (field_70146_Z.nextFloat() - field_70146_Z.nextFloat()) * 0.2F;
                field_70179_y = (field_70146_Z.nextFloat() - field_70146_Z.nextFloat()) * 0.2F;
                field_70170_p.func_72956_a(this, "random.fizz", 0.4F, 2.0F + field_70146_Z.nextFloat() * 0.4F);
            }
            if(!field_70170_p.field_72995_K)
            {
                EntityItem entityitem;
                for(Iterator iterator = field_70170_p.func_72872_a(net.minecraft.src.EntityItem.class, field_70121_D.func_72314_b(0.5D, 0.0D, 0.5D)).iterator(); iterator.hasNext(); func_70289_a(entityitem))
                {
                    entityitem = (EntityItem)iterator.next();
                }

            }
        }
        float f = 0.98F;
        if(field_70122_E)
        {
            f = 0.5880001F;
            int i = field_70170_p.func_72798_a(MathHelper.func_76128_c(field_70165_t), MathHelper.func_76128_c(field_70121_D.field_72338_b) - 1, MathHelper.func_76128_c(field_70161_v));
            if(i > 0)
            {
                f = Block.field_71973_m[i].field_72016_cq * 0.98F;
            }
        }
        field_70159_w *= f;
        field_70181_x *= 0.98000001907348633D;
        field_70179_y *= f;
        if(field_70122_E)
        {
            field_70181_x *= -0.5D;
        }
        field_70292_b++;
        if(field_70292_b >= 6000)
        {
            func_70106_y();
        }
    }

    public boolean func_70289_a(EntityItem p_70289_1_)
    {
        if(p_70289_1_ == this)
        {
            return false;
        }
        if(!p_70289_1_.func_70089_S() || !func_70089_S())
        {
            return false;
        }
        if(p_70289_1_.field_70294_a.func_77973_b() != field_70294_a.func_77973_b())
        {
            return false;
        }
        if(p_70289_1_.field_70294_a.func_77973_b().func_77614_k() && p_70289_1_.field_70294_a.func_77960_j() != field_70294_a.func_77960_j())
        {
            return false;
        }
        if(p_70289_1_.field_70294_a.field_77994_a < field_70294_a.field_77994_a)
        {
            return p_70289_1_.func_70289_a(this);
        }
        if(p_70289_1_.field_70294_a.field_77994_a + field_70294_a.field_77994_a > p_70289_1_.field_70294_a.func_77976_d())
        {
            return false;
        } else
        {
            p_70289_1_.field_70294_a.field_77994_a += field_70294_a.field_77994_a;
            p_70289_1_.field_70293_c = Math.max(p_70289_1_.field_70293_c, field_70293_c);
            p_70289_1_.field_70292_b = Math.min(p_70289_1_.field_70292_b, field_70292_b);
            func_70106_y();
            return true;
        }
    }

    public void func_70288_d()
    {
        field_70292_b = 4800;
    }

    public boolean func_70072_I()
    {
        return field_70170_p.func_72918_a(field_70121_D, Material.field_76244_g, this);
    }

    protected void func_70081_e(int p_70081_1_)
    {
        func_70097_a(DamageSource.field_76372_a, p_70081_1_);
    }

    public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_)
    {
        func_70018_K();
        field_70291_e -= p_70097_2_;
        if(field_70291_e <= 0)
        {
            func_70106_y();
        }
        return false;
    }

    public void func_70014_b(NBTTagCompound p_70014_1_)
    {
        p_70014_1_.func_74777_a("Health", (byte)field_70291_e);
        p_70014_1_.func_74777_a("Age", (short)field_70292_b);
        if(field_70294_a != null)
        {
            p_70014_1_.func_74766_a("Item", field_70294_a.func_77955_b(new NBTTagCompound()));
        }
    }

    public void func_70037_a(NBTTagCompound p_70037_1_)
    {
        field_70291_e = p_70037_1_.func_74765_d("Health") & 0xff;
        field_70292_b = p_70037_1_.func_74765_d("Age");
        NBTTagCompound nbttagcompound = p_70037_1_.func_74775_l("Item");
        field_70294_a = ItemStack.func_77949_a(nbttagcompound);
        if(field_70294_a == null)
        {
            func_70106_y();
        }
    }

    public void func_70100_b_(EntityPlayer p_70100_1_)
    {
        if(field_70170_p.field_72995_K)
        {
            return;
        }
        int i = field_70294_a.field_77994_a;
        if(field_70293_c == 0 && p_70100_1_.field_71071_by.func_70441_a(field_70294_a))
        {
            if(field_70294_a.field_77993_c == Block.field_71951_J.field_71990_ca)
            {
                p_70100_1_.func_71029_a(AchievementList.field_76005_g);
            }
            if(field_70294_a.field_77993_c == Item.field_77770_aF.field_77779_bT)
            {
                p_70100_1_.func_71029_a(AchievementList.field_76022_t);
            }
            if(field_70294_a.field_77993_c == Item.field_77702_n.field_77779_bT)
            {
                p_70100_1_.func_71029_a(AchievementList.field_76019_w);
            }
            if(field_70294_a.field_77993_c == Item.field_77731_bo.field_77779_bT)
            {
                p_70100_1_.func_71029_a(AchievementList.field_76027_z);
            }
            ModLoader.onItemPickup(p_70100_1_, field_70294_a);
            field_70170_p.func_72956_a(this, "random.pop", 0.2F, ((field_70146_Z.nextFloat() - field_70146_Z.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            p_70100_1_.func_71001_a(this, i);
            if(field_70294_a.field_77994_a <= 0)
            {
                func_70106_y();
            }
        }
    }

    public String func_70023_ak()
    {
        return StatCollector.func_74838_a((new StringBuilder()).append("item.").append(field_70294_a.func_77977_a()).toString());
    }

    public boolean func_70075_an()
    {
        return false;
    }
}
