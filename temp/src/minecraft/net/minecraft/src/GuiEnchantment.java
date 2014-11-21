// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

// Referenced classes of package net.minecraft.src:
//            GuiContainer, ContainerEnchantment, StatCollector, FontRenderer, 
//            PlayerControllerMP, RenderEngine, ScaledResolution, RenderHelper, 
//            MathHelper, ModelBook, EnchantmentNameParts, EntityClientPlayerMP, 
//            PlayerCapabilities, Container, Slot, ItemStack, 
//            InventoryPlayer, World

public class GuiEnchantment extends GuiContainer
{

    private static ModelBook field_74206_w = new ModelBook();
    private Random field_74216_x;
    private ContainerEnchantment field_74215_y;
    public int field_74214_o;
    public float field_74213_p;
    public float field_74212_q;
    public float field_74211_r;
    public float field_74210_s;
    public float field_74209_t;
    public float field_74208_u;
    ItemStack field_74207_v;

    public GuiEnchantment(InventoryPlayer p_i3089_1_, World p_i3089_2_, int p_i3089_3_, int p_i3089_4_, int p_i3089_5_)
    {
        super(new ContainerEnchantment(p_i3089_1_, p_i3089_2_, p_i3089_3_, p_i3089_4_, p_i3089_5_));
        field_74216_x = new Random();
        field_74215_y = (ContainerEnchantment)field_74193_d;
    }

    protected void func_74189_g()
    {
        field_73886_k.func_78276_b(StatCollector.func_74838_a("container.enchant"), 12, 6, 0x404040);
        field_73886_k.func_78276_b(StatCollector.func_74838_a("container.inventory"), 8, (field_74195_c - 96) + 2, 0x404040);
    }

    public void func_73876_c()
    {
        super.func_73876_c();
        func_74205_h();
    }

    protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_)
    {
        super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
        int i = (field_73880_f - field_74194_b) / 2;
        int j = (field_73881_g - field_74195_c) / 2;
        for(int k = 0; k < 3; k++)
        {
            int l = p_73864_1_ - (i + 60);
            int i1 = p_73864_2_ - (j + 14 + 19 * k);
            if(l >= 0 && i1 >= 0 && l < 108 && i1 < 19 && field_74215_y.func_75140_a(field_73882_e.field_71439_g, k))
            {
                field_73882_e.field_71442_b.func_78756_a(field_74215_y.field_75152_c, k);
            }
        }

    }

    protected void func_74185_a(float p_74185_1_, int p_74185_2_, int p_74185_3_)
    {
        int i = field_73882_e.field_71446_o.func_78341_b("/gui/enchant.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        field_73882_e.field_71446_o.func_78342_b(i);
        int j = (field_73880_f - field_74194_b) / 2;
        int k = (field_73881_g - field_74195_c) / 2;
        func_73729_b(j, k, 0, 0, field_74194_b, field_74195_c);
        GL11.glPushMatrix();
        GL11.glMatrixMode(5889);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        ScaledResolution scaledresolution = new ScaledResolution(field_73882_e.field_71474_y, field_73882_e.field_71443_c, field_73882_e.field_71440_d);
        GL11.glViewport(((scaledresolution.func_78326_a() - 320) / 2) * scaledresolution.func_78325_e(), ((scaledresolution.func_78328_b() - 240) / 2) * scaledresolution.func_78325_e(), 320 * scaledresolution.func_78325_e(), 240 * scaledresolution.func_78325_e());
        GL11.glTranslatef(-0.34F, 0.23F, 0.0F);
        GLU.gluPerspective(90F, 1.333333F, 9F, 80F);
        float f = 1.0F;
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        RenderHelper.func_74519_b();
        GL11.glTranslatef(0.0F, 3.3F, -16F);
        GL11.glScalef(f, f, f);
        float f1 = 5F;
        GL11.glScalef(f1, f1, f1);
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        field_73882_e.field_71446_o.func_78342_b(field_73882_e.field_71446_o.func_78341_b("/item/book.png"));
        GL11.glRotatef(20F, 1.0F, 0.0F, 0.0F);
        float f2 = field_74208_u + (field_74209_t - field_74208_u) * p_74185_1_;
        GL11.glTranslatef((1.0F - f2) * 0.2F, (1.0F - f2) * 0.1F, (1.0F - f2) * 0.25F);
        GL11.glRotatef(-(1.0F - f2) * 90F - 90F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
        float f3 = field_74212_q + (field_74213_p - field_74212_q) * p_74185_1_ + 0.25F;
        float f4 = field_74212_q + (field_74213_p - field_74212_q) * p_74185_1_ + 0.75F;
        f3 = (f3 - (float)MathHelper.func_76140_b(f3)) * 1.6F - 0.3F;
        f4 = (f4 - (float)MathHelper.func_76140_b(f4)) * 1.6F - 0.3F;
        if(f3 < 0.0F)
        {
            f3 = 0.0F;
        }
        if(f4 < 0.0F)
        {
            f4 = 0.0F;
        }
        if(f3 > 1.0F)
        {
            f3 = 1.0F;
        }
        if(f4 > 1.0F)
        {
            f4 = 1.0F;
        }
        GL11.glEnable(32826);
        field_74206_w.func_78088_a(null, 0.0F, f3, f4, f2, 0.0F, 0.0625F);
        GL11.glDisable(32826);
        RenderHelper.func_74518_a();
        GL11.glMatrixMode(5889);
        GL11.glViewport(0, 0, field_73882_e.field_71443_c, field_73882_e.field_71440_d);
        GL11.glPopMatrix();
        GL11.glMatrixMode(5888);
        GL11.glPopMatrix();
        RenderHelper.func_74518_a();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        field_73882_e.field_71446_o.func_78342_b(i);
        EnchantmentNameParts.field_78061_a.func_78058_a(field_74215_y.field_75166_f);
        for(int l = 0; l < 3; l++)
        {
            String s = EnchantmentNameParts.field_78061_a.func_78057_a();
            field_73735_i = 0.0F;
            field_73882_e.field_71446_o.func_78342_b(i);
            int i1 = field_74215_y.field_75167_g[l];
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            if(i1 == 0)
            {
                func_73729_b(j + 60, k + 14 + 19 * l, 0, 185, 108, 19);
                continue;
            }
            String s1 = (new StringBuilder()).append("").append(i1).toString();
            FontRenderer fontrenderer = field_73882_e.field_71464_q;
            int j1 = 0x685e4a;
            if(field_73882_e.field_71439_g.field_71068_ca < i1 && !field_73882_e.field_71439_g.field_71075_bZ.field_75098_d)
            {
                func_73729_b(j + 60, k + 14 + 19 * l, 0, 185, 108, 19);
                fontrenderer.func_78279_b(s, j + 62, k + 16 + 19 * l, 104, (j1 & 0xfefefe) >> 1);
                fontrenderer = field_73882_e.field_71466_p;
                j1 = 0x407f10;
                fontrenderer.func_78261_a(s1, (j + 62 + 104) - fontrenderer.func_78256_a(s1), k + 16 + 19 * l + 7, j1);
                continue;
            }
            int k1 = p_74185_2_ - (j + 60);
            int l1 = p_74185_3_ - (k + 14 + 19 * l);
            if(k1 >= 0 && l1 >= 0 && k1 < 108 && l1 < 19)
            {
                func_73729_b(j + 60, k + 14 + 19 * l, 0, 204, 108, 19);
                j1 = 0xffff80;
            } else
            {
                func_73729_b(j + 60, k + 14 + 19 * l, 0, 166, 108, 19);
            }
            fontrenderer.func_78279_b(s, j + 62, k + 16 + 19 * l, 104, j1);
            fontrenderer = field_73882_e.field_71466_p;
            j1 = 0x80ff20;
            fontrenderer.func_78261_a(s1, (j + 62 + 104) - fontrenderer.func_78256_a(s1), k + 16 + 19 * l + 7, j1);
        }

    }

    public void func_74205_h()
    {
        ItemStack itemstack = field_74193_d.func_75139_a(0).func_75211_c();
        if(!ItemStack.func_77989_b(itemstack, field_74207_v))
        {
            field_74207_v = itemstack;
            do
            {
                field_74211_r += field_74216_x.nextInt(4) - field_74216_x.nextInt(4);
            } while(field_74213_p <= field_74211_r + 1.0F && field_74213_p >= field_74211_r - 1.0F);
        }
        field_74214_o++;
        field_74212_q = field_74213_p;
        field_74208_u = field_74209_t;
        boolean flag = false;
        for(int i = 0; i < 3; i++)
        {
            if(field_74215_y.field_75167_g[i] != 0)
            {
                flag = true;
            }
        }

        if(flag)
        {
            field_74209_t += 0.2F;
        } else
        {
            field_74209_t -= 0.2F;
        }
        if(field_74209_t < 0.0F)
        {
            field_74209_t = 0.0F;
        }
        if(field_74209_t > 1.0F)
        {
            field_74209_t = 1.0F;
        }
        float f = (field_74211_r - field_74213_p) * 0.4F;
        float f1 = 0.2F;
        if(f < -f1)
        {
            f = -f1;
        }
        if(f > f1)
        {
            f = f1;
        }
        field_74210_s += (f - field_74210_s) * 0.9F;
        field_74213_p += field_74210_s;
    }

}
