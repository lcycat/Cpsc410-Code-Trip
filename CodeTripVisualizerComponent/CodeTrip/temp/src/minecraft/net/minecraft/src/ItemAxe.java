// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemTool, Block, Material, EnumToolMaterial, 
//            ItemStack

public class ItemAxe extends ItemTool
{

    private static Block field_77868_c[];

    protected ItemAxe(int p_i3656_1_, EnumToolMaterial p_i3656_2_)
    {
        super(p_i3656_1_, 3, p_i3656_2_, field_77868_c);
    }

    public float func_77638_a(ItemStack p_77638_1_, Block p_77638_2_)
    {
        if(p_77638_2_ != null && p_77638_2_.field_72018_cp == Material.field_76245_d)
        {
            return field_77864_a;
        } else
        {
            return super.func_77638_a(p_77638_1_, p_77638_2_);
        }
    }

    static 
    {
        field_77868_c = (new Block[] {
            Block.field_71988_x, Block.field_72093_an, Block.field_71951_J, Block.field_72077_au, Block.field_72085_aj, Block.field_72079_ak, Block.field_72061_ba, Block.field_72008_bf
        });
    }
}
