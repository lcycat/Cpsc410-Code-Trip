// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Block, BlockRail, BlockDragonEgg, BlockFence, 
//            BlockPane, BlockFenceGate, BlockCauldron, BlockBrewingStand, 
//            BlockCocoa, ModLoader, IBlockAccess, BlockEndPortalFrame, 
//            Tessellator, BlockBed, Direction, EntityRenderer, 
//            BlockRedstoneRepeater, BlockPistonBase, BlockPistonExtension, Vec3, 
//            Vec3Pool, BlockTripWire, BlockFire, BlockRedstoneWire, 
//            BlockStem, Material, BlockFluid, MathHelper, 
//            World, BlockDirectional, BlockDoor, BlockGrass, 
//            ChestItemRenderHelper

public class RenderBlocks
{

    public IBlockAccess field_78669_a;
    public int field_78664_d;
    public boolean field_78666_e;
    public boolean field_78661_f;
    public static boolean field_78667_b = true;
    public static boolean cfgGrassFix = true;
    public boolean field_78668_c;
    public int field_78662_g;
    public int field_78683_h;
    public int field_78685_i;
    public int field_78679_j;
    public int field_78681_k;
    public int field_78675_l;
    public boolean field_78677_m;
    public float field_78671_n;
    public float field_78673_o;
    public float field_78701_p;
    public float field_78699_q;
    public float field_78697_r;
    public float field_78695_s;
    public float field_78693_t;
    public float field_78691_u;
    public float field_78689_v;
    public float field_78687_w;
    public float field_78712_x;
    public float field_78710_y;
    public float field_78708_z;
    public float field_78628_A;
    public float field_78629_B;
    public float field_78630_C;
    public float field_78624_D;
    public float field_78625_E;
    public float field_78626_F;
    public float field_78627_G;
    public float field_78634_H;
    public float field_78635_I;
    public float field_78636_J;
    public float field_78637_K;
    public float field_78631_L;
    public float field_78632_M;
    public float field_78633_N;
    public int field_78649_S;
    public int field_78641_T;
    public int field_78639_U;
    public int field_78645_V;
    public int field_78643_W;
    public int field_78657_X;
    public int field_78655_Y;
    public int field_78660_Z;
    public int field_78704_aa;
    public int field_78705_ab;
    public int field_78702_ac;
    public int field_78703_ad;
    public int field_78709_ae;
    public int field_78711_af;
    public int field_78706_ag;
    public int field_78707_ah;
    public int field_78690_ai;
    public int field_78692_aj;
    public int field_78686_ak;
    public int field_78688_al;
    public int field_78698_am;
    public int field_78700_an;
    public int field_78694_ao;
    public int field_78696_ap;
    public int field_78676_aq;
    public float field_78674_ar;
    public float field_78672_as;
    public float field_78670_at;
    public float field_78684_au;
    public float field_78682_av;
    public float field_78680_aw;
    public float field_78678_ax;
    public float field_78665_ay;
    public float field_78663_az;
    public float field_78650_aA;
    public float field_78651_aB;
    public float field_78652_aC;
    public boolean field_78653_aD;
    public boolean field_78654_aE;
    public boolean field_78656_aF;
    public boolean field_78658_aG;
    public boolean field_78659_aH;
    public boolean field_78638_aI;
    public boolean field_78640_aJ;
    public boolean field_78642_aK;
    public boolean field_78644_aL;
    public boolean field_78646_aM;
    public boolean field_78647_aN;
    public boolean field_78648_aO;

    public RenderBlocks(IBlockAccess p_i3187_1_)
    {
        field_78664_d = -1;
        field_78666_e = false;
        field_78661_f = false;
        field_78668_c = true;
        field_78662_g = 0;
        field_78683_h = 0;
        field_78685_i = 0;
        field_78679_j = 0;
        field_78681_k = 0;
        field_78675_l = 0;
        field_78698_am = 1;
        field_78669_a = p_i3187_1_;
    }

    public RenderBlocks()
    {
        field_78664_d = -1;
        field_78666_e = false;
        field_78661_f = false;
        field_78668_c = true;
        field_78662_g = 0;
        field_78683_h = 0;
        field_78685_i = 0;
        field_78679_j = 0;
        field_78681_k = 0;
        field_78675_l = 0;
        field_78698_am = 1;
    }

    public void func_78595_a()
    {
        field_78664_d = -1;
    }

    public void func_78604_a(Block p_78604_1_, int p_78604_2_, int p_78604_3_, int p_78604_4_, int p_78604_5_)
    {
        field_78664_d = p_78604_5_;
        func_78612_b(p_78604_1_, p_78604_2_, p_78604_3_, p_78604_4_);
        field_78664_d = -1;
    }

    public void func_78583_a(Block p_78583_1_, int p_78583_2_, int p_78583_3_, int p_78583_4_)
    {
        field_78661_f = true;
        func_78612_b(p_78583_1_, p_78583_2_, p_78583_3_, p_78583_4_);
        field_78661_f = false;
    }

    public boolean func_78612_b(Block p_78612_1_, int p_78612_2_, int p_78612_3_, int p_78612_4_)
    {
        int i = p_78612_1_.func_71857_b();
        p_78612_1_.func_71902_a(field_78669_a, p_78612_2_, p_78612_3_, p_78612_4_);
        if(i == 0)
        {
            return func_78570_q(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_);
        }
        if(i == 31)
        {
            return func_78581_r(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_);
        }
        if(i == 4)
        {
            return func_78621_p(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_);
        }
        if(i == 13)
        {
            return func_78584_s(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_);
        }
        if(i == 1)
        {
            return func_78620_l(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_);
        }
        if(i == 19)
        {
            return func_78603_m(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_);
        }
        if(i == 23)
        {
            return func_78566_o(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_);
        }
        if(i == 6)
        {
            return func_78614_n(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_);
        }
        if(i == 2)
        {
            return func_78572_c(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_);
        }
        if(i == 3)
        {
            return func_78590_h(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_);
        }
        if(i == 5)
        {
            return func_78589_i(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_);
        }
        if(i == 8)
        {
            return func_78576_j(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_);
        }
        if(i == 7)
        {
            return func_78601_u(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_);
        }
        if(i == 9)
        {
            return func_78586_a((BlockRail)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_);
        }
        if(i == 10)
        {
            return func_78565_t(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_);
        }
        if(i == 27)
        {
            return func_78618_a((BlockDragonEgg)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_);
        }
        if(i == 11)
        {
            return func_78582_a((BlockFence)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_);
        }
        if(i == 12)
        {
            return func_78594_e(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_);
        }
        if(i == 29)
        {
            return func_78577_f(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_);
        }
        if(i == 30)
        {
            return func_78619_g(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_);
        }
        if(i == 14)
        {
            return func_78574_w(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_);
        }
        if(i == 15)
        {
            return func_78610_x(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_);
        }
        if(i == 16)
        {
            return func_78593_b(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_, false);
        }
        if(i == 17)
        {
            return func_78608_c(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_, true);
        }
        if(i == 18)
        {
            return func_78592_a((BlockPane)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_);
        }
        if(i == 20)
        {
            return func_78598_k(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_);
        }
        if(i == 21)
        {
            return func_78580_a((BlockFenceGate)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_);
        }
        if(i == 24)
        {
            return func_78615_a((BlockCauldron)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_);
        }
        if(i == 25)
        {
            return func_78585_a((BlockBrewingStand)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_);
        }
        if(i == 26)
        {
            return func_78567_v(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_);
        }
        if(i == 28)
        {
            return func_78616_a((BlockCocoa)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_);
        } else
        {
            return ModLoader.renderWorldBlock(this, field_78669_a, p_78612_2_, p_78612_3_, p_78612_4_, p_78612_1_, i);
        }
    }

    public boolean func_78567_v(Block p_78567_1_, int p_78567_2_, int p_78567_3_, int p_78567_4_)
    {
        int i = field_78669_a.func_72805_g(p_78567_2_, p_78567_3_, p_78567_4_);
        int j = i & 3;
        if(j == 0)
        {
            field_78681_k = 3;
        } else
        if(j == 3)
        {
            field_78681_k = 1;
        } else
        if(j == 1)
        {
            field_78681_k = 2;
        }
        if(!BlockEndPortalFrame.func_72165_e(i))
        {
            p_78567_1_.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
            func_78570_q(p_78567_1_, p_78567_2_, p_78567_3_, p_78567_4_);
            p_78567_1_.func_71919_f();
            field_78681_k = 0;
            return true;
        } else
        {
            p_78567_1_.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
            func_78570_q(p_78567_1_, p_78567_2_, p_78567_3_, p_78567_4_);
            field_78664_d = 174;
            p_78567_1_.func_71905_a(0.25F, 0.8125F, 0.25F, 0.75F, 1.0F, 0.75F);
            func_78570_q(p_78567_1_, p_78567_2_, p_78567_3_, p_78567_4_);
            func_78595_a();
            p_78567_1_.func_71919_f();
            field_78681_k = 0;
            return true;
        }
    }

    public boolean func_78574_w(Block p_78574_1_, int p_78574_2_, int p_78574_3_, int p_78574_4_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        int i = field_78669_a.func_72805_g(p_78574_2_, p_78574_3_, p_78574_4_);
        int j = BlockBed.func_72217_d(i);
        boolean flag = BlockBed.func_72229_a_(i);
        float f = 0.5F;
        float f1 = 1.0F;
        float f2 = 0.8F;
        float f3 = 0.6F;
        float f4 = f1;
        float f5 = f1;
        float f6 = f1;
        float f7 = f;
        float f8 = f2;
        float f9 = f3;
        float f10 = f;
        float f11 = f2;
        float f12 = f3;
        float f13 = f;
        float f14 = f2;
        float f15 = f3;
        int k = p_78574_1_.func_71874_e(field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_);
        tessellator.func_78380_c(k);
        tessellator.func_78386_a(f7, f10, f13);
        int l = p_78574_1_.func_71895_b(field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_, 0);
        int i1 = (l & 0xf) << 4;
        int j1 = l & 0xf0;
        double d = (float)i1 / 256F;
        double d1 = ((double)(i1 + 16) - 0.01D) / 256D;
        double d2 = (float)j1 / 256F;
        double d3 = ((double)(j1 + 16) - 0.01D) / 256D;
        double d4 = (double)p_78574_2_ + p_78574_1_.field_72026_ch;
        double d5 = (double)p_78574_2_ + p_78574_1_.field_72021_ck;
        double d6 = (double)p_78574_3_ + p_78574_1_.field_72023_ci + 0.1875D;
        double d7 = (double)p_78574_4_ + p_78574_1_.field_72024_cj;
        double d8 = (double)p_78574_4_ + p_78574_1_.field_72019_cm;
        tessellator.func_78374_a(d4, d6, d8, d, d3);
        tessellator.func_78374_a(d4, d6, d7, d, d2);
        tessellator.func_78374_a(d5, d6, d7, d1, d2);
        tessellator.func_78374_a(d5, d6, d8, d1, d3);
        tessellator.func_78380_c(p_78574_1_.func_71874_e(field_78669_a, p_78574_2_, p_78574_3_ + 1, p_78574_4_));
        tessellator.func_78386_a(f4, f5, f6);
        l = p_78574_1_.func_71895_b(field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_, 1);
        i1 = (l & 0xf) << 4;
        j1 = l & 0xf0;
        d = (float)i1 / 256F;
        d1 = ((double)(i1 + 16) - 0.01D) / 256D;
        d2 = (float)j1 / 256F;
        d3 = ((double)(j1 + 16) - 0.01D) / 256D;
        d4 = d;
        d5 = d1;
        d6 = d2;
        d7 = d2;
        d8 = d;
        double d9 = d1;
        double d10 = d3;
        double d11 = d3;
        if(j == 0)
        {
            d5 = d;
            d6 = d3;
            d8 = d1;
            d11 = d2;
        } else
        if(j == 2)
        {
            d4 = d1;
            d7 = d3;
            d9 = d;
            d10 = d2;
        } else
        if(j == 3)
        {
            d4 = d1;
            d7 = d3;
            d9 = d;
            d10 = d2;
            d5 = d;
            d6 = d3;
            d8 = d1;
            d11 = d2;
        }
        double d12 = (double)p_78574_2_ + p_78574_1_.field_72026_ch;
        double d13 = (double)p_78574_2_ + p_78574_1_.field_72021_ck;
        double d14 = (double)p_78574_3_ + p_78574_1_.field_72022_cl;
        double d15 = (double)p_78574_4_ + p_78574_1_.field_72024_cj;
        double d16 = (double)p_78574_4_ + p_78574_1_.field_72019_cm;
        tessellator.func_78374_a(d13, d14, d16, d8, d10);
        tessellator.func_78374_a(d13, d14, d15, d4, d6);
        tessellator.func_78374_a(d12, d14, d15, d5, d7);
        tessellator.func_78374_a(d12, d14, d16, d9, d11);
        int k1 = Direction.field_71582_c[j];
        if(flag)
        {
            k1 = Direction.field_71582_c[Direction.field_71580_e[j]];
        }
        byte byte0 = 4;
        switch(j)
        {
        case 0: // '\0'
            byte0 = 5;
            break;

        case 3: // '\003'
            byte0 = 2;
            break;

        case 1: // '\001'
            byte0 = 3;
            break;
        }
        if(k1 != 2 && (field_78661_f || p_78574_1_.func_71877_c(field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_ - 1, 2)))
        {
            tessellator.func_78380_c(p_78574_1_.field_72024_cj > 0.0D ? k : p_78574_1_.func_71874_e(field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_ - 1));
            tessellator.func_78386_a(f8, f11, f14);
            field_78666_e = byte0 == 2;
            func_78611_c(p_78574_1_, p_78574_2_, p_78574_3_, p_78574_4_, p_78574_1_.func_71895_b(field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_, 2));
        }
        if(k1 != 3 && (field_78661_f || p_78574_1_.func_71877_c(field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_ + 1, 3)))
        {
            tessellator.func_78380_c(p_78574_1_.field_72019_cm < 1.0D ? k : p_78574_1_.func_71874_e(field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_ + 1));
            tessellator.func_78386_a(f8, f11, f14);
            field_78666_e = byte0 == 3;
            func_78622_d(p_78574_1_, p_78574_2_, p_78574_3_, p_78574_4_, p_78574_1_.func_71895_b(field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_, 3));
        }
        if(k1 != 4 && (field_78661_f || p_78574_1_.func_71877_c(field_78669_a, p_78574_2_ - 1, p_78574_3_, p_78574_4_, 4)))
        {
            tessellator.func_78380_c(p_78574_1_.field_72024_cj > 0.0D ? k : p_78574_1_.func_71874_e(field_78669_a, p_78574_2_ - 1, p_78574_3_, p_78574_4_));
            tessellator.func_78386_a(f9, f12, f15);
            field_78666_e = byte0 == 4;
            func_78573_e(p_78574_1_, p_78574_2_, p_78574_3_, p_78574_4_, p_78574_1_.func_71895_b(field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_, 4));
        }
        if(k1 != 5 && (field_78661_f || p_78574_1_.func_71877_c(field_78669_a, p_78574_2_ + 1, p_78574_3_, p_78574_4_, 5)))
        {
            tessellator.func_78380_c(p_78574_1_.field_72019_cm < 1.0D ? k : p_78574_1_.func_71874_e(field_78669_a, p_78574_2_ + 1, p_78574_3_, p_78574_4_));
            tessellator.func_78386_a(f9, f12, f15);
            field_78666_e = byte0 == 5;
            func_78605_f(p_78574_1_, p_78574_2_, p_78574_3_, p_78574_4_, p_78574_1_.func_71895_b(field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_, 5));
        }
        field_78666_e = false;
        return true;
    }

    public boolean func_78585_a(BlockBrewingStand p_78585_1_, int p_78585_2_, int p_78585_3_, int p_78585_4_)
    {
        p_78585_1_.func_71905_a(0.4375F, 0.0F, 0.4375F, 0.5625F, 0.875F, 0.5625F);
        func_78570_q(p_78585_1_, p_78585_2_, p_78585_3_, p_78585_4_);
        field_78664_d = 156;
        p_78585_1_.func_71905_a(0.5625F, 0.0F, 0.3125F, 0.9375F, 0.125F, 0.6875F);
        func_78570_q(p_78585_1_, p_78585_2_, p_78585_3_, p_78585_4_);
        p_78585_1_.func_71905_a(0.125F, 0.0F, 0.0625F, 0.5F, 0.125F, 0.4375F);
        func_78570_q(p_78585_1_, p_78585_2_, p_78585_3_, p_78585_4_);
        p_78585_1_.func_71905_a(0.125F, 0.0F, 0.5625F, 0.5F, 0.125F, 0.9375F);
        func_78570_q(p_78585_1_, p_78585_2_, p_78585_3_, p_78585_4_);
        func_78595_a();
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78380_c(p_78585_1_.func_71874_e(field_78669_a, p_78585_2_, p_78585_3_, p_78585_4_));
        float f = 1.0F;
        int i = p_78585_1_.func_71920_b(field_78669_a, p_78585_2_, p_78585_3_, p_78585_4_);
        float f1 = (float)(i >> 16 & 0xff) / 255F;
        float f2 = (float)(i >> 8 & 0xff) / 255F;
        float f3 = (float)(i & 0xff) / 255F;
        if(EntityRenderer.field_78517_a)
        {
            float f4 = (f1 * 30F + f2 * 59F + f3 * 11F) / 100F;
            float f5 = (f1 * 30F + f2 * 70F) / 100F;
            float f6 = (f1 * 30F + f3 * 70F) / 100F;
            f1 = f4;
            f2 = f5;
            f3 = f6;
        }
        tessellator.func_78386_a(f * f1, f * f2, f * f3);
        int j = p_78585_1_.func_71858_a(0, 0);
        if(field_78664_d >= 0)
        {
            j = field_78664_d;
        }
        int k = (j & 0xf) << 4;
        int l = j & 0xf0;
        double d = (float)l / 256F;
        double d1 = ((float)l + 15.99F) / 256F;
        int i1 = field_78669_a.func_72805_g(p_78585_2_, p_78585_3_, p_78585_4_);
        for(int j1 = 0; j1 < 3; j1++)
        {
            double d2 = ((double)j1 * 3.1415926535897931D * 2D) / 3D + 1.5707963267948966D;
            double d3 = ((float)k + 8F) / 256F;
            double d4 = ((float)k + 15.99F) / 256F;
            if((i1 & 1 << j1) != 0)
            {
                d3 = ((float)k + 7.99F) / 256F;
                d4 = ((float)k + 0.0F) / 256F;
            }
            double d5 = (double)p_78585_2_ + 0.5D;
            double d6 = (double)p_78585_2_ + 0.5D + (Math.sin(d2) * 8D) / 16D;
            double d7 = (double)p_78585_4_ + 0.5D;
            double d8 = (double)p_78585_4_ + 0.5D + (Math.cos(d2) * 8D) / 16D;
            tessellator.func_78374_a(d5, p_78585_3_ + 1, d7, d3, d);
            tessellator.func_78374_a(d5, p_78585_3_ + 0, d7, d3, d1);
            tessellator.func_78374_a(d6, p_78585_3_ + 0, d8, d4, d1);
            tessellator.func_78374_a(d6, p_78585_3_ + 1, d8, d4, d);
            tessellator.func_78374_a(d6, p_78585_3_ + 1, d8, d4, d);
            tessellator.func_78374_a(d6, p_78585_3_ + 0, d8, d4, d1);
            tessellator.func_78374_a(d5, p_78585_3_ + 0, d7, d3, d1);
            tessellator.func_78374_a(d5, p_78585_3_ + 1, d7, d3, d);
        }

        p_78585_1_.func_71919_f();
        return true;
    }

    public boolean func_78615_a(BlockCauldron p_78615_1_, int p_78615_2_, int p_78615_3_, int p_78615_4_)
    {
        func_78570_q(p_78615_1_, p_78615_2_, p_78615_3_, p_78615_4_);
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78380_c(p_78615_1_.func_71874_e(field_78669_a, p_78615_2_, p_78615_3_, p_78615_4_));
        float f = 1.0F;
        int i = p_78615_1_.func_71920_b(field_78669_a, p_78615_2_, p_78615_3_, p_78615_4_);
        float f1 = (float)(i >> 16 & 0xff) / 255F;
        float f2 = (float)(i >> 8 & 0xff) / 255F;
        float f3 = (float)(i & 0xff) / 255F;
        if(EntityRenderer.field_78517_a)
        {
            float f4 = (f1 * 30F + f2 * 59F + f3 * 11F) / 100F;
            float f5 = (f1 * 30F + f2 * 70F) / 100F;
            float f7 = (f1 * 30F + f3 * 70F) / 100F;
            f1 = f4;
            f2 = f5;
            f3 = f7;
        }
        tessellator.func_78386_a(f * f1, f * f2, f * f3);
        char c = '\232';
        float f6 = 0.125F;
        func_78605_f(p_78615_1_, ((float)p_78615_2_ - 1.0F) + f6, p_78615_3_, p_78615_4_, c);
        func_78573_e(p_78615_1_, ((float)p_78615_2_ + 1.0F) - f6, p_78615_3_, p_78615_4_, c);
        func_78622_d(p_78615_1_, p_78615_2_, p_78615_3_, ((float)p_78615_4_ - 1.0F) + f6, c);
        func_78611_c(p_78615_1_, p_78615_2_, p_78615_3_, ((float)p_78615_4_ + 1.0F) - f6, c);
        char c1 = '\213';
        func_78617_b(p_78615_1_, p_78615_2_, ((float)p_78615_3_ - 1.0F) + 0.25F, p_78615_4_, c1);
        func_78613_a(p_78615_1_, p_78615_2_, ((float)p_78615_3_ + 1.0F) - 0.75F, p_78615_4_, c1);
        int j = field_78669_a.func_72805_g(p_78615_2_, p_78615_3_, p_78615_4_);
        if(j > 0)
        {
            char c2 = '\315';
            if(j > 3)
            {
                j = 3;
            }
            func_78617_b(p_78615_1_, p_78615_2_, ((float)p_78615_3_ - 1.0F) + (6F + (float)j * 3F) / 16F, p_78615_4_, c2);
        }
        return true;
    }

    public boolean func_78572_c(Block p_78572_1_, int p_78572_2_, int p_78572_3_, int p_78572_4_)
    {
        int i = field_78669_a.func_72805_g(p_78572_2_, p_78572_3_, p_78572_4_);
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78380_c(p_78572_1_.func_71874_e(field_78669_a, p_78572_2_, p_78572_3_, p_78572_4_));
        tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
        double d = 0.40000000596046448D;
        double d1 = 0.5D - d;
        double d2 = 0.20000000298023224D;
        if(i == 1)
        {
            func_78623_a(p_78572_1_, (double)p_78572_2_ - d1, (double)p_78572_3_ + d2, p_78572_4_, -d, 0.0D);
        } else
        if(i == 2)
        {
            func_78623_a(p_78572_1_, (double)p_78572_2_ + d1, (double)p_78572_3_ + d2, p_78572_4_, d, 0.0D);
        } else
        if(i == 3)
        {
            func_78623_a(p_78572_1_, p_78572_2_, (double)p_78572_3_ + d2, (double)p_78572_4_ - d1, 0.0D, -d);
        } else
        if(i == 4)
        {
            func_78623_a(p_78572_1_, p_78572_2_, (double)p_78572_3_ + d2, (double)p_78572_4_ + d1, 0.0D, d);
        } else
        {
            func_78623_a(p_78572_1_, p_78572_2_, p_78572_3_, p_78572_4_, 0.0D, 0.0D);
        }
        return true;
    }

    public boolean func_78610_x(Block p_78610_1_, int p_78610_2_, int p_78610_3_, int p_78610_4_)
    {
        int i = field_78669_a.func_72805_g(p_78610_2_, p_78610_3_, p_78610_4_);
        int j = i & 3;
        int k = (i & 0xc) >> 2;
        func_78570_q(p_78610_1_, p_78610_2_, p_78610_3_, p_78610_4_);
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78380_c(p_78610_1_.func_71874_e(field_78669_a, p_78610_2_, p_78610_3_, p_78610_4_));
        tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
        double d = -0.1875D;
        double d1 = 0.0D;
        double d2 = 0.0D;
        double d3 = 0.0D;
        double d4 = 0.0D;
        switch(j)
        {
        case 0: // '\0'
            d4 = -0.3125D;
            d2 = BlockRedstoneRepeater.field_72223_a[k];
            break;

        case 2: // '\002'
            d4 = 0.3125D;
            d2 = -BlockRedstoneRepeater.field_72223_a[k];
            break;

        case 3: // '\003'
            d3 = -0.3125D;
            d1 = BlockRedstoneRepeater.field_72223_a[k];
            break;

        case 1: // '\001'
            d3 = 0.3125D;
            d1 = -BlockRedstoneRepeater.field_72223_a[k];
            break;
        }
        func_78623_a(p_78610_1_, (double)p_78610_2_ + d1, (double)p_78610_3_ + d, (double)p_78610_4_ + d2, 0.0D, 0.0D);
        func_78623_a(p_78610_1_, (double)p_78610_2_ + d3, (double)p_78610_3_ + d, (double)p_78610_4_ + d4, 0.0D, 0.0D);
        int l = p_78610_1_.func_71851_a(1);
        int i1 = (l & 0xf) << 4;
        int j1 = l & 0xf0;
        double d5 = (float)i1 / 256F;
        double d6 = ((float)i1 + 15.99F) / 256F;
        double d7 = (float)j1 / 256F;
        double d8 = ((float)j1 + 15.99F) / 256F;
        double d9 = 0.125D;
        double d10 = p_78610_2_ + 1;
        double d11 = p_78610_2_ + 1;
        double d12 = p_78610_2_ + 0;
        double d13 = p_78610_2_ + 0;
        double d14 = p_78610_4_ + 0;
        double d15 = p_78610_4_ + 1;
        double d16 = p_78610_4_ + 1;
        double d17 = p_78610_4_ + 0;
        double d18 = (double)p_78610_3_ + d9;
        if(j == 2)
        {
            d10 = d11 = p_78610_2_ + 0;
            d12 = d13 = p_78610_2_ + 1;
            d14 = d17 = p_78610_4_ + 1;
            d15 = d16 = p_78610_4_ + 0;
        } else
        if(j == 3)
        {
            d10 = d13 = p_78610_2_ + 0;
            d11 = d12 = p_78610_2_ + 1;
            d14 = d15 = p_78610_4_ + 0;
            d16 = d17 = p_78610_4_ + 1;
        } else
        if(j == 1)
        {
            d10 = d13 = p_78610_2_ + 1;
            d11 = d12 = p_78610_2_ + 0;
            d14 = d15 = p_78610_4_ + 1;
            d16 = d17 = p_78610_4_ + 0;
        }
        tessellator.func_78374_a(d13, d18, d17, d5, d7);
        tessellator.func_78374_a(d12, d18, d16, d5, d8);
        tessellator.func_78374_a(d11, d18, d15, d6, d8);
        tessellator.func_78374_a(d10, d18, d14, d6, d7);
        return true;
    }

    public void func_78568_d(Block p_78568_1_, int p_78568_2_, int p_78568_3_, int p_78568_4_)
    {
        field_78661_f = true;
        func_78593_b(p_78568_1_, p_78568_2_, p_78568_3_, p_78568_4_, true);
        field_78661_f = false;
    }

    public boolean func_78593_b(Block p_78593_1_, int p_78593_2_, int p_78593_3_, int p_78593_4_, boolean p_78593_5_)
    {
        int i = field_78669_a.func_72805_g(p_78593_2_, p_78593_3_, p_78593_4_);
        boolean flag = p_78593_5_ || (i & 8) != 0;
        int j = BlockPistonBase.func_72117_e(i);
        if(flag)
        {
            switch(j)
            {
            case 0: // '\0'
                field_78662_g = 3;
                field_78683_h = 3;
                field_78685_i = 3;
                field_78679_j = 3;
                p_78593_1_.func_71905_a(0.0F, 0.25F, 0.0F, 1.0F, 1.0F, 1.0F);
                break;

            case 1: // '\001'
                p_78593_1_.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
                break;

            case 2: // '\002'
                field_78685_i = 1;
                field_78679_j = 2;
                p_78593_1_.func_71905_a(0.0F, 0.0F, 0.25F, 1.0F, 1.0F, 1.0F);
                break;

            case 3: // '\003'
                field_78685_i = 2;
                field_78679_j = 1;
                field_78681_k = 3;
                field_78675_l = 3;
                p_78593_1_.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.75F);
                break;

            case 4: // '\004'
                field_78662_g = 1;
                field_78683_h = 2;
                field_78681_k = 2;
                field_78675_l = 1;
                p_78593_1_.func_71905_a(0.25F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
                break;

            case 5: // '\005'
                field_78662_g = 2;
                field_78683_h = 1;
                field_78681_k = 1;
                field_78675_l = 2;
                p_78593_1_.func_71905_a(0.0F, 0.0F, 0.0F, 0.75F, 1.0F, 1.0F);
                break;
            }
            func_78570_q(p_78593_1_, p_78593_2_, p_78593_3_, p_78593_4_);
            field_78662_g = 0;
            field_78683_h = 0;
            field_78685_i = 0;
            field_78679_j = 0;
            field_78681_k = 0;
            field_78675_l = 0;
            p_78593_1_.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        } else
        {
            switch(j)
            {
            case 0: // '\0'
                field_78662_g = 3;
                field_78683_h = 3;
                field_78685_i = 3;
                field_78679_j = 3;
                break;

            case 2: // '\002'
                field_78685_i = 1;
                field_78679_j = 2;
                break;

            case 3: // '\003'
                field_78685_i = 2;
                field_78679_j = 1;
                field_78681_k = 3;
                field_78675_l = 3;
                break;

            case 4: // '\004'
                field_78662_g = 1;
                field_78683_h = 2;
                field_78681_k = 2;
                field_78675_l = 1;
                break;

            case 5: // '\005'
                field_78662_g = 2;
                field_78683_h = 1;
                field_78681_k = 1;
                field_78675_l = 2;
                break;
            }
            func_78570_q(p_78593_1_, p_78593_2_, p_78593_3_, p_78593_4_);
            field_78662_g = 0;
            field_78683_h = 0;
            field_78685_i = 0;
            field_78679_j = 0;
            field_78681_k = 0;
            field_78675_l = 0;
        }
        return true;
    }

    public void func_78591_a(double p_78591_1_, double p_78591_3_, double p_78591_5_, double p_78591_7_, double p_78591_9_, double p_78591_11_, float p_78591_13_, double p_78591_14_)
    {
        int i = 108;
        if(field_78664_d >= 0)
        {
            i = field_78664_d;
        }
        int j = (i & 0xf) << 4;
        int k = i & 0xf0;
        Tessellator tessellator = Tessellator.field_78398_a;
        double d = (float)(j + 0) / 256F;
        double d1 = (float)(k + 0) / 256F;
        double d2 = (((double)j + p_78591_14_) - 0.01D) / 256D;
        double d3 = ((double)((float)k + 4F) - 0.01D) / 256D;
        tessellator.func_78386_a(p_78591_13_, p_78591_13_, p_78591_13_);
        tessellator.func_78374_a(p_78591_1_, p_78591_7_, p_78591_9_, d2, d1);
        tessellator.func_78374_a(p_78591_1_, p_78591_5_, p_78591_9_, d, d1);
        tessellator.func_78374_a(p_78591_3_, p_78591_5_, p_78591_11_, d, d3);
        tessellator.func_78374_a(p_78591_3_, p_78591_7_, p_78591_11_, d2, d3);
    }

    public void func_78607_b(double p_78607_1_, double p_78607_3_, double p_78607_5_, double p_78607_7_, double p_78607_9_, double p_78607_11_, float p_78607_13_, double p_78607_14_)
    {
        int i = 108;
        if(field_78664_d >= 0)
        {
            i = field_78664_d;
        }
        int j = (i & 0xf) << 4;
        int k = i & 0xf0;
        Tessellator tessellator = Tessellator.field_78398_a;
        double d = (float)(j + 0) / 256F;
        double d1 = (float)(k + 0) / 256F;
        double d2 = (((double)j + p_78607_14_) - 0.01D) / 256D;
        double d3 = ((double)((float)k + 4F) - 0.01D) / 256D;
        tessellator.func_78386_a(p_78607_13_, p_78607_13_, p_78607_13_);
        tessellator.func_78374_a(p_78607_1_, p_78607_5_, p_78607_11_, d2, d1);
        tessellator.func_78374_a(p_78607_1_, p_78607_5_, p_78607_9_, d, d1);
        tessellator.func_78374_a(p_78607_3_, p_78607_7_, p_78607_9_, d, d3);
        tessellator.func_78374_a(p_78607_3_, p_78607_7_, p_78607_11_, d2, d3);
    }

    public void func_78571_c(double p_78571_1_, double p_78571_3_, double p_78571_5_, double p_78571_7_, double p_78571_9_, double p_78571_11_, float p_78571_13_, double p_78571_14_)
    {
        int i = 108;
        if(field_78664_d >= 0)
        {
            i = field_78664_d;
        }
        int j = (i & 0xf) << 4;
        int k = i & 0xf0;
        Tessellator tessellator = Tessellator.field_78398_a;
        double d = (float)(j + 0) / 256F;
        double d1 = (float)(k + 0) / 256F;
        double d2 = (((double)j + p_78571_14_) - 0.01D) / 256D;
        double d3 = ((double)((float)k + 4F) - 0.01D) / 256D;
        tessellator.func_78386_a(p_78571_13_, p_78571_13_, p_78571_13_);
        tessellator.func_78374_a(p_78571_3_, p_78571_5_, p_78571_9_, d2, d1);
        tessellator.func_78374_a(p_78571_1_, p_78571_5_, p_78571_9_, d, d1);
        tessellator.func_78374_a(p_78571_1_, p_78571_7_, p_78571_11_, d, d3);
        tessellator.func_78374_a(p_78571_3_, p_78571_7_, p_78571_11_, d2, d3);
    }

    public void func_78587_a(Block p_78587_1_, int p_78587_2_, int p_78587_3_, int p_78587_4_, boolean p_78587_5_)
    {
        field_78661_f = true;
        func_78608_c(p_78587_1_, p_78587_2_, p_78587_3_, p_78587_4_, p_78587_5_);
        field_78661_f = false;
    }

    public boolean func_78608_c(Block p_78608_1_, int p_78608_2_, int p_78608_3_, int p_78608_4_, boolean p_78608_5_)
    {
        int i = field_78669_a.func_72805_g(p_78608_2_, p_78608_3_, p_78608_4_);
        int j = BlockPistonExtension.func_72121_f(i);
        float f = p_78608_1_.func_71870_f(field_78669_a, p_78608_2_, p_78608_3_, p_78608_4_);
        float f1 = p_78608_5_ ? 1.0F : 0.5F;
        double d = p_78608_5_ ? 16D : 8D;
        switch(j)
        {
        case 0: // '\0'
            field_78662_g = 3;
            field_78683_h = 3;
            field_78685_i = 3;
            field_78679_j = 3;
            p_78608_1_.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
            func_78570_q(p_78608_1_, p_78608_2_, p_78608_3_, p_78608_4_);
            func_78591_a((float)p_78608_2_ + 0.375F, (float)p_78608_2_ + 0.625F, (float)p_78608_3_ + 0.25F, (float)p_78608_3_ + 0.25F + f1, (float)p_78608_4_ + 0.625F, (float)p_78608_4_ + 0.625F, f * 0.8F, d);
            func_78591_a((float)p_78608_2_ + 0.625F, (float)p_78608_2_ + 0.375F, (float)p_78608_3_ + 0.25F, (float)p_78608_3_ + 0.25F + f1, (float)p_78608_4_ + 0.375F, (float)p_78608_4_ + 0.375F, f * 0.8F, d);
            func_78591_a((float)p_78608_2_ + 0.375F, (float)p_78608_2_ + 0.375F, (float)p_78608_3_ + 0.25F, (float)p_78608_3_ + 0.25F + f1, (float)p_78608_4_ + 0.375F, (float)p_78608_4_ + 0.625F, f * 0.6F, d);
            func_78591_a((float)p_78608_2_ + 0.625F, (float)p_78608_2_ + 0.625F, (float)p_78608_3_ + 0.25F, (float)p_78608_3_ + 0.25F + f1, (float)p_78608_4_ + 0.625F, (float)p_78608_4_ + 0.375F, f * 0.6F, d);
            break;

        case 1: // '\001'
            p_78608_1_.func_71905_a(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
            func_78570_q(p_78608_1_, p_78608_2_, p_78608_3_, p_78608_4_);
            func_78591_a((float)p_78608_2_ + 0.375F, (float)p_78608_2_ + 0.625F, (((float)p_78608_3_ - 0.25F) + 1.0F) - f1, ((float)p_78608_3_ - 0.25F) + 1.0F, (float)p_78608_4_ + 0.625F, (float)p_78608_4_ + 0.625F, f * 0.8F, d);
            func_78591_a((float)p_78608_2_ + 0.625F, (float)p_78608_2_ + 0.375F, (((float)p_78608_3_ - 0.25F) + 1.0F) - f1, ((float)p_78608_3_ - 0.25F) + 1.0F, (float)p_78608_4_ + 0.375F, (float)p_78608_4_ + 0.375F, f * 0.8F, d);
            func_78591_a((float)p_78608_2_ + 0.375F, (float)p_78608_2_ + 0.375F, (((float)p_78608_3_ - 0.25F) + 1.0F) - f1, ((float)p_78608_3_ - 0.25F) + 1.0F, (float)p_78608_4_ + 0.375F, (float)p_78608_4_ + 0.625F, f * 0.6F, d);
            func_78591_a((float)p_78608_2_ + 0.625F, (float)p_78608_2_ + 0.625F, (((float)p_78608_3_ - 0.25F) + 1.0F) - f1, ((float)p_78608_3_ - 0.25F) + 1.0F, (float)p_78608_4_ + 0.625F, (float)p_78608_4_ + 0.375F, f * 0.6F, d);
            break;

        case 2: // '\002'
            field_78685_i = 1;
            field_78679_j = 2;
            p_78608_1_.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
            func_78570_q(p_78608_1_, p_78608_2_, p_78608_3_, p_78608_4_);
            func_78607_b((float)p_78608_2_ + 0.375F, (float)p_78608_2_ + 0.375F, (float)p_78608_3_ + 0.625F, (float)p_78608_3_ + 0.375F, (float)p_78608_4_ + 0.25F, (float)p_78608_4_ + 0.25F + f1, f * 0.6F, d);
            func_78607_b((float)p_78608_2_ + 0.625F, (float)p_78608_2_ + 0.625F, (float)p_78608_3_ + 0.375F, (float)p_78608_3_ + 0.625F, (float)p_78608_4_ + 0.25F, (float)p_78608_4_ + 0.25F + f1, f * 0.6F, d);
            func_78607_b((float)p_78608_2_ + 0.375F, (float)p_78608_2_ + 0.625F, (float)p_78608_3_ + 0.375F, (float)p_78608_3_ + 0.375F, (float)p_78608_4_ + 0.25F, (float)p_78608_4_ + 0.25F + f1, f * 0.5F, d);
            func_78607_b((float)p_78608_2_ + 0.625F, (float)p_78608_2_ + 0.375F, (float)p_78608_3_ + 0.625F, (float)p_78608_3_ + 0.625F, (float)p_78608_4_ + 0.25F, (float)p_78608_4_ + 0.25F + f1, f, d);
            break;

        case 3: // '\003'
            field_78685_i = 2;
            field_78679_j = 1;
            field_78681_k = 3;
            field_78675_l = 3;
            p_78608_1_.func_71905_a(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
            func_78570_q(p_78608_1_, p_78608_2_, p_78608_3_, p_78608_4_);
            func_78607_b((float)p_78608_2_ + 0.375F, (float)p_78608_2_ + 0.375F, (float)p_78608_3_ + 0.625F, (float)p_78608_3_ + 0.375F, (((float)p_78608_4_ - 0.25F) + 1.0F) - f1, ((float)p_78608_4_ - 0.25F) + 1.0F, f * 0.6F, d);
            func_78607_b((float)p_78608_2_ + 0.625F, (float)p_78608_2_ + 0.625F, (float)p_78608_3_ + 0.375F, (float)p_78608_3_ + 0.625F, (((float)p_78608_4_ - 0.25F) + 1.0F) - f1, ((float)p_78608_4_ - 0.25F) + 1.0F, f * 0.6F, d);
            func_78607_b((float)p_78608_2_ + 0.375F, (float)p_78608_2_ + 0.625F, (float)p_78608_3_ + 0.375F, (float)p_78608_3_ + 0.375F, (((float)p_78608_4_ - 0.25F) + 1.0F) - f1, ((float)p_78608_4_ - 0.25F) + 1.0F, f * 0.5F, d);
            func_78607_b((float)p_78608_2_ + 0.625F, (float)p_78608_2_ + 0.375F, (float)p_78608_3_ + 0.625F, (float)p_78608_3_ + 0.625F, (((float)p_78608_4_ - 0.25F) + 1.0F) - f1, ((float)p_78608_4_ - 0.25F) + 1.0F, f, d);
            break;

        case 4: // '\004'
            field_78662_g = 1;
            field_78683_h = 2;
            field_78681_k = 2;
            field_78675_l = 1;
            p_78608_1_.func_71905_a(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
            func_78570_q(p_78608_1_, p_78608_2_, p_78608_3_, p_78608_4_);
            func_78571_c((float)p_78608_2_ + 0.25F, (float)p_78608_2_ + 0.25F + f1, (float)p_78608_3_ + 0.375F, (float)p_78608_3_ + 0.375F, (float)p_78608_4_ + 0.625F, (float)p_78608_4_ + 0.375F, f * 0.5F, d);
            func_78571_c((float)p_78608_2_ + 0.25F, (float)p_78608_2_ + 0.25F + f1, (float)p_78608_3_ + 0.625F, (float)p_78608_3_ + 0.625F, (float)p_78608_4_ + 0.375F, (float)p_78608_4_ + 0.625F, f, d);
            func_78571_c((float)p_78608_2_ + 0.25F, (float)p_78608_2_ + 0.25F + f1, (float)p_78608_3_ + 0.375F, (float)p_78608_3_ + 0.625F, (float)p_78608_4_ + 0.375F, (float)p_78608_4_ + 0.375F, f * 0.6F, d);
            func_78571_c((float)p_78608_2_ + 0.25F, (float)p_78608_2_ + 0.25F + f1, (float)p_78608_3_ + 0.625F, (float)p_78608_3_ + 0.375F, (float)p_78608_4_ + 0.625F, (float)p_78608_4_ + 0.625F, f * 0.6F, d);
            break;

        case 5: // '\005'
            field_78662_g = 2;
            field_78683_h = 1;
            field_78681_k = 1;
            field_78675_l = 2;
            p_78608_1_.func_71905_a(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            func_78570_q(p_78608_1_, p_78608_2_, p_78608_3_, p_78608_4_);
            func_78571_c((((float)p_78608_2_ - 0.25F) + 1.0F) - f1, ((float)p_78608_2_ - 0.25F) + 1.0F, (float)p_78608_3_ + 0.375F, (float)p_78608_3_ + 0.375F, (float)p_78608_4_ + 0.625F, (float)p_78608_4_ + 0.375F, f * 0.5F, d);
            func_78571_c((((float)p_78608_2_ - 0.25F) + 1.0F) - f1, ((float)p_78608_2_ - 0.25F) + 1.0F, (float)p_78608_3_ + 0.625F, (float)p_78608_3_ + 0.625F, (float)p_78608_4_ + 0.375F, (float)p_78608_4_ + 0.625F, f, d);
            func_78571_c((((float)p_78608_2_ - 0.25F) + 1.0F) - f1, ((float)p_78608_2_ - 0.25F) + 1.0F, (float)p_78608_3_ + 0.375F, (float)p_78608_3_ + 0.625F, (float)p_78608_4_ + 0.375F, (float)p_78608_4_ + 0.375F, f * 0.6F, d);
            func_78571_c((((float)p_78608_2_ - 0.25F) + 1.0F) - f1, ((float)p_78608_2_ - 0.25F) + 1.0F, (float)p_78608_3_ + 0.625F, (float)p_78608_3_ + 0.375F, (float)p_78608_4_ + 0.625F, (float)p_78608_4_ + 0.625F, f * 0.6F, d);
            break;
        }
        field_78662_g = 0;
        field_78683_h = 0;
        field_78685_i = 0;
        field_78679_j = 0;
        field_78681_k = 0;
        field_78675_l = 0;
        p_78608_1_.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        return true;
    }

    public boolean func_78594_e(Block p_78594_1_, int p_78594_2_, int p_78594_3_, int p_78594_4_)
    {
        int i = field_78669_a.func_72805_g(p_78594_2_, p_78594_3_, p_78594_4_);
        int j = i & 7;
        boolean flag = (i & 8) > 0;
        Tessellator tessellator = Tessellator.field_78398_a;
        boolean flag1 = field_78664_d >= 0;
        if(!flag1)
        {
            field_78664_d = Block.field_71978_w.field_72059_bZ;
        }
        float f = 0.25F;
        float f1 = 0.1875F;
        float f2 = 0.1875F;
        if(j == 5)
        {
            p_78594_1_.func_71905_a(0.5F - f1, 0.0F, 0.5F - f, 0.5F + f1, f2, 0.5F + f);
        } else
        if(j == 6)
        {
            p_78594_1_.func_71905_a(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, f2, 0.5F + f1);
        } else
        if(j == 4)
        {
            p_78594_1_.func_71905_a(0.5F - f1, 0.5F - f, 1.0F - f2, 0.5F + f1, 0.5F + f, 1.0F);
        } else
        if(j == 3)
        {
            p_78594_1_.func_71905_a(0.5F - f1, 0.5F - f, 0.0F, 0.5F + f1, 0.5F + f, f2);
        } else
        if(j == 2)
        {
            p_78594_1_.func_71905_a(1.0F - f2, 0.5F - f, 0.5F - f1, 1.0F, 0.5F + f, 0.5F + f1);
        } else
        if(j == 1)
        {
            p_78594_1_.func_71905_a(0.0F, 0.5F - f, 0.5F - f1, f2, 0.5F + f, 0.5F + f1);
        } else
        if(j == 0)
        {
            p_78594_1_.func_71905_a(0.5F - f, 1.0F - f2, 0.5F - f1, 0.5F + f, 1.0F, 0.5F + f1);
        } else
        if(j == 7)
        {
            p_78594_1_.func_71905_a(0.5F - f1, 1.0F - f2, 0.5F - f, 0.5F + f1, 1.0F, 0.5F + f);
        }
        func_78570_q(p_78594_1_, p_78594_2_, p_78594_3_, p_78594_4_);
        if(!flag1)
        {
            field_78664_d = -1;
        }
        tessellator.func_78380_c(p_78594_1_.func_71874_e(field_78669_a, p_78594_2_, p_78594_3_, p_78594_4_));
        float f3 = 1.0F;
        if(Block.field_71984_q[p_78594_1_.field_71990_ca] > 0)
        {
            f3 = 1.0F;
        }
        tessellator.func_78386_a(f3, f3, f3);
        int k = p_78594_1_.func_71851_a(0);
        if(field_78664_d >= 0)
        {
            k = field_78664_d;
        }
        int l = (k & 0xf) << 4;
        int i1 = k & 0xf0;
        float f4 = (float)l / 256F;
        float f5 = ((float)l + 15.99F) / 256F;
        float f6 = (float)i1 / 256F;
        float f7 = ((float)i1 + 15.99F) / 256F;
        Vec3 avec3[] = new Vec3[8];
        float f8 = 0.0625F;
        float f9 = 0.0625F;
        float f10 = 0.625F;
        avec3[0] = Vec3.func_72437_a().func_72345_a(-f8, 0.0D, -f9);
        avec3[1] = Vec3.func_72437_a().func_72345_a(f8, 0.0D, -f9);
        avec3[2] = Vec3.func_72437_a().func_72345_a(f8, 0.0D, f9);
        avec3[3] = Vec3.func_72437_a().func_72345_a(-f8, 0.0D, f9);
        avec3[4] = Vec3.func_72437_a().func_72345_a(-f8, f10, -f9);
        avec3[5] = Vec3.func_72437_a().func_72345_a(f8, f10, -f9);
        avec3[6] = Vec3.func_72437_a().func_72345_a(f8, f10, f9);
        avec3[7] = Vec3.func_72437_a().func_72345_a(-f8, f10, f9);
        for(int j1 = 0; j1 < 8; j1++)
        {
            if(flag)
            {
                avec3[j1].field_72449_c -= 0.0625D;
                avec3[j1].func_72440_a(0.6981317F);
            } else
            {
                avec3[j1].field_72449_c += 0.0625D;
                avec3[j1].func_72440_a(-0.6981317F);
            }
            if(j == 0 || j == 7)
            {
                avec3[j1].func_72446_c(3.141593F);
            }
            if(j == 6 || j == 0)
            {
                avec3[j1].func_72442_b(1.570796F);
            }
            if(j > 0 && j < 5)
            {
                avec3[j1].field_72448_b -= 0.375D;
                avec3[j1].func_72440_a(1.570796F);
                if(j == 4)
                {
                    avec3[j1].func_72442_b(0.0F);
                }
                if(j == 3)
                {
                    avec3[j1].func_72442_b(3.141593F);
                }
                if(j == 2)
                {
                    avec3[j1].func_72442_b(1.570796F);
                }
                if(j == 1)
                {
                    avec3[j1].func_72442_b(-1.570796F);
                }
                avec3[j1].field_72450_a += (double)p_78594_2_ + 0.5D;
                avec3[j1].field_72448_b += (float)p_78594_3_ + 0.5F;
                avec3[j1].field_72449_c += (double)p_78594_4_ + 0.5D;
                continue;
            }
            if(j == 0 || j == 7)
            {
                avec3[j1].field_72450_a += (double)p_78594_2_ + 0.5D;
                avec3[j1].field_72448_b += (float)p_78594_3_ + 0.875F;
                avec3[j1].field_72449_c += (double)p_78594_4_ + 0.5D;
            } else
            {
                avec3[j1].field_72450_a += (double)p_78594_2_ + 0.5D;
                avec3[j1].field_72448_b += (float)p_78594_3_ + 0.125F;
                avec3[j1].field_72449_c += (double)p_78594_4_ + 0.5D;
            }
        }

        Vec3 vec3 = null;
        Vec3 vec3_1 = null;
        Vec3 vec3_2 = null;
        Vec3 vec3_3 = null;
        for(int k1 = 0; k1 < 6; k1++)
        {
            if(k1 == 0)
            {
                f4 = (float)(l + 7) / 256F;
                f5 = ((float)(l + 9) - 0.01F) / 256F;
                f6 = (float)(i1 + 6) / 256F;
                f7 = ((float)(i1 + 8) - 0.01F) / 256F;
            } else
            if(k1 == 2)
            {
                f4 = (float)(l + 7) / 256F;
                f5 = ((float)(l + 9) - 0.01F) / 256F;
                f6 = (float)(i1 + 6) / 256F;
                f7 = ((float)(i1 + 16) - 0.01F) / 256F;
            }
            if(k1 == 0)
            {
                vec3 = avec3[0];
                vec3_1 = avec3[1];
                vec3_2 = avec3[2];
                vec3_3 = avec3[3];
            } else
            if(k1 == 1)
            {
                vec3 = avec3[7];
                vec3_1 = avec3[6];
                vec3_2 = avec3[5];
                vec3_3 = avec3[4];
            } else
            if(k1 == 2)
            {
                vec3 = avec3[1];
                vec3_1 = avec3[0];
                vec3_2 = avec3[4];
                vec3_3 = avec3[5];
            } else
            if(k1 == 3)
            {
                vec3 = avec3[2];
                vec3_1 = avec3[1];
                vec3_2 = avec3[5];
                vec3_3 = avec3[6];
            } else
            if(k1 == 4)
            {
                vec3 = avec3[3];
                vec3_1 = avec3[2];
                vec3_2 = avec3[6];
                vec3_3 = avec3[7];
            } else
            if(k1 == 5)
            {
                vec3 = avec3[0];
                vec3_1 = avec3[3];
                vec3_2 = avec3[7];
                vec3_3 = avec3[4];
            }
            tessellator.func_78374_a(vec3.field_72450_a, vec3.field_72448_b, vec3.field_72449_c, f4, f7);
            tessellator.func_78374_a(vec3_1.field_72450_a, vec3_1.field_72448_b, vec3_1.field_72449_c, f5, f7);
            tessellator.func_78374_a(vec3_2.field_72450_a, vec3_2.field_72448_b, vec3_2.field_72449_c, f5, f6);
            tessellator.func_78374_a(vec3_3.field_72450_a, vec3_3.field_72448_b, vec3_3.field_72449_c, f4, f6);
        }

        return true;
    }

    public boolean func_78577_f(Block p_78577_1_, int p_78577_2_, int p_78577_3_, int p_78577_4_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        int i = field_78669_a.func_72805_g(p_78577_2_, p_78577_3_, p_78577_4_);
        int j = i & 3;
        boolean flag = (i & 4) == 4;
        boolean flag1 = (i & 8) == 8;
        boolean flag2 = !field_78669_a.func_72797_t(p_78577_2_, p_78577_3_ - 1, p_78577_4_);
        boolean flag3 = field_78664_d >= 0;
        if(!flag3)
        {
            field_78664_d = Block.field_71988_x.field_72059_bZ;
        }
        float f = 0.25F;
        float f1 = 0.125F;
        float f2 = 0.125F;
        float f3 = 0.3F - f;
        float f4 = 0.3F + f;
        if(j == 2)
        {
            p_78577_1_.func_71905_a(0.5F - f1, f3, 1.0F - f2, 0.5F + f1, f4, 1.0F);
        } else
        if(j == 0)
        {
            p_78577_1_.func_71905_a(0.5F - f1, f3, 0.0F, 0.5F + f1, f4, f2);
        } else
        if(j == 1)
        {
            p_78577_1_.func_71905_a(1.0F - f2, f3, 0.5F - f1, 1.0F, f4, 0.5F + f1);
        } else
        if(j == 3)
        {
            p_78577_1_.func_71905_a(0.0F, f3, 0.5F - f1, f2, f4, 0.5F + f1);
        }
        func_78570_q(p_78577_1_, p_78577_2_, p_78577_3_, p_78577_4_);
        if(!flag3)
        {
            field_78664_d = -1;
        }
        tessellator.func_78380_c(p_78577_1_.func_71874_e(field_78669_a, p_78577_2_, p_78577_3_, p_78577_4_));
        float f5 = 1.0F;
        if(Block.field_71984_q[p_78577_1_.field_71990_ca] > 0)
        {
            f5 = 1.0F;
        }
        tessellator.func_78386_a(f5, f5, f5);
        int k = p_78577_1_.func_71851_a(0);
        if(field_78664_d >= 0)
        {
            k = field_78664_d;
        }
        int l = (k & 0xf) << 4;
        int i1 = k & 0xf0;
        float f6 = (float)l / 256F;
        float f7 = ((float)l + 15.99F) / 256F;
        float f8 = (float)i1 / 256F;
        float f9 = ((float)i1 + 15.99F) / 256F;
        Vec3 avec3[] = new Vec3[8];
        float f10 = 0.046875F;
        float f11 = 0.046875F;
        float f12 = 0.3125F;
        avec3[0] = Vec3.func_72437_a().func_72345_a(-f10, 0.0D, -f11);
        avec3[1] = Vec3.func_72437_a().func_72345_a(f10, 0.0D, -f11);
        avec3[2] = Vec3.func_72437_a().func_72345_a(f10, 0.0D, f11);
        avec3[3] = Vec3.func_72437_a().func_72345_a(-f10, 0.0D, f11);
        avec3[4] = Vec3.func_72437_a().func_72345_a(-f10, f12, -f11);
        avec3[5] = Vec3.func_72437_a().func_72345_a(f10, f12, -f11);
        avec3[6] = Vec3.func_72437_a().func_72345_a(f10, f12, f11);
        avec3[7] = Vec3.func_72437_a().func_72345_a(-f10, f12, f11);
        for(int j1 = 0; j1 < 8; j1++)
        {
            avec3[j1].field_72449_c += 0.0625D;
            if(flag1)
            {
                avec3[j1].func_72440_a(0.5235988F);
                avec3[j1].field_72448_b -= 0.4375D;
            } else
            if(flag)
            {
                avec3[j1].func_72440_a(0.08726647F);
                avec3[j1].field_72448_b -= 0.4375D;
            } else
            {
                avec3[j1].func_72440_a(-0.6981317F);
                avec3[j1].field_72448_b -= 0.375D;
            }
            avec3[j1].func_72440_a(1.570796F);
            if(j == 2)
            {
                avec3[j1].func_72442_b(0.0F);
            }
            if(j == 0)
            {
                avec3[j1].func_72442_b(3.141593F);
            }
            if(j == 1)
            {
                avec3[j1].func_72442_b(1.570796F);
            }
            if(j == 3)
            {
                avec3[j1].func_72442_b(-1.570796F);
            }
            avec3[j1].field_72450_a += (double)p_78577_2_ + 0.5D;
            avec3[j1].field_72448_b += (float)p_78577_3_ + 0.3125F;
            avec3[j1].field_72449_c += (double)p_78577_4_ + 0.5D;
        }

        Vec3 vec3 = null;
        Vec3 vec3_1 = null;
        Vec3 vec3_2 = null;
        Vec3 vec3_3 = null;
        byte byte0 = 7;
        byte byte1 = 9;
        byte byte2 = 9;
        byte byte3 = 16;
        for(int k1 = 0; k1 < 6; k1++)
        {
            if(k1 == 0)
            {
                vec3 = avec3[0];
                vec3_1 = avec3[1];
                vec3_2 = avec3[2];
                vec3_3 = avec3[3];
                f6 = (float)(l + byte0) / 256F;
                f7 = (float)(l + byte1) / 256F;
                f8 = (float)(i1 + byte2) / 256F;
                f9 = (float)(i1 + byte2 + 2) / 256F;
            } else
            if(k1 == 1)
            {
                vec3 = avec3[7];
                vec3_1 = avec3[6];
                vec3_2 = avec3[5];
                vec3_3 = avec3[4];
            } else
            if(k1 == 2)
            {
                vec3 = avec3[1];
                vec3_1 = avec3[0];
                vec3_2 = avec3[4];
                vec3_3 = avec3[5];
                f6 = (float)(l + byte0) / 256F;
                f7 = (float)(l + byte1) / 256F;
                f8 = (float)(i1 + byte2) / 256F;
                f9 = (float)(i1 + byte3) / 256F;
            } else
            if(k1 == 3)
            {
                vec3 = avec3[2];
                vec3_1 = avec3[1];
                vec3_2 = avec3[5];
                vec3_3 = avec3[6];
            } else
            if(k1 == 4)
            {
                vec3 = avec3[3];
                vec3_1 = avec3[2];
                vec3_2 = avec3[6];
                vec3_3 = avec3[7];
            } else
            if(k1 == 5)
            {
                vec3 = avec3[0];
                vec3_1 = avec3[3];
                vec3_2 = avec3[7];
                vec3_3 = avec3[4];
            }
            tessellator.func_78374_a(vec3.field_72450_a, vec3.field_72448_b, vec3.field_72449_c, f6, f9);
            tessellator.func_78374_a(vec3_1.field_72450_a, vec3_1.field_72448_b, vec3_1.field_72449_c, f7, f9);
            tessellator.func_78374_a(vec3_2.field_72450_a, vec3_2.field_72448_b, vec3_2.field_72449_c, f7, f8);
            tessellator.func_78374_a(vec3_3.field_72450_a, vec3_3.field_72448_b, vec3_3.field_72449_c, f6, f8);
        }

        float f13 = 0.09375F;
        float f14 = 0.09375F;
        float f15 = 0.03125F;
        avec3[0] = Vec3.func_72437_a().func_72345_a(-f13, 0.0D, -f14);
        avec3[1] = Vec3.func_72437_a().func_72345_a(f13, 0.0D, -f14);
        avec3[2] = Vec3.func_72437_a().func_72345_a(f13, 0.0D, f14);
        avec3[3] = Vec3.func_72437_a().func_72345_a(-f13, 0.0D, f14);
        avec3[4] = Vec3.func_72437_a().func_72345_a(-f13, f15, -f14);
        avec3[5] = Vec3.func_72437_a().func_72345_a(f13, f15, -f14);
        avec3[6] = Vec3.func_72437_a().func_72345_a(f13, f15, f14);
        avec3[7] = Vec3.func_72437_a().func_72345_a(-f13, f15, f14);
        for(int l1 = 0; l1 < 8; l1++)
        {
            avec3[l1].field_72449_c += 0.21875D;
            if(flag1)
            {
                avec3[l1].field_72448_b -= 0.09375D;
                avec3[l1].field_72449_c -= 0.16250000000000001D;
                avec3[l1].func_72440_a(0.0F);
            } else
            if(flag)
            {
                avec3[l1].field_72448_b += 0.015625D;
                avec3[l1].field_72449_c -= 0.171875D;
                avec3[l1].func_72440_a(0.1745329F);
            } else
            {
                avec3[l1].func_72440_a(0.8726646F);
            }
            if(j == 2)
            {
                avec3[l1].func_72442_b(0.0F);
            }
            if(j == 0)
            {
                avec3[l1].func_72442_b(3.141593F);
            }
            if(j == 1)
            {
                avec3[l1].func_72442_b(1.570796F);
            }
            if(j == 3)
            {
                avec3[l1].func_72442_b(-1.570796F);
            }
            avec3[l1].field_72450_a += (double)p_78577_2_ + 0.5D;
            avec3[l1].field_72448_b += (float)p_78577_3_ + 0.3125F;
            avec3[l1].field_72449_c += (double)p_78577_4_ + 0.5D;
        }

        byte byte4 = 5;
        byte byte5 = 11;
        byte byte6 = 3;
        byte byte7 = 9;
        for(int i2 = 0; i2 < 6; i2++)
        {
            if(i2 == 0)
            {
                vec3 = avec3[0];
                vec3_1 = avec3[1];
                vec3_2 = avec3[2];
                vec3_3 = avec3[3];
                f6 = (float)(l + byte4) / 256F;
                f7 = (float)(l + byte5) / 256F;
                f8 = (float)(i1 + byte6) / 256F;
                f9 = (float)(i1 + byte7) / 256F;
            } else
            if(i2 == 1)
            {
                vec3 = avec3[7];
                vec3_1 = avec3[6];
                vec3_2 = avec3[5];
                vec3_3 = avec3[4];
            } else
            if(i2 == 2)
            {
                vec3 = avec3[1];
                vec3_1 = avec3[0];
                vec3_2 = avec3[4];
                vec3_3 = avec3[5];
                f6 = (float)(l + byte4) / 256F;
                f7 = (float)(l + byte5) / 256F;
                f8 = (float)(i1 + byte6) / 256F;
                f9 = (float)(i1 + byte6 + 2) / 256F;
            } else
            if(i2 == 3)
            {
                vec3 = avec3[2];
                vec3_1 = avec3[1];
                vec3_2 = avec3[5];
                vec3_3 = avec3[6];
            } else
            if(i2 == 4)
            {
                vec3 = avec3[3];
                vec3_1 = avec3[2];
                vec3_2 = avec3[6];
                vec3_3 = avec3[7];
            } else
            if(i2 == 5)
            {
                vec3 = avec3[0];
                vec3_1 = avec3[3];
                vec3_2 = avec3[7];
                vec3_3 = avec3[4];
            }
            tessellator.func_78374_a(vec3.field_72450_a, vec3.field_72448_b, vec3.field_72449_c, f6, f9);
            tessellator.func_78374_a(vec3_1.field_72450_a, vec3_1.field_72448_b, vec3_1.field_72449_c, f7, f9);
            tessellator.func_78374_a(vec3_2.field_72450_a, vec3_2.field_72448_b, vec3_2.field_72449_c, f7, f8);
            tessellator.func_78374_a(vec3_3.field_72450_a, vec3_3.field_72448_b, vec3_3.field_72449_c, f6, f8);
        }

        if(flag)
        {
            double d = avec3[0].field_72448_b;
            float f16 = 0.03125F;
            float f17 = 0.5F - f16 / 2.0F;
            float f18 = f17 + f16;
            int j2 = (Block.field_72062_bU.field_72059_bZ & 0xf) << 4;
            int k2 = Block.field_72062_bU.field_72059_bZ & 0xf0;
            double d1 = (float)j2 / 256F;
            double d2 = (float)(j2 + 16) / 256F;
            double d3 = (float)(k2 + (flag ? 2 : 0)) / 256F;
            double d4 = (float)(k2 + (flag ? 4 : 2)) / 256F;
            double d5 = (double)(flag2 ? 3.5F : 1.5F) / 16D;
            float f19 = p_78577_1_.func_71870_f(field_78669_a, p_78577_2_, p_78577_3_, p_78577_4_) * 0.75F;
            tessellator.func_78386_a(f19, f19, f19);
            if(j == 2)
            {
                tessellator.func_78374_a((float)p_78577_2_ + f17, (double)p_78577_3_ + d5, (double)p_78577_4_ + 0.25D, d1, d3);
                tessellator.func_78374_a((float)p_78577_2_ + f18, (double)p_78577_3_ + d5, (double)p_78577_4_ + 0.25D, d1, d4);
                tessellator.func_78374_a((float)p_78577_2_ + f18, (double)p_78577_3_ + d5, p_78577_4_, d2, d4);
                tessellator.func_78374_a((float)p_78577_2_ + f17, (double)p_78577_3_ + d5, p_78577_4_, d2, d3);
                tessellator.func_78374_a((float)p_78577_2_ + f17, d, (double)p_78577_4_ + 0.5D, d1, d3);
                tessellator.func_78374_a((float)p_78577_2_ + f18, d, (double)p_78577_4_ + 0.5D, d1, d4);
                tessellator.func_78374_a((float)p_78577_2_ + f18, (double)p_78577_3_ + d5, (double)p_78577_4_ + 0.25D, d2, d4);
                tessellator.func_78374_a((float)p_78577_2_ + f17, (double)p_78577_3_ + d5, (double)p_78577_4_ + 0.25D, d2, d3);
            } else
            if(j == 0)
            {
                tessellator.func_78374_a((float)p_78577_2_ + f17, (double)p_78577_3_ + d5, (double)p_78577_4_ + 0.75D, d1, d3);
                tessellator.func_78374_a((float)p_78577_2_ + f18, (double)p_78577_3_ + d5, (double)p_78577_4_ + 0.75D, d1, d4);
                tessellator.func_78374_a((float)p_78577_2_ + f18, d, (double)p_78577_4_ + 0.5D, d2, d4);
                tessellator.func_78374_a((float)p_78577_2_ + f17, d, (double)p_78577_4_ + 0.5D, d2, d3);
                tessellator.func_78374_a((float)p_78577_2_ + f17, (double)p_78577_3_ + d5, p_78577_4_ + 1, d1, d3);
                tessellator.func_78374_a((float)p_78577_2_ + f18, (double)p_78577_3_ + d5, p_78577_4_ + 1, d1, d4);
                tessellator.func_78374_a((float)p_78577_2_ + f18, (double)p_78577_3_ + d5, (double)p_78577_4_ + 0.75D, d2, d4);
                tessellator.func_78374_a((float)p_78577_2_ + f17, (double)p_78577_3_ + d5, (double)p_78577_4_ + 0.75D, d2, d3);
            } else
            if(j == 1)
            {
                tessellator.func_78374_a(p_78577_2_, (double)p_78577_3_ + d5, (float)p_78577_4_ + f18, d1, d4);
                tessellator.func_78374_a((double)p_78577_2_ + 0.25D, (double)p_78577_3_ + d5, (float)p_78577_4_ + f18, d2, d4);
                tessellator.func_78374_a((double)p_78577_2_ + 0.25D, (double)p_78577_3_ + d5, (float)p_78577_4_ + f17, d2, d3);
                tessellator.func_78374_a(p_78577_2_, (double)p_78577_3_ + d5, (float)p_78577_4_ + f17, d1, d3);
                tessellator.func_78374_a((double)p_78577_2_ + 0.25D, (double)p_78577_3_ + d5, (float)p_78577_4_ + f18, d1, d4);
                tessellator.func_78374_a((double)p_78577_2_ + 0.5D, d, (float)p_78577_4_ + f18, d2, d4);
                tessellator.func_78374_a((double)p_78577_2_ + 0.5D, d, (float)p_78577_4_ + f17, d2, d3);
                tessellator.func_78374_a((double)p_78577_2_ + 0.25D, (double)p_78577_3_ + d5, (float)p_78577_4_ + f17, d1, d3);
            } else
            {
                tessellator.func_78374_a((double)p_78577_2_ + 0.5D, d, (float)p_78577_4_ + f18, d1, d4);
                tessellator.func_78374_a((double)p_78577_2_ + 0.75D, (double)p_78577_3_ + d5, (float)p_78577_4_ + f18, d2, d4);
                tessellator.func_78374_a((double)p_78577_2_ + 0.75D, (double)p_78577_3_ + d5, (float)p_78577_4_ + f17, d2, d3);
                tessellator.func_78374_a((double)p_78577_2_ + 0.5D, d, (float)p_78577_4_ + f17, d1, d3);
                tessellator.func_78374_a((double)p_78577_2_ + 0.75D, (double)p_78577_3_ + d5, (float)p_78577_4_ + f18, d1, d4);
                tessellator.func_78374_a(p_78577_2_ + 1, (double)p_78577_3_ + d5, (float)p_78577_4_ + f18, d2, d4);
                tessellator.func_78374_a(p_78577_2_ + 1, (double)p_78577_3_ + d5, (float)p_78577_4_ + f17, d2, d3);
                tessellator.func_78374_a((double)p_78577_2_ + 0.75D, (double)p_78577_3_ + d5, (float)p_78577_4_ + f17, d1, d3);
            }
        }
        return true;
    }

    public boolean func_78619_g(Block p_78619_1_, int p_78619_2_, int p_78619_3_, int p_78619_4_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        int i = p_78619_1_.func_71851_a(0);
        int j = field_78669_a.func_72805_g(p_78619_2_, p_78619_3_, p_78619_4_);
        boolean flag = (j & 4) == 4;
        boolean flag1 = (j & 2) == 2;
        if(field_78664_d >= 0)
        {
            i = field_78664_d;
        }
        tessellator.func_78380_c(p_78619_1_.func_71874_e(field_78669_a, p_78619_2_, p_78619_3_, p_78619_4_));
        float f = p_78619_1_.func_71870_f(field_78669_a, p_78619_2_, p_78619_3_, p_78619_4_) * 0.75F;
        tessellator.func_78386_a(f, f, f);
        int k = (i & 0xf) << 4;
        int l = i & 0xf0;
        double d = (float)k / 256F;
        double d1 = (float)(k + 16) / 256F;
        double d2 = (float)(l + (flag ? 2 : 0)) / 256F;
        double d3 = (float)(l + (flag ? 4 : 2)) / 256F;
        double d4 = (double)(flag1 ? 3.5F : 1.5F) / 16D;
        boolean flag2 = BlockTripWire.func_72148_a(field_78669_a, p_78619_2_, p_78619_3_, p_78619_4_, j, 1);
        boolean flag3 = BlockTripWire.func_72148_a(field_78669_a, p_78619_2_, p_78619_3_, p_78619_4_, j, 3);
        boolean flag4 = BlockTripWire.func_72148_a(field_78669_a, p_78619_2_, p_78619_3_, p_78619_4_, j, 2);
        boolean flag5 = BlockTripWire.func_72148_a(field_78669_a, p_78619_2_, p_78619_3_, p_78619_4_, j, 0);
        float f1 = 0.03125F;
        float f2 = 0.5F - f1 / 2.0F;
        float f3 = f2 + f1;
        if(!flag4 && !flag3 && !flag5 && !flag2)
        {
            flag4 = true;
            flag5 = true;
        }
        if(flag4)
        {
            tessellator.func_78374_a((float)p_78619_2_ + f2, (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.25D, d, d2);
            tessellator.func_78374_a((float)p_78619_2_ + f3, (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.25D, d, d3);
            tessellator.func_78374_a((float)p_78619_2_ + f3, (double)p_78619_3_ + d4, p_78619_4_, d1, d3);
            tessellator.func_78374_a((float)p_78619_2_ + f2, (double)p_78619_3_ + d4, p_78619_4_, d1, d2);
            tessellator.func_78374_a((float)p_78619_2_ + f2, (double)p_78619_3_ + d4, p_78619_4_, d1, d2);
            tessellator.func_78374_a((float)p_78619_2_ + f3, (double)p_78619_3_ + d4, p_78619_4_, d1, d3);
            tessellator.func_78374_a((float)p_78619_2_ + f3, (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.25D, d, d3);
            tessellator.func_78374_a((float)p_78619_2_ + f2, (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.25D, d, d2);
        }
        if(flag4 || flag5 && !flag3 && !flag2)
        {
            tessellator.func_78374_a((float)p_78619_2_ + f2, (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.5D, d, d2);
            tessellator.func_78374_a((float)p_78619_2_ + f3, (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.5D, d, d3);
            tessellator.func_78374_a((float)p_78619_2_ + f3, (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.25D, d1, d3);
            tessellator.func_78374_a((float)p_78619_2_ + f2, (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.25D, d1, d2);
            tessellator.func_78374_a((float)p_78619_2_ + f2, (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.25D, d1, d2);
            tessellator.func_78374_a((float)p_78619_2_ + f3, (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.25D, d1, d3);
            tessellator.func_78374_a((float)p_78619_2_ + f3, (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.5D, d, d3);
            tessellator.func_78374_a((float)p_78619_2_ + f2, (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.5D, d, d2);
        }
        if(flag5 || flag4 && !flag3 && !flag2)
        {
            tessellator.func_78374_a((float)p_78619_2_ + f2, (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.75D, d, d2);
            tessellator.func_78374_a((float)p_78619_2_ + f3, (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.75D, d, d3);
            tessellator.func_78374_a((float)p_78619_2_ + f3, (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.5D, d1, d3);
            tessellator.func_78374_a((float)p_78619_2_ + f2, (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.5D, d1, d2);
            tessellator.func_78374_a((float)p_78619_2_ + f2, (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.5D, d1, d2);
            tessellator.func_78374_a((float)p_78619_2_ + f3, (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.5D, d1, d3);
            tessellator.func_78374_a((float)p_78619_2_ + f3, (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.75D, d, d3);
            tessellator.func_78374_a((float)p_78619_2_ + f2, (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.75D, d, d2);
        }
        if(flag5)
        {
            tessellator.func_78374_a((float)p_78619_2_ + f2, (double)p_78619_3_ + d4, p_78619_4_ + 1, d, d2);
            tessellator.func_78374_a((float)p_78619_2_ + f3, (double)p_78619_3_ + d4, p_78619_4_ + 1, d, d3);
            tessellator.func_78374_a((float)p_78619_2_ + f3, (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.75D, d1, d3);
            tessellator.func_78374_a((float)p_78619_2_ + f2, (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.75D, d1, d2);
            tessellator.func_78374_a((float)p_78619_2_ + f2, (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.75D, d1, d2);
            tessellator.func_78374_a((float)p_78619_2_ + f3, (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.75D, d1, d3);
            tessellator.func_78374_a((float)p_78619_2_ + f3, (double)p_78619_3_ + d4, p_78619_4_ + 1, d, d3);
            tessellator.func_78374_a((float)p_78619_2_ + f2, (double)p_78619_3_ + d4, p_78619_4_ + 1, d, d2);
        }
        if(flag2)
        {
            tessellator.func_78374_a(p_78619_2_, (double)p_78619_3_ + d4, (float)p_78619_4_ + f3, d, d3);
            tessellator.func_78374_a((double)p_78619_2_ + 0.25D, (double)p_78619_3_ + d4, (float)p_78619_4_ + f3, d1, d3);
            tessellator.func_78374_a((double)p_78619_2_ + 0.25D, (double)p_78619_3_ + d4, (float)p_78619_4_ + f2, d1, d2);
            tessellator.func_78374_a(p_78619_2_, (double)p_78619_3_ + d4, (float)p_78619_4_ + f2, d, d2);
            tessellator.func_78374_a(p_78619_2_, (double)p_78619_3_ + d4, (float)p_78619_4_ + f2, d, d2);
            tessellator.func_78374_a((double)p_78619_2_ + 0.25D, (double)p_78619_3_ + d4, (float)p_78619_4_ + f2, d1, d2);
            tessellator.func_78374_a((double)p_78619_2_ + 0.25D, (double)p_78619_3_ + d4, (float)p_78619_4_ + f3, d1, d3);
            tessellator.func_78374_a(p_78619_2_, (double)p_78619_3_ + d4, (float)p_78619_4_ + f3, d, d3);
        }
        if(flag2 || flag3 && !flag4 && !flag5)
        {
            tessellator.func_78374_a((double)p_78619_2_ + 0.25D, (double)p_78619_3_ + d4, (float)p_78619_4_ + f3, d, d3);
            tessellator.func_78374_a((double)p_78619_2_ + 0.5D, (double)p_78619_3_ + d4, (float)p_78619_4_ + f3, d1, d3);
            tessellator.func_78374_a((double)p_78619_2_ + 0.5D, (double)p_78619_3_ + d4, (float)p_78619_4_ + f2, d1, d2);
            tessellator.func_78374_a((double)p_78619_2_ + 0.25D, (double)p_78619_3_ + d4, (float)p_78619_4_ + f2, d, d2);
            tessellator.func_78374_a((double)p_78619_2_ + 0.25D, (double)p_78619_3_ + d4, (float)p_78619_4_ + f2, d, d2);
            tessellator.func_78374_a((double)p_78619_2_ + 0.5D, (double)p_78619_3_ + d4, (float)p_78619_4_ + f2, d1, d2);
            tessellator.func_78374_a((double)p_78619_2_ + 0.5D, (double)p_78619_3_ + d4, (float)p_78619_4_ + f3, d1, d3);
            tessellator.func_78374_a((double)p_78619_2_ + 0.25D, (double)p_78619_3_ + d4, (float)p_78619_4_ + f3, d, d3);
        }
        if(flag3 || flag2 && !flag4 && !flag5)
        {
            tessellator.func_78374_a((double)p_78619_2_ + 0.5D, (double)p_78619_3_ + d4, (float)p_78619_4_ + f3, d, d3);
            tessellator.func_78374_a((double)p_78619_2_ + 0.75D, (double)p_78619_3_ + d4, (float)p_78619_4_ + f3, d1, d3);
            tessellator.func_78374_a((double)p_78619_2_ + 0.75D, (double)p_78619_3_ + d4, (float)p_78619_4_ + f2, d1, d2);
            tessellator.func_78374_a((double)p_78619_2_ + 0.5D, (double)p_78619_3_ + d4, (float)p_78619_4_ + f2, d, d2);
            tessellator.func_78374_a((double)p_78619_2_ + 0.5D, (double)p_78619_3_ + d4, (float)p_78619_4_ + f2, d, d2);
            tessellator.func_78374_a((double)p_78619_2_ + 0.75D, (double)p_78619_3_ + d4, (float)p_78619_4_ + f2, d1, d2);
            tessellator.func_78374_a((double)p_78619_2_ + 0.75D, (double)p_78619_3_ + d4, (float)p_78619_4_ + f3, d1, d3);
            tessellator.func_78374_a((double)p_78619_2_ + 0.5D, (double)p_78619_3_ + d4, (float)p_78619_4_ + f3, d, d3);
        }
        if(flag3)
        {
            tessellator.func_78374_a((double)p_78619_2_ + 0.75D, (double)p_78619_3_ + d4, (float)p_78619_4_ + f3, d, d3);
            tessellator.func_78374_a(p_78619_2_ + 1, (double)p_78619_3_ + d4, (float)p_78619_4_ + f3, d1, d3);
            tessellator.func_78374_a(p_78619_2_ + 1, (double)p_78619_3_ + d4, (float)p_78619_4_ + f2, d1, d2);
            tessellator.func_78374_a((double)p_78619_2_ + 0.75D, (double)p_78619_3_ + d4, (float)p_78619_4_ + f2, d, d2);
            tessellator.func_78374_a((double)p_78619_2_ + 0.75D, (double)p_78619_3_ + d4, (float)p_78619_4_ + f2, d, d2);
            tessellator.func_78374_a(p_78619_2_ + 1, (double)p_78619_3_ + d4, (float)p_78619_4_ + f2, d1, d2);
            tessellator.func_78374_a(p_78619_2_ + 1, (double)p_78619_3_ + d4, (float)p_78619_4_ + f3, d1, d3);
            tessellator.func_78374_a((double)p_78619_2_ + 0.75D, (double)p_78619_3_ + d4, (float)p_78619_4_ + f3, d, d3);
        }
        return true;
    }

    public boolean func_78590_h(Block p_78590_1_, int p_78590_2_, int p_78590_3_, int p_78590_4_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        int i = p_78590_1_.func_71851_a(0);
        if(field_78664_d >= 0)
        {
            i = field_78664_d;
        }
        tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
        tessellator.func_78380_c(p_78590_1_.func_71874_e(field_78669_a, p_78590_2_, p_78590_3_, p_78590_4_));
        int j = (i & 0xf) << 4;
        int k = i & 0xf0;
        double d = (float)j / 256F;
        double d1 = ((float)j + 15.99F) / 256F;
        double d2 = (float)k / 256F;
        double d3 = ((float)k + 15.99F) / 256F;
        float f = 1.4F;
        if(field_78669_a.func_72797_t(p_78590_2_, p_78590_3_ - 1, p_78590_4_) || Block.field_72067_ar.func_72256_d(field_78669_a, p_78590_2_, p_78590_3_ - 1, p_78590_4_))
        {
            double d4 = (double)p_78590_2_ + 0.5D + 0.20000000000000001D;
            double d5 = ((double)p_78590_2_ + 0.5D) - 0.20000000000000001D;
            double d8 = (double)p_78590_4_ + 0.5D + 0.20000000000000001D;
            double d10 = ((double)p_78590_4_ + 0.5D) - 0.20000000000000001D;
            double d12 = ((double)p_78590_2_ + 0.5D) - 0.29999999999999999D;
            double d14 = (double)p_78590_2_ + 0.5D + 0.29999999999999999D;
            double d16 = ((double)p_78590_4_ + 0.5D) - 0.29999999999999999D;
            double d18 = (double)p_78590_4_ + 0.5D + 0.29999999999999999D;
            tessellator.func_78374_a(d12, (float)p_78590_3_ + f, p_78590_4_ + 1, d1, d2);
            tessellator.func_78374_a(d4, p_78590_3_ + 0, p_78590_4_ + 1, d1, d3);
            tessellator.func_78374_a(d4, p_78590_3_ + 0, p_78590_4_ + 0, d, d3);
            tessellator.func_78374_a(d12, (float)p_78590_3_ + f, p_78590_4_ + 0, d, d2);
            tessellator.func_78374_a(d14, (float)p_78590_3_ + f, p_78590_4_ + 0, d1, d2);
            tessellator.func_78374_a(d5, p_78590_3_ + 0, p_78590_4_ + 0, d1, d3);
            tessellator.func_78374_a(d5, p_78590_3_ + 0, p_78590_4_ + 1, d, d3);
            tessellator.func_78374_a(d14, (float)p_78590_3_ + f, p_78590_4_ + 1, d, d2);
            d = (float)j / 256F;
            d1 = ((float)j + 15.99F) / 256F;
            d2 = (float)(k + 16) / 256F;
            d3 = ((float)k + 15.99F + 16F) / 256F;
            tessellator.func_78374_a(p_78590_2_ + 1, (float)p_78590_3_ + f, d18, d1, d2);
            tessellator.func_78374_a(p_78590_2_ + 1, p_78590_3_ + 0, d10, d1, d3);
            tessellator.func_78374_a(p_78590_2_ + 0, p_78590_3_ + 0, d10, d, d3);
            tessellator.func_78374_a(p_78590_2_ + 0, (float)p_78590_3_ + f, d18, d, d2);
            tessellator.func_78374_a(p_78590_2_ + 0, (float)p_78590_3_ + f, d16, d1, d2);
            tessellator.func_78374_a(p_78590_2_ + 0, p_78590_3_ + 0, d8, d1, d3);
            tessellator.func_78374_a(p_78590_2_ + 1, p_78590_3_ + 0, d8, d, d3);
            tessellator.func_78374_a(p_78590_2_ + 1, (float)p_78590_3_ + f, d16, d, d2);
            d4 = ((double)p_78590_2_ + 0.5D) - 0.5D;
            d5 = (double)p_78590_2_ + 0.5D + 0.5D;
            d8 = ((double)p_78590_4_ + 0.5D) - 0.5D;
            d10 = (double)p_78590_4_ + 0.5D + 0.5D;
            d12 = ((double)p_78590_2_ + 0.5D) - 0.40000000000000002D;
            d14 = (double)p_78590_2_ + 0.5D + 0.40000000000000002D;
            d16 = ((double)p_78590_4_ + 0.5D) - 0.40000000000000002D;
            d18 = (double)p_78590_4_ + 0.5D + 0.40000000000000002D;
            tessellator.func_78374_a(d12, (float)p_78590_3_ + f, p_78590_4_ + 0, d, d2);
            tessellator.func_78374_a(d4, p_78590_3_ + 0, p_78590_4_ + 0, d, d3);
            tessellator.func_78374_a(d4, p_78590_3_ + 0, p_78590_4_ + 1, d1, d3);
            tessellator.func_78374_a(d12, (float)p_78590_3_ + f, p_78590_4_ + 1, d1, d2);
            tessellator.func_78374_a(d14, (float)p_78590_3_ + f, p_78590_4_ + 1, d, d2);
            tessellator.func_78374_a(d5, p_78590_3_ + 0, p_78590_4_ + 1, d, d3);
            tessellator.func_78374_a(d5, p_78590_3_ + 0, p_78590_4_ + 0, d1, d3);
            tessellator.func_78374_a(d14, (float)p_78590_3_ + f, p_78590_4_ + 0, d1, d2);
            d = (float)j / 256F;
            d1 = ((float)j + 15.99F) / 256F;
            d2 = (float)k / 256F;
            d3 = ((float)k + 15.99F) / 256F;
            tessellator.func_78374_a(p_78590_2_ + 0, (float)p_78590_3_ + f, d18, d, d2);
            tessellator.func_78374_a(p_78590_2_ + 0, p_78590_3_ + 0, d10, d, d3);
            tessellator.func_78374_a(p_78590_2_ + 1, p_78590_3_ + 0, d10, d1, d3);
            tessellator.func_78374_a(p_78590_2_ + 1, (float)p_78590_3_ + f, d18, d1, d2);
            tessellator.func_78374_a(p_78590_2_ + 1, (float)p_78590_3_ + f, d16, d, d2);
            tessellator.func_78374_a(p_78590_2_ + 1, p_78590_3_ + 0, d8, d, d3);
            tessellator.func_78374_a(p_78590_2_ + 0, p_78590_3_ + 0, d8, d1, d3);
            tessellator.func_78374_a(p_78590_2_ + 0, (float)p_78590_3_ + f, d16, d1, d2);
        } else
        {
            float f1 = 0.2F;
            float f2 = 0.0625F;
            if((p_78590_2_ + p_78590_3_ + p_78590_4_ & 1) == 1)
            {
                d = (float)j / 256F;
                d1 = ((float)j + 15.99F) / 256F;
                d2 = (float)(k + 16) / 256F;
                d3 = ((float)k + 15.99F + 16F) / 256F;
            }
            if((p_78590_2_ / 2 + p_78590_3_ / 2 + p_78590_4_ / 2 & 1) == 1)
            {
                double d6 = d1;
                d1 = d;
                d = d6;
            }
            if(Block.field_72067_ar.func_72256_d(field_78669_a, p_78590_2_ - 1, p_78590_3_, p_78590_4_))
            {
                tessellator.func_78374_a((float)p_78590_2_ + f1, (float)p_78590_3_ + f + f2, p_78590_4_ + 1, d1, d2);
                tessellator.func_78374_a(p_78590_2_ + 0, (float)(p_78590_3_ + 0) + f2, p_78590_4_ + 1, d1, d3);
                tessellator.func_78374_a(p_78590_2_ + 0, (float)(p_78590_3_ + 0) + f2, p_78590_4_ + 0, d, d3);
                tessellator.func_78374_a((float)p_78590_2_ + f1, (float)p_78590_3_ + f + f2, p_78590_4_ + 0, d, d2);
                tessellator.func_78374_a((float)p_78590_2_ + f1, (float)p_78590_3_ + f + f2, p_78590_4_ + 0, d, d2);
                tessellator.func_78374_a(p_78590_2_ + 0, (float)(p_78590_3_ + 0) + f2, p_78590_4_ + 0, d, d3);
                tessellator.func_78374_a(p_78590_2_ + 0, (float)(p_78590_3_ + 0) + f2, p_78590_4_ + 1, d1, d3);
                tessellator.func_78374_a((float)p_78590_2_ + f1, (float)p_78590_3_ + f + f2, p_78590_4_ + 1, d1, d2);
            }
            if(Block.field_72067_ar.func_72256_d(field_78669_a, p_78590_2_ + 1, p_78590_3_, p_78590_4_))
            {
                tessellator.func_78374_a((float)(p_78590_2_ + 1) - f1, (float)p_78590_3_ + f + f2, p_78590_4_ + 0, d, d2);
                tessellator.func_78374_a((p_78590_2_ + 1) - 0, (float)(p_78590_3_ + 0) + f2, p_78590_4_ + 0, d, d3);
                tessellator.func_78374_a((p_78590_2_ + 1) - 0, (float)(p_78590_3_ + 0) + f2, p_78590_4_ + 1, d1, d3);
                tessellator.func_78374_a((float)(p_78590_2_ + 1) - f1, (float)p_78590_3_ + f + f2, p_78590_4_ + 1, d1, d2);
                tessellator.func_78374_a((float)(p_78590_2_ + 1) - f1, (float)p_78590_3_ + f + f2, p_78590_4_ + 1, d1, d2);
                tessellator.func_78374_a((p_78590_2_ + 1) - 0, (float)(p_78590_3_ + 0) + f2, p_78590_4_ + 1, d1, d3);
                tessellator.func_78374_a((p_78590_2_ + 1) - 0, (float)(p_78590_3_ + 0) + f2, p_78590_4_ + 0, d, d3);
                tessellator.func_78374_a((float)(p_78590_2_ + 1) - f1, (float)p_78590_3_ + f + f2, p_78590_4_ + 0, d, d2);
            }
            if(Block.field_72067_ar.func_72256_d(field_78669_a, p_78590_2_, p_78590_3_, p_78590_4_ - 1))
            {
                tessellator.func_78374_a(p_78590_2_ + 0, (float)p_78590_3_ + f + f2, (float)p_78590_4_ + f1, d1, d2);
                tessellator.func_78374_a(p_78590_2_ + 0, (float)(p_78590_3_ + 0) + f2, p_78590_4_ + 0, d1, d3);
                tessellator.func_78374_a(p_78590_2_ + 1, (float)(p_78590_3_ + 0) + f2, p_78590_4_ + 0, d, d3);
                tessellator.func_78374_a(p_78590_2_ + 1, (float)p_78590_3_ + f + f2, (float)p_78590_4_ + f1, d, d2);
                tessellator.func_78374_a(p_78590_2_ + 1, (float)p_78590_3_ + f + f2, (float)p_78590_4_ + f1, d, d2);
                tessellator.func_78374_a(p_78590_2_ + 1, (float)(p_78590_3_ + 0) + f2, p_78590_4_ + 0, d, d3);
                tessellator.func_78374_a(p_78590_2_ + 0, (float)(p_78590_3_ + 0) + f2, p_78590_4_ + 0, d1, d3);
                tessellator.func_78374_a(p_78590_2_ + 0, (float)p_78590_3_ + f + f2, (float)p_78590_4_ + f1, d1, d2);
            }
            if(Block.field_72067_ar.func_72256_d(field_78669_a, p_78590_2_, p_78590_3_, p_78590_4_ + 1))
            {
                tessellator.func_78374_a(p_78590_2_ + 1, (float)p_78590_3_ + f + f2, (float)(p_78590_4_ + 1) - f1, d, d2);
                tessellator.func_78374_a(p_78590_2_ + 1, (float)(p_78590_3_ + 0) + f2, (p_78590_4_ + 1) - 0, d, d3);
                tessellator.func_78374_a(p_78590_2_ + 0, (float)(p_78590_3_ + 0) + f2, (p_78590_4_ + 1) - 0, d1, d3);
                tessellator.func_78374_a(p_78590_2_ + 0, (float)p_78590_3_ + f + f2, (float)(p_78590_4_ + 1) - f1, d1, d2);
                tessellator.func_78374_a(p_78590_2_ + 0, (float)p_78590_3_ + f + f2, (float)(p_78590_4_ + 1) - f1, d1, d2);
                tessellator.func_78374_a(p_78590_2_ + 0, (float)(p_78590_3_ + 0) + f2, (p_78590_4_ + 1) - 0, d1, d3);
                tessellator.func_78374_a(p_78590_2_ + 1, (float)(p_78590_3_ + 0) + f2, (p_78590_4_ + 1) - 0, d, d3);
                tessellator.func_78374_a(p_78590_2_ + 1, (float)p_78590_3_ + f + f2, (float)(p_78590_4_ + 1) - f1, d, d2);
            }
            if(Block.field_72067_ar.func_72256_d(field_78669_a, p_78590_2_, p_78590_3_ + 1, p_78590_4_))
            {
                double d7 = (double)p_78590_2_ + 0.5D + 0.5D;
                double d9 = ((double)p_78590_2_ + 0.5D) - 0.5D;
                double d11 = (double)p_78590_4_ + 0.5D + 0.5D;
                double d13 = ((double)p_78590_4_ + 0.5D) - 0.5D;
                double d15 = ((double)p_78590_2_ + 0.5D) - 0.5D;
                double d17 = (double)p_78590_2_ + 0.5D + 0.5D;
                double d19 = ((double)p_78590_4_ + 0.5D) - 0.5D;
                double d20 = (double)p_78590_4_ + 0.5D + 0.5D;
                double d21 = (float)j / 256F;
                double d22 = ((float)j + 15.99F) / 256F;
                double d23 = (float)k / 256F;
                double d24 = ((float)k + 15.99F) / 256F;
                p_78590_3_++;
                float f3 = -0.2F;
                if((p_78590_2_ + p_78590_3_ + p_78590_4_ & 1) == 0)
                {
                    tessellator.func_78374_a(d15, (float)p_78590_3_ + f3, p_78590_4_ + 0, d22, d23);
                    tessellator.func_78374_a(d7, p_78590_3_ + 0, p_78590_4_ + 0, d22, d24);
                    tessellator.func_78374_a(d7, p_78590_3_ + 0, p_78590_4_ + 1, d21, d24);
                    tessellator.func_78374_a(d15, (float)p_78590_3_ + f3, p_78590_4_ + 1, d21, d23);
                    d21 = (float)j / 256F;
                    d22 = ((float)j + 15.99F) / 256F;
                    d23 = (float)(k + 16) / 256F;
                    d24 = ((float)k + 15.99F + 16F) / 256F;
                    tessellator.func_78374_a(d17, (float)p_78590_3_ + f3, p_78590_4_ + 1, d22, d23);
                    tessellator.func_78374_a(d9, p_78590_3_ + 0, p_78590_4_ + 1, d22, d24);
                    tessellator.func_78374_a(d9, p_78590_3_ + 0, p_78590_4_ + 0, d21, d24);
                    tessellator.func_78374_a(d17, (float)p_78590_3_ + f3, p_78590_4_ + 0, d21, d23);
                } else
                {
                    tessellator.func_78374_a(p_78590_2_ + 0, (float)p_78590_3_ + f3, d20, d22, d23);
                    tessellator.func_78374_a(p_78590_2_ + 0, p_78590_3_ + 0, d13, d22, d24);
                    tessellator.func_78374_a(p_78590_2_ + 1, p_78590_3_ + 0, d13, d21, d24);
                    tessellator.func_78374_a(p_78590_2_ + 1, (float)p_78590_3_ + f3, d20, d21, d23);
                    d21 = (float)j / 256F;
                    d22 = ((float)j + 15.99F) / 256F;
                    d23 = (float)(k + 16) / 256F;
                    d24 = ((float)k + 15.99F + 16F) / 256F;
                    tessellator.func_78374_a(p_78590_2_ + 1, (float)p_78590_3_ + f3, d19, d22, d23);
                    tessellator.func_78374_a(p_78590_2_ + 1, p_78590_3_ + 0, d11, d22, d24);
                    tessellator.func_78374_a(p_78590_2_ + 0, p_78590_3_ + 0, d11, d21, d24);
                    tessellator.func_78374_a(p_78590_2_ + 0, (float)p_78590_3_ + f3, d19, d21, d23);
                }
            }
        }
        return true;
    }

    public boolean func_78589_i(Block p_78589_1_, int p_78589_2_, int p_78589_3_, int p_78589_4_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        int i = field_78669_a.func_72805_g(p_78589_2_, p_78589_3_, p_78589_4_);
        int j = p_78589_1_.func_71858_a(1, i);
        if(field_78664_d >= 0)
        {
            j = field_78664_d;
        }
        tessellator.func_78380_c(p_78589_1_.func_71874_e(field_78669_a, p_78589_2_, p_78589_3_, p_78589_4_));
        float f = 1.0F;
        float f1 = (float)i / 15F;
        float f2 = f1 * 0.6F + 0.4F;
        if(i == 0)
        {
            f2 = 0.3F;
        }
        float f3 = f1 * f1 * 0.7F - 0.5F;
        float f4 = f1 * f1 * 0.6F - 0.7F;
        if(f3 < 0.0F)
        {
            f3 = 0.0F;
        }
        if(f4 < 0.0F)
        {
            f4 = 0.0F;
        }
        tessellator.func_78386_a(f2, f3, f4);
        int k = (j & 0xf) << 4;
        int l = j & 0xf0;
        double d = (float)k / 256F;
        double d1 = ((float)k + 15.99F) / 256F;
        double d2 = (float)l / 256F;
        double d3 = ((float)l + 15.99F) / 256F;
        boolean flag = BlockRedstoneWire.func_72173_e(field_78669_a, p_78589_2_ - 1, p_78589_3_, p_78589_4_, 1) || !field_78669_a.func_72809_s(p_78589_2_ - 1, p_78589_3_, p_78589_4_) && BlockRedstoneWire.func_72173_e(field_78669_a, p_78589_2_ - 1, p_78589_3_ - 1, p_78589_4_, -1);
        boolean flag1 = BlockRedstoneWire.func_72173_e(field_78669_a, p_78589_2_ + 1, p_78589_3_, p_78589_4_, 3) || !field_78669_a.func_72809_s(p_78589_2_ + 1, p_78589_3_, p_78589_4_) && BlockRedstoneWire.func_72173_e(field_78669_a, p_78589_2_ + 1, p_78589_3_ - 1, p_78589_4_, -1);
        boolean flag2 = BlockRedstoneWire.func_72173_e(field_78669_a, p_78589_2_, p_78589_3_, p_78589_4_ - 1, 2) || !field_78669_a.func_72809_s(p_78589_2_, p_78589_3_, p_78589_4_ - 1) && BlockRedstoneWire.func_72173_e(field_78669_a, p_78589_2_, p_78589_3_ - 1, p_78589_4_ - 1, -1);
        boolean flag3 = BlockRedstoneWire.func_72173_e(field_78669_a, p_78589_2_, p_78589_3_, p_78589_4_ + 1, 0) || !field_78669_a.func_72809_s(p_78589_2_, p_78589_3_, p_78589_4_ + 1) && BlockRedstoneWire.func_72173_e(field_78669_a, p_78589_2_, p_78589_3_ - 1, p_78589_4_ + 1, -1);
        if(!field_78669_a.func_72809_s(p_78589_2_, p_78589_3_ + 1, p_78589_4_))
        {
            if(field_78669_a.func_72809_s(p_78589_2_ - 1, p_78589_3_, p_78589_4_) && BlockRedstoneWire.func_72173_e(field_78669_a, p_78589_2_ - 1, p_78589_3_ + 1, p_78589_4_, -1))
            {
                flag = true;
            }
            if(field_78669_a.func_72809_s(p_78589_2_ + 1, p_78589_3_, p_78589_4_) && BlockRedstoneWire.func_72173_e(field_78669_a, p_78589_2_ + 1, p_78589_3_ + 1, p_78589_4_, -1))
            {
                flag1 = true;
            }
            if(field_78669_a.func_72809_s(p_78589_2_, p_78589_3_, p_78589_4_ - 1) && BlockRedstoneWire.func_72173_e(field_78669_a, p_78589_2_, p_78589_3_ + 1, p_78589_4_ - 1, -1))
            {
                flag2 = true;
            }
            if(field_78669_a.func_72809_s(p_78589_2_, p_78589_3_, p_78589_4_ + 1) && BlockRedstoneWire.func_72173_e(field_78669_a, p_78589_2_, p_78589_3_ + 1, p_78589_4_ + 1, -1))
            {
                flag3 = true;
            }
        }
        float f5 = p_78589_2_ + 0;
        float f6 = p_78589_2_ + 1;
        float f7 = p_78589_4_ + 0;
        float f8 = p_78589_4_ + 1;
        byte byte0 = 0;
        if((flag || flag1) && !flag2 && !flag3)
        {
            byte0 = 1;
        }
        if((flag2 || flag3) && !flag1 && !flag)
        {
            byte0 = 2;
        }
        if(byte0 != 0)
        {
            d = (float)(k + 16) / 256F;
            d1 = ((float)(k + 16) + 15.99F) / 256F;
            d2 = (float)l / 256F;
            d3 = ((float)l + 15.99F) / 256F;
        }
        if(byte0 == 0)
        {
            if(!flag)
            {
                f5 += 0.3125F;
            }
            if(!flag)
            {
                d += 0.01953125D;
            }
            if(!flag1)
            {
                f6 -= 0.3125F;
            }
            if(!flag1)
            {
                d1 -= 0.01953125D;
            }
            if(!flag2)
            {
                f7 += 0.3125F;
            }
            if(!flag2)
            {
                d2 += 0.01953125D;
            }
            if(!flag3)
            {
                f8 -= 0.3125F;
            }
            if(!flag3)
            {
                d3 -= 0.01953125D;
            }
            tessellator.func_78374_a(f6, (double)p_78589_3_ + 0.015625D, f8, d1, d3);
            tessellator.func_78374_a(f6, (double)p_78589_3_ + 0.015625D, f7, d1, d2);
            tessellator.func_78374_a(f5, (double)p_78589_3_ + 0.015625D, f7, d, d2);
            tessellator.func_78374_a(f5, (double)p_78589_3_ + 0.015625D, f8, d, d3);
            tessellator.func_78386_a(f, f, f);
            tessellator.func_78374_a(f6, (double)p_78589_3_ + 0.015625D, f8, d1, d3 + 0.0625D);
            tessellator.func_78374_a(f6, (double)p_78589_3_ + 0.015625D, f7, d1, d2 + 0.0625D);
            tessellator.func_78374_a(f5, (double)p_78589_3_ + 0.015625D, f7, d, d2 + 0.0625D);
            tessellator.func_78374_a(f5, (double)p_78589_3_ + 0.015625D, f8, d, d3 + 0.0625D);
        } else
        if(byte0 == 1)
        {
            tessellator.func_78374_a(f6, (double)p_78589_3_ + 0.015625D, f8, d1, d3);
            tessellator.func_78374_a(f6, (double)p_78589_3_ + 0.015625D, f7, d1, d2);
            tessellator.func_78374_a(f5, (double)p_78589_3_ + 0.015625D, f7, d, d2);
            tessellator.func_78374_a(f5, (double)p_78589_3_ + 0.015625D, f8, d, d3);
            tessellator.func_78386_a(f, f, f);
            tessellator.func_78374_a(f6, (double)p_78589_3_ + 0.015625D, f8, d1, d3 + 0.0625D);
            tessellator.func_78374_a(f6, (double)p_78589_3_ + 0.015625D, f7, d1, d2 + 0.0625D);
            tessellator.func_78374_a(f5, (double)p_78589_3_ + 0.015625D, f7, d, d2 + 0.0625D);
            tessellator.func_78374_a(f5, (double)p_78589_3_ + 0.015625D, f8, d, d3 + 0.0625D);
        } else
        if(byte0 == 2)
        {
            tessellator.func_78374_a(f6, (double)p_78589_3_ + 0.015625D, f8, d1, d3);
            tessellator.func_78374_a(f6, (double)p_78589_3_ + 0.015625D, f7, d, d3);
            tessellator.func_78374_a(f5, (double)p_78589_3_ + 0.015625D, f7, d, d2);
            tessellator.func_78374_a(f5, (double)p_78589_3_ + 0.015625D, f8, d1, d2);
            tessellator.func_78386_a(f, f, f);
            tessellator.func_78374_a(f6, (double)p_78589_3_ + 0.015625D, f8, d1, d3 + 0.0625D);
            tessellator.func_78374_a(f6, (double)p_78589_3_ + 0.015625D, f7, d, d3 + 0.0625D);
            tessellator.func_78374_a(f5, (double)p_78589_3_ + 0.015625D, f7, d, d2 + 0.0625D);
            tessellator.func_78374_a(f5, (double)p_78589_3_ + 0.015625D, f8, d1, d2 + 0.0625D);
        }
        if(!field_78669_a.func_72809_s(p_78589_2_, p_78589_3_ + 1, p_78589_4_))
        {
            double d4 = (float)(k + 16) / 256F;
            double d5 = ((float)(k + 16) + 15.99F) / 256F;
            double d6 = (float)l / 256F;
            double d7 = ((float)l + 15.99F) / 256F;
            if(field_78669_a.func_72809_s(p_78589_2_ - 1, p_78589_3_, p_78589_4_) && field_78669_a.func_72798_a(p_78589_2_ - 1, p_78589_3_ + 1, p_78589_4_) == Block.field_72075_av.field_71990_ca)
            {
                tessellator.func_78386_a(f * f2, f * f3, f * f4);
                tessellator.func_78374_a((double)p_78589_2_ + 0.015625D, (float)(p_78589_3_ + 1) + 0.021875F, p_78589_4_ + 1, d5, d6);
                tessellator.func_78374_a((double)p_78589_2_ + 0.015625D, p_78589_3_ + 0, p_78589_4_ + 1, d4, d6);
                tessellator.func_78374_a((double)p_78589_2_ + 0.015625D, p_78589_3_ + 0, p_78589_4_ + 0, d4, d7);
                tessellator.func_78374_a((double)p_78589_2_ + 0.015625D, (float)(p_78589_3_ + 1) + 0.021875F, p_78589_4_ + 0, d5, d7);
                tessellator.func_78386_a(f, f, f);
                tessellator.func_78374_a((double)p_78589_2_ + 0.015625D, (float)(p_78589_3_ + 1) + 0.021875F, p_78589_4_ + 1, d5, d6 + 0.0625D);
                tessellator.func_78374_a((double)p_78589_2_ + 0.015625D, p_78589_3_ + 0, p_78589_4_ + 1, d4, d6 + 0.0625D);
                tessellator.func_78374_a((double)p_78589_2_ + 0.015625D, p_78589_3_ + 0, p_78589_4_ + 0, d4, d7 + 0.0625D);
                tessellator.func_78374_a((double)p_78589_2_ + 0.015625D, (float)(p_78589_3_ + 1) + 0.021875F, p_78589_4_ + 0, d5, d7 + 0.0625D);
            }
            if(field_78669_a.func_72809_s(p_78589_2_ + 1, p_78589_3_, p_78589_4_) && field_78669_a.func_72798_a(p_78589_2_ + 1, p_78589_3_ + 1, p_78589_4_) == Block.field_72075_av.field_71990_ca)
            {
                tessellator.func_78386_a(f * f2, f * f3, f * f4);
                tessellator.func_78374_a((double)(p_78589_2_ + 1) - 0.015625D, p_78589_3_ + 0, p_78589_4_ + 1, d4, d7);
                tessellator.func_78374_a((double)(p_78589_2_ + 1) - 0.015625D, (float)(p_78589_3_ + 1) + 0.021875F, p_78589_4_ + 1, d5, d7);
                tessellator.func_78374_a((double)(p_78589_2_ + 1) - 0.015625D, (float)(p_78589_3_ + 1) + 0.021875F, p_78589_4_ + 0, d5, d6);
                tessellator.func_78374_a((double)(p_78589_2_ + 1) - 0.015625D, p_78589_3_ + 0, p_78589_4_ + 0, d4, d6);
                tessellator.func_78386_a(f, f, f);
                tessellator.func_78374_a((double)(p_78589_2_ + 1) - 0.015625D, p_78589_3_ + 0, p_78589_4_ + 1, d4, d7 + 0.0625D);
                tessellator.func_78374_a((double)(p_78589_2_ + 1) - 0.015625D, (float)(p_78589_3_ + 1) + 0.021875F, p_78589_4_ + 1, d5, d7 + 0.0625D);
                tessellator.func_78374_a((double)(p_78589_2_ + 1) - 0.015625D, (float)(p_78589_3_ + 1) + 0.021875F, p_78589_4_ + 0, d5, d6 + 0.0625D);
                tessellator.func_78374_a((double)(p_78589_2_ + 1) - 0.015625D, p_78589_3_ + 0, p_78589_4_ + 0, d4, d6 + 0.0625D);
            }
            if(field_78669_a.func_72809_s(p_78589_2_, p_78589_3_, p_78589_4_ - 1) && field_78669_a.func_72798_a(p_78589_2_, p_78589_3_ + 1, p_78589_4_ - 1) == Block.field_72075_av.field_71990_ca)
            {
                tessellator.func_78386_a(f * f2, f * f3, f * f4);
                tessellator.func_78374_a(p_78589_2_ + 1, p_78589_3_ + 0, (double)p_78589_4_ + 0.015625D, d4, d7);
                tessellator.func_78374_a(p_78589_2_ + 1, (float)(p_78589_3_ + 1) + 0.021875F, (double)p_78589_4_ + 0.015625D, d5, d7);
                tessellator.func_78374_a(p_78589_2_ + 0, (float)(p_78589_3_ + 1) + 0.021875F, (double)p_78589_4_ + 0.015625D, d5, d6);
                tessellator.func_78374_a(p_78589_2_ + 0, p_78589_3_ + 0, (double)p_78589_4_ + 0.015625D, d4, d6);
                tessellator.func_78386_a(f, f, f);
                tessellator.func_78374_a(p_78589_2_ + 1, p_78589_3_ + 0, (double)p_78589_4_ + 0.015625D, d4, d7 + 0.0625D);
                tessellator.func_78374_a(p_78589_2_ + 1, (float)(p_78589_3_ + 1) + 0.021875F, (double)p_78589_4_ + 0.015625D, d5, d7 + 0.0625D);
                tessellator.func_78374_a(p_78589_2_ + 0, (float)(p_78589_3_ + 1) + 0.021875F, (double)p_78589_4_ + 0.015625D, d5, d6 + 0.0625D);
                tessellator.func_78374_a(p_78589_2_ + 0, p_78589_3_ + 0, (double)p_78589_4_ + 0.015625D, d4, d6 + 0.0625D);
            }
            if(field_78669_a.func_72809_s(p_78589_2_, p_78589_3_, p_78589_4_ + 1) && field_78669_a.func_72798_a(p_78589_2_, p_78589_3_ + 1, p_78589_4_ + 1) == Block.field_72075_av.field_71990_ca)
            {
                tessellator.func_78386_a(f * f2, f * f3, f * f4);
                tessellator.func_78374_a(p_78589_2_ + 1, (float)(p_78589_3_ + 1) + 0.021875F, (double)(p_78589_4_ + 1) - 0.015625D, d5, d6);
                tessellator.func_78374_a(p_78589_2_ + 1, p_78589_3_ + 0, (double)(p_78589_4_ + 1) - 0.015625D, d4, d6);
                tessellator.func_78374_a(p_78589_2_ + 0, p_78589_3_ + 0, (double)(p_78589_4_ + 1) - 0.015625D, d4, d7);
                tessellator.func_78374_a(p_78589_2_ + 0, (float)(p_78589_3_ + 1) + 0.021875F, (double)(p_78589_4_ + 1) - 0.015625D, d5, d7);
                tessellator.func_78386_a(f, f, f);
                tessellator.func_78374_a(p_78589_2_ + 1, (float)(p_78589_3_ + 1) + 0.021875F, (double)(p_78589_4_ + 1) - 0.015625D, d5, d6 + 0.0625D);
                tessellator.func_78374_a(p_78589_2_ + 1, p_78589_3_ + 0, (double)(p_78589_4_ + 1) - 0.015625D, d4, d6 + 0.0625D);
                tessellator.func_78374_a(p_78589_2_ + 0, p_78589_3_ + 0, (double)(p_78589_4_ + 1) - 0.015625D, d4, d7 + 0.0625D);
                tessellator.func_78374_a(p_78589_2_ + 0, (float)(p_78589_3_ + 1) + 0.021875F, (double)(p_78589_4_ + 1) - 0.015625D, d5, d7 + 0.0625D);
            }
        }
        return true;
    }

    public boolean func_78586_a(BlockRail p_78586_1_, int p_78586_2_, int p_78586_3_, int p_78586_4_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        int i = field_78669_a.func_72805_g(p_78586_2_, p_78586_3_, p_78586_4_);
        int j = p_78586_1_.func_71858_a(0, i);
        if(field_78664_d >= 0)
        {
            j = field_78664_d;
        }
        if(p_78586_1_.func_72183_n())
        {
            i &= 7;
        }
        tessellator.func_78380_c(p_78586_1_.func_71874_e(field_78669_a, p_78586_2_, p_78586_3_, p_78586_4_));
        tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
        int k = (j & 0xf) << 4;
        int l = j & 0xf0;
        double d = (float)k / 256F;
        double d1 = ((float)k + 15.99F) / 256F;
        double d2 = (float)l / 256F;
        double d3 = ((float)l + 15.99F) / 256F;
        double d4 = 0.0625D;
        double d5 = p_78586_2_ + 1;
        double d6 = p_78586_2_ + 1;
        double d7 = p_78586_2_ + 0;
        double d8 = p_78586_2_ + 0;
        double d9 = p_78586_4_ + 0;
        double d10 = p_78586_4_ + 1;
        double d11 = p_78586_4_ + 1;
        double d12 = p_78586_4_ + 0;
        double d13 = (double)p_78586_3_ + d4;
        double d14 = (double)p_78586_3_ + d4;
        double d15 = (double)p_78586_3_ + d4;
        double d16 = (double)p_78586_3_ + d4;
        if(i == 1 || i == 2 || i == 3 || i == 7)
        {
            d5 = d8 = p_78586_2_ + 1;
            d6 = d7 = p_78586_2_ + 0;
            d9 = d10 = p_78586_4_ + 1;
            d11 = d12 = p_78586_4_ + 0;
        } else
        if(i == 8)
        {
            d5 = d6 = p_78586_2_ + 0;
            d7 = d8 = p_78586_2_ + 1;
            d9 = d12 = p_78586_4_ + 1;
            d10 = d11 = p_78586_4_ + 0;
        } else
        if(i == 9)
        {
            d5 = d8 = p_78586_2_ + 0;
            d6 = d7 = p_78586_2_ + 1;
            d9 = d10 = p_78586_4_ + 0;
            d11 = d12 = p_78586_4_ + 1;
        }
        if(i == 2 || i == 4)
        {
            d13++;
            d16++;
        } else
        if(i == 3 || i == 5)
        {
            d14++;
            d15++;
        }
        tessellator.func_78374_a(d5, d13, d9, d1, d2);
        tessellator.func_78374_a(d6, d14, d10, d1, d3);
        tessellator.func_78374_a(d7, d15, d11, d, d3);
        tessellator.func_78374_a(d8, d16, d12, d, d2);
        tessellator.func_78374_a(d8, d16, d12, d, d2);
        tessellator.func_78374_a(d7, d15, d11, d, d3);
        tessellator.func_78374_a(d6, d14, d10, d1, d3);
        tessellator.func_78374_a(d5, d13, d9, d1, d2);
        return true;
    }

    public boolean func_78576_j(Block p_78576_1_, int p_78576_2_, int p_78576_3_, int p_78576_4_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        int i = p_78576_1_.func_71851_a(0);
        if(field_78664_d >= 0)
        {
            i = field_78664_d;
        }
        tessellator.func_78380_c(p_78576_1_.func_71874_e(field_78669_a, p_78576_2_, p_78576_3_, p_78576_4_));
        float f = 1.0F;
        tessellator.func_78386_a(f, f, f);
        f = (i & 0xf) << 4;
        int j = i & 0xf0;
        double d = f / 256F;
        double d1 = (f + 15.99F) / 256F;
        double d2 = (float)j / 256F;
        double d3 = ((float)j + 15.99F) / 256F;
        int k = field_78669_a.func_72805_g(p_78576_2_, p_78576_3_, p_78576_4_);
        double d4 = 0.0D;
        double d5 = 0.05000000074505806D;
        if(k == 5)
        {
            tessellator.func_78374_a((double)p_78576_2_ + d5, (double)(p_78576_3_ + 1) + d4, (double)(p_78576_4_ + 1) + d4, d, d2);
            tessellator.func_78374_a((double)p_78576_2_ + d5, (double)(p_78576_3_ + 0) - d4, (double)(p_78576_4_ + 1) + d4, d, d3);
            tessellator.func_78374_a((double)p_78576_2_ + d5, (double)(p_78576_3_ + 0) - d4, (double)(p_78576_4_ + 0) - d4, d1, d3);
            tessellator.func_78374_a((double)p_78576_2_ + d5, (double)(p_78576_3_ + 1) + d4, (double)(p_78576_4_ + 0) - d4, d1, d2);
        }
        if(k == 4)
        {
            tessellator.func_78374_a((double)(p_78576_2_ + 1) - d5, (double)(p_78576_3_ + 0) - d4, (double)(p_78576_4_ + 1) + d4, d1, d3);
            tessellator.func_78374_a((double)(p_78576_2_ + 1) - d5, (double)(p_78576_3_ + 1) + d4, (double)(p_78576_4_ + 1) + d4, d1, d2);
            tessellator.func_78374_a((double)(p_78576_2_ + 1) - d5, (double)(p_78576_3_ + 1) + d4, (double)(p_78576_4_ + 0) - d4, d, d2);
            tessellator.func_78374_a((double)(p_78576_2_ + 1) - d5, (double)(p_78576_3_ + 0) - d4, (double)(p_78576_4_ + 0) - d4, d, d3);
        }
        if(k == 3)
        {
            tessellator.func_78374_a((double)(p_78576_2_ + 1) + d4, (double)(p_78576_3_ + 0) - d4, (double)p_78576_4_ + d5, d1, d3);
            tessellator.func_78374_a((double)(p_78576_2_ + 1) + d4, (double)(p_78576_3_ + 1) + d4, (double)p_78576_4_ + d5, d1, d2);
            tessellator.func_78374_a((double)(p_78576_2_ + 0) - d4, (double)(p_78576_3_ + 1) + d4, (double)p_78576_4_ + d5, d, d2);
            tessellator.func_78374_a((double)(p_78576_2_ + 0) - d4, (double)(p_78576_3_ + 0) - d4, (double)p_78576_4_ + d5, d, d3);
        }
        if(k == 2)
        {
            tessellator.func_78374_a((double)(p_78576_2_ + 1) + d4, (double)(p_78576_3_ + 1) + d4, (double)(p_78576_4_ + 1) - d5, d, d2);
            tessellator.func_78374_a((double)(p_78576_2_ + 1) + d4, (double)(p_78576_3_ + 0) - d4, (double)(p_78576_4_ + 1) - d5, d, d3);
            tessellator.func_78374_a((double)(p_78576_2_ + 0) - d4, (double)(p_78576_3_ + 0) - d4, (double)(p_78576_4_ + 1) - d5, d1, d3);
            tessellator.func_78374_a((double)(p_78576_2_ + 0) - d4, (double)(p_78576_3_ + 1) + d4, (double)(p_78576_4_ + 1) - d5, d1, d2);
        }
        return true;
    }

    public boolean func_78598_k(Block p_78598_1_, int p_78598_2_, int p_78598_3_, int p_78598_4_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        int i = p_78598_1_.func_71851_a(0);
        if(field_78664_d >= 0)
        {
            i = field_78664_d;
        }
        float f = 1.0F;
        tessellator.func_78380_c(p_78598_1_.func_71874_e(field_78669_a, p_78598_2_, p_78598_3_, p_78598_4_));
        int j = p_78598_1_.func_71920_b(field_78669_a, p_78598_2_, p_78598_3_, p_78598_4_);
        float f1 = (float)(j >> 16 & 0xff) / 255F;
        float f2 = (float)(j >> 8 & 0xff) / 255F;
        float f3 = (float)(j & 0xff) / 255F;
        tessellator.func_78386_a(f * f1, f * f2, f * f3);
        j = (i & 0xf) << 4;
        f1 = i & 0xf0;
        double d = (float)j / 256F;
        double d1 = ((float)j + 15.99F) / 256F;
        double d2 = f1 / 256F;
        double d3 = (f1 + 15.99F) / 256F;
        double d4 = 0.05000000074505806D;
        int k = field_78669_a.func_72805_g(p_78598_2_, p_78598_3_, p_78598_4_);
        if((k & 2) != 0)
        {
            tessellator.func_78374_a((double)p_78598_2_ + d4, p_78598_3_ + 1, p_78598_4_ + 1, d, d2);
            tessellator.func_78374_a((double)p_78598_2_ + d4, p_78598_3_ + 0, p_78598_4_ + 1, d, d3);
            tessellator.func_78374_a((double)p_78598_2_ + d4, p_78598_3_ + 0, p_78598_4_ + 0, d1, d3);
            tessellator.func_78374_a((double)p_78598_2_ + d4, p_78598_3_ + 1, p_78598_4_ + 0, d1, d2);
            tessellator.func_78374_a((double)p_78598_2_ + d4, p_78598_3_ + 1, p_78598_4_ + 0, d1, d2);
            tessellator.func_78374_a((double)p_78598_2_ + d4, p_78598_3_ + 0, p_78598_4_ + 0, d1, d3);
            tessellator.func_78374_a((double)p_78598_2_ + d4, p_78598_3_ + 0, p_78598_4_ + 1, d, d3);
            tessellator.func_78374_a((double)p_78598_2_ + d4, p_78598_3_ + 1, p_78598_4_ + 1, d, d2);
        }
        if((k & 8) != 0)
        {
            tessellator.func_78374_a((double)(p_78598_2_ + 1) - d4, p_78598_3_ + 0, p_78598_4_ + 1, d1, d3);
            tessellator.func_78374_a((double)(p_78598_2_ + 1) - d4, p_78598_3_ + 1, p_78598_4_ + 1, d1, d2);
            tessellator.func_78374_a((double)(p_78598_2_ + 1) - d4, p_78598_3_ + 1, p_78598_4_ + 0, d, d2);
            tessellator.func_78374_a((double)(p_78598_2_ + 1) - d4, p_78598_3_ + 0, p_78598_4_ + 0, d, d3);
            tessellator.func_78374_a((double)(p_78598_2_ + 1) - d4, p_78598_3_ + 0, p_78598_4_ + 0, d, d3);
            tessellator.func_78374_a((double)(p_78598_2_ + 1) - d4, p_78598_3_ + 1, p_78598_4_ + 0, d, d2);
            tessellator.func_78374_a((double)(p_78598_2_ + 1) - d4, p_78598_3_ + 1, p_78598_4_ + 1, d1, d2);
            tessellator.func_78374_a((double)(p_78598_2_ + 1) - d4, p_78598_3_ + 0, p_78598_4_ + 1, d1, d3);
        }
        if((k & 4) != 0)
        {
            tessellator.func_78374_a(p_78598_2_ + 1, p_78598_3_ + 0, (double)p_78598_4_ + d4, d1, d3);
            tessellator.func_78374_a(p_78598_2_ + 1, p_78598_3_ + 1, (double)p_78598_4_ + d4, d1, d2);
            tessellator.func_78374_a(p_78598_2_ + 0, p_78598_3_ + 1, (double)p_78598_4_ + d4, d, d2);
            tessellator.func_78374_a(p_78598_2_ + 0, p_78598_3_ + 0, (double)p_78598_4_ + d4, d, d3);
            tessellator.func_78374_a(p_78598_2_ + 0, p_78598_3_ + 0, (double)p_78598_4_ + d4, d, d3);
            tessellator.func_78374_a(p_78598_2_ + 0, p_78598_3_ + 1, (double)p_78598_4_ + d4, d, d2);
            tessellator.func_78374_a(p_78598_2_ + 1, p_78598_3_ + 1, (double)p_78598_4_ + d4, d1, d2);
            tessellator.func_78374_a(p_78598_2_ + 1, p_78598_3_ + 0, (double)p_78598_4_ + d4, d1, d3);
        }
        if((k & 1) != 0)
        {
            tessellator.func_78374_a(p_78598_2_ + 1, p_78598_3_ + 1, (double)(p_78598_4_ + 1) - d4, d, d2);
            tessellator.func_78374_a(p_78598_2_ + 1, p_78598_3_ + 0, (double)(p_78598_4_ + 1) - d4, d, d3);
            tessellator.func_78374_a(p_78598_2_ + 0, p_78598_3_ + 0, (double)(p_78598_4_ + 1) - d4, d1, d3);
            tessellator.func_78374_a(p_78598_2_ + 0, p_78598_3_ + 1, (double)(p_78598_4_ + 1) - d4, d1, d2);
            tessellator.func_78374_a(p_78598_2_ + 0, p_78598_3_ + 1, (double)(p_78598_4_ + 1) - d4, d1, d2);
            tessellator.func_78374_a(p_78598_2_ + 0, p_78598_3_ + 0, (double)(p_78598_4_ + 1) - d4, d1, d3);
            tessellator.func_78374_a(p_78598_2_ + 1, p_78598_3_ + 0, (double)(p_78598_4_ + 1) - d4, d, d3);
            tessellator.func_78374_a(p_78598_2_ + 1, p_78598_3_ + 1, (double)(p_78598_4_ + 1) - d4, d, d2);
        }
        if(field_78669_a.func_72809_s(p_78598_2_, p_78598_3_ + 1, p_78598_4_))
        {
            tessellator.func_78374_a(p_78598_2_ + 1, (double)(p_78598_3_ + 1) - d4, p_78598_4_ + 0, d, d2);
            tessellator.func_78374_a(p_78598_2_ + 1, (double)(p_78598_3_ + 1) - d4, p_78598_4_ + 1, d, d3);
            tessellator.func_78374_a(p_78598_2_ + 0, (double)(p_78598_3_ + 1) - d4, p_78598_4_ + 1, d1, d3);
            tessellator.func_78374_a(p_78598_2_ + 0, (double)(p_78598_3_ + 1) - d4, p_78598_4_ + 0, d1, d2);
        }
        return true;
    }

    public boolean func_78592_a(BlockPane p_78592_1_, int p_78592_2_, int p_78592_3_, int p_78592_4_)
    {
        int i = field_78669_a.func_72800_K();
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78380_c(p_78592_1_.func_71874_e(field_78669_a, p_78592_2_, p_78592_3_, p_78592_4_));
        float f = 1.0F;
        int j = p_78592_1_.func_71920_b(field_78669_a, p_78592_2_, p_78592_3_, p_78592_4_);
        float f1 = (float)(j >> 16 & 0xff) / 255F;
        float f2 = (float)(j >> 8 & 0xff) / 255F;
        float f3 = (float)(j & 0xff) / 255F;
        if(EntityRenderer.field_78517_a)
        {
            float f4 = (f1 * 30F + f2 * 59F + f3 * 11F) / 100F;
            float f5 = (f1 * 30F + f2 * 70F) / 100F;
            float f6 = (f1 * 30F + f3 * 70F) / 100F;
            f1 = f4;
            f2 = f5;
            f3 = f6;
        }
        tessellator.func_78386_a(f * f1, f * f2, f * f3);
        int k = 0;
        int l = 0;
        if(field_78664_d >= 0)
        {
            k = field_78664_d;
            l = field_78664_d;
        } else
        {
            int i1 = field_78669_a.func_72805_g(p_78592_2_, p_78592_3_, p_78592_4_);
            k = p_78592_1_.func_71858_a(0, i1);
            l = p_78592_1_.func_72162_n();
        }
        int j1 = (k & 0xf) << 4;
        int k1 = k & 0xf0;
        double d = (float)j1 / 256F;
        double d1 = ((float)j1 + 7.99F) / 256F;
        double d2 = ((float)j1 + 15.99F) / 256F;
        double d3 = (float)k1 / 256F;
        double d4 = ((float)k1 + 15.99F) / 256F;
        int l1 = (l & 0xf) << 4;
        int i2 = l & 0xf0;
        double d5 = (float)(l1 + 7) / 256F;
        double d6 = ((float)l1 + 8.99F) / 256F;
        double d7 = (float)i2 / 256F;
        double d8 = (float)(i2 + 8) / 256F;
        double d9 = ((float)i2 + 15.99F) / 256F;
        double d10 = p_78592_2_;
        double d11 = (double)p_78592_2_ + 0.5D;
        double d12 = p_78592_2_ + 1;
        double d13 = p_78592_4_;
        double d14 = (double)p_78592_4_ + 0.5D;
        double d15 = p_78592_4_ + 1;
        double d16 = ((double)p_78592_2_ + 0.5D) - 0.0625D;
        double d17 = (double)p_78592_2_ + 0.5D + 0.0625D;
        double d18 = ((double)p_78592_4_ + 0.5D) - 0.0625D;
        double d19 = (double)p_78592_4_ + 0.5D + 0.0625D;
        boolean flag = p_78592_1_.func_72161_e(field_78669_a.func_72798_a(p_78592_2_, p_78592_3_, p_78592_4_ - 1));
        boolean flag1 = p_78592_1_.func_72161_e(field_78669_a.func_72798_a(p_78592_2_, p_78592_3_, p_78592_4_ + 1));
        boolean flag2 = p_78592_1_.func_72161_e(field_78669_a.func_72798_a(p_78592_2_ - 1, p_78592_3_, p_78592_4_));
        boolean flag3 = p_78592_1_.func_72161_e(field_78669_a.func_72798_a(p_78592_2_ + 1, p_78592_3_, p_78592_4_));
        boolean flag4 = p_78592_1_.func_71877_c(field_78669_a, p_78592_2_, p_78592_3_ + 1, p_78592_4_, 1);
        boolean flag5 = p_78592_1_.func_71877_c(field_78669_a, p_78592_2_, p_78592_3_ - 1, p_78592_4_, 0);
        if(flag2 && flag3 || !flag2 && !flag3 && !flag && !flag1)
        {
            tessellator.func_78374_a(d10, p_78592_3_ + 1, d14, d, d3);
            tessellator.func_78374_a(d10, p_78592_3_ + 0, d14, d, d4);
            tessellator.func_78374_a(d12, p_78592_3_ + 0, d14, d2, d4);
            tessellator.func_78374_a(d12, p_78592_3_ + 1, d14, d2, d3);
            tessellator.func_78374_a(d12, p_78592_3_ + 1, d14, d, d3);
            tessellator.func_78374_a(d12, p_78592_3_ + 0, d14, d, d4);
            tessellator.func_78374_a(d10, p_78592_3_ + 0, d14, d2, d4);
            tessellator.func_78374_a(d10, p_78592_3_ + 1, d14, d2, d3);
            if(flag4)
            {
                tessellator.func_78374_a(d10, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d9);
                tessellator.func_78374_a(d12, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d7);
                tessellator.func_78374_a(d12, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d7);
                tessellator.func_78374_a(d10, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d9);
                tessellator.func_78374_a(d12, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d9);
                tessellator.func_78374_a(d10, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d7);
                tessellator.func_78374_a(d10, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d7);
                tessellator.func_78374_a(d12, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d9);
            } else
            {
                if(p_78592_3_ < i - 1 && field_78669_a.func_72799_c(p_78592_2_ - 1, p_78592_3_ + 1, p_78592_4_))
                {
                    tessellator.func_78374_a(d10, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d8);
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d9);
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d9);
                    tessellator.func_78374_a(d10, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d8);
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d8);
                    tessellator.func_78374_a(d10, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d9);
                    tessellator.func_78374_a(d10, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d9);
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d8);
                }
                if(p_78592_3_ < i - 1 && field_78669_a.func_72799_c(p_78592_2_ + 1, p_78592_3_ + 1, p_78592_4_))
                {
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d7);
                    tessellator.func_78374_a(d12, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d8);
                    tessellator.func_78374_a(d12, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d8);
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d7);
                    tessellator.func_78374_a(d12, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d7);
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d8);
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d8);
                    tessellator.func_78374_a(d12, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d7);
                }
            }
            if(flag5)
            {
                tessellator.func_78374_a(d10, (double)p_78592_3_ - 0.01D, d19, d6, d9);
                tessellator.func_78374_a(d12, (double)p_78592_3_ - 0.01D, d19, d6, d7);
                tessellator.func_78374_a(d12, (double)p_78592_3_ - 0.01D, d18, d5, d7);
                tessellator.func_78374_a(d10, (double)p_78592_3_ - 0.01D, d18, d5, d9);
                tessellator.func_78374_a(d12, (double)p_78592_3_ - 0.01D, d19, d6, d9);
                tessellator.func_78374_a(d10, (double)p_78592_3_ - 0.01D, d19, d6, d7);
                tessellator.func_78374_a(d10, (double)p_78592_3_ - 0.01D, d18, d5, d7);
                tessellator.func_78374_a(d12, (double)p_78592_3_ - 0.01D, d18, d5, d9);
            } else
            {
                if(p_78592_3_ > 1 && field_78669_a.func_72799_c(p_78592_2_ - 1, p_78592_3_ - 1, p_78592_4_))
                {
                    tessellator.func_78374_a(d10, (double)p_78592_3_ - 0.01D, d19, d6, d8);
                    tessellator.func_78374_a(d11, (double)p_78592_3_ - 0.01D, d19, d6, d9);
                    tessellator.func_78374_a(d11, (double)p_78592_3_ - 0.01D, d18, d5, d9);
                    tessellator.func_78374_a(d10, (double)p_78592_3_ - 0.01D, d18, d5, d8);
                    tessellator.func_78374_a(d11, (double)p_78592_3_ - 0.01D, d19, d6, d8);
                    tessellator.func_78374_a(d10, (double)p_78592_3_ - 0.01D, d19, d6, d9);
                    tessellator.func_78374_a(d10, (double)p_78592_3_ - 0.01D, d18, d5, d9);
                    tessellator.func_78374_a(d11, (double)p_78592_3_ - 0.01D, d18, d5, d8);
                }
                if(p_78592_3_ > 1 && field_78669_a.func_72799_c(p_78592_2_ + 1, p_78592_3_ - 1, p_78592_4_))
                {
                    tessellator.func_78374_a(d11, (double)p_78592_3_ - 0.01D, d19, d6, d7);
                    tessellator.func_78374_a(d12, (double)p_78592_3_ - 0.01D, d19, d6, d8);
                    tessellator.func_78374_a(d12, (double)p_78592_3_ - 0.01D, d18, d5, d8);
                    tessellator.func_78374_a(d11, (double)p_78592_3_ - 0.01D, d18, d5, d7);
                    tessellator.func_78374_a(d12, (double)p_78592_3_ - 0.01D, d19, d6, d7);
                    tessellator.func_78374_a(d11, (double)p_78592_3_ - 0.01D, d19, d6, d8);
                    tessellator.func_78374_a(d11, (double)p_78592_3_ - 0.01D, d18, d5, d8);
                    tessellator.func_78374_a(d12, (double)p_78592_3_ - 0.01D, d18, d5, d7);
                }
            }
        } else
        if(flag2 && !flag3)
        {
            tessellator.func_78374_a(d10, p_78592_3_ + 1, d14, d, d3);
            tessellator.func_78374_a(d10, p_78592_3_ + 0, d14, d, d4);
            tessellator.func_78374_a(d11, p_78592_3_ + 0, d14, d1, d4);
            tessellator.func_78374_a(d11, p_78592_3_ + 1, d14, d1, d3);
            tessellator.func_78374_a(d11, p_78592_3_ + 1, d14, d, d3);
            tessellator.func_78374_a(d11, p_78592_3_ + 0, d14, d, d4);
            tessellator.func_78374_a(d10, p_78592_3_ + 0, d14, d1, d4);
            tessellator.func_78374_a(d10, p_78592_3_ + 1, d14, d1, d3);
            if(!flag1 && !flag)
            {
                tessellator.func_78374_a(d11, p_78592_3_ + 1, d19, d5, d7);
                tessellator.func_78374_a(d11, p_78592_3_ + 0, d19, d5, d9);
                tessellator.func_78374_a(d11, p_78592_3_ + 0, d18, d6, d9);
                tessellator.func_78374_a(d11, p_78592_3_ + 1, d18, d6, d7);
                tessellator.func_78374_a(d11, p_78592_3_ + 1, d18, d5, d7);
                tessellator.func_78374_a(d11, p_78592_3_ + 0, d18, d5, d9);
                tessellator.func_78374_a(d11, p_78592_3_ + 0, d19, d6, d9);
                tessellator.func_78374_a(d11, p_78592_3_ + 1, d19, d6, d7);
            }
            if(flag4 || p_78592_3_ < i - 1 && field_78669_a.func_72799_c(p_78592_2_ - 1, p_78592_3_ + 1, p_78592_4_))
            {
                tessellator.func_78374_a(d10, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d8);
                tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d9);
                tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d9);
                tessellator.func_78374_a(d10, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d8);
                tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d8);
                tessellator.func_78374_a(d10, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d9);
                tessellator.func_78374_a(d10, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d9);
                tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d8);
            }
            if(flag5 || p_78592_3_ > 1 && field_78669_a.func_72799_c(p_78592_2_ - 1, p_78592_3_ - 1, p_78592_4_))
            {
                tessellator.func_78374_a(d10, (double)p_78592_3_ - 0.01D, d19, d6, d8);
                tessellator.func_78374_a(d11, (double)p_78592_3_ - 0.01D, d19, d6, d9);
                tessellator.func_78374_a(d11, (double)p_78592_3_ - 0.01D, d18, d5, d9);
                tessellator.func_78374_a(d10, (double)p_78592_3_ - 0.01D, d18, d5, d8);
                tessellator.func_78374_a(d11, (double)p_78592_3_ - 0.01D, d19, d6, d8);
                tessellator.func_78374_a(d10, (double)p_78592_3_ - 0.01D, d19, d6, d9);
                tessellator.func_78374_a(d10, (double)p_78592_3_ - 0.01D, d18, d5, d9);
                tessellator.func_78374_a(d11, (double)p_78592_3_ - 0.01D, d18, d5, d8);
            }
        } else
        if(!flag2 && flag3)
        {
            tessellator.func_78374_a(d11, p_78592_3_ + 1, d14, d1, d3);
            tessellator.func_78374_a(d11, p_78592_3_ + 0, d14, d1, d4);
            tessellator.func_78374_a(d12, p_78592_3_ + 0, d14, d2, d4);
            tessellator.func_78374_a(d12, p_78592_3_ + 1, d14, d2, d3);
            tessellator.func_78374_a(d12, p_78592_3_ + 1, d14, d1, d3);
            tessellator.func_78374_a(d12, p_78592_3_ + 0, d14, d1, d4);
            tessellator.func_78374_a(d11, p_78592_3_ + 0, d14, d2, d4);
            tessellator.func_78374_a(d11, p_78592_3_ + 1, d14, d2, d3);
            if(!flag1 && !flag)
            {
                tessellator.func_78374_a(d11, p_78592_3_ + 1, d18, d5, d7);
                tessellator.func_78374_a(d11, p_78592_3_ + 0, d18, d5, d9);
                tessellator.func_78374_a(d11, p_78592_3_ + 0, d19, d6, d9);
                tessellator.func_78374_a(d11, p_78592_3_ + 1, d19, d6, d7);
                tessellator.func_78374_a(d11, p_78592_3_ + 1, d19, d5, d7);
                tessellator.func_78374_a(d11, p_78592_3_ + 0, d19, d5, d9);
                tessellator.func_78374_a(d11, p_78592_3_ + 0, d18, d6, d9);
                tessellator.func_78374_a(d11, p_78592_3_ + 1, d18, d6, d7);
            }
            if(flag4 || p_78592_3_ < i - 1 && field_78669_a.func_72799_c(p_78592_2_ + 1, p_78592_3_ + 1, p_78592_4_))
            {
                tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d7);
                tessellator.func_78374_a(d12, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d8);
                tessellator.func_78374_a(d12, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d8);
                tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d7);
                tessellator.func_78374_a(d12, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d7);
                tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d8);
                tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d8);
                tessellator.func_78374_a(d12, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d7);
            }
            if(flag5 || p_78592_3_ > 1 && field_78669_a.func_72799_c(p_78592_2_ + 1, p_78592_3_ - 1, p_78592_4_))
            {
                tessellator.func_78374_a(d11, (double)p_78592_3_ - 0.01D, d19, d6, d7);
                tessellator.func_78374_a(d12, (double)p_78592_3_ - 0.01D, d19, d6, d8);
                tessellator.func_78374_a(d12, (double)p_78592_3_ - 0.01D, d18, d5, d8);
                tessellator.func_78374_a(d11, (double)p_78592_3_ - 0.01D, d18, d5, d7);
                tessellator.func_78374_a(d12, (double)p_78592_3_ - 0.01D, d19, d6, d7);
                tessellator.func_78374_a(d11, (double)p_78592_3_ - 0.01D, d19, d6, d8);
                tessellator.func_78374_a(d11, (double)p_78592_3_ - 0.01D, d18, d5, d8);
                tessellator.func_78374_a(d12, (double)p_78592_3_ - 0.01D, d18, d5, d7);
            }
        }
        if(flag && flag1 || !flag2 && !flag3 && !flag && !flag1)
        {
            tessellator.func_78374_a(d11, p_78592_3_ + 1, d15, d, d3);
            tessellator.func_78374_a(d11, p_78592_3_ + 0, d15, d, d4);
            tessellator.func_78374_a(d11, p_78592_3_ + 0, d13, d2, d4);
            tessellator.func_78374_a(d11, p_78592_3_ + 1, d13, d2, d3);
            tessellator.func_78374_a(d11, p_78592_3_ + 1, d13, d, d3);
            tessellator.func_78374_a(d11, p_78592_3_ + 0, d13, d, d4);
            tessellator.func_78374_a(d11, p_78592_3_ + 0, d15, d2, d4);
            tessellator.func_78374_a(d11, p_78592_3_ + 1, d15, d2, d3);
            if(flag4)
            {
                tessellator.func_78374_a(d17, p_78592_3_ + 1, d15, d6, d9);
                tessellator.func_78374_a(d17, p_78592_3_ + 1, d13, d6, d7);
                tessellator.func_78374_a(d16, p_78592_3_ + 1, d13, d5, d7);
                tessellator.func_78374_a(d16, p_78592_3_ + 1, d15, d5, d9);
                tessellator.func_78374_a(d17, p_78592_3_ + 1, d13, d6, d9);
                tessellator.func_78374_a(d17, p_78592_3_ + 1, d15, d6, d7);
                tessellator.func_78374_a(d16, p_78592_3_ + 1, d15, d5, d7);
                tessellator.func_78374_a(d16, p_78592_3_ + 1, d13, d5, d9);
            } else
            {
                if(p_78592_3_ < i - 1 && field_78669_a.func_72799_c(p_78592_2_, p_78592_3_ + 1, p_78592_4_ - 1))
                {
                    tessellator.func_78374_a(d16, p_78592_3_ + 1, d13, d6, d7);
                    tessellator.func_78374_a(d16, p_78592_3_ + 1, d14, d6, d8);
                    tessellator.func_78374_a(d17, p_78592_3_ + 1, d14, d5, d8);
                    tessellator.func_78374_a(d17, p_78592_3_ + 1, d13, d5, d7);
                    tessellator.func_78374_a(d16, p_78592_3_ + 1, d14, d6, d7);
                    tessellator.func_78374_a(d16, p_78592_3_ + 1, d13, d6, d8);
                    tessellator.func_78374_a(d17, p_78592_3_ + 1, d13, d5, d8);
                    tessellator.func_78374_a(d17, p_78592_3_ + 1, d14, d5, d7);
                }
                if(p_78592_3_ < i - 1 && field_78669_a.func_72799_c(p_78592_2_, p_78592_3_ + 1, p_78592_4_ + 1))
                {
                    tessellator.func_78374_a(d16, p_78592_3_ + 1, d14, d5, d8);
                    tessellator.func_78374_a(d16, p_78592_3_ + 1, d15, d5, d9);
                    tessellator.func_78374_a(d17, p_78592_3_ + 1, d15, d6, d9);
                    tessellator.func_78374_a(d17, p_78592_3_ + 1, d14, d6, d8);
                    tessellator.func_78374_a(d16, p_78592_3_ + 1, d15, d5, d8);
                    tessellator.func_78374_a(d16, p_78592_3_ + 1, d14, d5, d9);
                    tessellator.func_78374_a(d17, p_78592_3_ + 1, d14, d6, d9);
                    tessellator.func_78374_a(d17, p_78592_3_ + 1, d15, d6, d8);
                }
            }
            if(flag5)
            {
                tessellator.func_78374_a(d17, p_78592_3_, d15, d6, d9);
                tessellator.func_78374_a(d17, p_78592_3_, d13, d6, d7);
                tessellator.func_78374_a(d16, p_78592_3_, d13, d5, d7);
                tessellator.func_78374_a(d16, p_78592_3_, d15, d5, d9);
                tessellator.func_78374_a(d17, p_78592_3_, d13, d6, d9);
                tessellator.func_78374_a(d17, p_78592_3_, d15, d6, d7);
                tessellator.func_78374_a(d16, p_78592_3_, d15, d5, d7);
                tessellator.func_78374_a(d16, p_78592_3_, d13, d5, d9);
            } else
            {
                if(p_78592_3_ > 1 && field_78669_a.func_72799_c(p_78592_2_, p_78592_3_ - 1, p_78592_4_ - 1))
                {
                    tessellator.func_78374_a(d16, p_78592_3_, d13, d6, d7);
                    tessellator.func_78374_a(d16, p_78592_3_, d14, d6, d8);
                    tessellator.func_78374_a(d17, p_78592_3_, d14, d5, d8);
                    tessellator.func_78374_a(d17, p_78592_3_, d13, d5, d7);
                    tessellator.func_78374_a(d16, p_78592_3_, d14, d6, d7);
                    tessellator.func_78374_a(d16, p_78592_3_, d13, d6, d8);
                    tessellator.func_78374_a(d17, p_78592_3_, d13, d5, d8);
                    tessellator.func_78374_a(d17, p_78592_3_, d14, d5, d7);
                }
                if(p_78592_3_ > 1 && field_78669_a.func_72799_c(p_78592_2_, p_78592_3_ - 1, p_78592_4_ + 1))
                {
                    tessellator.func_78374_a(d16, p_78592_3_, d14, d5, d8);
                    tessellator.func_78374_a(d16, p_78592_3_, d15, d5, d9);
                    tessellator.func_78374_a(d17, p_78592_3_, d15, d6, d9);
                    tessellator.func_78374_a(d17, p_78592_3_, d14, d6, d8);
                    tessellator.func_78374_a(d16, p_78592_3_, d15, d5, d8);
                    tessellator.func_78374_a(d16, p_78592_3_, d14, d5, d9);
                    tessellator.func_78374_a(d17, p_78592_3_, d14, d6, d9);
                    tessellator.func_78374_a(d17, p_78592_3_, d15, d6, d8);
                }
            }
        } else
        if(flag && !flag1)
        {
            tessellator.func_78374_a(d11, p_78592_3_ + 1, d13, d, d3);
            tessellator.func_78374_a(d11, p_78592_3_ + 0, d13, d, d4);
            tessellator.func_78374_a(d11, p_78592_3_ + 0, d14, d1, d4);
            tessellator.func_78374_a(d11, p_78592_3_ + 1, d14, d1, d3);
            tessellator.func_78374_a(d11, p_78592_3_ + 1, d14, d, d3);
            tessellator.func_78374_a(d11, p_78592_3_ + 0, d14, d, d4);
            tessellator.func_78374_a(d11, p_78592_3_ + 0, d13, d1, d4);
            tessellator.func_78374_a(d11, p_78592_3_ + 1, d13, d1, d3);
            if(!flag3 && !flag2)
            {
                tessellator.func_78374_a(d16, p_78592_3_ + 1, d14, d5, d7);
                tessellator.func_78374_a(d16, p_78592_3_ + 0, d14, d5, d9);
                tessellator.func_78374_a(d17, p_78592_3_ + 0, d14, d6, d9);
                tessellator.func_78374_a(d17, p_78592_3_ + 1, d14, d6, d7);
                tessellator.func_78374_a(d17, p_78592_3_ + 1, d14, d5, d7);
                tessellator.func_78374_a(d17, p_78592_3_ + 0, d14, d5, d9);
                tessellator.func_78374_a(d16, p_78592_3_ + 0, d14, d6, d9);
                tessellator.func_78374_a(d16, p_78592_3_ + 1, d14, d6, d7);
            }
            if(flag4 || p_78592_3_ < i - 1 && field_78669_a.func_72799_c(p_78592_2_, p_78592_3_ + 1, p_78592_4_ - 1))
            {
                tessellator.func_78374_a(d16, p_78592_3_ + 1, d13, d6, d7);
                tessellator.func_78374_a(d16, p_78592_3_ + 1, d14, d6, d8);
                tessellator.func_78374_a(d17, p_78592_3_ + 1, d14, d5, d8);
                tessellator.func_78374_a(d17, p_78592_3_ + 1, d13, d5, d7);
                tessellator.func_78374_a(d16, p_78592_3_ + 1, d14, d6, d7);
                tessellator.func_78374_a(d16, p_78592_3_ + 1, d13, d6, d8);
                tessellator.func_78374_a(d17, p_78592_3_ + 1, d13, d5, d8);
                tessellator.func_78374_a(d17, p_78592_3_ + 1, d14, d5, d7);
            }
            if(flag5 || p_78592_3_ > 1 && field_78669_a.func_72799_c(p_78592_2_, p_78592_3_ - 1, p_78592_4_ - 1))
            {
                tessellator.func_78374_a(d16, p_78592_3_, d13, d6, d7);
                tessellator.func_78374_a(d16, p_78592_3_, d14, d6, d8);
                tessellator.func_78374_a(d17, p_78592_3_, d14, d5, d8);
                tessellator.func_78374_a(d17, p_78592_3_, d13, d5, d7);
                tessellator.func_78374_a(d16, p_78592_3_, d14, d6, d7);
                tessellator.func_78374_a(d16, p_78592_3_, d13, d6, d8);
                tessellator.func_78374_a(d17, p_78592_3_, d13, d5, d8);
                tessellator.func_78374_a(d17, p_78592_3_, d14, d5, d7);
            }
        } else
        if(!flag && flag1)
        {
            tessellator.func_78374_a(d11, p_78592_3_ + 1, d14, d1, d3);
            tessellator.func_78374_a(d11, p_78592_3_ + 0, d14, d1, d4);
            tessellator.func_78374_a(d11, p_78592_3_ + 0, d15, d2, d4);
            tessellator.func_78374_a(d11, p_78592_3_ + 1, d15, d2, d3);
            tessellator.func_78374_a(d11, p_78592_3_ + 1, d15, d1, d3);
            tessellator.func_78374_a(d11, p_78592_3_ + 0, d15, d1, d4);
            tessellator.func_78374_a(d11, p_78592_3_ + 0, d14, d2, d4);
            tessellator.func_78374_a(d11, p_78592_3_ + 1, d14, d2, d3);
            if(!flag3 && !flag2)
            {
                tessellator.func_78374_a(d17, p_78592_3_ + 1, d14, d5, d7);
                tessellator.func_78374_a(d17, p_78592_3_ + 0, d14, d5, d9);
                tessellator.func_78374_a(d16, p_78592_3_ + 0, d14, d6, d9);
                tessellator.func_78374_a(d16, p_78592_3_ + 1, d14, d6, d7);
                tessellator.func_78374_a(d16, p_78592_3_ + 1, d14, d5, d7);
                tessellator.func_78374_a(d16, p_78592_3_ + 0, d14, d5, d9);
                tessellator.func_78374_a(d17, p_78592_3_ + 0, d14, d6, d9);
                tessellator.func_78374_a(d17, p_78592_3_ + 1, d14, d6, d7);
            }
            if(flag4 || p_78592_3_ < i - 1 && field_78669_a.func_72799_c(p_78592_2_, p_78592_3_ + 1, p_78592_4_ + 1))
            {
                tessellator.func_78374_a(d16, p_78592_3_ + 1, d14, d5, d8);
                tessellator.func_78374_a(d16, p_78592_3_ + 1, d15, d5, d9);
                tessellator.func_78374_a(d17, p_78592_3_ + 1, d15, d6, d9);
                tessellator.func_78374_a(d17, p_78592_3_ + 1, d14, d6, d8);
                tessellator.func_78374_a(d16, p_78592_3_ + 1, d15, d5, d8);
                tessellator.func_78374_a(d16, p_78592_3_ + 1, d14, d5, d9);
                tessellator.func_78374_a(d17, p_78592_3_ + 1, d14, d6, d9);
                tessellator.func_78374_a(d17, p_78592_3_ + 1, d15, d6, d8);
            }
            if(flag5 || p_78592_3_ > 1 && field_78669_a.func_72799_c(p_78592_2_, p_78592_3_ - 1, p_78592_4_ + 1))
            {
                tessellator.func_78374_a(d16, p_78592_3_, d14, d5, d8);
                tessellator.func_78374_a(d16, p_78592_3_, d15, d5, d9);
                tessellator.func_78374_a(d17, p_78592_3_, d15, d6, d9);
                tessellator.func_78374_a(d17, p_78592_3_, d14, d6, d8);
                tessellator.func_78374_a(d16, p_78592_3_, d15, d5, d8);
                tessellator.func_78374_a(d16, p_78592_3_, d14, d5, d9);
                tessellator.func_78374_a(d17, p_78592_3_, d14, d6, d9);
                tessellator.func_78374_a(d17, p_78592_3_, d15, d6, d8);
            }
        }
        return true;
    }

    public boolean func_78620_l(Block p_78620_1_, int p_78620_2_, int p_78620_3_, int p_78620_4_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78380_c(p_78620_1_.func_71874_e(field_78669_a, p_78620_2_, p_78620_3_, p_78620_4_));
        float f = 1.0F;
        int i = p_78620_1_.func_71920_b(field_78669_a, p_78620_2_, p_78620_3_, p_78620_4_);
        float f1 = (float)(i >> 16 & 0xff) / 255F;
        float f2 = (float)(i >> 8 & 0xff) / 255F;
        float f3 = (float)(i & 0xff) / 255F;
        if(EntityRenderer.field_78517_a)
        {
            float f4 = (f1 * 30F + f2 * 59F + f3 * 11F) / 100F;
            float f5 = (f1 * 30F + f2 * 70F) / 100F;
            float f6 = (f1 * 30F + f3 * 70F) / 100F;
            f1 = f4;
            f2 = f5;
            f3 = f6;
        }
        tessellator.func_78386_a(f * f1, f * f2, f * f3);
        double d = p_78620_2_;
        double d1 = p_78620_3_;
        double d2 = p_78620_4_;
        if(p_78620_1_ == Block.field_71962_X)
        {
            long l = (long)(p_78620_2_ * 0x2fc20f) ^ (long)p_78620_4_ * 0x6ebfff5L ^ (long)p_78620_3_;
            l = l * l * 0x285b825L + l * 11L;
            d += ((double)((float)(l >> 16 & 15L) / 15F) - 0.5D) * 0.5D;
            d1 += ((double)((float)(l >> 20 & 15L) / 15F) - 1.0D) * 0.20000000000000001D;
            d2 += ((double)((float)(l >> 24 & 15L) / 15F) - 0.5D) * 0.5D;
        }
        func_78599_a(p_78620_1_, field_78669_a.func_72805_g(p_78620_2_, p_78620_3_, p_78620_4_), d, d1, d2);
        return true;
    }

    public boolean func_78603_m(Block p_78603_1_, int p_78603_2_, int p_78603_3_, int p_78603_4_)
    {
        BlockStem blockstem = (BlockStem)p_78603_1_;
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78380_c(blockstem.func_71874_e(field_78669_a, p_78603_2_, p_78603_3_, p_78603_4_));
        float f = 1.0F;
        int i = blockstem.func_71920_b(field_78669_a, p_78603_2_, p_78603_3_, p_78603_4_);
        float f1 = (float)(i >> 16 & 0xff) / 255F;
        float f2 = (float)(i >> 8 & 0xff) / 255F;
        float f3 = (float)(i & 0xff) / 255F;
        if(EntityRenderer.field_78517_a)
        {
            float f4 = (f1 * 30F + f2 * 59F + f3 * 11F) / 100F;
            float f5 = (f1 * 30F + f2 * 70F) / 100F;
            float f6 = (f1 * 30F + f3 * 70F) / 100F;
            f1 = f4;
            f2 = f5;
            f3 = f6;
        }
        tessellator.func_78386_a(f * f1, f * f2, f * f3);
        blockstem.func_71902_a(field_78669_a, p_78603_2_, p_78603_3_, p_78603_4_);
        int j = blockstem.func_72265_d(field_78669_a, p_78603_2_, p_78603_3_, p_78603_4_);
        if(j < 0)
        {
            func_78575_a(blockstem, field_78669_a.func_72805_g(p_78603_2_, p_78603_3_, p_78603_4_), blockstem.field_72022_cl, p_78603_2_, (float)p_78603_3_ - 0.0625F, p_78603_4_);
        } else
        {
            func_78575_a(blockstem, field_78669_a.func_72805_g(p_78603_2_, p_78603_3_, p_78603_4_), 0.5D, p_78603_2_, (float)p_78603_3_ - 0.0625F, p_78603_4_);
            func_78606_a(blockstem, field_78669_a.func_72805_g(p_78603_2_, p_78603_3_, p_78603_4_), j, blockstem.field_72022_cl, p_78603_2_, (float)p_78603_3_ - 0.0625F, p_78603_4_);
        }
        return true;
    }

    public boolean func_78614_n(Block p_78614_1_, int p_78614_2_, int p_78614_3_, int p_78614_4_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78380_c(p_78614_1_.func_71874_e(field_78669_a, p_78614_2_, p_78614_3_, p_78614_4_));
        tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
        func_78579_b(p_78614_1_, field_78669_a.func_72805_g(p_78614_2_, p_78614_3_, p_78614_4_), p_78614_2_, (float)p_78614_3_ - 0.0625F, p_78614_4_);
        return true;
    }

    public void func_78623_a(Block p_78623_1_, double p_78623_2_, double p_78623_4_, double p_78623_6_, 
            double p_78623_8_, double p_78623_10_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        int i = p_78623_1_.func_71851_a(0);
        if(field_78664_d >= 0)
        {
            i = field_78664_d;
        }
        int j = (i & 0xf) << 4;
        int k = i & 0xf0;
        float f = (float)j / 256F;
        float f1 = ((float)j + 15.99F) / 256F;
        float f2 = (float)k / 256F;
        float f3 = ((float)k + 15.99F) / 256F;
        double d = (double)f + 0.02734375D;
        double d1 = (double)f2 + 0.0234375D;
        double d2 = (double)f + 0.03515625D;
        double d3 = (double)f2 + 0.03125D;
        p_78623_2_ += 0.5D;
        p_78623_6_ += 0.5D;
        double d4 = p_78623_2_ - 0.5D;
        double d5 = p_78623_2_ + 0.5D;
        double d6 = p_78623_6_ - 0.5D;
        double d7 = p_78623_6_ + 0.5D;
        double d8 = 0.0625D;
        double d9 = 0.625D;
        tessellator.func_78374_a((p_78623_2_ + p_78623_8_ * (1.0D - d9)) - d8, p_78623_4_ + d9, (p_78623_6_ + p_78623_10_ * (1.0D - d9)) - d8, d, d1);
        tessellator.func_78374_a((p_78623_2_ + p_78623_8_ * (1.0D - d9)) - d8, p_78623_4_ + d9, p_78623_6_ + p_78623_10_ * (1.0D - d9) + d8, d, d3);
        tessellator.func_78374_a(p_78623_2_ + p_78623_8_ * (1.0D - d9) + d8, p_78623_4_ + d9, p_78623_6_ + p_78623_10_ * (1.0D - d9) + d8, d2, d3);
        tessellator.func_78374_a(p_78623_2_ + p_78623_8_ * (1.0D - d9) + d8, p_78623_4_ + d9, (p_78623_6_ + p_78623_10_ * (1.0D - d9)) - d8, d2, d1);
        tessellator.func_78374_a(p_78623_2_ - d8, p_78623_4_ + 1.0D, d6, f, f2);
        tessellator.func_78374_a((p_78623_2_ - d8) + p_78623_8_, p_78623_4_ + 0.0D, d6 + p_78623_10_, f, f3);
        tessellator.func_78374_a((p_78623_2_ - d8) + p_78623_8_, p_78623_4_ + 0.0D, d7 + p_78623_10_, f1, f3);
        tessellator.func_78374_a(p_78623_2_ - d8, p_78623_4_ + 1.0D, d7, f1, f2);
        tessellator.func_78374_a(p_78623_2_ + d8, p_78623_4_ + 1.0D, d7, f, f2);
        tessellator.func_78374_a(p_78623_2_ + p_78623_8_ + d8, p_78623_4_ + 0.0D, d7 + p_78623_10_, f, f3);
        tessellator.func_78374_a(p_78623_2_ + p_78623_8_ + d8, p_78623_4_ + 0.0D, d6 + p_78623_10_, f1, f3);
        tessellator.func_78374_a(p_78623_2_ + d8, p_78623_4_ + 1.0D, d6, f1, f2);
        tessellator.func_78374_a(d4, p_78623_4_ + 1.0D, p_78623_6_ + d8, f, f2);
        tessellator.func_78374_a(d4 + p_78623_8_, p_78623_4_ + 0.0D, p_78623_6_ + d8 + p_78623_10_, f, f3);
        tessellator.func_78374_a(d5 + p_78623_8_, p_78623_4_ + 0.0D, p_78623_6_ + d8 + p_78623_10_, f1, f3);
        tessellator.func_78374_a(d5, p_78623_4_ + 1.0D, p_78623_6_ + d8, f1, f2);
        tessellator.func_78374_a(d5, p_78623_4_ + 1.0D, p_78623_6_ - d8, f, f2);
        tessellator.func_78374_a(d5 + p_78623_8_, p_78623_4_ + 0.0D, (p_78623_6_ - d8) + p_78623_10_, f, f3);
        tessellator.func_78374_a(d4 + p_78623_8_, p_78623_4_ + 0.0D, (p_78623_6_ - d8) + p_78623_10_, f1, f3);
        tessellator.func_78374_a(d4, p_78623_4_ + 1.0D, p_78623_6_ - d8, f1, f2);
    }

    public void func_78599_a(Block p_78599_1_, int p_78599_2_, double p_78599_3_, double p_78599_5_, double p_78599_7_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        int i = p_78599_1_.func_71858_a(0, p_78599_2_);
        if(field_78664_d >= 0)
        {
            i = field_78664_d;
        }
        int j = (i & 0xf) << 4;
        int k = i & 0xf0;
        double d = (float)j / 256F;
        double d1 = ((float)j + 15.99F) / 256F;
        double d2 = (float)k / 256F;
        double d3 = ((float)k + 15.99F) / 256F;
        double d4 = (p_78599_3_ + 0.5D) - 0.45000000000000001D;
        double d5 = p_78599_3_ + 0.5D + 0.45000000000000001D;
        double d6 = (p_78599_7_ + 0.5D) - 0.45000000000000001D;
        double d7 = p_78599_7_ + 0.5D + 0.45000000000000001D;
        tessellator.func_78374_a(d4, p_78599_5_ + 1.0D, d6, d, d2);
        tessellator.func_78374_a(d4, p_78599_5_ + 0.0D, d6, d, d3);
        tessellator.func_78374_a(d5, p_78599_5_ + 0.0D, d7, d1, d3);
        tessellator.func_78374_a(d5, p_78599_5_ + 1.0D, d7, d1, d2);
        tessellator.func_78374_a(d5, p_78599_5_ + 1.0D, d7, d, d2);
        tessellator.func_78374_a(d5, p_78599_5_ + 0.0D, d7, d, d3);
        tessellator.func_78374_a(d4, p_78599_5_ + 0.0D, d6, d1, d3);
        tessellator.func_78374_a(d4, p_78599_5_ + 1.0D, d6, d1, d2);
        tessellator.func_78374_a(d4, p_78599_5_ + 1.0D, d7, d, d2);
        tessellator.func_78374_a(d4, p_78599_5_ + 0.0D, d7, d, d3);
        tessellator.func_78374_a(d5, p_78599_5_ + 0.0D, d6, d1, d3);
        tessellator.func_78374_a(d5, p_78599_5_ + 1.0D, d6, d1, d2);
        tessellator.func_78374_a(d5, p_78599_5_ + 1.0D, d6, d, d2);
        tessellator.func_78374_a(d5, p_78599_5_ + 0.0D, d6, d, d3);
        tessellator.func_78374_a(d4, p_78599_5_ + 0.0D, d7, d1, d3);
        tessellator.func_78374_a(d4, p_78599_5_ + 1.0D, d7, d1, d2);
    }

    public void func_78575_a(Block p_78575_1_, int p_78575_2_, double p_78575_3_, double p_78575_5_, double p_78575_7_, double p_78575_9_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        int i = p_78575_1_.func_71858_a(0, p_78575_2_);
        if(field_78664_d >= 0)
        {
            i = field_78664_d;
        }
        int j = (i & 0xf) << 4;
        int k = i & 0xf0;
        double d = (float)j / 256F;
        double d1 = ((float)j + 15.99F) / 256F;
        double d2 = (float)k / 256F;
        double d3 = ((double)k + 15.989999771118164D * p_78575_3_) / 256D;
        double d4 = (p_78575_5_ + 0.5D) - 0.44999998807907104D;
        double d5 = p_78575_5_ + 0.5D + 0.44999998807907104D;
        double d6 = (p_78575_9_ + 0.5D) - 0.44999998807907104D;
        double d7 = p_78575_9_ + 0.5D + 0.44999998807907104D;
        tessellator.func_78374_a(d4, p_78575_7_ + p_78575_3_, d6, d, d2);
        tessellator.func_78374_a(d4, p_78575_7_ + 0.0D, d6, d, d3);
        tessellator.func_78374_a(d5, p_78575_7_ + 0.0D, d7, d1, d3);
        tessellator.func_78374_a(d5, p_78575_7_ + p_78575_3_, d7, d1, d2);
        tessellator.func_78374_a(d5, p_78575_7_ + p_78575_3_, d7, d, d2);
        tessellator.func_78374_a(d5, p_78575_7_ + 0.0D, d7, d, d3);
        tessellator.func_78374_a(d4, p_78575_7_ + 0.0D, d6, d1, d3);
        tessellator.func_78374_a(d4, p_78575_7_ + p_78575_3_, d6, d1, d2);
        tessellator.func_78374_a(d4, p_78575_7_ + p_78575_3_, d7, d, d2);
        tessellator.func_78374_a(d4, p_78575_7_ + 0.0D, d7, d, d3);
        tessellator.func_78374_a(d5, p_78575_7_ + 0.0D, d6, d1, d3);
        tessellator.func_78374_a(d5, p_78575_7_ + p_78575_3_, d6, d1, d2);
        tessellator.func_78374_a(d5, p_78575_7_ + p_78575_3_, d6, d, d2);
        tessellator.func_78374_a(d5, p_78575_7_ + 0.0D, d6, d, d3);
        tessellator.func_78374_a(d4, p_78575_7_ + 0.0D, d7, d1, d3);
        tessellator.func_78374_a(d4, p_78575_7_ + p_78575_3_, d7, d1, d2);
    }

    public boolean func_78566_o(Block p_78566_1_, int p_78566_2_, int p_78566_3_, int p_78566_4_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        int i = p_78566_1_.field_72059_bZ;
        if(field_78664_d >= 0)
        {
            i = field_78664_d;
        }
        int j = (i & 0xf) << 4;
        int k = i & 0xf0;
        float f = 0.015625F;
        double d = (float)j / 256F;
        double d1 = ((float)j + 15.99F) / 256F;
        double d2 = (float)k / 256F;
        double d3 = ((float)k + 15.99F) / 256F;
        long l = (long)(p_78566_2_ * 0x2fc20f) ^ (long)p_78566_4_ * 0x6ebfff5L ^ (long)p_78566_3_;
        l = l * l * 0x285b825L + l * 11L;
        int i1 = (int)(l >> 16 & 3L);
        tessellator.func_78380_c(p_78566_1_.func_71874_e(field_78669_a, p_78566_2_, p_78566_3_, p_78566_4_));
        float f1 = (float)p_78566_2_ + 0.5F;
        float f2 = (float)p_78566_4_ + 0.5F;
        float f3 = (float)(i1 & 1) * 0.5F * (float)(1 - ((i1 / 2) % 2) * 2);
        float f4 = (float)(i1 + 1 & 1) * 0.5F * (float)(1 - (((i1 + 1) / 2) % 2) * 2);
        tessellator.func_78378_d(p_78566_1_.func_71933_m());
        tessellator.func_78374_a((f1 + f3) - f4, (float)p_78566_3_ + f, f2 + f3 + f4, d, d2);
        tessellator.func_78374_a(f1 + f3 + f4, (float)p_78566_3_ + f, (f2 - f3) + f4, d1, d2);
        tessellator.func_78374_a((f1 - f3) + f4, (float)p_78566_3_ + f, f2 - f3 - f4, d1, d3);
        tessellator.func_78374_a(f1 - f3 - f4, (float)p_78566_3_ + f, (f2 + f3) - f4, d, d3);
        tessellator.func_78378_d((p_78566_1_.func_71933_m() & 0xfefefe) >> 1);
        tessellator.func_78374_a(f1 - f3 - f4, (float)p_78566_3_ + f, (f2 + f3) - f4, d, d3);
        tessellator.func_78374_a((f1 - f3) + f4, (float)p_78566_3_ + f, f2 - f3 - f4, d1, d3);
        tessellator.func_78374_a(f1 + f3 + f4, (float)p_78566_3_ + f, (f2 - f3) + f4, d1, d2);
        tessellator.func_78374_a((f1 + f3) - f4, (float)p_78566_3_ + f, f2 + f3 + f4, d, d2);
        return true;
    }

    public void func_78606_a(Block p_78606_1_, int p_78606_2_, int p_78606_3_, double p_78606_4_, double p_78606_6_, 
            double p_78606_8_, double p_78606_10_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        int i = p_78606_1_.func_71858_a(0, p_78606_2_) + 16;
        if(field_78664_d >= 0)
        {
            i = field_78664_d;
        }
        int j = (i & 0xf) << 4;
        int k = i & 0xf0;
        double d = (float)j / 256F;
        double d1 = ((float)j + 15.99F) / 256F;
        double d2 = (float)k / 256F;
        double d3 = ((double)k + 15.989999771118164D * p_78606_4_) / 256D;
        double d4 = (p_78606_6_ + 0.5D) - 0.5D;
        double d5 = p_78606_6_ + 0.5D + 0.5D;
        double d6 = (p_78606_10_ + 0.5D) - 0.5D;
        double d7 = p_78606_10_ + 0.5D + 0.5D;
        double d8 = p_78606_6_ + 0.5D;
        double d9 = p_78606_10_ + 0.5D;
        if(((p_78606_3_ + 1) / 2) % 2 == 1)
        {
            double d10 = d1;
            d1 = d;
            d = d10;
        }
        if(p_78606_3_ < 2)
        {
            tessellator.func_78374_a(d4, p_78606_8_ + p_78606_4_, d9, d, d2);
            tessellator.func_78374_a(d4, p_78606_8_ + 0.0D, d9, d, d3);
            tessellator.func_78374_a(d5, p_78606_8_ + 0.0D, d9, d1, d3);
            tessellator.func_78374_a(d5, p_78606_8_ + p_78606_4_, d9, d1, d2);
            tessellator.func_78374_a(d5, p_78606_8_ + p_78606_4_, d9, d1, d2);
            tessellator.func_78374_a(d5, p_78606_8_ + 0.0D, d9, d1, d3);
            tessellator.func_78374_a(d4, p_78606_8_ + 0.0D, d9, d, d3);
            tessellator.func_78374_a(d4, p_78606_8_ + p_78606_4_, d9, d, d2);
        } else
        {
            tessellator.func_78374_a(d8, p_78606_8_ + p_78606_4_, d7, d, d2);
            tessellator.func_78374_a(d8, p_78606_8_ + 0.0D, d7, d, d3);
            tessellator.func_78374_a(d8, p_78606_8_ + 0.0D, d6, d1, d3);
            tessellator.func_78374_a(d8, p_78606_8_ + p_78606_4_, d6, d1, d2);
            tessellator.func_78374_a(d8, p_78606_8_ + p_78606_4_, d6, d1, d2);
            tessellator.func_78374_a(d8, p_78606_8_ + 0.0D, d6, d1, d3);
            tessellator.func_78374_a(d8, p_78606_8_ + 0.0D, d7, d, d3);
            tessellator.func_78374_a(d8, p_78606_8_ + p_78606_4_, d7, d, d2);
        }
    }

    public void func_78579_b(Block p_78579_1_, int p_78579_2_, double p_78579_3_, double p_78579_5_, double p_78579_7_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        int i = p_78579_1_.func_71858_a(0, p_78579_2_);
        if(field_78664_d >= 0)
        {
            i = field_78664_d;
        }
        int j = (i & 0xf) << 4;
        int k = i & 0xf0;
        double d = (float)j / 256F;
        double d1 = ((float)j + 15.99F) / 256F;
        double d2 = (float)k / 256F;
        double d3 = ((float)k + 15.99F) / 256F;
        double d4 = (p_78579_3_ + 0.5D) - 0.25D;
        double d5 = p_78579_3_ + 0.5D + 0.25D;
        double d6 = (p_78579_7_ + 0.5D) - 0.5D;
        double d7 = p_78579_7_ + 0.5D + 0.5D;
        tessellator.func_78374_a(d4, p_78579_5_ + 1.0D, d6, d, d2);
        tessellator.func_78374_a(d4, p_78579_5_ + 0.0D, d6, d, d3);
        tessellator.func_78374_a(d4, p_78579_5_ + 0.0D, d7, d1, d3);
        tessellator.func_78374_a(d4, p_78579_5_ + 1.0D, d7, d1, d2);
        tessellator.func_78374_a(d4, p_78579_5_ + 1.0D, d7, d, d2);
        tessellator.func_78374_a(d4, p_78579_5_ + 0.0D, d7, d, d3);
        tessellator.func_78374_a(d4, p_78579_5_ + 0.0D, d6, d1, d3);
        tessellator.func_78374_a(d4, p_78579_5_ + 1.0D, d6, d1, d2);
        tessellator.func_78374_a(d5, p_78579_5_ + 1.0D, d7, d, d2);
        tessellator.func_78374_a(d5, p_78579_5_ + 0.0D, d7, d, d3);
        tessellator.func_78374_a(d5, p_78579_5_ + 0.0D, d6, d1, d3);
        tessellator.func_78374_a(d5, p_78579_5_ + 1.0D, d6, d1, d2);
        tessellator.func_78374_a(d5, p_78579_5_ + 1.0D, d6, d, d2);
        tessellator.func_78374_a(d5, p_78579_5_ + 0.0D, d6, d, d3);
        tessellator.func_78374_a(d5, p_78579_5_ + 0.0D, d7, d1, d3);
        tessellator.func_78374_a(d5, p_78579_5_ + 1.0D, d7, d1, d2);
        d4 = (p_78579_3_ + 0.5D) - 0.5D;
        d5 = p_78579_3_ + 0.5D + 0.5D;
        d6 = (p_78579_7_ + 0.5D) - 0.25D;
        d7 = p_78579_7_ + 0.5D + 0.25D;
        tessellator.func_78374_a(d4, p_78579_5_ + 1.0D, d6, d, d2);
        tessellator.func_78374_a(d4, p_78579_5_ + 0.0D, d6, d, d3);
        tessellator.func_78374_a(d5, p_78579_5_ + 0.0D, d6, d1, d3);
        tessellator.func_78374_a(d5, p_78579_5_ + 1.0D, d6, d1, d2);
        tessellator.func_78374_a(d5, p_78579_5_ + 1.0D, d6, d, d2);
        tessellator.func_78374_a(d5, p_78579_5_ + 0.0D, d6, d, d3);
        tessellator.func_78374_a(d4, p_78579_5_ + 0.0D, d6, d1, d3);
        tessellator.func_78374_a(d4, p_78579_5_ + 1.0D, d6, d1, d2);
        tessellator.func_78374_a(d5, p_78579_5_ + 1.0D, d7, d, d2);
        tessellator.func_78374_a(d5, p_78579_5_ + 0.0D, d7, d, d3);
        tessellator.func_78374_a(d4, p_78579_5_ + 0.0D, d7, d1, d3);
        tessellator.func_78374_a(d4, p_78579_5_ + 1.0D, d7, d1, d2);
        tessellator.func_78374_a(d4, p_78579_5_ + 1.0D, d7, d, d2);
        tessellator.func_78374_a(d4, p_78579_5_ + 0.0D, d7, d, d3);
        tessellator.func_78374_a(d5, p_78579_5_ + 0.0D, d7, d1, d3);
        tessellator.func_78374_a(d5, p_78579_5_ + 1.0D, d7, d1, d2);
    }

    public boolean func_78621_p(Block p_78621_1_, int p_78621_2_, int p_78621_3_, int p_78621_4_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        int i = p_78621_1_.func_71920_b(field_78669_a, p_78621_2_, p_78621_3_, p_78621_4_);
        float f = (float)(i >> 16 & 0xff) / 255F;
        float f1 = (float)(i >> 8 & 0xff) / 255F;
        float f2 = (float)(i & 0xff) / 255F;
        boolean flag = p_78621_1_.func_71877_c(field_78669_a, p_78621_2_, p_78621_3_ + 1, p_78621_4_, 1);
        boolean flag1 = p_78621_1_.func_71877_c(field_78669_a, p_78621_2_, p_78621_3_ - 1, p_78621_4_, 0);
        boolean aflag[] = new boolean[4];
        aflag[0] = p_78621_1_.func_71877_c(field_78669_a, p_78621_2_, p_78621_3_, p_78621_4_ - 1, 2);
        aflag[1] = p_78621_1_.func_71877_c(field_78669_a, p_78621_2_, p_78621_3_, p_78621_4_ + 1, 3);
        aflag[2] = p_78621_1_.func_71877_c(field_78669_a, p_78621_2_ - 1, p_78621_3_, p_78621_4_, 4);
        aflag[3] = p_78621_1_.func_71877_c(field_78669_a, p_78621_2_ + 1, p_78621_3_, p_78621_4_, 5);
        if(!flag && !flag1 && !aflag[0] && !aflag[1] && !aflag[2] && !aflag[3])
        {
            return false;
        }
        boolean flag2 = false;
        float f3 = 0.5F;
        float f4 = 1.0F;
        float f5 = 0.8F;
        float f6 = 0.6F;
        double d = 0.0D;
        double d1 = 1.0D;
        Material material = p_78621_1_.field_72018_cp;
        int j = field_78669_a.func_72805_g(p_78621_2_, p_78621_3_, p_78621_4_);
        double d2 = func_78596_a(p_78621_2_, p_78621_3_, p_78621_4_, material);
        double d3 = func_78596_a(p_78621_2_, p_78621_3_, p_78621_4_ + 1, material);
        double d4 = func_78596_a(p_78621_2_ + 1, p_78621_3_, p_78621_4_ + 1, material);
        double d5 = func_78596_a(p_78621_2_ + 1, p_78621_3_, p_78621_4_, material);
        double d6 = 0.0010000000474974513D;
        if(field_78661_f || flag)
        {
            flag2 = true;
            int k = p_78621_1_.func_71858_a(1, j);
            float f8 = (float)BlockFluid.func_72204_a(field_78669_a, p_78621_2_, p_78621_3_, p_78621_4_, material);
            if(f8 > -999F)
            {
                k = p_78621_1_.func_71858_a(2, j);
            }
            d2 -= d6;
            d3 -= d6;
            d4 -= d6;
            d5 -= d6;
            int j1 = (k & 0xf) << 4;
            int l1 = k & 0xf0;
            double d7 = ((double)j1 + 8D) / 256D;
            double d8 = ((double)l1 + 8D) / 256D;
            if(f8 < -999F)
            {
                f8 = 0.0F;
            } else
            {
                d7 = (float)(j1 + 16) / 256F;
                d8 = (float)(l1 + 16) / 256F;
            }
            double d10 = (double)(MathHelper.func_76126_a(f8) * 8F) / 256D;
            double d12 = (double)(MathHelper.func_76134_b(f8) * 8F) / 256D;
            tessellator.func_78380_c(p_78621_1_.func_71874_e(field_78669_a, p_78621_2_, p_78621_3_, p_78621_4_));
            float f9 = 1.0F;
            tessellator.func_78386_a(f4 * f9 * f, f4 * f9 * f1, f4 * f9 * f2);
            tessellator.func_78374_a(p_78621_2_ + 0, (double)p_78621_3_ + d2, p_78621_4_ + 0, d7 - d12 - d10, (d8 - d12) + d10);
            tessellator.func_78374_a(p_78621_2_ + 0, (double)p_78621_3_ + d3, p_78621_4_ + 1, (d7 - d12) + d10, d8 + d12 + d10);
            tessellator.func_78374_a(p_78621_2_ + 1, (double)p_78621_3_ + d4, p_78621_4_ + 1, d7 + d12 + d10, (d8 + d12) - d10);
            tessellator.func_78374_a(p_78621_2_ + 1, (double)p_78621_3_ + d5, p_78621_4_ + 0, (d7 + d12) - d10, d8 - d12 - d10);
        }
        if(field_78661_f || flag1)
        {
            tessellator.func_78380_c(p_78621_1_.func_71874_e(field_78669_a, p_78621_2_, p_78621_3_ - 1, p_78621_4_));
            float f7 = 1.0F;
            tessellator.func_78386_a(f3 * f7, f3 * f7, f3 * f7);
            func_78613_a(p_78621_1_, p_78621_2_, (double)p_78621_3_ + d6, p_78621_4_, p_78621_1_.func_71851_a(0));
            flag2 = true;
        }
        for(int l = 0; l < 4; l++)
        {
            int i1 = p_78621_2_;
            int k1 = p_78621_3_;
            int i2 = p_78621_4_;
            if(l == 0)
            {
                i2--;
            }
            if(l == 1)
            {
                i2++;
            }
            if(l == 2)
            {
                i1--;
            }
            if(l == 3)
            {
                i1++;
            }
            int j2 = p_78621_1_.func_71858_a(l + 2, j);
            int k2 = (j2 & 0xf) << 4;
            int l2 = j2 & 0xf0;
            if(!field_78661_f && !aflag[l])
            {
                continue;
            }
            double d9;
            double d11;
            double d13;
            double d14;
            double d15;
            double d16;
            if(l == 0)
            {
                d9 = d2;
                d11 = d5;
                d13 = p_78621_2_;
                d15 = p_78621_2_ + 1;
                d14 = (double)p_78621_4_ + d6;
                d16 = (double)p_78621_4_ + d6;
            } else
            if(l == 1)
            {
                d9 = d4;
                d11 = d3;
                d13 = p_78621_2_ + 1;
                d15 = p_78621_2_;
                d14 = (double)(p_78621_4_ + 1) - d6;
                d16 = (double)(p_78621_4_ + 1) - d6;
            } else
            if(l == 2)
            {
                d9 = d3;
                d11 = d2;
                d13 = (double)p_78621_2_ + d6;
                d15 = (double)p_78621_2_ + d6;
                d14 = p_78621_4_ + 1;
                d16 = p_78621_4_;
            } else
            {
                d9 = d5;
                d11 = d4;
                d13 = (double)(p_78621_2_ + 1) - d6;
                d15 = (double)(p_78621_2_ + 1) - d6;
                d14 = p_78621_4_;
                d16 = p_78621_4_ + 1;
            }
            flag2 = true;
            double d17 = (float)(k2 + 0) / 256F;
            double d18 = ((double)(k2 + 16) - 0.01D) / 256D;
            double d19 = ((double)l2 + (1.0D - d9) * 16D) / 256D;
            double d20 = ((double)l2 + (1.0D - d11) * 16D) / 256D;
            double d21 = ((double)(l2 + 16) - 0.01D) / 256D;
            tessellator.func_78380_c(p_78621_1_.func_71874_e(field_78669_a, i1, k1, i2));
            float f10 = 1.0F;
            if(l < 2)
            {
                f10 *= f5;
            } else
            {
                f10 *= f6;
            }
            tessellator.func_78386_a(f4 * f10 * f, f4 * f10 * f1, f4 * f10 * f2);
            tessellator.func_78374_a(d13, (double)p_78621_3_ + d9, d14, d17, d19);
            tessellator.func_78374_a(d15, (double)p_78621_3_ + d11, d16, d18, d20);
            tessellator.func_78374_a(d15, p_78621_3_ + 0, d16, d18, d21);
            tessellator.func_78374_a(d13, p_78621_3_ + 0, d14, d17, d21);
        }

        p_78621_1_.field_72023_ci = d;
        p_78621_1_.field_72022_cl = d1;
        return flag2;
    }

    public float func_78596_a(int p_78596_1_, int p_78596_2_, int p_78596_3_, Material p_78596_4_)
    {
        int i = 0;
        float f = 0.0F;
        for(int j = 0; j < 4; j++)
        {
            int k = p_78596_1_ - (j & 1);
            int l = p_78596_2_;
            int i1 = p_78596_3_ - (j >> 1 & 1);
            if(field_78669_a.func_72803_f(k, l + 1, i1) == p_78596_4_)
            {
                return 1.0F;
            }
            Material material = field_78669_a.func_72803_f(k, l, i1);
            if(material == p_78596_4_)
            {
                int j1 = field_78669_a.func_72805_g(k, l, i1);
                if(j1 >= 8 || j1 == 0)
                {
                    f += BlockFluid.func_72199_d(j1) * 10F;
                    i += 10;
                }
                f += BlockFluid.func_72199_d(j1);
                i++;
                continue;
            }
            if(!material.func_76220_a())
            {
                f++;
                i++;
            }
        }

        return 1.0F - f / (float)i;
    }

    public void func_78588_a(Block p_78588_1_, World p_78588_2_, int p_78588_3_, int p_78588_4_, int p_78588_5_, int p_78588_6_)
    {
        float f = 0.5F;
        float f1 = 1.0F;
        float f2 = 0.8F;
        float f3 = 0.6F;
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78382_b();
        tessellator.func_78380_c(p_78588_1_.func_71874_e(p_78588_2_, p_78588_3_, p_78588_4_, p_78588_5_));
        float f4 = 1.0F;
        float f5 = 1.0F;
        if(f5 < f4)
        {
            f5 = f4;
        }
        tessellator.func_78386_a(f * f5, f * f5, f * f5);
        func_78613_a(p_78588_1_, -0.5D, -0.5D, -0.5D, p_78588_1_.func_71858_a(0, p_78588_6_));
        f5 = 1.0F;
        if(f5 < f4)
        {
            f5 = f4;
        }
        tessellator.func_78386_a(f1 * f5, f1 * f5, f1 * f5);
        func_78617_b(p_78588_1_, -0.5D, -0.5D, -0.5D, p_78588_1_.func_71858_a(1, p_78588_6_));
        f5 = 1.0F;
        if(f5 < f4)
        {
            f5 = f4;
        }
        tessellator.func_78386_a(f2 * f5, f2 * f5, f2 * f5);
        func_78611_c(p_78588_1_, -0.5D, -0.5D, -0.5D, p_78588_1_.func_71858_a(2, p_78588_6_));
        f5 = 1.0F;
        if(f5 < f4)
        {
            f5 = f4;
        }
        tessellator.func_78386_a(f2 * f5, f2 * f5, f2 * f5);
        func_78622_d(p_78588_1_, -0.5D, -0.5D, -0.5D, p_78588_1_.func_71858_a(3, p_78588_6_));
        f5 = 1.0F;
        if(f5 < f4)
        {
            f5 = f4;
        }
        tessellator.func_78386_a(f3 * f5, f3 * f5, f3 * f5);
        func_78573_e(p_78588_1_, -0.5D, -0.5D, -0.5D, p_78588_1_.func_71858_a(4, p_78588_6_));
        f5 = 1.0F;
        if(f5 < f4)
        {
            f5 = f4;
        }
        tessellator.func_78386_a(f3 * f5, f3 * f5, f3 * f5);
        func_78605_f(p_78588_1_, -0.5D, -0.5D, -0.5D, p_78588_1_.func_71858_a(5, p_78588_6_));
        tessellator.func_78381_a();
    }

    public boolean func_78570_q(Block p_78570_1_, int p_78570_2_, int p_78570_3_, int p_78570_4_)
    {
        int i = p_78570_1_.func_71920_b(field_78669_a, p_78570_2_, p_78570_3_, p_78570_4_);
        float f = (float)(i >> 16 & 0xff) / 255F;
        float f1 = (float)(i >> 8 & 0xff) / 255F;
        float f2 = (float)(i & 0xff) / 255F;
        if(EntityRenderer.field_78517_a)
        {
            float f3 = (f * 30F + f1 * 59F + f2 * 11F) / 100F;
            float f4 = (f * 30F + f1 * 70F) / 100F;
            float f5 = (f * 30F + f2 * 70F) / 100F;
            f = f3;
            f1 = f4;
            f2 = f5;
        }
        if(Minecraft.func_71379_u() && Block.field_71984_q[p_78570_1_.field_71990_ca] == 0)
        {
            return func_78578_a(p_78570_1_, p_78570_2_, p_78570_3_, p_78570_4_, f, f1, f2);
        } else
        {
            return func_78609_c(p_78570_1_, p_78570_2_, p_78570_3_, p_78570_4_, f, f1, f2);
        }
    }

    public boolean func_78581_r(Block p_78581_1_, int p_78581_2_, int p_78581_3_, int p_78581_4_)
    {
        int i = field_78669_a.func_72805_g(p_78581_2_, p_78581_3_, p_78581_4_);
        int j = i & 0xc;
        if(j == 4)
        {
            field_78662_g = 1;
            field_78683_h = 1;
            field_78681_k = 1;
            field_78675_l = 1;
        } else
        if(j == 8)
        {
            field_78685_i = 1;
            field_78679_j = 1;
        }
        boolean flag = func_78570_q(p_78581_1_, p_78581_2_, p_78581_3_, p_78581_4_);
        field_78685_i = 0;
        field_78662_g = 0;
        field_78683_h = 0;
        field_78679_j = 0;
        field_78681_k = 0;
        field_78675_l = 0;
        return flag;
    }

    public boolean func_78578_a(Block p_78578_1_, int p_78578_2_, int p_78578_3_, int p_78578_4_, float p_78578_5_, float p_78578_6_, float p_78578_7_)
    {
        field_78677_m = true;
        boolean flag = false;
        float f = field_78671_n;
        float f1 = field_78671_n;
        float f2 = field_78671_n;
        float f3 = field_78671_n;
        boolean flag1 = true;
        boolean flag2 = true;
        boolean flag3 = true;
        boolean flag4 = true;
        boolean flag5 = true;
        boolean flag6 = true;
        field_78671_n = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_);
        field_78673_o = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
        field_78701_p = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
        field_78699_q = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
        field_78697_r = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
        field_78695_s = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
        field_78693_t = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
        int i = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_);
        int j = i;
        int k = i;
        int l = i;
        int i1 = i;
        int j1 = i;
        int k1 = i;
        if(p_78578_1_.field_72023_ci <= 0.0D)
        {
            k = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
        }
        if(p_78578_1_.field_72022_cl >= 1.0D)
        {
            j1 = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
        }
        if(p_78578_1_.field_72026_ch <= 0.0D)
        {
            j = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
        }
        if(p_78578_1_.field_72021_ck >= 1.0D)
        {
            i1 = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
        }
        if(p_78578_1_.field_72024_cj <= 0.0D)
        {
            l = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
        }
        if(p_78578_1_.field_72019_cm >= 1.0D)
        {
            k1 = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
        }
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78380_c(0xf000f);
        field_78654_aE = Block.field_71985_p[field_78669_a.func_72798_a(p_78578_2_ + 1, p_78578_3_ + 1, p_78578_4_)];
        field_78646_aM = Block.field_71985_p[field_78669_a.func_72798_a(p_78578_2_ + 1, p_78578_3_ - 1, p_78578_4_)];
        field_78638_aI = Block.field_71985_p[field_78669_a.func_72798_a(p_78578_2_ + 1, p_78578_3_, p_78578_4_ + 1)];
        field_78642_aK = Block.field_71985_p[field_78669_a.func_72798_a(p_78578_2_ + 1, p_78578_3_, p_78578_4_ - 1)];
        field_78656_aF = Block.field_71985_p[field_78669_a.func_72798_a(p_78578_2_ - 1, p_78578_3_ + 1, p_78578_4_)];
        field_78647_aN = Block.field_71985_p[field_78669_a.func_72798_a(p_78578_2_ - 1, p_78578_3_ - 1, p_78578_4_)];
        field_78659_aH = Block.field_71985_p[field_78669_a.func_72798_a(p_78578_2_ - 1, p_78578_3_, p_78578_4_ - 1)];
        field_78640_aJ = Block.field_71985_p[field_78669_a.func_72798_a(p_78578_2_ - 1, p_78578_3_, p_78578_4_ + 1)];
        field_78658_aG = Block.field_71985_p[field_78669_a.func_72798_a(p_78578_2_, p_78578_3_ + 1, p_78578_4_ + 1)];
        field_78653_aD = Block.field_71985_p[field_78669_a.func_72798_a(p_78578_2_, p_78578_3_ + 1, p_78578_4_ - 1)];
        field_78648_aO = Block.field_71985_p[field_78669_a.func_72798_a(p_78578_2_, p_78578_3_ - 1, p_78578_4_ + 1)];
        field_78644_aL = Block.field_71985_p[field_78669_a.func_72798_a(p_78578_2_, p_78578_3_ - 1, p_78578_4_ - 1)];
        if(p_78578_1_.field_72059_bZ == 3)
        {
            flag1 = flag3 = flag4 = flag5 = flag6 = false;
        }
        if(field_78664_d >= 0)
        {
            flag1 = flag3 = flag4 = flag5 = flag6 = false;
        }
        if(field_78661_f || p_78578_1_.func_71877_c(field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_, 0))
        {
            float f4;
            float f10;
            float f16;
            float f22;
            if(field_78698_am > 0)
            {
                if(p_78578_1_.field_72023_ci <= 0.0D)
                {
                    p_78578_3_--;
                }
                field_78641_T = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
                field_78645_V = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
                field_78643_W = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
                field_78655_Y = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
                field_78689_v = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
                field_78712_x = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
                field_78710_y = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
                field_78628_A = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
                if(field_78644_aL || field_78647_aN)
                {
                    field_78691_u = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_ - 1);
                    field_78649_S = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_ - 1);
                } else
                {
                    field_78691_u = field_78689_v;
                    field_78649_S = field_78641_T;
                }
                if(field_78648_aO || field_78647_aN)
                {
                    field_78687_w = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_ + 1);
                    field_78639_U = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_ + 1);
                } else
                {
                    field_78687_w = field_78689_v;
                    field_78639_U = field_78641_T;
                }
                if(field_78644_aL || field_78646_aM)
                {
                    field_78708_z = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_ - 1);
                    field_78657_X = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_ - 1);
                } else
                {
                    field_78708_z = field_78628_A;
                    field_78657_X = field_78655_Y;
                }
                if(field_78648_aO || field_78646_aM)
                {
                    field_78629_B = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_ + 1);
                    field_78660_Z = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_ + 1);
                } else
                {
                    field_78629_B = field_78628_A;
                    field_78660_Z = field_78655_Y;
                }
                if(p_78578_1_.field_72023_ci <= 0.0D)
                {
                    p_78578_3_++;
                }
                f4 = (field_78687_w + field_78689_v + field_78710_y + field_78701_p) / 4F;
                f22 = (field_78710_y + field_78701_p + field_78629_B + field_78628_A) / 4F;
                f16 = (field_78701_p + field_78712_x + field_78628_A + field_78708_z) / 4F;
                f10 = (field_78689_v + field_78691_u + field_78701_p + field_78712_x) / 4F;
                field_78700_an = func_78602_a(field_78639_U, field_78641_T, field_78643_W, k);
                field_78676_aq = func_78602_a(field_78643_W, field_78660_Z, field_78655_Y, k);
                field_78696_ap = func_78602_a(field_78645_V, field_78655_Y, field_78657_X, k);
                field_78694_ao = func_78602_a(field_78641_T, field_78649_S, field_78645_V, k);
            } else
            {
                f4 = f10 = f16 = f22 = field_78701_p;
                field_78700_an = field_78694_ao = field_78696_ap = field_78676_aq = field_78641_T;
            }
            field_78674_ar = field_78672_as = field_78670_at = field_78684_au = (flag1 ? p_78578_5_ : 1.0F) * 0.5F;
            field_78682_av = field_78680_aw = field_78678_ax = field_78665_ay = (flag1 ? p_78578_6_ : 1.0F) * 0.5F;
            field_78663_az = field_78650_aA = field_78651_aB = field_78652_aC = (flag1 ? p_78578_7_ : 1.0F) * 0.5F;
            field_78674_ar *= f4;
            field_78682_av *= f4;
            field_78663_az *= f4;
            field_78672_as *= f10;
            field_78680_aw *= f10;
            field_78650_aA *= f10;
            field_78670_at *= f16;
            field_78678_ax *= f16;
            field_78651_aB *= f16;
            field_78684_au *= f22;
            field_78665_ay *= f22;
            field_78652_aC *= f22;
            func_78613_a(p_78578_1_, p_78578_2_, p_78578_3_, p_78578_4_, p_78578_1_.func_71895_b(field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_, 0));
            flag = true;
        }
        if(field_78661_f || p_78578_1_.func_71877_c(field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_, 1))
        {
            float f5;
            float f11;
            float f17;
            float f23;
            if(field_78698_am > 0)
            {
                if(p_78578_1_.field_72022_cl >= 1.0D)
                {
                    p_78578_3_++;
                }
                field_78705_ab = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
                field_78711_af = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
                field_78703_ad = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
                field_78706_ag = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
                field_78624_D = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
                field_78634_H = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
                field_78626_F = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
                field_78635_I = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
                if(field_78653_aD || field_78656_aF)
                {
                    field_78630_C = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_ - 1);
                    field_78704_aa = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_ - 1);
                } else
                {
                    field_78630_C = field_78624_D;
                    field_78704_aa = field_78705_ab;
                }
                if(field_78653_aD || field_78654_aE)
                {
                    field_78627_G = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_ - 1);
                    field_78709_ae = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_ - 1);
                } else
                {
                    field_78627_G = field_78634_H;
                    field_78709_ae = field_78711_af;
                }
                if(field_78658_aG || field_78656_aF)
                {
                    field_78625_E = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_ + 1);
                    field_78702_ac = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_ + 1);
                } else
                {
                    field_78625_E = field_78624_D;
                    field_78702_ac = field_78705_ab;
                }
                if(field_78658_aG || field_78654_aE)
                {
                    field_78636_J = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_ + 1);
                    field_78707_ah = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_ + 1);
                } else
                {
                    field_78636_J = field_78634_H;
                    field_78707_ah = field_78711_af;
                }
                if(p_78578_1_.field_72022_cl >= 1.0D)
                {
                    p_78578_3_--;
                }
                f23 = (field_78625_E + field_78624_D + field_78635_I + field_78695_s) / 4F;
                f5 = (field_78635_I + field_78695_s + field_78636_J + field_78634_H) / 4F;
                f11 = (field_78695_s + field_78626_F + field_78634_H + field_78627_G) / 4F;
                f17 = (field_78624_D + field_78630_C + field_78695_s + field_78626_F) / 4F;
                field_78676_aq = func_78602_a(field_78702_ac, field_78705_ab, field_78706_ag, j1);
                field_78700_an = func_78602_a(field_78706_ag, field_78707_ah, field_78711_af, j1);
                field_78694_ao = func_78602_a(field_78703_ad, field_78711_af, field_78709_ae, j1);
                field_78696_ap = func_78602_a(field_78705_ab, field_78704_aa, field_78703_ad, j1);
            } else
            {
                f5 = f11 = f17 = f23 = field_78695_s;
                field_78700_an = field_78694_ao = field_78696_ap = field_78676_aq = j1;
            }
            field_78674_ar = field_78672_as = field_78670_at = field_78684_au = flag2 ? p_78578_5_ : 1.0F;
            field_78682_av = field_78680_aw = field_78678_ax = field_78665_ay = flag2 ? p_78578_6_ : 1.0F;
            field_78663_az = field_78650_aA = field_78651_aB = field_78652_aC = flag2 ? p_78578_7_ : 1.0F;
            field_78674_ar *= f5;
            field_78682_av *= f5;
            field_78663_az *= f5;
            field_78672_as *= f11;
            field_78680_aw *= f11;
            field_78650_aA *= f11;
            field_78670_at *= f17;
            field_78678_ax *= f17;
            field_78651_aB *= f17;
            field_78684_au *= f23;
            field_78665_ay *= f23;
            field_78652_aC *= f23;
            func_78617_b(p_78578_1_, p_78578_2_, p_78578_3_, p_78578_4_, p_78578_1_.func_71895_b(field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_, 1));
            flag = true;
        }
        if(field_78661_f || p_78578_1_.func_71877_c(field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1, 2))
        {
            float f6;
            float f12;
            float f18;
            float f24;
            if(field_78698_am > 0)
            {
                if(p_78578_1_.field_72024_cj <= 0.0D)
                {
                    p_78578_4_--;
                }
                field_78637_K = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
                field_78712_x = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
                field_78626_F = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
                field_78631_L = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
                field_78690_ai = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
                field_78645_V = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
                field_78703_ad = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
                field_78692_aj = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
                if(field_78659_aH || field_78644_aL)
                {
                    field_78691_u = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_ - 1, p_78578_3_ - 1, p_78578_4_);
                    field_78649_S = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_ - 1, p_78578_3_ - 1, p_78578_4_);
                } else
                {
                    field_78691_u = field_78637_K;
                    field_78649_S = field_78690_ai;
                }
                if(field_78659_aH || field_78653_aD)
                {
                    field_78630_C = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_ - 1, p_78578_3_ + 1, p_78578_4_);
                    field_78704_aa = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_ - 1, p_78578_3_ + 1, p_78578_4_);
                } else
                {
                    field_78630_C = field_78637_K;
                    field_78704_aa = field_78690_ai;
                }
                if(field_78642_aK || field_78644_aL)
                {
                    field_78708_z = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_ + 1, p_78578_3_ - 1, p_78578_4_);
                    field_78657_X = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_ + 1, p_78578_3_ - 1, p_78578_4_);
                } else
                {
                    field_78708_z = field_78631_L;
                    field_78657_X = field_78692_aj;
                }
                if(field_78642_aK || field_78653_aD)
                {
                    field_78627_G = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_ + 1, p_78578_3_ + 1, p_78578_4_);
                    field_78709_ae = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_ + 1, p_78578_3_ + 1, p_78578_4_);
                } else
                {
                    field_78627_G = field_78631_L;
                    field_78709_ae = field_78692_aj;
                }
                if(p_78578_1_.field_72024_cj <= 0.0D)
                {
                    p_78578_4_++;
                }
                f6 = (field_78637_K + field_78630_C + field_78699_q + field_78626_F) / 4F;
                f12 = (field_78699_q + field_78626_F + field_78631_L + field_78627_G) / 4F;
                f18 = (field_78712_x + field_78699_q + field_78708_z + field_78631_L) / 4F;
                f24 = (field_78691_u + field_78637_K + field_78712_x + field_78699_q) / 4F;
                field_78700_an = func_78602_a(field_78690_ai, field_78704_aa, field_78703_ad, l);
                field_78694_ao = func_78602_a(field_78703_ad, field_78692_aj, field_78709_ae, l);
                field_78696_ap = func_78602_a(field_78645_V, field_78657_X, field_78692_aj, l);
                field_78676_aq = func_78602_a(field_78649_S, field_78690_ai, field_78645_V, l);
            } else
            {
                f6 = f12 = f18 = f24 = field_78699_q;
                field_78700_an = field_78694_ao = field_78696_ap = field_78676_aq = l;
            }
            field_78674_ar = field_78672_as = field_78670_at = field_78684_au = (flag3 ? p_78578_5_ : 1.0F) * 0.8F;
            field_78682_av = field_78680_aw = field_78678_ax = field_78665_ay = (flag3 ? p_78578_6_ : 1.0F) * 0.8F;
            field_78663_az = field_78650_aA = field_78651_aB = field_78652_aC = (flag3 ? p_78578_7_ : 1.0F) * 0.8F;
            field_78674_ar *= f6;
            field_78682_av *= f6;
            field_78663_az *= f6;
            field_78672_as *= f12;
            field_78680_aw *= f12;
            field_78650_aA *= f12;
            field_78670_at *= f18;
            field_78678_ax *= f18;
            field_78651_aB *= f18;
            field_78684_au *= f24;
            field_78665_ay *= f24;
            field_78652_aC *= f24;
            int l1 = p_78578_1_.func_71895_b(field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_, 2);
            func_78611_c(p_78578_1_, p_78578_2_, p_78578_3_, p_78578_4_, l1);
            if(field_78667_b && l1 == 3 && field_78664_d < 0)
            {
                field_78674_ar *= p_78578_5_;
                field_78672_as *= p_78578_5_;
                field_78670_at *= p_78578_5_;
                field_78684_au *= p_78578_5_;
                field_78682_av *= p_78578_6_;
                field_78680_aw *= p_78578_6_;
                field_78678_ax *= p_78578_6_;
                field_78665_ay *= p_78578_6_;
                field_78663_az *= p_78578_7_;
                field_78650_aA *= p_78578_7_;
                field_78651_aB *= p_78578_7_;
                field_78652_aC *= p_78578_7_;
                func_78611_c(p_78578_1_, p_78578_2_, p_78578_3_, p_78578_4_, 38);
            }
            flag = true;
        }
        if(field_78661_f || p_78578_1_.func_71877_c(field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1, 3))
        {
            float f7;
            float f13;
            float f19;
            float f25;
            if(field_78698_am > 0)
            {
                if(p_78578_1_.field_72019_cm >= 1.0D)
                {
                    p_78578_4_++;
                }
                field_78632_M = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
                field_78633_N = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
                field_78710_y = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
                field_78635_I = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
                field_78686_ak = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
                field_78688_al = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
                field_78643_W = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
                field_78706_ag = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
                if(field_78640_aJ || field_78648_aO)
                {
                    field_78687_w = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_ - 1, p_78578_3_ - 1, p_78578_4_);
                    field_78639_U = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_ - 1, p_78578_3_ - 1, p_78578_4_);
                } else
                {
                    field_78687_w = field_78632_M;
                    field_78639_U = field_78686_ak;
                }
                if(field_78640_aJ || field_78658_aG)
                {
                    field_78625_E = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_ - 1, p_78578_3_ + 1, p_78578_4_);
                    field_78702_ac = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_ - 1, p_78578_3_ + 1, p_78578_4_);
                } else
                {
                    field_78625_E = field_78632_M;
                    field_78702_ac = field_78686_ak;
                }
                if(field_78638_aI || field_78648_aO)
                {
                    field_78629_B = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_ + 1, p_78578_3_ - 1, p_78578_4_);
                    field_78660_Z = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_ + 1, p_78578_3_ - 1, p_78578_4_);
                } else
                {
                    field_78629_B = field_78633_N;
                    field_78660_Z = field_78688_al;
                }
                if(field_78638_aI || field_78658_aG)
                {
                    field_78636_J = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_ + 1, p_78578_3_ + 1, p_78578_4_);
                    field_78707_ah = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_ + 1, p_78578_3_ + 1, p_78578_4_);
                } else
                {
                    field_78636_J = field_78633_N;
                    field_78707_ah = field_78688_al;
                }
                if(p_78578_1_.field_72019_cm >= 1.0D)
                {
                    p_78578_4_--;
                }
                f7 = (field_78632_M + field_78625_E + field_78693_t + field_78635_I) / 4F;
                f25 = (field_78693_t + field_78635_I + field_78633_N + field_78636_J) / 4F;
                f19 = (field_78710_y + field_78693_t + field_78629_B + field_78633_N) / 4F;
                f13 = (field_78687_w + field_78632_M + field_78710_y + field_78693_t) / 4F;
                field_78700_an = func_78602_a(field_78686_ak, field_78702_ac, field_78706_ag, k1);
                field_78676_aq = func_78602_a(field_78706_ag, field_78688_al, field_78707_ah, k1);
                field_78696_ap = func_78602_a(field_78643_W, field_78660_Z, field_78688_al, k1);
                field_78694_ao = func_78602_a(field_78639_U, field_78686_ak, field_78643_W, k1);
            } else
            {
                f7 = f13 = f19 = f25 = field_78693_t;
                field_78700_an = field_78694_ao = field_78696_ap = field_78676_aq = k1;
            }
            field_78674_ar = field_78672_as = field_78670_at = field_78684_au = (flag4 ? p_78578_5_ : 1.0F) * 0.8F;
            field_78682_av = field_78680_aw = field_78678_ax = field_78665_ay = (flag4 ? p_78578_6_ : 1.0F) * 0.8F;
            field_78663_az = field_78650_aA = field_78651_aB = field_78652_aC = (flag4 ? p_78578_7_ : 1.0F) * 0.8F;
            field_78674_ar *= f7;
            field_78682_av *= f7;
            field_78663_az *= f7;
            field_78672_as *= f13;
            field_78680_aw *= f13;
            field_78650_aA *= f13;
            field_78670_at *= f19;
            field_78678_ax *= f19;
            field_78651_aB *= f19;
            field_78684_au *= f25;
            field_78665_ay *= f25;
            field_78652_aC *= f25;
            int i2 = p_78578_1_.func_71895_b(field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_, 3);
            func_78622_d(p_78578_1_, p_78578_2_, p_78578_3_, p_78578_4_, p_78578_1_.func_71895_b(field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_, 3));
            if(field_78667_b && i2 == 3 && field_78664_d < 0)
            {
                field_78674_ar *= p_78578_5_;
                field_78672_as *= p_78578_5_;
                field_78670_at *= p_78578_5_;
                field_78684_au *= p_78578_5_;
                field_78682_av *= p_78578_6_;
                field_78680_aw *= p_78578_6_;
                field_78678_ax *= p_78578_6_;
                field_78665_ay *= p_78578_6_;
                field_78663_az *= p_78578_7_;
                field_78650_aA *= p_78578_7_;
                field_78651_aB *= p_78578_7_;
                field_78652_aC *= p_78578_7_;
                func_78622_d(p_78578_1_, p_78578_2_, p_78578_3_, p_78578_4_, 38);
            }
            flag = true;
        }
        if(field_78661_f || p_78578_1_.func_71877_c(field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_, 4))
        {
            float f8;
            float f14;
            float f20;
            float f26;
            if(field_78698_am > 0)
            {
                if(p_78578_1_.field_72026_ch <= 0.0D)
                {
                    p_78578_2_--;
                }
                field_78689_v = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
                field_78637_K = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
                field_78632_M = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
                field_78624_D = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
                field_78641_T = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
                field_78690_ai = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
                field_78686_ak = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
                field_78705_ab = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
                if(field_78659_aH || field_78647_aN)
                {
                    field_78691_u = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_ - 1);
                    field_78649_S = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_ - 1);
                } else
                {
                    field_78691_u = field_78637_K;
                    field_78649_S = field_78690_ai;
                }
                if(field_78640_aJ || field_78647_aN)
                {
                    field_78687_w = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_ + 1);
                    field_78639_U = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_ + 1);
                } else
                {
                    field_78687_w = field_78632_M;
                    field_78639_U = field_78686_ak;
                }
                if(field_78659_aH || field_78656_aF)
                {
                    field_78630_C = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_ - 1);
                    field_78704_aa = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_ - 1);
                } else
                {
                    field_78630_C = field_78637_K;
                    field_78704_aa = field_78690_ai;
                }
                if(field_78640_aJ || field_78656_aF)
                {
                    field_78625_E = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_ + 1);
                    field_78702_ac = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_ + 1);
                } else
                {
                    field_78625_E = field_78632_M;
                    field_78702_ac = field_78686_ak;
                }
                if(p_78578_1_.field_72026_ch <= 0.0D)
                {
                    p_78578_2_++;
                }
                f26 = (field_78689_v + field_78687_w + field_78673_o + field_78632_M) / 4F;
                f8 = (field_78673_o + field_78632_M + field_78624_D + field_78625_E) / 4F;
                f14 = (field_78637_K + field_78673_o + field_78630_C + field_78624_D) / 4F;
                f20 = (field_78691_u + field_78689_v + field_78637_K + field_78673_o) / 4F;
                field_78676_aq = func_78602_a(field_78641_T, field_78639_U, field_78686_ak, j);
                field_78700_an = func_78602_a(field_78686_ak, field_78705_ab, field_78702_ac, j);
                field_78694_ao = func_78602_a(field_78690_ai, field_78704_aa, field_78705_ab, j);
                field_78696_ap = func_78602_a(field_78649_S, field_78641_T, field_78690_ai, j);
            } else
            {
                f8 = f14 = f20 = f26 = field_78673_o;
                field_78700_an = field_78694_ao = field_78696_ap = field_78676_aq = j;
            }
            field_78674_ar = field_78672_as = field_78670_at = field_78684_au = (flag5 ? p_78578_5_ : 1.0F) * 0.6F;
            field_78682_av = field_78680_aw = field_78678_ax = field_78665_ay = (flag5 ? p_78578_6_ : 1.0F) * 0.6F;
            field_78663_az = field_78650_aA = field_78651_aB = field_78652_aC = (flag5 ? p_78578_7_ : 1.0F) * 0.6F;
            field_78674_ar *= f8;
            field_78682_av *= f8;
            field_78663_az *= f8;
            field_78672_as *= f14;
            field_78680_aw *= f14;
            field_78650_aA *= f14;
            field_78670_at *= f20;
            field_78678_ax *= f20;
            field_78651_aB *= f20;
            field_78684_au *= f26;
            field_78665_ay *= f26;
            field_78652_aC *= f26;
            int j2 = p_78578_1_.func_71895_b(field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_, 4);
            func_78573_e(p_78578_1_, p_78578_2_, p_78578_3_, p_78578_4_, j2);
            if(field_78667_b && j2 == 3 && field_78664_d < 0)
            {
                field_78674_ar *= p_78578_5_;
                field_78672_as *= p_78578_5_;
                field_78670_at *= p_78578_5_;
                field_78684_au *= p_78578_5_;
                field_78682_av *= p_78578_6_;
                field_78680_aw *= p_78578_6_;
                field_78678_ax *= p_78578_6_;
                field_78665_ay *= p_78578_6_;
                field_78663_az *= p_78578_7_;
                field_78650_aA *= p_78578_7_;
                field_78651_aB *= p_78578_7_;
                field_78652_aC *= p_78578_7_;
                func_78573_e(p_78578_1_, p_78578_2_, p_78578_3_, p_78578_4_, 38);
            }
            flag = true;
        }
        if(field_78661_f || p_78578_1_.func_71877_c(field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_, 5))
        {
            float f9;
            float f15;
            float f21;
            float f27;
            if(field_78698_am > 0)
            {
                if(p_78578_1_.field_72021_ck >= 1.0D)
                {
                    p_78578_2_++;
                }
                field_78628_A = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
                field_78631_L = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
                field_78633_N = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
                field_78634_H = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
                field_78655_Y = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
                field_78692_aj = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
                field_78688_al = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
                field_78711_af = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
                if(field_78646_aM || field_78642_aK)
                {
                    field_78708_z = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_ - 1);
                    field_78657_X = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_ - 1);
                } else
                {
                    field_78708_z = field_78631_L;
                    field_78657_X = field_78692_aj;
                }
                if(field_78646_aM || field_78638_aI)
                {
                    field_78629_B = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_ + 1);
                    field_78660_Z = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_ + 1);
                } else
                {
                    field_78629_B = field_78633_N;
                    field_78660_Z = field_78688_al;
                }
                if(field_78654_aE || field_78642_aK)
                {
                    field_78627_G = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_ - 1);
                    field_78709_ae = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_ - 1);
                } else
                {
                    field_78627_G = field_78631_L;
                    field_78709_ae = field_78692_aj;
                }
                if(field_78654_aE || field_78638_aI)
                {
                    field_78636_J = p_78578_1_.func_71888_h(field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_ + 1);
                    field_78707_ah = p_78578_1_.func_71874_e(field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_ + 1);
                } else
                {
                    field_78636_J = field_78633_N;
                    field_78707_ah = field_78688_al;
                }
                if(p_78578_1_.field_72021_ck >= 1.0D)
                {
                    p_78578_2_--;
                }
                f9 = (field_78628_A + field_78629_B + field_78697_r + field_78633_N) / 4F;
                f27 = (field_78697_r + field_78633_N + field_78634_H + field_78636_J) / 4F;
                f21 = (field_78631_L + field_78697_r + field_78627_G + field_78634_H) / 4F;
                f15 = (field_78708_z + field_78628_A + field_78631_L + field_78697_r) / 4F;
                field_78700_an = func_78602_a(field_78655_Y, field_78660_Z, field_78688_al, i1);
                field_78676_aq = func_78602_a(field_78688_al, field_78711_af, field_78707_ah, i1);
                field_78696_ap = func_78602_a(field_78692_aj, field_78709_ae, field_78711_af, i1);
                field_78694_ao = func_78602_a(field_78657_X, field_78655_Y, field_78692_aj, i1);
            } else
            {
                f9 = f15 = f21 = f27 = field_78697_r;
                field_78700_an = field_78694_ao = field_78696_ap = field_78676_aq = i1;
            }
            field_78674_ar = field_78672_as = field_78670_at = field_78684_au = (flag6 ? p_78578_5_ : 1.0F) * 0.6F;
            field_78682_av = field_78680_aw = field_78678_ax = field_78665_ay = (flag6 ? p_78578_6_ : 1.0F) * 0.6F;
            field_78663_az = field_78650_aA = field_78651_aB = field_78652_aC = (flag6 ? p_78578_7_ : 1.0F) * 0.6F;
            field_78674_ar *= f9;
            field_78682_av *= f9;
            field_78663_az *= f9;
            field_78672_as *= f15;
            field_78680_aw *= f15;
            field_78650_aA *= f15;
            field_78670_at *= f21;
            field_78678_ax *= f21;
            field_78651_aB *= f21;
            field_78684_au *= f27;
            field_78665_ay *= f27;
            field_78652_aC *= f27;
            int k2 = p_78578_1_.func_71895_b(field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_, 5);
            func_78605_f(p_78578_1_, p_78578_2_, p_78578_3_, p_78578_4_, k2);
            if(field_78667_b && k2 == 3 && field_78664_d < 0)
            {
                field_78674_ar *= p_78578_5_;
                field_78672_as *= p_78578_5_;
                field_78670_at *= p_78578_5_;
                field_78684_au *= p_78578_5_;
                field_78682_av *= p_78578_6_;
                field_78680_aw *= p_78578_6_;
                field_78678_ax *= p_78578_6_;
                field_78665_ay *= p_78578_6_;
                field_78663_az *= p_78578_7_;
                field_78650_aA *= p_78578_7_;
                field_78651_aB *= p_78578_7_;
                field_78652_aC *= p_78578_7_;
                func_78605_f(p_78578_1_, p_78578_2_, p_78578_3_, p_78578_4_, 38);
            }
            flag = true;
        }
        field_78677_m = false;
        return flag;
    }

    public int func_78602_a(int p_78602_1_, int p_78602_2_, int p_78602_3_, int p_78602_4_)
    {
        if(p_78602_1_ == 0)
        {
            p_78602_1_ = p_78602_4_;
        }
        if(p_78602_2_ == 0)
        {
            p_78602_2_ = p_78602_4_;
        }
        if(p_78602_3_ == 0)
        {
            p_78602_3_ = p_78602_4_;
        }
        return p_78602_1_ + p_78602_2_ + p_78602_3_ + p_78602_4_ >> 2 & 0xff00ff;
    }

    public boolean func_78609_c(Block p_78609_1_, int p_78609_2_, int p_78609_3_, int p_78609_4_, float p_78609_5_, float p_78609_6_, float p_78609_7_)
    {
        field_78677_m = false;
        Tessellator tessellator = Tessellator.field_78398_a;
        boolean flag = false;
        float f = 0.5F;
        float f1 = 1.0F;
        float f2 = 0.8F;
        float f3 = 0.6F;
        float f4 = f1 * p_78609_5_;
        float f5 = f1 * p_78609_6_;
        float f6 = f1 * p_78609_7_;
        float f7 = f;
        float f8 = f2;
        float f9 = f3;
        float f10 = f;
        float f11 = f2;
        float f12 = f3;
        float f13 = f;
        float f14 = f2;
        float f15 = f3;
        if(p_78609_1_ != Block.field_71980_u)
        {
            f7 *= p_78609_5_;
            f8 *= p_78609_5_;
            f9 *= p_78609_5_;
            f10 *= p_78609_6_;
            f11 *= p_78609_6_;
            f12 *= p_78609_6_;
            f13 *= p_78609_7_;
            f14 *= p_78609_7_;
            f15 *= p_78609_7_;
        }
        int i = p_78609_1_.func_71874_e(field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_);
        if(field_78661_f || p_78609_1_.func_71877_c(field_78669_a, p_78609_2_, p_78609_3_ - 1, p_78609_4_, 0))
        {
            tessellator.func_78380_c(p_78609_1_.field_72023_ci > 0.0D ? i : p_78609_1_.func_71874_e(field_78669_a, p_78609_2_, p_78609_3_ - 1, p_78609_4_));
            tessellator.func_78386_a(f7, f10, f13);
            func_78613_a(p_78609_1_, p_78609_2_, p_78609_3_, p_78609_4_, p_78609_1_.func_71895_b(field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_, 0));
            flag = true;
        }
        if(field_78661_f || p_78609_1_.func_71877_c(field_78669_a, p_78609_2_, p_78609_3_ + 1, p_78609_4_, 1))
        {
            tessellator.func_78380_c(p_78609_1_.field_72022_cl < 1.0D ? i : p_78609_1_.func_71874_e(field_78669_a, p_78609_2_, p_78609_3_ + 1, p_78609_4_));
            tessellator.func_78386_a(f4, f5, f6);
            func_78617_b(p_78609_1_, p_78609_2_, p_78609_3_, p_78609_4_, p_78609_1_.func_71895_b(field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_, 1));
            flag = true;
        }
        if(field_78661_f || p_78609_1_.func_71877_c(field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_ - 1, 2))
        {
            tessellator.func_78380_c(p_78609_1_.field_72024_cj > 0.0D ? i : p_78609_1_.func_71874_e(field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_ - 1));
            tessellator.func_78386_a(f8, f11, f14);
            int j = p_78609_1_.func_71895_b(field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_, 2);
            func_78611_c(p_78609_1_, p_78609_2_, p_78609_3_, p_78609_4_, j);
            if(field_78667_b && j == 3 && field_78664_d < 0)
            {
                tessellator.func_78386_a(f8 * p_78609_5_, f11 * p_78609_6_, f14 * p_78609_7_);
                func_78611_c(p_78609_1_, p_78609_2_, p_78609_3_, p_78609_4_, 38);
            }
            flag = true;
        }
        if(field_78661_f || p_78609_1_.func_71877_c(field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_ + 1, 3))
        {
            tessellator.func_78380_c(p_78609_1_.field_72019_cm < 1.0D ? i : p_78609_1_.func_71874_e(field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_ + 1));
            tessellator.func_78386_a(f8, f11, f14);
            int k = p_78609_1_.func_71895_b(field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_, 3);
            func_78622_d(p_78609_1_, p_78609_2_, p_78609_3_, p_78609_4_, k);
            if(field_78667_b && k == 3 && field_78664_d < 0)
            {
                tessellator.func_78386_a(f8 * p_78609_5_, f11 * p_78609_6_, f14 * p_78609_7_);
                func_78622_d(p_78609_1_, p_78609_2_, p_78609_3_, p_78609_4_, 38);
            }
            flag = true;
        }
        if(field_78661_f || p_78609_1_.func_71877_c(field_78669_a, p_78609_2_ - 1, p_78609_3_, p_78609_4_, 4))
        {
            tessellator.func_78380_c(p_78609_1_.field_72026_ch > 0.0D ? i : p_78609_1_.func_71874_e(field_78669_a, p_78609_2_ - 1, p_78609_3_, p_78609_4_));
            tessellator.func_78386_a(f9, f12, f15);
            int l = p_78609_1_.func_71895_b(field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_, 4);
            func_78573_e(p_78609_1_, p_78609_2_, p_78609_3_, p_78609_4_, l);
            if(field_78667_b && l == 3 && field_78664_d < 0)
            {
                tessellator.func_78386_a(f9 * p_78609_5_, f12 * p_78609_6_, f15 * p_78609_7_);
                func_78573_e(p_78609_1_, p_78609_2_, p_78609_3_, p_78609_4_, 38);
            }
            flag = true;
        }
        if(field_78661_f || p_78609_1_.func_71877_c(field_78669_a, p_78609_2_ + 1, p_78609_3_, p_78609_4_, 5))
        {
            tessellator.func_78380_c(p_78609_1_.field_72021_ck < 1.0D ? i : p_78609_1_.func_71874_e(field_78669_a, p_78609_2_ + 1, p_78609_3_, p_78609_4_));
            tessellator.func_78386_a(f9, f12, f15);
            int i1 = p_78609_1_.func_71895_b(field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_, 5);
            func_78605_f(p_78609_1_, p_78609_2_, p_78609_3_, p_78609_4_, i1);
            if(field_78667_b && i1 == 3 && field_78664_d < 0)
            {
                tessellator.func_78386_a(f9 * p_78609_5_, f12 * p_78609_6_, f15 * p_78609_7_);
                func_78605_f(p_78609_1_, p_78609_2_, p_78609_3_, p_78609_4_, 38);
            }
            flag = true;
        }
        return flag;
    }

    public boolean func_78616_a(BlockCocoa p_78616_1_, int p_78616_2_, int p_78616_3_, int p_78616_4_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78380_c(p_78616_1_.func_71874_e(field_78669_a, p_78616_2_, p_78616_3_, p_78616_4_));
        tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
        int i = field_78669_a.func_72805_g(p_78616_2_, p_78616_3_, p_78616_4_);
        int j = p_78616_1_.func_71851_a(1);
        int k = BlockDirectional.func_72217_d(i);
        int l = BlockCocoa.func_72219_c(i);
        j = (j + 2) - l;
        int i1 = 4 + l * 2;
        int j1 = 5 + l * 2;
        int k1 = (j & 0xf) << 4;
        int l1 = j & 0xf0;
        double d = 15D - (double)i1;
        double d1 = 15D;
        double d2 = 4D;
        double d3 = 4D + (double)j1;
        double d4 = ((double)k1 + d) / 256D;
        double d5 = (((double)k1 + d1) - 0.01D) / 256D;
        double d6 = ((double)l1 + d2) / 256D;
        double d7 = (((double)l1 + d3) - 0.01D) / 256D;
        double d8 = 0.0D;
        double d9 = 0.0D;
        switch(k)
        {
        case 2: // '\002'
            d8 = 8D - (double)(i1 / 2);
            d9 = 1.0D;
            break;

        case 0: // '\0'
            d8 = 8D - (double)(i1 / 2);
            d9 = 15D - (double)i1;
            break;

        case 3: // '\003'
            d8 = 15D - (double)i1;
            d9 = 8D - (double)(i1 / 2);
            break;

        case 1: // '\001'
            d8 = 1.0D;
            d9 = 8D - (double)(i1 / 2);
            break;
        }
        double d10 = (double)p_78616_2_ + d8 / 16D;
        double d11 = (double)p_78616_2_ + (d8 + (double)i1) / 16D;
        double d12 = (double)p_78616_3_ + (12D - (double)j1) / 16D;
        double d13 = (double)p_78616_3_ + 0.75D;
        double d14 = (double)p_78616_4_ + d9 / 16D;
        double d15 = (double)p_78616_4_ + (d9 + (double)i1) / 16D;
        tessellator.func_78374_a(d10, d12, d14, d4, d7);
        tessellator.func_78374_a(d10, d12, d15, d5, d7);
        tessellator.func_78374_a(d10, d13, d15, d5, d6);
        tessellator.func_78374_a(d10, d13, d14, d4, d6);
        tessellator.func_78374_a(d11, d12, d15, d4, d7);
        tessellator.func_78374_a(d11, d12, d14, d5, d7);
        tessellator.func_78374_a(d11, d13, d14, d5, d6);
        tessellator.func_78374_a(d11, d13, d15, d4, d6);
        tessellator.func_78374_a(d11, d12, d14, d4, d7);
        tessellator.func_78374_a(d10, d12, d14, d5, d7);
        tessellator.func_78374_a(d10, d13, d14, d5, d6);
        tessellator.func_78374_a(d11, d13, d14, d4, d6);
        tessellator.func_78374_a(d10, d12, d15, d4, d7);
        tessellator.func_78374_a(d11, d12, d15, d5, d7);
        tessellator.func_78374_a(d11, d13, d15, d5, d6);
        tessellator.func_78374_a(d10, d13, d15, d4, d6);
        int i2 = i1;
        if(l >= 2)
        {
            i2--;
        }
        d4 = (float)(k1 + 0) / 256F;
        d5 = ((double)(k1 + i2) - 0.01D) / 256D;
        d6 = (float)(l1 + 0) / 256F;
        d7 = ((double)(l1 + i2) - 0.01D) / 256D;
        tessellator.func_78374_a(d10, d13, d15, d4, d7);
        tessellator.func_78374_a(d11, d13, d15, d5, d7);
        tessellator.func_78374_a(d11, d13, d14, d5, d6);
        tessellator.func_78374_a(d10, d13, d14, d4, d6);
        tessellator.func_78374_a(d10, d12, d14, d4, d6);
        tessellator.func_78374_a(d11, d12, d14, d5, d6);
        tessellator.func_78374_a(d11, d12, d15, d5, d7);
        tessellator.func_78374_a(d10, d12, d15, d4, d7);
        d4 = (float)(k1 + 12) / 256F;
        d5 = ((double)(k1 + 16) - 0.01D) / 256D;
        d6 = (float)(l1 + 0) / 256F;
        d7 = ((double)(l1 + 4) - 0.01D) / 256D;
        d8 = 8D;
        d9 = 0.0D;
        switch(k)
        {
        case 2: // '\002'
            d8 = 8D;
            d9 = 0.0D;
            break;

        case 0: // '\0'
            d8 = 8D;
            d9 = 12D;
            double d16 = d4;
            d4 = d5;
            d5 = d16;
            break;

        case 3: // '\003'
            d8 = 12D;
            d9 = 8D;
            double d17 = d4;
            d4 = d5;
            d5 = d17;
            break;

        case 1: // '\001'
            d8 = 0.0D;
            d9 = 8D;
            break;
        }
        d10 = (double)p_78616_2_ + d8 / 16D;
        d11 = (double)p_78616_2_ + (d8 + 4D) / 16D;
        d12 = (double)p_78616_3_ + 0.75D;
        d13 = (double)p_78616_3_ + 1.0D;
        d14 = (double)p_78616_4_ + d9 / 16D;
        d15 = (double)p_78616_4_ + (d9 + 4D) / 16D;
        if(k == 2 || k == 0)
        {
            tessellator.func_78374_a(d10, d12, d14, d5, d7);
            tessellator.func_78374_a(d10, d12, d15, d4, d7);
            tessellator.func_78374_a(d10, d13, d15, d4, d6);
            tessellator.func_78374_a(d10, d13, d14, d5, d6);
            tessellator.func_78374_a(d10, d12, d15, d4, d7);
            tessellator.func_78374_a(d10, d12, d14, d5, d7);
            tessellator.func_78374_a(d10, d13, d14, d5, d6);
            tessellator.func_78374_a(d10, d13, d15, d4, d6);
        } else
        if(k == 1 || k == 3)
        {
            tessellator.func_78374_a(d11, d12, d14, d4, d7);
            tessellator.func_78374_a(d10, d12, d14, d5, d7);
            tessellator.func_78374_a(d10, d13, d14, d5, d6);
            tessellator.func_78374_a(d11, d13, d14, d4, d6);
            tessellator.func_78374_a(d10, d12, d14, d5, d7);
            tessellator.func_78374_a(d11, d12, d14, d4, d7);
            tessellator.func_78374_a(d11, d13, d14, d4, d6);
            tessellator.func_78374_a(d10, d13, d14, d5, d6);
        }
        return true;
    }

    public boolean func_78584_s(Block p_78584_1_, int p_78584_2_, int p_78584_3_, int p_78584_4_)
    {
        int i = p_78584_1_.func_71920_b(field_78669_a, p_78584_2_, p_78584_3_, p_78584_4_);
        float f = (float)(i >> 16 & 0xff) / 255F;
        float f1 = (float)(i >> 8 & 0xff) / 255F;
        float f2 = (float)(i & 0xff) / 255F;
        if(EntityRenderer.field_78517_a)
        {
            float f3 = (f * 30F + f1 * 59F + f2 * 11F) / 100F;
            float f4 = (f * 30F + f1 * 70F) / 100F;
            float f5 = (f * 30F + f2 * 70F) / 100F;
            f = f3;
            f1 = f4;
            f2 = f5;
        }
        return func_78569_d(p_78584_1_, p_78584_2_, p_78584_3_, p_78584_4_, f, f1, f2);
    }

    public boolean func_78569_d(Block p_78569_1_, int p_78569_2_, int p_78569_3_, int p_78569_4_, float p_78569_5_, float p_78569_6_, float p_78569_7_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        boolean flag = false;
        float f = 0.5F;
        float f1 = 1.0F;
        float f2 = 0.8F;
        float f3 = 0.6F;
        float f4 = f * p_78569_5_;
        float f5 = f1 * p_78569_5_;
        float f6 = f2 * p_78569_5_;
        float f7 = f3 * p_78569_5_;
        float f8 = f * p_78569_6_;
        float f9 = f1 * p_78569_6_;
        float f10 = f2 * p_78569_6_;
        float f11 = f3 * p_78569_6_;
        float f12 = f * p_78569_7_;
        float f13 = f1 * p_78569_7_;
        float f14 = f2 * p_78569_7_;
        float f15 = f3 * p_78569_7_;
        float f16 = 0.0625F;
        int i = p_78569_1_.func_71874_e(field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_);
        if(field_78661_f || p_78569_1_.func_71877_c(field_78669_a, p_78569_2_, p_78569_3_ - 1, p_78569_4_, 0))
        {
            tessellator.func_78380_c(p_78569_1_.field_72023_ci > 0.0D ? i : p_78569_1_.func_71874_e(field_78669_a, p_78569_2_, p_78569_3_ - 1, p_78569_4_));
            tessellator.func_78386_a(f4, f8, f12);
            func_78613_a(p_78569_1_, p_78569_2_, p_78569_3_, p_78569_4_, p_78569_1_.func_71895_b(field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_, 0));
            flag = true;
        }
        if(field_78661_f || p_78569_1_.func_71877_c(field_78669_a, p_78569_2_, p_78569_3_ + 1, p_78569_4_, 1))
        {
            tessellator.func_78380_c(p_78569_1_.field_72022_cl < 1.0D ? i : p_78569_1_.func_71874_e(field_78669_a, p_78569_2_, p_78569_3_ + 1, p_78569_4_));
            tessellator.func_78386_a(f5, f9, f13);
            func_78617_b(p_78569_1_, p_78569_2_, p_78569_3_, p_78569_4_, p_78569_1_.func_71895_b(field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_, 1));
            flag = true;
        }
        if(field_78661_f || p_78569_1_.func_71877_c(field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_ - 1, 2))
        {
            tessellator.func_78380_c(p_78569_1_.field_72024_cj > 0.0D ? i : p_78569_1_.func_71874_e(field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_ - 1));
            tessellator.func_78386_a(f6, f10, f14);
            tessellator.func_78372_c(0.0F, 0.0F, f16);
            func_78611_c(p_78569_1_, p_78569_2_, p_78569_3_, p_78569_4_, p_78569_1_.func_71895_b(field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_, 2));
            tessellator.func_78372_c(0.0F, 0.0F, -f16);
            flag = true;
        }
        if(field_78661_f || p_78569_1_.func_71877_c(field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_ + 1, 3))
        {
            tessellator.func_78380_c(p_78569_1_.field_72019_cm < 1.0D ? i : p_78569_1_.func_71874_e(field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_ + 1));
            tessellator.func_78386_a(f6, f10, f14);
            tessellator.func_78372_c(0.0F, 0.0F, -f16);
            func_78622_d(p_78569_1_, p_78569_2_, p_78569_3_, p_78569_4_, p_78569_1_.func_71895_b(field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_, 3));
            tessellator.func_78372_c(0.0F, 0.0F, f16);
            flag = true;
        }
        if(field_78661_f || p_78569_1_.func_71877_c(field_78669_a, p_78569_2_ - 1, p_78569_3_, p_78569_4_, 4))
        {
            tessellator.func_78380_c(p_78569_1_.field_72026_ch > 0.0D ? i : p_78569_1_.func_71874_e(field_78669_a, p_78569_2_ - 1, p_78569_3_, p_78569_4_));
            tessellator.func_78386_a(f7, f11, f15);
            tessellator.func_78372_c(f16, 0.0F, 0.0F);
            func_78573_e(p_78569_1_, p_78569_2_, p_78569_3_, p_78569_4_, p_78569_1_.func_71895_b(field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_, 4));
            tessellator.func_78372_c(-f16, 0.0F, 0.0F);
            flag = true;
        }
        if(field_78661_f || p_78569_1_.func_71877_c(field_78669_a, p_78569_2_ + 1, p_78569_3_, p_78569_4_, 5))
        {
            tessellator.func_78380_c(p_78569_1_.field_72021_ck < 1.0D ? i : p_78569_1_.func_71874_e(field_78669_a, p_78569_2_ + 1, p_78569_3_, p_78569_4_));
            tessellator.func_78386_a(f7, f11, f15);
            tessellator.func_78372_c(-f16, 0.0F, 0.0F);
            func_78605_f(p_78569_1_, p_78569_2_, p_78569_3_, p_78569_4_, p_78569_1_.func_71895_b(field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_, 5));
            tessellator.func_78372_c(f16, 0.0F, 0.0F);
            flag = true;
        }
        return flag;
    }

    public boolean func_78582_a(BlockFence p_78582_1_, int p_78582_2_, int p_78582_3_, int p_78582_4_)
    {
        boolean flag = false;
        float f = 0.375F;
        float f1 = 0.625F;
        p_78582_1_.func_71905_a(f, 0.0F, f, f1, 1.0F, f1);
        func_78570_q(p_78582_1_, p_78582_2_, p_78582_3_, p_78582_4_);
        flag = true;
        boolean flag1 = false;
        boolean flag2 = false;
        if(p_78582_1_.func_72250_d(field_78669_a, p_78582_2_ - 1, p_78582_3_, p_78582_4_) || p_78582_1_.func_72250_d(field_78669_a, p_78582_2_ + 1, p_78582_3_, p_78582_4_))
        {
            flag1 = true;
        }
        if(p_78582_1_.func_72250_d(field_78669_a, p_78582_2_, p_78582_3_, p_78582_4_ - 1) || p_78582_1_.func_72250_d(field_78669_a, p_78582_2_, p_78582_3_, p_78582_4_ + 1))
        {
            flag2 = true;
        }
        boolean flag3 = p_78582_1_.func_72250_d(field_78669_a, p_78582_2_ - 1, p_78582_3_, p_78582_4_);
        boolean flag4 = p_78582_1_.func_72250_d(field_78669_a, p_78582_2_ + 1, p_78582_3_, p_78582_4_);
        boolean flag5 = p_78582_1_.func_72250_d(field_78669_a, p_78582_2_, p_78582_3_, p_78582_4_ - 1);
        boolean flag6 = p_78582_1_.func_72250_d(field_78669_a, p_78582_2_, p_78582_3_, p_78582_4_ + 1);
        if(!flag1 && !flag2)
        {
            flag1 = true;
        }
        f = 0.4375F;
        f1 = 0.5625F;
        float f2 = 0.75F;
        float f3 = 0.9375F;
        float f4 = flag3 ? 0.0F : f;
        float f5 = flag4 ? 1.0F : f1;
        float f6 = flag5 ? 0.0F : f;
        float f7 = flag6 ? 1.0F : f1;
        if(flag1)
        {
            p_78582_1_.func_71905_a(f4, f2, f, f5, f3, f1);
            func_78570_q(p_78582_1_, p_78582_2_, p_78582_3_, p_78582_4_);
            flag = true;
        }
        if(flag2)
        {
            p_78582_1_.func_71905_a(f, f2, f6, f1, f3, f7);
            func_78570_q(p_78582_1_, p_78582_2_, p_78582_3_, p_78582_4_);
            flag = true;
        }
        f2 = 0.375F;
        f3 = 0.5625F;
        if(flag1)
        {
            p_78582_1_.func_71905_a(f4, f2, f, f5, f3, f1);
            func_78570_q(p_78582_1_, p_78582_2_, p_78582_3_, p_78582_4_);
            flag = true;
        }
        if(flag2)
        {
            p_78582_1_.func_71905_a(f, f2, f6, f1, f3, f7);
            func_78570_q(p_78582_1_, p_78582_2_, p_78582_3_, p_78582_4_);
            flag = true;
        }
        p_78582_1_.func_71902_a(field_78669_a, p_78582_2_, p_78582_3_, p_78582_4_);
        return flag;
    }

    public boolean func_78618_a(BlockDragonEgg p_78618_1_, int p_78618_2_, int p_78618_3_, int p_78618_4_)
    {
        boolean flag = false;
        int i = 0;
        for(int j = 0; j < 8; j++)
        {
            int k = 0;
            byte byte0 = 1;
            if(j == 0)
            {
                k = 2;
            }
            if(j == 1)
            {
                k = 3;
            }
            if(j == 2)
            {
                k = 4;
            }
            if(j == 3)
            {
                k = 5;
                byte0 = 2;
            }
            if(j == 4)
            {
                k = 6;
                byte0 = 3;
            }
            if(j == 5)
            {
                k = 7;
                byte0 = 5;
            }
            if(j == 6)
            {
                k = 6;
                byte0 = 2;
            }
            if(j == 7)
            {
                k = 3;
            }
            float f = (float)k / 16F;
            float f1 = 1.0F - (float)i / 16F;
            float f2 = 1.0F - (float)(i + byte0) / 16F;
            i += byte0;
            p_78618_1_.func_71905_a(0.5F - f, f2, 0.5F - f, 0.5F + f, f1, 0.5F + f);
            func_78570_q(p_78618_1_, p_78618_2_, p_78618_3_, p_78618_4_);
        }

        flag = true;
        p_78618_1_.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        return flag;
    }

    public boolean func_78580_a(BlockFenceGate p_78580_1_, int p_78580_2_, int p_78580_3_, int p_78580_4_)
    {
        boolean flag = true;
        int i = field_78669_a.func_72805_g(p_78580_2_, p_78580_3_, p_78580_4_);
        boolean flag1 = BlockFenceGate.func_72224_c(i);
        int j = BlockDirectional.func_72217_d(i);
        if(j == 3 || j == 1)
        {
            float f = 0.4375F;
            float f4 = 0.5625F;
            float f8 = 0.0F;
            float f12 = 0.125F;
            p_78580_1_.func_71905_a(f, 0.3125F, f8, f4, 1.0F, f12);
            func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            f8 = 0.875F;
            f12 = 1.0F;
            p_78580_1_.func_71905_a(f, 0.3125F, f8, f4, 1.0F, f12);
            func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
        } else
        {
            float f1 = 0.0F;
            float f5 = 0.125F;
            float f9 = 0.4375F;
            float f13 = 0.5625F;
            p_78580_1_.func_71905_a(f1, 0.3125F, f9, f5, 1.0F, f13);
            func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            f1 = 0.875F;
            f5 = 1.0F;
            p_78580_1_.func_71905_a(f1, 0.3125F, f9, f5, 1.0F, f13);
            func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
        }
        if(flag1)
        {
            if(j == 3)
            {
                p_78580_1_.func_71905_a(0.8125F, 0.375F, 0.0F, 0.9375F, 0.9375F, 0.125F);
                func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                p_78580_1_.func_71905_a(0.8125F, 0.375F, 0.875F, 0.9375F, 0.9375F, 1.0F);
                func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                p_78580_1_.func_71905_a(0.5625F, 0.375F, 0.0F, 0.8125F, 0.5625F, 0.125F);
                func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                p_78580_1_.func_71905_a(0.5625F, 0.375F, 0.875F, 0.8125F, 0.5625F, 1.0F);
                func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                p_78580_1_.func_71905_a(0.5625F, 0.75F, 0.0F, 0.8125F, 0.9375F, 0.125F);
                func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                p_78580_1_.func_71905_a(0.5625F, 0.75F, 0.875F, 0.8125F, 0.9375F, 1.0F);
                func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            } else
            if(j == 1)
            {
                p_78580_1_.func_71905_a(0.0625F, 0.375F, 0.0F, 0.1875F, 0.9375F, 0.125F);
                func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                p_78580_1_.func_71905_a(0.0625F, 0.375F, 0.875F, 0.1875F, 0.9375F, 1.0F);
                func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                p_78580_1_.func_71905_a(0.1875F, 0.375F, 0.0F, 0.4375F, 0.5625F, 0.125F);
                func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                p_78580_1_.func_71905_a(0.1875F, 0.375F, 0.875F, 0.4375F, 0.5625F, 1.0F);
                func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                p_78580_1_.func_71905_a(0.1875F, 0.75F, 0.0F, 0.4375F, 0.9375F, 0.125F);
                func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                p_78580_1_.func_71905_a(0.1875F, 0.75F, 0.875F, 0.4375F, 0.9375F, 1.0F);
                func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            } else
            if(j == 0)
            {
                p_78580_1_.func_71905_a(0.0F, 0.375F, 0.8125F, 0.125F, 0.9375F, 0.9375F);
                func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                p_78580_1_.func_71905_a(0.875F, 0.375F, 0.8125F, 1.0F, 0.9375F, 0.9375F);
                func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                p_78580_1_.func_71905_a(0.0F, 0.375F, 0.5625F, 0.125F, 0.5625F, 0.8125F);
                func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                p_78580_1_.func_71905_a(0.875F, 0.375F, 0.5625F, 1.0F, 0.5625F, 0.8125F);
                func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                p_78580_1_.func_71905_a(0.0F, 0.75F, 0.5625F, 0.125F, 0.9375F, 0.8125F);
                func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                p_78580_1_.func_71905_a(0.875F, 0.75F, 0.5625F, 1.0F, 0.9375F, 0.8125F);
                func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            } else
            if(j == 2)
            {
                p_78580_1_.func_71905_a(0.0F, 0.375F, 0.0625F, 0.125F, 0.9375F, 0.1875F);
                func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                p_78580_1_.func_71905_a(0.875F, 0.375F, 0.0625F, 1.0F, 0.9375F, 0.1875F);
                func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                p_78580_1_.func_71905_a(0.0F, 0.375F, 0.1875F, 0.125F, 0.5625F, 0.4375F);
                func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                p_78580_1_.func_71905_a(0.875F, 0.375F, 0.1875F, 1.0F, 0.5625F, 0.4375F);
                func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                p_78580_1_.func_71905_a(0.0F, 0.75F, 0.1875F, 0.125F, 0.9375F, 0.4375F);
                func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                p_78580_1_.func_71905_a(0.875F, 0.75F, 0.1875F, 1.0F, 0.9375F, 0.4375F);
                func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            }
        } else
        if(j == 3 || j == 1)
        {
            float f2 = 0.4375F;
            float f6 = 0.5625F;
            float f10 = 0.375F;
            float f14 = 0.5F;
            p_78580_1_.func_71905_a(f2, 0.375F, f10, f6, 0.9375F, f14);
            func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            f10 = 0.5F;
            f14 = 0.625F;
            p_78580_1_.func_71905_a(f2, 0.375F, f10, f6, 0.9375F, f14);
            func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            f10 = 0.625F;
            f14 = 0.875F;
            p_78580_1_.func_71905_a(f2, 0.375F, f10, f6, 0.5625F, f14);
            func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            p_78580_1_.func_71905_a(f2, 0.75F, f10, f6, 0.9375F, f14);
            func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            f10 = 0.125F;
            f14 = 0.375F;
            p_78580_1_.func_71905_a(f2, 0.375F, f10, f6, 0.5625F, f14);
            func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            p_78580_1_.func_71905_a(f2, 0.75F, f10, f6, 0.9375F, f14);
            func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
        } else
        {
            float f3 = 0.375F;
            float f7 = 0.5F;
            float f11 = 0.4375F;
            float f15 = 0.5625F;
            p_78580_1_.func_71905_a(f3, 0.375F, f11, f7, 0.9375F, f15);
            func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            f3 = 0.5F;
            f7 = 0.625F;
            p_78580_1_.func_71905_a(f3, 0.375F, f11, f7, 0.9375F, f15);
            func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            f3 = 0.625F;
            f7 = 0.875F;
            p_78580_1_.func_71905_a(f3, 0.375F, f11, f7, 0.5625F, f15);
            func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            p_78580_1_.func_71905_a(f3, 0.75F, f11, f7, 0.9375F, f15);
            func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            f3 = 0.125F;
            f7 = 0.375F;
            p_78580_1_.func_71905_a(f3, 0.375F, f11, f7, 0.5625F, f15);
            func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            p_78580_1_.func_71905_a(f3, 0.75F, f11, f7, 0.9375F, f15);
            func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
        }
        p_78580_1_.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        return flag;
    }

    public boolean func_78565_t(Block p_78565_1_, int p_78565_2_, int p_78565_3_, int p_78565_4_)
    {
        int i = field_78669_a.func_72805_g(p_78565_2_, p_78565_3_, p_78565_4_);
        int j = i & 3;
        float f = 0.0F;
        float f1 = 0.5F;
        float f2 = 0.5F;
        float f3 = 1.0F;
        if((i & 4) != 0)
        {
            f = 0.5F;
            f1 = 1.0F;
            f2 = 0.0F;
            f3 = 0.5F;
        }
        p_78565_1_.func_71905_a(0.0F, f, 0.0F, 1.0F, f1, 1.0F);
        func_78570_q(p_78565_1_, p_78565_2_, p_78565_3_, p_78565_4_);
        if(j == 0)
        {
            p_78565_1_.func_71905_a(0.5F, f2, 0.0F, 1.0F, f3, 1.0F);
            func_78570_q(p_78565_1_, p_78565_2_, p_78565_3_, p_78565_4_);
        } else
        if(j == 1)
        {
            p_78565_1_.func_71905_a(0.0F, f2, 0.0F, 0.5F, f3, 1.0F);
            func_78570_q(p_78565_1_, p_78565_2_, p_78565_3_, p_78565_4_);
        } else
        if(j == 2)
        {
            p_78565_1_.func_71905_a(0.0F, f2, 0.5F, 1.0F, f3, 1.0F);
            func_78570_q(p_78565_1_, p_78565_2_, p_78565_3_, p_78565_4_);
        } else
        if(j == 3)
        {
            p_78565_1_.func_71905_a(0.0F, f2, 0.0F, 1.0F, f3, 0.5F);
            func_78570_q(p_78565_1_, p_78565_2_, p_78565_3_, p_78565_4_);
        }
        p_78565_1_.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        return true;
    }

    public boolean func_78601_u(Block p_78601_1_, int p_78601_2_, int p_78601_3_, int p_78601_4_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        BlockDoor blockdoor = (BlockDoor)p_78601_1_;
        boolean flag = false;
        float f = 0.5F;
        float f1 = 1.0F;
        float f2 = 0.8F;
        float f3 = 0.6F;
        int i = p_78601_1_.func_71874_e(field_78669_a, p_78601_2_, p_78601_3_, p_78601_4_);
        tessellator.func_78380_c(p_78601_1_.field_72023_ci > 0.0D ? i : p_78601_1_.func_71874_e(field_78669_a, p_78601_2_, p_78601_3_ - 1, p_78601_4_));
        tessellator.func_78386_a(f, f, f);
        func_78613_a(p_78601_1_, p_78601_2_, p_78601_3_, p_78601_4_, p_78601_1_.func_71895_b(field_78669_a, p_78601_2_, p_78601_3_, p_78601_4_, 0));
        flag = true;
        tessellator.func_78380_c(p_78601_1_.field_72022_cl < 1.0D ? i : p_78601_1_.func_71874_e(field_78669_a, p_78601_2_, p_78601_3_ + 1, p_78601_4_));
        tessellator.func_78386_a(f1, f1, f1);
        func_78617_b(p_78601_1_, p_78601_2_, p_78601_3_, p_78601_4_, p_78601_1_.func_71895_b(field_78669_a, p_78601_2_, p_78601_3_, p_78601_4_, 1));
        flag = true;
        tessellator.func_78380_c(p_78601_1_.field_72024_cj > 0.0D ? i : p_78601_1_.func_71874_e(field_78669_a, p_78601_2_, p_78601_3_, p_78601_4_ - 1));
        tessellator.func_78386_a(f2, f2, f2);
        int j = p_78601_1_.func_71895_b(field_78669_a, p_78601_2_, p_78601_3_, p_78601_4_, 2);
        if(j < 0)
        {
            field_78666_e = true;
            j = -j;
        }
        func_78611_c(p_78601_1_, p_78601_2_, p_78601_3_, p_78601_4_, j);
        flag = true;
        field_78666_e = false;
        tessellator.func_78380_c(p_78601_1_.field_72019_cm < 1.0D ? i : p_78601_1_.func_71874_e(field_78669_a, p_78601_2_, p_78601_3_, p_78601_4_ + 1));
        tessellator.func_78386_a(f2, f2, f2);
        j = p_78601_1_.func_71895_b(field_78669_a, p_78601_2_, p_78601_3_, p_78601_4_, 3);
        if(j < 0)
        {
            field_78666_e = true;
            j = -j;
        }
        func_78622_d(p_78601_1_, p_78601_2_, p_78601_3_, p_78601_4_, j);
        flag = true;
        field_78666_e = false;
        tessellator.func_78380_c(p_78601_1_.field_72026_ch > 0.0D ? i : p_78601_1_.func_71874_e(field_78669_a, p_78601_2_ - 1, p_78601_3_, p_78601_4_));
        tessellator.func_78386_a(f3, f3, f3);
        j = p_78601_1_.func_71895_b(field_78669_a, p_78601_2_, p_78601_3_, p_78601_4_, 4);
        if(j < 0)
        {
            field_78666_e = true;
            j = -j;
        }
        func_78573_e(p_78601_1_, p_78601_2_, p_78601_3_, p_78601_4_, j);
        flag = true;
        field_78666_e = false;
        tessellator.func_78380_c(p_78601_1_.field_72021_ck < 1.0D ? i : p_78601_1_.func_71874_e(field_78669_a, p_78601_2_ + 1, p_78601_3_, p_78601_4_));
        tessellator.func_78386_a(f3, f3, f3);
        j = p_78601_1_.func_71895_b(field_78669_a, p_78601_2_, p_78601_3_, p_78601_4_, 5);
        if(j < 0)
        {
            field_78666_e = true;
            j = -j;
        }
        func_78605_f(p_78601_1_, p_78601_2_, p_78601_3_, p_78601_4_, j);
        flag = true;
        field_78666_e = false;
        return flag;
    }

    public void func_78613_a(Block p_78613_1_, double p_78613_2_, double p_78613_4_, double p_78613_6_, 
            int p_78613_8_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        if(field_78664_d >= 0)
        {
            p_78613_8_ = field_78664_d;
        }
        int i = (p_78613_8_ & 0xf) << 4;
        int j = p_78613_8_ & 0xf0;
        double d = ((double)i + p_78613_1_.field_72026_ch * 16D) / 256D;
        double d1 = (((double)i + p_78613_1_.field_72021_ck * 16D) - 0.01D) / 256D;
        double d2 = ((double)j + p_78613_1_.field_72024_cj * 16D) / 256D;
        double d3 = (((double)j + p_78613_1_.field_72019_cm * 16D) - 0.01D) / 256D;
        if(p_78613_1_.field_72026_ch < 0.0D || p_78613_1_.field_72021_ck > 1.0D)
        {
            d = ((float)i + 0.0F) / 256F;
            d1 = ((float)i + 15.99F) / 256F;
        }
        if(p_78613_1_.field_72024_cj < 0.0D || p_78613_1_.field_72019_cm > 1.0D)
        {
            d2 = ((float)j + 0.0F) / 256F;
            d3 = ((float)j + 15.99F) / 256F;
        }
        double d4 = d1;
        double d5 = d;
        double d6 = d2;
        double d7 = d3;
        if(field_78675_l == 2)
        {
            d = ((double)i + p_78613_1_.field_72024_cj * 16D) / 256D;
            d2 = ((double)(j + 16) - p_78613_1_.field_72021_ck * 16D) / 256D;
            d1 = ((double)i + p_78613_1_.field_72019_cm * 16D) / 256D;
            d3 = ((double)(j + 16) - p_78613_1_.field_72026_ch * 16D) / 256D;
            d4 = d1;
            d5 = d;
            d6 = d2;
            d7 = d3;
            d4 = d;
            d5 = d1;
            d2 = d3;
            d3 = d6;
        } else
        if(field_78675_l == 1)
        {
            d = ((double)(i + 16) - p_78613_1_.field_72019_cm * 16D) / 256D;
            d2 = ((double)j + p_78613_1_.field_72026_ch * 16D) / 256D;
            d1 = ((double)(i + 16) - p_78613_1_.field_72024_cj * 16D) / 256D;
            d3 = ((double)j + p_78613_1_.field_72021_ck * 16D) / 256D;
            d4 = d1;
            d5 = d;
            d6 = d2;
            d7 = d3;
            d = d4;
            d1 = d5;
            d6 = d3;
            d7 = d2;
        } else
        if(field_78675_l == 3)
        {
            d = ((double)(i + 16) - p_78613_1_.field_72026_ch * 16D) / 256D;
            d1 = ((double)(i + 16) - p_78613_1_.field_72021_ck * 16D - 0.01D) / 256D;
            d2 = ((double)(j + 16) - p_78613_1_.field_72024_cj * 16D) / 256D;
            d3 = ((double)(j + 16) - p_78613_1_.field_72019_cm * 16D - 0.01D) / 256D;
            d4 = d1;
            d5 = d;
            d6 = d2;
            d7 = d3;
        }
        double d8 = p_78613_2_ + p_78613_1_.field_72026_ch;
        double d9 = p_78613_2_ + p_78613_1_.field_72021_ck;
        double d10 = p_78613_4_ + p_78613_1_.field_72023_ci;
        double d11 = p_78613_6_ + p_78613_1_.field_72024_cj;
        double d12 = p_78613_6_ + p_78613_1_.field_72019_cm;
        if(field_78677_m)
        {
            tessellator.func_78386_a(field_78674_ar, field_78682_av, field_78663_az);
            tessellator.func_78380_c(field_78700_an);
            tessellator.func_78374_a(d8, d10, d12, d5, d7);
            tessellator.func_78386_a(field_78672_as, field_78680_aw, field_78650_aA);
            tessellator.func_78380_c(field_78694_ao);
            tessellator.func_78374_a(d8, d10, d11, d, d2);
            tessellator.func_78386_a(field_78670_at, field_78678_ax, field_78651_aB);
            tessellator.func_78380_c(field_78696_ap);
            tessellator.func_78374_a(d9, d10, d11, d4, d6);
            tessellator.func_78386_a(field_78684_au, field_78665_ay, field_78652_aC);
            tessellator.func_78380_c(field_78676_aq);
            tessellator.func_78374_a(d9, d10, d12, d1, d3);
        } else
        {
            tessellator.func_78374_a(d8, d10, d12, d5, d7);
            tessellator.func_78374_a(d8, d10, d11, d, d2);
            tessellator.func_78374_a(d9, d10, d11, d4, d6);
            tessellator.func_78374_a(d9, d10, d12, d1, d3);
        }
    }

    public void func_78617_b(Block p_78617_1_, double p_78617_2_, double p_78617_4_, double p_78617_6_, 
            int p_78617_8_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        if(field_78664_d >= 0)
        {
            p_78617_8_ = field_78664_d;
        }
        int i = (p_78617_8_ & 0xf) << 4;
        int j = p_78617_8_ & 0xf0;
        double d = ((double)i + p_78617_1_.field_72026_ch * 16D) / 256D;
        double d1 = (((double)i + p_78617_1_.field_72021_ck * 16D) - 0.01D) / 256D;
        double d2 = ((double)j + p_78617_1_.field_72024_cj * 16D) / 256D;
        double d3 = (((double)j + p_78617_1_.field_72019_cm * 16D) - 0.01D) / 256D;
        if(p_78617_1_.field_72026_ch < 0.0D || p_78617_1_.field_72021_ck > 1.0D)
        {
            d = ((float)i + 0.0F) / 256F;
            d1 = ((float)i + 15.99F) / 256F;
        }
        if(p_78617_1_.field_72024_cj < 0.0D || p_78617_1_.field_72019_cm > 1.0D)
        {
            d2 = ((float)j + 0.0F) / 256F;
            d3 = ((float)j + 15.99F) / 256F;
        }
        double d4 = d1;
        double d5 = d;
        double d6 = d2;
        double d7 = d3;
        if(field_78681_k == 1)
        {
            d = ((double)i + p_78617_1_.field_72024_cj * 16D) / 256D;
            d2 = ((double)(j + 16) - p_78617_1_.field_72021_ck * 16D) / 256D;
            d1 = ((double)i + p_78617_1_.field_72019_cm * 16D) / 256D;
            d3 = ((double)(j + 16) - p_78617_1_.field_72026_ch * 16D) / 256D;
            d4 = d1;
            d5 = d;
            d6 = d2;
            d7 = d3;
            d4 = d;
            d5 = d1;
            d2 = d3;
            d3 = d6;
        } else
        if(field_78681_k == 2)
        {
            d = ((double)(i + 16) - p_78617_1_.field_72019_cm * 16D) / 256D;
            d2 = ((double)j + p_78617_1_.field_72026_ch * 16D) / 256D;
            d1 = ((double)(i + 16) - p_78617_1_.field_72024_cj * 16D) / 256D;
            d3 = ((double)j + p_78617_1_.field_72021_ck * 16D) / 256D;
            d4 = d1;
            d5 = d;
            d6 = d2;
            d7 = d3;
            d = d4;
            d1 = d5;
            d6 = d3;
            d7 = d2;
        } else
        if(field_78681_k == 3)
        {
            d = ((double)(i + 16) - p_78617_1_.field_72026_ch * 16D) / 256D;
            d1 = ((double)(i + 16) - p_78617_1_.field_72021_ck * 16D - 0.01D) / 256D;
            d2 = ((double)(j + 16) - p_78617_1_.field_72024_cj * 16D) / 256D;
            d3 = ((double)(j + 16) - p_78617_1_.field_72019_cm * 16D - 0.01D) / 256D;
            d4 = d1;
            d5 = d;
            d6 = d2;
            d7 = d3;
        }
        double d8 = p_78617_2_ + p_78617_1_.field_72026_ch;
        double d9 = p_78617_2_ + p_78617_1_.field_72021_ck;
        double d10 = p_78617_4_ + p_78617_1_.field_72022_cl;
        double d11 = p_78617_6_ + p_78617_1_.field_72024_cj;
        double d12 = p_78617_6_ + p_78617_1_.field_72019_cm;
        if(field_78677_m)
        {
            tessellator.func_78386_a(field_78674_ar, field_78682_av, field_78663_az);
            tessellator.func_78380_c(field_78700_an);
            tessellator.func_78374_a(d9, d10, d12, d1, d3);
            tessellator.func_78386_a(field_78672_as, field_78680_aw, field_78650_aA);
            tessellator.func_78380_c(field_78694_ao);
            tessellator.func_78374_a(d9, d10, d11, d4, d6);
            tessellator.func_78386_a(field_78670_at, field_78678_ax, field_78651_aB);
            tessellator.func_78380_c(field_78696_ap);
            tessellator.func_78374_a(d8, d10, d11, d, d2);
            tessellator.func_78386_a(field_78684_au, field_78665_ay, field_78652_aC);
            tessellator.func_78380_c(field_78676_aq);
            tessellator.func_78374_a(d8, d10, d12, d5, d7);
        } else
        {
            tessellator.func_78374_a(d9, d10, d12, d1, d3);
            tessellator.func_78374_a(d9, d10, d11, d4, d6);
            tessellator.func_78374_a(d8, d10, d11, d, d2);
            tessellator.func_78374_a(d8, d10, d12, d5, d7);
        }
    }

    public void func_78611_c(Block p_78611_1_, double p_78611_2_, double p_78611_4_, double p_78611_6_, 
            int p_78611_8_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        if(field_78664_d >= 0)
        {
            p_78611_8_ = field_78664_d;
        }
        int i = (p_78611_8_ & 0xf) << 4;
        int j = p_78611_8_ & 0xf0;
        double d = ((double)i + p_78611_1_.field_72026_ch * 16D) / 256D;
        double d1 = (((double)i + p_78611_1_.field_72021_ck * 16D) - 0.01D) / 256D;
        double d2 = ((double)(j + 16) - p_78611_1_.field_72022_cl * 16D) / 256D;
        double d3 = ((double)(j + 16) - p_78611_1_.field_72023_ci * 16D - 0.01D) / 256D;
        if(field_78666_e)
        {
            double d4 = d;
            d = d1;
            d1 = d4;
        }
        if(p_78611_1_.field_72026_ch < 0.0D || p_78611_1_.field_72021_ck > 1.0D)
        {
            d = ((float)i + 0.0F) / 256F;
            d1 = ((float)i + 15.99F) / 256F;
        }
        if(p_78611_1_.field_72023_ci < 0.0D || p_78611_1_.field_72022_cl > 1.0D)
        {
            d2 = ((float)j + 0.0F) / 256F;
            d3 = ((float)j + 15.99F) / 256F;
        }
        double d5 = d1;
        double d6 = d;
        double d7 = d2;
        double d8 = d3;
        if(field_78662_g == 2)
        {
            d = ((double)i + p_78611_1_.field_72023_ci * 16D) / 256D;
            d2 = ((double)(j + 16) - p_78611_1_.field_72026_ch * 16D) / 256D;
            d1 = ((double)i + p_78611_1_.field_72022_cl * 16D) / 256D;
            d3 = ((double)(j + 16) - p_78611_1_.field_72021_ck * 16D) / 256D;
            d5 = d1;
            d6 = d;
            d7 = d2;
            d8 = d3;
            d5 = d;
            d6 = d1;
            d2 = d3;
            d3 = d7;
        } else
        if(field_78662_g == 1)
        {
            d = ((double)(i + 16) - p_78611_1_.field_72022_cl * 16D) / 256D;
            d2 = ((double)j + p_78611_1_.field_72021_ck * 16D) / 256D;
            d1 = ((double)(i + 16) - p_78611_1_.field_72023_ci * 16D) / 256D;
            d3 = ((double)j + p_78611_1_.field_72026_ch * 16D) / 256D;
            d5 = d1;
            d6 = d;
            d7 = d2;
            d8 = d3;
            d = d5;
            d1 = d6;
            d7 = d3;
            d8 = d2;
        } else
        if(field_78662_g == 3)
        {
            d = ((double)(i + 16) - p_78611_1_.field_72026_ch * 16D) / 256D;
            d1 = ((double)(i + 16) - p_78611_1_.field_72021_ck * 16D - 0.01D) / 256D;
            d2 = ((double)j + p_78611_1_.field_72022_cl * 16D) / 256D;
            d3 = (((double)j + p_78611_1_.field_72023_ci * 16D) - 0.01D) / 256D;
            d5 = d1;
            d6 = d;
            d7 = d2;
            d8 = d3;
        }
        double d9 = p_78611_2_ + p_78611_1_.field_72026_ch;
        double d10 = p_78611_2_ + p_78611_1_.field_72021_ck;
        double d11 = p_78611_4_ + p_78611_1_.field_72023_ci;
        double d12 = p_78611_4_ + p_78611_1_.field_72022_cl;
        double d13 = p_78611_6_ + p_78611_1_.field_72024_cj;
        if(field_78677_m)
        {
            tessellator.func_78386_a(field_78674_ar, field_78682_av, field_78663_az);
            tessellator.func_78380_c(field_78700_an);
            tessellator.func_78374_a(d9, d12, d13, d5, d7);
            tessellator.func_78386_a(field_78672_as, field_78680_aw, field_78650_aA);
            tessellator.func_78380_c(field_78694_ao);
            tessellator.func_78374_a(d10, d12, d13, d, d2);
            tessellator.func_78386_a(field_78670_at, field_78678_ax, field_78651_aB);
            tessellator.func_78380_c(field_78696_ap);
            tessellator.func_78374_a(d10, d11, d13, d6, d8);
            tessellator.func_78386_a(field_78684_au, field_78665_ay, field_78652_aC);
            tessellator.func_78380_c(field_78676_aq);
            tessellator.func_78374_a(d9, d11, d13, d1, d3);
        } else
        {
            tessellator.func_78374_a(d9, d12, d13, d5, d7);
            tessellator.func_78374_a(d10, d12, d13, d, d2);
            tessellator.func_78374_a(d10, d11, d13, d6, d8);
            tessellator.func_78374_a(d9, d11, d13, d1, d3);
        }
    }

    public void func_78622_d(Block p_78622_1_, double p_78622_2_, double p_78622_4_, double p_78622_6_, 
            int p_78622_8_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        if(field_78664_d >= 0)
        {
            p_78622_8_ = field_78664_d;
        }
        int i = (p_78622_8_ & 0xf) << 4;
        int j = p_78622_8_ & 0xf0;
        double d = ((double)i + p_78622_1_.field_72026_ch * 16D) / 256D;
        double d1 = (((double)i + p_78622_1_.field_72021_ck * 16D) - 0.01D) / 256D;
        double d2 = ((double)(j + 16) - p_78622_1_.field_72022_cl * 16D) / 256D;
        double d3 = ((double)(j + 16) - p_78622_1_.field_72023_ci * 16D - 0.01D) / 256D;
        if(field_78666_e)
        {
            double d4 = d;
            d = d1;
            d1 = d4;
        }
        if(p_78622_1_.field_72026_ch < 0.0D || p_78622_1_.field_72021_ck > 1.0D)
        {
            d = ((float)i + 0.0F) / 256F;
            d1 = ((float)i + 15.99F) / 256F;
        }
        if(p_78622_1_.field_72023_ci < 0.0D || p_78622_1_.field_72022_cl > 1.0D)
        {
            d2 = ((float)j + 0.0F) / 256F;
            d3 = ((float)j + 15.99F) / 256F;
        }
        double d5 = d1;
        double d6 = d;
        double d7 = d2;
        double d8 = d3;
        if(field_78683_h == 1)
        {
            d = ((double)i + p_78622_1_.field_72023_ci * 16D) / 256D;
            d3 = ((double)(j + 16) - p_78622_1_.field_72026_ch * 16D) / 256D;
            d1 = ((double)i + p_78622_1_.field_72022_cl * 16D) / 256D;
            d2 = ((double)(j + 16) - p_78622_1_.field_72021_ck * 16D) / 256D;
            d5 = d1;
            d6 = d;
            d7 = d2;
            d8 = d3;
            d5 = d;
            d6 = d1;
            d2 = d3;
            d3 = d7;
        } else
        if(field_78683_h == 2)
        {
            d = ((double)(i + 16) - p_78622_1_.field_72022_cl * 16D) / 256D;
            d2 = ((double)j + p_78622_1_.field_72026_ch * 16D) / 256D;
            d1 = ((double)(i + 16) - p_78622_1_.field_72023_ci * 16D) / 256D;
            d3 = ((double)j + p_78622_1_.field_72021_ck * 16D) / 256D;
            d5 = d1;
            d6 = d;
            d7 = d2;
            d8 = d3;
            d = d5;
            d1 = d6;
            d7 = d3;
            d8 = d2;
        } else
        if(field_78683_h == 3)
        {
            d = ((double)(i + 16) - p_78622_1_.field_72026_ch * 16D) / 256D;
            d1 = ((double)(i + 16) - p_78622_1_.field_72021_ck * 16D - 0.01D) / 256D;
            d2 = ((double)j + p_78622_1_.field_72022_cl * 16D) / 256D;
            d3 = (((double)j + p_78622_1_.field_72023_ci * 16D) - 0.01D) / 256D;
            d5 = d1;
            d6 = d;
            d7 = d2;
            d8 = d3;
        }
        double d9 = p_78622_2_ + p_78622_1_.field_72026_ch;
        double d10 = p_78622_2_ + p_78622_1_.field_72021_ck;
        double d11 = p_78622_4_ + p_78622_1_.field_72023_ci;
        double d12 = p_78622_4_ + p_78622_1_.field_72022_cl;
        double d13 = p_78622_6_ + p_78622_1_.field_72019_cm;
        if(field_78677_m)
        {
            tessellator.func_78386_a(field_78674_ar, field_78682_av, field_78663_az);
            tessellator.func_78380_c(field_78700_an);
            tessellator.func_78374_a(d9, d12, d13, d, d2);
            tessellator.func_78386_a(field_78672_as, field_78680_aw, field_78650_aA);
            tessellator.func_78380_c(field_78694_ao);
            tessellator.func_78374_a(d9, d11, d13, d6, d8);
            tessellator.func_78386_a(field_78670_at, field_78678_ax, field_78651_aB);
            tessellator.func_78380_c(field_78696_ap);
            tessellator.func_78374_a(d10, d11, d13, d1, d3);
            tessellator.func_78386_a(field_78684_au, field_78665_ay, field_78652_aC);
            tessellator.func_78380_c(field_78676_aq);
            tessellator.func_78374_a(d10, d12, d13, d5, d7);
        } else
        {
            tessellator.func_78374_a(d9, d12, d13, d, d2);
            tessellator.func_78374_a(d9, d11, d13, d6, d8);
            tessellator.func_78374_a(d10, d11, d13, d1, d3);
            tessellator.func_78374_a(d10, d12, d13, d5, d7);
        }
    }

    public void func_78573_e(Block p_78573_1_, double p_78573_2_, double p_78573_4_, double p_78573_6_, 
            int p_78573_8_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        if(field_78664_d >= 0)
        {
            p_78573_8_ = field_78664_d;
        }
        int i = (p_78573_8_ & 0xf) << 4;
        int j = p_78573_8_ & 0xf0;
        double d = ((double)i + p_78573_1_.field_72024_cj * 16D) / 256D;
        double d1 = (((double)i + p_78573_1_.field_72019_cm * 16D) - 0.01D) / 256D;
        double d2 = ((double)(j + 16) - p_78573_1_.field_72022_cl * 16D) / 256D;
        double d3 = ((double)(j + 16) - p_78573_1_.field_72023_ci * 16D - 0.01D) / 256D;
        if(field_78666_e)
        {
            double d4 = d;
            d = d1;
            d1 = d4;
        }
        if(p_78573_1_.field_72024_cj < 0.0D || p_78573_1_.field_72019_cm > 1.0D)
        {
            d = ((float)i + 0.0F) / 256F;
            d1 = ((float)i + 15.99F) / 256F;
        }
        if(p_78573_1_.field_72023_ci < 0.0D || p_78573_1_.field_72022_cl > 1.0D)
        {
            d2 = ((float)j + 0.0F) / 256F;
            d3 = ((float)j + 15.99F) / 256F;
        }
        double d5 = d1;
        double d6 = d;
        double d7 = d2;
        double d8 = d3;
        if(field_78679_j == 1)
        {
            d = ((double)i + p_78573_1_.field_72023_ci * 16D) / 256D;
            d2 = ((double)(j + 16) - p_78573_1_.field_72019_cm * 16D) / 256D;
            d1 = ((double)i + p_78573_1_.field_72022_cl * 16D) / 256D;
            d3 = ((double)(j + 16) - p_78573_1_.field_72024_cj * 16D) / 256D;
            d5 = d1;
            d6 = d;
            d7 = d2;
            d8 = d3;
            d5 = d;
            d6 = d1;
            d2 = d3;
            d3 = d7;
        } else
        if(field_78679_j == 2)
        {
            d = ((double)(i + 16) - p_78573_1_.field_72022_cl * 16D) / 256D;
            d2 = ((double)j + p_78573_1_.field_72024_cj * 16D) / 256D;
            d1 = ((double)(i + 16) - p_78573_1_.field_72023_ci * 16D) / 256D;
            d3 = ((double)j + p_78573_1_.field_72019_cm * 16D) / 256D;
            d5 = d1;
            d6 = d;
            d7 = d2;
            d8 = d3;
            d = d5;
            d1 = d6;
            d7 = d3;
            d8 = d2;
        } else
        if(field_78679_j == 3)
        {
            d = ((double)(i + 16) - p_78573_1_.field_72024_cj * 16D) / 256D;
            d1 = ((double)(i + 16) - p_78573_1_.field_72019_cm * 16D - 0.01D) / 256D;
            d2 = ((double)j + p_78573_1_.field_72022_cl * 16D) / 256D;
            d3 = (((double)j + p_78573_1_.field_72023_ci * 16D) - 0.01D) / 256D;
            d5 = d1;
            d6 = d;
            d7 = d2;
            d8 = d3;
        }
        double d9 = p_78573_2_ + p_78573_1_.field_72026_ch;
        double d10 = p_78573_4_ + p_78573_1_.field_72023_ci;
        double d11 = p_78573_4_ + p_78573_1_.field_72022_cl;
        double d12 = p_78573_6_ + p_78573_1_.field_72024_cj;
        double d13 = p_78573_6_ + p_78573_1_.field_72019_cm;
        if(field_78677_m)
        {
            tessellator.func_78386_a(field_78674_ar, field_78682_av, field_78663_az);
            tessellator.func_78380_c(field_78700_an);
            tessellator.func_78374_a(d9, d11, d13, d5, d7);
            tessellator.func_78386_a(field_78672_as, field_78680_aw, field_78650_aA);
            tessellator.func_78380_c(field_78694_ao);
            tessellator.func_78374_a(d9, d11, d12, d, d2);
            tessellator.func_78386_a(field_78670_at, field_78678_ax, field_78651_aB);
            tessellator.func_78380_c(field_78696_ap);
            tessellator.func_78374_a(d9, d10, d12, d6, d8);
            tessellator.func_78386_a(field_78684_au, field_78665_ay, field_78652_aC);
            tessellator.func_78380_c(field_78676_aq);
            tessellator.func_78374_a(d9, d10, d13, d1, d3);
        } else
        {
            tessellator.func_78374_a(d9, d11, d13, d5, d7);
            tessellator.func_78374_a(d9, d11, d12, d, d2);
            tessellator.func_78374_a(d9, d10, d12, d6, d8);
            tessellator.func_78374_a(d9, d10, d13, d1, d3);
        }
    }

    public void func_78605_f(Block p_78605_1_, double p_78605_2_, double p_78605_4_, double p_78605_6_, 
            int p_78605_8_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        if(field_78664_d >= 0)
        {
            p_78605_8_ = field_78664_d;
        }
        int i = (p_78605_8_ & 0xf) << 4;
        int j = p_78605_8_ & 0xf0;
        double d = ((double)i + p_78605_1_.field_72024_cj * 16D) / 256D;
        double d1 = (((double)i + p_78605_1_.field_72019_cm * 16D) - 0.01D) / 256D;
        double d2 = ((double)(j + 16) - p_78605_1_.field_72022_cl * 16D) / 256D;
        double d3 = ((double)(j + 16) - p_78605_1_.field_72023_ci * 16D - 0.01D) / 256D;
        if(field_78666_e)
        {
            double d4 = d;
            d = d1;
            d1 = d4;
        }
        if(p_78605_1_.field_72024_cj < 0.0D || p_78605_1_.field_72019_cm > 1.0D)
        {
            d = ((float)i + 0.0F) / 256F;
            d1 = ((float)i + 15.99F) / 256F;
        }
        if(p_78605_1_.field_72023_ci < 0.0D || p_78605_1_.field_72022_cl > 1.0D)
        {
            d2 = ((float)j + 0.0F) / 256F;
            d3 = ((float)j + 15.99F) / 256F;
        }
        double d5 = d1;
        double d6 = d;
        double d7 = d2;
        double d8 = d3;
        if(field_78685_i == 2)
        {
            d = ((double)i + p_78605_1_.field_72023_ci * 16D) / 256D;
            d2 = ((double)(j + 16) - p_78605_1_.field_72024_cj * 16D) / 256D;
            d1 = ((double)i + p_78605_1_.field_72022_cl * 16D) / 256D;
            d3 = ((double)(j + 16) - p_78605_1_.field_72019_cm * 16D) / 256D;
            d5 = d1;
            d6 = d;
            d7 = d2;
            d8 = d3;
            d5 = d;
            d6 = d1;
            d2 = d3;
            d3 = d7;
        } else
        if(field_78685_i == 1)
        {
            d = ((double)(i + 16) - p_78605_1_.field_72022_cl * 16D) / 256D;
            d2 = ((double)j + p_78605_1_.field_72019_cm * 16D) / 256D;
            d1 = ((double)(i + 16) - p_78605_1_.field_72023_ci * 16D) / 256D;
            d3 = ((double)j + p_78605_1_.field_72024_cj * 16D) / 256D;
            d5 = d1;
            d6 = d;
            d7 = d2;
            d8 = d3;
            d = d5;
            d1 = d6;
            d7 = d3;
            d8 = d2;
        } else
        if(field_78685_i == 3)
        {
            d = ((double)(i + 16) - p_78605_1_.field_72024_cj * 16D) / 256D;
            d1 = ((double)(i + 16) - p_78605_1_.field_72019_cm * 16D - 0.01D) / 256D;
            d2 = ((double)j + p_78605_1_.field_72022_cl * 16D) / 256D;
            d3 = (((double)j + p_78605_1_.field_72023_ci * 16D) - 0.01D) / 256D;
            d5 = d1;
            d6 = d;
            d7 = d2;
            d8 = d3;
        }
        double d9 = p_78605_2_ + p_78605_1_.field_72021_ck;
        double d10 = p_78605_4_ + p_78605_1_.field_72023_ci;
        double d11 = p_78605_4_ + p_78605_1_.field_72022_cl;
        double d12 = p_78605_6_ + p_78605_1_.field_72024_cj;
        double d13 = p_78605_6_ + p_78605_1_.field_72019_cm;
        if(field_78677_m)
        {
            tessellator.func_78386_a(field_78674_ar, field_78682_av, field_78663_az);
            tessellator.func_78380_c(field_78700_an);
            tessellator.func_78374_a(d9, d10, d13, d6, d8);
            tessellator.func_78386_a(field_78672_as, field_78680_aw, field_78650_aA);
            tessellator.func_78380_c(field_78694_ao);
            tessellator.func_78374_a(d9, d10, d12, d1, d3);
            tessellator.func_78386_a(field_78670_at, field_78678_ax, field_78651_aB);
            tessellator.func_78380_c(field_78696_ap);
            tessellator.func_78374_a(d9, d11, d12, d5, d7);
            tessellator.func_78386_a(field_78684_au, field_78665_ay, field_78652_aC);
            tessellator.func_78380_c(field_78676_aq);
            tessellator.func_78374_a(d9, d11, d13, d, d2);
        } else
        {
            tessellator.func_78374_a(d9, d10, d13, d6, d8);
            tessellator.func_78374_a(d9, d10, d12, d1, d3);
            tessellator.func_78374_a(d9, d11, d12, d5, d7);
            tessellator.func_78374_a(d9, d11, d13, d, d2);
        }
    }

    public void func_78600_a(Block p_78600_1_, int p_78600_2_, float p_78600_3_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        boolean flag = p_78600_1_.field_71990_ca == Block.field_71980_u.field_71990_ca;
        if(field_78668_c)
        {
            int i = p_78600_1_.func_71889_f_(p_78600_2_);
            if(flag)
            {
                i = 0xffffff;
            }
            float f = (float)(i >> 16 & 0xff) / 255F;
            float f2 = (float)(i >> 8 & 0xff) / 255F;
            float f6 = (float)(i & 0xff) / 255F;
            GL11.glColor4f(f * p_78600_3_, f2 * p_78600_3_, f6 * p_78600_3_, 1.0F);
        }
        int j = p_78600_1_.func_71857_b();
        if(j == 0 || j == 31 || j == 16 || j == 26)
        {
            if(j == 16)
            {
                p_78600_2_ = 1;
            }
            p_78600_1_.func_71919_f();
            GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            tessellator.func_78382_b();
            tessellator.func_78375_b(0.0F, -1F, 0.0F);
            func_78613_a(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71858_a(0, p_78600_2_));
            tessellator.func_78381_a();
            if(flag && field_78668_c)
            {
                int k = p_78600_1_.func_71889_f_(p_78600_2_);
                float f3 = (float)(k >> 16 & 0xff) / 255F;
                float f7 = (float)(k >> 8 & 0xff) / 255F;
                float f8 = (float)(k & 0xff) / 255F;
                GL11.glColor4f(f3 * p_78600_3_, f7 * p_78600_3_, f8 * p_78600_3_, 1.0F);
            }
            tessellator.func_78382_b();
            tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
            func_78617_b(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71858_a(1, p_78600_2_));
            tessellator.func_78381_a();
            if(flag && field_78668_c)
            {
                GL11.glColor4f(p_78600_3_, p_78600_3_, p_78600_3_, 1.0F);
            }
            tessellator.func_78382_b();
            tessellator.func_78375_b(0.0F, 0.0F, -1F);
            func_78611_c(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71858_a(2, p_78600_2_));
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
            func_78622_d(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71858_a(3, p_78600_2_));
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78375_b(-1F, 0.0F, 0.0F);
            func_78573_e(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71858_a(4, p_78600_2_));
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
            func_78605_f(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71858_a(5, p_78600_2_));
            tessellator.func_78381_a();
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
        } else
        if(j == 1)
        {
            tessellator.func_78382_b();
            tessellator.func_78375_b(0.0F, -1F, 0.0F);
            func_78599_a(p_78600_1_, p_78600_2_, -0.5D, -0.5D, -0.5D);
            tessellator.func_78381_a();
        } else
        if(j == 19)
        {
            tessellator.func_78382_b();
            tessellator.func_78375_b(0.0F, -1F, 0.0F);
            p_78600_1_.func_71919_f();
            func_78575_a(p_78600_1_, p_78600_2_, p_78600_1_.field_72022_cl, -0.5D, -0.5D, -0.5D);
            tessellator.func_78381_a();
        } else
        if(j == 23)
        {
            tessellator.func_78382_b();
            tessellator.func_78375_b(0.0F, -1F, 0.0F);
            p_78600_1_.func_71919_f();
            tessellator.func_78381_a();
        } else
        if(j == 13)
        {
            p_78600_1_.func_71919_f();
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            float f1 = 0.0625F;
            tessellator.func_78382_b();
            tessellator.func_78375_b(0.0F, -1F, 0.0F);
            func_78613_a(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(0));
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
            func_78617_b(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(1));
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78375_b(0.0F, 0.0F, -1F);
            tessellator.func_78372_c(0.0F, 0.0F, f1);
            func_78611_c(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(2));
            tessellator.func_78372_c(0.0F, 0.0F, -f1);
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
            tessellator.func_78372_c(0.0F, 0.0F, -f1);
            func_78622_d(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(3));
            tessellator.func_78372_c(0.0F, 0.0F, f1);
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78375_b(-1F, 0.0F, 0.0F);
            tessellator.func_78372_c(f1, 0.0F, 0.0F);
            func_78573_e(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(4));
            tessellator.func_78372_c(-f1, 0.0F, 0.0F);
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
            tessellator.func_78372_c(-f1, 0.0F, 0.0F);
            func_78605_f(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(5));
            tessellator.func_78372_c(f1, 0.0F, 0.0F);
            tessellator.func_78381_a();
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
        } else
        if(j == 22)
        {
            GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            ChestItemRenderHelper.field_78545_a.func_78542_a(p_78600_1_, p_78600_2_, p_78600_3_);
            GL11.glEnable(32826);
        } else
        if(j == 6)
        {
            tessellator.func_78382_b();
            tessellator.func_78375_b(0.0F, -1F, 0.0F);
            func_78579_b(p_78600_1_, p_78600_2_, -0.5D, -0.5D, -0.5D);
            tessellator.func_78381_a();
        } else
        if(j == 2)
        {
            tessellator.func_78382_b();
            tessellator.func_78375_b(0.0F, -1F, 0.0F);
            func_78623_a(p_78600_1_, -0.5D, -0.5D, -0.5D, 0.0D, 0.0D);
            tessellator.func_78381_a();
        } else
        if(j == 10)
        {
            for(int l = 0; l < 2; l++)
            {
                if(l == 0)
                {
                    p_78600_1_.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
                }
                if(l == 1)
                {
                    p_78600_1_.func_71905_a(0.0F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F);
                }
                GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
                tessellator.func_78382_b();
                tessellator.func_78375_b(0.0F, -1F, 0.0F);
                func_78613_a(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(0));
                tessellator.func_78381_a();
                tessellator.func_78382_b();
                tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
                func_78617_b(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(1));
                tessellator.func_78381_a();
                tessellator.func_78382_b();
                tessellator.func_78375_b(0.0F, 0.0F, -1F);
                func_78611_c(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(2));
                tessellator.func_78381_a();
                tessellator.func_78382_b();
                tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
                func_78622_d(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(3));
                tessellator.func_78381_a();
                tessellator.func_78382_b();
                tessellator.func_78375_b(-1F, 0.0F, 0.0F);
                func_78573_e(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(4));
                tessellator.func_78381_a();
                tessellator.func_78382_b();
                tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
                func_78605_f(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(5));
                tessellator.func_78381_a();
                GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            }

        } else
        if(j == 27)
        {
            int i1 = 0;
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            tessellator.func_78382_b();
            for(int l1 = 0; l1 < 8; l1++)
            {
                int i2 = 0;
                byte byte0 = 1;
                if(l1 == 0)
                {
                    i2 = 2;
                }
                if(l1 == 1)
                {
                    i2 = 3;
                }
                if(l1 == 2)
                {
                    i2 = 4;
                }
                if(l1 == 3)
                {
                    i2 = 5;
                    byte0 = 2;
                }
                if(l1 == 4)
                {
                    i2 = 6;
                    byte0 = 3;
                }
                if(l1 == 5)
                {
                    i2 = 7;
                    byte0 = 5;
                }
                if(l1 == 6)
                {
                    i2 = 6;
                    byte0 = 2;
                }
                if(l1 == 7)
                {
                    i2 = 3;
                }
                float f9 = (float)i2 / 16F;
                float f10 = 1.0F - (float)i1 / 16F;
                float f11 = 1.0F - (float)(i1 + byte0) / 16F;
                i1 += byte0;
                p_78600_1_.func_71905_a(0.5F - f9, f11, 0.5F - f9, 0.5F + f9, f10, 0.5F + f9);
                tessellator.func_78375_b(0.0F, -1F, 0.0F);
                func_78613_a(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(0));
                tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
                func_78617_b(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(1));
                tessellator.func_78375_b(0.0F, 0.0F, -1F);
                func_78611_c(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(2));
                tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
                func_78622_d(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(3));
                tessellator.func_78375_b(-1F, 0.0F, 0.0F);
                func_78573_e(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(4));
                tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
                func_78605_f(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(5));
            }

            tessellator.func_78381_a();
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            p_78600_1_.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        } else
        if(j == 11)
        {
            for(int j1 = 0; j1 < 4; j1++)
            {
                float f4 = 0.125F;
                if(j1 == 0)
                {
                    p_78600_1_.func_71905_a(0.5F - f4, 0.0F, 0.0F, 0.5F + f4, 1.0F, f4 * 2.0F);
                }
                if(j1 == 1)
                {
                    p_78600_1_.func_71905_a(0.5F - f4, 0.0F, 1.0F - f4 * 2.0F, 0.5F + f4, 1.0F, 1.0F);
                }
                f4 = 0.0625F;
                if(j1 == 2)
                {
                    p_78600_1_.func_71905_a(0.5F - f4, 1.0F - f4 * 3F, -f4 * 2.0F, 0.5F + f4, 1.0F - f4, 1.0F + f4 * 2.0F);
                }
                if(j1 == 3)
                {
                    p_78600_1_.func_71905_a(0.5F - f4, 0.5F - f4 * 3F, -f4 * 2.0F, 0.5F + f4, 0.5F - f4, 1.0F + f4 * 2.0F);
                }
                GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
                tessellator.func_78382_b();
                tessellator.func_78375_b(0.0F, -1F, 0.0F);
                func_78613_a(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(0));
                tessellator.func_78381_a();
                tessellator.func_78382_b();
                tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
                func_78617_b(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(1));
                tessellator.func_78381_a();
                tessellator.func_78382_b();
                tessellator.func_78375_b(0.0F, 0.0F, -1F);
                func_78611_c(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(2));
                tessellator.func_78381_a();
                tessellator.func_78382_b();
                tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
                func_78622_d(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(3));
                tessellator.func_78381_a();
                tessellator.func_78382_b();
                tessellator.func_78375_b(-1F, 0.0F, 0.0F);
                func_78573_e(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(4));
                tessellator.func_78381_a();
                tessellator.func_78382_b();
                tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
                func_78605_f(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(5));
                tessellator.func_78381_a();
                GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            }

            p_78600_1_.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        } else
        if(j == 21)
        {
            for(int k1 = 0; k1 < 3; k1++)
            {
                float f5 = 0.0625F;
                if(k1 == 0)
                {
                    p_78600_1_.func_71905_a(0.5F - f5, 0.3F, 0.0F, 0.5F + f5, 1.0F, f5 * 2.0F);
                }
                if(k1 == 1)
                {
                    p_78600_1_.func_71905_a(0.5F - f5, 0.3F, 1.0F - f5 * 2.0F, 0.5F + f5, 1.0F, 1.0F);
                }
                f5 = 0.0625F;
                if(k1 == 2)
                {
                    p_78600_1_.func_71905_a(0.5F - f5, 0.5F, 0.0F, 0.5F + f5, 1.0F - f5, 1.0F);
                }
                GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
                tessellator.func_78382_b();
                tessellator.func_78375_b(0.0F, -1F, 0.0F);
                func_78613_a(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(0));
                tessellator.func_78381_a();
                tessellator.func_78382_b();
                tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
                func_78617_b(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(1));
                tessellator.func_78381_a();
                tessellator.func_78382_b();
                tessellator.func_78375_b(0.0F, 0.0F, -1F);
                func_78611_c(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(2));
                tessellator.func_78381_a();
                tessellator.func_78382_b();
                tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
                func_78622_d(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(3));
                tessellator.func_78381_a();
                tessellator.func_78382_b();
                tessellator.func_78375_b(-1F, 0.0F, 0.0F);
                func_78573_e(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(4));
                tessellator.func_78381_a();
                tessellator.func_78382_b();
                tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
                func_78605_f(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(5));
                tessellator.func_78381_a();
                GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            }

            p_78600_1_.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        } else
        {
            ModLoader.renderInvBlock(this, p_78600_1_, p_78600_2_, j);
        }
    }

    public static boolean func_78597_b(int p_78597_0_)
    {
        if(p_78597_0_ == 0)
        {
            return true;
        }
        if(p_78597_0_ == 31)
        {
            return true;
        }
        if(p_78597_0_ == 13)
        {
            return true;
        }
        if(p_78597_0_ == 10)
        {
            return true;
        }
        if(p_78597_0_ == 11)
        {
            return true;
        }
        if(p_78597_0_ == 27)
        {
            return true;
        }
        if(p_78597_0_ == 22)
        {
            return true;
        }
        if(p_78597_0_ == 21)
        {
            return true;
        }
        if(p_78597_0_ == 16)
        {
            return true;
        } else
        {
            return ModLoader.renderBlockIsItemFull3D(p_78597_0_);
        }
    }

}
