package net.minecraft.src;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.security.CodeSource;
import java.security.DigestException;
import java.security.NoSuchAlgorithmException;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.imageio.ImageIO;

import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public final class ModLoader
{
    private static final List animList = new LinkedList();
    private static final Map blockModels = new HashMap();
    private static final Map blockSpecialInv = new HashMap();
    private static final File cfgdir;
    private static final File cfgfile;
    public static Level cfgLoggingLevel;
    private static Map classMap = null;
    private static long clock = 0L;
    private static Field field_animList = null;
    private static Field field_armorList = null;
    private static Field field_modifiers = null;
    private static Field field_TileEntityRenderers = null;
    private static boolean hasInit = false;
    private static int highestEntityId = 3000;
    private static final Map inGameHooks = new HashMap();
    private static final Map inGUIHooks = new HashMap();
    private static Minecraft instance = null;
    private static int itemSpriteIndex = 0;
    private static int itemSpritesLeft = 0;
    private static final Map keyList = new HashMap();
    private static String langPack = null;
    private static Map localizedStrings = new HashMap();
    private static final File logfile = new File(Minecraft.getMinecraftDir(), "ModLoader.txt");
    private static final Logger logger = Logger.getLogger("ModLoader");
    private static FileHandler logHandler = null;
    private static Method method_RegisterEntityID = null;
    private static Method method_RegisterTileEntity = null;
    private static final File modDir = new File(Minecraft.getMinecraftDir(), "/mods/");
    private static final LinkedList modList = new LinkedList();
    private static int nextBlockModelID = 1000;
    private static final Map overrides = new HashMap();
    private static final Map packetChannels = new HashMap();
    public static final Properties props = new Properties();
    private static BiomeGenBase standardBiomes[];
    private static int terrainSpriteIndex = 0;
    private static int terrainSpritesLeft = 0;
    private static String texPack = null;
    private static boolean texturesAdded = false;
    private static final boolean usedItemSprites[] = new boolean[256];
    private static final boolean usedTerrainSprites[] = new boolean[256];
    public static final String VERSION = "ModLoader 1.3.1";
    private static NetClientHandler clientHandler = null;
    private static final List commandList = new LinkedList();
    private static final Map tradeItems = new HashMap();
    private static final Map containerGUIs = new HashMap();
    public static List<Building> Buildings = new ArrayList<Building>();
    
    //generate a list of sample buildings
    public static void generateSampleBuilding(){
    	Building buildA = new Building();
    	buildA.setName("A");
    	buildA.setHeight(55);
    	buildA.setNumberOfFunctions(5);
    	buildA.setTotalNCSS(10);
    	buildA.setBugs(12);
    	Building buildB = new Building();
    	buildB.setName("B");
    	buildB.setHeight(20);
    	buildB.setNumberOfFunctions(3);
    	buildB.setTotalNCSS(6);
    	buildB.setBugs(4);
    	Building buildC = new Building();
    	buildC.setName("C");
    	buildC.setHeight(50);
    	buildC.setNumberOfFunctions(7);
    	buildC.setTotalNCSS(12);
    	buildC.setBugs(10);
    	Buildings.add(buildA);
    	Buildings.add(buildB);
    	Buildings.add(buildC);
    }

    public static void addAchievementDesc(Achievement achievement, String s, String s1)
    {
        try
        {
            if (achievement.getName().contains("."))
            {
                String as[] = achievement.getName().split("\\.");

                if (as.length == 2)
                {
                    String s2 = as[1];
                    addLocalization((new StringBuilder("achievement.")).append(s2).toString(), s);
                    addLocalization((new StringBuilder("achievement.")).append(s2).append(".desc").toString(), s1);
                    setPrivateValue(net.minecraft.src.StatBase.class, achievement, 1, StatCollector.translateToLocal((new StringBuilder("achievement.")).append(s2).toString()));
                    setPrivateValue(net.minecraft.src.Achievement.class, achievement, 3, StatCollector.translateToLocal((new StringBuilder("achievement.")).append(s2).append(".desc").toString()));
                }
                else
                {
                    setPrivateValue(net.minecraft.src.StatBase.class, achievement, 1, s);
                    setPrivateValue(net.minecraft.src.Achievement.class, achievement, 3, s1);
                }
            }
            else
            {
                setPrivateValue(net.minecraft.src.StatBase.class, achievement, 1, s);
                setPrivateValue(net.minecraft.src.Achievement.class, achievement, 3, s1);
            }
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            logger.throwing("ModLoader", "AddAchievementDesc", illegalargumentexception);
            throwException(illegalargumentexception);
        }
        catch (SecurityException securityexception)
        {
            logger.throwing("ModLoader", "AddAchievementDesc", securityexception);
            throwException(securityexception);
        }
        catch (NoSuchFieldException nosuchfieldexception)
        {
            logger.throwing("ModLoader", "AddAchievementDesc", nosuchfieldexception);
            throwException(nosuchfieldexception);
        }
    }

    public static int addAllFuel(int i, int j)
    {
        logger.finest((new StringBuilder()).append("Finding fuel for ").append(i).toString());
        int k = 0;

        for (Iterator iterator = modList.iterator(); iterator.hasNext() && k == 0; k = ((BaseMod)iterator.next()).addFuel(i, j)) { }

        if (k != 0)
        {
            logger.finest((new StringBuilder()).append("Returned ").append(k).toString());
        }

        return k;
    }

    public static void addAllRenderers(Map map)
    {
        if (!hasInit)
        {
            init();
            logger.fine("Initialized");
        }

        BaseMod basemod;

        for (Iterator iterator = modList.iterator(); iterator.hasNext(); basemod.addRenderer(map))
        {
            basemod = (BaseMod)iterator.next();
        }
    }

    public static void addAnimation(TextureFX texturefx)
    {
        logger.finest((new StringBuilder()).append("Adding animation ").append(texturefx.toString()).toString());
        Iterator iterator = animList.iterator();

        do
        {
            if (!iterator.hasNext())
            {
                break;
            }

            TextureFX texturefx1 = (TextureFX)iterator.next();

            if (texturefx1.iconIndex != texturefx.iconIndex || texturefx1.tileImage != texturefx.tileImage)
            {
                continue;
            }

            animList.remove(texturefx);
            break;
        }
        while (true);

        animList.add(texturefx);
    }

    public static int addArmor(String s)
    {
        try
        {
            String as[] = (String[])field_armorList.get(null);
            List list = Arrays.asList(as);
            ArrayList arraylist = new ArrayList();
            arraylist.addAll(list);

            if (!arraylist.contains(s))
            {
                arraylist.add(s);
            }

            int i = arraylist.indexOf(s);
            field_armorList.set(null, ((Object)(arraylist.toArray(new String[0]))));
            return i;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            logger.throwing("ModLoader", "AddArmor", illegalargumentexception);
            throwException("An impossible error has occured!", illegalargumentexception);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            logger.throwing("ModLoader", "AddArmor", illegalaccessexception);
            throwException("An impossible error has occured!", illegalaccessexception);
        }

        return -1;
    }

    public static void addBiome(BiomeGenBase biomegenbase)
    {
        BiomeGenBase abiomegenbase[] = GenLayerBiome.biomeArray;
        List list = Arrays.asList(abiomegenbase);
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(list);

        if (!arraylist.contains(biomegenbase))
        {
            arraylist.add(biomegenbase);
        }

        GenLayerBiome.biomeArray = (BiomeGenBase[])arraylist.toArray(new BiomeGenBase[0]);
    }

    public static void addCommand(ICommand icommand)
    {
        commandList.add(icommand);
    }

    public static void registerCommands(MinecraftServer minecraftserver)
    {
        ICommandManager icommandmanager = minecraftserver.getCommandManager();

        if (!(icommandmanager instanceof CommandHandler))
        {
            return;
        }

        CommandHandler commandhandler = (CommandHandler)icommandmanager;
        ICommand icommand;

        for (Iterator iterator = commandList.iterator(); iterator.hasNext(); commandhandler.registerCommand(icommand))
        {
            icommand = (ICommand)iterator.next();
        }
    }

    public static void addLocalization(String s, String s1)
    {
        addLocalization(s, "en_US", s1);
    }

    public static void addLocalization(String s, String s1, String s2)
    {
        Object obj;

        if (localizedStrings.containsKey(s1))
        {
            obj = (Map)localizedStrings.get(s1);
        }
        else
        {
            obj = new HashMap();
            localizedStrings.put(s1, obj);
        }

        ((Map)(obj)).put(s, s2);
    }

    public static void addTrade(int i, TradeEntry tradeentry)
    {
        Object obj = null;

        if (tradeItems.containsKey(Integer.valueOf(i)))
        {
            obj = (List)tradeItems.get(Integer.valueOf(i));
        }
        else
        {
            obj = new LinkedList();
            tradeItems.put(Integer.valueOf(i), obj);
        }

        ((List)(obj)).add(tradeentry);
    }

    public static List getTrades(int i)
    {
        if (i == -1)
        {
            LinkedList linkedlist = new LinkedList();
            List list;

            for (Iterator iterator = tradeItems.values().iterator(); iterator.hasNext(); linkedlist.addAll(list))
            {
                list = (List)iterator.next();
            }

            return linkedlist;
        }

        if (tradeItems.containsKey(Integer.valueOf(i)))
        {
            return Collections.unmodifiableList((List)tradeItems.get(Integer.valueOf(i)));
        }
        else
        {
            return null;
        }
    }

    private static void addMod(ClassLoader classloader, String s)
    {
        try
        {
            String s1 = s.split("\\.")[0];

            if (s1.contains("$"))
            {
                return;
            }

            if (props.containsKey(s1) && (props.getProperty(s1).equalsIgnoreCase("no") || props.getProperty(s1).equalsIgnoreCase("off")))
            {
                return;
            }

            Package package1 = (net.minecraft.src.ModLoader.class).getPackage();

            if (package1 != null)
            {
                s1 = (new StringBuilder(String.valueOf(package1.getName()))).append(".").append(s1).toString();
            }

            Class class1 = classloader.loadClass(s1);

            if (!(net.minecraft.src.BaseMod.class).isAssignableFrom(class1))
            {
                return;
            }

            setupProperties(class1);
            BaseMod basemod = (BaseMod)class1.newInstance();

            if (basemod != null)
            {
                modList.add(basemod);
                logger.fine((new StringBuilder("Mod Initialized: \"")).append(basemod.toString()).append("\" from ").append(s).toString());
                System.out.println((new StringBuilder("Mod Initialized: ")).append(basemod.toString()).toString());
            }
        }
        catch (Throwable throwable)
        {
            logger.fine((new StringBuilder("Failed to load mod from \"")).append(s).append("\"").toString());
            System.out.println((new StringBuilder("Failed to load mod from \"")).append(s).append("\"").toString());
            logger.throwing("ModLoader", "addMod", throwable);
            throwException(throwable);
        }
    }

    public static void addName(Object obj, String s)
    {
        addName(obj, "en_US", s);
    }

    public static void addName(Object obj, String s, String s1)
    {
        String s2 = null;

        if (obj instanceof Item)
        {
            Item item = (Item)obj;

            if (item.getItemName() != null)
            {
                s2 = (new StringBuilder(String.valueOf(item.getItemName()))).append(".name").toString();
            }
        }
        else if (obj instanceof Block)
        {
            Block block = (Block)obj;

            if (block.getBlockName() != null)
            {
                s2 = (new StringBuilder(String.valueOf(block.getBlockName()))).append(".name").toString();
            }
        }
        else if (obj instanceof ItemStack)
        {
            ItemStack itemstack = (ItemStack)obj;
            String s3 = Item.itemsList[itemstack.itemID].getItemNameIS(itemstack);

            if (s3 != null)
            {
                s2 = (new StringBuilder(String.valueOf(s3))).append(".name").toString();
            }
        }
        else
        {
            Exception exception = new Exception((new StringBuilder(String.valueOf(obj.getClass().getName()))).append(" cannot have name attached to it!").toString());
            logger.throwing("ModLoader", "AddName", exception);
            throwException(exception);
        }

        if (s2 != null)
        {
            addLocalization(s2, s, s1);
        }
        else
        {
            Exception exception1 = new Exception((new StringBuilder()).append(obj).append(" is missing name tag!").toString());
            logger.throwing("ModLoader", "AddName", exception1);
            throwException(exception1);
        }
    }

    public static int addOverride(String s, String s1)
    {
        try
        {
            int i = getUniqueSpriteIndex(s);
            addOverride(s, s1, i);
            return i;
        }
        catch (Throwable throwable)
        {
            logger.throwing("ModLoader", "addOverride", throwable);
            throwException(throwable);
            throw new RuntimeException(throwable);
        }
    }

    public static void addOverride(String s, String s1, int i)
    {
        int j = -1;
        int k = 0;

        if (s.equals("/terrain.png"))
        {
            j = 0;
            k = terrainSpritesLeft;
        }
        else if (s.equals("/gui/items.png"))
        {
            j = 1;
            k = itemSpritesLeft;
        }
        else
        {
            return;
        }

        System.out.println((new StringBuilder("Overriding ")).append(s).append(" with ").append(s1).append(" @ ").append(i).append(". ").append(k).append(" left.").toString());
        logger.finer((new StringBuilder("addOverride(")).append(s).append(",").append(s1).append(",").append(i).append("). ").append(k).append(" left.").toString());
        Object obj = (Map)overrides.get(Integer.valueOf(j));

        if (obj == null)
        {
            obj = new HashMap();
            overrides.put(Integer.valueOf(j), obj);
        }

        ((Map)(obj)).put(s1, Integer.valueOf(i));
    }

    public static void addRecipe(ItemStack itemstack, Object aobj[])
    {
        CraftingManager.getInstance().addRecipe(itemstack, aobj);
    }

    public static void addShapelessRecipe(ItemStack itemstack, Object aobj[])
    {
        CraftingManager.getInstance().addShapelessRecipe(itemstack, aobj);
    }

    public static void addSmelting(int i, ItemStack itemstack, float f)
    {
        FurnaceRecipes.smelting().addSmelting(i, itemstack, f);
    }

    public static void addSpawn(Class class1, int i, int j, int k, EnumCreatureType enumcreaturetype)
    {
        addSpawn(class1, i, j, k, enumcreaturetype, null);
    }

    public static void addSpawn(Class class1, int i, int j, int k, EnumCreatureType enumcreaturetype, BiomeGenBase abiomegenbase[])
    {
        if (class1 == null)
        {
            throw new IllegalArgumentException("entityClass cannot be null");
        }

        if (enumcreaturetype == null)
        {
            throw new IllegalArgumentException("spawnList cannot be null");
        }

        if (abiomegenbase == null)
        {
            abiomegenbase = standardBiomes;
        }

        for (int l = 0; l < abiomegenbase.length; l++)
        {
            List list = abiomegenbase[l].getSpawnableList(enumcreaturetype);

            if (list == null)
            {
                continue;
            }

            boolean flag = false;
            Iterator iterator = list.iterator();

            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }

                SpawnListEntry spawnlistentry = (SpawnListEntry)iterator.next();

                if (spawnlistentry.entityClass != class1)
                {
                    continue;
                }

                spawnlistentry.itemWeight = i;
                spawnlistentry.minGroupCount = j;
                spawnlistentry.maxGroupCount = k;
                flag = true;
                break;
            }
            while (true);

            if (!flag)
            {
                list.add(new SpawnListEntry(class1, i, j, k));
            }
        }
    }

    public static void addSpawn(String s, int i, int j, int k, EnumCreatureType enumcreaturetype)
    {
        addSpawn(s, i, j, k, enumcreaturetype, null);
    }

    public static void addSpawn(String s, int i, int j, int k, EnumCreatureType enumcreaturetype, BiomeGenBase abiomegenbase[])
    {
        Class class1 = (Class)classMap.get(s);

        if (class1 != null && (net.minecraft.src.EntityLiving.class).isAssignableFrom(class1))
        {
            addSpawn(class1, i, j, k, enumcreaturetype, abiomegenbase);
        }
    }

    public static int dispenseEntity(World world, ItemStack itemstack, Random random, int i, int j, int k, int l, int i1, double d, double d1, double d2)
    {
        int j1 = 0;

        for (Iterator iterator = modList.iterator(); j1 == 0 && iterator.hasNext(); j1 = ((BaseMod)iterator.next()).dispenseEntity(world, itemstack, random, i, j, k, l, i1, d, d1, d2)) { }

        return j1;
    }

    public static void genericContainerRemoval(World world, int i, int j, int k)
    {
        IInventory iinventory = (IInventory)world.getBlockTileEntity(i, j, k);

        if (iinventory != null)
        {
            for (int l = 0; l < iinventory.getSizeInventory(); l++)
            {
                ItemStack itemstack = iinventory.getStackInSlot(l);

                if (itemstack == null)
                {
                    continue;
                }

                double d = world.rand.nextDouble() * 0.80000000000000004D + 0.10000000000000001D;
                double d1 = world.rand.nextDouble() * 0.80000000000000004D + 0.10000000000000001D;
                double d2 = world.rand.nextDouble() * 0.80000000000000004D + 0.10000000000000001D;

                while (itemstack.stackSize > 0)
                {
                    int i1 = world.rand.nextInt(21) + 10;

                    if (i1 > itemstack.stackSize)
                    {
                        i1 = itemstack.stackSize;
                    }

                    itemstack.stackSize -= i1;
                    EntityItem entityitem = new EntityItem(world, (double)i + d, (double)j + d1, (double)k + d2, new ItemStack(itemstack.itemID, i1, itemstack.getItemDamage()));
                    double d3 = 0.050000000000000003D;
                    entityitem.motionX = world.rand.nextGaussian() * d3;
                    entityitem.motionY = world.rand.nextGaussian() * d3 + 0.20000000000000001D;
                    entityitem.motionZ = world.rand.nextGaussian() * d3;

                    if (itemstack.hasTagCompound())
                    {
                        entityitem.item.setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                    }

                    world.spawnEntityInWorld(entityitem);
                }

                iinventory.setInventorySlotContents(l, null);
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

    public static Minecraft getMinecraftInstance()
    {
        if (instance == null)
        {
            try
            {
                ThreadGroup threadgroup = Thread.currentThread().getThreadGroup();
                int i = threadgroup.activeCount();
                Thread athread[] = new Thread[i];
                threadgroup.enumerate(athread);

                for (int j = 0; j < athread.length; j++)
                {
                    System.out.println(athread[j].getName());
                }

                int k = 0;

                do
                {
                    if (k >= athread.length)
                    {
                        break;
                    }

                    if (athread[k].getName().equals("Minecraft main thread"))
                    {
                        instance = (Minecraft)getPrivateValue(java.lang.Thread.class, athread[k], "target");
                        break;
                    }

                    k++;
                }
                while (true);
            }
            catch (SecurityException securityexception)
            {
                logger.throwing("ModLoader", "getMinecraftInstance", securityexception);
                throw new RuntimeException(securityexception);
            }
            catch (NoSuchFieldException nosuchfieldexception)
            {
                logger.throwing("ModLoader", "getMinecraftInstance", nosuchfieldexception);
                throw new RuntimeException(nosuchfieldexception);
            }
        }

        return instance;
    }

    public static Object getPrivateValue(Class class1, Object obj, int i) throws IllegalArgumentException, SecurityException, NoSuchFieldException
    {
        try
        {
            Field field = class1.getDeclaredFields()[i];
            field.setAccessible(true);
            return field.get(obj);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            logger.throwing("ModLoader", "getPrivateValue", illegalaccessexception);
            throwException("An impossible error has occured!", illegalaccessexception);
            return null;
        }
    }

    public static Object getPrivateValue(Class class1, Object obj, String s) throws IllegalArgumentException, SecurityException, NoSuchFieldException
    {
        try
        {
            Field field = class1.getDeclaredField(s);
            field.setAccessible(true);
            return field.get(obj);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            logger.throwing("ModLoader", "getPrivateValue", illegalaccessexception);
            throwException("An impossible error has occured!", illegalaccessexception);
            return null;
        }
    }

    public static int getUniqueBlockModelID(BaseMod basemod, boolean flag)
    {
        int i = nextBlockModelID++;
        blockModels.put(Integer.valueOf(i), basemod);
        blockSpecialInv.put(Integer.valueOf(i), Boolean.valueOf(flag));
        return i;
    }

    public static int getUniqueEntityId()
    {
        return highestEntityId++;
    }

    private static int getUniqueItemSpriteIndex()
    {
        for (; itemSpriteIndex < usedItemSprites.length; itemSpriteIndex++)
        {
            if (!usedItemSprites[itemSpriteIndex])
            {
                usedItemSprites[itemSpriteIndex] = true;
                itemSpritesLeft--;
                return itemSpriteIndex++;
            }
        }

        Exception exception = new Exception("No more empty item sprite indices left!");
        logger.throwing("ModLoader", "getUniqueItemSpriteIndex", exception);
        throwException(exception);
        return 0;
    }

    public static int getUniqueSpriteIndex(String s)
    {
        if (s.equals("/gui/items.png"))
        {
            return getUniqueItemSpriteIndex();
        }

        if (s.equals("/terrain.png"))
        {
            return getUniqueTerrainSpriteIndex();
        }
        else
        {
            Exception exception = new Exception((new StringBuilder("No registry for this texture: ")).append(s).toString());
            logger.throwing("ModLoader", "getUniqueItemSpriteIndex", exception);
            throwException(exception);
            return 0;
        }
    }

    private static int getUniqueTerrainSpriteIndex()
    {
        for (; terrainSpriteIndex < usedTerrainSprites.length; terrainSpriteIndex++)
        {
            if (!usedTerrainSprites[terrainSpriteIndex])
            {
                usedTerrainSprites[terrainSpriteIndex] = true;
                terrainSpritesLeft--;
                return terrainSpriteIndex++;
            }
        }

        Exception exception = new Exception("No more empty terrain sprite indices left!");
        logger.throwing("ModLoader", "getUniqueItemSpriteIndex", exception);
        throwException(exception);
        return 0;
    }

    private static void init()
    {
        hasInit = true;
        String s = "1111111111111111111111111111111111111101111111111111111111111111111111111111111111111111111111111111110111111111111111000111111111111101111111110000000101111111000000010111111100000000001110110000000000000000000000000000000000000000000000001111111111111111";
        String s1 = "1111111111111111111111111100111111111111100111111111111110011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000001111111100000111111111100000001111111110000001111111111111111111";

        for (int i = 0; i < 256; i++)
        {
            usedItemSprites[i] = s.charAt(i) == '1';

            if (!usedItemSprites[i])
            {
                itemSpritesLeft++;
            }

            usedTerrainSprites[i] = s1.charAt(i) == '1';

            if (!usedTerrainSprites[i])
            {
                terrainSpritesLeft++;
            }
        }

        try
        {
            instance = Minecraft.getMinecraft();
            instance.entityRenderer = new EntityRendererProxy(instance);
            classMap = (Map)getPrivateValue(net.minecraft.src.EntityList.class, null, 0);
            field_modifiers = (java.lang.reflect.Field.class).getDeclaredField("modifiers");
            field_modifiers.setAccessible(true);
            field_TileEntityRenderers = (net.minecraft.src.TileEntityRenderer.class).getDeclaredFields()[0];
            field_TileEntityRenderers.setAccessible(true);
            field_armorList = (net.minecraft.src.RenderPlayer.class).getDeclaredFields()[3];
            field_modifiers.setInt(field_armorList, field_armorList.getModifiers() & 0xffffffef);
            field_armorList.setAccessible(true);
            field_animList = (net.minecraft.src.RenderEngine.class).getDeclaredFields()[6];
            field_animList.setAccessible(true);
            Field afield[] = (net.minecraft.src.BiomeGenBase.class).getDeclaredFields();
            LinkedList linkedlist = new LinkedList();

            for (int j = 0; j < afield.length; j++)
            {
                Class class1 = afield[j].getType();

                if ((afield[j].getModifiers() & 8) == 0 || !class1.isAssignableFrom(net.minecraft.src.BiomeGenBase.class))
                {
                    continue;
                }

                BiomeGenBase biomegenbase = (BiomeGenBase)afield[j].get(null);

                if (!(biomegenbase instanceof BiomeGenHell) && !(biomegenbase instanceof BiomeGenEnd))
                {
                    linkedlist.add(biomegenbase);
                }
            }

            standardBiomes = (BiomeGenBase[])linkedlist.toArray(new BiomeGenBase[0]);

            try
            {
                method_RegisterTileEntity = (net.minecraft.src.TileEntity.class).getDeclaredMethod("a", new Class[]
                        {
                            java.lang.Class.class, java.lang.String.class
                        });
            }
            catch (NoSuchMethodException nosuchmethodexception1)
            {
                method_RegisterTileEntity = (net.minecraft.src.TileEntity.class).getDeclaredMethod("addMapping", new Class[]
                        {
                            java.lang.Class.class, java.lang.String.class
                        });
            }

            method_RegisterTileEntity.setAccessible(true);

            try
            {
                method_RegisterEntityID = (net.minecraft.src.EntityList.class).getDeclaredMethod("a", new Class[]
                        {
                            java.lang.Class.class, java.lang.String.class, Integer.TYPE
                        });
            }
            catch (NoSuchMethodException nosuchmethodexception2)
            {
                method_RegisterEntityID = (net.minecraft.src.EntityList.class).getDeclaredMethod("addMapping", new Class[]
                        {
                            java.lang.Class.class, java.lang.String.class, Integer.TYPE
                        });
            }

            method_RegisterEntityID.setAccessible(true);
        }
        catch (SecurityException securityexception)
        {
            logger.throwing("ModLoader", "init", securityexception);
            throwException(securityexception);
            throw new RuntimeException(securityexception);
        }
        catch (NoSuchFieldException nosuchfieldexception)
        {
            logger.throwing("ModLoader", "init", nosuchfieldexception);
            throwException(nosuchfieldexception);
            throw new RuntimeException(nosuchfieldexception);
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            logger.throwing("ModLoader", "init", nosuchmethodexception);
            throwException(nosuchmethodexception);
            throw new RuntimeException(nosuchmethodexception);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            logger.throwing("ModLoader", "init", illegalargumentexception);
            throwException(illegalargumentexception);
            throw new RuntimeException(illegalargumentexception);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            logger.throwing("ModLoader", "init", illegalaccessexception);
            throwException(illegalaccessexception);
            throw new RuntimeException(illegalaccessexception);
        }

        try
        {
            loadConfig();

            if (props.containsKey("loggingLevel"))
            {
                cfgLoggingLevel = Level.parse(props.getProperty("loggingLevel"));
            }

            if (props.containsKey("grassFix"))
            {
                RenderBlocks.cfgGrassFix = Boolean.parseBoolean(props.getProperty("grassFix"));
            }

            logger.setLevel(cfgLoggingLevel);

            if ((logfile.exists() || logfile.createNewFile()) && logfile.canWrite() && logHandler == null)
            {
                logHandler = new FileHandler(logfile.getPath());
                logHandler.setFormatter(new SimpleFormatter());
                logger.addHandler(logHandler);
            }

            logger.fine("ModLoader 1.3.1 Initializing...");
            System.out.println("ModLoader 1.3.1 Initializing...");
            File file = new File((net.minecraft.src.ModLoader.class).getProtectionDomain().getCodeSource().getLocation().toURI());
            modDir.mkdirs();
            readFromClassPath(file);
            readFromModFolder(modDir);
            sortModList();
            Iterator iterator = modList.iterator();

            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }

                BaseMod basemod1 = (BaseMod)iterator.next();
                basemod1.load();
                logger.fine((new StringBuilder("Mod Loaded: \"")).append(basemod1.toString()).append("\"").toString());
                System.out.println((new StringBuilder("Mod Loaded: ")).append(basemod1.toString()).toString());

                if (!props.containsKey(basemod1.getClass().getSimpleName()))
                {
                    props.setProperty(basemod1.getClass().getSimpleName(), "on");
                }
            }
            while (true);

            BaseMod basemod;

            for (Iterator iterator1 = modList.iterator(); iterator1.hasNext(); basemod.modsLoaded())
            {
                basemod = (BaseMod)iterator1.next();
            }

            System.out.println("Done.");
            props.setProperty("loggingLevel", cfgLoggingLevel.getName());
            props.setProperty("grassFix", Boolean.toString(RenderBlocks.cfgGrassFix));
            instance.gameSettings.keyBindings = registerAllKeys(instance.gameSettings.keyBindings);
            instance.gameSettings.loadOptions();
            initStats();
            saveConfig();
        }
        catch (Throwable throwable)
        {
            logger.throwing("ModLoader", "init", throwable);
            throwException("ModLoader has failed to initialize.", throwable);

            if (logHandler != null)
            {
                logHandler.close();
            }

            throw new RuntimeException(throwable);
        }
    }

    private static void initStats()
    {
        for (int i = 0; i < Block.blocksList.length; i++)
        {
            if (!StatList.oneShotStats.containsKey(Integer.valueOf(0x1000000 + i)) && Block.blocksList[i] != null && Block.blocksList[i].getEnableStats())
            {
                String s = StatCollector.translateToLocalFormatted("stat.mineBlock", new Object[]
                        {
                            Block.blocksList[i].translateBlockName()
                        });
                StatList.mineBlockStatArray[i] = (new StatCrafting(0x1000000 + i, s, i)).registerStat();
                StatList.objectMineStats.add(StatList.mineBlockStatArray[i]);
            }
        }

        for (int j = 0; j < Item.itemsList.length; j++)
        {
            if (!StatList.oneShotStats.containsKey(Integer.valueOf(0x1020000 + j)) && Item.itemsList[j] != null)
            {
                String s1 = StatCollector.translateToLocalFormatted("stat.useItem", new Object[]
                        {
                            Item.itemsList[j].getStatName()
                        });
                StatList.objectUseStats[j] = (new StatCrafting(0x1020000 + j, s1, j)).registerStat();

                if (j >= Block.blocksList.length)
                {
                    StatList.itemStats.add(StatList.objectUseStats[j]);
                }
            }

            if (!StatList.oneShotStats.containsKey(Integer.valueOf(0x1030000 + j)) && Item.itemsList[j] != null && Item.itemsList[j].isDamageable())
            {
                String s2 = StatCollector.translateToLocalFormatted("stat.breakItem", new Object[]
                        {
                            Item.itemsList[j].getStatName()
                        });
                StatList.objectBreakStats[j] = (new StatCrafting(0x1030000 + j, s2, j)).registerStat();
            }
        }

        HashSet hashset = new HashSet();
        Object obj;

        for (Iterator iterator = CraftingManager.getInstance().getRecipeList().iterator(); iterator.hasNext(); hashset.add(Integer.valueOf(((IRecipe)obj).getRecipeOutput().itemID)))
        {
            obj = iterator.next();
        }

        Object obj1;

        for (Iterator iterator1 = FurnaceRecipes.smelting().getSmeltingList().values().iterator(); iterator1.hasNext(); hashset.add(Integer.valueOf(((ItemStack)obj1).itemID)))
        {
            obj1 = iterator1.next();
        }

        Iterator iterator2 = hashset.iterator();

        do
        {
            if (!iterator2.hasNext())
            {
                break;
            }

            int k = ((Integer)iterator2.next()).intValue();

            if (!StatList.oneShotStats.containsKey(Integer.valueOf(0x1010000 + k)) && Item.itemsList[k] != null)
            {
                String s3 = StatCollector.translateToLocalFormatted("stat.craftItem", new Object[]
                        {
                            Item.itemsList[k].getStatName()
                        });
                StatList.objectCraftStats[k] = (new StatCrafting(0x1010000 + k, s3, k)).registerStat();
            }
        }
        while (true);
    }

    public static boolean isGUIOpen(Class class1)
    {
        Minecraft minecraft = getMinecraftInstance();

        if (class1 == null)
        {
            return minecraft.currentScreen == null;
        }

        if (minecraft.currentScreen == null && class1 != null)
        {
            return false;
        }
        else
        {
            return class1.isInstance(minecraft.currentScreen);
        }
    }

    public static boolean isModLoaded(String s)
    {
        for (Iterator iterator = modList.iterator(); iterator.hasNext();)
        {
            BaseMod basemod = (BaseMod)iterator.next();

            if (s.contentEquals(basemod.getName()))
            {
                return true;
            }
        }

        return false;
    }

    public static void loadConfig() throws IOException
    {
        cfgdir.mkdir();

        if (!cfgfile.exists() && !cfgfile.createNewFile())
        {
            return;
        }

        if (cfgfile.canRead())
        {
            FileInputStream fileinputstream = new FileInputStream(cfgfile);
            props.load(fileinputstream);
            fileinputstream.close();
        }
    }

    public static java.awt.image.BufferedImage loadImage(RenderEngine renderengine, String s) throws Exception
    {
        TexturePackList texturepacklist = (TexturePackList)getPrivateValue(net.minecraft.src.RenderEngine.class, renderengine, 10);
        InputStream inputstream = texturepacklist.func_77292_e().getResourceAsStream(s);

        if (inputstream == null)
        {
            throw new Exception((new StringBuilder("Image not found: ")).append(s).toString());
        }

        java.awt.image.BufferedImage bufferedimage = ImageIO.read(inputstream);

        if (bufferedimage == null)
        {
            throw new Exception((new StringBuilder("Image corrupted: ")).append(s).toString());
        }
        else
        {
            return bufferedimage;
        }
    }

    public static void onItemPickup(EntityPlayer entityplayer, ItemStack itemstack)
    {
        BaseMod basemod;

        for (Iterator iterator = modList.iterator(); iterator.hasNext(); basemod.onItemPickup(entityplayer, itemstack))
        {
            basemod = (BaseMod)iterator.next();
        }
    }

    public static void onTick(float f, Minecraft minecraft)
    {
        minecraft.mcProfiler.endSection();
        minecraft.mcProfiler.endSection();
        minecraft.mcProfiler.startSection("modtick");

        if (!hasInit)
        {
            init();
            logger.fine("Initialized");
        }

        if (texPack == null || minecraft.gameSettings.skin != texPack)
        {
            texturesAdded = false;
            texPack = minecraft.gameSettings.skin;
        }

        if (langPack == null || StringTranslate.getInstance().getCurrentLanguage() != langPack)
        {
            Properties properties = null;

            try
            {
                properties = (Properties)getPrivateValue(net.minecraft.src.StringTranslate.class, StringTranslate.getInstance(), 1);
            }
            catch (SecurityException securityexception)
            {
                logger.throwing("ModLoader", "AddLocalization", securityexception);
                throwException(securityexception);
            }
            catch (NoSuchFieldException nosuchfieldexception)
            {
                logger.throwing("ModLoader", "AddLocalization", nosuchfieldexception);
                throwException(nosuchfieldexception);
            }

            langPack = StringTranslate.getInstance().getCurrentLanguage();

            if (properties != null)
            {
                if (localizedStrings.containsKey("en_US"))
                {
                    properties.putAll((Map)localizedStrings.get("en_US"));
                }

                if (!langPack.contentEquals("en_US") && localizedStrings.containsKey(langPack))
                {
                    properties.putAll((Map)localizedStrings.get(langPack));
                }
            }
        }

        if (!texturesAdded && minecraft.renderEngine != null)
        {
            registerAllTextureOverrides(minecraft.renderEngine);
            texturesAdded = true;
        }

        long l = 0L;

        if (minecraft.thePlayer != null && minecraft.thePlayer.worldObj != null)
        {
            l = minecraft.thePlayer.worldObj.getWorldTime();
            Iterator iterator = inGameHooks.entrySet().iterator();

            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }

                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();

                if ((clock != l || !((Boolean)entry.getValue()).booleanValue()) && !((BaseMod)entry.getKey()).onTickInGame(f, minecraft))
                {
                    iterator.remove();
                }
            }
            while (true);
        }

        if (minecraft.currentScreen != null)
        {
            Iterator iterator1 = inGUIHooks.entrySet().iterator();

            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }

                java.util.Map.Entry entry1 = (java.util.Map.Entry)iterator1.next();

                if ((clock != l || !(((Boolean)entry1.getValue()).booleanValue() & (minecraft.renderViewEntity.worldObj != null))) && !((BaseMod)entry1.getKey()).onTickInGUI(f, minecraft, minecraft.currentScreen))
                {
                    iterator1.remove();
                }
            }
            while (true);
        }

        if (clock != l)
        {
            for (Iterator iterator2 = keyList.entrySet().iterator(); iterator2.hasNext();)
            {
                java.util.Map.Entry entry2 = (java.util.Map.Entry)iterator2.next();
                Iterator iterator3 = ((Map)entry2.getValue()).entrySet().iterator();

                while (iterator3.hasNext())
                {
                    java.util.Map.Entry entry3 = (java.util.Map.Entry)iterator3.next();
                    int i = ((KeyBinding)entry3.getKey()).keyCode;
                    boolean flag;

                    if (i < 0)
                    {
                        flag = Mouse.isButtonDown(i += 100);
                    }
                    else
                    {
                        flag = Keyboard.isKeyDown(i);
                    }

                    boolean aflag[] = (boolean[])entry3.getValue();
                    boolean flag1 = aflag[1];
                    aflag[1] = flag;

                    if (flag && (!flag1 || aflag[0]))
                    {
                        ((BaseMod)entry2.getKey()).keyboardEvent((KeyBinding)entry3.getKey());
                    }
                }
            }
        }

        clock = l;
        minecraft.mcProfiler.endSection();
        minecraft.mcProfiler.startSection("render");
        minecraft.mcProfiler.startSection("gameRenderer");
    }

    public static void openGUI(EntityPlayer entityplayer, GuiScreen guiscreen)
    {
        if (!hasInit)
        {
            init();
            logger.fine("Initialized");
        }

        Minecraft minecraft = getMinecraftInstance();

        if (minecraft.thePlayer != entityplayer)
        {
            return;
        }

        if (guiscreen != null)
        {
            minecraft.displayGuiScreen(guiscreen);
        }
    }

    public static void populateChunk(IChunkProvider ichunkprovider, int i, int j, World world)
    {
        if (!hasInit)
        {
            init();
            logger.fine("Initialized");
        }

        Random random = new Random(world.getSeed());
        long l = (random.nextLong() / 2L) * 2L + 1L;
        long l1 = (random.nextLong() / 2L) * 2L + 1L;
        random.setSeed((long)i * l + (long)j * l1 ^ world.getSeed());
        Iterator iterator = modList.iterator();

        do
        {
            if (!iterator.hasNext())
            {
                break;
            }

            BaseMod basemod = (BaseMod)iterator.next();

            if (world.provider.isSurfaceWorld())
            	
            {
            	//increase the distance between buildings:32blocks
            	 if(i%2==0&&j%2==0){
                 basemod.generateBuildings(world, random, i<<4, j<<4, getBuildings());
            	 }

            }
            else if (world.provider.isHellWorld)
            {
                basemod.generateNether(world, random, i << 4, j << 4);
            }
        }
        while (true);
    }
    
    public static List<Building> getBuildings(){
    	return Buildings;
    }

    private static void readFromClassPath(File file) throws FileNotFoundException, IOException
    {
        logger.finer((new StringBuilder("Adding mods from ")).append(file.getCanonicalPath()).toString());
        ClassLoader classloader = (net.minecraft.src.ModLoader.class).getClassLoader();

        if (file.isFile() && (file.getName().endsWith(".jar") || file.getName().endsWith(".zip")))
        {
            logger.finer("Zip found.");
            FileInputStream fileinputstream = new FileInputStream(file);
            ZipInputStream zipinputstream = new ZipInputStream(fileinputstream);
            Object obj = null;

            do
            {
                ZipEntry zipentry = zipinputstream.getNextEntry();

                if (zipentry == null)
                {
                    break;
                }

                String s2 = zipentry.getName();

                if (!zipentry.isDirectory() && s2.startsWith("mod_") && s2.endsWith(".class"))
                {
                    addMod(classloader, s2);
                }
            }
            while (true);

            fileinputstream.close();
        }
        else if (file.isDirectory())
        {
            Package package1 = (net.minecraft.src.ModLoader.class).getPackage();

            if (package1 != null)
            {
                String s = package1.getName().replace('.', File.separatorChar);
                file = new File(file, s);
            }

            logger.finer("Directory found.");
            File afile[] = file.listFiles();

            if (afile != null)
            {
                for (int i = 0; i < afile.length; i++)
                {
                    String s1 = afile[i].getName();

                    if (afile[i].isFile() && s1.startsWith("mod_") && s1.endsWith(".class"))
                    {
                        addMod(classloader, s1);
                    }
                }
            }
        }
    }

    private static void readFromModFolder(File file) throws IOException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException
    {
        ClassLoader classloader = (net.minecraft.client.Minecraft.class).getClassLoader();
        Method method = (java.net.URLClassLoader.class).getDeclaredMethod("addURL", new Class[]
                {
                    java.net.URL.class
                });
        method.setAccessible(true);

        if (!file.isDirectory())
        {
            throw new IllegalArgumentException("folder must be a Directory.");
        }

        File afile[] = file.listFiles();
        Arrays.sort(afile);

        if (classloader instanceof URLClassLoader)
        {
            for (int i = 0; i < afile.length; i++)
            {
                File file1 = afile[i];

                if (file1.isDirectory() || file1.isFile() && (file1.getName().endsWith(".jar") || file1.getName().endsWith(".zip")))
                {
                    method.invoke(classloader, new Object[]
                            {
                                file1.toURI().toURL()
                            });
                }
            }
        }

        for (int j = 0; j < afile.length; j++)
        {
            File file2 = afile[j];

            if (!file2.isDirectory() && (!file2.isFile() || !file2.getName().endsWith(".jar") && !file2.getName().endsWith(".zip")))
            {
                continue;
            }

            logger.finer((new StringBuilder("Adding mods from ")).append(file2.getCanonicalPath()).toString());

            if (file2.isFile())
            {
                logger.finer("Zip found.");
                FileInputStream fileinputstream = new FileInputStream(file2);
                ZipInputStream zipinputstream = new ZipInputStream(fileinputstream);
                Object obj = null;

                do
                {
                    ZipEntry zipentry = zipinputstream.getNextEntry();

                    if (zipentry == null)
                    {
                        break;
                    }

                    String s2 = zipentry.getName();

                    if (!zipentry.isDirectory() && s2.startsWith("mod_") && s2.endsWith(".class"))
                    {
                        addMod(classloader, s2);
                    }
                }
                while (true);

                zipinputstream.close();
                fileinputstream.close();
                continue;
            }

            if (!file2.isDirectory())
            {
                continue;
            }

            Package package1 = (net.minecraft.src.ModLoader.class).getPackage();

            if (package1 != null)
            {
                String s = package1.getName().replace('.', File.separatorChar);
                file2 = new File(file2, s);
            }

            logger.finer("Directory found.");
            File afile1[] = file2.listFiles();

            if (afile1 == null)
            {
                continue;
            }

            for (int k = 0; k < afile1.length; k++)
            {
                String s1 = afile1[k].getName();

                if (afile1[k].isFile() && s1.startsWith("mod_") && s1.endsWith(".class"))
                {
                    addMod(classloader, s1);
                }
            }
        }
    }

    public static void clientCustomPayload(Packet250CustomPayload packet250custompayload)
    {
        if (packet250custompayload.channel.equals("ML|OpenTE"))
        {
            try
            {
                DataInputStream datainputstream = new DataInputStream(new ByteArrayInputStream(packet250custompayload.data));
                int i = datainputstream.read();
                int j = datainputstream.readInt();
                int k = datainputstream.readInt();
                int l = datainputstream.readInt();
                int i1 = datainputstream.readInt();
                int j1 = datainputstream.read();
                EntityClientPlayerMP entityclientplayermp = instance.thePlayer;

                if (entityclientplayermp.dimension != j1)
                {
                    return;
                }

                if (containerGUIs.containsKey(Integer.valueOf(j)))
                {
                    BaseMod basemod1 = (BaseMod)containerGUIs.get(Integer.valueOf(j));

                    if (basemod1 != null)
                    {
                        GuiContainer guicontainer = basemod1.getContainerGUI(entityclientplayermp, j, k, l, i1);

                        if (guicontainer == null)
                        {
                            return;
                        }

                        instance.displayGuiScreen(guicontainer);
                        entityclientplayermp.craftingInventory.windowId = i;
                    }
                }
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
            }
        }
        else if (packetChannels.containsKey(packet250custompayload.channel))
        {
            BaseMod basemod = (BaseMod)packetChannels.get(packet250custompayload.channel);

            if (basemod != null)
            {
                basemod.clientCustomPayload(clientHandler, packet250custompayload);
            }
        }
    }

    public static void serverCustomPayload(NetServerHandler netserverhandler, Packet250CustomPayload packet250custompayload)
    {
        if (packetChannels.containsKey(packet250custompayload.channel))
        {
            BaseMod basemod = (BaseMod)packetChannels.get(packet250custompayload.channel);

            if (basemod != null)
            {
                basemod.serverCustomPayload(netserverhandler, packet250custompayload);
            }
        }
    }

    public static void registerContainerID(BaseMod basemod, int i)
    {
        containerGUIs.put(Integer.valueOf(i), basemod);
    }

    public static void clientOpenWindow(Packet100OpenWindow packet100openwindow)
    {
    }

    public static void serverOpenWindow(EntityPlayerMP entityplayermp, Container container, int i, int j, int k, int l)
    {
        try
        {
            Field field = (net.minecraft.src.EntityPlayerMP.class).getDeclaredFields()[17];
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
            dataoutputstream.write(entityplayermp.dimension);
            entityplayermp.serverForThisPlayer.sendPacketToPlayer(new Packet250CustomPayload("ML|OpenTE", bytearrayoutputstream.toByteArray()));
            entityplayermp.craftingInventory = container;
            entityplayermp.craftingInventory.windowId = i1;
            entityplayermp.craftingInventory.addCraftingToCrafters(entityplayermp);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public static KeyBinding[] registerAllKeys(KeyBinding akeybinding[])
    {
        LinkedList linkedlist = new LinkedList();
        linkedlist.addAll(Arrays.asList(akeybinding));
        Map map;

        for (Iterator iterator = keyList.values().iterator(); iterator.hasNext(); linkedlist.addAll(map.keySet()))
        {
            map = (Map)iterator.next();
        }

        return (KeyBinding[])linkedlist.toArray(new KeyBinding[0]);
    }

    public static void registerAllTextureOverrides(RenderEngine renderengine)
    {
        animList.clear();
        Minecraft minecraft = getMinecraftInstance();
        BaseMod basemod;

        for (Iterator iterator = modList.iterator(); iterator.hasNext(); basemod.registerAnimation(minecraft))
        {
            basemod = (BaseMod)iterator.next();
        }

        TextureFX texturefx;

        for (Iterator iterator1 = animList.iterator(); iterator1.hasNext(); renderengine.registerTextureFX(texturefx))
        {
            texturefx = (TextureFX)iterator1.next();
        }

        for (Iterator iterator2 = overrides.entrySet().iterator(); iterator2.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator2.next();
            Iterator iterator3 = ((Map)entry.getValue()).entrySet().iterator();

            while (iterator3.hasNext())
            {
                java.util.Map.Entry entry1 = (java.util.Map.Entry)iterator3.next();
                String s = (String)entry1.getKey();
                int i = ((Integer)entry1.getValue()).intValue();
                int j = ((Integer)entry.getKey()).intValue();

                try
                {
                    java.awt.image.BufferedImage bufferedimage = loadImage(renderengine, s);
                    ModTextureStatic modtexturestatic = new ModTextureStatic(i, j, bufferedimage);
                    renderengine.registerTextureFX(modtexturestatic);
                }
                catch (Exception exception)
                {
                    logger.throwing("ModLoader", "RegisterAllTextureOverrides", exception);
                    throwException(exception);
                    throw new RuntimeException(exception);
                }
            }
        }
    }

    public static void registerBlock(Block block)
    {
        registerBlock(block, null);
    }

    public static void registerBlock(Block block, Class class1)
    {
        try
        {
            if (block == null)
            {
                throw new IllegalArgumentException("block parameter cannot be null.");
            }

            int i = block.blockID;
            ItemBlock itemblock = null;

            if (class1 != null)
            {
                itemblock = (ItemBlock)class1.getConstructor(new Class[]
                        {
                            Integer.TYPE
                        }).newInstance(new Object[]
                                {
                                    Integer.valueOf(i - 256)
                                });
            }
            else
            {
                itemblock = new ItemBlock(i - 256);
            }

            if (Block.blocksList[i] != null && Item.itemsList[i] == null)
            {
                Item.itemsList[i] = itemblock;
            }
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            logger.throwing("ModLoader", "RegisterBlock", illegalargumentexception);
            throwException(illegalargumentexception);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            logger.throwing("ModLoader", "RegisterBlock", illegalaccessexception);
            throwException(illegalaccessexception);
        }
        catch (SecurityException securityexception)
        {
            logger.throwing("ModLoader", "RegisterBlock", securityexception);
            throwException(securityexception);
        }
        catch (InstantiationException instantiationexception)
        {
            logger.throwing("ModLoader", "RegisterBlock", instantiationexception);
            throwException(instantiationexception);
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            logger.throwing("ModLoader", "RegisterBlock", invocationtargetexception);
            throwException(invocationtargetexception);
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            logger.throwing("ModLoader", "RegisterBlock", nosuchmethodexception);
            throwException(nosuchmethodexception);
        }
    }

    public static void registerEntityID(Class class1, String s, int i)
    {
        try
        {
            method_RegisterEntityID.invoke(null, new Object[]
                    {
                        class1, s, Integer.valueOf(i)
                    });
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            logger.throwing("ModLoader", "RegisterEntityID", illegalargumentexception);
            throwException(illegalargumentexception);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            logger.throwing("ModLoader", "RegisterEntityID", illegalaccessexception);
            throwException(illegalaccessexception);
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            logger.throwing("ModLoader", "RegisterEntityID", invocationtargetexception);
            throwException(invocationtargetexception);
        }
    }

    public static void registerEntityID(Class class1, String s, int i, int j, int k)
    {
        registerEntityID(class1, s, i);
        EntityList.entityEggs.put(Integer.valueOf(i), new EntityEggInfo(i, j, k));
    }

    public static void registerKey(BaseMod basemod, KeyBinding keybinding, boolean flag)
    {
        Object obj = (Map)keyList.get(basemod);

        if (obj == null)
        {
            obj = new HashMap();
        }

        boolean aflag[] = new boolean[2];
        aflag[0] = flag;
        ((Map)(obj)).put(keybinding, aflag);
        keyList.put(basemod, obj);
    }

    public static void registerPacketChannel(BaseMod basemod, String s)
    {
        if (s.length() < 16)
        {
            packetChannels.put(s, basemod);
        }
        else
        {
            throw new RuntimeException(String.format("Invalid channel name: %s. Must be less than 16 characters.", new Object[]
                    {
                        s
                    }));
        }
    }

    public static void registerTileEntity(Class class1, String s)
    {
        registerTileEntity(class1, s, null);
    }

    public static void registerTileEntity(Class class1, String s, TileEntitySpecialRenderer tileentityspecialrenderer)
    {
        try
        {
            method_RegisterTileEntity.invoke(null, new Object[]
                    {
                        class1, s
                    });

            if (tileentityspecialrenderer != null)
            {
                TileEntityRenderer tileentityrenderer = TileEntityRenderer.instance;
                Map map = (Map)field_TileEntityRenderers.get(tileentityrenderer);
                map.put(class1, tileentityspecialrenderer);
                tileentityspecialrenderer.setTileEntityRenderer(tileentityrenderer);
            }
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            logger.throwing("ModLoader", "RegisterTileEntity", illegalargumentexception);
            throwException(illegalargumentexception);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            logger.throwing("ModLoader", "RegisterTileEntity", illegalaccessexception);
            throwException(illegalaccessexception);
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            logger.throwing("ModLoader", "RegisterTileEntity", invocationtargetexception);
            throwException(invocationtargetexception);
        }
    }

    public static void removeBiome(BiomeGenBase biomegenbase)
    {
        BiomeGenBase abiomegenbase[] = GenLayerBiome.biomeArray;
        List list = Arrays.asList(abiomegenbase);
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(list);

        if (arraylist.contains(biomegenbase))
        {
            arraylist.remove(biomegenbase);
        }

        GenLayerBiome.biomeArray = (BiomeGenBase[])arraylist.toArray(new BiomeGenBase[0]);
    }

    public static void removeSpawn(Class class1, EnumCreatureType enumcreaturetype)
    {
        removeSpawn(class1, enumcreaturetype, null);
    }

    public static void removeSpawn(Class class1, EnumCreatureType enumcreaturetype, BiomeGenBase abiomegenbase[])
    {
        if (class1 == null)
        {
            throw new IllegalArgumentException("entityClass cannot be null");
        }

        if (enumcreaturetype == null)
        {
            throw new IllegalArgumentException("spawnList cannot be null");
        }

        if (abiomegenbase == null)
        {
            abiomegenbase = standardBiomes;
        }

        label0:

        for (int i = 0; i < abiomegenbase.length; i++)
        {
            List list = abiomegenbase[i].getSpawnableList(enumcreaturetype);

            if (list == null)
            {
                continue;
            }

            Iterator iterator = list.iterator();

            do
            {
                SpawnListEntry spawnlistentry;

                do
                {
                    if (!iterator.hasNext())
                    {
                        continue label0;
                    }

                    spawnlistentry = (SpawnListEntry)iterator.next();
                }
                while (spawnlistentry.entityClass != class1);

                iterator.remove();
            }
            while (true);
        }
    }

    public static void removeSpawn(String s, EnumCreatureType enumcreaturetype)
    {
        removeSpawn(s, enumcreaturetype, null);
    }

    public static void removeSpawn(String s, EnumCreatureType enumcreaturetype, BiomeGenBase abiomegenbase[])
    {
        Class class1 = (Class)classMap.get(s);

        if (class1 != null && (net.minecraft.src.EntityLiving.class).isAssignableFrom(class1))
        {
            removeSpawn(class1, enumcreaturetype, abiomegenbase);
        }
    }

    public static boolean renderBlockIsItemFull3D(int i)
    {
        if (!blockSpecialInv.containsKey(Integer.valueOf(i)))
        {
            return i == 26;
        }
        else
        {
            return ((Boolean)blockSpecialInv.get(Integer.valueOf(i))).booleanValue();
        }
    }

    public static void renderInvBlock(RenderBlocks renderblocks, Block block, int i, int j)
    {
        BaseMod basemod = (BaseMod)blockModels.get(Integer.valueOf(j));

        if (basemod == null)
        {
            return;
        }
        else
        {
            basemod.renderInvBlock(renderblocks, block, i, j);
            return;
        }
    }

    public static boolean renderWorldBlock(RenderBlocks renderblocks, IBlockAccess iblockaccess, int i, int j, int k, Block block, int l)
    {
        BaseMod basemod = (BaseMod)blockModels.get(Integer.valueOf(l));

        if (basemod == null)
        {
            return false;
        }
        else
        {
            return basemod.renderWorldBlock(renderblocks, iblockaccess, i, j, k, block, l);
        }
    }

    public static void saveConfig() throws IOException
    {
        cfgdir.mkdir();

        if (!cfgfile.exists() && !cfgfile.createNewFile())
        {
            return;
        }

        if (cfgfile.canWrite())
        {
            FileOutputStream fileoutputstream = new FileOutputStream(cfgfile);
            props.store(fileoutputstream, "ModLoader Config");
            fileoutputstream.close();
        }
    }

    public static void clientChat(String s)
    {
        BaseMod basemod;

        for (Iterator iterator = modList.iterator(); iterator.hasNext(); basemod.clientChat(s))
        {
            basemod = (BaseMod)iterator.next();
        }
    }

    public static void serverChat(NetServerHandler netserverhandler, String s)
    {
        BaseMod basemod;

        for (Iterator iterator = modList.iterator(); iterator.hasNext(); basemod.serverChat(netserverhandler, s))
        {
            basemod = (BaseMod)iterator.next();
        }
    }

    public static void clientConnect(NetClientHandler netclienthandler, Packet1Login packet1login)
    {
        clientHandler = netclienthandler;

        if (packetChannels.size() > 0)
        {
            Packet250CustomPayload packet250custompayload = new Packet250CustomPayload();
            packet250custompayload.channel = "REGISTER";
            StringBuilder stringbuilder = new StringBuilder();
            Iterator iterator1 = packetChannels.keySet().iterator();
            stringbuilder.append((String)iterator1.next());

            for (; iterator1.hasNext(); stringbuilder.append((String)iterator1.next()))
            {
                stringbuilder.append("\0");
            }

            packet250custompayload.data = stringbuilder.toString().getBytes(Charset.forName("UTF8"));
            packet250custompayload.length = packet250custompayload.data.length;
            clientSendPacket(packet250custompayload);
        }

        BaseMod basemod;

        for (Iterator iterator = modList.iterator(); iterator.hasNext(); basemod.clientConnect(netclienthandler))
        {
            basemod = (BaseMod)iterator.next();
        }
    }

    public static void clientDisconnect()
    {
        BaseMod basemod;

        for (Iterator iterator = modList.iterator(); iterator.hasNext(); basemod.clientDisconnect(clientHandler))
        {
            basemod = (BaseMod)iterator.next();
        }

        clientHandler = null;
    }

    public static void clientSendPacket(Packet packet)
    {
        if (clientHandler != null)
        {
            clientHandler.addToSendQueue(packet);
        }
    }

    public static void serverSendPacket(NetServerHandler netserverhandler, Packet packet)
    {
        if (netserverhandler != null)
        {
            netserverhandler.sendPacketToPlayer(packet);
        }
    }

    public static void setInGameHook(BaseMod basemod, boolean flag, boolean flag1)
    {
        if (flag)
        {
            inGameHooks.put(basemod, Boolean.valueOf(flag1));
        }
        else
        {
            inGameHooks.remove(basemod);
        }
    }

    public static void setInGUIHook(BaseMod basemod, boolean flag, boolean flag1)
    {
        if (flag)
        {
            inGUIHooks.put(basemod, Boolean.valueOf(flag1));
        }
        else
        {
            inGUIHooks.remove(basemod);
        }
    }

    public static void setPrivateValue(Class class1, Object obj, int i, Object obj1) throws IllegalArgumentException, SecurityException, NoSuchFieldException
    {
        try
        {
            Field field = class1.getDeclaredFields()[i];
            field.setAccessible(true);
            int j = field_modifiers.getInt(field);

            if ((j & 0x10) != 0)
            {
                field_modifiers.setInt(field, j & 0xffffffef);
            }

            field.set(obj, obj1);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            logger.throwing("ModLoader", "setPrivateValue", illegalaccessexception);
            throwException("An impossible error has occured!", illegalaccessexception);
        }
    }

    public static void setPrivateValue(Class class1, Object obj, String s, Object obj1) throws IllegalArgumentException, SecurityException, NoSuchFieldException
    {
        try
        {
            Field field = class1.getDeclaredField(s);
            int i = field_modifiers.getInt(field);

            if ((i & 0x10) != 0)
            {
                field_modifiers.setInt(field, i & 0xffffffef);
            }

            field.setAccessible(true);
            field.set(obj, obj1);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            logger.throwing("ModLoader", "setPrivateValue", illegalaccessexception);
            throwException("An impossible error has occured!", illegalaccessexception);
        }
    }

    private static void setupProperties(Class class1) throws IllegalArgumentException, IllegalAccessException, IOException, SecurityException, NoSuchFieldException, NoSuchAlgorithmException, DigestException
    {
        LinkedList linkedlist = new LinkedList();
        Properties properties = new Properties();
        int i = 0;
        int j = 0;
        File file = new File(cfgdir, (new StringBuilder(String.valueOf(class1.getSimpleName()))).append(".cfg").toString());

        if (file.exists() && file.canRead())
        {
            properties.load(new FileInputStream(file));
        }

        if (properties.containsKey("checksum"))
        {
            j = Integer.parseInt(properties.getProperty("checksum"), 36);
        }

        Field afield[];
        int k = (afield = class1.getDeclaredFields()).length;

        for (int l = 0; l < k; l++)
        {
            Field field = afield[l];

            if ((field.getModifiers() & 8) != 0 && field.isAnnotationPresent(net.minecraft.src.MLProp.class))
            {
                linkedlist.add(field);
                Object obj = field.get(null);
                i += obj.hashCode();
            }
        }

        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = linkedlist.iterator();

        do
        {
            if (!iterator.hasNext())
            {
                break;
            }

            Field field1 = (Field)iterator.next();

            if ((field1.getModifiers() & 8) == 0 || !field1.isAnnotationPresent(net.minecraft.src.MLProp.class))
            {
                continue;
            }

            Class class2 = field1.getType();
            MLProp mlprop = (MLProp)field1.getAnnotation(net.minecraft.src.MLProp.class);
            String s = mlprop.name().length() == 0 ? field1.getName() : mlprop.name();
            Object obj1 = field1.get(null);
            StringBuilder stringbuilder1 = new StringBuilder();

            if (mlprop.min() != (-1.0D / 0.0D))
            {
                stringbuilder1.append(String.format(",>=%.1f", new Object[]
                        {
                            Double.valueOf(mlprop.min())
                        }));
            }

            if (mlprop.max() != (1.0D / 0.0D))
            {
                stringbuilder1.append(String.format(",<=%.1f", new Object[]
                        {
                            Double.valueOf(mlprop.max())
                        }));
            }

            StringBuilder stringbuilder2 = new StringBuilder();

            if (mlprop.info().length() > 0)
            {
                stringbuilder2.append(" -- ");
                stringbuilder2.append(mlprop.info());
            }

            stringbuilder.append(String.format("%s (%s:%s%s)%s\n", new Object[]
                    {
                        s, class2.getName(), obj1, stringbuilder1, stringbuilder2
                    }));

            if (j == i && properties.containsKey(s))
            {
                String s1 = properties.getProperty(s);
                Object obj2 = null;

                if (class2.isAssignableFrom(java.lang.String.class))
                {
                    obj2 = s1;
                }
                else if (class2.isAssignableFrom(Integer.TYPE))
                {
                    obj2 = Integer.valueOf(Integer.parseInt(s1));
                }
                else if (class2.isAssignableFrom(Short.TYPE))
                {
                    obj2 = Short.valueOf(Short.parseShort(s1));
                }
                else if (class2.isAssignableFrom(Byte.TYPE))
                {
                    obj2 = Byte.valueOf(Byte.parseByte(s1));
                }
                else if (class2.isAssignableFrom(Boolean.TYPE))
                {
                    obj2 = Boolean.valueOf(Boolean.parseBoolean(s1));
                }
                else if (class2.isAssignableFrom(Float.TYPE))
                {
                    obj2 = Float.valueOf(Float.parseFloat(s1));
                }
                else if (class2.isAssignableFrom(Double.TYPE))
                {
                    obj2 = Double.valueOf(Double.parseDouble(s1));
                }

                if (obj2 == null)
                {
                    continue;
                }

                if (obj2 instanceof Number)
                {
                    double d = ((Number)obj2).doubleValue();

                    if (mlprop.min() != (-1.0D / 0.0D) && d < mlprop.min() || mlprop.max() != (1.0D / 0.0D) && d > mlprop.max())
                    {
                        continue;
                    }
                }

                logger.finer((new StringBuilder(String.valueOf(s))).append(" set to ").append(obj2).toString());

                if (!obj2.equals(obj1))
                {
                    field1.set(null, obj2);
                }
            }
            else
            {
                logger.finer((new StringBuilder(String.valueOf(s))).append(" not in config, using default: ").append(obj1).toString());
                properties.setProperty(s, obj1.toString());
            }
        }
        while (true);

        properties.put("checksum", Integer.toString(i, 36));

        if (!properties.isEmpty() && (file.exists() || file.createNewFile()) && file.canWrite())
        {
            properties.store(new FileOutputStream(file), stringbuilder.toString());
        }
    }

    private static void sortModList() throws Exception
    {
        HashMap hashmap = new HashMap();
        BaseMod basemod;

        for (Iterator iterator = getLoadedMods().iterator(); iterator.hasNext(); hashmap.put(basemod.getClass().getSimpleName(), basemod))
        {
            basemod = (BaseMod)iterator.next();
        }

        LinkedList linkedlist = new LinkedList();
        label0:

        for (int i = 0; linkedlist.size() != modList.size() && i <= 10; i++)
        {
            Iterator iterator1 = modList.iterator();
            label1:

            do
            {
                if (!iterator1.hasNext())
                {
                    continue label0;
                }

                BaseMod basemod1 = (BaseMod)iterator1.next();

                if (linkedlist.contains(basemod1))
                {
                    continue;
                }

                String s = basemod1.getPriorities();

                if (s == null || s.length() == 0 || s.indexOf(':') == -1)
                {
                    linkedlist.add(basemod1);
                    continue;
                }

                if (i <= 0)
                {
                    continue;
                }

                int j = -1;
                int k = 0x80000000;
                int l = 0x7fffffff;
                String as[];

                if (s.indexOf(';') > 0)
                {
                    as = s.split(";");
                }
                else
                {
                    as = (new String[]
                            {
                                s
                            });
                }

                for (int i1 = 0; i1 < as.length; i1++)
                {
                    String s1 = as[i1];

                    if (s1.indexOf(':') == -1)
                    {
                        continue;
                    }

                    String as1[] = s1.split(":");
                    String s2 = as1[0];
                    String s3 = as1[1];

                    if (!s2.contentEquals("required-before") && !s2.contentEquals("before") && !s2.contentEquals("after") && !s2.contentEquals("required-after"))
                    {
                        continue;
                    }

                    if (s3.contentEquals("*"))
                    {
                        if (s2.contentEquals("required-before") || s2.contentEquals("before"))
                        {
                            j = 0;
                            break;
                        }

                        if (s2.contentEquals("required-after") || s2.contentEquals("after"))
                        {
                            j = linkedlist.size();
                        }

                        break;
                    }

                    if ((s2.contentEquals("required-before") || s2.contentEquals("required-after")) && !hashmap.containsKey(s3))
                    {
                        throw new Exception(String.format("%s is missing dependency: %s", new Object[]
                                {
                                    basemod1, s3
                                }));
                    }

                    BaseMod basemod2 = (BaseMod)hashmap.get(s3);

                    if (!linkedlist.contains(basemod2))
                    {
                        continue label1;
                    }

                    int j1 = linkedlist.indexOf(basemod2);

                    if (s2.contentEquals("required-before") || s2.contentEquals("before"))
                    {
                        j = j1;

                        if (j < l)
                        {
                            l = j;
                        }
                        else
                        {
                            j = l;
                        }

                        continue;
                    }

                    if (!s2.contentEquals("required-after") && !s2.contentEquals("after"))
                    {
                        continue;
                    }

                    j = j1 + 1;

                    if (j > k)
                    {
                        k = j;
                    }
                    else
                    {
                        j = k;
                    }
                }

                if (j != -1)
                {
                    linkedlist.add(j, basemod1);
                }
            }
            while (true);
        }

        modList.clear();
        modList.addAll(linkedlist);
    }

    public static void takenFromCrafting(EntityPlayer entityplayer, ItemStack itemstack, IInventory iinventory)
    {
        BaseMod basemod;

        for (Iterator iterator = modList.iterator(); iterator.hasNext(); basemod.takenFromCrafting(entityplayer, itemstack, iinventory))
        {
            basemod = (BaseMod)iterator.next();
        }
    }

    public static void takenFromFurnace(EntityPlayer entityplayer, ItemStack itemstack)
    {
        BaseMod basemod;

        for (Iterator iterator = modList.iterator(); iterator.hasNext(); basemod.takenFromFurnace(entityplayer, itemstack))
        {
            basemod = (BaseMod)iterator.next();
        }
    }

    public static void throwException(String s, Throwable throwable)
    {
        Minecraft minecraft = getMinecraftInstance();

        if (minecraft != null)
        {
            minecraft.displayCrashReport(new CrashReport(s, throwable));
        }
        else
        {
            throw new RuntimeException(throwable);
        }
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
        stringbuilder.append("ModLoader 1.3.1");
        stringbuilder.append('\n');

        for (Iterator iterator = getLoadedMods().iterator(); iterator.hasNext(); stringbuilder.append('\n'))
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

    static
    {
        cfgdir = new File(Minecraft.getMinecraftDir(), "/config/");
        cfgfile = new File(cfgdir, "ModLoader.cfg");
        cfgLoggingLevel = Level.FINER;
    }
}
