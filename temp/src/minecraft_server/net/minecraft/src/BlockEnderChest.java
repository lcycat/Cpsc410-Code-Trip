// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockContainer, Material, CreativeTabs, Block, 
//            EntityLiving, MathHelper, World, EntityPlayer, 
//            TileEntityEnderChest, InventoryEnderChest, TileEntity

public class BlockEnderChest extends BlockContainer
{

    protected BlockEnderChest(int p_i3942_1_)
    {
        super(p_i3942_1_, Material.field_76246_e);
        field_72059_bZ = 37;
        func_71849_a(CreativeTabs.field_78031_c);
    }

    public boolean func_71926_d()
    {
        return false;
    }

    public boolean func_71886_c()
    {
        return false;
    }

    public int func_71857_b()
    {
        return 22;
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        return Block.field_72089_ap.field_71990_ca;
    }

    public int func_71925_a(Random p_71925_1_)
    {
        return 8;
    }

    protected boolean func_71906_q_()
    {
        return true;
    }

    public void func_71860_a(World p_71860_1_, int p_71860_2_, int p_71860_3_, int p_71860_4_, EntityLiving p_71860_5_)
    {
        byte byte0 = 0;
        int i = MathHelper.func_76128_c((double)((p_71860_5_.field_70177_z * 4F) / 360F) + 0.5D) & 3;
        if(i == 0)
        {
            byte0 = 2;
        }
        if(i == 1)
        {
            byte0 = 5;
        }
        if(i == 2)
        {
            byte0 = 3;
        }
        if(i == 3)
        {
            byte0 = 4;
        }
        p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, byte0);
    }

    public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, 
            float p_71903_8_, float p_71903_9_)
    {
        InventoryEnderChest inventoryenderchest = p_71903_5_.func_71005_bN();
        TileEntityEnderChest tileentityenderchest = (TileEntityEnderChest)p_71903_1_.func_72796_p(p_71903_2_, p_71903_3_, p_71903_4_);
        if(inventoryenderchest == null || tileentityenderchest == null)
        {
            return true;
        }
        if(p_71903_1_.func_72809_s(p_71903_2_, p_71903_3_ + 1, p_71903_4_))
        {
            return true;
        }
        if(p_71903_1_.field_72995_K)
        {
            return true;
        } else
        {
            inventoryenderchest.func_70485_a(tileentityenderchest);
            p_71903_5_.func_71007_a(inventoryenderchest);
            return true;
        }
    }

    public TileEntity func_72274_a(World p_72274_1_)
    {
        return new TileEntityEnderChest();
    }
}
