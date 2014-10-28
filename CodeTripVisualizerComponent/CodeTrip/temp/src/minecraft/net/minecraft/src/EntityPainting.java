// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            Entity, EnumArt, AxisAlignedBB, World, 
//            EntityItem, ItemStack, Item, MathHelper, 
//            Material, DamageSource, EntityPlayer, PlayerCapabilities, 
//            NBTTagCompound

public class EntityPainting extends Entity
{

    private int field_70520_f;
    public int field_70525_a;
    public int field_70523_b;
    public int field_70524_c;
    public int field_70521_d;
    public EnumArt field_70522_e;

    public EntityPainting(World p_i3447_1_)
    {
        super(p_i3447_1_);
        field_70520_f = 0;
        field_70525_a = 0;
        field_70129_M = 0.0F;
        func_70105_a(0.5F, 0.5F);
    }

    public EntityPainting(World p_i3448_1_, int p_i3448_2_, int p_i3448_3_, int p_i3448_4_, int p_i3448_5_)
    {
        this(p_i3448_1_);
        field_70523_b = p_i3448_2_;
        field_70524_c = p_i3448_3_;
        field_70521_d = p_i3448_4_;
        ArrayList arraylist = new ArrayList();
        EnumArt aenumart[] = EnumArt.values();
        int i = aenumart.length;
        for(int j = 0; j < i; j++)
        {
            EnumArt enumart = aenumart[j];
            field_70522_e = enumart;
            func_70519_a(p_i3448_5_);
            if(func_70518_d())
            {
                arraylist.add(enumart);
            }
        }

        if(!arraylist.isEmpty())
        {
            field_70522_e = (EnumArt)arraylist.get(field_70146_Z.nextInt(arraylist.size()));
        }
        func_70519_a(p_i3448_5_);
    }

    public EntityPainting(World p_i3449_1_, int p_i3449_2_, int p_i3449_3_, int p_i3449_4_, int p_i3449_5_, String p_i3449_6_)
    {
        this(p_i3449_1_);
        field_70523_b = p_i3449_2_;
        field_70524_c = p_i3449_3_;
        field_70521_d = p_i3449_4_;
        EnumArt aenumart[] = EnumArt.values();
        int i = aenumart.length;
        int j = 0;
        do
        {
            if(j >= i)
            {
                break;
            }
            EnumArt enumart = aenumart[j];
            if(enumart.field_75702_A.equals(p_i3449_6_))
            {
                field_70522_e = enumart;
                break;
            }
            j++;
        } while(true);
        func_70519_a(p_i3449_5_);
    }

    protected void func_70088_a()
    {
    }

    public void func_70519_a(int p_70519_1_)
    {
        field_70525_a = p_70519_1_;
        field_70126_B = field_70177_z = p_70519_1_ * 90;
        float f = field_70522_e.field_75703_B;
        float f1 = field_70522_e.field_75704_C;
        float f2 = field_70522_e.field_75703_B;
        if(p_70519_1_ == 0 || p_70519_1_ == 2)
        {
            f2 = 0.5F;
        } else
        {
            f = 0.5F;
        }
        f /= 32F;
        f1 /= 32F;
        f2 /= 32F;
        float f3 = (float)field_70523_b + 0.5F;
        float f4 = (float)field_70524_c + 0.5F;
        float f5 = (float)field_70521_d + 0.5F;
        float f6 = 0.5625F;
        if(p_70519_1_ == 0)
        {
            f5 -= f6;
        }
        if(p_70519_1_ == 1)
        {
            f3 -= f6;
        }
        if(p_70519_1_ == 2)
        {
            f5 += f6;
        }
        if(p_70519_1_ == 3)
        {
            f3 += f6;
        }
        if(p_70519_1_ == 0)
        {
            f3 -= func_70517_b(field_70522_e.field_75703_B);
        }
        if(p_70519_1_ == 1)
        {
            f5 += func_70517_b(field_70522_e.field_75703_B);
        }
        if(p_70519_1_ == 2)
        {
            f3 += func_70517_b(field_70522_e.field_75703_B);
        }
        if(p_70519_1_ == 3)
        {
            f5 -= func_70517_b(field_70522_e.field_75703_B);
        }
        f4 += func_70517_b(field_70522_e.field_75704_C);
        func_70107_b(f3, f4, f5);
        float f7 = -0.00625F;
        field_70121_D.func_72324_b(f3 - f - f7, f4 - f1 - f7, f5 - f2 - f7, f3 + f + f7, f4 + f1 + f7, f5 + f2 + f7);
    }

    private float func_70517_b(int p_70517_1_)
    {
        if(p_70517_1_ == 32)
        {
            return 0.5F;
        }
        return p_70517_1_ != 64 ? 0.0F : 0.5F;
    }

    public void func_70071_h_()
    {
        if(field_70520_f++ == 100 && !field_70170_p.field_72995_K)
        {
            field_70520_f = 0;
            if(!field_70128_L && !func_70518_d())
            {
                func_70106_y();
                field_70170_p.func_72838_d(new EntityItem(field_70170_p, field_70165_t, field_70163_u, field_70161_v, new ItemStack(Item.field_77780_as)));
            }
        }
    }

    public boolean func_70518_d()
    {
        if(!field_70170_p.func_72945_a(this, field_70121_D).isEmpty())
        {
            return false;
        }
        int i = field_70522_e.field_75703_B / 16;
        int j = field_70522_e.field_75704_C / 16;
        int k = field_70523_b;
        int l = field_70524_c;
        int i1 = field_70521_d;
        if(field_70525_a == 0)
        {
            k = MathHelper.func_76128_c(field_70165_t - (double)((float)field_70522_e.field_75703_B / 32F));
        }
        if(field_70525_a == 1)
        {
            i1 = MathHelper.func_76128_c(field_70161_v - (double)((float)field_70522_e.field_75703_B / 32F));
        }
        if(field_70525_a == 2)
        {
            k = MathHelper.func_76128_c(field_70165_t - (double)((float)field_70522_e.field_75703_B / 32F));
        }
        if(field_70525_a == 3)
        {
            i1 = MathHelper.func_76128_c(field_70161_v - (double)((float)field_70522_e.field_75703_B / 32F));
        }
        l = MathHelper.func_76128_c(field_70163_u - (double)((float)field_70522_e.field_75704_C / 32F));
        for(int j1 = 0; j1 < i; j1++)
        {
            for(int k1 = 0; k1 < j; k1++)
            {
                Material material;
                if(field_70525_a == 0 || field_70525_a == 2)
                {
                    material = field_70170_p.func_72803_f(k + j1, l + k1, field_70521_d);
                } else
                {
                    material = field_70170_p.func_72803_f(field_70523_b, l + k1, i1 + j1);
                }
                if(!material.func_76220_a())
                {
                    return false;
                }
            }

        }

        List list = field_70170_p.func_72839_b(this, field_70121_D);
        for(Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            Entity entity = (Entity)iterator.next();
            if(entity instanceof EntityPainting)
            {
                return false;
            }
        }

        return true;
    }

    public boolean func_70067_L()
    {
        return true;
    }

    public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_)
    {
        if(!field_70128_L && !field_70170_p.field_72995_K)
        {
            func_70106_y();
            func_70018_K();
            EntityPlayer entityplayer = null;
            if(p_70097_1_.func_76346_g() instanceof EntityPlayer)
            {
                entityplayer = (EntityPlayer)p_70097_1_.func_76346_g();
            }
            if(entityplayer != null && entityplayer.field_71075_bZ.field_75098_d)
            {
                return true;
            }
            field_70170_p.func_72838_d(new EntityItem(field_70170_p, field_70165_t, field_70163_u, field_70161_v, new ItemStack(Item.field_77780_as)));
        }
        return true;
    }

    public void func_70014_b(NBTTagCompound p_70014_1_)
    {
        p_70014_1_.func_74774_a("Dir", (byte)field_70525_a);
        p_70014_1_.func_74778_a("Motive", field_70522_e.field_75702_A);
        p_70014_1_.func_74768_a("TileX", field_70523_b);
        p_70014_1_.func_74768_a("TileY", field_70524_c);
        p_70014_1_.func_74768_a("TileZ", field_70521_d);
    }

    public void func_70037_a(NBTTagCompound p_70037_1_)
    {
        field_70525_a = p_70037_1_.func_74771_c("Dir");
        field_70523_b = p_70037_1_.func_74762_e("TileX");
        field_70524_c = p_70037_1_.func_74762_e("TileY");
        field_70521_d = p_70037_1_.func_74762_e("TileZ");
        String s = p_70037_1_.func_74779_i("Motive");
        EnumArt aenumart[] = EnumArt.values();
        int i = aenumart.length;
        for(int j = 0; j < i; j++)
        {
            EnumArt enumart = aenumart[j];
            if(enumart.field_75702_A.equals(s))
            {
                field_70522_e = enumart;
            }
        }

        if(field_70522_e == null)
        {
            field_70522_e = EnumArt.Kebab;
        }
        func_70519_a(field_70525_a);
    }

    public void func_70091_d(double p_70091_1_, double p_70091_3_, double p_70091_5_)
    {
        if(!field_70170_p.field_72995_K && !field_70128_L && p_70091_1_ * p_70091_1_ + p_70091_3_ * p_70091_3_ + p_70091_5_ * p_70091_5_ > 0.0D)
        {
            func_70106_y();
            field_70170_p.func_72838_d(new EntityItem(field_70170_p, field_70165_t, field_70163_u, field_70161_v, new ItemStack(Item.field_77780_as)));
        }
    }

    public void func_70024_g(double p_70024_1_, double p_70024_3_, double p_70024_5_)
    {
        if(!field_70170_p.field_72995_K && !field_70128_L && p_70024_1_ * p_70024_1_ + p_70024_3_ * p_70024_3_ + p_70024_5_ * p_70024_5_ > 0.0D)
        {
            func_70106_y();
            field_70170_p.func_72838_d(new EntityItem(field_70170_p, field_70165_t, field_70163_u, field_70161_v, new ItemStack(Item.field_77780_as)));
        }
    }
}
