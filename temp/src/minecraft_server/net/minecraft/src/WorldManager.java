// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Iterator;
import java.util.List;
import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            IWorldAccess, WorldServer, EntityTracker, WorldProvider, 
//            Packet62LevelSound, ServerConfigurationManager, PlayerManager, Packet61DoorChange, 
//            EntityPlayerMP, Packet55BlockDestroy, NetServerHandler, Entity, 
//            EntityPlayer

public class WorldManager
    implements IWorldAccess
{

    private MinecraftServer field_72783_a;
    private WorldServer field_72782_b;

    public WorldManager(MinecraftServer p_i3390_1_, WorldServer p_i3390_2_)
    {
        field_72783_a = p_i3390_1_;
        field_72782_b = p_i3390_2_;
    }

    public void func_72708_a(String s, double d, double d1, double d2, 
            double d3, double d4, double d5)
    {
    }

    public void func_72703_a(Entity p_72703_1_)
    {
        field_72782_b.func_73039_n().func_72786_a(p_72703_1_);
    }

    public void func_72709_b(Entity p_72709_1_)
    {
        field_72782_b.func_73039_n().func_72790_b(p_72709_1_);
    }

    public void func_72704_a(String p_72704_1_, double p_72704_2_, double p_72704_4_, double p_72704_6_, 
            float p_72704_8_, float p_72704_9_)
    {
        field_72783_a.func_71203_ab().func_72393_a(p_72704_2_, p_72704_4_, p_72704_6_, p_72704_8_ <= 1.0F ? 16D : 16F * p_72704_8_, field_72782_b.field_73011_w.field_76574_g, new Packet62LevelSound(p_72704_1_, p_72704_2_, p_72704_4_, p_72704_6_, p_72704_8_, p_72704_9_));
    }

    public void func_72707_a(int i, int j, int k, int l, int i1, int j1)
    {
    }

    public void func_72710_a(int p_72710_1_, int p_72710_2_, int p_72710_3_)
    {
        field_72782_b.func_73040_p().func_72687_a(p_72710_1_, p_72710_2_, p_72710_3_);
    }

    public void func_72711_b(int i, int j, int k)
    {
    }

    public void func_72702_a(String s, int i, int j, int k)
    {
    }

    public void func_72706_a(EntityPlayer p_72706_1_, int p_72706_2_, int p_72706_3_, int p_72706_4_, int p_72706_5_, int p_72706_6_)
    {
        field_72783_a.func_71203_ab().func_72397_a(p_72706_1_, p_72706_3_, p_72706_4_, p_72706_5_, 64D, field_72782_b.field_73011_w.field_76574_g, new Packet61DoorChange(p_72706_2_, p_72706_3_, p_72706_4_, p_72706_5_, p_72706_6_));
    }

    public void func_72705_a(int p_72705_1_, int p_72705_2_, int p_72705_3_, int p_72705_4_, int p_72705_5_)
    {
        Iterator iterator = field_72783_a.func_71203_ab().field_72404_b.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            EntityPlayerMP entityplayermp = (EntityPlayerMP)iterator.next();
            if(entityplayermp != null && entityplayermp.field_70170_p == field_72782_b && entityplayermp.field_70157_k != p_72705_1_)
            {
                double d = (double)p_72705_2_ - entityplayermp.field_70165_t;
                double d1 = (double)p_72705_3_ - entityplayermp.field_70163_u;
                double d2 = (double)p_72705_4_ - entityplayermp.field_70161_v;
                if(d * d + d1 * d1 + d2 * d2 < 1024D)
                {
                    entityplayermp.field_71135_a.func_72567_b(new Packet55BlockDestroy(p_72705_1_, p_72705_2_, p_72705_3_, p_72705_4_, p_72705_5_));
                }
            }
        } while(true);
    }
}
