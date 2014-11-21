// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            Slot, ICrafting, ItemStack, EntityPlayer, 
//            InventoryPlayer, IInventory

public abstract class Container
{

    public List field_75153_a;
    public List field_75151_b;
    public int field_75152_c;
    private short field_75150_e;
    protected List field_75149_d;
    private Set field_75148_f;

    public Container()
    {
        field_75153_a = new ArrayList();
        field_75151_b = new ArrayList();
        field_75152_c = 0;
        field_75150_e = 0;
        field_75149_d = new ArrayList();
        field_75148_f = new HashSet();
    }

    protected Slot func_75146_a(Slot p_75146_1_)
    {
        p_75146_1_.field_75222_d = field_75151_b.size();
        field_75151_b.add(p_75146_1_);
        field_75153_a.add(null);
        return p_75146_1_;
    }

    public void func_75132_a(ICrafting p_75132_1_)
    {
        if(field_75149_d.contains(p_75132_1_))
        {
            throw new IllegalArgumentException("Listener already listening");
        } else
        {
            field_75149_d.add(p_75132_1_);
            p_75132_1_.func_71110_a(this, func_75138_a());
            func_75142_b();
            return;
        }
    }

    public List func_75138_a()
    {
        ArrayList arraylist = new ArrayList();
        Slot slot;
        for(Iterator iterator = field_75151_b.iterator(); iterator.hasNext(); arraylist.add(slot.func_75211_c()))
        {
            slot = (Slot)iterator.next();
        }

        return arraylist;
    }

    public void func_75142_b()
    {
        for(int i = 0; i < field_75151_b.size(); i++)
        {
            ItemStack itemstack = ((Slot)field_75151_b.get(i)).func_75211_c();
            ItemStack itemstack1 = (ItemStack)field_75153_a.get(i);
            if(ItemStack.func_77989_b(itemstack1, itemstack))
            {
                continue;
            }
            itemstack1 = itemstack != null ? itemstack.func_77946_l() : null;
            field_75153_a.set(i, itemstack1);
            ICrafting icrafting;
            for(Iterator iterator = field_75149_d.iterator(); iterator.hasNext(); icrafting.func_71111_a(this, i, itemstack1))
            {
                icrafting = (ICrafting)iterator.next();
            }

        }

    }

    public boolean func_75140_a(EntityPlayer p_75140_1_, int p_75140_2_)
    {
        return false;
    }

    public Slot func_75147_a(IInventory p_75147_1_, int p_75147_2_)
    {
        for(Iterator iterator = field_75151_b.iterator(); iterator.hasNext();)
        {
            Slot slot = (Slot)iterator.next();
            if(slot.func_75217_a(p_75147_1_, p_75147_2_))
            {
                return slot;
            }
        }

        return null;
    }

    public Slot func_75139_a(int p_75139_1_)
    {
        return (Slot)field_75151_b.get(p_75139_1_);
    }

    public ItemStack func_75143_b(int p_75143_1_)
    {
        Slot slot = (Slot)field_75151_b.get(p_75143_1_);
        if(slot != null)
        {
            return slot.func_75211_c();
        } else
        {
            return null;
        }
    }

    public ItemStack func_75144_a(int p_75144_1_, int p_75144_2_, boolean p_75144_3_, EntityPlayer p_75144_4_)
    {
        ItemStack itemstack = null;
        if(p_75144_2_ > 1)
        {
            return null;
        }
        if(p_75144_2_ == 0 || p_75144_2_ == 1)
        {
            InventoryPlayer inventoryplayer = p_75144_4_.field_71071_by;
            if(p_75144_1_ == -999)
            {
                if(inventoryplayer.func_70445_o() != null && p_75144_1_ == -999)
                {
                    if(p_75144_2_ == 0)
                    {
                        p_75144_4_.func_71021_b(inventoryplayer.func_70445_o());
                        inventoryplayer.func_70437_b(null);
                    }
                    if(p_75144_2_ == 1)
                    {
                        p_75144_4_.func_71021_b(inventoryplayer.func_70445_o().func_77979_a(1));
                        if(inventoryplayer.func_70445_o().field_77994_a == 0)
                        {
                            inventoryplayer.func_70437_b(null);
                        }
                    }
                }
            } else
            if(p_75144_3_)
            {
                ItemStack itemstack1 = func_75143_b(p_75144_1_);
                if(itemstack1 != null)
                {
                    int i = itemstack1.field_77993_c;
                    itemstack = itemstack1.func_77946_l();
                    Slot slot1 = (Slot)field_75151_b.get(p_75144_1_);
                    if(slot1 != null && slot1.func_75211_c() != null && slot1.func_75211_c().field_77993_c == i)
                    {
                        func_75133_b(p_75144_1_, p_75144_2_, p_75144_3_, p_75144_4_);
                    }
                }
            } else
            {
                if(p_75144_1_ < 0)
                {
                    return null;
                }
                Slot slot = (Slot)field_75151_b.get(p_75144_1_);
                if(slot != null)
                {
                    ItemStack itemstack2 = slot.func_75211_c();
                    ItemStack itemstack4 = inventoryplayer.func_70445_o();
                    if(itemstack2 != null)
                    {
                        itemstack = itemstack2.func_77946_l();
                    }
                    if(itemstack2 == null)
                    {
                        if(itemstack4 != null && slot.func_75214_a(itemstack4))
                        {
                            int j = p_75144_2_ != 0 ? 1 : itemstack4.field_77994_a;
                            if(j > slot.func_75219_a())
                            {
                                j = slot.func_75219_a();
                            }
                            slot.func_75215_d(itemstack4.func_77979_a(j));
                            if(itemstack4.field_77994_a == 0)
                            {
                                inventoryplayer.func_70437_b(null);
                            }
                        }
                    } else
                    if(itemstack4 == null)
                    {
                        int k = p_75144_2_ != 0 ? (itemstack2.field_77994_a + 1) / 2 : itemstack2.field_77994_a;
                        ItemStack itemstack5 = slot.func_75209_a(k);
                        inventoryplayer.func_70437_b(itemstack5);
                        if(itemstack2.field_77994_a == 0)
                        {
                            slot.func_75215_d(null);
                        }
                        slot.func_75213_b(inventoryplayer.func_70445_o());
                    } else
                    if(slot.func_75214_a(itemstack4))
                    {
                        if(itemstack2.field_77993_c != itemstack4.field_77993_c || itemstack2.func_77981_g() && itemstack2.func_77960_j() != itemstack4.func_77960_j() || !ItemStack.func_77970_a(itemstack2, itemstack4))
                        {
                            if(itemstack4.field_77994_a <= slot.func_75219_a())
                            {
                                slot.func_75215_d(itemstack4);
                                inventoryplayer.func_70437_b(itemstack2);
                            }
                        } else
                        {
                            int l = p_75144_2_ != 0 ? 1 : itemstack4.field_77994_a;
                            if(l > slot.func_75219_a() - itemstack2.field_77994_a)
                            {
                                l = slot.func_75219_a() - itemstack2.field_77994_a;
                            }
                            if(l > itemstack4.func_77976_d() - itemstack2.field_77994_a)
                            {
                                l = itemstack4.func_77976_d() - itemstack2.field_77994_a;
                            }
                            itemstack4.func_77979_a(l);
                            if(itemstack4.field_77994_a == 0)
                            {
                                inventoryplayer.func_70437_b(null);
                            }
                            itemstack2.field_77994_a += l;
                        }
                    } else
                    if(itemstack2.field_77993_c == itemstack4.field_77993_c && itemstack4.func_77976_d() > 1 && (!itemstack2.func_77981_g() || itemstack2.func_77960_j() == itemstack4.func_77960_j()) && ItemStack.func_77970_a(itemstack2, itemstack4))
                    {
                        int i1 = itemstack2.field_77994_a;
                        if(i1 > 0 && i1 + itemstack4.field_77994_a <= itemstack4.func_77976_d())
                        {
                            itemstack4.field_77994_a += i1;
                            ItemStack itemstack3 = slot.func_75209_a(i1);
                            if(itemstack3.field_77994_a == 0)
                            {
                                slot.func_75215_d(null);
                            }
                            slot.func_75213_b(inventoryplayer.func_70445_o());
                        }
                    }
                    slot.func_75218_e();
                }
            }
        }
        return itemstack;
    }

    protected void func_75133_b(int p_75133_1_, int p_75133_2_, boolean p_75133_3_, EntityPlayer p_75133_4_)
    {
        func_75144_a(p_75133_1_, p_75133_2_, p_75133_3_, p_75133_4_);
    }

    public void func_75134_a(EntityPlayer p_75134_1_)
    {
        InventoryPlayer inventoryplayer = p_75134_1_.field_71071_by;
        if(inventoryplayer.func_70445_o() != null)
        {
            p_75134_1_.func_71021_b(inventoryplayer.func_70445_o());
            inventoryplayer.func_70437_b(null);
        }
    }

    public void func_75130_a(IInventory p_75130_1_)
    {
        func_75142_b();
    }

    public void func_75141_a(int p_75141_1_, ItemStack p_75141_2_)
    {
        func_75139_a(p_75141_1_).func_75215_d(p_75141_2_);
    }

    public void func_75131_a(ItemStack p_75131_1_[])
    {
        for(int i = 0; i < p_75131_1_.length; i++)
        {
            func_75139_a(i).func_75215_d(p_75131_1_[i]);
        }

    }

    public void func_75137_b(int i, int j)
    {
    }

    public short func_75136_a(InventoryPlayer p_75136_1_)
    {
        field_75150_e++;
        return field_75150_e;
    }

    public boolean func_75129_b(EntityPlayer p_75129_1_)
    {
        return !field_75148_f.contains(p_75129_1_);
    }

    public void func_75128_a(EntityPlayer p_75128_1_, boolean p_75128_2_)
    {
        if(p_75128_2_)
        {
            field_75148_f.remove(p_75128_1_);
        } else
        {
            field_75148_f.add(p_75128_1_);
        }
    }

    public abstract boolean func_75145_c(EntityPlayer entityplayer);

    protected boolean func_75135_a(ItemStack p_75135_1_, int p_75135_2_, int p_75135_3_, boolean p_75135_4_)
    {
        boolean flag = false;
        int i = p_75135_2_;
        if(p_75135_4_)
        {
            i = p_75135_3_ - 1;
        }
        if(p_75135_1_.func_77985_e())
        {
            while(p_75135_1_.field_77994_a > 0 && (!p_75135_4_ && i < p_75135_3_ || p_75135_4_ && i >= p_75135_2_)) 
            {
                Slot slot = (Slot)field_75151_b.get(i);
                ItemStack itemstack = slot.func_75211_c();
                if(itemstack != null && itemstack.field_77993_c == p_75135_1_.field_77993_c && (!p_75135_1_.func_77981_g() || p_75135_1_.func_77960_j() == itemstack.func_77960_j()) && ItemStack.func_77970_a(p_75135_1_, itemstack))
                {
                    int k = itemstack.field_77994_a + p_75135_1_.field_77994_a;
                    if(k <= p_75135_1_.func_77976_d())
                    {
                        p_75135_1_.field_77994_a = 0;
                        itemstack.field_77994_a = k;
                        slot.func_75218_e();
                        flag = true;
                    } else
                    if(itemstack.field_77994_a < p_75135_1_.func_77976_d())
                    {
                        p_75135_1_.field_77994_a -= p_75135_1_.func_77976_d() - itemstack.field_77994_a;
                        itemstack.field_77994_a = p_75135_1_.func_77976_d();
                        slot.func_75218_e();
                        flag = true;
                    }
                }
                if(p_75135_4_)
                {
                    i--;
                } else
                {
                    i++;
                }
            }
        }
        if(p_75135_1_.field_77994_a > 0)
        {
            int j;
            if(p_75135_4_)
            {
                j = p_75135_3_ - 1;
            } else
            {
                j = p_75135_2_;
            }
            do
            {
                if((p_75135_4_ || j >= p_75135_3_) && (!p_75135_4_ || j < p_75135_2_))
                {
                    break;
                }
                Slot slot1 = (Slot)field_75151_b.get(j);
                ItemStack itemstack1 = slot1.func_75211_c();
                if(itemstack1 == null)
                {
                    slot1.func_75215_d(p_75135_1_.func_77946_l());
                    slot1.func_75218_e();
                    p_75135_1_.field_77994_a = 0;
                    flag = true;
                    break;
                }
                if(p_75135_4_)
                {
                    j--;
                } else
                {
                    j++;
                }
            } while(true);
        }
        return flag;
    }
}
