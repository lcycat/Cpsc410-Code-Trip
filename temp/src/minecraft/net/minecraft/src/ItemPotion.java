// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            Item, CreativeTabs, ItemStack, PotionHelper, 
//            EntityPlayer, PlayerCapabilities, World, PotionEffect, 
//            InventoryPlayer, EnumAction, EntityPotion, Potion, 
//            StatCollector

public class ItemPotion extends Item
{

    private HashMap field_77836_a;
    private static final Map field_77835_b = new LinkedHashMap();

    public ItemPotion(int p_i3675_1_)
    {
        super(p_i3675_1_);
        field_77836_a = new HashMap();
        func_77625_d(1);
        func_77627_a(true);
        func_77656_e(0);
        func_77637_a(CreativeTabs.field_78038_k);
    }

    public List func_77832_l(ItemStack p_77832_1_)
    {
        return func_77834_f(p_77832_1_.func_77960_j());
    }

    public List func_77834_f(int p_77834_1_)
    {
        List list = (List)field_77836_a.get(Integer.valueOf(p_77834_1_));
        if(list == null)
        {
            list = PotionHelper.func_77917_b(p_77834_1_, false);
            field_77836_a.put(Integer.valueOf(p_77834_1_), list);
        }
        return list;
    }

    public ItemStack func_77654_b(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_)
    {
        if(!p_77654_3_.field_71075_bZ.field_75098_d)
        {
            p_77654_1_.field_77994_a--;
        }
        if(!p_77654_2_.field_72995_K)
        {
            List list = func_77832_l(p_77654_1_);
            if(list != null)
            {
                PotionEffect potioneffect;
                for(Iterator iterator = list.iterator(); iterator.hasNext(); p_77654_3_.func_70690_d(new PotionEffect(potioneffect)))
                {
                    potioneffect = (PotionEffect)iterator.next();
                }

            }
        }
        if(!p_77654_3_.field_71075_bZ.field_75098_d)
        {
            if(p_77654_1_.field_77994_a <= 0)
            {
                return new ItemStack(Item.field_77729_bt);
            }
            p_77654_3_.field_71071_by.func_70441_a(new ItemStack(Item.field_77729_bt));
        }
        return p_77654_1_;
    }

    public int func_77626_a(ItemStack p_77626_1_)
    {
        return 32;
    }

    public EnumAction func_77661_b(ItemStack p_77661_1_)
    {
        return EnumAction.drink;
    }

    public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
        if(func_77831_g(p_77659_1_.func_77960_j()))
        {
            if(!p_77659_3_.field_71075_bZ.field_75098_d)
            {
                p_77659_1_.field_77994_a--;
            }
            p_77659_2_.func_72956_a(p_77659_3_, "random.bow", 0.5F, 0.4F / (field_77697_d.nextFloat() * 0.4F + 0.8F));
            if(!p_77659_2_.field_72995_K)
            {
                p_77659_2_.func_72838_d(new EntityPotion(p_77659_2_, p_77659_3_, p_77659_1_.func_77960_j()));
            }
            return p_77659_1_;
        } else
        {
            p_77659_3_.func_71008_a(p_77659_1_, func_77626_a(p_77659_1_));
            return p_77659_1_;
        }
    }

    public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int i, int j, int k, int l, 
            float f, float f1, float f2)
    {
        return false;
    }

    public int func_77617_a(int p_77617_1_)
    {
        return !func_77831_g(p_77617_1_) ? 140 : 154;
    }

    public int func_77618_c(int p_77618_1_, int p_77618_2_)
    {
        if(p_77618_2_ == 0)
        {
            return 141;
        } else
        {
            return super.func_77618_c(p_77618_1_, p_77618_2_);
        }
    }

    public static boolean func_77831_g(int p_77831_0_)
    {
        return (p_77831_0_ & 0x4000) != 0;
    }

    public int func_77620_a(int p_77620_1_, int p_77620_2_)
    {
        if(p_77620_2_ > 0)
        {
            return 0xffffff;
        } else
        {
            return PotionHelper.func_77915_a(p_77620_1_, false);
        }
    }

    public boolean func_77623_v()
    {
        return true;
    }

    public boolean func_77833_h(int p_77833_1_)
    {
        List list = func_77834_f(p_77833_1_);
        if(list == null || list.isEmpty())
        {
            return false;
        }
        for(Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            PotionEffect potioneffect = (PotionEffect)iterator.next();
            if(Potion.field_76425_a[potioneffect.func_76456_a()].func_76403_b())
            {
                return true;
            }
        }

        return false;
    }

    public String func_77628_j(ItemStack p_77628_1_)
    {
        if(p_77628_1_.func_77960_j() == 0)
        {
            return StatCollector.func_74838_a("item.emptyPotion.name").trim();
        }
        String s = "";
        if(func_77831_g(p_77628_1_.func_77960_j()))
        {
            s = (new StringBuilder()).append(StatCollector.func_74838_a("potion.prefix.grenade").trim()).append(" ").toString();
        }
        List list = Item.field_77726_bs.func_77832_l(p_77628_1_);
        if(list != null && !list.isEmpty())
        {
            String s1 = ((PotionEffect)list.get(0)).func_76453_d();
            s1 = (new StringBuilder()).append(s1).append(".postfix").toString();
            return (new StringBuilder()).append(s).append(StatCollector.func_74838_a(s1).trim()).toString();
        } else
        {
            String s2 = PotionHelper.func_77905_c(p_77628_1_.func_77960_j());
            return (new StringBuilder()).append(StatCollector.func_74838_a(s2).trim()).append(" ").append(super.func_77628_j(p_77628_1_)).toString();
        }
    }

    public void func_77624_a(ItemStack p_77624_1_, List p_77624_2_)
    {
        if(p_77624_1_.func_77960_j() == 0)
        {
            return;
        }
        List list = Item.field_77726_bs.func_77832_l(p_77624_1_);
        if(list != null && !list.isEmpty())
        {
            for(Iterator iterator = list.iterator(); iterator.hasNext();)
            {
                PotionEffect potioneffect = (PotionEffect)iterator.next();
                String s1 = StatCollector.func_74838_a(potioneffect.func_76453_d()).trim();
                if(potioneffect.func_76458_c() > 0)
                {
                    s1 = (new StringBuilder()).append(s1).append(" ").append(StatCollector.func_74838_a((new StringBuilder()).append("potion.potency.").append(potioneffect.func_76458_c()).toString()).trim()).toString();
                }
                if(potioneffect.func_76459_b() > 20)
                {
                    s1 = (new StringBuilder()).append(s1).append(" (").append(Potion.func_76389_a(potioneffect)).append(")").toString();
                }
                if(Potion.field_76425_a[potioneffect.func_76456_a()].func_76398_f())
                {
                    p_77624_2_.add((new StringBuilder()).append("\247c").append(s1).toString());
                } else
                {
                    p_77624_2_.add((new StringBuilder()).append("\2477").append(s1).toString());
                }
            }

        } else
        {
            String s = StatCollector.func_74838_a("potion.empty").trim();
            p_77624_2_.add((new StringBuilder()).append("\2477").append(s).toString());
        }
    }

    public boolean func_77636_d(ItemStack p_77636_1_)
    {
        List list = func_77832_l(p_77636_1_);
        return list != null && !list.isEmpty();
    }

    public void func_77633_a(int p_77633_1_, CreativeTabs p_77633_2_, List p_77633_3_)
    {
        super.func_77633_a(p_77633_1_, p_77633_2_, p_77633_3_);
        if(field_77835_b.isEmpty())
        {
            for(int i = 0; i <= 32767; i++)
            {
                List list = PotionHelper.func_77917_b(i, false);
                if(list != null && !list.isEmpty())
                {
                    field_77835_b.put(list, Integer.valueOf(i));
                }
            }

        }
        int j;
        for(Iterator iterator = field_77835_b.values().iterator(); iterator.hasNext(); p_77633_3_.add(new ItemStack(p_77633_1_, 1, j)))
        {
            j = ((Integer)iterator.next()).intValue();
        }

    }

}
