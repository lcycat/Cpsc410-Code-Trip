// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.nio.IntBuffer;
import java.util.*;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.ARBOcclusionQuery;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            IWorldAccess, GLAllocation, RenderList, OpenGlCapsChecker, 
//            Tessellator, WorldClient, RenderManager, RenderBlocks, 
//            Block, GameSettings, BlockLeaves, WorldRenderer, 
//            Entity, MathHelper, EntitySorter, Profiler, 
//            TileEntityRenderer, EntityRenderer, ICamera, EntityLiving, 
//            RenderHelper, TileEntity, WorldProvider, RenderEngine, 
//            Vec3, EntityClientPlayerMP, RenderSorter, EntityPlayer, 
//            DestroyBlockProgress, MovingObjectPosition, EnumMovingObjectType, AxisAlignedBB, 
//            GuiIngame, SoundManager, EntityHugeExplodeFX, EffectRenderer, 
//            EntityLargeExplodeFX, EntityBubbleFX, EntitySuspendFX, EntityAuraFX, 
//            EntityCritFX, EntityFX, EntitySmokeFX, EntitySpellParticleFX, 
//            EntityNoteFX, EntityPortalFX, EntityEnchantmentTableParticleFX, EntityExplodeFX, 
//            EntityFlameFX, EntityLavaFX, EntityFootStepFX, EntitySplashFX, 
//            EntityCloudFX, EntityReddustFX, EntityBreakingFX, Item, 
//            EntityDropParticleFX, Material, EntitySnowShovelFX, EntityHeartFX, 
//            EntityDiggingFX, ImageBufferDownload, ItemPotion, StepSound, 
//            ItemRecord, ItemStack

public class RenderGlobal
    implements IWorldAccess
{

    public List field_72762_a;
    private WorldClient field_72769_h;
    private final RenderEngine field_72770_i;
    private List field_72767_j;
    private WorldRenderer field_72768_k[];
    private WorldRenderer field_72765_l[];
    private int field_72766_m;
    private int field_72763_n;
    private int field_72764_o;
    private int field_72778_p;
    private Minecraft field_72777_q;
    private RenderBlocks field_72776_r;
    private IntBuffer field_72775_s;
    private boolean field_72774_t;
    private int field_72773_u;
    private int field_72772_v;
    private int field_72771_w;
    private int field_72781_x;
    private int field_72780_y;
    private int field_72779_z;
    private int field_72741_A;
    private int field_72742_B;
    private int field_72743_C;
    private int field_72737_D;
    private Map field_72738_E;
    private int field_72739_F;
    private int field_72740_G;
    private int field_72748_H;
    private int field_72749_I;
    private int field_72750_J;
    int field_72760_b[];
    IntBuffer field_72761_c;
    private int field_72751_K;
    private int field_72744_L;
    private int field_72745_M;
    private int field_72746_N;
    private int field_72747_O;
    private int field_72753_P;
    private int field_72752_Q;
    private List field_72755_R;
    private RenderList field_72754_S[] = {
        new RenderList(), new RenderList(), new RenderList(), new RenderList()
    };
    double field_72758_d;
    double field_72759_e;
    double field_72756_f;
    int field_72757_g;

    public RenderGlobal(Minecraft p_i3194_1_, RenderEngine p_i3194_2_)
    {
        field_72762_a = new ArrayList();
        field_72767_j = new ArrayList();
        field_72774_t = false;
        field_72773_u = 0;
        field_72738_E = new HashMap();
        field_72739_F = -1;
        field_72740_G = 2;
        field_72760_b = new int[50000];
        field_72761_c = GLAllocation.func_74527_f(64);
        field_72755_R = new ArrayList();
        field_72758_d = -9999D;
        field_72759_e = -9999D;
        field_72756_f = -9999D;
        field_72757_g = 0;
        field_72777_q = p_i3194_1_;
        field_72770_i = p_i3194_2_;
        byte byte0 = 34;
        byte byte1 = 32;
        field_72778_p = GLAllocation.func_74526_a(byte0 * byte0 * byte1 * 3);
        field_72774_t = OpenGlCapsChecker.func_74371_a();
        if(field_72774_t)
        {
            field_72761_c.clear();
            field_72775_s = GLAllocation.func_74527_f(byte0 * byte0 * byte1);
            field_72775_s.clear();
            field_72775_s.position(0);
            field_72775_s.limit(byte0 * byte0 * byte1);
            ARBOcclusionQuery.glGenQueriesARB(field_72775_s);
        }
        field_72772_v = GLAllocation.func_74526_a(3);
        GL11.glPushMatrix();
        GL11.glNewList(field_72772_v, 4864);
        func_72730_g();
        GL11.glEndList();
        GL11.glPopMatrix();
        Tessellator tessellator = Tessellator.field_78398_a;
        field_72771_w = field_72772_v + 1;
        GL11.glNewList(field_72771_w, 4864);
        byte byte2 = 64;
        int i = 256 / byte2 + 2;
        float f = 16F;
        for(int j = -byte2 * i; j <= byte2 * i; j += byte2)
        {
            for(int l = -byte2 * i; l <= byte2 * i; l += byte2)
            {
                tessellator.func_78382_b();
                tessellator.func_78377_a(j + 0, f, l + 0);
                tessellator.func_78377_a(j + byte2, f, l + 0);
                tessellator.func_78377_a(j + byte2, f, l + byte2);
                tessellator.func_78377_a(j + 0, f, l + byte2);
                tessellator.func_78381_a();
            }

        }

        GL11.glEndList();
        field_72781_x = field_72772_v + 2;
        GL11.glNewList(field_72781_x, 4864);
        f = -16F;
        tessellator.func_78382_b();
        for(int k = -byte2 * i; k <= byte2 * i; k += byte2)
        {
            for(int i1 = -byte2 * i; i1 <= byte2 * i; i1 += byte2)
            {
                tessellator.func_78377_a(k + byte2, f, i1 + 0);
                tessellator.func_78377_a(k + 0, f, i1 + 0);
                tessellator.func_78377_a(k + 0, f, i1 + byte2);
                tessellator.func_78377_a(k + byte2, f, i1 + byte2);
            }

        }

        tessellator.func_78381_a();
        GL11.glEndList();
    }

    private void func_72730_g()
    {
        Random random = new Random(10842L);
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78382_b();
        for(int i = 0; i < 1500; i++)
        {
            double d = random.nextFloat() * 2.0F - 1.0F;
            double d1 = random.nextFloat() * 2.0F - 1.0F;
            double d2 = random.nextFloat() * 2.0F - 1.0F;
            double d3 = 0.15F + random.nextFloat() * 0.1F;
            double d4 = d * d + d1 * d1 + d2 * d2;
            if(d4 >= 1.0D || d4 <= 0.01D)
            {
                continue;
            }
            d4 = 1.0D / Math.sqrt(d4);
            d *= d4;
            d1 *= d4;
            d2 *= d4;
            double d5 = d * 100D;
            double d6 = d1 * 100D;
            double d7 = d2 * 100D;
            double d8 = Math.atan2(d, d2);
            double d9 = Math.sin(d8);
            double d10 = Math.cos(d8);
            double d11 = Math.atan2(Math.sqrt(d * d + d2 * d2), d1);
            double d12 = Math.sin(d11);
            double d13 = Math.cos(d11);
            double d14 = random.nextDouble() * 3.1415926535897931D * 2D;
            double d15 = Math.sin(d14);
            double d16 = Math.cos(d14);
            for(int j = 0; j < 4; j++)
            {
                double d17 = 0.0D;
                double d18 = (double)((j & 2) - 1) * d3;
                double d19 = (double)((j + 1 & 2) - 1) * d3;
                double d20 = d17;
                double d21 = d18 * d16 - d19 * d15;
                double d22 = d19 * d16 + d18 * d15;
                double d23 = d22;
                double d24 = d21 * d12 + d20 * d13;
                double d25 = d20 * d12 - d21 * d13;
                double d26 = d25 * d9 - d23 * d10;
                double d27 = d24;
                double d28 = d23 * d9 + d25 * d10;
                tessellator.func_78377_a(d5 + d26, d6 + d27, d7 + d28);
            }

        }

        tessellator.func_78381_a();
    }

    public void func_72732_a(WorldClient p_72732_1_)
    {
        if(field_72769_h != null)
        {
            field_72769_h.func_72848_b(this);
        }
        field_72758_d = -9999D;
        field_72759_e = -9999D;
        field_72756_f = -9999D;
        RenderManager.field_78727_a.func_78717_a(p_72732_1_);
        field_72769_h = p_72732_1_;
        field_72776_r = new RenderBlocks(p_72732_1_);
        if(p_72732_1_ != null)
        {
            p_72732_1_.func_72954_a(this);
            func_72712_a();
        }
    }

    public void func_72712_a()
    {
        if(field_72769_h == null)
        {
            return;
        }
        Block.field_71952_K.func_72133_a(field_72777_q.field_71474_y.field_74347_j);
        field_72739_F = field_72777_q.field_71474_y.field_74339_e;
        if(field_72765_l != null)
        {
            WorldRenderer aworldrenderer[] = field_72765_l;
            int j = aworldrenderer.length;
            for(int l = 0; l < j; l++)
            {
                WorldRenderer worldrenderer = aworldrenderer[l];
                worldrenderer.func_78911_c();
            }

        }
        int i = 64 << 3 - field_72739_F;
        if(i > 400)
        {
            i = 400;
        }
        field_72766_m = i / 16 + 1;
        field_72763_n = 16;
        field_72764_o = i / 16 + 1;
        field_72765_l = new WorldRenderer[field_72766_m * field_72763_n * field_72764_o];
        field_72768_k = new WorldRenderer[field_72766_m * field_72763_n * field_72764_o];
        int k = 0;
        int i1 = 0;
        field_72780_y = 0;
        field_72779_z = 0;
        field_72741_A = 0;
        field_72742_B = field_72766_m;
        field_72743_C = field_72763_n;
        field_72737_D = field_72764_o;
        for(Iterator iterator = field_72767_j.iterator(); iterator.hasNext();)
        {
            WorldRenderer worldrenderer1 = (WorldRenderer)iterator.next();
            worldrenderer1.field_78939_q = false;
        }

        field_72767_j.clear();
        field_72762_a.clear();
        for(int j1 = 0; j1 < field_72766_m; j1++)
        {
            for(int k1 = 0; k1 < field_72763_n; k1++)
            {
                for(int l1 = 0; l1 < field_72764_o; l1++)
                {
                    field_72765_l[(l1 * field_72763_n + k1) * field_72766_m + j1] = new WorldRenderer(field_72769_h, field_72762_a, j1 * 16, k1 * 16, l1 * 16, field_72778_p + k);
                    if(field_72774_t)
                    {
                        field_72765_l[(l1 * field_72763_n + k1) * field_72766_m + j1].field_78934_v = field_72775_s.get(i1);
                    }
                    field_72765_l[(l1 * field_72763_n + k1) * field_72766_m + j1].field_78935_u = false;
                    field_72765_l[(l1 * field_72763_n + k1) * field_72766_m + j1].field_78936_t = true;
                    field_72765_l[(l1 * field_72763_n + k1) * field_72766_m + j1].field_78927_l = true;
                    field_72765_l[(l1 * field_72763_n + k1) * field_72766_m + j1].field_78937_s = i1++;
                    field_72765_l[(l1 * field_72763_n + k1) * field_72766_m + j1].func_78914_f();
                    field_72768_k[(l1 * field_72763_n + k1) * field_72766_m + j1] = field_72765_l[(l1 * field_72763_n + k1) * field_72766_m + j1];
                    field_72767_j.add(field_72765_l[(l1 * field_72763_n + k1) * field_72766_m + j1]);
                    k += 3;
                }

            }

        }

        if(field_72769_h != null)
        {
            EntityLiving entityliving = field_72777_q.field_71451_h;
            if(entityliving != null)
            {
                func_72722_c(MathHelper.func_76128_c(((Entity) (entityliving)).field_70165_t), MathHelper.func_76128_c(((Entity) (entityliving)).field_70163_u), MathHelper.func_76128_c(((Entity) (entityliving)).field_70161_v));
                Arrays.sort(field_72768_k, new EntitySorter(entityliving));
            }
        }
        field_72740_G = 2;
    }

    public void func_72713_a(Vec3 p_72713_1_, ICamera p_72713_2_, float p_72713_3_)
    {
        if(field_72740_G > 0)
        {
            field_72740_G--;
            return;
        }
        field_72769_h.field_72984_F.func_76320_a("prepare");
        TileEntityRenderer.field_76963_a.func_76953_a(field_72769_h, field_72770_i, field_72777_q.field_71466_p, field_72777_q.field_71451_h, p_72713_3_);
        RenderManager.field_78727_a.func_78718_a(field_72769_h, field_72770_i, field_72777_q.field_71466_p, field_72777_q.field_71451_h, field_72777_q.field_71474_y, p_72713_3_);
        field_72748_H = 0;
        field_72749_I = 0;
        field_72750_J = 0;
        EntityLiving entityliving = field_72777_q.field_71451_h;
        RenderManager.field_78725_b = ((Entity) (entityliving)).field_70142_S + (((Entity) (entityliving)).field_70165_t - ((Entity) (entityliving)).field_70142_S) * (double)p_72713_3_;
        RenderManager.field_78726_c = ((Entity) (entityliving)).field_70137_T + (((Entity) (entityliving)).field_70163_u - ((Entity) (entityliving)).field_70137_T) * (double)p_72713_3_;
        RenderManager.field_78723_d = ((Entity) (entityliving)).field_70136_U + (((Entity) (entityliving)).field_70161_v - ((Entity) (entityliving)).field_70136_U) * (double)p_72713_3_;
        TileEntityRenderer.field_76961_b = ((Entity) (entityliving)).field_70142_S + (((Entity) (entityliving)).field_70165_t - ((Entity) (entityliving)).field_70142_S) * (double)p_72713_3_;
        TileEntityRenderer.field_76962_c = ((Entity) (entityliving)).field_70137_T + (((Entity) (entityliving)).field_70163_u - ((Entity) (entityliving)).field_70137_T) * (double)p_72713_3_;
        TileEntityRenderer.field_76959_d = ((Entity) (entityliving)).field_70136_U + (((Entity) (entityliving)).field_70161_v - ((Entity) (entityliving)).field_70136_U) * (double)p_72713_3_;
        field_72777_q.field_71460_t.func_78463_b(p_72713_3_);
        field_72769_h.field_72984_F.func_76318_c("global");
        List list = field_72769_h.func_72910_y();
        field_72748_H = list.size();
        for(int i = 0; i < field_72769_h.field_73007_j.size(); i++)
        {
            Entity entity = (Entity)field_72769_h.field_73007_j.get(i);
            field_72749_I++;
            if(entity.func_70102_a(p_72713_1_))
            {
                RenderManager.field_78727_a.func_78720_a(entity, p_72713_3_);
            }
        }

        field_72769_h.field_72984_F.func_76318_c("entities");
        for(int j = 0; j < list.size(); j++)
        {
            Entity entity1 = (Entity)list.get(j);
            if(entity1.func_70102_a(p_72713_1_) && (entity1.field_70158_ak || p_72713_2_.func_78546_a(entity1.field_70121_D)) && (entity1 != field_72777_q.field_71451_h || field_72777_q.field_71474_y.field_74320_O != 0 || field_72777_q.field_71451_h.func_70608_bn()) && field_72769_h.func_72899_e(MathHelper.func_76128_c(entity1.field_70165_t), 0, MathHelper.func_76128_c(entity1.field_70161_v)))
            {
                field_72749_I++;
                RenderManager.field_78727_a.func_78720_a(entity1, p_72713_3_);
            }
        }

        field_72769_h.field_72984_F.func_76318_c("tileentities");
        RenderHelper.func_74519_b();
        TileEntity tileentity;
        for(Iterator iterator = field_72762_a.iterator(); iterator.hasNext(); TileEntityRenderer.field_76963_a.func_76950_a(tileentity, p_72713_3_))
        {
            tileentity = (TileEntity)iterator.next();
        }

        field_72777_q.field_71460_t.func_78483_a(p_72713_3_);
        field_72769_h.field_72984_F.func_76319_b();
    }

    public String func_72735_c()
    {
        return (new StringBuilder()).append("C: ").append(field_72746_N).append("/").append(field_72751_K).append(". F: ").append(field_72744_L).append(", O: ").append(field_72745_M).append(", E: ").append(field_72747_O).toString();
    }

    public String func_72723_d()
    {
        return (new StringBuilder()).append("E: ").append(field_72749_I).append("/").append(field_72748_H).append(". B: ").append(field_72750_J).append(", I: ").append(field_72748_H - field_72750_J - field_72749_I).toString();
    }

    private void func_72722_c(int p_72722_1_, int p_72722_2_, int p_72722_3_)
    {
        p_72722_1_ -= 8;
        p_72722_2_ -= 8;
        p_72722_3_ -= 8;
        field_72780_y = 0x7fffffff;
        field_72779_z = 0x7fffffff;
        field_72741_A = 0x7fffffff;
        field_72742_B = 0x80000000;
        field_72743_C = 0x80000000;
        field_72737_D = 0x80000000;
        int i = field_72766_m * 16;
        int j = i / 2;
        for(int k = 0; k < field_72766_m; k++)
        {
            int l = k * 16;
            int i1 = (l + j) - p_72722_1_;
            if(i1 < 0)
            {
                i1 -= i - 1;
            }
            i1 /= i;
            l -= i1 * i;
            if(l < field_72780_y)
            {
                field_72780_y = l;
            }
            if(l > field_72742_B)
            {
                field_72742_B = l;
            }
            for(int j1 = 0; j1 < field_72764_o; j1++)
            {
                int k1 = j1 * 16;
                int l1 = (k1 + j) - p_72722_3_;
                if(l1 < 0)
                {
                    l1 -= i - 1;
                }
                l1 /= i;
                k1 -= l1 * i;
                if(k1 < field_72741_A)
                {
                    field_72741_A = k1;
                }
                if(k1 > field_72737_D)
                {
                    field_72737_D = k1;
                }
                for(int i2 = 0; i2 < field_72763_n; i2++)
                {
                    int j2 = i2 * 16;
                    if(j2 < field_72779_z)
                    {
                        field_72779_z = j2;
                    }
                    if(j2 > field_72743_C)
                    {
                        field_72743_C = j2;
                    }
                    WorldRenderer worldrenderer = field_72765_l[(j1 * field_72763_n + i2) * field_72766_m + k];
                    boolean flag = worldrenderer.field_78939_q;
                    worldrenderer.func_78913_a(l, j2, k1);
                    if(!flag && worldrenderer.field_78939_q)
                    {
                        field_72767_j.add(worldrenderer);
                    }
                }

            }

        }

    }

    public int func_72719_a(EntityLiving p_72719_1_, int p_72719_2_, double p_72719_3_)
    {
        field_72769_h.field_72984_F.func_76320_a("sortchunks");
        for(int i = 0; i < 10; i++)
        {
            field_72752_Q = (field_72752_Q + 1) % field_72765_l.length;
            WorldRenderer worldrenderer = field_72765_l[field_72752_Q];
            if(worldrenderer.field_78939_q && !field_72767_j.contains(worldrenderer))
            {
                field_72767_j.add(worldrenderer);
            }
        }

        if(field_72777_q.field_71474_y.field_74339_e != field_72739_F)
        {
            func_72712_a();
        }
        if(p_72719_2_ == 0)
        {
            field_72751_K = 0;
            field_72753_P = 0;
            field_72744_L = 0;
            field_72745_M = 0;
            field_72746_N = 0;
            field_72747_O = 0;
        }
        double d = p_72719_1_.field_70142_S + (p_72719_1_.field_70165_t - p_72719_1_.field_70142_S) * p_72719_3_;
        double d1 = p_72719_1_.field_70137_T + (p_72719_1_.field_70163_u - p_72719_1_.field_70137_T) * p_72719_3_;
        double d2 = p_72719_1_.field_70136_U + (p_72719_1_.field_70161_v - p_72719_1_.field_70136_U) * p_72719_3_;
        double d3 = p_72719_1_.field_70165_t - field_72758_d;
        double d4 = p_72719_1_.field_70163_u - field_72759_e;
        double d5 = p_72719_1_.field_70161_v - field_72756_f;
        if(d3 * d3 + d4 * d4 + d5 * d5 > 16D)
        {
            field_72758_d = p_72719_1_.field_70165_t;
            field_72759_e = p_72719_1_.field_70163_u;
            field_72756_f = p_72719_1_.field_70161_v;
            func_72722_c(MathHelper.func_76128_c(p_72719_1_.field_70165_t), MathHelper.func_76128_c(p_72719_1_.field_70163_u), MathHelper.func_76128_c(p_72719_1_.field_70161_v));
            Arrays.sort(field_72768_k, new EntitySorter(p_72719_1_));
        }
        RenderHelper.func_74518_a();
        int j = 0;
        if(field_72774_t && field_72777_q.field_71474_y.field_74349_h && !field_72777_q.field_71474_y.field_74337_g && p_72719_2_ == 0)
        {
            int k = 0;
            int l = 16;
            func_72720_a(k, l);
            for(int i1 = k; i1 < l; i1++)
            {
                field_72768_k[i1].field_78936_t = true;
            }

            field_72769_h.field_72984_F.func_76318_c("render");
            j += func_72724_a(k, l, p_72719_2_, p_72719_3_);
            do
            {
                field_72769_h.field_72984_F.func_76318_c("occ");
                byte byte0 = l;
                l *= 2;
                if(l > field_72768_k.length)
                {
                    l = field_72768_k.length;
                }
                GL11.glDisable(3553);
                GL11.glDisable(2896);
                GL11.glDisable(3008);
                GL11.glDisable(2912);
                GL11.glColorMask(false, false, false, false);
                GL11.glDepthMask(false);
                field_72769_h.field_72984_F.func_76320_a("check");
                func_72720_a(byte0, l);
                field_72769_h.field_72984_F.func_76319_b();
                GL11.glPushMatrix();
                float f = 0.0F;
                float f1 = 0.0F;
                float f2 = 0.0F;
                for(int j1 = byte0; j1 < l; j1++)
                {
                    if(field_72768_k[j1].func_78906_e())
                    {
                        field_72768_k[j1].field_78927_l = false;
                        continue;
                    }
                    if(!field_72768_k[j1].field_78927_l)
                    {
                        field_72768_k[j1].field_78936_t = true;
                    }
                    if(!field_72768_k[j1].field_78927_l || field_72768_k[j1].field_78935_u)
                    {
                        continue;
                    }
                    float f3 = MathHelper.func_76129_c(field_72768_k[j1].func_78912_a(p_72719_1_));
                    int k1 = (int)(1.0F + f3 / 128F);
                    if(field_72773_u % k1 != j1 % k1)
                    {
                        continue;
                    }
                    WorldRenderer worldrenderer1 = field_72768_k[j1];
                    float f4 = (float)((double)worldrenderer1.field_78918_f - d);
                    float f5 = (float)((double)worldrenderer1.field_78919_g - d1);
                    float f6 = (float)((double)worldrenderer1.field_78931_h - d2);
                    float f7 = f4 - f;
                    float f8 = f5 - f1;
                    float f9 = f6 - f2;
                    if(f7 != 0.0F || f8 != 0.0F || f9 != 0.0F)
                    {
                        GL11.glTranslatef(f7, f8, f9);
                        f += f7;
                        f1 += f8;
                        f2 += f9;
                    }
                    field_72769_h.field_72984_F.func_76320_a("bb");
                    ARBOcclusionQuery.glBeginQueryARB(35092, field_72768_k[j1].field_78934_v);
                    field_72768_k[j1].func_78904_d();
                    ARBOcclusionQuery.glEndQueryARB(35092);
                    field_72769_h.field_72984_F.func_76319_b();
                    field_72768_k[j1].field_78935_u = true;
                }

                GL11.glPopMatrix();
                if(field_72777_q.field_71474_y.field_74337_g)
                {
                    if(EntityRenderer.field_78515_b == 0)
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
                GL11.glDepthMask(true);
                GL11.glEnable(3553);
                GL11.glEnable(3008);
                GL11.glEnable(2912);
                field_72769_h.field_72984_F.func_76318_c("render");
                j += func_72724_a(byte0, l, p_72719_2_, p_72719_3_);
            } while(l < field_72768_k.length);
        } else
        {
            field_72769_h.field_72984_F.func_76318_c("render");
            j += func_72724_a(0, field_72768_k.length, p_72719_2_, p_72719_3_);
        }
        field_72769_h.field_72984_F.func_76319_b();
        return j;
    }

    private void func_72720_a(int p_72720_1_, int p_72720_2_)
    {
        for(int i = p_72720_1_; i < p_72720_2_; i++)
        {
            if(!field_72768_k[i].field_78935_u)
            {
                continue;
            }
            field_72761_c.clear();
            ARBOcclusionQuery.glGetQueryObjectuARB(field_72768_k[i].field_78934_v, 34919, field_72761_c);
            if(field_72761_c.get(0) != 0)
            {
                field_72768_k[i].field_78935_u = false;
                field_72761_c.clear();
                ARBOcclusionQuery.glGetQueryObjectuARB(field_72768_k[i].field_78934_v, 34918, field_72761_c);
                field_72768_k[i].field_78936_t = field_72761_c.get(0) != 0;
            }
        }

    }

    private int func_72724_a(int p_72724_1_, int p_72724_2_, int p_72724_3_, double p_72724_4_)
    {
        field_72755_R.clear();
        int i = 0;
        for(int j = p_72724_1_; j < p_72724_2_; j++)
        {
            if(p_72724_3_ == 0)
            {
                field_72751_K++;
                if(field_72768_k[j].field_78928_m[p_72724_3_])
                {
                    field_72747_O++;
                } else
                if(!field_72768_k[j].field_78927_l)
                {
                    field_72744_L++;
                } else
                if(field_72774_t && !field_72768_k[j].field_78936_t)
                {
                    field_72745_M++;
                } else
                {
                    field_72746_N++;
                }
            }
            if(field_72768_k[j].field_78928_m[p_72724_3_] || !field_72768_k[j].field_78927_l || field_72774_t && !field_72768_k[j].field_78936_t)
            {
                continue;
            }
            int k = field_72768_k[j].func_78909_a(p_72724_3_);
            if(k >= 0)
            {
                field_72755_R.add(field_72768_k[j]);
                i++;
            }
        }

        EntityLiving entityliving = field_72777_q.field_71451_h;
        double d = entityliving.field_70142_S + (entityliving.field_70165_t - entityliving.field_70142_S) * p_72724_4_;
        double d1 = entityliving.field_70137_T + (entityliving.field_70163_u - entityliving.field_70137_T) * p_72724_4_;
        double d2 = entityliving.field_70136_U + (entityliving.field_70161_v - entityliving.field_70136_U) * p_72724_4_;
        int l = 0;
        RenderList arenderlist[] = field_72754_S;
        int i1 = arenderlist.length;
        for(int j1 = 0; j1 < i1; j1++)
        {
            RenderList renderlist = arenderlist[j1];
            renderlist.func_78421_b();
        }

        WorldRenderer worldrenderer;
        int k1;
        for(Iterator iterator = field_72755_R.iterator(); iterator.hasNext(); field_72754_S[k1].func_78420_a(worldrenderer.func_78909_a(p_72724_3_)))
        {
            worldrenderer = (WorldRenderer)iterator.next();
            k1 = -1;
            for(int l1 = 0; l1 < l; l1++)
            {
                if(field_72754_S[l1].func_78418_a(worldrenderer.field_78918_f, worldrenderer.field_78919_g, worldrenderer.field_78931_h))
                {
                    k1 = l1;
                }
            }

            if(k1 < 0)
            {
                k1 = l++;
                field_72754_S[k1].func_78422_a(worldrenderer.field_78918_f, worldrenderer.field_78919_g, worldrenderer.field_78931_h, d, d1, d2);
            }
        }

        func_72733_a(p_72724_3_, p_72724_4_);
        return i;
    }

    public void func_72733_a(int p_72733_1_, double p_72733_2_)
    {
        field_72777_q.field_71460_t.func_78463_b(p_72733_2_);
        RenderList arenderlist[] = field_72754_S;
        int i = arenderlist.length;
        for(int j = 0; j < i; j++)
        {
            RenderList renderlist = arenderlist[j];
            renderlist.func_78419_a();
        }

        field_72777_q.field_71460_t.func_78483_a(p_72733_2_);
    }

    public void func_72734_e()
    {
        field_72773_u++;
    }

    public void func_72714_a(float p_72714_1_)
    {
        if(field_72777_q.field_71441_e.field_73011_w.field_76574_g == 1)
        {
            GL11.glDisable(2912);
            GL11.glDisable(3008);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            RenderHelper.func_74518_a();
            GL11.glDepthMask(false);
            field_72770_i.func_78342_b(field_72770_i.func_78341_b("/misc/tunnel.png"));
            Tessellator tessellator = Tessellator.field_78398_a;
            for(int i = 0; i < 6; i++)
            {
                GL11.glPushMatrix();
                if(i == 1)
                {
                    GL11.glRotatef(90F, 1.0F, 0.0F, 0.0F);
                }
                if(i == 2)
                {
                    GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
                }
                if(i == 3)
                {
                    GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
                }
                if(i == 4)
                {
                    GL11.glRotatef(90F, 0.0F, 0.0F, 1.0F);
                }
                if(i == 5)
                {
                    GL11.glRotatef(-90F, 0.0F, 0.0F, 1.0F);
                }
                tessellator.func_78382_b();
                tessellator.func_78378_d(0x282828);
                tessellator.func_78374_a(-100D, -100D, -100D, 0.0D, 0.0D);
                tessellator.func_78374_a(-100D, -100D, 100D, 0.0D, 16D);
                tessellator.func_78374_a(100D, -100D, 100D, 16D, 16D);
                tessellator.func_78374_a(100D, -100D, -100D, 16D, 0.0D);
                tessellator.func_78381_a();
                GL11.glPopMatrix();
            }

            GL11.glDepthMask(true);
            GL11.glEnable(3553);
            GL11.glEnable(3008);
            return;
        }
        if(!field_72777_q.field_71441_e.field_73011_w.func_76569_d())
        {
            return;
        }
        GL11.glDisable(3553);
        Vec3 vec3 = field_72769_h.func_72833_a(field_72777_q.field_71451_h, p_72714_1_);
        float f = (float)vec3.field_72450_a;
        float f1 = (float)vec3.field_72448_b;
        float f2 = (float)vec3.field_72449_c;
        if(field_72777_q.field_71474_y.field_74337_g)
        {
            float f3 = (f * 30F + f1 * 59F + f2 * 11F) / 100F;
            float f4 = (f * 30F + f1 * 70F) / 100F;
            float f5 = (f * 30F + f2 * 70F) / 100F;
            f = f3;
            f1 = f4;
            f2 = f5;
        }
        GL11.glColor3f(f, f1, f2);
        Tessellator tessellator1 = Tessellator.field_78398_a;
        GL11.glDepthMask(false);
        GL11.glEnable(2912);
        GL11.glColor3f(f, f1, f2);
        GL11.glCallList(field_72771_w);
        GL11.glDisable(2912);
        GL11.glDisable(3008);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        RenderHelper.func_74518_a();
        float af[] = field_72769_h.field_73011_w.func_76560_a(field_72769_h.func_72826_c(p_72714_1_), p_72714_1_);
        if(af != null)
        {
            GL11.glDisable(3553);
            GL11.glShadeModel(7425);
            GL11.glPushMatrix();
            GL11.glRotatef(90F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(MathHelper.func_76126_a(field_72769_h.func_72929_e(p_72714_1_)) >= 0.0F ? 0.0F : 180F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(90F, 0.0F, 0.0F, 1.0F);
            float f6 = af[0];
            float f7 = af[1];
            float f9 = af[2];
            if(field_72777_q.field_71474_y.field_74337_g)
            {
                float f12 = (f6 * 30F + f7 * 59F + f9 * 11F) / 100F;
                float f15 = (f6 * 30F + f7 * 70F) / 100F;
                float f18 = (f6 * 30F + f9 * 70F) / 100F;
                f6 = f12;
                f7 = f15;
                f9 = f18;
            }
            tessellator1.func_78371_b(6);
            tessellator1.func_78369_a(f6, f7, f9, af[3]);
            tessellator1.func_78377_a(0.0D, 100D, 0.0D);
            int j = 16;
            tessellator1.func_78369_a(af[0], af[1], af[2], 0.0F);
            for(int k = 0; k <= j; k++)
            {
                float f19 = ((float)k * 3.141593F * 2.0F) / (float)j;
                float f21 = MathHelper.func_76126_a(f19);
                float f22 = MathHelper.func_76134_b(f19);
                tessellator1.func_78377_a(f21 * 120F, f22 * 120F, -f22 * 40F * af[3]);
            }

            tessellator1.func_78381_a();
            GL11.glPopMatrix();
            GL11.glShadeModel(7424);
        }
        GL11.glEnable(3553);
        GL11.glBlendFunc(770, 1);
        GL11.glPushMatrix();
        double d = 1.0F - field_72769_h.func_72867_j(p_72714_1_);
        float f8 = 0.0F;
        float f10 = 0.0F;
        float f13 = 0.0F;
        GL11.glColor4f(1.0F, 1.0F, 1.0F, d);
        GL11.glTranslatef(f8, f10, f13);
        GL11.glRotatef(-90F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(field_72769_h.func_72826_c(p_72714_1_) * 360F, 1.0F, 0.0F, 0.0F);
        float f16 = 30F;
        GL11.glBindTexture(3553, field_72770_i.func_78341_b("/terrain/sun.png"));
        tessellator1.func_78382_b();
        tessellator1.func_78374_a(-f16, 100D, -f16, 0.0D, 0.0D);
        tessellator1.func_78374_a(f16, 100D, -f16, 1.0D, 0.0D);
        tessellator1.func_78374_a(f16, 100D, f16, 1.0D, 1.0D);
        tessellator1.func_78374_a(-f16, 100D, f16, 0.0D, 1.0D);
        tessellator1.func_78381_a();
        f16 = 20F;
        GL11.glBindTexture(3553, field_72770_i.func_78341_b("/terrain/moon_phases.png"));
        int l = field_72769_h.func_72853_d(p_72714_1_);
        int i1 = l % 4;
        int j1 = (l / 4) % 2;
        float f23 = (float)(i1 + 0) / 4F;
        float f24 = (float)(j1 + 0) / 2.0F;
        float f25 = (float)(i1 + 1) / 4F;
        float f26 = (float)(j1 + 1) / 2.0F;
        tessellator1.func_78382_b();
        tessellator1.func_78374_a(-f16, -100D, f16, f25, f26);
        tessellator1.func_78374_a(f16, -100D, f16, f23, f26);
        tessellator1.func_78374_a(f16, -100D, -f16, f23, f24);
        tessellator1.func_78374_a(-f16, -100D, -f16, f25, f24);
        tessellator1.func_78381_a();
        GL11.glDisable(3553);
        float f27 = field_72769_h.func_72880_h(p_72714_1_) * d;
        if(f27 > 0.0F)
        {
            GL11.glColor4f(f27, f27, f27, f27);
            GL11.glCallList(field_72772_v);
        }
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(3042);
        GL11.glEnable(3008);
        GL11.glEnable(2912);
        GL11.glPopMatrix();
        GL11.glDisable(3553);
        GL11.glColor3f(0.0F, 0.0F, 0.0F);
        d = field_72777_q.field_71439_g.func_70666_h(p_72714_1_).field_72448_b - field_72769_h.func_72919_O();
        if(d < 0.0D)
        {
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, 12F, 0.0F);
            GL11.glCallList(field_72781_x);
            GL11.glPopMatrix();
            float f11 = 1.0F;
            float f14 = -(float)(d + 65D);
            float f17 = -f11;
            float f20 = f14;
            tessellator1.func_78382_b();
            tessellator1.func_78384_a(0, 255);
            tessellator1.func_78377_a(-f11, f20, f11);
            tessellator1.func_78377_a(f11, f20, f11);
            tessellator1.func_78377_a(f11, f17, f11);
            tessellator1.func_78377_a(-f11, f17, f11);
            tessellator1.func_78377_a(-f11, f17, -f11);
            tessellator1.func_78377_a(f11, f17, -f11);
            tessellator1.func_78377_a(f11, f20, -f11);
            tessellator1.func_78377_a(-f11, f20, -f11);
            tessellator1.func_78377_a(f11, f17, -f11);
            tessellator1.func_78377_a(f11, f17, f11);
            tessellator1.func_78377_a(f11, f20, f11);
            tessellator1.func_78377_a(f11, f20, -f11);
            tessellator1.func_78377_a(-f11, f20, -f11);
            tessellator1.func_78377_a(-f11, f20, f11);
            tessellator1.func_78377_a(-f11, f17, f11);
            tessellator1.func_78377_a(-f11, f17, -f11);
            tessellator1.func_78377_a(-f11, f17, -f11);
            tessellator1.func_78377_a(-f11, f17, f11);
            tessellator1.func_78377_a(f11, f17, f11);
            tessellator1.func_78377_a(f11, f17, -f11);
            tessellator1.func_78381_a();
        }
        if(field_72769_h.field_73011_w.func_76561_g())
        {
            GL11.glColor3f(f * 0.2F + 0.04F, f1 * 0.2F + 0.04F, f2 * 0.6F + 0.1F);
        } else
        {
            GL11.glColor3f(f, f1, f2);
        }
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, -(float)(d - 16D), 0.0F);
        GL11.glCallList(field_72781_x);
        GL11.glPopMatrix();
        GL11.glEnable(3553);
        GL11.glDepthMask(true);
    }

    public void func_72718_b(float p_72718_1_)
    {
        if(!field_72777_q.field_71441_e.field_73011_w.func_76569_d())
        {
            return;
        }
        if(field_72777_q.field_71474_y.field_74347_j)
        {
            func_72736_c(p_72718_1_);
            return;
        }
        GL11.glDisable(2884);
        float f = (float)(field_72777_q.field_71451_h.field_70137_T + (field_72777_q.field_71451_h.field_70163_u - field_72777_q.field_71451_h.field_70137_T) * (double)p_72718_1_);
        byte byte0 = 32;
        int i = 256 / byte0;
        Tessellator tessellator = Tessellator.field_78398_a;
        GL11.glBindTexture(3553, field_72770_i.func_78341_b("/environment/clouds.png"));
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        Vec3 vec3 = field_72769_h.func_72824_f(p_72718_1_);
        float f1 = (float)vec3.field_72450_a;
        float f2 = (float)vec3.field_72448_b;
        float f3 = (float)vec3.field_72449_c;
        if(field_72777_q.field_71474_y.field_74337_g)
        {
            float f4 = (f1 * 30F + f2 * 59F + f3 * 11F) / 100F;
            float f6 = (f1 * 30F + f2 * 70F) / 100F;
            float f7 = (f1 * 30F + f3 * 70F) / 100F;
            f1 = f4;
            f2 = f6;
            f3 = f7;
        }
        float f5 = 0.0004882813F;
        double d = (float)field_72773_u + p_72718_1_;
        double d1 = field_72777_q.field_71451_h.field_70169_q + (field_72777_q.field_71451_h.field_70165_t - field_72777_q.field_71451_h.field_70169_q) * (double)p_72718_1_ + d * 0.029999999329447746D;
        double d2 = field_72777_q.field_71451_h.field_70166_s + (field_72777_q.field_71451_h.field_70161_v - field_72777_q.field_71451_h.field_70166_s) * (double)p_72718_1_;
        int j = MathHelper.func_76128_c(d1 / 2048D);
        int k = MathHelper.func_76128_c(d2 / 2048D);
        d1 -= j * 2048;
        d2 -= k * 2048;
        float f8 = (field_72769_h.field_73011_w.func_76571_f() - f) + 0.33F;
        float f9 = (float)(d1 * (double)f5);
        float f10 = (float)(d2 * (double)f5);
        tessellator.func_78382_b();
        tessellator.func_78369_a(f1, f2, f3, 0.8F);
        for(int l = -byte0 * i; l < byte0 * i; l += byte0)
        {
            for(int i1 = -byte0 * i; i1 < byte0 * i; i1 += byte0)
            {
                tessellator.func_78374_a(l + 0, f8, i1 + byte0, (float)(l + 0) * f5 + f9, (float)(i1 + byte0) * f5 + f10);
                tessellator.func_78374_a(l + byte0, f8, i1 + byte0, (float)(l + byte0) * f5 + f9, (float)(i1 + byte0) * f5 + f10);
                tessellator.func_78374_a(l + byte0, f8, i1 + 0, (float)(l + byte0) * f5 + f9, (float)(i1 + 0) * f5 + f10);
                tessellator.func_78374_a(l + 0, f8, i1 + 0, (float)(l + 0) * f5 + f9, (float)(i1 + 0) * f5 + f10);
            }

        }

        tessellator.func_78381_a();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(3042);
        GL11.glEnable(2884);
    }

    public boolean func_72721_a(double p_72721_1_, double p_72721_3_, double d, float f)
    {
        return false;
    }

    public void func_72736_c(float p_72736_1_)
    {
        GL11.glDisable(2884);
        float f = (float)(field_72777_q.field_71451_h.field_70137_T + (field_72777_q.field_71451_h.field_70163_u - field_72777_q.field_71451_h.field_70137_T) * (double)p_72736_1_);
        Tessellator tessellator = Tessellator.field_78398_a;
        float f1 = 12F;
        float f2 = 4F;
        double d = (float)field_72773_u + p_72736_1_;
        double d1 = (field_72777_q.field_71451_h.field_70169_q + (field_72777_q.field_71451_h.field_70165_t - field_72777_q.field_71451_h.field_70169_q) * (double)p_72736_1_ + d * 0.029999999329447746D) / (double)f1;
        double d2 = (field_72777_q.field_71451_h.field_70166_s + (field_72777_q.field_71451_h.field_70161_v - field_72777_q.field_71451_h.field_70166_s) * (double)p_72736_1_) / (double)f1 + 0.33000001311302185D;
        float f3 = (field_72769_h.field_73011_w.func_76571_f() - f) + 0.33F;
        int i = MathHelper.func_76128_c(d1 / 2048D);
        int j = MathHelper.func_76128_c(d2 / 2048D);
        d1 -= i * 2048;
        d2 -= j * 2048;
        GL11.glBindTexture(3553, field_72770_i.func_78341_b("/environment/clouds.png"));
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        Vec3 vec3 = field_72769_h.func_72824_f(p_72736_1_);
        float f4 = (float)vec3.field_72450_a;
        float f5 = (float)vec3.field_72448_b;
        float f6 = (float)vec3.field_72449_c;
        if(field_72777_q.field_71474_y.field_74337_g)
        {
            float f7 = (f4 * 30F + f5 * 59F + f6 * 11F) / 100F;
            float f9 = (f4 * 30F + f5 * 70F) / 100F;
            float f11 = (f4 * 30F + f6 * 70F) / 100F;
            f4 = f7;
            f5 = f9;
            f6 = f11;
        }
        float f8 = (float)(d1 * 0.0D);
        float f10 = (float)(d2 * 0.0D);
        float f12 = 0.00390625F;
        f8 = (float)MathHelper.func_76128_c(d1) * f12;
        f10 = (float)MathHelper.func_76128_c(d2) * f12;
        float f13 = (float)(d1 - (double)MathHelper.func_76128_c(d1));
        float f14 = (float)(d2 - (double)MathHelper.func_76128_c(d2));
        int k = 8;
        byte byte0 = 4;
        float f15 = 0.0009765625F;
        GL11.glScalef(f1, 1.0F, f1);
        for(int l = 0; l < 2; l++)
        {
            if(l == 0)
            {
                GL11.glColorMask(false, false, false, false);
            } else
            if(field_72777_q.field_71474_y.field_74337_g)
            {
                if(EntityRenderer.field_78515_b == 0)
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
            for(int i1 = -byte0 + 1; i1 <= byte0; i1++)
            {
                for(int j1 = -byte0 + 1; j1 <= byte0; j1++)
                {
                    tessellator.func_78382_b();
                    float f16 = i1 * k;
                    float f17 = j1 * k;
                    float f18 = f16 - f13;
                    float f19 = f17 - f14;
                    if(f3 > -f2 - 1.0F)
                    {
                        tessellator.func_78369_a(f4 * 0.7F, f5 * 0.7F, f6 * 0.7F, 0.8F);
                        tessellator.func_78375_b(0.0F, -1F, 0.0F);
                        tessellator.func_78374_a(f18 + 0.0F, f3 + 0.0F, f19 + (float)k, (f16 + 0.0F) * f12 + f8, (f17 + (float)k) * f12 + f10);
                        tessellator.func_78374_a(f18 + (float)k, f3 + 0.0F, f19 + (float)k, (f16 + (float)k) * f12 + f8, (f17 + (float)k) * f12 + f10);
                        tessellator.func_78374_a(f18 + (float)k, f3 + 0.0F, f19 + 0.0F, (f16 + (float)k) * f12 + f8, (f17 + 0.0F) * f12 + f10);
                        tessellator.func_78374_a(f18 + 0.0F, f3 + 0.0F, f19 + 0.0F, (f16 + 0.0F) * f12 + f8, (f17 + 0.0F) * f12 + f10);
                    }
                    if(f3 <= f2 + 1.0F)
                    {
                        tessellator.func_78369_a(f4, f5, f6, 0.8F);
                        tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
                        tessellator.func_78374_a(f18 + 0.0F, (f3 + f2) - f15, f19 + (float)k, (f16 + 0.0F) * f12 + f8, (f17 + (float)k) * f12 + f10);
                        tessellator.func_78374_a(f18 + (float)k, (f3 + f2) - f15, f19 + (float)k, (f16 + (float)k) * f12 + f8, (f17 + (float)k) * f12 + f10);
                        tessellator.func_78374_a(f18 + (float)k, (f3 + f2) - f15, f19 + 0.0F, (f16 + (float)k) * f12 + f8, (f17 + 0.0F) * f12 + f10);
                        tessellator.func_78374_a(f18 + 0.0F, (f3 + f2) - f15, f19 + 0.0F, (f16 + 0.0F) * f12 + f8, (f17 + 0.0F) * f12 + f10);
                    }
                    tessellator.func_78369_a(f4 * 0.9F, f5 * 0.9F, f6 * 0.9F, 0.8F);
                    if(i1 > -1)
                    {
                        tessellator.func_78375_b(-1F, 0.0F, 0.0F);
                        for(int k1 = 0; k1 < k; k1++)
                        {
                            tessellator.func_78374_a(f18 + (float)k1 + 0.0F, f3 + 0.0F, f19 + (float)k, (f16 + (float)k1 + 0.5F) * f12 + f8, (f17 + (float)k) * f12 + f10);
                            tessellator.func_78374_a(f18 + (float)k1 + 0.0F, f3 + f2, f19 + (float)k, (f16 + (float)k1 + 0.5F) * f12 + f8, (f17 + (float)k) * f12 + f10);
                            tessellator.func_78374_a(f18 + (float)k1 + 0.0F, f3 + f2, f19 + 0.0F, (f16 + (float)k1 + 0.5F) * f12 + f8, (f17 + 0.0F) * f12 + f10);
                            tessellator.func_78374_a(f18 + (float)k1 + 0.0F, f3 + 0.0F, f19 + 0.0F, (f16 + (float)k1 + 0.5F) * f12 + f8, (f17 + 0.0F) * f12 + f10);
                        }

                    }
                    if(i1 <= 1)
                    {
                        tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
                        for(int l1 = 0; l1 < k; l1++)
                        {
                            tessellator.func_78374_a((f18 + (float)l1 + 1.0F) - f15, f3 + 0.0F, f19 + (float)k, (f16 + (float)l1 + 0.5F) * f12 + f8, (f17 + (float)k) * f12 + f10);
                            tessellator.func_78374_a((f18 + (float)l1 + 1.0F) - f15, f3 + f2, f19 + (float)k, (f16 + (float)l1 + 0.5F) * f12 + f8, (f17 + (float)k) * f12 + f10);
                            tessellator.func_78374_a((f18 + (float)l1 + 1.0F) - f15, f3 + f2, f19 + 0.0F, (f16 + (float)l1 + 0.5F) * f12 + f8, (f17 + 0.0F) * f12 + f10);
                            tessellator.func_78374_a((f18 + (float)l1 + 1.0F) - f15, f3 + 0.0F, f19 + 0.0F, (f16 + (float)l1 + 0.5F) * f12 + f8, (f17 + 0.0F) * f12 + f10);
                        }

                    }
                    tessellator.func_78369_a(f4 * 0.8F, f5 * 0.8F, f6 * 0.8F, 0.8F);
                    if(j1 > -1)
                    {
                        tessellator.func_78375_b(0.0F, 0.0F, -1F);
                        for(int i2 = 0; i2 < k; i2++)
                        {
                            tessellator.func_78374_a(f18 + 0.0F, f3 + f2, f19 + (float)i2 + 0.0F, (f16 + 0.0F) * f12 + f8, (f17 + (float)i2 + 0.5F) * f12 + f10);
                            tessellator.func_78374_a(f18 + (float)k, f3 + f2, f19 + (float)i2 + 0.0F, (f16 + (float)k) * f12 + f8, (f17 + (float)i2 + 0.5F) * f12 + f10);
                            tessellator.func_78374_a(f18 + (float)k, f3 + 0.0F, f19 + (float)i2 + 0.0F, (f16 + (float)k) * f12 + f8, (f17 + (float)i2 + 0.5F) * f12 + f10);
                            tessellator.func_78374_a(f18 + 0.0F, f3 + 0.0F, f19 + (float)i2 + 0.0F, (f16 + 0.0F) * f12 + f8, (f17 + (float)i2 + 0.5F) * f12 + f10);
                        }

                    }
                    if(j1 <= 1)
                    {
                        tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
                        for(int j2 = 0; j2 < k; j2++)
                        {
                            tessellator.func_78374_a(f18 + 0.0F, f3 + f2, (f19 + (float)j2 + 1.0F) - f15, (f16 + 0.0F) * f12 + f8, (f17 + (float)j2 + 0.5F) * f12 + f10);
                            tessellator.func_78374_a(f18 + (float)k, f3 + f2, (f19 + (float)j2 + 1.0F) - f15, (f16 + (float)k) * f12 + f8, (f17 + (float)j2 + 0.5F) * f12 + f10);
                            tessellator.func_78374_a(f18 + (float)k, f3 + 0.0F, (f19 + (float)j2 + 1.0F) - f15, (f16 + (float)k) * f12 + f8, (f17 + (float)j2 + 0.5F) * f12 + f10);
                            tessellator.func_78374_a(f18 + 0.0F, f3 + 0.0F, (f19 + (float)j2 + 1.0F) - f15, (f16 + 0.0F) * f12 + f8, (f17 + (float)j2 + 0.5F) * f12 + f10);
                        }

                    }
                    tessellator.func_78381_a();
                }

            }

        }

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(3042);
        GL11.glEnable(2884);
    }

    public boolean func_72716_a(EntityLiving p_72716_1_, boolean p_72716_2_)
    {
        byte byte0 = 2;
        RenderSorter rendersorter = new RenderSorter(p_72716_1_);
        WorldRenderer aworldrenderer[] = new WorldRenderer[byte0];
        ArrayList arraylist = null;
        int i = field_72767_j.size();
        int j = 0;
        field_72769_h.field_72984_F.func_76320_a("nearChunksSearch");
        for(int k = 0; k < i; k++)
        {
            WorldRenderer worldrenderer = (WorldRenderer)field_72767_j.get(k);
            if(worldrenderer == null)
            {
                continue;
            }
            if(!p_72716_2_)
            {
                if(worldrenderer.func_78912_a(p_72716_1_) > 256F)
                {
                    int l1;
                    for(l1 = 0; l1 < byte0 && (aworldrenderer[l1] == null || rendersorter.func_78944_a(aworldrenderer[l1], worldrenderer) <= 0); l1++) { }
                    if(--l1 <= 0)
                    {
                        continue;
                    }
                    for(int j2 = l1; --j2 != 0;)
                    {
                        aworldrenderer[j2 - 1] = aworldrenderer[j2];
                    }

                    aworldrenderer[l1] = worldrenderer;
                    continue;
                }
            } else
            if(!worldrenderer.field_78927_l)
            {
                continue;
            }
            if(arraylist == null)
            {
                arraylist = new ArrayList();
            }
            j++;
            arraylist.add(worldrenderer);
            field_72767_j.set(k, null);
        }

        field_72769_h.field_72984_F.func_76319_b();
        field_72769_h.field_72984_F.func_76320_a("sort");
        if(arraylist != null)
        {
            if(arraylist.size() > 1)
            {
                Collections.sort(arraylist, rendersorter);
            }
            for(int l = arraylist.size() - 1; l >= 0; l--)
            {
                WorldRenderer worldrenderer1 = (WorldRenderer)arraylist.get(l);
                worldrenderer1.func_78907_a();
                worldrenderer1.field_78939_q = false;
            }

        }
        field_72769_h.field_72984_F.func_76319_b();
        int i1 = 0;
        field_72769_h.field_72984_F.func_76320_a("rebuild");
        for(int j1 = byte0 - 1; j1 >= 0; j1--)
        {
            WorldRenderer worldrenderer2 = aworldrenderer[j1];
            if(worldrenderer2 == null)
            {
                continue;
            }
            if(!worldrenderer2.field_78927_l && j1 != byte0 - 1)
            {
                aworldrenderer[j1] = null;
                aworldrenderer[0] = null;
                break;
            }
            aworldrenderer[j1].func_78907_a();
            aworldrenderer[j1].field_78939_q = false;
            i1++;
        }

        field_72769_h.field_72984_F.func_76319_b();
        field_72769_h.field_72984_F.func_76320_a("cleanup");
        int k1 = 0;
        int i2 = 0;
        for(int k2 = field_72767_j.size(); k1 != k2; k1++)
        {
            WorldRenderer worldrenderer3 = (WorldRenderer)field_72767_j.get(k1);
            if(worldrenderer3 == null)
            {
                continue;
            }
            boolean flag = false;
            for(int l2 = 0; l2 < byte0 && !flag; l2++)
            {
                if(worldrenderer3 == aworldrenderer[l2])
                {
                    flag = true;
                }
            }

            if(flag)
            {
                continue;
            }
            if(i2 != k1)
            {
                field_72767_j.set(i2, worldrenderer3);
            }
            i2++;
        }

        field_72769_h.field_72984_F.func_76319_b();
        field_72769_h.field_72984_F.func_76320_a("trim");
        while(--k1 >= i2) 
        {
            field_72767_j.remove(k1);
        }
        field_72769_h.field_72984_F.func_76319_b();
        return i == j + i1;
    }

    public void func_72727_a(EntityPlayer p_72727_1_, MovingObjectPosition p_72727_2_, int p_72727_3_, ItemStack p_72727_4_, float p_72727_5_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        GL11.glEnable(3042);
        GL11.glEnable(3008);
        GL11.glBlendFunc(770, 1);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, (MathHelper.func_76126_a((float)Minecraft.func_71386_F() / 100F) * 0.2F + 0.4F) * 0.5F);
        if(p_72727_3_ != 0 && p_72727_4_ != null)
        {
            GL11.glBlendFunc(770, 771);
            float f = MathHelper.func_76126_a((float)Minecraft.func_71386_F() / 100F) * 0.2F + 0.8F;
            GL11.glColor4f(f, f, f, MathHelper.func_76126_a((float)Minecraft.func_71386_F() / 200F) * 0.2F + 0.5F);
            int i = field_72770_i.func_78341_b("/terrain.png");
            GL11.glBindTexture(3553, i);
        }
        GL11.glDisable(3042);
        GL11.glDisable(3008);
    }

    public void func_72717_a(Tessellator p_72717_1_, EntityPlayer p_72717_2_, float p_72717_3_)
    {
        double d = p_72717_2_.field_70142_S + (p_72717_2_.field_70165_t - p_72717_2_.field_70142_S) * (double)p_72717_3_;
        double d1 = p_72717_2_.field_70137_T + (p_72717_2_.field_70163_u - p_72717_2_.field_70137_T) * (double)p_72717_3_;
        double d2 = p_72717_2_.field_70136_U + (p_72717_2_.field_70161_v - p_72717_2_.field_70136_U) * (double)p_72717_3_;
        if(!field_72738_E.isEmpty())
        {
            GL11.glBlendFunc(774, 768);
            int i = field_72770_i.func_78341_b("/terrain.png");
            GL11.glBindTexture(3553, i);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.5F);
            GL11.glPushMatrix();
            GL11.glDisable(3008);
            GL11.glPolygonOffset(-3F, -3F);
            GL11.glEnable(32823);
            GL11.glEnable(3008);
            p_72717_1_.func_78382_b();
            p_72717_1_.func_78373_b(-d, -d1, -d2);
            p_72717_1_.func_78383_c();
            for(Iterator iterator = field_72738_E.values().iterator(); iterator.hasNext();)
            {
                DestroyBlockProgress destroyblockprogress = (DestroyBlockProgress)iterator.next();
                double d3 = (double)destroyblockprogress.func_73110_b() - d;
                double d4 = (double)destroyblockprogress.func_73109_c() - d1;
                double d5 = (double)destroyblockprogress.func_73108_d() - d2;
                if(d3 * d3 + d4 * d4 + d5 * d5 > 1024D)
                {
                    iterator.remove();
                } else
                {
                    int j = field_72769_h.func_72798_a(destroyblockprogress.func_73110_b(), destroyblockprogress.func_73109_c(), destroyblockprogress.func_73108_d());
                    Block block = j <= 0 ? null : Block.field_71973_m[j];
                    if(block == null)
                    {
                        block = Block.field_71981_t;
                    }
                    field_72776_r.func_78604_a(block, destroyblockprogress.func_73110_b(), destroyblockprogress.func_73109_c(), destroyblockprogress.func_73108_d(), 240 + destroyblockprogress.func_73106_e());
                }
            }

            p_72717_1_.func_78381_a();
            p_72717_1_.func_78373_b(0.0D, 0.0D, 0.0D);
            GL11.glDisable(3008);
            GL11.glPolygonOffset(0.0F, 0.0F);
            GL11.glDisable(32823);
            GL11.glEnable(3008);
            GL11.glDepthMask(true);
            GL11.glPopMatrix();
        }
    }

    public void func_72731_b(EntityPlayer p_72731_1_, MovingObjectPosition p_72731_2_, int p_72731_3_, ItemStack p_72731_4_, float p_72731_5_)
    {
        if(p_72731_3_ == 0 && p_72731_2_.field_72313_a == EnumMovingObjectType.TILE)
        {
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glColor4f(0.0F, 0.0F, 0.0F, 0.4F);
            GL11.glLineWidth(2.0F);
            GL11.glDisable(3553);
            GL11.glDepthMask(false);
            float f = 0.002F;
            int i = field_72769_h.func_72798_a(p_72731_2_.field_72311_b, p_72731_2_.field_72312_c, p_72731_2_.field_72309_d);
            if(i > 0)
            {
                Block.field_71973_m[i].func_71902_a(field_72769_h, p_72731_2_.field_72311_b, p_72731_2_.field_72312_c, p_72731_2_.field_72309_d);
                double d = p_72731_1_.field_70142_S + (p_72731_1_.field_70165_t - p_72731_1_.field_70142_S) * (double)p_72731_5_;
                double d1 = p_72731_1_.field_70137_T + (p_72731_1_.field_70163_u - p_72731_1_.field_70137_T) * (double)p_72731_5_;
                double d2 = p_72731_1_.field_70136_U + (p_72731_1_.field_70161_v - p_72731_1_.field_70136_U) * (double)p_72731_5_;
                func_72715_a(Block.field_71973_m[i].func_71911_a_(field_72769_h, p_72731_2_.field_72311_b, p_72731_2_.field_72312_c, p_72731_2_.field_72309_d).func_72314_b(f, f, f).func_72325_c(-d, -d1, -d2));
            }
            GL11.glDepthMask(true);
            GL11.glEnable(3553);
            GL11.glDisable(3042);
        }
    }

    private void func_72715_a(AxisAlignedBB p_72715_1_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78371_b(3);
        tessellator.func_78377_a(p_72715_1_.field_72340_a, p_72715_1_.field_72338_b, p_72715_1_.field_72339_c);
        tessellator.func_78377_a(p_72715_1_.field_72336_d, p_72715_1_.field_72338_b, p_72715_1_.field_72339_c);
        tessellator.func_78377_a(p_72715_1_.field_72336_d, p_72715_1_.field_72338_b, p_72715_1_.field_72334_f);
        tessellator.func_78377_a(p_72715_1_.field_72340_a, p_72715_1_.field_72338_b, p_72715_1_.field_72334_f);
        tessellator.func_78377_a(p_72715_1_.field_72340_a, p_72715_1_.field_72338_b, p_72715_1_.field_72339_c);
        tessellator.func_78381_a();
        tessellator.func_78371_b(3);
        tessellator.func_78377_a(p_72715_1_.field_72340_a, p_72715_1_.field_72337_e, p_72715_1_.field_72339_c);
        tessellator.func_78377_a(p_72715_1_.field_72336_d, p_72715_1_.field_72337_e, p_72715_1_.field_72339_c);
        tessellator.func_78377_a(p_72715_1_.field_72336_d, p_72715_1_.field_72337_e, p_72715_1_.field_72334_f);
        tessellator.func_78377_a(p_72715_1_.field_72340_a, p_72715_1_.field_72337_e, p_72715_1_.field_72334_f);
        tessellator.func_78377_a(p_72715_1_.field_72340_a, p_72715_1_.field_72337_e, p_72715_1_.field_72339_c);
        tessellator.func_78381_a();
        tessellator.func_78371_b(1);
        tessellator.func_78377_a(p_72715_1_.field_72340_a, p_72715_1_.field_72338_b, p_72715_1_.field_72339_c);
        tessellator.func_78377_a(p_72715_1_.field_72340_a, p_72715_1_.field_72337_e, p_72715_1_.field_72339_c);
        tessellator.func_78377_a(p_72715_1_.field_72336_d, p_72715_1_.field_72338_b, p_72715_1_.field_72339_c);
        tessellator.func_78377_a(p_72715_1_.field_72336_d, p_72715_1_.field_72337_e, p_72715_1_.field_72339_c);
        tessellator.func_78377_a(p_72715_1_.field_72336_d, p_72715_1_.field_72338_b, p_72715_1_.field_72334_f);
        tessellator.func_78377_a(p_72715_1_.field_72336_d, p_72715_1_.field_72337_e, p_72715_1_.field_72334_f);
        tessellator.func_78377_a(p_72715_1_.field_72340_a, p_72715_1_.field_72338_b, p_72715_1_.field_72334_f);
        tessellator.func_78377_a(p_72715_1_.field_72340_a, p_72715_1_.field_72337_e, p_72715_1_.field_72334_f);
        tessellator.func_78381_a();
    }

    public void func_72725_b(int p_72725_1_, int p_72725_2_, int p_72725_3_, int p_72725_4_, int p_72725_5_, int p_72725_6_)
    {
        int i = MathHelper.func_76137_a(p_72725_1_, 16);
        int j = MathHelper.func_76137_a(p_72725_2_, 16);
        int k = MathHelper.func_76137_a(p_72725_3_, 16);
        int l = MathHelper.func_76137_a(p_72725_4_, 16);
        int i1 = MathHelper.func_76137_a(p_72725_5_, 16);
        int j1 = MathHelper.func_76137_a(p_72725_6_, 16);
        for(int k1 = i; k1 <= l; k1++)
        {
            int l1 = k1 % field_72766_m;
            if(l1 < 0)
            {
                l1 += field_72766_m;
            }
            for(int i2 = j; i2 <= i1; i2++)
            {
                int j2 = i2 % field_72763_n;
                if(j2 < 0)
                {
                    j2 += field_72763_n;
                }
                for(int k2 = k; k2 <= j1; k2++)
                {
                    int l2 = k2 % field_72764_o;
                    if(l2 < 0)
                    {
                        l2 += field_72764_o;
                    }
                    int i3 = (l2 * field_72763_n + j2) * field_72766_m + l1;
                    WorldRenderer worldrenderer = field_72765_l[i3];
                    if(worldrenderer != null && !worldrenderer.field_78939_q)
                    {
                        field_72767_j.add(worldrenderer);
                        worldrenderer.func_78914_f();
                    }
                }

            }

        }

    }

    public void func_72710_a(int p_72710_1_, int p_72710_2_, int p_72710_3_)
    {
        func_72725_b(p_72710_1_ - 1, p_72710_2_ - 1, p_72710_3_ - 1, p_72710_1_ + 1, p_72710_2_ + 1, p_72710_3_ + 1);
    }

    public void func_72711_b(int p_72711_1_, int p_72711_2_, int p_72711_3_)
    {
        func_72725_b(p_72711_1_ - 1, p_72711_2_ - 1, p_72711_3_ - 1, p_72711_1_ + 1, p_72711_2_ + 1, p_72711_3_ + 1);
    }

    public void func_72707_a(int p_72707_1_, int p_72707_2_, int p_72707_3_, int p_72707_4_, int p_72707_5_, int p_72707_6_)
    {
        func_72725_b(p_72707_1_ - 1, p_72707_2_ - 1, p_72707_3_ - 1, p_72707_4_ + 1, p_72707_5_ + 1, p_72707_6_ + 1);
    }

    public void func_72729_a(ICamera p_72729_1_, float p_72729_2_)
    {
        for(int i = 0; i < field_72765_l.length; i++)
        {
            if(!field_72765_l[i].func_78906_e() && (!field_72765_l[i].field_78927_l || (i + field_72757_g & 0xf) == 0))
            {
                field_72765_l[i].func_78908_a(p_72729_1_);
            }
        }

        field_72757_g++;
    }

    public void func_72702_a(String p_72702_1_, int p_72702_2_, int p_72702_3_, int p_72702_4_)
    {
        if(p_72702_1_ != null)
        {
            field_72777_q.field_71456_v.func_73833_a((new StringBuilder()).append("C418 - ").append(p_72702_1_).toString());
        }
        field_72777_q.field_71416_A.func_77368_a(p_72702_1_, p_72702_2_, p_72702_3_, p_72702_4_, 1.0F, 1.0F);
    }

    public void func_72704_a(String s, double d, double d1, double d2, 
            float f, float f1)
    {
    }

    public void func_72708_a(String p_72708_1_, double p_72708_2_, double p_72708_4_, double p_72708_6_, 
            double p_72708_8_, double p_72708_10_, double p_72708_12_)
    {
        func_72726_b(p_72708_1_, p_72708_2_, p_72708_4_, p_72708_6_, p_72708_8_, p_72708_10_, p_72708_12_);
    }

    public EntityFX func_72726_b(String p_72726_1_, double p_72726_2_, double p_72726_4_, double p_72726_6_, 
            double p_72726_8_, double p_72726_10_, double p_72726_12_)
    {
        if(field_72777_q == null || field_72777_q.field_71451_h == null || field_72777_q.field_71452_i == null)
        {
            return null;
        }
        int i = field_72777_q.field_71474_y.field_74362_aa;
        if(i == 1 && field_72769_h.field_73012_v.nextInt(3) == 0)
        {
            i = 2;
        }
        double d = field_72777_q.field_71451_h.field_70165_t - p_72726_2_;
        double d1 = field_72777_q.field_71451_h.field_70163_u - p_72726_4_;
        double d2 = field_72777_q.field_71451_h.field_70161_v - p_72726_6_;
        Object obj = null;
        if(p_72726_1_.equals("hugeexplosion"))
        {
            field_72777_q.field_71452_i.func_78873_a(((EntityFX) (obj = new EntityHugeExplodeFX(field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_))));
        } else
        if(p_72726_1_.equals("largeexplode"))
        {
            field_72777_q.field_71452_i.func_78873_a(((EntityFX) (obj = new EntityLargeExplodeFX(field_72770_i, field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_))));
        }
        if(obj != null)
        {
            return ((EntityFX) (obj));
        }
        double d3 = 16D;
        if(d * d + d1 * d1 + d2 * d2 > d3 * d3)
        {
            return null;
        }
        if(i > 1)
        {
            return null;
        }
        if(p_72726_1_.equals("bubble"))
        {
            obj = new EntityBubbleFX(field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        } else
        if(p_72726_1_.equals("suspended"))
        {
            obj = new EntitySuspendFX(field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        } else
        if(p_72726_1_.equals("depthsuspend"))
        {
            obj = new EntityAuraFX(field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        } else
        if(p_72726_1_.equals("townaura"))
        {
            obj = new EntityAuraFX(field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        } else
        if(p_72726_1_.equals("crit"))
        {
            obj = new EntityCritFX(field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        } else
        if(p_72726_1_.equals("magicCrit"))
        {
            obj = new EntityCritFX(field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
            ((EntityFX) (obj)).func_70538_b(((EntityFX) (obj)).func_70534_d() * 0.3F, ((EntityFX) (obj)).func_70542_f() * 0.8F, ((EntityFX) (obj)).func_70535_g());
            ((EntityFX) (obj)).func_70536_a(((EntityFX) (obj)).func_70540_h() + 1);
        } else
        if(p_72726_1_.equals("smoke"))
        {
            obj = new EntitySmokeFX(field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        } else
        if(p_72726_1_.equals("mobSpell"))
        {
            obj = new EntitySpellParticleFX(field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, 0.0D, 0.0D, 0.0D);
            ((EntityFX) (obj)).func_70538_b((float)p_72726_8_, (float)p_72726_10_, (float)p_72726_12_);
        } else
        if(p_72726_1_.equals("spell"))
        {
            obj = new EntitySpellParticleFX(field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        } else
        if(p_72726_1_.equals("instantSpell"))
        {
            obj = new EntitySpellParticleFX(field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
            ((EntitySpellParticleFX)obj).func_70589_b(144);
        } else
        if(p_72726_1_.equals("note"))
        {
            obj = new EntityNoteFX(field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        } else
        if(p_72726_1_.equals("portal"))
        {
            obj = new EntityPortalFX(field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        } else
        if(p_72726_1_.equals("enchantmenttable"))
        {
            obj = new EntityEnchantmentTableParticleFX(field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        } else
        if(p_72726_1_.equals("explode"))
        {
            obj = new EntityExplodeFX(field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        } else
        if(p_72726_1_.equals("flame"))
        {
            obj = new EntityFlameFX(field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        } else
        if(p_72726_1_.equals("lava"))
        {
            obj = new EntityLavaFX(field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_);
        } else
        if(p_72726_1_.equals("footstep"))
        {
            obj = new EntityFootStepFX(field_72770_i, field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_);
        } else
        if(p_72726_1_.equals("splash"))
        {
            obj = new EntitySplashFX(field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        } else
        if(p_72726_1_.equals("largesmoke"))
        {
            obj = new EntitySmokeFX(field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, 2.5F);
        } else
        if(p_72726_1_.equals("cloud"))
        {
            obj = new EntityCloudFX(field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        } else
        if(p_72726_1_.equals("reddust"))
        {
            obj = new EntityReddustFX(field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, (float)p_72726_8_, (float)p_72726_10_, (float)p_72726_12_);
        } else
        if(p_72726_1_.equals("snowballpoof"))
        {
            obj = new EntityBreakingFX(field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, Item.field_77768_aD);
        } else
        if(p_72726_1_.equals("dripWater"))
        {
            obj = new EntityDropParticleFX(field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, Material.field_76244_g);
        } else
        if(p_72726_1_.equals("dripLava"))
        {
            obj = new EntityDropParticleFX(field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, Material.field_76256_h);
        } else
        if(p_72726_1_.equals("snowshovel"))
        {
            obj = new EntitySnowShovelFX(field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        } else
        if(p_72726_1_.equals("slime"))
        {
            obj = new EntityBreakingFX(field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, Item.field_77761_aM);
        } else
        if(p_72726_1_.equals("heart"))
        {
            obj = new EntityHeartFX(field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        } else
        if(p_72726_1_.startsWith("iconcrack_"))
        {
            int j = Integer.parseInt(p_72726_1_.substring(p_72726_1_.indexOf("_") + 1));
            obj = new EntityBreakingFX(field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, Item.field_77698_e[j]);
        } else
        if(p_72726_1_.startsWith("tilecrack_"))
        {
            int k = Integer.parseInt(p_72726_1_.substring(p_72726_1_.indexOf("_") + 1));
            obj = new EntityDiggingFX(field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, Block.field_71973_m[k], 0, 0);
        }
        if(obj != null)
        {
            field_72777_q.field_71452_i.func_78873_a(((EntityFX) (obj)));
        }
        return ((EntityFX) (obj));
    }

    public void func_72703_a(Entity p_72703_1_)
    {
        p_72703_1_.func_70059_ac();
        if(p_72703_1_.field_70120_cr != null)
        {
            field_72770_i.func_78356_a(p_72703_1_.field_70120_cr, new ImageBufferDownload());
        }
        if(p_72703_1_.field_70119_cs != null)
        {
            field_72770_i.func_78356_a(p_72703_1_.field_70119_cs, new ImageBufferDownload());
        }
    }

    public void func_72709_b(Entity p_72709_1_)
    {
        if(p_72709_1_.field_70120_cr != null)
        {
            field_72770_i.func_78347_c(p_72709_1_.field_70120_cr);
        }
        if(p_72709_1_.field_70119_cs != null)
        {
            field_72770_i.func_78347_c(p_72709_1_.field_70119_cs);
        }
    }

    public void func_72728_f()
    {
        GLAllocation.func_74523_b(field_72778_p);
    }

    public void func_72706_a(EntityPlayer p_72706_1_, int p_72706_2_, int p_72706_3_, int p_72706_4_, int p_72706_5_, int p_72706_6_)
    {
        Random random = field_72769_h.field_73012_v;
        switch(p_72706_2_)
        {
        default:
            break;

        case 1001: 
            field_72769_h.func_72980_b(p_72706_3_, p_72706_4_, p_72706_5_, "random.click", 1.0F, 1.2F);
            break;

        case 1000: 
            field_72769_h.func_72980_b(p_72706_3_, p_72706_4_, p_72706_5_, "random.click", 1.0F, 1.0F);
            break;

        case 1002: 
            field_72769_h.func_72980_b(p_72706_3_, p_72706_4_, p_72706_5_, "random.bow", 1.0F, 1.2F);
            break;

        case 2000: 
            int i = p_72706_6_ % 3 - 1;
            int j = (p_72706_6_ / 3) % 3 - 1;
            double d2 = (double)p_72706_3_ + (double)i * 0.59999999999999998D + 0.5D;
            double d5 = (double)p_72706_4_ + 0.5D;
            double d8 = (double)p_72706_5_ + (double)j * 0.59999999999999998D + 0.5D;
            for(int j1 = 0; j1 < 10; j1++)
            {
                double d10 = random.nextDouble() * 0.20000000000000001D + 0.01D;
                double d11 = d2 + (double)i * 0.01D + (random.nextDouble() - 0.5D) * (double)j * 0.5D;
                double d12 = d5 + (random.nextDouble() - 0.5D) * 0.5D;
                double d15 = d8 + (double)j * 0.01D + (random.nextDouble() - 0.5D) * (double)i * 0.5D;
                double d18 = (double)i * d10 + random.nextGaussian() * 0.01D;
                double d21 = -0.029999999999999999D + random.nextGaussian() * 0.01D;
                double d23 = (double)j * d10 + random.nextGaussian() * 0.01D;
                func_72708_a("smoke", d11, d12, d15, d18, d21, d23);
            }

            break;

        case 2003: 
            double d = (double)p_72706_3_ + 0.5D;
            double d3 = p_72706_4_;
            double d6 = (double)p_72706_5_ + 0.5D;
            String s = (new StringBuilder()).append("iconcrack_").append(Item.field_77748_bA.field_77779_bT).toString();
            for(int k = 0; k < 8; k++)
            {
                func_72708_a(s, d, d3, d6, random.nextGaussian() * 0.14999999999999999D, random.nextDouble() * 0.20000000000000001D, random.nextGaussian() * 0.14999999999999999D);
            }

            for(double d9 = 0.0D; d9 < 6.2831853071795862D; d9 += 0.15707963267948966D)
            {
                func_72708_a("portal", d + Math.cos(d9) * 5D, d3 - 0.40000000000000002D, d6 + Math.sin(d9) * 5D, Math.cos(d9) * -5D, 0.0D, Math.sin(d9) * -5D);
                func_72708_a("portal", d + Math.cos(d9) * 5D, d3 - 0.40000000000000002D, d6 + Math.sin(d9) * 5D, Math.cos(d9) * -7D, 0.0D, Math.sin(d9) * -7D);
            }

            break;

        case 2002: 
            double d1 = p_72706_3_;
            double d4 = p_72706_4_;
            double d7 = p_72706_5_;
            String s1 = (new StringBuilder()).append("iconcrack_").append(Item.field_77726_bs.field_77779_bT).toString();
            for(int l = 0; l < 8; l++)
            {
                func_72708_a(s1, d1, d4, d7, random.nextGaussian() * 0.14999999999999999D, random.nextDouble() * 0.20000000000000001D, random.nextGaussian() * 0.14999999999999999D);
            }

            int i1 = Item.field_77726_bs.func_77620_a(p_72706_6_, 0);
            float f = (float)(i1 >> 16 & 0xff) / 255F;
            float f1 = (float)(i1 >> 8 & 0xff) / 255F;
            float f2 = (float)(i1 >> 0 & 0xff) / 255F;
            String s2 = "spell";
            if(Item.field_77726_bs.func_77833_h(p_72706_6_))
            {
                s2 = "instantSpell";
            }
            for(int k1 = 0; k1 < 100; k1++)
            {
                double d13 = random.nextDouble() * 4D;
                double d16 = random.nextDouble() * 3.1415926535897931D * 2D;
                double d19 = Math.cos(d16) * d13;
                double d22 = 0.01D + random.nextDouble() * 0.5D;
                double d24 = Math.sin(d16) * d13;
                EntityFX entityfx = func_72726_b(s2, d1 + d19 * 0.10000000000000001D, d4 + 0.29999999999999999D, d7 + d24 * 0.10000000000000001D, d19, d22, d24);
                if(entityfx != null)
                {
                    float f3 = 0.75F + random.nextFloat() * 0.25F;
                    entityfx.func_70538_b(f * f3, f1 * f3, f2 * f3);
                    entityfx.func_70543_e((float)d13);
                }
            }

            field_72769_h.func_72980_b((double)p_72706_3_ + 0.5D, (double)p_72706_4_ + 0.5D, (double)p_72706_5_ + 0.5D, "random.glass", 1.0F, field_72769_h.field_73012_v.nextFloat() * 0.1F + 0.9F);
            break;

        case 2001: 
            int l1 = p_72706_6_ & 0xfff;
            if(l1 > 0)
            {
                Block block = Block.field_71973_m[l1];
                field_72777_q.field_71416_A.func_77364_b(block.field_72020_cn.func_72676_a(), (float)p_72706_3_ + 0.5F, (float)p_72706_4_ + 0.5F, (float)p_72706_5_ + 0.5F, (block.field_72020_cn.func_72677_b() + 1.0F) / 2.0F, block.field_72020_cn.func_72678_c() * 0.8F);
            }
            field_72777_q.field_71452_i.func_78871_a(p_72706_3_, p_72706_4_, p_72706_5_, p_72706_6_ & 0xfff, p_72706_6_ >> 12 & 0xff);
            break;

        case 2004: 
            for(int i2 = 0; i2 < 20; i2++)
            {
                double d14 = (double)p_72706_3_ + 0.5D + ((double)field_72769_h.field_73012_v.nextFloat() - 0.5D) * 2D;
                double d17 = (double)p_72706_4_ + 0.5D + ((double)field_72769_h.field_73012_v.nextFloat() - 0.5D) * 2D;
                double d20 = (double)p_72706_5_ + 0.5D + ((double)field_72769_h.field_73012_v.nextFloat() - 0.5D) * 2D;
                field_72769_h.func_72869_a("smoke", d14, d17, d20, 0.0D, 0.0D, 0.0D);
                field_72769_h.func_72869_a("flame", d14, d17, d20, 0.0D, 0.0D, 0.0D);
            }

            break;

        case 1003: 
            if(Math.random() < 0.5D)
            {
                field_72769_h.func_72980_b((double)p_72706_3_ + 0.5D, (double)p_72706_4_ + 0.5D, (double)p_72706_5_ + 0.5D, "random.door_open", 1.0F, field_72769_h.field_73012_v.nextFloat() * 0.1F + 0.9F);
            } else
            {
                field_72769_h.func_72980_b((double)p_72706_3_ + 0.5D, (double)p_72706_4_ + 0.5D, (double)p_72706_5_ + 0.5D, "random.door_close", 1.0F, field_72769_h.field_73012_v.nextFloat() * 0.1F + 0.9F);
            }
            break;

        case 1004: 
            field_72769_h.func_72980_b((float)p_72706_3_ + 0.5F, (float)p_72706_4_ + 0.5F, (float)p_72706_5_ + 0.5F, "random.fizz", 0.5F, 2.6F + (random.nextFloat() - random.nextFloat()) * 0.8F);
            break;

        case 1005: 
            if(Item.field_77698_e[p_72706_6_] instanceof ItemRecord)
            {
                field_72769_h.func_72934_a(((ItemRecord)Item.field_77698_e[p_72706_6_]).field_77837_a, p_72706_3_, p_72706_4_, p_72706_5_);
            } else
            {
                field_72769_h.func_72934_a(null, p_72706_3_, p_72706_4_, p_72706_5_);
            }
            break;

        case 1007: 
            field_72769_h.func_72980_b((double)p_72706_3_ + 0.5D, (double)p_72706_4_ + 0.5D, (double)p_72706_5_ + 0.5D, "mob.ghast.charge", 10F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F);
            break;

        case 1008: 
            field_72769_h.func_72980_b((double)p_72706_3_ + 0.5D, (double)p_72706_4_ + 0.5D, (double)p_72706_5_ + 0.5D, "mob.ghast.fireball", 10F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F);
            break;

        case 1010: 
            field_72769_h.func_72980_b((double)p_72706_3_ + 0.5D, (double)p_72706_4_ + 0.5D, (double)p_72706_5_ + 0.5D, "mob.zombie.wood", 2.0F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F);
            break;

        case 1012: 
            field_72769_h.func_72980_b((double)p_72706_3_ + 0.5D, (double)p_72706_4_ + 0.5D, (double)p_72706_5_ + 0.5D, "mob.zombie.woodbreak", 2.0F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F);
            break;

        case 1011: 
            field_72769_h.func_72980_b((double)p_72706_3_ + 0.5D, (double)p_72706_4_ + 0.5D, (double)p_72706_5_ + 0.5D, "mob.zombie.metal", 2.0F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F);
            break;
        }
    }

    public void func_72705_a(int p_72705_1_, int p_72705_2_, int p_72705_3_, int p_72705_4_, int p_72705_5_)
    {
        if(p_72705_5_ < 0 || p_72705_5_ >= 10)
        {
            field_72738_E.remove(Integer.valueOf(p_72705_1_));
        } else
        {
            DestroyBlockProgress destroyblockprogress = (DestroyBlockProgress)field_72738_E.get(Integer.valueOf(p_72705_1_));
            if(destroyblockprogress == null || destroyblockprogress.func_73110_b() != p_72705_2_ || destroyblockprogress.func_73109_c() != p_72705_3_ || destroyblockprogress.func_73108_d() != p_72705_4_)
            {
                destroyblockprogress = new DestroyBlockProgress(p_72705_1_, p_72705_2_, p_72705_3_, p_72705_4_);
                field_72738_E.put(Integer.valueOf(p_72705_1_), destroyblockprogress);
            }
            destroyblockprogress.func_73107_a(p_72705_5_);
        }
    }
}
