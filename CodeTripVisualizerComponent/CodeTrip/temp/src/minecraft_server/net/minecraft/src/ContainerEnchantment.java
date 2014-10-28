// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            Container, SlotEnchantmentTable, SlotEnchantment, Slot, 
//            ICrafting, IInventory, ItemStack, World, 
//            Block, EnchantmentHelper, EntityPlayer, PlayerCapabilities, 
//            EnchantmentData, InventoryPlayer

public class ContainerEnchantment extends Container
{

    public IInventory field_75168_e;
    private World field_75172_h;
    private int field_75173_i;
    private int field_75170_j;
    private int field_75171_k;
    private Random field_75169_l;
    public long field_75166_f;
    public int field_75167_g[];

    public ContainerEnchantment(InventoryPlayer p_i3606_1_, World p_i3606_2_, int p_i3606_3_, int p_i3606_4_, int p_i3606_5_)
    {
        field_75168_e = new SlotEnchantmentTable(this, "Enchant", 1);
        field_75169_l = new Random();
        field_75167_g = new int[3];
        field_75172_h = p_i3606_2_;
        field_75173_i = p_i3606_3_;
        field_75170_j = p_i3606_4_;
        field_75171_k = p_i3606_5_;
        func_75146_a(new SlotEnchantment(this, field_75168_e, 0, 25, 47));
        for(int i = 0; i < 3; i++)
        {
            for(int k = 0; k < 9; k++)
            {
                func_75146_a(new Slot(p_i3606_1_, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
            }

        }

        for(int j = 0; j < 9; j++)
        {
            func_75146_a(new Slot(p_i3606_1_, j, 8 + j * 18, 142));
        }

    }

    public void func_75132_a(ICrafting p_75132_1_)
    {
        super.func_75132_a(p_75132_1_);
        p_75132_1_.func_71112_a(this, 0, field_75167_g[0]);
        p_75132_1_.func_71112_a(this, 1, field_75167_g[1]);
        p_75132_1_.func_71112_a(this, 2, field_75167_g[2]);
    }

    public void func_75142_b()
    {
        super.func_75142_b();
        ICrafting icrafting;
        for(Iterator iterator = field_75149_d.iterator(); iterator.hasNext(); icrafting.func_71112_a(this, 2, field_75167_g[2]))
        {
            icrafting = (ICrafting)iterator.next();
            icrafting.func_71112_a(this, 0, field_75167_g[0]);
            icrafting.func_71112_a(this, 1, field_75167_g[1]);
        }

    }

    public void func_75130_a(IInventory p_75130_1_)
    {
        if(p_75130_1_ == field_75168_e)
        {
            ItemStack itemstack = p_75130_1_.func_70301_a(0);
            if(itemstack == null || !itemstack.func_77956_u())
            {
                for(int i = 0; i < 3; i++)
                {
                    field_75167_g[i] = 0;
                }

            } else
            {
                field_75166_f = field_75169_l.nextLong();
                if(!field_75172_h.field_72995_K)
                {
                    int j = 0;
                    for(int k = -1; k <= 1; k++)
                    {
                        for(int i1 = -1; i1 <= 1; i1++)
                        {
                            if(k == 0 && i1 == 0 || !field_75172_h.func_72799_c(field_75173_i + i1, field_75170_j, field_75171_k + k) || !field_75172_h.func_72799_c(field_75173_i + i1, field_75170_j + 1, field_75171_k + k))
                            {
                                continue;
                            }
                            if(field_75172_h.func_72798_a(field_75173_i + i1 * 2, field_75170_j, field_75171_k + k * 2) == Block.field_72093_an.field_71990_ca)
                            {
                                j++;
                            }
                            if(field_75172_h.func_72798_a(field_75173_i + i1 * 2, field_75170_j + 1, field_75171_k + k * 2) == Block.field_72093_an.field_71990_ca)
                            {
                                j++;
                            }
                            if(i1 == 0 || k == 0)
                            {
                                continue;
                            }
                            if(field_75172_h.func_72798_a(field_75173_i + i1 * 2, field_75170_j, field_75171_k + k) == Block.field_72093_an.field_71990_ca)
                            {
                                j++;
                            }
                            if(field_75172_h.func_72798_a(field_75173_i + i1 * 2, field_75170_j + 1, field_75171_k + k) == Block.field_72093_an.field_71990_ca)
                            {
                                j++;
                            }
                            if(field_75172_h.func_72798_a(field_75173_i + i1, field_75170_j, field_75171_k + k * 2) == Block.field_72093_an.field_71990_ca)
                            {
                                j++;
                            }
                            if(field_75172_h.func_72798_a(field_75173_i + i1, field_75170_j + 1, field_75171_k + k * 2) == Block.field_72093_an.field_71990_ca)
                            {
                                j++;
                            }
                        }

                    }

                    for(int l = 0; l < 3; l++)
                    {
                        field_75167_g[l] = EnchantmentHelper.func_77514_a(field_75169_l, l, j, itemstack);
                    }

                    func_75142_b();
                }
            }
        }
    }

    public boolean func_75140_a(EntityPlayer p_75140_1_, int p_75140_2_)
    {
        ItemStack itemstack = field_75168_e.func_70301_a(0);
        if(field_75167_g[p_75140_2_] > 0 && itemstack != null && (p_75140_1_.field_71068_ca >= field_75167_g[p_75140_2_] || p_75140_1_.field_71075_bZ.field_75098_d))
        {
            if(!field_75172_h.field_72995_K)
            {
                List list = EnchantmentHelper.func_77513_b(field_75169_l, itemstack, field_75167_g[p_75140_2_]);
                if(list != null)
                {
                    p_75140_1_.func_71032_a(field_75167_g[p_75140_2_]);
                    EnchantmentData enchantmentdata;
                    for(Iterator iterator = list.iterator(); iterator.hasNext(); itemstack.func_77966_a(enchantmentdata.field_76302_b, enchantmentdata.field_76303_c))
                    {
                        enchantmentdata = (EnchantmentData)iterator.next();
                    }

                    func_75130_a(field_75168_e);
                }
            }
            return true;
        } else
        {
            return false;
        }
    }

    public void func_75134_a(EntityPlayer p_75134_1_)
    {
        super.func_75134_a(p_75134_1_);
        if(field_75172_h.field_72995_K)
        {
            return;
        }
        ItemStack itemstack = field_75168_e.func_70304_b(0);
        if(itemstack != null)
        {
            p_75134_1_.func_71021_b(itemstack);
        }
    }

    public boolean func_75145_c(EntityPlayer p_75145_1_)
    {
        if(field_75172_h.func_72798_a(field_75173_i, field_75170_j, field_75171_k) != Block.field_72096_bE.field_71990_ca)
        {
            return false;
        }
        return p_75145_1_.func_70092_e((double)field_75173_i + 0.5D, (double)field_75170_j + 0.5D, (double)field_75171_k + 0.5D) <= 64D;
    }

    public ItemStack func_75143_b(int p_75143_1_)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)field_75151_b.get(p_75143_1_);
        if(slot != null && slot.func_75216_d())
        {
            ItemStack itemstack1 = slot.func_75211_c();
            itemstack = itemstack1.func_77946_l();
            if(p_75143_1_ == 0)
            {
                if(!func_75135_a(itemstack1, 1, 37, true))
                {
                    return null;
                }
            } else
            if(!((Slot)field_75151_b.get(0)).func_75216_d() && ((Slot)field_75151_b.get(0)).func_75214_a(itemstack1))
            {
                if(itemstack1.func_77942_o() && itemstack1.field_77994_a == 1)
                {
                    ((Slot)field_75151_b.get(0)).func_75215_d(itemstack1.func_77946_l());
                    itemstack1.field_77994_a = 0;
                } else
                if(itemstack1.field_77994_a >= 1)
                {
                    ((Slot)field_75151_b.get(0)).func_75215_d(new ItemStack(itemstack1.field_77993_c, 1, itemstack1.func_77960_j()));
                    itemstack1.field_77994_a--;
                }
            } else
            {
                return null;
            }
            if(itemstack1.field_77994_a == 0)
            {
                slot.func_75215_d(null);
            } else
            {
                slot.func_75218_e();
            }
            if(itemstack1.field_77994_a == itemstack.field_77994_a)
            {
                return null;
            }
            slot.func_75213_b(itemstack1);
        }
        return itemstack;
    }
}
