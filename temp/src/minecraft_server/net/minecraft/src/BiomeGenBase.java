// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            Block, BlockGrass, WorldGenTrees, WorldGenBigTree, 
//            WorldGenForest, WorldGenSwamp, SpawnListEntry, EntitySheep, 
//            EntityPig, EntityChicken, EntityCow, EntitySpider, 
//            EntityZombie, EntitySkeleton, EntityCreeper, EntitySlime, 
//            EntityEnderman, EntitySquid, BiomeDecorator, WorldGenTallGrass, 
//            BlockTallGrass, EnumCreatureType, BiomeGenOcean, BiomeGenPlains, 
//            BiomeGenDesert, BiomeGenHills, BiomeGenForest, BiomeGenTaiga, 
//            BiomeGenSwamp, BiomeGenRiver, BiomeGenHell, BiomeGenEnd, 
//            BiomeGenSnow, BiomeGenMushroomIsland, BiomeGenBeach, BiomeGenJungle, 
//            WorldGenerator, World

public abstract class BiomeGenBase
{

    public static final BiomeGenBase field_76773_a[] = new BiomeGenBase[256];
    public static final BiomeGenBase field_76771_b = (new BiomeGenOcean(0)).func_76739_b(112).func_76735_a("Ocean").func_76725_b(-1F, 0.4F);
    public static final BiomeGenBase field_76772_c = (new BiomeGenPlains(1)).func_76739_b(0x8db360).func_76735_a("Plains").func_76732_a(0.8F, 0.4F);
    public static final BiomeGenBase field_76769_d = (new BiomeGenDesert(2)).func_76739_b(0xfa9418).func_76735_a("Desert").func_76745_m().func_76732_a(2.0F, 0.0F).func_76725_b(0.1F, 0.2F);
    public static final BiomeGenBase field_76770_e = (new BiomeGenHills(3)).func_76739_b(0x606060).func_76735_a("Extreme Hills").func_76725_b(0.3F, 1.5F).func_76732_a(0.2F, 0.3F);
    public static final BiomeGenBase field_76767_f = (new BiomeGenForest(4)).func_76739_b(0x56621).func_76735_a("Forest").func_76733_a(0x4eba31).func_76732_a(0.7F, 0.8F);
    public static final BiomeGenBase field_76768_g = (new BiomeGenTaiga(5)).func_76739_b(0xb6659).func_76735_a("Taiga").func_76733_a(0x4eba31).func_76742_b().func_76732_a(0.05F, 0.8F).func_76725_b(0.1F, 0.4F);
    public static final BiomeGenBase field_76780_h = (new BiomeGenSwamp(6)).func_76739_b(0x7f9b2).func_76735_a("Swampland").func_76733_a(0x8baf48).func_76725_b(-0.2F, 0.1F).func_76732_a(0.8F, 0.9F);
    public static final BiomeGenBase field_76781_i = (new BiomeGenRiver(7)).func_76739_b(255).func_76735_a("River").func_76725_b(-0.5F, 0.0F);
    public static final BiomeGenBase field_76778_j = (new BiomeGenHell(8)).func_76739_b(0xff0000).func_76735_a("Hell").func_76745_m().func_76732_a(2.0F, 0.0F);
    public static final BiomeGenBase field_76779_k = (new BiomeGenEnd(9)).func_76739_b(0x8080ff).func_76735_a("Sky").func_76745_m();
    public static final BiomeGenBase field_76776_l = (new BiomeGenOcean(10)).func_76739_b(0x9090a0).func_76735_a("FrozenOcean").func_76742_b().func_76725_b(-1F, 0.5F).func_76732_a(0.0F, 0.5F);
    public static final BiomeGenBase field_76777_m = (new BiomeGenRiver(11)).func_76739_b(0xa0a0ff).func_76735_a("FrozenRiver").func_76742_b().func_76725_b(-0.5F, 0.0F).func_76732_a(0.0F, 0.5F);
    public static final BiomeGenBase field_76774_n = (new BiomeGenSnow(12)).func_76739_b(0xffffff).func_76735_a("Ice Plains").func_76742_b().func_76732_a(0.0F, 0.5F);
    public static final BiomeGenBase field_76775_o = (new BiomeGenSnow(13)).func_76739_b(0xa0a0a0).func_76735_a("Ice Mountains").func_76742_b().func_76725_b(0.3F, 1.3F).func_76732_a(0.0F, 0.5F);
    public static final BiomeGenBase field_76789_p = (new BiomeGenMushroomIsland(14)).func_76739_b(0xff00ff).func_76735_a("MushroomIsland").func_76732_a(0.9F, 1.0F).func_76725_b(0.2F, 1.0F);
    public static final BiomeGenBase field_76788_q = (new BiomeGenMushroomIsland(15)).func_76739_b(0xa000ff).func_76735_a("MushroomIslandShore").func_76732_a(0.9F, 1.0F).func_76725_b(-1F, 0.1F);
    public static final BiomeGenBase field_76787_r = (new BiomeGenBeach(16)).func_76739_b(0xfade55).func_76735_a("Beach").func_76732_a(0.8F, 0.4F).func_76725_b(0.0F, 0.1F);
    public static final BiomeGenBase field_76786_s = (new BiomeGenDesert(17)).func_76739_b(0xd25f12).func_76735_a("DesertHills").func_76745_m().func_76732_a(2.0F, 0.0F).func_76725_b(0.3F, 0.8F);
    public static final BiomeGenBase field_76785_t = (new BiomeGenForest(18)).func_76739_b(0x22551c).func_76735_a("ForestHills").func_76733_a(0x4eba31).func_76732_a(0.7F, 0.8F).func_76725_b(0.3F, 0.7F);
    public static final BiomeGenBase field_76784_u = (new BiomeGenTaiga(19)).func_76739_b(0x163933).func_76735_a("TaigaHills").func_76742_b().func_76733_a(0x4eba31).func_76732_a(0.05F, 0.8F).func_76725_b(0.3F, 0.8F);
    public static final BiomeGenBase field_76783_v = (new BiomeGenHills(20)).func_76739_b(0x72789a).func_76735_a("Extreme Hills Edge").func_76725_b(0.2F, 0.8F).func_76732_a(0.2F, 0.3F);
    public static final BiomeGenBase field_76782_w = (new BiomeGenJungle(21)).func_76739_b(0x537b09).func_76735_a("Jungle").func_76733_a(0x537b09).func_76732_a(1.2F, 0.9F).func_76725_b(0.2F, 0.4F);
    public static final BiomeGenBase field_76792_x = (new BiomeGenJungle(22)).func_76739_b(0x2c4205).func_76735_a("JungleHills").func_76733_a(0x537b09).func_76732_a(1.2F, 0.9F).func_76725_b(1.8F, 0.5F);
    public String field_76791_y;
    public int field_76790_z;
    public byte field_76752_A;
    public byte field_76753_B;
    public int field_76754_C;
    public float field_76748_D;
    public float field_76749_E;
    public float field_76750_F;
    public float field_76751_G;
    public int field_76759_H;
    public BiomeDecorator field_76760_I;
    protected List field_76761_J;
    protected List field_76762_K;
    protected List field_76755_L;
    private boolean field_76766_R;
    private boolean field_76765_S;
    public final int field_76756_M;
    protected WorldGenTrees field_76757_N;
    protected WorldGenBigTree field_76758_O;
    protected WorldGenForest field_76764_P;
    protected WorldGenSwamp field_76763_Q;

    protected BiomeGenBase(int p_i3747_1_)
    {
        field_76752_A = (byte)Block.field_71980_u.field_71990_ca;
        field_76753_B = (byte)Block.field_71979_v.field_71990_ca;
        field_76754_C = 0x4ee031;
        field_76748_D = 0.1F;
        field_76749_E = 0.3F;
        field_76750_F = 0.5F;
        field_76751_G = 0.5F;
        field_76759_H = 0xffffff;
        field_76761_J = new ArrayList();
        field_76762_K = new ArrayList();
        field_76755_L = new ArrayList();
        field_76765_S = true;
        field_76757_N = new WorldGenTrees(false);
        field_76758_O = new WorldGenBigTree(false);
        field_76764_P = new WorldGenForest(false);
        field_76763_Q = new WorldGenSwamp();
        field_76756_M = p_i3747_1_;
        field_76773_a[p_i3747_1_] = this;
        field_76760_I = func_76729_a();
        field_76762_K.add(new SpawnListEntry(net.minecraft.src.EntitySheep.class, 12, 4, 4));
        field_76762_K.add(new SpawnListEntry(net.minecraft.src.EntityPig.class, 10, 4, 4));
        field_76762_K.add(new SpawnListEntry(net.minecraft.src.EntityChicken.class, 10, 4, 4));
        field_76762_K.add(new SpawnListEntry(net.minecraft.src.EntityCow.class, 8, 4, 4));
        field_76761_J.add(new SpawnListEntry(net.minecraft.src.EntitySpider.class, 10, 4, 4));
        field_76761_J.add(new SpawnListEntry(net.minecraft.src.EntityZombie.class, 10, 4, 4));
        field_76761_J.add(new SpawnListEntry(net.minecraft.src.EntitySkeleton.class, 10, 4, 4));
        field_76761_J.add(new SpawnListEntry(net.minecraft.src.EntityCreeper.class, 10, 4, 4));
        field_76761_J.add(new SpawnListEntry(net.minecraft.src.EntitySlime.class, 10, 4, 4));
        field_76761_J.add(new SpawnListEntry(net.minecraft.src.EntityEnderman.class, 1, 1, 4));
        field_76755_L.add(new SpawnListEntry(net.minecraft.src.EntitySquid.class, 10, 4, 4));
    }

    protected BiomeDecorator func_76729_a()
    {
        return new BiomeDecorator(this);
    }

    private BiomeGenBase func_76732_a(float p_76732_1_, float p_76732_2_)
    {
        if(p_76732_1_ > 0.1F && p_76732_1_ < 0.2F)
        {
            throw new IllegalArgumentException("Please avoid temperatures in the range 0.1 - 0.2 because of snow");
        } else
        {
            field_76750_F = p_76732_1_;
            field_76751_G = p_76732_2_;
            return this;
        }
    }

    private BiomeGenBase func_76725_b(float p_76725_1_, float p_76725_2_)
    {
        field_76748_D = p_76725_1_;
        field_76749_E = p_76725_2_;
        return this;
    }

    private BiomeGenBase func_76745_m()
    {
        field_76765_S = false;
        return this;
    }

    public WorldGenerator func_76740_a(Random p_76740_1_)
    {
        if(p_76740_1_.nextInt(10) == 0)
        {
            return field_76758_O;
        } else
        {
            return field_76757_N;
        }
    }

    public WorldGenerator func_76730_b(Random p_76730_1_)
    {
        return new WorldGenTallGrass(Block.field_71962_X.field_71990_ca, 1);
    }

    protected BiomeGenBase func_76742_b()
    {
        field_76766_R = true;
        return this;
    }

    protected BiomeGenBase func_76735_a(String p_76735_1_)
    {
        field_76791_y = p_76735_1_;
        return this;
    }

    protected BiomeGenBase func_76733_a(int p_76733_1_)
    {
        field_76754_C = p_76733_1_;
        return this;
    }

    protected BiomeGenBase func_76739_b(int p_76739_1_)
    {
        field_76790_z = p_76739_1_;
        return this;
    }

    public List func_76747_a(EnumCreatureType p_76747_1_)
    {
        if(p_76747_1_ == EnumCreatureType.monster)
        {
            return field_76761_J;
        }
        if(p_76747_1_ == EnumCreatureType.creature)
        {
            return field_76762_K;
        }
        if(p_76747_1_ == EnumCreatureType.waterCreature)
        {
            return field_76755_L;
        } else
        {
            return null;
        }
    }

    public boolean func_76746_c()
    {
        return field_76766_R;
    }

    public boolean func_76738_d()
    {
        if(field_76766_R)
        {
            return false;
        } else
        {
            return field_76765_S;
        }
    }

    public boolean func_76736_e()
    {
        return field_76751_G > 0.85F;
    }

    public float func_76741_f()
    {
        return 0.1F;
    }

    public final int func_76744_g()
    {
        return (int)(field_76751_G * 65536F);
    }

    public final int func_76734_h()
    {
        return (int)(field_76750_F * 65536F);
    }

    public final float func_76743_j()
    {
        return field_76750_F;
    }

    public void func_76728_a(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_)
    {
        field_76760_I.func_76796_a(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
    }

}
