// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            IntHashMap, PacketCount, ItemStack, Item, 
//            CompressedStreamTools, Packet0KeepAlive, Packet1Login, Packet2ClientProtocol, 
//            Packet3Chat, Packet4UpdateTime, Packet5PlayerInventory, Packet6SpawnPosition, 
//            Packet7UseEntity, Packet8UpdateHealth, Packet9Respawn, Packet10Flying, 
//            Packet11PlayerPosition, Packet12PlayerLook, Packet13PlayerLookMove, Packet14BlockDig, 
//            Packet15Place, Packet16BlockItemSwitch, Packet17Sleep, Packet18Animation, 
//            Packet19EntityAction, Packet20NamedEntitySpawn, Packet21PickupSpawn, Packet22Collect, 
//            Packet23VehicleSpawn, Packet24MobSpawn, Packet25EntityPainting, Packet26EntityExpOrb, 
//            Packet28EntityVelocity, Packet29DestroyEntity, Packet30Entity, Packet31RelEntityMove, 
//            Packet32EntityLook, Packet33RelEntityMoveLook, Packet34EntityTeleport, Packet35EntityHeadRotation, 
//            Packet38EntityStatus, Packet39AttachEntity, Packet40EntityMetadata, Packet41EntityEffect, 
//            Packet42RemoveEntityEffect, Packet43Experience, Packet51MapChunk, Packet52MultiBlockChange, 
//            Packet53BlockChange, Packet54PlayNoteBlock, Packet55BlockDestroy, Packet56MapChunks, 
//            Packet60Explosion, Packet61DoorChange, Packet62LevelSound, Packet70GameEvent, 
//            Packet71Weather, Packet100OpenWindow, Packet101CloseWindow, Packet102WindowClick, 
//            Packet103SetSlot, Packet104WindowItems, Packet105UpdateProgressbar, Packet106Transaction, 
//            Packet107CreativeSetSlot, Packet108EnchantItem, Packet130UpdateSign, Packet131MapData, 
//            Packet132TileEntityData, Packet200Statistic, Packet201PlayerInfo, Packet202PlayerAbilities, 
//            Packet203AutoComplete, Packet204ClientInfo, Packet205ClientCommand, Packet250CustomPayload, 
//            Packet252SharedKey, Packet253ServerAuthData, Packet254ServerPing, Packet255KickDisconnect, 
//            NetHandler, NBTTagCompound

public abstract class Packet
{

    public static IntHashMap field_73294_l = new IntHashMap();
    private static Map field_73291_a = new HashMap();
    private static Set field_73286_b = new HashSet();
    private static Set field_73288_c = new HashSet();
    public final long field_73295_m = System.currentTimeMillis();
    public static long field_73292_n;
    public static long field_73293_o;
    public static long field_73290_p;
    public static long field_73289_q;
    public boolean field_73287_r;

    public Packet()
    {
        field_73287_r = false;
    }

    static void func_73285_a(int p_73285_0_, boolean p_73285_1_, boolean p_73285_2_, Class p_73285_3_)
    {
        if(field_73294_l.func_76037_b(p_73285_0_))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Duplicate packet id:").append(p_73285_0_).toString());
        }
        if(field_73291_a.containsKey(p_73285_3_))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Duplicate packet class:").append(p_73285_3_).toString());
        }
        field_73294_l.func_76038_a(p_73285_0_, p_73285_3_);
        field_73291_a.put(p_73285_3_, Integer.valueOf(p_73285_0_));
        if(p_73285_1_)
        {
            field_73286_b.add(Integer.valueOf(p_73285_0_));
        }
        if(p_73285_2_)
        {
            field_73288_c.add(Integer.valueOf(p_73285_0_));
        }
    }

    public static Packet func_73269_d(int p_73269_0_)
    {
        try
        {
            Class class1 = (Class)field_73294_l.func_76041_a(p_73269_0_);
            if(class1 == null)
            {
                return null;
            } else
            {
                return (Packet)class1.newInstance();
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        System.out.println((new StringBuilder()).append("Skipping packet with id ").append(p_73269_0_).toString());
        return null;
    }

    public static void func_73274_a(DataOutputStream p_73274_0_, byte p_73274_1_[])
        throws IOException
    {
        p_73274_0_.writeShort(p_73274_1_.length);
        p_73274_0_.write(p_73274_1_);
    }

    public static byte[] func_73280_b(DataInputStream p_73280_0_)
        throws IOException
    {
        short word0 = p_73280_0_.readShort();
        if(word0 < 0)
        {
            throw new IOException("Key was smaller than nothing!  Weird key!");
        } else
        {
            byte abyte0[] = new byte[word0];
            p_73280_0_.read(abyte0);
            return abyte0;
        }
    }

    public final int func_73281_k()
    {
        return ((Integer)field_73291_a.get(getClass())).intValue();
    }

    public static Packet func_73272_a(DataInputStream p_73272_0_, boolean p_73272_1_)
        throws IOException
    {
        int i = 0;
        Packet packet = null;
        try
        {
            i = p_73272_0_.read();
            if(i == -1)
            {
                return null;
            }
            if(p_73272_1_ && !field_73288_c.contains(Integer.valueOf(i)) || !p_73272_1_ && !field_73286_b.contains(Integer.valueOf(i)))
            {
                throw new IOException((new StringBuilder()).append("Bad packet id ").append(i).toString());
            }
            packet = func_73269_d(i);
            if(packet == null)
            {
                throw new IOException((new StringBuilder()).append("Bad packet id ").append(i).toString());
            }
            packet.func_73267_a(p_73272_0_);
            field_73292_n++;
            field_73293_o += packet.func_73284_a();
        }
        catch(EOFException eofexception)
        {
            System.out.println("Reached end of stream");
            return null;
        }
        PacketCount.func_76118_a(i, packet.func_73284_a());
        field_73292_n++;
        field_73293_o += packet.func_73284_a();
        return packet;
    }

    public static void func_73266_a(Packet p_73266_0_, DataOutputStream p_73266_1_)
        throws IOException
    {
        p_73266_1_.write(p_73266_0_.func_73281_k());
        p_73266_0_.func_73273_a(p_73266_1_);
        field_73290_p++;
        field_73289_q += p_73266_0_.func_73284_a();
    }

    public static void func_73271_a(String p_73271_0_, DataOutputStream p_73271_1_)
        throws IOException
    {
        if(p_73271_0_.length() > 32767)
        {
            throw new IOException("String too big");
        } else
        {
            p_73271_1_.writeShort(p_73271_0_.length());
            p_73271_1_.writeChars(p_73271_0_);
            return;
        }
    }

    public static String func_73282_a(DataInputStream p_73282_0_, int p_73282_1_)
        throws IOException
    {
        short word0 = p_73282_0_.readShort();
        if(word0 > p_73282_1_)
        {
            throw new IOException((new StringBuilder()).append("Received string length longer than maximum allowed (").append(word0).append(" > ").append(p_73282_1_).append(")").toString());
        }
        if(word0 < 0)
        {
            throw new IOException("Received string length is less than zero! Weird string!");
        }
        StringBuilder stringbuilder = new StringBuilder();
        for(int i = 0; i < word0; i++)
        {
            stringbuilder.append(p_73282_0_.readChar());
        }

        return stringbuilder.toString();
    }

    public abstract void func_73267_a(DataInputStream datainputstream)
        throws IOException;

    public abstract void func_73273_a(DataOutputStream dataoutputstream)
        throws IOException;

    public abstract void func_73279_a(NetHandler nethandler);

    public abstract int func_73284_a();

    public boolean func_73278_e()
    {
        return false;
    }

    public boolean func_73268_a(Packet p_73268_1_)
    {
        return false;
    }

    public boolean func_73277_a_()
    {
        return false;
    }

    public String toString()
    {
        String s = getClass().getSimpleName();
        return s;
    }

    public static ItemStack func_73276_c(DataInputStream p_73276_0_)
        throws IOException
    {
        ItemStack itemstack = null;
        short word0 = p_73276_0_.readShort();
        if(word0 >= 0)
        {
            byte byte0 = p_73276_0_.readByte();
            short word1 = p_73276_0_.readShort();
            itemstack = new ItemStack(word0, byte0, word1);
            itemstack.field_77990_d = func_73283_d(p_73276_0_);
        }
        return itemstack;
    }

    public static void func_73270_a(ItemStack p_73270_0_, DataOutputStream p_73270_1_)
        throws IOException
    {
        if(p_73270_0_ == null)
        {
            p_73270_1_.writeShort(-1);
        } else
        {
            p_73270_1_.writeShort(p_73270_0_.field_77993_c);
            p_73270_1_.writeByte(p_73270_0_.field_77994_a);
            p_73270_1_.writeShort(p_73270_0_.func_77960_j());
            NBTTagCompound nbttagcompound = null;
            if(p_73270_0_.func_77973_b().func_77645_m() || p_73270_0_.func_77973_b().func_77651_p())
            {
                nbttagcompound = p_73270_0_.field_77990_d;
            }
            func_73275_a(nbttagcompound, p_73270_1_);
        }
    }

    public static NBTTagCompound func_73283_d(DataInputStream p_73283_0_)
        throws IOException
    {
        short word0 = p_73283_0_.readShort();
        if(word0 < 0)
        {
            return null;
        } else
        {
            byte abyte0[] = new byte[word0];
            p_73283_0_.readFully(abyte0);
            return CompressedStreamTools.func_74792_a(abyte0);
        }
    }

    protected static void func_73275_a(NBTTagCompound p_73275_0_, DataOutputStream p_73275_1_)
        throws IOException
    {
        if(p_73275_0_ == null)
        {
            p_73275_1_.writeShort(-1);
        } else
        {
            byte abyte0[] = CompressedStreamTools.func_74798_a(p_73275_0_);
            p_73275_1_.writeShort((short)abyte0.length);
            p_73275_1_.write(abyte0);
        }
    }

    static Class _mthclass$(String s)
    {
        try
        {
            return Class.forName(s);
        }
        catch(ClassNotFoundException classnotfoundexception)
        {
            throw new NoClassDefFoundError(classnotfoundexception.getMessage());
        }
    }

    static 
    {
        func_73285_a(0, true, true, net.minecraft.src.Packet0KeepAlive.class);
        func_73285_a(1, true, true, net.minecraft.src.Packet1Login.class);
        func_73285_a(2, false, true, net.minecraft.src.Packet2ClientProtocol.class);
        func_73285_a(3, true, true, net.minecraft.src.Packet3Chat.class);
        func_73285_a(4, true, false, net.minecraft.src.Packet4UpdateTime.class);
        func_73285_a(5, true, false, net.minecraft.src.Packet5PlayerInventory.class);
        func_73285_a(6, true, false, net.minecraft.src.Packet6SpawnPosition.class);
        func_73285_a(7, false, true, net.minecraft.src.Packet7UseEntity.class);
        func_73285_a(8, true, false, net.minecraft.src.Packet8UpdateHealth.class);
        func_73285_a(9, true, true, net.minecraft.src.Packet9Respawn.class);
        func_73285_a(10, true, true, net.minecraft.src.Packet10Flying.class);
        func_73285_a(11, true, true, net.minecraft.src.Packet11PlayerPosition.class);
        func_73285_a(12, true, true, net.minecraft.src.Packet12PlayerLook.class);
        func_73285_a(13, true, true, net.minecraft.src.Packet13PlayerLookMove.class);
        func_73285_a(14, false, true, net.minecraft.src.Packet14BlockDig.class);
        func_73285_a(15, false, true, net.minecraft.src.Packet15Place.class);
        func_73285_a(16, false, true, net.minecraft.src.Packet16BlockItemSwitch.class);
        func_73285_a(17, true, false, net.minecraft.src.Packet17Sleep.class);
        func_73285_a(18, true, true, net.minecraft.src.Packet18Animation.class);
        func_73285_a(19, false, true, net.minecraft.src.Packet19EntityAction.class);
        func_73285_a(20, true, false, net.minecraft.src.Packet20NamedEntitySpawn.class);
        func_73285_a(21, true, false, net.minecraft.src.Packet21PickupSpawn.class);
        func_73285_a(22, true, false, net.minecraft.src.Packet22Collect.class);
        func_73285_a(23, true, false, net.minecraft.src.Packet23VehicleSpawn.class);
        func_73285_a(24, true, false, net.minecraft.src.Packet24MobSpawn.class);
        func_73285_a(25, true, false, net.minecraft.src.Packet25EntityPainting.class);
        func_73285_a(26, true, false, net.minecraft.src.Packet26EntityExpOrb.class);
        func_73285_a(28, true, false, net.minecraft.src.Packet28EntityVelocity.class);
        func_73285_a(29, true, false, net.minecraft.src.Packet29DestroyEntity.class);
        func_73285_a(30, true, false, net.minecraft.src.Packet30Entity.class);
        func_73285_a(31, true, false, net.minecraft.src.Packet31RelEntityMove.class);
        func_73285_a(32, true, false, net.minecraft.src.Packet32EntityLook.class);
        func_73285_a(33, true, false, net.minecraft.src.Packet33RelEntityMoveLook.class);
        func_73285_a(34, true, false, net.minecraft.src.Packet34EntityTeleport.class);
        func_73285_a(35, true, false, net.minecraft.src.Packet35EntityHeadRotation.class);
        func_73285_a(38, true, false, net.minecraft.src.Packet38EntityStatus.class);
        func_73285_a(39, true, false, net.minecraft.src.Packet39AttachEntity.class);
        func_73285_a(40, true, false, net.minecraft.src.Packet40EntityMetadata.class);
        func_73285_a(41, true, false, net.minecraft.src.Packet41EntityEffect.class);
        func_73285_a(42, true, false, net.minecraft.src.Packet42RemoveEntityEffect.class);
        func_73285_a(43, true, false, net.minecraft.src.Packet43Experience.class);
        func_73285_a(51, true, false, net.minecraft.src.Packet51MapChunk.class);
        func_73285_a(52, true, false, net.minecraft.src.Packet52MultiBlockChange.class);
        func_73285_a(53, true, false, net.minecraft.src.Packet53BlockChange.class);
        func_73285_a(54, true, false, net.minecraft.src.Packet54PlayNoteBlock.class);
        func_73285_a(55, true, false, net.minecraft.src.Packet55BlockDestroy.class);
        func_73285_a(56, true, false, net.minecraft.src.Packet56MapChunks.class);
        func_73285_a(60, true, false, net.minecraft.src.Packet60Explosion.class);
        func_73285_a(61, true, false, net.minecraft.src.Packet61DoorChange.class);
        func_73285_a(62, true, false, net.minecraft.src.Packet62LevelSound.class);
        func_73285_a(70, true, false, net.minecraft.src.Packet70GameEvent.class);
        func_73285_a(71, true, false, net.minecraft.src.Packet71Weather.class);
        func_73285_a(100, true, false, net.minecraft.src.Packet100OpenWindow.class);
        func_73285_a(101, true, true, net.minecraft.src.Packet101CloseWindow.class);
        func_73285_a(102, false, true, net.minecraft.src.Packet102WindowClick.class);
        func_73285_a(103, true, false, net.minecraft.src.Packet103SetSlot.class);
        func_73285_a(104, true, false, net.minecraft.src.Packet104WindowItems.class);
        func_73285_a(105, true, false, net.minecraft.src.Packet105UpdateProgressbar.class);
        func_73285_a(106, true, true, net.minecraft.src.Packet106Transaction.class);
        func_73285_a(107, true, true, net.minecraft.src.Packet107CreativeSetSlot.class);
        func_73285_a(108, false, true, net.minecraft.src.Packet108EnchantItem.class);
        func_73285_a(130, true, true, net.minecraft.src.Packet130UpdateSign.class);
        func_73285_a(131, true, false, net.minecraft.src.Packet131MapData.class);
        func_73285_a(132, true, false, net.minecraft.src.Packet132TileEntityData.class);
        func_73285_a(200, true, false, net.minecraft.src.Packet200Statistic.class);
        func_73285_a(201, true, false, net.minecraft.src.Packet201PlayerInfo.class);
        func_73285_a(202, true, true, net.minecraft.src.Packet202PlayerAbilities.class);
        func_73285_a(203, true, true, net.minecraft.src.Packet203AutoComplete.class);
        func_73285_a(204, false, true, net.minecraft.src.Packet204ClientInfo.class);
        func_73285_a(205, false, true, net.minecraft.src.Packet205ClientCommand.class);
        func_73285_a(250, true, true, net.minecraft.src.Packet250CustomPayload.class);
        func_73285_a(252, true, true, net.minecraft.src.Packet252SharedKey.class);
        func_73285_a(253, true, false, net.minecraft.src.Packet253ServerAuthData.class);
        func_73285_a(254, false, true, net.minecraft.src.Packet254ServerPing.class);
        func_73285_a(255, true, true, net.minecraft.src.Packet255KickDisconnect.class);
    }
}
