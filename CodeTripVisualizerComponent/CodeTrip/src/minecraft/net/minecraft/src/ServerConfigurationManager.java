package net.minecraft.src;

import java.io.File;
import java.net.SocketAddress;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;
import net.minecraft.server.MinecraftServer;

public abstract class ServerConfigurationManager
{
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    public static final Logger myLogger = Logger.getLogger("Minecraft");
    private final MinecraftServer minecraftServerInstance;
    public final List playerList = new ArrayList();
    private final BanList bannedPlayers = new BanList(new File("banned-players.txt"));
    private final BanList bannedIPs = new BanList(new File("banned-ips.txt"));

    /** the list of names on the whiteList */
    private Set whiteListNames;
    private Set whiteListIPs;
    private IPlayerFileData field_72412_k;

    /**
     * Server setting to only allow OPs and whitelisted players to join the server.
     */
    private boolean whiteListEnforced;

    /** The maximum number of players that can be connected at a time. */
    protected int maxPlayers;
    protected int viewDistance;
    private EnumGameType gameType;

    /** True if all players are allowed to use commands (cheats). */
    private boolean commandsAllowedForAll;
    private int field_72408_o;

    public ServerConfigurationManager(MinecraftServer par1MinecraftServer)
    {
        whiteListNames = new HashSet();
        whiteListIPs = new HashSet();
        field_72408_o = 0;
        minecraftServerInstance = par1MinecraftServer;
        bannedPlayers.setListActive(false);
        bannedIPs.setListActive(false);
        maxPlayers = 8;
    }

    public void initializeConnectionToPlayer(NetworkManager par1NetworkManager, EntityPlayerMP par2EntityPlayerMP)
    {
        func_72380_a(par2EntityPlayerMP);
        par2EntityPlayerMP.setWorld(minecraftServerInstance.worldServerForDimension(par2EntityPlayerMP.dimension));
        par2EntityPlayerMP.theItemInWorldManager.setWorld((WorldServer)par2EntityPlayerMP.worldObj);
        String s = "local";

        if (par1NetworkManager.getSocketAddress() != null)
        {
            s = par1NetworkManager.getSocketAddress().toString();
        }

        myLogger.info((new StringBuilder()).append(par2EntityPlayerMP.username).append("[").append(s).append("] logged in with entity id ").append(par2EntityPlayerMP.entityId).append(" at (").append(par2EntityPlayerMP.posX).append(", ").append(par2EntityPlayerMP.posY).append(", ").append(par2EntityPlayerMP.posZ).append(")").toString());
        WorldServer worldserver = minecraftServerInstance.worldServerForDimension(par2EntityPlayerMP.dimension);
        ChunkCoordinates chunkcoordinates = worldserver.getSpawnPoint();
        func_72381_a(par2EntityPlayerMP, null, worldserver);
        NetServerHandler netserverhandler = new NetServerHandler(minecraftServerInstance, par1NetworkManager, par2EntityPlayerMP);
        netserverhandler.sendPacketToPlayer(new Packet1Login(par2EntityPlayerMP.entityId, worldserver.getWorldInfo().getTerrainType(), par2EntityPlayerMP.theItemInWorldManager.getGameType(), worldserver.getWorldInfo().isHardcoreModeEnabled(), worldserver.provider.worldType, worldserver.difficultySetting, worldserver.getHeight(), getMaxPlayers()));
        netserverhandler.sendPacketToPlayer(new Packet6SpawnPosition(chunkcoordinates.posX, chunkcoordinates.posY, chunkcoordinates.posZ));
        netserverhandler.sendPacketToPlayer(new Packet202PlayerAbilities(par2EntityPlayerMP.capabilities));
        sendTimeAndRainingToPlayer(par2EntityPlayerMP, worldserver);
        sendPacketToAllPlayers(new Packet3Chat((new StringBuilder()).append("\247e").append(par2EntityPlayerMP.username).append(" joined the game.").toString()));
        func_72377_c(par2EntityPlayerMP);
        netserverhandler.setPlayerLocation(par2EntityPlayerMP.posX, par2EntityPlayerMP.posY, par2EntityPlayerMP.posZ, par2EntityPlayerMP.rotationYaw, par2EntityPlayerMP.rotationPitch);
        minecraftServerInstance.getNetworkThread().func_71745_a(netserverhandler);
        netserverhandler.sendPacketToPlayer(new Packet4UpdateTime(worldserver.getWorldTime()));

        if (minecraftServerInstance.getTexturePack().length() > 0)
        {
            par2EntityPlayerMP.requestTexturePackLoad(minecraftServerInstance.getTexturePack(), minecraftServerInstance.textureFlag());
        }

        PotionEffect potioneffect;

        for (Iterator iterator = par2EntityPlayerMP.getActivePotionEffects().iterator(); iterator.hasNext(); netserverhandler.sendPacketToPlayer(new Packet41EntityEffect(par2EntityPlayerMP.entityId, potioneffect)))
        {
            potioneffect = (PotionEffect)iterator.next();
        }

        par2EntityPlayerMP.addSelfToInternalCraftingInventory();
    }

    public void func_72364_a(WorldServer par1ArrayOfWorldServer[])
    {
        field_72412_k = par1ArrayOfWorldServer[0].getSaveHandler().getSaveHandler();
    }

    public void func_72375_a(EntityPlayerMP par1EntityPlayerMP, WorldServer par2WorldServer)
    {
        WorldServer worldserver = par1EntityPlayerMP.getServerForPlayer();

        if (par2WorldServer != null)
        {
            par2WorldServer.getPlayerManager().func_72695_c(par1EntityPlayerMP);
        }

        worldserver.getPlayerManager().func_72683_a(par1EntityPlayerMP);
        worldserver.theChunkProviderServer.loadChunk((int)par1EntityPlayerMP.posX >> 4, (int)par1EntityPlayerMP.posZ >> 4);
    }

    public int getEntityViewDistance()
    {
        return PlayerManager.func_72686_a(getViewDistance());
    }

    public void func_72380_a(EntityPlayerMP par1EntityPlayerMP)
    {
        NBTTagCompound nbttagcompound = minecraftServerInstance.dimensionServerList[0].getWorldInfo().getPlayerNBTTagCompound();

        if (par1EntityPlayerMP.getCommandSenderName().equals(minecraftServerInstance.getServerOwner()) && nbttagcompound != null)
        {
            par1EntityPlayerMP.readFromNBT(nbttagcompound);
        }
        else
        {
            field_72412_k.readPlayerData(par1EntityPlayerMP);
        }
    }

    /**
     * also stores the NBTTags if this is an intergratedPlayerList
     */
    protected void writePlayerData(EntityPlayerMP par1EntityPlayerMP)
    {
        field_72412_k.writePlayerData(par1EntityPlayerMP);
    }

    public void func_72377_c(EntityPlayerMP par1EntityPlayerMP)
    {
        sendPacketToAllPlayers(new Packet201PlayerInfo(par1EntityPlayerMP.username, true, 1000));
        playerList.add(par1EntityPlayerMP);
        WorldServer worldserver;

        for (worldserver = minecraftServerInstance.worldServerForDimension(par1EntityPlayerMP.dimension); !worldserver.getCollidingBoundingBoxes(par1EntityPlayerMP, par1EntityPlayerMP.boundingBox).isEmpty(); par1EntityPlayerMP.setPosition(par1EntityPlayerMP.posX, par1EntityPlayerMP.posY + 1.0D, par1EntityPlayerMP.posZ)) { }

        worldserver.spawnEntityInWorld(par1EntityPlayerMP);
        func_72375_a(par1EntityPlayerMP, null);
        EntityPlayerMP entityplayermp;

        for (Iterator iterator = playerList.iterator(); iterator.hasNext(); par1EntityPlayerMP.serverForThisPlayer.sendPacketToPlayer(new Packet201PlayerInfo(entityplayermp.username, true, entityplayermp.field_71138_i)))
        {
            entityplayermp = (EntityPlayerMP)iterator.next();
        }
    }

    public void func_72358_d(EntityPlayerMP par1EntityPlayerMP)
    {
        par1EntityPlayerMP.getServerForPlayer().getPlayerManager().func_72685_d(par1EntityPlayerMP);
    }

    public void func_72367_e(EntityPlayerMP par1EntityPlayerMP)
    {
        writePlayerData(par1EntityPlayerMP);
        WorldServer worldserver = par1EntityPlayerMP.getServerForPlayer();
        worldserver.setEntityDead(par1EntityPlayerMP);
        worldserver.getPlayerManager().func_72695_c(par1EntityPlayerMP);
        playerList.remove(par1EntityPlayerMP);
        sendPacketToAllPlayers(new Packet201PlayerInfo(par1EntityPlayerMP.username, false, 9999));
    }

    /**
     * checks ban-lists, then white-lists, then space for the server. Returns null on success, or an error message
     */
    public String allowUserToConnect(SocketAddress par1SocketAddress, String par2Str)
    {
        if (bannedPlayers.isBanned(par2Str))
        {
            BanEntry banentry = (BanEntry)bannedPlayers.getBannedList().get(par2Str);
            String s1 = (new StringBuilder()).append("You are banned from this server!\nReason: ").append(banentry.getBanReason()).toString();

            if (banentry.getBanEndDate() != null)
            {
                s1 = (new StringBuilder()).append(s1).append("\nYour ban will be removed on ").append(dateFormat.format(banentry.getBanEndDate())).toString();
            }

            return s1;
        }

        if (!isWhiteListed(par2Str))
        {
            return "You are not white-listed on this server!";
        }

        String s = par1SocketAddress.toString();
        s = s.substring(s.indexOf("/") + 1);
        s = s.substring(0, s.indexOf(":"));

        if (bannedIPs.isBanned(s))
        {
            BanEntry banentry1 = (BanEntry)bannedIPs.getBannedList().get(s);
            String s2 = (new StringBuilder()).append("Your IP address is banned from this server!\nReason: ").append(banentry1.getBanReason()).toString();

            if (banentry1.getBanEndDate() != null)
            {
                s2 = (new StringBuilder()).append(s2).append("\nYour ban will be removed on ").append(dateFormat.format(banentry1.getBanEndDate())).toString();
            }

            return s2;
        }

        if (playerList.size() >= maxPlayers)
        {
            return "The server is full!";
        }
        else
        {
            return null;
        }
    }

    /**
     * also checks for multiple logins
     */
    public EntityPlayerMP createPlayerForUser(String par1Str)
    {
        ArrayList arraylist = new ArrayList();
        Object obj = playerList.iterator();

        do
        {
            if (!((Iterator)(obj)).hasNext())
            {
                break;
            }

            EntityPlayerMP entityplayermp = (EntityPlayerMP)((Iterator)(obj)).next();

            if (entityplayermp.username.equalsIgnoreCase(par1Str))
            {
                arraylist.add(entityplayermp);
            }
        }
        while (true);

        EntityPlayerMP entityplayermp1;

        for (obj = arraylist.iterator(); ((Iterator)(obj)).hasNext(); entityplayermp1.serverForThisPlayer.kickPlayerFromServer("You logged in from another location"))
        {
            entityplayermp1 = (EntityPlayerMP)((Iterator)(obj)).next();
        }

        if (minecraftServerInstance.isDemo())
        {
            obj = new DemoWorldManager(minecraftServerInstance.worldServerForDimension(0));
        }
        else
        {
            obj = new ItemInWorldManager(minecraftServerInstance.worldServerForDimension(0));
        }

        return new EntityPlayerMP(minecraftServerInstance, minecraftServerInstance.worldServerForDimension(0), par1Str, ((ItemInWorldManager)(obj)));
    }

    /**
     * creates and returns a respawned player based on the provided PlayerEntity. Args are the PlayerEntityMP to
     * respawn, an INT for the dimension to respawn into (usually 0), and a boolean value that is true if the player
     * beat the game rather than dying
     */
    public EntityPlayerMP respawnPlayer(EntityPlayerMP par1EntityPlayerMP, int par2, boolean par3)
    {
        par1EntityPlayerMP.getServerForPlayer().getEntityTracker().removeAllTrackingPlayers(par1EntityPlayerMP);
        par1EntityPlayerMP.getServerForPlayer().getEntityTracker().removeEntityFromAllTrackingPlayers(par1EntityPlayerMP);
        par1EntityPlayerMP.getServerForPlayer().getPlayerManager().func_72695_c(par1EntityPlayerMP);
        playerList.remove(par1EntityPlayerMP);
        minecraftServerInstance.worldServerForDimension(par1EntityPlayerMP.dimension).removeEntity(par1EntityPlayerMP);
        ChunkCoordinates chunkcoordinates = par1EntityPlayerMP.getSpawnChunk();
        par1EntityPlayerMP.dimension = par2;
        Object obj;

        if (minecraftServerInstance.isDemo())
        {
            obj = new DemoWorldManager(minecraftServerInstance.worldServerForDimension(par1EntityPlayerMP.dimension));
        }
        else
        {
            obj = new ItemInWorldManager(minecraftServerInstance.worldServerForDimension(par1EntityPlayerMP.dimension));
        }

        EntityPlayerMP entityplayermp = new EntityPlayerMP(minecraftServerInstance, minecraftServerInstance.worldServerForDimension(par1EntityPlayerMP.dimension), par1EntityPlayerMP.username, ((ItemInWorldManager)(obj)));
        entityplayermp.clonePlayer(par1EntityPlayerMP, par3);
        entityplayermp.entityId = par1EntityPlayerMP.entityId;
        entityplayermp.serverForThisPlayer = par1EntityPlayerMP.serverForThisPlayer;
        WorldServer worldserver = minecraftServerInstance.worldServerForDimension(par1EntityPlayerMP.dimension);
        func_72381_a(entityplayermp, par1EntityPlayerMP, worldserver);

        if (chunkcoordinates != null)
        {
            ChunkCoordinates chunkcoordinates1 = EntityPlayer.verifyRespawnCoordinates(minecraftServerInstance.worldServerForDimension(par1EntityPlayerMP.dimension), chunkcoordinates);

            if (chunkcoordinates1 != null)
            {
                entityplayermp.setLocationAndAngles((float)chunkcoordinates1.posX + 0.5F, (float)chunkcoordinates1.posY + 0.1F, (float)chunkcoordinates1.posZ + 0.5F, 0.0F, 0.0F);
                entityplayermp.setSpawnChunk(chunkcoordinates);
            }
            else
            {
                entityplayermp.serverForThisPlayer.sendPacketToPlayer(new Packet70GameEvent(0, 0));
            }
        }

        worldserver.theChunkProviderServer.loadChunk((int)entityplayermp.posX >> 4, (int)entityplayermp.posZ >> 4);

        for (; !worldserver.getCollidingBoundingBoxes(entityplayermp, entityplayermp.boundingBox).isEmpty(); entityplayermp.setPosition(entityplayermp.posX, entityplayermp.posY + 1.0D, entityplayermp.posZ)) { }

        entityplayermp.serverForThisPlayer.sendPacketToPlayer(new Packet9Respawn(entityplayermp.dimension, (byte)entityplayermp.worldObj.difficultySetting, entityplayermp.worldObj.getWorldInfo().getTerrainType(), entityplayermp.worldObj.getHeight(), entityplayermp.theItemInWorldManager.getGameType()));
        ChunkCoordinates chunkcoordinates2 = worldserver.getSpawnPoint();
        entityplayermp.serverForThisPlayer.setPlayerLocation(entityplayermp.posX, entityplayermp.posY, entityplayermp.posZ, entityplayermp.rotationYaw, entityplayermp.rotationPitch);
        entityplayermp.serverForThisPlayer.sendPacketToPlayer(new Packet6SpawnPosition(chunkcoordinates2.posX, chunkcoordinates2.posY, chunkcoordinates2.posZ));
        sendTimeAndRainingToPlayer(entityplayermp, worldserver);
        worldserver.getPlayerManager().func_72683_a(entityplayermp);
        worldserver.spawnEntityInWorld(entityplayermp);
        playerList.add(entityplayermp);
        entityplayermp.addSelfToInternalCraftingInventory();
        return entityplayermp;
    }

    public void transferPlayerToDimension(EntityPlayerMP par1EntityPlayerMP, int par2)
    {
        int i = par1EntityPlayerMP.dimension;
        WorldServer worldserver = minecraftServerInstance.worldServerForDimension(par1EntityPlayerMP.dimension);
        par1EntityPlayerMP.dimension = par2;
        WorldServer worldserver1 = minecraftServerInstance.worldServerForDimension(par1EntityPlayerMP.dimension);
        par1EntityPlayerMP.serverForThisPlayer.sendPacketToPlayer(new Packet9Respawn(par1EntityPlayerMP.dimension, (byte)par1EntityPlayerMP.worldObj.difficultySetting, worldserver1.getWorldInfo().getTerrainType(), worldserver1.getHeight(), par1EntityPlayerMP.theItemInWorldManager.getGameType()));
        worldserver.removeEntity(par1EntityPlayerMP);
        par1EntityPlayerMP.isDead = false;
        double d = par1EntityPlayerMP.posX;
        double d1 = par1EntityPlayerMP.posZ;
        double d2 = 8D;

        if (par1EntityPlayerMP.dimension == -1)
        {
            d /= d2;
            d1 /= d2;
            par1EntityPlayerMP.setLocationAndAngles(d, par1EntityPlayerMP.posY, d1, par1EntityPlayerMP.rotationYaw, par1EntityPlayerMP.rotationPitch);

            if (par1EntityPlayerMP.isEntityAlive())
            {
                worldserver.updateEntityWithOptionalForce(par1EntityPlayerMP, false);
            }
        }
        else if (par1EntityPlayerMP.dimension == 0)
        {
            d *= d2;
            d1 *= d2;
            par1EntityPlayerMP.setLocationAndAngles(d, par1EntityPlayerMP.posY, d1, par1EntityPlayerMP.rotationYaw, par1EntityPlayerMP.rotationPitch);

            if (par1EntityPlayerMP.isEntityAlive())
            {
                worldserver.updateEntityWithOptionalForce(par1EntityPlayerMP, false);
            }
        }
        else
        {
            ChunkCoordinates chunkcoordinates = worldserver1.getEntrancePortalLocation();
            d = chunkcoordinates.posX;
            par1EntityPlayerMP.posY = chunkcoordinates.posY;
            d1 = chunkcoordinates.posZ;
            par1EntityPlayerMP.setLocationAndAngles(d, par1EntityPlayerMP.posY, d1, 90F, 0.0F);

            if (par1EntityPlayerMP.isEntityAlive())
            {
                worldserver.updateEntityWithOptionalForce(par1EntityPlayerMP, false);
            }
        }

        if (i != 1)
        {
            d = MathHelper.clamp_int((int)d, 0xfe363d00, 0x1c9c300);
            d1 = MathHelper.clamp_int((int)d1, 0xfe363d00, 0x1c9c300);

            if (par1EntityPlayerMP.isEntityAlive())
            {
                worldserver1.spawnEntityInWorld(par1EntityPlayerMP);
                par1EntityPlayerMP.setLocationAndAngles(d, par1EntityPlayerMP.posY, d1, par1EntityPlayerMP.rotationYaw, par1EntityPlayerMP.rotationPitch);
                worldserver1.updateEntityWithOptionalForce(par1EntityPlayerMP, false);
                (new Teleporter()).placeInPortal(worldserver1, par1EntityPlayerMP);
            }
        }

        par1EntityPlayerMP.setWorld(worldserver1);
        func_72375_a(par1EntityPlayerMP, worldserver);
        par1EntityPlayerMP.serverForThisPlayer.setPlayerLocation(par1EntityPlayerMP.posX, par1EntityPlayerMP.posY, par1EntityPlayerMP.posZ, par1EntityPlayerMP.rotationYaw, par1EntityPlayerMP.rotationPitch);
        par1EntityPlayerMP.theItemInWorldManager.setWorld(worldserver1);
        sendTimeAndRainingToPlayer(par1EntityPlayerMP, worldserver1);
        syncPlayerInventory(par1EntityPlayerMP);
        PotionEffect potioneffect;

        for (Iterator iterator = par1EntityPlayerMP.getActivePotionEffects().iterator(); iterator.hasNext(); par1EntityPlayerMP.serverForThisPlayer.sendPacketToPlayer(new Packet41EntityEffect(par1EntityPlayerMP.entityId, potioneffect)))
        {
            potioneffect = (PotionEffect)iterator.next();
        }
    }

    /**
     * sends 1 player per tick, but only sends a player once every 600 ticks
     */
    public void sendPlayerInfoToAllPlayers()
    {
        if (++field_72408_o > 600)
        {
            field_72408_o = 0;
        }

        if (field_72408_o < playerList.size())
        {
            EntityPlayerMP entityplayermp = (EntityPlayerMP)playerList.get(field_72408_o);
            sendPacketToAllPlayers(new Packet201PlayerInfo(entityplayermp.username, true, entityplayermp.field_71138_i));
        }
    }

    public void sendPacketToAllPlayers(Packet par1Packet)
    {
        EntityPlayerMP entityplayermp;

        for (Iterator iterator = playerList.iterator(); iterator.hasNext(); entityplayermp.serverForThisPlayer.sendPacketToPlayer(par1Packet))
        {
            entityplayermp = (EntityPlayerMP)iterator.next();
        }
    }

    public void sendPacketToAllPlayersInDimension(Packet par1Packet, int par2)
    {
        Iterator iterator = playerList.iterator();

        do
        {
            if (!iterator.hasNext())
            {
                break;
            }

            EntityPlayerMP entityplayermp = (EntityPlayerMP)iterator.next();

            if (entityplayermp.dimension == par2)
            {
                entityplayermp.serverForThisPlayer.sendPacketToPlayer(par1Packet);
            }
        }
        while (true);
    }

    public String func_72398_c()
    {
        String s = "";

        for (int i = 0; i < playerList.size(); i++)
        {
            if (i > 0)
            {
                s = (new StringBuilder()).append(s).append(", ").toString();
            }

            s = (new StringBuilder()).append(s).append(((EntityPlayerMP)playerList.get(i)).username).toString();
        }

        return s;
    }

    public String[] getAllUsernames()
    {
        String as[] = new String[playerList.size()];

        for (int i = 0; i < playerList.size(); i++)
        {
            as[i] = ((EntityPlayerMP)playerList.get(i)).username;
        }

        return as;
    }

    public BanList getBannedPlayers()
    {
        return bannedPlayers;
    }

    public BanList getBannedIPs()
    {
        return bannedIPs;
    }

    public void addNameToWhitelist(String par1Str)
    {
        whiteListNames.add(par1Str.toLowerCase());
    }

    public void removeNameFromWhitelist(String par1Str)
    {
        whiteListNames.remove(par1Str.toLowerCase());
    }

    public boolean isWhiteListed(String par1Str)
    {
        par1Str = par1Str.trim().toLowerCase();
        return !whiteListEnforced || whiteListNames.contains(par1Str) || whiteListIPs.contains(par1Str);
    }

    public boolean areCommandsAllowed(String par1Str)
    {
        return whiteListNames.contains(par1Str.trim().toLowerCase()) || minecraftServerInstance.isSinglePlayer() && minecraftServerInstance.dimensionServerList[0].getWorldInfo().areCommandsAllowed() && minecraftServerInstance.getServerOwner().equalsIgnoreCase(par1Str) || commandsAllowedForAll;
    }

    public EntityPlayerMP getPlayerForUsername(String par1Str)
    {
        for (Iterator iterator = playerList.iterator(); iterator.hasNext();)
        {
            EntityPlayerMP entityplayermp = (EntityPlayerMP)iterator.next();

            if (entityplayermp.username.equalsIgnoreCase(par1Str))
            {
                return entityplayermp;
            }
        }

        return null;
    }

    /**
     * params: x,y,z,d,dimension. The packet is sent to all players within d distance of x,y,z (d^2<x^2+y^2+z^2)
     */
    public void sendToAllNear(double par1, double par3, double par5, double par7, int par9, Packet par10Packet)
    {
        sendToAllNearExcept(null, par1, par3, par5, par7, par9, par10Packet);
    }

    /**
     * params: srcPlayer,x,y,z,d,dimension. The packet is not sent to the srcPlayer, but all other players where
     * dx*dx+dy*dy+dz*dz<d*d
     */
    public void sendToAllNearExcept(EntityPlayer par1EntityPlayer, double par2, double par4, double par6, double par8, int par10, Packet par11Packet)
    {
        Iterator iterator = playerList.iterator();

        do
        {
            if (!iterator.hasNext())
            {
                break;
            }

            EntityPlayerMP entityplayermp = (EntityPlayerMP)iterator.next();

            if (entityplayermp != par1EntityPlayer && entityplayermp.dimension == par10)
            {
                double d = par2 - entityplayermp.posX;
                double d1 = par4 - entityplayermp.posY;
                double d2 = par6 - entityplayermp.posZ;

                if (d * d + d1 * d1 + d2 * d2 < par8 * par8)
                {
                    entityplayermp.serverForThisPlayer.sendPacketToPlayer(par11Packet);
                }
            }
        }
        while (true);
    }

    public void saveAllPlayerData()
    {
        EntityPlayerMP entityplayermp;

        for (Iterator iterator = playerList.iterator(); iterator.hasNext(); writePlayerData(entityplayermp))
        {
            entityplayermp = (EntityPlayerMP)iterator.next();
        }
    }

    public void addToIPWhitelist(String par1Str)
    {
        whiteListIPs.add(par1Str);
    }

    public void removeFromIPWhitelist(String par1Str)
    {
        whiteListIPs.remove(par1Str);
    }

    public Set getIPWhiteList()
    {
        return whiteListIPs;
    }

    public Set getNamesWhiteList()
    {
        return whiteListNames;
    }

    /**
     * eithre does nothing, or calls readWhiteList
     */
    public void loadWhiteList()
    {
    }

    public void sendTimeAndRainingToPlayer(EntityPlayerMP par1EntityPlayerMP, WorldServer par2WorldServer)
    {
        par1EntityPlayerMP.serverForThisPlayer.sendPacketToPlayer(new Packet4UpdateTime(par2WorldServer.getWorldTime()));

        if (par2WorldServer.isRaining())
        {
            par1EntityPlayerMP.serverForThisPlayer.sendPacketToPlayer(new Packet70GameEvent(1, 0));
        }
    }

    /**
     * sends the players inventory to himself
     */
    public void syncPlayerInventory(EntityPlayerMP par1EntityPlayerMP)
    {
        par1EntityPlayerMP.sendContainerToPlayer(par1EntityPlayerMP.inventorySlots);
        par1EntityPlayerMP.setPlayerHealthUpdated();
    }

    public int getPlayerListSize()
    {
        return playerList.size();
    }

    public int getMaxPlayers()
    {
        return maxPlayers;
    }

    /**
     * returns a list of usernames for which playerData is available
     */
    public String[] getAvailablePlayerDat()
    {
        return minecraftServerInstance.dimensionServerList[0].getSaveHandler().getSaveHandler().getAvailablePlayerDat();
    }

    public boolean isWhiteListEnabled()
    {
        return whiteListEnforced;
    }

    public void setWhiteListEnabled(boolean par1)
    {
        whiteListEnforced = par1;
    }

    public List getPlayerList(String par1Str)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = playerList.iterator();

        do
        {
            if (!iterator.hasNext())
            {
                break;
            }

            EntityPlayerMP entityplayermp = (EntityPlayerMP)iterator.next();

            if (entityplayermp.func_71114_r().equals(par1Str))
            {
                arraylist.add(entityplayermp);
            }
        }
        while (true);

        return arraylist;
    }

    /**
     * Gets the View Distance.
     */
    public int getViewDistance()
    {
        return viewDistance;
    }

    public MinecraftServer getServerInstance()
    {
        return minecraftServerInstance;
    }

    /**
     * gets the tags created in the last writePlayerData call
     */
    public NBTTagCompound getTagsFromLastWrite()
    {
        return null;
    }

    public void setGameType(EnumGameType par1EnumGameType)
    {
        gameType = par1EnumGameType;
    }

    private void func_72381_a(EntityPlayerMP par1EntityPlayerMP, EntityPlayerMP par2EntityPlayerMP, World par3World)
    {
        if (par2EntityPlayerMP != null)
        {
            par1EntityPlayerMP.theItemInWorldManager.setGameType(par2EntityPlayerMP.theItemInWorldManager.getGameType());
        }
        else if (gameType != null)
        {
            par1EntityPlayerMP.theItemInWorldManager.setGameType(gameType);
        }

        par1EntityPlayerMP.theItemInWorldManager.initializeGameType(par3World.getWorldInfo().getGameType());
    }

    /**
     * Sets whether all players are allowed to use commands (cheats) on the server.
     */
    public void setCommandsAllowedForAll(boolean par1)
    {
        commandsAllowedForAll = par1;
    }

    /**
     * kicks everyone with the "Server closed"
     */
    public void removeAllPlayers()
    {
        for (; !playerList.isEmpty(); ((EntityPlayerMP)playerList.get(0)).serverForThisPlayer.kickPlayerFromServer("Server closed")) { }
    }
}
