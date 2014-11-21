package net.minecraft.src;

import java.io.PrintStream;
import java.util.*;
import net.minecraft.server.MinecraftServer;

public class WorldServer extends World
{
    private final MinecraftServer mcServer;
    private final EntityTracker field_73062_L;
    private final PlayerManager field_73063_M;
    private Set field_73064_N;

    /** All work to do in future ticks. */
    private TreeSet pendingTickListEntries;
    public ChunkProviderServer theChunkProviderServer;

    /** Set to true when an op is building or this dimension != 0 */
    public boolean disableSpawnProtection;

    /** Whether or not level saving is enabled */
    public boolean levelSaving;
    private boolean field_73068_P;
    private ServerBlockEventList blockEventCache[] =
    {
        new ServerBlockEventList(null), new ServerBlockEventList(null)
    };

    /**
     * The index into the blockEventCache; either 0, or 1, toggled in sendBlockEventPackets  where all BlockEvent are
     * applied locally and send to clients.
     */
    private int blockEventCacheIndex;
    private static final WeightedRandomChestContent bonusChestContent[];

    /** An IntHashMap of entity IDs (integers) to their Entity objects. */
    private IntHashMap entityIdMap;

    public WorldServer(MinecraftServer par1MinecraftServer, ISaveHandler par2ISaveHandler, String par3Str, int par4, WorldSettings par5WorldSettings, Profiler par6Profiler)
    {
        super(par2ISaveHandler, par3Str, par5WorldSettings, WorldProvider.getProviderForDimension(par4), par6Profiler);
        disableSpawnProtection = false;
        blockEventCacheIndex = 0;
        mcServer = par1MinecraftServer;
        field_73062_L = new EntityTracker(this);
        field_73063_M = new PlayerManager(this, par1MinecraftServer.func_71203_ab().getViewDistance());

        if (entityIdMap == null)
        {
            entityIdMap = new IntHashMap();
        }

        if (field_73064_N == null)
        {
            field_73064_N = new HashSet();
        }

        if (pendingTickListEntries == null)
        {
            pendingTickListEntries = new TreeSet();
        }
    }

    /**
     * Runs a single tick for the world
     */
    public void tick()
    {
        super.tick();

        if (getWorldInfo().isHardcoreModeEnabled() && difficultySetting < 3)
        {
            difficultySetting = 3;
        }

        provider.worldChunkMgr.cleanupCache();

        if (func_73056_e())
        {
            boolean flag = false;

            if (spawnHostileMobs)
            {
                if (difficultySetting < 1);
            }

            if (!flag)
            {
                long l = worldInfo.getWorldTime() + 24000L;
                worldInfo.setWorldTime(l - l % 24000L);
                func_73053_d();
            }
        }

        theProfiler.startSection("mobSpawner");
        SpawnerAnimals.func_77192_a(this, spawnHostileMobs, spawnPeacefulMobs && worldInfo.getWorldTime() % 400L == 0L);
        theProfiler.endStartSection("chunkSource");
        chunkProvider.unload100OldestChunks();
        int i = calculateSkylightSubtracted(1.0F);

        if (i != skylightSubtracted)
        {
            skylightSubtracted = i;
        }

        sendAndApplyBlockEvents();
        worldInfo.setWorldTime(worldInfo.getWorldTime() + 1L);
        theProfiler.endStartSection("tickPending");
        tickUpdates(false);
        theProfiler.endStartSection("tickTiles");
        tickBlocksAndAmbiance();
        theProfiler.endStartSection("chunkMap");
        field_73063_M.updatePlayerInstances();
        theProfiler.endStartSection("village");
        villageCollectionObj.tick();
        villageSiegeObj.tick();
        theProfiler.endSection();
        sendAndApplyBlockEvents();
    }

    public SpawnListEntry func_73057_a(EnumCreatureType par1EnumCreatureType, int par2, int par3, int par4)
    {
        List list = getChunkProvider().getPossibleCreatures(par1EnumCreatureType, par2, par3, par4);

        if (list == null || list.isEmpty())
        {
            return null;
        }
        else
        {
            return (SpawnListEntry)WeightedRandom.getRandomItem(rand, list);
        }
    }

    /**
     * Updates the flag that indicates whether or not all players in the world are sleeping.
     */
    public void updateAllPlayersSleepingFlag()
    {
        field_73068_P = !playerEntities.isEmpty();
        Iterator iterator = playerEntities.iterator();

        do
        {
            if (!iterator.hasNext())
            {
                break;
            }

            EntityPlayer entityplayer = (EntityPlayer)iterator.next();

            if (entityplayer.isPlayerSleeping())
            {
                continue;
            }

            field_73068_P = false;
            break;
        }
        while (true);
    }

    protected void func_73053_d()
    {
        field_73068_P = false;
        Iterator iterator = playerEntities.iterator();

        do
        {
            if (!iterator.hasNext())
            {
                break;
            }

            EntityPlayer entityplayer = (EntityPlayer)iterator.next();

            if (entityplayer.isPlayerSleeping())
            {
                entityplayer.wakeUpPlayer(false, false, true);
            }
        }
        while (true);

        func_73051_P();
    }

    private void func_73051_P()
    {
        worldInfo.setRainTime(0);
        worldInfo.setRaining(false);
        worldInfo.setThunderTime(0);
        worldInfo.setThundering(false);
    }

    public boolean func_73056_e()
    {
        if (field_73068_P && !isRemote)
        {
            for (Iterator iterator = playerEntities.iterator(); iterator.hasNext();)
            {
                EntityPlayer entityplayer = (EntityPlayer)iterator.next();

                if (!entityplayer.isPlayerFullyAsleep())
                {
                    return false;
                }
            }

            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * plays random cave ambient sounds and runs updateTick on random blocks within each chunk in the vacinity of a
     * player
     */
    protected void tickBlocksAndAmbiance()
    {
        super.tickBlocksAndAmbiance();
        int i = 0;
        int j = 0;

        for (Iterator iterator = activeChunkSet.iterator(); iterator.hasNext(); theProfiler.endSection())
        {
            ChunkCoordIntPair chunkcoordintpair = (ChunkCoordIntPair)iterator.next();
            int k = chunkcoordintpair.chunkXPos * 16;
            int l = chunkcoordintpair.chunkZPos * 16;
            theProfiler.startSection("getChunk");
            Chunk chunk = getChunkFromChunkCoords(chunkcoordintpair.chunkXPos, chunkcoordintpair.chunkZPos);
            func_72941_a(k, l, chunk);
            theProfiler.endStartSection("tickChunk");
            chunk.updateSkylight();
            theProfiler.endStartSection("thunder");

            if (rand.nextInt(0x186a0) == 0 && isRaining() && isThundering())
            {
                updateLCG = updateLCG * 3 + 0x3c6ef35f;
                int i1 = updateLCG >> 2;
                int k1 = k + (i1 & 0xf);
                int j2 = l + (i1 >> 8 & 0xf);
                int i3 = getPrecipitationHeight(k1, j2);

                if (canLightningStrikeAt(k1, i3, j2))
                {
                    addWeatherEffect(new EntityLightningBolt(this, k1, i3, j2));
                    lastLightningBolt = 2;
                }
            }

            theProfiler.endStartSection("iceandsnow");

            if (rand.nextInt(16) == 0)
            {
                updateLCG = updateLCG * 3 + 0x3c6ef35f;
                int j1 = updateLCG >> 2;
                int l1 = j1 & 0xf;
                int k2 = j1 >> 8 & 0xf;
                int j3 = getPrecipitationHeight(l1 + k, k2 + l);

                if (isBlockFreezableNaturally(l1 + k, j3 - 1, k2 + l))
                {
                    setBlockWithNotify(l1 + k, j3 - 1, k2 + l, Block.ice.blockID);
                }

                if (isRaining() && canSnowAt(l1 + k, j3, k2 + l))
                {
                    setBlockWithNotify(l1 + k, j3, k2 + l, Block.snow.blockID);
                }

                if (isRaining())
                {
                    BiomeGenBase biomegenbase = getBiomeGenForCoords(l1 + k, k2 + l);

                    if (biomegenbase.canSpawnLightningBolt())
                    {
                        int l3 = getBlockId(l1 + k, j3 - 1, k2 + l);

                        if (l3 != 0)
                        {
                            Block.blocksList[l3].func_71892_f(this, l1 + k, j3 - 1, k2 + l);
                        }
                    }
                }
            }

            theProfiler.endStartSection("tickTiles");
            ExtendedBlockStorage aextendedblockstorage[] = chunk.getBlockStorageArray();
            int i2 = aextendedblockstorage.length;

            for (int l2 = 0; l2 < i2; l2++)
            {
                ExtendedBlockStorage extendedblockstorage = aextendedblockstorage[l2];

                if (extendedblockstorage == null || !extendedblockstorage.getNeedsRandomTick())
                {
                    continue;
                }

                for (int k3 = 0; k3 < 3; k3++)
                {
                    updateLCG = updateLCG * 3 + 0x3c6ef35f;
                    int i4 = updateLCG >> 2;
                    int j4 = i4 & 0xf;
                    int k4 = i4 >> 8 & 0xf;
                    int l4 = i4 >> 16 & 0xf;
                    int i5 = extendedblockstorage.getExtBlockID(j4, l4, k4);
                    j++;
                    Block block = Block.blocksList[i5];

                    if (block != null && block.getTickRandomly())
                    {
                        i++;
                        block.updateTick(this, j4 + k, l4 + extendedblockstorage.getYLocation(), k4 + l, rand);
                    }
                }
            }
        }
    }

    /**
     * Used to schedule a call to the updateTick method on the specified block.
     */
    public void scheduleBlockUpdate(int par1, int par2, int par3, int par4, int par5)
    {
        NextTickListEntry nextticklistentry = new NextTickListEntry(par1, par2, par3, par4);
        byte byte0 = 8;

        if (scheduledUpdatesAreImmediate)
        {
            if (checkChunksExist(nextticklistentry.xCoord - byte0, nextticklistentry.yCoord - byte0, nextticklistentry.zCoord - byte0, nextticklistentry.xCoord + byte0, nextticklistentry.yCoord + byte0, nextticklistentry.zCoord + byte0))
            {
                int i = getBlockId(nextticklistentry.xCoord, nextticklistentry.yCoord, nextticklistentry.zCoord);

                if (i == nextticklistentry.blockID && i > 0)
                {
                    Block.blocksList[i].updateTick(this, nextticklistentry.xCoord, nextticklistentry.yCoord, nextticklistentry.zCoord, rand);
                }
            }

            return;
        }

        if (checkChunksExist(par1 - byte0, par2 - byte0, par3 - byte0, par1 + byte0, par2 + byte0, par3 + byte0))
        {
            if (par4 > 0)
            {
                nextticklistentry.setScheduledTime((long)par5 + worldInfo.getWorldTime());
            }

            if (!field_73064_N.contains(nextticklistentry))
            {
                field_73064_N.add(nextticklistentry);
                pendingTickListEntries.add(nextticklistentry);
            }
        }
    }

    /**
     * Schedules a block update from the saved information in a chunk. Called when the chunk is loaded.
     */
    public void scheduleBlockUpdateFromLoad(int par1, int par2, int par3, int par4, int par5)
    {
        NextTickListEntry nextticklistentry = new NextTickListEntry(par1, par2, par3, par4);

        if (par4 > 0)
        {
            nextticklistentry.setScheduledTime((long)par5 + worldInfo.getWorldTime());
        }

        if (!field_73064_N.contains(nextticklistentry))
        {
            field_73064_N.add(nextticklistentry);
            pendingTickListEntries.add(nextticklistentry);
        }
    }

    /**
     * Runs through the list of updates to run and ticks them
     */
    public boolean tickUpdates(boolean par1)
    {
        int i = pendingTickListEntries.size();

        if (i != field_73064_N.size())
        {
            throw new IllegalStateException("TickNextTick list out of synch");
        }

        if (i > 1000)
        {
            i = 1000;
        }

        for (int j = 0; j < i; j++)
        {
            NextTickListEntry nextticklistentry = (NextTickListEntry)pendingTickListEntries.first();

            if (!par1 && nextticklistentry.scheduledTime > worldInfo.getWorldTime())
            {
                break;
            }

            pendingTickListEntries.remove(nextticklistentry);
            field_73064_N.remove(nextticklistentry);
            byte byte0 = 8;

            if (!checkChunksExist(nextticklistentry.xCoord - byte0, nextticklistentry.yCoord - byte0, nextticklistentry.zCoord - byte0, nextticklistentry.xCoord + byte0, nextticklistentry.yCoord + byte0, nextticklistentry.zCoord + byte0))
            {
                continue;
            }

            int k = getBlockId(nextticklistentry.xCoord, nextticklistentry.yCoord, nextticklistentry.zCoord);

            if (k == nextticklistentry.blockID && k > 0)
            {
                Block.blocksList[k].updateTick(this, nextticklistentry.xCoord, nextticklistentry.yCoord, nextticklistentry.zCoord, rand);
            }
        }

        return !pendingTickListEntries.isEmpty();
    }

    public List getPendingBlockUpdates(Chunk par1Chunk, boolean par2)
    {
        ArrayList arraylist = null;
        ChunkCoordIntPair chunkcoordintpair = par1Chunk.getChunkCoordIntPair();
        int i = chunkcoordintpair.chunkXPos << 4;
        int j = i + 16;
        int k = chunkcoordintpair.chunkZPos << 4;
        int l = k + 16;
        Iterator iterator = pendingTickListEntries.iterator();

        do
        {
            if (!iterator.hasNext())
            {
                break;
            }

            NextTickListEntry nextticklistentry = (NextTickListEntry)iterator.next();

            if (nextticklistentry.xCoord >= i && nextticklistentry.xCoord < j && nextticklistentry.zCoord >= k && nextticklistentry.zCoord < l)
            {
                if (par2)
                {
                    field_73064_N.remove(nextticklistentry);
                    iterator.remove();
                }

                if (arraylist == null)
                {
                    arraylist = new ArrayList();
                }

                arraylist.add(nextticklistentry);
            }
        }
        while (true);

        return arraylist;
    }

    /**
     * Will update the entity in the world if the chunk the entity is in is currently loaded or its forced to update.
     * Args: entity, forceUpdate
     */
    public void updateEntityWithOptionalForce(Entity par1Entity, boolean par2)
    {
        if (!mcServer.func_71268_U() && ((par1Entity instanceof EntityAnimal) || (par1Entity instanceof EntityWaterMob)))
        {
            par1Entity.setDead();
        }

        if (!mcServer.func_71220_V() && (par1Entity instanceof INpc))
        {
            par1Entity.setDead();
        }

        if (!(par1Entity.riddenByEntity instanceof EntityPlayer))
        {
            super.updateEntityWithOptionalForce(par1Entity, par2);
        }
    }

    public void func_73050_b(Entity par1Entity, boolean par2)
    {
        super.updateEntityWithOptionalForce(par1Entity, par2);
    }

    /**
     * Creates the chunk provider for this world. Called in the constructor. Retrieves provider from worldProvider?
     */
    protected IChunkProvider createChunkProvider()
    {
        IChunkLoader ichunkloader = saveHandler.getChunkLoader(provider);
        theChunkProviderServer = new ChunkProviderServer(this, ichunkloader, provider.getChunkProvider());
        return theChunkProviderServer;
    }

    /**
     * get a list of tileEntity's
     */
    public List getTileEntityList(int par1, int par2, int par3, int par4, int par5, int par6)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = loadedTileEntityList.iterator();

        do
        {
            if (!iterator.hasNext())
            {
                break;
            }

            TileEntity tileentity = (TileEntity)iterator.next();

            if (tileentity.xCoord >= par1 && tileentity.yCoord >= par2 && tileentity.zCoord >= par3 && tileentity.xCoord < par4 && tileentity.yCoord < par5 && tileentity.zCoord < par6)
            {
                arraylist.add(tileentity);
            }
        }
        while (true);

        return arraylist;
    }

    /**
     * Called when checking if a certain block can be mined or not. The 'spawn safe zone' check is located here.
     */
    public boolean canMineBlock(EntityPlayer par1EntityPlayer, int par2, int par3, int par4)
    {
        int i = MathHelper.abs(par2 - worldInfo.getSpawnX());
        int j = MathHelper.abs(par4 - worldInfo.getSpawnZ());

        if (i > j)
        {
            j = i;
        }

        return j > 16 || mcServer.func_71203_ab().isOp(par1EntityPlayer.username) || mcServer.func_71264_H();
    }

    protected void initialize(WorldSettings par1WorldSettings)
    {
        if (entityIdMap == null)
        {
            entityIdMap = new IntHashMap();
        }

        if (field_73064_N == null)
        {
            field_73064_N = new HashSet();
        }

        if (pendingTickListEntries == null)
        {
            pendingTickListEntries = new TreeSet();
        }

        func_73052_b(par1WorldSettings);
        super.initialize(par1WorldSettings);
    }

    protected void func_73052_b(WorldSettings par1WorldSettings)
    {
        if (!provider.canRespawnHere())
        {
            worldInfo.setSpawnPosition(0, provider.getAverageGroundLevel(), 0);
            return;
        }

        findingSpawnPoint = true;
        WorldChunkManager worldchunkmanager = provider.worldChunkMgr;
        List list = worldchunkmanager.getBiomesToSpawnIn();
        Random random = new Random(getSeed());
        ChunkPosition chunkposition = worldchunkmanager.findBiomePosition(0, 0, 256, list, random);
        int i = 0;
        int j = provider.getAverageGroundLevel();
        int k = 0;

        if (chunkposition != null)
        {
            i = chunkposition.x;
            k = chunkposition.z;
        }
        else
        {
            System.out.println("Unable to find spawn biome");
        }

        int l = 0;

        do
        {
            if (provider.canCoordinateBeSpawn(i, k))
            {
                break;
            }

            i += random.nextInt(64) - random.nextInt(64);
            k += random.nextInt(64) - random.nextInt(64);
        }
        while (++l != 1000);

        worldInfo.setSpawnPosition(i, j, k);
        findingSpawnPoint = false;

        if (par1WorldSettings.isBonusChestEnabled())
        {
            createBonusChest();
        }
    }

    /**
     * Creates the bonus chest in the world.
     */
    protected void createBonusChest()
    {
        WorldGeneratorBonusChest worldgeneratorbonuschest = new WorldGeneratorBonusChest(bonusChestContent, 10);
        int i = 0;

        do
        {
            if (i >= 10)
            {
                break;
            }

            int j = (worldInfo.getSpawnX() + rand.nextInt(6)) - rand.nextInt(6);
            int k = (worldInfo.getSpawnZ() + rand.nextInt(6)) - rand.nextInt(6);
            int l = getTopSolidOrLiquidBlock(j, k) + 1;

            if (worldgeneratorbonuschest.generate(this, rand, j, l, k))
            {
                break;
            }

            i++;
        }
        while (true);
    }

    public ChunkCoordinates func_73054_j()
    {
        return provider.getEntrancePortalLocation();
    }

    /**
     * Saves all chunks to disk while updating progress bar.
     */
    public void saveAllChunks(boolean par1, IProgressUpdate par2IProgressUpdate) throws MinecraftException
    {
        if (!chunkProvider.canSave())
        {
            return;
        }

        if (par2IProgressUpdate != null)
        {
            par2IProgressUpdate.displaySavingString("Saving level");
        }

        saveLevel();

        if (par2IProgressUpdate != null)
        {
            par2IProgressUpdate.displayLoadingString("Saving chunks");
        }

        chunkProvider.saveChunks(par1, par2IProgressUpdate);
    }

    /**
     * Saves the chunks to disk.
     */
    protected void saveLevel() throws MinecraftException
    {
        checkSessionLock();
        saveHandler.saveWorldInfoWithPlayer(worldInfo, mcServer.func_71203_ab().func_72378_q());
        mapStorage.saveAllData();
    }

    /**
     * Start the skin for this entity downloading, if necessary, and increment its reference counter
     */
    protected void obtainEntitySkin(Entity par1Entity)
    {
        super.obtainEntitySkin(par1Entity);
        entityIdMap.addKey(par1Entity.entityId, par1Entity);
        Entity aentity[] = par1Entity.getParts();

        if (aentity != null)
        {
            Entity aentity1[] = aentity;
            int i = aentity1.length;

            for (int j = 0; j < i; j++)
            {
                Entity entity = aentity1[j];
                entityIdMap.addKey(entity.entityId, entity);
            }
        }
    }

    /**
     * Decrement the reference counter for this entity's skin image data
     */
    protected void releaseEntitySkin(Entity par1Entity)
    {
        super.releaseEntitySkin(par1Entity);
        entityIdMap.removeObject(par1Entity.entityId);
        Entity aentity[] = par1Entity.getParts();

        if (aentity != null)
        {
            Entity aentity1[] = aentity;
            int i = aentity1.length;

            for (int j = 0; j < i; j++)
            {
                Entity entity = aentity1[j];
                entityIdMap.removeObject(entity.entityId);
            }
        }
    }

    /**
     * Returns the Entity with the given ID, or null if it doesn't exist in this World.
     */
    public Entity getEntityByID(int par1)
    {
        return (Entity)entityIdMap.lookup(par1);
    }

    /**
     * adds a lightning bolt to the list of lightning bolts in this world.
     */
    public boolean addWeatherEffect(Entity par1Entity)
    {
        if (super.addWeatherEffect(par1Entity))
        {
            mcServer.func_71203_ab().sendPacketToPlayersAroundPoint(par1Entity.posX, par1Entity.posY, par1Entity.posZ, 512D, provider.worldType, new Packet71Weather(par1Entity));
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * sends a Packet 38 (Entity Status) to all tracked players of that entity
     */
    public void setEntityState(Entity par1Entity, byte par2)
    {
        Packet38EntityStatus packet38entitystatus = new Packet38EntityStatus(par1Entity.entityId, par2);
        getEntityTracker().sendPacketToTrackedPlayersAndTrackedEntity(par1Entity, packet38entitystatus);
    }

    /**
     * returns a new explosion. Does initiation (at time of writing Explosion is not finished)
     */
    public Explosion newExplosion(Entity par1Entity, double par2, double par4, double par6, float par8, boolean par9)
    {
        Explosion explosion = new Explosion(this, par1Entity, par2, par4, par6, par8);
        explosion.isFlaming = par9;
        explosion.doExplosionA();
        explosion.doExplosionB(false);
        Iterator iterator = playerEntities.iterator();

        do
        {
            if (!iterator.hasNext())
            {
                break;
            }

            EntityPlayer entityplayer = (EntityPlayer)iterator.next();

            if (entityplayer.getDistanceSq(par2, par4, par6) < 4096D)
            {
                ((EntityPlayerMP)entityplayer).playerNetServerHandler.sendPacket(new Packet60Explosion(par2, par4, par6, par8, explosion.field_77281_g, (Vec3)explosion.func_77277_b().get(entityplayer)));
            }
        }
        while (true);

        return explosion;
    }

    /**
     * Adds a block event with the given Args to the blockEventCache. During the next tick(), the block specified will
     * have its onBlockEvent handler called with the given parameters. Args: X,Y,Z, BlockID, EventID, EventParameter
     */
    public void addBlockEvent(int par1, int par2, int par3, int par4, int par5, int par6)
    {
        BlockEventData blockeventdata = new BlockEventData(par1, par2, par3, par4, par5, par6);

        for (Iterator iterator = blockEventCache[blockEventCacheIndex].iterator(); iterator.hasNext();)
        {
            BlockEventData blockeventdata1 = (BlockEventData)iterator.next();

            if (blockeventdata1.equals(blockeventdata))
            {
                return;
            }
        }

        blockEventCache[blockEventCacheIndex].add(blockeventdata);
    }

    /**
     * Send and apply locally all pending BlockEvents to each player with 64m radius of the event.
     */
    private void sendAndApplyBlockEvents()
    {
        int i;
        label0:

        for (; !blockEventCache[blockEventCacheIndex].isEmpty(); blockEventCache[i].clear())
        {
            i = blockEventCacheIndex;
            blockEventCacheIndex ^= 1;
            Iterator iterator = blockEventCache[i].iterator();

            do
            {
                if (!iterator.hasNext())
                {
                    continue label0;
                }

                BlockEventData blockeventdata = (BlockEventData)iterator.next();

                if (onBlockEventReceived(blockeventdata))
                {
                    mcServer.func_71203_ab().sendPacketToPlayersAroundPoint(blockeventdata.getX(), blockeventdata.getY(), blockeventdata.getZ(), 64D, provider.worldType, new Packet54PlayNoteBlock(blockeventdata.getX(), blockeventdata.getY(), blockeventdata.getZ(), blockeventdata.getBlockID(), blockeventdata.getEventID(), blockeventdata.getEventParameter()));
                }
            }
            while (true);
        }
    }

    /**
     * Called to apply a pending BlockEvent to apply to the current world.
     */
    private boolean onBlockEventReceived(BlockEventData par1BlockEventData)
    {
        int i = getBlockId(par1BlockEventData.getX(), par1BlockEventData.getY(), par1BlockEventData.getZ());

        if (i == par1BlockEventData.getBlockID())
        {
            Block.blocksList[i].onBlockEventReceived(this, par1BlockEventData.getX(), par1BlockEventData.getY(), par1BlockEventData.getZ(), par1BlockEventData.getEventID(), par1BlockEventData.getEventParameter());
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Syncs all changes to disk and wait for completion.
     */
    public void flush()
    {
        saveHandler.flush();
    }

    /**
     * Updates all weather states.
     */
    protected void updateWeather()
    {
        boolean flag = isRaining();
        super.updateWeather();

        if (flag != isRaining())
        {
            if (flag)
            {
                mcServer.func_71203_ab().sendPacketToAllPlayers(new Packet70GameEvent(2, 0));
            }
            else
            {
                mcServer.func_71203_ab().sendPacketToAllPlayers(new Packet70GameEvent(1, 0));
            }
        }
    }

    /**
     * Gets the MinecraftServer.
     */
    public MinecraftServer getMinecraftServer()
    {
        return mcServer;
    }

    /**
     * Gets the EntityTracker
     */
    public EntityTracker getEntityTracker()
    {
        return field_73062_L;
    }

    /**
     * Sets the time on the given WorldServer
     */
    public void setTime(long par1)
    {
        long l = par1 - worldInfo.getWorldTime();

        for (Iterator iterator = field_73064_N.iterator(); iterator.hasNext();)
        {
            NextTickListEntry nextticklistentry = (NextTickListEntry)iterator.next();
            nextticklistentry.scheduledTime += l;
        }

        Block ablock[] = Block.blocksList;
        int i = ablock.length;

        for (int j = 0; j < i; j++)
        {
            Block block = ablock[j];

            if (block != null)
            {
                block.onTimeChanged(this, l, par1);
            }
        }

        setWorldTime(par1);
    }

    public PlayerManager func_73040_p()
    {
        return field_73063_M;
    }

    static
    {
        bonusChestContent = (new WeightedRandomChestContent[]
                {
                    new WeightedRandomChestContent(Item.stick.shiftedIndex, 0, 1, 3, 10), new WeightedRandomChestContent(Block.planks.blockID, 0, 1, 3, 10), new WeightedRandomChestContent(Block.wood.blockID, 0, 1, 3, 10), new WeightedRandomChestContent(Item.axeStone.shiftedIndex, 0, 1, 1, 3), new WeightedRandomChestContent(Item.axeWood.shiftedIndex, 0, 1, 1, 5), new WeightedRandomChestContent(Item.pickaxeStone.shiftedIndex, 0, 1, 1, 3), new WeightedRandomChestContent(Item.pickaxeWood.shiftedIndex, 0, 1, 1, 5), new WeightedRandomChestContent(Item.appleRed.shiftedIndex, 0, 2, 3, 5), new WeightedRandomChestContent(Item.bread.shiftedIndex, 0, 2, 3, 3)
                });
    }
}
