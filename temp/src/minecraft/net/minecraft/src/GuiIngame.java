// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.awt.Color;
import java.util.Random;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Gui, GuiNewChat, ScaledResolution, EntityRenderer, 
//            EntityClientPlayerMP, InventoryPlayer, GameSettings, ItemStack, 
//            Block, Potion, PlayerControllerMP, RenderEngine, 
//            FoodStats, Profiler, WorldClient, WorldInfo, 
//            Material, MathHelper, RenderHelper, FontRenderer, 
//            StatCollector, StringUtils, AxisAlignedBB, Chunk, 
//            BiomeGenBase, EnumSkyBlock, PlayerCapabilities, KeyBinding, 
//            NetClientHandler, GuiPlayerInfo, RenderDragon, EntityDragon, 
//            Tessellator, BlockPortal, RenderItem

public class GuiIngame extends Gui
{

    private static final RenderItem field_73841_b = new RenderItem();
    private final Random field_73842_c = new Random();
    private final Minecraft field_73839_d;
    private final GuiNewChat field_73840_e;
    private int field_73837_f;
    private String field_73838_g;
    private int field_73845_h;
    private boolean field_73844_j;
    public float field_73843_a;

    public GuiIngame(Minecraft p_i3037_1_)
    {
        field_73837_f = 0;
        field_73838_g = "";
        field_73845_h = 0;
        field_73844_j = false;
        field_73843_a = 1.0F;
        field_73839_d = p_i3037_1_;
        field_73840_e = new GuiNewChat(p_i3037_1_);
    }

    public void func_73830_a(float p_73830_1_, boolean p_73830_2_, int p_73830_3_, int p_73830_4_)
    {
        ScaledResolution scaledresolution = new ScaledResolution(field_73839_d.field_71474_y, field_73839_d.field_71443_c, field_73839_d.field_71440_d);
        int i = scaledresolution.func_78326_a();
        int j = scaledresolution.func_78328_b();
        FontRenderer fontrenderer = field_73839_d.field_71466_p;
        field_73839_d.field_71460_t.func_78478_c();
        GL11.glEnable(3042);
        if(Minecraft.func_71375_t())
        {
            func_73829_a(field_73839_d.field_71439_g.func_70013_c(p_73830_1_), i, j);
        } else
        {
            GL11.glBlendFunc(770, 771);
        }
        ItemStack itemstack = field_73839_d.field_71439_g.field_71071_by.func_70440_f(3);
        if(field_73839_d.field_71474_y.field_74320_O == 0 && itemstack != null && itemstack.field_77993_c == Block.field_72061_ba.field_71990_ca)
        {
            func_73836_a(i, j);
        }
        if(!field_73839_d.field_71439_g.func_70644_a(Potion.field_76431_k))
        {
            float f = field_73839_d.field_71439_g.field_71080_cy + (field_73839_d.field_71439_g.field_71086_bY - field_73839_d.field_71439_g.field_71080_cy) * p_73830_1_;
            if(f > 0.0F)
            {
                func_73835_b(f, i, j);
            }
        }
        if(!field_73839_d.field_71442_b.func_78747_a())
        {
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glBindTexture(3553, field_73839_d.field_71446_o.func_78341_b("/gui/gui.png"));
            InventoryPlayer inventoryplayer = field_73839_d.field_71439_g.field_71071_by;
            field_73735_i = -90F;
            func_73729_b(i / 2 - 91, j - 22, 0, 0, 182, 22);
            func_73729_b((i / 2 - 91 - 1) + inventoryplayer.field_70461_c * 20, j - 22 - 1, 0, 22, 24, 22);
            GL11.glBindTexture(3553, field_73839_d.field_71446_o.func_78341_b("/gui/icons.png"));
            GL11.glEnable(3042);
            GL11.glBlendFunc(775, 769);
            func_73729_b(i / 2 - 7, j / 2 - 7, 0, 0, 16, 16);
            GL11.glDisable(3042);
            boolean flag = (field_73839_d.field_71439_g.field_70172_ad / 3) % 2 == 1;
            if(field_73839_d.field_71439_g.field_70172_ad < 10)
            {
                flag = false;
            }
            int i1 = field_73839_d.field_71439_g.func_70630_aN();
            int j2 = field_73839_d.field_71439_g.field_70735_aL;
            field_73842_c.setSeed(field_73837_f * 0x4c627);
            boolean flag2 = false;
            FoodStats foodstats = field_73839_d.field_71439_g.func_71024_bL();
            int j4 = foodstats.func_75116_a();
            int i5 = foodstats.func_75120_b();
            field_73839_d.field_71424_I.func_76320_a("bossHealth");
            func_73828_d();
            field_73839_d.field_71424_I.func_76319_b();
            if(field_73839_d.field_71442_b.func_78755_b())
            {
                int k5 = i / 2 - 91;
                int j6 = i / 2 + 91;
                field_73839_d.field_71424_I.func_76320_a("expBar");
                int i7 = field_73839_d.field_71439_g.func_71050_bK();
                if(i7 > 0)
                {
                    char c = '\266';
                    int k8 = (int)(field_73839_d.field_71439_g.field_71106_cc * (float)(c + 1));
                    int j9 = (j - 32) + 3;
                    func_73729_b(k5, j9, 0, 64, c, 5);
                    if(k8 > 0)
                    {
                        func_73729_b(k5, j9, 0, 69, k8, 5);
                    }
                }
                int l7 = j - 39;
                int l8 = l7 - 10;
                int k9 = field_73839_d.field_71439_g.func_70658_aO();
                int j10 = -1;
                if(field_73839_d.field_71439_g.func_70644_a(Potion.field_76428_l))
                {
                    j10 = field_73837_f % 25;
                }
                field_73839_d.field_71424_I.func_76318_c("healthArmor");
                for(int k10 = 0; k10 < 10; k10++)
                {
                    if(k9 > 0)
                    {
                        int j11 = k5 + k10 * 8;
                        if(k10 * 2 + 1 < k9)
                        {
                            func_73729_b(j11, l8, 34, 9, 9, 9);
                        }
                        if(k10 * 2 + 1 == k9)
                        {
                            func_73729_b(j11, l8, 25, 9, 9, 9);
                        }
                        if(k10 * 2 + 1 > k9)
                        {
                            func_73729_b(j11, l8, 16, 9, 9, 9);
                        }
                    }
                    int k11 = 16;
                    if(field_73839_d.field_71439_g.func_70644_a(Potion.field_76436_u))
                    {
                        k11 += 36;
                    }
                    int j12 = 0;
                    if(flag)
                    {
                        j12 = 1;
                    }
                    int i13 = k5 + k10 * 8;
                    int k13 = l7;
                    if(i1 <= 4)
                    {
                        k13 += field_73842_c.nextInt(2);
                    }
                    if(k10 == j10)
                    {
                        k13 -= 2;
                    }
                    byte byte3 = 0;
                    if(field_73839_d.field_71441_e.func_72912_H().func_76093_s())
                    {
                        byte3 = 5;
                    }
                    func_73729_b(i13, k13, 16 + j12 * 9, 9 * byte3, 9, 9);
                    if(flag)
                    {
                        if(k10 * 2 + 1 < j2)
                        {
                            func_73729_b(i13, k13, k11 + 54, 9 * byte3, 9, 9);
                        }
                        if(k10 * 2 + 1 == j2)
                        {
                            func_73729_b(i13, k13, k11 + 63, 9 * byte3, 9, 9);
                        }
                    }
                    if(k10 * 2 + 1 < i1)
                    {
                        func_73729_b(i13, k13, k11 + 36, 9 * byte3, 9, 9);
                    }
                    if(k10 * 2 + 1 == i1)
                    {
                        func_73729_b(i13, k13, k11 + 45, 9 * byte3, 9, 9);
                    }
                }

                field_73839_d.field_71424_I.func_76318_c("food");
                for(int l10 = 0; l10 < 10; l10++)
                {
                    int l11 = l7;
                    int k12 = 16;
                    byte byte2 = 0;
                    if(field_73839_d.field_71439_g.func_70644_a(Potion.field_76438_s))
                    {
                        k12 += 36;
                        byte2 = 13;
                    }
                    if(field_73839_d.field_71439_g.func_71024_bL().func_75115_e() <= 0.0F && field_73837_f % (j4 * 3 + 1) == 0)
                    {
                        l11 += field_73842_c.nextInt(3) - 1;
                    }
                    if(flag2)
                    {
                        byte2 = 1;
                    }
                    int l13 = j6 - l10 * 8 - 9;
                    func_73729_b(l13, l11, 16 + byte2 * 9, 27, 9, 9);
                    if(flag2)
                    {
                        if(l10 * 2 + 1 < i5)
                        {
                            func_73729_b(l13, l11, k12 + 54, 27, 9, 9);
                        }
                        if(l10 * 2 + 1 == i5)
                        {
                            func_73729_b(l13, l11, k12 + 63, 27, 9, 9);
                        }
                    }
                    if(l10 * 2 + 1 < j4)
                    {
                        func_73729_b(l13, l11, k12 + 36, 27, 9, 9);
                    }
                    if(l10 * 2 + 1 == j4)
                    {
                        func_73729_b(l13, l11, k12 + 45, 27, 9, 9);
                    }
                }

                field_73839_d.field_71424_I.func_76318_c("air");
                if(field_73839_d.field_71439_g.func_70055_a(Material.field_76244_g))
                {
                    int i11 = field_73839_d.field_71439_g.func_70086_ai();
                    int i12 = MathHelper.func_76143_f(((double)(i11 - 2) * 10D) / 300D);
                    int l12 = MathHelper.func_76143_f(((double)i11 * 10D) / 300D) - i12;
                    for(int j13 = 0; j13 < i12 + l12; j13++)
                    {
                        if(j13 < i12)
                        {
                            func_73729_b(j6 - j13 * 8 - 9, l8, 16, 18, 9, 9);
                        } else
                        {
                            func_73729_b(j6 - j13 * 8 - 9, l8, 25, 18, 9, 9);
                        }
                    }

                }
                field_73839_d.field_71424_I.func_76319_b();
            }
            GL11.glDisable(3042);
            field_73839_d.field_71424_I.func_76320_a("actionBar");
            GL11.glEnable(32826);
            RenderHelper.func_74520_c();
            for(int i6 = 0; i6 < 9; i6++)
            {
                int k6 = (i / 2 - 90) + i6 * 20 + 2;
                int j7 = j - 16 - 3;
                func_73832_a(i6, k6, j7, p_73830_1_);
            }

            RenderHelper.func_74518_a();
            GL11.glDisable(32826);
            field_73839_d.field_71424_I.func_76319_b();
        }
        if(field_73839_d.field_71439_g.func_71060_bI() > 0)
        {
            field_73839_d.field_71424_I.func_76320_a("sleep");
            GL11.glDisable(2929);
            GL11.glDisable(3008);
            int k = field_73839_d.field_71439_g.func_71060_bI();
            float f1 = (float)k / 100F;
            if(f1 > 1.0F)
            {
                f1 = 1.0F - (float)(k - 100) / 10F;
            }
            int j1 = (int)(220F * f1) << 24 | 0x101020;
            func_73734_a(0, 0, i, j, j1);
            GL11.glEnable(3008);
            GL11.glEnable(2929);
            field_73839_d.field_71424_I.func_76319_b();
        }
        if(field_73839_d.field_71442_b.func_78763_f() && field_73839_d.field_71439_g.field_71068_ca > 0)
        {
            field_73839_d.field_71424_I.func_76320_a("expLevel");
            boolean flag1 = false;
            int k1 = flag1 ? 0xffffff : 0x80ff20;
            String s1 = (new StringBuilder()).append("").append(field_73839_d.field_71439_g.field_71068_ca).toString();
            int j3 = (i - fontrenderer.func_78256_a(s1)) / 2;
            int l3 = j - 31 - 4;
            fontrenderer.func_78276_b(s1, j3 + 1, l3, 0);
            fontrenderer.func_78276_b(s1, j3 - 1, l3, 0);
            fontrenderer.func_78276_b(s1, j3, l3 + 1, 0);
            fontrenderer.func_78276_b(s1, j3, l3 - 1, 0);
            fontrenderer.func_78276_b(s1, j3, l3, k1);
            field_73839_d.field_71424_I.func_76319_b();
        }
        if(field_73839_d.func_71355_q())
        {
            field_73839_d.field_71424_I.func_76320_a("demo");
            String s = "";
            if(field_73839_d.field_71441_e.func_72820_D() >= 0x1d6b4L)
            {
                s = StatCollector.func_74838_a("demo.demoExpired");
            } else
            {
                s = String.format(StatCollector.func_74838_a("demo.remainingTime"), new Object[] {
                    StringUtils.func_76337_a((int)(0x1d6b4L - field_73839_d.field_71441_e.func_72820_D()))
                });
            }
            int l1 = fontrenderer.func_78256_a(s);
            fontrenderer.func_78261_a(s, i - l1 - 10, 5, 0xffffff);
            field_73839_d.field_71424_I.func_76319_b();
        }
        if(field_73839_d.field_71474_y.field_74330_P)
        {
            field_73839_d.field_71424_I.func_76320_a("debug");
            GL11.glPushMatrix();
            fontrenderer.func_78261_a((new StringBuilder()).append("Minecraft 1.3.1 (").append(field_73839_d.field_71426_K).append(")").toString(), 2, 2, 0xffffff);
            fontrenderer.func_78261_a(field_73839_d.func_71393_m(), 2, 12, 0xffffff);
            fontrenderer.func_78261_a(field_73839_d.func_71408_n(), 2, 22, 0xffffff);
            fontrenderer.func_78261_a(field_73839_d.func_71374_p(), 2, 32, 0xffffff);
            fontrenderer.func_78261_a(field_73839_d.func_71388_o(), 2, 42, 0xffffff);
            long l = Runtime.getRuntime().maxMemory();
            long l2 = Runtime.getRuntime().totalMemory();
            long l4 = Runtime.getRuntime().freeMemory();
            long l5 = l2 - l4;
            String s2 = (new StringBuilder()).append("Used memory: ").append((l5 * 100L) / l).append("% (").append(l5 / 1024L / 1024L).append("MB) of ").append(l / 1024L / 1024L).append("MB").toString();
            func_73731_b(fontrenderer, s2, i - fontrenderer.func_78256_a(s2) - 2, 2, 0xe0e0e0);
            s2 = (new StringBuilder()).append("Allocated memory: ").append((l2 * 100L) / l).append("% (").append(l2 / 1024L / 1024L).append("MB)").toString();
            func_73731_b(fontrenderer, s2, i - fontrenderer.func_78256_a(s2) - 2, 12, 0xe0e0e0);
            func_73731_b(fontrenderer, String.format("x: %.5f", new Object[] {
                Double.valueOf(field_73839_d.field_71439_g.field_70165_t)
            }), 2, 64, 0xe0e0e0);
            func_73731_b(fontrenderer, String.format("y: %.3f (feet pos, %.3f eyes pos)", new Object[] {
                Double.valueOf(field_73839_d.field_71439_g.field_70121_D.field_72338_b), Double.valueOf(field_73839_d.field_71439_g.field_70163_u)
            }), 2, 72, 0xe0e0e0);
            func_73731_b(fontrenderer, String.format("z: %.5f", new Object[] {
                Double.valueOf(field_73839_d.field_71439_g.field_70161_v)
            }), 2, 80, 0xe0e0e0);
            func_73731_b(fontrenderer, (new StringBuilder()).append("f: ").append(MathHelper.func_76128_c((double)((field_73839_d.field_71439_g.field_70177_z * 4F) / 360F) + 0.5D) & 3).toString(), 2, 88, 0xe0e0e0);
            int i8 = MathHelper.func_76128_c(field_73839_d.field_71439_g.field_70165_t);
            int i9 = MathHelper.func_76128_c(field_73839_d.field_71439_g.field_70163_u);
            int l9 = MathHelper.func_76128_c(field_73839_d.field_71439_g.field_70161_v);
            if(field_73839_d.field_71441_e != null && field_73839_d.field_71441_e.func_72899_e(i8, i9, l9))
            {
                Chunk chunk = field_73839_d.field_71441_e.func_72938_d(i8, l9);
                func_73731_b(fontrenderer, (new StringBuilder()).append("lc: ").append(chunk.func_76625_h() + 15).append(" b: ").append(chunk.func_76591_a(i8 & 0xf, l9 & 0xf, field_73839_d.field_71441_e.func_72959_q()).field_76791_y).append(" bl: ").append(chunk.func_76614_a(EnumSkyBlock.Block, i8 & 0xf, i9, l9 & 0xf)).append(" sl: ").append(chunk.func_76614_a(EnumSkyBlock.Sky, i8 & 0xf, i9, l9 & 0xf)).append(" rl: ").append(chunk.func_76629_c(i8 & 0xf, i9, l9 & 0xf, 0)).toString(), 2, 96, 0xe0e0e0);
            }
            func_73731_b(fontrenderer, String.format("ws: %.3f, fs: %.3f, g: %b", new Object[] {
                Float.valueOf(field_73839_d.field_71439_g.field_71075_bZ.func_75094_b()), Float.valueOf(field_73839_d.field_71439_g.field_71075_bZ.func_75093_a()), Boolean.valueOf(field_73839_d.field_71439_g.field_70122_E)
            }), 2, 104, 0xe0e0e0);
            GL11.glPopMatrix();
            field_73839_d.field_71424_I.func_76319_b();
        }
        if(field_73845_h > 0)
        {
            field_73839_d.field_71424_I.func_76320_a("overlayMessage");
            float f2 = (float)field_73845_h - p_73830_1_;
            int i2 = (int)((f2 * 256F) / 20F);
            if(i2 > 255)
            {
                i2 = 255;
            }
            if(i2 > 0)
            {
                GL11.glPushMatrix();
                GL11.glTranslatef(i / 2, j - 48, 0.0F);
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                int k2 = 0xffffff;
                if(field_73844_j)
                {
                    k2 = Color.HSBtoRGB(f2 / 50F, 0.7F, 0.6F) & 0xffffff;
                }
                fontrenderer.func_78276_b(field_73838_g, -fontrenderer.func_78256_a(field_73838_g) / 2, -4, k2 + (i2 << 24));
                GL11.glDisable(3042);
                GL11.glPopMatrix();
            }
            field_73839_d.field_71424_I.func_76319_b();
        }
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3008);
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, j - 48, 0.0F);
        field_73839_d.field_71424_I.func_76320_a("chat");
        field_73840_e.func_73762_a(field_73837_f);
        field_73839_d.field_71424_I.func_76319_b();
        GL11.glPopMatrix();
        if(field_73839_d.field_71474_y.field_74321_H.field_74513_e && (!field_73839_d.func_71387_A() || field_73839_d.field_71439_g.field_71174_a.field_72559_c.size() > 1))
        {
            field_73839_d.field_71424_I.func_76320_a("playerList");
            NetClientHandler netclienthandler = field_73839_d.field_71439_g.field_71174_a;
            java.util.List list = netclienthandler.field_72559_c;
            int i3 = netclienthandler.field_72556_d;
            int k3 = i3;
            int i4 = 1;
            for(; k3 > 20; k3 = ((i3 + i4) - 1) / i4)
            {
                i4++;
            }

            int k4 = 300 / i4;
            if(k4 > 150)
            {
                k4 = 150;
            }
            int j5 = (i - i4 * k4) / 2;
            byte byte0 = 10;
            func_73734_a(j5 - 1, byte0 - 1, j5 + k4 * i4, byte0 + 9 * k3, 0x80000000);
            for(int l6 = 0; l6 < i3; l6++)
            {
                int k7 = j5 + (l6 % i4) * k4;
                int j8 = byte0 + (l6 / i4) * 9;
                func_73734_a(k7, j8, (k7 + k4) - 1, j8 + 8, 0x20ffffff);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                GL11.glEnable(3008);
                if(l6 >= list.size())
                {
                    continue;
                }
                GuiPlayerInfo guiplayerinfo = (GuiPlayerInfo)list.get(l6);
                fontrenderer.func_78261_a(guiplayerinfo.field_78831_a, k7, j8, 0xffffff);
                field_73839_d.field_71446_o.func_78342_b(field_73839_d.field_71446_o.func_78341_b("/gui/icons.png"));
                int i10 = 0;
                byte byte1 = 0;
                if(guiplayerinfo.field_78829_b < 0)
                {
                    byte1 = 5;
                } else
                if(guiplayerinfo.field_78829_b < 150)
                {
                    byte1 = 0;
                } else
                if(guiplayerinfo.field_78829_b < 300)
                {
                    byte1 = 1;
                } else
                if(guiplayerinfo.field_78829_b < 600)
                {
                    byte1 = 2;
                } else
                if(guiplayerinfo.field_78829_b < 1000)
                {
                    byte1 = 3;
                } else
                {
                    byte1 = 4;
                }
                field_73735_i += 100F;
                func_73729_b((k7 + k4) - 12, j8, 0 + i10 * 10, 176 + byte1 * 8, 10, 8);
                field_73735_i -= 100F;
            }

        }
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(2896);
        GL11.glEnable(3008);
    }

    private void func_73828_d()
    {
        if(RenderDragon.field_77085_a == null)
        {
            return;
        }
        EntityDragon entitydragon = RenderDragon.field_77085_a;
        RenderDragon.field_77085_a = null;
        FontRenderer fontrenderer = field_73839_d.field_71466_p;
        ScaledResolution scaledresolution = new ScaledResolution(field_73839_d.field_71474_y, field_73839_d.field_71443_c, field_73839_d.field_71440_d);
        int i = scaledresolution.func_78326_a();
        char c = '\266';
        int j = i / 2 - c / 2;
        int k = (int)(((float)entitydragon.func_70968_i() / (float)entitydragon.func_70667_aM()) * (float)(c + 1));
        byte byte0 = 12;
        func_73729_b(j, byte0, 0, 74, c, 5);
        func_73729_b(j, byte0, 0, 74, c, 5);
        if(k > 0)
        {
            func_73729_b(j, byte0, 0, 79, k, 5);
        }
        String s = "Boss health";
        fontrenderer.func_78261_a(s, i / 2 - fontrenderer.func_78256_a(s) / 2, byte0 - 10, 0xff00ff);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glBindTexture(3553, field_73839_d.field_71446_o.func_78341_b("/gui/icons.png"));
    }

    private void func_73836_a(int p_73836_1_, int p_73836_2_)
    {
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(3008);
        GL11.glBindTexture(3553, field_73839_d.field_71446_o.func_78341_b("%blur%/misc/pumpkinblur.png"));
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78382_b();
        tessellator.func_78374_a(0.0D, p_73836_2_, -90D, 0.0D, 1.0D);
        tessellator.func_78374_a(p_73836_1_, p_73836_2_, -90D, 1.0D, 1.0D);
        tessellator.func_78374_a(p_73836_1_, 0.0D, -90D, 1.0D, 0.0D);
        tessellator.func_78374_a(0.0D, 0.0D, -90D, 0.0D, 0.0D);
        tessellator.func_78381_a();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glEnable(3008);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    private void func_73829_a(float p_73829_1_, int p_73829_2_, int p_73829_3_)
    {
        p_73829_1_ = 1.0F - p_73829_1_;
        if(p_73829_1_ < 0.0F)
        {
            p_73829_1_ = 0.0F;
        }
        if(p_73829_1_ > 1.0F)
        {
            p_73829_1_ = 1.0F;
        }
        field_73843_a += (double)(p_73829_1_ - field_73843_a) * 0.01D;
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(0, 769);
        GL11.glColor4f(field_73843_a, field_73843_a, field_73843_a, 1.0F);
        GL11.glBindTexture(3553, field_73839_d.field_71446_o.func_78341_b("%blur%/misc/vignette.png"));
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78382_b();
        tessellator.func_78374_a(0.0D, p_73829_3_, -90D, 0.0D, 1.0D);
        tessellator.func_78374_a(p_73829_2_, p_73829_3_, -90D, 1.0D, 1.0D);
        tessellator.func_78374_a(p_73829_2_, 0.0D, -90D, 1.0D, 0.0D);
        tessellator.func_78374_a(0.0D, 0.0D, -90D, 0.0D, 0.0D);
        tessellator.func_78381_a();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glBlendFunc(770, 771);
    }

    private void func_73835_b(float p_73835_1_, int p_73835_2_, int p_73835_3_)
    {
        if(p_73835_1_ < 1.0F)
        {
            p_73835_1_ *= p_73835_1_;
            p_73835_1_ *= p_73835_1_;
            p_73835_1_ = p_73835_1_ * 0.8F + 0.2F;
        }
        GL11.glDisable(3008);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, p_73835_1_);
        GL11.glBindTexture(3553, field_73839_d.field_71446_o.func_78341_b("/terrain.png"));
        float f = (float)(Block.field_72015_be.field_72059_bZ % 16) / 16F;
        float f1 = (float)(Block.field_72015_be.field_72059_bZ / 16) / 16F;
        float f2 = (float)(Block.field_72015_be.field_72059_bZ % 16 + 1) / 16F;
        float f3 = (float)(Block.field_72015_be.field_72059_bZ / 16 + 1) / 16F;
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78382_b();
        tessellator.func_78374_a(0.0D, p_73835_3_, -90D, f, f3);
        tessellator.func_78374_a(p_73835_2_, p_73835_3_, -90D, f2, f3);
        tessellator.func_78374_a(p_73835_2_, 0.0D, -90D, f2, f1);
        tessellator.func_78374_a(0.0D, 0.0D, -90D, f, f1);
        tessellator.func_78381_a();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glEnable(3008);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    private void func_73832_a(int p_73832_1_, int p_73832_2_, int p_73832_3_, float p_73832_4_)
    {
        ItemStack itemstack = field_73839_d.field_71439_g.field_71071_by.field_70462_a[p_73832_1_];
        if(itemstack == null)
        {
            return;
        }
        float f = (float)itemstack.field_77992_b - p_73832_4_;
        if(f > 0.0F)
        {
            GL11.glPushMatrix();
            float f1 = 1.0F + f / 5F;
            GL11.glTranslatef(p_73832_2_ + 8, p_73832_3_ + 12, 0.0F);
            GL11.glScalef(1.0F / f1, (f1 + 1.0F) / 2.0F, 1.0F);
            GL11.glTranslatef(-(p_73832_2_ + 8), -(p_73832_3_ + 12), 0.0F);
        }
        field_73841_b.func_77015_a(field_73839_d.field_71466_p, field_73839_d.field_71446_o, itemstack, p_73832_2_, p_73832_3_);
        if(f > 0.0F)
        {
            GL11.glPopMatrix();
        }
        field_73841_b.func_77021_b(field_73839_d.field_71466_p, field_73839_d.field_71446_o, itemstack, p_73832_2_, p_73832_3_);
    }

    public void func_73831_a()
    {
        if(field_73845_h > 0)
        {
            field_73845_h--;
        }
        field_73837_f++;
    }

    public void func_73833_a(String p_73833_1_)
    {
        field_73838_g = (new StringBuilder()).append("Now playing: ").append(p_73833_1_).toString();
        field_73845_h = 60;
        field_73844_j = true;
    }

    public GuiNewChat func_73827_b()
    {
        return field_73840_e;
    }

    public int func_73834_c()
    {
        return field_73837_f;
    }

}
