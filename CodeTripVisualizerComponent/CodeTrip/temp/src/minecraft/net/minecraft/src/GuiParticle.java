// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Gui, Particle, RenderEngine

public class GuiParticle extends Gui
{

    private List field_73776_a;
    private Minecraft field_73775_b;

    public GuiParticle(Minecraft p_i3095_1_)
    {
        field_73776_a = new ArrayList();
        field_73775_b = p_i3095_1_;
    }

    public void func_73774_a()
    {
        for(int i = 0; i < field_73776_a.size(); i++)
        {
            Particle particle = (Particle)field_73776_a.get(i);
            particle.func_78062_a();
            particle.func_78063_a(this);
            if(particle.field_78078_h)
            {
                field_73776_a.remove(i--);
            }
        }

    }

    public void func_73773_a(float p_73773_1_)
    {
        field_73775_b.field_71446_o.func_78342_b(field_73775_b.field_71446_o.func_78341_b("/gui/particles.png"));
        int i;
        int j;
        for(Iterator iterator = field_73776_a.iterator(); iterator.hasNext(); func_73729_b(i, j, 40, 0, 8, 8))
        {
            Particle particle = (Particle)iterator.next();
            i = (int)((particle.field_78070_c + (particle.field_78071_a - particle.field_78070_c) * (double)p_73773_1_) - 4D);
            j = (int)((particle.field_78067_d + (particle.field_78069_b - particle.field_78067_d) * (double)p_73773_1_) - 4D);
            float f = (float)(particle.field_78081_r + (particle.field_78072_n - particle.field_78081_r) * (double)p_73773_1_);
            float f1 = (float)(particle.field_78073_o + (particle.field_78077_k - particle.field_78073_o) * (double)p_73773_1_);
            float f2 = (float)(particle.field_78083_p + (particle.field_78074_l - particle.field_78083_p) * (double)p_73773_1_);
            float f3 = (float)(particle.field_78082_q + (particle.field_78075_m - particle.field_78082_q) * (double)p_73773_1_);
            GL11.glColor4f(f1, f2, f3, f);
        }

    }
}
