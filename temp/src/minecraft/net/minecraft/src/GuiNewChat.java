// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Gui, GameSettings, ChatLine, StringUtils, 
//            FontRenderer, GuiIngame, ScaledResolution, ChatClickData, 
//            StringTranslate, GuiChat

public class GuiNewChat extends Gui
{

    private final Minecraft field_73772_a;
    private final List field_73770_b = new ArrayList();
    private final List field_73771_c = new ArrayList();
    private int field_73768_d;
    private boolean field_73769_e;

    public GuiNewChat(Minecraft p_i3043_1_)
    {
        field_73768_d = 0;
        field_73769_e = false;
        field_73772_a = p_i3043_1_;
    }

    public void func_73762_a(int p_73762_1_)
    {
        if(field_73772_a.field_71474_y.field_74343_n == 2)
        {
            return;
        }
        byte byte0 = 10;
        boolean flag = false;
        int i = 0;
        int j = field_73771_c.size();
        float f = field_73772_a.field_71474_y.field_74357_r * 0.9F + 0.1F;
        if(j <= 0)
        {
            return;
        }
        if(func_73760_d())
        {
            byte0 = 20;
            flag = true;
        }
        for(int k = 0; k + field_73768_d < field_73771_c.size() && k < byte0; k++)
        {
            ChatLine chatline = (ChatLine)field_73771_c.get(k + field_73768_d);
            if(chatline == null)
            {
                continue;
            }
            int j1 = p_73762_1_ - chatline.func_74540_b();
            if(j1 >= 200 && !flag)
            {
                continue;
            }
            double d = (double)j1 / 200D;
            d = 1.0D - d;
            d *= 10D;
            if(d < 0.0D)
            {
                d = 0.0D;
            }
            if(d > 1.0D)
            {
                d = 1.0D;
            }
            d *= d;
            int j2 = (int)(255D * d);
            if(flag)
            {
                j2 = 255;
            }
            j2 = (int)((float)j2 * f);
            i++;
            if(j2 <= 3)
            {
                continue;
            }
            byte byte1 = 3;
            int l2 = -k * 9;
            func_73734_a(byte1, l2 - 1, byte1 + 320 + 4, l2 + 8, j2 / 2 << 24);
            GL11.glEnable(3042);
            String s = chatline.func_74538_a();
            if(!field_73772_a.field_71474_y.field_74344_o)
            {
                s = StringUtils.func_76338_a(s);
            }
            field_73772_a.field_71466_p.func_78261_a(s, byte1, l2, 0xffffff + (j2 << 24));
        }

        if(flag)
        {
            int l = field_73772_a.field_71466_p.field_78288_b;
            GL11.glTranslatef(0.0F, l, 0.0F);
            int i1 = j * l + j;
            int k1 = i * l + i;
            int l1 = (field_73768_d * k1) / j;
            int i2 = (k1 * k1) / i1;
            if(i1 != k1)
            {
                char c = l1 <= 0 ? '`' : '\252';
                int k2 = field_73769_e ? 0xcc3333 : 0x3333aa;
                func_73734_a(0, -l1, 2, -l1 - i2, k2 + (c << 24));
                func_73734_a(2, -l1, 1, -l1 - i2, 0xcccccc + (c << 24));
            }
        }
    }

    public void func_73761_a()
    {
        field_73771_c.clear();
        field_73770_b.clear();
    }

    public void func_73765_a(String p_73765_1_)
    {
        func_73763_a(p_73765_1_, 0);
    }

    public void func_73763_a(String p_73763_1_, int p_73763_2_)
    {
        boolean flag = func_73760_d();
        boolean flag1 = true;
        if(p_73763_2_ != 0)
        {
            func_73759_c(p_73763_2_);
        }
        String s;
        for(Iterator iterator = field_73772_a.field_71466_p.func_78271_c(p_73763_1_, 320).iterator(); iterator.hasNext(); field_73771_c.add(0, new ChatLine(field_73772_a.field_71456_v.func_73834_c(), s, p_73763_2_)))
        {
            s = (String)iterator.next();
            if(flag && field_73768_d > 0)
            {
                field_73769_e = true;
                func_73758_b(1);
            }
            if(!flag1)
            {
                s = (new StringBuilder()).append(" ").append(s).toString();
            }
            flag1 = false;
        }

        for(; field_73771_c.size() > 100; field_73771_c.remove(field_73771_c.size() - 1)) { }
    }

    public List func_73756_b()
    {
        return field_73770_b;
    }

    public void func_73767_b(String p_73767_1_)
    {
        if(field_73770_b.isEmpty() || !((String)field_73770_b.get(field_73770_b.size() - 1)).equals(p_73767_1_))
        {
            field_73770_b.add(p_73767_1_);
        }
    }

    public void func_73764_c()
    {
        field_73768_d = 0;
        field_73769_e = false;
    }

    public void func_73758_b(int p_73758_1_)
    {
        field_73768_d += p_73758_1_;
        int i = field_73771_c.size();
        if(field_73768_d > i - 20)
        {
            field_73768_d = i - 20;
        }
        if(field_73768_d <= 0)
        {
            field_73768_d = 0;
            field_73769_e = false;
        }
    }

    public ChatClickData func_73766_a(int p_73766_1_, int p_73766_2_)
    {
        if(!func_73760_d())
        {
            return null;
        }
        ScaledResolution scaledresolution = new ScaledResolution(field_73772_a.field_71474_y, field_73772_a.field_71443_c, field_73772_a.field_71440_d);
        int i = scaledresolution.func_78325_e();
        int j = p_73766_1_ / i - 3;
        int k = p_73766_2_ / i - 40;
        if(j < 0 || k < 0)
        {
            return null;
        }
        int l = Math.min(20, field_73771_c.size());
        if(j <= 320 && k < field_73772_a.field_71466_p.field_78288_b * l + l)
        {
            int i1 = k / (field_73772_a.field_71466_p.field_78288_b + 1) + field_73768_d;
            return new ChatClickData(field_73772_a.field_71466_p, (ChatLine)field_73771_c.get(i1), j, (k - (i1 - field_73768_d) * field_73772_a.field_71466_p.field_78288_b) + i1);
        } else
        {
            return null;
        }
    }

    public void func_73757_a(String p_73757_1_, Object p_73757_2_[])
    {
        func_73765_a(StringTranslate.func_74808_a().func_74803_a(p_73757_1_, p_73757_2_));
    }

    public boolean func_73760_d()
    {
        return field_73772_a.field_71462_r instanceof GuiChat;
    }

    public void func_73759_c(int p_73759_1_)
    {
        for(Iterator iterator = field_73771_c.iterator(); iterator.hasNext();)
        {
            ChatLine chatline = (ChatLine)iterator.next();
            if(chatline.func_74539_c() == p_73759_1_)
            {
                iterator.remove();
                return;
            }
        }

    }
}
