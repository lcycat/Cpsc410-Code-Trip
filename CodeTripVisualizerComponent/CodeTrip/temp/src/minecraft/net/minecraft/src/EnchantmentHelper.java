// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            ItemStack, NBTTagList, NBTTagCompound, Enchantment, 
//            IEnchantmentModifier, EnchantmentModifierDamage, InventoryPlayer, EnchantmentModifierLiving, 
//            Item, EnchantmentData, WeightedRandom, EnumEnchantmentType, 
//            DamageSource, EntityLiving

public class EnchantmentHelper
{

    private static final Random field_77522_a = new Random();
    private static final EnchantmentModifierDamage field_77520_b = new EnchantmentModifierDamage(null);
    private static final EnchantmentModifierLiving field_77521_c = new EnchantmentModifierLiving(null);

    public static int func_77506_a(int p_77506_0_, ItemStack p_77506_1_)
    {
        if(p_77506_1_ == null)
        {
            return 0;
        }
        NBTTagList nbttaglist = p_77506_1_.func_77986_q();
        if(nbttaglist == null)
        {
            return 0;
        }
        for(int i = 0; i < nbttaglist.func_74745_c(); i++)
        {
            short word0 = ((NBTTagCompound)nbttaglist.func_74743_b(i)).func_74765_d("id");
            short word1 = ((NBTTagCompound)nbttaglist.func_74743_b(i)).func_74765_d("lvl");
            if(word0 == p_77506_0_)
            {
                return word1;
            }
        }

        return 0;
    }

    private static int func_77511_a(int p_77511_0_, ItemStack p_77511_1_[])
    {
        int i = 0;
        ItemStack aitemstack[] = p_77511_1_;
        int j = aitemstack.length;
        for(int k = 0; k < j; k++)
        {
            ItemStack itemstack = aitemstack[k];
            int l = func_77506_a(p_77511_0_, itemstack);
            if(l > i)
            {
                i = l;
            }
        }

        return i;
    }

    private static void func_77518_a(IEnchantmentModifier p_77518_0_, ItemStack p_77518_1_)
    {
        if(p_77518_1_ == null)
        {
            return;
        }
        NBTTagList nbttaglist = p_77518_1_.func_77986_q();
        if(nbttaglist == null)
        {
            return;
        }
        for(int i = 0; i < nbttaglist.func_74745_c(); i++)
        {
            short word0 = ((NBTTagCompound)nbttaglist.func_74743_b(i)).func_74765_d("id");
            short word1 = ((NBTTagCompound)nbttaglist.func_74743_b(i)).func_74765_d("lvl");
            if(Enchantment.field_77331_b[word0] != null)
            {
                p_77518_0_.func_77493_a(Enchantment.field_77331_b[word0], word1);
            }
        }

    }

    private static void func_77516_a(IEnchantmentModifier p_77516_0_, ItemStack p_77516_1_[])
    {
        ItemStack aitemstack[] = p_77516_1_;
        int i = aitemstack.length;
        for(int j = 0; j < i; j++)
        {
            ItemStack itemstack = aitemstack[j];
            func_77518_a(p_77516_0_, itemstack);
        }

    }

    public static int func_77508_a(InventoryPlayer p_77508_0_, DamageSource p_77508_1_)
    {
        field_77520_b.field_77497_a = 0;
        field_77520_b.field_77496_b = p_77508_1_;
        func_77516_a(field_77520_b, p_77508_0_.field_70460_b);
        if(field_77520_b.field_77497_a > 25)
        {
            field_77520_b.field_77497_a = 25;
        }
        return (field_77520_b.field_77497_a + 1 >> 1) + field_77522_a.nextInt((field_77520_b.field_77497_a >> 1) + 1);
    }

    public static int func_77512_a(InventoryPlayer p_77512_0_, EntityLiving p_77512_1_)
    {
        field_77521_c.field_77495_a = 0;
        field_77521_c.field_77494_b = p_77512_1_;
        func_77518_a(field_77521_c, p_77512_0_.func_70448_g());
        if(field_77521_c.field_77495_a > 0)
        {
            return 1 + field_77522_a.nextInt(field_77521_c.field_77495_a);
        } else
        {
            return 0;
        }
    }

    public static int func_77507_b(InventoryPlayer p_77507_0_, EntityLiving p_77507_1_)
    {
        return func_77506_a(Enchantment.field_77337_m.field_77352_x, p_77507_0_.func_70448_g());
    }

    public static int func_77515_c(InventoryPlayer p_77515_0_, EntityLiving p_77515_1_)
    {
        return func_77506_a(Enchantment.field_77334_n.field_77352_x, p_77515_0_.func_70448_g());
    }

    public static int func_77501_a(InventoryPlayer p_77501_0_)
    {
        return func_77511_a(Enchantment.field_77340_h.field_77352_x, p_77501_0_.field_70460_b);
    }

    public static int func_77509_b(InventoryPlayer p_77509_0_)
    {
        return func_77506_a(Enchantment.field_77349_p.field_77352_x, p_77509_0_.func_70448_g());
    }

    public static int func_77503_c(InventoryPlayer p_77503_0_)
    {
        return func_77506_a(Enchantment.field_77347_r.field_77352_x, p_77503_0_.func_70448_g());
    }

    public static boolean func_77502_d(InventoryPlayer p_77502_0_)
    {
        return func_77506_a(Enchantment.field_77348_q.field_77352_x, p_77502_0_.func_70448_g()) > 0;
    }

    public static int func_77517_e(InventoryPlayer p_77517_0_)
    {
        return func_77506_a(Enchantment.field_77346_s.field_77352_x, p_77517_0_.func_70448_g());
    }

    public static int func_77519_f(InventoryPlayer p_77519_0_)
    {
        return func_77506_a(Enchantment.field_77335_o.field_77352_x, p_77519_0_.func_70448_g());
    }

    public static boolean func_77510_g(InventoryPlayer p_77510_0_)
    {
        return func_77511_a(Enchantment.field_77341_i.field_77352_x, p_77510_0_.field_70460_b) > 0;
    }

    public static int func_77514_a(Random p_77514_0_, int p_77514_1_, int p_77514_2_, ItemStack p_77514_3_)
    {
        Item item = p_77514_3_.func_77973_b();
        int i = item.func_77619_b();
        if(i <= 0)
        {
            return 0;
        }
        if(p_77514_2_ > 15)
        {
            p_77514_2_ = 15;
        }
        int j = p_77514_0_.nextInt(8) + 1 + (p_77514_2_ >> 1) + p_77514_0_.nextInt(p_77514_2_ + 1);
        if(p_77514_1_ == 0)
        {
            return Math.max(j / 3, 1);
        }
        if(p_77514_1_ == 1)
        {
            return (j * 2) / 3 + 1;
        } else
        {
            return Math.max(j, p_77514_2_ * 2);
        }
    }

    public static ItemStack func_77504_a(Random p_77504_0_, ItemStack p_77504_1_, int p_77504_2_)
    {
        List list = func_77513_b(p_77504_0_, p_77504_1_, p_77504_2_);
        if(list != null)
        {
            EnchantmentData enchantmentdata;
            for(Iterator iterator = list.iterator(); iterator.hasNext(); p_77504_1_.func_77966_a(enchantmentdata.field_76302_b, enchantmentdata.field_76303_c))
            {
                enchantmentdata = (EnchantmentData)iterator.next();
            }

        }
        return p_77504_1_;
    }

    public static List func_77513_b(Random p_77513_0_, ItemStack p_77513_1_, int p_77513_2_)
    {
        Item item = p_77513_1_.func_77973_b();
        int i = item.func_77619_b();
        if(i <= 0)
        {
            return null;
        }
        i /= 2;
        i = 1 + p_77513_0_.nextInt((i >> 1) + 1) + p_77513_0_.nextInt((i >> 1) + 1);
        int j = i + p_77513_2_;
        float f = ((p_77513_0_.nextFloat() + p_77513_0_.nextFloat()) - 1.0F) * 0.15F;
        int k = (int)((float)j * (1.0F + f) + 0.5F);
        if(k < 1)
        {
            k = 1;
        }
        ArrayList arraylist = null;
        Map map = func_77505_b(k, p_77513_1_);
        if(map != null && !map.isEmpty())
        {
            EnchantmentData enchantmentdata = (EnchantmentData)WeightedRandom.func_76271_a(p_77513_0_, map.values());
            if(enchantmentdata != null)
            {
                arraylist = new ArrayList();
                arraylist.add(enchantmentdata);
                for(int l = k; p_77513_0_.nextInt(50) <= l; l >>= 1)
                {
                    Iterator iterator = map.keySet().iterator();
                    do
                    {
                        if(!iterator.hasNext())
                        {
                            break;
                        }
                        Integer integer = (Integer)iterator.next();
                        boolean flag = true;
                        Iterator iterator1 = arraylist.iterator();
                        do
                        {
                            if(!iterator1.hasNext())
                            {
                                break;
                            }
                            EnchantmentData enchantmentdata2 = (EnchantmentData)iterator1.next();
                            if(enchantmentdata2.field_76302_b.func_77326_a(Enchantment.field_77331_b[integer.intValue()]))
                            {
                                continue;
                            }
                            flag = false;
                            break;
                        } while(true);
                        if(!flag)
                        {
                            iterator.remove();
                        }
                    } while(true);
                    if(!map.isEmpty())
                    {
                        EnchantmentData enchantmentdata1 = (EnchantmentData)WeightedRandom.func_76271_a(p_77513_0_, map.values());
                        arraylist.add(enchantmentdata1);
                    }
                }

            }
        }
        return arraylist;
    }

    public static Map func_77505_b(int p_77505_0_, ItemStack p_77505_1_)
    {
        Item item = p_77505_1_.func_77973_b();
        HashMap hashmap = null;
        Enchantment aenchantment[] = Enchantment.field_77331_b;
        int i = aenchantment.length;
        for(int j = 0; j < i; j++)
        {
            Enchantment enchantment = aenchantment[j];
            if(enchantment == null || !enchantment.field_77351_y.func_77557_a(item))
            {
                continue;
            }
            for(int k = enchantment.func_77319_d(); k <= enchantment.func_77325_b(); k++)
            {
                if(p_77505_0_ < enchantment.func_77321_a(k) || p_77505_0_ > enchantment.func_77317_b(k))
                {
                    continue;
                }
                if(hashmap == null)
                {
                    hashmap = new HashMap();
                }
                hashmap.put(Integer.valueOf(enchantment.field_77352_x), new EnchantmentData(enchantment, k));
            }

        }

        return hashmap;
    }

}
