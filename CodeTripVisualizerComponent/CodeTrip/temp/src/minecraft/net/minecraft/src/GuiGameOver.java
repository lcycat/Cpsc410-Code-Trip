// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, WorldClient, WorldInfo, GuiButton, 
//            StatCollector, EntityClientPlayerMP, GuiMainMenu

public class GuiGameOver extends GuiScreen
{

    private int field_73995_a;

    public GuiGameOver()
    {
    }

    public void func_73866_w_()
    {
        field_73887_h.clear();
        if(field_73882_e.field_71441_e.func_72912_H().func_76093_s())
        {
            if(field_73882_e.func_71387_A())
            {
                field_73887_h.add(new GuiButton(1, field_73880_f / 2 - 100, field_73881_g / 4 + 96, StatCollector.func_74838_a("deathScreen.deleteWorld")));
            } else
            {
                field_73887_h.add(new GuiButton(1, field_73880_f / 2 - 100, field_73881_g / 4 + 96, StatCollector.func_74838_a("deathScreen.leaveServer")));
            }
        } else
        {
            field_73887_h.add(new GuiButton(1, field_73880_f / 2 - 100, field_73881_g / 4 + 72, StatCollector.func_74838_a("deathScreen.respawn")));
            field_73887_h.add(new GuiButton(2, field_73880_f / 2 - 100, field_73881_g / 4 + 96, StatCollector.func_74838_a("deathScreen.titleScreen")));
            if(field_73882_e.field_71449_j == null)
            {
                ((GuiButton)field_73887_h.get(1)).field_73742_g = false;
            }
        }
        for(Iterator iterator = field_73887_h.iterator(); iterator.hasNext();)
        {
            GuiButton guibutton = (GuiButton)iterator.next();
            guibutton.field_73742_g = false;
        }

    }

    protected void func_73869_a(char c, int i)
    {
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        switch(p_73875_1_.field_73741_f)
        {
        case 1: // '\001'
            field_73882_e.field_71439_g.func_71004_bE();
            field_73882_e.func_71373_a(null);
            break;

        case 2: // '\002'
            field_73882_e.field_71441_e.func_72882_A();
            field_73882_e.func_71403_a(null);
            field_73882_e.func_71373_a(new GuiMainMenu());
            break;
        }
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        func_73733_a(0, 0, field_73880_f, field_73881_g, 0x60500000, 0xa0803030);
        GL11.glPushMatrix();
        GL11.glScalef(2.0F, 2.0F, 2.0F);
        boolean flag = field_73882_e.field_71441_e.func_72912_H().func_76093_s();
        String s = flag ? StatCollector.func_74838_a("deathScreen.title.hardcore") : StatCollector.func_74838_a("deathScreen.title");
        func_73732_a(field_73886_k, s, field_73880_f / 2 / 2, 30, 0xffffff);
        GL11.glPopMatrix();
        if(flag)
        {
            func_73732_a(field_73886_k, StatCollector.func_74838_a("deathScreen.hardcoreInfo"), field_73880_f / 2, 144, 0xffffff);
        }
        func_73732_a(field_73886_k, (new StringBuilder()).append(StatCollector.func_74838_a("deathScreen.score")).append(": \247e").append(field_73882_e.field_71439_g.func_71037_bA()).toString(), field_73880_f / 2, 100, 0xffffff);
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
    }

    public boolean func_73868_f()
    {
        return false;
    }

    public void func_73876_c()
    {
        super.func_73876_c();
        field_73995_a++;
        if(field_73995_a == 20)
        {
            for(Iterator iterator = field_73887_h.iterator(); iterator.hasNext();)
            {
                GuiButton guibutton = (GuiButton)iterator.next();
                guibutton.field_73742_g = true;
            }

        }
    }
}
