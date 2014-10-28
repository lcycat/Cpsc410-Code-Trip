// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Mouse;

// Referenced classes of package net.minecraft.src:
//            GuiSlot, GuiStats, SoundManager, StatCrafting, 
//            StatFileWriter, FontRenderer, StringTranslate, Item, 
//            Tessellator

abstract class GuiSlotStats extends GuiSlot
{

    protected int field_77262_g;
    protected List field_77266_h;
    protected Comparator field_77267_i;
    protected int field_77264_j;
    protected int field_77265_k;
    final GuiStats field_77263_l; /* synthetic field */

    protected GuiSlotStats(GuiStats p_i3071_1_)
    {
        field_77263_l = p_i3071_1_;
        super(GuiStats.func_74139_f(p_i3071_1_), p_i3071_1_.field_73880_f, p_i3071_1_.field_73881_g, 32, p_i3071_1_.field_73881_g - 64, 20);
        field_77262_g = -1;
        field_77264_j = -1;
        field_77265_k = 0;
        func_77216_a(false);
        func_77223_a(true, 20);
    }

    protected void func_77213_a(int i, boolean flag)
    {
    }

    protected boolean func_77218_a(int p_77218_1_)
    {
        return false;
    }

    protected void func_77221_c()
    {
        field_77263_l.func_73873_v_();
    }

    protected void func_77222_a(int p_77222_1_, int p_77222_2_, Tessellator p_77222_3_)
    {
        if(!Mouse.isButtonDown(0))
        {
            field_77262_g = -1;
        }
        if(field_77262_g == 0)
        {
            GuiStats.func_74134_a(field_77263_l, (p_77222_1_ + 115) - 18, p_77222_2_ + 1, 0, 0);
        } else
        {
            GuiStats.func_74134_a(field_77263_l, (p_77222_1_ + 115) - 18, p_77222_2_ + 1, 0, 18);
        }
        if(field_77262_g == 1)
        {
            GuiStats.func_74134_a(field_77263_l, (p_77222_1_ + 165) - 18, p_77222_2_ + 1, 0, 0);
        } else
        {
            GuiStats.func_74134_a(field_77263_l, (p_77222_1_ + 165) - 18, p_77222_2_ + 1, 0, 18);
        }
        if(field_77262_g == 2)
        {
            GuiStats.func_74134_a(field_77263_l, (p_77222_1_ + 215) - 18, p_77222_2_ + 1, 0, 0);
        } else
        {
            GuiStats.func_74134_a(field_77263_l, (p_77222_1_ + 215) - 18, p_77222_2_ + 1, 0, 18);
        }
        if(field_77264_j != -1)
        {
            char c = 'O';
            byte byte0 = 18;
            if(field_77264_j == 1)
            {
                c = '\201';
            } else
            if(field_77264_j == 2)
            {
                c = '\263';
            }
            if(field_77265_k == 1)
            {
                byte0 = 36;
            }
            GuiStats.func_74134_a(field_77263_l, p_77222_1_ + c, p_77222_2_ + 1, byte0, 0);
        }
    }

    protected void func_77224_a(int p_77224_1_, int p_77224_2_)
    {
        field_77262_g = -1;
        if(p_77224_1_ >= 79 && p_77224_1_ < 115)
        {
            field_77262_g = 0;
        } else
        if(p_77224_1_ >= 129 && p_77224_1_ < 165)
        {
            field_77262_g = 1;
        } else
        if(p_77224_1_ >= 179 && p_77224_1_ < 215)
        {
            field_77262_g = 2;
        }
        if(field_77262_g >= 0)
        {
            func_77261_e(field_77262_g);
            GuiStats.func_74133_g(field_77263_l).field_71416_A.func_77366_a("random.click", 1.0F, 1.0F);
        }
    }

    protected final int func_77217_a()
    {
        return field_77266_h.size();
    }

    protected final StatCrafting func_77257_d(int p_77257_1_)
    {
        return (StatCrafting)field_77266_h.get(p_77257_1_);
    }

    protected abstract String func_77258_c(int i);

    protected void func_77260_a(StatCrafting p_77260_1_, int p_77260_2_, int p_77260_3_, boolean p_77260_4_)
    {
        if(p_77260_1_ != null)
        {
            String s = p_77260_1_.func_75968_a(GuiStats.func_74127_c(field_77263_l).func_77444_a(p_77260_1_));
            field_77263_l.func_73731_b(GuiStats.func_74129_h(field_77263_l), s, p_77260_2_ - GuiStats.func_74146_i(field_77263_l).func_78256_a(s), p_77260_3_ + 5, p_77260_4_ ? 0xffffff : 0x909090);
        } else
        {
            String s1 = "-";
            field_77263_l.func_73731_b(GuiStats.func_74135_j(field_77263_l), s1, p_77260_2_ - GuiStats.func_74148_k(field_77263_l).func_78256_a(s1), p_77260_3_ + 5, p_77260_4_ ? 0xffffff : 0x909090);
        }
    }

    protected void func_77215_b(int p_77215_1_, int p_77215_2_)
    {
        if(p_77215_2_ < field_77231_b || p_77215_2_ > field_77232_c)
        {
            return;
        }
        int i = func_77210_c(p_77215_1_, p_77215_2_);
        int j = field_77263_l.field_73880_f / 2 - 92 - 16;
        if(i >= 0)
        {
            if(p_77215_1_ < j + 40 || p_77215_1_ > j + 40 + 20)
            {
                return;
            }
            StatCrafting statcrafting = func_77257_d(i);
            func_77259_a(statcrafting, p_77215_1_, p_77215_2_);
        } else
        {
            String s = "";
            if(p_77215_1_ >= (j + 115) - 18 && p_77215_1_ <= j + 115)
            {
                s = func_77258_c(0);
            } else
            if(p_77215_1_ >= (j + 165) - 18 && p_77215_1_ <= j + 165)
            {
                s = func_77258_c(1);
            } else
            if(p_77215_1_ >= (j + 215) - 18 && p_77215_1_ <= j + 215)
            {
                s = func_77258_c(2);
            } else
            {
                return;
            }
            s = (new StringBuilder()).append("").append(StringTranslate.func_74808_a().func_74805_b(s)).toString().trim();
            if(s.length() > 0)
            {
                int k = p_77215_1_ + 12;
                int l = p_77215_2_ - 12;
                int i1 = GuiStats.func_74147_l(field_77263_l).func_78256_a(s);
                GuiStats.func_74149_a(field_77263_l, k - 3, l - 3, k + i1 + 3, l + 8 + 3, 0xc0000000, 0xc0000000);
                GuiStats.func_74141_m(field_77263_l).func_78261_a(s, k, l, -1);
            }
        }
    }

    protected void func_77259_a(StatCrafting p_77259_1_, int p_77259_2_, int p_77259_3_)
    {
        if(p_77259_1_ == null)
        {
            return;
        }
        Item item = Item.field_77698_e[p_77259_1_.func_75982_a()];
        String s = (new StringBuilder()).append("").append(StringTranslate.func_74808_a().func_74809_c(item.func_77658_a())).toString().trim();
        if(s.length() > 0)
        {
            int i = p_77259_2_ + 12;
            int j = p_77259_3_ - 12;
            int k = GuiStats.func_74140_n(field_77263_l).func_78256_a(s);
            GuiStats.func_74136_b(field_77263_l, i - 3, j - 3, i + k + 3, j + 8 + 3, 0xc0000000, 0xc0000000);
            GuiStats.func_74144_o(field_77263_l).func_78261_a(s, i, j, -1);
        }
    }

    protected void func_77261_e(int p_77261_1_)
    {
        if(p_77261_1_ != field_77264_j)
        {
            field_77264_j = p_77261_1_;
            field_77265_k = -1;
        } else
        if(field_77265_k == -1)
        {
            field_77265_k = 1;
        } else
        {
            field_77264_j = -1;
            field_77265_k = 0;
        }
        Collections.sort(field_77266_h, field_77267_i);
    }
}
