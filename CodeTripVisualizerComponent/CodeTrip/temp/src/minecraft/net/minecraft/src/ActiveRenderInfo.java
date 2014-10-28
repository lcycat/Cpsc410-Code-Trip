// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

// Referenced classes of package net.minecraft.src:
//            EntityPlayer, MathHelper, EntityLiving, Vec3, 
//            Vec3Pool, ChunkPosition, World, Block, 
//            Material, BlockFluid, GLAllocation

public class ActiveRenderInfo
{

    public static float field_74592_a = 0.0F;
    public static float field_74590_b = 0.0F;
    public static float field_74591_c = 0.0F;
    private static IntBuffer field_74597_i = GLAllocation.func_74527_f(16);
    private static FloatBuffer field_74594_j = GLAllocation.func_74529_h(16);
    private static FloatBuffer field_74595_k = GLAllocation.func_74529_h(16);
    private static FloatBuffer field_74593_l = GLAllocation.func_74529_h(3);
    public static float field_74588_d;
    public static float field_74589_e;
    public static float field_74586_f;
    public static float field_74587_g;
    public static float field_74596_h;

    public static void func_74583_a(EntityPlayer p_74583_0_, boolean p_74583_1_)
    {
        GL11.glGetFloat(2982, field_74594_j);
        GL11.glGetFloat(2983, field_74595_k);
        GL11.glGetInteger(2978, field_74597_i);
        float f = (field_74597_i.get(0) + field_74597_i.get(2)) / 2;
        float f1 = (field_74597_i.get(1) + field_74597_i.get(3)) / 2;
        GLU.gluUnProject(f, f1, 0.0F, field_74594_j, field_74595_k, field_74597_i, field_74593_l);
        field_74592_a = field_74593_l.get(0);
        field_74590_b = field_74593_l.get(1);
        field_74591_c = field_74593_l.get(2);
        int i = p_74583_1_ ? 1 : 0;
        float f2 = p_74583_0_.field_70125_A;
        float f3 = p_74583_0_.field_70177_z;
        field_74588_d = MathHelper.func_76134_b((f3 * 3.141593F) / 180F) * (float)(1 - i * 2);
        field_74586_f = MathHelper.func_76126_a((f3 * 3.141593F) / 180F) * (float)(1 - i * 2);
        field_74587_g = -field_74586_f * MathHelper.func_76126_a((f2 * 3.141593F) / 180F) * (float)(1 - i * 2);
        field_74596_h = field_74588_d * MathHelper.func_76126_a((f2 * 3.141593F) / 180F) * (float)(1 - i * 2);
        field_74589_e = MathHelper.func_76134_b((f2 * 3.141593F) / 180F);
    }

    public static Vec3 func_74585_b(EntityLiving p_74585_0_, double p_74585_1_)
    {
        double d = p_74585_0_.field_70169_q + (p_74585_0_.field_70165_t - p_74585_0_.field_70169_q) * p_74585_1_;
        double d1 = p_74585_0_.field_70167_r + (p_74585_0_.field_70163_u - p_74585_0_.field_70167_r) * p_74585_1_ + (double)p_74585_0_.func_70047_e();
        double d2 = p_74585_0_.field_70166_s + (p_74585_0_.field_70161_v - p_74585_0_.field_70166_s) * p_74585_1_;
        double d3 = d + (double)(field_74592_a * 1.0F);
        double d4 = d1 + (double)(field_74590_b * 1.0F);
        double d5 = d2 + (double)(field_74591_c * 1.0F);
        return Vec3.func_72437_a().func_72345_a(d3, d4, d5);
    }

    public static int func_74584_a(World p_74584_0_, EntityLiving p_74584_1_, float p_74584_2_)
    {
        Vec3 vec3 = func_74585_b(p_74584_1_, p_74584_2_);
        ChunkPosition chunkposition = new ChunkPosition(vec3);
        int i = p_74584_0_.func_72798_a(chunkposition.field_76930_a, chunkposition.field_76928_b, chunkposition.field_76929_c);
        if(i != 0 && Block.field_71973_m[i].field_72018_cp.func_76224_d())
        {
            float f = BlockFluid.func_72199_d(p_74584_0_.func_72805_g(chunkposition.field_76930_a, chunkposition.field_76928_b, chunkposition.field_76929_c)) - 0.1111111F;
            float f1 = (float)(chunkposition.field_76928_b + 1) - f;
            if(vec3.field_72448_b >= (double)f1)
            {
                i = p_74584_0_.func_72798_a(chunkposition.field_76930_a, chunkposition.field_76928_b + 1, chunkposition.field_76929_c);
            }
        }
        return i;
    }

}
