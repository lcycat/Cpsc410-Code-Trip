// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.PrintStream;
import java.util.*;
import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            World, WorldProvider, ServerBlockEventList, EntityTracker, 
//            PlayerManager, ServerConfigurationManager, IntHashMap, WorldInfo, 
//            WorldChunkManager, Profiler, SpawnerAnimals, IChunkProvider, 
//            VillageCollection, VillageSiege, WeightedRandom, SpawnListEntry, 
//            EntityPlayer, ChunkCoordIntPair, Chunk, EntityLightningBolt, 
//            Block, BiomeGenBase, ExtendedBlockStorage, NextTickListEntry, 
//            EntityAnimal, EntityWaterMob, Entity, INpc, 
//            ISaveHandler, ChunkProviderServer, TileEntity, MathHelper, 
//            ChunkPosition, WorldSettings, WorldGeneratorBonusChest, MinecraftException, 
//            IProgressUpdate, MapStorage, Packet71Weather, Packet38EntityStatus, 
//            Explosion, EntityPlayerMP, Packet60Explosion, Vec3, 
//            NetServerHandler, BlockEventData, Packet54PlayNoteBlock, Packet70GameEvent, 
//            WeightedRandomChestContent, Item, EnumCreatureType, ChunkCoordinates

public class WorldServer extends World
{

    private final MinecraftServer field_73061_a;
    private final EntityTracker field_73062_L = new EntityTracker(this);
    private final PlayerManager field_73063_M;
    private Set field_73064_N;
    private TreeSet field_73065_O;
    public ChunkProviderServer field_73059_b;
    public boolean field_73060_c;
    public boolean field_73058_d;
    private boolean field_73068_P;
    private ServerBlockEventList field_73067_Q[] = {
        new ServerBlockEventList(null), new ServerBlockEventList(null)
    };
    private int field_73070_R;
    private static final WeightedRandomChestContent field_73069_S[];
    private IntHashMap field_73066_T;

    public WorldServer(MinecraftServer p_i3395_1_, ISaveHandler p_i3395_2_, String p_i3395_3_, int p_i3395_4_, WorldSettings p_i3395_5_, Profiler p_i3395_6_)
    {
        super(p_i3395_2_, p_i3395_3_, p_i3395_5_, WorldProvider.func_76570_a(p_i3395_4_), p_i3395_6_);
        field_73060_c = false;
        field_73070_R = 0;
        field_73061_a = p_i3395_1_;
        field_73063_M = new PlayerManager(this, p_i3395_1_.func_71203_ab().func_72395_o());
        if(field_73066_T == null)
        {
            field_73066_T = new IntHashMap();
        }
        if(field_73064_N == null)
        {
            field_73064_N = new HashSet();
        }
        if(field_73065_O == null)
        {
            field_73065_O = new TreeSet();
        }
    }

    public void func_72835_b()
    {
        super.func_72835_b();
        if(func_72912_H().func_76093_s() && field_73013_u < 3)
        {
            field_73013_u = 3;
        }
        field_73011_w.field_76578_c.func_76938_b();
        if(func_73056_e())
        {
            boolean flag = false;
            if(field_72985_G)
            {
                if(field_73013_u < 1);
            }
            if(!flag)
            {
                long l = field_72986_A.func_76073_f() + 24000L;
                field_72986_A.func_76068_b(l - l % 24000L);
                func_73053_d();
            }
        }
        field_72984_F.func_76320_a("mobSpawner");
        SpawnerAnimals.func_77192_a(this, field_72985_G, field_72992_H && field_72986_A.func_76073_f() % 400L == 0L);
        field_72984_F.func_76318_c("chunkSource");
        field_73020_y.func_73156_b();
        int i = func_72967_a(1.0F);
        if(i != field_73008_k)
        {
            field_73008_k = i;
        }
        func_73055_Q();
        field_72986_A.func_76068_b(field_72986_A.func_76073_f() + 1L);
        field_72984_F.func_76318_c("tickPending");
        func_72955_a(false);
        field_72984_F.func_76318_c("tickTiles");
        func_72893_g();
        field_72984_F.func_76318_c("chunkMap");
        field_73063_M.func_72693_b();
        field_72984_F.func_76318_c("village");
        field_72982_D.func_75544_a();
        field_72983_E.func_75528_a();
        field_72984_F.func_76319_b();
        func_73055_Q();
    }

    public SpawnListEntry func_73057_a(EnumCreatureType p_73057_1_, int p_73057_2_, int p_73057_3_, int p_73057_4_)
    {
        List list = func_72863_F().func_73155_a(p_73057_1_, p_73057_2_, p_73057_3_, p_73057_4_);
        if(list == null || list.isEmpty())
        {
            return null;
        } else
        {
            return (SpawnListEntry)WeightedRandom.func_76271_a(field_73012_v, list);
        }
    }

    public void func_72854_c()
    {
        field_73068_P = !field_73010_i.isEmpty();
        Iterator iterator = field_73010_i.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            EntityPlayer entityplayer = (EntityPlayer)iterator.next();
            if(entityplayer.func_70608_bn())
            {
                continue;
            }
            field_73068_P = false;
            break;
        } while(true);
    }

    protected void func_73053_d()
    {
        field_73068_P = false;
        Iterator iterator = field_73010_i.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            EntityPlayer entityplayer = (EntityPlayer)iterator.next();
            if(entityplayer.func_70608_bn())
            {
                entityplayer.func_70999_a(false, false, true);
            }
        } while(true);
        func_73051_P();
    }

    private void func_73051_P()
    {
        field_72986_A.func_76080_g(0);
        field_72986_A.func_76084_b(false);
        field_72986_A.func_76090_f(0);
        field_72986_A.func_76069_a(false);
    }

    public boolean func_73056_e()
    {
        if(field_73068_P && !field_72995_K)
        {
            for(Iterator iterator = field_73010_i.iterator(); iterator.hasNext();)
            {
                EntityPlayer entityplayer = (EntityPlayer)iterator.next();
                if(!entityplayer.func_71026_bH())
                {
                    return false;
                }
            }

            return true;
        } else
        {
            return false;
        }
    }

    protected void func_72893_g()
    {
        super.func_72893_g();
        int i = 0;
        int j = 0;
        for(Iterator iterator = field_72993_I.iterator(); iterator.hasNext(); field_72984_F.func_76319_b())
        {
            ChunkCoordIntPair chunkcoordintpair = (ChunkCoordIntPair)iterator.next();
            int k = chunkcoordintpair.field_77276_a * 16;
            int l = chunkcoordintpair.field_77275_b * 16;
            field_72984_F.func_76320_a("getChunk");
            Chunk chunk = func_72964_e(chunkcoordintpair.field_77276_a, chunkcoordintpair.field_77275_b);
            func_72941_a(k, l, chunk);
            field_72984_F.func_76318_c("tickChunk");
            chunk.func_76586_k();
            field_72984_F.func_76318_c("thunder");
            if(field_73012_v.nextInt(0x186a0) == 0 && func_72896_J() && func_72911_I())
            {
                field_73005_l = field_73005_l * 3 + 0x3c6ef35f;
                int i1 = field_73005_l >> 2;
                int k1 = k + (i1 & 0xf);
                int j2 = l + (i1 >> 8 & 0xf);
                int i3 = func_72874_g(k1, j2);
                if(func_72951_B(k1, i3, j2))
                {
                    func_72942_c(new EntityLightningBolt(this, k1, i3, j2));
                    field_73016_r = 2;
                }
            }
            field_72984_F.func_76318_c("iceandsnow");
            if(field_73012_v.nextInt(16) == 0)
            {
                field_73005_l = field_73005_l * 3 + 0x3c6ef35f;
                int j1 = field_73005_l >> 2;
                int l1 = j1 & 0xf;
                int k2 = j1 >> 8 & 0xf;
                int j3 = func_72874_g(l1 + k, k2 + l);
                if(func_72850_v(l1 + k, j3 - 1, k2 + l))
                {
                    func_72859_e(l1 + k, j3 - 1, k2 + l, Block.field_72036_aT.field_71990_ca);
                }
                if(func_72896_J() && func_72858_w(l1 + k, j3, k2 + l))
                {
                    func_72859_e(l1 + k, j3, k2 + l, Block.field_72037_aS.field_71990_ca);
                }
                if(func_72896_J())
                {
                    BiomeGenBase biomegenbase = func_72807_a(l1 + k, k2 + l);
                    if(biomegenbase.func_76738_d())
                    {
                        int l3 = func_72798_a(l1 + k, j3 - 1, k2 + l);
                        if(l3 != 0)
                        {
                            Block.field_71973_m[l3].func_71892_f(this, l1 + k, j3 - 1, k2 + l);
                        }
                    }
                }
            }
            field_72984_F.func_76318_c("tickTiles");
            ExtendedBlockStorage aextendedblockstorage[] = chunk.func_76587_i();
            int i2 = aextendedblockstorage.length;
            for(int l2 = 0; l2 < i2; l2++)
            {
                ExtendedBlockStorage extendedblockstorage = aextendedblockstorage[l2];
                if(extendedblockstorage == null || !extendedblockstorage.func_76675_b())
                {
                    continue;
                }
                for(int k3 = 0; k3 < 3; k3++)
                {
                    field_73005_l = field_73005_l * 3 + 0x3c6ef35f;
                    int i4 = field_73005_l >> 2;
                    int j4 = i4 & 0xf;
                    int k4 = i4 >> 8 & 0xf;
                    int l4 = i4 >> 16 & 0xf;
                    int i5 = extendedblockstorage.func_76656_a(j4, l4, k4);
                    j++;
                    Block block = Block.field_71973_m[i5];
                    if(block != null && block.func_71881_r())
                    {
                        i++;
                        block.func_71847_b(this, j4 + k, l4 + extendedblockstorage.func_76662_d(), k4 + l, field_73012_v);
                    }
                }

            }

        }

    }

    public void func_72836_a(int p_72836_1_, int p_72836_2_, int p_72836_3_, int p_72836_4_, int p_72836_5_)
    {
        NextTickListEntry nextticklistentry = new NextTickListEntry(p_72836_1_, p_72836_2_, p_72836_3_, p_72836_4_);
        byte byte0 = 8;
        if(field_72999_e)
        {
            if(func_72904_c(nextticklistentry.field_77183_a - byte0, nextticklistentry.field_77181_b - byte0, nextticklistentry.field_77182_c - byte0, nextticklistentry.field_77183_a + byte0, nextticklistentry.field_77181_b + byte0, nextticklistentry.field_77182_c + byte0))
            {
                int i = func_72798_a(nextticklistentry.field_77183_a, nextticklistentry.field_77181_b, nextticklistentry.field_77182_c);
                if(i == nextticklistentry.field_77179_d && i > 0)
                {
                    Block.field_71973_m[i].func_71847_b(this, nextticklistentry.field_77183_a, nextticklistentry.field_77181_b, nextticklistentry.field_77182_c, field_73012_v);
                }
            }
            return;
        }
        if(func_72904_c(p_72836_1_ - byte0, p_72836_2_ - byte0, p_72836_3_ - byte0, p_72836_1_ + byte0, p_72836_2_ + byte0, p_72836_3_ + byte0))
        {
            if(p_72836_4_ > 0)
            {
                nextticklistentry.func_77176_a((long)p_72836_5_ + field_72986_A.func_76073_f());
            }
            if(!field_73064_N.contains(nextticklistentry))
            {
                field_73064_N.add(nextticklistentry);
                field_73065_O.add(nextticklistentry);
            }
        }
    }

    public void func_72892_b(int p_72892_1_, int p_72892_2_, int p_72892_3_, int p_72892_4_, int p_72892_5_)
    {
        NextTickListEntry nextticklistentry = new NextTickListEntry(p_72892_1_, p_72892_2_, p_72892_3_, p_72892_4_);
        if(p_72892_4_ > 0)
        {
            nextticklistentry.func_77176_a((long)p_72892_5_ + field_72986_A.func_76073_f());
        }
        if(!field_73064_N.contains(nextticklistentry))
        {
            field_73064_N.add(nextticklistentry);
            field_73065_O.add(nextticklistentry);
        }
    }

    public boolean func_72955_a(boolean p_72955_1_)
    {
        int i = field_73065_O.size();
        if(i != field_73064_N.size())
        {
            throw new IllegalStateException("TickNextTick list out of synch");
        }
        if(i > 1000)
        {
            i = 1000;
        }
        for(int j = 0; j < i; j++)
        {
            NextTickListEntry nextticklistentry = (NextTickListEntry)field_73065_O.first();
            if(!p_72955_1_ && nextticklistentry.field_77180_e > field_72986_A.func_76073_f())
            {
                break;
            }
            field_73065_O.remove(nextticklistentry);
            field_73064_N.remove(nextticklistentry);
            byte byte0 = 8;
            if(!func_72904_c(nextticklistentry.field_77183_a - byte0, nextticklistentry.field_77181_b - byte0, nextticklistentry.field_77182_c - byte0, nextticklistentry.field_77183_a + byte0, nextticklistentry.field_77181_b + byte0, nextticklistentry.field_77182_c + byte0))
            {
                continue;
            }
            int k = func_72798_a(nextticklistentry.field_77183_a, nextticklistentry.field_77181_b, nextticklistentry.field_77182_c);
            if(k == nextticklistentry.field_77179_d && k > 0)
            {
                Block.field_71973_m[k].func_71847_b(this, nextticklistentry.field_77183_a, nextticklistentry.field_77181_b, nextticklistentry.field_77182_c, field_73012_v);
            }
        }

        return !field_73065_O.isEmpty();
    }

    public List func_72920_a(Chunk p_72920_1_, boolean p_72920_2_)
    {
        ArrayList arraylist = null;
        ChunkCoordIntPair chunkcoordintpair = p_72920_1_.func_76632_l();
        int i = chunkcoordintpair.field_77276_a << 4;
        int j = i + 16;
        int k = chunkcoordintpair.field_77275_b << 4;
        int l = k + 16;
        Iterator iterator = field_73065_O.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            NextTickListEntry nextticklistentry = (NextTickListEntry)iterator.next();
            if(nextticklistentry.field_77183_a >= i && nextticklistentry.field_77183_a < j && nextticklistentry.field_77182_c >= k && nextticklistentry.field_77182_c < l)
            {
                if(p_72920_2_)
                {
                    field_73064_N.remove(nextticklistentry);
                    iterator.remove();
                }
                if(arraylist == null)
                {
                    arraylist = new ArrayList();
                }
                arraylist.add(nextticklistentry);
            }
        } while(true);
        return arraylist;
    }

    public void func_72866_a(Entity p_72866_1_, boolean p_72866_2_)
    {
        if(!field_73061_a.func_71268_U() && ((p_72866_1_ instanceof EntityAnimal) || (p_72866_1_ instanceof EntityWaterMob)))
        {
            p_72866_1_.func_70106_y();
        }
        if(!field_73061_a.func_71220_V() && (p_72866_1_ instanceof INpc))
        {
            p_72866_1_.func_70106_y();
        }
        if(!(p_72866_1_.field_70153_n instanceof EntityPlayer))
        {
            super.func_72866_a(p_72866_1_, p_72866_2_);
        }
    }

    public void func_73050_b(Entity p_73050_1_, boolean p_73050_2_)
    {
        super.func_72866_a(p_73050_1_, p_73050_2_);
    }

    protected IChunkProvider func_72970_h()
    {
        IChunkLoader ichunkloader = field_73019_z.func_75763_a(field_73011_w);
        field_73059_b = new ChunkProviderServer(this, ichunkloader, field_73011_w.func_76555_c());
        return field_73059_b;
    }

    public List func_73049_a(int p_73049_1_, int p_73049_2_, int p_73049_3_, int p_73049_4_, int p_73049_5_, int p_73049_6_)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = field_73009_h.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            TileEntity tileentity = (TileEntity)iterator.next();
            if(tileentity.field_70329_l >= p_73049_1_ && tileentity.field_70330_m >= p_73049_2_ && tileentity.field_70327_n >= p_73049_3_ && tileentity.field_70329_l < p_73049_4_ && tileentity.field_70330_m < p_73049_5_ && tileentity.field_70327_n < p_73049_6_)
            {
                arraylist.add(tileentity);
            }
        } while(true);
        return arraylist;
    }

    public boolean func_72962_a(EntityPlayer p_72962_1_, int p_72962_2_, int p_72962_3_, int p_72962_4_)
    {
        int i = MathHelper.func_76130_a(p_72962_2_ - field_72986_A.func_76079_c());
        int j = MathHelper.func_76130_a(p_72962_4_ - field_72986_A.func_76074_e());
        if(i > j)
        {
            j = i;
        }
        return j > 16 || field_73061_a.func_71203_ab().func_72353_e(p_72962_1_.field_71092_bJ) || field_73061_a.func_71264_H();
    }

    protected void func_72963_a(WorldSettings p_72963_1_)
    {
        if(field_73066_T == null)
        {
            field_73066_T = new IntHashMap();
        }
        if(field_73064_N == null)
        {
            field_73064_N = new HashSet();
        }
        if(field_73065_O == null)
        {
            field_73065_O = new TreeSet();
        }
        func_73052_b(p_72963_1_);
        super.func_72963_a(p_72963_1_);
    }

    protected void func_73052_b(WorldSettings p_73052_1_)
    {
        if(!field_73011_w.func_76567_e())
        {
            field_72986_A.func_76081_a(0, field_73011_w.func_76557_i(), 0);
            return;
        }
        field_72987_B = true;
        WorldChunkManager worldchunkmanager = field_73011_w.field_76578_c;
        List list = worldchunkmanager.func_76932_a();
        Random random = new Random(func_72905_C());
        ChunkPosition chunkposition = worldchunkmanager.func_76941_a(0, 0, 256, list, random);
        int i = 0;
        int j = field_73011_w.func_76557_i();
        int k = 0;
        if(chunkposition != null)
        {
            i = chunkposition.field_76930_a;
            k = chunkposition.field_76929_c;
        } else
        {
            System.out.println("Unable to find spawn biome");
        }
        int l = 0;
        do
        {
            if(field_73011_w.func_76566_a(i, k))
            {
                break;
            }
            i += random.nextInt(64) - random.nextInt(64);
            k += random.nextInt(64) - random.nextInt(64);
        } while(++l != 1000);
        field_72986_A.func_76081_a(i, j, k);
        field_72987_B = false;
        if(p_73052_1_.func_77167_c())
        {
            func_73047_i();
        }
    }

    protected void func_73047_i()
    {
        WorldGeneratorBonusChest worldgeneratorbonuschest = new WorldGeneratorBonusChest(field_73069_S, 10);
        int i = 0;
        do
        {
            if(i >= 10)
            {
                break;
            }
            int j = (field_72986_A.func_76079_c() + field_73012_v.nextInt(6)) - field_73012_v.nextInt(6);
            int k = (field_72986_A.func_76074_e() + field_73012_v.nextInt(6)) - field_73012_v.nextInt(6);
            int l = func_72825_h(j, k) + 1;
            if(worldgeneratorbonuschest.func_76484_a(this, field_73012_v, j, l, k))
            {
                break;
            }
            i++;
        } while(true);
    }

    public ChunkCoordinates func_73054_j()
    {
        return field_73011_w.func_76554_h();
    }

    public void func_73044_a(boolean p_73044_1_, IProgressUpdate p_73044_2_)
        throws MinecraftException
    {
        if(!field_73020_y.func_73157_c())
        {
            return;
        }
        if(p_73044_2_ != null)
        {
            p_73044_2_.func_73720_a("Saving level");
        }
        func_73042_a();
        if(p_73044_2_ != null)
        {
            p_73044_2_.func_73719_c("Saving chunks");
        }
        field_73020_y.func_73151_a(p_73044_1_, p_73044_2_);
    }

    protected void func_73042_a()
        throws MinecraftException
    {
        func_72906_B();
        field_73019_z.func_75755_a(field_72986_A, field_73061_a.func_71203_ab().func_72378_q());
        field_72988_C.func_75744_a();
    }

    protected void func_72923_a(Entity p_72923_1_)
    {
        super.func_72923_a(p_72923_1_);
        field_73066_T.func_76038_a(p_72923_1_.field_70157_k, p_72923_1_);
        Entity aentity[] = p_72923_1_.func_70021_al();
        if(aentity != null)
        {
            Entity aentity1[] = aentity;
            int i = aentity1.length;
            for(int j = 0; j < i; j++)
            {
                Entity entity = aentity1[j];
                field_73066_T.func_76038_a(entity.field_70157_k, entity);
            }

        }
    }

    protected void func_72847_b(Entity p_72847_1_)
    {
        super.func_72847_b(p_72847_1_);
        field_73066_T.func_76049_d(p_72847_1_.field_70157_k);
        Entity aentity[] = p_72847_1_.func_70021_al();
        if(aentity != null)
        {
            Entity aentity1[] = aentity;
            int i = aentity1.length;
            for(int j = 0; j < i; j++)
            {
                Entity entity = aentity1[j];
                field_73066_T.func_76049_d(entity.field_70157_k);
            }

        }
    }

    public Entity func_73045_a(int p_73045_1_)
    {
        return (Entity)field_73066_T.func_76041_a(p_73045_1_);
    }

    public boolean func_72942_c(Entity p_72942_1_)
    {
        if(super.func_72942_c(p_72942_1_))
        {
            field_73061_a.func_71203_ab().func_72393_a(p_72942_1_.field_70165_t, p_72942_1_.field_70163_u, p_72942_1_.field_70161_v, 512D, field_73011_w.field_76574_g, new Packet71Weather(p_72942_1_));
            return true;
        } else
        {
            return false;
        }
    }

    public void func_72960_a(Entity p_72960_1_, byte p_72960_2_)
    {
        Packet38EntityStatus packet38entitystatus = new Packet38EntityStatus(p_72960_1_.field_70157_k, p_72960_2_);
        func_73039_n().func_72789_b(p_72960_1_, packet38entitystatus);
    }

    public Explosion func_72885_a(Entity p_72885_1_, double p_72885_2_, double p_72885_4_, double p_72885_6_, 
            float p_72885_8_, boolean p_72885_9_)
    {
        Explosion explosion = new Explosion(this, p_72885_1_, p_72885_2_, p_72885_4_, p_72885_6_, p_72885_8_);
        explosion.field_77286_a = p_72885_9_;
        explosion.func_77278_a();
        explosion.func_77279_a(false);
        Iterator iterator = field_73010_i.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            EntityPlayer entityplayer = (EntityPlayer)iterator.next();
            if(entityplayer.func_70092_e(p_72885_2_, p_72885_4_, p_72885_6_) < 4096D)
            {
                ((EntityPlayerMP)entityplayer).field_71135_a.func_72567_b(new Packet60Explosion(p_72885_2_, p_72885_4_, p_72885_6_, p_72885_8_, explosion.field_77281_g, (Vec3)explosion.func_77277_b().get(entityplayer)));
            }
        } while(true);
        return explosion;
    }

    public void func_72965_b(int p_72965_1_, int p_72965_2_, int p_72965_3_, int p_72965_4_, int p_72965_5_, int p_72965_6_)
    {
        BlockEventData blockeventdata = new BlockEventData(p_72965_1_, p_72965_2_, p_72965_3_, p_72965_4_, p_72965_5_, p_72965_6_);
        for(Iterator iterator = field_73067_Q[field_73070_R].iterator(); iterator.hasNext();)
        {
            BlockEventData blockeventdata1 = (BlockEventData)iterator.next();
            if(blockeventdata1.equals(blockeventdata))
            {
                return;
            }
        }

        field_73067_Q[field_73070_R].add(blockeventdata);
    }

    private void func_73055_Q()
    {
        int i;
label0:
        for(; !field_73067_Q[field_73070_R].isEmpty(); field_73067_Q[i].clear())
        {
            i = field_73070_R;
            field_73070_R ^= 1;
            Iterator iterator = field_73067_Q[i].iterator();
            do
            {
                if(!iterator.hasNext())
                {
                    continue label0;
                }
                BlockEventData blockeventdata = (BlockEventData)iterator.next();
                if(func_73043_a(blockeventdata))
                {
                    field_73061_a.func_71203_ab().func_72393_a(blockeventdata.func_76919_a(), blockeventdata.func_76921_b(), blockeventdata.func_76920_c(), 64D, field_73011_w.field_76574_g, new Packet54PlayNoteBlock(blockeventdata.func_76919_a(), blockeventdata.func_76921_b(), blockeventdata.func_76920_c(), blockeventdata.func_76916_f(), blockeventdata.func_76918_d(), blockeventdata.func_76917_e()));
                }
            } while(true);
        }

    }

    private boolean func_73043_a(BlockEventData p_73043_1_)
    {
        int i = func_72798_a(p_73043_1_.func_76919_a(), p_73043_1_.func_76921_b(), p_73043_1_.func_76920_c());
        if(i == p_73043_1_.func_76916_f())
        {
            Block.field_71973_m[i].func_71883_b(this, p_73043_1_.func_76919_a(), p_73043_1_.func_76921_b(), p_73043_1_.func_76920_c(), p_73043_1_.func_76918_d(), p_73043_1_.func_76917_e());
            return true;
        } else
        {
            return false;
        }
    }

    public void func_73041_k()
    {
        field_73019_z.func_75759_a();
    }

    protected void func_72979_l()
    {
        boolean flag = func_72896_J();
        super.func_72979_l();
        if(flag != func_72896_J())
        {
            if(flag)
            {
                field_73061_a.func_71203_ab().func_72384_a(new Packet70GameEvent(2, 0));
            } else
            {
                field_73061_a.func_71203_ab().func_72384_a(new Packet70GameEvent(1, 0));
            }
        }
    }

    public MinecraftServer func_73046_m()
    {
        return field_73061_a;
    }

    public EntityTracker func_73039_n()
    {
        return field_73062_L;
    }

    public void func_73048_a(long p_73048_1_)
    {
        long l = p_73048_1_ - field_72986_A.func_76073_f();
        for(Iterator iterator = field_73064_N.iterator(); iterator.hasNext();)
        {
            NextTickListEntry nextticklistentry = (NextTickListEntry)iterator.next();
            nextticklistentry.field_77180_e += l;
        }

        Block ablock[] = Block.field_71973_m;
        int i = ablock.length;
        for(int j = 0; j < i; j++)
        {
            Block block = ablock[j];
            if(block != null)
            {
                block.func_71937_a(this, l, p_73048_1_);
            }
        }

        func_72877_b(p_73048_1_);
    }

    public PlayerManager func_73040_p()
    {
        return field_73063_M;
    }

    static 
    {
        field_73069_S = (new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(Item.field_77669_D.field_77779_bT, 0, 1, 3, 10), new WeightedRandomChestContent(Block.field_71988_x.field_71990_ca, 0, 1, 3, 10), new WeightedRandomChestContent(Block.field_71951_J.field_71990_ca, 0, 1, 3, 10), new WeightedRandomChestContent(Item.field_77719_y.field_77779_bT, 0, 1, 1, 3), new WeightedRandomChestContent(Item.field_77712_u.field_77779_bT, 0, 1, 1, 5), new WeightedRandomChestContent(Item.field_77720_x.field_77779_bT, 0, 1, 1, 3), new WeightedRandomChestContent(Item.field_77713_t.field_77779_bT, 0, 1, 1, 5), new WeightedRandomChestContent(Item.field_77706_j.field_77779_bT, 0, 2, 3, 5), new WeightedRandomChestContent(Item.field_77684_U.field_77779_bT, 0, 2, 3, 3)
        });
    }
}
