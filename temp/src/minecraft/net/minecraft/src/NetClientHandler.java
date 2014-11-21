// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.net.*;
import java.security.PublicKey;
import java.util.*;
import java.util.logging.Logger;
import javax.crypto.SecretKey;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

// Referenced classes of package net.minecraft.src:
//            NetHandler, MapStorage, ISaveHandler, TcpConnection, 
//            MemoryConnection, IntegratedServer, Session, IntegratedServerListenThread, 
//            NetworkManager, Packet253ServerAuthData, CryptManager, Packet252SharedKey, 
//            Packet205ClientCommand, PlayerControllerMP, StatList, StatFileWriter, 
//            WorldClient, WorldSettings, Packet1Login, EntityClientPlayerMP, 
//            GuiDownloadTerrain, Packet204ClientInfo, GameSettings, ModLoader, 
//            Packet21PickupSpawn, EntityItem, ItemStack, Packet23VehicleSpawn, 
//            EntityMinecart, EntityPlayer, EntityFishHook, Entity, 
//            EntityArrow, EntitySnowball, EntityEnderPearl, EntityEnderEye, 
//            EntityFireball, EntitySmallFireball, EntityEgg, EntityPotion, 
//            EntityExpBottle, EntityBoat, EntityTNTPrimed, EntityEnderCrystal, 
//            EntityFallingSand, ModLoaderMp, NetClientHandlerEntity, World, 
//            EntityLiving, EntityXPOrb, Packet26EntityExpOrb, Packet71Weather, 
//            EntityLightningBolt, EntityPainting, Packet25EntityPainting, Packet28EntityVelocity, 
//            Packet40EntityMetadata, DataWatcher, Packet20NamedEntitySpawn, EntityOtherPlayerMP, 
//            InventoryPlayer, Packet34EntityTeleport, Packet30Entity, Packet35EntityHeadRotation, 
//            Packet29DestroyEntity, Packet10Flying, AxisAlignedBB, GuiScreen, 
//            Packet52MultiBlockChange, Packet51MapChunk, Chunk, WorldProviderSurface, 
//            Packet53BlockChange, GuiDisconnected, Packet255KickDisconnect, Packet22Collect, 
//            EntityPickupFX, EffectRenderer, GuiIngame, Packet3Chat, 
//            GuiNewChat, Packet18Animation, EntityCrit2FX, Packet17Sleep, 
//            Packet24MobSpawn, EntityList, Packet4UpdateTime, ChunkCoordinates, 
//            Packet6SpawnPosition, WorldInfo, Packet39AttachEntity, Packet38EntityStatus, 
//            Packet8UpdateHealth, FoodStats, Packet43Experience, Packet9Respawn, 
//            Explosion, Packet60Explosion, Packet100OpenWindow, InventoryBasic, 
//            Container, MathHelper, TileEntityFurnace, TileEntityDispenser, 
//            TileEntityBrewingStand, NpcMerchant, Packet103SetSlot, GuiContainerCreative, 
//            CreativeTabs, Slot, Packet106Transaction, Packet104WindowItems, 
//            Packet130UpdateSign, TileEntitySign, TileEntity, Packet132TileEntityData, 
//            TileEntityMobSpawner, Packet105UpdateProgressbar, Packet5PlayerInventory, Packet54PlayNoteBlock, 
//            Packet55BlockDestroy, Packet56MapChunks, Packet70GameEvent, EnumGameType, 
//            GuiWinGame, GuiScreenDemo, KeyBinding, Packet131MapData, 
//            Item, ItemMap, MapData, Packet61DoorChange, 
//            Packet200Statistic, Packet41EntityEffect, PotionEffect, Packet42RemoveEntityEffect, 
//            Packet201PlayerInfo, GuiPlayerInfo, Packet0KeepAlive, Packet202PlayerAbilities, 
//            PlayerCapabilities, Packet203AutoComplete, GuiChat, Packet62LevelSound, 
//            Packet250CustomPayload, TexturePackList, GuiYesNo, NetClientWebTextures, 
//            StringTranslate, GuiMerchant, MerchantRecipeList, IMerchant, 
//            Packet, Packet101CloseWindow

public class NetClientHandler extends NetHandler
{

    private boolean field_72554_f;
    private NetworkManager field_72555_g;
    public String field_72560_a;
    private Minecraft field_72563_h;
    private WorldClient field_72564_i;
    private boolean field_72561_j;
    public MapStorage field_72558_b;
    private Map field_72562_k;
    public List field_72559_c;
    public int field_72556_d;
    Random field_72557_e;

    public NetClientHandler(Minecraft p_i3103_1_, String p_i3103_2_, int p_i3103_3_)
        throws IOException
    {
        field_72554_f = false;
        field_72561_j = false;
        field_72558_b = new MapStorage((ISaveHandler)null);
        field_72562_k = new HashMap();
        field_72559_c = new ArrayList();
        field_72556_d = 20;
        field_72557_e = new Random();
        field_72563_h = p_i3103_1_;
        Socket socket = new Socket(InetAddress.getByName(p_i3103_2_), p_i3103_3_);
        field_72555_g = new TcpConnection(socket, "Client", this);
    }

    public NetClientHandler(Minecraft p_i3104_1_, IntegratedServer p_i3104_2_)
        throws IOException
    {
        field_72554_f = false;
        field_72561_j = false;
        field_72558_b = new MapStorage((ISaveHandler)null);
        field_72562_k = new HashMap();
        field_72559_c = new ArrayList();
        field_72556_d = 20;
        field_72557_e = new Random();
        field_72563_h = p_i3104_1_;
        field_72555_g = new MemoryConnection(this);
        p_i3104_2_.func_71343_a().func_71754_a((MemoryConnection)field_72555_g, p_i3104_1_.field_71449_j.field_74286_b);
    }

    public void func_72547_c()
    {
        if(field_72555_g != null)
        {
            field_72555_g.func_74427_a();
        }
        field_72555_g = null;
        field_72564_i = null;
    }

    public void func_72551_d()
    {
        if(!field_72554_f && field_72555_g != null)
        {
            field_72555_g.func_74428_b();
        }
        if(field_72555_g != null)
        {
            field_72555_g.func_74427_a();
        }
    }

    public void func_72470_a(Packet253ServerAuthData p_72470_1_)
    {
        String s = p_72470_1_.func_73377_d().trim();
        PublicKey publickey = p_72470_1_.func_73376_f();
        SecretKey secretkey = CryptManager.func_75890_a();
        if(!"-".equals(s))
        {
            String s1 = (new BigInteger(CryptManager.func_75895_a(s, publickey, secretkey))).toString(16);
            String s2 = func_72550_a(field_72563_h.field_71449_j.field_74286_b, field_72563_h.field_71449_j.field_74287_c, s1);
            if(!"ok".equalsIgnoreCase(s2))
            {
                field_72555_g.func_74424_a("disconnect.loginFailedInfo", new Object[] {
                    s2
                });
                return;
            }
        }
        func_72552_c(new Packet252SharedKey(secretkey, publickey, p_72470_1_.func_73378_g()));
    }

    private String func_72550_a(String p_72550_1_, String p_72550_2_, String p_72550_3_)
    {
        try
        {
            URL url = new URL((new StringBuilder()).append("http://session.minecraft.net/game/joinserver.jsp?user=").append(func_72549_a(p_72550_1_)).append("&sessionId=").append(func_72549_a(p_72550_2_)).append("&serverId=").append(func_72549_a(p_72550_3_)).toString());
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(url.openStream()));
            String s = bufferedreader.readLine();
            bufferedreader.close();
            return s;
        }
        catch(IOException ioexception)
        {
            return ioexception.toString();
        }
    }

    private static String func_72549_a(String p_72549_0_)
        throws IOException
    {
        return URLEncoder.encode(p_72549_0_, "UTF-8");
    }

    public void func_72513_a(Packet252SharedKey p_72513_1_)
    {
        func_72552_c(new Packet205ClientCommand(0));
    }

    public void func_72455_a(Packet1Login p_72455_1_)
    {
        field_72563_h.field_71442_b = new PlayerControllerMP(field_72563_h, this);
        field_72563_h.field_71413_E.func_77450_a(StatList.field_75950_i, 1);
        field_72564_i = new WorldClient(this, new WorldSettings(0L, p_72455_1_.field_73557_d, false, p_72455_1_.field_73560_c, p_72455_1_.field_73559_b), p_72455_1_.field_73558_e, p_72455_1_.field_73555_f, field_72563_h.field_71424_I);
        field_72564_i.field_72995_K = true;
        field_72563_h.func_71403_a(field_72564_i);
        field_72563_h.field_71439_g.field_71093_bK = p_72455_1_.field_73558_e;
        field_72563_h.func_71373_a(new GuiDownloadTerrain(this));
        field_72563_h.field_71439_g.field_70157_k = p_72455_1_.field_73561_a;
        field_72556_d = p_72455_1_.field_73562_h;
        field_72563_h.field_71442_b.func_78746_a(p_72455_1_.field_73557_d);
        func_72552_c(new Packet204ClientInfo(field_72563_h.field_71474_y.field_74363_ab, field_72563_h.field_71474_y.field_74339_e, field_72563_h.field_71474_y.field_74343_n, field_72563_h.field_71474_y.field_74344_o, field_72563_h.field_71474_y.field_74318_M));
        ModLoader.clientConnect(this, p_72455_1_);
    }

    public void func_72459_a(Packet21PickupSpawn p_72459_1_)
    {
        double d = (double)p_72459_1_.field_73483_b / 32D;
        double d1 = (double)p_72459_1_.field_73484_c / 32D;
        double d2 = (double)p_72459_1_.field_73481_d / 32D;
        EntityItem entityitem = new EntityItem(field_72564_i, d, d1, d2, new ItemStack(p_72459_1_.field_73487_h, p_72459_1_.field_73488_i, p_72459_1_.field_73486_j));
        entityitem.field_70159_w = (double)p_72459_1_.field_73482_e / 128D;
        entityitem.field_70181_x = (double)p_72459_1_.field_73479_f / 128D;
        entityitem.field_70179_y = (double)p_72459_1_.field_73480_g / 128D;
        entityitem.field_70118_ct = p_72459_1_.field_73483_b;
        entityitem.field_70117_cu = p_72459_1_.field_73484_c;
        entityitem.field_70116_cv = p_72459_1_.field_73481_d;
        field_72564_i.func_73027_a(p_72459_1_.field_73485_a, entityitem);
    }

    public void func_72511_a(Packet23VehicleSpawn p_72511_1_)
    {
        double d = (double)p_72511_1_.field_73524_b / 32D;
        double d1 = (double)p_72511_1_.field_73525_c / 32D;
        double d2 = (double)p_72511_1_.field_73522_d / 32D;
        Object obj = null;
        if(p_72511_1_.field_73527_h == 10)
        {
            obj = new EntityMinecart(field_72564_i, d, d1, d2, 0);
        } else
        if(p_72511_1_.field_73527_h == 11)
        {
            obj = new EntityMinecart(field_72564_i, d, d1, d2, 1);
        } else
        if(p_72511_1_.field_73527_h == 12)
        {
            obj = new EntityMinecart(field_72564_i, d, d1, d2, 2);
        } else
        if(p_72511_1_.field_73527_h == 90)
        {
            Entity entity = func_72545_a(p_72511_1_.field_73528_i);
            if(entity instanceof EntityPlayer)
            {
                obj = new EntityFishHook(field_72564_i, d, d1, d2, (EntityPlayer)entity);
            }
            p_72511_1_.field_73528_i = 0;
        } else
        if(p_72511_1_.field_73527_h == 60)
        {
            obj = new EntityArrow(field_72564_i, d, d1, d2);
        } else
        if(p_72511_1_.field_73527_h == 61)
        {
            obj = new EntitySnowball(field_72564_i, d, d1, d2);
        } else
        if(p_72511_1_.field_73527_h == 65)
        {
            obj = new EntityEnderPearl(field_72564_i, d, d1, d2);
        } else
        if(p_72511_1_.field_73527_h == 72)
        {
            obj = new EntityEnderEye(field_72564_i, d, d1, d2);
        } else
        if(p_72511_1_.field_73527_h == 63)
        {
            obj = new EntityFireball(field_72564_i, d, d1, d2, (double)p_72511_1_.field_73523_e / 8000D, (double)p_72511_1_.field_73520_f / 8000D, (double)p_72511_1_.field_73521_g / 8000D);
            p_72511_1_.field_73528_i = 0;
        } else
        if(p_72511_1_.field_73527_h == 64)
        {
            obj = new EntitySmallFireball(field_72564_i, d, d1, d2, (double)p_72511_1_.field_73523_e / 8000D, (double)p_72511_1_.field_73520_f / 8000D, (double)p_72511_1_.field_73521_g / 8000D);
            p_72511_1_.field_73528_i = 0;
        } else
        if(p_72511_1_.field_73527_h == 62)
        {
            obj = new EntityEgg(field_72564_i, d, d1, d2);
        } else
        if(p_72511_1_.field_73527_h == 73)
        {
            obj = new EntityPotion(field_72564_i, d, d1, d2, p_72511_1_.field_73528_i);
            p_72511_1_.field_73528_i = 0;
        } else
        if(p_72511_1_.field_73527_h == 75)
        {
            obj = new EntityExpBottle(field_72564_i, d, d1, d2);
            p_72511_1_.field_73528_i = 0;
        } else
        if(p_72511_1_.field_73527_h == 1)
        {
            obj = new EntityBoat(field_72564_i, d, d1, d2);
        } else
        if(p_72511_1_.field_73527_h == 50)
        {
            obj = new EntityTNTPrimed(field_72564_i, d, d1, d2);
        } else
        if(p_72511_1_.field_73527_h == 51)
        {
            obj = new EntityEnderCrystal(field_72564_i, d, d1, d2);
        } else
        if(p_72511_1_.field_73527_h == 70)
        {
            obj = new EntityFallingSand(field_72564_i, d, d1, d2, p_72511_1_.field_73528_i & 0xffff, p_72511_1_.field_73528_i >> 16);
            p_72511_1_.field_73528_i = 0;
        }
        NetClientHandlerEntity netclienthandlerentity = ModLoaderMp.handleNetClientHandlerEntities(p_72511_1_.field_73527_h);
        if(netclienthandlerentity != null)
        {
            try
            {
                obj = (Entity)netclienthandlerentity.entityClass.getConstructor(new Class[] {
                    net.minecraft.src.World.class, Double.TYPE, Double.TYPE, Double.TYPE
                }).newInstance(new Object[] {
                    field_72564_i, Double.valueOf(d), Double.valueOf(d1), Double.valueOf(d2)
                });
                if(netclienthandlerentity.entityHasOwner)
                {
                    Field field = netclienthandlerentity.entityClass.getField("owner");
                    if((net.minecraft.src.Entity.class).isAssignableFrom(field.getType()))
                    {
                        Entity entity1 = func_72545_a(p_72511_1_.field_73528_i);
                        if(entity1 == null)
                        {
                            ModLoaderMp.log("Received spawn packet for entity with owner, but owner was not found.");
                        } else
                        if(field.getType().isAssignableFrom(entity1.getClass()))
                        {
                            field.set(obj, entity1);
                        } else
                        {
                            throw new Exception(String.format("Tried to assign an entity of type %s to entity owner, which is of type %s.", new Object[] {
                                entity1.getClass(), field.getType()
                            }));
                        }
                    } else
                    {
                        throw new Exception(String.format("Entity's owner field must be of type Entity, but it is of type %s.", new Object[] {
                            field.getType()
                        }));
                    }
                }
            }
            catch(Exception exception)
            {
                ModLoader.getLogger().throwing("NetClientHandler", "handleVehicleSpawn", exception);
                ModLoader.throwException(String.format("Error initializing entity of type %s.", new Object[] {
                    Integer.valueOf(p_72511_1_.field_73527_h)
                }), exception);
                return;
            }
        }
        if(obj != null)
        {
            ((Entity)obj).field_70118_ct = p_72511_1_.field_73524_b;
            ((Entity)obj).field_70117_cu = p_72511_1_.field_73525_c;
            ((Entity)obj).field_70116_cv = p_72511_1_.field_73522_d;
            ((Entity)obj).field_70177_z = 0.0F;
            ((Entity)obj).field_70125_A = 0.0F;
            Entity aentity[] = ((Entity)obj).func_70021_al();
            if(aentity != null)
            {
                int i = p_72511_1_.field_73526_a - ((Entity)obj).field_70157_k;
                Entity aentity1[] = aentity;
                int j = aentity.length;
                for(int k = 0; k < j; k++)
                {
                    Entity entity3 = aentity1[k];
                    entity3.field_70157_k += i;
                }

            }
            ((Entity)obj).field_70157_k = p_72511_1_.field_73526_a;
            field_72564_i.func_73027_a(p_72511_1_.field_73526_a, (Entity)obj);
            if(p_72511_1_.field_73528_i > 0)
            {
                if(p_72511_1_.field_73527_h == 60)
                {
                    Entity entity2 = func_72545_a(p_72511_1_.field_73528_i);
                    if(entity2 instanceof EntityLiving)
                    {
                        EntityArrow entityarrow = (EntityArrow)obj;
                        entityarrow.field_70250_c = entity2;
                    }
                }
                ((Entity)obj).func_70016_h((double)p_72511_1_.field_73523_e / 8000D, (double)p_72511_1_.field_73520_f / 8000D, (double)p_72511_1_.field_73521_g / 8000D);
            }
        }
    }

    public void func_72514_a(Packet26EntityExpOrb p_72514_1_)
    {
        EntityXPOrb entityxporb = new EntityXPOrb(field_72564_i, p_72514_1_.field_73531_b, p_72514_1_.field_73532_c, p_72514_1_.field_73529_d, p_72514_1_.field_73530_e);
        entityxporb.field_70118_ct = p_72514_1_.field_73531_b;
        entityxporb.field_70117_cu = p_72514_1_.field_73532_c;
        entityxporb.field_70116_cv = p_72514_1_.field_73529_d;
        entityxporb.field_70177_z = 0.0F;
        entityxporb.field_70125_A = 0.0F;
        entityxporb.field_70157_k = p_72514_1_.field_73533_a;
        field_72564_i.func_73027_a(p_72514_1_.field_73533_a, entityxporb);
    }

    public void func_72508_a(Packet71Weather p_72508_1_)
    {
        double d = (double)p_72508_1_.field_73536_b / 32D;
        double d1 = (double)p_72508_1_.field_73537_c / 32D;
        double d2 = (double)p_72508_1_.field_73534_d / 32D;
        EntityLightningBolt entitylightningbolt = null;
        if(p_72508_1_.field_73535_e == 1)
        {
            entitylightningbolt = new EntityLightningBolt(field_72564_i, d, d1, d2);
        }
        if(entitylightningbolt != null)
        {
            entitylightningbolt.field_70118_ct = p_72508_1_.field_73536_b;
            entitylightningbolt.field_70117_cu = p_72508_1_.field_73537_c;
            entitylightningbolt.field_70116_cv = p_72508_1_.field_73534_d;
            entitylightningbolt.field_70177_z = 0.0F;
            entitylightningbolt.field_70125_A = 0.0F;
            entitylightningbolt.field_70157_k = p_72508_1_.field_73538_a;
            field_72564_i.func_72942_c(entitylightningbolt);
        }
    }

    public void func_72495_a(Packet25EntityPainting p_72495_1_)
    {
        EntityPainting entitypainting = new EntityPainting(field_72564_i, p_72495_1_.field_73506_b, p_72495_1_.field_73507_c, p_72495_1_.field_73504_d, p_72495_1_.field_73505_e, p_72495_1_.field_73503_f);
        field_72564_i.func_73027_a(p_72495_1_.field_73508_a, entitypainting);
    }

    public void func_72520_a(Packet28EntityVelocity p_72520_1_)
    {
        Entity entity = func_72545_a(p_72520_1_.field_73390_a);
        if(entity != null)
        {
            entity.func_70016_h((double)p_72520_1_.field_73388_b / 8000D, (double)p_72520_1_.field_73389_c / 8000D, (double)p_72520_1_.field_73387_d / 8000D);
        }
    }

    public void func_72493_a(Packet40EntityMetadata p_72493_1_)
    {
        Entity entity = func_72545_a(p_72493_1_.field_73393_a);
        if(entity != null && p_72493_1_.func_73391_d() != null)
        {
            entity.func_70096_w().func_75687_a(p_72493_1_.func_73391_d());
        }
    }

    public void func_72518_a(Packet20NamedEntitySpawn p_72518_1_)
    {
        double d = (double)p_72518_1_.field_73515_c / 32D;
        double d1 = (double)p_72518_1_.field_73512_d / 32D;
        double d2 = (double)p_72518_1_.field_73513_e / 32D;
        float f = (float)(p_72518_1_.field_73510_f * 360) / 256F;
        float f1 = (float)(p_72518_1_.field_73511_g * 360) / 256F;
        EntityOtherPlayerMP entityotherplayermp = new EntityOtherPlayerMP(field_72563_h.field_71441_e, p_72518_1_.field_73514_b);
        entityotherplayermp.field_70169_q = entityotherplayermp.field_70142_S = entityotherplayermp.field_70118_ct = p_72518_1_.field_73515_c;
        entityotherplayermp.field_70167_r = entityotherplayermp.field_70137_T = entityotherplayermp.field_70117_cu = p_72518_1_.field_73512_d;
        entityotherplayermp.field_70166_s = entityotherplayermp.field_70136_U = entityotherplayermp.field_70116_cv = p_72518_1_.field_73513_e;
        int i = p_72518_1_.field_73518_h;
        if(i == 0)
        {
            entityotherplayermp.field_71071_by.field_70462_a[entityotherplayermp.field_71071_by.field_70461_c] = null;
        } else
        {
            entityotherplayermp.field_71071_by.field_70462_a[entityotherplayermp.field_71071_by.field_70461_c] = new ItemStack(i, 1, 0);
        }
        entityotherplayermp.func_70080_a(d, d1, d2, f, f1);
        field_72564_i.func_73027_a(p_72518_1_.field_73516_a, entityotherplayermp);
        List list = p_72518_1_.func_73509_c();
        if(list != null)
        {
            entityotherplayermp.func_70096_w().func_75687_a(list);
        }
    }

    public void func_72512_a(Packet34EntityTeleport p_72512_1_)
    {
        Entity entity = func_72545_a(p_72512_1_.field_73319_a);
        if(entity != null)
        {
            entity.field_70118_ct = p_72512_1_.field_73317_b;
            entity.field_70117_cu = p_72512_1_.field_73318_c;
            entity.field_70116_cv = p_72512_1_.field_73315_d;
            double d = (double)entity.field_70118_ct / 32D;
            double d1 = (double)entity.field_70117_cu / 32D + 0.015625D;
            double d2 = (double)entity.field_70116_cv / 32D;
            float f = (float)(p_72512_1_.field_73316_e * 360) / 256F;
            float f1 = (float)(p_72512_1_.field_73314_f * 360) / 256F;
            entity.func_70056_a(d, d1, d2, f, f1, 3);
        }
    }

    public void func_72482_a(Packet30Entity p_72482_1_)
    {
        Entity entity = func_72545_a(p_72482_1_.field_73554_a);
        if(entity != null)
        {
            entity.field_70118_ct += p_72482_1_.field_73552_b;
            entity.field_70117_cu += p_72482_1_.field_73553_c;
            entity.field_70116_cv += p_72482_1_.field_73550_d;
            double d = (double)entity.field_70118_ct / 32D;
            double d1 = (double)entity.field_70117_cu / 32D;
            double d2 = (double)entity.field_70116_cv / 32D;
            float f = p_72482_1_.field_73549_g ? (float)(p_72482_1_.field_73551_e * 360) / 256F : entity.field_70177_z;
            float f1 = p_72482_1_.field_73549_g ? (float)(p_72482_1_.field_73548_f * 360) / 256F : entity.field_70125_A;
            entity.func_70056_a(d, d1, d2, f, f1, 3);
        }
    }

    public void func_72478_a(Packet35EntityHeadRotation p_72478_1_)
    {
        Entity entity = func_72545_a(p_72478_1_.field_73383_a);
        if(entity != null)
        {
            float f = (float)(p_72478_1_.field_73382_b * 360) / 256F;
            entity.func_70034_d(f);
        }
    }

    public void func_72491_a(Packet29DestroyEntity p_72491_1_)
    {
        for(int i = 0; i < p_72491_1_.field_73368_a.length; i++)
        {
            field_72564_i.func_73028_b(p_72491_1_.field_73368_a[i]);
        }

    }

    public void func_72498_a(Packet10Flying p_72498_1_)
    {
        EntityClientPlayerMP entityclientplayermp = field_72563_h.field_71439_g;
        double d = entityclientplayermp.field_70165_t;
        double d1 = entityclientplayermp.field_70163_u;
        double d2 = entityclientplayermp.field_70161_v;
        float f = entityclientplayermp.field_70177_z;
        float f1 = entityclientplayermp.field_70125_A;
        if(p_72498_1_.field_73546_h)
        {
            d = p_72498_1_.field_73545_a;
            d1 = p_72498_1_.field_73543_b;
            d2 = p_72498_1_.field_73544_c;
        }
        if(p_72498_1_.field_73547_i)
        {
            f = p_72498_1_.field_73542_e;
            f1 = p_72498_1_.field_73539_f;
        }
        entityclientplayermp.field_70139_V = 0.0F;
        entityclientplayermp.field_70159_w = entityclientplayermp.field_70181_x = entityclientplayermp.field_70179_y = 0.0D;
        entityclientplayermp.func_70080_a(d, d1, d2, f, f1);
        p_72498_1_.field_73545_a = entityclientplayermp.field_70165_t;
        p_72498_1_.field_73543_b = entityclientplayermp.field_70121_D.field_72338_b;
        p_72498_1_.field_73544_c = entityclientplayermp.field_70161_v;
        p_72498_1_.field_73541_d = entityclientplayermp.field_70163_u;
        field_72555_g.func_74429_a(p_72498_1_);
        if(!field_72561_j)
        {
            field_72563_h.field_71439_g.field_70169_q = field_72563_h.field_71439_g.field_70165_t;
            field_72563_h.field_71439_g.field_70167_r = field_72563_h.field_71439_g.field_70163_u;
            field_72563_h.field_71439_g.field_70166_s = field_72563_h.field_71439_g.field_70161_v;
            field_72561_j = true;
            field_72563_h.func_71373_a((GuiScreen)null);
        }
    }

    public void func_72496_a(Packet52MultiBlockChange p_72496_1_)
    {
        int i = p_72496_1_.field_73452_a * 16;
        int j = p_72496_1_.field_73450_b * 16;
        if(p_72496_1_.field_73451_c != null)
        {
            DataInputStream datainputstream = new DataInputStream(new ByteArrayInputStream(p_72496_1_.field_73451_c));
            try
            {
                for(int k = 0; k < p_72496_1_.field_73448_d; k++)
                {
                    short word0 = datainputstream.readShort();
                    short word1 = datainputstream.readShort();
                    int l = word1 >> 4 & 0xfff;
                    int i1 = word1 & 0xf;
                    int j1 = word0 >> 12 & 0xf;
                    int k1 = word0 >> 8 & 0xf;
                    int l1 = word0 & 0xff;
                    field_72564_i.func_73023_g(j1 + i, l1, k1 + j, l, i1);
                }

            }
            catch(IOException ioexception) { }
        }
    }

    public void func_72463_a(Packet51MapChunk p_72463_1_)
    {
        if(p_72463_1_.field_73598_e)
        {
            if(p_72463_1_.field_73600_c == 0)
            {
                field_72564_i.func_73025_a(p_72463_1_.field_73601_a, p_72463_1_.field_73599_b, false);
                return;
            }
            field_72564_i.func_73025_a(p_72463_1_.field_73601_a, p_72463_1_.field_73599_b, true);
        }
        field_72564_i.func_73031_a(p_72463_1_.field_73601_a << 4, 0, p_72463_1_.field_73599_b << 4, (p_72463_1_.field_73601_a << 4) + 15, 256, (p_72463_1_.field_73599_b << 4) + 15);
        Chunk chunk = field_72564_i.func_72964_e(p_72463_1_.field_73601_a, p_72463_1_.field_73599_b);
        if(p_72463_1_.field_73598_e && chunk == null)
        {
            field_72564_i.func_73025_a(p_72463_1_.field_73601_a, p_72463_1_.field_73599_b, true);
            chunk = field_72564_i.func_72964_e(p_72463_1_.field_73601_a, p_72463_1_.field_73599_b);
        }
        if(chunk != null)
        {
            chunk.func_76607_a(p_72463_1_.func_73593_d(), p_72463_1_.field_73600_c, p_72463_1_.field_73597_d, p_72463_1_.field_73598_e);
            field_72564_i.func_72909_d(p_72463_1_.field_73601_a << 4, 0, p_72463_1_.field_73599_b << 4, (p_72463_1_.field_73601_a << 4) + 15, 256, (p_72463_1_.field_73599_b << 4) + 15);
            if(!p_72463_1_.field_73598_e || !(field_72564_i.field_73011_w instanceof WorldProviderSurface))
            {
                chunk.func_76613_n();
            }
        }
    }

    public void func_72456_a(Packet53BlockChange p_72456_1_)
    {
        field_72564_i.func_73023_g(p_72456_1_.field_73425_a, p_72456_1_.field_73423_b, p_72456_1_.field_73424_c, p_72456_1_.field_73421_d, p_72456_1_.field_73422_e);
    }

    public void func_72492_a(Packet255KickDisconnect p_72492_1_)
    {
        field_72555_g.func_74424_a("disconnect.kicked", new Object[0]);
        field_72554_f = true;
        ModLoader.clientDisconnect();
        field_72563_h.func_71403_a((WorldClient)null);
        field_72563_h.func_71373_a(new GuiDisconnected("disconnect.disconnected", "disconnect.genericReason", new Object[] {
            p_72492_1_.field_73631_a
        }));
    }

    public void func_72515_a(String p_72515_1_, Object p_72515_2_[])
    {
        if(!field_72554_f)
        {
            field_72554_f = true;
            ModLoader.clientDisconnect();
            field_72563_h.func_71403_a((WorldClient)null);
            field_72563_h.func_71373_a(new GuiDisconnected("disconnect.lost", p_72515_1_, p_72515_2_));
        }
    }

    public void func_72546_b(Packet p_72546_1_)
    {
        if(!field_72554_f)
        {
            field_72555_g.func_74429_a(p_72546_1_);
            field_72555_g.func_74423_d();
        }
    }

    public void func_72552_c(Packet p_72552_1_)
    {
        if(!field_72554_f)
        {
            field_72555_g.func_74429_a(p_72552_1_);
        }
    }

    public void func_72475_a(Packet22Collect p_72475_1_)
    {
        Entity entity = func_72545_a(p_72475_1_.field_73313_a);
        Object obj = (EntityLiving)func_72545_a(p_72475_1_.field_73312_b);
        if(obj == null)
        {
            obj = field_72563_h.field_71439_g;
        }
        if(entity != null)
        {
            if(entity instanceof EntityXPOrb)
            {
                field_72564_i.func_72956_a(entity, "random.orb", 0.2F, ((field_72557_e.nextFloat() - field_72557_e.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            } else
            {
                field_72564_i.func_72956_a(entity, "random.pop", 0.2F, ((field_72557_e.nextFloat() - field_72557_e.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            }
            field_72563_h.field_71452_i.func_78873_a(new EntityPickupFX(field_72563_h.field_71441_e, entity, (Entity)obj, -0.5F));
            field_72564_i.func_73028_b(p_72475_1_.field_73313_a);
        }
    }

    public void func_72481_a(Packet3Chat p_72481_1_)
    {
        field_72563_h.field_71456_v.func_73827_b().func_73765_a(p_72481_1_.field_73476_b);
        ModLoader.clientChat(p_72481_1_.field_73476_b);
    }

    public void func_72524_a(Packet18Animation p_72524_1_)
    {
        Entity entity = func_72545_a(p_72524_1_.field_73470_a);
        if(entity != null)
        {
            if(p_72524_1_.field_73469_b == 1)
            {
                EntityPlayer entityplayer = (EntityPlayer)entity;
                entityplayer.func_71038_i();
            } else
            if(p_72524_1_.field_73469_b == 2)
            {
                entity.func_70057_ab();
            } else
            if(p_72524_1_.field_73469_b == 3)
            {
                EntityPlayer entityplayer1 = (EntityPlayer)entity;
                entityplayer1.func_70999_a(false, false, false);
            } else
            if(p_72524_1_.field_73469_b != 4)
            {
                if(p_72524_1_.field_73469_b == 6)
                {
                    field_72563_h.field_71452_i.func_78873_a(new EntityCrit2FX(field_72563_h.field_71441_e, entity));
                } else
                if(p_72524_1_.field_73469_b == 7)
                {
                    EntityCrit2FX entitycrit2fx = new EntityCrit2FX(field_72563_h.field_71441_e, entity, "magicCrit");
                    field_72563_h.field_71452_i.func_78873_a(entitycrit2fx);
                } else
                if(p_72524_1_.field_73469_b == 5)
                {
                    if(entity instanceof EntityOtherPlayerMP);
                }
            }
        }
    }

    public void func_72460_a(Packet17Sleep p_72460_1_)
    {
        Entity entity = func_72545_a(p_72460_1_.field_73625_a);
        if(entity != null && p_72460_1_.field_73622_e == 0)
        {
            EntityPlayer entityplayer = (EntityPlayer)entity;
            entityplayer.func_71018_a(p_72460_1_.field_73623_b, p_72460_1_.field_73624_c, p_72460_1_.field_73621_d);
        }
    }

    public void func_72553_e()
    {
        field_72554_f = true;
        ModLoader.clientDisconnect();
        field_72555_g.func_74427_a();
        field_72555_g.func_74424_a("disconnect.closed", new Object[0]);
    }

    public void func_72519_a(Packet24MobSpawn p_72519_1_)
    {
        double d = (double)p_72519_1_.field_73495_c / 32D;
        double d1 = (double)p_72519_1_.field_73492_d / 32D;
        double d2 = (double)p_72519_1_.field_73493_e / 32D;
        float f = (float)(p_72519_1_.field_73500_i * 360) / 256F;
        float f1 = (float)(p_72519_1_.field_73497_j * 360) / 256F;
        EntityLiving entityliving = (EntityLiving)EntityList.func_75616_a(p_72519_1_.field_73494_b, field_72563_h.field_71441_e);
        entityliving.field_70118_ct = p_72519_1_.field_73495_c;
        entityliving.field_70117_cu = p_72519_1_.field_73492_d;
        entityliving.field_70116_cv = p_72519_1_.field_73493_e;
        entityliving.field_70759_as = (float)(p_72519_1_.field_73498_k * 360) / 256F;
        Entity aentity[] = entityliving.func_70021_al();
        if(aentity != null)
        {
            int i = p_72519_1_.field_73496_a - entityliving.field_70157_k;
            Entity aentity1[] = aentity;
            int j = aentity.length;
            for(int k = 0; k < j; k++)
            {
                Entity entity = aentity1[k];
                entity.field_70157_k += i;
            }

        }
        entityliving.field_70157_k = p_72519_1_.field_73496_a;
        entityliving.func_70080_a(d, d1, d2, f, f1);
        entityliving.field_70159_w = (float)p_72519_1_.field_73490_f / 8000F;
        entityliving.field_70181_x = (float)p_72519_1_.field_73491_g / 8000F;
        entityliving.field_70179_y = (float)p_72519_1_.field_73499_h / 8000F;
        field_72564_i.func_73027_a(p_72519_1_.field_73496_a, entityliving);
        List list = p_72519_1_.func_73489_c();
        if(list != null)
        {
            entityliving.func_70096_w().func_75687_a(list);
        }
    }

    public void func_72497_a(Packet4UpdateTime p_72497_1_)
    {
        field_72563_h.field_71441_e.func_72877_b(p_72497_1_.field_73301_a);
    }

    public void func_72466_a(Packet6SpawnPosition p_72466_1_)
    {
        field_72563_h.field_71439_g.func_71063_a(new ChunkCoordinates(p_72466_1_.field_73300_a, p_72466_1_.field_73298_b, p_72466_1_.field_73299_c));
        field_72563_h.field_71441_e.func_72912_H().func_76081_a(p_72466_1_.field_73300_a, p_72466_1_.field_73298_b, p_72466_1_.field_73299_c);
    }

    public void func_72484_a(Packet39AttachEntity p_72484_1_)
    {
        Object obj = func_72545_a(p_72484_1_.field_73297_a);
        Entity entity = func_72545_a(p_72484_1_.field_73296_b);
        if(p_72484_1_.field_73297_a == field_72563_h.field_71439_g.field_70157_k)
        {
            obj = field_72563_h.field_71439_g;
            if(entity instanceof EntityBoat)
            {
                ((EntityBoat)entity).func_70270_d(false);
            }
        } else
        if(entity instanceof EntityBoat)
        {
            ((EntityBoat)entity).func_70270_d(true);
        }
        if(obj != null)
        {
            ((Entity)obj).func_70078_a(entity);
        }
    }

    public void func_72485_a(Packet38EntityStatus p_72485_1_)
    {
        Entity entity = func_72545_a(p_72485_1_.field_73627_a);
        if(entity != null)
        {
            entity.func_70103_a(p_72485_1_.field_73626_b);
        }
    }

    private Entity func_72545_a(int p_72545_1_)
    {
        return ((Entity) (p_72545_1_ != field_72563_h.field_71439_g.field_70157_k ? field_72564_i.func_73024_a(p_72545_1_) : field_72563_h.field_71439_g));
    }

    public void func_72521_a(Packet8UpdateHealth p_72521_1_)
    {
        field_72563_h.field_71439_g.func_71150_b(p_72521_1_.field_73640_a);
        field_72563_h.field_71439_g.func_71024_bL().func_75114_a(p_72521_1_.field_73638_b);
        field_72563_h.field_71439_g.func_71024_bL().func_75119_b(p_72521_1_.field_73639_c);
    }

    public void func_72522_a(Packet43Experience p_72522_1_)
    {
        field_72563_h.field_71439_g.func_71152_a(p_72522_1_.field_73396_a, p_72522_1_.field_73394_b, p_72522_1_.field_73395_c);
    }

    public void func_72483_a(Packet9Respawn p_72483_1_)
    {
        if(p_72483_1_.field_73373_a != field_72563_h.field_71439_g.field_71093_bK)
        {
            field_72561_j = false;
            field_72564_i = new WorldClient(this, new WorldSettings(0L, p_72483_1_.field_73369_d, false, field_72563_h.field_71441_e.func_72912_H().func_76093_s(), p_72483_1_.field_73370_e), p_72483_1_.field_73373_a, p_72483_1_.field_73371_b, field_72563_h.field_71424_I);
            field_72564_i.field_72995_K = true;
            field_72563_h.func_71403_a(field_72564_i);
            field_72563_h.field_71439_g.field_71093_bK = p_72483_1_.field_73373_a;
            field_72563_h.func_71373_a(new GuiDownloadTerrain(this));
        }
        field_72563_h.func_71354_a(p_72483_1_.field_73373_a);
        field_72563_h.field_71442_b.func_78746_a(p_72483_1_.field_73369_d);
    }

    public void func_72499_a(Packet60Explosion p_72499_1_)
    {
        Explosion explosion = new Explosion(field_72563_h.field_71441_e, (Entity)null, p_72499_1_.field_73616_a, p_72499_1_.field_73614_b, p_72499_1_.field_73615_c, p_72499_1_.field_73612_d);
        explosion.field_77281_g = p_72499_1_.field_73613_e;
        explosion.func_77279_a(true);
        field_72563_h.field_71439_g.field_70159_w += p_72499_1_.func_73607_d();
        field_72563_h.field_71439_g.field_70181_x += p_72499_1_.func_73609_f();
        field_72563_h.field_71439_g.field_70179_y += p_72499_1_.func_73608_g();
    }

    public void func_72516_a(Packet100OpenWindow p_72516_1_)
    {
        EntityClientPlayerMP entityclientplayermp = field_72563_h.field_71439_g;
        switch(p_72516_1_.field_73429_b)
        {
        case 0: // '\0'
            entityclientplayermp.func_71007_a(new InventoryBasic(p_72516_1_.field_73430_c, p_72516_1_.field_73428_d));
            entityclientplayermp.field_71070_bA.field_75152_c = p_72516_1_.field_73431_a;
            break;

        case 1: // '\001'
            entityclientplayermp.func_71058_b(MathHelper.func_76128_c(entityclientplayermp.field_70165_t), MathHelper.func_76128_c(entityclientplayermp.field_70163_u), MathHelper.func_76128_c(entityclientplayermp.field_70161_v));
            entityclientplayermp.field_71070_bA.field_75152_c = p_72516_1_.field_73431_a;
            break;

        case 2: // '\002'
            entityclientplayermp.func_71042_a(new TileEntityFurnace());
            entityclientplayermp.field_71070_bA.field_75152_c = p_72516_1_.field_73431_a;
            break;

        case 3: // '\003'
            entityclientplayermp.func_71006_a(new TileEntityDispenser());
            entityclientplayermp.field_71070_bA.field_75152_c = p_72516_1_.field_73431_a;
            break;

        case 4: // '\004'
            entityclientplayermp.func_71002_c(MathHelper.func_76128_c(entityclientplayermp.field_70165_t), MathHelper.func_76128_c(entityclientplayermp.field_70163_u), MathHelper.func_76128_c(entityclientplayermp.field_70161_v));
            entityclientplayermp.field_71070_bA.field_75152_c = p_72516_1_.field_73431_a;
            break;

        case 5: // '\005'
            entityclientplayermp.func_71017_a(new TileEntityBrewingStand());
            entityclientplayermp.field_71070_bA.field_75152_c = p_72516_1_.field_73431_a;
            break;

        case 6: // '\006'
            entityclientplayermp.func_71030_a(new NpcMerchant(entityclientplayermp));
            entityclientplayermp.field_71070_bA.field_75152_c = p_72516_1_.field_73431_a;
            break;

        default:
            ModLoader.clientOpenWindow(p_72516_1_);
            ModLoaderMp.handleGUI(p_72516_1_);
            break;
        }
    }

    public void func_72490_a(Packet103SetSlot p_72490_1_)
    {
        EntityClientPlayerMP entityclientplayermp = field_72563_h.field_71439_g;
        if(p_72490_1_.field_73637_a == -1)
        {
            entityclientplayermp.field_71071_by.func_70437_b(p_72490_1_.field_73636_c);
        } else
        {
            boolean flag = false;
            if(field_72563_h.field_71462_r instanceof GuiContainerCreative)
            {
                GuiContainerCreative guicontainercreative = (GuiContainerCreative)field_72563_h.field_71462_r;
                flag = guicontainercreative.func_74230_h() != CreativeTabs.field_78036_m.func_78021_a();
            }
            if(p_72490_1_.field_73637_a == 0 && p_72490_1_.field_73635_b >= 36 && p_72490_1_.field_73635_b < 45)
            {
                ItemStack itemstack = entityclientplayermp.field_71069_bz.func_75139_a(p_72490_1_.field_73635_b).func_75211_c();
                if(p_72490_1_.field_73636_c != null && (itemstack == null || itemstack.field_77994_a < p_72490_1_.field_73636_c.field_77994_a))
                {
                    p_72490_1_.field_73636_c.field_77992_b = 5;
                }
                entityclientplayermp.field_71069_bz.func_75141_a(p_72490_1_.field_73635_b, p_72490_1_.field_73636_c);
            } else
            if(p_72490_1_.field_73637_a == entityclientplayermp.field_71070_bA.field_75152_c && (p_72490_1_.field_73637_a != 0 || !flag))
            {
                entityclientplayermp.field_71070_bA.func_75141_a(p_72490_1_.field_73635_b, p_72490_1_.field_73636_c);
            }
        }
    }

    public void func_72476_a(Packet106Transaction p_72476_1_)
    {
        Container container = null;
        EntityClientPlayerMP entityclientplayermp = field_72563_h.field_71439_g;
        if(p_72476_1_.field_73435_a == 0)
        {
            container = entityclientplayermp.field_71069_bz;
        } else
        if(p_72476_1_.field_73435_a == entityclientplayermp.field_71070_bA.field_75152_c)
        {
            container = entityclientplayermp.field_71070_bA;
        }
        if(container != null && !p_72476_1_.field_73434_c)
        {
            func_72552_c(new Packet106Transaction(p_72476_1_.field_73435_a, p_72476_1_.field_73433_b, true));
        }
    }

    public void func_72486_a(Packet104WindowItems p_72486_1_)
    {
        EntityClientPlayerMP entityclientplayermp = field_72563_h.field_71439_g;
        if(p_72486_1_.field_73427_a == 0)
        {
            entityclientplayermp.field_71069_bz.func_75131_a(p_72486_1_.field_73426_b);
        } else
        if(p_72486_1_.field_73427_a == entityclientplayermp.field_71070_bA.field_75152_c)
        {
            entityclientplayermp.field_71070_bA.func_75131_a(p_72486_1_.field_73426_b);
        }
    }

    public void func_72487_a(Packet130UpdateSign p_72487_1_)
    {
        if(field_72563_h.field_71441_e.func_72899_e(p_72487_1_.field_73311_a, p_72487_1_.field_73309_b, p_72487_1_.field_73310_c))
        {
            TileEntity tileentity = field_72563_h.field_71441_e.func_72796_p(p_72487_1_.field_73311_a, p_72487_1_.field_73309_b, p_72487_1_.field_73310_c);
            if(tileentity instanceof TileEntitySign)
            {
                TileEntitySign tileentitysign = (TileEntitySign)tileentity;
                if(tileentitysign.func_70409_a())
                {
                    for(int i = 0; i < 4; i++)
                    {
                        tileentitysign.field_70412_a[i] = p_72487_1_.field_73308_d[i];
                    }

                    tileentitysign.func_70296_d();
                }
            }
        }
    }

    public void func_72468_a(Packet132TileEntityData p_72468_1_)
    {
        if(field_72563_h.field_71441_e.func_72899_e(p_72468_1_.field_73334_a, p_72468_1_.field_73332_b, p_72468_1_.field_73333_c))
        {
            TileEntity tileentity = field_72563_h.field_71441_e.func_72796_p(p_72468_1_.field_73334_a, p_72468_1_.field_73332_b, p_72468_1_.field_73333_c);
            if(tileentity != null && p_72468_1_.field_73330_d == 1 && (tileentity instanceof TileEntityMobSpawner))
            {
                ((TileEntityMobSpawner)tileentity).func_70307_a(p_72468_1_.field_73331_e);
            }
        }
    }

    public void func_72505_a(Packet105UpdateProgressbar p_72505_1_)
    {
        EntityClientPlayerMP entityclientplayermp = field_72563_h.field_71439_g;
        func_72509_a(p_72505_1_);
        if(entityclientplayermp.field_71070_bA != null && entityclientplayermp.field_71070_bA.field_75152_c == p_72505_1_.field_73634_a)
        {
            entityclientplayermp.field_71070_bA.func_75137_b(p_72505_1_.field_73632_b, p_72505_1_.field_73633_c);
        }
    }

    public void func_72506_a(Packet5PlayerInventory p_72506_1_)
    {
        Entity entity = func_72545_a(p_72506_1_.field_73400_a);
        if(entity != null)
        {
            entity.func_70062_b(p_72506_1_.field_73398_b, p_72506_1_.func_73397_d());
        }
    }

    public void func_72474_a(Packet101CloseWindow p_72474_1_)
    {
        field_72563_h.field_71439_g.func_71053_j();
    }

    public void func_72454_a(Packet54PlayNoteBlock p_72454_1_)
    {
        field_72563_h.field_71441_e.func_72965_b(p_72454_1_.field_73340_a, p_72454_1_.field_73338_b, p_72454_1_.field_73339_c, p_72454_1_.field_73335_f, p_72454_1_.field_73336_d, p_72454_1_.field_73337_e);
    }

    public void func_72465_a(Packet55BlockDestroy p_72465_1_)
    {
        field_72563_h.field_71441_e.func_72888_f(p_72465_1_.func_73322_d(), p_72465_1_.func_73321_f(), p_72465_1_.func_73324_g(), p_72465_1_.func_73320_h(), p_72465_1_.func_73323_i());
    }

    public void func_72453_a(Packet56MapChunks p_72453_1_)
    {
        for(int i = 0; i < p_72453_1_.func_73581_d(); i++)
        {
            int j = p_72453_1_.func_73582_a(i);
            int k = p_72453_1_.func_73580_b(i);
            field_72564_i.func_73025_a(j, k, true);
            field_72564_i.func_73031_a(j << 4, 0, k << 4, (j << 4) + 15, 256, (k << 4) + 15);
            Chunk chunk = field_72564_i.func_72964_e(j, k);
            if(chunk == null)
            {
                field_72564_i.func_73025_a(j, k, true);
                chunk = field_72564_i.func_72964_e(j, k);
            }
            if(chunk == null)
            {
                continue;
            }
            chunk.func_76607_a(p_72453_1_.func_73583_c(i), p_72453_1_.field_73590_a[i], p_72453_1_.field_73588_b[i], true);
            field_72564_i.func_72909_d(j << 4, 0, k << 4, (j << 4) + 15, 256, (k << 4) + 15);
            if(!(field_72564_i.field_73011_w instanceof WorldProviderSurface))
            {
                chunk.func_76613_n();
            }
        }

    }

    public boolean func_72469_b()
    {
        return field_72563_h != null && field_72563_h.field_71441_e != null && field_72563_h.field_71439_g != null && field_72564_i != null;
    }

    public void func_72488_a(Packet70GameEvent p_72488_1_)
    {
        EntityClientPlayerMP entityclientplayermp = field_72563_h.field_71439_g;
        int i = p_72488_1_.field_73618_b;
        int j = p_72488_1_.field_73619_c;
        if(i >= 0 && i < Packet70GameEvent.field_73620_a.length && Packet70GameEvent.field_73620_a[i] != null)
        {
            entityclientplayermp.func_71035_c(Packet70GameEvent.field_73620_a[i]);
        }
        if(i == 1)
        {
            field_72564_i.func_72912_H().func_76084_b(true);
            field_72564_i.func_72894_k(0.0F);
        } else
        if(i == 2)
        {
            field_72564_i.func_72912_H().func_76084_b(false);
            field_72564_i.func_72894_k(1.0F);
        } else
        if(i == 3)
        {
            field_72563_h.field_71442_b.func_78746_a(EnumGameType.func_77146_a(j));
        } else
        if(i == 4)
        {
            field_72563_h.func_71373_a(new GuiWinGame());
        } else
        if(i == 5)
        {
            GameSettings gamesettings = field_72563_h.field_71474_y;
            if(j == 0)
            {
                field_72563_h.func_71373_a(new GuiScreenDemo());
            } else
            if(j == 101)
            {
                field_72563_h.field_71456_v.func_73827_b().func_73757_a("demo.help.movement", new Object[] {
                    Keyboard.getKeyName(gamesettings.field_74351_w.field_74512_d), Keyboard.getKeyName(gamesettings.field_74370_x.field_74512_d), Keyboard.getKeyName(gamesettings.field_74368_y.field_74512_d), Keyboard.getKeyName(gamesettings.field_74366_z.field_74512_d)
                });
            } else
            if(j == 102)
            {
                field_72563_h.field_71456_v.func_73827_b().func_73757_a("demo.help.jump", new Object[] {
                    Keyboard.getKeyName(gamesettings.field_74314_A.field_74512_d)
                });
            } else
            if(j == 103)
            {
                field_72563_h.field_71456_v.func_73827_b().func_73757_a("demo.help.inventory", new Object[] {
                    Keyboard.getKeyName(gamesettings.field_74315_B.field_74512_d)
                });
            }
        }
    }

    public void func_72494_a(Packet131MapData p_72494_1_)
    {
        if(p_72494_1_.field_73438_a == Item.field_77744_bd.field_77779_bT)
        {
            ItemMap.func_77874_a(p_72494_1_.field_73436_b, field_72563_h.field_71441_e).func_76192_a(p_72494_1_.field_73437_c);
        } else
        {
            System.out.println((new StringBuilder()).append("Unknown itemid: ").append(p_72494_1_.field_73436_b).toString());
        }
    }

    public void func_72462_a(Packet61DoorChange p_72462_1_)
    {
        field_72563_h.field_71441_e.func_72926_e(p_72462_1_.field_73567_a, p_72462_1_.field_73566_c, p_72462_1_.field_73563_d, p_72462_1_.field_73564_e, p_72462_1_.field_73565_b);
    }

    public void func_72517_a(Packet200Statistic p_72517_1_)
    {
        field_72563_h.field_71439_g.func_71167_b(StatList.func_75923_a(p_72517_1_.field_73472_a), p_72517_1_.field_73471_b);
    }

    public void func_72503_a(Packet41EntityEffect p_72503_1_)
    {
        Entity entity = func_72545_a(p_72503_1_.field_73420_a);
        if(entity instanceof EntityLiving)
        {
            ((EntityLiving)entity).func_70690_d(new PotionEffect(p_72503_1_.field_73418_b, p_72503_1_.field_73417_d, p_72503_1_.field_73419_c));
        }
    }

    public void func_72452_a(Packet42RemoveEntityEffect p_72452_1_)
    {
        Entity entity = func_72545_a(p_72452_1_.field_73375_a);
        if(entity instanceof EntityLiving)
        {
            ((EntityLiving)entity).func_70618_n(p_72452_1_.field_73374_b);
        }
    }

    public boolean func_72489_a()
    {
        return false;
    }

    public void func_72480_a(Packet201PlayerInfo p_72480_1_)
    {
        GuiPlayerInfo guiplayerinfo = (GuiPlayerInfo)field_72562_k.get(p_72480_1_.field_73365_a);
        if(guiplayerinfo == null && p_72480_1_.field_73363_b)
        {
            guiplayerinfo = new GuiPlayerInfo(p_72480_1_.field_73365_a);
            field_72562_k.put(p_72480_1_.field_73365_a, guiplayerinfo);
            field_72559_c.add(guiplayerinfo);
        }
        if(guiplayerinfo != null && !p_72480_1_.field_73363_b)
        {
            field_72562_k.remove(p_72480_1_.field_73365_a);
            field_72559_c.remove(guiplayerinfo);
        }
        if(p_72480_1_.field_73363_b && guiplayerinfo != null)
        {
            guiplayerinfo.field_78829_b = p_72480_1_.field_73364_c;
        }
    }

    public void func_72477_a(Packet0KeepAlive p_72477_1_)
    {
        func_72552_c(new Packet0KeepAlive(p_72477_1_.field_73592_a));
    }

    public void func_72471_a(Packet202PlayerAbilities p_72471_1_)
    {
        EntityClientPlayerMP entityclientplayermp = field_72563_h.field_71439_g;
        entityclientplayermp.field_71075_bZ.field_75100_b = p_72471_1_.func_73350_f();
        entityclientplayermp.field_71075_bZ.field_75098_d = p_72471_1_.func_73346_h();
        entityclientplayermp.field_71075_bZ.field_75102_a = p_72471_1_.func_73352_d();
        entityclientplayermp.field_71075_bZ.field_75101_c = p_72471_1_.func_73348_g();
        entityclientplayermp.field_71075_bZ.func_75092_a(p_72471_1_.func_73347_i());
    }

    public void func_72461_a(Packet203AutoComplete p_72461_1_)
    {
        String as[] = p_72461_1_.func_73473_d().split("\0");
        if(field_72563_h.field_71462_r instanceof GuiChat)
        {
            GuiChat guichat = (GuiChat)field_72563_h.field_71462_r;
            guichat.func_73894_a(as);
        }
    }

    public void func_72457_a(Packet62LevelSound p_72457_1_)
    {
        field_72563_h.field_71441_e.func_72980_b(p_72457_1_.func_73572_f(), p_72457_1_.func_73568_g(), p_72457_1_.func_73569_h(), p_72457_1_.func_73570_d(), p_72457_1_.func_73571_i(), p_72457_1_.func_73573_j());
    }

    public void func_72501_a(Packet250CustomPayload p_72501_1_)
    {
        if("MC|TPack".equals(p_72501_1_.field_73630_a))
        {
            String as[] = (new String(p_72501_1_.field_73629_c)).split("\0");
            String s = as[0];
            if(as[1].equals("16"))
            {
                if(field_72563_h.field_71418_C.func_77298_g())
                {
                    field_72563_h.field_71418_C.func_77296_a(s);
                } else
                if(field_72563_h.field_71418_C.func_77300_f())
                {
                    field_72563_h.func_71373_a(new GuiYesNo(new NetClientWebTextures(this, s), StringTranslate.func_74808_a().func_74805_b("multiplayer.texturePrompt.line1"), StringTranslate.func_74808_a().func_74805_b("multiplayer.texturePrompt.line2"), 0));
                }
            }
        } else
        if("MC|TrList".equals(p_72501_1_.field_73630_a))
        {
            DataInputStream datainputstream = new DataInputStream(new ByteArrayInputStream(p_72501_1_.field_73629_c));
            try
            {
                int i = datainputstream.readInt();
                GuiScreen guiscreen = field_72563_h.field_71462_r;
                if(guiscreen != null && (guiscreen instanceof GuiMerchant) && i == field_72563_h.field_71439_g.field_71070_bA.field_75152_c)
                {
                    IMerchant imerchant = ((GuiMerchant)guiscreen).func_74199_h();
                    MerchantRecipeList merchantrecipelist = MerchantRecipeList.func_77204_a(datainputstream);
                    imerchant.func_70930_a(merchantrecipelist);
                }
            }
            catch(IOException ioexception)
            {
                ioexception.printStackTrace();
            }
        } else
        {
            ModLoader.clientCustomPayload(p_72501_1_);
        }
    }

    public NetworkManager func_72548_f()
    {
        return field_72555_g;
    }
}
