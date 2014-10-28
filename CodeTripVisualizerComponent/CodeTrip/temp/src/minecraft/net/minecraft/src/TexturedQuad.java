// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            PositionTextureVertex, Vec3, Tessellator

public class TexturedQuad
{

    public PositionTextureVertex field_78239_a[];
    public int field_78237_b;
    private boolean field_78238_c;

    public TexturedQuad(PositionTextureVertex p_i3136_1_[])
    {
        field_78237_b = 0;
        field_78238_c = false;
        field_78239_a = p_i3136_1_;
        field_78237_b = p_i3136_1_.length;
    }

    public TexturedQuad(PositionTextureVertex p_i3137_1_[], int p_i3137_2_, int p_i3137_3_, int p_i3137_4_, int p_i3137_5_, float p_i3137_6_, float p_i3137_7_)
    {
        this(p_i3137_1_);
        float f = 0.0F / p_i3137_6_;
        float f1 = 0.0F / p_i3137_7_;
        p_i3137_1_[0] = p_i3137_1_[0].func_78240_a((float)p_i3137_4_ / p_i3137_6_ - f, (float)p_i3137_3_ / p_i3137_7_ + f1);
        p_i3137_1_[1] = p_i3137_1_[1].func_78240_a((float)p_i3137_2_ / p_i3137_6_ + f, (float)p_i3137_3_ / p_i3137_7_ + f1);
        p_i3137_1_[2] = p_i3137_1_[2].func_78240_a((float)p_i3137_2_ / p_i3137_6_ + f, (float)p_i3137_5_ / p_i3137_7_ - f1);
        p_i3137_1_[3] = p_i3137_1_[3].func_78240_a((float)p_i3137_4_ / p_i3137_6_ - f, (float)p_i3137_5_ / p_i3137_7_ - f1);
    }

    public void func_78235_a()
    {
        PositionTextureVertex apositiontexturevertex[] = new PositionTextureVertex[field_78239_a.length];
        for(int i = 0; i < field_78239_a.length; i++)
        {
            apositiontexturevertex[i] = field_78239_a[field_78239_a.length - i - 1];
        }

        field_78239_a = apositiontexturevertex;
    }

    public void func_78236_a(Tessellator p_78236_1_, float p_78236_2_)
    {
        Vec3 vec3 = field_78239_a[1].field_78243_a.func_72444_a(field_78239_a[0].field_78243_a);
        Vec3 vec3_1 = field_78239_a[1].field_78243_a.func_72444_a(field_78239_a[2].field_78243_a);
        Vec3 vec3_2 = vec3_1.func_72431_c(vec3).func_72432_b();
        p_78236_1_.func_78382_b();
        if(field_78238_c)
        {
            p_78236_1_.func_78375_b(-(float)vec3_2.field_72450_a, -(float)vec3_2.field_72448_b, -(float)vec3_2.field_72449_c);
        } else
        {
            p_78236_1_.func_78375_b((float)vec3_2.field_72450_a, (float)vec3_2.field_72448_b, (float)vec3_2.field_72449_c);
        }
        for(int i = 0; i < 4; i++)
        {
            PositionTextureVertex positiontexturevertex = field_78239_a[i];
            p_78236_1_.func_78374_a((float)positiontexturevertex.field_78243_a.field_72450_a * p_78236_2_, (float)positiontexturevertex.field_78243_a.field_72448_b * p_78236_2_, (float)positiontexturevertex.field_78243_a.field_72449_c * p_78236_2_, positiontexturevertex.field_78241_b, positiontexturevertex.field_78242_c);
        }

        p_78236_1_.func_78381_a();
    }
}
