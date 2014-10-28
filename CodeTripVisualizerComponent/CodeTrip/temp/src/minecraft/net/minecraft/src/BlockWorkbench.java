// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, Material, CreativeTabs, World, 
//            EntityPlayer

public class BlockWorkbench extends Block
{

    protected BlockWorkbench(int p_i4024_1_)
    {
        super(p_i4024_1_, Material.field_76245_d);
        field_72059_bZ = 59;
        func_71849_a(CreativeTabs.field_78031_c);
    }

    public int func_71851_a(int p_71851_1_)
    {
        if(p_71851_1_ == 1)
        {
            return field_72059_bZ - 16;
        }
        if(p_71851_1_ == 0)
        {
            return Block.field_71988_x.func_71851_a(0);
        }
        if(p_71851_1_ == 2 || p_71851_1_ == 4)
        {
            return field_72059_bZ + 1;
        } else
        {
            return field_72059_bZ;
        }
    }

    public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, 
            float p_71903_8_, float p_71903_9_)
    {
        if(p_71903_1_.field_72995_K)
        {
            return true;
        } else
        {
            p_71903_5_.func_71058_b(p_71903_2_, p_71903_3_, p_71903_4_);
            return true;
        }
    }
}
