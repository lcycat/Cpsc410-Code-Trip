// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            IInventory, ItemStack, Item, NBTTagCompound, 
//            EntityPlayer, PlayerCapabilities, NBTTagList, Block, 
//            Material, ItemArmor, Entity

public class InventoryPlayer
    implements IInventory
{

    public ItemStack field_70462_a[];
    public ItemStack field_70460_b[];
    public int field_70461_c;
    private ItemStack field_70456_f;
    public EntityPlayer field_70458_d;
    private ItemStack field_70457_g;
    public boolean field_70459_e;

    public InventoryPlayer(EntityPlayer p_i3562_1_)
    {
        field_70462_a = new ItemStack[36];
        field_70460_b = new ItemStack[4];
        field_70461_c = 0;
        field_70459_e = false;
        field_70458_d = p_i3562_1_;
    }

    public ItemStack func_70448_g()
    {
        if(field_70461_c < 9 && field_70461_c >= 0)
        {
            return field_70462_a[field_70461_c];
        } else
        {
            return null;
        }
    }

    public static int func_70451_h()
    {
        return 9;
    }

    private int func_70446_h(int p_70446_1_)
    {
        for(int i = 0; i < field_70462_a.length; i++)
        {
            if(field_70462_a[i] != null && field_70462_a[i].field_77993_c == p_70446_1_)
            {
                return i;
            }
        }

        return -1;
    }

    private int func_70434_c(int p_70434_1_, int p_70434_2_)
    {
        for(int i = 0; i < field_70462_a.length; i++)
        {
            if(field_70462_a[i] != null && field_70462_a[i].field_77993_c == p_70434_1_ && field_70462_a[i].func_77960_j() == p_70434_2_)
            {
                return i;
            }
        }

        return -1;
    }

    private int func_70432_d(ItemStack p_70432_1_)
    {
        for(int i = 0; i < field_70462_a.length; i++)
        {
            if(field_70462_a[i] != null && field_70462_a[i].field_77993_c == p_70432_1_.field_77993_c && field_70462_a[i].func_77985_e() && field_70462_a[i].field_77994_a < field_70462_a[i].func_77976_d() && field_70462_a[i].field_77994_a < func_70297_j_() && (!field_70462_a[i].func_77981_g() || field_70462_a[i].func_77960_j() == p_70432_1_.func_77960_j()) && ItemStack.func_77970_a(field_70462_a[i], p_70432_1_))
            {
                return i;
            }
        }

        return -1;
    }

    public int func_70447_i()
    {
        for(int i = 0; i < field_70462_a.length; i++)
        {
            if(field_70462_a[i] == null)
            {
                return i;
            }
        }

        return -1;
    }

    public void func_70433_a(int p_70433_1_, int p_70433_2_, boolean p_70433_3_, boolean p_70433_4_)
    {
        int i = -1;
        field_70456_f = func_70448_g();
        if(p_70433_3_)
        {
            i = func_70434_c(p_70433_1_, p_70433_2_);
        } else
        {
            i = func_70446_h(p_70433_1_);
        }
        if(i >= 0 && i < 9)
        {
            field_70461_c = i;
            return;
        }
        if(p_70433_4_ && p_70433_1_ > 0)
        {
            int j = func_70447_i();
            if(j >= 0 && j < 9)
            {
                field_70461_c = j;
            }
            func_70439_a(Item.field_77698_e[p_70433_1_], p_70433_2_);
        }
    }

    public void func_70453_c(int p_70453_1_)
    {
        if(p_70453_1_ > 0)
        {
            p_70453_1_ = 1;
        }
        if(p_70453_1_ < 0)
        {
            p_70453_1_ = -1;
        }
        for(field_70461_c -= p_70453_1_; field_70461_c < 0; field_70461_c += 9) { }
        for(; field_70461_c >= 9; field_70461_c -= 9) { }
    }

    public void func_70439_a(Item p_70439_1_, int p_70439_2_)
    {
        if(p_70439_1_ != null)
        {
            int i = func_70434_c(p_70439_1_.field_77779_bT, p_70439_2_);
            if(i >= 0)
            {
                field_70462_a[i] = field_70462_a[field_70461_c];
            }
            if(field_70456_f != null && field_70456_f.func_77956_u() && func_70434_c(field_70456_f.field_77993_c, field_70456_f.func_77952_i()) == field_70461_c)
            {
                return;
            }
            field_70462_a[field_70461_c] = new ItemStack(Item.field_77698_e[p_70439_1_.field_77779_bT], 1, p_70439_2_);
        }
    }

    private int func_70452_e(ItemStack p_70452_1_)
    {
        int i = p_70452_1_.field_77993_c;
        int j = p_70452_1_.field_77994_a;
        if(p_70452_1_.func_77976_d() == 1)
        {
            int k = func_70447_i();
            if(k < 0)
            {
                return j;
            }
            if(field_70462_a[k] == null)
            {
                field_70462_a[k] = ItemStack.func_77944_b(p_70452_1_);
            }
            return 0;
        }
        int l = func_70432_d(p_70452_1_);
        if(l < 0)
        {
            l = func_70447_i();
        }
        if(l < 0)
        {
            return j;
        }
        if(field_70462_a[l] == null)
        {
            field_70462_a[l] = new ItemStack(i, 0, p_70452_1_.func_77960_j());
            if(p_70452_1_.func_77942_o())
            {
                field_70462_a[l].func_77982_d((NBTTagCompound)p_70452_1_.func_77978_p().func_74737_b());
            }
        }
        int i1 = j;
        if(i1 > field_70462_a[l].func_77976_d() - field_70462_a[l].field_77994_a)
        {
            i1 = field_70462_a[l].func_77976_d() - field_70462_a[l].field_77994_a;
        }
        if(i1 > func_70297_j_() - field_70462_a[l].field_77994_a)
        {
            i1 = func_70297_j_() - field_70462_a[l].field_77994_a;
        }
        if(i1 == 0)
        {
            return j;
        } else
        {
            j -= i1;
            field_70462_a[l].field_77994_a += i1;
            field_70462_a[l].field_77992_b = 5;
            return j;
        }
    }

    public void func_70429_k()
    {
        for(int i = 0; i < field_70462_a.length; i++)
        {
            if(field_70462_a[i] != null)
            {
                field_70462_a[i].func_77945_a(field_70458_d.field_70170_p, field_70458_d, i, field_70461_c == i);
            }
        }

    }

    public boolean func_70435_d(int p_70435_1_)
    {
        int i = func_70446_h(p_70435_1_);
        if(i < 0)
        {
            return false;
        }
        if(--field_70462_a[i].field_77994_a <= 0)
        {
            field_70462_a[i] = null;
        }
        return true;
    }

    public boolean func_70450_e(int p_70450_1_)
    {
        int i = func_70446_h(p_70450_1_);
        return i >= 0;
    }

    public boolean func_70441_a(ItemStack p_70441_1_)
    {
        if(!p_70441_1_.func_77951_h())
        {
            int i;
            do
            {
                i = p_70441_1_.field_77994_a;
                p_70441_1_.field_77994_a = func_70452_e(p_70441_1_);
            } while(p_70441_1_.field_77994_a > 0 && p_70441_1_.field_77994_a < i);
            if(p_70441_1_.field_77994_a == i && field_70458_d.field_71075_bZ.field_75098_d)
            {
                p_70441_1_.field_77994_a = 0;
                return true;
            } else
            {
                return p_70441_1_.field_77994_a < i;
            }
        }
        int j = func_70447_i();
        if(j >= 0)
        {
            field_70462_a[j] = ItemStack.func_77944_b(p_70441_1_);
            field_70462_a[j].field_77992_b = 5;
            p_70441_1_.field_77994_a = 0;
            return true;
        }
        if(field_70458_d.field_71075_bZ.field_75098_d)
        {
            p_70441_1_.field_77994_a = 0;
            return true;
        } else
        {
            return false;
        }
    }

    public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_)
    {
        ItemStack aitemstack[] = field_70462_a;
        if(p_70298_1_ >= field_70462_a.length)
        {
            aitemstack = field_70460_b;
            p_70298_1_ -= field_70462_a.length;
        }
        if(aitemstack[p_70298_1_] != null)
        {
            if(aitemstack[p_70298_1_].field_77994_a <= p_70298_2_)
            {
                ItemStack itemstack = aitemstack[p_70298_1_];
                aitemstack[p_70298_1_] = null;
                return itemstack;
            }
            ItemStack itemstack1 = aitemstack[p_70298_1_].func_77979_a(p_70298_2_);
            if(aitemstack[p_70298_1_].field_77994_a == 0)
            {
                aitemstack[p_70298_1_] = null;
            }
            return itemstack1;
        } else
        {
            return null;
        }
    }

    public ItemStack func_70304_b(int p_70304_1_)
    {
        ItemStack aitemstack[] = field_70462_a;
        if(p_70304_1_ >= field_70462_a.length)
        {
            aitemstack = field_70460_b;
            p_70304_1_ -= field_70462_a.length;
        }
        if(aitemstack[p_70304_1_] != null)
        {
            ItemStack itemstack = aitemstack[p_70304_1_];
            aitemstack[p_70304_1_] = null;
            return itemstack;
        } else
        {
            return null;
        }
    }

    public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_)
    {
        ItemStack aitemstack[] = field_70462_a;
        if(p_70299_1_ >= aitemstack.length)
        {
            p_70299_1_ -= aitemstack.length;
            aitemstack = field_70460_b;
        }
        aitemstack[p_70299_1_] = p_70299_2_;
    }

    public float func_70438_a(Block p_70438_1_)
    {
        float f = 1.0F;
        if(field_70462_a[field_70461_c] != null)
        {
            f *= field_70462_a[field_70461_c].func_77967_a(p_70438_1_);
        }
        return f;
    }

    public NBTTagList func_70442_a(NBTTagList p_70442_1_)
    {
        for(int i = 0; i < field_70462_a.length; i++)
        {
            if(field_70462_a[i] != null)
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.func_74774_a("Slot", (byte)i);
                field_70462_a[i].func_77955_b(nbttagcompound);
                p_70442_1_.func_74742_a(nbttagcompound);
            }
        }

        for(int j = 0; j < field_70460_b.length; j++)
        {
            if(field_70460_b[j] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.func_74774_a("Slot", (byte)(j + 100));
                field_70460_b[j].func_77955_b(nbttagcompound1);
                p_70442_1_.func_74742_a(nbttagcompound1);
            }
        }

        return p_70442_1_;
    }

    public void func_70443_b(NBTTagList p_70443_1_)
    {
        field_70462_a = new ItemStack[36];
        field_70460_b = new ItemStack[4];
        for(int i = 0; i < p_70443_1_.func_74745_c(); i++)
        {
            NBTTagCompound nbttagcompound = (NBTTagCompound)p_70443_1_.func_74743_b(i);
            int j = nbttagcompound.func_74771_c("Slot") & 0xff;
            ItemStack itemstack = ItemStack.func_77949_a(nbttagcompound);
            if(itemstack == null)
            {
                continue;
            }
            if(j >= 0 && j < field_70462_a.length)
            {
                field_70462_a[j] = itemstack;
            }
            if(j >= 100 && j < field_70460_b.length + 100)
            {
                field_70460_b[j - 100] = itemstack;
            }
        }

    }

    public int func_70302_i_()
    {
        return field_70462_a.length + 4;
    }

    public ItemStack func_70301_a(int p_70301_1_)
    {
        ItemStack aitemstack[] = field_70462_a;
        if(p_70301_1_ >= aitemstack.length)
        {
            p_70301_1_ -= aitemstack.length;
            aitemstack = field_70460_b;
        }
        return aitemstack[p_70301_1_];
    }

    public String func_70303_b()
    {
        return "container.inventory";
    }

    public int func_70297_j_()
    {
        return 64;
    }

    public int func_70444_a(Entity p_70444_1_)
    {
        ItemStack itemstack = func_70301_a(field_70461_c);
        if(itemstack != null)
        {
            return itemstack.func_77971_a(p_70444_1_);
        } else
        {
            return 1;
        }
    }

    public boolean func_70454_b(Block p_70454_1_)
    {
        if(p_70454_1_.field_72018_cp.func_76229_l())
        {
            return true;
        }
        ItemStack itemstack = func_70301_a(field_70461_c);
        if(itemstack != null)
        {
            return itemstack.func_77987_b(p_70454_1_);
        } else
        {
            return false;
        }
    }

    public ItemStack func_70440_f(int p_70440_1_)
    {
        return field_70460_b[p_70440_1_];
    }

    public int func_70430_l()
    {
        int i = 0;
        ItemStack aitemstack[] = field_70460_b;
        int j = aitemstack.length;
        for(int k = 0; k < j; k++)
        {
            ItemStack itemstack = aitemstack[k];
            if(itemstack != null && (itemstack.func_77973_b() instanceof ItemArmor))
            {
                int l = ((ItemArmor)itemstack.func_77973_b()).field_77879_b;
                i += l;
            }
        }

        return i;
    }

    public void func_70449_g(int p_70449_1_)
    {
        p_70449_1_ /= 4;
        if(p_70449_1_ < 1)
        {
            p_70449_1_ = 1;
        }
        for(int i = 0; i < field_70460_b.length; i++)
        {
            if(field_70460_b[i] == null || !(field_70460_b[i].func_77973_b() instanceof ItemArmor))
            {
                continue;
            }
            field_70460_b[i].func_77972_a(p_70449_1_, field_70458_d);
            if(field_70460_b[i].field_77994_a == 0)
            {
                field_70460_b[i] = null;
            }
        }

    }

    public void func_70436_m()
    {
        for(int i = 0; i < field_70462_a.length; i++)
        {
            if(field_70462_a[i] != null)
            {
                field_70458_d.func_71019_a(field_70462_a[i], true);
                field_70462_a[i] = null;
            }
        }

        for(int j = 0; j < field_70460_b.length; j++)
        {
            if(field_70460_b[j] != null)
            {
                field_70458_d.func_71019_a(field_70460_b[j], true);
                field_70460_b[j] = null;
            }
        }

    }

    public void func_70296_d()
    {
        field_70459_e = true;
    }

    public void func_70437_b(ItemStack p_70437_1_)
    {
        field_70457_g = p_70437_1_;
    }

    public ItemStack func_70445_o()
    {
        return field_70457_g;
    }

    public boolean func_70300_a(EntityPlayer p_70300_1_)
    {
        if(field_70458_d.field_70128_L)
        {
            return false;
        }
        return p_70300_1_.func_70068_e(field_70458_d) <= 64D;
    }

    public boolean func_70431_c(ItemStack p_70431_1_)
    {
        ItemStack aitemstack[] = field_70460_b;
        int i = aitemstack.length;
        for(int j = 0; j < i; j++)
        {
            ItemStack itemstack = aitemstack[j];
            if(itemstack != null && itemstack.func_77965_c(p_70431_1_))
            {
                return true;
            }
        }

        aitemstack = field_70462_a;
        i = aitemstack.length;
        for(int k = 0; k < i; k++)
        {
            ItemStack itemstack1 = aitemstack[k];
            if(itemstack1 != null && itemstack1.func_77965_c(p_70431_1_))
            {
                return true;
            }
        }

        return false;
    }

    public void func_70295_k_()
    {
    }

    public void func_70305_f()
    {
    }

    public void func_70455_b(InventoryPlayer p_70455_1_)
    {
        for(int i = 0; i < field_70462_a.length; i++)
        {
            field_70462_a[i] = ItemStack.func_77944_b(p_70455_1_.field_70462_a[i]);
        }

        for(int j = 0; j < field_70460_b.length; j++)
        {
            field_70460_b[j] = ItemStack.func_77944_b(p_70455_1_.field_70460_b[j]);
        }

    }
}
