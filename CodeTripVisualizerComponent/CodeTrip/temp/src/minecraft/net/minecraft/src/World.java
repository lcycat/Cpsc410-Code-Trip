// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            IBlockAccess, WorldProvider, Chunk, WorldChunkManager, 
//            VillageCollection, VillageSiege, WorldInfo, MapStorage, 
//            ISaveHandler, Block, IChunkProvider, Profiler, 
//            Material, IWorldAccess, EnumSkyBlock, BlockHalfSlab, 
//            Vec3, MathHelper, Vec3Pool, Entity, 
//            EntityPlayer, AxisAlignedBB, BiomeGenBase, TileEntity, 
//            BlockFire, BlockFluid, Explosion, BlockStairs, 
//            ChunkCoordIntPair, ChunkCache, PathFinder, PlayerCapabilities, 
//            MinecraftException, ChunkCoordinates, WorldType, CallableLvl1, 
//            CrashReport, CallableLvl2, CallableLvl3, WorldSettings, 
//            MovingObjectPosition, PathEntity, WorldSavedData, ChunkPosition

public abstract class World
    implements IBlockAccess
{

    public boolean field_72999_e;
    public List field_72996_f;
    protected List field_72997_g;
    public List field_73009_h;
    private List field_73002_a;
    private List field_73000_b;
    public List field_73010_i;
    public List field_73007_j;
    private long field_73001_c;
    public int field_73008_k;
    protected int field_73005_l;
    protected final int field_73006_m = 0x3c6ef35f;
    protected float field_73003_n;
    protected float field_73004_o;
    protected float field_73018_p;
    protected float field_73017_q;
    protected int field_73016_r;
    public int field_73015_s;
    public boolean field_73014_t;
    public int field_73013_u;
    public Random field_73012_v;
    public final WorldProvider field_73011_w;
    protected List field_73021_x;
    protected IChunkProvider field_73020_y;
    protected final ISaveHandler field_73019_z;
    protected WorldInfo field_72986_A;
    public boolean field_72987_B;
    public MapStorage field_72988_C;
    public final VillageCollection field_72982_D;
    protected final VillageSiege field_72983_E;
    public final Profiler field_72984_F;
    private ArrayList field_72998_d;
    private boolean field_72989_L;
    protected boolean field_72985_G;
    protected boolean field_72992_H;
    protected Set field_72993_I;
    private int field_72990_M;
    int field_72994_J[];
    private List field_72991_N;
    public boolean field_72995_K;

    public BiomeGenBase func_72807_a(int p_72807_1_, int p_72807_2_)
    {
        if(func_72899_e(p_72807_1_, 0, p_72807_2_))
        {
            Chunk chunk = func_72938_d(p_72807_1_, p_72807_2_);
            if(chunk != null)
            {
                return chunk.func_76591_a(p_72807_1_ & 0xf, p_72807_2_ & 0xf, field_73011_w.field_76578_c);
            }
        }
        return field_73011_w.field_76578_c.func_76935_a(p_72807_1_, p_72807_2_);
    }

    public WorldChunkManager func_72959_q()
    {
        return field_73011_w.field_76578_c;
    }

    public World(ISaveHandler p_i3731_1_, String p_i3731_2_, WorldProvider p_i3731_3_, WorldSettings p_i3731_4_, Profiler p_i3731_5_)
    {
        field_72999_e = false;
        field_72996_f = new ArrayList();
        field_72997_g = new ArrayList();
        field_73009_h = new ArrayList();
        field_73002_a = new ArrayList();
        field_73000_b = new ArrayList();
        field_73010_i = new ArrayList();
        field_73007_j = new ArrayList();
        field_73001_c = 0xffffffL;
        field_73008_k = 0;
        field_73005_l = (new Random()).nextInt();
        field_73016_r = 0;
        field_73015_s = 0;
        field_73014_t = false;
        field_73012_v = new Random();
        field_73021_x = new ArrayList();
        field_72982_D = new VillageCollection(this);
        field_72983_E = new VillageSiege(this);
        field_72998_d = new ArrayList();
        field_72985_G = true;
        field_72992_H = true;
        field_72993_I = new HashSet();
        field_72990_M = field_73012_v.nextInt(12000);
        field_72994_J = new int[32768];
        field_72991_N = new ArrayList();
        field_72995_K = false;
        field_73019_z = p_i3731_1_;
        field_72984_F = p_i3731_5_;
        field_72986_A = new WorldInfo(p_i3731_4_, p_i3731_2_);
        field_73011_w = p_i3731_3_;
        field_72988_C = new MapStorage(p_i3731_1_);
        p_i3731_3_.func_76558_a(this);
        field_73020_y = func_72970_h();
        func_72966_v();
        func_72947_a();
    }

    public World(ISaveHandler p_i3732_1_, String p_i3732_2_, WorldSettings p_i3732_3_, WorldProvider p_i3732_4_, Profiler p_i3732_5_)
    {
        field_72999_e = false;
        field_72996_f = new ArrayList();
        field_72997_g = new ArrayList();
        field_73009_h = new ArrayList();
        field_73002_a = new ArrayList();
        field_73000_b = new ArrayList();
        field_73010_i = new ArrayList();
        field_73007_j = new ArrayList();
        field_73001_c = 0xffffffL;
        field_73008_k = 0;
        field_73005_l = (new Random()).nextInt();
        field_73016_r = 0;
        field_73015_s = 0;
        field_73014_t = false;
        field_73012_v = new Random();
        field_73021_x = new ArrayList();
        field_72982_D = new VillageCollection(this);
        field_72983_E = new VillageSiege(this);
        field_72998_d = new ArrayList();
        field_72985_G = true;
        field_72992_H = true;
        field_72993_I = new HashSet();
        field_72990_M = field_73012_v.nextInt(12000);
        field_72994_J = new int[32768];
        field_72991_N = new ArrayList();
        field_72995_K = false;
        field_73019_z = p_i3732_1_;
        field_72984_F = p_i3732_5_;
        field_72988_C = new MapStorage(p_i3732_1_);
        field_72986_A = p_i3732_1_.func_75757_d();
        if(p_i3732_4_ != null)
        {
            field_73011_w = p_i3732_4_;
        } else
        if(field_72986_A != null && field_72986_A.func_76076_i() != 0)
        {
            field_73011_w = WorldProvider.func_76570_a(field_72986_A.func_76076_i());
        } else
        {
            field_73011_w = WorldProvider.func_76570_a(0);
        }
        if(field_72986_A == null)
        {
            field_72986_A = new WorldInfo(p_i3732_3_, p_i3732_2_);
        } else
        {
            field_72986_A.func_76062_a(p_i3732_2_);
        }
        field_73011_w.func_76558_a(this);
        field_73020_y = func_72970_h();
        if(!field_72986_A.func_76070_v())
        {
            func_72963_a(p_i3732_3_);
            field_72986_A.func_76091_d(true);
        }
        func_72966_v();
        func_72947_a();
    }

    protected abstract IChunkProvider func_72970_h();

    protected void func_72963_a(WorldSettings p_72963_1_)
    {
        field_72986_A.func_76091_d(true);
    }

    public void func_72974_f()
    {
        func_72950_A(8, 64, 8);
    }

    public int func_72922_b(int p_72922_1_, int p_72922_2_)
    {
        int i;
        for(i = 63; !func_72799_c(p_72922_1_, i + 1, p_72922_2_); i++) { }
        return func_72798_a(p_72922_1_, i, p_72922_2_);
    }

    public int func_72798_a(int p_72798_1_, int p_72798_2_, int p_72798_3_)
    {
        if(p_72798_1_ < 0xfe363c80 || p_72798_3_ < 0xfe363c80 || p_72798_1_ >= 0x1c9c380 || p_72798_3_ >= 0x1c9c380)
        {
            return 0;
        }
        if(p_72798_2_ < 0)
        {
            return 0;
        }
        if(p_72798_2_ >= 256)
        {
            return 0;
        } else
        {
            return func_72964_e(p_72798_1_ >> 4, p_72798_3_ >> 4).func_76610_a(p_72798_1_ & 0xf, p_72798_2_, p_72798_3_ & 0xf);
        }
    }

    public int func_72952_b(int p_72952_1_, int p_72952_2_, int p_72952_3_)
    {
        if(p_72952_1_ < 0xfe363c80 || p_72952_3_ < 0xfe363c80 || p_72952_1_ >= 0x1c9c380 || p_72952_3_ >= 0x1c9c380)
        {
            return 0;
        }
        if(p_72952_2_ < 0)
        {
            return 0;
        }
        if(p_72952_2_ >= 256)
        {
            return 0;
        } else
        {
            return func_72964_e(p_72952_1_ >> 4, p_72952_3_ >> 4).func_76596_b(p_72952_1_ & 0xf, p_72952_2_, p_72952_3_ & 0xf);
        }
    }

    public boolean func_72799_c(int p_72799_1_, int p_72799_2_, int p_72799_3_)
    {
        return func_72798_a(p_72799_1_, p_72799_2_, p_72799_3_) == 0;
    }

    public boolean func_72927_d(int p_72927_1_, int p_72927_2_, int p_72927_3_)
    {
        int i = func_72798_a(p_72927_1_, p_72927_2_, p_72927_3_);
        return Block.field_71973_m[i] != null && Block.field_71973_m[i].func_71887_s();
    }

    public boolean func_72899_e(int p_72899_1_, int p_72899_2_, int p_72899_3_)
    {
        if(p_72899_2_ < 0 || p_72899_2_ >= 256)
        {
            return false;
        } else
        {
            return func_72916_c(p_72899_1_ >> 4, p_72899_3_ >> 4);
        }
    }

    public boolean func_72873_a(int p_72873_1_, int p_72873_2_, int p_72873_3_, int p_72873_4_)
    {
        return func_72904_c(p_72873_1_ - p_72873_4_, p_72873_2_ - p_72873_4_, p_72873_3_ - p_72873_4_, p_72873_1_ + p_72873_4_, p_72873_2_ + p_72873_4_, p_72873_3_ + p_72873_4_);
    }

    public boolean func_72904_c(int p_72904_1_, int p_72904_2_, int p_72904_3_, int p_72904_4_, int p_72904_5_, int p_72904_6_)
    {
        if(p_72904_5_ < 0 || p_72904_2_ >= 256)
        {
            return false;
        }
        p_72904_1_ >>= 4;
        p_72904_3_ >>= 4;
        p_72904_4_ >>= 4;
        p_72904_6_ >>= 4;
        for(int i = p_72904_1_; i <= p_72904_4_; i++)
        {
            for(int j = p_72904_3_; j <= p_72904_6_; j++)
            {
                if(!func_72916_c(i, j))
                {
                    return false;
                }
            }

        }

        return true;
    }

    protected boolean func_72916_c(int p_72916_1_, int p_72916_2_)
    {
        return field_73020_y.func_73149_a(p_72916_1_, p_72916_2_);
    }

    public Chunk func_72938_d(int p_72938_1_, int p_72938_2_)
    {
        return func_72964_e(p_72938_1_ >> 4, p_72938_2_ >> 4);
    }

    public Chunk func_72964_e(int p_72964_1_, int p_72964_2_)
    {
        return field_73020_y.func_73154_d(p_72964_1_, p_72964_2_);
    }

    public boolean func_72961_c(int p_72961_1_, int p_72961_2_, int p_72961_3_, int p_72961_4_, int p_72961_5_)
    {
        return func_72930_a(p_72961_1_, p_72961_2_, p_72961_3_, p_72961_4_, p_72961_5_, true);
    }

    public boolean func_72930_a(int p_72930_1_, int p_72930_2_, int p_72930_3_, int p_72930_4_, int p_72930_5_, boolean p_72930_6_)
    {
        if(p_72930_1_ < 0xfe363c80 || p_72930_3_ < 0xfe363c80 || p_72930_1_ >= 0x1c9c380 || p_72930_3_ >= 0x1c9c380)
        {
            return false;
        }
        if(p_72930_2_ < 0)
        {
            return false;
        }
        if(p_72930_2_ >= 256)
        {
            return false;
        }
        Chunk chunk = func_72964_e(p_72930_1_ >> 4, p_72930_3_ >> 4);
        boolean flag = chunk.func_76592_a(p_72930_1_ & 0xf, p_72930_2_, p_72930_3_ & 0xf, p_72930_4_, p_72930_5_);
        field_72984_F.func_76320_a("checkLight");
        func_72969_x(p_72930_1_, p_72930_2_, p_72930_3_);
        field_72984_F.func_76319_b();
        if(p_72930_6_ && flag && (field_72995_K || chunk.field_76642_o))
        {
            func_72845_h(p_72930_1_, p_72930_2_, p_72930_3_);
        }
        return flag;
    }

    public boolean func_72822_b(int p_72822_1_, int p_72822_2_, int p_72822_3_, int p_72822_4_)
    {
        if(p_72822_1_ < 0xfe363c80 || p_72822_3_ < 0xfe363c80 || p_72822_1_ >= 0x1c9c380 || p_72822_3_ >= 0x1c9c380)
        {
            return false;
        }
        if(p_72822_2_ < 0)
        {
            return false;
        }
        if(p_72822_2_ >= 256)
        {
            return false;
        }
        Chunk chunk = func_72964_e(p_72822_1_ >> 4, p_72822_3_ >> 4);
        boolean flag = chunk.func_76598_a(p_72822_1_ & 0xf, p_72822_2_, p_72822_3_ & 0xf, p_72822_4_);
        field_72984_F.func_76320_a("checkLight");
        func_72969_x(p_72822_1_, p_72822_2_, p_72822_3_);
        field_72984_F.func_76319_b();
        if(flag && (field_72995_K || chunk.field_76642_o))
        {
            func_72845_h(p_72822_1_, p_72822_2_, p_72822_3_);
        }
        return flag;
    }

    public Material func_72803_f(int p_72803_1_, int p_72803_2_, int p_72803_3_)
    {
        int i = func_72798_a(p_72803_1_, p_72803_2_, p_72803_3_);
        if(i == 0)
        {
            return Material.field_76249_a;
        } else
        {
            return Block.field_71973_m[i].field_72018_cp;
        }
    }

    public int func_72805_g(int p_72805_1_, int p_72805_2_, int p_72805_3_)
    {
        if(p_72805_1_ < 0xfe363c80 || p_72805_3_ < 0xfe363c80 || p_72805_1_ >= 0x1c9c380 || p_72805_3_ >= 0x1c9c380)
        {
            return 0;
        }
        if(p_72805_2_ < 0)
        {
            return 0;
        }
        if(p_72805_2_ >= 256)
        {
            return 0;
        } else
        {
            Chunk chunk = func_72964_e(p_72805_1_ >> 4, p_72805_3_ >> 4);
            p_72805_1_ &= 0xf;
            p_72805_3_ &= 0xf;
            return chunk.func_76628_c(p_72805_1_, p_72805_2_, p_72805_3_);
        }
    }

    public void func_72921_c(int p_72921_1_, int p_72921_2_, int p_72921_3_, int p_72921_4_)
    {
        if(func_72881_d(p_72921_1_, p_72921_2_, p_72921_3_, p_72921_4_))
        {
            func_72851_f(p_72921_1_, p_72921_2_, p_72921_3_, func_72798_a(p_72921_1_, p_72921_2_, p_72921_3_));
        }
    }

    public boolean func_72881_d(int p_72881_1_, int p_72881_2_, int p_72881_3_, int p_72881_4_)
    {
        if(p_72881_1_ < 0xfe363c80 || p_72881_3_ < 0xfe363c80 || p_72881_1_ >= 0x1c9c380 || p_72881_3_ >= 0x1c9c380)
        {
            return false;
        }
        if(p_72881_2_ < 0)
        {
            return false;
        }
        if(p_72881_2_ >= 256)
        {
            return false;
        }
        Chunk chunk = func_72964_e(p_72881_1_ >> 4, p_72881_3_ >> 4);
        int i = p_72881_1_ & 0xf;
        int j = p_72881_3_ & 0xf;
        boolean flag = chunk.func_76589_b(i, p_72881_2_, j, p_72881_4_);
        if(flag && (field_72995_K || chunk.field_76642_o && Block.field_71983_r[chunk.func_76610_a(i, p_72881_2_, j) & 0xfff]))
        {
            func_72845_h(p_72881_1_, p_72881_2_, p_72881_3_);
        }
        return flag;
    }

    public boolean func_72859_e(int p_72859_1_, int p_72859_2_, int p_72859_3_, int p_72859_4_)
    {
        if(func_72822_b(p_72859_1_, p_72859_2_, p_72859_3_, p_72859_4_))
        {
            func_72851_f(p_72859_1_, p_72859_2_, p_72859_3_, p_72859_4_);
            return true;
        } else
        {
            return false;
        }
    }

    public boolean func_72832_d(int p_72832_1_, int p_72832_2_, int p_72832_3_, int p_72832_4_, int p_72832_5_)
    {
        if(func_72961_c(p_72832_1_, p_72832_2_, p_72832_3_, p_72832_4_, p_72832_5_))
        {
            func_72851_f(p_72832_1_, p_72832_2_, p_72832_3_, p_72832_4_);
            return true;
        } else
        {
            return false;
        }
    }

    public void func_72845_h(int p_72845_1_, int p_72845_2_, int p_72845_3_)
    {
        IWorldAccess iworldaccess;
        for(Iterator iterator = field_73021_x.iterator(); iterator.hasNext(); iworldaccess.func_72710_a(p_72845_1_, p_72845_2_, p_72845_3_))
        {
            iworldaccess = (IWorldAccess)iterator.next();
        }

    }

    public void func_72851_f(int p_72851_1_, int p_72851_2_, int p_72851_3_, int p_72851_4_)
    {
        func_72898_h(p_72851_1_, p_72851_2_, p_72851_3_, p_72851_4_);
    }

    public void func_72975_g(int p_72975_1_, int p_72975_2_, int p_72975_3_, int p_72975_4_)
    {
        if(p_72975_3_ > p_72975_4_)
        {
            int i = p_72975_4_;
            p_72975_4_ = p_72975_3_;
            p_72975_3_ = i;
        }
        if(!field_73011_w.field_76576_e)
        {
            for(int j = p_72975_3_; j <= p_72975_4_; j++)
            {
                func_72936_c(EnumSkyBlock.Sky, p_72975_1_, j, p_72975_2_);
            }

        }
        func_72909_d(p_72975_1_, p_72975_3_, p_72975_2_, p_72975_1_, p_72975_4_, p_72975_2_);
    }

    public void func_72862_i(int p_72862_1_, int p_72862_2_, int p_72862_3_)
    {
        IWorldAccess iworldaccess;
        for(Iterator iterator = field_73021_x.iterator(); iterator.hasNext(); iworldaccess.func_72707_a(p_72862_1_, p_72862_2_, p_72862_3_, p_72862_1_, p_72862_2_, p_72862_3_))
        {
            iworldaccess = (IWorldAccess)iterator.next();
        }

    }

    public void func_72909_d(int p_72909_1_, int p_72909_2_, int p_72909_3_, int p_72909_4_, int p_72909_5_, int p_72909_6_)
    {
        IWorldAccess iworldaccess;
        for(Iterator iterator = field_73021_x.iterator(); iterator.hasNext(); iworldaccess.func_72707_a(p_72909_1_, p_72909_2_, p_72909_3_, p_72909_4_, p_72909_5_, p_72909_6_))
        {
            iworldaccess = (IWorldAccess)iterator.next();
        }

    }

    public void func_72898_h(int p_72898_1_, int p_72898_2_, int p_72898_3_, int p_72898_4_)
    {
        func_72821_m(p_72898_1_ - 1, p_72898_2_, p_72898_3_, p_72898_4_);
        func_72821_m(p_72898_1_ + 1, p_72898_2_, p_72898_3_, p_72898_4_);
        func_72821_m(p_72898_1_, p_72898_2_ - 1, p_72898_3_, p_72898_4_);
        func_72821_m(p_72898_1_, p_72898_2_ + 1, p_72898_3_, p_72898_4_);
        func_72821_m(p_72898_1_, p_72898_2_, p_72898_3_ - 1, p_72898_4_);
        func_72821_m(p_72898_1_, p_72898_2_, p_72898_3_ + 1, p_72898_4_);
    }

    private void func_72821_m(int p_72821_1_, int p_72821_2_, int p_72821_3_, int p_72821_4_)
    {
        if(field_73014_t || field_72995_K)
        {
            return;
        }
        Block block = Block.field_71973_m[func_72798_a(p_72821_1_, p_72821_2_, p_72821_3_)];
        if(block != null)
        {
            block.func_71863_a(this, p_72821_1_, p_72821_2_, p_72821_3_, p_72821_4_);
        }
    }

    public boolean func_72937_j(int p_72937_1_, int p_72937_2_, int p_72937_3_)
    {
        return func_72964_e(p_72937_1_ >> 4, p_72937_3_ >> 4).func_76619_d(p_72937_1_ & 0xf, p_72937_2_, p_72937_3_ & 0xf);
    }

    public int func_72883_k(int p_72883_1_, int p_72883_2_, int p_72883_3_)
    {
        if(p_72883_2_ < 0)
        {
            return 0;
        }
        if(p_72883_2_ >= 256)
        {
            p_72883_2_ = 255;
        }
        return func_72964_e(p_72883_1_ >> 4, p_72883_3_ >> 4).func_76629_c(p_72883_1_ & 0xf, p_72883_2_, p_72883_3_ & 0xf, 0);
    }

    public int func_72957_l(int p_72957_1_, int p_72957_2_, int p_72957_3_)
    {
        return func_72849_a(p_72957_1_, p_72957_2_, p_72957_3_, true);
    }

    public int func_72849_a(int p_72849_1_, int p_72849_2_, int p_72849_3_, boolean p_72849_4_)
    {
        if(p_72849_1_ < 0xfe363c80 || p_72849_3_ < 0xfe363c80 || p_72849_1_ >= 0x1c9c380 || p_72849_3_ >= 0x1c9c380)
        {
            return 15;
        }
        if(p_72849_4_)
        {
            int i = func_72798_a(p_72849_1_, p_72849_2_, p_72849_3_);
            if(i == Block.field_72079_ak.field_71990_ca || i == Block.field_72092_bO.field_71990_ca || i == Block.field_72050_aA.field_71990_ca || i == Block.field_72057_aH.field_71990_ca || i == Block.field_72063_at.field_71990_ca)
            {
                int j = func_72849_a(p_72849_1_, p_72849_2_ + 1, p_72849_3_, false);
                int k = func_72849_a(p_72849_1_ + 1, p_72849_2_, p_72849_3_, false);
                int l = func_72849_a(p_72849_1_ - 1, p_72849_2_, p_72849_3_, false);
                int i1 = func_72849_a(p_72849_1_, p_72849_2_, p_72849_3_ + 1, false);
                int j1 = func_72849_a(p_72849_1_, p_72849_2_, p_72849_3_ - 1, false);
                if(k > j)
                {
                    j = k;
                }
                if(l > j)
                {
                    j = l;
                }
                if(i1 > j)
                {
                    j = i1;
                }
                if(j1 > j)
                {
                    j = j1;
                }
                return j;
            }
        }
        if(p_72849_2_ < 0)
        {
            return 0;
        }
        if(p_72849_2_ >= 256)
        {
            p_72849_2_ = 255;
        }
        Chunk chunk = func_72964_e(p_72849_1_ >> 4, p_72849_3_ >> 4);
        p_72849_1_ &= 0xf;
        p_72849_3_ &= 0xf;
        return chunk.func_76629_c(p_72849_1_, p_72849_2_, p_72849_3_, field_73008_k);
    }

    public int func_72976_f(int p_72976_1_, int p_72976_2_)
    {
        if(p_72976_1_ < 0xfe363c80 || p_72976_2_ < 0xfe363c80 || p_72976_1_ >= 0x1c9c380 || p_72976_2_ >= 0x1c9c380)
        {
            return 0;
        }
        if(!func_72916_c(p_72976_1_ >> 4, p_72976_2_ >> 4))
        {
            return 0;
        } else
        {
            Chunk chunk = func_72964_e(p_72976_1_ >> 4, p_72976_2_ >> 4);
            return chunk.func_76611_b(p_72976_1_ & 0xf, p_72976_2_ & 0xf);
        }
    }

    public int func_72925_a(EnumSkyBlock p_72925_1_, int p_72925_2_, int p_72925_3_, int p_72925_4_)
    {
        if(field_73011_w.field_76576_e && p_72925_1_ == EnumSkyBlock.Sky)
        {
            return 0;
        }
        if(p_72925_3_ < 0)
        {
            p_72925_3_ = 0;
        }
        if(p_72925_3_ >= 256)
        {
            return p_72925_1_.field_77198_c;
        }
        if(p_72925_2_ < 0xfe363c80 || p_72925_4_ < 0xfe363c80 || p_72925_2_ >= 0x1c9c380 || p_72925_4_ >= 0x1c9c380)
        {
            return p_72925_1_.field_77198_c;
        }
        int i = p_72925_2_ >> 4;
        int j = p_72925_4_ >> 4;
        if(!func_72916_c(i, j))
        {
            return p_72925_1_.field_77198_c;
        }
        if(Block.field_71982_s[func_72798_a(p_72925_2_, p_72925_3_, p_72925_4_)])
        {
            int k = func_72972_b(p_72925_1_, p_72925_2_, p_72925_3_ + 1, p_72925_4_);
            int l = func_72972_b(p_72925_1_, p_72925_2_ + 1, p_72925_3_, p_72925_4_);
            int i1 = func_72972_b(p_72925_1_, p_72925_2_ - 1, p_72925_3_, p_72925_4_);
            int j1 = func_72972_b(p_72925_1_, p_72925_2_, p_72925_3_, p_72925_4_ + 1);
            int k1 = func_72972_b(p_72925_1_, p_72925_2_, p_72925_3_, p_72925_4_ - 1);
            if(l > k)
            {
                k = l;
            }
            if(i1 > k)
            {
                k = i1;
            }
            if(j1 > k)
            {
                k = j1;
            }
            if(k1 > k)
            {
                k = k1;
            }
            return k;
        } else
        {
            Chunk chunk = func_72964_e(i, j);
            return chunk.func_76614_a(p_72925_1_, p_72925_2_ & 0xf, p_72925_3_, p_72925_4_ & 0xf);
        }
    }

    public int func_72972_b(EnumSkyBlock p_72972_1_, int p_72972_2_, int p_72972_3_, int p_72972_4_)
    {
        if(p_72972_3_ < 0)
        {
            p_72972_3_ = 0;
        }
        if(p_72972_3_ >= 256)
        {
            p_72972_3_ = 255;
        }
        if(p_72972_2_ < 0xfe363c80 || p_72972_4_ < 0xfe363c80 || p_72972_2_ >= 0x1c9c380 || p_72972_4_ >= 0x1c9c380)
        {
            return p_72972_1_.field_77198_c;
        }
        int i = p_72972_2_ >> 4;
        int j = p_72972_4_ >> 4;
        if(!func_72916_c(i, j))
        {
            return p_72972_1_.field_77198_c;
        } else
        {
            Chunk chunk = func_72964_e(i, j);
            return chunk.func_76614_a(p_72972_1_, p_72972_2_ & 0xf, p_72972_3_, p_72972_4_ & 0xf);
        }
    }

    public void func_72915_b(EnumSkyBlock p_72915_1_, int p_72915_2_, int p_72915_3_, int p_72915_4_, int p_72915_5_)
    {
        if(p_72915_2_ < 0xfe363c80 || p_72915_4_ < 0xfe363c80 || p_72915_2_ >= 0x1c9c380 || p_72915_4_ >= 0x1c9c380)
        {
            return;
        }
        if(p_72915_3_ < 0)
        {
            return;
        }
        if(p_72915_3_ >= 256)
        {
            return;
        }
        if(!func_72916_c(p_72915_2_ >> 4, p_72915_4_ >> 4))
        {
            return;
        }
        Chunk chunk = func_72964_e(p_72915_2_ >> 4, p_72915_4_ >> 4);
        chunk.func_76633_a(p_72915_1_, p_72915_2_ & 0xf, p_72915_3_, p_72915_4_ & 0xf, p_72915_5_);
        IWorldAccess iworldaccess;
        for(Iterator iterator = field_73021_x.iterator(); iterator.hasNext(); iworldaccess.func_72711_b(p_72915_2_, p_72915_3_, p_72915_4_))
        {
            iworldaccess = (IWorldAccess)iterator.next();
        }

    }

    public void func_72902_n(int p_72902_1_, int p_72902_2_, int p_72902_3_)
    {
        IWorldAccess iworldaccess;
        for(Iterator iterator = field_73021_x.iterator(); iterator.hasNext(); iworldaccess.func_72711_b(p_72902_1_, p_72902_2_, p_72902_3_))
        {
            iworldaccess = (IWorldAccess)iterator.next();
        }

    }

    public int func_72802_i(int p_72802_1_, int p_72802_2_, int p_72802_3_, int p_72802_4_)
    {
        int i = func_72925_a(EnumSkyBlock.Sky, p_72802_1_, p_72802_2_, p_72802_3_);
        int j = func_72925_a(EnumSkyBlock.Block, p_72802_1_, p_72802_2_, p_72802_3_);
        if(j < p_72802_4_)
        {
            j = p_72802_4_;
        }
        return i << 20 | j << 4;
    }

    public float func_72808_j(int p_72808_1_, int p_72808_2_, int p_72808_3_, int p_72808_4_)
    {
        int i = func_72957_l(p_72808_1_, p_72808_2_, p_72808_3_);
        if(i < p_72808_4_)
        {
            i = p_72808_4_;
        }
        return field_73011_w.field_76573_f[i];
    }

    public float func_72801_o(int p_72801_1_, int p_72801_2_, int p_72801_3_)
    {
        return field_73011_w.field_76573_f[func_72957_l(p_72801_1_, p_72801_2_, p_72801_3_)];
    }

    public boolean func_72935_r()
    {
        return field_73008_k < 4;
    }

    public MovingObjectPosition func_72933_a(Vec3 p_72933_1_, Vec3 p_72933_2_)
    {
        return func_72831_a(p_72933_1_, p_72933_2_, false, false);
    }

    public MovingObjectPosition func_72901_a(Vec3 p_72901_1_, Vec3 p_72901_2_, boolean p_72901_3_)
    {
        return func_72831_a(p_72901_1_, p_72901_2_, p_72901_3_, false);
    }

    public MovingObjectPosition func_72831_a(Vec3 p_72831_1_, Vec3 p_72831_2_, boolean p_72831_3_, boolean p_72831_4_)
    {
        if(Double.isNaN(p_72831_1_.field_72450_a) || Double.isNaN(p_72831_1_.field_72448_b) || Double.isNaN(p_72831_1_.field_72449_c))
        {
            return null;
        }
        if(Double.isNaN(p_72831_2_.field_72450_a) || Double.isNaN(p_72831_2_.field_72448_b) || Double.isNaN(p_72831_2_.field_72449_c))
        {
            return null;
        }
        int i = MathHelper.func_76128_c(p_72831_2_.field_72450_a);
        int j = MathHelper.func_76128_c(p_72831_2_.field_72448_b);
        int k = MathHelper.func_76128_c(p_72831_2_.field_72449_c);
        int l = MathHelper.func_76128_c(p_72831_1_.field_72450_a);
        int i1 = MathHelper.func_76128_c(p_72831_1_.field_72448_b);
        int j1 = MathHelper.func_76128_c(p_72831_1_.field_72449_c);
        int k1 = func_72798_a(l, i1, j1);
        int i2 = func_72805_g(l, i1, j1);
        Block block = Block.field_71973_m[k1];
        if((!p_72831_4_ || block == null || block.func_71872_e(this, l, i1, j1) != null) && k1 > 0 && block.func_71913_a(i2, p_72831_3_))
        {
            MovingObjectPosition movingobjectposition = block.func_71878_a(this, l, i1, j1, p_72831_1_, p_72831_2_);
            if(movingobjectposition != null)
            {
                return movingobjectposition;
            }
        }
        for(int l1 = 200; l1-- >= 0;)
        {
            if(Double.isNaN(p_72831_1_.field_72450_a) || Double.isNaN(p_72831_1_.field_72448_b) || Double.isNaN(p_72831_1_.field_72449_c))
            {
                return null;
            }
            if(l == i && i1 == j && j1 == k)
            {
                return null;
            }
            boolean flag = true;
            boolean flag1 = true;
            boolean flag2 = true;
            double d = 999D;
            double d1 = 999D;
            double d2 = 999D;
            if(i > l)
            {
                d = (double)l + 1.0D;
            } else
            if(i < l)
            {
                d = (double)l + 0.0D;
            } else
            {
                flag = false;
            }
            if(j > i1)
            {
                d1 = (double)i1 + 1.0D;
            } else
            if(j < i1)
            {
                d1 = (double)i1 + 0.0D;
            } else
            {
                flag1 = false;
            }
            if(k > j1)
            {
                d2 = (double)j1 + 1.0D;
            } else
            if(k < j1)
            {
                d2 = (double)j1 + 0.0D;
            } else
            {
                flag2 = false;
            }
            double d3 = 999D;
            double d4 = 999D;
            double d5 = 999D;
            double d6 = p_72831_2_.field_72450_a - p_72831_1_.field_72450_a;
            double d7 = p_72831_2_.field_72448_b - p_72831_1_.field_72448_b;
            double d8 = p_72831_2_.field_72449_c - p_72831_1_.field_72449_c;
            if(flag)
            {
                d3 = (d - p_72831_1_.field_72450_a) / d6;
            }
            if(flag1)
            {
                d4 = (d1 - p_72831_1_.field_72448_b) / d7;
            }
            if(flag2)
            {
                d5 = (d2 - p_72831_1_.field_72449_c) / d8;
            }
            byte byte0 = 0;
            if(d3 < d4 && d3 < d5)
            {
                if(i > l)
                {
                    byte0 = 4;
                } else
                {
                    byte0 = 5;
                }
                p_72831_1_.field_72450_a = d;
                p_72831_1_.field_72448_b += d7 * d3;
                p_72831_1_.field_72449_c += d8 * d3;
            } else
            if(d4 < d5)
            {
                if(j > i1)
                {
                    byte0 = 0;
                } else
                {
                    byte0 = 1;
                }
                p_72831_1_.field_72450_a += d6 * d4;
                p_72831_1_.field_72448_b = d1;
                p_72831_1_.field_72449_c += d8 * d4;
            } else
            {
                if(k > j1)
                {
                    byte0 = 2;
                } else
                {
                    byte0 = 3;
                }
                p_72831_1_.field_72450_a += d6 * d5;
                p_72831_1_.field_72448_b += d7 * d5;
                p_72831_1_.field_72449_c = d2;
            }
            Vec3 vec3 = Vec3.func_72437_a().func_72345_a(p_72831_1_.field_72450_a, p_72831_1_.field_72448_b, p_72831_1_.field_72449_c);
            l = (int)(vec3.field_72450_a = MathHelper.func_76128_c(p_72831_1_.field_72450_a));
            if(byte0 == 5)
            {
                l--;
                vec3.field_72450_a++;
            }
            i1 = (int)(vec3.field_72448_b = MathHelper.func_76128_c(p_72831_1_.field_72448_b));
            if(byte0 == 1)
            {
                i1--;
                vec3.field_72448_b++;
            }
            j1 = (int)(vec3.field_72449_c = MathHelper.func_76128_c(p_72831_1_.field_72449_c));
            if(byte0 == 3)
            {
                j1--;
                vec3.field_72449_c++;
            }
            int j2 = func_72798_a(l, i1, j1);
            int k2 = func_72805_g(l, i1, j1);
            Block block1 = Block.field_71973_m[j2];
            if((!p_72831_4_ || block1 == null || block1.func_71872_e(this, l, i1, j1) != null) && j2 > 0 && block1.func_71913_a(k2, p_72831_3_))
            {
                MovingObjectPosition movingobjectposition1 = block1.func_71878_a(this, l, i1, j1, p_72831_1_, p_72831_2_);
                if(movingobjectposition1 != null)
                {
                    return movingobjectposition1;
                }
            }
        }

        return null;
    }

    public void func_72956_a(Entity p_72956_1_, String p_72956_2_, float p_72956_3_, float p_72956_4_)
    {
        if(p_72956_1_ == null || p_72956_2_ == null)
        {
            return;
        }
        IWorldAccess iworldaccess;
        for(Iterator iterator = field_73021_x.iterator(); iterator.hasNext(); iworldaccess.func_72704_a(p_72956_2_, p_72956_1_.field_70165_t, p_72956_1_.field_70163_u - (double)p_72956_1_.field_70129_M, p_72956_1_.field_70161_v, p_72956_3_, p_72956_4_))
        {
            iworldaccess = (IWorldAccess)iterator.next();
        }

    }

    public void func_72908_a(double p_72908_1_, double p_72908_3_, double p_72908_5_, String p_72908_7_, 
            float p_72908_8_, float p_72908_9_)
    {
        if(p_72908_7_ == null)
        {
            return;
        }
        IWorldAccess iworldaccess;
        for(Iterator iterator = field_73021_x.iterator(); iterator.hasNext(); iworldaccess.func_72704_a(p_72908_7_, p_72908_1_, p_72908_3_, p_72908_5_, p_72908_8_, p_72908_9_))
        {
            iworldaccess = (IWorldAccess)iterator.next();
        }

    }

    public void func_72980_b(double d, double d1, double d2, String s, 
            float f, float f1)
    {
    }

    public void func_72934_a(String p_72934_1_, int p_72934_2_, int p_72934_3_, int p_72934_4_)
    {
        IWorldAccess iworldaccess;
        for(Iterator iterator = field_73021_x.iterator(); iterator.hasNext(); iworldaccess.func_72702_a(p_72934_1_, p_72934_2_, p_72934_3_, p_72934_4_))
        {
            iworldaccess = (IWorldAccess)iterator.next();
        }

    }

    public void func_72869_a(String p_72869_1_, double p_72869_2_, double p_72869_4_, double p_72869_6_, 
            double p_72869_8_, double p_72869_10_, double p_72869_12_)
    {
        IWorldAccess iworldaccess;
        for(Iterator iterator = field_73021_x.iterator(); iterator.hasNext(); iworldaccess.func_72708_a(p_72869_1_, p_72869_2_, p_72869_4_, p_72869_6_, p_72869_8_, p_72869_10_, p_72869_12_))
        {
            iworldaccess = (IWorldAccess)iterator.next();
        }

    }

    public boolean func_72942_c(Entity p_72942_1_)
    {
        field_73007_j.add(p_72942_1_);
        return true;
    }

    public boolean func_72838_d(Entity p_72838_1_)
    {
        int i = MathHelper.func_76128_c(p_72838_1_.field_70165_t / 16D);
        int j = MathHelper.func_76128_c(p_72838_1_.field_70161_v / 16D);
        boolean flag = false;
        if(p_72838_1_ instanceof EntityPlayer)
        {
            flag = true;
        }
        if(flag || func_72916_c(i, j))
        {
            if(p_72838_1_ instanceof EntityPlayer)
            {
                EntityPlayer entityplayer = (EntityPlayer)p_72838_1_;
                field_73010_i.add(entityplayer);
                func_72854_c();
            }
            func_72964_e(i, j).func_76612_a(p_72838_1_);
            field_72996_f.add(p_72838_1_);
            func_72923_a(p_72838_1_);
            return true;
        } else
        {
            return false;
        }
    }

    protected void func_72923_a(Entity p_72923_1_)
    {
        IWorldAccess iworldaccess;
        for(Iterator iterator = field_73021_x.iterator(); iterator.hasNext(); iworldaccess.func_72703_a(p_72923_1_))
        {
            iworldaccess = (IWorldAccess)iterator.next();
        }

    }

    protected void func_72847_b(Entity p_72847_1_)
    {
        IWorldAccess iworldaccess;
        for(Iterator iterator = field_73021_x.iterator(); iterator.hasNext(); iworldaccess.func_72709_b(p_72847_1_))
        {
            iworldaccess = (IWorldAccess)iterator.next();
        }

    }

    public void func_72900_e(Entity p_72900_1_)
    {
        if(p_72900_1_.field_70153_n != null)
        {
            p_72900_1_.field_70153_n.func_70078_a(null);
        }
        if(p_72900_1_.field_70154_o != null)
        {
            p_72900_1_.func_70078_a(null);
        }
        p_72900_1_.func_70106_y();
        if(p_72900_1_ instanceof EntityPlayer)
        {
            field_73010_i.remove(p_72900_1_);
            func_72854_c();
        }
    }

    public void func_72973_f(Entity p_72973_1_)
    {
        p_72973_1_.func_70106_y();
        if(p_72973_1_ instanceof EntityPlayer)
        {
            field_73010_i.remove(p_72973_1_);
            func_72854_c();
        }
        int i = p_72973_1_.field_70176_ah;
        int j = p_72973_1_.field_70164_aj;
        if(p_72973_1_.field_70175_ag && func_72916_c(i, j))
        {
            func_72964_e(i, j).func_76622_b(p_72973_1_);
        }
        field_72996_f.remove(p_72973_1_);
        func_72847_b(p_72973_1_);
    }

    public void func_72954_a(IWorldAccess p_72954_1_)
    {
        field_73021_x.add(p_72954_1_);
    }

    public void func_72848_b(IWorldAccess p_72848_1_)
    {
        field_73021_x.remove(p_72848_1_);
    }

    public List func_72945_a(Entity p_72945_1_, AxisAlignedBB p_72945_2_)
    {
        field_72998_d.clear();
        int i = MathHelper.func_76128_c(p_72945_2_.field_72340_a);
        int j = MathHelper.func_76128_c(p_72945_2_.field_72336_d + 1.0D);
        int k = MathHelper.func_76128_c(p_72945_2_.field_72338_b);
        int l = MathHelper.func_76128_c(p_72945_2_.field_72337_e + 1.0D);
        int i1 = MathHelper.func_76128_c(p_72945_2_.field_72339_c);
        int j1 = MathHelper.func_76128_c(p_72945_2_.field_72334_f + 1.0D);
        for(int k1 = i; k1 < j; k1++)
        {
            for(int l1 = i1; l1 < j1; l1++)
            {
                if(!func_72899_e(k1, 64, l1))
                {
                    continue;
                }
                for(int i2 = k - 1; i2 < l; i2++)
                {
                    Block block = Block.field_71973_m[func_72798_a(k1, i2, l1)];
                    if(block != null)
                    {
                        block.func_71871_a(this, k1, i2, l1, p_72945_2_, field_72998_d, p_72945_1_);
                    }
                }

            }

        }

        double d = 0.25D;
        List list = func_72839_b(p_72945_1_, p_72945_2_.func_72314_b(d, d, d));
        Iterator iterator = list.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            Entity entity = (Entity)iterator.next();
            AxisAlignedBB axisalignedbb = entity.func_70046_E();
            if(axisalignedbb != null && axisalignedbb.func_72326_a(p_72945_2_))
            {
                field_72998_d.add(axisalignedbb);
            }
            axisalignedbb = p_72945_1_.func_70114_g(entity);
            if(axisalignedbb != null && axisalignedbb.func_72326_a(p_72945_2_))
            {
                field_72998_d.add(axisalignedbb);
            }
        } while(true);
        return field_72998_d;
    }

    public List func_72840_a(AxisAlignedBB p_72840_1_)
    {
        field_72998_d.clear();
        int i = MathHelper.func_76128_c(p_72840_1_.field_72340_a);
        int j = MathHelper.func_76128_c(p_72840_1_.field_72336_d + 1.0D);
        int k = MathHelper.func_76128_c(p_72840_1_.field_72338_b);
        int l = MathHelper.func_76128_c(p_72840_1_.field_72337_e + 1.0D);
        int i1 = MathHelper.func_76128_c(p_72840_1_.field_72339_c);
        int j1 = MathHelper.func_76128_c(p_72840_1_.field_72334_f + 1.0D);
        for(int k1 = i; k1 < j; k1++)
        {
            for(int l1 = i1; l1 < j1; l1++)
            {
                if(!func_72899_e(k1, 64, l1))
                {
                    continue;
                }
                for(int i2 = k - 1; i2 < l; i2++)
                {
                    Block block = Block.field_71973_m[func_72798_a(k1, i2, l1)];
                    if(block != null)
                    {
                        block.func_71871_a(this, k1, i2, l1, p_72840_1_, field_72998_d, null);
                    }
                }

            }

        }

        return field_72998_d;
    }

    public int func_72967_a(float p_72967_1_)
    {
        float f = func_72826_c(p_72967_1_);
        float f1 = 1.0F - (MathHelper.func_76134_b(f * 3.141593F * 2.0F) * 2.0F + 0.5F);
        if(f1 < 0.0F)
        {
            f1 = 0.0F;
        }
        if(f1 > 1.0F)
        {
            f1 = 1.0F;
        }
        f1 = 1.0F - f1;
        f1 = (float)((double)f1 * (1.0D - (double)(func_72867_j(p_72967_1_) * 5F) / 16D));
        f1 = (float)((double)f1 * (1.0D - (double)(func_72819_i(p_72967_1_) * 5F) / 16D));
        f1 = 1.0F - f1;
        return (int)(f1 * 11F);
    }

    public float func_72971_b(float p_72971_1_)
    {
        float f = func_72826_c(p_72971_1_);
        float f1 = 1.0F - (MathHelper.func_76134_b(f * 3.141593F * 2.0F) * 2.0F + 0.2F);
        if(f1 < 0.0F)
        {
            f1 = 0.0F;
        }
        if(f1 > 1.0F)
        {
            f1 = 1.0F;
        }
        f1 = 1.0F - f1;
        f1 = (float)((double)f1 * (1.0D - (double)(func_72867_j(p_72971_1_) * 5F) / 16D));
        f1 = (float)((double)f1 * (1.0D - (double)(func_72819_i(p_72971_1_) * 5F) / 16D));
        return f1 * 0.8F + 0.2F;
    }

    public Vec3 func_72833_a(Entity p_72833_1_, float p_72833_2_)
    {
        float f = func_72826_c(p_72833_2_);
        float f1 = MathHelper.func_76134_b(f * 3.141593F * 2.0F) * 2.0F + 0.5F;
        if(f1 < 0.0F)
        {
            f1 = 0.0F;
        }
        if(f1 > 1.0F)
        {
            f1 = 1.0F;
        }
        int i = MathHelper.func_76128_c(p_72833_1_.field_70165_t);
        int j = MathHelper.func_76128_c(p_72833_1_.field_70161_v);
        BiomeGenBase biomegenbase = func_72807_a(i, j);
        float f2 = biomegenbase.func_76743_j();
        int k = biomegenbase.func_76731_a(f2);
        float f3 = (float)(k >> 16 & 0xff) / 255F;
        float f4 = (float)(k >> 8 & 0xff) / 255F;
        float f5 = (float)(k & 0xff) / 255F;
        f3 *= f1;
        f4 *= f1;
        f5 *= f1;
        float f6 = func_72867_j(p_72833_2_);
        if(f6 > 0.0F)
        {
            float f7 = (f3 * 0.3F + f4 * 0.59F + f5 * 0.11F) * 0.6F;
            float f9 = 1.0F - f6 * 0.75F;
            f3 = f3 * f9 + f7 * (1.0F - f9);
            f4 = f4 * f9 + f7 * (1.0F - f9);
            f5 = f5 * f9 + f7 * (1.0F - f9);
        }
        float f8 = func_72819_i(p_72833_2_);
        if(f8 > 0.0F)
        {
            float f10 = (f3 * 0.3F + f4 * 0.59F + f5 * 0.11F) * 0.2F;
            float f12 = 1.0F - f8 * 0.75F;
            f3 = f3 * f12 + f10 * (1.0F - f12);
            f4 = f4 * f12 + f10 * (1.0F - f12);
            f5 = f5 * f12 + f10 * (1.0F - f12);
        }
        if(field_73015_s > 0)
        {
            float f11 = (float)field_73015_s - p_72833_2_;
            if(f11 > 1.0F)
            {
                f11 = 1.0F;
            }
            f11 *= 0.45F;
            f3 = f3 * (1.0F - f11) + 0.8F * f11;
            f4 = f4 * (1.0F - f11) + 0.8F * f11;
            f5 = f5 * (1.0F - f11) + 1.0F * f11;
        }
        return Vec3.func_72437_a().func_72345_a(f3, f4, f5);
    }

    public float func_72826_c(float p_72826_1_)
    {
        return field_73011_w.func_76563_a(field_72986_A.func_76073_f(), p_72826_1_);
    }

    public int func_72853_d(float p_72853_1_)
    {
        return field_73011_w.func_76559_b(field_72986_A.func_76073_f(), p_72853_1_);
    }

    public float func_72929_e(float p_72929_1_)
    {
        float f = func_72826_c(p_72929_1_);
        return f * 3.141593F * 2.0F;
    }

    public Vec3 func_72824_f(float p_72824_1_)
    {
        float f = func_72826_c(p_72824_1_);
        float f1 = MathHelper.func_76134_b(f * 3.141593F * 2.0F) * 2.0F + 0.5F;
        if(f1 < 0.0F)
        {
            f1 = 0.0F;
        }
        if(f1 > 1.0F)
        {
            f1 = 1.0F;
        }
        float f2 = (float)(field_73001_c >> 16 & 255L) / 255F;
        float f3 = (float)(field_73001_c >> 8 & 255L) / 255F;
        float f4 = (float)(field_73001_c & 255L) / 255F;
        float f5 = func_72867_j(p_72824_1_);
        if(f5 > 0.0F)
        {
            float f6 = (f2 * 0.3F + f3 * 0.59F + f4 * 0.11F) * 0.6F;
            float f8 = 1.0F - f5 * 0.95F;
            f2 = f2 * f8 + f6 * (1.0F - f8);
            f3 = f3 * f8 + f6 * (1.0F - f8);
            f4 = f4 * f8 + f6 * (1.0F - f8);
        }
        f2 *= f1 * 0.9F + 0.1F;
        f3 *= f1 * 0.9F + 0.1F;
        f4 *= f1 * 0.85F + 0.15F;
        float f7 = func_72819_i(p_72824_1_);
        if(f7 > 0.0F)
        {
            float f9 = (f2 * 0.3F + f3 * 0.59F + f4 * 0.11F) * 0.2F;
            float f10 = 1.0F - f7 * 0.95F;
            f2 = f2 * f10 + f9 * (1.0F - f10);
            f3 = f3 * f10 + f9 * (1.0F - f10);
            f4 = f4 * f10 + f9 * (1.0F - f10);
        }
        return Vec3.func_72437_a().func_72345_a(f2, f3, f4);
    }

    public Vec3 func_72948_g(float p_72948_1_)
    {
        float f = func_72826_c(p_72948_1_);
        return field_73011_w.func_76562_b(f, p_72948_1_);
    }

    public int func_72874_g(int p_72874_1_, int p_72874_2_)
    {
        return func_72938_d(p_72874_1_, p_72874_2_).func_76626_d(p_72874_1_ & 0xf, p_72874_2_ & 0xf);
    }

    public int func_72825_h(int p_72825_1_, int p_72825_2_)
    {
        Chunk chunk = func_72938_d(p_72825_1_, p_72825_2_);
        int i = chunk.func_76625_h() + 15;
        p_72825_1_ &= 0xf;
        p_72825_2_ &= 0xf;
        while(i > 0) 
        {
            int j = chunk.func_76610_a(p_72825_1_, i, p_72825_2_);
            if(j == 0 || !Block.field_71973_m[j].field_72018_cp.func_76230_c() || Block.field_71973_m[j].field_72018_cp == Material.field_76257_i)
            {
                i--;
            } else
            {
                return i + 1;
            }
        }
        return -1;
    }

    public float func_72880_h(float p_72880_1_)
    {
        float f = func_72826_c(p_72880_1_);
        float f1 = 1.0F - (MathHelper.func_76134_b(f * 3.141593F * 2.0F) * 2.0F + 0.25F);
        if(f1 < 0.0F)
        {
            f1 = 0.0F;
        }
        if(f1 > 1.0F)
        {
            f1 = 1.0F;
        }
        return f1 * f1 * 0.5F;
    }

    public void func_72836_a(int i, int j, int k, int l, int i1)
    {
    }

    public void func_72892_b(int i, int j, int k, int l, int i1)
    {
    }

    public void func_72939_s()
    {
        field_72984_F.func_76320_a("entities");
        field_72984_F.func_76320_a("global");
        for(int i = 0; i < field_73007_j.size(); i++)
        {
            Entity entity = (Entity)field_73007_j.get(i);
            entity.func_70071_h_();
            if(entity.field_70128_L)
            {
                field_73007_j.remove(i--);
            }
        }

        field_72984_F.func_76318_c("remove");
        field_72996_f.removeAll(field_72997_g);
        Iterator iterator = field_72997_g.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            Entity entity1 = (Entity)iterator.next();
            int k = entity1.field_70176_ah;
            int i1 = entity1.field_70164_aj;
            if(entity1.field_70175_ag && func_72916_c(k, i1))
            {
                func_72964_e(k, i1).func_76622_b(entity1);
            }
        } while(true);
        Entity entity2;
        for(iterator = field_72997_g.iterator(); iterator.hasNext(); func_72847_b(entity2))
        {
            entity2 = (Entity)iterator.next();
        }

        field_72997_g.clear();
        field_72984_F.func_76318_c("regular");
        for(int j = 0; j < field_72996_f.size(); j++)
        {
            Entity entity3 = (Entity)field_72996_f.get(j);
            if(entity3.field_70154_o != null)
            {
                if(!entity3.field_70154_o.field_70128_L && entity3.field_70154_o.field_70153_n == entity3)
                {
                    continue;
                }
                entity3.field_70154_o.field_70153_n = null;
                entity3.field_70154_o = null;
            }
            field_72984_F.func_76320_a("tick");
            if(!entity3.field_70128_L)
            {
                func_72870_g(entity3);
            }
            field_72984_F.func_76319_b();
            field_72984_F.func_76320_a("remove");
            if(entity3.field_70128_L)
            {
                int l = entity3.field_70176_ah;
                int j1 = entity3.field_70164_aj;
                if(entity3.field_70175_ag && func_72916_c(l, j1))
                {
                    func_72964_e(l, j1).func_76622_b(entity3);
                }
                field_72996_f.remove(j--);
                func_72847_b(entity3);
            }
            field_72984_F.func_76319_b();
        }

        field_72984_F.func_76318_c("tileEntities");
        field_72989_L = true;
        j = field_73009_h.iterator();
        do
        {
            if(!j.hasNext())
            {
                break;
            }
            TileEntity tileentity = (TileEntity)j.next();
            if(!tileentity.func_70320_p() && tileentity.func_70309_m() && func_72899_e(tileentity.field_70329_l, tileentity.field_70330_m, tileentity.field_70327_n))
            {
                tileentity.func_70316_g();
            }
            if(tileentity.func_70320_p())
            {
                j.remove();
                if(func_72916_c(tileentity.field_70329_l >> 4, tileentity.field_70327_n >> 4))
                {
                    Chunk chunk = func_72964_e(tileentity.field_70329_l >> 4, tileentity.field_70327_n >> 4);
                    if(chunk != null)
                    {
                        chunk.func_76627_f(tileentity.field_70329_l & 0xf, tileentity.field_70330_m, tileentity.field_70327_n & 0xf);
                    }
                }
            }
        } while(true);
        field_72989_L = false;
        if(!field_73000_b.isEmpty())
        {
            field_73009_h.removeAll(field_73000_b);
            field_73000_b.clear();
        }
        field_72984_F.func_76318_c("pendingTileEntities");
        if(!field_73002_a.isEmpty())
        {
            Iterator iterator1 = field_73002_a.iterator();
            do
            {
                if(!iterator1.hasNext())
                {
                    break;
                }
                TileEntity tileentity1 = (TileEntity)iterator1.next();
                if(!tileentity1.func_70320_p())
                {
                    if(!field_73009_h.contains(tileentity1))
                    {
                        field_73009_h.add(tileentity1);
                    }
                    if(func_72916_c(tileentity1.field_70329_l >> 4, tileentity1.field_70327_n >> 4))
                    {
                        Chunk chunk1 = func_72964_e(tileentity1.field_70329_l >> 4, tileentity1.field_70327_n >> 4);
                        if(chunk1 != null)
                        {
                            chunk1.func_76604_a(tileentity1.field_70329_l & 0xf, tileentity1.field_70330_m, tileentity1.field_70327_n & 0xf, tileentity1);
                        }
                    }
                    func_72845_h(tileentity1.field_70329_l, tileentity1.field_70330_m, tileentity1.field_70327_n);
                }
            } while(true);
            field_73002_a.clear();
        }
        field_72984_F.func_76319_b();
        field_72984_F.func_76319_b();
    }

    public void func_72852_a(Collection p_72852_1_)
    {
        if(field_72989_L)
        {
            field_73002_a.addAll(p_72852_1_);
        } else
        {
            field_73009_h.addAll(p_72852_1_);
        }
    }

    public void func_72870_g(Entity p_72870_1_)
    {
        func_72866_a(p_72870_1_, true);
    }

    public void func_72866_a(Entity p_72866_1_, boolean p_72866_2_)
    {
        int i = MathHelper.func_76128_c(p_72866_1_.field_70165_t);
        int j = MathHelper.func_76128_c(p_72866_1_.field_70161_v);
        byte byte0 = 32;
        if(p_72866_2_ && !func_72904_c(i - byte0, 0, j - byte0, i + byte0, 0, j + byte0))
        {
            return;
        }
        p_72866_1_.field_70142_S = p_72866_1_.field_70165_t;
        p_72866_1_.field_70137_T = p_72866_1_.field_70163_u;
        p_72866_1_.field_70136_U = p_72866_1_.field_70161_v;
        p_72866_1_.field_70126_B = p_72866_1_.field_70177_z;
        p_72866_1_.field_70127_C = p_72866_1_.field_70125_A;
        if(p_72866_2_ && p_72866_1_.field_70175_ag)
        {
            if(p_72866_1_.field_70154_o != null)
            {
                p_72866_1_.func_70098_U();
            } else
            {
                p_72866_1_.func_70071_h_();
            }
        }
        field_72984_F.func_76320_a("chunkCheck");
        if(Double.isNaN(p_72866_1_.field_70165_t) || Double.isInfinite(p_72866_1_.field_70165_t))
        {
            p_72866_1_.field_70165_t = p_72866_1_.field_70142_S;
        }
        if(Double.isNaN(p_72866_1_.field_70163_u) || Double.isInfinite(p_72866_1_.field_70163_u))
        {
            p_72866_1_.field_70163_u = p_72866_1_.field_70137_T;
        }
        if(Double.isNaN(p_72866_1_.field_70161_v) || Double.isInfinite(p_72866_1_.field_70161_v))
        {
            p_72866_1_.field_70161_v = p_72866_1_.field_70136_U;
        }
        if(Double.isNaN(p_72866_1_.field_70125_A) || Double.isInfinite(p_72866_1_.field_70125_A))
        {
            p_72866_1_.field_70125_A = p_72866_1_.field_70127_C;
        }
        if(Double.isNaN(p_72866_1_.field_70177_z) || Double.isInfinite(p_72866_1_.field_70177_z))
        {
            p_72866_1_.field_70177_z = p_72866_1_.field_70126_B;
        }
        int k = MathHelper.func_76128_c(p_72866_1_.field_70165_t / 16D);
        int l = MathHelper.func_76128_c(p_72866_1_.field_70163_u / 16D);
        int i1 = MathHelper.func_76128_c(p_72866_1_.field_70161_v / 16D);
        if(!p_72866_1_.field_70175_ag || p_72866_1_.field_70176_ah != k || p_72866_1_.field_70162_ai != l || p_72866_1_.field_70164_aj != i1)
        {
            if(p_72866_1_.field_70175_ag && func_72916_c(p_72866_1_.field_70176_ah, p_72866_1_.field_70164_aj))
            {
                func_72964_e(p_72866_1_.field_70176_ah, p_72866_1_.field_70164_aj).func_76608_a(p_72866_1_, p_72866_1_.field_70162_ai);
            }
            if(func_72916_c(k, i1))
            {
                p_72866_1_.field_70175_ag = true;
                func_72964_e(k, i1).func_76612_a(p_72866_1_);
            } else
            {
                p_72866_1_.field_70175_ag = false;
            }
        }
        field_72984_F.func_76319_b();
        if(p_72866_2_ && p_72866_1_.field_70175_ag && p_72866_1_.field_70153_n != null)
        {
            if(p_72866_1_.field_70153_n.field_70128_L || p_72866_1_.field_70153_n.field_70154_o != p_72866_1_)
            {
                p_72866_1_.field_70153_n.field_70154_o = null;
                p_72866_1_.field_70153_n = null;
            } else
            {
                func_72870_g(p_72866_1_.field_70153_n);
            }
        }
    }

    public boolean func_72855_b(AxisAlignedBB p_72855_1_)
    {
        return func_72917_a(p_72855_1_, null);
    }

    public boolean func_72917_a(AxisAlignedBB p_72917_1_, Entity p_72917_2_)
    {
        List list = func_72839_b(null, p_72917_1_);
        for(Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            Entity entity = (Entity)iterator.next();
            if(!entity.field_70128_L && entity.field_70156_m && entity != p_72917_2_)
            {
                return false;
            }
        }

        return true;
    }

    public boolean func_72829_c(AxisAlignedBB p_72829_1_)
    {
        int i = MathHelper.func_76128_c(p_72829_1_.field_72340_a);
        int j = MathHelper.func_76128_c(p_72829_1_.field_72336_d + 1.0D);
        int k = MathHelper.func_76128_c(p_72829_1_.field_72338_b);
        int l = MathHelper.func_76128_c(p_72829_1_.field_72337_e + 1.0D);
        int i1 = MathHelper.func_76128_c(p_72829_1_.field_72339_c);
        int j1 = MathHelper.func_76128_c(p_72829_1_.field_72334_f + 1.0D);
        if(p_72829_1_.field_72340_a < 0.0D)
        {
            i--;
        }
        if(p_72829_1_.field_72338_b < 0.0D)
        {
            k--;
        }
        if(p_72829_1_.field_72339_c < 0.0D)
        {
            i1--;
        }
        for(int k1 = i; k1 < j; k1++)
        {
            for(int l1 = k; l1 < l; l1++)
            {
                for(int i2 = i1; i2 < j1; i2++)
                {
                    Block block = Block.field_71973_m[func_72798_a(k1, l1, i2)];
                    if(block != null)
                    {
                        return true;
                    }
                }

            }

        }

        return false;
    }

    public boolean func_72953_d(AxisAlignedBB p_72953_1_)
    {
        int i = MathHelper.func_76128_c(p_72953_1_.field_72340_a);
        int j = MathHelper.func_76128_c(p_72953_1_.field_72336_d + 1.0D);
        int k = MathHelper.func_76128_c(p_72953_1_.field_72338_b);
        int l = MathHelper.func_76128_c(p_72953_1_.field_72337_e + 1.0D);
        int i1 = MathHelper.func_76128_c(p_72953_1_.field_72339_c);
        int j1 = MathHelper.func_76128_c(p_72953_1_.field_72334_f + 1.0D);
        if(p_72953_1_.field_72340_a < 0.0D)
        {
            i--;
        }
        if(p_72953_1_.field_72338_b < 0.0D)
        {
            k--;
        }
        if(p_72953_1_.field_72339_c < 0.0D)
        {
            i1--;
        }
        for(int k1 = i; k1 < j; k1++)
        {
            for(int l1 = k; l1 < l; l1++)
            {
                for(int i2 = i1; i2 < j1; i2++)
                {
                    Block block = Block.field_71973_m[func_72798_a(k1, l1, i2)];
                    if(block != null && block.field_72018_cp.func_76224_d())
                    {
                        return true;
                    }
                }

            }

        }

        return false;
    }

    public boolean func_72978_e(AxisAlignedBB p_72978_1_)
    {
        int i = MathHelper.func_76128_c(p_72978_1_.field_72340_a);
        int j = MathHelper.func_76128_c(p_72978_1_.field_72336_d + 1.0D);
        int k = MathHelper.func_76128_c(p_72978_1_.field_72338_b);
        int l = MathHelper.func_76128_c(p_72978_1_.field_72337_e + 1.0D);
        int i1 = MathHelper.func_76128_c(p_72978_1_.field_72339_c);
        int j1 = MathHelper.func_76128_c(p_72978_1_.field_72334_f + 1.0D);
        if(func_72904_c(i, k, i1, j, l, j1))
        {
            for(int k1 = i; k1 < j; k1++)
            {
                for(int l1 = k; l1 < l; l1++)
                {
                    for(int i2 = i1; i2 < j1; i2++)
                    {
                        int j2 = func_72798_a(k1, l1, i2);
                        if(j2 == Block.field_72067_ar.field_71990_ca || j2 == Block.field_71944_C.field_71990_ca || j2 == Block.field_71938_D.field_71990_ca)
                        {
                            return true;
                        }
                    }

                }

            }

        }
        return false;
    }

    public boolean func_72918_a(AxisAlignedBB p_72918_1_, Material p_72918_2_, Entity p_72918_3_)
    {
        int i = MathHelper.func_76128_c(p_72918_1_.field_72340_a);
        int j = MathHelper.func_76128_c(p_72918_1_.field_72336_d + 1.0D);
        int k = MathHelper.func_76128_c(p_72918_1_.field_72338_b);
        int l = MathHelper.func_76128_c(p_72918_1_.field_72337_e + 1.0D);
        int i1 = MathHelper.func_76128_c(p_72918_1_.field_72339_c);
        int j1 = MathHelper.func_76128_c(p_72918_1_.field_72334_f + 1.0D);
        if(!func_72904_c(i, k, i1, j, l, j1))
        {
            return false;
        }
        boolean flag = false;
        Vec3 vec3 = Vec3.func_72437_a().func_72345_a(0.0D, 0.0D, 0.0D);
        for(int k1 = i; k1 < j; k1++)
        {
            for(int l1 = k; l1 < l; l1++)
            {
                for(int i2 = i1; i2 < j1; i2++)
                {
                    Block block = Block.field_71973_m[func_72798_a(k1, l1, i2)];
                    if(block == null || block.field_72018_cp != p_72918_2_)
                    {
                        continue;
                    }
                    double d1 = (float)(l1 + 1) - BlockFluid.func_72199_d(func_72805_g(k1, l1, i2));
                    if((double)l >= d1)
                    {
                        flag = true;
                        block.func_71901_a(this, k1, l1, i2, p_72918_3_, vec3);
                    }
                }

            }

        }

        if(vec3.func_72433_c() > 0.0D)
        {
            vec3 = vec3.func_72432_b();
            double d = 0.014D;
            p_72918_3_.field_70159_w += vec3.field_72450_a * d;
            p_72918_3_.field_70181_x += vec3.field_72448_b * d;
            p_72918_3_.field_70179_y += vec3.field_72449_c * d;
        }
        return flag;
    }

    public boolean func_72875_a(AxisAlignedBB p_72875_1_, Material p_72875_2_)
    {
        int i = MathHelper.func_76128_c(p_72875_1_.field_72340_a);
        int j = MathHelper.func_76128_c(p_72875_1_.field_72336_d + 1.0D);
        int k = MathHelper.func_76128_c(p_72875_1_.field_72338_b);
        int l = MathHelper.func_76128_c(p_72875_1_.field_72337_e + 1.0D);
        int i1 = MathHelper.func_76128_c(p_72875_1_.field_72339_c);
        int j1 = MathHelper.func_76128_c(p_72875_1_.field_72334_f + 1.0D);
        for(int k1 = i; k1 < j; k1++)
        {
            for(int l1 = k; l1 < l; l1++)
            {
                for(int i2 = i1; i2 < j1; i2++)
                {
                    Block block = Block.field_71973_m[func_72798_a(k1, l1, i2)];
                    if(block != null && block.field_72018_cp == p_72875_2_)
                    {
                        return true;
                    }
                }

            }

        }

        return false;
    }

    public boolean func_72830_b(AxisAlignedBB p_72830_1_, Material p_72830_2_)
    {
        int i = MathHelper.func_76128_c(p_72830_1_.field_72340_a);
        int j = MathHelper.func_76128_c(p_72830_1_.field_72336_d + 1.0D);
        int k = MathHelper.func_76128_c(p_72830_1_.field_72338_b);
        int l = MathHelper.func_76128_c(p_72830_1_.field_72337_e + 1.0D);
        int i1 = MathHelper.func_76128_c(p_72830_1_.field_72339_c);
        int j1 = MathHelper.func_76128_c(p_72830_1_.field_72334_f + 1.0D);
        for(int k1 = i; k1 < j; k1++)
        {
            for(int l1 = k; l1 < l; l1++)
            {
                for(int i2 = i1; i2 < j1; i2++)
                {
                    Block block = Block.field_71973_m[func_72798_a(k1, l1, i2)];
                    if(block == null || block.field_72018_cp != p_72830_2_)
                    {
                        continue;
                    }
                    int j2 = func_72805_g(k1, l1, i2);
                    double d = l1 + 1;
                    if(j2 < 8)
                    {
                        d = (double)(l1 + 1) - (double)j2 / 8D;
                    }
                    if(d >= p_72830_1_.field_72338_b)
                    {
                        return true;
                    }
                }

            }

        }

        return false;
    }

    public Explosion func_72876_a(Entity p_72876_1_, double p_72876_2_, double p_72876_4_, double p_72876_6_, 
            float p_72876_8_)
    {
        return func_72885_a(p_72876_1_, p_72876_2_, p_72876_4_, p_72876_6_, p_72876_8_, false);
    }

    public Explosion func_72885_a(Entity p_72885_1_, double p_72885_2_, double p_72885_4_, double p_72885_6_, 
            float p_72885_8_, boolean p_72885_9_)
    {
        Explosion explosion = new Explosion(this, p_72885_1_, p_72885_2_, p_72885_4_, p_72885_6_, p_72885_8_);
        explosion.field_77286_a = p_72885_9_;
        explosion.func_77278_a();
        explosion.func_77279_a(true);
        return explosion;
    }

    public float func_72842_a(Vec3 p_72842_1_, AxisAlignedBB p_72842_2_)
    {
        double d = 1.0D / ((p_72842_2_.field_72336_d - p_72842_2_.field_72340_a) * 2D + 1.0D);
        double d1 = 1.0D / ((p_72842_2_.field_72337_e - p_72842_2_.field_72338_b) * 2D + 1.0D);
        double d2 = 1.0D / ((p_72842_2_.field_72334_f - p_72842_2_.field_72339_c) * 2D + 1.0D);
        int i = 0;
        int j = 0;
        for(float f = 0.0F; f <= 1.0F; f = (float)((double)f + d))
        {
            for(float f1 = 0.0F; f1 <= 1.0F; f1 = (float)((double)f1 + d1))
            {
                for(float f2 = 0.0F; f2 <= 1.0F; f2 = (float)((double)f2 + d2))
                {
                    double d3 = p_72842_2_.field_72340_a + (p_72842_2_.field_72336_d - p_72842_2_.field_72340_a) * (double)f;
                    double d4 = p_72842_2_.field_72338_b + (p_72842_2_.field_72337_e - p_72842_2_.field_72338_b) * (double)f1;
                    double d5 = p_72842_2_.field_72339_c + (p_72842_2_.field_72334_f - p_72842_2_.field_72339_c) * (double)f2;
                    if(func_72933_a(Vec3.func_72437_a().func_72345_a(d3, d4, d5), p_72842_1_) == null)
                    {
                        i++;
                    }
                    j++;
                }

            }

        }

        return (float)i / (float)j;
    }

    public boolean func_72886_a(EntityPlayer p_72886_1_, int p_72886_2_, int p_72886_3_, int p_72886_4_, int p_72886_5_)
    {
        if(p_72886_5_ == 0)
        {
            p_72886_3_--;
        }
        if(p_72886_5_ == 1)
        {
            p_72886_3_++;
        }
        if(p_72886_5_ == 2)
        {
            p_72886_4_--;
        }
        if(p_72886_5_ == 3)
        {
            p_72886_4_++;
        }
        if(p_72886_5_ == 4)
        {
            p_72886_2_--;
        }
        if(p_72886_5_ == 5)
        {
            p_72886_2_++;
        }
        if(func_72798_a(p_72886_2_, p_72886_3_, p_72886_4_) == Block.field_72067_ar.field_71990_ca)
        {
            func_72889_a(p_72886_1_, 1004, p_72886_2_, p_72886_3_, p_72886_4_, 0);
            func_72859_e(p_72886_2_, p_72886_3_, p_72886_4_, 0);
            return true;
        } else
        {
            return false;
        }
    }

    public String func_72981_t()
    {
        return (new StringBuilder()).append("All: ").append(field_72996_f.size()).toString();
    }

    public String func_72827_u()
    {
        return field_73020_y.func_73148_d();
    }

    public TileEntity func_72796_p(int p_72796_1_, int p_72796_2_, int p_72796_3_)
    {
label0:
        {
            TileEntity tileentity;
label1:
            {
                if(p_72796_2_ >= 256)
                {
                    return null;
                }
                Chunk chunk = func_72964_e(p_72796_1_ >> 4, p_72796_3_ >> 4);
                if(chunk == null)
                {
                    break label0;
                }
                tileentity = chunk.func_76597_e(p_72796_1_ & 0xf, p_72796_2_, p_72796_3_ & 0xf);
                if(tileentity != null)
                {
                    break label1;
                }
                Iterator iterator = field_73002_a.iterator();
                TileEntity tileentity1;
                do
                {
                    if(!iterator.hasNext())
                    {
                        break label1;
                    }
                    tileentity1 = (TileEntity)iterator.next();
                } while(tileentity1.func_70320_p() || tileentity1.field_70329_l != p_72796_1_ || tileentity1.field_70330_m != p_72796_2_ || tileentity1.field_70327_n != p_72796_3_);
                tileentity = tileentity1;
            }
            return tileentity;
        }
        return null;
    }

    public void func_72837_a(int p_72837_1_, int p_72837_2_, int p_72837_3_, TileEntity p_72837_4_)
    {
        if(p_72837_4_ != null && !p_72837_4_.func_70320_p())
        {
            if(field_72989_L)
            {
                p_72837_4_.field_70329_l = p_72837_1_;
                p_72837_4_.field_70330_m = p_72837_2_;
                p_72837_4_.field_70327_n = p_72837_3_;
                field_73002_a.add(p_72837_4_);
            } else
            {
                field_73009_h.add(p_72837_4_);
                Chunk chunk = func_72964_e(p_72837_1_ >> 4, p_72837_3_ >> 4);
                if(chunk != null)
                {
                    chunk.func_76604_a(p_72837_1_ & 0xf, p_72837_2_, p_72837_3_ & 0xf, p_72837_4_);
                }
            }
        }
    }

    public void func_72932_q(int p_72932_1_, int p_72932_2_, int p_72932_3_)
    {
        TileEntity tileentity = func_72796_p(p_72932_1_, p_72932_2_, p_72932_3_);
        if(tileentity != null && field_72989_L)
        {
            tileentity.func_70313_j();
            field_73002_a.remove(tileentity);
        } else
        {
            if(tileentity != null)
            {
                field_73002_a.remove(tileentity);
                field_73009_h.remove(tileentity);
            }
            Chunk chunk = func_72964_e(p_72932_1_ >> 4, p_72932_3_ >> 4);
            if(chunk != null)
            {
                chunk.func_76627_f(p_72932_1_ & 0xf, p_72932_2_, p_72932_3_ & 0xf);
            }
        }
    }

    public void func_72928_a(TileEntity p_72928_1_)
    {
        field_73000_b.add(p_72928_1_);
    }

    public boolean func_72804_r(int p_72804_1_, int p_72804_2_, int p_72804_3_)
    {
        Block block = Block.field_71973_m[func_72798_a(p_72804_1_, p_72804_2_, p_72804_3_)];
        if(block == null)
        {
            return false;
        } else
        {
            return block.func_71926_d();
        }
    }

    public boolean func_72809_s(int p_72809_1_, int p_72809_2_, int p_72809_3_)
    {
        return Block.func_71932_i(func_72798_a(p_72809_1_, p_72809_2_, p_72809_3_));
    }

    public boolean func_72797_t(int p_72797_1_, int p_72797_2_, int p_72797_3_)
    {
        Block block = Block.field_71973_m[func_72798_a(p_72797_1_, p_72797_2_, p_72797_3_)];
        if(block == null)
        {
            return false;
        }
        if(block.field_72018_cp.func_76218_k() && block.func_71886_c())
        {
            return true;
        }
        if(block instanceof BlockStairs)
        {
            return (func_72805_g(p_72797_1_, p_72797_2_, p_72797_3_) & 4) == 4;
        }
        if(block instanceof BlockHalfSlab)
        {
            return (func_72805_g(p_72797_1_, p_72797_2_, p_72797_3_) & 8) == 8;
        } else
        {
            return false;
        }
    }

    public boolean func_72887_b(int p_72887_1_, int p_72887_2_, int p_72887_3_, boolean p_72887_4_)
    {
        if(p_72887_1_ < 0xfe363c80 || p_72887_3_ < 0xfe363c80 || p_72887_1_ >= 0x1c9c380 || p_72887_3_ >= 0x1c9c380)
        {
            return p_72887_4_;
        }
        Chunk chunk = field_73020_y.func_73154_d(p_72887_1_ >> 4, p_72887_3_ >> 4);
        if(chunk == null || chunk.func_76621_g())
        {
            return p_72887_4_;
        }
        Block block = Block.field_71973_m[func_72798_a(p_72887_1_, p_72887_2_, p_72887_3_)];
        if(block == null)
        {
            return false;
        } else
        {
            return block.field_72018_cp.func_76218_k() && block.func_71886_c();
        }
    }

    public void func_72966_v()
    {
        int i = func_72967_a(1.0F);
        if(i != field_73008_k)
        {
            field_73008_k = i;
        }
    }

    public void func_72891_a(boolean p_72891_1_, boolean p_72891_2_)
    {
        field_72985_G = p_72891_1_;
        field_72992_H = p_72891_2_;
    }

    public void func_72835_b()
    {
        func_72979_l();
    }

    private void func_72947_a()
    {
        if(field_72986_A.func_76059_o())
        {
            field_73004_o = 1.0F;
            if(field_72986_A.func_76061_m())
            {
                field_73017_q = 1.0F;
            }
        }
    }

    protected void func_72979_l()
    {
        if(field_73011_w.field_76576_e)
        {
            return;
        }
        if(field_73016_r > 0)
        {
            field_73016_r--;
        }
        int i = field_72986_A.func_76071_n();
        if(i <= 0)
        {
            if(field_72986_A.func_76061_m())
            {
                field_72986_A.func_76090_f(field_73012_v.nextInt(12000) + 3600);
            } else
            {
                field_72986_A.func_76090_f(field_73012_v.nextInt(0x29040) + 12000);
            }
        } else
        {
            i--;
            field_72986_A.func_76090_f(i);
            if(i <= 0)
            {
                field_72986_A.func_76069_a(!field_72986_A.func_76061_m());
            }
        }
        int j = field_72986_A.func_76083_p();
        if(j <= 0)
        {
            if(field_72986_A.func_76059_o())
            {
                field_72986_A.func_76080_g(field_73012_v.nextInt(12000) + 12000);
            } else
            {
                field_72986_A.func_76080_g(field_73012_v.nextInt(0x29040) + 12000);
            }
        } else
        {
            j--;
            field_72986_A.func_76080_g(j);
            if(j <= 0)
            {
                field_72986_A.func_76084_b(!field_72986_A.func_76059_o());
            }
        }
        field_73003_n = field_73004_o;
        if(field_72986_A.func_76059_o())
        {
            field_73004_o += 0.01D;
        } else
        {
            field_73004_o -= 0.01D;
        }
        if(field_73004_o < 0.0F)
        {
            field_73004_o = 0.0F;
        }
        if(field_73004_o > 1.0F)
        {
            field_73004_o = 1.0F;
        }
        field_73018_p = field_73017_q;
        if(field_72986_A.func_76061_m())
        {
            field_73017_q += 0.01D;
        } else
        {
            field_73017_q -= 0.01D;
        }
        if(field_73017_q < 0.0F)
        {
            field_73017_q = 0.0F;
        }
        if(field_73017_q > 1.0F)
        {
            field_73017_q = 1.0F;
        }
    }

    public void func_72913_w()
    {
        field_72986_A.func_76080_g(1);
    }

    protected void func_72903_x()
    {
        field_72993_I.clear();
        field_72984_F.func_76320_a("buildList");
        for(int i = 0; i < field_73010_i.size(); i++)
        {
            EntityPlayer entityplayer = (EntityPlayer)field_73010_i.get(i);
            int k = MathHelper.func_76128_c(entityplayer.field_70165_t / 16D);
            int i1 = MathHelper.func_76128_c(entityplayer.field_70161_v / 16D);
            byte byte0 = 7;
            for(int l1 = -byte0; l1 <= byte0; l1++)
            {
                for(int i2 = -byte0; i2 <= byte0; i2++)
                {
                    field_72993_I.add(new ChunkCoordIntPair(l1 + k, i2 + i1));
                }

            }

        }

        field_72984_F.func_76319_b();
        if(field_72990_M > 0)
        {
            field_72990_M--;
        }
        field_72984_F.func_76320_a("playerCheckLight");
        if(!field_73010_i.isEmpty())
        {
            int j = field_73012_v.nextInt(field_73010_i.size());
            EntityPlayer entityplayer1 = (EntityPlayer)field_73010_i.get(j);
            int l = (MathHelper.func_76128_c(entityplayer1.field_70165_t) + field_73012_v.nextInt(11)) - 5;
            int j1 = (MathHelper.func_76128_c(entityplayer1.field_70163_u) + field_73012_v.nextInt(11)) - 5;
            int k1 = (MathHelper.func_76128_c(entityplayer1.field_70161_v) + field_73012_v.nextInt(11)) - 5;
            func_72969_x(l, j1, k1);
        }
        field_72984_F.func_76319_b();
    }

    protected void func_72941_a(int p_72941_1_, int p_72941_2_, Chunk p_72941_3_)
    {
        field_72984_F.func_76318_c("moodSound");
        if(field_72990_M == 0)
        {
            field_73005_l = field_73005_l * 3 + 0x3c6ef35f;
            int i = field_73005_l >> 2;
            int j = i & 0xf;
            int k = i >> 8 & 0xf;
            int l = i >> 16 & 0x7f;
            int i1 = p_72941_3_.func_76610_a(j, l, k);
            j += p_72941_1_;
            k += p_72941_2_;
            if(i1 == 0 && func_72883_k(j, l, k) <= field_73012_v.nextInt(8) && func_72972_b(EnumSkyBlock.Sky, j, l, k) <= 0)
            {
                EntityPlayer entityplayer = func_72977_a((double)j + 0.5D, (double)l + 0.5D, (double)k + 0.5D, 8D);
                if(entityplayer != null && entityplayer.func_70092_e((double)j + 0.5D, (double)l + 0.5D, (double)k + 0.5D) > 4D)
                {
                    func_72908_a((double)j + 0.5D, (double)l + 0.5D, (double)k + 0.5D, "ambient.cave.cave", 0.7F, 0.8F + field_73012_v.nextFloat() * 0.2F);
                    field_72990_M = field_73012_v.nextInt(12000) + 6000;
                }
            }
        }
        field_72984_F.func_76318_c("checkLight");
        p_72941_3_.func_76594_o();
    }

    protected void func_72893_g()
    {
        func_72903_x();
    }

    public boolean func_72884_u(int p_72884_1_, int p_72884_2_, int p_72884_3_)
    {
        return func_72834_c(p_72884_1_, p_72884_2_, p_72884_3_, false);
    }

    public boolean func_72850_v(int p_72850_1_, int p_72850_2_, int p_72850_3_)
    {
        return func_72834_c(p_72850_1_, p_72850_2_, p_72850_3_, true);
    }

    public boolean func_72834_c(int p_72834_1_, int p_72834_2_, int p_72834_3_, boolean p_72834_4_)
    {
        BiomeGenBase biomegenbase = func_72807_a(p_72834_1_, p_72834_3_);
        float f = biomegenbase.func_76743_j();
        if(f > 0.15F)
        {
            return false;
        }
        if(p_72834_2_ >= 0 && p_72834_2_ < 256 && func_72972_b(EnumSkyBlock.Block, p_72834_1_, p_72834_2_, p_72834_3_) < 10)
        {
            int i = func_72798_a(p_72834_1_, p_72834_2_, p_72834_3_);
            if((i == Block.field_71943_B.field_71990_ca || i == Block.field_71942_A.field_71990_ca) && func_72805_g(p_72834_1_, p_72834_2_, p_72834_3_) == 0)
            {
                if(!p_72834_4_)
                {
                    return true;
                }
                boolean flag = true;
                if(flag && func_72803_f(p_72834_1_ - 1, p_72834_2_, p_72834_3_) != Material.field_76244_g)
                {
                    flag = false;
                }
                if(flag && func_72803_f(p_72834_1_ + 1, p_72834_2_, p_72834_3_) != Material.field_76244_g)
                {
                    flag = false;
                }
                if(flag && func_72803_f(p_72834_1_, p_72834_2_, p_72834_3_ - 1) != Material.field_76244_g)
                {
                    flag = false;
                }
                if(flag && func_72803_f(p_72834_1_, p_72834_2_, p_72834_3_ + 1) != Material.field_76244_g)
                {
                    flag = false;
                }
                if(!flag)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean func_72858_w(int p_72858_1_, int p_72858_2_, int p_72858_3_)
    {
        BiomeGenBase biomegenbase = func_72807_a(p_72858_1_, p_72858_3_);
        float f = biomegenbase.func_76743_j();
        if(f > 0.15F)
        {
            return false;
        }
        if(p_72858_2_ >= 0 && p_72858_2_ < 256 && func_72972_b(EnumSkyBlock.Block, p_72858_1_, p_72858_2_, p_72858_3_) < 10)
        {
            int i = func_72798_a(p_72858_1_, p_72858_2_ - 1, p_72858_3_);
            int j = func_72798_a(p_72858_1_, p_72858_2_, p_72858_3_);
            if(j == 0 && Block.field_72037_aS.func_71930_b(this, p_72858_1_, p_72858_2_, p_72858_3_) && i != 0 && i != Block.field_72036_aT.field_71990_ca && Block.field_71973_m[i].field_72018_cp.func_76230_c())
            {
                return true;
            }
        }
        return false;
    }

    public void func_72969_x(int p_72969_1_, int p_72969_2_, int p_72969_3_)
    {
        if(!field_73011_w.field_76576_e)
        {
            func_72936_c(EnumSkyBlock.Sky, p_72969_1_, p_72969_2_, p_72969_3_);
        }
        func_72936_c(EnumSkyBlock.Block, p_72969_1_, p_72969_2_, p_72969_3_);
    }

    private int func_72949_a(int p_72949_1_, int p_72949_2_, int p_72949_3_, int p_72949_4_, int p_72949_5_, int p_72949_6_)
    {
        int i = 0;
        if(func_72937_j(p_72949_2_, p_72949_3_, p_72949_4_))
        {
            i = 15;
        } else
        {
            if(p_72949_6_ == 0)
            {
                p_72949_6_ = 1;
            }
            int j = func_72972_b(EnumSkyBlock.Sky, p_72949_2_ - 1, p_72949_3_, p_72949_4_) - p_72949_6_;
            int k = func_72972_b(EnumSkyBlock.Sky, p_72949_2_ + 1, p_72949_3_, p_72949_4_) - p_72949_6_;
            int l = func_72972_b(EnumSkyBlock.Sky, p_72949_2_, p_72949_3_ - 1, p_72949_4_) - p_72949_6_;
            int i1 = func_72972_b(EnumSkyBlock.Sky, p_72949_2_, p_72949_3_ + 1, p_72949_4_) - p_72949_6_;
            int j1 = func_72972_b(EnumSkyBlock.Sky, p_72949_2_, p_72949_3_, p_72949_4_ - 1) - p_72949_6_;
            int k1 = func_72972_b(EnumSkyBlock.Sky, p_72949_2_, p_72949_3_, p_72949_4_ + 1) - p_72949_6_;
            if(j > i)
            {
                i = j;
            }
            if(k > i)
            {
                i = k;
            }
            if(l > i)
            {
                i = l;
            }
            if(i1 > i)
            {
                i = i1;
            }
            if(j1 > i)
            {
                i = j1;
            }
            if(k1 > i)
            {
                i = k1;
            }
        }
        return i;
    }

    private int func_72895_f(int p_72895_1_, int p_72895_2_, int p_72895_3_, int p_72895_4_, int p_72895_5_, int p_72895_6_)
    {
        int i = Block.field_71984_q[p_72895_5_];
        int j = func_72972_b(EnumSkyBlock.Block, p_72895_2_ - 1, p_72895_3_, p_72895_4_) - p_72895_6_;
        int k = func_72972_b(EnumSkyBlock.Block, p_72895_2_ + 1, p_72895_3_, p_72895_4_) - p_72895_6_;
        int l = func_72972_b(EnumSkyBlock.Block, p_72895_2_, p_72895_3_ - 1, p_72895_4_) - p_72895_6_;
        int i1 = func_72972_b(EnumSkyBlock.Block, p_72895_2_, p_72895_3_ + 1, p_72895_4_) - p_72895_6_;
        int j1 = func_72972_b(EnumSkyBlock.Block, p_72895_2_, p_72895_3_, p_72895_4_ - 1) - p_72895_6_;
        int k1 = func_72972_b(EnumSkyBlock.Block, p_72895_2_, p_72895_3_, p_72895_4_ + 1) - p_72895_6_;
        if(j > i)
        {
            i = j;
        }
        if(k > i)
        {
            i = k;
        }
        if(l > i)
        {
            i = l;
        }
        if(i1 > i)
        {
            i = i1;
        }
        if(j1 > i)
        {
            i = j1;
        }
        if(k1 > i)
        {
            i = k1;
        }
        return i;
    }

    public void func_72936_c(EnumSkyBlock p_72936_1_, int p_72936_2_, int p_72936_3_, int p_72936_4_)
    {
        if(!func_72873_a(p_72936_2_, p_72936_3_, p_72936_4_, 17))
        {
            return;
        }
        int i = 0;
        int j = 0;
        field_72984_F.func_76320_a("getBrightness");
        int k = func_72972_b(p_72936_1_, p_72936_2_, p_72936_3_, p_72936_4_);
        int l = 0;
        int i1 = func_72798_a(p_72936_2_, p_72936_3_, p_72936_4_);
        int l1 = func_72952_b(p_72936_2_, p_72936_3_, p_72936_4_);
        if(l1 == 0)
        {
            l1 = 1;
        }
        int k2 = 0;
        if(p_72936_1_ == EnumSkyBlock.Sky)
        {
            k2 = func_72949_a(k, p_72936_2_, p_72936_3_, p_72936_4_, i1, l1);
        } else
        {
            k2 = func_72895_f(k, p_72936_2_, p_72936_3_, p_72936_4_, i1, l1);
        }
        l = k2;
        if(l > k)
        {
            field_72994_J[j++] = 0x20820;
        } else
        if(l < k)
        {
            if(p_72936_1_ == EnumSkyBlock.Block);
            field_72994_J[j++] = 0x20820 + (k << 18);
            do
            {
                if(i >= j)
                {
                    break;
                }
                int j1 = field_72994_J[i++];
                int i2 = ((j1 & 0x3f) - 32) + p_72936_2_;
                int l2 = ((j1 >> 6 & 0x3f) - 32) + p_72936_3_;
                int j3 = ((j1 >> 12 & 0x3f) - 32) + p_72936_4_;
                int l3 = j1 >> 18 & 0xf;
                int j4 = func_72972_b(p_72936_1_, i2, l2, j3);
                if(j4 == l3)
                {
                    func_72915_b(p_72936_1_, i2, l2, j3, 0);
                    if(l3 > 0)
                    {
                        int i5 = i2 - p_72936_2_;
                        int k5 = l2 - p_72936_3_;
                        int i6 = j3 - p_72936_4_;
                        if(i5 < 0)
                        {
                            i5 = -i5;
                        }
                        if(k5 < 0)
                        {
                            k5 = -k5;
                        }
                        if(i6 < 0)
                        {
                            i6 = -i6;
                        }
                        if(i5 + k5 + i6 < 17)
                        {
                            int k6 = 0;
                            while(k6 < 6) 
                            {
                                int i7 = (k6 % 2) * 2 - 1;
                                int k7 = i2 + (((k6 / 2) % 3) / 2) * i7;
                                int l7 = l2 + (((k6 / 2 + 1) % 3) / 2) * i7;
                                int i8 = j3 + (((k6 / 2 + 2) % 3) / 2) * i7;
                                int k4 = func_72972_b(p_72936_1_, k7, l7, i8);
                                int j8 = Block.field_71971_o[func_72798_a(k7, l7, i8)];
                                if(j8 == 0)
                                {
                                    j8 = 1;
                                }
                                if(k4 == l3 - j8 && j < field_72994_J.length)
                                {
                                    field_72994_J[j++] = (k7 - p_72936_2_) + 32 + ((l7 - p_72936_3_) + 32 << 6) + ((i8 - p_72936_4_) + 32 << 12) + (l3 - j8 << 18);
                                }
                                k6++;
                            }
                        }
                    }
                }
            } while(true);
            i = 0;
        }
        field_72984_F.func_76319_b();
        field_72984_F.func_76320_a("tcp < tcc");
        do
        {
            if(i >= j)
            {
                break;
            }
            int k1 = field_72994_J[i++];
            int j2 = ((k1 & 0x3f) - 32) + p_72936_2_;
            int i3 = ((k1 >> 6 & 0x3f) - 32) + p_72936_3_;
            int k3 = ((k1 >> 12 & 0x3f) - 32) + p_72936_4_;
            int i4 = func_72972_b(p_72936_1_, j2, i3, k3);
            int l4 = func_72798_a(j2, i3, k3);
            int j5 = Block.field_71971_o[l4];
            if(j5 == 0)
            {
                j5 = 1;
            }
            int l5 = 0;
            if(p_72936_1_ == EnumSkyBlock.Sky)
            {
                l5 = func_72949_a(i4, j2, i3, k3, l4, j5);
            } else
            {
                l5 = func_72895_f(i4, j2, i3, k3, l4, j5);
            }
            if(l5 != i4)
            {
                func_72915_b(p_72936_1_, j2, i3, k3, l5);
                if(l5 > i4)
                {
                    int j6 = j2 - p_72936_2_;
                    int l6 = i3 - p_72936_3_;
                    int j7 = k3 - p_72936_4_;
                    if(j6 < 0)
                    {
                        j6 = -j6;
                    }
                    if(l6 < 0)
                    {
                        l6 = -l6;
                    }
                    if(j7 < 0)
                    {
                        j7 = -j7;
                    }
                    if(j6 + l6 + j7 < 17 && j < field_72994_J.length - 6)
                    {
                        if(func_72972_b(p_72936_1_, j2 - 1, i3, k3) < l5)
                        {
                            field_72994_J[j++] = (j2 - 1 - p_72936_2_) + 32 + ((i3 - p_72936_3_) + 32 << 6) + ((k3 - p_72936_4_) + 32 << 12);
                        }
                        if(func_72972_b(p_72936_1_, j2 + 1, i3, k3) < l5)
                        {
                            field_72994_J[j++] = ((j2 + 1) - p_72936_2_) + 32 + ((i3 - p_72936_3_) + 32 << 6) + ((k3 - p_72936_4_) + 32 << 12);
                        }
                        if(func_72972_b(p_72936_1_, j2, i3 - 1, k3) < l5)
                        {
                            field_72994_J[j++] = (j2 - p_72936_2_) + 32 + ((i3 - 1 - p_72936_3_) + 32 << 6) + ((k3 - p_72936_4_) + 32 << 12);
                        }
                        if(func_72972_b(p_72936_1_, j2, i3 + 1, k3) < l5)
                        {
                            field_72994_J[j++] = (j2 - p_72936_2_) + 32 + (((i3 + 1) - p_72936_3_) + 32 << 6) + ((k3 - p_72936_4_) + 32 << 12);
                        }
                        if(func_72972_b(p_72936_1_, j2, i3, k3 - 1) < l5)
                        {
                            field_72994_J[j++] = (j2 - p_72936_2_) + 32 + ((i3 - p_72936_3_) + 32 << 6) + ((k3 - 1 - p_72936_4_) + 32 << 12);
                        }
                        if(func_72972_b(p_72936_1_, j2, i3, k3 + 1) < l5)
                        {
                            field_72994_J[j++] = (j2 - p_72936_2_) + 32 + ((i3 - p_72936_3_) + 32 << 6) + (((k3 + 1) - p_72936_4_) + 32 << 12);
                        }
                    }
                }
            }
        } while(true);
        field_72984_F.func_76319_b();
    }

    public boolean func_72955_a(boolean p_72955_1_)
    {
        return false;
    }

    public List func_72920_a(Chunk p_72920_1_, boolean p_72920_2_)
    {
        return null;
    }

    public List func_72839_b(Entity p_72839_1_, AxisAlignedBB p_72839_2_)
    {
        field_72991_N.clear();
        int i = MathHelper.func_76128_c((p_72839_2_.field_72340_a - 2D) / 16D);
        int j = MathHelper.func_76128_c((p_72839_2_.field_72336_d + 2D) / 16D);
        int k = MathHelper.func_76128_c((p_72839_2_.field_72339_c - 2D) / 16D);
        int l = MathHelper.func_76128_c((p_72839_2_.field_72334_f + 2D) / 16D);
        for(int i1 = i; i1 <= j; i1++)
        {
            for(int j1 = k; j1 <= l; j1++)
            {
                if(func_72916_c(i1, j1))
                {
                    func_72964_e(i1, j1).func_76588_a(p_72839_1_, p_72839_2_, field_72991_N);
                }
            }

        }

        return field_72991_N;
    }

    public List func_72872_a(Class p_72872_1_, AxisAlignedBB p_72872_2_)
    {
        int i = MathHelper.func_76128_c((p_72872_2_.field_72340_a - 2D) / 16D);
        int j = MathHelper.func_76128_c((p_72872_2_.field_72336_d + 2D) / 16D);
        int k = MathHelper.func_76128_c((p_72872_2_.field_72339_c - 2D) / 16D);
        int l = MathHelper.func_76128_c((p_72872_2_.field_72334_f + 2D) / 16D);
        ArrayList arraylist = new ArrayList();
        for(int i1 = i; i1 <= j; i1++)
        {
            for(int j1 = k; j1 <= l; j1++)
            {
                if(func_72916_c(i1, j1))
                {
                    func_72964_e(i1, j1).func_76618_a(p_72872_1_, p_72872_2_, arraylist);
                }
            }

        }

        return arraylist;
    }

    public Entity func_72857_a(Class p_72857_1_, AxisAlignedBB p_72857_2_, Entity p_72857_3_)
    {
        List list = func_72872_a(p_72857_1_, p_72857_2_);
        Entity entity = null;
        double d = 1.7976931348623157E+308D;
        Iterator iterator = list.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            Entity entity1 = (Entity)iterator.next();
            if(entity1 != p_72857_3_)
            {
                double d1 = p_72857_3_.func_70068_e(entity1);
                if(d1 <= d)
                {
                    entity = entity1;
                    d = d1;
                }
            }
        } while(true);
        return entity;
    }

    public List func_72910_y()
    {
        return field_72996_f;
    }

    public void func_72944_b(int p_72944_1_, int p_72944_2_, int p_72944_3_, TileEntity p_72944_4_)
    {
        if(func_72899_e(p_72944_1_, p_72944_2_, p_72944_3_))
        {
            func_72938_d(p_72944_1_, p_72944_3_).func_76630_e();
        }
    }

    public int func_72907_a(Class p_72907_1_)
    {
        int i = 0;
        for(int j = 0; j < field_72996_f.size(); j++)
        {
            Entity entity = (Entity)field_72996_f.get(j);
            if(p_72907_1_.isAssignableFrom(entity.getClass()))
            {
                i++;
            }
        }

        return i;
    }

    public void func_72868_a(List p_72868_1_)
    {
        field_72996_f.addAll(p_72868_1_);
        for(int i = 0; i < p_72868_1_.size(); i++)
        {
            func_72923_a((Entity)p_72868_1_.get(i));
        }

    }

    public void func_72828_b(List p_72828_1_)
    {
        field_72997_g.addAll(p_72828_1_);
    }

    public boolean func_72931_a(int p_72931_1_, int p_72931_2_, int p_72931_3_, int p_72931_4_, boolean p_72931_5_, int p_72931_6_, Entity p_72931_7_)
    {
        int i = func_72798_a(p_72931_2_, p_72931_3_, p_72931_4_);
        Block block = Block.field_71973_m[i];
        Block block1 = Block.field_71973_m[p_72931_1_];
        AxisAlignedBB axisalignedbb = block1.func_71872_e(this, p_72931_2_, p_72931_3_, p_72931_4_);
        if(p_72931_5_)
        {
            axisalignedbb = null;
        }
        if(axisalignedbb != null && !func_72917_a(axisalignedbb, p_72931_7_))
        {
            return false;
        }
        if(block != null && (block == Block.field_71942_A || block == Block.field_71943_B || block == Block.field_71944_C || block == Block.field_71938_D || block == Block.field_72067_ar || block.field_72018_cp.func_76222_j()))
        {
            block = null;
        }
        return p_72931_1_ > 0 && block == null && block1.func_71850_a_(this, p_72931_2_, p_72931_3_, p_72931_4_, p_72931_6_);
    }

    public PathEntity func_72865_a(Entity p_72865_1_, Entity p_72865_2_, float p_72865_3_, boolean p_72865_4_, boolean p_72865_5_, boolean p_72865_6_, boolean p_72865_7_)
    {
        field_72984_F.func_76320_a("pathfind");
        int i = MathHelper.func_76128_c(p_72865_1_.field_70165_t);
        int j = MathHelper.func_76128_c(p_72865_1_.field_70163_u + 1.0D);
        int k = MathHelper.func_76128_c(p_72865_1_.field_70161_v);
        int l = (int)(p_72865_3_ + 16F);
        int i1 = i - l;
        int j1 = j - l;
        int k1 = k - l;
        int l1 = i + l;
        int i2 = j + l;
        int j2 = k + l;
        ChunkCache chunkcache = new ChunkCache(this, i1, j1, k1, l1, i2, j2);
        PathEntity pathentity = (new PathFinder(chunkcache, p_72865_4_, p_72865_5_, p_72865_6_, p_72865_7_)).func_75856_a(p_72865_1_, p_72865_2_, p_72865_3_);
        field_72984_F.func_76319_b();
        return pathentity;
    }

    public PathEntity func_72844_a(Entity p_72844_1_, int p_72844_2_, int p_72844_3_, int p_72844_4_, float p_72844_5_, boolean p_72844_6_, boolean p_72844_7_, 
            boolean p_72844_8_, boolean p_72844_9_)
    {
        field_72984_F.func_76320_a("pathfind");
        int i = MathHelper.func_76128_c(p_72844_1_.field_70165_t);
        int j = MathHelper.func_76128_c(p_72844_1_.field_70163_u);
        int k = MathHelper.func_76128_c(p_72844_1_.field_70161_v);
        int l = (int)(p_72844_5_ + 8F);
        int i1 = i - l;
        int j1 = j - l;
        int k1 = k - l;
        int l1 = i + l;
        int i2 = j + l;
        int j2 = k + l;
        ChunkCache chunkcache = new ChunkCache(this, i1, j1, k1, l1, i2, j2);
        PathEntity pathentity = (new PathFinder(chunkcache, p_72844_6_, p_72844_7_, p_72844_8_, p_72844_9_)).func_75859_a(p_72844_1_, p_72844_2_, p_72844_3_, p_72844_4_, p_72844_5_);
        field_72984_F.func_76319_b();
        return pathentity;
    }

    public boolean func_72879_k(int p_72879_1_, int p_72879_2_, int p_72879_3_, int p_72879_4_)
    {
        int i = func_72798_a(p_72879_1_, p_72879_2_, p_72879_3_);
        if(i == 0)
        {
            return false;
        } else
        {
            return Block.field_71973_m[i].func_71855_c(this, p_72879_1_, p_72879_2_, p_72879_3_, p_72879_4_);
        }
    }

    public boolean func_72871_y(int p_72871_1_, int p_72871_2_, int p_72871_3_)
    {
        if(func_72879_k(p_72871_1_, p_72871_2_ - 1, p_72871_3_, 0))
        {
            return true;
        }
        if(func_72879_k(p_72871_1_, p_72871_2_ + 1, p_72871_3_, 1))
        {
            return true;
        }
        if(func_72879_k(p_72871_1_, p_72871_2_, p_72871_3_ - 1, 2))
        {
            return true;
        }
        if(func_72879_k(p_72871_1_, p_72871_2_, p_72871_3_ + 1, 3))
        {
            return true;
        }
        if(func_72879_k(p_72871_1_ - 1, p_72871_2_, p_72871_3_, 4))
        {
            return true;
        }
        return func_72879_k(p_72871_1_ + 1, p_72871_2_, p_72871_3_, 5);
    }

    public boolean func_72878_l(int p_72878_1_, int p_72878_2_, int p_72878_3_, int p_72878_4_)
    {
        if(func_72809_s(p_72878_1_, p_72878_2_, p_72878_3_))
        {
            return func_72871_y(p_72878_1_, p_72878_2_, p_72878_3_);
        }
        int i = func_72798_a(p_72878_1_, p_72878_2_, p_72878_3_);
        if(i == 0)
        {
            return false;
        } else
        {
            return Block.field_71973_m[i].func_71865_a(this, p_72878_1_, p_72878_2_, p_72878_3_, p_72878_4_);
        }
    }

    public boolean func_72864_z(int p_72864_1_, int p_72864_2_, int p_72864_3_)
    {
        if(func_72878_l(p_72864_1_, p_72864_2_ - 1, p_72864_3_, 0))
        {
            return true;
        }
        if(func_72878_l(p_72864_1_, p_72864_2_ + 1, p_72864_3_, 1))
        {
            return true;
        }
        if(func_72878_l(p_72864_1_, p_72864_2_, p_72864_3_ - 1, 2))
        {
            return true;
        }
        if(func_72878_l(p_72864_1_, p_72864_2_, p_72864_3_ + 1, 3))
        {
            return true;
        }
        if(func_72878_l(p_72864_1_ - 1, p_72864_2_, p_72864_3_, 4))
        {
            return true;
        }
        return func_72878_l(p_72864_1_ + 1, p_72864_2_, p_72864_3_, 5);
    }

    public EntityPlayer func_72890_a(Entity p_72890_1_, double p_72890_2_)
    {
        return func_72977_a(p_72890_1_.field_70165_t, p_72890_1_.field_70163_u, p_72890_1_.field_70161_v, p_72890_2_);
    }

    public EntityPlayer func_72977_a(double p_72977_1_, double p_72977_3_, double p_72977_5_, double p_72977_7_)
    {
        double d = -1D;
        EntityPlayer entityplayer = null;
        for(int i = 0; i < field_73010_i.size(); i++)
        {
            EntityPlayer entityplayer1 = (EntityPlayer)field_73010_i.get(i);
            double d1 = entityplayer1.func_70092_e(p_72977_1_, p_72977_3_, p_72977_5_);
            if((p_72977_7_ < 0.0D || d1 < p_72977_7_ * p_72977_7_) && (d == -1D || d1 < d))
            {
                d = d1;
                entityplayer = entityplayer1;
            }
        }

        return entityplayer;
    }

    public EntityPlayer func_72856_b(Entity p_72856_1_, double p_72856_2_)
    {
        return func_72846_b(p_72856_1_.field_70165_t, p_72856_1_.field_70163_u, p_72856_1_.field_70161_v, p_72856_2_);
    }

    public EntityPlayer func_72846_b(double p_72846_1_, double p_72846_3_, double p_72846_5_, double p_72846_7_)
    {
        double d = -1D;
        EntityPlayer entityplayer = null;
        for(int i = 0; i < field_73010_i.size(); i++)
        {
            EntityPlayer entityplayer1 = (EntityPlayer)field_73010_i.get(i);
            if(entityplayer1.field_71075_bZ.field_75102_a)
            {
                continue;
            }
            double d1 = entityplayer1.func_70092_e(p_72846_1_, p_72846_3_, p_72846_5_);
            if((p_72846_7_ < 0.0D || d1 < p_72846_7_ * p_72846_7_) && (d == -1D || d1 < d))
            {
                d = d1;
                entityplayer = entityplayer1;
            }
        }

        return entityplayer;
    }

    public EntityPlayer func_72924_a(String p_72924_1_)
    {
        for(int i = 0; i < field_73010_i.size(); i++)
        {
            if(p_72924_1_.equals(((EntityPlayer)field_73010_i.get(i)).field_71092_bJ))
            {
                return (EntityPlayer)field_73010_i.get(i);
            }
        }

        return null;
    }

    public void func_72882_A()
    {
    }

    public void func_72906_B()
        throws MinecraftException
    {
        field_73019_z.func_75762_c();
    }

    public void func_72877_b(long p_72877_1_)
    {
        field_72986_A.func_76068_b(p_72877_1_);
    }

    public long func_72905_C()
    {
        return field_72986_A.func_76063_b();
    }

    public long func_72820_D()
    {
        return field_72986_A.func_76073_f();
    }

    public ChunkCoordinates func_72861_E()
    {
        return new ChunkCoordinates(field_72986_A.func_76079_c(), field_72986_A.func_76075_d(), field_72986_A.func_76074_e());
    }

    public void func_72950_A(int p_72950_1_, int p_72950_2_, int p_72950_3_)
    {
        field_72986_A.func_76081_a(p_72950_1_, p_72950_2_, p_72950_3_);
    }

    public void func_72897_h(Entity p_72897_1_)
    {
        int i = MathHelper.func_76128_c(p_72897_1_.field_70165_t / 16D);
        int j = MathHelper.func_76128_c(p_72897_1_.field_70161_v / 16D);
        byte byte0 = 2;
        for(int k = i - byte0; k <= i + byte0; k++)
        {
            for(int l = j - byte0; l <= j + byte0; l++)
            {
                func_72964_e(k, l);
            }

        }

        if(!field_72996_f.contains(p_72897_1_))
        {
            field_72996_f.add(p_72897_1_);
        }
    }

    public boolean func_72962_a(EntityPlayer p_72962_1_, int p_72962_2_, int p_72962_3_, int i)
    {
        return true;
    }

    public void func_72960_a(Entity entity, byte byte0)
    {
    }

    public IChunkProvider func_72863_F()
    {
        return field_73020_y;
    }

    public void func_72965_b(int p_72965_1_, int p_72965_2_, int p_72965_3_, int p_72965_4_, int p_72965_5_, int p_72965_6_)
    {
        if(p_72965_4_ > 0)
        {
            Block.field_71973_m[p_72965_4_].func_71883_b(this, p_72965_1_, p_72965_2_, p_72965_3_, p_72965_5_, p_72965_6_);
        }
    }

    public ISaveHandler func_72860_G()
    {
        return field_73019_z;
    }

    public WorldInfo func_72912_H()
    {
        return field_72986_A;
    }

    public void func_72854_c()
    {
    }

    public float func_72819_i(float p_72819_1_)
    {
        return (field_73018_p + (field_73017_q - field_73018_p) * p_72819_1_) * func_72867_j(p_72819_1_);
    }

    public float func_72867_j(float p_72867_1_)
    {
        return field_73003_n + (field_73004_o - field_73003_n) * p_72867_1_;
    }

    public void func_72894_k(float p_72894_1_)
    {
        field_73003_n = p_72894_1_;
        field_73004_o = p_72894_1_;
    }

    public boolean func_72911_I()
    {
        return (double)func_72819_i(1.0F) > 0.90000000000000002D;
    }

    public boolean func_72896_J()
    {
        return (double)func_72867_j(1.0F) > 0.20000000000000001D;
    }

    public boolean func_72951_B(int p_72951_1_, int p_72951_2_, int p_72951_3_)
    {
        if(!func_72896_J())
        {
            return false;
        }
        if(!func_72937_j(p_72951_1_, p_72951_2_, p_72951_3_))
        {
            return false;
        }
        if(func_72874_g(p_72951_1_, p_72951_3_) > p_72951_2_)
        {
            return false;
        }
        BiomeGenBase biomegenbase = func_72807_a(p_72951_1_, p_72951_3_);
        if(biomegenbase.func_76746_c())
        {
            return false;
        } else
        {
            return biomegenbase.func_76738_d();
        }
    }

    public boolean func_72958_C(int p_72958_1_, int p_72958_2_, int p_72958_3_)
    {
        BiomeGenBase biomegenbase = func_72807_a(p_72958_1_, p_72958_3_);
        return biomegenbase.func_76736_e();
    }

    public void func_72823_a(String p_72823_1_, WorldSavedData p_72823_2_)
    {
        field_72988_C.func_75745_a(p_72823_1_, p_72823_2_);
    }

    public WorldSavedData func_72943_a(Class p_72943_1_, String p_72943_2_)
    {
        return field_72988_C.func_75742_a(p_72943_1_, p_72943_2_);
    }

    public int func_72841_b(String p_72841_1_)
    {
        return field_72988_C.func_75743_a(p_72841_1_);
    }

    public void func_72926_e(int p_72926_1_, int p_72926_2_, int p_72926_3_, int p_72926_4_, int p_72926_5_)
    {
        func_72889_a(null, p_72926_1_, p_72926_2_, p_72926_3_, p_72926_4_, p_72926_5_);
    }

    public void func_72889_a(EntityPlayer p_72889_1_, int p_72889_2_, int p_72889_3_, int p_72889_4_, int p_72889_5_, int p_72889_6_)
    {
        for(int i = 0; i < field_73021_x.size(); i++)
        {
            ((IWorldAccess)field_73021_x.get(i)).func_72706_a(p_72889_1_, p_72889_2_, p_72889_3_, p_72889_4_, p_72889_5_, p_72889_6_);
        }

    }

    public int func_72800_K()
    {
        return 256;
    }

    public int func_72940_L()
    {
        return field_73011_w.field_76576_e ? 128 : '\u0100';
    }

    public Random func_72843_D(int p_72843_1_, int p_72843_2_, int p_72843_3_)
    {
        long l = (long)p_72843_1_ * 0x4f9939f508L + (long)p_72843_2_ * 0x1ef1565bd5L + func_72912_H().func_76063_b() + (long)p_72843_3_;
        field_73012_v.setSeed(l);
        return field_73012_v;
    }

    public boolean func_72968_M()
    {
        return false;
    }

    public ChunkPosition func_72946_b(String p_72946_1_, int p_72946_2_, int p_72946_3_, int p_72946_4_)
    {
        return func_72863_F().func_73150_a(this, p_72946_1_, p_72946_2_, p_72946_3_, p_72946_4_);
    }

    public boolean func_72806_N()
    {
        return false;
    }

    public double func_72919_O()
    {
        return field_72986_A.func_76067_t() != WorldType.field_77138_c ? 63D : 0.0D;
    }

    public CrashReport func_72914_a(CrashReport p_72914_1_)
    {
        p_72914_1_.func_71500_a((new StringBuilder()).append("World ").append(field_72986_A.func_76065_j()).append(" Entities").toString(), new CallableLvl1(this));
        p_72914_1_.func_71500_a((new StringBuilder()).append("World ").append(field_72986_A.func_76065_j()).append(" Players").toString(), new CallableLvl2(this));
        p_72914_1_.func_71500_a((new StringBuilder()).append("World ").append(field_72986_A.func_76065_j()).append(" Chunk Stats").toString(), new CallableLvl3(this));
        return p_72914_1_;
    }

    public void func_72888_f(int p_72888_1_, int p_72888_2_, int p_72888_3_, int p_72888_4_, int p_72888_5_)
    {
        IWorldAccess iworldaccess;
        for(Iterator iterator = field_73021_x.iterator(); iterator.hasNext(); iworldaccess.func_72705_a(p_72888_1_, p_72888_2_, p_72888_3_, p_72888_4_, p_72888_5_))
        {
            iworldaccess = (IWorldAccess)iterator.next();
        }

    }
}
