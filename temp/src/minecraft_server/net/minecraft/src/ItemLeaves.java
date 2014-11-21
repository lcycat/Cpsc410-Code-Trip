// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemBlock, ItemStack, BlockLeaves

public class ItemLeaves extends ItemBlock
{

    public ItemLeaves(int p_i3667_1_)
    {
        super(p_i3667_1_);
        func_77656_e(0);
        func_77627_a(true);
    }

    public int func_77647_b(int p_77647_1_)
    {
        return p_77647_1_ | 4;
    }

    public String func_77667_c(ItemStack p_77667_1_)
    {
        int i = p_77667_1_.func_77960_j();
        if(i < 0 || i >= BlockLeaves.field_72136_a.length)
        {
            i = 0;
        }
        return (new StringBuilder()).append(super.func_77658_a()).append(".").append(BlockLeaves.field_72136_a[i]).toString();
    }
}
