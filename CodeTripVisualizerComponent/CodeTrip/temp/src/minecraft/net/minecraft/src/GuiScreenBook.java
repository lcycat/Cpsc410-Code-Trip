// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, ItemStack, NBTTagCompound, NBTTagList, 
//            NBTTagString, GuiButton, StatCollector, GuiButtonNextPage, 
//            EntityPlayer, Item, Packet, Packet250CustomPayload, 
//            NetClientHandler, ChatAllowedCharacters, FontRenderer, RenderEngine

public class GuiScreenBook extends GuiScreen
{

    private final EntityPlayer field_74169_a;
    private final ItemStack field_74167_b;
    private final boolean field_74168_c;
    private boolean field_74166_d;
    private boolean field_74172_m;
    private int field_74170_n;
    private int field_74171_o;
    private int field_74180_p;
    private int field_74179_q;
    private int field_74178_r;
    private NBTTagList field_74177_s;
    private String field_74176_t;
    private GuiButtonNextPage field_74175_u;
    private GuiButtonNextPage field_74174_v;
    private GuiButton field_74173_w;
    private GuiButton field_74183_x;
    private GuiButton field_74182_y;
    private GuiButton field_74181_z;

    public GuiScreenBook(EntityPlayer p_i3085_1_, ItemStack p_i3085_2_, boolean p_i3085_3_)
    {
        field_74171_o = 192;
        field_74180_p = 192;
        field_74179_q = 1;
        field_74176_t = "";
        field_74169_a = p_i3085_1_;
        field_74167_b = p_i3085_2_;
        field_74168_c = p_i3085_3_;
        if(p_i3085_2_.func_77942_o())
        {
            NBTTagCompound nbttagcompound = p_i3085_2_.func_77978_p();
            field_74177_s = nbttagcompound.func_74761_m("pages");
            if(field_74177_s != null)
            {
                field_74177_s = (NBTTagList)field_74177_s.func_74737_b();
                field_74179_q = field_74177_s.func_74745_c();
                if(field_74179_q < 1)
                {
                    field_74179_q = 1;
                }
            }
        }
        if(field_74177_s == null && p_i3085_3_)
        {
            field_74177_s = new NBTTagList("pages");
            field_74177_s.func_74742_a(new NBTTagString("1", ""));
            field_74179_q = 1;
        }
    }

    public void func_73876_c()
    {
        super.func_73876_c();
        field_74170_n++;
    }

    public void func_73866_w_()
    {
        field_73887_h.clear();
        Keyboard.enableRepeatEvents(true);
        if(field_74168_c)
        {
            field_73887_h.add(field_74183_x = new GuiButton(3, field_73880_f / 2 - 100, 4 + field_74180_p, 98, 20, StatCollector.func_74838_a("book.signButton")));
            field_73887_h.add(field_74173_w = new GuiButton(0, field_73880_f / 2 + 2, 4 + field_74180_p, 98, 20, StatCollector.func_74838_a("gui.done")));
            field_73887_h.add(field_74182_y = new GuiButton(5, field_73880_f / 2 - 100, 4 + field_74180_p, 98, 20, StatCollector.func_74838_a("book.finalizeButton")));
            field_73887_h.add(field_74181_z = new GuiButton(4, field_73880_f / 2 + 2, 4 + field_74180_p, 98, 20, StatCollector.func_74838_a("gui.cancel")));
        } else
        {
            field_73887_h.add(field_74173_w = new GuiButton(0, field_73880_f / 2 - 100, 4 + field_74180_p, 200, 20, StatCollector.func_74838_a("gui.done")));
        }
        int i = (field_73880_f - field_74171_o) / 2;
        byte byte0 = 2;
        field_73887_h.add(field_74175_u = new GuiButtonNextPage(1, i + 120, byte0 + 154, true));
        field_73887_h.add(field_74174_v = new GuiButtonNextPage(2, i + 38, byte0 + 154, false));
        func_74161_g();
    }

    public void func_73874_b()
    {
        Keyboard.enableRepeatEvents(false);
    }

    private void func_74161_g()
    {
        field_74175_u.field_73748_h = !field_74172_m && (field_74178_r < field_74179_q - 1 || field_74168_c);
        field_74174_v.field_73748_h = !field_74172_m && field_74178_r > 0;
        field_74173_w.field_73748_h = !field_74168_c || !field_74172_m;
        if(field_74168_c)
        {
            field_74183_x.field_73748_h = !field_74172_m;
            field_74181_z.field_73748_h = field_74172_m;
            field_74182_y.field_73748_h = field_74172_m;
            field_74182_y.field_73742_g = field_74176_t.trim().length() > 0;
        }
    }

    private void func_74163_a(boolean p_74163_1_)
    {
        if(!field_74168_c || !field_74166_d)
        {
            return;
        }
        if(field_74177_s != null)
        {
            do
            {
                if(field_74177_s.func_74745_c() <= 1)
                {
                    break;
                }
                NBTTagString nbttagstring = (NBTTagString)field_74177_s.func_74743_b(field_74177_s.func_74745_c() - 1);
                if(nbttagstring.field_74751_a != null && nbttagstring.field_74751_a.length() != 0)
                {
                    break;
                }
                field_74177_s.func_74744_a(field_74177_s.func_74745_c() - 1);
            } while(true);
            if(field_74167_b.func_77942_o())
            {
                NBTTagCompound nbttagcompound = field_74167_b.func_77978_p();
                nbttagcompound.func_74782_a("pages", field_74177_s);
            } else
            {
                field_74167_b.func_77983_a("pages", field_74177_s);
            }
            String s = "MC|BEdit";
            if(p_74163_1_)
            {
                s = "MC|BSign";
                field_74167_b.func_77983_a("author", new NBTTagString("author", field_74169_a.field_71092_bJ));
                field_74167_b.func_77983_a("title", new NBTTagString("title", field_74176_t.trim()));
                field_74167_b.field_77993_c = Item.field_77823_bG.field_77779_bT;
            }
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);
            try
            {
                Packet.func_73270_a(field_74167_b, dataoutputstream);
                field_73882_e.func_71391_r().func_72552_c(new Packet250CustomPayload(s, bytearrayoutputstream.toByteArray()));
            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        if(!p_73875_1_.field_73742_g)
        {
            return;
        }
        if(p_73875_1_.field_73741_f == 0)
        {
            field_73882_e.func_71373_a(null);
            func_74163_a(false);
        } else
        if(p_73875_1_.field_73741_f == 3 && field_74168_c)
        {
            field_74172_m = true;
        } else
        if(p_73875_1_.field_73741_f == 1)
        {
            if(field_74178_r < field_74179_q - 1)
            {
                field_74178_r++;
            } else
            if(field_74168_c)
            {
                func_74165_h();
                if(field_74178_r < field_74179_q - 1)
                {
                    field_74178_r++;
                }
            }
        } else
        if(p_73875_1_.field_73741_f == 2)
        {
            if(field_74178_r > 0)
            {
                field_74178_r--;
            }
        } else
        if(p_73875_1_.field_73741_f == 5 && field_74172_m)
        {
            func_74163_a(true);
            field_73882_e.func_71373_a(null);
        } else
        if(p_73875_1_.field_73741_f == 4 && field_74172_m)
        {
            field_74172_m = false;
        }
        func_74161_g();
    }

    private void func_74165_h()
    {
        if(field_74177_s == null || field_74177_s.func_74745_c() >= 50)
        {
            return;
        } else
        {
            field_74177_s.func_74742_a(new NBTTagString((new StringBuilder()).append("").append(field_74179_q + 1).toString(), ""));
            field_74179_q++;
            field_74166_d = true;
            return;
        }
    }

    protected void func_73869_a(char p_73869_1_, int p_73869_2_)
    {
        super.func_73869_a(p_73869_1_, p_73869_2_);
        if(!field_74168_c)
        {
            return;
        }
        if(field_74172_m)
        {
            func_74162_c(p_73869_1_, p_73869_2_);
        } else
        {
            func_74164_b(p_73869_1_, p_73869_2_);
        }
    }

    private void func_74164_b(char p_74164_1_, int p_74164_2_)
    {
        switch(p_74164_1_)
        {
        case 22: // '\026'
            func_74160_b(GuiScreen.func_73870_l());
            return;
        }
        switch(p_74164_2_)
        {
        case 14: // '\016'
            String s = func_74158_i();
            if(s.length() > 0)
            {
                func_74159_a(s.substring(0, s.length() - 1));
            }
            return;

        case 28: // '\034'
            func_74160_b("\n");
            return;
        }
        if(ChatAllowedCharacters.func_71566_a(p_74164_1_))
        {
            func_74160_b(Character.toString(p_74164_1_));
            return;
        } else
        {
            return;
        }
    }

    private void func_74162_c(char p_74162_1_, int p_74162_2_)
    {
        switch(p_74162_2_)
        {
        case 14: // '\016'
            if(field_74176_t.length() > 0)
            {
                field_74176_t = field_74176_t.substring(0, field_74176_t.length() - 1);
                func_74161_g();
            }
            return;

        case 28: // '\034'
            if(field_74176_t.length() > 0)
            {
                func_74163_a(true);
                field_73882_e.func_71373_a(null);
            }
            return;
        }
        if(field_74176_t.length() >= 16 || !ChatAllowedCharacters.func_71566_a(p_74162_1_))
        {
            break MISSING_BLOCK_LABEL_145;
        }
        new StringBuilder();
        this;
        JVM INSTR dup_x1 ;
        field_74176_t;
        append();
        Character.toString(p_74162_1_);
        append();
        toString();
        field_74176_t;
        func_74161_g();
        field_74166_d = true;
        return;
    }

    private String func_74158_i()
    {
        if(field_74177_s != null && field_74178_r >= 0 && field_74178_r < field_74177_s.func_74745_c())
        {
            NBTTagString nbttagstring = (NBTTagString)field_74177_s.func_74743_b(field_74178_r);
            return nbttagstring.toString();
        } else
        {
            return "";
        }
    }

    private void func_74159_a(String p_74159_1_)
    {
        if(field_74177_s != null && field_74178_r >= 0 && field_74178_r < field_74177_s.func_74745_c())
        {
            NBTTagString nbttagstring = (NBTTagString)field_74177_s.func_74743_b(field_74178_r);
            nbttagstring.field_74751_a = p_74159_1_;
            field_74166_d = true;
        }
    }

    private void func_74160_b(String p_74160_1_)
    {
        String s = func_74158_i();
        String s1 = (new StringBuilder()).append(s).append(p_74160_1_).toString();
        int i = field_73886_k.func_78267_b((new StringBuilder()).append(s1).append("\2470_").toString(), 118);
        if(i <= 118 && s1.length() < 256)
        {
            func_74159_a(s1);
        }
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        int i = field_73882_e.field_71446_o.func_78341_b("/gui/book.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        field_73882_e.field_71446_o.func_78342_b(i);
        int j = (field_73880_f - field_74171_o) / 2;
        byte byte0 = 2;
        func_73729_b(j, byte0, 0, 0, field_74171_o, field_74180_p);
        if(field_74172_m)
        {
            String s = field_74176_t;
            if(field_74168_c)
            {
                if((field_74170_n / 6) % 2 == 0)
                {
                    s = (new StringBuilder()).append(s).append("\2470_").toString();
                } else
                {
                    s = (new StringBuilder()).append(s).append("\2477_").toString();
                }
            }
            String s2 = StatCollector.func_74838_a("book.editTitle");
            int k = field_73886_k.func_78256_a(s2);
            field_73886_k.func_78276_b(s2, j + 36 + (116 - k) / 2, byte0 + 16 + 16, 0);
            int i1 = field_73886_k.func_78256_a(s);
            field_73886_k.func_78276_b(s, j + 36 + (116 - i1) / 2, byte0 + 48, 0);
            String s4 = String.format(StatCollector.func_74838_a("book.byAuthor"), new Object[] {
                field_74169_a.field_71092_bJ
            });
            int j1 = field_73886_k.func_78256_a(s4);
            field_73886_k.func_78276_b((new StringBuilder()).append("\2478").append(s4).toString(), j + 36 + (116 - j1) / 2, byte0 + 48 + 10, 0);
            String s5 = StatCollector.func_74838_a("book.finalizeWarning");
            field_73886_k.func_78279_b(s5, j + 36, byte0 + 80, 116, 0);
        } else
        {
            String s1 = String.format(StatCollector.func_74838_a("book.pageIndicator"), new Object[] {
                Integer.valueOf(field_74178_r + 1), Integer.valueOf(field_74179_q)
            });
            String s3 = "";
            if(field_74177_s != null && field_74178_r >= 0 && field_74178_r < field_74177_s.func_74745_c())
            {
                NBTTagString nbttagstring = (NBTTagString)field_74177_s.func_74743_b(field_74178_r);
                s3 = nbttagstring.toString();
            }
            if(field_74168_c)
            {
                if(field_73886_k.func_78260_a())
                {
                    s3 = (new StringBuilder()).append(s3).append("_").toString();
                } else
                if((field_74170_n / 6) % 2 == 0)
                {
                    s3 = (new StringBuilder()).append(s3).append("\2470_").toString();
                } else
                {
                    s3 = (new StringBuilder()).append(s3).append("\2477_").toString();
                }
            }
            int l = field_73886_k.func_78256_a(s1);
            field_73886_k.func_78276_b(s1, ((j - l) + field_74171_o) - 44, byte0 + 16, 0);
            field_73886_k.func_78279_b(s3, j + 36, byte0 + 16 + 16, 116, 0);
        }
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
    }
}
