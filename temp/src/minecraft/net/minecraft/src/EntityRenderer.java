// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.awt.image.BufferedImage;
import java.nio.FloatBuffer;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.util.glu.GLU;

// Referenced classes of package net.minecraft.src:
//            MouseFilter, GLAllocation, ItemRenderer, RenderEngine, 
//            GameSettings, EntityLiving, MathHelper, WorldClient, 
//            PlayerControllerMP, MovingObjectPosition, Vec3, AxisAlignedBB, 
//            Entity, EntityPlayerSP, EntityPlayer, ActiveRenderInfo, 
//            Block, Material, Vec3Pool, RenderGlobal, 
//            EntityClientPlayerMP, Potion, OpenGlHelper, World, 
//            WorldProvider, Profiler, MouseHelper, ScaledResolution, 
//            GuiIngame, GuiScreen, GuiParticle, ClippingHelperImpl, 
//            Frustrum, ICamera, RenderHelper, EffectRenderer, 
//            InventoryPlayer, Tessellator, BiomeGenBase, EntitySmokeFX, 
//            EntityRainFX, WorldChunkManager, PotionEffect, PlayerCapabilities

public class EntityRenderer
{

    public static boolean field_78517_a = false;
    public static int field_78515_b;
    private Minecraft field_78531_r;
    private float field_78530_s;
    public ItemRenderer field_78516_c;
    private int field_78529_t;
    private Entity field_78528_u;
    private MouseFilter field_78527_v;
    private MouseFilter field_78526_w;
    private MouseFilter field_78541_x;
    private MouseFilter field_78540_y;
    private MouseFilter field_78538_z;
    private MouseFilter field_78489_A;
    private float field_78490_B;
    private float field_78491_C;
    private float field_78485_D;
    private float field_78486_E;
    private float field_78487_F;
    private float field_78488_G;
    private float field_78496_H;
    private float field_78497_I;
    private float field_78498_J;
    private float field_78499_K;
    private float field_78492_L;
    private float field_78493_M;
    private float field_78494_N;
    private float field_78495_O;
    private float field_78505_P;
    public int field_78513_d;
    private int field_78504_Q[];
    private float field_78507_R;
    private float field_78506_S;
    private float field_78501_T;
    private boolean field_78500_U;
    private double field_78503_V;
    private double field_78502_W;
    private double field_78509_X;
    private long field_78508_Y;
    private long field_78510_Z;
    private boolean field_78536_aa;
    float field_78514_e;
    float field_78511_f;
    float field_78512_g;
    float field_78524_h;
    private Random field_78537_ab;
    private int field_78534_ac;
    float field_78525_i[];
    float field_78522_j[];
    volatile int field_78523_k;
    volatile int field_78520_l;
    FloatBuffer field_78521_m;
    float field_78518_n;
    float field_78519_o;
    float field_78533_p;
    private float field_78535_ad;
    private float field_78539_ae;
    public int field_78532_q;

    public EntityRenderer(Minecraft p_i3188_1_)
    {
        field_78530_s = 0.0F;
        field_78528_u = null;
        field_78527_v = new MouseFilter();
        field_78526_w = new MouseFilter();
        field_78541_x = new MouseFilter();
        field_78540_y = new MouseFilter();
        field_78538_z = new MouseFilter();
        field_78489_A = new MouseFilter();
        field_78490_B = 4F;
        field_78491_C = 4F;
        field_78485_D = 0.0F;
        field_78486_E = 0.0F;
        field_78487_F = 0.0F;
        field_78488_G = 0.0F;
        field_78493_M = 0.0F;
        field_78494_N = 0.0F;
        field_78495_O = 0.0F;
        field_78505_P = 0.0F;
        field_78500_U = false;
        field_78503_V = 1.0D;
        field_78502_W = 0.0D;
        field_78509_X = 0.0D;
        field_78508_Y = Minecraft.func_71386_F();
        field_78510_Z = 0L;
        field_78536_aa = false;
        field_78514_e = 0.0F;
        field_78511_f = 0.0F;
        field_78512_g = 0.0F;
        field_78524_h = 0.0F;
        field_78537_ab = new Random();
        field_78534_ac = 0;
        field_78523_k = 0;
        field_78520_l = 0;
        field_78521_m = GLAllocation.func_74529_h(16);
        field_78531_r = p_i3188_1_;
        field_78516_c = new ItemRenderer(p_i3188_1_);
        field_78513_d = p_i3188_1_.field_71446_o.func_78353_a(new BufferedImage(16, 16, 1));
        field_78504_Q = new int[256];
    }

    public void func_78464_a()
    {
        func_78477_e();
        func_78470_f();
        field_78535_ad = field_78539_ae;
        field_78491_C = field_78490_B;
        field_78486_E = field_78485_D;
        field_78488_G = field_78487_F;
        field_78494_N = field_78493_M;
        field_78505_P = field_78495_O;
        if(field_78531_r.field_71474_y.field_74326_T)
        {
            float f = field_78531_r.field_71474_y.field_74341_c * 0.6F + 0.2F;
            float f2 = f * f * f * 8F;
            field_78498_J = field_78527_v.func_76333_a(field_78496_H, 0.05F * f2);
            field_78499_K = field_78526_w.func_76333_a(field_78497_I, 0.05F * f2);
            field_78492_L = 0.0F;
            field_78496_H = 0.0F;
            field_78497_I = 0.0F;
        }
        if(field_78531_r.field_71451_h == null)
        {
            field_78531_r.field_71451_h = field_78531_r.field_71439_g;
        }
        float f1 = field_78531_r.field_71441_e.func_72801_o(MathHelper.func_76128_c(field_78531_r.field_71451_h.field_70165_t), MathHelper.func_76128_c(field_78531_r.field_71451_h.field_70163_u), MathHelper.func_76128_c(field_78531_r.field_71451_h.field_70161_v));
        float f3 = (float)(3 - field_78531_r.field_71474_y.field_74339_e) / 3F;
        float f4 = f1 * (1.0F - f3) + f3;
        field_78539_ae += (f4 - field_78539_ae) * 0.1F;
        field_78529_t++;
        field_78516_c.func_78441_a();
        func_78484_h();
    }

    public void func_78473_a(float p_78473_1_)
    {
        if(field_78531_r.field_71451_h == null)
        {
            return;
        }
        if(field_78531_r.field_71441_e == null)
        {
            return;
        }
        double d = field_78531_r.field_71442_b.func_78757_d();
        field_78531_r.field_71476_x = field_78531_r.field_71451_h.func_70614_a(d, p_78473_1_);
        double d1 = d;
        Vec3 vec3 = field_78531_r.field_71451_h.func_70666_h(p_78473_1_);
        if(field_78531_r.field_71442_b.func_78749_i())
        {
            d1 = d = 6D;
        } else
        {
            if(d1 > 3D)
            {
                d1 = 3D;
            }
            d = d1;
        }
        if(field_78531_r.field_71476_x != null)
        {
            d1 = field_78531_r.field_71476_x.field_72307_f.func_72438_d(vec3);
        }
        Vec3 vec3_1 = field_78531_r.field_71451_h.func_70676_i(p_78473_1_);
        Vec3 vec3_2 = vec3.func_72441_c(vec3_1.field_72450_a * d, vec3_1.field_72448_b * d, vec3_1.field_72449_c * d);
        field_78528_u = null;
        float f = 1.0F;
        java.util.List list = field_78531_r.field_71441_e.func_72839_b(field_78531_r.field_71451_h, field_78531_r.field_71451_h.field_70121_D.func_72321_a(vec3_1.field_72450_a * d, vec3_1.field_72448_b * d, vec3_1.field_72449_c * d).func_72314_b(f, f, f));
        double d2 = d1;
        Iterator iterator = list.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            Entity entity = (Entity)iterator.next();
            if(entity.func_70067_L())
            {
                float f1 = entity.func_70111_Y();
                AxisAlignedBB axisalignedbb = entity.field_70121_D.func_72314_b(f1, f1, f1);
                MovingObjectPosition movingobjectposition = axisalignedbb.func_72327_a(vec3, vec3_2);
                if(axisalignedbb.func_72318_a(vec3))
                {
                    if(0.0D < d2 || d2 == 0.0D)
                    {
                        field_78528_u = entity;
                        d2 = 0.0D;
                    }
                } else
                if(movingobjectposition != null)
                {
                    double d3 = vec3.func_72438_d(movingobjectposition.field_72307_f);
                    if(d3 < d2 || d2 == 0.0D)
                    {
                        field_78528_u = entity;
                        d2 = d3;
                    }
                }
            }
        } while(true);
        if(field_78528_u != null && (d2 < d1 || field_78531_r.field_71476_x == null))
        {
            field_78531_r.field_71476_x = new MovingObjectPosition(field_78528_u);
        }
    }

    private void func_78477_e()
    {
        EntityPlayerSP entityplayersp = (EntityPlayerSP)field_78531_r.field_71451_h;
        field_78501_T = entityplayersp.func_71151_f();
        field_78506_S = field_78507_R;
        field_78507_R += (field_78501_T - field_78507_R) * 0.5F;
    }

    private float func_78481_a(float p_78481_1_, boolean p_78481_2_)
    {
        if(field_78532_q > 0)
        {
            return 90F;
        }
        EntityPlayer entityplayer = (EntityPlayer)field_78531_r.field_71451_h;
        float f = 70F;
        if(p_78481_2_)
        {
            f += field_78531_r.field_71474_y.field_74334_X * 40F;
            f *= field_78506_S + (field_78507_R - field_78506_S) * p_78481_1_;
        }
        if(entityplayer.func_70630_aN() <= 0)
        {
            float f1 = (float)entityplayer.field_70725_aQ + p_78481_1_;
            f /= (1.0F - 500F / (f1 + 500F)) * 2.0F + 1.0F;
        }
        int i = ActiveRenderInfo.func_74584_a(field_78531_r.field_71441_e, entityplayer, p_78481_1_);
        if(i != 0 && Block.field_71973_m[i].field_72018_cp == Material.field_76244_g)
        {
            f = (f * 60F) / 70F;
        }
        return f + field_78494_N + (field_78493_M - field_78494_N) * p_78481_1_;
    }

    private void func_78482_e(float p_78482_1_)
    {
        EntityLiving entityliving = field_78531_r.field_71451_h;
        float f = (float)entityliving.field_70737_aN - p_78482_1_;
        if(entityliving.func_70630_aN() <= 0)
        {
            float f1 = (float)entityliving.field_70725_aQ + p_78482_1_;
            GL11.glRotatef(40F - 8000F / (f1 + 200F), 0.0F, 0.0F, 1.0F);
        }
        if(f < 0.0F)
        {
            return;
        } else
        {
            f /= entityliving.field_70738_aO;
            f = MathHelper.func_76126_a(f * f * f * f * 3.141593F);
            float f2 = entityliving.field_70739_aP;
            GL11.glRotatef(-f2, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(-f * 14F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(f2, 0.0F, 1.0F, 0.0F);
            return;
        }
    }

    private void func_78475_f(float p_78475_1_)
    {
        if(!(field_78531_r.field_71451_h instanceof EntityPlayer))
        {
            return;
        } else
        {
            EntityPlayer entityplayer = (EntityPlayer)field_78531_r.field_71451_h;
            float f = entityplayer.field_70140_Q - entityplayer.field_70141_P;
            float f1 = -(entityplayer.field_70140_Q + f * p_78475_1_);
            float f2 = entityplayer.field_71107_bF + (entityplayer.field_71109_bG - entityplayer.field_71107_bF) * p_78475_1_;
            float f3 = entityplayer.field_70727_aS + (entityplayer.field_70726_aT - entityplayer.field_70727_aS) * p_78475_1_;
            GL11.glTranslatef(MathHelper.func_76126_a(f1 * 3.141593F) * f2 * 0.5F, -Math.abs(MathHelper.func_76134_b(f1 * 3.141593F) * f2), 0.0F);
            GL11.glRotatef(MathHelper.func_76126_a(f1 * 3.141593F) * f2 * 3F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(Math.abs(MathHelper.func_76134_b(f1 * 3.141593F - 0.2F) * f2) * 5F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(f3, 1.0F, 0.0F, 0.0F);
            return;
        }
    }

    private void func_78467_g(float p_78467_1_)
    {
        EntityLiving entityliving = field_78531_r.field_71451_h;
        float f = entityliving.field_70129_M - 1.62F;
        double d = entityliving.field_70169_q + (entityliving.field_70165_t - entityliving.field_70169_q) * (double)p_78467_1_;
        double d1 = (entityliving.field_70167_r + (entityliving.field_70163_u - entityliving.field_70167_r) * (double)p_78467_1_) - (double)f;
        double d2 = entityliving.field_70166_s + (entityliving.field_70161_v - entityliving.field_70166_s) * (double)p_78467_1_;
        GL11.glRotatef(field_78505_P + (field_78495_O - field_78505_P) * p_78467_1_, 0.0F, 0.0F, 1.0F);
        if(entityliving.func_70608_bn())
        {
            f = (float)((double)f + 1.0D);
            GL11.glTranslatef(0.0F, 0.3F, 0.0F);
            if(!field_78531_r.field_71474_y.field_74325_U)
            {
                int i = field_78531_r.field_71441_e.func_72798_a(MathHelper.func_76128_c(entityliving.field_70165_t), MathHelper.func_76128_c(entityliving.field_70163_u), MathHelper.func_76128_c(entityliving.field_70161_v));
                if(i == Block.field_71959_S.field_71990_ca)
                {
                    int j = field_78531_r.field_71441_e.func_72805_g(MathHelper.func_76128_c(entityliving.field_70165_t), MathHelper.func_76128_c(entityliving.field_70163_u), MathHelper.func_76128_c(entityliving.field_70161_v));
                    int k = j & 3;
                    GL11.glRotatef(k * 90, 0.0F, 1.0F, 0.0F);
                }
                GL11.glRotatef(entityliving.field_70126_B + (entityliving.field_70177_z - entityliving.field_70126_B) * p_78467_1_ + 180F, 0.0F, -1F, 0.0F);
                GL11.glRotatef(entityliving.field_70127_C + (entityliving.field_70125_A - entityliving.field_70127_C) * p_78467_1_, -1F, 0.0F, 0.0F);
            }
        } else
        if(field_78531_r.field_71474_y.field_74320_O > 0)
        {
            double d3 = field_78491_C + (field_78490_B - field_78491_C) * p_78467_1_;
            if(field_78531_r.field_71474_y.field_74325_U)
            {
                float f1 = field_78486_E + (field_78485_D - field_78486_E) * p_78467_1_;
                float f3 = field_78488_G + (field_78487_F - field_78488_G) * p_78467_1_;
                GL11.glTranslatef(0.0F, 0.0F, (float)(-d3));
                GL11.glRotatef(f3, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(f1, 0.0F, 1.0F, 0.0F);
            } else
            {
                float f2 = entityliving.field_70177_z;
                float f4 = entityliving.field_70125_A;
                if(field_78531_r.field_71474_y.field_74320_O == 2)
                {
                    f4 += 180F;
                }
                double d4 = (double)(-MathHelper.func_76126_a((f2 / 180F) * 3.141593F) * MathHelper.func_76134_b((f4 / 180F) * 3.141593F)) * d3;
                double d5 = (double)(MathHelper.func_76134_b((f2 / 180F) * 3.141593F) * MathHelper.func_76134_b((f4 / 180F) * 3.141593F)) * d3;
                double d6 = (double)(-MathHelper.func_76126_a((f4 / 180F) * 3.141593F)) * d3;
                for(int l = 0; l < 8; l++)
                {
                    float f5 = (l & 1) * 2 - 1;
                    float f6 = (l >> 1 & 1) * 2 - 1;
                    float f7 = (l >> 2 & 1) * 2 - 1;
                    f5 *= 0.1F;
                    f6 *= 0.1F;
                    f7 *= 0.1F;
                    MovingObjectPosition movingobjectposition = field_78531_r.field_71441_e.func_72933_a(Vec3.func_72437_a().func_72345_a(d + (double)f5, d1 + (double)f6, d2 + (double)f7), Vec3.func_72437_a().func_72345_a((d - d4) + (double)f5 + (double)f7, (d1 - d6) + (double)f6, (d2 - d5) + (double)f7));
                    if(movingobjectposition == null)
                    {
                        continue;
                    }
                    double d7 = movingobjectposition.field_72307_f.func_72438_d(Vec3.func_72437_a().func_72345_a(d, d1, d2));
                    if(d7 < d3)
                    {
                        d3 = d7;
                    }
                }

                if(field_78531_r.field_71474_y.field_74320_O == 2)
                {
                    GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
                }
                GL11.glRotatef(entityliving.field_70125_A - f4, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(entityliving.field_70177_z - f2, 0.0F, 1.0F, 0.0F);
                GL11.glTranslatef(0.0F, 0.0F, (float)(-d3));
                GL11.glRotatef(f2 - entityliving.field_70177_z, 0.0F, 1.0F, 0.0F);
                GL11.glRotatef(f4 - entityliving.field_70125_A, 1.0F, 0.0F, 0.0F);
            }
        } else
        {
            GL11.glTranslatef(0.0F, 0.0F, -0.1F);
        }
        if(!field_78531_r.field_71474_y.field_74325_U)
        {
            GL11.glRotatef(entityliving.field_70127_C + (entityliving.field_70125_A - entityliving.field_70127_C) * p_78467_1_, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(entityliving.field_70126_B + (entityliving.field_70177_z - entityliving.field_70126_B) * p_78467_1_ + 180F, 0.0F, 1.0F, 0.0F);
        }
        GL11.glTranslatef(0.0F, f, 0.0F);
        d = entityliving.field_70169_q + (entityliving.field_70165_t - entityliving.field_70169_q) * (double)p_78467_1_;
        d1 = (entityliving.field_70167_r + (entityliving.field_70163_u - entityliving.field_70167_r) * (double)p_78467_1_) - (double)f;
        d2 = entityliving.field_70166_s + (entityliving.field_70161_v - entityliving.field_70166_s) * (double)p_78467_1_;
        field_78500_U = field_78531_r.field_71438_f.func_72721_a(d, d1, d2, p_78467_1_);
    }

    private void func_78479_a(float p_78479_1_, int p_78479_2_)
    {
        field_78530_s = 256 >> field_78531_r.field_71474_y.field_74339_e;
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        float f = 0.07F;
        if(field_78531_r.field_71474_y.field_74337_g)
        {
            GL11.glTranslatef((float)(-(p_78479_2_ * 2 - 1)) * f, 0.0F, 0.0F);
        }
        if(field_78503_V != 1.0D)
        {
            GL11.glTranslatef((float)field_78502_W, (float)(-field_78509_X), 0.0F);
            GL11.glScaled(field_78503_V, field_78503_V, 1.0D);
        }
        GLU.gluPerspective(func_78481_a(p_78479_1_, true), (float)field_78531_r.field_71443_c / (float)field_78531_r.field_71440_d, 0.05F, field_78530_s * 2.0F);
        if(field_78531_r.field_71442_b.func_78747_a())
        {
            float f1 = 0.6666667F;
            GL11.glScalef(1.0F, f1, 1.0F);
        }
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        if(field_78531_r.field_71474_y.field_74337_g)
        {
            GL11.glTranslatef((float)(p_78479_2_ * 2 - 1) * 0.1F, 0.0F, 0.0F);
        }
        func_78482_e(p_78479_1_);
        if(field_78531_r.field_71474_y.field_74336_f)
        {
            func_78475_f(p_78479_1_);
        }
        float f2 = field_78531_r.field_71439_g.field_71080_cy + (field_78531_r.field_71439_g.field_71086_bY - field_78531_r.field_71439_g.field_71080_cy) * p_78479_1_;
        if(f2 > 0.0F)
        {
            int i = 20;
            if(field_78531_r.field_71439_g.func_70644_a(Potion.field_76431_k))
            {
                i = 7;
            }
            float f3 = 5F / (f2 * f2 + 5F) - f2 * 0.04F;
            f3 *= f3;
            GL11.glRotatef(((float)field_78529_t + p_78479_1_) * (float)i, 0.0F, 1.0F, 1.0F);
            GL11.glScalef(1.0F / f3, 1.0F, 1.0F);
            GL11.glRotatef(-((float)field_78529_t + p_78479_1_) * (float)i, 0.0F, 1.0F, 1.0F);
        }
        func_78467_g(p_78479_1_);
        if(field_78532_q > 0)
        {
            int j = field_78532_q - 1;
            if(j == 1)
            {
                GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
            }
            if(j == 2)
            {
                GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
            }
            if(j == 3)
            {
                GL11.glRotatef(-90F, 0.0F, 1.0F, 0.0F);
            }
            if(j == 4)
            {
                GL11.glRotatef(90F, 1.0F, 0.0F, 0.0F);
            }
            if(j == 5)
            {
                GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
            }
        }
    }

    private void func_78476_b(float p_78476_1_, int p_78476_2_)
    {
        if(field_78532_q > 0)
        {
            return;
        }
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        float f = 0.07F;
        if(field_78531_r.field_71474_y.field_74337_g)
        {
            GL11.glTranslatef((float)(-(p_78476_2_ * 2 - 1)) * f, 0.0F, 0.0F);
        }
        if(field_78503_V != 1.0D)
        {
            GL11.glTranslatef((float)field_78502_W, (float)(-field_78509_X), 0.0F);
            GL11.glScaled(field_78503_V, field_78503_V, 1.0D);
        }
        GLU.gluPerspective(func_78481_a(p_78476_1_, false), (float)field_78531_r.field_71443_c / (float)field_78531_r.field_71440_d, 0.05F, field_78530_s * 2.0F);
        if(field_78531_r.field_71442_b.func_78747_a())
        {
            float f1 = 0.6666667F;
            GL11.glScalef(1.0F, f1, 1.0F);
        }
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        if(field_78531_r.field_71474_y.field_74337_g)
        {
            GL11.glTranslatef((float)(p_78476_2_ * 2 - 1) * 0.1F, 0.0F, 0.0F);
        }
        GL11.glPushMatrix();
        func_78482_e(p_78476_1_);
        if(field_78531_r.field_71474_y.field_74336_f)
        {
            func_78475_f(p_78476_1_);
        }
        if(field_78531_r.field_71474_y.field_74320_O == 0 && !field_78531_r.field_71451_h.func_70608_bn() && !field_78531_r.field_71474_y.field_74319_N && !field_78531_r.field_71442_b.func_78747_a())
        {
            func_78463_b(p_78476_1_);
            field_78516_c.func_78440_a(p_78476_1_);
            func_78483_a(p_78476_1_);
        }
        GL11.glPopMatrix();
        if(field_78531_r.field_71474_y.field_74320_O == 0 && !field_78531_r.field_71451_h.func_70608_bn())
        {
            field_78516_c.func_78447_b(p_78476_1_);
            func_78482_e(p_78476_1_);
        }
        if(field_78531_r.field_71474_y.field_74336_f)
        {
            func_78475_f(p_78476_1_);
        }
    }

    public void func_78483_a(double p_78483_1_)
    {
        OpenGlHelper.func_77473_a(OpenGlHelper.field_77476_b);
        GL11.glDisable(3553);
        OpenGlHelper.func_77473_a(OpenGlHelper.field_77478_a);
    }

    public void func_78463_b(double p_78463_1_)
    {
        OpenGlHelper.func_77473_a(OpenGlHelper.field_77476_b);
        GL11.glMatrixMode(5890);
        GL11.glLoadIdentity();
        float f = 0.00390625F;
        GL11.glScalef(f, f, f);
        GL11.glTranslatef(8F, 8F, 8F);
        GL11.glMatrixMode(5888);
        field_78531_r.field_71446_o.func_78342_b(field_78513_d);
        GL11.glTexParameteri(3553, 10241, 9729);
        GL11.glTexParameteri(3553, 10240, 9729);
        GL11.glTexParameteri(3553, 10241, 9729);
        GL11.glTexParameteri(3553, 10240, 9729);
        GL11.glTexParameteri(3553, 10242, 10496);
        GL11.glTexParameteri(3553, 10243, 10496);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glEnable(3553);
        OpenGlHelper.func_77473_a(OpenGlHelper.field_77478_a);
    }

    private void func_78470_f()
    {
        field_78511_f += (Math.random() - Math.random()) * Math.random() * Math.random();
        field_78524_h += (Math.random() - Math.random()) * Math.random() * Math.random();
        field_78511_f *= 0.90000000000000002D;
        field_78524_h *= 0.90000000000000002D;
        field_78514_e += (field_78511_f - field_78514_e) * 1.0F;
        field_78512_g += (field_78524_h - field_78512_g) * 1.0F;
        field_78536_aa = true;
    }

    private void func_78472_g()
    {
        WorldClient worldclient = field_78531_r.field_71441_e;
        if(worldclient == null)
        {
            return;
        }
        for(int i = 0; i < 256; i++)
        {
            float f = worldclient.func_72971_b(1.0F) * 0.95F + 0.05F;
            float f1 = ((World) (worldclient)).field_73011_w.field_76573_f[i / 16] * f;
            float f2 = ((World) (worldclient)).field_73011_w.field_76573_f[i % 16] * (field_78514_e * 0.1F + 1.5F);
            if(((World) (worldclient)).field_73015_s > 0)
            {
                f1 = ((World) (worldclient)).field_73011_w.field_76573_f[i / 16];
            }
            float f3 = f1 * (worldclient.func_72971_b(1.0F) * 0.65F + 0.35F);
            float f4 = f1 * (worldclient.func_72971_b(1.0F) * 0.65F + 0.35F);
            float f5 = f1;
            float f6 = f2;
            float f7 = f2 * ((f2 * 0.6F + 0.4F) * 0.6F + 0.4F);
            float f8 = f2 * (f2 * f2 * 0.6F + 0.4F);
            float f9 = f3 + f6;
            float f10 = f4 + f7;
            float f11 = f5 + f8;
            f9 = f9 * 0.96F + 0.03F;
            f10 = f10 * 0.96F + 0.03F;
            f11 = f11 * 0.96F + 0.03F;
            if(((World) (worldclient)).field_73011_w.field_76574_g == 1)
            {
                f9 = 0.22F + f6 * 0.75F;
                f10 = 0.28F + f7 * 0.75F;
                f11 = 0.25F + f8 * 0.75F;
            }
            float f12 = field_78531_r.field_71474_y.field_74333_Y;
            if(f9 > 1.0F)
            {
                f9 = 1.0F;
            }
            if(f10 > 1.0F)
            {
                f10 = 1.0F;
            }
            if(f11 > 1.0F)
            {
                f11 = 1.0F;
            }
            float f13 = 1.0F - f9;
            float f14 = 1.0F - f10;
            float f15 = 1.0F - f11;
            f13 = 1.0F - f13 * f13 * f13 * f13;
            f14 = 1.0F - f14 * f14 * f14 * f14;
            f15 = 1.0F - f15 * f15 * f15 * f15;
            f9 = f9 * (1.0F - f12) + f13 * f12;
            f10 = f10 * (1.0F - f12) + f14 * f12;
            f11 = f11 * (1.0F - f12) + f15 * f12;
            f9 = f9 * 0.96F + 0.03F;
            f10 = f10 * 0.96F + 0.03F;
            f11 = f11 * 0.96F + 0.03F;
            if(f9 > 1.0F)
            {
                f9 = 1.0F;
            }
            if(f10 > 1.0F)
            {
                f10 = 1.0F;
            }
            if(f11 > 1.0F)
            {
                f11 = 1.0F;
            }
            if(f9 < 0.0F)
            {
                f9 = 0.0F;
            }
            if(f10 < 0.0F)
            {
                f10 = 0.0F;
            }
            if(f11 < 0.0F)
            {
                f11 = 0.0F;
            }
            char c = '\377';
            int j = (int)(f9 * 255F);
            int k = (int)(f10 * 255F);
            int l = (int)(f11 * 255F);
            field_78504_Q[i] = c << 24 | j << 16 | k << 8 | l;
        }

        field_78531_r.field_71446_o.func_78349_a(field_78504_Q, 16, 16, field_78513_d);
    }

    public void func_78480_b(float p_78480_1_)
    {
        field_78531_r.field_71424_I.func_76320_a("lightTex");
        if(field_78536_aa)
        {
            func_78472_g();
        }
        field_78531_r.field_71424_I.func_76319_b();
        if(Display.isActive())
        {
            field_78508_Y = Minecraft.func_71386_F();
        } else
        if(Minecraft.func_71386_F() - field_78508_Y > 500L)
        {
            field_78531_r.func_71385_j();
        }
        field_78531_r.field_71424_I.func_76320_a("mouse");
        if(field_78531_r.field_71415_G)
        {
            field_78531_r.field_71417_B.func_74374_c();
            float f = field_78531_r.field_71474_y.field_74341_c * 0.6F + 0.2F;
            float f1 = f * f * f * 8F;
            float f2 = (float)field_78531_r.field_71417_B.field_74377_a * f1;
            float f3 = (float)field_78531_r.field_71417_B.field_74375_b * f1;
            int l = 1;
            if(field_78531_r.field_71474_y.field_74338_d)
            {
                l = -1;
            }
            if(field_78531_r.field_71474_y.field_74326_T)
            {
                field_78496_H += f2;
                field_78497_I += f3;
                float f4 = p_78480_1_ - field_78492_L;
                field_78492_L = p_78480_1_;
                f2 = field_78498_J * f4;
                f3 = field_78499_K * f4;
                field_78531_r.field_71439_g.func_70082_c(f2, f3 * (float)l);
            } else
            {
                field_78531_r.field_71439_g.func_70082_c(f2, f3 * (float)l);
            }
        }
        field_78531_r.field_71424_I.func_76319_b();
        if(field_78531_r.field_71454_w)
        {
            return;
        }
        field_78517_a = field_78531_r.field_71474_y.field_74337_g;
        ScaledResolution scaledresolution = new ScaledResolution(field_78531_r.field_71474_y, field_78531_r.field_71443_c, field_78531_r.field_71440_d);
        int i = scaledresolution.func_78326_a();
        int j = scaledresolution.func_78328_b();
        int k = (Mouse.getX() * i) / field_78531_r.field_71443_c;
        int i1 = j - (Mouse.getY() * j) / field_78531_r.field_71440_d - 1;
        int j1 = func_78465_a(field_78531_r.field_71474_y.field_74350_i);
        if(field_78531_r.field_71441_e != null)
        {
            field_78531_r.field_71424_I.func_76320_a("level");
            if(field_78531_r.field_71474_y.field_74350_i == 0)
            {
                func_78471_a(p_78480_1_, 0L);
            } else
            {
                func_78471_a(p_78480_1_, field_78510_Z + (long)(0x3b9aca00 / j1));
            }
            field_78510_Z = System.nanoTime();
            field_78531_r.field_71424_I.func_76318_c("gui");
            if(!field_78531_r.field_71474_y.field_74319_N || field_78531_r.field_71462_r != null)
            {
                field_78531_r.field_71456_v.func_73830_a(p_78480_1_, field_78531_r.field_71462_r != null, k, i1);
            }
            field_78531_r.field_71424_I.func_76319_b();
        } else
        {
            GL11.glViewport(0, 0, field_78531_r.field_71443_c, field_78531_r.field_71440_d);
            GL11.glMatrixMode(5889);
            GL11.glLoadIdentity();
            GL11.glMatrixMode(5888);
            GL11.glLoadIdentity();
            func_78478_c();
            field_78510_Z = System.nanoTime();
        }
        if(field_78531_r.field_71462_r != null)
        {
            GL11.glClear(256);
            field_78531_r.field_71462_r.func_73863_a(k, i1, p_78480_1_);
            if(field_78531_r.field_71462_r != null && field_78531_r.field_71462_r.field_73884_l != null)
            {
                field_78531_r.field_71462_r.field_73884_l.func_73773_a(p_78480_1_);
            }
        }
    }

    public void func_78471_a(float p_78471_1_, long p_78471_2_)
    {
        field_78531_r.field_71424_I.func_76320_a("lightTex");
        if(field_78536_aa)
        {
            func_78472_g();
        }
        GL11.glEnable(2884);
        GL11.glEnable(2929);
        if(field_78531_r.field_71451_h == null)
        {
            field_78531_r.field_71451_h = field_78531_r.field_71439_g;
        }
        field_78531_r.field_71424_I.func_76318_c("pick");
        func_78473_a(p_78471_1_);
        EntityLiving entityliving = field_78531_r.field_71451_h;
        RenderGlobal renderglobal = field_78531_r.field_71438_f;
        EffectRenderer effectrenderer = field_78531_r.field_71452_i;
        double d = entityliving.field_70142_S + (entityliving.field_70165_t - entityliving.field_70142_S) * (double)p_78471_1_;
        double d1 = entityliving.field_70137_T + (entityliving.field_70163_u - entityliving.field_70137_T) * (double)p_78471_1_;
        double d2 = entityliving.field_70136_U + (entityliving.field_70161_v - entityliving.field_70136_U) * (double)p_78471_1_;
        field_78531_r.field_71424_I.func_76318_c("center");
        for(int i = 0; i < 2; i++)
        {
            if(field_78531_r.field_71474_y.field_74337_g)
            {
                field_78515_b = i;
                if(field_78515_b == 0)
                {
                    GL11.glColorMask(false, true, true, false);
                } else
                {
                    GL11.glColorMask(true, false, false, false);
                }
            }
            field_78531_r.field_71424_I.func_76318_c("clear");
            GL11.glViewport(0, 0, field_78531_r.field_71443_c, field_78531_r.field_71440_d);
            func_78466_h(p_78471_1_);
            GL11.glClear(16640);
            GL11.glEnable(2884);
            field_78531_r.field_71424_I.func_76318_c("camera");
            func_78479_a(p_78471_1_, i);
            ActiveRenderInfo.func_74583_a(field_78531_r.field_71439_g, field_78531_r.field_71474_y.field_74320_O == 2);
            field_78531_r.field_71424_I.func_76318_c("frustrum");
            ClippingHelperImpl.func_78558_a();
            if(field_78531_r.field_71474_y.field_74339_e < 2)
            {
                func_78468_a(-1, p_78471_1_);
                field_78531_r.field_71424_I.func_76318_c("sky");
                renderglobal.func_72714_a(p_78471_1_);
            }
            GL11.glEnable(2912);
            func_78468_a(1, p_78471_1_);
            if(field_78531_r.field_71474_y.field_74348_k)
            {
                GL11.glShadeModel(7425);
            }
            field_78531_r.field_71424_I.func_76318_c("culling");
            Frustrum frustrum = new Frustrum();
            frustrum.func_78547_a(d, d1, d2);
            field_78531_r.field_71438_f.func_72729_a(frustrum, p_78471_1_);
            if(i == 0)
            {
                field_78531_r.field_71424_I.func_76318_c("updatechunks");
                long l;
                do
                {
                    if(field_78531_r.field_71438_f.func_72716_a(entityliving, false) || p_78471_2_ == 0L)
                    {
                        break;
                    }
                    l = p_78471_2_ - System.nanoTime();
                } while(l >= 0L && l <= 0x3b9aca00L);
            }
            func_78468_a(0, p_78471_1_);
            GL11.glEnable(2912);
            GL11.glBindTexture(3553, field_78531_r.field_71446_o.func_78341_b("/terrain.png"));
            RenderHelper.func_74518_a();
            field_78531_r.field_71424_I.func_76318_c("terrain");
            renderglobal.func_72719_a(entityliving, 0, p_78471_1_);
            GL11.glShadeModel(7424);
            if(field_78532_q == 0)
            {
                RenderHelper.func_74519_b();
                field_78531_r.field_71424_I.func_76318_c("entities");
                renderglobal.func_72713_a(entityliving.func_70666_h(p_78471_1_), frustrum, p_78471_1_);
                func_78463_b(p_78471_1_);
                field_78531_r.field_71424_I.func_76318_c("litParticles");
                effectrenderer.func_78872_b(entityliving, p_78471_1_);
                RenderHelper.func_74518_a();
                func_78468_a(0, p_78471_1_);
                field_78531_r.field_71424_I.func_76318_c("particles");
                effectrenderer.func_78874_a(entityliving, p_78471_1_);
                func_78483_a(p_78471_1_);
                if(field_78531_r.field_71476_x != null && entityliving.func_70055_a(Material.field_76244_g) && (entityliving instanceof EntityPlayer) && !field_78531_r.field_71474_y.field_74319_N)
                {
                    EntityPlayer entityplayer = (EntityPlayer)entityliving;
                    GL11.glDisable(3008);
                    field_78531_r.field_71424_I.func_76318_c("outline");
                    renderglobal.func_72727_a(entityplayer, field_78531_r.field_71476_x, 0, entityplayer.field_71071_by.func_70448_g(), p_78471_1_);
                    renderglobal.func_72731_b(entityplayer, field_78531_r.field_71476_x, 0, entityplayer.field_71071_by.func_70448_g(), p_78471_1_);
                    GL11.glEnable(3008);
                }
            }
            GL11.glDisable(3042);
            GL11.glEnable(2884);
            GL11.glBlendFunc(770, 771);
            GL11.glDepthMask(true);
            func_78468_a(0, p_78471_1_);
            GL11.glEnable(3042);
            GL11.glDisable(2884);
            GL11.glBindTexture(3553, field_78531_r.field_71446_o.func_78341_b("/terrain.png"));
            if(field_78531_r.field_71474_y.field_74347_j)
            {
                field_78531_r.field_71424_I.func_76318_c("water");
                if(field_78531_r.field_71474_y.field_74348_k)
                {
                    GL11.glShadeModel(7425);
                }
                GL11.glColorMask(false, false, false, false);
                int j = renderglobal.func_72719_a(entityliving, 1, p_78471_1_);
                if(field_78531_r.field_71474_y.field_74337_g)
                {
                    if(field_78515_b == 0)
                    {
                        GL11.glColorMask(false, true, true, true);
                    } else
                    {
                        GL11.glColorMask(true, false, false, true);
                    }
                } else
                {
                    GL11.glColorMask(true, true, true, true);
                }
                if(j > 0)
                {
                    renderglobal.func_72733_a(1, p_78471_1_);
                }
                GL11.glShadeModel(7424);
            } else
            {
                field_78531_r.field_71424_I.func_76318_c("water");
                renderglobal.func_72719_a(entityliving, 1, p_78471_1_);
            }
            GL11.glDepthMask(true);
            GL11.glEnable(2884);
            GL11.glDisable(3042);
            if(field_78503_V == 1.0D && (entityliving instanceof EntityPlayer) && !field_78531_r.field_71474_y.field_74319_N && field_78531_r.field_71476_x != null && !entityliving.func_70055_a(Material.field_76244_g))
            {
                EntityPlayer entityplayer1 = (EntityPlayer)entityliving;
                GL11.glDisable(3008);
                field_78531_r.field_71424_I.func_76318_c("outline");
                renderglobal.func_72727_a(entityplayer1, field_78531_r.field_71476_x, 0, entityplayer1.field_71071_by.func_70448_g(), p_78471_1_);
                renderglobal.func_72731_b(entityplayer1, field_78531_r.field_71476_x, 0, entityplayer1.field_71071_by.func_70448_g(), p_78471_1_);
                GL11.glEnable(3008);
            }
            field_78531_r.field_71424_I.func_76318_c("destroyProgress");
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 1);
            renderglobal.func_72717_a(Tessellator.field_78398_a, (EntityPlayer)entityliving, p_78471_1_);
            GL11.glDisable(3042);
            field_78531_r.field_71424_I.func_76318_c("weather");
            func_78474_d(p_78471_1_);
            GL11.glDisable(2912);
            if(field_78531_r.field_71474_y.func_74309_c())
            {
                field_78531_r.field_71424_I.func_76318_c("clouds");
                GL11.glPushMatrix();
                func_78468_a(0, p_78471_1_);
                GL11.glEnable(2912);
                renderglobal.func_72718_b(p_78471_1_);
                GL11.glDisable(2912);
                func_78468_a(1, p_78471_1_);
                GL11.glPopMatrix();
            }
            field_78531_r.field_71424_I.func_76318_c("hand");
            if(field_78503_V == 1.0D)
            {
                GL11.glClear(256);
                func_78476_b(p_78471_1_, i);
            }
            if(!field_78531_r.field_71474_y.field_74337_g)
            {
                field_78531_r.field_71424_I.func_76319_b();
                return;
            }
        }

        GL11.glColorMask(true, true, true, false);
        field_78531_r.field_71424_I.func_76319_b();
    }

    private void func_78484_h()
    {
        float f = field_78531_r.field_71441_e.func_72867_j(1.0F);
        if(!field_78531_r.field_71474_y.field_74347_j)
        {
            f /= 2.0F;
        }
        if(f == 0.0F)
        {
            return;
        }
        field_78537_ab.setSeed((long)field_78529_t * 0x12a7ce5fL);
        EntityLiving entityliving = field_78531_r.field_71451_h;
        WorldClient worldclient = field_78531_r.field_71441_e;
        int i = MathHelper.func_76128_c(entityliving.field_70165_t);
        int j = MathHelper.func_76128_c(entityliving.field_70163_u);
        int k = MathHelper.func_76128_c(entityliving.field_70161_v);
        byte byte0 = 10;
        double d = 0.0D;
        double d1 = 0.0D;
        double d2 = 0.0D;
        int l = 0;
        int i1 = (int)(100F * f * f);
        if(field_78531_r.field_71474_y.field_74362_aa == 1)
        {
            i1 >>= 1;
        } else
        if(field_78531_r.field_71474_y.field_74362_aa == 2)
        {
            i1 = 0;
        }
        for(int j1 = 0; j1 < i1; j1++)
        {
            int k1 = (i + field_78537_ab.nextInt(byte0)) - field_78537_ab.nextInt(byte0);
            int l1 = (k + field_78537_ab.nextInt(byte0)) - field_78537_ab.nextInt(byte0);
            int i2 = worldclient.func_72874_g(k1, l1);
            int j2 = worldclient.func_72798_a(k1, i2 - 1, l1);
            BiomeGenBase biomegenbase = worldclient.func_72807_a(k1, l1);
            if(i2 > j + byte0 || i2 < j - byte0 || !biomegenbase.func_76738_d() || biomegenbase.func_76743_j() < 0.2F)
            {
                continue;
            }
            float f1 = field_78537_ab.nextFloat();
            float f2 = field_78537_ab.nextFloat();
            if(j2 <= 0)
            {
                continue;
            }
            if(Block.field_71973_m[j2].field_72018_cp == Material.field_76256_h)
            {
                field_78531_r.field_71452_i.func_78873_a(new EntitySmokeFX(worldclient, (float)k1 + f1, (double)((float)i2 + 0.1F) - Block.field_71973_m[j2].field_72023_ci, (float)l1 + f2, 0.0D, 0.0D, 0.0D));
                continue;
            }
            if(field_78537_ab.nextInt(++l) == 0)
            {
                d = (float)k1 + f1;
                d1 = (double)((float)i2 + 0.1F) - Block.field_71973_m[j2].field_72023_ci;
                d2 = (float)l1 + f2;
            }
            field_78531_r.field_71452_i.func_78873_a(new EntityRainFX(worldclient, (float)k1 + f1, (double)((float)i2 + 0.1F) - Block.field_71973_m[j2].field_72023_ci, (float)l1 + f2));
        }

        if(l > 0 && field_78537_ab.nextInt(3) < field_78534_ac++)
        {
            field_78534_ac = 0;
            if(d1 > entityliving.field_70163_u + 1.0D && worldclient.func_72874_g(MathHelper.func_76128_c(entityliving.field_70165_t), MathHelper.func_76128_c(entityliving.field_70161_v)) > MathHelper.func_76128_c(entityliving.field_70163_u))
            {
                field_78531_r.field_71441_e.func_72980_b(d, d1, d2, "ambient.weather.rain", 0.1F, 0.5F);
            } else
            {
                field_78531_r.field_71441_e.func_72980_b(d, d1, d2, "ambient.weather.rain", 0.2F, 1.0F);
            }
        }
    }

    protected void func_78474_d(float p_78474_1_)
    {
        float f = field_78531_r.field_71441_e.func_72867_j(p_78474_1_);
        if(f <= 0.0F)
        {
            return;
        }
        func_78463_b(p_78474_1_);
        if(field_78525_i == null)
        {
            field_78525_i = new float[1024];
            field_78522_j = new float[1024];
            for(int i = 0; i < 32; i++)
            {
                for(int j = 0; j < 32; j++)
                {
                    float f1 = j - 16;
                    float f2 = i - 16;
                    float f3 = MathHelper.func_76129_c(f1 * f1 + f2 * f2);
                    field_78525_i[i << 5 | j] = -f2 / f3;
                    field_78522_j[i << 5 | j] = f1 / f3;
                }

            }

        }
        EntityLiving entityliving = field_78531_r.field_71451_h;
        WorldClient worldclient = field_78531_r.field_71441_e;
        int k = MathHelper.func_76128_c(entityliving.field_70165_t);
        int l = MathHelper.func_76128_c(entityliving.field_70163_u);
        int i1 = MathHelper.func_76128_c(entityliving.field_70161_v);
        Tessellator tessellator = Tessellator.field_78398_a;
        GL11.glDisable(2884);
        GL11.glNormal3f(0.0F, 1.0F, 0.0F);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glAlphaFunc(516, 0.01F);
        GL11.glBindTexture(3553, field_78531_r.field_71446_o.func_78341_b("/environment/snow.png"));
        double d = entityliving.field_70142_S + (entityliving.field_70165_t - entityliving.field_70142_S) * (double)p_78474_1_;
        double d1 = entityliving.field_70137_T + (entityliving.field_70163_u - entityliving.field_70137_T) * (double)p_78474_1_;
        double d2 = entityliving.field_70136_U + (entityliving.field_70161_v - entityliving.field_70136_U) * (double)p_78474_1_;
        int j1 = MathHelper.func_76128_c(d1);
        int k1 = 5;
        if(field_78531_r.field_71474_y.field_74347_j)
        {
            k1 = 10;
        }
        boolean flag = false;
        byte byte0 = -1;
        float f4 = (float)field_78529_t + p_78474_1_;
        if(field_78531_r.field_71474_y.field_74347_j)
        {
            k1 = 10;
        }
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        flag = false;
        for(int l1 = i1 - k1; l1 <= i1 + k1; l1++)
        {
            for(int i2 = k - k1; i2 <= k + k1; i2++)
            {
                int j2 = ((l1 - i1) + 16) * 32 + ((i2 - k) + 16);
                float f5 = field_78525_i[j2] * 0.5F;
                float f6 = field_78522_j[j2] * 0.5F;
                BiomeGenBase biomegenbase = worldclient.func_72807_a(i2, l1);
                if(!biomegenbase.func_76738_d() && !biomegenbase.func_76746_c())
                {
                    continue;
                }
                int k2 = worldclient.func_72874_g(i2, l1);
                int l2 = l - k1;
                int i3 = l + k1;
                if(l2 < k2)
                {
                    l2 = k2;
                }
                if(i3 < k2)
                {
                    i3 = k2;
                }
                float f7 = 1.0F;
                int j3 = k2;
                if(j3 < j1)
                {
                    j3 = j1;
                }
                if(l2 == i3)
                {
                    continue;
                }
                field_78537_ab.setSeed(i2 * i2 * 3121 + i2 * 0x2b24abb ^ l1 * l1 * 0x66397 + l1 * 13761);
                float f8 = biomegenbase.func_76743_j();
                if(worldclient.func_72959_q().func_76939_a(f8, k2) >= 0.15F)
                {
                    if(byte0 != 0)
                    {
                        if(byte0 >= 0)
                        {
                            tessellator.func_78381_a();
                        }
                        byte0 = 0;
                        GL11.glBindTexture(3553, field_78531_r.field_71446_o.func_78341_b("/environment/rain.png"));
                        tessellator.func_78382_b();
                    }
                    float f9 = (((float)(field_78529_t + i2 * i2 * 3121 + i2 * 0x2b24abb + l1 * l1 * 0x66397 + l1 * 13761 & 0x1f) + p_78474_1_) / 32F) * (3F + field_78537_ab.nextFloat());
                    double d3 = (double)((float)i2 + 0.5F) - entityliving.field_70165_t;
                    double d4 = (double)((float)l1 + 0.5F) - entityliving.field_70161_v;
                    float f13 = MathHelper.func_76133_a(d3 * d3 + d4 * d4) / (float)k1;
                    float f14 = 1.0F;
                    tessellator.func_78380_c(worldclient.func_72802_i(i2, j3, l1, 0));
                    tessellator.func_78369_a(f14, f14, f14, ((1.0F - f13 * f13) * 0.5F + 0.5F) * f);
                    tessellator.func_78373_b(-d * 1.0D, -d1 * 1.0D, -d2 * 1.0D);
                    tessellator.func_78374_a((double)((float)i2 - f5) + 0.5D, l2, (double)((float)l1 - f6) + 0.5D, 0.0F * f7, ((float)l2 * f7) / 4F + f9 * f7);
                    tessellator.func_78374_a((double)((float)i2 + f5) + 0.5D, l2, (double)((float)l1 + f6) + 0.5D, 1.0F * f7, ((float)l2 * f7) / 4F + f9 * f7);
                    tessellator.func_78374_a((double)((float)i2 + f5) + 0.5D, i3, (double)((float)l1 + f6) + 0.5D, 1.0F * f7, ((float)i3 * f7) / 4F + f9 * f7);
                    tessellator.func_78374_a((double)((float)i2 - f5) + 0.5D, i3, (double)((float)l1 - f6) + 0.5D, 0.0F * f7, ((float)i3 * f7) / 4F + f9 * f7);
                    tessellator.func_78373_b(0.0D, 0.0D, 0.0D);
                    continue;
                }
                if(byte0 != 1)
                {
                    if(byte0 >= 0)
                    {
                        tessellator.func_78381_a();
                    }
                    byte0 = 1;
                    GL11.glBindTexture(3553, field_78531_r.field_71446_o.func_78341_b("/environment/snow.png"));
                    tessellator.func_78382_b();
                }
                float f10 = ((float)(field_78529_t & 0x1ff) + p_78474_1_) / 512F;
                float f11 = field_78537_ab.nextFloat() + f4 * 0.01F * (float)field_78537_ab.nextGaussian();
                float f12 = field_78537_ab.nextFloat() + f4 * (float)field_78537_ab.nextGaussian() * 0.001F;
                double d5 = (double)((float)i2 + 0.5F) - entityliving.field_70165_t;
                double d6 = (double)((float)l1 + 0.5F) - entityliving.field_70161_v;
                float f15 = MathHelper.func_76133_a(d5 * d5 + d6 * d6) / (float)k1;
                float f16 = 1.0F;
                tessellator.func_78380_c((worldclient.func_72802_i(i2, j3, l1, 0) * 3 + 0xf000f0) / 4);
                tessellator.func_78369_a(f16, f16, f16, ((1.0F - f15 * f15) * 0.3F + 0.5F) * f);
                tessellator.func_78373_b(-d * 1.0D, -d1 * 1.0D, -d2 * 1.0D);
                tessellator.func_78374_a((double)((float)i2 - f5) + 0.5D, l2, (double)((float)l1 - f6) + 0.5D, 0.0F * f7 + f11, ((float)l2 * f7) / 4F + f10 * f7 + f12);
                tessellator.func_78374_a((double)((float)i2 + f5) + 0.5D, l2, (double)((float)l1 + f6) + 0.5D, 1.0F * f7 + f11, ((float)l2 * f7) / 4F + f10 * f7 + f12);
                tessellator.func_78374_a((double)((float)i2 + f5) + 0.5D, i3, (double)((float)l1 + f6) + 0.5D, 1.0F * f7 + f11, ((float)i3 * f7) / 4F + f10 * f7 + f12);
                tessellator.func_78374_a((double)((float)i2 - f5) + 0.5D, i3, (double)((float)l1 - f6) + 0.5D, 0.0F * f7 + f11, ((float)i3 * f7) / 4F + f10 * f7 + f12);
                tessellator.func_78373_b(0.0D, 0.0D, 0.0D);
            }

        }

        if(byte0 >= 0)
        {
            tessellator.func_78381_a();
        }
        GL11.glEnable(2884);
        GL11.glDisable(3042);
        GL11.glAlphaFunc(516, 0.1F);
        func_78483_a(p_78474_1_);
    }

    public void func_78478_c()
    {
        ScaledResolution scaledresolution = new ScaledResolution(field_78531_r.field_71474_y, field_78531_r.field_71443_c, field_78531_r.field_71440_d);
        GL11.glClear(256);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0D, scaledresolution.func_78327_c(), scaledresolution.func_78324_d(), 0.0D, 1000D, 3000D);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0F, 0.0F, -2000F);
    }

    private void func_78466_h(float p_78466_1_)
    {
        WorldClient worldclient = field_78531_r.field_71441_e;
        EntityLiving entityliving = field_78531_r.field_71451_h;
        float f = 1.0F / (float)(4 - field_78531_r.field_71474_y.field_74339_e);
        f = 1.0F - (float)Math.pow(f, 0.25D);
        Vec3 vec3 = worldclient.func_72833_a(field_78531_r.field_71451_h, p_78466_1_);
        float f1 = (float)vec3.field_72450_a;
        float f2 = (float)vec3.field_72448_b;
        float f3 = (float)vec3.field_72449_c;
        Vec3 vec3_1 = worldclient.func_72948_g(p_78466_1_);
        field_78518_n = (float)vec3_1.field_72450_a;
        field_78519_o = (float)vec3_1.field_72448_b;
        field_78533_p = (float)vec3_1.field_72449_c;
        if(field_78531_r.field_71474_y.field_74339_e < 2)
        {
            Vec3 vec3_2 = MathHelper.func_76126_a(worldclient.func_72929_e(p_78466_1_)) <= 0.0F ? Vec3.func_72437_a().func_72345_a(1.0D, 0.0D, 0.0D) : Vec3.func_72437_a().func_72345_a(-1D, 0.0D, 0.0D);
            float f5 = (float)entityliving.func_70676_i(p_78466_1_).func_72430_b(vec3_2);
            if(f5 < 0.0F)
            {
                f5 = 0.0F;
            }
            if(f5 > 0.0F)
            {
                float af[] = ((World) (worldclient)).field_73011_w.func_76560_a(worldclient.func_72826_c(p_78466_1_), p_78466_1_);
                if(af != null)
                {
                    f5 *= af[3];
                    field_78518_n = field_78518_n * (1.0F - f5) + af[0] * f5;
                    field_78519_o = field_78519_o * (1.0F - f5) + af[1] * f5;
                    field_78533_p = field_78533_p * (1.0F - f5) + af[2] * f5;
                }
            }
        }
        field_78518_n += (f1 - field_78518_n) * f;
        field_78519_o += (f2 - field_78519_o) * f;
        field_78533_p += (f3 - field_78533_p) * f;
        float f4 = worldclient.func_72867_j(p_78466_1_);
        if(f4 > 0.0F)
        {
            float f6 = 1.0F - f4 * 0.5F;
            float f8 = 1.0F - f4 * 0.4F;
            field_78518_n *= f6;
            field_78519_o *= f6;
            field_78533_p *= f8;
        }
        float f7 = worldclient.func_72819_i(p_78466_1_);
        if(f7 > 0.0F)
        {
            float f9 = 1.0F - f7 * 0.5F;
            field_78518_n *= f9;
            field_78519_o *= f9;
            field_78533_p *= f9;
        }
        int i = ActiveRenderInfo.func_74584_a(field_78531_r.field_71441_e, entityliving, p_78466_1_);
        if(field_78500_U)
        {
            Vec3 vec3_3 = worldclient.func_72824_f(p_78466_1_);
            field_78518_n = (float)vec3_3.field_72450_a;
            field_78519_o = (float)vec3_3.field_72448_b;
            field_78533_p = (float)vec3_3.field_72449_c;
        } else
        if(i != 0 && Block.field_71973_m[i].field_72018_cp == Material.field_76244_g)
        {
            field_78518_n = 0.02F;
            field_78519_o = 0.02F;
            field_78533_p = 0.2F;
        } else
        if(i != 0 && Block.field_71973_m[i].field_72018_cp == Material.field_76256_h)
        {
            field_78518_n = 0.6F;
            field_78519_o = 0.1F;
            field_78533_p = 0.0F;
        }
        float f10 = field_78535_ad + (field_78539_ae - field_78535_ad) * p_78466_1_;
        field_78518_n *= f10;
        field_78519_o *= f10;
        field_78533_p *= f10;
        double d = (entityliving.field_70137_T + (entityliving.field_70163_u - entityliving.field_70137_T) * (double)p_78466_1_) * ((World) (worldclient)).field_73011_w.func_76565_k();
        if(entityliving.func_70644_a(Potion.field_76440_q))
        {
            int j = entityliving.func_70660_b(Potion.field_76440_q).func_76459_b();
            if(j < 20)
            {
                d *= 1.0F - (float)j / 20F;
            } else
            {
                d = 0.0D;
            }
        }
        if(d < 1.0D)
        {
            if(d < 0.0D)
            {
                d = 0.0D;
            }
            d *= d;
            field_78518_n *= d;
            field_78519_o *= d;
            field_78533_p *= d;
        }
        if(field_78531_r.field_71474_y.field_74337_g)
        {
            float f11 = (field_78518_n * 30F + field_78519_o * 59F + field_78533_p * 11F) / 100F;
            float f12 = (field_78518_n * 30F + field_78519_o * 70F) / 100F;
            float f13 = (field_78518_n * 30F + field_78533_p * 70F) / 100F;
            field_78518_n = f11;
            field_78519_o = f12;
            field_78533_p = f13;
        }
        GL11.glClearColor(field_78518_n, field_78519_o, field_78533_p, 0.0F);
    }

    private void func_78468_a(int p_78468_1_, float p_78468_2_)
    {
        EntityLiving entityliving = field_78531_r.field_71451_h;
        boolean flag = false;
        if(entityliving instanceof EntityPlayer)
        {
            flag = ((EntityPlayer)entityliving).field_71075_bZ.field_75098_d;
        }
        if(p_78468_1_ == 999)
        {
            GL11.glFog(2918, func_78469_a(0.0F, 0.0F, 0.0F, 1.0F));
            GL11.glFogi(2917, 9729);
            GL11.glFogf(2915, 0.0F);
            GL11.glFogf(2916, 8F);
            if(GLContext.getCapabilities().GL_NV_fog_distance)
            {
                GL11.glFogi(34138, 34139);
            }
            GL11.glFogf(2915, 0.0F);
            return;
        }
        GL11.glFog(2918, func_78469_a(field_78518_n, field_78519_o, field_78533_p, 1.0F));
        GL11.glNormal3f(0.0F, -1F, 0.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        int i = ActiveRenderInfo.func_74584_a(field_78531_r.field_71441_e, entityliving, p_78468_2_);
        if(entityliving.func_70644_a(Potion.field_76440_q))
        {
            float f = 5F;
            int j = entityliving.func_70660_b(Potion.field_76440_q).func_76459_b();
            if(j < 20)
            {
                f = 5F + (field_78530_s - 5F) * (1.0F - (float)j / 20F);
            }
            GL11.glFogi(2917, 9729);
            if(p_78468_1_ < 0)
            {
                GL11.glFogf(2915, 0.0F);
                GL11.glFogf(2916, f * 0.8F);
            } else
            {
                GL11.glFogf(2915, f * 0.25F);
                GL11.glFogf(2916, f);
            }
            if(GLContext.getCapabilities().GL_NV_fog_distance)
            {
                GL11.glFogi(34138, 34139);
            }
        } else
        if(field_78500_U)
        {
            GL11.glFogi(2917, 2048);
            GL11.glFogf(2914, 0.1F);
            float f1 = 1.0F;
            float f5 = 1.0F;
            float f8 = 1.0F;
            if(field_78531_r.field_71474_y.field_74337_g)
            {
                float f11 = (f1 * 30F + f5 * 59F + f8 * 11F) / 100F;
                float f15 = (f1 * 30F + f5 * 70F) / 100F;
                float f18 = (f1 * 30F + f8 * 70F) / 100F;
                f1 = f11;
                f5 = f15;
                f8 = f18;
            }
        } else
        if(i > 0 && Block.field_71973_m[i].field_72018_cp == Material.field_76244_g)
        {
            GL11.glFogi(2917, 2048);
            if(entityliving.func_70644_a(Potion.field_76427_o))
            {
                GL11.glFogf(2914, 0.05F);
            } else
            {
                GL11.glFogf(2914, 0.1F);
            }
            float f2 = 0.4F;
            float f6 = 0.4F;
            float f9 = 0.9F;
            if(field_78531_r.field_71474_y.field_74337_g)
            {
                float f12 = (f2 * 30F + f6 * 59F + f9 * 11F) / 100F;
                float f16 = (f2 * 30F + f6 * 70F) / 100F;
                float f19 = (f2 * 30F + f9 * 70F) / 100F;
                f2 = f12;
                f6 = f16;
                f9 = f19;
            }
        } else
        if(i > 0 && Block.field_71973_m[i].field_72018_cp == Material.field_76256_h)
        {
            GL11.glFogi(2917, 2048);
            GL11.glFogf(2914, 2.0F);
            float f3 = 0.4F;
            float f7 = 0.3F;
            float f10 = 0.3F;
            if(field_78531_r.field_71474_y.field_74337_g)
            {
                float f13 = (f3 * 30F + f7 * 59F + f10 * 11F) / 100F;
                float f17 = (f3 * 30F + f7 * 70F) / 100F;
                float f20 = (f3 * 30F + f10 * 70F) / 100F;
                f3 = f13;
                f7 = f17;
                f10 = f20;
            }
        } else
        {
            float f4 = field_78530_s;
            if(field_78531_r.field_71441_e.field_73011_w.func_76564_j() && !flag)
            {
                double d = (double)((entityliving.func_70070_b(p_78468_2_) & 0xf00000) >> 20) / 16D + (entityliving.field_70137_T + (entityliving.field_70163_u - entityliving.field_70137_T) * (double)p_78468_2_ + 4D) / 32D;
                if(d < 1.0D)
                {
                    if(d < 0.0D)
                    {
                        d = 0.0D;
                    }
                    d *= d;
                    float f14 = 100F * (float)d;
                    if(f14 < 5F)
                    {
                        f14 = 5F;
                    }
                    if(f4 > f14)
                    {
                        f4 = f14;
                    }
                }
            }
            GL11.glFogi(2917, 9729);
            if(p_78468_1_ < 0)
            {
                GL11.glFogf(2915, 0.0F);
                GL11.glFogf(2916, f4 * 0.8F);
            } else
            {
                GL11.glFogf(2915, f4 * 0.25F);
                GL11.glFogf(2916, f4);
            }
            if(GLContext.getCapabilities().GL_NV_fog_distance)
            {
                GL11.glFogi(34138, 34139);
            }
            if(field_78531_r.field_71441_e.field_73011_w.func_76568_b((int)entityliving.field_70165_t, (int)entityliving.field_70161_v))
            {
                GL11.glFogf(2915, f4 * 0.05F);
                GL11.glFogf(2916, Math.min(f4, 192F) * 0.5F);
            }
        }
        GL11.glEnable(2903);
        GL11.glColorMaterial(1028, 4608);
    }

    private FloatBuffer func_78469_a(float p_78469_1_, float p_78469_2_, float p_78469_3_, float p_78469_4_)
    {
        field_78521_m.clear();
        field_78521_m.put(p_78469_1_).put(p_78469_2_).put(p_78469_3_).put(p_78469_4_);
        field_78521_m.flip();
        return field_78521_m;
    }

    public static int func_78465_a(int p_78465_0_)
    {
        char c = '\310';
        if(p_78465_0_ == 1)
        {
            c = 'x';
        }
        if(p_78465_0_ == 2)
        {
            c = '#';
        }
        return c;
    }

}
