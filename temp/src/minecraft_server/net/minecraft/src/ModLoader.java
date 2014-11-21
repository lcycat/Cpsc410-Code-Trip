// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.lang.reflect.*;
import java.net.*;
import java.security.*;
import java.util.*;
import java.util.logging.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            Achievement, StatBase, StatCollector, BaseMod, 
//            CommandHandler, ICommandManager, ICommand, CraftingManager, 
//            FurnaceRecipes, BiomeGenBase, SpawnListEntry, EntityLiving, 
//            World, IInventory, ItemStack, EntityItem, 
//            NBTTagCompound, EntityList, TileEntity, BiomeGenHell, 
//            BiomeGenEnd, Block, StatList, StatCrafting, 
//            Item, IRecipe, Profiler, WorldServer, 
//            EntityPlayerMP, Packet100OpenWindow, NetServerHandler, Container, 
//            EntityPlayer, IChunkProvider, ChunkProviderGenerate, ChunkProviderHell, 
//            Packet250CustomPayload, ItemBlock, EntityEggInfo, MLProp, 
//            TradeEntry, EnumCreatureType, Packet

public final class ModLoader
{

    private static File cfgdir;
    private static File cfgfile;
    public static Level cfgLoggingLevel;
    private static Map classMap = null;
    private static long clock = 0L;
    private static Field field_modifiers = null;
    private static boolean hasInit = false;
    private static int highestEntityId = 3000;
    private static final Map inGameHooks = new HashMap();
    private static MinecraftServer instance = null;
    private static int itemSpriteIndex = 0;
    private static int itemSpritesLeft = 0;
    private static File logfile;
    private static final Logger logger = Logger.getLogger("ModLoader");
    private static FileHandler logHandler = null;
    private static Method method_RegisterEntityID = null;
    private static Method method_RegisterTileEntity = null;
    private static File modDir;
    private static final LinkedList modList = new LinkedList();
    private static int nextBlockModelID = 1000;
    private static final Map overrides = new HashMap();
    private static final Map packetChannels = new HashMap();
    public static final Properties props = new Properties();
    private static BiomeGenBase standardBiomes[];
    private static int terrainSpriteIndex = 0;
    private static int terrainSpritesLeft = 0;
    private static final boolean usedItemSprites[] = new boolean[256];
    private static final boolean usedTerrainSprites[] = new boolean[256];
    public static final String VERSION = "ModLoaderMP 1.3.1v1";
    private static final List commandList = new LinkedList();
    private static final Map tradeItems = new HashMap();
    private static final Map containerGUIs = new HashMap();
    private static Method method_getNextWindowId;
    private static Field field_currentWindowId;

    public static void addAchievementDesc(Achievement achievement, String s, String s1)
    {
        try
        {
            if(achievement.toString().contains("."))
            {
                String as[] = achievement.toString().split("\\.");
                if(as.length == 2)
                {
                    String s2 = as[1];
                    setPrivateValue(net.minecraft.src.StatBase.class, achievement, 1, StatCollector.func_74838_a((new StringBuilder()).append("achievement.").append(s2).toString()));
                    setPrivateValue(net.minecraft.src.Achievement.class, achievement, 3, StatCollector.func_74838_a((new StringBuilder()).append("achievement.").append(s2).append(".desc").toString()));
                } else
                {
                    setPrivateValue(net.minecraft.src.StatBase.class, achievement, 1, s);
                    setPrivateValue(net.minecraft.src.Achievement.class, achievement, 3, s1);
                }
            } else
            {
                setPrivateValue(net.minecraft.src.StatBase.class, achievement, 1, s);
                setPrivateValue(net.minecraft.src.Achievement.class, achievement, 3, s1);
            }
        }
        catch(IllegalArgumentException illegalargumentexception)
        {
            logger.throwing("ModLoader", "AddAchievementDesc", illegalargumentexception);
            throwException(illegalargumentexception);
        }
        catch(SecurityException securityexception)
        {
            logger.throwing("ModLoader", "AddAchievementDesc", securityexception);
            throwException(securityexception);
        }
        catch(NoSuchFieldException nosuchfieldexception)
        {
            logger.throwing("ModLoader", "AddAchievementDesc", nosuchfieldexception);
            throwException(nosuchfieldexception);
        }
    }

    public static int addAllFuel(int i, int j)
    {
        logger.finest((new StringBuilder()).append("Finding fuel for ").append(i).toString());
        int k = 0;
        for(Iterator iterator = modList.iterator(); iterator.hasNext() && k == 0; k = ((BaseMod)iterator.next()).addFuel(i, j)) { }
        if(k != 0)
        {
            logger.finest((new StringBuilder()).append("Returned ").append(k).toString());
        }
        return k;
    }

    public static int addArmor(String s)
    {
        return -1;
    }

    public static void addCommand(ICommand icommand)
    {
        commandList.add(icommand);
    }

    public static void registerCommands(MinecraftServer minecraftserver)
    {
        ICommandManager icommandmanager = minecraftserver.func_71187_D();
        if(icommandmanager instanceof CommandHandler)
        {
            CommandHandler commandhandler = (CommandHandler)icommandmanager;
            ICommand icommand;
            for(Iterator iterator = commandList.iterator(); iterator.hasNext(); commandhandler.func_71560_a(icommand))
            {
                icommand = (ICommand)iterator.next();
            }

        }
    }

    public static void addTrade(int i, TradeEntry tradeentry)
    {
        Object obj = null;
        if(tradeItems.containsKey(Integer.valueOf(i)))
        {
            obj = (List)tradeItems.get(Integer.valueOf(i));
        } else
        {
            obj = new LinkedList();
            tradeItems.put(Integer.valueOf(i), obj);
        }
        ((List)obj).add(tradeentry);
    }

    public static List getTrades(int i)
    {
        if(i != -1)
        {
            return tradeItems.containsKey(Integer.valueOf(i)) ? Collections.unmodifiableList((List)tradeItems.get(Integer.valueOf(i))) : null;
        }
        LinkedList linkedlist = new LinkedList();
        List list;
        for(Iterator iterator = tradeItems.values().iterator(); iterator.hasNext(); linkedlist.addAll(list))
        {
            list = (List)iterator.next();
        }

        return linkedlist;
    }

    private static void addMod(ClassLoader classloader, String s)
    {
        try
        {
            String s1 = s.split("\\.")[0];
            if(s1.contains("$"))
            {
                return;
            }
            if(props.containsKey(s1) && (props.getProperty(s1).equalsIgnoreCase("no") || props.getProperty(s1).equalsIgnoreCase("off")))
            {
                return;
            }
            Package package1 = (net.minecraft.src.ModLoader.class).getPackage();
            if(package1 != null)
            {
                s1 = (new StringBuilder()).append(package1.getName()).append(".").append(s1).toString();
            }
            Class class1 = classloader.loadClass(s1);
            if(!(net.minecraft.src.BaseMod.class).isAssignableFrom(class1))
            {
                return;
            }
            setupProperties(class1);
            BaseMod basemod = (BaseMod)class1.newInstance();
            if(basemod != null)
            {
                modList.add(basemod);
                logger.fine((new StringBuilder()).append("Mod Initialized: \"").append(basemod.toString()).append("\" from ").append(s).toString());
                System.out.println((new StringBuilder()).append("Mod Initialized: ").append(basemod.toString()).toString());
                MinecraftServer.field_71306_a.info((new StringBuilder()).append("Mod Initialized: ").append(basemod.toString()).toString());
            }
        }
        catch(Throwable throwable)
        {
            logger.fine((new StringBuilder()).append("Failed to load mod from \"").append(s).append("\"").toString());
            System.out.println((new StringBuilder()).append("Failed to load mod from \"").append(s).append("\"").toString());
            logger.throwing("ModLoader", "addMod", throwable);
            throwException(throwable);
        }
    }

    public static int addOverride(String s, String s1)
    {
        return 0;
    }

    public static void addOverride(String s, String s1, int i)
    {
        boolean flag = true;
        boolean flag1 = false;
        int j;
        int k;
        if(s.equals("/terrain.png"))
        {
            j = 0;
            k = terrainSpritesLeft;
        } else
        {
            if(!s.equals("/gui/items.png"))
            {
                return;
            }
            j = 1;
            k = itemSpritesLeft;
        }
        System.out.println((new StringBuilder()).append("Overriding ").append(s).append(" with ").append(s1).append(" @ ").append(i).append(". ").append(k).append(" left.").toString());
        logger.finer((new StringBuilder()).append("addOverride(").append(s).append(",").append(s1).append(",").append(i).append("). ").append(k).append(" left.").toString());
        Object obj = (Map)overrides.get(Integer.valueOf(j));
        if(obj == null)
        {
            obj = new HashMap();
            overrides.put(Integer.valueOf(j), obj);
        }
        ((Map)obj).put(s1, Integer.valueOf(i));
    }

    public static void addRecipe(ItemStack itemstack, Object aobj[])
    {
        CraftingManager.func_77594_a().func_77595_a(itemstack, aobj);
    }

    public static void addShapelessRecipe(ItemStack itemstack, Object aobj[])
    {
        CraftingManager.func_77594_a().func_77596_b(itemstack, aobj);
    }

    public static void addSmelting(int i, ItemStack itemstack, float f)
    {
        FurnaceRecipes.func_77602_a().func_77600_a(i, itemstack, f);
    }

    public static void addSpawn(Class class1, int i, int j, int k, EnumCreatureType enumcreaturetype)
    {
        addSpawn(class1, i, j, k, enumcreaturetype, (BiomeGenBase[])null);
    }

    public static void addSpawn(Class class1, int i, int j, int k, EnumCreatureType enumcreaturetype, BiomeGenBase abiomegenbase[])
    {
        if(class1 == null)
        {
            throw new IllegalArgumentException("entityClass cannot be null");
        }
        if(enumcreaturetype == null)
        {
            throw new IllegalArgumentException("spawnList cannot be null");
        }
        if(abiomegenbase == null)
        {
            abiomegenbase = standardBiomes;
        }
        for(int l = 0; l < abiomegenbase.length; l++)
        {
            List list = abiomegenbase[l].func_76747_a(enumcreaturetype);
            if(list == null)
            {
                continue;
            }
            boolean flag = false;
            Iterator iterator = list.iterator();
            do
            {
                if(!iterator.hasNext())
                {
                    break;
                }
                SpawnListEntry spawnlistentry = (SpawnListEntry)iterator.next();
                if(spawnlistentry.field_76300_b != class1)
                {
                    continue;
                }
                spawnlistentry.field_76292_a = i;
                spawnlistentry.field_76301_c = j;
                spawnlistentry.field_76299_d = k;
                flag = true;
                break;
            } while(true);
            if(!flag)
            {
                list.add(new SpawnListEntry(class1, i, j, k));
            }
        }

    }

    public static void addSpawn(String s, int i, int j, int k, EnumCreatureType enumcreaturetype)
    {
        addSpawn(s, i, j, k, enumcreaturetype, (BiomeGenBase[])null);
    }

    public static void addSpawn(String s, int i, int j, int k, EnumCreatureType enumcreaturetype, BiomeGenBase abiomegenbase[])
    {
        Class class1 = (Class)classMap.get(s);
        if(class1 != null && (net.minecraft.src.EntityLiving.class).isAssignableFrom(class1))
        {
            addSpawn(class1, i, j, k, enumcreaturetype, abiomegenbase);
        }
    }

    public static int dispenseEntity(World world, ItemStack itemstack, Random random, int i, int j, int k, int l, int i1, 
            double d, double d1, double d2)
    {
        int j1 = 0;
        for(Iterator iterator = modList.iterator(); j1 == 0 && iterator.hasNext(); j1 = ((BaseMod)iterator.next()).dispenseEntity(world, itemstack, random, i, j, k, l, i1, d, d1, d2)) { }
        return j1;
    }

    public static void genericContainerRemoval(World world, int i, int j, int k)
    {
        IInventory iinventory = (IInventory)world.func_72796_p(i, j, k);
        if(iinventory != null)
        {
            for(int l = 0; l < iinventory.func_70302_i_(); l++)
            {
                ItemStack itemstack = iinventory.func_70301_a(l);
                if(itemstack == null)
                {
                    continue;
                }
                double d = world.field_73012_v.nextDouble() * 0.80000000000000004D + 0.10000000000000001D;
                double d1 = world.field_73012_v.nextDouble() * 0.80000000000000004D + 0.10000000000000001D;
                double d2 = world.field_73012_v.nextDouble() * 0.80000000000000004D + 0.10000000000000001D;
                while(itemstack.field_77994_a > 0) 
                {
                    int i1 = world.field_73012_v.nextInt(21) + 10;
                    if(i1 > itemstack.field_77994_a)
                    {
                        i1 = itemstack.field_77994_a;
                    }
                    itemstack.field_77994_a -= i1;
                    EntityItem entityitem = new EntityItem(world, (double)i + d, (double)j + d1, (double)k + d2, new ItemStack(itemstack.field_77993_c, i1, itemstack.func_77960_j()));
                    double d3 = 0.050000000000000003D;
                    entityitem.field_70159_w = world.field_73012_v.nextGaussian() * d3;
                    entityitem.field_70181_x = world.field_73012_v.nextGaussian() * d3 + 0.20000000000000001D;
                    entityitem.field_70179_y = world.field_73012_v.nextGaussian() * d3;
                    if(itemstack.func_77942_o())
                    {
                        entityitem.field_70294_a.func_77982_d((NBTTagCompound)itemstack.func_77978_p().func_74737_b());
                    }
                    world.func_72838_d(entityitem);
                }
                iinventory.func_70299_a(l, (ItemStack)null);
            }

        }
    }

    public static List getLoadedMods()
    {
        return Collections.unmodifiableList(modList);
    }

    public static Logger getLogger()
    {
        return logger;
    }

    public static MinecraftServer getMinecraftServerInstance()
    {
        return instance;
    }

    public static Object getPrivateValue(Class class1, Object obj, int i)
        throws IllegalArgumentException, SecurityException, NoSuchFieldException
    {
        try
        {
            Field field = class1.getDeclaredFields()[i];
            field.setAccessible(true);
            return field.get(obj);
        }
        catch(IllegalAccessException illegalaccessexception)
        {
            logger.throwing("ModLoader", "getPrivateValue", illegalaccessexception);
            throwException("An impossible error has occured!", illegalaccessexception);
            return null;
        }
    }

    public static Object getPrivateValue(Class class1, Object obj, String s)
        throws IllegalArgumentException, SecurityException, NoSuchFieldException
    {
        try
        {
            Field field = class1.getDeclaredField(s);
            field.setAccessible(true);
            return field.get(obj);
        }
        catch(IllegalAccessException illegalaccessexception)
        {
            logger.throwing("ModLoader", "getPrivateValue", illegalaccessexception);
            throwException("An impossible error has occured!", illegalaccessexception);
            return null;
        }
    }

    public static int getUniqueBlockModelID(BaseMod basemod, boolean flag)
    {
        int i = nextBlockModelID++;
        return i;
    }

    public static int getUniqueEntityId()
    {
        return highestEntityId++;
    }

    private static int getUniqueItemSpriteIndex()
    {
        while(itemSpriteIndex < usedItemSprites.length) 
        {
            if(!usedItemSprites[itemSpriteIndex])
            {
                usedItemSprites[itemSpriteIndex] = true;
                itemSpritesLeft--;
                return itemSpriteIndex++;
            }
        }
        return itemSpriteIndex++;
    }

    public static int getUniqueSpriteIndex(String s)
    {
        if(s.equals("/gui/items.png"))
        {
            return getUniqueItemSpriteIndex();
        }
        if(s.equals("/terrain.png"))
        {
            return getUniqueTerrainSpriteIndex();
        } else
        {
            Exception exception = new Exception((new StringBuilder()).append("No registry for this texture: ").append(s).toString());
            logger.throwing("ModLoader", "getUniqueItemSpriteIndex", exception);
            throwException(exception);
            return 0;
        }
    }

    private static int getUniqueTerrainSpriteIndex()
    {
        while(terrainSpriteIndex < usedTerrainSprites.length) 
        {
            if(!usedTerrainSprites[terrainSpriteIndex])
            {
                usedTerrainSprites[terrainSpriteIndex] = true;
                terrainSpritesLeft--;
                return terrainSpriteIndex++;
            }
        }
        return terrainSpriteIndex++;
    }

    private static void init()
    {
        hasInit = true;
        String s = "1111111111111111111111111111111111111101111111111111111111111111111111111111111111111111111111111111110111111111111111000111111111111101111111110000000101111111000000010111111100000000001110110000000000000000000000000000000000000000000000001111111111111111";
        String s1 = "1111111111111111111111111100111111111111100111111111111110011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000001111111100000111111111100000001111111110000001111111111111111111";
        for(int i = 0; i < 256; i++)
        {
            usedItemSprites[i] = s.charAt(i) == '1';
            if(!usedItemSprites[i])
            {
                itemSpritesLeft++;
            }
            usedTerrainSprites[i] = s1.charAt(i) == '1';
            if(!usedTerrainSprites[i])
            {
                terrainSpritesLeft++;
            }
        }

        try
        {
            classMap = (Map)getPrivateValue(net.minecraft.src.EntityList.class, (Object)null, 0);
            field_modifiers = (java.lang.reflect.Field.class).getDeclaredField("modifiers");
            field_modifiers.setAccessible(true);
            Field afield[] = (net.minecraft.src.BiomeGenBase.class).getDeclaredFields();
            LinkedList linkedlist = new LinkedList();
            int j = 0;
            do
            {
                if(j >= afield.length)
                {
                    standardBiomes = (BiomeGenBase[])linkedlist.toArray(new BiomeGenBase[0]);
                    try
                    {
                        method_RegisterTileEntity = (net.minecraft.src.TileEntity.class).getDeclaredMethod("a", new Class[] {
                            java.lang.Class.class, java.lang.String.class
                        });
                    }
                    catch(NoSuchMethodException nosuchmethodexception1)
                    {
                        method_RegisterTileEntity = (net.minecraft.src.TileEntity.class).getDeclaredMethod("addMapping", new Class[] {
                            java.lang.Class.class, java.lang.String.class
                        });
                    }
                    method_RegisterTileEntity.setAccessible(true);
                    try
                    {
                        method_RegisterEntityID = (net.minecraft.src.EntityList.class).getDeclaredMethod("a", new Class[] {
                            java.lang.Class.class, java.lang.String.class, Integer.TYPE
                        });
                    }
                    catch(NoSuchMethodException nosuchmethodexception2)
                    {
                        method_RegisterEntityID = (net.minecraft.src.EntityList.class).getDeclaredMethod("addMapping", new Class[] {
                            java.lang.Class.class, java.lang.String.class, Integer.TYPE
                        });
                    }
                    method_RegisterEntityID.setAccessible(true);
                    break;
                }
                Class class1 = afield[j].getType();
                if((afield[j].getModifiers() & 8) != 0 && class1.isAssignableFrom(net.minecraft.src.BiomeGenBase.class))
                {
                    BiomeGenBase biomegenbase = (BiomeGenBase)afield[j].get((Object)null);
                    if(!(biomegenbase instanceof BiomeGenHell) && !(biomegenbase instanceof BiomeGenEnd))
                    {
                        linkedlist.add(biomegenbase);
                    }
                }
                j++;
            } while(true);
        }
        catch(SecurityException securityexception)
        {
            logger.throwing("ModLoader", "init", securityexception);
            throwException(securityexception);
            throw new RuntimeException(securityexception);
        }
        catch(NoSuchFieldException nosuchfieldexception)
        {
            logger.throwing("ModLoader", "init", nosuchfieldexception);
            throwException(nosuchfieldexception);
            throw new RuntimeException(nosuchfieldexception);
        }
        catch(NoSuchMethodException nosuchmethodexception)
        {
            logger.throwing("ModLoader", "init", nosuchmethodexception);
            throwException(nosuchmethodexception);
            throw new RuntimeException(nosuchmethodexception);
        }
        catch(IllegalArgumentException illegalargumentexception)
        {
            logger.throwing("ModLoader", "init", illegalargumentexception);
            throwException(illegalargumentexception);
            throw new RuntimeException(illegalargumentexception);
        }
        catch(IllegalAccessException illegalaccessexception)
        {
            logger.throwing("ModLoader", "init", illegalaccessexception);
            throwException(illegalaccessexception);
            throw new RuntimeException(illegalaccessexception);
        }
        try
        {
            loadConfig();
            if(props.containsKey("loggingLevel"))
            {
                cfgLoggingLevel = Level.parse(props.getProperty("loggingLevel"));
            }
            logger.setLevel(cfgLoggingLevel);
            if((logfile.exists() || logfile.createNewFile()) && logfile.canWrite() && logHandler == null)
            {
                logHandler = new FileHandler(logfile.getPath());
                logHandler.setFormatter(new SimpleFormatter());
                logger.addHandler(logHandler);
            }
            logger.fine("ModLoaderMP 1.3.1v1 Initializing...");
            System.out.println("ModLoaderMP 1.3.1v1 Initializing...");
            MinecraftServer.field_71306_a.info("ModLoaderMP 1.3.1v1 Initializing...");
            File file = new File((net.minecraft.src.ModLoader.class).getProtectionDomain().getCodeSource().getLocation().toURI());
            modDir.mkdirs();
            readFromClassPath(file);
            readFromModFolder(modDir);
            sortModList();
            Iterator iterator = modList.iterator();
            do
            {
                if(!iterator.hasNext())
                {
                    break;
                }
                BaseMod basemod = (BaseMod)iterator.next();
                basemod.load();
                logger.fine((new StringBuilder()).append("Mod Loaded: \"").append(basemod.toString()).append("\"").toString());
                System.out.println((new StringBuilder()).append("Mod Loaded: ").append(basemod.toString()).toString());
                if(!props.containsKey(basemod.getClass().getSimpleName()))
                {
                    props.setProperty(basemod.getClass().getSimpleName(), "on");
                }
            } while(true);
            BaseMod basemod1;
            for(Iterator iterator1 = modList.iterator(); iterator1.hasNext(); basemod1.modsLoaded())
            {
                basemod1 = (BaseMod)iterator1.next();
            }

            System.out.println("Done.");
            props.setProperty("loggingLevel", cfgLoggingLevel.getName());
            initStats();
            saveConfig();
        }
        catch(Throwable throwable)
        {
            logger.throwing("ModLoader", "init", throwable);
            throwException("ModLoader has failed to initialize.", throwable);
            if(logHandler != null)
            {
                logHandler.close();
            }
            throw new RuntimeException(throwable);
        }
    }

    private static void initStats()
    {
        for(int i = 0; i < Block.field_71973_m.length; i++)
        {
            if(!StatList.field_75942_a.containsKey(Integer.valueOf(0x1000000 + i)) && Block.field_71973_m[i] != null && Block.field_71973_m[i].func_71876_u())
            {
                String s = StatCollector.func_74837_a("stat.mineBlock", new Object[] {
                    Block.field_71973_m[i].func_71931_t()
                });
                StatList.field_75934_C[i] = (new StatCrafting(0x1000000 + i, s, i)).func_75971_g();
                StatList.field_75939_e.add(StatList.field_75934_C[i]);
            }
        }

        for(int j = 0; j < Item.field_77698_e.length; j++)
        {
            if(!StatList.field_75942_a.containsKey(Integer.valueOf(0x1020000 + j)) && Item.field_77698_e[j] != null)
            {
                String s1 = StatCollector.func_74837_a("stat.useItem", new Object[] {
                    Item.field_77698_e[j].func_77635_s()
                });
                StatList.field_75929_E[j] = (new StatCrafting(0x1020000 + j, s1, j)).func_75971_g();
                if(j >= Block.field_71973_m.length)
                {
                    StatList.field_75938_d.add(StatList.field_75929_E[j]);
                }
            }
            if(!StatList.field_75942_a.containsKey(Integer.valueOf(0x1030000 + j)) && Item.field_77698_e[j] != null && Item.field_77698_e[j].func_77645_m())
            {
                String s2 = StatCollector.func_74837_a("stat.breakItem", new Object[] {
                    Item.field_77698_e[j].func_77635_s()
                });
                StatList.field_75930_F[j] = (new StatCrafting(0x1030000 + j, s2, j)).func_75971_g();
            }
        }

        HashSet hashset = new HashSet();
        Object obj;
        for(Iterator iterator = CraftingManager.func_77594_a().func_77592_b().iterator(); iterator.hasNext(); hashset.add(Integer.valueOf(((IRecipe)obj).func_77571_b().field_77993_c)))
        {
            obj = iterator.next();
        }

        Object obj1;
        for(Iterator iterator1 = FurnaceRecipes.func_77602_a().func_77599_b().values().iterator(); iterator1.hasNext(); hashset.add(Integer.valueOf(((ItemStack)obj1).field_77993_c)))
        {
            obj1 = iterator1.next();
        }

        Iterator iterator2 = hashset.iterator();
        do
        {
            if(!iterator2.hasNext())
            {
                break;
            }
            int k = ((Integer)iterator2.next()).intValue();
            if(!StatList.field_75942_a.containsKey(Integer.valueOf(0x1010000 + k)) && Item.field_77698_e[k] != null)
            {
                String s3 = StatCollector.func_74837_a("stat.craftItem", new Object[] {
                    Item.field_77698_e[k].func_77635_s()
                });
                StatList.field_75928_D[k] = (new StatCrafting(0x1010000 + k, s3, k)).func_75971_g();
            }
        } while(true);
    }

    public static boolean isModLoaded(String s)
    {
        Iterator iterator = modList.iterator();
        BaseMod basemod;
        do
        {
            if(!iterator.hasNext())
            {
                return false;
            }
            basemod = (BaseMod)iterator.next();
        } while(!s.contentEquals(basemod.getName()));
        return true;
    }

    public static void loadConfig()
        throws IOException
    {
        cfgdir.mkdir();
        if((cfgfile.exists() || cfgfile.createNewFile()) && cfgfile.canRead())
        {
            FileInputStream fileinputstream = new FileInputStream(cfgfile);
            props.load(fileinputstream);
            fileinputstream.close();
        }
    }

    public static void onItemPickup(EntityPlayer entityplayer, ItemStack itemstack)
    {
        BaseMod basemod;
        for(Iterator iterator = modList.iterator(); iterator.hasNext(); basemod.onItemPickup(entityplayer, itemstack))
        {
            basemod = (BaseMod)iterator.next();
        }

    }

    public static void onTick(MinecraftServer minecraftserver)
    {
        minecraftserver.field_71304_b.func_76319_b();
        minecraftserver.field_71304_b.func_76319_b();
        minecraftserver.field_71304_b.func_76320_a("modtick");
        if(!hasInit)
        {
            init();
            logger.fine("Initialized");
        }
        long l = 0L;
        if(minecraftserver.field_71305_c != null && minecraftserver.field_71305_c[0] != null)
        {
            l = minecraftserver.field_71305_c[0].func_72820_D();
            Iterator iterator = inGameHooks.entrySet().iterator();
            do
            {
                if(!iterator.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                if(clock != l || !((Boolean)entry.getValue()).booleanValue())
                {
                    ((BaseMod)entry.getKey()).onTickInGame(minecraftserver);
                }
            } while(true);
        }
        clock = l;
        minecraftserver.field_71304_b.func_76319_b();
        minecraftserver.field_71304_b.func_76320_a("render");
        minecraftserver.field_71304_b.func_76320_a("gameRenderer");
    }

    public static void openGUI(EntityPlayer entityplayer, int i, IInventory iinventory, Container container)
    {
        if(!hasInit)
        {
            init();
            logger.fine("Initialized");
        }
        if(entityplayer instanceof EntityPlayerMP)
        {
            EntityPlayerMP entityplayermp = (EntityPlayerMP)entityplayer;
            try
            {
                method_getNextWindowId.invoke(entityplayermp, new Object[0]);
                int j = field_currentWindowId.getInt(entityplayermp);
                entityplayermp.func_71128_l();
                entityplayermp.field_71135_a.func_72567_b(new Packet100OpenWindow(j, i, iinventory.func_70303_b(), iinventory.func_70302_i_()));
                entityplayermp.field_71070_bA = container;
                entityplayermp.field_71070_bA.field_75152_c = j;
                entityplayermp.field_71070_bA.func_75132_a(entityplayermp);
            }
            catch(InvocationTargetException invocationtargetexception)
            {
                getLogger().throwing("ModLoaderMultiplayer", "OpenModGUI", invocationtargetexception);
                throwException("ModLoaderMultiplayer", invocationtargetexception);
            }
            catch(IllegalAccessException illegalaccessexception)
            {
                getLogger().throwing("ModLoaderMultiplayer", "OpenModGUI", illegalaccessexception);
                throwException("ModLoaderMultiplayer", illegalaccessexception);
            }
        }
    }

    public static void populateChunk(IChunkProvider ichunkprovider, int i, int j, World world)
    {
        if(!hasInit)
        {
            init();
            logger.fine("Initialized");
        }
        Random random = new Random(world.func_72905_C());
        long l = (random.nextLong() / 2L) * 2L + 1L;
        long l1 = (random.nextLong() / 2L) * 2L + 1L;
        random.setSeed((long)i * l + (long)j * l1 ^ world.func_72905_C());
        Iterator iterator = modList.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            BaseMod basemod = (BaseMod)iterator.next();
            if(ichunkprovider instanceof ChunkProviderGenerate)
            {
                basemod.generateSurface(world, random, i << 4, j << 4);
            } else
            if(ichunkprovider instanceof ChunkProviderHell)
            {
                basemod.generateNether(world, random, i << 4, j << 4);
            }
        } while(true);
    }

    private static void readFromClassPath(File file)
        throws FileNotFoundException, IOException
    {
        logger.finer((new StringBuilder()).append("Adding mods from ").append(file.getCanonicalPath()).toString());
        ClassLoader classloader = (net.minecraft.src.ModLoader.class).getClassLoader();
        if(file.isFile() && (file.getName().endsWith(".jar") || file.getName().endsWith(".zip")))
        {
            logger.finer("Zip found.");
            FileInputStream fileinputstream = new FileInputStream(file);
            ZipInputStream zipinputstream = new ZipInputStream(fileinputstream);
            Object obj = null;
            do
            {
                ZipEntry zipentry = zipinputstream.getNextEntry();
                if(zipentry == null)
                {
                    fileinputstream.close();
                    break;
                }
                String s2 = zipentry.getName();
                if(!zipentry.isDirectory() && s2.startsWith("mod_") && s2.endsWith(".class"))
                {
                    addMod(classloader, s2);
                }
            } while(true);
        } else
        if(file.isDirectory())
        {
            Package package1 = (net.minecraft.src.ModLoader.class).getPackage();
            if(package1 != null)
            {
                String s = package1.getName().replace('.', File.separatorChar);
                file = new File(file, s);
            }
            logger.finer("Directory found.");
            File afile[] = file.listFiles();
            if(afile != null)
            {
                for(int i = 0; i < afile.length; i++)
                {
                    String s1 = afile[i].getName();
                    if(afile[i].isFile() && s1.startsWith("mod_") && s1.endsWith(".class"))
                    {
                        addMod(classloader, s1);
                    }
                }

            }
        }
    }

    private static void readFromModFolder(File file)
        throws IOException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException
    {
        ClassLoader classloader = (net.minecraft.server.MinecraftServer.class).getClassLoader();
        Method method = (java.net.URLClassLoader.class).getDeclaredMethod("addURL", new Class[] {
            java.net.URL.class
        });
        method.setAccessible(true);
        if(!file.isDirectory())
        {
            throw new IllegalArgumentException("folder must be a Directory.");
        }
        File afile[] = file.listFiles();
        Arrays.sort(afile);
        if(classloader instanceof URLClassLoader)
        {
            for(int i = 0; i < afile.length; i++)
            {
                File file1 = afile[i];
                if(file1.isDirectory() || file1.isFile() && (file1.getName().endsWith(".jar") || file1.getName().endsWith(".zip")))
                {
                    method.invoke(classloader, new Object[] {
                        file1.toURI().toURL()
                    });
                }
            }

        }
label0:
        for(int j = 0; j < afile.length; j++)
        {
            File file2 = afile[j];
            if(!file2.isDirectory() && (!file2.isFile() || !file2.getName().endsWith(".jar") && !file2.getName().endsWith(".zip")))
            {
                continue;
            }
            logger.finer((new StringBuilder()).append("Adding mods from ").append(file2.getCanonicalPath()).toString());
            if(file2.isFile())
            {
                logger.finer("Zip found.");
                FileInputStream fileinputstream = new FileInputStream(file2);
                ZipInputStream zipinputstream = new ZipInputStream(fileinputstream);
                Object obj = null;
                do
                {
                    ZipEntry zipentry;
                    String s2;
                    do
                    {
                        zipentry = zipinputstream.getNextEntry();
                        if(zipentry == null)
                        {
                            zipinputstream.close();
                            fileinputstream.close();
                            continue label0;
                        }
                        s2 = zipentry.getName();
                    } while(zipentry.isDirectory() || !s2.startsWith("mod_") || !s2.endsWith(".class"));
                    addMod(classloader, s2);
                } while(true);
            }
            if(!file2.isDirectory())
            {
                continue;
            }
            Package package1 = (net.minecraft.src.ModLoader.class).getPackage();
            if(package1 != null)
            {
                String s = package1.getName().replace('.', File.separatorChar);
                file2 = new File(file2, s);
            }
            logger.finer("Directory found.");
            File afile1[] = file2.listFiles();
            if(afile1 == null)
            {
                continue;
            }
            for(int k = 0; k < afile1.length; k++)
            {
                String s1 = afile1[k].getName();
                if(afile1[k].isFile() && s1.startsWith("mod_") && s1.endsWith(".class"))
                {
                    addMod(classloader, s1);
                }
            }

        }

    }

    public static void serverCustomPayload(NetServerHandler netserverhandler, Packet250CustomPayload packet250custompayload)
    {
        if(packetChannels.containsKey(packet250custompayload.field_73630_a))
        {
            BaseMod basemod = (BaseMod)packetChannels.get(packet250custompayload.field_73630_a);
            if(basemod != null)
            {
                basemod.serverCustomPayload(netserverhandler, packet250custompayload);
            }
        }
    }

    public static void registerContainerID(BaseMod basemod, int i)
    {
        containerGUIs.put(Integer.valueOf(i), basemod);
    }

    public static void serverOpenWindow(EntityPlayerMP entityplayermp, Container container, int i, int j, int k, int l)
    {
        try
        {
            Field field = (net.minecraft.src.EntityPlayerMP.class).getDeclaredFields()[18];
            field.setAccessible(true);
            int i1 = field.getInt(entityplayermp);
            i1 = i1 % 100 + 1;
            field.setInt(entityplayermp, i1);
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);
            dataoutputstream.write(i1);
            dataoutputstream.writeInt(i);
            dataoutputstream.writeInt(j);
            dataoutputstream.writeInt(k);
            dataoutputstream.writeInt(l);
            dataoutputstream.write(entityplayermp.field_71093_bK);
            entityplayermp.field_71135_a.func_72567_b(new Packet250CustomPayload("ML|OpenTE", bytearrayoutputstream.toByteArray()));
            entityplayermp.field_71070_bA = container;
            entityplayermp.field_71070_bA.field_75152_c = i1;
            entityplayermp.field_71070_bA.func_75132_a(entityplayermp);
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public static void registerBlock(Block block)
    {
        registerBlock(block, (Class)null);
    }

    public static void registerBlock(Block block, Class class1)
    {
        try
        {
            if(block == null)
            {
                throw new IllegalArgumentException("block parameter cannot be null.");
            }
            int i = block.field_71990_ca;
            ItemBlock itemblock = null;
            if(class1 != null)
            {
                itemblock = (ItemBlock)class1.getConstructor(new Class[] {
                    Integer.TYPE
                }).newInstance(new Object[] {
                    Integer.valueOf(i - 256)
                });
            } else
            {
                itemblock = new ItemBlock(i - 256);
            }
            if(Block.field_71973_m[i] != null && Item.field_77698_e[i] == null)
            {
                Item.field_77698_e[i] = itemblock;
            }
        }
        catch(IllegalArgumentException illegalargumentexception)
        {
            logger.throwing("ModLoader", "RegisterBlock", illegalargumentexception);
            throwException(illegalargumentexception);
        }
        catch(IllegalAccessException illegalaccessexception)
        {
            logger.throwing("ModLoader", "RegisterBlock", illegalaccessexception);
            throwException(illegalaccessexception);
        }
        catch(SecurityException securityexception)
        {
            logger.throwing("ModLoader", "RegisterBlock", securityexception);
            throwException(securityexception);
        }
        catch(InstantiationException instantiationexception)
        {
            logger.throwing("ModLoader", "RegisterBlock", instantiationexception);
            throwException(instantiationexception);
        }
        catch(InvocationTargetException invocationtargetexception)
        {
            logger.throwing("ModLoader", "RegisterBlock", invocationtargetexception);
            throwException(invocationtargetexception);
        }
        catch(NoSuchMethodException nosuchmethodexception)
        {
            logger.throwing("ModLoader", "RegisterBlock", nosuchmethodexception);
            throwException(nosuchmethodexception);
        }
    }

    public static void registerEntityID(Class class1, String s, int i)
    {
        try
        {
            method_RegisterEntityID.invoke((Object)null, new Object[] {
                class1, s, Integer.valueOf(i)
            });
        }
        catch(IllegalArgumentException illegalargumentexception)
        {
            logger.throwing("ModLoader", "RegisterEntityID", illegalargumentexception);
            throwException(illegalargumentexception);
        }
        catch(IllegalAccessException illegalaccessexception)
        {
            logger.throwing("ModLoader", "RegisterEntityID", illegalaccessexception);
            throwException(illegalaccessexception);
        }
        catch(InvocationTargetException invocationtargetexception)
        {
            logger.throwing("ModLoader", "RegisterEntityID", invocationtargetexception);
            throwException(invocationtargetexception);
        }
    }

    public static void registerEntityID(Class class1, String s, int i, int j, int k)
    {
        registerEntityID(class1, s, i);
        EntityList.field_75627_a.put(Integer.valueOf(i), new EntityEggInfo(i, j, k));
    }

    public static void registerPacketChannel(BaseMod basemod, String s)
    {
        if(s.length() < 16)
        {
            packetChannels.put(s, basemod);
        } else
        {
            throw new RuntimeException(String.format("Invalid channel name: %s. Must be less than 16 characters.", new Object[] {
                s
            }));
        }
    }

    public static void registerTileEntity(Class class1, String s)
    {
        try
        {
            method_RegisterTileEntity.invoke((Object)null, new Object[] {
                class1, s
            });
        }
        catch(IllegalArgumentException illegalargumentexception)
        {
            logger.throwing("ModLoader", "RegisterTileEntity", illegalargumentexception);
            throwException(illegalargumentexception);
        }
        catch(IllegalAccessException illegalaccessexception)
        {
            logger.throwing("ModLoader", "RegisterTileEntity", illegalaccessexception);
            throwException(illegalaccessexception);
        }
        catch(InvocationTargetException invocationtargetexception)
        {
            logger.throwing("ModLoader", "RegisterTileEntity", invocationtargetexception);
            throwException(invocationtargetexception);
        }
    }

    public static void removeSpawn(Class class1, EnumCreatureType enumcreaturetype)
    {
        removeSpawn(class1, enumcreaturetype, (BiomeGenBase[])null);
    }

    public static void removeSpawn(Class class1, EnumCreatureType enumcreaturetype, BiomeGenBase abiomegenbase[])
    {
        if(class1 == null)
        {
            throw new IllegalArgumentException("entityClass cannot be null");
        }
        if(enumcreaturetype == null)
        {
            throw new IllegalArgumentException("spawnList cannot be null");
        }
        if(abiomegenbase == null)
        {
            abiomegenbase = standardBiomes;
        }
label0:
        for(int i = 0; i < abiomegenbase.length; i++)
        {
            List list = abiomegenbase[i].func_76747_a(enumcreaturetype);
            if(list == null)
            {
                continue;
            }
            Iterator iterator = list.iterator();
            do
            {
                SpawnListEntry spawnlistentry;
                do
                {
                    if(!iterator.hasNext())
                    {
                        continue label0;
                    }
                    spawnlistentry = (SpawnListEntry)iterator.next();
                } while(spawnlistentry.field_76300_b != class1);
                iterator.remove();
            } while(true);
        }

    }

    public static void removeSpawn(String s, EnumCreatureType enumcreaturetype)
    {
        removeSpawn(s, enumcreaturetype, (BiomeGenBase[])null);
    }

    public static void removeSpawn(String s, EnumCreatureType enumcreaturetype, BiomeGenBase abiomegenbase[])
    {
        Class class1 = (Class)classMap.get(s);
        if(class1 != null && (net.minecraft.src.EntityLiving.class).isAssignableFrom(class1))
        {
            removeSpawn(class1, enumcreaturetype, abiomegenbase);
        }
    }

    public static void saveConfig()
        throws IOException
    {
        cfgdir.mkdir();
        if((cfgfile.exists() || cfgfile.createNewFile()) && cfgfile.canWrite())
        {
            FileOutputStream fileoutputstream = new FileOutputStream(cfgfile);
            props.store(fileoutputstream, "ModLoaderMP Config");
            fileoutputstream.close();
        }
    }

    public static void serverChat(NetServerHandler netserverhandler, String s)
    {
        BaseMod basemod;
        for(Iterator iterator = modList.iterator(); iterator.hasNext(); basemod.serverChat(netserverhandler, s))
        {
            basemod = (BaseMod)iterator.next();
        }

    }

    public static void serverSendPacket(NetServerHandler netserverhandler, Packet packet)
    {
        if(netserverhandler != null)
        {
            netserverhandler.func_72567_b(packet);
        }
    }

    public static void setInGameHook(BaseMod basemod, boolean flag, boolean flag1)
    {
        if(flag)
        {
            inGameHooks.put(basemod, Boolean.valueOf(flag1));
        } else
        {
            inGameHooks.remove(basemod);
        }
    }

    public static void setPrivateValue(Class class1, Object obj, int i, Object obj1)
        throws IllegalArgumentException, SecurityException, NoSuchFieldException
    {
        try
        {
            Field field = class1.getDeclaredFields()[i];
            field.setAccessible(true);
            int j = field_modifiers.getInt(field);
            if((j & 0x10) != 0)
            {
                field_modifiers.setInt(field, j & 0xffffffef);
            }
            field.set(obj, obj1);
        }
        catch(IllegalAccessException illegalaccessexception)
        {
            logger.throwing("ModLoader", "setPrivateValue", illegalaccessexception);
            throwException("An impossible error has occured!", illegalaccessexception);
        }
    }

    public static void setPrivateValue(Class class1, Object obj, String s, Object obj1)
        throws IllegalArgumentException, SecurityException, NoSuchFieldException
    {
        try
        {
            Field field = class1.getDeclaredField(s);
            int i = field_modifiers.getInt(field);
            if((i & 0x10) != 0)
            {
                field_modifiers.setInt(field, i & 0xffffffef);
            }
            field.setAccessible(true);
            field.set(obj, obj1);
        }
        catch(IllegalAccessException illegalaccessexception)
        {
            logger.throwing("ModLoader", "setPrivateValue", illegalaccessexception);
            throwException("An impossible error has occured!", illegalaccessexception);
        }
    }

    private static void setupProperties(Class class1)
        throws IllegalArgumentException, IllegalAccessException, IOException, SecurityException, NoSuchFieldException, NoSuchAlgorithmException, DigestException
    {
        LinkedList linkedlist = new LinkedList();
        Properties properties = new Properties();
        int i = 0;
        int j = 0;
        File file = new File(cfgdir, (new StringBuilder()).append(class1.getSimpleName()).append(".cfg").toString());
        if(file.exists() && file.canRead())
        {
            properties.load(new FileInputStream(file));
        }
        if(properties.containsKey("checksum"))
        {
            j = Integer.parseInt(properties.getProperty("checksum"), 36);
        }
        Field afield[];
        int k = (afield = class1.getDeclaredFields()).length;
        for(int l = 0; l < k; l++)
        {
            Field field = afield[l];
            if((field.getModifiers() & 8) != 0 && field.isAnnotationPresent(net.minecraft.src.MLProp.class))
            {
                linkedlist.add(field);
                Object obj = field.get((Object)null);
                i += obj.hashCode();
            }
        }

        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = linkedlist.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            Field field1 = (Field)iterator.next();
            if((field1.getModifiers() & 8) == 0 || !field1.isAnnotationPresent(net.minecraft.src.MLProp.class))
            {
                continue;
            }
            Class class2 = field1.getType();
            MLProp mlprop = (MLProp)field1.getAnnotation(net.minecraft.src.MLProp.class);
            String s = mlprop.name().length() == 0 ? field1.getName() : mlprop.name();
            Object obj1 = field1.get((Object)null);
            StringBuilder stringbuilder1 = new StringBuilder();
            if(mlprop.min() != (-1.0D / 0.0D))
            {
                stringbuilder1.append(String.format(",>=%.1f", new Object[] {
                    Double.valueOf(mlprop.min())
                }));
            }
            if(mlprop.max() != (1.0D / 0.0D))
            {
                stringbuilder1.append(String.format(",<=%.1f", new Object[] {
                    Double.valueOf(mlprop.max())
                }));
            }
            StringBuilder stringbuilder2 = new StringBuilder();
            if(mlprop.info().length() > 0)
            {
                stringbuilder2.append(" -- ");
                stringbuilder2.append(mlprop.info());
            }
            stringbuilder.append(String.format("%s (%s:%s%s)%s\n", new Object[] {
                s, class2.getName(), obj1, stringbuilder1, stringbuilder2
            }));
            if(j == i && properties.containsKey(s))
            {
                String s1 = properties.getProperty(s);
                Object obj2 = null;
                if(class2.isAssignableFrom(java.lang.String.class))
                {
                    obj2 = s1;
                } else
                if(class2.isAssignableFrom(Integer.TYPE))
                {
                    obj2 = Integer.valueOf(Integer.parseInt(s1));
                } else
                if(class2.isAssignableFrom(Short.TYPE))
                {
                    obj2 = Short.valueOf(Short.parseShort(s1));
                } else
                if(class2.isAssignableFrom(Byte.TYPE))
                {
                    obj2 = Byte.valueOf(Byte.parseByte(s1));
                } else
                if(class2.isAssignableFrom(Boolean.TYPE))
                {
                    obj2 = Boolean.valueOf(Boolean.parseBoolean(s1));
                } else
                if(class2.isAssignableFrom(Float.TYPE))
                {
                    obj2 = Float.valueOf(Float.parseFloat(s1));
                } else
                if(class2.isAssignableFrom(Double.TYPE))
                {
                    obj2 = Double.valueOf(Double.parseDouble(s1));
                }
                if(obj2 == null)
                {
                    continue;
                }
                if(obj2 instanceof Number)
                {
                    double d = ((Number)obj2).doubleValue();
                    if(mlprop.min() != (-1.0D / 0.0D) && d < mlprop.min() || mlprop.max() != (1.0D / 0.0D) && d > mlprop.max())
                    {
                        continue;
                    }
                }
                logger.finer((new StringBuilder()).append(s).append(" set to ").append(obj2).toString());
                if(!obj2.equals(obj1))
                {
                    field1.set((Object)null, obj2);
                }
            } else
            {
                logger.finer((new StringBuilder()).append(s).append(" not in config, using default: ").append(obj1).toString());
                properties.setProperty(s, obj1.toString());
            }
        } while(true);
        properties.put("checksum", Integer.toString(i, 36));
        if(!properties.isEmpty() && (file.exists() || file.createNewFile()) && file.canWrite())
        {
            properties.store(new FileOutputStream(file), stringbuilder.toString());
        }
    }

    private static void sortModList()
        throws Exception
    {
        HashMap hashmap = new HashMap();
        BaseMod basemod;
        for(Iterator iterator = getLoadedMods().iterator(); iterator.hasNext(); hashmap.put(basemod.getClass().getSimpleName(), basemod))
        {
            basemod = (BaseMod)iterator.next();
        }

        LinkedList linkedlist = new LinkedList();
label0:
        for(int i = 0; linkedlist.size() != modList.size() && i <= 10; i++)
        {
            Iterator iterator1 = modList.iterator();
label1:
            do
            {
                if(!iterator1.hasNext())
                {
                    continue label0;
                }
                BaseMod basemod1 = (BaseMod)iterator1.next();
                if(linkedlist.contains(basemod1))
                {
                    continue;
                }
                String s = basemod1.getPriorities();
                if(s != null && s.length() != 0 && s.indexOf(':') != -1)
                {
                    if(i <= 0)
                    {
                        continue;
                    }
                    int j = -1;
                    int k = 0x80000000;
                    int l = 0x7fffffff;
                    String as[];
                    if(s.indexOf(';') > 0)
                    {
                        as = s.split(";");
                    } else
                    {
                        as = (new String[] {
                            s
                        });
                    }
                    for(int i1 = 0; i1 < as.length; i1++)
                    {
                        String s1 = as[i1];
                        if(s1.indexOf(':') == -1)
                        {
                            continue;
                        }
                        String as1[] = s1.split(":");
                        String s2 = as1[0];
                        String s3 = as1[1];
                        if(!s2.contentEquals("required-before") && !s2.contentEquals("before") && !s2.contentEquals("after") && !s2.contentEquals("required-after"))
                        {
                            continue;
                        }
                        if(s3.contentEquals("*"))
                        {
                            if(!s2.contentEquals("required-before") && !s2.contentEquals("before"))
                            {
                                if(s2.contentEquals("required-after") || s2.contentEquals("after"))
                                {
                                    j = linkedlist.size();
                                }
                            } else
                            {
                                j = 0;
                            }
                            break;
                        }
                        if((s2.contentEquals("required-before") || s2.contentEquals("required-after")) && !hashmap.containsKey(s3))
                        {
                            throw new Exception(String.format("%s is missing dependency: %s", new Object[] {
                                basemod1, s3
                            }));
                        }
                        BaseMod basemod2 = (BaseMod)hashmap.get(s3);
                        if(!linkedlist.contains(basemod2))
                        {
                            continue label1;
                        }
                        int j1 = linkedlist.indexOf(basemod2);
                        if(!s2.contentEquals("required-before") && !s2.contentEquals("before"))
                        {
                            if(!s2.contentEquals("required-after") && !s2.contentEquals("after"))
                            {
                                continue;
                            }
                            j = j1 + 1;
                            if(j > k)
                            {
                                k = j;
                            } else
                            {
                                j = k;
                            }
                            continue;
                        }
                        j = j1;
                        if(j1 < l)
                        {
                            l = j1;
                        } else
                        {
                            j = l;
                        }
                    }

                    if(j != -1)
                    {
                        linkedlist.add(j, basemod1);
                    }
                } else
                {
                    linkedlist.add(basemod1);
                }
            } while(true);
        }

        modList.clear();
        modList.addAll(linkedlist);
    }

    public static void takenFromCrafting(EntityPlayer entityplayer, ItemStack itemstack, IInventory iinventory)
    {
        BaseMod basemod;
        for(Iterator iterator = modList.iterator(); iterator.hasNext(); basemod.takenFromCrafting(entityplayer, itemstack, iinventory))
        {
            basemod = (BaseMod)iterator.next();
        }

    }

    public static void takenFromFurnace(EntityPlayer entityplayer, ItemStack itemstack)
    {
        BaseMod basemod;
        for(Iterator iterator = modList.iterator(); iterator.hasNext(); basemod.takenFromFurnace(entityplayer, itemstack))
        {
            basemod = (BaseMod)iterator.next();
        }

    }

    public static void throwException(String s, Throwable throwable)
    {
        throwable.printStackTrace();
        logger.log(Level.SEVERE, "Unexpected exception", throwable);
        MinecraftServer.field_71306_a.throwing("ModLoader", s, throwable);
        throw new RuntimeException(s, throwable);
    }

    private static void throwException(Throwable throwable)
    {
        throwException("Exception occured in ModLoader", throwable);
    }

    public static String getCrashReport()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("Mods loaded: ");
        stringbuilder.append(getLoadedMods().size() + 1);
        stringbuilder.append('\n');
        stringbuilder.append("ModLoaderMP 1.3.1v1");
        stringbuilder.append('\n');
        for(Iterator iterator = getLoadedMods().iterator(); iterator.hasNext(); stringbuilder.append('\n'))
        {
            BaseMod basemod = (BaseMod)iterator.next();
            stringbuilder.append(basemod.getName());
            stringbuilder.append(' ');
            stringbuilder.append(basemod.getVersion());
        }

        return stringbuilder.toString();
    }

    private ModLoader()
    {
    }

    public static void initialize(MinecraftServer minecraftserver)
    {
        instance = minecraftserver;
        try
        {
            String s = (net.minecraft.src.ModLoader.class).getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
            s = s.substring(0, s.lastIndexOf('/'));
            cfgdir = new File(s, "/config/");
            cfgfile = new File(s, "/config/ModLoader.cfg");
            logfile = new File(s, "ModLoader.txt");
            modDir = new File(s, "/mods/");
        }
        catch(URISyntaxException urisyntaxexception)
        {
            getLogger().throwing("ModLoader", "Init", urisyntaxexception);
            throwException("ModLoader", urisyntaxexception);
            return;
        }
        try
        {
            try
            {
                method_getNextWindowId = (net.minecraft.src.EntityPlayerMP.class).getDeclaredMethod("b", (Class[])null);
            }
            catch(NoSuchMethodException nosuchmethodexception)
            {
                method_getNextWindowId = (net.minecraft.src.EntityPlayerMP.class).getDeclaredMethod("getNextWindowId", (Class[])null);
            }
            method_getNextWindowId.setAccessible(true);
            try
            {
                field_currentWindowId = (net.minecraft.src.EntityPlayerMP.class).getDeclaredField("cq");
            }
            catch(NoSuchFieldException nosuchfieldexception)
            {
                field_currentWindowId = (net.minecraft.src.EntityPlayerMP.class).getDeclaredField("currentWindowId");
            }
            field_currentWindowId.setAccessible(true);
        }
        catch(NoSuchFieldException nosuchfieldexception1)
        {
            getLogger().throwing("ModLoader", "Init", nosuchfieldexception1);
            throwException("ModLoader", nosuchfieldexception1);
            return;
        }
        catch(NoSuchMethodException nosuchmethodexception1)
        {
            getLogger().throwing("ModLoader", "Init", nosuchmethodexception1);
            throwException("ModLoader", nosuchmethodexception1);
            return;
        }
        init();
    }

    static 
    {
        cfgLoggingLevel = Level.FINER;
    }
}
