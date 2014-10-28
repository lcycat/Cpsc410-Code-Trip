// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Material, IBlockAccess, AxisAlignedBB, AABBPool, 
//            EntityPlayer, World, ItemStack, EntityItem, 
//            EntityXPOrb, Vec3, MovingObjectPosition, StatList, 
//            EnchantmentHelper, Item, StatCollector, StepSound, 
//            StepSoundStone, StepSoundSand, BlockStone, BlockGrass, 
//            BlockDirt, CreativeTabs, BlockWood, BlockSapling, 
//            BlockFlowing, BlockStationary, BlockSand, BlockGravel, 
//            BlockOre, BlockLog, BlockLeaves, BlockSponge, 
//            BlockGlass, BlockDispenser, BlockSandStone, BlockNote, 
//            BlockBed, BlockRail, BlockDetectorRail, BlockPistonBase, 
//            BlockWeb, BlockTallGrass, BlockDeadBush, BlockPistonExtension, 
//            BlockCloth, BlockPistonMoving, BlockFlower, BlockMushroom, 
//            BlockOreStorage, BlockStep, BlockHalfSlab, BlockTNT, 
//            BlockBookshelf, BlockObsidian, BlockTorch, BlockFire, 
//            BlockMobSpawner, BlockStairs, BlockChest, BlockRedstoneWire, 
//            BlockWorkbench, BlockCrops, BlockFarmland, BlockFurnace, 
//            BlockSign, TileEntitySign, BlockDoor, BlockLadder, 
//            BlockLever, BlockPressurePlate, EnumMobType, BlockRedstoneOre, 
//            BlockRedstoneTorch, BlockButton, BlockSnow, BlockIce, 
//            BlockSnowBlock, BlockCactus, BlockClay, BlockReed, 
//            BlockJukeBox, BlockFence, BlockPumpkin, BlockNetherrack, 
//            BlockSoulSand, BlockGlowStone, BlockPortal, BlockCake, 
//            BlockRedstoneRepeater, BlockLockedChest, BlockTrapDoor, BlockSilverfish, 
//            BlockStoneBrick, BlockMushroomCap, BlockPane, BlockMelon, 
//            BlockStem, BlockVine, BlockFenceGate, BlockMycelium, 
//            BlockLilyPad, BlockNetherStalk, BlockEnchantmentTable, BlockBrewingStand, 
//            BlockCauldron, BlockEndPortal, BlockEndPortalFrame, BlockDragonEgg, 
//            BlockRedstoneLight, BlockWoodSlab, BlockCocoa, BlockEnderChest, 
//            BlockTripWireSource, BlockTripWire, ItemCloth, ItemTree, 
//            ItemWood, ItemBlockSilverfish, ItemSmoothStone, ItemSandStone, 
//            ItemSlab, ItemSapling, ItemLeaves, ItemColored, 
//            ItemLilyPad, ItemPiston, ItemBlock, Entity, 
//            EntityLiving

public class Block
{

    private CreativeTabs field_71969_a;
    public static final StepSound field_71966_d;
    public static final StepSound field_71967_e;
    public static final StepSound field_71964_f;
    public static final StepSound field_71965_g;
    public static final StepSound field_71976_h;
    public static final StepSound field_71977_i;
    public static final StepSound field_71974_j;
    public static final StepSound field_71975_k;
    public static final StepSound field_71972_l;
    public static final Block field_71973_m[];
    public static final boolean field_71970_n[] = new boolean[4096];
    public static final int field_71971_o[];
    public static final boolean field_71985_p[];
    public static final int field_71984_q[] = new int[4096];
    public static final boolean field_71983_r[] = new boolean[4096];
    public static boolean field_71982_s[];
    public static final Block field_71981_t;
    public static final BlockGrass field_71980_u;
    public static final Block field_71979_v;
    public static final Block field_71978_w;
    public static final Block field_71988_x;
    public static final Block field_71987_y;
    public static final Block field_71986_z;
    public static final Block field_71942_A;
    public static final Block field_71943_B;
    public static final Block field_71944_C;
    public static final Block field_71938_D;
    public static final Block field_71939_E;
    public static final Block field_71940_F;
    public static final Block field_71941_G;
    public static final Block field_71949_H;
    public static final Block field_71950_I;
    public static final Block field_71951_J;
    public static final BlockLeaves field_71952_K;
    public static final Block field_71945_L;
    public static final Block field_71946_M;
    public static final Block field_71947_N;
    public static final Block field_71948_O;
    public static final Block field_71958_P;
    public static final Block field_71957_Q;
    public static final Block field_71960_R = (new BlockNote(25)).func_71848_c(0.8F).func_71864_b("musicBlock").func_71912_p();
    public static final Block field_71959_S = (new BlockBed(26)).func_71848_c(0.2F).func_71864_b("bed").func_71896_v().func_71912_p();
    public static final Block field_71954_T;
    public static final Block field_71953_U;
    public static final Block field_71956_V;
    public static final Block field_71955_W = (new BlockWeb(30, 11)).func_71868_h(1).func_71848_c(4F).func_71864_b("web");
    public static final BlockTallGrass field_71962_X;
    public static final BlockDeadBush field_71961_Y;
    public static final Block field_71963_Z;
    public static final BlockPistonExtension field_72099_aa = (BlockPistonExtension)(new BlockPistonExtension(34, 107)).func_71912_p();
    public static final Block field_72101_ab;
    public static final BlockPistonMoving field_72095_ac = new BlockPistonMoving(36);
    public static final BlockFlower field_72097_ad;
    public static final BlockFlower field_72107_ae;
    public static final BlockFlower field_72109_af;
    public static final BlockFlower field_72103_ag;
    public static final Block field_72105_ah;
    public static final Block field_72083_ai;
    public static final BlockHalfSlab field_72085_aj;
    public static final BlockHalfSlab field_72079_ak;
    public static final Block field_72081_al;
    public static final Block field_72091_am;
    public static final Block field_72093_an;
    public static final Block field_72087_ao;
    public static final Block field_72089_ap;
    public static final Block field_72069_aq;
    public static final BlockFire field_72067_ar;
    public static final Block field_72065_as;
    public static final Block field_72063_at;
    public static final Block field_72077_au;
    public static final Block field_72075_av;
    public static final Block field_72073_aw;
    public static final Block field_72071_ax;
    public static final Block field_72060_ay;
    public static final Block field_72058_az;
    public static final Block field_72050_aA;
    public static final Block field_72051_aB;
    public static final Block field_72052_aC;
    public static final Block field_72053_aD;
    public static final Block field_72054_aE;
    public static final Block field_72055_aF;
    public static final Block field_72056_aG;
    public static final Block field_72057_aH;
    public static final Block field_72042_aI;
    public static final Block field_72043_aJ;
    public static final Block field_72044_aK;
    public static final Block field_72045_aL;
    public static final Block field_72046_aM;
    public static final Block field_72047_aN;
    public static final Block field_72048_aO;
    public static final Block field_72049_aP;
    public static final Block field_72035_aQ;
    public static final Block field_72034_aR;
    public static final Block field_72037_aS;
    public static final Block field_72036_aT;
    public static final Block field_72039_aU;
    public static final Block field_72038_aV;
    public static final Block field_72041_aW;
    public static final Block field_72040_aX;
    public static final Block field_72032_aY;
    public static final Block field_72031_aZ;
    public static final Block field_72061_ba;
    public static final Block field_72012_bb;
    public static final Block field_72013_bc;
    public static final Block field_72014_bd;
    public static final BlockPortal field_72015_be;
    public static final Block field_72008_bf;
    public static final Block field_72009_bg;
    public static final Block field_72010_bh;
    public static final Block field_72011_bi;
    public static final Block field_72004_bj;
    public static final Block field_72005_bk;
    public static final Block field_72006_bl;
    public static final Block field_72007_bm;
    public static final Block field_72000_bn;
    public static final Block field_72001_bo;
    public static final Block field_72002_bp;
    public static final Block field_72003_bq;
    public static final Block field_71997_br;
    public static final Block field_71996_bs;
    public static final Block field_71999_bt;
    public static final Block field_71998_bu;
    public static final Block field_71993_bv;
    public static final Block field_71992_bw;
    public static final Block field_71995_bx;
    public static final BlockMycelium field_71994_by;
    public static final Block field_71991_bz;
    public static final Block field_72033_bA;
    public static final Block field_72098_bB;
    public static final Block field_72100_bC;
    public static final Block field_72094_bD = (new BlockNetherStalk(115)).func_71864_b("netherStalk").func_71912_p();
    public static final Block field_72096_bE = (new BlockEnchantmentTable(116)).func_71848_c(5F).func_71894_b(2000F).func_71864_b("enchantmentTable");
    public static final Block field_72106_bF = (new BlockBrewingStand(117)).func_71848_c(0.5F).func_71900_a(0.125F).func_71864_b("brewingStand").func_71912_p();
    public static final Block field_72108_bG = (new BlockCauldron(118)).func_71848_c(2.0F).func_71864_b("cauldron").func_71912_p();
    public static final Block field_72102_bH;
    public static final Block field_72104_bI;
    public static final Block field_72082_bJ;
    public static final Block field_72084_bK;
    public static final Block field_72078_bL;
    public static final Block field_72080_bM;
    public static final BlockHalfSlab field_72090_bN;
    public static final BlockHalfSlab field_72092_bO;
    public static final Block field_72086_bP;
    public static final Block field_72088_bQ;
    public static final Block field_72068_bR;
    public static final Block field_72066_bS;
    public static final BlockTripWireSource field_72064_bT = (BlockTripWireSource)(new BlockTripWireSource(131)).func_71864_b("tripWireSource").func_71912_p();
    public static final Block field_72062_bU = (new BlockTripWire(132)).func_71864_b("tripWire").func_71912_p();
    public static final Block field_72076_bV;
    public static final Block field_72074_bW;
    public static final Block field_72072_bX;
    public static final Block field_72070_bY;
    public int field_72059_bZ;
    public final int field_71990_ca;
    protected float field_71989_cb;
    protected float field_72029_cc;
    protected boolean field_72030_cd;
    protected boolean field_72027_ce;
    protected boolean field_72028_cf;
    protected boolean field_72025_cg;
    public double field_72026_ch;
    public double field_72023_ci;
    public double field_72024_cj;
    public double field_72021_ck;
    public double field_72022_cl;
    public double field_72019_cm;
    public StepSound field_72020_cn;
    public float field_72017_co;
    public final Material field_72018_cp;
    public float field_72016_cq;
    private String field_71968_b;

    protected Block(int p_i4009_1_, Material p_i4009_2_)
    {
        field_72030_cd = true;
        field_72027_ce = true;
        field_72020_cn = field_71966_d;
        field_72017_co = 1.0F;
        field_72016_cq = 0.6F;
        if(field_71973_m[p_i4009_1_] != null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Slot ").append(p_i4009_1_).append(" is already occupied by ").append(field_71973_m[p_i4009_1_]).append(" when adding ").append(this).toString());
        } else
        {
            field_72018_cp = p_i4009_2_;
            field_71973_m[p_i4009_1_] = this;
            field_71990_ca = p_i4009_1_;
            func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            field_71970_n[p_i4009_1_] = func_71926_d();
            field_71971_o[p_i4009_1_] = func_71926_d() ? 255 : 0;
            field_71985_p[p_i4009_1_] = !p_i4009_2_.func_76228_b();
            return;
        }
    }

    protected Block func_71912_p()
    {
        field_71983_r[field_71990_ca] = true;
        return this;
    }

    protected void func_71928_r_()
    {
    }

    protected Block(int p_i4010_1_, int p_i4010_2_, Material p_i4010_3_)
    {
        this(p_i4010_1_, p_i4010_3_);
        field_72059_bZ = p_i4010_2_;
    }

    protected Block func_71884_a(StepSound p_71884_1_)
    {
        field_72020_cn = p_71884_1_;
        return this;
    }

    protected Block func_71868_h(int p_71868_1_)
    {
        field_71971_o[field_71990_ca] = p_71868_1_;
        return this;
    }

    protected Block func_71900_a(float p_71900_1_)
    {
        field_71984_q[field_71990_ca] = (int)(15F * p_71900_1_);
        return this;
    }

    protected Block func_71894_b(float p_71894_1_)
    {
        field_72029_cc = p_71894_1_ * 3F;
        return this;
    }

    public static boolean func_71932_i(int p_71932_0_)
    {
        Block block = field_71973_m[p_71932_0_];
        if(block == null)
        {
            return false;
        } else
        {
            return block.field_72018_cp.func_76218_k() && block.func_71886_c();
        }
    }

    public boolean func_71886_c()
    {
        return true;
    }

    public boolean func_71918_c(IBlockAccess p_71918_1_, int p_71918_2_, int p_71918_3_, int p_71918_4_)
    {
        return !field_72018_cp.func_76230_c();
    }

    public int func_71857_b()
    {
        return 0;
    }

    protected Block func_71848_c(float p_71848_1_)
    {
        field_71989_cb = p_71848_1_;
        if(field_72029_cc < p_71848_1_ * 5F)
        {
            field_72029_cc = p_71848_1_ * 5F;
        }
        return this;
    }

    protected Block func_71875_q()
    {
        func_71848_c(-1F);
        return this;
    }

    public float func_71934_m(World p_71934_1_, int p_71934_2_, int p_71934_3_, int p_71934_4_)
    {
        return field_71989_cb;
    }

    protected Block func_71907_b(boolean p_71907_1_)
    {
        field_72028_cf = p_71907_1_;
        return this;
    }

    public boolean func_71881_r()
    {
        return field_72028_cf;
    }

    public boolean func_71887_s()
    {
        return field_72025_cg;
    }

    public void func_71905_a(float p_71905_1_, float p_71905_2_, float p_71905_3_, float p_71905_4_, float p_71905_5_, float p_71905_6_)
    {
        field_72026_ch = p_71905_1_;
        field_72023_ci = p_71905_2_;
        field_72024_cj = p_71905_3_;
        field_72021_ck = p_71905_4_;
        field_72022_cl = p_71905_5_;
        field_72019_cm = p_71905_6_;
    }

    public boolean func_71924_d(IBlockAccess p_71924_1_, int p_71924_2_, int p_71924_3_, int p_71924_4_, int p_71924_5_)
    {
        return p_71924_1_.func_72803_f(p_71924_2_, p_71924_3_, p_71924_4_).func_76220_a();
    }

    public int func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        return func_71851_a(p_71858_1_);
    }

    public int func_71851_a(int p_71851_1_)
    {
        return field_72059_bZ;
    }

    public void func_71871_a(World p_71871_1_, int p_71871_2_, int p_71871_3_, int p_71871_4_, AxisAlignedBB p_71871_5_, List p_71871_6_, Entity p_71871_7_)
    {
        AxisAlignedBB axisalignedbb = func_71872_e(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_);
        if(axisalignedbb != null && p_71871_5_.func_72326_a(axisalignedbb))
        {
            p_71871_6_.add(axisalignedbb);
        }
    }

    public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_)
    {
        return AxisAlignedBB.func_72332_a().func_72299_a((double)p_71872_2_ + field_72026_ch, (double)p_71872_3_ + field_72023_ci, (double)p_71872_4_ + field_72024_cj, (double)p_71872_2_ + field_72021_ck, (double)p_71872_3_ + field_72022_cl, (double)p_71872_4_ + field_72019_cm);
    }

    public boolean func_71926_d()
    {
        return true;
    }

    public boolean func_71913_a(int p_71913_1_, boolean p_71913_2_)
    {
        return func_71935_l();
    }

    public boolean func_71935_l()
    {
        return true;
    }

    public void func_71847_b(World world, int i, int j, int k, Random random)
    {
    }

    public void func_71898_d(World world, int i, int j, int k, int l)
    {
    }

    public void func_71863_a(World world, int i, int j, int k, int l)
    {
    }

    public int func_71859_p_()
    {
        return 10;
    }

    public void func_71861_g(World world, int i, int j, int k)
    {
    }

    public void func_71852_a(World world, int i, int j, int k, int l, int i1)
    {
    }

    public int func_71925_a(Random p_71925_1_)
    {
        return 1;
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        return field_71990_ca;
    }

    public float func_71908_a(EntityPlayer p_71908_1_, World p_71908_2_, int p_71908_3_, int p_71908_4_, int p_71908_5_)
    {
        float f = func_71934_m(p_71908_2_, p_71908_3_, p_71908_4_, p_71908_5_);
        if(f < 0.0F)
        {
            return 0.0F;
        }
        if(!p_71908_1_.func_71062_b(this))
        {
            return 1.0F / f / 100F;
        } else
        {
            return p_71908_1_.func_71055_a(this) / f / 30F;
        }
    }

    public final void func_71897_c(World p_71897_1_, int p_71897_2_, int p_71897_3_, int p_71897_4_, int p_71897_5_, int p_71897_6_)
    {
        func_71914_a(p_71897_1_, p_71897_2_, p_71897_3_, p_71897_4_, p_71897_5_, 1.0F, p_71897_6_);
    }

    public void func_71914_a(World p_71914_1_, int p_71914_2_, int p_71914_3_, int p_71914_4_, int p_71914_5_, float p_71914_6_, int p_71914_7_)
    {
        if(p_71914_1_.field_72995_K)
        {
            return;
        }
        int i = func_71910_a(p_71914_7_, p_71914_1_.field_73012_v);
        for(int j = 0; j < i; j++)
        {
            if(p_71914_1_.field_73012_v.nextFloat() > p_71914_6_)
            {
                continue;
            }
            int k = func_71885_a(p_71914_5_, p_71914_1_.field_73012_v, p_71914_7_);
            if(k > 0)
            {
                func_71929_a(p_71914_1_, p_71914_2_, p_71914_3_, p_71914_4_, new ItemStack(k, 1, func_71899_b(p_71914_5_)));
            }
        }

    }

    protected void func_71929_a(World p_71929_1_, int p_71929_2_, int p_71929_3_, int p_71929_4_, ItemStack p_71929_5_)
    {
        if(p_71929_1_.field_72995_K)
        {
            return;
        } else
        {
            float f = 0.7F;
            double d = (double)(p_71929_1_.field_73012_v.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
            double d1 = (double)(p_71929_1_.field_73012_v.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
            double d2 = (double)(p_71929_1_.field_73012_v.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
            EntityItem entityitem = new EntityItem(p_71929_1_, (double)p_71929_2_ + d, (double)p_71929_3_ + d1, (double)p_71929_4_ + d2, p_71929_5_);
            entityitem.field_70293_c = 10;
            p_71929_1_.func_72838_d(entityitem);
            return;
        }
    }

    protected void func_71923_g(World p_71923_1_, int p_71923_2_, int p_71923_3_, int p_71923_4_, int p_71923_5_)
    {
        if(!p_71923_1_.field_72995_K)
        {
            while(p_71923_5_ > 0) 
            {
                int i = EntityXPOrb.func_70527_a(p_71923_5_);
                p_71923_5_ -= i;
                p_71923_1_.func_72838_d(new EntityXPOrb(p_71923_1_, (double)p_71923_2_ + 0.5D, (double)p_71923_3_ + 0.5D, (double)p_71923_4_ + 0.5D, i));
            }
        }
    }

    protected int func_71899_b(int p_71899_1_)
    {
        return 0;
    }

    public float func_71904_a(Entity p_71904_1_)
    {
        return field_72029_cc / 5F;
    }

    public MovingObjectPosition func_71878_a(World p_71878_1_, int p_71878_2_, int p_71878_3_, int p_71878_4_, Vec3 p_71878_5_, Vec3 p_71878_6_)
    {
        func_71902_a(p_71878_1_, p_71878_2_, p_71878_3_, p_71878_4_);
        p_71878_5_ = p_71878_5_.func_72441_c(-p_71878_2_, -p_71878_3_, -p_71878_4_);
        p_71878_6_ = p_71878_6_.func_72441_c(-p_71878_2_, -p_71878_3_, -p_71878_4_);
        Vec3 vec3 = p_71878_5_.func_72429_b(p_71878_6_, field_72026_ch);
        Vec3 vec3_1 = p_71878_5_.func_72429_b(p_71878_6_, field_72021_ck);
        Vec3 vec3_2 = p_71878_5_.func_72435_c(p_71878_6_, field_72023_ci);
        Vec3 vec3_3 = p_71878_5_.func_72435_c(p_71878_6_, field_72022_cl);
        Vec3 vec3_4 = p_71878_5_.func_72434_d(p_71878_6_, field_72024_cj);
        Vec3 vec3_5 = p_71878_5_.func_72434_d(p_71878_6_, field_72019_cm);
        if(!func_71916_a(vec3))
        {
            vec3 = null;
        }
        if(!func_71916_a(vec3_1))
        {
            vec3_1 = null;
        }
        if(!func_71936_b(vec3_2))
        {
            vec3_2 = null;
        }
        if(!func_71936_b(vec3_3))
        {
            vec3_3 = null;
        }
        if(!func_71890_c(vec3_4))
        {
            vec3_4 = null;
        }
        if(!func_71890_c(vec3_5))
        {
            vec3_5 = null;
        }
        Vec3 vec3_6 = null;
        if(vec3 != null && (vec3_6 == null || p_71878_5_.func_72436_e(vec3) < p_71878_5_.func_72436_e(vec3_6)))
        {
            vec3_6 = vec3;
        }
        if(vec3_1 != null && (vec3_6 == null || p_71878_5_.func_72436_e(vec3_1) < p_71878_5_.func_72436_e(vec3_6)))
        {
            vec3_6 = vec3_1;
        }
        if(vec3_2 != null && (vec3_6 == null || p_71878_5_.func_72436_e(vec3_2) < p_71878_5_.func_72436_e(vec3_6)))
        {
            vec3_6 = vec3_2;
        }
        if(vec3_3 != null && (vec3_6 == null || p_71878_5_.func_72436_e(vec3_3) < p_71878_5_.func_72436_e(vec3_6)))
        {
            vec3_6 = vec3_3;
        }
        if(vec3_4 != null && (vec3_6 == null || p_71878_5_.func_72436_e(vec3_4) < p_71878_5_.func_72436_e(vec3_6)))
        {
            vec3_6 = vec3_4;
        }
        if(vec3_5 != null && (vec3_6 == null || p_71878_5_.func_72436_e(vec3_5) < p_71878_5_.func_72436_e(vec3_6)))
        {
            vec3_6 = vec3_5;
        }
        if(vec3_6 == null)
        {
            return null;
        }
        byte byte0 = -1;
        if(vec3_6 == vec3)
        {
            byte0 = 4;
        }
        if(vec3_6 == vec3_1)
        {
            byte0 = 5;
        }
        if(vec3_6 == vec3_2)
        {
            byte0 = 0;
        }
        if(vec3_6 == vec3_3)
        {
            byte0 = 1;
        }
        if(vec3_6 == vec3_4)
        {
            byte0 = 2;
        }
        if(vec3_6 == vec3_5)
        {
            byte0 = 3;
        }
        return new MovingObjectPosition(p_71878_2_, p_71878_3_, p_71878_4_, byte0, vec3_6.func_72441_c(p_71878_2_, p_71878_3_, p_71878_4_));
    }

    private boolean func_71916_a(Vec3 p_71916_1_)
    {
        if(p_71916_1_ == null)
        {
            return false;
        } else
        {
            return p_71916_1_.field_72448_b >= field_72023_ci && p_71916_1_.field_72448_b <= field_72022_cl && p_71916_1_.field_72449_c >= field_72024_cj && p_71916_1_.field_72449_c <= field_72019_cm;
        }
    }

    private boolean func_71936_b(Vec3 p_71936_1_)
    {
        if(p_71936_1_ == null)
        {
            return false;
        } else
        {
            return p_71936_1_.field_72450_a >= field_72026_ch && p_71936_1_.field_72450_a <= field_72021_ck && p_71936_1_.field_72449_c >= field_72024_cj && p_71936_1_.field_72449_c <= field_72019_cm;
        }
    }

    private boolean func_71890_c(Vec3 p_71890_1_)
    {
        if(p_71890_1_ == null)
        {
            return false;
        } else
        {
            return p_71890_1_.field_72450_a >= field_72026_ch && p_71890_1_.field_72450_a <= field_72021_ck && p_71890_1_.field_72448_b >= field_72023_ci && p_71890_1_.field_72448_b <= field_72022_cl;
        }
    }

    public void func_71867_k(World world, int i, int j, int k)
    {
    }

    public boolean func_71850_a_(World p_71850_1_, int p_71850_2_, int p_71850_3_, int p_71850_4_, int p_71850_5_)
    {
        return func_71930_b(p_71850_1_, p_71850_2_, p_71850_3_, p_71850_4_);
    }

    public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_)
    {
        int i = p_71930_1_.func_72798_a(p_71930_2_, p_71930_3_, p_71930_4_);
        return i == 0 || field_71973_m[i].field_72018_cp.func_76222_j();
    }

    public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int i, EntityPlayer entityplayer, int j, float f, 
            float f1, float f2)
    {
        return false;
    }

    public void func_71891_b(World world, int i, int j, int k, Entity entity)
    {
    }

    public void func_71909_a(World world, int i, int j, int k, int l, float f, float f1, 
            float f2)
    {
    }

    public void func_71921_a(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
    }

    public void func_71901_a(World world, int i, int j, int k, Entity entity, Vec3 vec3)
    {
    }

    public void func_71902_a(IBlockAccess iblockaccess, int i, int j, int k)
    {
    }

    public boolean func_71865_a(IBlockAccess p_71865_1_, int p_71865_2_, int p_71865_3_, int i, int j)
    {
        return false;
    }

    public boolean func_71853_i()
    {
        return false;
    }

    public void func_71869_a(World world, int i, int j, int k, Entity entity)
    {
    }

    public boolean func_71855_c(World p_71855_1_, int p_71855_2_, int p_71855_3_, int i, int j)
    {
        return false;
    }

    public void func_71919_f()
    {
    }

    public void func_71893_a(World p_71893_1_, EntityPlayer p_71893_2_, int p_71893_3_, int p_71893_4_, int p_71893_5_, int p_71893_6_)
    {
        p_71893_2_.func_71064_a(StatList.field_75934_C[field_71990_ca], 1);
        p_71893_2_.func_71020_j(0.025F);
        if(func_71906_q_() && EnchantmentHelper.func_77502_d(p_71893_2_.field_71071_by))
        {
            ItemStack itemstack = func_71880_c_(p_71893_6_);
            if(itemstack != null)
            {
                func_71929_a(p_71893_1_, p_71893_3_, p_71893_4_, p_71893_5_, itemstack);
            }
        } else
        {
            int i = EnchantmentHelper.func_77517_e(p_71893_2_.field_71071_by);
            func_71897_c(p_71893_1_, p_71893_3_, p_71893_4_, p_71893_5_, p_71893_6_, i);
        }
    }

    protected boolean func_71906_q_()
    {
        return func_71886_c() && !field_72025_cg;
    }

    protected ItemStack func_71880_c_(int p_71880_1_)
    {
        int i = 0;
        if(field_71990_ca >= 0 && field_71990_ca < Item.field_77698_e.length && Item.field_77698_e[field_71990_ca].func_77614_k())
        {
            i = p_71880_1_;
        }
        return new ItemStack(field_71990_ca, 1, i);
    }

    public int func_71910_a(int p_71910_1_, Random p_71910_2_)
    {
        return func_71925_a(p_71910_2_);
    }

    public boolean func_71854_d(World p_71854_1_, int p_71854_2_, int p_71854_3_, int i)
    {
        return true;
    }

    public void func_71860_a(World world, int i, int j, int k, EntityLiving entityliving)
    {
    }

    public Block func_71864_b(String p_71864_1_)
    {
        field_71968_b = (new StringBuilder()).append("tile.").append(p_71864_1_).toString();
        return this;
    }

    public String func_71931_t()
    {
        return StatCollector.func_74838_a((new StringBuilder()).append(func_71917_a()).append(".name").toString());
    }

    public String func_71917_a()
    {
        return field_71968_b;
    }

    public void func_71883_b(World world, int i, int j, int k, int l, int i1)
    {
    }

    public boolean func_71876_u()
    {
        return field_72027_ce;
    }

    protected Block func_71896_v()
    {
        field_72027_ce = false;
        return this;
    }

    public int func_71915_e()
    {
        return field_72018_cp.func_76227_m();
    }

    public void func_71866_a(World world, int i, int j, int k, Entity entity, float f)
    {
    }

    public Block func_71849_a(CreativeTabs p_71849_1_)
    {
        field_71969_a = p_71849_1_;
        return this;
    }

    public void func_71846_a(World world, int i, int j, int k, int l, EntityPlayer entityplayer)
    {
    }

    public void func_71927_h(World world, int i, int j, int k, int l)
    {
    }

    public void func_71892_f(World world, int i, int j, int k)
    {
    }

    public void func_71937_a(World world, long l, long l1)
    {
    }

    static Class _mthclass$(String s)
    {
        try
        {
            return Class.forName(s);
        }
        catch(ClassNotFoundException classnotfoundexception)
        {
            throw new NoClassDefFoundError(classnotfoundexception.getMessage());
        }
    }

    static 
    {
        field_71966_d = new StepSound("stone", 1.0F, 1.0F);
        field_71967_e = new StepSound("wood", 1.0F, 1.0F);
        field_71964_f = new StepSound("gravel", 1.0F, 1.0F);
        field_71965_g = new StepSound("grass", 1.0F, 1.0F);
        field_71976_h = new StepSound("stone", 1.0F, 1.0F);
        field_71977_i = new StepSound("stone", 1.0F, 1.5F);
        field_71974_j = new StepSoundStone("stone", 1.0F, 1.0F);
        field_71975_k = new StepSound("cloth", 1.0F, 1.0F);
        field_71972_l = new StepSoundSand("sand", 1.0F, 1.0F);
        field_71973_m = new Block[4096];
        field_71971_o = new int[4096];
        field_71985_p = new boolean[4096];
        field_71982_s = new boolean[4096];
        field_71981_t = (new BlockStone(1, 1)).func_71848_c(1.5F).func_71894_b(10F).func_71884_a(field_71976_h).func_71864_b("stone");
        field_71980_u = (BlockGrass)(new BlockGrass(2)).func_71848_c(0.6F).func_71884_a(field_71965_g).func_71864_b("grass");
        field_71979_v = (new BlockDirt(3, 2)).func_71848_c(0.5F).func_71884_a(field_71964_f).func_71864_b("dirt");
        field_71978_w = (new Block(4, 16, Material.field_76246_e)).func_71848_c(2.0F).func_71894_b(10F).func_71884_a(field_71976_h).func_71864_b("stonebrick").func_71849_a(CreativeTabs.field_78030_b);
        field_71988_x = (new BlockWood(5)).func_71848_c(2.0F).func_71894_b(5F).func_71884_a(field_71967_e).func_71864_b("wood").func_71912_p();
        field_71987_y = (new BlockSapling(6, 15)).func_71848_c(0.0F).func_71884_a(field_71965_g).func_71864_b("sapling").func_71912_p();
        field_71986_z = (new Block(7, 17, Material.field_76246_e)).func_71875_q().func_71894_b(6000000F).func_71884_a(field_71976_h).func_71864_b("bedrock").func_71896_v().func_71849_a(CreativeTabs.field_78030_b);
        field_71942_A = (new BlockFlowing(8, Material.field_76244_g)).func_71848_c(100F).func_71868_h(3).func_71864_b("water").func_71896_v().func_71912_p();
        field_71943_B = (new BlockStationary(9, Material.field_76244_g)).func_71848_c(100F).func_71868_h(3).func_71864_b("water").func_71896_v().func_71912_p();
        field_71944_C = (new BlockFlowing(10, Material.field_76256_h)).func_71848_c(0.0F).func_71900_a(1.0F).func_71868_h(255).func_71864_b("lava").func_71896_v().func_71912_p();
        field_71938_D = (new BlockStationary(11, Material.field_76256_h)).func_71848_c(100F).func_71900_a(1.0F).func_71868_h(255).func_71864_b("lava").func_71896_v().func_71912_p();
        field_71939_E = (new BlockSand(12, 18)).func_71848_c(0.5F).func_71884_a(field_71972_l).func_71864_b("sand");
        field_71940_F = (new BlockGravel(13, 19)).func_71848_c(0.6F).func_71884_a(field_71964_f).func_71864_b("gravel");
        field_71941_G = (new BlockOre(14, 32)).func_71848_c(3F).func_71894_b(5F).func_71884_a(field_71976_h).func_71864_b("oreGold");
        field_71949_H = (new BlockOre(15, 33)).func_71848_c(3F).func_71894_b(5F).func_71884_a(field_71976_h).func_71864_b("oreIron");
        field_71950_I = (new BlockOre(16, 34)).func_71848_c(3F).func_71894_b(5F).func_71884_a(field_71976_h).func_71864_b("oreCoal");
        field_71951_J = (new BlockLog(17)).func_71848_c(2.0F).func_71884_a(field_71967_e).func_71864_b("log").func_71912_p();
        field_71952_K = (BlockLeaves)(new BlockLeaves(18, 52)).func_71848_c(0.2F).func_71868_h(1).func_71884_a(field_71965_g).func_71864_b("leaves").func_71912_p();
        field_71945_L = (new BlockSponge(19)).func_71848_c(0.6F).func_71884_a(field_71965_g).func_71864_b("sponge");
        field_71946_M = (new BlockGlass(20, 49, Material.field_76264_q, false)).func_71848_c(0.3F).func_71884_a(field_71974_j).func_71864_b("glass");
        field_71947_N = (new BlockOre(21, 160)).func_71848_c(3F).func_71894_b(5F).func_71884_a(field_71976_h).func_71864_b("oreLapis");
        field_71948_O = (new Block(22, 144, Material.field_76246_e)).func_71848_c(3F).func_71894_b(5F).func_71884_a(field_71976_h).func_71864_b("blockLapis").func_71849_a(CreativeTabs.field_78030_b);
        field_71958_P = (new BlockDispenser(23)).func_71848_c(3.5F).func_71884_a(field_71976_h).func_71864_b("dispenser").func_71912_p();
        field_71957_Q = (new BlockSandStone(24)).func_71884_a(field_71976_h).func_71848_c(0.8F).func_71864_b("sandStone").func_71912_p();
        field_71954_T = (new BlockRail(27, 179, true)).func_71848_c(0.7F).func_71884_a(field_71977_i).func_71864_b("goldenRail").func_71912_p();
        field_71953_U = (new BlockDetectorRail(28, 195)).func_71848_c(0.7F).func_71884_a(field_71977_i).func_71864_b("detectorRail").func_71912_p();
        field_71956_V = (new BlockPistonBase(29, 106, true)).func_71864_b("pistonStickyBase").func_71912_p();
        field_71962_X = (BlockTallGrass)(new BlockTallGrass(31, 39)).func_71848_c(0.0F).func_71884_a(field_71965_g).func_71864_b("tallgrass");
        field_71961_Y = (BlockDeadBush)(new BlockDeadBush(32, 55)).func_71848_c(0.0F).func_71884_a(field_71965_g).func_71864_b("deadbush");
        field_71963_Z = (new BlockPistonBase(33, 107, false)).func_71864_b("pistonBase").func_71912_p();
        field_72101_ab = (new BlockCloth()).func_71848_c(0.8F).func_71884_a(field_71975_k).func_71864_b("cloth").func_71912_p();
        field_72097_ad = (BlockFlower)(new BlockFlower(37, 13)).func_71848_c(0.0F).func_71884_a(field_71965_g).func_71864_b("flower");
        field_72107_ae = (BlockFlower)(new BlockFlower(38, 12)).func_71848_c(0.0F).func_71884_a(field_71965_g).func_71864_b("rose");
        field_72109_af = (BlockFlower)(new BlockMushroom(39, 29)).func_71848_c(0.0F).func_71884_a(field_71965_g).func_71900_a(0.125F).func_71864_b("mushroom");
        field_72103_ag = (BlockFlower)(new BlockMushroom(40, 28)).func_71848_c(0.0F).func_71884_a(field_71965_g).func_71864_b("mushroom");
        field_72105_ah = (new BlockOreStorage(41, 23)).func_71848_c(3F).func_71894_b(10F).func_71884_a(field_71977_i).func_71864_b("blockGold");
        field_72083_ai = (new BlockOreStorage(42, 22)).func_71848_c(5F).func_71894_b(10F).func_71884_a(field_71977_i).func_71864_b("blockIron");
        field_72085_aj = (BlockHalfSlab)(new BlockStep(43, true)).func_71848_c(2.0F).func_71894_b(10F).func_71884_a(field_71976_h).func_71864_b("stoneSlab");
        field_72079_ak = (BlockHalfSlab)(new BlockStep(44, false)).func_71848_c(2.0F).func_71894_b(10F).func_71884_a(field_71976_h).func_71864_b("stoneSlab");
        field_72081_al = (new Block(45, 7, Material.field_76246_e)).func_71848_c(2.0F).func_71894_b(10F).func_71884_a(field_71976_h).func_71864_b("brick").func_71849_a(CreativeTabs.field_78030_b);
        field_72091_am = (new BlockTNT(46, 8)).func_71848_c(0.0F).func_71884_a(field_71965_g).func_71864_b("tnt");
        field_72093_an = (new BlockBookshelf(47, 35)).func_71848_c(1.5F).func_71884_a(field_71967_e).func_71864_b("bookshelf");
        field_72087_ao = (new Block(48, 36, Material.field_76246_e)).func_71848_c(2.0F).func_71894_b(10F).func_71884_a(field_71976_h).func_71864_b("stoneMoss").func_71849_a(CreativeTabs.field_78030_b);
        field_72089_ap = (new BlockObsidian(49, 37)).func_71848_c(50F).func_71894_b(2000F).func_71884_a(field_71976_h).func_71864_b("obsidian");
        field_72069_aq = (new BlockTorch(50, 80)).func_71848_c(0.0F).func_71900_a(0.9375F).func_71884_a(field_71967_e).func_71864_b("torch").func_71912_p();
        field_72067_ar = (BlockFire)(new BlockFire(51, 31)).func_71848_c(0.0F).func_71900_a(1.0F).func_71884_a(field_71967_e).func_71864_b("fire").func_71896_v();
        field_72065_as = (new BlockMobSpawner(52, 65)).func_71848_c(5F).func_71884_a(field_71977_i).func_71864_b("mobSpawner").func_71896_v();
        field_72063_at = (new BlockStairs(53, field_71988_x, 0)).func_71864_b("stairsWood").func_71912_p();
        field_72077_au = (new BlockChest(54)).func_71848_c(2.5F).func_71884_a(field_71967_e).func_71864_b("chest").func_71912_p();
        field_72075_av = (new BlockRedstoneWire(55, 164)).func_71848_c(0.0F).func_71884_a(field_71966_d).func_71864_b("redstoneDust").func_71896_v().func_71912_p();
        field_72073_aw = (new BlockOre(56, 50)).func_71848_c(3F).func_71894_b(5F).func_71884_a(field_71976_h).func_71864_b("oreDiamond");
        field_72071_ax = (new BlockOreStorage(57, 24)).func_71848_c(5F).func_71894_b(10F).func_71884_a(field_71977_i).func_71864_b("blockDiamond");
        field_72060_ay = (new BlockWorkbench(58)).func_71848_c(2.5F).func_71884_a(field_71967_e).func_71864_b("workbench");
        field_72058_az = (new BlockCrops(59, 88)).func_71848_c(0.0F).func_71884_a(field_71965_g).func_71864_b("crops").func_71896_v().func_71912_p();
        field_72050_aA = (new BlockFarmland(60)).func_71848_c(0.6F).func_71884_a(field_71964_f).func_71864_b("farmland").func_71912_p();
        field_72051_aB = (new BlockFurnace(61, false)).func_71848_c(3.5F).func_71884_a(field_71976_h).func_71864_b("furnace").func_71912_p().func_71849_a(CreativeTabs.field_78031_c);
        field_72052_aC = (new BlockFurnace(62, true)).func_71848_c(3.5F).func_71884_a(field_71976_h).func_71900_a(0.875F).func_71864_b("furnace").func_71912_p();
        field_72053_aD = (new BlockSign(63, net.minecraft.src.TileEntitySign.class, true)).func_71848_c(1.0F).func_71884_a(field_71967_e).func_71864_b("sign").func_71896_v().func_71912_p();
        field_72054_aE = (new BlockDoor(64, Material.field_76245_d)).func_71848_c(3F).func_71884_a(field_71967_e).func_71864_b("doorWood").func_71896_v().func_71912_p();
        field_72055_aF = (new BlockLadder(65, 83)).func_71848_c(0.4F).func_71884_a(field_71967_e).func_71864_b("ladder").func_71912_p();
        field_72056_aG = (new BlockRail(66, 128, false)).func_71848_c(0.7F).func_71884_a(field_71977_i).func_71864_b("rail").func_71912_p();
        field_72057_aH = (new BlockStairs(67, field_71978_w, 0)).func_71864_b("stairsStone").func_71912_p();
        field_72042_aI = (new BlockSign(68, net.minecraft.src.TileEntitySign.class, false)).func_71848_c(1.0F).func_71884_a(field_71967_e).func_71864_b("sign").func_71896_v().func_71912_p();
        field_72043_aJ = (new BlockLever(69, 96)).func_71848_c(0.5F).func_71884_a(field_71967_e).func_71864_b("lever").func_71912_p();
        field_72044_aK = (new BlockPressurePlate(70, field_71981_t.field_72059_bZ, EnumMobType.mobs, Material.field_76246_e)).func_71848_c(0.5F).func_71884_a(field_71976_h).func_71864_b("pressurePlate").func_71912_p();
        field_72045_aL = (new BlockDoor(71, Material.field_76243_f)).func_71848_c(5F).func_71884_a(field_71977_i).func_71864_b("doorIron").func_71896_v().func_71912_p();
        field_72046_aM = (new BlockPressurePlate(72, field_71988_x.field_72059_bZ, EnumMobType.everything, Material.field_76245_d)).func_71848_c(0.5F).func_71884_a(field_71967_e).func_71864_b("pressurePlate").func_71912_p();
        field_72047_aN = (new BlockRedstoneOre(73, 51, false)).func_71848_c(3F).func_71894_b(5F).func_71884_a(field_71976_h).func_71864_b("oreRedstone").func_71912_p().func_71849_a(CreativeTabs.field_78030_b);
        field_72048_aO = (new BlockRedstoneOre(74, 51, true)).func_71900_a(0.625F).func_71848_c(3F).func_71894_b(5F).func_71884_a(field_71976_h).func_71864_b("oreRedstone").func_71912_p();
        field_72049_aP = (new BlockRedstoneTorch(75, 115, false)).func_71848_c(0.0F).func_71884_a(field_71967_e).func_71864_b("notGate").func_71912_p();
        field_72035_aQ = (new BlockRedstoneTorch(76, 99, true)).func_71848_c(0.0F).func_71900_a(0.5F).func_71884_a(field_71967_e).func_71864_b("notGate").func_71912_p().func_71849_a(CreativeTabs.field_78028_d);
        field_72034_aR = (new BlockButton(77, field_71981_t.field_72059_bZ)).func_71848_c(0.5F).func_71884_a(field_71976_h).func_71864_b("button").func_71912_p();
        field_72037_aS = (new BlockSnow(78, 66)).func_71848_c(0.1F).func_71884_a(field_71975_k).func_71864_b("snow").func_71912_p().func_71868_h(0);
        field_72036_aT = (new BlockIce(79, 67)).func_71848_c(0.5F).func_71868_h(3).func_71884_a(field_71974_j).func_71864_b("ice");
        field_72039_aU = (new BlockSnowBlock(80, 66)).func_71848_c(0.2F).func_71884_a(field_71975_k).func_71864_b("snow");
        field_72038_aV = (new BlockCactus(81, 70)).func_71848_c(0.4F).func_71884_a(field_71975_k).func_71864_b("cactus");
        field_72041_aW = (new BlockClay(82, 72)).func_71848_c(0.6F).func_71884_a(field_71964_f).func_71864_b("clay");
        field_72040_aX = (new BlockReed(83, 73)).func_71848_c(0.0F).func_71884_a(field_71965_g).func_71864_b("reeds").func_71896_v();
        field_72032_aY = (new BlockJukeBox(84, 74)).func_71848_c(2.0F).func_71894_b(10F).func_71884_a(field_71976_h).func_71864_b("jukebox").func_71912_p();
        field_72031_aZ = (new BlockFence(85, 4)).func_71848_c(2.0F).func_71894_b(5F).func_71884_a(field_71967_e).func_71864_b("fence");
        field_72061_ba = (new BlockPumpkin(86, 102, false)).func_71848_c(1.0F).func_71884_a(field_71967_e).func_71864_b("pumpkin").func_71912_p();
        field_72012_bb = (new BlockNetherrack(87, 103)).func_71848_c(0.4F).func_71884_a(field_71976_h).func_71864_b("hellrock");
        field_72013_bc = (new BlockSoulSand(88, 104)).func_71848_c(0.5F).func_71884_a(field_71972_l).func_71864_b("hellsand");
        field_72014_bd = (new BlockGlowStone(89, 105, Material.field_76264_q)).func_71848_c(0.3F).func_71884_a(field_71974_j).func_71900_a(1.0F).func_71864_b("lightgem");
        field_72015_be = (BlockPortal)(new BlockPortal(90, 14)).func_71848_c(-1F).func_71884_a(field_71974_j).func_71900_a(0.75F).func_71864_b("portal");
        field_72008_bf = (new BlockPumpkin(91, 102, true)).func_71848_c(1.0F).func_71884_a(field_71967_e).func_71900_a(1.0F).func_71864_b("litpumpkin").func_71912_p();
        field_72009_bg = (new BlockCake(92, 121)).func_71848_c(0.5F).func_71884_a(field_71975_k).func_71864_b("cake").func_71896_v().func_71912_p();
        field_72010_bh = (new BlockRedstoneRepeater(93, false)).func_71848_c(0.0F).func_71884_a(field_71967_e).func_71864_b("diode").func_71896_v().func_71912_p();
        field_72011_bi = (new BlockRedstoneRepeater(94, true)).func_71848_c(0.0F).func_71900_a(0.625F).func_71884_a(field_71967_e).func_71864_b("diode").func_71896_v().func_71912_p();
        field_72004_bj = (new BlockLockedChest(95)).func_71848_c(0.0F).func_71900_a(1.0F).func_71884_a(field_71967_e).func_71864_b("lockedchest").func_71907_b(true).func_71912_p();
        field_72005_bk = (new BlockTrapDoor(96, Material.field_76245_d)).func_71848_c(3F).func_71884_a(field_71967_e).func_71864_b("trapdoor").func_71896_v().func_71912_p();
        field_72006_bl = (new BlockSilverfish(97)).func_71848_c(0.75F).func_71864_b("monsterStoneEgg");
        field_72007_bm = (new BlockStoneBrick(98)).func_71848_c(1.5F).func_71894_b(10F).func_71884_a(field_71976_h).func_71864_b("stonebricksmooth");
        field_72000_bn = (new BlockMushroomCap(99, Material.field_76245_d, 142, 0)).func_71848_c(0.2F).func_71884_a(field_71967_e).func_71864_b("mushroom").func_71912_p();
        field_72001_bo = (new BlockMushroomCap(100, Material.field_76245_d, 142, 1)).func_71848_c(0.2F).func_71884_a(field_71967_e).func_71864_b("mushroom").func_71912_p();
        field_72002_bp = (new BlockPane(101, 85, 85, Material.field_76243_f, true)).func_71848_c(5F).func_71894_b(10F).func_71884_a(field_71977_i).func_71864_b("fenceIron");
        field_72003_bq = (new BlockPane(102, 49, 148, Material.field_76264_q, false)).func_71848_c(0.3F).func_71884_a(field_71974_j).func_71864_b("thinGlass");
        field_71997_br = (new BlockMelon(103)).func_71848_c(1.0F).func_71884_a(field_71967_e).func_71864_b("melon");
        field_71996_bs = (new BlockStem(104, field_72061_ba)).func_71848_c(0.0F).func_71884_a(field_71967_e).func_71864_b("pumpkinStem").func_71912_p();
        field_71999_bt = (new BlockStem(105, field_71997_br)).func_71848_c(0.0F).func_71884_a(field_71967_e).func_71864_b("pumpkinStem").func_71912_p();
        field_71998_bu = (new BlockVine(106)).func_71848_c(0.2F).func_71884_a(field_71965_g).func_71864_b("vine").func_71912_p();
        field_71993_bv = (new BlockFenceGate(107, 4)).func_71848_c(2.0F).func_71894_b(5F).func_71884_a(field_71967_e).func_71864_b("fenceGate").func_71912_p();
        field_71992_bw = (new BlockStairs(108, field_72081_al, 0)).func_71864_b("stairsBrick").func_71912_p();
        field_71995_bx = (new BlockStairs(109, field_72007_bm, 0)).func_71864_b("stairsStoneBrickSmooth").func_71912_p();
        field_71994_by = (BlockMycelium)(new BlockMycelium(110)).func_71848_c(0.6F).func_71884_a(field_71965_g).func_71864_b("mycel");
        field_71991_bz = (new BlockLilyPad(111, 76)).func_71848_c(0.0F).func_71884_a(field_71965_g).func_71864_b("waterlily");
        field_72033_bA = (new Block(112, 224, Material.field_76246_e)).func_71848_c(2.0F).func_71894_b(10F).func_71884_a(field_71976_h).func_71864_b("netherBrick").func_71849_a(CreativeTabs.field_78030_b);
        field_72098_bB = (new BlockFence(113, 224, Material.field_76246_e)).func_71848_c(2.0F).func_71894_b(10F).func_71884_a(field_71976_h).func_71864_b("netherFence");
        field_72100_bC = (new BlockStairs(114, field_72033_bA, 0)).func_71864_b("stairsNetherBrick").func_71912_p();
        field_72102_bH = (new BlockEndPortal(119, Material.field_76237_B)).func_71848_c(-1F).func_71894_b(6000000F);
        field_72104_bI = (new BlockEndPortalFrame(120)).func_71884_a(field_71974_j).func_71900_a(0.125F).func_71848_c(-1F).func_71864_b("endPortalFrame").func_71912_p().func_71894_b(6000000F).func_71849_a(CreativeTabs.field_78031_c);
        field_72082_bJ = (new Block(121, 175, Material.field_76246_e)).func_71848_c(3F).func_71894_b(15F).func_71884_a(field_71976_h).func_71864_b("whiteStone").func_71849_a(CreativeTabs.field_78030_b);
        field_72084_bK = (new BlockDragonEgg(122, 167)).func_71848_c(3F).func_71894_b(15F).func_71884_a(field_71976_h).func_71900_a(0.125F).func_71864_b("dragonEgg");
        field_72078_bL = (new BlockRedstoneLight(123, false)).func_71848_c(0.3F).func_71884_a(field_71974_j).func_71864_b("redstoneLight").func_71849_a(CreativeTabs.field_78028_d);
        field_72080_bM = (new BlockRedstoneLight(124, true)).func_71848_c(0.3F).func_71884_a(field_71974_j).func_71864_b("redstoneLight");
        field_72090_bN = (BlockHalfSlab)(new BlockWoodSlab(125, true)).func_71848_c(2.0F).func_71894_b(5F).func_71884_a(field_71967_e).func_71864_b("woodSlab");
        field_72092_bO = (BlockHalfSlab)(new BlockWoodSlab(126, false)).func_71848_c(2.0F).func_71894_b(5F).func_71884_a(field_71967_e).func_71864_b("woodSlab");
        field_72086_bP = (new BlockCocoa(127)).func_71848_c(0.2F).func_71894_b(5F).func_71884_a(field_71967_e).func_71864_b("cocoa").func_71912_p();
        field_72088_bQ = (new BlockStairs(128, field_71957_Q, 0)).func_71864_b("stairsSandStone").func_71912_p();
        field_72068_bR = (new BlockOre(129, 171)).func_71848_c(3F).func_71894_b(5F).func_71884_a(field_71976_h).func_71864_b("oreEmerald");
        field_72066_bS = (new BlockEnderChest(130)).func_71848_c(22.5F).func_71894_b(1000F).func_71884_a(field_71976_h).func_71864_b("enderChest").func_71912_p().func_71900_a(0.5F);
        field_72076_bV = (new BlockOreStorage(133, 25)).func_71848_c(5F).func_71894_b(10F).func_71884_a(field_71977_i).func_71864_b("blockEmerald");
        field_72074_bW = (new BlockStairs(134, field_71988_x, 1)).func_71864_b("stairsWoodSpruce").func_71912_p();
        field_72072_bX = (new BlockStairs(135, field_71988_x, 2)).func_71864_b("stairsWoodBirch").func_71912_p();
        field_72070_bY = (new BlockStairs(136, field_71988_x, 3)).func_71864_b("stairsWoodJungle").func_71912_p();
        Item.field_77698_e[field_72101_ab.field_71990_ca] = (new ItemCloth(field_72101_ab.field_71990_ca - 256)).func_77655_b("cloth");
        Item.field_77698_e[field_71951_J.field_71990_ca] = (new ItemTree(field_71951_J.field_71990_ca - 256, field_71951_J)).func_77655_b("log");
        Item.field_77698_e[field_71988_x.field_71990_ca] = (new ItemWood(field_71988_x.field_71990_ca - 256, field_71988_x)).func_77655_b("wood");
        Item.field_77698_e[field_72006_bl.field_71990_ca] = (new ItemBlockSilverfish(field_72006_bl.field_71990_ca - 256)).func_77655_b("monsterStoneEgg");
        Item.field_77698_e[field_72007_bm.field_71990_ca] = (new ItemSmoothStone(field_72007_bm.field_71990_ca - 256, field_72007_bm)).func_77655_b("stonebricksmooth");
        Item.field_77698_e[field_71957_Q.field_71990_ca] = (new ItemSandStone(field_71957_Q.field_71990_ca - 256, field_71957_Q)).func_77655_b("sandStone");
        Item.field_77698_e[field_72079_ak.field_71990_ca] = (new ItemSlab(field_72079_ak.field_71990_ca - 256, field_72079_ak, field_72085_aj, false)).func_77655_b("stoneSlab");
        Item.field_77698_e[field_72085_aj.field_71990_ca] = (new ItemSlab(field_72085_aj.field_71990_ca - 256, field_72079_ak, field_72085_aj, true)).func_77655_b("stoneSlab");
        Item.field_77698_e[field_72092_bO.field_71990_ca] = (new ItemSlab(field_72092_bO.field_71990_ca - 256, field_72092_bO, field_72090_bN, false)).func_77655_b("woodSlab");
        Item.field_77698_e[field_72090_bN.field_71990_ca] = (new ItemSlab(field_72090_bN.field_71990_ca - 256, field_72092_bO, field_72090_bN, true)).func_77655_b("woodSlab");
        Item.field_77698_e[field_71987_y.field_71990_ca] = (new ItemSapling(field_71987_y.field_71990_ca - 256)).func_77655_b("sapling");
        Item.field_77698_e[field_71952_K.field_71990_ca] = (new ItemLeaves(field_71952_K.field_71990_ca - 256)).func_77655_b("leaves");
        Item.field_77698_e[field_71998_bu.field_71990_ca] = new ItemColored(field_71998_bu.field_71990_ca - 256, false);
        Item.field_77698_e[field_71962_X.field_71990_ca] = (new ItemColored(field_71962_X.field_71990_ca - 256, true)).func_77894_a(new String[] {
            "shrub", "grass", "fern"
        });
        Item.field_77698_e[field_71991_bz.field_71990_ca] = new ItemLilyPad(field_71991_bz.field_71990_ca - 256);
        Item.field_77698_e[field_71963_Z.field_71990_ca] = new ItemPiston(field_71963_Z.field_71990_ca - 256);
        Item.field_77698_e[field_71956_V.field_71990_ca] = new ItemPiston(field_71956_V.field_71990_ca - 256);
        for(int i = 0; i < 256; i++)
        {
            if(field_71973_m[i] == null)
            {
                continue;
            }
            if(Item.field_77698_e[i] == null)
            {
                Item.field_77698_e[i] = new ItemBlock(i - 256);
                field_71973_m[i].func_71928_r_();
            }
            boolean flag = false;
            if(i > 0 && field_71973_m[i].func_71857_b() == 10)
            {
                flag = true;
            }
            if(i > 0 && (field_71973_m[i] instanceof BlockHalfSlab))
            {
                flag = true;
            }
            if(i == field_72050_aA.field_71990_ca)
            {
                flag = true;
            }
            if(field_71985_p[i])
            {
                flag = true;
            }
            if(field_71971_o[i] == 0)
            {
                flag = true;
            }
            field_71982_s[i] = flag;
        }

        field_71985_p[0] = true;
        StatList.func_75922_b();
    }
}
