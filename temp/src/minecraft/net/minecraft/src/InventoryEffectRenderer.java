// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Collection;
import java.util.Iterator;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiContainer, EntityClientPlayerMP, RenderEngine, PotionEffect, 
//            Potion, StatCollector, FontRenderer, Container

public abstract class InventoryEffectRenderer extends GuiContainer
{

    private boolean field_74222_o;

    public InventoryEffectRenderer(Container p_i3084_1_)
    {
        super(p_i3084_1_);
    }

    public void func_73866_w_()
    {
        super.func_73866_w_();
        if(!field_73882_e.field_71439_g.func_70651_bq().isEmpty())
        {
            field_74198_m = 160 + (field_73880_f - field_74194_b - 200) / 2;
            field_74222_o = true;
        }
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
        if(field_74222_o)
        {
            func_74221_h();
        }
    }

    private void func_74221_h()
    {
        int i = field_74198_m - 124;
        int j = field_74197_n;
        Collection collection = field_73882_e.field_71439_g.func_70651_bq();
        if(collection.isEmpty())
        {
            return;
        }
        int k = field_73882_e.field_71446_o.func_78341_b("/gui/inventory.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(2896);
        int l = 33;
        if(collection.size() > 5)
        {
            l = 132 / (collection.size() - 1);
        }
        for(Iterator iterator = field_73882_e.field_71439_g.func_70651_bq().iterator(); iterator.hasNext();)
        {
            PotionEffect potioneffect = (PotionEffect)iterator.next();
            Potion potion = Potion.field_76425_a[potioneffect.func_76456_a()];
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            field_73882_e.field_71446_o.func_78342_b(k);
            func_73729_b(i, j, 0, 166, 140, 32);
            if(potion.func_76400_d())
            {
                int i1 = potion.func_76392_e();
                func_73729_b(i + 6, j + 7, 0 + (i1 % 8) * 18, 198 + (i1 / 8) * 18, 18, 18);
            }
            String s = StatCollector.func_74838_a(potion.func_76393_a());
            if(potioneffect.func_76458_c() == 1)
            {
                s = (new StringBuilder()).append(s).append(" II").toString();
            } else
            if(potioneffect.func_76458_c() == 2)
            {
                s = (new StringBuilder()).append(s).append(" III").toString();
            } else
            if(potioneffect.func_76458_c() == 3)
            {
                s = (new StringBuilder()).append(s).append(" IV").toString();
            }
            field_73886_k.func_78261_a(s, i + 10 + 18, j + 6, 0xffffff);
            String s1 = Potion.func_76389_a(potioneffect);
            field_73886_k.func_78261_a(s1, i + 10 + 18, j + 6 + 10, 0x7f7f7f);
            j += l;
        }

    }
}
