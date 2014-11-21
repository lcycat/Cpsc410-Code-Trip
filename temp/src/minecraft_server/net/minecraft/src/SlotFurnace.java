// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Slot, ItemStack, EntityPlayer, ModLoader, 
//            World, FurnaceRecipes, MathHelper, EntityXPOrb, 
//            Item, AchievementList, IInventory

public class SlotFurnace extends Slot
{

    private EntityPlayer field_75229_a;
    private int field_75228_b;

    public SlotFurnace(EntityPlayer p_i3608_1_, IInventory p_i3608_2_, int p_i3608_3_, int p_i3608_4_, int p_i3608_5_)
    {
        super(p_i3608_2_, p_i3608_3_, p_i3608_4_, p_i3608_5_);
        field_75229_a = p_i3608_1_;
    }

    public boolean func_75214_a(ItemStack p_75214_1_)
    {
        return false;
    }

    public ItemStack func_75209_a(int p_75209_1_)
    {
        if(func_75216_d())
        {
            field_75228_b += Math.min(p_75209_1_, func_75211_c().field_77994_a);
        }
        return super.func_75209_a(p_75209_1_);
    }

    public void func_75213_b(ItemStack p_75213_1_)
    {
        func_75208_c(p_75213_1_);
        super.func_75213_b(p_75213_1_);
    }

    protected void func_75210_a(ItemStack p_75210_1_, int p_75210_2_)
    {
        field_75228_b += p_75210_2_;
        func_75208_c(p_75210_1_);
    }

    protected void func_75208_c(ItemStack p_75208_1_)
    {
        p_75208_1_.func_77980_a(field_75229_a.field_70170_p, field_75229_a, field_75228_b);
        ModLoader.takenFromFurnace(field_75229_a, p_75208_1_);
        if(!field_75229_a.field_70170_p.field_72995_K)
        {
            int i = field_75228_b;
            float f = FurnaceRecipes.func_77602_a().func_77601_c(p_75208_1_.field_77993_c);
            if(f == 0.0F)
            {
                i = 0;
            } else
            if(f < 1.0F)
            {
                int j = MathHelper.func_76141_d((float)i * f);
                if(j < MathHelper.func_76123_f((float)i * f) && (float)Math.random() < (float)i * f - (float)j)
                {
                    j++;
                }
                i = j;
            }
            while(i > 0) 
            {
                int k = EntityXPOrb.func_70527_a(i);
                i -= k;
                field_75229_a.field_70170_p.func_72838_d(new EntityXPOrb(field_75229_a.field_70170_p, field_75229_a.field_70165_t, field_75229_a.field_70163_u + 0.5D, field_75229_a.field_70161_v + 0.5D, k));
            }
        }
        field_75228_b = 0;
        if(p_75208_1_.field_77993_c == Item.field_77703_o.field_77779_bT)
        {
            field_75229_a.func_71064_a(AchievementList.field_76016_k, 1);
        }
        if(p_75208_1_.field_77993_c == Item.field_77753_aV.field_77779_bT)
        {
            field_75229_a.func_71064_a(AchievementList.field_76026_p, 1);
        }
    }
}
