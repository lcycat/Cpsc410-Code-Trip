// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.File;
import java.net.SocketAddress;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;
import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            BanList, EntityPlayerMP, WorldServer, ItemInWorldManager, 
//            NetworkManager, NetServerHandler, Packet1Login, WorldInfo, 
//            WorldProvider, Packet6SpawnPosition, ChunkCoordinates, Packet202PlayerAbilities, 
//            Packet3Chat, NetworkListenThread, Packet4UpdateTime, PotionEffect, 
//            Packet41EntityEffect, ISaveHandler, PlayerManager, ChunkProviderServer, 
//            IPlayerFileData, Packet201PlayerInfo, BanEntry, DemoWorldManager, 
//            EntityTracker, EntityPlayer, Packet70GameEvent, Packet9Respawn, 
//            World, MathHelper, Teleporter, EnumGameType, 
//            Packet, NBTTagCompound

public abstract class ServerConfigurationManager
{

    private static final SimpleDateFormat field_72403_e = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    public static final Logger field_72406_a = Logger.getLogger("Minecraft");
    private final MinecraftServer field_72400_f;
    public final List field_72404_b = new ArrayList();
    private final BanList field_72401_g = new BanList(new File("banned-players.txt"));
    private final BanList field_72413_h = new BanList(new File("banned-ips.txt"));
    private Set field_72414_i;
    private Set field_72411_j;
    private IPlayerFileData field_72412_k;
    private boolean field_72409_l;
    protected int field_72405_c;
    protected int field_72402_d;
    private EnumGameType field_72410_m;
    private boolean field_72407_n;
    private int field_72408_o;

    public ServerConfigurationManager(MinecraftServer p_i3376_1_)
    {
        field_72414_i = new HashSet();
        field_72411_j = new HashSet();
        field_72408_o = 0;
        field_72400_f = p_i3376_1_;
        field_72401_g.func_73708_a(false);
        field_72413_h.func_73708_a(false);
        field_72405_c = 8;
    }

    public void func_72355_a(NetworkManager p_72355_1_, EntityPlayerMP p_72355_2_)
    {
        func_72380_a(p_72355_2_);
        p_72355_2_.func_70029_a(field_72400_f.func_71218_a(p_72355_2_.field_71093_bK));
        p_72355_2_.field_71134_c.func_73080_a((WorldServer)p_72355_2_.field_70170_p);
        String s = "local";
        if(p_72355_1_.func_74430_c() != null)
        {
            s = p_72355_1_.func_74430_c().toString();
        }
        field_72406_a.info((new StringBuilder()).append(p_72355_2_.field_71092_bJ).append("[").append(s).append("] logged in with entity id ").append(p_72355_2_.field_70157_k).append(" at (").append(p_72355_2_.field_70165_t).append(", ").append(p_72355_2_.field_70163_u).append(", ").append(p_72355_2_.field_70161_v).append(")").toString());
        WorldServer worldserver = field_72400_f.func_71218_a(p_72355_2_.field_71093_bK);
        ChunkCoordinates chunkcoordinates = worldserver.func_72861_E();
        func_72381_a(p_72355_2_, null, worldserver);
        NetServerHandler netserverhandler = new NetServerHandler(field_72400_f, p_72355_1_, p_72355_2_);
        netserverhandler.func_72567_b(new Packet1Login(p_72355_2_.field_70157_k, worldserver.func_72912_H().func_76067_t(), p_72355_2_.field_71134_c.func_73081_b(), worldserver.func_72912_H().func_76093_s(), worldserver.field_73011_w.field_76574_g, worldserver.field_73013_u, worldserver.func_72800_K(), func_72352_l()));
        netserverhandler.func_72567_b(new Packet6SpawnPosition(chunkcoordinates.field_71574_a, chunkcoordinates.field_71572_b, chunkcoordinates.field_71573_c));
        netserverhandler.func_72567_b(new Packet202PlayerAbilities(p_72355_2_.field_71075_bZ));
        func_72354_b(p_72355_2_, worldserver);
        func_72384_a(new Packet3Chat((new StringBuilder()).append("\247e").append(p_72355_2_.field_71092_bJ).append(" joined the game.").toString()));
        func_72377_c(p_72355_2_);
        netserverhandler.func_72569_a(p_72355_2_.field_70165_t, p_72355_2_.field_70163_u, p_72355_2_.field_70161_v, p_72355_2_.field_70177_z, p_72355_2_.field_70125_A);
        field_72400_f.func_71212_ac().func_71745_a(netserverhandler);
        netserverhandler.func_72567_b(new Packet4UpdateTime(worldserver.func_72820_D()));
        if(field_72400_f.func_71202_P().length() > 0)
        {
            p_72355_2_.func_71115_a(field_72400_f.func_71202_P(), field_72400_f.func_71227_R());
        }
        PotionEffect potioneffect;
        for(Iterator iterator = p_72355_2_.func_70651_bq().iterator(); iterator.hasNext(); netserverhandler.func_72567_b(new Packet41EntityEffect(p_72355_2_.field_70157_k, potioneffect)))
        {
            potioneffect = (PotionEffect)iterator.next();
        }

        p_72355_2_.func_71116_b();
    }

    public void func_72364_a(WorldServer p_72364_1_[])
    {
        field_72412_k = p_72364_1_[0].func_72860_G().func_75756_e();
    }

    public void func_72375_a(EntityPlayerMP p_72375_1_, WorldServer p_72375_2_)
    {
        WorldServer worldserver = p_72375_1_.func_71121_q();
        if(p_72375_2_ != null)
        {
            p_72375_2_.func_73040_p().func_72695_c(p_72375_1_);
        }
        worldserver.func_73040_p().func_72683_a(p_72375_1_);
        worldserver.field_73059_b.func_73158_c((int)p_72375_1_.field_70165_t >> 4, (int)p_72375_1_.field_70161_v >> 4);
    }

    public int func_72372_a()
    {
        return PlayerManager.func_72686_a(func_72395_o());
    }

    public void func_72380_a(EntityPlayerMP p_72380_1_)
    {
        NBTTagCompound nbttagcompound = field_72400_f.field_71305_c[0].func_72912_H().func_76072_h();
        if(p_72380_1_.func_70005_c_().equals(field_72400_f.func_71214_G()) && nbttagcompound != null)
        {
            p_72380_1_.func_70020_e(nbttagcompound);
        } else
        {
            field_72412_k.func_75752_b(p_72380_1_);
        }
    }

    protected void func_72391_b(EntityPlayerMP p_72391_1_)
    {
        field_72412_k.func_75753_a(p_72391_1_);
    }

    public void func_72377_c(EntityPlayerMP p_72377_1_)
    {
        func_72384_a(new Packet201PlayerInfo(p_72377_1_.field_71092_bJ, true, 1000));
        field_72404_b.add(p_72377_1_);
        WorldServer worldserver;
        for(worldserver = field_72400_f.func_71218_a(p_72377_1_.field_71093_bK); !worldserver.func_72945_a(p_72377_1_, p_72377_1_.field_70121_D).isEmpty(); p_72377_1_.func_70107_b(p_72377_1_.field_70165_t, p_72377_1_.field_70163_u + 1.0D, p_72377_1_.field_70161_v)) { }
        worldserver.func_72838_d(p_72377_1_);
        func_72375_a(p_72377_1_, null);
        EntityPlayerMP entityplayermp;
        for(Iterator iterator = field_72404_b.iterator(); iterator.hasNext(); p_72377_1_.field_71135_a.func_72567_b(new Packet201PlayerInfo(entityplayermp.field_71092_bJ, true, entityplayermp.field_71138_i)))
        {
            entityplayermp = (EntityPlayerMP)iterator.next();
        }

    }

    public void func_72358_d(EntityPlayerMP p_72358_1_)
    {
        p_72358_1_.func_71121_q().func_73040_p().func_72685_d(p_72358_1_);
    }

    public void func_72367_e(EntityPlayerMP p_72367_1_)
    {
        func_72391_b(p_72367_1_);
        WorldServer worldserver = p_72367_1_.func_71121_q();
        worldserver.func_72900_e(p_72367_1_);
        worldserver.func_73040_p().func_72695_c(p_72367_1_);
        field_72404_b.remove(p_72367_1_);
        func_72384_a(new Packet201PlayerInfo(p_72367_1_.field_71092_bJ, false, 9999));
    }

    public String func_72399_a(SocketAddress p_72399_1_, String p_72399_2_)
    {
        if(field_72401_g.func_73704_a(p_72399_2_))
        {
            BanEntry banentry = (BanEntry)field_72401_g.func_73712_c().get(p_72399_2_);
            String s1 = (new StringBuilder()).append("You are banned from this server!\nReason: ").append(banentry.func_73686_f()).toString();
            if(banentry.func_73680_d() != null)
            {
                s1 = (new StringBuilder()).append(s1).append("\nYour ban will be removed on ").append(field_72403_e.format(banentry.func_73680_d())).toString();
            }
            return s1;
        }
        if(!func_72370_d(p_72399_2_))
        {
            return "You are not white-listed on this server!";
        }
        String s = p_72399_1_.toString();
        s = s.substring(s.indexOf("/") + 1);
        s = s.substring(0, s.indexOf(":"));
        if(field_72413_h.func_73704_a(s))
        {
            BanEntry banentry1 = (BanEntry)field_72413_h.func_73712_c().get(s);
            String s2 = (new StringBuilder()).append("Your IP address is banned from this server!\nReason: ").append(banentry1.func_73686_f()).toString();
            if(banentry1.func_73680_d() != null)
            {
                s2 = (new StringBuilder()).append(s2).append("\nYour ban will be removed on ").append(field_72403_e.format(banentry1.func_73680_d())).toString();
            }
            return s2;
        }
        if(field_72404_b.size() >= field_72405_c)
        {
            return "The server is full!";
        } else
        {
            return null;
        }
    }

    public EntityPlayerMP func_72366_a(String p_72366_1_)
    {
        ArrayList arraylist = new ArrayList();
        Object obj = field_72404_b.iterator();
        do
        {
            if(!((Iterator) (obj)).hasNext())
            {
                break;
            }
            EntityPlayerMP entityplayermp = (EntityPlayerMP)((Iterator) (obj)).next();
            if(entityplayermp.field_71092_bJ.equalsIgnoreCase(p_72366_1_))
            {
                arraylist.add(entityplayermp);
            }
        } while(true);
        EntityPlayerMP entityplayermp1;
        for(obj = arraylist.iterator(); ((Iterator) (obj)).hasNext(); entityplayermp1.field_71135_a.func_72565_c("You logged in from another location"))
        {
            entityplayermp1 = (EntityPlayerMP)((Iterator) (obj)).next();
        }

        if(field_72400_f.func_71242_L())
        {
            obj = new DemoWorldManager(field_72400_f.func_71218_a(0));
        } else
        {
            obj = new ItemInWorldManager(field_72400_f.func_71218_a(0));
        }
        return new EntityPlayerMP(field_72400_f, field_72400_f.func_71218_a(0), p_72366_1_, ((ItemInWorldManager) (obj)));
    }

    public EntityPlayerMP func_72368_a(EntityPlayerMP p_72368_1_, int p_72368_2_, boolean p_72368_3_)
    {
        p_72368_1_.func_71121_q().func_73039_n().func_72787_a(p_72368_1_);
        p_72368_1_.func_71121_q().func_73039_n().func_72790_b(p_72368_1_);
        p_72368_1_.func_71121_q().func_73040_p().func_72695_c(p_72368_1_);
        field_72404_b.remove(p_72368_1_);
        field_72400_f.func_71218_a(p_72368_1_.field_71093_bK).func_72973_f(p_72368_1_);
        ChunkCoordinates chunkcoordinates = p_72368_1_.func_70997_bJ();
        p_72368_1_.field_71093_bK = p_72368_2_;
        Object obj;
        if(field_72400_f.func_71242_L())
        {
            obj = new DemoWorldManager(field_72400_f.func_71218_a(p_72368_1_.field_71093_bK));
        } else
        {
            obj = new ItemInWorldManager(field_72400_f.func_71218_a(p_72368_1_.field_71093_bK));
        }
        EntityPlayerMP entityplayermp = new EntityPlayerMP(field_72400_f, field_72400_f.func_71218_a(p_72368_1_.field_71093_bK), p_72368_1_.field_71092_bJ, ((ItemInWorldManager) (obj)));
        entityplayermp.func_71049_a(p_72368_1_, p_72368_3_);
        entityplayermp.field_70157_k = p_72368_1_.field_70157_k;
        entityplayermp.field_71135_a = p_72368_1_.field_71135_a;
        WorldServer worldserver = field_72400_f.func_71218_a(p_72368_1_.field_71093_bK);
        func_72381_a(entityplayermp, p_72368_1_, worldserver);
        if(chunkcoordinates != null)
        {
            ChunkCoordinates chunkcoordinates1 = EntityPlayer.func_71056_a(field_72400_f.func_71218_a(p_72368_1_.field_71093_bK), chunkcoordinates);
            if(chunkcoordinates1 != null)
            {
                entityplayermp.func_70012_b((float)chunkcoordinates1.field_71574_a + 0.5F, (float)chunkcoordinates1.field_71572_b + 0.1F, (float)chunkcoordinates1.field_71573_c + 0.5F, 0.0F, 0.0F);
                entityplayermp.func_71063_a(chunkcoordinates);
            } else
            {
                entityplayermp.field_71135_a.func_72567_b(new Packet70GameEvent(0, 0));
            }
        }
        worldserver.field_73059_b.func_73158_c((int)entityplayermp.field_70165_t >> 4, (int)entityplayermp.field_70161_v >> 4);
        for(; !worldserver.func_72945_a(entityplayermp, entityplayermp.field_70121_D).isEmpty(); entityplayermp.func_70107_b(entityplayermp.field_70165_t, entityplayermp.field_70163_u + 1.0D, entityplayermp.field_70161_v)) { }
        entityplayermp.field_71135_a.func_72567_b(new Packet9Respawn(entityplayermp.field_71093_bK, (byte)entityplayermp.field_70170_p.field_73013_u, entityplayermp.field_70170_p.func_72912_H().func_76067_t(), entityplayermp.field_70170_p.func_72800_K(), entityplayermp.field_71134_c.func_73081_b()));
        ChunkCoordinates chunkcoordinates2 = worldserver.func_72861_E();
        entityplayermp.field_71135_a.func_72569_a(entityplayermp.field_70165_t, entityplayermp.field_70163_u, entityplayermp.field_70161_v, entityplayermp.field_70177_z, entityplayermp.field_70125_A);
        entityplayermp.field_71135_a.func_72567_b(new Packet6SpawnPosition(chunkcoordinates2.field_71574_a, chunkcoordinates2.field_71572_b, chunkcoordinates2.field_71573_c));
        func_72354_b(entityplayermp, worldserver);
        worldserver.func_73040_p().func_72683_a(entityplayermp);
        worldserver.func_72838_d(entityplayermp);
        field_72404_b.add(entityplayermp);
        entityplayermp.func_71116_b();
        return entityplayermp;
    }

    public void func_72356_a(EntityPlayerMP p_72356_1_, int p_72356_2_)
    {
        int i = p_72356_1_.field_71093_bK;
        WorldServer worldserver = field_72400_f.func_71218_a(p_72356_1_.field_71093_bK);
        p_72356_1_.field_71093_bK = p_72356_2_;
        WorldServer worldserver1 = field_72400_f.func_71218_a(p_72356_1_.field_71093_bK);
        p_72356_1_.field_71135_a.func_72567_b(new Packet9Respawn(p_72356_1_.field_71093_bK, (byte)p_72356_1_.field_70170_p.field_73013_u, worldserver1.func_72912_H().func_76067_t(), worldserver1.func_72800_K(), p_72356_1_.field_71134_c.func_73081_b()));
        worldserver.func_72973_f(p_72356_1_);
        p_72356_1_.field_70128_L = false;
        double d = p_72356_1_.field_70165_t;
        double d1 = p_72356_1_.field_70161_v;
        double d2 = 8D;
        if(p_72356_1_.field_71093_bK == -1)
        {
            d /= d2;
            d1 /= d2;
            p_72356_1_.func_70012_b(d, p_72356_1_.field_70163_u, d1, p_72356_1_.field_70177_z, p_72356_1_.field_70125_A);
            if(p_72356_1_.func_70089_S())
            {
                worldserver.func_72866_a(p_72356_1_, false);
            }
        } else
        if(p_72356_1_.field_71093_bK == 0)
        {
            d *= d2;
            d1 *= d2;
            p_72356_1_.func_70012_b(d, p_72356_1_.field_70163_u, d1, p_72356_1_.field_70177_z, p_72356_1_.field_70125_A);
            if(p_72356_1_.func_70089_S())
            {
                worldserver.func_72866_a(p_72356_1_, false);
            }
        } else
        {
            ChunkCoordinates chunkcoordinates = worldserver1.func_73054_j();
            d = chunkcoordinates.field_71574_a;
            p_72356_1_.field_70163_u = chunkcoordinates.field_71572_b;
            d1 = chunkcoordinates.field_71573_c;
            p_72356_1_.func_70012_b(d, p_72356_1_.field_70163_u, d1, 90F, 0.0F);
            if(p_72356_1_.func_70089_S())
            {
                worldserver.func_72866_a(p_72356_1_, false);
            }
        }
        if(i != 1)
        {
            d = MathHelper.func_76125_a((int)d, 0xfe363d00, 0x1c9c300);
            d1 = MathHelper.func_76125_a((int)d1, 0xfe363d00, 0x1c9c300);
            if(p_72356_1_.func_70089_S())
            {
                worldserver1.func_72838_d(p_72356_1_);
                p_72356_1_.func_70012_b(d, p_72356_1_.field_70163_u, d1, p_72356_1_.field_70177_z, p_72356_1_.field_70125_A);
                worldserver1.func_72866_a(p_72356_1_, false);
                (new Teleporter()).func_77185_a(worldserver1, p_72356_1_);
            }
        }
        p_72356_1_.func_70029_a(worldserver1);
        func_72375_a(p_72356_1_, worldserver);
        p_72356_1_.field_71135_a.func_72569_a(p_72356_1_.field_70165_t, p_72356_1_.field_70163_u, p_72356_1_.field_70161_v, p_72356_1_.field_70177_z, p_72356_1_.field_70125_A);
        p_72356_1_.field_71134_c.func_73080_a(worldserver1);
        func_72354_b(p_72356_1_, worldserver1);
        func_72385_f(p_72356_1_);
        PotionEffect potioneffect;
        for(Iterator iterator = p_72356_1_.func_70651_bq().iterator(); iterator.hasNext(); p_72356_1_.field_71135_a.func_72567_b(new Packet41EntityEffect(p_72356_1_.field_70157_k, potioneffect)))
        {
            potioneffect = (PotionEffect)iterator.next();
        }

    }

    public void func_72374_b()
    {
        if(++field_72408_o > 600)
        {
            field_72408_o = 0;
        }
        if(field_72408_o < field_72404_b.size())
        {
            EntityPlayerMP entityplayermp = (EntityPlayerMP)field_72404_b.get(field_72408_o);
            func_72384_a(new Packet201PlayerInfo(entityplayermp.field_71092_bJ, true, entityplayermp.field_71138_i));
        }
    }

    public void func_72384_a(Packet p_72384_1_)
    {
        EntityPlayerMP entityplayermp;
        for(Iterator iterator = field_72404_b.iterator(); iterator.hasNext(); entityplayermp.field_71135_a.func_72567_b(p_72384_1_))
        {
            entityplayermp = (EntityPlayerMP)iterator.next();
        }

    }

    public void func_72396_a(Packet p_72396_1_, int p_72396_2_)
    {
        Iterator iterator = field_72404_b.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            EntityPlayerMP entityplayermp = (EntityPlayerMP)iterator.next();
            if(entityplayermp.field_71093_bK == p_72396_2_)
            {
                entityplayermp.field_71135_a.func_72567_b(p_72396_1_);
            }
        } while(true);
    }

    public String func_72398_c()
    {
        String s = "";
        for(int i = 0; i < field_72404_b.size(); i++)
        {
            if(i > 0)
            {
                s = (new StringBuilder()).append(s).append(", ").toString();
            }
            s = (new StringBuilder()).append(s).append(((EntityPlayerMP)field_72404_b.get(i)).field_71092_bJ).toString();
        }

        return s;
    }

    public String[] func_72369_d()
    {
        String as[] = new String[field_72404_b.size()];
        for(int i = 0; i < field_72404_b.size(); i++)
        {
            as[i] = ((EntityPlayerMP)field_72404_b.get(i)).field_71092_bJ;
        }

        return as;
    }

    public BanList func_72390_e()
    {
        return field_72401_g;
    }

    public BanList func_72363_f()
    {
        return field_72413_h;
    }

    public void func_72386_b(String p_72386_1_)
    {
        field_72414_i.add(p_72386_1_.toLowerCase());
    }

    public void func_72360_c(String p_72360_1_)
    {
        field_72414_i.remove(p_72360_1_.toLowerCase());
    }

    public boolean func_72370_d(String p_72370_1_)
    {
        p_72370_1_ = p_72370_1_.trim().toLowerCase();
        return !field_72409_l || field_72414_i.contains(p_72370_1_) || field_72411_j.contains(p_72370_1_);
    }

    public boolean func_72353_e(String p_72353_1_)
    {
        return field_72414_i.contains(p_72353_1_.trim().toLowerCase()) || field_72400_f.func_71264_H() && field_72400_f.field_71305_c[0].func_72912_H().func_76086_u() && field_72400_f.func_71214_G().equalsIgnoreCase(p_72353_1_) || field_72407_n;
    }

    public EntityPlayerMP func_72361_f(String p_72361_1_)
    {
        for(Iterator iterator = field_72404_b.iterator(); iterator.hasNext();)
        {
            EntityPlayerMP entityplayermp = (EntityPlayerMP)iterator.next();
            if(entityplayermp.field_71092_bJ.equalsIgnoreCase(p_72361_1_))
            {
                return entityplayermp;
            }
        }

        return null;
    }

    public void func_72393_a(double p_72393_1_, double p_72393_3_, double p_72393_5_, double p_72393_7_, int p_72393_9_, Packet p_72393_10_)
    {
        func_72397_a(null, p_72393_1_, p_72393_3_, p_72393_5_, p_72393_7_, p_72393_9_, p_72393_10_);
    }

    public void func_72397_a(EntityPlayer p_72397_1_, double p_72397_2_, double p_72397_4_, double p_72397_6_, 
            double p_72397_8_, int p_72397_10_, Packet p_72397_11_)
    {
        Iterator iterator = field_72404_b.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            EntityPlayerMP entityplayermp = (EntityPlayerMP)iterator.next();
            if(entityplayermp != p_72397_1_ && entityplayermp.field_71093_bK == p_72397_10_)
            {
                double d = p_72397_2_ - entityplayermp.field_70165_t;
                double d1 = p_72397_4_ - entityplayermp.field_70163_u;
                double d2 = p_72397_6_ - entityplayermp.field_70161_v;
                if(d * d + d1 * d1 + d2 * d2 < p_72397_8_ * p_72397_8_)
                {
                    entityplayermp.field_71135_a.func_72567_b(p_72397_11_);
                }
            }
        } while(true);
    }

    public void func_72389_g()
    {
        EntityPlayerMP entityplayermp;
        for(Iterator iterator = field_72404_b.iterator(); iterator.hasNext(); func_72391_b(entityplayermp))
        {
            entityplayermp = (EntityPlayerMP)iterator.next();
        }

    }

    public void func_72359_h(String p_72359_1_)
    {
        field_72411_j.add(p_72359_1_);
    }

    public void func_72379_i(String p_72379_1_)
    {
        field_72411_j.remove(p_72379_1_);
    }

    public Set func_72388_h()
    {
        return field_72411_j;
    }

    public Set func_72376_i()
    {
        return field_72414_i;
    }

    public void func_72362_j()
    {
    }

    public void func_72354_b(EntityPlayerMP p_72354_1_, WorldServer p_72354_2_)
    {
        p_72354_1_.field_71135_a.func_72567_b(new Packet4UpdateTime(p_72354_2_.func_72820_D()));
        if(p_72354_2_.func_72896_J())
        {
            p_72354_1_.field_71135_a.func_72567_b(new Packet70GameEvent(1, 0));
        }
    }

    public void func_72385_f(EntityPlayerMP p_72385_1_)
    {
        p_72385_1_.func_71120_a(p_72385_1_.field_71069_bz);
        p_72385_1_.func_71118_n();
    }

    public int func_72394_k()
    {
        return field_72404_b.size();
    }

    public int func_72352_l()
    {
        return field_72405_c;
    }

    public String[] func_72373_m()
    {
        return field_72400_f.field_71305_c[0].func_72860_G().func_75756_e().func_75754_f();
    }

    public boolean func_72383_n()
    {
        return field_72409_l;
    }

    public void func_72371_a(boolean p_72371_1_)
    {
        field_72409_l = p_72371_1_;
    }

    public List func_72382_j(String p_72382_1_)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = field_72404_b.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            EntityPlayerMP entityplayermp = (EntityPlayerMP)iterator.next();
            if(entityplayermp.func_71114_r().equals(p_72382_1_))
            {
                arraylist.add(entityplayermp);
            }
        } while(true);
        return arraylist;
    }

    public int func_72395_o()
    {
        return field_72402_d;
    }

    public MinecraftServer func_72365_p()
    {
        return field_72400_f;
    }

    public NBTTagCompound func_72378_q()
    {
        return null;
    }

    private void func_72381_a(EntityPlayerMP p_72381_1_, EntityPlayerMP p_72381_2_, World p_72381_3_)
    {
        if(p_72381_2_ != null)
        {
            p_72381_1_.field_71134_c.func_73076_a(p_72381_2_.field_71134_c.func_73081_b());
        } else
        if(field_72410_m != null)
        {
            p_72381_1_.field_71134_c.func_73076_a(field_72410_m);
        }
        p_72381_1_.field_71134_c.func_73077_b(p_72381_3_.func_72912_H().func_76077_q());
    }

    public void func_72392_r()
    {
        for(; !field_72404_b.isEmpty(); ((EntityPlayerMP)field_72404_b.get(0)).field_71135_a.func_72565_c("Server closed")) { }
    }

}
