// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, GuiButton, TileEntitySign, Packet130UpdateSign, 
//            NetClientHandler, Block, TileEntityRenderer, ChatAllowedCharacters

public class GuiEditSign extends GuiScreen
{

    private static final String field_73981_b;
    protected String field_73983_a;
    private TileEntitySign field_73982_c;
    private int field_73980_d;
    private int field_73984_m;

    public GuiEditSign(TileEntitySign p_i3080_1_)
    {
        field_73983_a = "Edit sign message:";
        field_73984_m = 0;
        field_73982_c = p_i3080_1_;
    }

    public void func_73866_w_()
    {
        field_73887_h.clear();
        Keyboard.enableRepeatEvents(true);
        field_73887_h.add(new GuiButton(0, field_73880_f / 2 - 100, field_73881_g / 4 + 120, "Done"));
        field_73982_c.func_70408_a(false);
    }

    public void func_73874_b()
    {
        Keyboard.enableRepeatEvents(false);
        field_73882_e.func_71391_r().func_72552_c(new Packet130UpdateSign(field_73982_c.field_70329_l, field_73982_c.field_70330_m, field_73982_c.field_70327_n, field_73982_c.field_70412_a));
        field_73982_c.func_70408_a(true);
    }

    public void func_73876_c()
    {
        field_73980_d++;
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        if(!p_73875_1_.field_73742_g)
        {
            return;
        }
        if(p_73875_1_.field_73741_f == 0)
        {
            field_73982_c.func_70296_d();
            field_73882_e.func_71373_a(null);
        }
    }

    protected void func_73869_a(char p_73869_1_, int p_73869_2_)
    {
        if(p_73869_2_ == 200)
        {
            field_73984_m = field_73984_m - 1 & 3;
        }
        if(p_73869_2_ == 208 || p_73869_2_ == 28)
        {
            field_73984_m = field_73984_m + 1 & 3;
        }
        if(p_73869_2_ == 14 && field_73982_c.field_70412_a[field_73984_m].length() > 0)
        {
            field_73982_c.field_70412_a[field_73984_m] = field_73982_c.field_70412_a[field_73984_m].substring(0, field_73982_c.field_70412_a[field_73984_m].length() - 1);
        }
        if(field_73981_b.indexOf(p_73869_1_) < 0 || field_73982_c.field_70412_a[field_73984_m].length() >= 15) goto _L2; else goto _L1
_L1:
        new StringBuilder();
        field_73982_c.field_70412_a;
        field_73984_m;
        JVM INSTR dup2_x1 ;
        JVM INSTR aaload ;
        append();
        p_73869_1_;
        append();
        toString();
        JVM INSTR aastore ;
_L2:
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        func_73873_v_();
        func_73732_a(field_73886_k, field_73983_a, field_73880_f / 2, 40, 0xffffff);
        GL11.glPushMatrix();
        GL11.glTranslatef(field_73880_f / 2, 0.0F, 50F);
        float f = 93.75F;
        GL11.glScalef(-f, -f, -f);
        GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
        Block block = field_73982_c.func_70311_o();
        if(block == Block.field_72053_aD)
        {
            float f1 = (float)(field_73982_c.func_70322_n() * 360) / 16F;
            GL11.glRotatef(f1, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(0.0F, -1.0625F, 0.0F);
        } else
        {
            int i = field_73982_c.func_70322_n();
            float f2 = 0.0F;
            if(i == 2)
            {
                f2 = 180F;
            }
            if(i == 4)
            {
                f2 = 90F;
            }
            if(i == 5)
            {
                f2 = -90F;
            }
            GL11.glRotatef(f2, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(0.0F, -1.0625F, 0.0F);
        }
        if((field_73980_d / 6) % 2 == 0)
        {
            field_73982_c.field_70410_b = field_73984_m;
        }
        TileEntityRenderer.field_76963_a.func_76949_a(field_73982_c, -0.5D, -0.75D, -0.5D, 0.0F);
        field_73982_c.field_70410_b = -1;
        GL11.glPopMatrix();
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
    }

    static 
    {
        field_73981_b = ChatAllowedCharacters.field_71568_a;
    }
}
