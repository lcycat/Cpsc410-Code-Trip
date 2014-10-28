// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            ModelBase, TextureOffset, ModelBox, GLAllocation, 
//            Tessellator

public class ModelRenderer
{

    public float field_78801_a;
    public float field_78799_b;
    private int field_78803_o;
    private int field_78813_p;
    public float field_78800_c;
    public float field_78797_d;
    public float field_78798_e;
    public float field_78795_f;
    public float field_78796_g;
    public float field_78808_h;
    private boolean field_78812_q;
    private int field_78811_r;
    public boolean field_78809_i;
    public boolean field_78806_j;
    public boolean field_78807_k;
    public List field_78804_l;
    public List field_78805_m;
    public final String field_78802_n;
    private ModelBase field_78810_s;

    public ModelRenderer(ModelBase p_i3147_1_, String p_i3147_2_)
    {
        field_78801_a = 64F;
        field_78799_b = 32F;
        field_78812_q = false;
        field_78811_r = 0;
        field_78809_i = false;
        field_78806_j = true;
        field_78807_k = false;
        field_78804_l = new ArrayList();
        field_78810_s = p_i3147_1_;
        p_i3147_1_.field_78092_r.add(this);
        field_78802_n = p_i3147_2_;
        func_78787_b(p_i3147_1_.field_78090_t, p_i3147_1_.field_78089_u);
    }

    public ModelRenderer(ModelBase p_i3148_1_)
    {
        this(p_i3148_1_, null);
    }

    public ModelRenderer(ModelBase p_i3149_1_, int p_i3149_2_, int p_i3149_3_)
    {
        this(p_i3149_1_);
        func_78784_a(p_i3149_2_, p_i3149_3_);
    }

    public void func_78792_a(ModelRenderer p_78792_1_)
    {
        if(field_78805_m == null)
        {
            field_78805_m = new ArrayList();
        }
        field_78805_m.add(p_78792_1_);
    }

    public ModelRenderer func_78784_a(int p_78784_1_, int p_78784_2_)
    {
        field_78803_o = p_78784_1_;
        field_78813_p = p_78784_2_;
        return this;
    }

    public ModelRenderer func_78786_a(String p_78786_1_, float p_78786_2_, float p_78786_3_, float p_78786_4_, int p_78786_5_, int p_78786_6_, int p_78786_7_)
    {
        p_78786_1_ = (new StringBuilder()).append(field_78802_n).append(".").append(p_78786_1_).toString();
        TextureOffset textureoffset = field_78810_s.func_78084_a(p_78786_1_);
        func_78784_a(textureoffset.field_78783_a, textureoffset.field_78782_b);
        field_78804_l.add((new ModelBox(this, field_78803_o, field_78813_p, p_78786_2_, p_78786_3_, p_78786_4_, p_78786_5_, p_78786_6_, p_78786_7_, 0.0F)).func_78244_a(p_78786_1_));
        return this;
    }

    public ModelRenderer func_78789_a(float p_78789_1_, float p_78789_2_, float p_78789_3_, int p_78789_4_, int p_78789_5_, int p_78789_6_)
    {
        field_78804_l.add(new ModelBox(this, field_78803_o, field_78813_p, p_78789_1_, p_78789_2_, p_78789_3_, p_78789_4_, p_78789_5_, p_78789_6_, 0.0F));
        return this;
    }

    public void func_78790_a(float p_78790_1_, float p_78790_2_, float p_78790_3_, int p_78790_4_, int p_78790_5_, int p_78790_6_, float p_78790_7_)
    {
        field_78804_l.add(new ModelBox(this, field_78803_o, field_78813_p, p_78790_1_, p_78790_2_, p_78790_3_, p_78790_4_, p_78790_5_, p_78790_6_, p_78790_7_));
    }

    public void func_78793_a(float p_78793_1_, float p_78793_2_, float p_78793_3_)
    {
        field_78800_c = p_78793_1_;
        field_78797_d = p_78793_2_;
        field_78798_e = p_78793_3_;
    }

    public void func_78785_a(float p_78785_1_)
    {
        if(field_78807_k)
        {
            return;
        }
        if(!field_78806_j)
        {
            return;
        }
        if(!field_78812_q)
        {
            func_78788_d(p_78785_1_);
        }
        if(field_78795_f != 0.0F || field_78796_g != 0.0F || field_78808_h != 0.0F)
        {
            GL11.glPushMatrix();
            GL11.glTranslatef(field_78800_c * p_78785_1_, field_78797_d * p_78785_1_, field_78798_e * p_78785_1_);
            if(field_78808_h != 0.0F)
            {
                GL11.glRotatef(field_78808_h * 57.29578F, 0.0F, 0.0F, 1.0F);
            }
            if(field_78796_g != 0.0F)
            {
                GL11.glRotatef(field_78796_g * 57.29578F, 0.0F, 1.0F, 0.0F);
            }
            if(field_78795_f != 0.0F)
            {
                GL11.glRotatef(field_78795_f * 57.29578F, 1.0F, 0.0F, 0.0F);
            }
            GL11.glCallList(field_78811_r);
            if(field_78805_m != null)
            {
                ModelRenderer modelrenderer;
                for(Iterator iterator = field_78805_m.iterator(); iterator.hasNext(); modelrenderer.func_78785_a(p_78785_1_))
                {
                    modelrenderer = (ModelRenderer)iterator.next();
                }

            }
            GL11.glPopMatrix();
        } else
        if(field_78800_c != 0.0F || field_78797_d != 0.0F || field_78798_e != 0.0F)
        {
            GL11.glTranslatef(field_78800_c * p_78785_1_, field_78797_d * p_78785_1_, field_78798_e * p_78785_1_);
            GL11.glCallList(field_78811_r);
            if(field_78805_m != null)
            {
                ModelRenderer modelrenderer1;
                for(Iterator iterator1 = field_78805_m.iterator(); iterator1.hasNext(); modelrenderer1.func_78785_a(p_78785_1_))
                {
                    modelrenderer1 = (ModelRenderer)iterator1.next();
                }

            }
            GL11.glTranslatef(-field_78800_c * p_78785_1_, -field_78797_d * p_78785_1_, -field_78798_e * p_78785_1_);
        } else
        {
            GL11.glCallList(field_78811_r);
            if(field_78805_m != null)
            {
                ModelRenderer modelrenderer2;
                for(Iterator iterator2 = field_78805_m.iterator(); iterator2.hasNext(); modelrenderer2.func_78785_a(p_78785_1_))
                {
                    modelrenderer2 = (ModelRenderer)iterator2.next();
                }

            }
        }
    }

    public void func_78791_b(float p_78791_1_)
    {
        if(field_78807_k)
        {
            return;
        }
        if(!field_78806_j)
        {
            return;
        }
        if(!field_78812_q)
        {
            func_78788_d(p_78791_1_);
        }
        GL11.glPushMatrix();
        GL11.glTranslatef(field_78800_c * p_78791_1_, field_78797_d * p_78791_1_, field_78798_e * p_78791_1_);
        if(field_78796_g != 0.0F)
        {
            GL11.glRotatef(field_78796_g * 57.29578F, 0.0F, 1.0F, 0.0F);
        }
        if(field_78795_f != 0.0F)
        {
            GL11.glRotatef(field_78795_f * 57.29578F, 1.0F, 0.0F, 0.0F);
        }
        if(field_78808_h != 0.0F)
        {
            GL11.glRotatef(field_78808_h * 57.29578F, 0.0F, 0.0F, 1.0F);
        }
        GL11.glCallList(field_78811_r);
        GL11.glPopMatrix();
    }

    public void func_78794_c(float p_78794_1_)
    {
        if(field_78807_k)
        {
            return;
        }
        if(!field_78806_j)
        {
            return;
        }
        if(!field_78812_q)
        {
            func_78788_d(p_78794_1_);
        }
        if(field_78795_f != 0.0F || field_78796_g != 0.0F || field_78808_h != 0.0F)
        {
            GL11.glTranslatef(field_78800_c * p_78794_1_, field_78797_d * p_78794_1_, field_78798_e * p_78794_1_);
            if(field_78808_h != 0.0F)
            {
                GL11.glRotatef(field_78808_h * 57.29578F, 0.0F, 0.0F, 1.0F);
            }
            if(field_78796_g != 0.0F)
            {
                GL11.glRotatef(field_78796_g * 57.29578F, 0.0F, 1.0F, 0.0F);
            }
            if(field_78795_f != 0.0F)
            {
                GL11.glRotatef(field_78795_f * 57.29578F, 1.0F, 0.0F, 0.0F);
            }
        } else
        if(field_78800_c != 0.0F || field_78797_d != 0.0F || field_78798_e != 0.0F)
        {
            GL11.glTranslatef(field_78800_c * p_78794_1_, field_78797_d * p_78794_1_, field_78798_e * p_78794_1_);
        }
    }

    private void func_78788_d(float p_78788_1_)
    {
        field_78811_r = GLAllocation.func_74526_a(1);
        GL11.glNewList(field_78811_r, 4864);
        Tessellator tessellator = Tessellator.field_78398_a;
        ModelBox modelbox;
        for(Iterator iterator = field_78804_l.iterator(); iterator.hasNext(); modelbox.func_78245_a(tessellator, p_78788_1_))
        {
            modelbox = (ModelBox)iterator.next();
        }

        GL11.glEndList();
        field_78812_q = true;
    }

    public ModelRenderer func_78787_b(int p_78787_1_, int p_78787_2_)
    {
        field_78801_a = p_78787_1_;
        field_78799_b = p_78787_2_;
        return this;
    }
}
