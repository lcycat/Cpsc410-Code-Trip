// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            TileEntityChest, TileEntityEnderChest, Block, TileEntityRenderer

public class ChestItemRenderHelper
{

    public static ChestItemRenderHelper field_78545_a = new ChestItemRenderHelper();
    private TileEntityChest field_78543_b;
    private TileEntityEnderChest field_78544_c;

    public ChestItemRenderHelper()
    {
        field_78543_b = new TileEntityChest();
        field_78544_c = new TileEntityEnderChest();
    }

    public void func_78542_a(Block p_78542_1_, int p_78542_2_, float p_78542_3_)
    {
        if(p_78542_1_.field_71990_ca == Block.field_72066_bS.field_71990_ca)
        {
            TileEntityRenderer.field_76963_a.func_76949_a(field_78544_c, 0.0D, 0.0D, 0.0D, 0.0F);
        } else
        {
            TileEntityRenderer.field_76963_a.func_76949_a(field_78543_b, 0.0D, 0.0D, 0.0D, 0.0F);
        }
    }

}
