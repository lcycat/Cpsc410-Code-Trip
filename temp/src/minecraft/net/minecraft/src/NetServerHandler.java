// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;
import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            NetHandler, IntHashMap, NetworkManager, EntityPlayerMP, 
//            Profiler, Packet0KeepAlive, Packet255KickDisconnect, Packet3Chat, 
//            ServerConfigurationManager, WorldServer, Packet10Flying, Entity, 
//            AxisAlignedBB, ItemInWorldManager, Packet13PlayerLookMove, Packet14BlockDig, 
//            WorldProvider, ChunkCoordinates, MathHelper, Packet53BlockChange, 
//            InventoryPlayer, Packet15Place, ItemStack, Container, 
//            Packet103SetSlot, Slot, Packet16BlockItemSwitch, ModLoader, 
//            ChatAllowedCharacters, ICommandManager, Packet18Animation, Packet19EntityAction, 
//            Packet7UseEntity, Packet205ClientCommand, WorldInfo, BanEntry, 
//            BanList, Packet102WindowClick, Packet106Transaction, Packet108EnchantItem, 
//            Packet107CreativeSetSlot, Item, EntityItem, Packet130UpdateSign, 
//            TileEntitySign, TileEntity, Packet202PlayerAbilities, PlayerCapabilities, 
//            Packet203AutoComplete, Packet250CustomPayload, Packet, ItemWritableBook, 
//            ItemEditableBook, ContainerMerchant, Packet9Respawn, Packet101CloseWindow, 
//            Packet204ClientInfo

public class NetServerHandler extends NetHandler
{

    public static Logger field_72577_a = Logger.getLogger("Minecraft");
    public NetworkManager field_72575_b;
    public boolean field_72576_c;
    private MinecraftServer field_72573_d;
    private EntityPlayerMP field_72574_e;
    private int field_72571_f;
    private int field_72572_g;
    private boolean field_72584_h;
    private int field_72585_i;
    private long field_72582_j;
    private static Random field_72583_k = new Random();
    private long field_72580_l;
    private int field_72581_m;
    private int field_72578_n;
    private double field_72579_o;
    private double field_72589_p;
    private double field_72588_q;
    private boolean field_72587_r;
    private IntHashMap field_72586_s;

    public NetServerHandler(MinecraftServer p_i3401_1_, NetworkManager p_i3401_2_, EntityPlayerMP p_i3401_3_)
    {
        field_72576_c = false;
        field_72581_m = 0;
        field_72578_n = 0;
        field_72587_r = true;
        field_72586_s = new IntHashMap();
        field_72573_d = p_i3401_1_;
        field_72575_b = p_i3401_2_;
        p_i3401_2_.func_74425_a(this);
        field_72574_e = p_i3401_3_;
        p_i3401_3_.field_71135_a = this;
    }

    public EntityPlayerMP getPlayer()
    {
        return field_72574_e;
    }

    public void func_72570_d()
    {
        field_72584_h = false;
        field_72571_f++;
        field_72573_d.field_71304_b.func_76320_a("packetflow");
        field_72575_b.func_74428_b();
        field_72573_d.field_71304_b.func_76318_c("keepAlive");
        if((long)field_72571_f - field_72580_l > 20L)
        {
            field_72580_l = field_72571_f;
            field_72582_j = System.nanoTime() / 0xf4240L;
            field_72585_i = field_72583_k.nextInt();
            func_72567_b(new Packet0KeepAlive(field_72585_i));
        }
        if(field_72581_m > 0)
        {
            field_72581_m--;
        }
        if(field_72578_n > 0)
        {
            field_72578_n--;
        }
        field_72573_d.field_71304_b.func_76318_c("playerTick");
        if(!field_72584_h && !field_72574_e.field_71136_j)
        {
            field_72574_e.func_71127_g();
        }
        field_72573_d.field_71304_b.func_76319_b();
    }

    public void func_72565_c(String p_72565_1_)
    {
        if(field_72576_c)
        {
            return;
        } else
        {
            field_72574_e.func_71123_m();
            func_72567_b(new Packet255KickDisconnect(p_72565_1_));
            field_72575_b.func_74423_d();
            field_72573_d.func_71203_ab().func_72384_a(new Packet3Chat((new StringBuilder()).append("\247e").append(field_72574_e.field_71092_bJ).append(" left the game.").toString()));
            field_72573_d.func_71203_ab().func_72367_e(field_72574_e);
            field_72576_c = true;
            return;
        }
    }

    public void func_72498_a(Packet10Flying p_72498_1_)
    {
        WorldServer worldserver = field_72573_d.func_71218_a(field_72574_e.field_71093_bK);
        field_72584_h = true;
        if(field_72574_e.field_71136_j)
        {
            return;
        }
        if(!field_72587_r)
        {
            double d = p_72498_1_.field_73543_b - field_72589_p;
            if(p_72498_1_.field_73545_a == field_72579_o && d * d < 0.01D && p_72498_1_.field_73544_c == field_72588_q)
            {
                field_72587_r = true;
            }
        }
        if(field_72587_r)
        {
            if(field_72574_e.field_70154_o != null)
            {
                float f = field_72574_e.field_70177_z;
                float f1 = field_72574_e.field_70125_A;
                field_72574_e.field_70154_o.func_70043_V();
                double d2 = field_72574_e.field_70165_t;
                double d4 = field_72574_e.field_70163_u;
                double d6 = field_72574_e.field_70161_v;
                double d8 = 0.0D;
                double d9 = 0.0D;
                if(p_72498_1_.field_73547_i)
                {
                    f = p_72498_1_.field_73542_e;
                    f1 = p_72498_1_.field_73539_f;
                }
                if(p_72498_1_.field_73546_h && p_72498_1_.field_73543_b == -999D && p_72498_1_.field_73541_d == -999D)
                {
                    if(p_72498_1_.field_73545_a > 1.0D || p_72498_1_.field_73544_c > 1.0D)
                    {
                        System.err.println((new StringBuilder()).append(field_72574_e.field_71092_bJ).append(" was caught trying to crash the server with an invalid position.").toString());
                        func_72565_c("Nope!");
                        return;
                    }
                    d8 = p_72498_1_.field_73545_a;
                    d9 = p_72498_1_.field_73544_c;
                }
                field_72574_e.field_70122_E = p_72498_1_.field_73540_g;
                field_72574_e.func_71127_g();
                field_72574_e.func_70091_d(d8, 0.0D, d9);
                field_72574_e.func_70080_a(d2, d4, d6, f, f1);
                field_72574_e.field_70159_w = d8;
                field_72574_e.field_70179_y = d9;
                if(field_72574_e.field_70154_o != null)
                {
                    worldserver.func_73050_b(field_72574_e.field_70154_o, true);
                }
                if(field_72574_e.field_70154_o != null)
                {
                    field_72574_e.field_70154_o.func_70043_V();
                }
                field_72573_d.func_71203_ab().func_72358_d(field_72574_e);
                field_72579_o = field_72574_e.field_70165_t;
                field_72589_p = field_72574_e.field_70163_u;
                field_72588_q = field_72574_e.field_70161_v;
                worldserver.func_72870_g(field_72574_e);
                return;
            }
            if(field_72574_e.func_70608_bn())
            {
                field_72574_e.func_71127_g();
                field_72574_e.func_70080_a(field_72579_o, field_72589_p, field_72588_q, field_72574_e.field_70177_z, field_72574_e.field_70125_A);
                worldserver.func_72870_g(field_72574_e);
                return;
            }
            double d1 = field_72574_e.field_70163_u;
            field_72579_o = field_72574_e.field_70165_t;
            field_72589_p = field_72574_e.field_70163_u;
            field_72588_q = field_72574_e.field_70161_v;
            double d3 = field_72574_e.field_70165_t;
            double d5 = field_72574_e.field_70163_u;
            double d7 = field_72574_e.field_70161_v;
            float f2 = field_72574_e.field_70177_z;
            float f3 = field_72574_e.field_70125_A;
            if(p_72498_1_.field_73546_h && p_72498_1_.field_73543_b == -999D && p_72498_1_.field_73541_d == -999D)
            {
                p_72498_1_.field_73546_h = false;
            }
            if(p_72498_1_.field_73546_h)
            {
                d3 = p_72498_1_.field_73545_a;
                d5 = p_72498_1_.field_73543_b;
                d7 = p_72498_1_.field_73544_c;
                double d10 = p_72498_1_.field_73541_d - p_72498_1_.field_73543_b;
                if(!field_72574_e.func_70608_bn() && (d10 > 1.6499999999999999D || d10 < 0.10000000000000001D))
                {
                    func_72565_c("Illegal stance");
                    field_72577_a.warning((new StringBuilder()).append(field_72574_e.field_71092_bJ).append(" had an illegal stance: ").append(d10).toString());
                    return;
                }
                if(Math.abs(p_72498_1_.field_73545_a) > 32000000D || Math.abs(p_72498_1_.field_73544_c) > 32000000D)
                {
                    func_72565_c("Illegal position");
                    return;
                }
            }
            if(p_72498_1_.field_73547_i)
            {
                f2 = p_72498_1_.field_73542_e;
                f3 = p_72498_1_.field_73539_f;
            }
            field_72574_e.func_71127_g();
            field_72574_e.field_70139_V = 0.0F;
            field_72574_e.func_70080_a(field_72579_o, field_72589_p, field_72588_q, f2, f3);
            if(!field_72587_r)
            {
                return;
            }
            double d11 = d3 - field_72574_e.field_70165_t;
            double d12 = d5 - field_72574_e.field_70163_u;
            double d13 = d7 - field_72574_e.field_70161_v;
            double d14 = Math.min(Math.abs(d11), Math.abs(field_72574_e.field_70159_w));
            double d15 = Math.min(Math.abs(d12), Math.abs(field_72574_e.field_70181_x));
            double d16 = Math.min(Math.abs(d13), Math.abs(field_72574_e.field_70179_y));
            double d17 = d14 * d14 + d15 * d15 + d16 * d16;
            if(d17 > 100D && (!field_72573_d.func_71264_H() || !field_72573_d.func_71214_G().equals(field_72574_e.field_71092_bJ)))
            {
                field_72577_a.warning((new StringBuilder()).append(field_72574_e.field_71092_bJ).append(" moved too quickly! ").append(d11).append(",").append(d12).append(",").append(d13).append(" (").append(d14).append(", ").append(d15).append(", ").append(d16).append(")").toString());
                func_72569_a(field_72579_o, field_72589_p, field_72588_q, field_72574_e.field_70177_z, field_72574_e.field_70125_A);
                return;
            }
            float f4 = 0.0625F;
            boolean flag = worldserver.func_72945_a(field_72574_e, field_72574_e.field_70121_D.func_72329_c().func_72331_e(f4, f4, f4)).isEmpty();
            if(field_72574_e.field_70122_E && !p_72498_1_.field_73540_g && d12 > 0.0D)
            {
                field_72574_e.func_71020_j(0.2F);
            }
            field_72574_e.func_70091_d(d11, d12, d13);
            field_72574_e.field_70122_E = p_72498_1_.field_73540_g;
            field_72574_e.func_71000_j(d11, d12, d13);
            double d18 = d12;
            d11 = d3 - field_72574_e.field_70165_t;
            d12 = d5 - field_72574_e.field_70163_u;
            if(d12 > -0.5D || d12 < 0.5D)
            {
                d12 = 0.0D;
            }
            d13 = d7 - field_72574_e.field_70161_v;
            d17 = d11 * d11 + d12 * d12 + d13 * d13;
            boolean flag1 = false;
            if(d17 > 0.0625D && !field_72574_e.func_70608_bn() && !field_72574_e.field_71134_c.func_73083_d())
            {
                flag1 = true;
                field_72577_a.warning((new StringBuilder()).append(field_72574_e.field_71092_bJ).append(" moved wrongly!").toString());
            }
            field_72574_e.func_70080_a(d3, d5, d7, f2, f3);
            boolean flag2 = worldserver.func_72945_a(field_72574_e, field_72574_e.field_70121_D.func_72329_c().func_72331_e(f4, f4, f4)).isEmpty();
            if(flag && (flag1 || !flag2) && !field_72574_e.func_70608_bn())
            {
                func_72569_a(field_72579_o, field_72589_p, field_72588_q, f2, f3);
                return;
            }
            AxisAlignedBB axisalignedbb = field_72574_e.field_70121_D.func_72329_c().func_72314_b(f4, f4, f4).func_72321_a(0.0D, -0.55000000000000004D, 0.0D);
            if(!field_72573_d.func_71231_X() && !field_72574_e.field_71134_c.func_73083_d() && !worldserver.func_72829_c(axisalignedbb))
            {
                if(d18 >= -0.03125D)
                {
                    field_72572_g++;
                    if(field_72572_g > 80)
                    {
                        field_72577_a.warning((new StringBuilder()).append(field_72574_e.field_71092_bJ).append(" was kicked for floating too long!").toString());
                        func_72565_c("Flying is not enabled on this server");
                        return;
                    }
                }
            } else
            {
                field_72572_g = 0;
            }
            field_72574_e.field_70122_E = p_72498_1_.field_73540_g;
            field_72573_d.func_71203_ab().func_72358_d(field_72574_e);
            field_72574_e.func_71122_b(field_72574_e.field_70163_u - d1, p_72498_1_.field_73540_g);
        }
    }

    public void func_72569_a(double p_72569_1_, double p_72569_3_, double p_72569_5_, float p_72569_7_, 
            float p_72569_8_)
    {
        field_72587_r = false;
        field_72579_o = p_72569_1_;
        field_72589_p = p_72569_3_;
        field_72588_q = p_72569_5_;
        field_72574_e.func_70080_a(p_72569_1_, p_72569_3_, p_72569_5_, p_72569_7_, p_72569_8_);
        field_72574_e.field_71135_a.func_72567_b(new Packet13PlayerLookMove(p_72569_1_, p_72569_3_ + 1.6200000047683716D, p_72569_3_, p_72569_5_, p_72569_7_, p_72569_8_, false));
    }

    public void func_72510_a(Packet14BlockDig p_72510_1_)
    {
        WorldServer worldserver = field_72573_d.func_71218_a(field_72574_e.field_71093_bK);
        if(p_72510_1_.field_73342_e == 4)
        {
            field_72574_e.func_71040_bB();
            return;
        }
        if(p_72510_1_.field_73342_e == 5)
        {
            field_72574_e.func_71034_by();
            return;
        }
        boolean flag = worldserver.field_73060_c = worldserver.field_73011_w.field_76574_g != 0 || field_72573_d.func_71203_ab().func_72353_e(field_72574_e.field_71092_bJ) || field_72573_d.func_71264_H();
        boolean flag1 = false;
        if(p_72510_1_.field_73342_e == 0)
        {
            flag1 = true;
        }
        if(p_72510_1_.field_73342_e == 2)
        {
            flag1 = true;
        }
        int i = p_72510_1_.field_73345_a;
        int j = p_72510_1_.field_73343_b;
        int k = p_72510_1_.field_73344_c;
        if(flag1)
        {
            double d = field_72574_e.field_70165_t - ((double)i + 0.5D);
            double d1 = (field_72574_e.field_70163_u - ((double)j + 0.5D)) + 1.5D;
            double d3 = field_72574_e.field_70161_v - ((double)k + 0.5D);
            double d5 = d * d + d1 * d1 + d3 * d3;
            if(d5 > 36D)
            {
                return;
            }
            if(j >= field_72573_d.func_71207_Z())
            {
                return;
            }
        }
        ChunkCoordinates chunkcoordinates = worldserver.func_72861_E();
        int l = MathHelper.func_76130_a(i - chunkcoordinates.field_71574_a);
        int i1 = MathHelper.func_76130_a(k - chunkcoordinates.field_71573_c);
        if(l > i1)
        {
            i1 = l;
        }
        if(p_72510_1_.field_73342_e == 0)
        {
            if(i1 > 16 || flag)
            {
                field_72574_e.field_71134_c.func_73074_a(i, j, k, p_72510_1_.field_73341_d);
            } else
            {
                field_72574_e.field_71135_a.func_72567_b(new Packet53BlockChange(i, j, k, worldserver));
            }
        } else
        if(p_72510_1_.field_73342_e == 2)
        {
            field_72574_e.field_71134_c.func_73082_a(i, j, k);
            if(worldserver.func_72798_a(i, j, k) != 0)
            {
                field_72574_e.field_71135_a.func_72567_b(new Packet53BlockChange(i, j, k, worldserver));
            }
        } else
        if(p_72510_1_.field_73342_e == 1)
        {
            field_72574_e.field_71134_c.func_73073_c(i, j, k);
            if(worldserver.func_72798_a(i, j, k) != 0)
            {
                field_72574_e.field_71135_a.func_72567_b(new Packet53BlockChange(i, j, k, worldserver));
            }
        } else
        if(p_72510_1_.field_73342_e == 3)
        {
            double d2 = field_72574_e.field_70165_t - ((double)i + 0.5D);
            double d4 = field_72574_e.field_70163_u - ((double)j + 0.5D);
            double d6 = field_72574_e.field_70161_v - ((double)k + 0.5D);
            double d7 = d2 * d2 + d4 * d4 + d6 * d6;
            if(d7 < 256D)
            {
                field_72574_e.field_71135_a.func_72567_b(new Packet53BlockChange(i, j, k, worldserver));
            }
        }
        worldserver.field_73060_c = false;
    }

    public void func_72472_a(Packet15Place p_72472_1_)
    {
        WorldServer worldserver = field_72573_d.func_71218_a(field_72574_e.field_71093_bK);
        ItemStack itemstack = field_72574_e.field_71071_by.func_70448_g();
        boolean flag = false;
        int i = p_72472_1_.func_73403_d();
        int j = p_72472_1_.func_73402_f();
        int k = p_72472_1_.func_73407_g();
        int l = p_72472_1_.func_73401_h();
        boolean flag1 = worldserver.field_73060_c = worldserver.field_73011_w.field_76574_g != 0 || field_72573_d.func_71203_ab().func_72353_e(field_72574_e.field_71092_bJ) || field_72573_d.func_71264_H();
        if(p_72472_1_.func_73401_h() == 255)
        {
            if(itemstack == null)
            {
                return;
            }
            field_72574_e.field_71134_c.func_73085_a(field_72574_e, worldserver, itemstack);
        } else
        if(p_72472_1_.func_73402_f() < field_72573_d.func_71207_Z() - 1 || p_72472_1_.func_73401_h() != 1 && p_72472_1_.func_73402_f() < field_72573_d.func_71207_Z())
        {
            ChunkCoordinates chunkcoordinates = worldserver.func_72861_E();
            int i1 = MathHelper.func_76130_a(i - chunkcoordinates.field_71574_a);
            int j1 = MathHelper.func_76130_a(k - chunkcoordinates.field_71573_c);
            if(i1 > j1)
            {
                j1 = i1;
            }
            if(field_72587_r && field_72574_e.func_70092_e((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D) < 64D && (j1 > 16 || flag1))
            {
                field_72574_e.field_71134_c.func_73078_a(field_72574_e, worldserver, itemstack, i, j, k, l, p_72472_1_.func_73406_j(), p_72472_1_.func_73404_l(), p_72472_1_.func_73408_m());
            }
            flag = true;
        } else
        {
            field_72574_e.field_71135_a.func_72567_b(new Packet3Chat((new StringBuilder()).append("\2477Height limit for building is ").append(field_72573_d.func_71207_Z()).toString()));
            flag = true;
        }
        if(flag)
        {
            field_72574_e.field_71135_a.func_72567_b(new Packet53BlockChange(i, j, k, worldserver));
            if(l == 0)
            {
                j--;
            }
            if(l == 1)
            {
                j++;
            }
            if(l == 2)
            {
                k--;
            }
            if(l == 3)
            {
                k++;
            }
            if(l == 4)
            {
                i--;
            }
            if(l == 5)
            {
                i++;
            }
            field_72574_e.field_71135_a.func_72567_b(new Packet53BlockChange(i, j, k, worldserver));
        }
        itemstack = field_72574_e.field_71071_by.func_70448_g();
        if(itemstack != null && itemstack.field_77994_a == 0)
        {
            field_72574_e.field_71071_by.field_70462_a[field_72574_e.field_71071_by.field_70461_c] = null;
            itemstack = null;
        }
        if(itemstack == null || itemstack.func_77988_m() == 0)
        {
            field_72574_e.field_71137_h = true;
            field_72574_e.field_71071_by.field_70462_a[field_72574_e.field_71071_by.field_70461_c] = ItemStack.func_77944_b(field_72574_e.field_71071_by.field_70462_a[field_72574_e.field_71071_by.field_70461_c]);
            Slot slot = field_72574_e.field_71070_bA.func_75147_a(field_72574_e.field_71071_by, field_72574_e.field_71071_by.field_70461_c);
            field_72574_e.field_71070_bA.func_75142_b();
            field_72574_e.field_71137_h = false;
            if(!ItemStack.func_77989_b(field_72574_e.field_71071_by.func_70448_g(), p_72472_1_.func_73405_i()))
            {
                func_72567_b(new Packet103SetSlot(field_72574_e.field_71070_bA.field_75152_c, slot.field_75222_d, field_72574_e.field_71071_by.func_70448_g()));
            }
        }
        worldserver.field_73060_c = false;
    }

    public void func_72515_a(String p_72515_1_, Object p_72515_2_[])
    {
        field_72577_a.info((new StringBuilder()).append(field_72574_e.field_71092_bJ).append(" lost connection: ").append(p_72515_1_).toString());
        field_72573_d.func_71203_ab().func_72384_a(new Packet3Chat((new StringBuilder()).append("\247e").append(field_72574_e.field_71092_bJ).append(" left the game.").toString()));
        field_72573_d.func_71203_ab().func_72367_e(field_72574_e);
        field_72576_c = true;
        if(field_72573_d.func_71264_H() && field_72574_e.field_71092_bJ.equals(field_72573_d.func_71214_G()))
        {
            field_72577_a.info("Stopping singleplayer server as player logged out");
            field_72573_d.func_71263_m();
        }
    }

    public void func_72509_a(Packet p_72509_1_)
    {
        field_72577_a.warning((new StringBuilder()).append(getClass()).append(" wasn't prepared to deal with a ").append(p_72509_1_.getClass()).toString());
        func_72565_c("Protocol error, unexpected packet");
    }

    public void func_72567_b(Packet p_72567_1_)
    {
        if(p_72567_1_ instanceof Packet3Chat)
        {
            Packet3Chat packet3chat = (Packet3Chat)p_72567_1_;
            int i = field_72574_e.func_71126_v();
            if(i == 2)
            {
                return;
            }
            if(i == 1 && !packet3chat.func_73475_d())
            {
                return;
            }
        }
        field_72575_b.func_74429_a(p_72567_1_);
    }

    public void func_72502_a(Packet16BlockItemSwitch p_72502_1_)
    {
        if(p_72502_1_.field_73386_a < 0 || p_72502_1_.field_73386_a >= InventoryPlayer.func_70451_h())
        {
            field_72577_a.warning((new StringBuilder()).append(field_72574_e.field_71092_bJ).append(" tried to set an invalid carried item").toString());
            return;
        } else
        {
            field_72574_e.field_71071_by.field_70461_c = p_72502_1_.field_73386_a;
            return;
        }
    }

    public void func_72481_a(Packet3Chat p_72481_1_)
    {
        ModLoader.serverChat(this, p_72481_1_.field_73476_b);
        if(field_72574_e.func_71126_v() == 2)
        {
            func_72567_b(new Packet3Chat("Cannot send chat message."));
            return;
        }
        String s = p_72481_1_.field_73476_b;
        if(s.length() > 100)
        {
            func_72565_c("Chat message too long");
            return;
        }
        s = s.trim();
        for(int i = 0; i < s.length(); i++)
        {
            if(!ChatAllowedCharacters.func_71566_a(s.charAt(i)))
            {
                func_72565_c("Illegal characters in chat");
                return;
            }
        }

        if(s.startsWith("/"))
        {
            func_72566_d(s);
        } else
        {
            if(field_72574_e.func_71126_v() == 1)
            {
                func_72567_b(new Packet3Chat("Cannot send chat message."));
                return;
            }
            s = (new StringBuilder()).append("<").append(field_72574_e.field_71092_bJ).append("> ").append(s).toString();
            field_72577_a.info(s);
            field_72573_d.func_71203_ab().func_72384_a(new Packet3Chat(s, false));
        }
        field_72581_m += 20;
        if(field_72581_m > 200 && !field_72573_d.func_71203_ab().func_72353_e(field_72574_e.field_71092_bJ))
        {
            func_72565_c("disconnect.spam");
        }
    }

    private void func_72566_d(String p_72566_1_)
    {
        if(field_72573_d.func_71203_ab().func_72353_e(field_72574_e.field_71092_bJ) || "/seed".equals(p_72566_1_))
        {
            field_72577_a.info((new StringBuilder()).append(field_72574_e.field_71092_bJ).append(" issued server command: ").append(p_72566_1_).toString());
            field_72573_d.func_71187_D().func_71556_a(field_72574_e, p_72566_1_);
        }
    }

    public void func_72524_a(Packet18Animation p_72524_1_)
    {
        if(p_72524_1_.field_73469_b == 1)
        {
            field_72574_e.func_71038_i();
        }
    }

    public void func_72473_a(Packet19EntityAction p_72473_1_)
    {
        if(p_72473_1_.field_73366_b == 1)
        {
            field_72574_e.func_70095_a(true);
        } else
        if(p_72473_1_.field_73366_b == 2)
        {
            field_72574_e.func_70095_a(false);
        } else
        if(p_72473_1_.field_73366_b == 4)
        {
            field_72574_e.func_70031_b(true);
        } else
        if(p_72473_1_.field_73366_b == 5)
        {
            field_72574_e.func_70031_b(false);
        } else
        if(p_72473_1_.field_73366_b == 3)
        {
            field_72574_e.func_70999_a(false, true, true);
            field_72587_r = false;
        }
    }

    public void func_72492_a(Packet255KickDisconnect p_72492_1_)
    {
        field_72575_b.func_74424_a("disconnect.quitting", new Object[0]);
    }

    public int func_72568_e()
    {
        return field_72575_b.func_74426_e();
    }

    public void func_72507_a(Packet7UseEntity p_72507_1_)
    {
        WorldServer worldserver = field_72573_d.func_71218_a(field_72574_e.field_71093_bK);
        Entity entity = worldserver.func_73045_a(p_72507_1_.field_73604_b);
        if(entity != null)
        {
            boolean flag = field_72574_e.func_70685_l(entity);
            double d = 36D;
            if(!flag)
            {
                d = 9D;
            }
            if(field_72574_e.func_70068_e(entity) < d)
            {
                if(p_72507_1_.field_73605_c == 0)
                {
                    field_72574_e.func_70998_m(entity);
                } else
                if(p_72507_1_.field_73605_c == 1)
                {
                    field_72574_e.func_71059_n(entity);
                }
            }
        }
    }

    public void func_72458_a(Packet205ClientCommand p_72458_1_)
    {
        if(p_72458_1_.field_73447_a == 1)
        {
            if(field_72574_e.field_71136_j)
            {
                field_72574_e = field_72573_d.func_71203_ab().func_72368_a(field_72574_e, 0, true);
            } else
            if(field_72574_e.func_71121_q().func_72912_H().func_76093_s())
            {
                if(field_72573_d.func_71264_H() && field_72574_e.field_71092_bJ.equals(field_72573_d.func_71214_G()))
                {
                    field_72574_e.field_71135_a.func_72565_c("You have died. Game over, man, it's game over!");
                    field_72573_d.func_71272_O();
                } else
                {
                    BanEntry banentry = new BanEntry(field_72574_e.field_71092_bJ);
                    banentry.func_73689_b("Death in Hardcore");
                    field_72573_d.func_71203_ab().func_72390_e().func_73706_a(banentry);
                    field_72574_e.field_71135_a.func_72565_c("You have died. Game over, man, it's game over!");
                }
            } else
            {
                if(field_72574_e.func_70630_aN() > 0)
                {
                    return;
                }
                field_72574_e = field_72573_d.func_71203_ab().func_72368_a(field_72574_e, 0, false);
            }
        }
    }

    public boolean func_72469_b()
    {
        return true;
    }

    public void func_72483_a(Packet9Respawn packet9respawn)
    {
    }

    public void func_72474_a(Packet101CloseWindow p_72474_1_)
    {
        field_72574_e.func_71128_l();
    }

    public void func_72523_a(Packet102WindowClick p_72523_1_)
    {
        if(field_72574_e.field_71070_bA.field_75152_c == p_72523_1_.field_73444_a && field_72574_e.field_71070_bA.func_75129_b(field_72574_e))
        {
            ItemStack itemstack = field_72574_e.field_71070_bA.func_75144_a(p_72523_1_.field_73442_b, p_72523_1_.field_73443_c, p_72523_1_.field_73439_f, field_72574_e);
            if(ItemStack.func_77989_b(p_72523_1_.field_73441_e, itemstack))
            {
                field_72574_e.field_71135_a.func_72567_b(new Packet106Transaction(p_72523_1_.field_73444_a, p_72523_1_.field_73440_d, true));
                field_72574_e.field_71137_h = true;
                field_72574_e.field_71070_bA.func_75142_b();
                field_72574_e.func_71113_k();
                field_72574_e.field_71137_h = false;
            } else
            {
                field_72586_s.func_76038_a(field_72574_e.field_71070_bA.field_75152_c, Short.valueOf(p_72523_1_.field_73440_d));
                field_72574_e.field_71135_a.func_72567_b(new Packet106Transaction(p_72523_1_.field_73444_a, p_72523_1_.field_73440_d, false));
                field_72574_e.field_71070_bA.func_75128_a(field_72574_e, false);
                ArrayList arraylist = new ArrayList();
                for(int i = 0; i < field_72574_e.field_71070_bA.field_75151_b.size(); i++)
                {
                    arraylist.add(((Slot)field_72574_e.field_71070_bA.field_75151_b.get(i)).func_75211_c());
                }

                field_72574_e.func_71110_a(field_72574_e.field_71070_bA, arraylist);
            }
        }
    }

    public void func_72479_a(Packet108EnchantItem p_72479_1_)
    {
        if(field_72574_e.field_71070_bA.field_75152_c == p_72479_1_.field_73446_a && field_72574_e.field_71070_bA.func_75129_b(field_72574_e))
        {
            field_72574_e.field_71070_bA.func_75140_a(field_72574_e, p_72479_1_.field_73445_b);
            field_72574_e.field_71070_bA.func_75142_b();
        }
    }

    public void func_72464_a(Packet107CreativeSetSlot p_72464_1_)
    {
        if(field_72574_e.field_71134_c.func_73083_d())
        {
            boolean flag = p_72464_1_.field_73385_a < 0;
            ItemStack itemstack = p_72464_1_.field_73384_b;
            boolean flag1 = p_72464_1_.field_73385_a >= 1 && p_72464_1_.field_73385_a < 36 + InventoryPlayer.func_70451_h();
            boolean flag2 = itemstack == null || itemstack.field_77993_c < Item.field_77698_e.length && itemstack.field_77993_c >= 0 && Item.field_77698_e[itemstack.field_77993_c] != null;
            boolean flag3 = itemstack == null || itemstack.func_77960_j() >= 0 && itemstack.func_77960_j() >= 0 && itemstack.field_77994_a <= 64 && itemstack.field_77994_a > 0;
            if(flag1 && flag2 && flag3)
            {
                if(itemstack == null)
                {
                    field_72574_e.field_71069_bz.func_75141_a(p_72464_1_.field_73385_a, null);
                } else
                {
                    field_72574_e.field_71069_bz.func_75141_a(p_72464_1_.field_73385_a, itemstack);
                }
                field_72574_e.field_71069_bz.func_75128_a(field_72574_e, true);
            } else
            if(flag && flag2 && flag3 && field_72578_n < 200)
            {
                field_72578_n += 20;
                EntityItem entityitem = field_72574_e.func_71021_b(itemstack);
                if(entityitem != null)
                {
                    entityitem.func_70288_d();
                }
            }
        }
    }

    public void func_72476_a(Packet106Transaction p_72476_1_)
    {
        Short short1 = (Short)field_72586_s.func_76041_a(field_72574_e.field_71070_bA.field_75152_c);
        if(short1 != null && p_72476_1_.field_73433_b == short1.shortValue() && field_72574_e.field_71070_bA.field_75152_c == p_72476_1_.field_73435_a && !field_72574_e.field_71070_bA.func_75129_b(field_72574_e))
        {
            field_72574_e.field_71070_bA.func_75128_a(field_72574_e, true);
        }
    }

    public void func_72487_a(Packet130UpdateSign p_72487_1_)
    {
        WorldServer worldserver = field_72573_d.func_71218_a(field_72574_e.field_71093_bK);
        if(worldserver.func_72899_e(p_72487_1_.field_73311_a, p_72487_1_.field_73309_b, p_72487_1_.field_73310_c))
        {
            TileEntity tileentity = worldserver.func_72796_p(p_72487_1_.field_73311_a, p_72487_1_.field_73309_b, p_72487_1_.field_73310_c);
            if(tileentity instanceof TileEntitySign)
            {
                TileEntitySign tileentitysign = (TileEntitySign)tileentity;
                if(!tileentitysign.func_70409_a())
                {
                    field_72573_d.func_71236_h((new StringBuilder()).append("Player ").append(field_72574_e.field_71092_bJ).append(" just tried to change non-editable sign").toString());
                    return;
                }
            }
            for(int i = 0; i < 4; i++)
            {
                boolean flag = true;
                if(p_72487_1_.field_73308_d[i].length() > 15)
                {
                    flag = false;
                } else
                {
                    for(int l = 0; l < p_72487_1_.field_73308_d[i].length(); l++)
                    {
                        if(ChatAllowedCharacters.field_71568_a.indexOf(p_72487_1_.field_73308_d[i].charAt(l)) < 0)
                        {
                            flag = false;
                        }
                    }

                }
                if(!flag)
                {
                    p_72487_1_.field_73308_d[i] = "!?";
                }
            }

            if(tileentity instanceof TileEntitySign)
            {
                int j = p_72487_1_.field_73311_a;
                int k = p_72487_1_.field_73309_b;
                int i1 = p_72487_1_.field_73310_c;
                TileEntitySign tileentitysign1 = (TileEntitySign)tileentity;
                System.arraycopy(p_72487_1_.field_73308_d, 0, tileentitysign1.field_70412_a, 0, 4);
                tileentitysign1.func_70296_d();
                worldserver.func_72845_h(j, k, i1);
            }
        }
    }

    public void func_72477_a(Packet0KeepAlive p_72477_1_)
    {
        if(p_72477_1_.field_73592_a == field_72585_i)
        {
            int i = (int)(System.nanoTime() / 0xf4240L - field_72582_j);
            field_72574_e.field_71138_i = (field_72574_e.field_71138_i * 3 + i) / 4;
        }
    }

    public boolean func_72489_a()
    {
        return true;
    }

    public void func_72471_a(Packet202PlayerAbilities p_72471_1_)
    {
        field_72574_e.field_71075_bZ.field_75100_b = p_72471_1_.func_73350_f() && field_72574_e.field_71075_bZ.field_75101_c;
    }

    public void func_72461_a(Packet203AutoComplete p_72461_1_)
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s;
        for(Iterator iterator = field_72573_d.func_71248_a(field_72574_e, p_72461_1_.func_73473_d()).iterator(); iterator.hasNext(); stringbuilder.append(s))
        {
            s = (String)iterator.next();
            if(stringbuilder.length() > 0)
            {
                stringbuilder.append("\0");
            }
        }

        field_72574_e.field_71135_a.func_72567_b(new Packet203AutoComplete(stringbuilder.toString()));
    }

    public void func_72504_a(Packet204ClientInfo p_72504_1_)
    {
        field_72574_e.func_71125_a(p_72504_1_);
    }

    public void func_72501_a(Packet250CustomPayload p_72501_1_)
    {
        if("MC|BEdit".equals(p_72501_1_.field_73630_a))
        {
            try
            {
                DataInputStream datainputstream = new DataInputStream(new ByteArrayInputStream(p_72501_1_.field_73629_c));
                ItemStack itemstack = Packet.func_73276_c(datainputstream);
                if(!ItemWritableBook.func_77829_a(itemstack.func_77978_p()))
                {
                    throw new IOException("Invalid book tag!");
                }
                ItemStack itemstack2 = field_72574_e.field_71071_by.func_70448_g();
                if(itemstack != null && itemstack.field_77993_c == Item.field_77821_bF.field_77779_bT && itemstack.field_77993_c == itemstack2.field_77993_c)
                {
                    itemstack2.func_77982_d(itemstack.func_77978_p());
                }
            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        } else
        if("MC|BSign".equals(p_72501_1_.field_73630_a))
        {
            try
            {
                DataInputStream datainputstream1 = new DataInputStream(new ByteArrayInputStream(p_72501_1_.field_73629_c));
                ItemStack itemstack1 = Packet.func_73276_c(datainputstream1);
                if(!ItemEditableBook.func_77828_a(itemstack1.func_77978_p()))
                {
                    throw new IOException("Invalid book tag!");
                }
                ItemStack itemstack3 = field_72574_e.field_71071_by.func_70448_g();
                if(itemstack1 != null && itemstack1.field_77993_c == Item.field_77823_bG.field_77779_bT && itemstack3.field_77993_c == Item.field_77821_bF.field_77779_bT)
                {
                    itemstack3.func_77982_d(itemstack1.func_77978_p());
                    itemstack3.field_77993_c = Item.field_77823_bG.field_77779_bT;
                }
            }
            catch(Exception exception1)
            {
                exception1.printStackTrace();
            }
        } else
        if("MC|TrSel".equals(p_72501_1_.field_73630_a))
        {
            try
            {
                DataInputStream datainputstream2 = new DataInputStream(new ByteArrayInputStream(p_72501_1_.field_73629_c));
                int i = datainputstream2.readInt();
                Container container = field_72574_e.field_71070_bA;
                if(container instanceof ContainerMerchant)
                {
                    ((ContainerMerchant)container).func_75175_c(i);
                }
            }
            catch(Exception exception2)
            {
                exception2.printStackTrace();
            }
        } else
        {
            ModLoader.serverCustomPayload(this, p_72501_1_);
        }
    }

}
