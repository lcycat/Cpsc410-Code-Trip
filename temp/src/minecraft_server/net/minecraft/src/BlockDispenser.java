// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockContainer, Material, CreativeTabs, Block, 
//            World, TileEntityDispenser, EntityPlayer, ItemStack, 
//            EntityLiving, MathHelper, EntityItem, NBTTagCompound, 
//            Item, EntityArrow, EntityEgg, EntitySnowball, 
//            ItemPotion, EntityPotion, EntityExpBottle, ItemMonsterPlacer, 
//            EntitySmallFireball, ItemMinecart, BlockRail, EntityMinecart, 
//            EntityBoat, ModLoader, ItemBucket, TileEntity

public class BlockDispenser extends BlockContainer
{

    private Random field_72284_a;

    protected BlockDispenser(int p_i3938_1_)
    {
        super(p_i3938_1_, Material.field_76246_e);
        field_72284_a = new Random();
        field_72059_bZ = 45;
        func_71849_a(CreativeTabs.field_78028_d);
    }

    public int func_71859_p_()
    {
        return 4;
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        return Block.field_71958_P.field_71990_ca;
    }

    public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_)
    {
        super.func_71861_g(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
        func_72280_l(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
    }

    private void func_72280_l(World p_72280_1_, int p_72280_2_, int p_72280_3_, int p_72280_4_)
    {
        if(!p_72280_1_.field_72995_K)
        {
            int i = p_72280_1_.func_72798_a(p_72280_2_, p_72280_3_, p_72280_4_ - 1);
            int j = p_72280_1_.func_72798_a(p_72280_2_, p_72280_3_, p_72280_4_ + 1);
            int k = p_72280_1_.func_72798_a(p_72280_2_ - 1, p_72280_3_, p_72280_4_);
            int l = p_72280_1_.func_72798_a(p_72280_2_ + 1, p_72280_3_, p_72280_4_);
            byte byte0 = 3;
            if(Block.field_71970_n[i] && !Block.field_71970_n[j])
            {
                byte0 = 3;
            }
            if(Block.field_71970_n[j] && !Block.field_71970_n[i])
            {
                byte0 = 2;
            }
            if(Block.field_71970_n[k] && !Block.field_71970_n[l])
            {
                byte0 = 5;
            }
            if(Block.field_71970_n[l] && !Block.field_71970_n[k])
            {
                byte0 = 4;
            }
            p_72280_1_.func_72921_c(p_72280_2_, p_72280_3_, p_72280_4_, byte0);
        }
    }

    public int func_71851_a(int p_71851_1_)
    {
        return p_71851_1_ != 1 ? p_71851_1_ != 0 ? p_71851_1_ != 3 ? field_72059_bZ : field_72059_bZ + 1 : field_72059_bZ + 17 : field_72059_bZ + 17;
    }

    public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, 
            float p_71903_8_, float p_71903_9_)
    {
        if(p_71903_1_.field_72995_K)
        {
            return true;
        }
        TileEntityDispenser tileentitydispenser = (TileEntityDispenser)p_71903_1_.func_72796_p(p_71903_2_, p_71903_3_, p_71903_4_);
        if(tileentitydispenser != null)
        {
            p_71903_5_.func_71006_a(tileentitydispenser);
        }
        return true;
    }

    private void func_72281_c(World p_72281_1_, int p_72281_2_, int p_72281_3_, int p_72281_4_, Random p_72281_5_)
    {
        int i = p_72281_1_.func_72805_g(p_72281_2_, p_72281_3_, p_72281_4_);
        int j = 0;
        int k = 0;
        if(i == 3)
        {
            k = 1;
        } else
        if(i == 2)
        {
            k = -1;
        } else
        if(i == 5)
        {
            j = 1;
        } else
        {
            j = -1;
        }
        TileEntityDispenser tileentitydispenser = (TileEntityDispenser)p_72281_1_.func_72796_p(p_72281_2_, p_72281_3_, p_72281_4_);
        if(tileentitydispenser != null)
        {
            int l = tileentitydispenser.func_70361_i();
            if(l < 0)
            {
                p_72281_1_.func_72926_e(1001, p_72281_2_, p_72281_3_, p_72281_4_, 0);
            } else
            {
                double d = (double)p_72281_2_ + (double)j * 0.59999999999999998D + 0.5D;
                double d1 = (double)p_72281_3_ + 0.5D;
                double d2 = (double)p_72281_4_ + (double)k * 0.59999999999999998D + 0.5D;
                ItemStack itemstack = tileentitydispenser.func_70301_a(l);
                int i1 = func_72283_a(tileentitydispenser, p_72281_1_, itemstack, p_72281_5_, p_72281_2_, p_72281_3_, p_72281_4_, j, k, d, d1, d2);
                if(i1 == 1)
                {
                    tileentitydispenser.func_70298_a(l, 1);
                } else
                if(i1 == 0)
                {
                    ItemStack itemstack1 = tileentitydispenser.func_70298_a(l, 1);
                    func_72282_a(p_72281_1_, itemstack1, p_72281_5_, 6, j, k, d, d1, d2);
                    p_72281_1_.func_72926_e(1000, p_72281_2_, p_72281_3_, p_72281_4_, 0);
                }
                p_72281_1_.func_72926_e(2000, p_72281_2_, p_72281_3_, p_72281_4_, j + 1 + (k + 1) * 3);
            }
        }
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        if(p_71863_5_ > 0 && Block.field_71973_m[p_71863_5_].func_71853_i())
        {
            boolean flag = p_71863_1_.func_72864_z(p_71863_2_, p_71863_3_, p_71863_4_) || p_71863_1_.func_72864_z(p_71863_2_, p_71863_3_ + 1, p_71863_4_);
            if(flag)
            {
                p_71863_1_.func_72836_a(p_71863_2_, p_71863_3_, p_71863_4_, field_71990_ca, func_71859_p_());
            }
        }
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_)
    {
        if(!p_71847_1_.field_72995_K && (p_71847_1_.func_72864_z(p_71847_2_, p_71847_3_, p_71847_4_) || p_71847_1_.func_72864_z(p_71847_2_, p_71847_3_ + 1, p_71847_4_)))
        {
            func_72281_c(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_, p_71847_5_);
        }
    }

    public TileEntity func_72274_a(World p_72274_1_)
    {
        return new TileEntityDispenser();
    }

    public void func_71860_a(World p_71860_1_, int p_71860_2_, int p_71860_3_, int p_71860_4_, EntityLiving p_71860_5_)
    {
        int i = MathHelper.func_76128_c((double)((p_71860_5_.field_70177_z * 4F) / 360F) + 0.5D) & 3;
        if(i == 0)
        {
            p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, 2);
        }
        if(i == 1)
        {
            p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, 5);
        }
        if(i == 2)
        {
            p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, 3);
        }
        if(i == 3)
        {
            p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, 4);
        }
    }

    public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_)
    {
        TileEntityDispenser tileentitydispenser = (TileEntityDispenser)p_71852_1_.func_72796_p(p_71852_2_, p_71852_3_, p_71852_4_);
        if(tileentitydispenser != null)
        {
label0:
            for(int i = 0; i < tileentitydispenser.func_70302_i_(); i++)
            {
                ItemStack itemstack = tileentitydispenser.func_70301_a(i);
                if(itemstack == null)
                {
                    continue;
                }
                float f = field_72284_a.nextFloat() * 0.8F + 0.1F;
                float f1 = field_72284_a.nextFloat() * 0.8F + 0.1F;
                float f2 = field_72284_a.nextFloat() * 0.8F + 0.1F;
                do
                {
                    if(itemstack.field_77994_a <= 0)
                    {
                        continue label0;
                    }
                    int j = field_72284_a.nextInt(21) + 10;
                    if(j > itemstack.field_77994_a)
                    {
                        j = itemstack.field_77994_a;
                    }
                    itemstack.field_77994_a -= j;
                    EntityItem entityitem = new EntityItem(p_71852_1_, (float)p_71852_2_ + f, (float)p_71852_3_ + f1, (float)p_71852_4_ + f2, new ItemStack(itemstack.field_77993_c, j, itemstack.func_77960_j()));
                    if(itemstack.func_77942_o())
                    {
                        entityitem.field_70294_a.func_77982_d((NBTTagCompound)itemstack.func_77978_p().func_74737_b());
                    }
                    float f3 = 0.05F;
                    entityitem.field_70159_w = (float)field_72284_a.nextGaussian() * f3;
                    entityitem.field_70181_x = (float)field_72284_a.nextGaussian() * f3 + 0.2F;
                    entityitem.field_70179_y = (float)field_72284_a.nextGaussian() * f3;
                    p_71852_1_.func_72838_d(entityitem);
                } while(true);
            }

        }
        super.func_71852_a(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_, p_71852_5_, p_71852_6_);
    }

    private static void func_72282_a(World p_72282_0_, ItemStack p_72282_1_, Random p_72282_2_, int p_72282_3_, int p_72282_4_, int p_72282_5_, double p_72282_6_, 
            double p_72282_8_, double p_72282_10_)
    {
        EntityItem entityitem = new EntityItem(p_72282_0_, p_72282_6_, p_72282_8_ - 0.29999999999999999D, p_72282_10_, p_72282_1_);
        double d = p_72282_2_.nextDouble() * 0.10000000000000001D + 0.20000000000000001D;
        entityitem.field_70159_w = (double)p_72282_4_ * d;
        entityitem.field_70181_x = 0.20000000298023224D;
        entityitem.field_70179_y = (double)p_72282_5_ * d;
        entityitem.field_70159_w += p_72282_2_.nextGaussian() * 0.0074999998323619366D * (double)p_72282_3_;
        entityitem.field_70181_x += p_72282_2_.nextGaussian() * 0.0074999998323619366D * (double)p_72282_3_;
        entityitem.field_70179_y += p_72282_2_.nextGaussian() * 0.0074999998323619366D * (double)p_72282_3_;
        p_72282_0_.func_72838_d(entityitem);
    }

    private static int func_72283_a(TileEntityDispenser p_72283_0_, World p_72283_1_, ItemStack p_72283_2_, Random p_72283_3_, int p_72283_4_, int p_72283_5_, int p_72283_6_, int p_72283_7_, 
            int p_72283_8_, double p_72283_9_, double p_72283_11_, double p_72283_13_)
    {
        float f = 1.1F;
        int i = 6;
        if(p_72283_2_.field_77993_c == Item.field_77704_l.field_77779_bT)
        {
            EntityArrow entityarrow = new EntityArrow(p_72283_1_, p_72283_9_, p_72283_11_, p_72283_13_);
            entityarrow.func_70244_c(p_72283_7_, 0.10000000149011612D, p_72283_8_, f, i);
            entityarrow.field_70251_a = 1;
            p_72283_1_.func_72838_d(entityarrow);
            p_72283_1_.func_72926_e(1002, p_72283_4_, p_72283_5_, p_72283_6_, 0);
            return 1;
        }
        if(p_72283_2_.field_77993_c == Item.field_77764_aP.field_77779_bT)
        {
            EntityEgg entityegg = new EntityEgg(p_72283_1_, p_72283_9_, p_72283_11_, p_72283_13_);
            entityegg.func_70186_c(p_72283_7_, 0.10000000149011612D, p_72283_8_, f, i);
            p_72283_1_.func_72838_d(entityegg);
            p_72283_1_.func_72926_e(1002, p_72283_4_, p_72283_5_, p_72283_6_, 0);
            return 1;
        }
        if(p_72283_2_.field_77993_c == Item.field_77768_aD.field_77779_bT)
        {
            EntitySnowball entitysnowball = new EntitySnowball(p_72283_1_, p_72283_9_, p_72283_11_, p_72283_13_);
            entitysnowball.func_70186_c(p_72283_7_, 0.10000000149011612D, p_72283_8_, f, i);
            p_72283_1_.func_72838_d(entitysnowball);
            p_72283_1_.func_72926_e(1002, p_72283_4_, p_72283_5_, p_72283_6_, 0);
            return 1;
        }
        if(p_72283_2_.field_77993_c == Item.field_77726_bs.field_77779_bT && ItemPotion.func_77831_g(p_72283_2_.func_77960_j()))
        {
            EntityPotion entitypotion = new EntityPotion(p_72283_1_, p_72283_9_, p_72283_11_, p_72283_13_, p_72283_2_.func_77960_j());
            entitypotion.func_70186_c(p_72283_7_, 0.10000000149011612D, p_72283_8_, f * 1.25F, (float)i * 0.5F);
            p_72283_1_.func_72838_d(entitypotion);
            p_72283_1_.func_72926_e(1002, p_72283_4_, p_72283_5_, p_72283_6_, 0);
            return 1;
        }
        if(p_72283_2_.field_77993_c == Item.field_77809_bD.field_77779_bT)
        {
            EntityExpBottle entityexpbottle = new EntityExpBottle(p_72283_1_, p_72283_9_, p_72283_11_, p_72283_13_);
            entityexpbottle.func_70186_c(p_72283_7_, 0.10000000149011612D, p_72283_8_, f * 1.25F, (float)i * 0.5F);
            p_72283_1_.func_72838_d(entityexpbottle);
            p_72283_1_.func_72926_e(1002, p_72283_4_, p_72283_5_, p_72283_6_, 0);
            return 1;
        }
        if(p_72283_2_.field_77993_c == Item.field_77815_bC.field_77779_bT)
        {
            ItemMonsterPlacer.func_77840_a(p_72283_1_, p_72283_2_.func_77960_j(), p_72283_9_ + (double)p_72283_7_ * 0.29999999999999999D, p_72283_11_ - 0.29999999999999999D, p_72283_13_ + (double)p_72283_8_ * 0.29999999999999999D);
            p_72283_1_.func_72926_e(1002, p_72283_4_, p_72283_5_, p_72283_6_, 0);
            return 1;
        }
        if(p_72283_2_.field_77993_c == Item.field_77811_bE.field_77779_bT)
        {
            EntitySmallFireball entitysmallfireball = new EntitySmallFireball(p_72283_1_, p_72283_9_ + (double)p_72283_7_ * 0.29999999999999999D, p_72283_11_, p_72283_13_ + (double)p_72283_8_ * 0.29999999999999999D, (double)p_72283_7_ + p_72283_3_.nextGaussian() * 0.050000000000000003D, p_72283_3_.nextGaussian() * 0.050000000000000003D, (double)p_72283_8_ + p_72283_3_.nextGaussian() * 0.050000000000000003D);
            p_72283_1_.func_72838_d(entitysmallfireball);
            p_72283_1_.func_72926_e(1009, p_72283_4_, p_72283_5_, p_72283_6_, 0);
            return 1;
        }
        if(p_72283_2_.field_77993_c != Item.field_77775_ay.field_77779_bT && p_72283_2_.field_77993_c != Item.field_77786_ax.field_77779_bT)
        {
            if(p_72283_2_.field_77993_c == Item.field_77788_aw.field_77779_bT)
            {
                int j = p_72283_4_ + p_72283_7_;
                int k = p_72283_6_ + p_72283_8_;
                Material material = p_72283_1_.func_72803_f(j, p_72283_5_, k);
                int l = p_72283_1_.func_72805_g(j, p_72283_5_, k);
                if(material == Material.field_76244_g && l == 0)
                {
                    p_72283_1_.func_72859_e(j, p_72283_5_, k, 0);
                    if(--p_72283_2_.field_77994_a == 0)
                    {
                        p_72283_2_.field_77993_c = Item.field_77786_ax.field_77779_bT;
                        p_72283_2_.field_77994_a = 1;
                    } else
                    if(p_72283_0_.func_70360_a(new ItemStack(Item.field_77786_ax)) < 0)
                    {
                        func_72282_a(p_72283_1_, new ItemStack(Item.field_77786_ax), p_72283_3_, 6, p_72283_7_, p_72283_8_, p_72283_9_, p_72283_11_, p_72283_13_);
                    }
                    return 2;
                }
                if(material == Material.field_76256_h && l == 0)
                {
                    p_72283_1_.func_72859_e(j, p_72283_5_, k, 0);
                    if(--p_72283_2_.field_77994_a == 0)
                    {
                        p_72283_2_.field_77993_c = Item.field_77775_ay.field_77779_bT;
                        p_72283_2_.field_77994_a = 1;
                    } else
                    if(p_72283_0_.func_70360_a(new ItemStack(Item.field_77775_ay)) < 0)
                    {
                        func_72282_a(p_72283_1_, new ItemStack(Item.field_77775_ay), p_72283_3_, 6, p_72283_7_, p_72283_8_, p_72283_9_, p_72283_11_, p_72283_13_);
                    }
                    return 2;
                } else
                {
                    return 0;
                }
            }
            if(p_72283_2_.func_77973_b() instanceof ItemMinecart)
            {
                p_72283_9_ = (double)p_72283_4_ + (p_72283_7_ >= 0 ? (float)p_72283_7_ * 1.8F : (double)p_72283_7_ * 0.80000000000000004D) + (double)((float)Math.abs(p_72283_8_) * 0.5F);
                p_72283_13_ = (double)p_72283_6_ + (p_72283_8_ >= 0 ? (float)p_72283_8_ * 1.8F : (double)p_72283_8_ * 0.80000000000000004D) + (double)((float)Math.abs(p_72283_7_) * 0.5F);
                if(BlockRail.func_72180_d_(p_72283_1_, p_72283_4_ + p_72283_7_, p_72283_5_, p_72283_6_ + p_72283_8_))
                {
                    p_72283_11_ = (float)p_72283_5_ + 0.5F;
                } else
                {
                    if(!p_72283_1_.func_72799_c(p_72283_4_ + p_72283_7_, p_72283_5_, p_72283_6_ + p_72283_8_) || !BlockRail.func_72180_d_(p_72283_1_, p_72283_4_ + p_72283_7_, p_72283_5_ - 1, p_72283_6_ + p_72283_8_))
                    {
                        return 0;
                    }
                    p_72283_11_ = (float)p_72283_5_ - 0.5F;
                }
                EntityMinecart entityminecart = new EntityMinecart(p_72283_1_, p_72283_9_, p_72283_11_, p_72283_13_, ((ItemMinecart)p_72283_2_.func_77973_b()).field_77841_a);
                p_72283_1_.func_72838_d(entityminecart);
                p_72283_1_.func_72926_e(1000, p_72283_4_, p_72283_5_, p_72283_6_, 0);
                return 1;
            }
            if(p_72283_2_.field_77993_c == Item.field_77769_aE.field_77779_bT)
            {
                p_72283_9_ = (double)p_72283_4_ + (p_72283_7_ >= 0 ? (float)p_72283_7_ * 1.8F : (double)p_72283_7_ * 0.80000000000000004D) + (double)((float)Math.abs(p_72283_8_) * 0.5F);
                p_72283_13_ = (double)p_72283_6_ + (p_72283_8_ >= 0 ? (float)p_72283_8_ * 1.8F : (double)p_72283_8_ * 0.80000000000000004D) + (double)((float)Math.abs(p_72283_7_) * 0.5F);
                if(p_72283_1_.func_72803_f(p_72283_4_ + p_72283_7_, p_72283_5_, p_72283_6_ + p_72283_8_) == Material.field_76244_g)
                {
                    p_72283_11_ = (float)p_72283_5_ + 1.0F;
                } else
                {
                    if(!p_72283_1_.func_72799_c(p_72283_4_ + p_72283_7_, p_72283_5_, p_72283_6_ + p_72283_8_) || p_72283_1_.func_72803_f(p_72283_4_ + p_72283_7_, p_72283_5_ - 1, p_72283_6_ + p_72283_8_) != Material.field_76244_g)
                    {
                        return 0;
                    }
                    p_72283_11_ = p_72283_5_;
                }
                EntityBoat entityboat = new EntityBoat(p_72283_1_, p_72283_9_, p_72283_11_, p_72283_13_);
                p_72283_1_.func_72838_d(entityboat);
                p_72283_1_.func_72926_e(1000, p_72283_4_, p_72283_5_, p_72283_6_, 0);
                return 1;
            } else
            {
                return ModLoader.dispenseEntity(p_72283_1_, p_72283_2_, p_72283_3_, p_72283_4_, p_72283_5_, p_72283_6_, p_72283_7_, p_72283_8_, p_72283_9_, p_72283_11_, p_72283_13_);
            }
        }
        ItemBucket itembucket = (ItemBucket)p_72283_2_.func_77973_b();
        if(itembucket.func_77875_a(p_72283_1_, p_72283_4_, p_72283_5_, p_72283_6_, p_72283_4_ + p_72283_7_, p_72283_5_, p_72283_6_ + p_72283_8_))
        {
            p_72283_2_.field_77993_c = Item.field_77788_aw.field_77779_bT;
            p_72283_2_.field_77994_a = 1;
            return 2;
        } else
        {
            return 0;
        }
    }
}
