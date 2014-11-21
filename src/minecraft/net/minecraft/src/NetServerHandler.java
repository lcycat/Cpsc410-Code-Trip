package net.minecraft.src;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;
import net.minecraft.server.MinecraftServer;

public class NetServerHandler extends NetHandler
{
    /** The logging system. */
    public static Logger logger = Logger.getLogger("Minecraft");
    public NetworkManager theNetworkManager;
    public boolean serverShuttingDown;

    /** Reference to the MinecraftServer object. */
    private MinecraftServer mcServer;

    /** Reference to the EntityPlayerMP object. */
    private EntityPlayerMP playerEntity;

    /** incremented each tick */
    private int currentTicks;

    /**
     * player is kicked if they float for over 80 ticks without flying enabled
     */
    private int ticksForFloatKick;
    private boolean field_72584_h;
    private int keepAliveRandomID;
    private long keepAliveTimeSent;
    private static Random randomGenerator = new Random();
    private long ticksOfLastKeepAlive;
    private int chatSpamThresholdCount;
    private int creativeItemCreationSpamThresholdTally;

    /** The last known x position for this connection. */
    private double lastPosX;

    /** The last known y position for this connection. */
    private double lastPosY;

    /** The last known z position for this connection. */
    private double lastPosZ;
    private boolean field_72587_r;
    private IntHashMap field_72586_s;

    public NetServerHandler(MinecraftServer par1MinecraftServer, NetworkManager par2NetworkManager, EntityPlayerMP par3EntityPlayerMP)
    {
        serverShuttingDown = false;
        chatSpamThresholdCount = 0;
        creativeItemCreationSpamThresholdTally = 0;
        field_72587_r = true;
        field_72586_s = new IntHashMap();
        mcServer = par1MinecraftServer;
        theNetworkManager = par2NetworkManager;
        par2NetworkManager.setNetHandler(this);
        playerEntity = par3EntityPlayerMP;
        par3EntityPlayerMP.serverForThisPlayer = this;
    }

    public EntityPlayerMP getPlayer()
    {
        return playerEntity;
    }

    /**
     * run once each game tick
     */
    public void networkTick()
    {
        field_72584_h = false;
        currentTicks++;
        mcServer.theProfiler.startSection("packetflow");
        theNetworkManager.processReadPackets();
        mcServer.theProfiler.endStartSection("keepAlive");

        if ((long)currentTicks - ticksOfLastKeepAlive > 20L)
        {
            ticksOfLastKeepAlive = currentTicks;
            keepAliveTimeSent = System.nanoTime() / 0xf4240L;
            keepAliveRandomID = randomGenerator.nextInt();
            sendPacketToPlayer(new Packet0KeepAlive(keepAliveRandomID));
        }

        if (chatSpamThresholdCount > 0)
        {
            chatSpamThresholdCount--;
        }

        if (creativeItemCreationSpamThresholdTally > 0)
        {
            creativeItemCreationSpamThresholdTally--;
        }

        mcServer.theProfiler.endStartSection("playerTick");

        if (!field_72584_h && !playerEntity.playerHasConqueredTheEnd)
        {
            playerEntity.onUpdateEntity();
        }

        mcServer.theProfiler.endSection();
    }

    public void kickPlayerFromServer(String par1Str)
    {
        if (serverShuttingDown)
        {
            return;
        }
        else
        {
            playerEntity.mountEntityAndWakeUp();
            sendPacketToPlayer(new Packet255KickDisconnect(par1Str));
            theNetworkManager.serverShutdown();
            mcServer.getConfigurationManager().sendPacketToAllPlayers(new Packet3Chat((new StringBuilder()).append("\247e").append(playerEntity.username).append(" left the game.").toString()));
            mcServer.getConfigurationManager().func_72367_e(playerEntity);
            serverShuttingDown = true;
            return;
        }
    }

    public void handleFlying(Packet10Flying par1Packet10Flying)
    {
        WorldServer worldserver = mcServer.worldServerForDimension(playerEntity.dimension);
        field_72584_h = true;

        if (playerEntity.playerHasConqueredTheEnd)
        {
            return;
        }

        if (!field_72587_r)
        {
            double d = par1Packet10Flying.yPosition - lastPosY;

            if (par1Packet10Flying.xPosition == lastPosX && d * d < 0.01D && par1Packet10Flying.zPosition == lastPosZ)
            {
                field_72587_r = true;
            }
        }

        if (field_72587_r)
        {
            if (playerEntity.ridingEntity != null)
            {
                float f = playerEntity.rotationYaw;
                float f1 = playerEntity.rotationPitch;
                playerEntity.ridingEntity.updateRiderPosition();
                double d2 = playerEntity.posX;
                double d4 = playerEntity.posY;
                double d6 = playerEntity.posZ;
                double d8 = 0.0D;
                double d9 = 0.0D;

                if (par1Packet10Flying.rotating)
                {
                    f = par1Packet10Flying.yaw;
                    f1 = par1Packet10Flying.pitch;
                }

                if (par1Packet10Flying.moving && par1Packet10Flying.yPosition == -999D && par1Packet10Flying.stance == -999D)
                {
                    if (par1Packet10Flying.xPosition > 1.0D || par1Packet10Flying.zPosition > 1.0D)
                    {
                        System.err.println((new StringBuilder()).append(playerEntity.username).append(" was caught trying to crash the server with an invalid position.").toString());
                        kickPlayerFromServer("Nope!");
                        return;
                    }

                    d8 = par1Packet10Flying.xPosition;
                    d9 = par1Packet10Flying.zPosition;
                }

                playerEntity.onGround = par1Packet10Flying.onGround;
                playerEntity.onUpdateEntity();
                playerEntity.moveEntity(d8, 0.0D, d9);
                playerEntity.setPositionAndRotation(d2, d4, d6, f, f1);
                playerEntity.motionX = d8;
                playerEntity.motionZ = d9;

                if (playerEntity.ridingEntity != null)
                {
                    worldserver.uncheckedUpdateEntity(playerEntity.ridingEntity, true);
                }

                if (playerEntity.ridingEntity != null)
                {
                    playerEntity.ridingEntity.updateRiderPosition();
                }

                mcServer.getConfigurationManager().func_72358_d(playerEntity);
                lastPosX = playerEntity.posX;
                lastPosY = playerEntity.posY;
                lastPosZ = playerEntity.posZ;
                worldserver.updateEntity(playerEntity);
                return;
            }

            if (playerEntity.isPlayerSleeping())
            {
                playerEntity.onUpdateEntity();
                playerEntity.setPositionAndRotation(lastPosX, lastPosY, lastPosZ, playerEntity.rotationYaw, playerEntity.rotationPitch);
                worldserver.updateEntity(playerEntity);
                return;
            }

            double d1 = playerEntity.posY;
            lastPosX = playerEntity.posX;
            lastPosY = playerEntity.posY;
            lastPosZ = playerEntity.posZ;
            double d3 = playerEntity.posX;
            double d5 = playerEntity.posY;
            double d7 = playerEntity.posZ;
            float f2 = playerEntity.rotationYaw;
            float f3 = playerEntity.rotationPitch;

            if (par1Packet10Flying.moving && par1Packet10Flying.yPosition == -999D && par1Packet10Flying.stance == -999D)
            {
                par1Packet10Flying.moving = false;
            }

            if (par1Packet10Flying.moving)
            {
                d3 = par1Packet10Flying.xPosition;
                d5 = par1Packet10Flying.yPosition;
                d7 = par1Packet10Flying.zPosition;
                double d10 = par1Packet10Flying.stance - par1Packet10Flying.yPosition;

                if (!playerEntity.isPlayerSleeping() && (d10 > 1.6499999999999999D || d10 < 0.10000000000000001D))
                {
                    kickPlayerFromServer("Illegal stance");
                    logger.warning((new StringBuilder()).append(playerEntity.username).append(" had an illegal stance: ").append(d10).toString());
                    return;
                }

                if (Math.abs(par1Packet10Flying.xPosition) > 32000000D || Math.abs(par1Packet10Flying.zPosition) > 32000000D)
                {
                    kickPlayerFromServer("Illegal position");
                    return;
                }
            }

            if (par1Packet10Flying.rotating)
            {
                f2 = par1Packet10Flying.yaw;
                f3 = par1Packet10Flying.pitch;
            }

            playerEntity.onUpdateEntity();
            playerEntity.ySize = 0.0F;
            playerEntity.setPositionAndRotation(lastPosX, lastPosY, lastPosZ, f2, f3);

            if (!field_72587_r)
            {
                return;
            }

            double d11 = d3 - playerEntity.posX;
            double d12 = d5 - playerEntity.posY;
            double d13 = d7 - playerEntity.posZ;
            double d14 = Math.min(Math.abs(d11), Math.abs(playerEntity.motionX));
            double d15 = Math.min(Math.abs(d12), Math.abs(playerEntity.motionY));
            double d16 = Math.min(Math.abs(d13), Math.abs(playerEntity.motionZ));
            double d17 = d14 * d14 + d15 * d15 + d16 * d16;

            if (d17 > 100D && (!mcServer.isSinglePlayer() || !mcServer.getServerOwner().equals(playerEntity.username)))
            {
                logger.warning((new StringBuilder()).append(playerEntity.username).append(" moved too quickly! ").append(d11).append(",").append(d12).append(",").append(d13).append(" (").append(d14).append(", ").append(d15).append(", ").append(d16).append(")").toString());
                setPlayerLocation(lastPosX, lastPosY, lastPosZ, playerEntity.rotationYaw, playerEntity.rotationPitch);
                return;
            }

            float f4 = 0.0625F;
            boolean flag = worldserver.getCollidingBoundingBoxes(playerEntity, playerEntity.boundingBox.copy().contract(f4, f4, f4)).isEmpty();

            if (playerEntity.onGround && !par1Packet10Flying.onGround && d12 > 0.0D)
            {
                playerEntity.addExhaustion(0.2F);
            }

            playerEntity.moveEntity(d11, d12, d13);
            playerEntity.onGround = par1Packet10Flying.onGround;
            playerEntity.addMovementStat(d11, d12, d13);
            double d18 = d12;
            d11 = d3 - playerEntity.posX;
            d12 = d5 - playerEntity.posY;

            if (d12 > -0.5D || d12 < 0.5D)
            {
                d12 = 0.0D;
            }

            d13 = d7 - playerEntity.posZ;
            d17 = d11 * d11 + d12 * d12 + d13 * d13;
            boolean flag1 = false;

            if (d17 > 0.0625D && !playerEntity.isPlayerSleeping() && !playerEntity.theItemInWorldManager.isCreative())
            {
                flag1 = true;
                logger.warning((new StringBuilder()).append(playerEntity.username).append(" moved wrongly!").toString());
            }

            playerEntity.setPositionAndRotation(d3, d5, d7, f2, f3);
            boolean flag2 = worldserver.getCollidingBoundingBoxes(playerEntity, playerEntity.boundingBox.copy().contract(f4, f4, f4)).isEmpty();

            if (flag && (flag1 || !flag2) && !playerEntity.isPlayerSleeping())
            {
                setPlayerLocation(lastPosX, lastPosY, lastPosZ, f2, f3);
                return;
            }

            AxisAlignedBB axisalignedbb = playerEntity.boundingBox.copy().expand(f4, f4, f4).addCoord(0.0D, -0.55000000000000004D, 0.0D);

            if (!mcServer.isFlightAllowed() && !playerEntity.theItemInWorldManager.isCreative() && !worldserver.isAABBNonEmpty(axisalignedbb))
            {
                if (d18 >= -0.03125D)
                {
                    ticksForFloatKick++;

                    if (ticksForFloatKick > 80)
                    {
                        logger.warning((new StringBuilder()).append(playerEntity.username).append(" was kicked for floating too long!").toString());
                        kickPlayerFromServer("Flying is not enabled on this server");
                        return;
                    }
                }
            }
            else
            {
                ticksForFloatKick = 0;
            }

            playerEntity.onGround = par1Packet10Flying.onGround;
            mcServer.getConfigurationManager().func_72358_d(playerEntity);
            playerEntity.updateFlyingState(playerEntity.posY - d1, par1Packet10Flying.onGround);
        }
    }

    public void setPlayerLocation(double par1, double par3, double par5, float par7, float par8)
    {
        field_72587_r = false;
        lastPosX = par1;
        lastPosY = par3;
        lastPosZ = par5;
        playerEntity.setPositionAndRotation(par1, par3, par5, par7, par8);
        playerEntity.serverForThisPlayer.sendPacketToPlayer(new Packet13PlayerLookMove(par1, par3 + 1.6200000047683716D, par3, par5, par7, par8, false));
    }

    public void handleBlockDig(Packet14BlockDig par1Packet14BlockDig)
    {
        WorldServer worldserver = mcServer.worldServerForDimension(playerEntity.dimension);

        if (par1Packet14BlockDig.status == 4)
        {
            playerEntity.dropOneItem();
            return;
        }

        if (par1Packet14BlockDig.status == 5)
        {
            playerEntity.stopUsingItem();
            return;
        }

        boolean flag = worldserver.actionsAllowed = worldserver.provider.worldType != 0 || mcServer.getConfigurationManager().areCommandsAllowed(playerEntity.username) || mcServer.isSinglePlayer();
        boolean flag1 = false;

        if (par1Packet14BlockDig.status == 0)
        {
            flag1 = true;
        }

        if (par1Packet14BlockDig.status == 2)
        {
            flag1 = true;
        }

        int i = par1Packet14BlockDig.xPosition;
        int j = par1Packet14BlockDig.yPosition;
        int k = par1Packet14BlockDig.zPosition;

        if (flag1)
        {
            double d = playerEntity.posX - ((double)i + 0.5D);
            double d1 = (playerEntity.posY - ((double)j + 0.5D)) + 1.5D;
            double d3 = playerEntity.posZ - ((double)k + 0.5D);
            double d5 = d * d + d1 * d1 + d3 * d3;

            if (d5 > 36D)
            {
                return;
            }

            if (j >= mcServer.getBuildLimit())
            {
                return;
            }
        }

        ChunkCoordinates chunkcoordinates = worldserver.getSpawnPoint();
        int l = MathHelper.abs_int(i - chunkcoordinates.posX);
        int i1 = MathHelper.abs_int(k - chunkcoordinates.posZ);

        if (l > i1)
        {
            i1 = l;
        }

        if (par1Packet14BlockDig.status == 0)
        {
            if (i1 > 16 || flag)
            {
                playerEntity.theItemInWorldManager.onBlockClicked(i, j, k, par1Packet14BlockDig.face);
            }
            else
            {
                playerEntity.serverForThisPlayer.sendPacketToPlayer(new Packet53BlockChange(i, j, k, worldserver));
            }
        }
        else if (par1Packet14BlockDig.status == 2)
        {
            playerEntity.theItemInWorldManager.uncheckedTryHarvestBlock(i, j, k);

            if (worldserver.getBlockId(i, j, k) != 0)
            {
                playerEntity.serverForThisPlayer.sendPacketToPlayer(new Packet53BlockChange(i, j, k, worldserver));
            }
        }
        else if (par1Packet14BlockDig.status == 1)
        {
            playerEntity.theItemInWorldManager.destroyBlockInWorldPartially(i, j, k);

            if (worldserver.getBlockId(i, j, k) != 0)
            {
                playerEntity.serverForThisPlayer.sendPacketToPlayer(new Packet53BlockChange(i, j, k, worldserver));
            }
        }
        else if (par1Packet14BlockDig.status == 3)
        {
            double d2 = playerEntity.posX - ((double)i + 0.5D);
            double d4 = playerEntity.posY - ((double)j + 0.5D);
            double d6 = playerEntity.posZ - ((double)k + 0.5D);
            double d7 = d2 * d2 + d4 * d4 + d6 * d6;

            if (d7 < 256D)
            {
                playerEntity.serverForThisPlayer.sendPacketToPlayer(new Packet53BlockChange(i, j, k, worldserver));
            }
        }

        worldserver.actionsAllowed = false;
    }

    public void handlePlace(Packet15Place par1Packet15Place)
    {
        WorldServer worldserver = mcServer.worldServerForDimension(playerEntity.dimension);
        ItemStack itemstack = playerEntity.inventory.getCurrentItem();
        boolean flag = false;
        int i = par1Packet15Place.getXPosition();
        int j = par1Packet15Place.getYPosition();
        int k = par1Packet15Place.getZPosition();
        int l = par1Packet15Place.getDirection();
        boolean flag1 = worldserver.actionsAllowed = worldserver.provider.worldType != 0 || mcServer.getConfigurationManager().areCommandsAllowed(playerEntity.username) || mcServer.isSinglePlayer();

        if (par1Packet15Place.getDirection() == 255)
        {
            if (itemstack == null)
            {
                return;
            }

            playerEntity.theItemInWorldManager.tryUseItem(playerEntity, worldserver, itemstack);
        }
        else if (par1Packet15Place.getYPosition() < mcServer.getBuildLimit() - 1 || par1Packet15Place.getDirection() != 1 && par1Packet15Place.getYPosition() < mcServer.getBuildLimit())
        {
            ChunkCoordinates chunkcoordinates = worldserver.getSpawnPoint();
            int i1 = MathHelper.abs_int(i - chunkcoordinates.posX);
            int j1 = MathHelper.abs_int(k - chunkcoordinates.posZ);

            if (i1 > j1)
            {
                j1 = i1;
            }

            if (field_72587_r && playerEntity.getDistanceSq((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D) < 64D && (j1 > 16 || flag1))
            {
                playerEntity.theItemInWorldManager.activateBlockOrUseItem(playerEntity, worldserver, itemstack, i, j, k, l, par1Packet15Place.getXOffset(), par1Packet15Place.getYOffset(), par1Packet15Place.getZOffset());
            }

            flag = true;
        }
        else
        {
            playerEntity.serverForThisPlayer.sendPacketToPlayer(new Packet3Chat((new StringBuilder()).append("\2477Height limit for building is ").append(mcServer.getBuildLimit()).toString()));
            flag = true;
        }

        if (flag)
        {
            playerEntity.serverForThisPlayer.sendPacketToPlayer(new Packet53BlockChange(i, j, k, worldserver));

            if (l == 0)
            {
                j--;
            }

            if (l == 1)
            {
                j++;
            }

            if (l == 2)
            {
                k--;
            }

            if (l == 3)
            {
                k++;
            }

            if (l == 4)
            {
                i--;
            }

            if (l == 5)
            {
                i++;
            }

            playerEntity.serverForThisPlayer.sendPacketToPlayer(new Packet53BlockChange(i, j, k, worldserver));
        }

        itemstack = playerEntity.inventory.getCurrentItem();

        if (itemstack != null && itemstack.stackSize == 0)
        {
            playerEntity.inventory.mainInventory[playerEntity.inventory.currentItem] = null;
            itemstack = null;
        }

        if (itemstack == null || itemstack.getMaxItemUseDuration() == 0)
        {
            playerEntity.playerInventoryBeingManipulated = true;
            playerEntity.inventory.mainInventory[playerEntity.inventory.currentItem] = ItemStack.copyItemStack(playerEntity.inventory.mainInventory[playerEntity.inventory.currentItem]);
            Slot slot = playerEntity.craftingInventory.getSlotFromInventory(playerEntity.inventory, playerEntity.inventory.currentItem);
            playerEntity.craftingInventory.updateCraftingResults();
            playerEntity.playerInventoryBeingManipulated = false;

            if (!ItemStack.areItemStacksEqual(playerEntity.inventory.getCurrentItem(), par1Packet15Place.getItemStack()))
            {
                sendPacketToPlayer(new Packet103SetSlot(playerEntity.craftingInventory.windowId, slot.slotNumber, playerEntity.inventory.getCurrentItem()));
            }
        }

        worldserver.actionsAllowed = false;
    }

    public void handleErrorMessage(String par1Str, Object par2ArrayOfObj[])
    {
        logger.info((new StringBuilder()).append(playerEntity.username).append(" lost connection: ").append(par1Str).toString());
        mcServer.getConfigurationManager().sendPacketToAllPlayers(new Packet3Chat((new StringBuilder()).append("\247e").append(playerEntity.username).append(" left the game.").toString()));
        mcServer.getConfigurationManager().func_72367_e(playerEntity);
        serverShuttingDown = true;

        if (mcServer.isSinglePlayer() && playerEntity.username.equals(mcServer.getServerOwner()))
        {
            logger.info("Stopping singleplayer server as player logged out");
            mcServer.setServerStopping();
        }
    }

    public void registerPacket(Packet par1Packet)
    {
        logger.warning((new StringBuilder()).append(getClass()).append(" wasn't prepared to deal with a ").append(par1Packet.getClass()).toString());
        kickPlayerFromServer("Protocol error, unexpected packet");
    }

    /**
     * addToSendQueue. if it is a chat packet, check before sending it
     */
    public void sendPacketToPlayer(Packet par1Packet)
    {
        if (par1Packet instanceof Packet3Chat)
        {
            Packet3Chat packet3chat = (Packet3Chat)par1Packet;
            int i = playerEntity.getChatVisibility();

            if (i == 2)
            {
                return;
            }

            if (i == 1 && !packet3chat.func_73475_d())
            {
                return;
            }
        }

        theNetworkManager.addToSendQueue(par1Packet);
    }

    public void handleBlockItemSwitch(Packet16BlockItemSwitch par1Packet16BlockItemSwitch)
    {
        if (par1Packet16BlockItemSwitch.id < 0 || par1Packet16BlockItemSwitch.id >= InventoryPlayer.func_70451_h())
        {
            logger.warning((new StringBuilder()).append(playerEntity.username).append(" tried to set an invalid carried item").toString());
            return;
        }
        else
        {
            playerEntity.inventory.currentItem = par1Packet16BlockItemSwitch.id;
            return;
        }
    }

    public void handleChat(Packet3Chat par1Packet3Chat)
    {
        ModLoader.serverChat(this, par1Packet3Chat.message);

        if (playerEntity.getChatVisibility() == 2)
        {
            sendPacketToPlayer(new Packet3Chat("Cannot send chat message."));
            return;
        }

        String s = par1Packet3Chat.message;

        if (s.length() > 100)
        {
            kickPlayerFromServer("Chat message too long");
            return;
        }

        s = s.trim();

        for (int i = 0; i < s.length(); i++)
        {
            if (!ChatAllowedCharacters.isAllowedCharacter(s.charAt(i)))
            {
                kickPlayerFromServer("Illegal characters in chat");
                return;
            }
        }

        if (s.startsWith("/"))
        {
            func_72566_d(s);
        }
        else
        {
            if (playerEntity.getChatVisibility() == 1)
            {
                sendPacketToPlayer(new Packet3Chat("Cannot send chat message."));
                return;
            }

            s = (new StringBuilder()).append("<").append(playerEntity.username).append("> ").append(s).toString();
            logger.info(s);
            mcServer.getConfigurationManager().sendPacketToAllPlayers(new Packet3Chat(s, false));
        }

        chatSpamThresholdCount += 20;

        if (chatSpamThresholdCount > 200 && !mcServer.getConfigurationManager().areCommandsAllowed(playerEntity.username))
        {
            kickPlayerFromServer("disconnect.spam");
        }
    }

    private void func_72566_d(String par1Str)
    {
        if (mcServer.getConfigurationManager().areCommandsAllowed(playerEntity.username) || "/seed".equals(par1Str))
        {
            logger.info((new StringBuilder()).append(playerEntity.username).append(" issued server command: ").append(par1Str).toString());
            mcServer.getCommandManager().executeCommand(playerEntity, par1Str);
        }
    }

    public void handleAnimation(Packet18Animation par1Packet18Animation)
    {
        if (par1Packet18Animation.animate == 1)
        {
            playerEntity.swingItem();
        }
    }

    /**
     * runs registerPacket on the given Packet19EntityAction
     */
    public void handleEntityAction(Packet19EntityAction par1Packet19EntityAction)
    {
        if (par1Packet19EntityAction.state == 1)
        {
            playerEntity.setSneaking(true);
        }
        else if (par1Packet19EntityAction.state == 2)
        {
            playerEntity.setSneaking(false);
        }
        else if (par1Packet19EntityAction.state == 4)
        {
            playerEntity.setSprinting(true);
        }
        else if (par1Packet19EntityAction.state == 5)
        {
            playerEntity.setSprinting(false);
        }
        else if (par1Packet19EntityAction.state == 3)
        {
            playerEntity.wakeUpPlayer(false, true, true);
            field_72587_r = false;
        }
    }

    public void handleKickDisconnect(Packet255KickDisconnect par1Packet255KickDisconnect)
    {
        theNetworkManager.networkShutdown("disconnect.quitting", new Object[0]);
    }

    /**
     * returns 0 for memoryMapped connections
     */
    public int packetSize()
    {
        return theNetworkManager.packetSize();
    }

    public void handleUseEntity(Packet7UseEntity par1Packet7UseEntity)
    {
        WorldServer worldserver = mcServer.worldServerForDimension(playerEntity.dimension);
        Entity entity = worldserver.getEntityByID(par1Packet7UseEntity.targetEntity);

        if (entity != null)
        {
            boolean flag = playerEntity.canEntityBeSeen(entity);
            double d = 36D;

            if (!flag)
            {
                d = 9D;
            }

            if (playerEntity.getDistanceSqToEntity(entity) < d)
            {
                if (par1Packet7UseEntity.isLeftClick == 0)
                {
                    playerEntity.interactWith(entity);
                }
                else if (par1Packet7UseEntity.isLeftClick == 1)
                {
                    playerEntity.attackTargetEntityWithCurrentItem(entity);
                }
            }
        }
    }

    public void handleClientCommand(Packet205ClientCommand par1Packet205ClientCommand)
    {
        if (par1Packet205ClientCommand.forceRespawn == 1)
        {
            if (playerEntity.playerHasConqueredTheEnd)
            {
                playerEntity = mcServer.getConfigurationManager().respawnPlayer(playerEntity, 0, true);
            }
            else if (playerEntity.getServerForPlayer().getWorldInfo().isHardcoreModeEnabled())
            {
                if (mcServer.isSinglePlayer() && playerEntity.username.equals(mcServer.getServerOwner()))
                {
                    playerEntity.serverForThisPlayer.kickPlayerFromServer("You have died. Game over, man, it's game over!");
                    mcServer.deleteWorldAndStopServer();
                }
                else
                {
                    BanEntry banentry = new BanEntry(playerEntity.username);
                    banentry.setBanReason("Death in Hardcore");
                    mcServer.getConfigurationManager().getBannedPlayers().put(banentry);
                    playerEntity.serverForThisPlayer.kickPlayerFromServer("You have died. Game over, man, it's game over!");
                }
            }
            else
            {
                if (playerEntity.getHealth() > 0)
                {
                    return;
                }

                playerEntity = mcServer.getConfigurationManager().respawnPlayer(playerEntity, 0, false);
            }
        }
    }

    /**
     * packet.processPacket is only called if this returns true
     */
    public boolean canProcessPackets()
    {
        return true;
    }

    /**
     * respawns the player
     */
    public void handleRespawn(Packet9Respawn packet9respawn)
    {
    }

    public void handleCloseWindow(Packet101CloseWindow par1Packet101CloseWindow)
    {
        playerEntity.closeInventory();
    }

    public void handleWindowClick(Packet102WindowClick par1Packet102WindowClick)
    {
        if (playerEntity.craftingInventory.windowId == par1Packet102WindowClick.window_Id && playerEntity.craftingInventory.isPlayerNotUsingContainer(playerEntity))
        {
            ItemStack itemstack = playerEntity.craftingInventory.slotClick(par1Packet102WindowClick.inventorySlot, par1Packet102WindowClick.mouseClick, par1Packet102WindowClick.holdingShift, playerEntity);

            if (ItemStack.areItemStacksEqual(par1Packet102WindowClick.itemStack, itemstack))
            {
                playerEntity.serverForThisPlayer.sendPacketToPlayer(new Packet106Transaction(par1Packet102WindowClick.window_Id, par1Packet102WindowClick.action, true));
                playerEntity.playerInventoryBeingManipulated = true;
                playerEntity.craftingInventory.updateCraftingResults();
                playerEntity.sendInventoryToPlayer();
                playerEntity.playerInventoryBeingManipulated = false;
            }
            else
            {
                field_72586_s.addKey(playerEntity.craftingInventory.windowId, Short.valueOf(par1Packet102WindowClick.action));
                playerEntity.serverForThisPlayer.sendPacketToPlayer(new Packet106Transaction(par1Packet102WindowClick.window_Id, par1Packet102WindowClick.action, false));
                playerEntity.craftingInventory.setPlayerIsPresent(playerEntity, false);
                ArrayList arraylist = new ArrayList();

                for (int i = 0; i < playerEntity.craftingInventory.inventorySlots.size(); i++)
                {
                    arraylist.add(((Slot)playerEntity.craftingInventory.inventorySlots.get(i)).getStack());
                }

                playerEntity.sendContainerAndContentsToPlayer(playerEntity.craftingInventory, arraylist);
            }
        }
    }

    public void handleEnchantItem(Packet108EnchantItem par1Packet108EnchantItem)
    {
        if (playerEntity.craftingInventory.windowId == par1Packet108EnchantItem.windowId && playerEntity.craftingInventory.isPlayerNotUsingContainer(playerEntity))
        {
            playerEntity.craftingInventory.enchantItem(playerEntity, par1Packet108EnchantItem.enchantment);
            playerEntity.craftingInventory.updateCraftingResults();
        }
    }

    /**
     * Handle a creative slot packet.
     */
    public void handleCreativeSetSlot(Packet107CreativeSetSlot par1Packet107CreativeSetSlot)
    {
        if (playerEntity.theItemInWorldManager.isCreative())
        {
            boolean flag = par1Packet107CreativeSetSlot.slot < 0;
            ItemStack itemstack = par1Packet107CreativeSetSlot.itemStack;
            boolean flag1 = par1Packet107CreativeSetSlot.slot >= 1 && par1Packet107CreativeSetSlot.slot < 36 + InventoryPlayer.func_70451_h();
            boolean flag2 = itemstack == null || itemstack.itemID < Item.itemsList.length && itemstack.itemID >= 0 && Item.itemsList[itemstack.itemID] != null;
            boolean flag3 = itemstack == null || itemstack.getItemDamage() >= 0 && itemstack.getItemDamage() >= 0 && itemstack.stackSize <= 64 && itemstack.stackSize > 0;

            if (flag1 && flag2 && flag3)
            {
                if (itemstack == null)
                {
                    playerEntity.inventorySlots.putStackInSlot(par1Packet107CreativeSetSlot.slot, null);
                }
                else
                {
                    playerEntity.inventorySlots.putStackInSlot(par1Packet107CreativeSetSlot.slot, itemstack);
                }

                playerEntity.inventorySlots.setPlayerIsPresent(playerEntity, true);
            }
            else if (flag && flag2 && flag3 && creativeItemCreationSpamThresholdTally < 200)
            {
                creativeItemCreationSpamThresholdTally += 20;
                EntityItem entityitem = playerEntity.dropPlayerItem(itemstack);

                if (entityitem != null)
                {
                    entityitem.func_70288_d();
                }
            }
        }
    }

    public void handleTransaction(Packet106Transaction par1Packet106Transaction)
    {
        Short short1 = (Short)field_72586_s.lookup(playerEntity.craftingInventory.windowId);

        if (short1 != null && par1Packet106Transaction.shortWindowId == short1.shortValue() && playerEntity.craftingInventory.windowId == par1Packet106Transaction.windowId && !playerEntity.craftingInventory.isPlayerNotUsingContainer(playerEntity))
        {
            playerEntity.craftingInventory.setPlayerIsPresent(playerEntity, true);
        }
    }

    /**
     * Updates Client side signs
     */
    public void handleUpdateSign(Packet130UpdateSign par1Packet130UpdateSign)
    {
        WorldServer worldserver = mcServer.worldServerForDimension(playerEntity.dimension);

        if (worldserver.blockExists(par1Packet130UpdateSign.xPosition, par1Packet130UpdateSign.yPosition, par1Packet130UpdateSign.zPosition))
        {
            TileEntity tileentity = worldserver.getBlockTileEntity(par1Packet130UpdateSign.xPosition, par1Packet130UpdateSign.yPosition, par1Packet130UpdateSign.zPosition);

            if (tileentity instanceof TileEntitySign)
            {
                TileEntitySign tileentitysign = (TileEntitySign)tileentity;

                if (!tileentitysign.isEditable())
                {
                    mcServer.logWarningMessage((new StringBuilder()).append("Player ").append(playerEntity.username).append(" just tried to change non-editable sign").toString());
                    return;
                }
            }

            for (int i = 0; i < 4; i++)
            {
                boolean flag = true;

                if (par1Packet130UpdateSign.signLines[i].length() > 15)
                {
                    flag = false;
                }
                else
                {
                    for (int l = 0; l < par1Packet130UpdateSign.signLines[i].length(); l++)
                    {
                        if (ChatAllowedCharacters.allowedCharacters.indexOf(par1Packet130UpdateSign.signLines[i].charAt(l)) < 0)
                        {
                            flag = false;
                        }
                    }
                }

                if (!flag)
                {
                    par1Packet130UpdateSign.signLines[i] = "!?";
                }
            }

            if (tileentity instanceof TileEntitySign)
            {
                int j = par1Packet130UpdateSign.xPosition;
                int k = par1Packet130UpdateSign.yPosition;
                int i1 = par1Packet130UpdateSign.zPosition;
                TileEntitySign tileentitysign1 = (TileEntitySign)tileentity;
                System.arraycopy(par1Packet130UpdateSign.signLines, 0, tileentitysign1.signText, 0, 4);
                tileentitysign1.onInventoryChanged();
                worldserver.markBlockNeedsUpdate(j, k, i1);
            }
        }
    }

    /**
     * Handle a keep alive packet.
     */
    public void handleKeepAlive(Packet0KeepAlive par1Packet0KeepAlive)
    {
        if (par1Packet0KeepAlive.randomId == keepAliveRandomID)
        {
            int i = (int)(System.nanoTime() / 0xf4240L - keepAliveTimeSent);
            playerEntity.field_71138_i = (playerEntity.field_71138_i * 3 + i) / 4;
        }
    }

    /**
     * determine if it is a server handler
     */
    public boolean isServerHandler()
    {
        return true;
    }

    /**
     * Handle a player abilities packet.
     */
    public void handlePlayerAbilities(Packet202PlayerAbilities par1Packet202PlayerAbilities)
    {
        playerEntity.capabilities.isFlying = par1Packet202PlayerAbilities.getIsFlying() && playerEntity.capabilities.allowFlying;
    }

    public void handleAutoComplete(Packet203AutoComplete par1Packet203AutoComplete)
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s;

        for (Iterator iterator = mcServer.getPossibleCompletions(playerEntity, par1Packet203AutoComplete.func_73473_d()).iterator(); iterator.hasNext(); stringbuilder.append(s))
        {
            s = (String)iterator.next();

            if (stringbuilder.length() > 0)
            {
                stringbuilder.append("\0");
            }
        }

        playerEntity.serverForThisPlayer.sendPacketToPlayer(new Packet203AutoComplete(stringbuilder.toString()));
    }

    public void handleClientInfo(Packet204ClientInfo par1Packet204ClientInfo)
    {
        playerEntity.updateClientInfo(par1Packet204ClientInfo);
    }

    public void handleCustomPayload(Packet250CustomPayload par1Packet250CustomPayload)
    {
        if ("MC|BEdit".equals(par1Packet250CustomPayload.channel))
        {
            try
            {
                DataInputStream datainputstream = new DataInputStream(new ByteArrayInputStream(par1Packet250CustomPayload.data));
                ItemStack itemstack = Packet.readItemStack(datainputstream);

                if (!ItemWritableBook.validBookTagPages(itemstack.getTagCompound()))
                {
                    throw new IOException("Invalid book tag!");
                }

                ItemStack itemstack2 = playerEntity.inventory.getCurrentItem();

                if (itemstack != null && itemstack.itemID == Item.writableBook.shiftedIndex && itemstack.itemID == itemstack2.itemID)
                {
                    itemstack2.setTagCompound(itemstack.getTagCompound());
                }
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
        else if ("MC|BSign".equals(par1Packet250CustomPayload.channel))
        {
            try
            {
                DataInputStream datainputstream1 = new DataInputStream(new ByteArrayInputStream(par1Packet250CustomPayload.data));
                ItemStack itemstack1 = Packet.readItemStack(datainputstream1);

                if (!ItemEditableBook.validBookTagContents(itemstack1.getTagCompound()))
                {
                    throw new IOException("Invalid book tag!");
                }

                ItemStack itemstack3 = playerEntity.inventory.getCurrentItem();

                if (itemstack1 != null && itemstack1.itemID == Item.writtenBook.shiftedIndex && itemstack3.itemID == Item.writableBook.shiftedIndex)
                {
                    itemstack3.setTagCompound(itemstack1.getTagCompound());
                    itemstack3.itemID = Item.writtenBook.shiftedIndex;
                }
            }
            catch (Exception exception1)
            {
                exception1.printStackTrace();
            }
        }
        else if ("MC|TrSel".equals(par1Packet250CustomPayload.channel))
        {
            try
            {
                DataInputStream datainputstream2 = new DataInputStream(new ByteArrayInputStream(par1Packet250CustomPayload.data));
                int i = datainputstream2.readInt();
                Container container = playerEntity.craftingInventory;

                if (container instanceof ContainerMerchant)
                {
                    ((ContainerMerchant)container).setCurrentRecipeIndex(i);
                }
            }
            catch (Exception exception2)
            {
                exception2.printStackTrace();
            }
        }
        else
        {
            ModLoader.serverCustomPayload(this, par1Packet250CustomPayload);
        }
    }
}
