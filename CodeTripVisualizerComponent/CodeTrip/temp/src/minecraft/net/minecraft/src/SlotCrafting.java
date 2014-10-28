// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Slot, ItemStack, EntityPlayer, Block, 
//            AchievementList, Item, ModLoader, IInventory, 
//            InventoryPlayer

public class SlotCrafting extends Slot
{

    private final IInventory field_75239_a;
    private EntityPlayer field_75238_b;
    private int field_75237_g;

    public SlotCrafting(EntityPlayer p_i3615_1_, IInventory p_i3615_2_, IInventory p_i3615_3_, int p_i3615_4_, int p_i3615_5_, int p_i3615_6_)
    {
        super(p_i3615_3_, p_i3615_4_, p_i3615_5_, p_i3615_6_);
        field_75238_b = p_i3615_1_;
        field_75239_a = p_i3615_2_;
    }

    public boolean func_75214_a(ItemStack p_75214_1_)
    {
        return false;
    }

    public ItemStack func_75209_a(int p_75209_1_)
    {
        if(func_75216_d())
        {
            field_75237_g += Math.min(p_75209_1_, func_75211_c().field_77994_a);
        }
        return super.func_75209_a(p_75209_1_);
    }

    protected void func_75210_a(ItemStack p_75210_1_, int p_75210_2_)
    {
        field_75237_g += p_75210_2_;
        func_75208_c(p_75210_1_);
    }

    protected void func_75208_c(ItemStack p_75208_1_)
    {
        p_75208_1_.func_77980_a(field_75238_b.field_70170_p, field_75238_b, field_75237_g);
        field_75237_g = 0;
        if(p_75208_1_.field_77993_c == Block.field_72060_ay.field_71990_ca)
        {
            field_75238_b.func_71064_a(AchievementList.field_76017_h, 1);
        } else
        if(p_75208_1_.field_77993_c == Item.field_77713_t.field_77779_bT)
        {
            field_75238_b.func_71064_a(AchievementList.field_76018_i, 1);
        } else
        if(p_75208_1_.field_77993_c == Block.field_72051_aB.field_71990_ca)
        {
            field_75238_b.func_71064_a(AchievementList.field_76015_j, 1);
        } else
        if(p_75208_1_.field_77993_c == Item.field_77678_N.field_77779_bT)
        {
            field_75238_b.func_71064_a(AchievementList.field_76013_l, 1);
        } else
        if(p_75208_1_.field_77993_c == Item.field_77684_U.field_77779_bT)
        {
            field_75238_b.func_71064_a(AchievementList.field_76014_m, 1);
        } else
        if(p_75208_1_.field_77993_c == Item.field_77746_aZ.field_77779_bT)
        {
            field_75238_b.func_71064_a(AchievementList.field_76011_n, 1);
        } else
        if(p_75208_1_.field_77993_c == Item.field_77720_x.field_77779_bT)
        {
            field_75238_b.func_71064_a(AchievementList.field_76012_o, 1);
        } else
        if(p_75208_1_.field_77993_c == Item.field_77715_r.field_77779_bT)
        {
            field_75238_b.func_71064_a(AchievementList.field_76024_r, 1);
        } else
        if(p_75208_1_.field_77993_c == Block.field_72096_bE.field_71990_ca)
        {
            field_75238_b.func_71064_a(AchievementList.field_75998_D, 1);
        } else
        if(p_75208_1_.field_77993_c == Block.field_72093_an.field_71990_ca)
        {
            field_75238_b.func_71064_a(AchievementList.field_76000_F, 1);
        }
    }

    public void func_75213_b(ItemStack p_75213_1_)
    {
        func_75208_c(p_75213_1_);
        ModLoader.takenFromCrafting(field_75238_b, p_75213_1_, field_75239_a);
        for(int i = 0; i < field_75239_a.func_70302_i_(); i++)
        {
            ItemStack itemstack = field_75239_a.func_70301_a(i);
            if(itemstack == null)
            {
                continue;
            }
            field_75239_a.func_70298_a(i, 1);
            if(!itemstack.func_77973_b().func_77634_r())
            {
                continue;
            }
            ItemStack itemstack1 = new ItemStack(itemstack.func_77973_b().func_77668_q());
            if(itemstack.func_77973_b().func_77630_h(itemstack) && field_75238_b.field_71071_by.func_70441_a(itemstack1))
            {
                continue;
            }
            if(field_75239_a.func_70301_a(i) == null)
            {
                field_75239_a.func_70299_a(i, itemstack1);
            } else
            {
                field_75238_b.func_71021_b(itemstack1);
            }
        }

    }
}
