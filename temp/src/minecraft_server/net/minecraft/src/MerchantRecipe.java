// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemStack, NBTTagCompound, Item

public class MerchantRecipe
{

    private ItemStack field_77403_a;
    private ItemStack field_77401_b;
    private ItemStack field_77402_c;
    private int field_77400_d;

    public MerchantRecipe(NBTTagCompound p_i3721_1_)
    {
        func_77390_a(p_i3721_1_);
    }

    public MerchantRecipe(ItemStack p_i3722_1_, ItemStack p_i3722_2_, ItemStack p_i3722_3_)
    {
        field_77403_a = p_i3722_1_;
        field_77401_b = p_i3722_2_;
        field_77402_c = p_i3722_3_;
    }

    public MerchantRecipe(ItemStack p_i3723_1_, ItemStack p_i3723_2_)
    {
        this(p_i3723_1_, null, p_i3723_2_);
    }

    public MerchantRecipe(ItemStack p_i3724_1_, Item p_i3724_2_)
    {
        this(p_i3724_1_, new ItemStack(p_i3724_2_));
    }

    public ItemStack func_77394_a()
    {
        return field_77403_a;
    }

    public ItemStack func_77396_b()
    {
        return field_77401_b;
    }

    public boolean func_77398_c()
    {
        return field_77401_b != null;
    }

    public ItemStack func_77397_d()
    {
        return field_77402_c;
    }

    public boolean func_77393_a(MerchantRecipe p_77393_1_)
    {
        if(field_77403_a.field_77993_c != p_77393_1_.field_77403_a.field_77993_c || field_77402_c.field_77993_c != p_77393_1_.field_77402_c.field_77993_c)
        {
            return false;
        } else
        {
            return field_77401_b == null && p_77393_1_.field_77401_b == null || field_77401_b != null && p_77393_1_.field_77401_b != null && field_77401_b.field_77993_c == p_77393_1_.field_77401_b.field_77993_c;
        }
    }

    public boolean func_77391_b(MerchantRecipe p_77391_1_)
    {
        return func_77393_a(p_77391_1_) && (field_77403_a.field_77994_a < p_77391_1_.field_77403_a.field_77994_a || field_77401_b != null && field_77401_b.field_77994_a < p_77391_1_.field_77401_b.field_77994_a);
    }

    public int func_77392_e()
    {
        return field_77400_d;
    }

    public void func_77399_f()
    {
        field_77400_d++;
    }

    public void func_77390_a(NBTTagCompound p_77390_1_)
    {
        NBTTagCompound nbttagcompound = p_77390_1_.func_74775_l("buy");
        field_77403_a = ItemStack.func_77949_a(nbttagcompound);
        NBTTagCompound nbttagcompound1 = p_77390_1_.func_74775_l("sell");
        field_77402_c = ItemStack.func_77949_a(nbttagcompound1);
        if(p_77390_1_.func_74764_b("buyB"))
        {
            field_77401_b = ItemStack.func_77949_a(p_77390_1_.func_74775_l("buyB"));
        }
        if(p_77390_1_.func_74764_b("uses"))
        {
            field_77400_d = p_77390_1_.func_74762_e("uses");
        }
    }

    public NBTTagCompound func_77395_g()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        nbttagcompound.func_74766_a("buy", field_77403_a.func_77955_b(new NBTTagCompound("buy")));
        nbttagcompound.func_74766_a("sell", field_77402_c.func_77955_b(new NBTTagCompound("sell")));
        if(field_77401_b != null)
        {
            nbttagcompound.func_74766_a("buyB", field_77401_b.func_77955_b(new NBTTagCompound("buyB")));
        }
        nbttagcompound.func_74768_a("uses", field_77400_d);
        return nbttagcompound;
    }
}
