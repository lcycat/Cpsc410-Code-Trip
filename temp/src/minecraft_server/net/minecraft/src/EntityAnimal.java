// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            EntityAgeable, IAnimals, World, EntityPlayer, 
//            Entity, Block, BlockGrass, NBTTagCompound, 
//            AxisAlignedBB, MathHelper, ItemStack, Item, 
//            InventoryPlayer, PlayerCapabilities, DamageSource

public abstract class EntityAnimal extends EntityAgeable
    implements IAnimals
{

    private int field_70881_d;
    private int field_70882_e;

    public EntityAnimal(World p_i3514_1_)
    {
        super(p_i3514_1_);
        field_70882_e = 0;
    }

    protected void func_70629_bd()
    {
        if(func_70874_b() != 0)
        {
            field_70881_d = 0;
        }
        super.func_70629_bd();
    }

    public void func_70636_d()
    {
        super.func_70636_d();
        if(func_70874_b() != 0)
        {
            field_70881_d = 0;
        }
        if(field_70881_d > 0)
        {
            field_70881_d--;
            String s = "heart";
            if(field_70881_d % 10 == 0)
            {
                double d = field_70146_Z.nextGaussian() * 0.02D;
                double d1 = field_70146_Z.nextGaussian() * 0.02D;
                double d2 = field_70146_Z.nextGaussian() * 0.02D;
                field_70170_p.func_72869_a(s, (field_70165_t + (double)(field_70146_Z.nextFloat() * field_70130_N * 2.0F)) - (double)field_70130_N, field_70163_u + 0.5D + (double)(field_70146_Z.nextFloat() * field_70131_O), (field_70161_v + (double)(field_70146_Z.nextFloat() * field_70130_N * 2.0F)) - (double)field_70130_N, d, d1, d2);
            }
        } else
        {
            field_70882_e = 0;
        }
    }

    protected void func_70785_a(Entity p_70785_1_, float p_70785_2_)
    {
        if(p_70785_1_ instanceof EntityPlayer)
        {
            if(p_70785_2_ < 3F)
            {
                double d = p_70785_1_.field_70165_t - field_70165_t;
                double d1 = p_70785_1_.field_70161_v - field_70161_v;
                field_70177_z = (float)((Math.atan2(d1, d) * 180D) / 3.1415927410125732D) - 90F;
                field_70787_b = true;
            }
            EntityPlayer entityplayer = (EntityPlayer)p_70785_1_;
            if(entityplayer.func_71045_bC() == null || !func_70877_b(entityplayer.func_71045_bC()))
            {
                field_70789_a = null;
            }
        } else
        if(p_70785_1_ instanceof EntityAnimal)
        {
            EntityAnimal entityanimal = (EntityAnimal)p_70785_1_;
            if(func_70874_b() > 0 && entityanimal.func_70874_b() < 0)
            {
                if((double)p_70785_2_ < 2.5D)
                {
                    field_70787_b = true;
                }
            } else
            if(field_70881_d > 0 && entityanimal.field_70881_d > 0)
            {
                if(entityanimal.field_70789_a == null)
                {
                    entityanimal.field_70789_a = this;
                }
                if(entityanimal.field_70789_a == this && (double)p_70785_2_ < 3.5D)
                {
                    entityanimal.field_70881_d++;
                    field_70881_d++;
                    field_70882_e++;
                    if(field_70882_e % 4 == 0)
                    {
                        field_70170_p.func_72869_a("heart", (field_70165_t + (double)(field_70146_Z.nextFloat() * field_70130_N * 2.0F)) - (double)field_70130_N, field_70163_u + 0.5D + (double)(field_70146_Z.nextFloat() * field_70131_O), (field_70161_v + (double)(field_70146_Z.nextFloat() * field_70130_N * 2.0F)) - (double)field_70130_N, 0.0D, 0.0D, 0.0D);
                    }
                    if(field_70882_e == 60)
                    {
                        func_70876_c((EntityAnimal)p_70785_1_);
                    }
                } else
                {
                    field_70882_e = 0;
                }
            } else
            {
                field_70882_e = 0;
                field_70789_a = null;
            }
        }
    }

    private void func_70876_c(EntityAnimal p_70876_1_)
    {
        EntityAnimal entityanimal = func_70879_a(p_70876_1_);
        if(entityanimal != null)
        {
            func_70873_a(6000);
            p_70876_1_.func_70873_a(6000);
            field_70881_d = 0;
            field_70882_e = 0;
            field_70789_a = null;
            p_70876_1_.field_70789_a = null;
            p_70876_1_.field_70882_e = 0;
            p_70876_1_.field_70881_d = 0;
            entityanimal.func_70873_a(-24000);
            entityanimal.func_70012_b(field_70165_t, field_70163_u, field_70161_v, field_70177_z, field_70125_A);
            for(int i = 0; i < 7; i++)
            {
                double d = field_70146_Z.nextGaussian() * 0.02D;
                double d1 = field_70146_Z.nextGaussian() * 0.02D;
                double d2 = field_70146_Z.nextGaussian() * 0.02D;
                field_70170_p.func_72869_a("heart", (field_70165_t + (double)(field_70146_Z.nextFloat() * field_70130_N * 2.0F)) - (double)field_70130_N, field_70163_u + 0.5D + (double)(field_70146_Z.nextFloat() * field_70131_O), (field_70161_v + (double)(field_70146_Z.nextFloat() * field_70130_N * 2.0F)) - (double)field_70130_N, d, d1, d2);
            }

            field_70170_p.func_72838_d(entityanimal);
        }
    }

    public abstract EntityAnimal func_70879_a(EntityAnimal entityanimal);

    public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_)
    {
        field_70788_c = 60;
        field_70789_a = null;
        field_70881_d = 0;
        return super.func_70097_a(p_70097_1_, p_70097_2_);
    }

    public float func_70783_a(int p_70783_1_, int p_70783_2_, int p_70783_3_)
    {
        if(field_70170_p.func_72798_a(p_70783_1_, p_70783_2_ - 1, p_70783_3_) == Block.field_71980_u.field_71990_ca)
        {
            return 10F;
        } else
        {
            return field_70170_p.func_72801_o(p_70783_1_, p_70783_2_, p_70783_3_) - 0.5F;
        }
    }

    public void func_70014_b(NBTTagCompound p_70014_1_)
    {
        super.func_70014_b(p_70014_1_);
        p_70014_1_.func_74768_a("InLove", field_70881_d);
    }

    public void func_70037_a(NBTTagCompound p_70037_1_)
    {
        super.func_70037_a(p_70037_1_);
        field_70881_d = p_70037_1_.func_74762_e("InLove");
    }

    protected Entity func_70782_k()
    {
label0:
        {
            if(field_70788_c > 0)
            {
                return null;
            }
            float f = 8F;
            if(field_70881_d > 0)
            {
                List list = field_70170_p.func_72872_a(getClass(), field_70121_D.func_72314_b(f, f, f));
                Iterator iterator = list.iterator();
                EntityAnimal entityanimal;
                do
                {
                    if(!iterator.hasNext())
                    {
                        break label0;
                    }
                    entityanimal = (EntityAnimal)iterator.next();
                } while(entityanimal == this || entityanimal.field_70881_d <= 0);
                return entityanimal;
            }
            if(func_70874_b() == 0)
            {
                List list1 = field_70170_p.func_72872_a(net.minecraft.src.EntityPlayer.class, field_70121_D.func_72314_b(f, f, f));
                Iterator iterator1 = list1.iterator();
                EntityPlayer entityplayer;
                do
                {
                    if(!iterator1.hasNext())
                    {
                        break label0;
                    }
                    entityplayer = (EntityPlayer)iterator1.next();
                } while(entityplayer.func_71045_bC() == null || !func_70877_b(entityplayer.func_71045_bC()));
                return entityplayer;
            }
            if(func_70874_b() <= 0)
            {
                break label0;
            }
            List list2 = field_70170_p.func_72872_a(getClass(), field_70121_D.func_72314_b(f, f, f));
            Iterator iterator2 = list2.iterator();
            EntityAnimal entityanimal1;
            do
            {
                if(!iterator2.hasNext())
                {
                    break label0;
                }
                entityanimal1 = (EntityAnimal)iterator2.next();
            } while(entityanimal1 == this || entityanimal1.func_70874_b() >= 0);
            return entityanimal1;
        }
        return null;
    }

    public boolean func_70601_bi()
    {
        int i = MathHelper.func_76128_c(field_70165_t);
        int j = MathHelper.func_76128_c(field_70121_D.field_72338_b);
        int k = MathHelper.func_76128_c(field_70161_v);
        return field_70170_p.func_72798_a(i, j - 1, k) == Block.field_71980_u.field_71990_ca && field_70170_p.func_72883_k(i, j, k) > 8 && super.func_70601_bi();
    }

    public int func_70627_aG()
    {
        return 120;
    }

    protected boolean func_70692_ba()
    {
        return false;
    }

    protected int func_70693_a(EntityPlayer p_70693_1_)
    {
        return 1 + field_70170_p.field_73012_v.nextInt(3);
    }

    public boolean func_70877_b(ItemStack p_70877_1_)
    {
        return p_70877_1_.field_77993_c == Item.field_77685_T.field_77779_bT;
    }

    public boolean func_70085_c(EntityPlayer p_70085_1_)
    {
        ItemStack itemstack = p_70085_1_.field_71071_by.func_70448_g();
        if(itemstack != null && func_70877_b(itemstack) && func_70874_b() == 0)
        {
            if(!p_70085_1_.field_71075_bZ.field_75098_d)
            {
                itemstack.field_77994_a--;
                if(itemstack.field_77994_a <= 0)
                {
                    p_70085_1_.field_71071_by.func_70299_a(p_70085_1_.field_71071_by.field_70461_c, null);
                }
            }
            field_70881_d = 600;
            field_70789_a = null;
            for(int i = 0; i < 7; i++)
            {
                double d = field_70146_Z.nextGaussian() * 0.02D;
                double d1 = field_70146_Z.nextGaussian() * 0.02D;
                double d2 = field_70146_Z.nextGaussian() * 0.02D;
                field_70170_p.func_72869_a("heart", (field_70165_t + (double)(field_70146_Z.nextFloat() * field_70130_N * 2.0F)) - (double)field_70130_N, field_70163_u + 0.5D + (double)(field_70146_Z.nextFloat() * field_70131_O), (field_70161_v + (double)(field_70146_Z.nextFloat() * field_70130_N * 2.0F)) - (double)field_70130_N, d, d1, d2);
            }

            return true;
        } else
        {
            return super.func_70085_c(p_70085_1_);
        }
    }

    public boolean func_70880_s()
    {
        return field_70881_d > 0;
    }

    public void func_70875_t()
    {
        field_70881_d = 0;
    }

    public boolean func_70878_b(EntityAnimal p_70878_1_)
    {
        if(p_70878_1_ == this)
        {
            return false;
        }
        if(p_70878_1_.getClass() != getClass())
        {
            return false;
        } else
        {
            return func_70880_s() && p_70878_1_.func_70880_s();
        }
    }
}
