// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiContainer, ContainerMerchant, GuiButtonMerchant, StatCollector, 
//            FontRenderer, IMerchant, MerchantRecipeList, Packet250CustomPayload, 
//            NetClientHandler, RenderEngine, MerchantRecipe, RenderHelper, 
//            RenderItem, InventoryPlayer, World, GuiButton

public class GuiMerchant extends GuiContainer
{

    private IMerchant field_74203_o;
    private GuiButtonMerchant field_74202_p;
    private GuiButtonMerchant field_74201_q;
    private int field_74200_r;

    public GuiMerchant(InventoryPlayer p_i3093_1_, IMerchant p_i3093_2_, World p_i3093_3_)
    {
        super(new ContainerMerchant(p_i3093_1_, p_i3093_2_, p_i3093_3_));
        field_74200_r = 0;
        field_74203_o = p_i3093_2_;
    }

    public void func_73866_w_()
    {
        super.func_73866_w_();
        int i = (field_73880_f - field_74194_b) / 2;
        int j = (field_73881_g - field_74195_c) / 2;
        field_73887_h.add(field_74202_p = new GuiButtonMerchant(1, i + 120 + 27, (j + 24) - 1, true));
        field_73887_h.add(field_74201_q = new GuiButtonMerchant(2, (i + 36) - 19, (j + 24) - 1, false));
        field_74202_p.field_73742_g = false;
        field_74201_q.field_73742_g = false;
    }

    protected void func_74189_g()
    {
        field_73886_k.func_78276_b(StatCollector.func_74838_a("entity.Villager.name"), 56, 6, 0x404040);
        field_73886_k.func_78276_b(StatCollector.func_74838_a("container.inventory"), 8, (field_74195_c - 96) + 2, 0x404040);
    }

    public void func_73876_c()
    {
        super.func_73876_c();
        MerchantRecipeList merchantrecipelist = field_74203_o.func_70934_b(field_73882_e.field_71439_g);
        if(merchantrecipelist != null)
        {
            field_74202_p.field_73742_g = field_74200_r < merchantrecipelist.size() - 1;
            field_74201_q.field_73742_g = field_74200_r > 0;
        }
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        boolean flag = false;
        if(p_73875_1_ == field_74202_p)
        {
            field_74200_r++;
            flag = true;
        } else
        if(p_73875_1_ == field_74201_q)
        {
            field_74200_r--;
            flag = true;
        }
        if(flag)
        {
            ((ContainerMerchant)field_74193_d).func_75175_c(field_74200_r);
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);
            try
            {
                dataoutputstream.writeInt(field_74200_r);
                field_73882_e.func_71391_r().func_72552_c(new Packet250CustomPayload("MC|TrSel", bytearrayoutputstream.toByteArray()));
            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }
    }

    protected void func_74185_a(float p_74185_1_, int p_74185_2_, int p_74185_3_)
    {
        int i = field_73882_e.field_71446_o.func_78341_b("/gui/trading.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        field_73882_e.field_71446_o.func_78342_b(i);
        int j = (field_73880_f - field_74194_b) / 2;
        int k = (field_73881_g - field_74195_c) / 2;
        func_73729_b(j, k, 0, 0, field_74194_b, field_74195_c);
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
        MerchantRecipeList merchantrecipelist = field_74203_o.func_70934_b(field_73882_e.field_71439_g);
        if(merchantrecipelist != null && !merchantrecipelist.isEmpty())
        {
            int i = (field_73880_f - field_74194_b) / 2;
            int j = (field_73881_g - field_74195_c) / 2;
            GL11.glPushMatrix();
            int k = field_74200_r;
            MerchantRecipe merchantrecipe = (MerchantRecipe)merchantrecipelist.get(k);
            ItemStack itemstack = merchantrecipe.func_77394_a();
            ItemStack itemstack1 = merchantrecipe.func_77396_b();
            ItemStack itemstack2 = merchantrecipe.func_77397_d();
            RenderHelper.func_74520_c();
            GL11.glDisable(2896);
            GL11.glEnable(32826);
            GL11.glEnable(2903);
            GL11.glEnable(2896);
            field_74196_a.field_77023_b = 100F;
            field_74196_a.func_77015_a(field_73886_k, field_73882_e.field_71446_o, itemstack, i + 36, j + 24);
            field_74196_a.func_77021_b(field_73886_k, field_73882_e.field_71446_o, itemstack, i + 36, j + 24);
            if(itemstack1 != null)
            {
                field_74196_a.func_77015_a(field_73886_k, field_73882_e.field_71446_o, itemstack1, i + 62, j + 24);
                field_74196_a.func_77021_b(field_73886_k, field_73882_e.field_71446_o, itemstack1, i + 62, j + 24);
            }
            field_74196_a.func_77015_a(field_73886_k, field_73882_e.field_71446_o, itemstack2, i + 120, j + 24);
            field_74196_a.func_77021_b(field_73886_k, field_73882_e.field_71446_o, itemstack2, i + 120, j + 24);
            field_74196_a.field_77023_b = 0.0F;
            GL11.glDisable(2896);
            if(func_74188_c(36, 24, 16, 16, p_73863_1_, p_73863_2_))
            {
                func_74184_a(itemstack, p_73863_1_, p_73863_2_);
            } else
            if(itemstack1 != null && func_74188_c(62, 24, 16, 16, p_73863_1_, p_73863_2_))
            {
                func_74184_a(itemstack1, p_73863_1_, p_73863_2_);
            } else
            if(func_74188_c(120, 24, 16, 16, p_73863_1_, p_73863_2_))
            {
                func_74184_a(itemstack2, p_73863_1_, p_73863_2_);
            }
            GL11.glPopMatrix();
            GL11.glEnable(2896);
            GL11.glEnable(2929);
            RenderHelper.func_74519_b();
        }
    }

    public IMerchant func_74199_h()
    {
        return field_74203_o;
    }
}
