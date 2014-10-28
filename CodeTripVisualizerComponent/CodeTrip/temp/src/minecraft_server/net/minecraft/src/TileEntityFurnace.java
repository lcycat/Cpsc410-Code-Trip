// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            TileEntity, IInventory, ItemStack, NBTTagCompound, 
//            NBTTagList, World, Item, BlockFurnace, 
//            FurnaceRecipes, Block, Material, ItemTool, 
//            ItemSword, ItemHoe, ModLoader, EntityPlayer

public class TileEntityFurnace extends TileEntity
    implements IInventory
{

    private ItemStack field_70404_d[];
    public int field_70407_a;
    public int field_70405_b;
    public int field_70406_c;

    public TileEntityFurnace()
    {
        field_70404_d = new ItemStack[3];
        field_70407_a = 0;
        field_70405_b = 0;
        field_70406_c = 0;
    }

    public int func_70302_i_()
    {
        return field_70404_d.length;
    }

    public ItemStack func_70301_a(int p_70301_1_)
    {
        return field_70404_d[p_70301_1_];
    }

    public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_)
    {
        if(field_70404_d[p_70298_1_] != null)
        {
            if(field_70404_d[p_70298_1_].field_77994_a <= p_70298_2_)
            {
                ItemStack itemstack = field_70404_d[p_70298_1_];
                field_70404_d[p_70298_1_] = null;
                return itemstack;
            }
            ItemStack itemstack1 = field_70404_d[p_70298_1_].func_77979_a(p_70298_2_);
            if(field_70404_d[p_70298_1_].field_77994_a == 0)
            {
                field_70404_d[p_70298_1_] = null;
            }
            return itemstack1;
        } else
        {
            return null;
        }
    }

    public ItemStack func_70304_b(int p_70304_1_)
    {
        if(field_70404_d[p_70304_1_] != null)
        {
            ItemStack itemstack = field_70404_d[p_70304_1_];
            field_70404_d[p_70304_1_] = null;
            return itemstack;
        } else
        {
            return null;
        }
    }

    public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_)
    {
        field_70404_d[p_70299_1_] = p_70299_2_;
        if(p_70299_2_ != null && p_70299_2_.field_77994_a > func_70297_j_())
        {
            p_70299_2_.field_77994_a = func_70297_j_();
        }
    }

    public String func_70303_b()
    {
        return "container.furnace";
    }

    public void func_70307_a(NBTTagCompound p_70307_1_)
    {
        super.func_70307_a(p_70307_1_);
        NBTTagList nbttaglist = p_70307_1_.func_74761_m("Items");
        field_70404_d = new ItemStack[func_70302_i_()];
        for(int i = 0; i < nbttaglist.func_74745_c(); i++)
        {
            NBTTagCompound nbttagcompound = (NBTTagCompound)nbttaglist.func_74743_b(i);
            byte byte0 = nbttagcompound.func_74771_c("Slot");
            if(byte0 >= 0 && byte0 < field_70404_d.length)
            {
                field_70404_d[byte0] = ItemStack.func_77949_a(nbttagcompound);
            }
        }

        field_70407_a = p_70307_1_.func_74765_d("BurnTime");
        field_70406_c = p_70307_1_.func_74765_d("CookTime");
        field_70405_b = func_70398_a(field_70404_d[1]);
    }

    public void func_70310_b(NBTTagCompound p_70310_1_)
    {
        super.func_70310_b(p_70310_1_);
        p_70310_1_.func_74777_a("BurnTime", (short)field_70407_a);
        p_70310_1_.func_74777_a("CookTime", (short)field_70406_c);
        NBTTagList nbttaglist = new NBTTagList();
        for(int i = 0; i < field_70404_d.length; i++)
        {
            if(field_70404_d[i] != null)
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.func_74774_a("Slot", (byte)i);
                field_70404_d[i].func_77955_b(nbttagcompound);
                nbttaglist.func_74742_a(nbttagcompound);
            }
        }

        p_70310_1_.func_74782_a("Items", nbttaglist);
    }

    public int func_70297_j_()
    {
        return 64;
    }

    public boolean func_70400_i()
    {
        return field_70407_a > 0;
    }

    public void func_70316_g()
    {
        boolean flag = field_70407_a > 0;
        boolean flag1 = false;
        if(field_70407_a > 0)
        {
            field_70407_a--;
        }
        if(!field_70331_k.field_72995_K)
        {
            if(field_70407_a == 0 && func_70402_r())
            {
                field_70405_b = field_70407_a = func_70398_a(field_70404_d[1]);
                if(field_70407_a > 0)
                {
                    flag1 = true;
                    if(field_70404_d[1] != null)
                    {
                        field_70404_d[1].field_77994_a--;
                        if(field_70404_d[1].field_77994_a == 0)
                        {
                            Item item = field_70404_d[1].func_77973_b().func_77668_q();
                            field_70404_d[1] = item == null ? null : new ItemStack(item);
                        }
                    }
                }
            }
            if(func_70400_i() && func_70402_r())
            {
                field_70406_c++;
                if(field_70406_c == 200)
                {
                    field_70406_c = 0;
                    func_70399_k();
                    flag1 = true;
                }
            } else
            {
                field_70406_c = 0;
            }
            if(flag != (field_70407_a > 0))
            {
                flag1 = true;
                BlockFurnace.func_72286_a(field_70407_a > 0, field_70331_k, field_70329_l, field_70330_m, field_70327_n);
            }
        }
        if(flag1)
        {
            func_70296_d();
        }
    }

    private boolean func_70402_r()
    {
        if(field_70404_d[0] == null)
        {
            return false;
        } else
        {
            ItemStack itemstack = FurnaceRecipes.func_77602_a().func_77603_b(field_70404_d[0].func_77973_b().field_77779_bT);
            return itemstack != null ? field_70404_d[2] != null ? field_70404_d[2].func_77969_a(itemstack) ? field_70404_d[2].field_77994_a >= func_70297_j_() || field_70404_d[2].field_77994_a >= field_70404_d[2].func_77976_d() ? field_70404_d[2].field_77994_a < itemstack.func_77976_d() : true : false : true : false;
        }
    }

    public void func_70399_k()
    {
        if(func_70402_r())
        {
            ItemStack itemstack = FurnaceRecipes.func_77602_a().func_77603_b(field_70404_d[0].func_77973_b().field_77779_bT);
            if(field_70404_d[2] == null)
            {
                field_70404_d[2] = itemstack.func_77946_l();
            } else
            if(field_70404_d[2].field_77993_c == itemstack.field_77993_c)
            {
                field_70404_d[2].field_77994_a++;
            }
            field_70404_d[0].field_77994_a--;
            if(field_70404_d[0].field_77994_a <= 0)
            {
                field_70404_d[0] = null;
            }
        }
    }

    public static int func_70398_a(ItemStack p_70398_0_)
    {
        if(p_70398_0_ == null)
        {
            return 0;
        }
        int i = p_70398_0_.func_77973_b().field_77779_bT;
        Item item = p_70398_0_.func_77973_b();
        if(i < 256 && Block.field_71973_m[i] != null)
        {
            Block block = Block.field_71973_m[i];
            if(block == Block.field_72092_bO)
            {
                return 150;
            }
            if(block.field_72018_cp == Material.field_76245_d)
            {
                return 300;
            }
        }
        return !(item instanceof ItemTool) || !((ItemTool)item).func_77861_e().equals("WOOD") ? !(item instanceof ItemSword) || !((ItemSword)item).func_77825_f().equals("WOOD") ? !(item instanceof ItemHoe) || !((ItemHoe)item).func_77842_f().equals("WOOD") ? i != Item.field_77669_D.field_77779_bT ? i != Item.field_77705_m.field_77779_bT ? i != Item.field_77775_ay.field_77779_bT ? i != Block.field_71987_y.field_71990_ca ? i != Item.field_77731_bo.field_77779_bT ? ModLoader.addAllFuel(p_70398_0_.field_77993_c, p_70398_0_.func_77960_j()) : 2400 : 100 : 20000 : 1600 : 100 : 200 : 200 : 200;
    }

    public static boolean func_70401_b(ItemStack p_70401_0_)
    {
        return func_70398_a(p_70401_0_) > 0;
    }

    public boolean func_70300_a(EntityPlayer p_70300_1_)
    {
        return field_70331_k.func_72796_p(field_70329_l, field_70330_m, field_70327_n) == this ? p_70300_1_.func_70092_e((double)field_70329_l + 0.5D, (double)field_70330_m + 0.5D, (double)field_70327_n + 0.5D) <= 64D : false;
    }

    public void func_70295_k_()
    {
    }

    public void func_70305_f()
    {
    }
}
