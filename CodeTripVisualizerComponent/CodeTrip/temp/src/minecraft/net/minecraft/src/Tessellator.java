// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.nio.*;
import org.lwjgl.opengl.*;

// Referenced classes of package net.minecraft.src:
//            GLAllocation, OpenGlHelper

public class Tessellator
{

    private static boolean field_78396_b = false;
    private static boolean field_78397_c = false;
    private ByteBuffer field_78394_d;
    private IntBuffer field_78395_e;
    private FloatBuffer field_78392_f;
    private ShortBuffer field_78393_g;
    private int field_78405_h[];
    private int field_78406_i;
    private double field_78403_j;
    private double field_78404_k;
    private int field_78401_l;
    private int field_78402_m;
    private boolean field_78399_n;
    private boolean field_78400_o;
    private boolean field_78414_p;
    private boolean field_78413_q;
    private int field_78412_r;
    private int field_78411_s;
    private boolean field_78410_t;
    private int field_78409_u;
    private double field_78408_v;
    private double field_78407_w;
    private double field_78417_x;
    private int field_78416_y;
    public static final Tessellator field_78398_a = new Tessellator(0x200000);
    private boolean field_78415_z;
    private boolean field_78389_A;
    private IntBuffer field_78390_B;
    private int field_78391_C;
    private int field_78387_D;
    private int field_78388_E;

    private Tessellator(int p_i3191_1_)
    {
        field_78406_i = 0;
        field_78399_n = false;
        field_78400_o = false;
        field_78414_p = false;
        field_78413_q = false;
        field_78412_r = 0;
        field_78411_s = 0;
        field_78410_t = false;
        field_78415_z = false;
        field_78389_A = false;
        field_78391_C = 0;
        field_78387_D = 10;
        field_78388_E = p_i3191_1_;
        field_78394_d = GLAllocation.func_74524_c(p_i3191_1_ * 4);
        field_78395_e = field_78394_d.asIntBuffer();
        field_78392_f = field_78394_d.asFloatBuffer();
        field_78393_g = field_78394_d.asShortBuffer();
        field_78405_h = new int[p_i3191_1_];
        field_78389_A = field_78397_c && GLContext.getCapabilities().GL_ARB_vertex_buffer_object;
        if(field_78389_A)
        {
            field_78390_B = GLAllocation.func_74527_f(field_78387_D);
            ARBVertexBufferObject.glGenBuffersARB(field_78390_B);
        }
    }

    public int func_78381_a()
    {
        if(!field_78415_z)
        {
            throw new IllegalStateException("Not tesselating!");
        }
        field_78415_z = false;
        if(field_78406_i > 0)
        {
            field_78395_e.clear();
            field_78395_e.put(field_78405_h, 0, field_78412_r);
            field_78394_d.position(0);
            field_78394_d.limit(field_78412_r * 4);
            if(field_78389_A)
            {
                field_78391_C = (field_78391_C + 1) % field_78387_D;
                ARBVertexBufferObject.glBindBufferARB(34962, field_78390_B.get(field_78391_C));
                ARBVertexBufferObject.glBufferDataARB(34962, field_78394_d, 35040);
            }
            if(field_78400_o)
            {
                if(field_78389_A)
                {
                    GL11.glTexCoordPointer(2, 5126, 32, 12L);
                } else
                {
                    field_78392_f.position(3);
                    GL11.glTexCoordPointer(2, 32, field_78392_f);
                }
                GL11.glEnableClientState(32888);
            }
            if(field_78414_p)
            {
                OpenGlHelper.func_77472_b(OpenGlHelper.field_77476_b);
                if(field_78389_A)
                {
                    GL11.glTexCoordPointer(2, 5122, 32, 28L);
                } else
                {
                    field_78393_g.position(14);
                    GL11.glTexCoordPointer(2, 32, field_78393_g);
                }
                GL11.glEnableClientState(32888);
                OpenGlHelper.func_77472_b(OpenGlHelper.field_77478_a);
            }
            if(field_78399_n)
            {
                if(field_78389_A)
                {
                    GL11.glColorPointer(4, 5121, 32, 20L);
                } else
                {
                    field_78394_d.position(20);
                    GL11.glColorPointer(4, true, 32, field_78394_d);
                }
                GL11.glEnableClientState(32886);
            }
            if(field_78413_q)
            {
                if(field_78389_A)
                {
                    GL11.glNormalPointer(5121, 32, 24L);
                } else
                {
                    field_78394_d.position(24);
                    GL11.glNormalPointer(32, field_78394_d);
                }
                GL11.glEnableClientState(32885);
            }
            if(field_78389_A)
            {
                GL11.glVertexPointer(3, 5126, 32, 0L);
            } else
            {
                field_78392_f.position(0);
                GL11.glVertexPointer(3, 32, field_78392_f);
            }
            GL11.glEnableClientState(32884);
            if(field_78409_u == 7 && field_78396_b)
            {
                GL11.glDrawArrays(4, 0, field_78406_i);
            } else
            {
                GL11.glDrawArrays(field_78409_u, 0, field_78406_i);
            }
            GL11.glDisableClientState(32884);
            if(field_78400_o)
            {
                GL11.glDisableClientState(32888);
            }
            if(field_78414_p)
            {
                OpenGlHelper.func_77472_b(OpenGlHelper.field_77476_b);
                GL11.glDisableClientState(32888);
                OpenGlHelper.func_77472_b(OpenGlHelper.field_77478_a);
            }
            if(field_78399_n)
            {
                GL11.glDisableClientState(32886);
            }
            if(field_78413_q)
            {
                GL11.glDisableClientState(32885);
            }
        }
        int i = field_78412_r * 4;
        func_78379_d();
        return i;
    }

    private void func_78379_d()
    {
        field_78406_i = 0;
        field_78394_d.clear();
        field_78412_r = 0;
        field_78411_s = 0;
    }

    public void func_78382_b()
    {
        func_78371_b(7);
    }

    public void func_78371_b(int p_78371_1_)
    {
        if(field_78415_z)
        {
            throw new IllegalStateException("Already tesselating!");
        } else
        {
            field_78415_z = true;
            func_78379_d();
            field_78409_u = p_78371_1_;
            field_78413_q = false;
            field_78399_n = false;
            field_78400_o = false;
            field_78414_p = false;
            field_78410_t = false;
            return;
        }
    }

    public void func_78385_a(double p_78385_1_, double p_78385_3_)
    {
        field_78400_o = true;
        field_78403_j = p_78385_1_;
        field_78404_k = p_78385_3_;
    }

    public void func_78380_c(int p_78380_1_)
    {
        field_78414_p = true;
        field_78401_l = p_78380_1_;
    }

    public void func_78386_a(float p_78386_1_, float p_78386_2_, float p_78386_3_)
    {
        func_78376_a((int)(p_78386_1_ * 255F), (int)(p_78386_2_ * 255F), (int)(p_78386_3_ * 255F));
    }

    public void func_78369_a(float p_78369_1_, float p_78369_2_, float p_78369_3_, float p_78369_4_)
    {
        func_78370_a((int)(p_78369_1_ * 255F), (int)(p_78369_2_ * 255F), (int)(p_78369_3_ * 255F), (int)(p_78369_4_ * 255F));
    }

    public void func_78376_a(int p_78376_1_, int p_78376_2_, int p_78376_3_)
    {
        func_78370_a(p_78376_1_, p_78376_2_, p_78376_3_, 255);
    }

    public void func_78370_a(int p_78370_1_, int p_78370_2_, int p_78370_3_, int p_78370_4_)
    {
        if(field_78410_t)
        {
            return;
        }
        if(p_78370_1_ > 255)
        {
            p_78370_1_ = 255;
        }
        if(p_78370_2_ > 255)
        {
            p_78370_2_ = 255;
        }
        if(p_78370_3_ > 255)
        {
            p_78370_3_ = 255;
        }
        if(p_78370_4_ > 255)
        {
            p_78370_4_ = 255;
        }
        if(p_78370_1_ < 0)
        {
            p_78370_1_ = 0;
        }
        if(p_78370_2_ < 0)
        {
            p_78370_2_ = 0;
        }
        if(p_78370_3_ < 0)
        {
            p_78370_3_ = 0;
        }
        if(p_78370_4_ < 0)
        {
            p_78370_4_ = 0;
        }
        field_78399_n = true;
        if(ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN)
        {
            field_78402_m = p_78370_4_ << 24 | p_78370_3_ << 16 | p_78370_2_ << 8 | p_78370_1_;
        } else
        {
            field_78402_m = p_78370_1_ << 24 | p_78370_2_ << 16 | p_78370_3_ << 8 | p_78370_4_;
        }
    }

    public void func_78374_a(double p_78374_1_, double p_78374_3_, double p_78374_5_, double p_78374_7_, double p_78374_9_)
    {
        func_78385_a(p_78374_7_, p_78374_9_);
        func_78377_a(p_78374_1_, p_78374_3_, p_78374_5_);
    }

    public void func_78377_a(double p_78377_1_, double p_78377_3_, double p_78377_5_)
    {
        field_78411_s++;
        if(field_78409_u == 7 && field_78396_b && field_78411_s % 4 == 0)
        {
            for(int i = 0; i < 2; i++)
            {
                int j = 8 * (3 - i);
                if(field_78400_o)
                {
                    field_78405_h[field_78412_r + 3] = field_78405_h[(field_78412_r - j) + 3];
                    field_78405_h[field_78412_r + 4] = field_78405_h[(field_78412_r - j) + 4];
                }
                if(field_78414_p)
                {
                    field_78405_h[field_78412_r + 7] = field_78405_h[(field_78412_r - j) + 7];
                }
                if(field_78399_n)
                {
                    field_78405_h[field_78412_r + 5] = field_78405_h[(field_78412_r - j) + 5];
                }
                field_78405_h[field_78412_r + 0] = field_78405_h[(field_78412_r - j) + 0];
                field_78405_h[field_78412_r + 1] = field_78405_h[(field_78412_r - j) + 1];
                field_78405_h[field_78412_r + 2] = field_78405_h[(field_78412_r - j) + 2];
                field_78406_i++;
                field_78412_r += 8;
            }

        }
        if(field_78400_o)
        {
            field_78405_h[field_78412_r + 3] = Float.floatToRawIntBits((float)field_78403_j);
            field_78405_h[field_78412_r + 4] = Float.floatToRawIntBits((float)field_78404_k);
        }
        if(field_78414_p)
        {
            field_78405_h[field_78412_r + 7] = field_78401_l;
        }
        if(field_78399_n)
        {
            field_78405_h[field_78412_r + 5] = field_78402_m;
        }
        if(field_78413_q)
        {
            field_78405_h[field_78412_r + 6] = field_78416_y;
        }
        field_78405_h[field_78412_r + 0] = Float.floatToRawIntBits((float)(p_78377_1_ + field_78408_v));
        field_78405_h[field_78412_r + 1] = Float.floatToRawIntBits((float)(p_78377_3_ + field_78407_w));
        field_78405_h[field_78412_r + 2] = Float.floatToRawIntBits((float)(p_78377_5_ + field_78417_x));
        field_78412_r += 8;
        field_78406_i++;
        if(field_78406_i % 4 == 0 && field_78412_r >= field_78388_E - 32)
        {
            func_78381_a();
            field_78415_z = true;
        }
    }

    public void func_78378_d(int p_78378_1_)
    {
        int i = p_78378_1_ >> 16 & 0xff;
        int j = p_78378_1_ >> 8 & 0xff;
        int k = p_78378_1_ & 0xff;
        func_78376_a(i, j, k);
    }

    public void func_78384_a(int p_78384_1_, int p_78384_2_)
    {
        int i = p_78384_1_ >> 16 & 0xff;
        int j = p_78384_1_ >> 8 & 0xff;
        int k = p_78384_1_ & 0xff;
        func_78370_a(i, j, k, p_78384_2_);
    }

    public void func_78383_c()
    {
        field_78410_t = true;
    }

    public void func_78375_b(float p_78375_1_, float p_78375_2_, float p_78375_3_)
    {
        field_78413_q = true;
        byte byte0 = (byte)(int)(p_78375_1_ * 127F);
        byte byte1 = (byte)(int)(p_78375_2_ * 127F);
        byte byte2 = (byte)(int)(p_78375_3_ * 127F);
        field_78416_y = byte0 & 0xff | (byte1 & 0xff) << 8 | (byte2 & 0xff) << 16;
    }

    public void func_78373_b(double p_78373_1_, double p_78373_3_, double p_78373_5_)
    {
        field_78408_v = p_78373_1_;
        field_78407_w = p_78373_3_;
        field_78417_x = p_78373_5_;
    }

    public void func_78372_c(float p_78372_1_, float p_78372_2_, float p_78372_3_)
    {
        field_78408_v += p_78372_1_;
        field_78407_w += p_78372_2_;
        field_78417_x += p_78372_3_;
    }

}
