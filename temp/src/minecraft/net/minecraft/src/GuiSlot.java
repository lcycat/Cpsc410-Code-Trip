// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiButton, Tessellator, RenderEngine

public abstract class GuiSlot
{

    private final Minecraft field_77233_a;
    private int field_77228_g;
    private int field_77240_h;
    protected int field_77231_b;
    protected int field_77232_c;
    private int field_77241_i;
    private int field_77238_j;
    protected final int field_77229_d;
    private int field_77239_k;
    private int field_77236_l;
    protected int field_77230_e;
    protected int field_77227_f;
    private float field_77237_m;
    private float field_77234_n;
    private float field_77235_o;
    private int field_77246_p;
    private long field_77245_q;
    private boolean field_77244_r;
    private boolean field_77243_s;
    private int field_77242_t;

    public GuiSlot(Minecraft p_i3060_1_, int p_i3060_2_, int p_i3060_3_, int p_i3060_4_, int p_i3060_5_, int p_i3060_6_)
    {
        field_77237_m = -2F;
        field_77246_p = -1;
        field_77245_q = 0L;
        field_77244_r = true;
        field_77233_a = p_i3060_1_;
        field_77228_g = p_i3060_2_;
        field_77240_h = p_i3060_3_;
        field_77231_b = p_i3060_4_;
        field_77232_c = p_i3060_5_;
        field_77229_d = p_i3060_6_;
        field_77238_j = 0;
        field_77241_i = p_i3060_2_;
    }

    public void func_77207_a(int p_77207_1_, int p_77207_2_, int p_77207_3_, int p_77207_4_)
    {
        field_77228_g = p_77207_1_;
        field_77240_h = p_77207_2_;
        field_77231_b = p_77207_3_;
        field_77232_c = p_77207_4_;
        field_77238_j = 0;
        field_77241_i = p_77207_1_;
    }

    public void func_77216_a(boolean p_77216_1_)
    {
        field_77244_r = p_77216_1_;
    }

    protected void func_77223_a(boolean p_77223_1_, int p_77223_2_)
    {
        field_77243_s = p_77223_1_;
        field_77242_t = p_77223_2_;
        if(!p_77223_1_)
        {
            field_77242_t = 0;
        }
    }

    protected abstract int func_77217_a();

    protected abstract void func_77213_a(int i, boolean flag);

    protected abstract boolean func_77218_a(int i);

    protected int func_77212_b()
    {
        return func_77217_a() * field_77229_d + field_77242_t;
    }

    protected abstract void func_77221_c();

    protected abstract void func_77214_a(int i, int j, int k, int l, Tessellator tessellator);

    protected void func_77222_a(int i, int j, Tessellator tessellator)
    {
    }

    protected void func_77224_a(int i, int j)
    {
    }

    protected void func_77215_b(int i, int j)
    {
    }

    public int func_77210_c(int p_77210_1_, int p_77210_2_)
    {
        int i = field_77228_g / 2 - 110;
        int j = field_77228_g / 2 + 110;
        int k = ((p_77210_2_ - field_77231_b - field_77242_t) + (int)field_77235_o) - 4;
        int l = k / field_77229_d;
        if(p_77210_1_ >= i && p_77210_1_ <= j && l >= 0 && k >= 0 && l < func_77217_a())
        {
            return l;
        } else
        {
            return -1;
        }
    }

    public void func_77220_a(List p_77220_1_, int p_77220_2_, int p_77220_3_)
    {
        field_77239_k = p_77220_2_;
        field_77236_l = p_77220_3_;
    }

    private void func_77226_h()
    {
        int i = func_77209_d();
        if(i < 0)
        {
            i /= 2;
        }
        if(field_77235_o < 0.0F)
        {
            field_77235_o = 0.0F;
        }
        if(field_77235_o > (float)i)
        {
            field_77235_o = i;
        }
    }

    public int func_77209_d()
    {
        return func_77212_b() - (field_77232_c - field_77231_b - 4);
    }

    public void func_77208_b(int p_77208_1_)
    {
        field_77235_o += p_77208_1_;
        func_77226_h();
        field_77237_m = -2F;
    }

    public void func_77219_a(GuiButton p_77219_1_)
    {
        if(!p_77219_1_.field_73742_g)
        {
            return;
        }
        if(p_77219_1_.field_73741_f == field_77239_k)
        {
            field_77235_o -= (field_77229_d * 2) / 3;
            field_77237_m = -2F;
            func_77226_h();
        } else
        if(p_77219_1_.field_73741_f == field_77236_l)
        {
            field_77235_o += (field_77229_d * 2) / 3;
            field_77237_m = -2F;
            func_77226_h();
        }
    }

    public void func_77211_a(int p_77211_1_, int p_77211_2_, float p_77211_3_)
    {
        field_77230_e = p_77211_1_;
        field_77227_f = p_77211_2_;
        func_77221_c();
        int i = func_77217_a();
        int j = func_77225_g();
        int k = j + 6;
        if(Mouse.isButtonDown(0))
        {
            if(field_77237_m == -1F)
            {
                boolean flag = true;
                if(p_77211_2_ >= field_77231_b && p_77211_2_ <= field_77232_c)
                {
                    int i1 = field_77228_g / 2 - 110;
                    int j1 = field_77228_g / 2 + 110;
                    int l1 = ((p_77211_2_ - field_77231_b - field_77242_t) + (int)field_77235_o) - 4;
                    int j2 = l1 / field_77229_d;
                    if(p_77211_1_ >= i1 && p_77211_1_ <= j1 && j2 >= 0 && l1 >= 0 && j2 < i)
                    {
                        boolean flag1 = j2 == field_77246_p && Minecraft.func_71386_F() - field_77245_q < 250L;
                        func_77213_a(j2, flag1);
                        field_77246_p = j2;
                        field_77245_q = Minecraft.func_71386_F();
                    } else
                    if(p_77211_1_ >= i1 && p_77211_1_ <= j1 && l1 < 0)
                    {
                        func_77224_a(p_77211_1_ - i1, ((p_77211_2_ - field_77231_b) + (int)field_77235_o) - 4);
                        flag = false;
                    }
                    if(p_77211_1_ >= j && p_77211_1_ <= k)
                    {
                        field_77234_n = -1F;
                        int l2 = func_77209_d();
                        if(l2 < 1)
                        {
                            l2 = 1;
                        }
                        int k3 = (int)((float)((field_77232_c - field_77231_b) * (field_77232_c - field_77231_b)) / (float)func_77212_b());
                        if(k3 < 32)
                        {
                            k3 = 32;
                        }
                        if(k3 > field_77232_c - field_77231_b - 8)
                        {
                            k3 = field_77232_c - field_77231_b - 8;
                        }
                        field_77234_n /= (float)(field_77232_c - field_77231_b - k3) / (float)l2;
                    } else
                    {
                        field_77234_n = 1.0F;
                    }
                    if(flag)
                    {
                        field_77237_m = p_77211_2_;
                    } else
                    {
                        field_77237_m = -2F;
                    }
                } else
                {
                    field_77237_m = -2F;
                }
            } else
            if(field_77237_m >= 0.0F)
            {
                field_77235_o -= ((float)p_77211_2_ - field_77237_m) * field_77234_n;
                field_77237_m = p_77211_2_;
            }
        } else
        {
            do
            {
                if(!Mouse.next())
                {
                    break;
                }
                int l = Mouse.getEventDWheel();
                if(l != 0)
                {
                    if(l > 0)
                    {
                        l = -1;
                    } else
                    if(l < 0)
                    {
                        l = 1;
                    }
                    field_77235_o += (l * field_77229_d) / 2;
                }
            } while(true);
            field_77237_m = -1F;
        }
        func_77226_h();
        GL11.glDisable(2896);
        GL11.glDisable(2912);
        Tessellator tessellator = Tessellator.field_78398_a;
        GL11.glBindTexture(3553, field_77233_a.field_71446_o.func_78341_b("/gui/background.png"));
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        float f = 32F;
        tessellator.func_78382_b();
        tessellator.func_78378_d(0x202020);
        tessellator.func_78374_a(field_77238_j, field_77232_c, 0.0D, (float)field_77238_j / f, (float)(field_77232_c + (int)field_77235_o) / f);
        tessellator.func_78374_a(field_77241_i, field_77232_c, 0.0D, (float)field_77241_i / f, (float)(field_77232_c + (int)field_77235_o) / f);
        tessellator.func_78374_a(field_77241_i, field_77231_b, 0.0D, (float)field_77241_i / f, (float)(field_77231_b + (int)field_77235_o) / f);
        tessellator.func_78374_a(field_77238_j, field_77231_b, 0.0D, (float)field_77238_j / f, (float)(field_77231_b + (int)field_77235_o) / f);
        tessellator.func_78381_a();
        int k1 = field_77228_g / 2 - 92 - 16;
        int i2 = (field_77231_b + 4) - (int)field_77235_o;
        if(field_77243_s)
        {
            func_77222_a(k1, i2, tessellator);
        }
        for(int k2 = 0; k2 < i; k2++)
        {
            int i3 = i2 + k2 * field_77229_d + field_77242_t;
            int l3 = field_77229_d - 4;
            if(i3 > field_77232_c || i3 + l3 < field_77231_b)
            {
                continue;
            }
            if(field_77244_r && func_77218_a(k2))
            {
                int j4 = field_77228_g / 2 - 110;
                int l4 = field_77228_g / 2 + 110;
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                GL11.glDisable(3553);
                tessellator.func_78382_b();
                tessellator.func_78378_d(0x808080);
                tessellator.func_78374_a(j4, i3 + l3 + 2, 0.0D, 0.0D, 1.0D);
                tessellator.func_78374_a(l4, i3 + l3 + 2, 0.0D, 1.0D, 1.0D);
                tessellator.func_78374_a(l4, i3 - 2, 0.0D, 1.0D, 0.0D);
                tessellator.func_78374_a(j4, i3 - 2, 0.0D, 0.0D, 0.0D);
                tessellator.func_78378_d(0);
                tessellator.func_78374_a(j4 + 1, i3 + l3 + 1, 0.0D, 0.0D, 1.0D);
                tessellator.func_78374_a(l4 - 1, i3 + l3 + 1, 0.0D, 1.0D, 1.0D);
                tessellator.func_78374_a(l4 - 1, i3 - 1, 0.0D, 1.0D, 0.0D);
                tessellator.func_78374_a(j4 + 1, i3 - 1, 0.0D, 0.0D, 0.0D);
                tessellator.func_78381_a();
                GL11.glEnable(3553);
            }
            func_77214_a(k2, k1, i3, l3, tessellator);
        }

        GL11.glDisable(2929);
        byte byte0 = 4;
        func_77206_b(0, field_77231_b, 255, 255);
        func_77206_b(field_77232_c, field_77240_h, 255, 255);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3008);
        GL11.glShadeModel(7425);
        GL11.glDisable(3553);
        tessellator.func_78382_b();
        tessellator.func_78384_a(0, 0);
        tessellator.func_78374_a(field_77238_j, field_77231_b + byte0, 0.0D, 0.0D, 1.0D);
        tessellator.func_78374_a(field_77241_i, field_77231_b + byte0, 0.0D, 1.0D, 1.0D);
        tessellator.func_78384_a(0, 255);
        tessellator.func_78374_a(field_77241_i, field_77231_b, 0.0D, 1.0D, 0.0D);
        tessellator.func_78374_a(field_77238_j, field_77231_b, 0.0D, 0.0D, 0.0D);
        tessellator.func_78381_a();
        tessellator.func_78382_b();
        tessellator.func_78384_a(0, 255);
        tessellator.func_78374_a(field_77238_j, field_77232_c, 0.0D, 0.0D, 1.0D);
        tessellator.func_78374_a(field_77241_i, field_77232_c, 0.0D, 1.0D, 1.0D);
        tessellator.func_78384_a(0, 0);
        tessellator.func_78374_a(field_77241_i, field_77232_c - byte0, 0.0D, 1.0D, 0.0D);
        tessellator.func_78374_a(field_77238_j, field_77232_c - byte0, 0.0D, 0.0D, 0.0D);
        tessellator.func_78381_a();
        int j3 = func_77209_d();
        if(j3 > 0)
        {
            int i4 = ((field_77232_c - field_77231_b) * (field_77232_c - field_77231_b)) / func_77212_b();
            if(i4 < 32)
            {
                i4 = 32;
            }
            if(i4 > field_77232_c - field_77231_b - 8)
            {
                i4 = field_77232_c - field_77231_b - 8;
            }
            int k4 = ((int)field_77235_o * (field_77232_c - field_77231_b - i4)) / j3 + field_77231_b;
            if(k4 < field_77231_b)
            {
                k4 = field_77231_b;
            }
            tessellator.func_78382_b();
            tessellator.func_78384_a(0, 255);
            tessellator.func_78374_a(j, field_77232_c, 0.0D, 0.0D, 1.0D);
            tessellator.func_78374_a(k, field_77232_c, 0.0D, 1.0D, 1.0D);
            tessellator.func_78374_a(k, field_77231_b, 0.0D, 1.0D, 0.0D);
            tessellator.func_78374_a(j, field_77231_b, 0.0D, 0.0D, 0.0D);
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78384_a(0x808080, 255);
            tessellator.func_78374_a(j, k4 + i4, 0.0D, 0.0D, 1.0D);
            tessellator.func_78374_a(k, k4 + i4, 0.0D, 1.0D, 1.0D);
            tessellator.func_78374_a(k, k4, 0.0D, 1.0D, 0.0D);
            tessellator.func_78374_a(j, k4, 0.0D, 0.0D, 0.0D);
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78384_a(0xc0c0c0, 255);
            tessellator.func_78374_a(j, (k4 + i4) - 1, 0.0D, 0.0D, 1.0D);
            tessellator.func_78374_a(k - 1, (k4 + i4) - 1, 0.0D, 1.0D, 1.0D);
            tessellator.func_78374_a(k - 1, k4, 0.0D, 1.0D, 0.0D);
            tessellator.func_78374_a(j, k4, 0.0D, 0.0D, 0.0D);
            tessellator.func_78381_a();
        }
        func_77215_b(p_77211_1_, p_77211_2_);
        GL11.glEnable(3553);
        GL11.glShadeModel(7424);
        GL11.glEnable(3008);
        GL11.glDisable(3042);
    }

    protected int func_77225_g()
    {
        return field_77228_g / 2 + 124;
    }

    private void func_77206_b(int p_77206_1_, int p_77206_2_, int p_77206_3_, int p_77206_4_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        GL11.glBindTexture(3553, field_77233_a.field_71446_o.func_78341_b("/gui/background.png"));
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        float f = 32F;
        tessellator.func_78382_b();
        tessellator.func_78384_a(0x404040, p_77206_4_);
        tessellator.func_78374_a(0.0D, p_77206_2_, 0.0D, 0.0D, (float)p_77206_2_ / f);
        tessellator.func_78374_a(field_77228_g, p_77206_2_, 0.0D, (float)field_77228_g / f, (float)p_77206_2_ / f);
        tessellator.func_78384_a(0x404040, p_77206_3_);
        tessellator.func_78374_a(field_77228_g, p_77206_1_, 0.0D, (float)field_77228_g / f, (float)p_77206_1_ / f);
        tessellator.func_78374_a(0.0D, p_77206_1_, 0.0D, 0.0D, (float)p_77206_1_ / f);
        tessellator.func_78381_a();
    }
}
