// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            InventoryBasic, NBTTagList, NBTTagCompound, ItemStack, 
//            TileEntityEnderChest, EntityPlayer

public class InventoryEnderChest extends InventoryBasic
{

    private TileEntityEnderChest field_70488_a;

    public InventoryEnderChest()
    {
        super("container.enderchest", 27);
    }

    public void func_70485_a(TileEntityEnderChest p_70485_1_)
    {
        field_70488_a = p_70485_1_;
    }

    public void func_70486_a(NBTTagList p_70486_1_)
    {
        for(int i = 0; i < func_70302_i_(); i++)
        {
            func_70299_a(i, null);
        }

        for(int j = 0; j < p_70486_1_.func_74745_c(); j++)
        {
            NBTTagCompound nbttagcompound = (NBTTagCompound)p_70486_1_.func_74743_b(j);
            int k = nbttagcompound.func_74771_c("Slot") & 0xff;
            if(k >= 0 && k < func_70302_i_())
            {
                func_70299_a(k, ItemStack.func_77949_a(nbttagcompound));
            }
        }

    }

    public NBTTagList func_70487_g()
    {
        NBTTagList nbttaglist = new NBTTagList("EnderItems");
        for(int i = 0; i < func_70302_i_(); i++)
        {
            ItemStack itemstack = func_70301_a(i);
            if(itemstack != null)
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.func_74774_a("Slot", (byte)i);
                itemstack.func_77955_b(nbttagcompound);
                nbttaglist.func_74742_a(nbttagcompound);
            }
        }

        return nbttaglist;
    }

    public boolean func_70300_a(EntityPlayer p_70300_1_)
    {
        if(field_70488_a != null && !field_70488_a.func_70365_a(p_70300_1_))
        {
            return false;
        } else
        {
            return super.func_70300_a(p_70300_1_);
        }
    }

    public void func_70295_k_()
    {
        if(field_70488_a != null)
        {
            field_70488_a.func_70364_a();
        }
        super.func_70295_k_();
    }

    public void func_70305_f()
    {
        if(field_70488_a != null)
        {
            field_70488_a.func_70366_b();
        }
        super.func_70305_f();
        field_70488_a = null;
    }
}
