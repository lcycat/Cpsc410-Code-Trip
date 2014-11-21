// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemTool, Block, EnumToolMaterial

public class ItemSpade extends ItemTool
{

    private static Block field_77866_c[];

    public ItemSpade(int p_i3684_1_, EnumToolMaterial p_i3684_2_)
    {
        super(p_i3684_1_, 1, p_i3684_2_, field_77866_c);
    }

    public boolean func_77641_a(Block p_77641_1_)
    {
        if(p_77641_1_ == Block.field_72037_aS)
        {
            return true;
        }
        return p_77641_1_ == Block.field_72039_aU;
    }

    static 
    {
        field_77866_c = (new Block[] {
            Block.field_71980_u, Block.field_71979_v, Block.field_71939_E, Block.field_71940_F, Block.field_72037_aS, Block.field_72039_aU, Block.field_72041_aW, Block.field_72050_aA, Block.field_72013_bc, Block.field_71994_by
        });
    }
}
