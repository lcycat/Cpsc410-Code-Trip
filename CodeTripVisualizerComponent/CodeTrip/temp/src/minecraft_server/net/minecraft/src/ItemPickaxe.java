// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemTool, Block, EnumToolMaterial, Material, 
//            ItemStack

public class ItemPickaxe extends ItemTool
{

    private static Block field_77867_c[];

    protected ItemPickaxe(int p_i3673_1_, EnumToolMaterial p_i3673_2_)
    {
        super(p_i3673_1_, 2, p_i3673_2_, field_77867_c);
    }

    public boolean func_77641_a(Block p_77641_1_)
    {
        if(p_77641_1_ == Block.field_72089_ap)
        {
            return field_77862_b.func_77996_d() == 3;
        }
        if(p_77641_1_ == Block.field_72071_ax || p_77641_1_ == Block.field_72073_aw)
        {
            return field_77862_b.func_77996_d() >= 2;
        }
        if(p_77641_1_ == Block.field_72068_bR)
        {
            return field_77862_b.func_77996_d() >= 2;
        }
        if(p_77641_1_ == Block.field_72105_ah || p_77641_1_ == Block.field_71941_G)
        {
            return field_77862_b.func_77996_d() >= 2;
        }
        if(p_77641_1_ == Block.field_72083_ai || p_77641_1_ == Block.field_71949_H)
        {
            return field_77862_b.func_77996_d() >= 1;
        }
        if(p_77641_1_ == Block.field_71948_O || p_77641_1_ == Block.field_71947_N)
        {
            return field_77862_b.func_77996_d() >= 1;
        }
        if(p_77641_1_ == Block.field_72047_aN || p_77641_1_ == Block.field_72048_aO)
        {
            return field_77862_b.func_77996_d() >= 2;
        }
        if(p_77641_1_.field_72018_cp == Material.field_76246_e)
        {
            return true;
        }
        return p_77641_1_.field_72018_cp == Material.field_76243_f;
    }

    public float func_77638_a(ItemStack p_77638_1_, Block p_77638_2_)
    {
        if(p_77638_2_ != null && (p_77638_2_.field_72018_cp == Material.field_76243_f || p_77638_2_.field_72018_cp == Material.field_76246_e))
        {
            return field_77864_a;
        } else
        {
            return super.func_77638_a(p_77638_1_, p_77638_2_);
        }
    }

    static 
    {
        field_77867_c = (new Block[] {
            Block.field_71978_w, Block.field_72085_aj, Block.field_72079_ak, Block.field_71981_t, Block.field_71957_Q, Block.field_72087_ao, Block.field_71949_H, Block.field_72083_ai, Block.field_71950_I, Block.field_72105_ah, 
            Block.field_71941_G, Block.field_72073_aw, Block.field_72071_ax, Block.field_72036_aT, Block.field_72012_bb, Block.field_71947_N, Block.field_71948_O, Block.field_72047_aN, Block.field_72048_aO, Block.field_72056_aG, 
            Block.field_71953_U, Block.field_71954_T
        });
    }
}
