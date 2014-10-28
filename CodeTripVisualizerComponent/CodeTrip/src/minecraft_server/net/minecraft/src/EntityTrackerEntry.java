package net.minecraft.src;

import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.*;
import java.util.logging.Logger;

public class EntityTrackerEntry
{
    /** The entity that this EntityTrackerEntry tracks. */
    public Entity trackedEntity;
    public int trackingDistanceThreshold;
    public int field_73131_c;

    /** The encoded entity X position. */
    public int encodedPosX;

    /** The encoded entity Y position. */
    public int encodedPosY;

    /** The encoded entity Z position. */
    public int encodedPosZ;

    /** The encoded entity yaw rotation. */
    public int encodedRotationYaw;

    /** The encoded entity pitch rotation. */
    public int encodedRotationPitch;
    public int field_73140_i;
    public double lastTrackedEntityMotionX;
    public double lastTrackedEntityMotionY;
    public double lastTrackedEntityMotionZ;
    public int updateCounter;
    private double lastTrackedEntityPosX;
    private double lastTrackedEntityPosY;
    private double lastTrackedEntityPosZ;
    private boolean firstUpdateDone;
    private boolean shouldSendMotionUpdates;
    private int field_73142_u;
    private Entity field_73141_v;
    public boolean playerEntitiesUpdated;
    public Set trackedPlayers;

    public EntityTrackerEntry(Entity par1Entity, int par2, int par3, boolean par4)
    {
        updateCounter = 0;
        firstUpdateDone = false;
        field_73142_u = 0;
        playerEntitiesUpdated = false;
        trackedPlayers = new HashSet();
        trackedEntity = par1Entity;
        trackingDistanceThreshold = par2;
        field_73131_c = par3;
        shouldSendMotionUpdates = par4;
        encodedPosX = MathHelper.floor_double(par1Entity.posX * 32D);
        encodedPosY = MathHelper.floor_double(par1Entity.posY * 32D);
        encodedPosZ = MathHelper.floor_double(par1Entity.posZ * 32D);
        encodedRotationYaw = MathHelper.floor_float((par1Entity.rotationYaw * 256F) / 360F);
        encodedRotationPitch = MathHelper.floor_float((par1Entity.rotationPitch * 256F) / 360F);
        field_73140_i = MathHelper.floor_float((par1Entity.func_70079_am() * 256F) / 360F);
    }

    public boolean equals(Object par1Obj)
    {
        return (par1Obj instanceof EntityTrackerEntry) ? ((EntityTrackerEntry)par1Obj).trackedEntity.entityId == trackedEntity.entityId : false;
    }

    public int hashCode()
    {
        return trackedEntity.entityId;
    }

    public void updatePlayerList(List par1List)
    {
        playerEntitiesUpdated = false;

        if (!firstUpdateDone || trackedEntity.getDistanceSq(lastTrackedEntityPosX, lastTrackedEntityPosY, lastTrackedEntityPosZ) > 16D)
        {
            lastTrackedEntityPosX = trackedEntity.posX;
            lastTrackedEntityPosY = trackedEntity.posY;
            lastTrackedEntityPosZ = trackedEntity.posZ;
            firstUpdateDone = true;
            playerEntitiesUpdated = true;
            updatePlayerEntities(par1List);
        }

        if (field_73141_v != trackedEntity.ridingEntity)
        {
            field_73141_v = trackedEntity.ridingEntity;
            sendPacketToTrackedPlayers(new Packet39AttachEntity(trackedEntity, trackedEntity.ridingEntity));
        }

        if (trackedEntity.ridingEntity == null)
        {
            field_73142_u++;

            if (updateCounter++ % field_73131_c == 0 || trackedEntity.isAirBorne)
            {
                int i = trackedEntity.field_70168_am.func_75630_a(trackedEntity.posX);
                int j = MathHelper.floor_double(trackedEntity.posY * 32D);
                int k = trackedEntity.field_70168_am.func_75630_a(trackedEntity.posZ);
                int l = MathHelper.floor_float((trackedEntity.rotationYaw * 256F) / 360F);
                int i1 = MathHelper.floor_float((trackedEntity.rotationPitch * 256F) / 360F);
                int j1 = i - encodedPosX;
                int k1 = j - encodedPosY;
                int l1 = k - encodedPosZ;
                Object obj = null;
                boolean flag = Math.abs(j1) >= 4 || Math.abs(k1) >= 4 || Math.abs(l1) >= 4;
                boolean flag1 = Math.abs(l - encodedRotationYaw) >= 4 || Math.abs(i1 - encodedRotationPitch) >= 4;

                if (j1 >= -128 && j1 < 128 && k1 >= -128 && k1 < 128 && l1 >= -128 && l1 < 128 && field_73142_u <= 400)
                {
                    if (flag && flag1)
                    {
                        obj = new Packet33RelEntityMoveLook(trackedEntity.entityId, (byte)j1, (byte)k1, (byte)l1, (byte)l, (byte)i1);
                    }
                    else if (flag)
                    {
                        obj = new Packet31RelEntityMove(trackedEntity.entityId, (byte)j1, (byte)k1, (byte)l1);
                    }
                    else if (flag1)
                    {
                        obj = new Packet32EntityLook(trackedEntity.entityId, (byte)l, (byte)i1);
                    }
                }
                else
                {
                    field_73142_u = 0;
                    obj = new Packet34EntityTeleport(trackedEntity.entityId, i, j, k, (byte)l, (byte)i1);
                }

                if (shouldSendMotionUpdates)
                {
                    double d = trackedEntity.motionX - lastTrackedEntityMotionX;
                    double d1 = trackedEntity.motionY - lastTrackedEntityMotionY;
                    double d2 = trackedEntity.motionZ - lastTrackedEntityMotionZ;
                    double d3 = 0.02D;
                    double d4 = d * d + d1 * d1 + d2 * d2;

                    if (d4 > d3 * d3 || d4 > 0.0D && trackedEntity.motionX == 0.0D && trackedEntity.motionY == 0.0D && trackedEntity.motionZ == 0.0D)
                    {
                        lastTrackedEntityMotionX = trackedEntity.motionX;
                        lastTrackedEntityMotionY = trackedEntity.motionY;
                        lastTrackedEntityMotionZ = trackedEntity.motionZ;
                        sendPacketToTrackedPlayers(new Packet28EntityVelocity(trackedEntity.entityId, lastTrackedEntityMotionX, lastTrackedEntityMotionY, lastTrackedEntityMotionZ));
                    }
                }

                if (obj != null)
                {
                    sendPacketToTrackedPlayers((Packet)obj);
                }

                DataWatcher datawatcher = trackedEntity.getDataWatcher();

                if (datawatcher.hasObjectChanged())
                {
                    sendPacketToTrackedPlayersAndTrackedEntity(new Packet40EntityMetadata(trackedEntity.entityId, datawatcher));
                }

                int i2 = MathHelper.floor_float((trackedEntity.func_70079_am() * 256F) / 360F);

                if (Math.abs(i2 - field_73140_i) >= 4)
                {
                    sendPacketToTrackedPlayers(new Packet35EntityHeadRotation(trackedEntity.entityId, (byte)i2));
                    field_73140_i = i2;
                }

                if (flag)
                {
                    encodedPosX = i;
                    encodedPosY = j;
                    encodedPosZ = k;
                }

                if (flag1)
                {
                    encodedRotationYaw = l;
                    encodedRotationPitch = i1;
                }
            }

            trackedEntity.isAirBorne = false;
        }

        if (trackedEntity.velocityChanged)
        {
            sendPacketToTrackedPlayersAndTrackedEntity(new Packet28EntityVelocity(trackedEntity));
            trackedEntity.velocityChanged = false;
        }
    }

    public void sendPacketToTrackedPlayers(Packet par1Packet)
    {
        EntityPlayerMP entityplayermp;

        for (Iterator iterator = trackedPlayers.iterator(); iterator.hasNext(); entityplayermp.playerNetServerHandler.sendPacket(par1Packet))
        {
            entityplayermp = (EntityPlayerMP)iterator.next();
        }
    }

    public void sendPacketToTrackedPlayersAndTrackedEntity(Packet par1Packet)
    {
        sendPacketToTrackedPlayers(par1Packet);

        if (trackedEntity instanceof EntityPlayerMP)
        {
            ((EntityPlayerMP)trackedEntity).playerNetServerHandler.sendPacket(par1Packet);
        }
    }

    public void sendDestroyEntityPacketToTrackedPlayers()
    {
        EntityPlayerMP entityplayermp;

        for (Iterator iterator = trackedPlayers.iterator(); iterator.hasNext(); entityplayermp.field_71130_g.add(Integer.valueOf(trackedEntity.entityId)))
        {
            entityplayermp = (EntityPlayerMP)iterator.next();
        }
    }

    public void removeFromTrackedPlayers(EntityPlayerMP par1EntityPlayerMP)
    {
        if (trackedPlayers.contains(par1EntityPlayerMP))
        {
            trackedPlayers.remove(par1EntityPlayerMP);
        }
    }

    public void updatePlayerEntity(EntityPlayerMP par1EntityPlayerMP)
    {
        if (par1EntityPlayerMP != trackedEntity)
        {
            double d = par1EntityPlayerMP.posX - (double)(encodedPosX / 32);
            double d1 = par1EntityPlayerMP.posZ - (double)(encodedPosZ / 32);

            if (d >= (double)(-trackingDistanceThreshold) && d <= (double)trackingDistanceThreshold && d1 >= (double)(-trackingDistanceThreshold) && d1 <= (double)trackingDistanceThreshold)
            {
                if (!trackedPlayers.contains(par1EntityPlayerMP) && func_73121_d(par1EntityPlayerMP))
                {
                    trackedPlayers.add(par1EntityPlayerMP);
                    Packet packet = getSpawnPacket();
                    par1EntityPlayerMP.playerNetServerHandler.sendPacket(packet);
                    lastTrackedEntityMotionX = trackedEntity.motionX;
                    lastTrackedEntityMotionY = trackedEntity.motionY;
                    lastTrackedEntityMotionZ = trackedEntity.motionZ;

                    if (shouldSendMotionUpdates && !(packet instanceof Packet24MobSpawn))
                    {
                        par1EntityPlayerMP.playerNetServerHandler.sendPacket(new Packet28EntityVelocity(trackedEntity.entityId, trackedEntity.motionX, trackedEntity.motionY, trackedEntity.motionZ));
                    }

                    if (trackedEntity.ridingEntity != null)
                    {
                        par1EntityPlayerMP.playerNetServerHandler.sendPacket(new Packet39AttachEntity(trackedEntity, trackedEntity.ridingEntity));
                    }

                    ItemStack aitemstack[] = trackedEntity.getInventory();

                    if (aitemstack != null)
                    {
                        for (int i = 0; i < aitemstack.length; i++)
                        {
                            par1EntityPlayerMP.playerNetServerHandler.sendPacket(new Packet5PlayerInventory(trackedEntity.entityId, i, aitemstack[i]));
                        }
                    }

                    if (trackedEntity instanceof EntityPlayer)
                    {
                        EntityPlayer entityplayer = (EntityPlayer)trackedEntity;

                        if (entityplayer.isPlayerSleeping())
                        {
                            par1EntityPlayerMP.playerNetServerHandler.sendPacket(new Packet17Sleep(trackedEntity, 0, MathHelper.floor_double(trackedEntity.posX), MathHelper.floor_double(trackedEntity.posY), MathHelper.floor_double(trackedEntity.posZ)));
                        }
                    }

                    if (trackedEntity instanceof EntityLiving)
                    {
                        EntityLiving entityliving = (EntityLiving)trackedEntity;
                        PotionEffect potioneffect;

                        for (Iterator iterator = entityliving.getActivePotionEffects().iterator(); iterator.hasNext(); par1EntityPlayerMP.playerNetServerHandler.sendPacket(new Packet41EntityEffect(trackedEntity.entityId, potioneffect)))
                        {
                            potioneffect = (PotionEffect)iterator.next();
                        }
                    }
                }
            }
            else if (trackedPlayers.contains(par1EntityPlayerMP))
            {
                trackedPlayers.remove(par1EntityPlayerMP);
                par1EntityPlayerMP.field_71130_g.add(Integer.valueOf(trackedEntity.entityId));
            }
        }
    }

    private boolean func_73121_d(EntityPlayerMP par1EntityPlayerMP)
    {
        return par1EntityPlayerMP.func_71121_q().func_73040_p().func_72694_a(par1EntityPlayerMP, trackedEntity.chunkCoordX, trackedEntity.chunkCoordZ);
    }

    public void updatePlayerEntities(List par1List)
    {
        EntityPlayer entityplayer;

        for (Iterator iterator = par1List.iterator(); iterator.hasNext(); updatePlayerEntity((EntityPlayerMP)entityplayer))
        {
            entityplayer = (EntityPlayer)iterator.next();
        }
    }

    private Packet getSpawnPacket()
    {
        if (trackedEntity.isDead)
        {
            System.out.println("Fetching addPacket for removed entity");
        }

        EntityTrackerEntry2 entitytrackerentry2 = ModLoaderMp.handleEntityTrackerEntries(trackedEntity);

        if (entitytrackerentry2 != null)
        {
            try
            {
                if (trackedEntity instanceof ISpawnable)
                {
                    Packet230ModLoader packet230modloader = ((ISpawnable)trackedEntity).getSpawnPacket();
                    packet230modloader.modId = "Spawn".hashCode();

                    if (entitytrackerentry2.entityId > 127)
                    {
                        packet230modloader.packetType = entitytrackerentry2.entityId - 256;
                    }
                    else
                    {
                        packet230modloader.packetType = entitytrackerentry2.entityId;
                    }

                    return packet230modloader;
                }

                if (!entitytrackerentry2.entityHasOwner)
                {
                    return new Packet23VehicleSpawn(trackedEntity, entitytrackerentry2.entityId);
                }

                Field field = trackedEntity.getClass().getField("owner");

                if ((net.minecraft.src.Entity.class).isAssignableFrom(field.getType()))
                {
                    Entity entity1 = (Entity)field.get(trackedEntity);
                    return new Packet23VehicleSpawn(trackedEntity, entitytrackerentry2.entityId, entity1 == null ? trackedEntity.entityId : entity1.entityId);
                }
                else
                {
                    throw new Exception(String.format("Entity's owner field must be of type Entity, but it is of type %s.", new Object[]
                            {
                                field.getType()
                            }));
                }
            }
            catch (Exception exception)
            {
                ModLoader.getLogger().throwing("EntityTrackerEntry", "getSpawnPacket", exception);
                ModLoader.throwException(String.format("Error sending spawn packet for entity of type %s.", new Object[]
                        {
                            trackedEntity.getClass()
                        }), exception);
                return null;
            }
        }

        if (trackedEntity instanceof EntityItem)
        {
            EntityItem entityitem = (EntityItem)trackedEntity;
            Packet21PickupSpawn packet21pickupspawn = new Packet21PickupSpawn(entityitem);
            entityitem.posX = (double)packet21pickupspawn.xPosition / 32D;
            entityitem.posY = (double)packet21pickupspawn.yPosition / 32D;
            entityitem.posZ = (double)packet21pickupspawn.zPosition / 32D;
            return packet21pickupspawn;
        }

        if (trackedEntity instanceof EntityPlayerMP)
        {
            return new Packet20NamedEntitySpawn((EntityPlayer)trackedEntity);
        }

        if (trackedEntity instanceof EntityMinecart)
        {
            EntityMinecart entityminecart = (EntityMinecart)trackedEntity;

            if (entityminecart.minecartType == 0)
            {
                return new Packet23VehicleSpawn(trackedEntity, 10);
            }

            if (entityminecart.minecartType == 1)
            {
                return new Packet23VehicleSpawn(trackedEntity, 11);
            }

            if (entityminecart.minecartType == 2)
            {
                return new Packet23VehicleSpawn(trackedEntity, 12);
            }
        }

        if (trackedEntity instanceof EntityBoat)
        {
            return new Packet23VehicleSpawn(trackedEntity, 1);
        }

        if (!(trackedEntity instanceof IAnimals) && !(trackedEntity instanceof EntityDragon))
        {
            if (trackedEntity instanceof EntityFishHook)
            {
                EntityPlayer entityplayer = ((EntityFishHook)trackedEntity).angler;
                return new Packet23VehicleSpawn(trackedEntity, 90, entityplayer == null ? trackedEntity.entityId : entityplayer.entityId);
            }

            if (trackedEntity instanceof EntityArrow)
            {
                Entity entity = ((EntityArrow)trackedEntity).shootingEntity;
                return new Packet23VehicleSpawn(trackedEntity, 60, entity == null ? trackedEntity.entityId : entity.entityId);
            }

            if (trackedEntity instanceof EntitySnowball)
            {
                return new Packet23VehicleSpawn(trackedEntity, 61);
            }

            if (trackedEntity instanceof EntityPotion)
            {
                return new Packet23VehicleSpawn(trackedEntity, 73, ((EntityPotion)trackedEntity).getPotionDamage());
            }

            if (trackedEntity instanceof EntityExpBottle)
            {
                return new Packet23VehicleSpawn(trackedEntity, 75);
            }

            if (trackedEntity instanceof EntityEnderPearl)
            {
                return new Packet23VehicleSpawn(trackedEntity, 65);
            }

            if (trackedEntity instanceof EntityEnderEye)
            {
                return new Packet23VehicleSpawn(trackedEntity, 72);
            }

            if (trackedEntity instanceof EntitySmallFireball)
            {
                EntitySmallFireball entitysmallfireball = (EntitySmallFireball)trackedEntity;
                Packet23VehicleSpawn packet23vehiclespawn = null;

                if (entitysmallfireball.shootingEntity != null)
                {
                    packet23vehiclespawn = new Packet23VehicleSpawn(trackedEntity, 64, entitysmallfireball.shootingEntity.entityId);
                }
                else
                {
                    packet23vehiclespawn = new Packet23VehicleSpawn(trackedEntity, 64, 0);
                }

                packet23vehiclespawn.speedX = (int)(entitysmallfireball.accelerationX * 8000D);
                packet23vehiclespawn.speedY = (int)(entitysmallfireball.accelerationY * 8000D);
                packet23vehiclespawn.speedZ = (int)(entitysmallfireball.accelerationZ * 8000D);
                return packet23vehiclespawn;
            }

            if (trackedEntity instanceof EntityFireball)
            {
                EntityFireball entityfireball = (EntityFireball)trackedEntity;
                Packet23VehicleSpawn packet23vehiclespawn1 = null;

                if (entityfireball.shootingEntity != null)
                {
                    packet23vehiclespawn1 = new Packet23VehicleSpawn(trackedEntity, 63, ((EntityFireball)trackedEntity).shootingEntity.entityId);
                }
                else
                {
                    packet23vehiclespawn1 = new Packet23VehicleSpawn(trackedEntity, 63, 0);
                }

                packet23vehiclespawn1.speedX = (int)(entityfireball.accelerationX * 8000D);
                packet23vehiclespawn1.speedY = (int)(entityfireball.accelerationY * 8000D);
                packet23vehiclespawn1.speedZ = (int)(entityfireball.accelerationZ * 8000D);
                return packet23vehiclespawn1;
            }

            if (trackedEntity instanceof EntityEgg)
            {
                return new Packet23VehicleSpawn(trackedEntity, 62);
            }

            if (trackedEntity instanceof EntityTNTPrimed)
            {
                return new Packet23VehicleSpawn(trackedEntity, 50);
            }

            if (trackedEntity instanceof EntityEnderCrystal)
            {
                return new Packet23VehicleSpawn(trackedEntity, 51);
            }

            if (trackedEntity instanceof EntityFallingSand)
            {
                EntityFallingSand entityfallingsand = (EntityFallingSand)trackedEntity;
                return new Packet23VehicleSpawn(trackedEntity, 70, entityfallingsand.blockID | entityfallingsand.field_70285_b << 16);
            }

            if (trackedEntity instanceof EntityPainting)
            {
                return new Packet25EntityPainting((EntityPainting)trackedEntity);
            }

            if (trackedEntity instanceof EntityXPOrb)
            {
                return new Packet26EntityExpOrb((EntityXPOrb)trackedEntity);
            }
            else
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Don't know how to add ").append(trackedEntity.getClass()).append("!").toString());
            }
        }
        else
        {
            field_73140_i = MathHelper.floor_float((trackedEntity.func_70079_am() * 256F) / 360F);
            return new Packet24MobSpawn((EntityLiving)trackedEntity);
        }
    }

    /**
     * Remove a tracked player from our list and tell the tracked player to destroy us from their world.
     */
    public void removeTrackedPlayerSymmetric(EntityPlayerMP par1EntityPlayerMP)
    {
        if (trackedPlayers.contains(par1EntityPlayerMP))
        {
            trackedPlayers.remove(par1EntityPlayerMP);
            par1EntityPlayerMP.field_71130_g.add(Integer.valueOf(trackedEntity.entityId));
        }
    }
}
