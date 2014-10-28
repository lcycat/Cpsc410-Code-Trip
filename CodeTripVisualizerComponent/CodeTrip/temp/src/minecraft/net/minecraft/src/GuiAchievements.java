// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, AchievementList, Achievement, GuiSmallButton, 
//            StatCollector, GuiButton, GameSettings, KeyBinding, 
//            FontRenderer, MathHelper, RenderEngine, Block, 
//            StatFileWriter, RenderItem, RenderHelper

public class GuiAchievements extends GuiScreen
{

    private static final int field_74122_s;
    private static final int field_74121_t;
    private static final int field_74120_u;
    private static final int field_74119_v;
    protected int field_74114_a;
    protected int field_74112_b;
    protected int field_74113_c;
    protected int field_74111_d;
    protected double field_74117_m;
    protected double field_74115_n;
    protected double field_74116_o;
    protected double field_74125_p;
    protected double field_74124_q;
    protected double field_74123_r;
    private int field_74118_w;
    private StatFileWriter field_74126_x;

    public GuiAchievements(StatFileWriter p_i3070_1_)
    {
        field_74114_a = 256;
        field_74112_b = 202;
        field_74113_c = 0;
        field_74111_d = 0;
        field_74118_w = 0;
        field_74126_x = p_i3070_1_;
        char c = '\215';
        char c1 = '\215';
        field_74117_m = field_74116_o = field_74124_q = AchievementList.field_76004_f.field_75993_a * 24 - c / 2 - 12;
        field_74115_n = field_74125_p = field_74123_r = AchievementList.field_76004_f.field_75991_b * 24 - c1 / 2;
    }

    public void func_73866_w_()
    {
        field_73887_h.clear();
        field_73887_h.add(new GuiSmallButton(1, field_73880_f / 2 + 24, field_73881_g / 2 + 74, 80, 20, StatCollector.func_74838_a("gui.done")));
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        if(p_73875_1_.field_73741_f == 1)
        {
            field_73882_e.func_71373_a(null);
            field_73882_e.func_71381_h();
        }
        super.func_73875_a(p_73875_1_);
    }

    protected void func_73869_a(char p_73869_1_, int p_73869_2_)
    {
        if(p_73869_2_ == field_73882_e.field_71474_y.field_74315_B.field_74512_d)
        {
            field_73882_e.func_71373_a(null);
            field_73882_e.func_71381_h();
        } else
        {
            super.func_73869_a(p_73869_1_, p_73869_2_);
        }
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        if(Mouse.isButtonDown(0))
        {
            int i = (field_73880_f - field_74114_a) / 2;
            int j = (field_73881_g - field_74112_b) / 2;
            int k = i + 8;
            int l = j + 17;
            if((field_74118_w == 0 || field_74118_w == 1) && p_73863_1_ >= k && p_73863_1_ < k + 224 && p_73863_2_ >= l && p_73863_2_ < l + 155)
            {
                if(field_74118_w == 0)
                {
                    field_74118_w = 1;
                } else
                {
                    field_74116_o -= p_73863_1_ - field_74113_c;
                    field_74125_p -= p_73863_2_ - field_74111_d;
                    field_74124_q = field_74117_m = field_74116_o;
                    field_74123_r = field_74115_n = field_74125_p;
                }
                field_74113_c = p_73863_1_;
                field_74111_d = p_73863_2_;
            }
            if(field_74124_q < (double)field_74122_s)
            {
                field_74124_q = field_74122_s;
            }
            if(field_74123_r < (double)field_74121_t)
            {
                field_74123_r = field_74121_t;
            }
            if(field_74124_q >= (double)field_74120_u)
            {
                field_74124_q = field_74120_u - 1;
            }
            if(field_74123_r >= (double)field_74119_v)
            {
                field_74123_r = field_74119_v - 1;
            }
        } else
        {
            field_74118_w = 0;
        }
        func_73873_v_();
        func_74110_b(p_73863_1_, p_73863_2_, p_73863_3_);
        GL11.glDisable(2896);
        GL11.glDisable(2929);
        func_74109_g();
        GL11.glEnable(2896);
        GL11.glEnable(2929);
    }

    public void func_73876_c()
    {
        field_74117_m = field_74116_o;
        field_74115_n = field_74125_p;
        double d = field_74124_q - field_74116_o;
        double d1 = field_74123_r - field_74125_p;
        if(d * d + d1 * d1 < 4D)
        {
            field_74116_o += d;
            field_74125_p += d1;
        } else
        {
            field_74116_o += d * 0.84999999999999998D;
            field_74125_p += d1 * 0.84999999999999998D;
        }
    }

    protected void func_74109_g()
    {
        int i = (field_73880_f - field_74114_a) / 2;
        int j = (field_73881_g - field_74112_b) / 2;
        field_73886_k.func_78276_b("Achievements", i + 15, j + 5, 0x404040);
    }

    protected void func_74110_b(int p_74110_1_, int p_74110_2_, float p_74110_3_)
    {
        int i = MathHelper.func_76128_c(field_74117_m + (field_74116_o - field_74117_m) * (double)p_74110_3_);
        int j = MathHelper.func_76128_c(field_74115_n + (field_74125_p - field_74115_n) * (double)p_74110_3_);
        if(i < field_74122_s)
        {
            i = field_74122_s;
        }
        if(j < field_74121_t)
        {
            j = field_74121_t;
        }
        if(i >= field_74120_u)
        {
            i = field_74120_u - 1;
        }
        if(j >= field_74119_v)
        {
            j = field_74119_v - 1;
        }
        int k = field_73882_e.field_71446_o.func_78341_b("/terrain.png");
        int l = field_73882_e.field_71446_o.func_78341_b("/achievement/bg.png");
        int i1 = (field_73880_f - field_74114_a) / 2;
        int j1 = (field_73881_g - field_74112_b) / 2;
        int k1 = i1 + 16;
        int l1 = j1 + 17;
        field_73735_i = 0.0F;
        GL11.glDepthFunc(518);
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, 0.0F, -200F);
        GL11.glEnable(3553);
        GL11.glDisable(2896);
        GL11.glEnable(32826);
        GL11.glEnable(2903);
        field_73882_e.field_71446_o.func_78342_b(k);
        int i2 = i + 288 >> 4;
        int j2 = j + 288 >> 4;
        int k2 = (i + 288) % 16;
        int l2 = (j + 288) % 16;
        Random random = new Random();
        for(int i3 = 0; i3 * 16 - l2 < 155; i3++)
        {
            float f = 0.6F - ((float)(j2 + i3) / 25F) * 0.3F;
            GL11.glColor4f(f, f, f, 1.0F);
            for(int k3 = 0; k3 * 16 - k2 < 224; k3++)
            {
                random.setSeed(1234 + i2 + k3);
                random.nextInt();
                int j4 = random.nextInt(1 + j2 + i3) + (j2 + i3) / 2;
                int l4 = Block.field_71939_E.field_72059_bZ;
                if(j4 > 37 || j2 + i3 == 35)
                {
                    l4 = Block.field_71986_z.field_72059_bZ;
                } else
                if(j4 == 22)
                {
                    if(random.nextInt(2) == 0)
                    {
                        l4 = Block.field_72073_aw.field_72059_bZ;
                    } else
                    {
                        l4 = Block.field_72047_aN.field_72059_bZ;
                    }
                } else
                if(j4 == 10)
                {
                    l4 = Block.field_71949_H.field_72059_bZ;
                } else
                if(j4 == 8)
                {
                    l4 = Block.field_71950_I.field_72059_bZ;
                } else
                if(j4 > 4)
                {
                    l4 = Block.field_71981_t.field_72059_bZ;
                } else
                if(j4 > 0)
                {
                    l4 = Block.field_71979_v.field_72059_bZ;
                }
                func_73729_b((k1 + k3 * 16) - k2, (l1 + i3 * 16) - l2, l4 % 16 << 4, (l4 >> 4) << 4, 16, 16);
            }

        }

        GL11.glEnable(2929);
        GL11.glDepthFunc(515);
        GL11.glDisable(3553);
        for(int j3 = 0; j3 < AchievementList.field_76007_e.size(); j3++)
        {
            Achievement achievement1 = (Achievement)AchievementList.field_76007_e.get(j3);
            if(achievement1.field_75992_c == null)
            {
                continue;
            }
            int l3 = (achievement1.field_75993_a * 24 - i) + 11 + k1;
            int k4 = (achievement1.field_75991_b * 24 - j) + 11 + l1;
            int i5 = (achievement1.field_75992_c.field_75993_a * 24 - i) + 11 + k1;
            int l5 = (achievement1.field_75992_c.field_75991_b * 24 - j) + 11 + l1;
            boolean flag = field_74126_x.func_77443_a(achievement1);
            boolean flag1 = field_74126_x.func_77442_b(achievement1);
            char c = Math.sin(((double)(Minecraft.func_71386_F() % 600L) / 600D) * 3.1415926535897931D * 2D) <= 0.59999999999999998D ? '\202' : '\377';
            int i8 = 0xff000000;
            if(flag)
            {
                i8 = 0xff707070;
            } else
            if(flag1)
            {
                i8 = 65280 + (c << 24);
            }
            func_73730_a(l3, i5, k4, i8);
            func_73728_b(i5, k4, l5, i8);
        }

        Achievement achievement = null;
        RenderItem renderitem = new RenderItem();
        RenderHelper.func_74520_c();
        GL11.glDisable(2896);
        GL11.glEnable(32826);
        GL11.glEnable(2903);
        for(int i4 = 0; i4 < AchievementList.field_76007_e.size(); i4++)
        {
            Achievement achievement2 = (Achievement)AchievementList.field_76007_e.get(i4);
            int j5 = achievement2.field_75993_a * 24 - i;
            int i6 = achievement2.field_75991_b * 24 - j;
            if(j5 < -24 || i6 < -24 || j5 > 224 || i6 > 155)
            {
                continue;
            }
            if(field_74126_x.func_77443_a(achievement2))
            {
                float f1 = 1.0F;
                GL11.glColor4f(f1, f1, f1, 1.0F);
            } else
            if(field_74126_x.func_77442_b(achievement2))
            {
                float f2 = Math.sin(((double)(Minecraft.func_71386_F() % 600L) / 600D) * 3.1415926535897931D * 2D) >= 0.59999999999999998D ? 0.8F : 0.6F;
                GL11.glColor4f(f2, f2, f2, 1.0F);
            } else
            {
                float f3 = 0.3F;
                GL11.glColor4f(f3, f3, f3, 1.0F);
            }
            field_73882_e.field_71446_o.func_78342_b(l);
            int k6 = k1 + j5;
            int j7 = l1 + i6;
            if(achievement2.func_75984_f())
            {
                func_73729_b(k6 - 2, j7 - 2, 26, 202, 26, 26);
            } else
            {
                func_73729_b(k6 - 2, j7 - 2, 0, 202, 26, 26);
            }
            if(!field_74126_x.func_77442_b(achievement2))
            {
                float f4 = 0.1F;
                GL11.glColor4f(f4, f4, f4, 1.0F);
                renderitem.field_77024_a = false;
            }
            GL11.glEnable(2896);
            GL11.glEnable(2884);
            renderitem.func_77015_a(field_73882_e.field_71466_p, field_73882_e.field_71446_o, achievement2.field_75990_d, k6 + 3, j7 + 3);
            GL11.glDisable(2896);
            if(!field_74126_x.func_77442_b(achievement2))
            {
                renderitem.field_77024_a = true;
            }
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            if(p_74110_1_ >= k1 && p_74110_2_ >= l1 && p_74110_1_ < k1 + 224 && p_74110_2_ < l1 + 155 && p_74110_1_ >= k6 && p_74110_1_ <= k6 + 22 && p_74110_2_ >= j7 && p_74110_2_ <= j7 + 22)
            {
                achievement = achievement2;
            }
        }

        GL11.glDisable(2929);
        GL11.glEnable(3042);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        field_73882_e.field_71446_o.func_78342_b(l);
        func_73729_b(i1, j1, 0, 0, field_74114_a, field_74112_b);
        GL11.glPopMatrix();
        field_73735_i = 0.0F;
        GL11.glDepthFunc(515);
        GL11.glDisable(2929);
        GL11.glEnable(3553);
        super.func_73863_a(p_74110_1_, p_74110_2_, p_74110_3_);
        if(achievement != null)
        {
            String s = StatCollector.func_74838_a(achievement.func_75970_i());
            String s1 = achievement.func_75989_e();
            int k5 = p_74110_1_ + 12;
            int j6 = p_74110_2_ - 4;
            if(field_74126_x.func_77442_b(achievement))
            {
                int l6 = Math.max(field_73886_k.func_78256_a(s), 120);
                int k7 = field_73886_k.func_78267_b(s1, l6);
                if(field_74126_x.func_77443_a(achievement))
                {
                    k7 += 12;
                }
                func_73733_a(k5 - 3, j6 - 3, k5 + l6 + 3, j6 + k7 + 3 + 12, 0xc0000000, 0xc0000000);
                field_73886_k.func_78279_b(s1, k5, j6 + 12, l6, 0xffa0a0a0);
                if(field_74126_x.func_77443_a(achievement))
                {
                    field_73886_k.func_78261_a(StatCollector.func_74838_a("achievement.taken"), k5, j6 + k7 + 4, 0xff9090ff);
                }
            } else
            {
                int i7 = Math.max(field_73886_k.func_78256_a(s), 120);
                String s2 = StatCollector.func_74837_a("achievement.requires", new Object[] {
                    StatCollector.func_74838_a(achievement.field_75992_c.func_75970_i())
                });
                int l7 = field_73886_k.func_78267_b(s2, i7);
                func_73733_a(k5 - 3, j6 - 3, k5 + i7 + 3, j6 + l7 + 12 + 3, 0xc0000000, 0xc0000000);
                field_73886_k.func_78279_b(s2, k5, j6 + 12, i7, 0xff705050);
            }
            field_73886_k.func_78261_a(s, k5, j6, field_74126_x.func_77442_b(achievement) ? achievement.func_75984_f() ? -128 : -1 : achievement.func_75984_f() ? 0xff808040 : 0xff808080);
        }
        GL11.glEnable(2929);
        GL11.glEnable(2896);
        RenderHelper.func_74518_a();
    }

    public boolean func_73868_f()
    {
        return true;
    }

    static 
    {
        field_74122_s = AchievementList.field_76010_a * 24 - 112;
        field_74121_t = AchievementList.field_76008_b * 24 - 112;
        field_74120_u = AchievementList.field_76009_c * 24 - 77;
        field_74119_v = AchievementList.field_76006_d * 24 - 77;
    }
}
