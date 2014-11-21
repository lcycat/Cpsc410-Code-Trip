// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Gui, ChatAllowedCharacters, GuiScreen, FontRenderer, 
//            Tessellator

public class GuiTextField extends Gui
{

    private final FontRenderer field_73815_a;
    private final int field_73813_b;
    private final int field_73814_c;
    private final int field_73811_d;
    private final int field_73812_e;
    private String field_73809_f;
    private int field_73810_g;
    private int field_73822_h;
    private boolean field_73820_j;
    private boolean field_73821_k;
    private boolean field_73818_l;
    private boolean field_73819_m;
    private int field_73816_n;
    private int field_73817_o;
    private int field_73826_p;
    private int field_73825_q;
    private int field_73824_r;
    private boolean field_73823_s;

    public GuiTextField(FontRenderer p_i3050_1_, int p_i3050_2_, int p_i3050_3_, int p_i3050_4_, int p_i3050_5_)
    {
        field_73809_f = "";
        field_73810_g = 32;
        field_73820_j = true;
        field_73821_k = true;
        field_73818_l = false;
        field_73819_m = true;
        field_73816_n = 0;
        field_73817_o = 0;
        field_73826_p = 0;
        field_73825_q = 0xe0e0e0;
        field_73824_r = 0x707070;
        field_73823_s = true;
        field_73815_a = p_i3050_1_;
        field_73813_b = p_i3050_2_;
        field_73814_c = p_i3050_3_;
        field_73811_d = p_i3050_4_;
        field_73812_e = p_i3050_5_;
    }

    public void func_73780_a()
    {
        field_73822_h++;
    }

    public void func_73782_a(String p_73782_1_)
    {
        if(p_73782_1_.length() > field_73810_g)
        {
            field_73809_f = p_73782_1_.substring(0, field_73810_g);
        } else
        {
            field_73809_f = p_73782_1_;
        }
        func_73803_e();
    }

    public String func_73781_b()
    {
        return field_73809_f;
    }

    public String func_73807_c()
    {
        int i = field_73817_o >= field_73826_p ? field_73826_p : field_73817_o;
        int j = field_73817_o >= field_73826_p ? field_73817_o : field_73826_p;
        return field_73809_f.substring(i, j);
    }

    public void func_73792_b(String p_73792_1_)
    {
        String s = "";
        String s1 = ChatAllowedCharacters.func_71565_a(p_73792_1_);
        int i = field_73817_o >= field_73826_p ? field_73826_p : field_73817_o;
        int j = field_73817_o >= field_73826_p ? field_73817_o : field_73826_p;
        int k = field_73810_g - field_73809_f.length() - (i - field_73826_p);
        int l = 0;
        if(field_73809_f.length() > 0)
        {
            s = (new StringBuilder()).append(s).append(field_73809_f.substring(0, i)).toString();
        }
        if(k < s1.length())
        {
            s = (new StringBuilder()).append(s).append(s1.substring(0, k)).toString();
            l = k;
        } else
        {
            s = (new StringBuilder()).append(s).append(s1).toString();
            l = s1.length();
        }
        if(field_73809_f.length() > 0 && j < field_73809_f.length())
        {
            s = (new StringBuilder()).append(s).append(field_73809_f.substring(j)).toString();
        }
        field_73809_f = s;
        func_73784_d((i - field_73826_p) + l);
    }

    public void func_73779_a(int p_73779_1_)
    {
        if(field_73809_f.length() == 0)
        {
            return;
        }
        if(field_73826_p != field_73817_o)
        {
            func_73792_b("");
            return;
        } else
        {
            func_73777_b(func_73788_c(p_73779_1_) - field_73817_o);
            return;
        }
    }

    public void func_73777_b(int p_73777_1_)
    {
        if(field_73809_f.length() == 0)
        {
            return;
        }
        if(field_73826_p != field_73817_o)
        {
            func_73792_b("");
            return;
        }
        boolean flag = p_73777_1_ < 0;
        int i = flag ? field_73817_o + p_73777_1_ : field_73817_o;
        int j = flag ? field_73817_o : field_73817_o + p_73777_1_;
        String s = "";
        if(i >= 0)
        {
            s = field_73809_f.substring(0, i);
        }
        if(j < field_73809_f.length())
        {
            s = (new StringBuilder()).append(s).append(field_73809_f.substring(j)).toString();
        }
        field_73809_f = s;
        if(flag)
        {
            func_73784_d(p_73777_1_);
        }
    }

    public int func_73788_c(int p_73788_1_)
    {
        return func_73785_a(p_73788_1_, func_73799_h());
    }

    public int func_73785_a(int p_73785_1_, int p_73785_2_)
    {
        return func_73798_a(p_73785_1_, func_73799_h(), true);
    }

    public int func_73798_a(int p_73798_1_, int p_73798_2_, boolean p_73798_3_)
    {
        int i = p_73798_2_;
        boolean flag = p_73798_1_ < 0;
        int j = Math.abs(p_73798_1_);
        for(int k = 0; k < j; k++)
        {
            if(flag)
            {
                for(; p_73798_3_ && i > 0 && field_73809_f.charAt(i - 1) == ' '; i--) { }
                for(; i > 0 && field_73809_f.charAt(i - 1) != ' '; i--) { }
                continue;
            }
            int l = field_73809_f.length();
            i = field_73809_f.indexOf(' ', i);
            if(i == -1)
            {
                i = l;
                continue;
            }
            for(; p_73798_3_ && i < l && field_73809_f.charAt(i) == ' '; i++) { }
        }

        return i;
    }

    public void func_73784_d(int p_73784_1_)
    {
        func_73791_e(field_73826_p + p_73784_1_);
    }

    public void func_73791_e(int p_73791_1_)
    {
        field_73817_o = p_73791_1_;
        int i = field_73809_f.length();
        if(field_73817_o < 0)
        {
            field_73817_o = 0;
        }
        if(field_73817_o > i)
        {
            field_73817_o = i;
        }
        func_73800_i(field_73817_o);
    }

    public void func_73797_d()
    {
        func_73791_e(0);
    }

    public void func_73803_e()
    {
        func_73791_e(field_73809_f.length());
    }

    public boolean func_73802_a(char p_73802_1_, int p_73802_2_)
    {
        if(!field_73819_m || !field_73818_l)
        {
            return false;
        }
        switch(p_73802_1_)
        {
        case 1: // '\001'
            func_73803_e();
            func_73800_i(0);
            return true;

        case 3: // '\003'
            GuiScreen.func_73865_d(func_73807_c());
            return true;

        case 22: // '\026'
            func_73792_b(GuiScreen.func_73870_l());
            return true;

        case 24: // '\030'
            GuiScreen.func_73865_d(func_73807_c());
            func_73792_b("");
            return true;
        }
        switch(p_73802_2_)
        {
        case 203: 
            if(GuiScreen.func_73877_p())
            {
                if(GuiScreen.func_73861_o())
                {
                    func_73800_i(func_73785_a(-1, func_73787_n()));
                } else
                {
                    func_73800_i(func_73787_n() - 1);
                }
            } else
            if(GuiScreen.func_73861_o())
            {
                func_73791_e(func_73788_c(-1));
            } else
            {
                func_73784_d(-1);
            }
            return true;

        case 205: 
            if(GuiScreen.func_73877_p())
            {
                if(GuiScreen.func_73861_o())
                {
                    func_73800_i(func_73785_a(1, func_73787_n()));
                } else
                {
                    func_73800_i(func_73787_n() + 1);
                }
            } else
            if(GuiScreen.func_73861_o())
            {
                func_73791_e(func_73788_c(1));
            } else
            {
                func_73784_d(1);
            }
            return true;

        case 14: // '\016'
            if(GuiScreen.func_73861_o())
            {
                func_73779_a(-1);
            } else
            {
                func_73777_b(-1);
            }
            return true;

        case 211: 
            if(GuiScreen.func_73861_o())
            {
                func_73779_a(1);
            } else
            {
                func_73777_b(1);
            }
            return true;

        case 199: 
            if(GuiScreen.func_73877_p())
            {
                func_73800_i(0);
            } else
            {
                func_73797_d();
            }
            return true;

        case 207: 
            if(GuiScreen.func_73877_p())
            {
                func_73800_i(field_73809_f.length());
            } else
            {
                func_73803_e();
            }
            return true;
        }
        if(ChatAllowedCharacters.func_71566_a(p_73802_1_))
        {
            func_73792_b(Character.toString(p_73802_1_));
            return true;
        } else
        {
            return false;
        }
    }

    public void func_73793_a(int p_73793_1_, int p_73793_2_, int p_73793_3_)
    {
        boolean flag = p_73793_1_ >= field_73813_b && p_73793_1_ < field_73813_b + field_73811_d && p_73793_2_ >= field_73814_c && p_73793_2_ < field_73814_c + field_73812_e;
        if(field_73821_k)
        {
            func_73796_b(field_73819_m && flag);
        }
        if(field_73818_l && p_73793_3_ == 0)
        {
            int i = p_73793_1_ - field_73813_b;
            if(field_73820_j)
            {
                i -= 4;
            }
            String s = field_73815_a.func_78269_a(field_73809_f.substring(field_73816_n), func_73801_o());
            func_73791_e(field_73815_a.func_78269_a(s, i).length() + field_73816_n);
        }
    }

    public void func_73795_f()
    {
        if(!func_73778_q())
        {
            return;
        }
        if(func_73783_i())
        {
            func_73734_a(field_73813_b - 1, field_73814_c - 1, field_73813_b + field_73811_d + 1, field_73814_c + field_73812_e + 1, 0xffa0a0a0);
            func_73734_a(field_73813_b, field_73814_c, field_73813_b + field_73811_d, field_73814_c + field_73812_e, 0xff000000);
        }
        int i = field_73819_m ? field_73825_q : field_73824_r;
        int j = field_73817_o - field_73816_n;
        int k = field_73826_p - field_73816_n;
        String s = field_73815_a.func_78269_a(field_73809_f.substring(field_73816_n), func_73801_o());
        boolean flag = j >= 0 && j <= s.length();
        boolean flag1 = field_73818_l && (field_73822_h / 6) % 2 == 0 && flag;
        int l = field_73820_j ? field_73813_b + 4 : field_73813_b;
        int i1 = field_73820_j ? field_73814_c + (field_73812_e - 8) / 2 : field_73814_c;
        int j1 = l;
        if(k > s.length())
        {
            k = s.length();
        }
        if(s.length() > 0)
        {
            String s1 = flag ? s.substring(0, j) : s;
            j1 = field_73815_a.func_78261_a(s1, j1, i1, i);
        }
        boolean flag2 = field_73817_o < field_73809_f.length() || field_73809_f.length() >= func_73808_g();
        int k1 = j1;
        if(!flag)
        {
            k1 = j <= 0 ? l : l + field_73811_d;
        } else
        if(flag2)
        {
            k1--;
            j1--;
        }
        if(s.length() > 0 && flag && j < s.length())
        {
            j1 = field_73815_a.func_78261_a(s.substring(j), j1, i1, i);
        }
        if(flag1)
        {
            if(flag2)
            {
                Gui.func_73734_a(k1, i1 - 1, k1 + 1, i1 + 1 + field_73815_a.field_78288_b, 0xffd0d0d0);
            } else
            {
                field_73815_a.func_78261_a("_", k1, i1, i);
            }
        }
        if(k != j)
        {
            int l1 = l + field_73815_a.func_78256_a(s.substring(0, k));
            func_73789_c(k1, i1 - 1, l1 - 1, i1 + 1 + field_73815_a.field_78288_b);
        }
    }

    private void func_73789_c(int p_73789_1_, int p_73789_2_, int p_73789_3_, int p_73789_4_)
    {
        if(p_73789_1_ < p_73789_3_)
        {
            int i = p_73789_1_;
            p_73789_1_ = p_73789_3_;
            p_73789_3_ = i;
        }
        if(p_73789_2_ < p_73789_4_)
        {
            int j = p_73789_2_;
            p_73789_2_ = p_73789_4_;
            p_73789_4_ = j;
        }
        Tessellator tessellator = Tessellator.field_78398_a;
        GL11.glColor4f(0.0F, 0.0F, 255F, 255F);
        GL11.glDisable(3553);
        GL11.glEnable(3058);
        GL11.glLogicOp(5387);
        tessellator.func_78382_b();
        tessellator.func_78377_a(p_73789_1_, p_73789_4_, 0.0D);
        tessellator.func_78377_a(p_73789_3_, p_73789_4_, 0.0D);
        tessellator.func_78377_a(p_73789_3_, p_73789_2_, 0.0D);
        tessellator.func_78377_a(p_73789_1_, p_73789_2_, 0.0D);
        tessellator.func_78381_a();
        GL11.glDisable(3058);
        GL11.glEnable(3553);
    }

    public void func_73804_f(int p_73804_1_)
    {
        field_73810_g = p_73804_1_;
        if(field_73809_f.length() > p_73804_1_)
        {
            field_73809_f = field_73809_f.substring(0, p_73804_1_);
        }
    }

    public int func_73808_g()
    {
        return field_73810_g;
    }

    public int func_73799_h()
    {
        return field_73817_o;
    }

    public boolean func_73783_i()
    {
        return field_73820_j;
    }

    public void func_73786_a(boolean p_73786_1_)
    {
        field_73820_j = p_73786_1_;
    }

    public void func_73794_g(int p_73794_1_)
    {
        field_73825_q = p_73794_1_;
    }

    public void func_73796_b(boolean p_73796_1_)
    {
        if(p_73796_1_ && !field_73818_l)
        {
            field_73822_h = 0;
        }
        field_73818_l = p_73796_1_;
    }

    public boolean func_73806_l()
    {
        return field_73818_l;
    }

    public int func_73787_n()
    {
        return field_73826_p;
    }

    public int func_73801_o()
    {
        return func_73783_i() ? field_73811_d - 8 : field_73811_d;
    }

    public void func_73800_i(int p_73800_1_)
    {
        int i = field_73809_f.length();
        if(p_73800_1_ > i)
        {
            p_73800_1_ = i;
        }
        if(p_73800_1_ < 0)
        {
            p_73800_1_ = 0;
        }
        field_73826_p = p_73800_1_;
        if(field_73815_a != null)
        {
            if(field_73816_n > i)
            {
                field_73816_n = i;
            }
            int j = func_73801_o();
            String s = field_73815_a.func_78269_a(field_73809_f.substring(field_73816_n), j);
            int k = s.length() + field_73816_n;
            if(p_73800_1_ == field_73816_n)
            {
                field_73816_n -= field_73815_a.func_78262_a(field_73809_f, j, true).length();
            }
            if(p_73800_1_ > k)
            {
                field_73816_n += p_73800_1_ - k;
            } else
            if(p_73800_1_ <= field_73816_n)
            {
                field_73816_n -= field_73816_n - p_73800_1_;
            }
            if(field_73816_n < 0)
            {
                field_73816_n = 0;
            }
            if(field_73816_n > i)
            {
                field_73816_n = i;
            }
        }
    }

    public void func_73805_d(boolean p_73805_1_)
    {
        field_73821_k = p_73805_1_;
    }

    public boolean func_73778_q()
    {
        return field_73823_s;
    }

    public void func_73790_e(boolean p_73790_1_)
    {
        field_73823_s = p_73790_1_;
    }
}
