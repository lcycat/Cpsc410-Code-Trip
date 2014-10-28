// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            InventoryEffectRenderer, EntityPlayer, AchievementList, PlayerControllerMP, 
//            GuiContainerCreative, StatCollector, FontRenderer, RenderEngine, 
//            EntityClientPlayerMP, RenderHelper, RenderManager, GuiButton, 
//            GuiAchievements, GuiStats

public class GuiInventory extends InventoryEffectRenderer
{

    private float field_74225_o;
    private float field_74224_p;

    public GuiInventory(EntityPlayer p_i3081_1_)
    {
        super(p_i3081_1_.field_71069_bz);
        field_73885_j = true;
        p_i3081_1_.func_71064_a(AchievementList.field_76004_f, 1);
    }

    public void func_73876_c()
    {
        if(field_73882_e.field_71442_b.func_78758_h())
        {
            field_73882_e.func_71373_a(new GuiContainerCreative(field_73882_e.field_71439_g));
        }
    }

    public void func_73866_w_()
    {
        field_73887_h.clear();
        if(field_73882_e.field_71442_b.func_78758_h())
        {
            field_73882_e.func_71373_a(new GuiContainerCreative(field_73882_e.field_71439_g));
        } else
        {
            super.func_73866_w_();
        }
    }

    protected void func_74189_g()
    {
        field_73886_k.func_78276_b(StatCollector.func_74838_a("container.crafting"), 86, 16, 0x404040);
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
        field_74225_o = p_73863_1_;
        field_74224_p = p_73863_2_;
    }

    protected void func_74185_a(float p_74185_1_, int p_74185_2_, int p_74185_3_)
    {
        int i = field_73882_e.field_71446_o.func_78341_b("/gui/inventory.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        field_73882_e.field_71446_o.func_78342_b(i);
        int j = field_74198_m;
        int k = field_74197_n;
        func_73729_b(j, k, 0, 0, field_74194_b, field_74195_c);
        func_74223_a(field_73882_e, j + 51, k + 75, 30, (float)(j + 51) - field_74225_o, (float)((k + 75) - 50) - field_74224_p);
    }

    public static void func_74223_a(Minecraft p_74223_0_, int p_74223_1_, int p_74223_2_, int p_74223_3_, float p_74223_4_, float p_74223_5_)
    {
        GL11.glEnable(2903);
        GL11.glPushMatrix();
        GL11.glTranslatef(p_74223_1_, p_74223_2_, 50F);
        GL11.glScalef(-p_74223_3_, p_74223_3_, p_74223_3_);
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        float f = p_74223_0_.field_71439_g.field_70761_aq;
        float f1 = p_74223_0_.field_71439_g.field_70177_z;
        float f2 = p_74223_0_.field_71439_g.field_70125_A;
        GL11.glRotatef(135F, 0.0F, 1.0F, 0.0F);
        RenderHelper.func_74519_b();
        GL11.glRotatef(-135F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-(float)Math.atan(p_74223_5_ / 40F) * 20F, 1.0F, 0.0F, 0.0F);
        p_74223_0_.field_71439_g.field_70761_aq = (float)Math.atan(p_74223_4_ / 40F) * 20F;
        p_74223_0_.field_71439_g.field_70177_z = (float)Math.atan(p_74223_4_ / 40F) * 40F;
        p_74223_0_.field_71439_g.field_70125_A = -(float)Math.atan(p_74223_5_ / 40F) * 20F;
        p_74223_0_.field_71439_g.field_70759_as = p_74223_0_.field_71439_g.field_70177_z;
        GL11.glTranslatef(0.0F, p_74223_0_.field_71439_g.field_70129_M, 0.0F);
        RenderManager.field_78727_a.field_78735_i = 180F;
        RenderManager.field_78727_a.func_78719_a(p_74223_0_.field_71439_g, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
        p_74223_0_.field_71439_g.field_70761_aq = f;
        p_74223_0_.field_71439_g.field_70177_z = f1;
        p_74223_0_.field_71439_g.field_70125_A = f2;
        GL11.glPopMatrix();
        RenderHelper.func_74518_a();
        GL11.glDisable(32826);
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        if(p_73875_1_.field_73741_f == 0)
        {
            field_73882_e.func_71373_a(new GuiAchievements(field_73882_e.field_71413_E));
        }
        if(p_73875_1_.field_73741_f == 1)
        {
            field_73882_e.func_71373_a(new GuiStats(this, field_73882_e.field_71413_E));
        }
    }
}
