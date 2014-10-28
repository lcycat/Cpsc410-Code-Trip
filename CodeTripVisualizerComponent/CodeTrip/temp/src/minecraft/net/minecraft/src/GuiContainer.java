// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, EntityClientPlayerMP, RenderHelper, OpenGlHelper, 
//            Container, Slot, InventoryPlayer, RenderItem, 
//            ItemStack, FontRenderer, EnumRarity, RenderEngine, 
//            PlayerControllerMP, GameSettings, KeyBinding

public abstract class GuiContainer extends GuiScreen
{

    protected static RenderItem field_74196_a = new RenderItem();
    protected int field_74194_b;
    protected int field_74195_c;
    public Container field_74193_d;
    protected int field_74198_m;
    protected int field_74197_n;

    public GuiContainer(Container p_i3079_1_)
    {
        field_74194_b = 176;
        field_74195_c = 166;
        field_74193_d = p_i3079_1_;
    }

    public void func_73866_w_()
    {
        super.func_73866_w_();
        field_73882_e.field_71439_g.field_71070_bA = field_74193_d;
        field_74198_m = (field_73880_f - field_74194_b) / 2;
        field_74197_n = (field_73881_g - field_74195_c) / 2;
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        func_73873_v_();
        int i = field_74198_m;
        int j = field_74197_n;
        func_74185_a(p_73863_3_, p_73863_1_, p_73863_2_);
        GL11.glDisable(32826);
        RenderHelper.func_74518_a();
        GL11.glDisable(2896);
        GL11.glDisable(2929);
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
        RenderHelper.func_74520_c();
        GL11.glPushMatrix();
        GL11.glTranslatef(i, j, 0.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glEnable(32826);
        Slot slot = null;
        int k = 240;
        int i1 = 240;
        OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)k / 1.0F, (float)i1 / 1.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        for(int l = 0; l < field_74193_d.field_75151_b.size(); l++)
        {
            Slot slot1 = (Slot)field_74193_d.field_75151_b.get(l);
            func_74192_a(slot1);
            if(func_74186_a(slot1, p_73863_1_, p_73863_2_))
            {
                slot = slot1;
                GL11.glDisable(2896);
                GL11.glDisable(2929);
                int j1 = slot1.field_75223_e;
                int k1 = slot1.field_75221_f;
                func_73733_a(j1, k1, j1 + 16, k1 + 16, 0x80ffffff, 0x80ffffff);
                GL11.glEnable(2896);
                GL11.glEnable(2929);
            }
        }

        func_74189_g();
        InventoryPlayer inventoryplayer = field_73882_e.field_71439_g.field_71071_by;
        if(inventoryplayer.func_70445_o() != null)
        {
            GL11.glTranslatef(0.0F, 0.0F, 32F);
            field_73735_i = 200F;
            field_74196_a.field_77023_b = 200F;
            field_74196_a.func_77015_a(field_73886_k, field_73882_e.field_71446_o, inventoryplayer.func_70445_o(), p_73863_1_ - i - 8, p_73863_2_ - j - 8);
            field_74196_a.func_77021_b(field_73886_k, field_73882_e.field_71446_o, inventoryplayer.func_70445_o(), p_73863_1_ - i - 8, p_73863_2_ - j - 8);
            field_73735_i = 0.0F;
            field_74196_a.field_77023_b = 0.0F;
        }
        if(inventoryplayer.func_70445_o() == null && slot != null && slot.func_75216_d())
        {
            ItemStack itemstack = slot.func_75211_c();
            func_74184_a(itemstack, p_73863_1_ - i, p_73863_2_ - j);
        }
        GL11.glPopMatrix();
        GL11.glEnable(2896);
        GL11.glEnable(2929);
        RenderHelper.func_74519_b();
    }

    protected void func_74184_a(ItemStack p_74184_1_, int p_74184_2_, int p_74184_3_)
    {
        GL11.glDisable(32826);
        RenderHelper.func_74518_a();
        GL11.glDisable(2896);
        GL11.glDisable(2929);
        List list = p_74184_1_.func_77968_r();
        if(!list.isEmpty())
        {
            int i = 0;
            Iterator iterator = list.iterator();
            do
            {
                if(!iterator.hasNext())
                {
                    break;
                }
                String s = (String)iterator.next();
                int l = field_73886_k.func_78256_a(s);
                if(l > i)
                {
                    i = l;
                }
            } while(true);
            int j = p_74184_2_ + 12;
            int k = p_74184_3_ - 12;
            int i1 = i;
            int j1 = 8;
            if(list.size() > 1)
            {
                j1 += 2 + (list.size() - 1) * 10;
            }
            field_73735_i = 300F;
            field_74196_a.field_77023_b = 300F;
            int k1 = 0xf0100010;
            func_73733_a(j - 3, k - 4, j + i1 + 3, k - 3, k1, k1);
            func_73733_a(j - 3, k + j1 + 3, j + i1 + 3, k + j1 + 4, k1, k1);
            func_73733_a(j - 3, k - 3, j + i1 + 3, k + j1 + 3, k1, k1);
            func_73733_a(j - 4, k - 3, j - 3, k + j1 + 3, k1, k1);
            func_73733_a(j + i1 + 3, k - 3, j + i1 + 4, k + j1 + 3, k1, k1);
            int l1 = 0x505000ff;
            int i2 = (l1 & 0xfefefe) >> 1 | l1 & 0xff000000;
            func_73733_a(j - 3, (k - 3) + 1, (j - 3) + 1, (k + j1 + 3) - 1, l1, i2);
            func_73733_a(j + i1 + 2, (k - 3) + 1, j + i1 + 3, (k + j1 + 3) - 1, l1, i2);
            func_73733_a(j - 3, k - 3, j + i1 + 3, (k - 3) + 1, l1, l1);
            func_73733_a(j - 3, k + j1 + 2, j + i1 + 3, k + j1 + 3, i2, i2);
            for(int j2 = 0; j2 < list.size(); j2++)
            {
                String s1 = (String)list.get(j2);
                if(j2 == 0)
                {
                    s1 = (new StringBuilder()).append("\247").append(Integer.toHexString(p_74184_1_.func_77953_t().field_77937_e)).append(s1).toString();
                } else
                {
                    s1 = (new StringBuilder()).append("\2477").append(s1).toString();
                }
                field_73886_k.func_78261_a(s1, j, k, -1);
                if(j2 == 0)
                {
                    k += 2;
                }
                k += 10;
            }

            field_73735_i = 0.0F;
            field_74196_a.field_77023_b = 0.0F;
        }
    }

    protected void func_74190_a(String p_74190_1_, int p_74190_2_, int p_74190_3_)
    {
        GL11.glDisable(32826);
        RenderHelper.func_74518_a();
        GL11.glDisable(2896);
        GL11.glDisable(2929);
        int i = field_73886_k.func_78256_a(p_74190_1_);
        int j = p_74190_2_ + 12;
        int k = p_74190_3_ - 12;
        int l = i;
        byte byte0 = 8;
        field_73735_i = 300F;
        field_74196_a.field_77023_b = 300F;
        int i1 = 0xf0100010;
        func_73733_a(j - 3, k - 4, j + l + 3, k - 3, i1, i1);
        func_73733_a(j - 3, k + byte0 + 3, j + l + 3, k + byte0 + 4, i1, i1);
        func_73733_a(j - 3, k - 3, j + l + 3, k + byte0 + 3, i1, i1);
        func_73733_a(j - 4, k - 3, j - 3, k + byte0 + 3, i1, i1);
        func_73733_a(j + l + 3, k - 3, j + l + 4, k + byte0 + 3, i1, i1);
        int j1 = 0x505000ff;
        int k1 = (j1 & 0xfefefe) >> 1 | j1 & 0xff000000;
        func_73733_a(j - 3, (k - 3) + 1, (j - 3) + 1, (k + byte0 + 3) - 1, j1, k1);
        func_73733_a(j + l + 2, (k - 3) + 1, j + l + 3, (k + byte0 + 3) - 1, j1, k1);
        func_73733_a(j - 3, k - 3, j + l + 3, (k - 3) + 1, j1, j1);
        func_73733_a(j - 3, k + byte0 + 2, j + l + 3, k + byte0 + 3, k1, k1);
        field_73886_k.func_78261_a(p_74190_1_, j, k, -1);
        field_73735_i = 0.0F;
        field_74196_a.field_77023_b = 0.0F;
    }

    protected void func_74189_g()
    {
    }

    protected abstract void func_74185_a(float f, int i, int j);

    private void func_74192_a(Slot p_74192_1_)
    {
        int i = p_74192_1_.field_75223_e;
        int j = p_74192_1_.field_75221_f;
        ItemStack itemstack = p_74192_1_.func_75211_c();
        boolean flag = false;
        field_73735_i = 100F;
        field_74196_a.field_77023_b = 100F;
        if(itemstack == null)
        {
            int k = p_74192_1_.func_75212_b();
            if(k >= 0)
            {
                GL11.glDisable(2896);
                field_73882_e.field_71446_o.func_78342_b(field_73882_e.field_71446_o.func_78341_b("/gui/items.png"));
                func_73729_b(i, j, (k % 16) * 16, (k / 16) * 16, 16, 16);
                GL11.glEnable(2896);
                flag = true;
            }
        }
        if(!flag)
        {
            GL11.glEnable(2929);
            field_74196_a.func_77015_a(field_73886_k, field_73882_e.field_71446_o, itemstack, i, j);
            field_74196_a.func_77021_b(field_73886_k, field_73882_e.field_71446_o, itemstack, i, j);
        }
        field_74196_a.field_77023_b = 0.0F;
        field_73735_i = 0.0F;
    }

    private Slot func_74187_b(int p_74187_1_, int p_74187_2_)
    {
        for(int i = 0; i < field_74193_d.field_75151_b.size(); i++)
        {
            Slot slot = (Slot)field_74193_d.field_75151_b.get(i);
            if(func_74186_a(slot, p_74187_1_, p_74187_2_))
            {
                return slot;
            }
        }

        return null;
    }

    protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_)
    {
        super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
        if(p_73864_3_ == 0 || p_73864_3_ == 1)
        {
            Slot slot = func_74187_b(p_73864_1_, p_73864_2_);
            int i = field_74198_m;
            int j = field_74197_n;
            boolean flag = p_73864_1_ < i || p_73864_2_ < j || p_73864_1_ >= i + field_74194_b || p_73864_2_ >= j + field_74195_c;
            int k = -1;
            if(slot != null)
            {
                k = slot.field_75222_d;
            }
            if(flag)
            {
                k = -999;
            }
            if(k != -1)
            {
                boolean flag1 = k != -999 && (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54));
                func_74191_a(slot, k, p_73864_3_, flag1);
            }
        }
    }

    private boolean func_74186_a(Slot p_74186_1_, int p_74186_2_, int p_74186_3_)
    {
        return func_74188_c(p_74186_1_.field_75223_e, p_74186_1_.field_75221_f, 16, 16, p_74186_2_, p_74186_3_);
    }

    protected boolean func_74188_c(int p_74188_1_, int p_74188_2_, int p_74188_3_, int p_74188_4_, int p_74188_5_, int p_74188_6_)
    {
        int i = field_74198_m;
        int j = field_74197_n;
        p_74188_5_ -= i;
        p_74188_6_ -= j;
        return p_74188_5_ >= p_74188_1_ - 1 && p_74188_5_ < p_74188_1_ + p_74188_3_ + 1 && p_74188_6_ >= p_74188_2_ - 1 && p_74188_6_ < p_74188_2_ + p_74188_4_ + 1;
    }

    protected void func_74191_a(Slot p_74191_1_, int p_74191_2_, int p_74191_3_, boolean p_74191_4_)
    {
        if(p_74191_1_ != null)
        {
            p_74191_2_ = p_74191_1_.field_75222_d;
        }
        field_73882_e.field_71442_b.func_78753_a(field_74193_d.field_75152_c, p_74191_2_, p_74191_3_, p_74191_4_, field_73882_e.field_71439_g);
    }

    protected void func_73869_a(char p_73869_1_, int p_73869_2_)
    {
        if(p_73869_2_ == 1 || p_73869_2_ == field_73882_e.field_71474_y.field_74315_B.field_74512_d)
        {
            field_73882_e.field_71439_g.func_71053_j();
        }
    }

    public void func_73874_b()
    {
        if(field_73882_e.field_71439_g == null)
        {
            return;
        } else
        {
            field_74193_d.func_75134_a(field_73882_e.field_71439_g);
            return;
        }
    }

    public boolean func_73868_f()
    {
        return false;
    }

    public void func_73876_c()
    {
        super.func_73876_c();
        if(!field_73882_e.field_71439_g.func_70089_S() || field_73882_e.field_71439_g.field_70128_L)
        {
            field_73882_e.field_71439_g.func_71053_j();
        }
    }

}
