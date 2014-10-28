package net.minecraft.src;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;
import net.minecraft.server.MinecraftServer;

public class NetServerHandler extends NetHandler
{
    /** The logging system. */
    public static Logger logger = Logger.getLogger("Minecraft");

    /** The underlying network manager for this server handler. */
    public NetworkManager netManager;

    /** This is set to true whenever a player disconnects from the server */
    public boolean connectionClosed;

    /** Reference to the MinecraftServer object. */
    private MinecraftServer mcServer;

    /** Reference to the EntityPlayerMP object. */
    private EntityPlayerMP playerEntity;
    private int field_72571_f;

    /** holds the amount of tick the player is floating */
    private int playerInAirTime;
    private boolean field_72584_h;
    private int field_72585_i;
    private long field_72582_j;

    /** The Java Random object. */
    private static Random rndmObj = new Random();
    private long field_72580_l;
    private int field_72581_m;
    private int field_72578_n;

    /** The last known x position for this connection. */
    private double lastPosX;

    /** The last known y position for this connection. */
    private double lastPosY;

    /** The last known z position for this connection. */
    private double lastPosZ;

    /** is true when the player has moved since his last movement packet */
    private boolean hasMoved;
    private IntHashMap field_72586_s;

    public NetServerHandler(MinecraftServer par1MinecraftServer, NetworkManager par2NetworkManager, EntityPlayerMP par3EntityPlayerMP)
    {
        connectionClosed = false;
        field_72581_m = 0;
        field_72578_n = 0;
        hasMoved = true;
        field_72586_s = new IntHashMap();
        mcServer = par1MinecraftServer;
        netManager = par2NetworkManager;
        par2NetworkManager.setNetHandler(this);
        playerEntity = par3EntityPlayerMP;
        par3EntityPlayerMP.playerNetServerHandler = this;
    }

    /**
     * handle all the packets for the connection
     */
    public void handlePackets()
    {
        field_72584_h = false;
        field_72571_f++;
        mcServer.field_71304_b.startSection("packetflow");
        netManager.processReadPackets();
        mcServer.field_71304_b.endStartSection("keepAlive");

        if ((long)field_72571_f - field_72580_l > 20L)
        {
            field_72580_l = field_72571_f;
            field_72582_j = System.nanoTime() / 0xf4240L;
            field_72585_i = rndmObj.nextInt();
            sendPacket(new Packet0KeepAlive(field_72585_i));
        }

        if (field_72581_m > 0)
        {
            field_72581_m--;
        }

        if (field_72578_n > 0)
        {
            field_72578_n--;
        }

        mcServer.field_71304_b.endStartSection("playerTick");

        if (!field_72584_h && !playerEntity.gameOver)
        {
            playerEntity.func_71127_g();
        }

        mcServer.field_71304_b.endSection();
    }

    /**
     * Kick the offending player and give a reason why
     */
    public void kickPlayer(String par1Str)
    {
        if (!connectionClosed)
        {
            playerEntity.func_71123_m();
            sendPacket(new Packet255KickDisconnect(par1Str));
            netManager.serverShutdown();
            mcServer.func_71203_ab().sendPacketToAllPlayers(new Packet3Chat((new StringBuilder()).append("\247e").append(playerEntity.username).append(" left the game.").toString()));
            mcServer.func_71203_ab().playerLoggedOut(playerEntity);
            connectionClosed = true;
        }
    }

    public void handleFlying(Packet10Flying par1Packet10Flying)
    {
        WorldServer worldserver = mcServer.getWorldManager(playerEntity.dimension);
        field_72584_h = true;

        if (!playerEntity.gameOver)
        {
            if (!hasMoved)
            {
                double d = par1Packet10Flying.yPosition - lastPosY;

                if (par1Packet10Flying.xPosition == lastPosX && d * d < 0.01D && par1Packet10Flying.zPosition == lastPosZ)
                {
                    hasMoved = true;
                }
            }

            if (hasMoved)
            {
                if (playerEntity.ridingEntity != null)
                {
                    float f = playerEntity.rotationYaw;
                    float f2 = playerEntity.rotationPitch;
                    playerEntity.ridingEntity.updateRiderPosition();
                    double d2 = playerEntity.posX;
                    double d4 = playerEntity.posY;
                    double d6 = playerEntity.posZ;
                    double d11 = 0.0D;
                    double d8 = 0.0D;

                    if (par1Packet10Flying.rotating)
                    {
                        f = par1Packet10Flying.yaw;
                        f2 = par1Packet10Flying.pitch;
                    }

                    if (par1Packet10Flying.moving && par1Packet10Flying.yPosition == -999D && par1Packet10Flying.stance == -999D)
                    {
                        if (par1Packet10Flying.xPosition > 1.0D || par1Packet10Flying.zPosition > 1.0D)
                        {
                            System.err.println((new StringBuilder()).append(playerEntity.username).append(" was caught trying to crash the server with an invalid position.").toString());
                            kickPlayer("Nope!");
                            return;
                        }

                        d11 = par1Packet10Flying.xPosition;
                        d8 = par1Packet10Flying.zPosition;
                    }

                    playerEntity.onGround = par1Packet10Flying.onGround;
                    playerEntity.func_71127_g();
                    playerEntity.moveEntity(d11, 0.0D, d8);
                    playerEntity.setPositionAndRotation(d2, d4, d6, f, f2);
                    playerEntity.motionX = d11;
                    playerEntity.motionZ = d8;

                    if (playerEntity.ridingEntity != null)
                    {
                        worldserver.func_73050_b(playerEntity.ridingEntity, true);
                    }

                    if (playerEntity.ridingEntity != null)
                    {
                        playerEntity.ridingEntity.updateRiderPosition();
                    }

                    mcServer.func_71203_ab().serverUpdateMountedMovingPlayer(playerEntity);
                    lastPosX = playerEntity.posX;
                    lastPosY = playerEntity.posY;
                    lastPosZ = playerEntity.posZ;
                    worldserver.updateEntity(playerEntity);
                    return;
                }

                if (playerEntity.isPlayerSleeping())
                {
                    playerEntity.func_71127_g();
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
                float f1 = playerEntity.rotationYaw;
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
                    double d9 = par1Packet10Flying.stance - par1Packet10Flying.yPosition;

                    if (!playerEntity.isPlayerSleeping() && (d9 > 1.6499999999999999D || d9 < 0.10000000000000001D))
                    {
                        kickPlayer("Illegal stance");
                        logger.warning((new StringBuilder()).append(playerEntity.username).append(" had an illegal stance: ").append(d9).toString());
                        return;
                    }

                    if (Math.abs(par1Packet10Flying.xPosition) > 32000000D || Math.abs(par1Packet10Flying.zPosition) > 32000000D)
                    {
                        kickPlayer("Illegal position");
                        return;
                    }
                }

                if (par1Packet10Flying.rotating)
                {
                    f1 = par1Packet10Flying.yaw;
                    f3 = par1Packet10Flying.pitch;
                }

                playerEntity.func_71127_g();
                playerEntity.ySize = 0.0F;
                playerEntity.setPositionAndRotation(lastPosX, lastPosY, lastPosZ, f1, f3);

                if (!hasMoved)
                {
                    return;
                }

                double d10 = d3 - playerEntity.posX;
                double d12 = d5 - playerEntity.posY;
                double d13 = d7 - playerEntity.posZ;
                double d14 = Math.min(Math.abs(d10), Math.abs(playerEntity.motionX));
                double d15 = Math.min(Math.abs(d12), Math.abs(playerEntity.motionY));
                double d16 = Math.min(Math.abs(d13), Math.abs(playerEntity.motionZ));
                double d17 = d14 * d14 + d15 * d15 + d16 * d16;

                if (d17 > 100D && (!mcServer.func_71264_H() || !mcServer.getServerOwner().equals(playerEntity.username)))
                {
                    logger.warning((new StringBuilder()).append(playerEntity.username).append(" moved too quickly! ").append(d10).append(",").append(d12).append(",").append(d13).append(" (").append(d14).append(", ").append(d15).append(", ").append(d16).append(")").toString());
                    teleportTo(lastPosX, lastPosY, lastPosZ, playerEntity.rotationYaw, playerEntity.rotationPitch);
                    return;
                }

                float f4 = 0.0625F;
                boolean flag = worldserver.getCollidingBoundingBoxes(playerEntity, playerEntity.boundingBox.copy().contract(f4, f4, f4)).isEmpty();

                if (playerEntity.onGround && !par1Packet10Flying.onGround && d12 > 0.0D)
                {
                    playerEntity.addExhaustion(0.2F);
                }

                playerEntity.moveEntity(d10, d12, d13);
                playerEntity.onGround = par1Packet10Flying.onGround;
                playerEntity.addMovementStat(d10, d12, d13);
                double d18 = d12;
                d10 = d3 - playerEntity.posX;
                d12 = d5 - playerEntity.posY;

                if (d12 > -0.5D || d12 < 0.5D)
                {
                    d12 = 0.0D;
                }

                d13 = d7 - playerEntity.posZ;
                d17 = d10 * d10 + d12 * d12 + d13 * d13;
                boolean flag1 = false;

                if (d17 > 0.0625D && !playerEntity.isPlayerSleeping() && !playerEntity.theItemInWorldManager.isCreative())
                {
                    flag1 = true;
                    logger.warning((new StringBuilder()).append(playerEntity.username).append(" moved wrongly!").toString());
                }

                playerEntity.setPositionAndRotation(d3, d5, d7, f1, f3);
                boolean flag2 = worldserver.getCollidingBoundingBoxes(playerEntity, playerEntity.boundingBox.copy().contract(f4, f4, f4)).isEmpty();

                if (flag && (flag1 || !flag2) && !playerEntity.isPlayerSleeping())
                {
                    teleportTo(lastPosX, lastPosY, lastPosZ, f1, f3);
                    return;
                }

                AxisAlignedBB axisalignedbb = playerEntity.boundingBox.copy().expand(f4, f4, f4).addCoord(0.0D, -0.55000000000000004D, 0.0D);

                if (!mcServer.func_71231_X() && !playerEntity.theItemInWorldManager.isCreative() && !worldserver.isAABBNonEmpty(axisalignedbb))
                {
                    if (d18 >= -0.03125D)
                    {
                        playerInAirTime++;

                        if (playerInAirTime > 80)
                        {
                            logger.warning((new StringBuilder()).append(playerEntity.username).append(" was kicked for floating too long!").toString());
                            kickPlayer("Flying is not enabled on this server");
                            return;
                        }
                    }
                }
                else
                {
                    playerInAirTime = 0;
                }

                playerEntity.onGround = par1Packet10Flying.onGround;
                mcServer.func_71203_ab().serverUpdateMountedMovingPlayer(playerEntity);
                playerEntity.handleFalling(playerEntity.posY - d1, par1Packet10Flying.onGround);
            }
        }
    }

    /**
     * Teleports the player to the specified destination and rotation
     */
    public void teleportTo(double par1, double par3, double par5, float par7, float par8)
    {
        hasMoved = false;
        lastPosX = par1;
        lastPosY = par3;
        lastPosZ = par5;
        playerEntity.setPositionAndRotation(par1, par3, par5, par7, par8);
        playerEntity.playerNetServerHandler.sendPacket(new Packet13PlayerLookMove(par1, par3 + 1.6200000047683716D, par3, par5, par7, par8, false));
    }

    public void handleBlockDig(Packet14BlockDig par1Packet14BlockDig)
    {
        WorldServer worldserver = mcServer.getWorldManager(playerEntity.dimension);

        if (par1Packet14BlockDig.status == 4)
        {
            playerEntity.dropOneItem();
        }
        else if (par1Packet14BlockDig.status == 5)
        {
            playerEntity.stopUsingItem();
        }
        else
        {
            boolean flag = worldserver.disableSpawnProtection = worldserver.provider.worldType != 0 || mcServer.func_71203_ab().isOp(playerEntity.username) || mcServer.func_71264_H();
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

                if (j >= mcServer.func_71207_Z())
                {
                    return;
                }
            }

            ChunkCoordinates chunkcoordinates = worldserver.getSpawnPoint();
            int l = MathHelper.abs(i - chunkcoordinates.posX);
            int i1 = MathHelper.abs(k - chunkcoordinates.posZ);

            if (l > i1)
            {
                i1 = l;
            }

            if (par1Packet14BlockDig.status == 0)
            {
                if (i1 <= 16 && !flag)
                {
                    playerEntity.playerNetServerHandler.sendPacket(new Packet53BlockChange(i, j, k, worldserver));
                }
                else
                {
                    playerEntity.theItemInWorldManager.blockClicked(i, j, k, par1Packet14BlockDig.face);
                }
            }
            else if (par1Packet14BlockDig.status == 2)
            {
                playerEntity.theItemInWorldManager.blockRemoving(i, j, k);

                if (worldserver.getBlockId(i, j, k) != 0)
                {
                    playerEntity.playerNetServerHandler.sendPacket(new Packet53BlockChange(i, j, k, worldserver));
                }
            }
            else if (par1Packet14BlockDig.status == 1)
            {
                playerEntity.theItemInWorldManager.func_73073_c(i, j, k);

                if (worldserver.getBlockId(i, j, k) != 0)
                {
                    playerEntity.playerNetServerHandler.sendPacket(new Packet53BlockChange(i, j, k, worldserver));
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
                    playerEntity.playerNetServerHandler.sendPacket(new Packet53BlockChange(i, j, k, worldserver));
                }
            }

            worldserver.disableSpawnProtection = false;
        }
    }

    public void handlePlace(Packet15Place par1Packet15Place)
    {
        WorldServer worldserver = mcServer.getWorldManager(playerEntity.dimension);
        ItemStack itemstack = playerEntity.inventory.getCurrentItem();
        boolean flag = false;
        int i = par1Packet15Place.getXPosition();
        int j = par1Packet15Place.getYPosition();
        int k = par1Packet15Place.getZPosition();
        int l = par1Packet15Place.getDirection();
        boolean flag1 = worldserver.disableSpawnProtection = worldserver.provider.worldType != 0 || mcServer.func_71203_ab().isOp(playerEntity.username) || mcServer.func_71264_H();

        if (par1Packet15Place.getDirection() == 255)
        {
            if (itemstack == null)
            {
                return;
            }

            playerEntity.theItemInWorldManager.tryUseItem(playerEntity, worldserver, itemstack);
        }
        else if (par1Packet15Place.getYPosition() >= mcServer.func_71207_Z() - 1 && (par1Packet15Place.getDirection() == 1 || par1Packet15Place.getYPosition() >= mcServer.func_71207_Z()))
        {
            playerEntity.playerNetServerHandler.sendPacket(new Packet3Chat((new StringBuilder()).append("\2477Height limit for building is ").append(mcServer.func_71207_Z()).toString()));
            flag = true;
        }
        else
        {
            ChunkCoordinates chunkcoordinates = worldserver.getSpawnPoint();
            int i1 = MathHelper.abs(i - chunkcoordinates.posX);
            int j1 = MathHelper.abs(k - chunkcoordinates.posZ);

            if (i1 > j1)
            {
                j1 = i1;
            }

            if (hasMoved && playerEntity.getDistanceSq((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D) < 64D && (j1 > 16 || flag1))
            {
                playerEntity.theItemInWorldManager.activateBlockOrUseItem(playerEntity, worldserver, itemstack, i, j, k, l, par1Packet15Place.getXOffset(), par1Packet15Place.getYOffset(), par1Packet15Place.getZOffset());
            }

            flag = true;
        }

        if (flag)
        {
            playerEntity.playerNetServerHandler.sendPacket(new Packet53BlockChange(i, j, k, worldserver));

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

            playerEntity.playerNetServerHandler.sendPacket(new Packet53BlockChange(i, j, k, worldserver));
        }

        itemstack = playerEntity.inventory.getCurrentItem();

        if (itemstack != null && itemstack.stackSize == 0)
        {
            playerEntity.inventory.mainInventory[playerEntity.inventory.currentItem] = null;
            itemstack = null;
        }

        if (itemstack == null || itemstack.getMaxItemUseDuration() == 0)
        {
            playerEntity.isChangingQuantityOnly = true;
            playerEntity.inventory.mainInventory[playerEntity.inventory.currentItem] = ItemStack.copyItemStack(playerEntity.inventory.mainInventory[playerEntity.inventory.currentItem]);
            Slot slot = playerEntity.craftingInventory.func_75147_a(playerEntity.inventory, playerEntity.inventory.currentItem);
            playerEntity.craftingInventory.updateCraftingResults();
            playerEntity.isChangingQuantityOnly = false;

            if (!ItemStack.areItemStacksEqual(playerEntity.inventory.getCurrentItem(), par1Packet15Place.getItemStack()))
            {
                sendPacket(new Packet103SetSlot(playerEntity.craftingInventory.windowId, slot.slotNumber, playerEntity.inventory.getCurrentItem()));
            }
        }

        worldserver.disableSpawnProtection = false;
    }

    public void handleErrorMessage(String par1Str, Object par2ArrayOfObj[])
    {
        logger.info((new StringBuilder()).append(playerEntity.username).append(" lost connection: ").append(par1Str).toString());
        mcServer.func_71203_ab().sendPacketToAllPlayers(new Packet3Chat((new StringBuilder()).append("\247e").append(playerEntity.username).append(" left the game.").toString()));
        mcServer.func_71203_ab().playerLoggedOut(playerEntity);
        connectionClosed = true;

        if (mcServer.func_71264_H() && playerEntity.username.equals(mcServer.getServerOwner()))
        {
            logger.info("Stopping singleplayer server as player logged out");
            mcServer.initiateShutdown();
        }
    }

    public void registerPacket(Packet par1Packet)
    {
        logger.warning((new StringBuilder()).append(getClass()).append(" wasn't prepared to deal with a ").append(par1Packet.getClass()).toString());
        kickPlayer("Protocol error, unexpected packet");
    }

    /**
     * Adds the packet to the underlying network manager's send queue.
     */
    public void sendPacket(Packet par1Packet)
    {
        if (par1Packet instanceof Packet3Chat)
        {
            Packet3Chat packet3chat = (Packet3Chat)par1Packet;
            int i = playerEntity.func_71126_v();

            if (i == 2)
            {
                return;
            }

            if (i == 1 && !packet3chat.func_73475_d())
            {
                return;
            }
        }

        netManager.addToSendQueue(par1Packet);
    }

    public void handleBlockItemSwitch(Packet16BlockItemSwitch par1Packet16BlockItemSwitch)
    {
        if (par1Packet16BlockItemSwitch.id >= 0 && par1Packet16BlockItemSwitch.id < InventoryPlayer.func_70451_h())
        {
            playerEntity.inventory.currentItem = par1Packet16BlockItemSwitch.id;
        }
        else
        {
            logger.warning((new StringBuilder()).append(playerEntity.username).append(" tried to set an invalid carried item").toString());
        }
    }

    public void handleChat(Packet3Chat par1Packet3Chat)
    {
        ModLoader.serverChat(this, par1Packet3Chat.message);

        if (playerEntity.func_71126_v() == 2)
        {
            sendPacket(new Packet3Chat("Cannot send chat message."));
        }
        else
        {
            String s = par1Packet3Chat.message;

            if (s.length() > 100)
            {
                kickPlayer("Chat message too long");
            }
            else
            {
                s = s.trim();

                for (int i = 0; i < s.length(); i++)
                {
                    if (!ChatAllowedCharacters.isAllowedCharacter(s.charAt(i)))
                    {
                        kickPlayer("Illegal characters in chat");
                        return;
                    }
                }

                if (s.startsWith("/"))
                {
                    handleSlashCommand(s);
                }
                else
                {
                    if (playerEntity.func_71126_v() == 1)
                    {
                        sendPacket(new Packet3Chat("Cannot send chat message."));
                        return;
                    }

                    s = (new StringBuilder()).append("<").append(playerEntity.username).append("> ").append(s).toString();
                    logger.info(s);
                    mcServer.func_71203_ab().sendPacketToAllPlayers(new Packet3Chat(s, false));
                }

                field_72581_m += 20;

                if (field_72581_m > 200 && !mcServer.func_71203_ab().isOp(playerEntity.username))
                {
                    kickPlayer("disconnect.spam");
                }
            }
        }
    }

    /**
     * Processes a / command
     */
    private void handleSlashCommand(String par1Str)
    {
        if (ModLoaderMp.handleCommand(par1Str.substring(1), playerEntity.username, logger, mcServer.serverConfigManager.isOp(playerEntity.username)))
        {
            logger.info((new StringBuilder()).append("ModLoaderMP : ").append(playerEntity.username).append(" issued command: ").append(par1Str.substring(1)).toString());
        }
        else if (mcServer.func_71203_ab().isOp(playerEntity.username) || "/seed".equals(par1Str))
        {
            logger.info((new StringBuilder()).append(playerEntity.username).append(" issued server command: ").append(par1Str).toString());
            mcServer.func_71187_D().func_71556_a(playerEntity, par1Str);
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
            hasMoved = false;
        }
    }

    public void handleKickDisconnect(Packet255KickDisconnect par1Packet255KickDisconnect)
    {
        netManager.networkShutdown("disconnect.quitting", new Object[0]);
    }

    /**
     * return the number of chuckDataPackets from the netManager
     */
    public int getNumChunkDataPackets()
    {
        return netManager.getNumChunkDataPackets();
    }

    public void handleUseEntity(Packet7UseEntity par1Packet7UseEntity)
    {
        WorldServer worldserver = mcServer.getWorldManager(playerEntity.dimension);
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
                    playerEntity.func_70998_m(entity);
                }
                else if (par1Packet7UseEntity.isLeftClick == 1)
                {
                    playerEntity.attackTargetEntityWithCurrentItem(entity);
                }
            }
        }
    }

    public void func_72458_a(Packet205ClientCommand par1Packet205ClientCommand)
    {
        if (par1Packet205ClientCommand.field_73447_a == 1)
        {
            if (playerEntity.gameOver)
            {
                playerEntity = mcServer.func_71203_ab().recreatePlayerEntity(playerEntity, 0, true);
            }
            else if (playerEntity.func_71121_q().getWorldInfo().isHardcoreModeEnabled())
            {
                if (mcServer.func_71264_H() && playerEntity.username.equals(mcServer.getServerOwner()))
                {
                    playerEntity.playerNetServerHandler.kickPlayer("You have died. Game over, man, it's game over!");
                    mcServer.func_71272_O();
                }
                else
                {
                    BanEntry banentry = new BanEntry(playerEntity.username);
                    banentry.func_73689_b("Death in Hardcore");
                    mcServer.func_71203_ab().func_72390_e().func_73706_a(banentry);
                    playerEntity.playerNetServerHandler.kickPlayer("You have died. Game over, man, it's game over!");
                }
            }
            else
            {
                if (playerEntity.getHealth() > 0)
                {
                    return;
                }

                playerEntity = mcServer.func_71203_ab().recreatePlayerEntity(playerEntity, 0, false);
            }
        }
    }

    public boolean func_72469_b()
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
        playerEntity.closeCraftingGui();
    }

    public void handleWindowClick(Packet102WindowClick par1Packet102WindowClick)
    {
        if (playerEntity.craftingInventory.windowId == par1Packet102WindowClick.window_Id && playerEntity.craftingInventory.getCanCraft(playerEntity))
        {
            ItemStack itemstack = playerEntity.craftingInventory.slotClick(par1Packet102WindowClick.inventorySlot, par1Packet102WindowClick.mouseClick, par1Packet102WindowClick.holdingShift, playerEntity);

            if (ItemStack.areItemStacksEqual(par1Packet102WindowClick.itemStack, itemstack))
            {
                playerEntity.playerNetServerHandler.sendPacket(new Packet106Transaction(par1Packet102WindowClick.window_Id, par1Packet102WindowClick.action, true));
                playerEntity.isChangingQuantityOnly = true;
                playerEntity.craftingInventory.updateCraftingResults();
                playerEntity.updateHeldItem();
                playerEntity.isChangingQuantityOnly = false;
            }
            else
            {
                field_72586_s.addKey(playerEntity.craftingInventory.windowId, Short.valueOf(par1Packet102WindowClick.action));
                playerEntity.playerNetServerHandler.sendPacket(new Packet106Transaction(par1Packet102WindowClick.window_Id, par1Packet102WindowClick.action, false));
                playerEntity.craftingInventory.setCanCraft(playerEntity, false);
                ArrayList arraylist = new ArrayList();

                for (int i = 0; i < playerEntity.craftingInventory.inventorySlots.size(); i++)
                {
                    arraylist.add(((Slot)playerEntity.craftingInventory.inventorySlots.get(i)).getStack());
                }

                playerEntity.updateCraftingInventory(playerEntity.craftingInventory, arraylist);
            }
        }
    }

    public void handleEnchantItem(Packet108EnchantItem par1Packet108EnchantItem)
    {
        if (playerEntity.craftingInventory.windowId == par1Packet108EnchantItem.windowId && playerEntity.craftingInventory.getCanCraft(playerEntity))
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
                    playerEntity.inventorySlots.putStackInSlot(par1Packet107CreativeSetSlot.slot, (ItemStack)null);
                }
                else
                {
                    playerEntity.inventorySlots.putStackInSlot(par1Packet107CreativeSetSlot.slot, itemstack);
                }

                playerEntity.inventorySlots.setCanCraft(playerEntity, true);
            }
            else if (flag && flag2 && flag3 && field_72578_n < 200)
            {
                field_72578_n += 20;
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

        if (short1 != null && par1Packet106Transaction.shortWindowId == short1.shortValue() && playerEntity.craftingInventory.windowId == par1Packet106Transaction.windowId && !playerEntity.craftingInventory.getCanCraft(playerEntity))
        {
            playerEntity.craftingInventory.setCanCraft(playerEntity, true);
        }
    }

    /**
     * Updates Client side signs
     */
    public void handleUpdateSign(Packet130UpdateSign par1Packet130UpdateSign)
    {
        WorldServer worldserver = mcServer.getWorldManager(playerEntity.dimension);

        if (worldserver.blockExists(par1Packet130UpdateSign.xPosition, par1Packet130UpdateSign.yPosition, par1Packet130UpdateSign.zPosition))
        {
            TileEntity tileentity = worldserver.getBlockTileEntity(par1Packet130UpdateSign.xPosition, par1Packet130UpdateSign.yPosition, par1Packet130UpdateSign.zPosition);

            if (tileentity instanceof TileEntitySign)
            {
                TileEntitySign tileentitysign = (TileEntitySign)tileentity;

                if (!tileentitysign.isEditable())
                {
                    mcServer.logWarning((new StringBuilder()).append("Player ").append(playerEntity.username).append(" just tried to change non-editable sign").toString());
                    return;
                }
            }

            for (int k = 0; k < 4; k++)
            {
                boolean flag = true;

                if (par1Packet130UpdateSign.signLines[k].length() > 15)
                {
                    flag = false;
                }
                else
                {
                    for (int i = 0; i < par1Packet130UpdateSign.signLines[k].length(); i++)
                    {
                        if (ChatAllowedCharacters.allowedCharacters.indexOf(par1Packet130UpdateSign.signLines[k].charAt(i)) < 0)
                        {
                            flag = false;
                        }
                    }
                }

                if (!flag)
                {
                    par1Packet130UpdateSign.signLines[k] = "!?";
                }
            }

            if (tileentity instanceof TileEntitySign)
            {
                int l = par1Packet130UpdateSign.xPosition;
                int i1 = par1Packet130UpdateSign.yPosition;
                int j = par1Packet130UpdateSign.zPosition;
                TileEntitySign tileentitysign1 = (TileEntitySign)tileentity;
                System.arraycopy(par1Packet130UpdateSign.signLines, 0, tileentitysign1.signText, 0, 4);
                tileentitysign1.onInventoryChanged();
                worldserver.markBlockNeedsUpdate(l, i1, j);
            }
        }
    }

    /**
     * Handle a keep alive packet.
     */
    public void handleKeepAlive(Packet0KeepAlive par1Packet0KeepAlive)
    {
        if (par1Packet0KeepAlive.randomId == field_72585_i)
        {
            int i = (int)(System.nanoTime() / 0xf4240L - field_72582_j);
            playerEntity.ping = (playerEntity.ping * 3 + i) / 4;
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
        playerEntity.capabilities.isFlying = par1Packet202PlayerAbilities.func_73350_f() && playerEntity.capabilities.allowFlying;
    }

    public void func_72461_a(Packet203AutoComplete par1Packet203AutoComplete)
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s;

        for (Iterator iterator = mcServer.func_71248_a(playerEntity, par1Packet203AutoComplete.func_73473_d()).iterator(); iterator.hasNext(); stringbuilder.append(s))
        {
            s = (String)iterator.next();

            if (stringbuilder.length() > 0)
            {
                stringbuilder.append("\0");
            }
        }

        playerEntity.playerNetServerHandler.sendPacket(new Packet203AutoComplete(stringbuilder.toString()));
    }

    public void func_72504_a(Packet204ClientInfo par1Packet204ClientInfo)
    {
        playerEntity.func_71125_a(par1Packet204ClientInfo);
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

                if (itemstack1 != null && itemstack1.itemID == Item.field_77823_bG.shiftedIndex && itemstack3.itemID == Item.writableBook.shiftedIndex)
                {
                    itemstack3.setTagCompound(itemstack1.getTagCompound());
                    itemstack3.itemID = Item.field_77823_bG.shiftedIndex;
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
                    ((ContainerMerchant)container).func_75175_c(i);
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
