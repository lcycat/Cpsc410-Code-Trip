package net.minecraft.src;

import java.io.PrintStream;
import java.util.*;

public class EntityTrackerEntry
{
    public Entity myEntity;
    public int BlocksDistanceThreshold;

    /** check for sync when ticks % updateFrequency==0 */
    public int updateFrequency;
    public int lastScaledXPosition;
    public int lastScaledYPosition;
    public int lastScaledZPosition;
    public int lastYaw;
    public int lastPitch;
    public int lastHeadMotion;
    public double motionX;
    public double motionY;
    public double motionZ;
    public int ticks;
    private double posX;
    private double posY;
    private double posZ;

    /** set to true on first sendLocationToClients */
    private boolean isDataInitialized;
    private boolean trackMotion;

    /**
     * every 400 ticks a  full teleport packet is sent, rather than just a "move me +x" command, so that position
     * remains fully synced.
     */
    private int ticksSinceLastForcedTeleport;
    private Entity ridingEntity;
    public boolean field_73133_n;
    public Set field_73134_o;

    public EntityTrackerEntry(Entity par1Entity, int par2, int par3, boolean par4)
    {
        ticks = 0;
        isDataInitialized = false;
        ticksSinceLastForcedTeleport = 0;
        field_73133_n = false;
        field_73134_o = new HashSet();
        myEntity = par1Entity;
        BlocksDistanceThreshold = par2;
        updateFrequency = par3;
        trackMotion = par4;
        lastScaledXPosition = MathHelper.floor_double(par1Entity.posX * 32D);
        lastScaledYPosition = MathHelper.floor_double(par1Entity.posY * 32D);
        lastScaledZPosition = MathHelper.floor_double(par1Entity.posZ * 32D);
        lastYaw = MathHelper.floor_float((par1Entity.rotationYaw * 256F) / 360F);
        lastPitch = MathHelper.floor_float((par1Entity.rotationPitch * 256F) / 360F);
        lastHeadMotion = MathHelper.floor_float((par1Entity.func_70079_am() * 256F) / 360F);
    }

    public boolean equals(Object par1Obj)
    {
        if (par1Obj instanceof EntityTrackerEntry)
        {
            return ((EntityTrackerEntry)par1Obj).myEntity.entityId == myEntity.entityId;
        }
        else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return myEntity.entityId;
    }

    /**
     * also sends velocity, rotation, and riding info.
     */
    public void sendLocationToAllClients(List par1List)
    {
        field_73133_n = false;

        if (!isDataInitialized || myEntity.getDistanceSq(posX, posY, posZ) > 16D)
        {
            posX = myEntity.posX;
            posY = myEntity.posY;
            posZ = myEntity.posZ;
            isDataInitialized = true;
            field_73133_n = true;
            sendEventsToPlayers(par1List);
        }

        if (ridingEntity != myEntity.ridingEntity)
        {
            ridingEntity = myEntity.ridingEntity;
            sendPacketToAllTrackingPlayers(new Packet39AttachEntity(myEntity, myEntity.ridingEntity));
        }

        if (myEntity.ridingEntity == null)
        {
            ticksSinceLastForcedTeleport++;

            if (ticks++ % updateFrequency == 0 || myEntity.isAirBorne)
            {
                int i = myEntity.myEntitySize.multiplyBy32AndRound(myEntity.posX);
                int j = MathHelper.floor_double(myEntity.posY * 32D);
                int k = myEntity.myEntitySize.multiplyBy32AndRound(myEntity.posZ);
                int l = MathHelper.floor_float((myEntity.rotationYaw * 256F) / 360F);
                int i1 = MathHelper.floor_float((myEntity.rotationPitch * 256F) / 360F);
                int j1 = i - lastScaledXPosition;
                int k1 = j - lastScaledYPosition;
                int l1 = k - lastScaledZPosition;
                Object obj = null;
                boolean flag = Math.abs(j1) >= 4 || Math.abs(k1) >= 4 || Math.abs(l1) >= 4;
                boolean flag1 = Math.abs(l - lastYaw) >= 4 || Math.abs(i1 - lastPitch) >= 4;

                if (j1 < -128 || j1 >= 128 || k1 < -128 || k1 >= 128 || l1 < -128 || l1 >= 128 || ticksSinceLastForcedTeleport > 400)
                {
                    ticksSinceLastForcedTeleport = 0;
                    obj = new Packet34EntityTeleport(myEntity.entityId, i, j, k, (byte)l, (byte)i1);
                }
                else if (flag && flag1)
                {
                    obj = new Packet33RelEntityMoveLook(myEntity.entityId, (byte)j1, (byte)k1, (byte)l1, (byte)l, (byte)i1);
                }
                else if (flag)
                {
                    obj = new Packet31RelEntityMove(myEntity.entityId, (byte)j1, (byte)k1, (byte)l1);
                }
                else if (flag1)
                {
                    obj = new Packet32EntityLook(myEntity.entityId, (byte)l, (byte)i1);
                }

                if (trackMotion)
                {
                    double d = myEntity.motionX - motionX;
                    double d1 = myEntity.motionY - motionY;
                    double d2 = myEntity.motionZ - motionZ;
                    double d3 = 0.02D;
                    double d4 = d * d + d1 * d1 + d2 * d2;

                    if (d4 > d3 * d3 || d4 > 0.0D && myEntity.motionX == 0.0D && myEntity.motionY == 0.0D && myEntity.motionZ == 0.0D)
                    {
                        motionX = myEntity.motionX;
                        motionY = myEntity.motionY;
                        motionZ = myEntity.motionZ;
                        sendPacketToAllTrackingPlayers(new Packet28EntityVelocity(myEntity.entityId, motionX, motionY, motionZ));
                    }
                }

                if (obj != null)
                {
                    sendPacketToAllTrackingPlayers(((Packet)(obj)));
                }

                DataWatcher datawatcher = myEntity.getDataWatcher();

                if (datawatcher.hasChanges())
                {
                    sendPacketToAllAssociatedPlayers(new Packet40EntityMetadata(myEntity.entityId, datawatcher));
                }

                int i2 = MathHelper.floor_float((myEntity.func_70079_am() * 256F) / 360F);

                if (Math.abs(i2 - lastHeadMotion) >= 4)
                {
                    sendPacketToAllTrackingPlayers(new Packet35EntityHeadRotation(myEntity.entityId, (byte)i2));
                    lastHeadMotion = i2;
                }

                if (flag)
                {
                    lastScaledXPosition = i;
                    lastScaledYPosition = j;
                    lastScaledZPosition = k;
                }

                if (flag1)
                {
                    lastYaw = l;
                    lastPitch = i1;
                }
            }

            myEntity.isAirBorne = false;
        }

        if (myEntity.velocityChanged)
        {
            sendPacketToAllAssociatedPlayers(new Packet28EntityVelocity(myEntity));
            myEntity.velocityChanged = false;
        }
    }

    /**
     * if this is a player, then it is not informed
     */
    public void sendPacketToAllTrackingPlayers(Packet par1Packet)
    {
        EntityPlayerMP entityplayermp;

        for (Iterator iterator = field_73134_o.iterator(); iterator.hasNext(); entityplayermp.serverForThisPlayer.sendPacketToPlayer(par1Packet))
        {
            entityplayermp = (EntityPlayerMP)iterator.next();
        }
    }

    /**
     * if this is a player, then it recieves the message also
     */
    public void sendPacketToAllAssociatedPlayers(Packet par1Packet)
    {
        sendPacketToAllTrackingPlayers(par1Packet);

        if (myEntity instanceof EntityPlayerMP)
        {
            ((EntityPlayerMP)myEntity).serverForThisPlayer.sendPacketToPlayer(par1Packet);
        }
    }

    public void informAllAssociatedPlayersOfItemDestruction()
    {
        EntityPlayerMP entityplayermp;

        for (Iterator iterator = field_73134_o.iterator(); iterator.hasNext(); entityplayermp.destroyedItemsNetCache.add(Integer.valueOf(myEntity.entityId)))
        {
            entityplayermp = (EntityPlayerMP)iterator.next();
        }
    }

    public void removeFromWatchingList(EntityPlayerMP par1EntityPlayerMP)
    {
        if (field_73134_o.contains(par1EntityPlayerMP))
        {
            field_73134_o.remove(par1EntityPlayerMP);
        }
    }

    /**
     * if the player is more than the distance threshold (typically 64) then the player is removed instead
     */
    public void tryStartWachingThis(EntityPlayerMP par1EntityPlayerMP)
    {
        if (par1EntityPlayerMP == myEntity)
        {
            return;
        }

        double d = par1EntityPlayerMP.posX - (double)(lastScaledXPosition / 32);
        double d1 = par1EntityPlayerMP.posZ - (double)(lastScaledZPosition / 32);

        if (d >= (double)(-BlocksDistanceThreshold) && d <= (double)BlocksDistanceThreshold && d1 >= (double)(-BlocksDistanceThreshold) && d1 <= (double)BlocksDistanceThreshold)
        {
            if (!field_73134_o.contains(par1EntityPlayerMP) && isPlayerWatchingThisChunk(par1EntityPlayerMP))
            {
                field_73134_o.add(par1EntityPlayerMP);
                Packet packet = getPacketForThisEntity();
                par1EntityPlayerMP.serverForThisPlayer.sendPacketToPlayer(packet);
                motionX = myEntity.motionX;
                motionY = myEntity.motionY;
                motionZ = myEntity.motionZ;

                if (trackMotion && !(packet instanceof Packet24MobSpawn))
                {
                    par1EntityPlayerMP.serverForThisPlayer.sendPacketToPlayer(new Packet28EntityVelocity(myEntity.entityId, myEntity.motionX, myEntity.motionY, myEntity.motionZ));
                }

                if (myEntity.ridingEntity != null)
                {
                    par1EntityPlayerMP.serverForThisPlayer.sendPacketToPlayer(new Packet39AttachEntity(myEntity, myEntity.ridingEntity));
                }

                ItemStack aitemstack[] = myEntity.getLastActiveItems();

                if (aitemstack != null)
                {
                    for (int i = 0; i < aitemstack.length; i++)
                    {
                        par1EntityPlayerMP.serverForThisPlayer.sendPacketToPlayer(new Packet5PlayerInventory(myEntity.entityId, i, aitemstack[i]));
                    }
                }

                if (myEntity instanceof EntityPlayer)
                {
                    EntityPlayer entityplayer = (EntityPlayer)myEntity;

                    if (entityplayer.isPlayerSleeping())
                    {
                        par1EntityPlayerMP.serverForThisPlayer.sendPacketToPlayer(new Packet17Sleep(myEntity, 0, MathHelper.floor_double(myEntity.posX), MathHelper.floor_double(myEntity.posY), MathHelper.floor_double(myEntity.posZ)));
                    }
                }

                if (myEntity instanceof EntityLiving)
                {
                    EntityLiving entityliving = (EntityLiving)myEntity;
                    PotionEffect potioneffect;

                    for (Iterator iterator = entityliving.getActivePotionEffects().iterator(); iterator.hasNext(); par1EntityPlayerMP.serverForThisPlayer.sendPacketToPlayer(new Packet41EntityEffect(myEntity.entityId, potioneffect)))
                    {
                        potioneffect = (PotionEffect)iterator.next();
                    }
                }
            }
        }
        else if (field_73134_o.contains(par1EntityPlayerMP))
        {
            field_73134_o.remove(par1EntityPlayerMP);
            par1EntityPlayerMP.destroyedItemsNetCache.add(Integer.valueOf(myEntity.entityId));
        }
    }

    private boolean isPlayerWatchingThisChunk(EntityPlayerMP par1EntityPlayerMP)
    {
        return par1EntityPlayerMP.getServerForPlayer().getPlayerManager().isPlayerWatchingChunk(par1EntityPlayerMP, myEntity.chunkCoordX, myEntity.chunkCoordZ);
    }

    public void sendEventsToPlayers(List par1List)
    {
        EntityPlayer entityplayer;

        for (Iterator iterator = par1List.iterator(); iterator.hasNext(); tryStartWachingThis((EntityPlayerMP)entityplayer))
        {
            entityplayer = (EntityPlayer)iterator.next();
        }
    }

    private Packet getPacketForThisEntity()
    {
        if (myEntity.isDead)
        {
            System.out.println("Fetching addPacket for removed entity");
        }

        if (myEntity instanceof EntityItem)
        {
            EntityItem entityitem = (EntityItem)myEntity;
            Packet21PickupSpawn packet21pickupspawn = new Packet21PickupSpawn(entityitem);
            entityitem.posX = (double)packet21pickupspawn.xPosition / 32D;
            entityitem.posY = (double)packet21pickupspawn.yPosition / 32D;
            entityitem.posZ = (double)packet21pickupspawn.zPosition / 32D;
            return packet21pickupspawn;
        }

        if (myEntity instanceof EntityPlayerMP)
        {
            return new Packet20NamedEntitySpawn((EntityPlayer)myEntity);
        }

        if (myEntity instanceof EntityMinecart)
        {
            EntityMinecart entityminecart = (EntityMinecart)myEntity;

            if (entityminecart.minecartType == 0)
            {
                return new Packet23VehicleSpawn(myEntity, 10);
            }

            if (entityminecart.minecartType == 1)
            {
                return new Packet23VehicleSpawn(myEntity, 11);
            }

            if (entityminecart.minecartType == 2)
            {
                return new Packet23VehicleSpawn(myEntity, 12);
            }
        }

        if (myEntity instanceof EntityBoat)
        {
            return new Packet23VehicleSpawn(myEntity, 1);
        }

        if ((myEntity instanceof IAnimals) || (myEntity instanceof EntityDragon))
        {
            lastHeadMotion = MathHelper.floor_float((myEntity.func_70079_am() * 256F) / 360F);
            return new Packet24MobSpawn((EntityLiving)myEntity);
        }

        if (myEntity instanceof EntityFishHook)
        {
            EntityPlayer entityplayer = ((EntityFishHook)myEntity).angler;
            return new Packet23VehicleSpawn(myEntity, 90, entityplayer == null ? myEntity.entityId : ((Entity)(entityplayer)).entityId);
        }

        if (myEntity instanceof EntityArrow)
        {
            Entity entity = ((EntityArrow)myEntity).shootingEntity;
            return new Packet23VehicleSpawn(myEntity, 60, entity == null ? myEntity.entityId : entity.entityId);
        }

        if (myEntity instanceof EntitySnowball)
        {
            return new Packet23VehicleSpawn(myEntity, 61);
        }

        if (myEntity instanceof EntityPotion)
        {
            return new Packet23VehicleSpawn(myEntity, 73, ((EntityPotion)myEntity).getPotionDamage());
        }

        if (myEntity instanceof EntityExpBottle)
        {
            return new Packet23VehicleSpawn(myEntity, 75);
        }

        if (myEntity instanceof EntityEnderPearl)
        {
            return new Packet23VehicleSpawn(myEntity, 65);
        }

        if (myEntity instanceof EntityEnderEye)
        {
            return new Packet23VehicleSpawn(myEntity, 72);
        }

        if (myEntity instanceof EntitySmallFireball)
        {
            EntitySmallFireball entitysmallfireball = (EntitySmallFireball)myEntity;
            Packet23VehicleSpawn packet23vehiclespawn = null;

            if (entitysmallfireball.shootingEntity != null)
            {
                packet23vehiclespawn = new Packet23VehicleSpawn(myEntity, 64, entitysmallfireball.shootingEntity.entityId);
            }
            else
            {
                packet23vehiclespawn = new Packet23VehicleSpawn(myEntity, 64, 0);
            }

            packet23vehiclespawn.speedX = (int)(entitysmallfireball.accelerationX * 8000D);
            packet23vehiclespawn.speedY = (int)(entitysmallfireball.accelerationY * 8000D);
            packet23vehiclespawn.speedZ = (int)(entitysmallfireball.accelerationZ * 8000D);
            return packet23vehiclespawn;
        }

        if (myEntity instanceof EntityFireball)
        {
            EntityFireball entityfireball = (EntityFireball)myEntity;
            Packet23VehicleSpawn packet23vehiclespawn1 = null;

            if (entityfireball.shootingEntity != null)
            {
                packet23vehiclespawn1 = new Packet23VehicleSpawn(myEntity, 63, ((EntityFireball)myEntity).shootingEntity.entityId);
            }
            else
            {
                packet23vehiclespawn1 = new Packet23VehicleSpawn(myEntity, 63, 0);
            }

            packet23vehiclespawn1.speedX = (int)(entityfireball.accelerationX * 8000D);
            packet23vehiclespawn1.speedY = (int)(entityfireball.accelerationY * 8000D);
            packet23vehiclespawn1.speedZ = (int)(entityfireball.accelerationZ * 8000D);
            return packet23vehiclespawn1;
        }

        if (myEntity instanceof EntityEgg)
        {
            return new Packet23VehicleSpawn(myEntity, 62);
        }

        if (myEntity instanceof EntityTNTPrimed)
        {
            return new Packet23VehicleSpawn(myEntity, 50);
        }

        if (myEntity instanceof EntityEnderCrystal)
        {
            return new Packet23VehicleSpawn(myEntity, 51);
        }

        if (myEntity instanceof EntityFallingSand)
        {
            EntityFallingSand entityfallingsand = (EntityFallingSand)myEntity;
            return new Packet23VehicleSpawn(myEntity, 70, entityfallingsand.blockID | entityfallingsand.field_70285_b << 16);
        }

        if (myEntity instanceof EntityPainting)
        {
            return new Packet25EntityPainting((EntityPainting)myEntity);
        }

        if (myEntity instanceof EntityXPOrb)
        {
            return new Packet26EntityExpOrb((EntityXPOrb)myEntity);
        }
        else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Don't know how to add ").append(myEntity.getClass()).append("!").toString());
        }
    }

    public void removePlayerFromTracker(EntityPlayerMP par1EntityPlayerMP)
    {
        if (field_73134_o.contains(par1EntityPlayerMP))
        {
            field_73134_o.remove(par1EntityPlayerMP);
            par1EntityPlayerMP.destroyedItemsNetCache.add(Integer.valueOf(myEntity.entityId));
        }
    }
}
