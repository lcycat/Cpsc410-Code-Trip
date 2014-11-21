// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Slot, GuiContainerCreative, ItemStack, IInventory

class SlotCreativeInventory extends Slot
{

    private final Slot field_75241_b;
    final GuiContainerCreative field_75242_a; /* synthetic field */

    public SlotCreativeInventory(GuiContainerCreative p_i3088_1_, Slot p_i3088_2_, int p_i3088_3_)
    {
        field_75242_a = p_i3088_1_;
        super(p_i3088_2_.field_75224_c, p_i3088_3_, 0, 0);
        field_75241_b = p_i3088_2_;
    }

    public void func_75213_b(ItemStack p_75213_1_)
    {
        field_75241_b.func_75213_b(p_75213_1_);
    }

    public boolean func_75214_a(ItemStack p_75214_1_)
    {
        return field_75241_b.func_75214_a(p_75214_1_);
    }

    public ItemStack func_75211_c()
    {
        return field_75241_b.func_75211_c();
    }

    public boolean func_75216_d()
    {
        return field_75241_b.func_75216_d();
    }

    public void func_75215_d(ItemStack p_75215_1_)
    {
        field_75241_b.func_75215_d(p_75215_1_);
    }

    public void func_75218_e()
    {
        field_75241_b.func_75218_e();
    }

    public int func_75219_a()
    {
        return field_75241_b.func_75219_a();
    }

    public int func_75212_b()
    {
        return field_75241_b.func_75212_b();
    }

    public ItemStack func_75209_a(int p_75209_1_)
    {
        return field_75241_b.func_75209_a(p_75209_1_);
    }

    public boolean func_75217_a(IInventory p_75217_1_, int p_75217_2_)
    {
        return field_75241_b.func_75217_a(p_75217_1_, p_75217_2_);
    }

    static Slot func_75240_a(SlotCreativeInventory p_75240_0_)
    {
        return p_75240_0_.field_75241_b;
    }
}
