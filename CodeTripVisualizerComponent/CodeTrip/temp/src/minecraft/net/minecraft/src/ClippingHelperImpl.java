// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.nio.Buffer;
import java.nio.FloatBuffer;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            ClippingHelper, GLAllocation, MathHelper

public class ClippingHelperImpl extends ClippingHelper
{

    private static ClippingHelperImpl field_78563_e = new ClippingHelperImpl();
    private FloatBuffer field_78561_f;
    private FloatBuffer field_78562_g;
    private FloatBuffer field_78564_h;

    public ClippingHelperImpl()
    {
        field_78561_f = GLAllocation.func_74529_h(16);
        field_78562_g = GLAllocation.func_74529_h(16);
        field_78564_h = GLAllocation.func_74529_h(16);
    }

    public static ClippingHelper func_78558_a()
    {
        field_78563_e.func_78560_b();
        return field_78563_e;
    }

    private void func_78559_a(float p_78559_1_[][], int p_78559_2_)
    {
        float f = MathHelper.func_76129_c(p_78559_1_[p_78559_2_][0] * p_78559_1_[p_78559_2_][0] + p_78559_1_[p_78559_2_][1] * p_78559_1_[p_78559_2_][1] + p_78559_1_[p_78559_2_][2] * p_78559_1_[p_78559_2_][2]);
        p_78559_1_[p_78559_2_][0] /= f;
        p_78559_1_[p_78559_2_][1] /= f;
        p_78559_1_[p_78559_2_][2] /= f;
        p_78559_1_[p_78559_2_][3] /= f;
    }

    private void func_78560_b()
    {
        field_78561_f.clear();
        field_78562_g.clear();
        field_78564_h.clear();
        GL11.glGetFloat(2983, field_78561_f);
        GL11.glGetFloat(2982, field_78562_g);
        field_78561_f.flip().limit(16);
        field_78561_f.get(field_78555_b);
        field_78562_g.flip().limit(16);
        field_78562_g.get(field_78556_c);
        field_78554_d[0] = field_78556_c[0] * field_78555_b[0] + field_78556_c[1] * field_78555_b[4] + field_78556_c[2] * field_78555_b[8] + field_78556_c[3] * field_78555_b[12];
        field_78554_d[1] = field_78556_c[0] * field_78555_b[1] + field_78556_c[1] * field_78555_b[5] + field_78556_c[2] * field_78555_b[9] + field_78556_c[3] * field_78555_b[13];
        field_78554_d[2] = field_78556_c[0] * field_78555_b[2] + field_78556_c[1] * field_78555_b[6] + field_78556_c[2] * field_78555_b[10] + field_78556_c[3] * field_78555_b[14];
        field_78554_d[3] = field_78556_c[0] * field_78555_b[3] + field_78556_c[1] * field_78555_b[7] + field_78556_c[2] * field_78555_b[11] + field_78556_c[3] * field_78555_b[15];
        field_78554_d[4] = field_78556_c[4] * field_78555_b[0] + field_78556_c[5] * field_78555_b[4] + field_78556_c[6] * field_78555_b[8] + field_78556_c[7] * field_78555_b[12];
        field_78554_d[5] = field_78556_c[4] * field_78555_b[1] + field_78556_c[5] * field_78555_b[5] + field_78556_c[6] * field_78555_b[9] + field_78556_c[7] * field_78555_b[13];
        field_78554_d[6] = field_78556_c[4] * field_78555_b[2] + field_78556_c[5] * field_78555_b[6] + field_78556_c[6] * field_78555_b[10] + field_78556_c[7] * field_78555_b[14];
        field_78554_d[7] = field_78556_c[4] * field_78555_b[3] + field_78556_c[5] * field_78555_b[7] + field_78556_c[6] * field_78555_b[11] + field_78556_c[7] * field_78555_b[15];
        field_78554_d[8] = field_78556_c[8] * field_78555_b[0] + field_78556_c[9] * field_78555_b[4] + field_78556_c[10] * field_78555_b[8] + field_78556_c[11] * field_78555_b[12];
        field_78554_d[9] = field_78556_c[8] * field_78555_b[1] + field_78556_c[9] * field_78555_b[5] + field_78556_c[10] * field_78555_b[9] + field_78556_c[11] * field_78555_b[13];
        field_78554_d[10] = field_78556_c[8] * field_78555_b[2] + field_78556_c[9] * field_78555_b[6] + field_78556_c[10] * field_78555_b[10] + field_78556_c[11] * field_78555_b[14];
        field_78554_d[11] = field_78556_c[8] * field_78555_b[3] + field_78556_c[9] * field_78555_b[7] + field_78556_c[10] * field_78555_b[11] + field_78556_c[11] * field_78555_b[15];
        field_78554_d[12] = field_78556_c[12] * field_78555_b[0] + field_78556_c[13] * field_78555_b[4] + field_78556_c[14] * field_78555_b[8] + field_78556_c[15] * field_78555_b[12];
        field_78554_d[13] = field_78556_c[12] * field_78555_b[1] + field_78556_c[13] * field_78555_b[5] + field_78556_c[14] * field_78555_b[9] + field_78556_c[15] * field_78555_b[13];
        field_78554_d[14] = field_78556_c[12] * field_78555_b[2] + field_78556_c[13] * field_78555_b[6] + field_78556_c[14] * field_78555_b[10] + field_78556_c[15] * field_78555_b[14];
        field_78554_d[15] = field_78556_c[12] * field_78555_b[3] + field_78556_c[13] * field_78555_b[7] + field_78556_c[14] * field_78555_b[11] + field_78556_c[15] * field_78555_b[15];
        field_78557_a[0][0] = field_78554_d[3] - field_78554_d[0];
        field_78557_a[0][1] = field_78554_d[7] - field_78554_d[4];
        field_78557_a[0][2] = field_78554_d[11] - field_78554_d[8];
        field_78557_a[0][3] = field_78554_d[15] - field_78554_d[12];
        func_78559_a(field_78557_a, 0);
        field_78557_a[1][0] = field_78554_d[3] + field_78554_d[0];
        field_78557_a[1][1] = field_78554_d[7] + field_78554_d[4];
        field_78557_a[1][2] = field_78554_d[11] + field_78554_d[8];
        field_78557_a[1][3] = field_78554_d[15] + field_78554_d[12];
        func_78559_a(field_78557_a, 1);
        field_78557_a[2][0] = field_78554_d[3] + field_78554_d[1];
        field_78557_a[2][1] = field_78554_d[7] + field_78554_d[5];
        field_78557_a[2][2] = field_78554_d[11] + field_78554_d[9];
        field_78557_a[2][3] = field_78554_d[15] + field_78554_d[13];
        func_78559_a(field_78557_a, 2);
        field_78557_a[3][0] = field_78554_d[3] - field_78554_d[1];
        field_78557_a[3][1] = field_78554_d[7] - field_78554_d[5];
        field_78557_a[3][2] = field_78554_d[11] - field_78554_d[9];
        field_78557_a[3][3] = field_78554_d[15] - field_78554_d[13];
        func_78559_a(field_78557_a, 3);
        field_78557_a[4][0] = field_78554_d[3] - field_78554_d[2];
        field_78557_a[4][1] = field_78554_d[7] - field_78554_d[6];
        field_78557_a[4][2] = field_78554_d[11] - field_78554_d[10];
        field_78557_a[4][3] = field_78554_d[15] - field_78554_d[14];
        func_78559_a(field_78557_a, 4);
        field_78557_a[5][0] = field_78554_d[3] + field_78554_d[2];
        field_78557_a[5][1] = field_78554_d[7] + field_78554_d[6];
        field_78557_a[5][2] = field_78554_d[11] + field_78554_d[10];
        field_78557_a[5][3] = field_78554_d[15] + field_78554_d[14];
        func_78559_a(field_78557_a, 5);
    }

}
