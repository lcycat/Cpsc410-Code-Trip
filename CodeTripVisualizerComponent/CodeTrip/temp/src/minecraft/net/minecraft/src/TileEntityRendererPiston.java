// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            TileEntitySpecialRenderer, Block, TileEntityPiston, Tessellator, 
//            RenderHelper, RenderBlocks, BlockPistonBase, BlockPistonExtension, 
//            World, TileEntity

public class TileEntityRendererPiston extends TileEntitySpecialRenderer
{

    private RenderBlocks field_76904_a;

    public TileEntityRendererPiston()
    {
    }

    public void func_76903_a(TileEntityPiston p_76903_1_, double p_76903_2_, double p_76903_4_, double p_76903_6_, 
            float p_76903_8_)
    {
        Block block = Block.field_71973_m[p_76903_1_.func_70340_a()];
        if(block != null && p_76903_1_.func_70333_a(p_76903_8_) < 1.0F)
        {
            Tessellator tessellator = Tessellator.field_78398_a;
            func_76897_a("/terrain.png");
            RenderHelper.func_74518_a();
            GL11.glBlendFunc(770, 771);
            GL11.glEnable(3042);
            GL11.glDisable(2884);
            if(Minecraft.func_71379_u())
            {
                GL11.glShadeModel(7425);
            } else
            {
                GL11.glShadeModel(7424);
            }
            tessellator.func_78382_b();
            tessellator.func_78373_b(((float)p_76903_2_ - (float)p_76903_1_.field_70329_l) + p_76903_1_.func_70337_b(p_76903_8_), ((float)p_76903_4_ - (float)p_76903_1_.field_70330_m) + p_76903_1_.func_70334_c(p_76903_8_), ((float)p_76903_6_ - (float)p_76903_1_.field_70327_n) + p_76903_1_.func_70332_d(p_76903_8_));
            tessellator.func_78376_a(1, 1, 1);
            if(block == Block.field_72099_aa && p_76903_1_.func_70333_a(p_76903_8_) < 0.5F)
            {
                field_76904_a.func_78587_a(block, p_76903_1_.field_70329_l, p_76903_1_.field_70330_m, p_76903_1_.field_70327_n, false);
            } else
            if(p_76903_1_.func_70338_f() && !p_76903_1_.func_70341_b())
            {
                Block.field_72099_aa.func_72122_e(((BlockPistonBase)block).func_72118_n());
                field_76904_a.func_78587_a(Block.field_72099_aa, p_76903_1_.field_70329_l, p_76903_1_.field_70330_m, p_76903_1_.field_70327_n, p_76903_1_.func_70333_a(p_76903_8_) < 0.5F);
                Block.field_72099_aa.func_72120_n();
                tessellator.func_78373_b((float)p_76903_2_ - (float)p_76903_1_.field_70329_l, (float)p_76903_4_ - (float)p_76903_1_.field_70330_m, (float)p_76903_6_ - (float)p_76903_1_.field_70327_n);
                field_76904_a.func_78568_d(block, p_76903_1_.field_70329_l, p_76903_1_.field_70330_m, p_76903_1_.field_70327_n);
            } else
            {
                field_76904_a.func_78583_a(block, p_76903_1_.field_70329_l, p_76903_1_.field_70330_m, p_76903_1_.field_70327_n);
            }
            tessellator.func_78373_b(0.0D, 0.0D, 0.0D);
            tessellator.func_78381_a();
            RenderHelper.func_74519_b();
        }
    }

    public void func_76896_a(World p_76896_1_)
    {
        field_76904_a = new RenderBlocks(p_76896_1_);
    }

    public void func_76894_a(TileEntity p_76894_1_, double p_76894_2_, double p_76894_4_, double p_76894_6_, 
            float p_76894_8_)
    {
        func_76903_a((TileEntityPiston)p_76894_1_, p_76894_2_, p_76894_4_, p_76894_6_, p_76894_8_);
    }
}
