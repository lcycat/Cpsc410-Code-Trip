// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            PositionTextureVertex, TexturedQuad, ModelRenderer, Tessellator

public class ModelBox
{

    private PositionTextureVertex field_78253_h[];
    private TexturedQuad field_78254_i[];
    public final float field_78252_a;
    public final float field_78250_b;
    public final float field_78251_c;
    public final float field_78248_d;
    public final float field_78249_e;
    public final float field_78246_f;
    public String field_78247_g;

    public ModelBox(ModelRenderer p_i3145_1_, int p_i3145_2_, int p_i3145_3_, float p_i3145_4_, float p_i3145_5_, float p_i3145_6_, int p_i3145_7_, 
            int p_i3145_8_, int p_i3145_9_, float p_i3145_10_)
    {
        field_78252_a = p_i3145_4_;
        field_78250_b = p_i3145_5_;
        field_78251_c = p_i3145_6_;
        field_78248_d = p_i3145_4_ + (float)p_i3145_7_;
        field_78249_e = p_i3145_5_ + (float)p_i3145_8_;
        field_78246_f = p_i3145_6_ + (float)p_i3145_9_;
        field_78253_h = new PositionTextureVertex[8];
        field_78254_i = new TexturedQuad[6];
        float f = p_i3145_4_ + (float)p_i3145_7_;
        float f1 = p_i3145_5_ + (float)p_i3145_8_;
        float f2 = p_i3145_6_ + (float)p_i3145_9_;
        p_i3145_4_ -= p_i3145_10_;
        p_i3145_5_ -= p_i3145_10_;
        p_i3145_6_ -= p_i3145_10_;
        f += p_i3145_10_;
        f1 += p_i3145_10_;
        f2 += p_i3145_10_;
        if(p_i3145_1_.field_78809_i)
        {
            float f3 = f;
            f = p_i3145_4_;
            p_i3145_4_ = f3;
        }
        PositionTextureVertex positiontexturevertex = new PositionTextureVertex(p_i3145_4_, p_i3145_5_, p_i3145_6_, 0.0F, 0.0F);
        PositionTextureVertex positiontexturevertex1 = new PositionTextureVertex(f, p_i3145_5_, p_i3145_6_, 0.0F, 8F);
        PositionTextureVertex positiontexturevertex2 = new PositionTextureVertex(f, f1, p_i3145_6_, 8F, 8F);
        PositionTextureVertex positiontexturevertex3 = new PositionTextureVertex(p_i3145_4_, f1, p_i3145_6_, 8F, 0.0F);
        PositionTextureVertex positiontexturevertex4 = new PositionTextureVertex(p_i3145_4_, p_i3145_5_, f2, 0.0F, 0.0F);
        PositionTextureVertex positiontexturevertex5 = new PositionTextureVertex(f, p_i3145_5_, f2, 0.0F, 8F);
        PositionTextureVertex positiontexturevertex6 = new PositionTextureVertex(f, f1, f2, 8F, 8F);
        PositionTextureVertex positiontexturevertex7 = new PositionTextureVertex(p_i3145_4_, f1, f2, 8F, 0.0F);
        field_78253_h[0] = positiontexturevertex;
        field_78253_h[1] = positiontexturevertex1;
        field_78253_h[2] = positiontexturevertex2;
        field_78253_h[3] = positiontexturevertex3;
        field_78253_h[4] = positiontexturevertex4;
        field_78253_h[5] = positiontexturevertex5;
        field_78253_h[6] = positiontexturevertex6;
        field_78253_h[7] = positiontexturevertex7;
        field_78254_i[0] = new TexturedQuad(new PositionTextureVertex[] {
            positiontexturevertex5, positiontexturevertex1, positiontexturevertex2, positiontexturevertex6
        }, p_i3145_2_ + p_i3145_9_ + p_i3145_7_, p_i3145_3_ + p_i3145_9_, p_i3145_2_ + p_i3145_9_ + p_i3145_7_ + p_i3145_9_, p_i3145_3_ + p_i3145_9_ + p_i3145_8_, p_i3145_1_.field_78801_a, p_i3145_1_.field_78799_b);
        field_78254_i[1] = new TexturedQuad(new PositionTextureVertex[] {
            positiontexturevertex, positiontexturevertex4, positiontexturevertex7, positiontexturevertex3
        }, p_i3145_2_, p_i3145_3_ + p_i3145_9_, p_i3145_2_ + p_i3145_9_, p_i3145_3_ + p_i3145_9_ + p_i3145_8_, p_i3145_1_.field_78801_a, p_i3145_1_.field_78799_b);
        field_78254_i[2] = new TexturedQuad(new PositionTextureVertex[] {
            positiontexturevertex5, positiontexturevertex4, positiontexturevertex, positiontexturevertex1
        }, p_i3145_2_ + p_i3145_9_, p_i3145_3_, p_i3145_2_ + p_i3145_9_ + p_i3145_7_, p_i3145_3_ + p_i3145_9_, p_i3145_1_.field_78801_a, p_i3145_1_.field_78799_b);
        field_78254_i[3] = new TexturedQuad(new PositionTextureVertex[] {
            positiontexturevertex2, positiontexturevertex3, positiontexturevertex7, positiontexturevertex6
        }, p_i3145_2_ + p_i3145_9_ + p_i3145_7_, p_i3145_3_ + p_i3145_9_, p_i3145_2_ + p_i3145_9_ + p_i3145_7_ + p_i3145_7_, p_i3145_3_, p_i3145_1_.field_78801_a, p_i3145_1_.field_78799_b);
        field_78254_i[4] = new TexturedQuad(new PositionTextureVertex[] {
            positiontexturevertex1, positiontexturevertex, positiontexturevertex3, positiontexturevertex2
        }, p_i3145_2_ + p_i3145_9_, p_i3145_3_ + p_i3145_9_, p_i3145_2_ + p_i3145_9_ + p_i3145_7_, p_i3145_3_ + p_i3145_9_ + p_i3145_8_, p_i3145_1_.field_78801_a, p_i3145_1_.field_78799_b);
        field_78254_i[5] = new TexturedQuad(new PositionTextureVertex[] {
            positiontexturevertex4, positiontexturevertex5, positiontexturevertex6, positiontexturevertex7
        }, p_i3145_2_ + p_i3145_9_ + p_i3145_7_ + p_i3145_9_, p_i3145_3_ + p_i3145_9_, p_i3145_2_ + p_i3145_9_ + p_i3145_7_ + p_i3145_9_ + p_i3145_7_, p_i3145_3_ + p_i3145_9_ + p_i3145_8_, p_i3145_1_.field_78801_a, p_i3145_1_.field_78799_b);
        if(p_i3145_1_.field_78809_i)
        {
            TexturedQuad atexturedquad[] = field_78254_i;
            int i = atexturedquad.length;
            for(int j = 0; j < i; j++)
            {
                TexturedQuad texturedquad = atexturedquad[j];
                texturedquad.func_78235_a();
            }

        }
    }

    public void func_78245_a(Tessellator p_78245_1_, float p_78245_2_)
    {
        TexturedQuad atexturedquad[] = field_78254_i;
        int i = atexturedquad.length;
        for(int j = 0; j < i; j++)
        {
            TexturedQuad texturedquad = atexturedquad[j];
            texturedquad.func_78236_a(p_78245_1_, p_78245_2_);
        }

    }

    public ModelBox func_78244_a(String p_78244_1_)
    {
        field_78247_g = p_78244_1_;
        return this;
    }
}
