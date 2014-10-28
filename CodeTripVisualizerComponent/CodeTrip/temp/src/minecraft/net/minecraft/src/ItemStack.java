// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            Block, Item, NBTTagCompound, StatList, 
//            EntityPlayer, EnchantmentHelper, EntityLiving, World, 
//            PlayerCapabilities, NBTTagList, Enchantment, Entity, 
//            EnumAction, EnumRarity, NBTBase

public final class ItemStack
{

    public int field_77994_a;
    public int field_77992_b;
    public int field_77993_c;
    public NBTTagCompound field_77990_d;
    private int field_77991_e;

    public ItemStack(Block p_i3660_1_)
    {
        this(p_i3660_1_, 1);
    }

    public ItemStack(Block p_i3661_1_, int p_i3661_2_)
    {
        this(p_i3661_1_.field_71990_ca, p_i3661_2_, 0);
    }

    public ItemStack(Block p_i3662_1_, int p_i3662_2_, int p_i3662_3_)
    {
        this(p_i3662_1_.field_71990_ca, p_i3662_2_, p_i3662_3_);
    }

    public ItemStack(Item p_i3663_1_)
    {
        this(p_i3663_1_.field_77779_bT, 1, 0);
    }

    public ItemStack(Item p_i3664_1_, int p_i3664_2_)
    {
        this(p_i3664_1_.field_77779_bT, p_i3664_2_, 0);
    }

    public ItemStack(Item p_i3665_1_, int p_i3665_2_, int p_i3665_3_)
    {
        this(p_i3665_1_.field_77779_bT, p_i3665_2_, p_i3665_3_);
    }

    public ItemStack(int p_i3666_1_, int p_i3666_2_, int p_i3666_3_)
    {
        field_77994_a = 0;
        field_77993_c = p_i3666_1_;
        field_77994_a = p_i3666_2_;
        field_77991_e = p_i3666_3_;
    }

    public static ItemStack func_77949_a(NBTTagCompound p_77949_0_)
    {
        ItemStack itemstack = new ItemStack();
        itemstack.func_77963_c(p_77949_0_);
        return itemstack.func_77973_b() == null ? null : itemstack;
    }

    private ItemStack()
    {
        field_77994_a = 0;
    }

    public ItemStack func_77979_a(int p_77979_1_)
    {
        ItemStack itemstack = new ItemStack(field_77993_c, p_77979_1_, field_77991_e);
        if(field_77990_d != null)
        {
            itemstack.field_77990_d = (NBTTagCompound)field_77990_d.func_74737_b();
        }
        field_77994_a -= p_77979_1_;
        return itemstack;
    }

    public Item func_77973_b()
    {
        return Item.field_77698_e[field_77993_c];
    }

    public int func_77954_c()
    {
        return func_77973_b().func_77650_f(this);
    }

    public boolean func_77943_a(EntityPlayer p_77943_1_, World p_77943_2_, int p_77943_3_, int p_77943_4_, int p_77943_5_, int p_77943_6_, float p_77943_7_, 
            float p_77943_8_, float p_77943_9_)
    {
        boolean flag = func_77973_b().func_77648_a(this, p_77943_1_, p_77943_2_, p_77943_3_, p_77943_4_, p_77943_5_, p_77943_6_, p_77943_7_, p_77943_8_, p_77943_9_);
        if(flag)
        {
            p_77943_1_.func_71064_a(StatList.field_75929_E[field_77993_c], 1);
        }
        return flag;
    }

    public float func_77967_a(Block p_77967_1_)
    {
        return func_77973_b().func_77638_a(this, p_77967_1_);
    }

    public ItemStack func_77957_a(World p_77957_1_, EntityPlayer p_77957_2_)
    {
        return func_77973_b().func_77659_a(this, p_77957_1_, p_77957_2_);
    }

    public ItemStack func_77950_b(World p_77950_1_, EntityPlayer p_77950_2_)
    {
        return func_77973_b().func_77654_b(this, p_77950_1_, p_77950_2_);
    }

    public NBTTagCompound func_77955_b(NBTTagCompound p_77955_1_)
    {
        p_77955_1_.func_74777_a("id", (short)field_77993_c);
        p_77955_1_.func_74774_a("Count", (byte)field_77994_a);
        p_77955_1_.func_74777_a("Damage", (short)field_77991_e);
        if(field_77990_d != null)
        {
            p_77955_1_.func_74782_a("tag", field_77990_d);
        }
        return p_77955_1_;
    }

    public void func_77963_c(NBTTagCompound p_77963_1_)
    {
        field_77993_c = p_77963_1_.func_74765_d("id");
        field_77994_a = p_77963_1_.func_74771_c("Count");
        field_77991_e = p_77963_1_.func_74765_d("Damage");
        if(p_77963_1_.func_74764_b("tag"))
        {
            field_77990_d = p_77963_1_.func_74775_l("tag");
        }
    }

    public int func_77976_d()
    {
        return func_77973_b().func_77639_j();
    }

    public boolean func_77985_e()
    {
        return func_77976_d() > 1 && (!func_77984_f() || !func_77951_h());
    }

    public boolean func_77984_f()
    {
        return Item.field_77698_e[field_77993_c].func_77612_l() > 0;
    }

    public boolean func_77981_g()
    {
        return Item.field_77698_e[field_77993_c].func_77614_k();
    }

    public boolean func_77951_h()
    {
        return func_77984_f() && field_77991_e > 0;
    }

    public int func_77952_i()
    {
        return field_77991_e;
    }

    public int func_77960_j()
    {
        return field_77991_e;
    }

    public void func_77964_b(int p_77964_1_)
    {
        field_77991_e = p_77964_1_;
    }

    public int func_77958_k()
    {
        return Item.field_77698_e[field_77993_c].func_77612_l();
    }

    public void func_77972_a(int p_77972_1_, EntityLiving p_77972_2_)
    {
        if(!func_77984_f())
        {
            return;
        }
        if(p_77972_1_ > 0 && (p_77972_2_ instanceof EntityPlayer))
        {
            int i = EnchantmentHelper.func_77503_c(((EntityPlayer)p_77972_2_).field_71071_by);
            if(i > 0 && p_77972_2_.field_70170_p.field_73012_v.nextInt(i + 1) > 0)
            {
                return;
            }
        }
        if(!(p_77972_2_ instanceof EntityPlayer) || !((EntityPlayer)p_77972_2_).field_71075_bZ.field_75098_d)
        {
            field_77991_e += p_77972_1_;
        }
        if(field_77991_e > func_77958_k())
        {
            p_77972_2_.func_70669_a(this);
            if(p_77972_2_ instanceof EntityPlayer)
            {
                ((EntityPlayer)p_77972_2_).func_71064_a(StatList.field_75930_F[field_77993_c], 1);
            }
            field_77994_a--;
            if(field_77994_a < 0)
            {
                field_77994_a = 0;
            }
            field_77991_e = 0;
        }
    }

    public void func_77961_a(EntityLiving p_77961_1_, EntityPlayer p_77961_2_)
    {
        boolean flag = Item.field_77698_e[field_77993_c].func_77644_a(this, p_77961_1_, p_77961_2_);
        if(flag)
        {
            p_77961_2_.func_71064_a(StatList.field_75929_E[field_77993_c], 1);
        }
    }

    public void func_77941_a(World p_77941_1_, int p_77941_2_, int p_77941_3_, int p_77941_4_, int p_77941_5_, EntityPlayer p_77941_6_)
    {
        boolean flag = Item.field_77698_e[field_77993_c].func_77660_a(this, p_77941_1_, p_77941_2_, p_77941_3_, p_77941_4_, p_77941_5_, p_77941_6_);
        if(flag)
        {
            p_77941_6_.func_71064_a(StatList.field_75929_E[field_77993_c], 1);
        }
    }

    public int func_77971_a(Entity p_77971_1_)
    {
        return Item.field_77698_e[field_77993_c].func_77649_a(p_77971_1_);
    }

    public boolean func_77987_b(Block p_77987_1_)
    {
        return Item.field_77698_e[field_77993_c].func_77641_a(p_77987_1_);
    }

    public boolean func_77947_a(EntityLiving p_77947_1_)
    {
        return Item.field_77698_e[field_77993_c].func_77646_a(this, p_77947_1_);
    }

    public ItemStack func_77946_l()
    {
        ItemStack itemstack = new ItemStack(field_77993_c, field_77994_a, field_77991_e);
        if(field_77990_d != null)
        {
            itemstack.field_77990_d = (NBTTagCompound)field_77990_d.func_74737_b();
        }
        return itemstack;
    }

    public static boolean func_77970_a(ItemStack p_77970_0_, ItemStack p_77970_1_)
    {
        if(p_77970_0_ == null && p_77970_1_ == null)
        {
            return true;
        }
        if(p_77970_0_ == null || p_77970_1_ == null)
        {
            return false;
        }
        if(p_77970_0_.field_77990_d == null && p_77970_1_.field_77990_d != null)
        {
            return false;
        }
        return p_77970_0_.field_77990_d == null || p_77970_0_.field_77990_d.equals(p_77970_1_.field_77990_d);
    }

    public static boolean func_77989_b(ItemStack p_77989_0_, ItemStack p_77989_1_)
    {
        if(p_77989_0_ == null && p_77989_1_ == null)
        {
            return true;
        }
        if(p_77989_0_ == null || p_77989_1_ == null)
        {
            return false;
        } else
        {
            return p_77989_0_.func_77959_d(p_77989_1_);
        }
    }

    private boolean func_77959_d(ItemStack p_77959_1_)
    {
        if(field_77994_a != p_77959_1_.field_77994_a)
        {
            return false;
        }
        if(field_77993_c != p_77959_1_.field_77993_c)
        {
            return false;
        }
        if(field_77991_e != p_77959_1_.field_77991_e)
        {
            return false;
        }
        if(field_77990_d == null && p_77959_1_.field_77990_d != null)
        {
            return false;
        }
        return field_77990_d == null || field_77990_d.equals(p_77959_1_.field_77990_d);
    }

    public boolean func_77969_a(ItemStack p_77969_1_)
    {
        return field_77993_c == p_77969_1_.field_77993_c && field_77991_e == p_77969_1_.field_77991_e;
    }

    public String func_77977_a()
    {
        return Item.field_77698_e[field_77993_c].func_77667_c(this);
    }

    public static ItemStack func_77944_b(ItemStack p_77944_0_)
    {
        return p_77944_0_ != null ? p_77944_0_.func_77946_l() : null;
    }

    public String toString()
    {
        return (new StringBuilder()).append(field_77994_a).append("x").append(Item.field_77698_e[field_77993_c].func_77658_a()).append("@").append(field_77991_e).toString();
    }

    public void func_77945_a(World p_77945_1_, Entity p_77945_2_, int p_77945_3_, boolean p_77945_4_)
    {
        if(field_77992_b > 0)
        {
            field_77992_b--;
        }
        Item.field_77698_e[field_77993_c].func_77663_a(this, p_77945_1_, p_77945_2_, p_77945_3_, p_77945_4_);
    }

    public void func_77980_a(World p_77980_1_, EntityPlayer p_77980_2_, int p_77980_3_)
    {
        p_77980_2_.func_71064_a(StatList.field_75928_D[field_77993_c], p_77980_3_);
        Item.field_77698_e[field_77993_c].func_77622_d(this, p_77980_1_, p_77980_2_);
    }

    public boolean func_77965_c(ItemStack p_77965_1_)
    {
        return field_77993_c == p_77965_1_.field_77993_c && field_77994_a == p_77965_1_.field_77994_a && field_77991_e == p_77965_1_.field_77991_e;
    }

    public int func_77988_m()
    {
        return func_77973_b().func_77626_a(this);
    }

    public EnumAction func_77975_n()
    {
        return func_77973_b().func_77661_b(this);
    }

    public void func_77974_b(World p_77974_1_, EntityPlayer p_77974_2_, int p_77974_3_)
    {
        func_77973_b().func_77615_a(this, p_77974_1_, p_77974_2_, p_77974_3_);
    }

    public boolean func_77942_o()
    {
        return field_77990_d != null;
    }

    public NBTTagCompound func_77978_p()
    {
        return field_77990_d;
    }

    public NBTTagList func_77986_q()
    {
        if(field_77990_d == null)
        {
            return null;
        } else
        {
            return (NBTTagList)field_77990_d.func_74781_a("ench");
        }
    }

    public void func_77982_d(NBTTagCompound p_77982_1_)
    {
        field_77990_d = p_77982_1_;
    }

    public List func_77968_r()
    {
        ArrayList arraylist = new ArrayList();
        Item item = Item.field_77698_e[field_77993_c];
        arraylist.add(item.func_77628_j(this));
        item.func_77624_a(this, arraylist);
        if(func_77942_o())
        {
            NBTTagList nbttaglist = func_77986_q();
            if(nbttaglist != null)
            {
                for(int i = 0; i < nbttaglist.func_74745_c(); i++)
                {
                    short word0 = ((NBTTagCompound)nbttaglist.func_74743_b(i)).func_74765_d("id");
                    short word1 = ((NBTTagCompound)nbttaglist.func_74743_b(i)).func_74765_d("lvl");
                    if(Enchantment.field_77331_b[word0] != null)
                    {
                        arraylist.add(Enchantment.field_77331_b[word0].func_77316_c(word1));
                    }
                }

            }
        }
        return arraylist;
    }

    public boolean func_77962_s()
    {
        return func_77973_b().func_77636_d(this);
    }

    public EnumRarity func_77953_t()
    {
        return func_77973_b().func_77613_e(this);
    }

    public boolean func_77956_u()
    {
        if(!func_77973_b().func_77616_k(this))
        {
            return false;
        }
        return !func_77948_v();
    }

    public void func_77966_a(Enchantment p_77966_1_, int p_77966_2_)
    {
        if(field_77990_d == null)
        {
            func_77982_d(new NBTTagCompound());
        }
        if(!field_77990_d.func_74764_b("ench"))
        {
            field_77990_d.func_74782_a("ench", new NBTTagList("ench"));
        }
        NBTTagList nbttaglist = (NBTTagList)field_77990_d.func_74781_a("ench");
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        nbttagcompound.func_74777_a("id", (short)p_77966_1_.field_77352_x);
        nbttagcompound.func_74777_a("lvl", (byte)p_77966_2_);
        nbttaglist.func_74742_a(nbttagcompound);
    }

    public boolean func_77948_v()
    {
        return field_77990_d != null && field_77990_d.func_74764_b("ench");
    }

    public void func_77983_a(String p_77983_1_, NBTBase p_77983_2_)
    {
        if(field_77990_d == null)
        {
            func_77982_d(new NBTTagCompound());
        }
        field_77990_d.func_74782_a(p_77983_1_, p_77983_2_);
    }
}
