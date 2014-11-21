package net.minecraft.src;

import java.util.*;
import net.minecraft.server.MinecraftServer;

public class EntityTracker
{
    private final WorldServer theWorld;
    private Set trackedEntities;
    private IntHashMap trackedEntityIDs;
    private int entityViewDistance;

    public EntityTracker(WorldServer par1WorldServer)
    {
        trackedEntities = new HashSet();
        trackedEntityIDs = new IntHashMap();
        theWorld = par1WorldServer;
        entityViewDistance = par1WorldServer.getMinecraftServer().getConfigurationManager().getEntityViewDistance();
    }

    /**
     * if entity is a player sends all tracked events to the player, otherwise, adds with a visibility and update arate
     * based on the class type
     */
    public void addEntityToTracker(Entity par1Entity)
    {
        if (par1Entity instanceof EntityPlayerMP)
        {
            addEntityToTracker(par1Entity, 512, 2);
            EntityPlayerMP entityplayermp = (EntityPlayerMP)par1Entity;
            Iterator iterator = trackedEntities.iterator();

            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }

                EntityTrackerEntry entitytrackerentry = (EntityTrackerEntry)iterator.next();

                if (entitytrackerentry.myEntity != entityplayermp)
                {
                    entitytrackerentry.tryStartWachingThis(entityplayermp);
                }
            }
            while (true);
        }
        else if (par1Entity instanceof EntityFishHook)
        {
            addEntityToTracker(par1Entity, 64, 5, true);
        }
        else if (par1Entity instanceof EntityArrow)
        {
            addEntityToTracker(par1Entity, 64, 20, false);
        }
        else if (par1Entity instanceof EntitySmallFireball)
        {
            addEntityToTracker(par1Entity, 64, 10, false);
        }
        else if (par1Entity instanceof EntityFireball)
        {
            addEntityToTracker(par1Entity, 64, 10, false);
        }
        else if (par1Entity instanceof EntitySnowball)
        {
            addEntityToTracker(par1Entity, 64, 10, true);
        }
        else if (par1Entity instanceof EntityEnderPearl)
        {
            addEntityToTracker(par1Entity, 64, 10, true);
        }
        else if (par1Entity instanceof EntityEnderEye)
        {
            addEntityToTracker(par1Entity, 64, 4, true);
        }
        else if (par1Entity instanceof EntityEgg)
        {
            addEntityToTracker(par1Entity, 64, 10, true);
        }
        else if (par1Entity instanceof EntityPotion)
        {
            addEntityToTracker(par1Entity, 64, 10, true);
        }
        else if (par1Entity instanceof EntityExpBottle)
        {
            addEntityToTracker(par1Entity, 64, 10, true);
        }
        else if (par1Entity instanceof EntityItem)
        {
            addEntityToTracker(par1Entity, 64, 20, true);
        }
        else if (par1Entity instanceof EntityMinecart)
        {
            addEntityToTracker(par1Entity, 80, 3, true);
        }
        else if (par1Entity instanceof EntityBoat)
        {
            addEntityToTracker(par1Entity, 80, 3, true);
        }
        else if (par1Entity instanceof EntitySquid)
        {
            addEntityToTracker(par1Entity, 64, 3, true);
        }
        else if (par1Entity instanceof IAnimals)
        {
            addEntityToTracker(par1Entity, 80, 3, true);
        }
        else if (par1Entity instanceof EntityDragon)
        {
            addEntityToTracker(par1Entity, 160, 3, true);
        }
        else if (par1Entity instanceof EntityTNTPrimed)
        {
            addEntityToTracker(par1Entity, 160, 10, true);
        }
        else if (par1Entity instanceof EntityFallingSand)
        {
            addEntityToTracker(par1Entity, 160, 20, true);
        }
        else if (par1Entity instanceof EntityPainting)
        {
            addEntityToTracker(par1Entity, 160, 0x7fffffff, false);
        }
        else if (par1Entity instanceof EntityXPOrb)
        {
            addEntityToTracker(par1Entity, 160, 20, true);
        }
        else if (par1Entity instanceof EntityEnderCrystal)
        {
            addEntityToTracker(par1Entity, 256, 0x7fffffff, false);
        }
    }

    public void addEntityToTracker(Entity par1Entity, int par2, int par3)
    {
        addEntityToTracker(par1Entity, par2, par3, false);
    }

    public void addEntityToTracker(Entity par1Entity, int par2, int par3, boolean par4)
    {
        if (par2 > entityViewDistance)
        {
            par2 = entityViewDistance;
        }

        if (trackedEntityIDs.containsItem(par1Entity.entityId))
        {
            throw new IllegalStateException("Entity is already tracked!");
        }
        else
        {
            EntityTrackerEntry entitytrackerentry = new EntityTrackerEntry(par1Entity, par2, par3, par4);
            trackedEntities.add(entitytrackerentry);
            trackedEntityIDs.addKey(par1Entity.entityId, entitytrackerentry);
            entitytrackerentry.sendEventsToPlayers(theWorld.playerEntities);
            return;
        }
    }

    public void removeEntityFromAllTrackingPlayers(Entity par1Entity)
    {
        if (par1Entity instanceof EntityPlayerMP)
        {
            EntityPlayerMP entityplayermp = (EntityPlayerMP)par1Entity;
            EntityTrackerEntry entitytrackerentry1;

            for (Iterator iterator = trackedEntities.iterator(); iterator.hasNext(); entitytrackerentry1.removeFromWatchingList(entityplayermp))
            {
                entitytrackerentry1 = (EntityTrackerEntry)iterator.next();
            }
        }

        EntityTrackerEntry entitytrackerentry = (EntityTrackerEntry)trackedEntityIDs.removeObject(par1Entity.entityId);

        if (entitytrackerentry != null)
        {
            trackedEntities.remove(entitytrackerentry);
            entitytrackerentry.informAllAssociatedPlayersOfItemDestruction();
        }
    }

    public void processOutstandingEntries()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = trackedEntities.iterator();

        do
        {
            if (!iterator.hasNext())
            {
                break;
            }

            EntityTrackerEntry entitytrackerentry = (EntityTrackerEntry)iterator.next();
            entitytrackerentry.sendLocationToAllClients(theWorld.playerEntities);

            if (entitytrackerentry.field_73133_n && (entitytrackerentry.myEntity instanceof EntityPlayerMP))
            {
                arraylist.add((EntityPlayerMP)entitytrackerentry.myEntity);
            }
        }
        while (true);

        for (Iterator iterator1 = arraylist.iterator(); iterator1.hasNext();)
        {
            EntityPlayerMP entityplayermp = (EntityPlayerMP)iterator1.next();
            EntityPlayerMP entityplayermp1 = entityplayermp;
            Iterator iterator2 = trackedEntities.iterator();

            while (iterator2.hasNext())
            {
                EntityTrackerEntry entitytrackerentry1 = (EntityTrackerEntry)iterator2.next();

                if (entitytrackerentry1.myEntity != entityplayermp1)
                {
                    entitytrackerentry1.tryStartWachingThis(entityplayermp1);
                }
            }
        }
    }

    /**
     * does not send the packet to the entity if the entity is a player
     */
    public void sendPacketToAllPlayersTrackingEntity(Entity par1Entity, Packet par2Packet)
    {
        EntityTrackerEntry entitytrackerentry = (EntityTrackerEntry)trackedEntityIDs.lookup(par1Entity.entityId);

        if (entitytrackerentry != null)
        {
            entitytrackerentry.sendPacketToAllTrackingPlayers(par2Packet);
        }
    }

    /**
     * sends to the entity if the entity is a player
     */
    public void sendPacketToAllAssociatedPlayers(Entity par1Entity, Packet par2Packet)
    {
        EntityTrackerEntry entitytrackerentry = (EntityTrackerEntry)trackedEntityIDs.lookup(par1Entity.entityId);

        if (entitytrackerentry != null)
        {
            entitytrackerentry.sendPacketToAllAssociatedPlayers(par2Packet);
        }
    }

    public void removeAllTrackingPlayers(EntityPlayerMP par1EntityPlayerMP)
    {
        EntityTrackerEntry entitytrackerentry;

        for (Iterator iterator = trackedEntities.iterator(); iterator.hasNext(); entitytrackerentry.removePlayerFromTracker(par1EntityPlayerMP))
        {
            entitytrackerentry = (EntityTrackerEntry)iterator.next();
        }
    }
}
