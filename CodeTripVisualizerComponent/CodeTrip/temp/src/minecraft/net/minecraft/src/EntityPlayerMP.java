// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.*;
import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            EntityPlayer, ICrafting, StringTranslate, ItemStack, 
//            ItemInWorldManager, ServerConfigurationManager, World, ChunkCoordinates, 
//            WorldProvider, WorldInfo, EnumGameType, NBTTagCompound, 
//            Container, WorldServer, Packet5PlayerInventory, EntityTracker, 
//            ChunkCoordIntPair, Packet56MapChunks, NetServerHandler, TileEntity, 
//            Packet29DestroyEntity, InventoryPlayer, Item, ItemMapBase, 
//            AchievementList, FoodStats, Packet8UpdateHealth, Packet43Experience, 
//            Packet3Chat, DamageSource, EntityDamageSource, EntityArrow, 
//            Packet70GameEvent, Entity, EntityItem, Packet22Collect, 
//            EntityXPOrb, Packet18Animation, EnumStatus, Packet17Sleep, 
//            Packet39AttachEntity, Packet100OpenWindow, ContainerWorkbench, ContainerEnchantment, 
//            IInventory, ContainerChest, TileEntityFurnace, ContainerFurnace, 
//            TileEntityDispenser, ContainerDispenser, TileEntityBrewingStand, ContainerBrewingStand, 
//            ContainerMerchant, IMerchant, MerchantRecipeList, Packet250CustomPayload, 
//            SlotCrafting, Packet103SetSlot, Packet104WindowItems, Packet105UpdateProgressbar, 
//            Packet101CloseWindow, StatBase, Packet200Statistic, Packet38EntityStatus, 
//            EnumAction, Packet41EntityEffect, Packet42RemoveEntityEffect, Packet202PlayerAbilities, 
//            NetworkManager, Packet204ClientInfo, PotionEffect

public class EntityPlayerMP extends EntityPlayer
    implements ICrafting
{

    private StringTranslate field_71148_cg;
    public NetServerHandler field_71135_a;
    public MinecraftServer field_71133_b;
    public ItemInWorldManager field_71134_c;
    public double field_71131_d;
    public double field_71132_e;
    public final List field_71129_f = new LinkedList();
    public final List field_71130_g = new LinkedList();
    private int field_71149_ch;
    private int field_71146_ci;
    private boolean field_71147_cj;
    private int field_71144_ck;
    private int field_71145_cl;
    private int field_71142_cm;
    private int field_71143_cn;
    private boolean field_71140_co;
    private ItemStack field_71141_cp[] = {
        null, null, null, null, null
    };
    private int field_71139_cq;
    public boolean field_71137_h;
    public int field_71138_i;
    public boolean field_71136_j;

    public EntityPlayerMP(MinecraftServer p_i3396_1_, World p_i3396_2_, String p_i3396_3_, ItemInWorldManager p_i3396_4_)
    {
        super(p_i3396_2_);
        field_71148_cg = new StringTranslate("en_US");
        field_71149_ch = 0xfa0a1f01;
        field_71146_ci = 0xfa0a1f01;
        field_71147_cj = true;
        field_71144_ck = 0xfa0a1f01;
        field_71145_cl = 60;
        field_71142_cm = 0;
        field_71143_cn = 0;
        field_71140_co = true;
        field_71139_cq = 0;
        field_71136_j = false;
        p_i3396_4_.field_73090_b = this;
        field_71134_c = p_i3396_4_;
        field_71142_cm = p_i3396_1_.func_71203_ab().func_72395_o();
        ChunkCoordinates chunkcoordinates = p_i3396_2_.func_72861_E();
        int i = chunkcoordinates.field_71574_a;
        int j = chunkcoordinates.field_71573_c;
        int k = chunkcoordinates.field_71572_b;
        if(!p_i3396_2_.field_73011_w.field_76576_e && p_i3396_2_.func_72912_H().func_76077_q() != EnumGameType.ADVENTURE)
        {
            i += field_70146_Z.nextInt(20) - 10;
            k = p_i3396_2_.func_72825_h(i, j);
            j += field_70146_Z.nextInt(20) - 10;
        }
        func_70012_b((double)i + 0.5D, k, (double)j + 0.5D, 0.0F, 0.0F);
        field_71133_b = p_i3396_1_;
        field_70138_W = 0.0F;
        field_71092_bJ = p_i3396_3_;
        field_70129_M = 0.0F;
    }

    public void func_70037_a(NBTTagCompound p_70037_1_)
    {
        super.func_70037_a(p_70037_1_);
        if(p_70037_1_.func_74764_b("playerGameType"))
        {
            field_71134_c.func_73076_a(EnumGameType.func_77146_a(p_70037_1_.func_74762_e("playerGameType")));
        }
    }

    public void func_70014_b(NBTTagCompound p_70014_1_)
    {
        super.func_70014_b(p_70014_1_);
        p_70014_1_.func_74768_a("playerGameType", field_71134_c.func_73081_b().func_77148_a());
    }

    public void func_71032_a(int p_71032_1_)
    {
        super.func_71032_a(p_71032_1_);
        field_71144_ck = -1;
    }

    public void func_71116_b()
    {
        field_71070_bA.func_75132_a(this);
    }

    public ItemStack[] func_70035_c()
    {
        return field_71141_cp;
    }

    protected void func_71061_d_()
    {
        field_70129_M = 0.0F;
    }

    public float func_70047_e()
    {
        return 1.62F;
    }

    public void func_70071_h_()
    {
        field_71134_c.func_73075_a();
        field_71145_cl--;
        field_71070_bA.func_75142_b();
        for(int i = 0; i < 5; i++)
        {
            ItemStack itemstack = func_71124_b(i);
            if(itemstack != field_71141_cp[i])
            {
                func_71121_q().func_73039_n().func_72784_a(this, new Packet5PlayerInventory(field_70157_k, i, itemstack));
                field_71141_cp[i] = itemstack;
            }
        }

        if(!field_71129_f.isEmpty())
        {
            ArrayList arraylist = new ArrayList();
            Iterator iterator = field_71129_f.iterator();
            ArrayList arraylist1 = new ArrayList();
            do
            {
                if(!iterator.hasNext() || arraylist.size() >= 5)
                {
                    break;
                }
                ChunkCoordIntPair chunkcoordintpair = (ChunkCoordIntPair)iterator.next();
                iterator.remove();
                if(chunkcoordintpair != null && field_70170_p.func_72899_e(chunkcoordintpair.field_77276_a << 4, 0, chunkcoordintpair.field_77275_b << 4))
                {
                    arraylist.add(field_70170_p.func_72964_e(chunkcoordintpair.field_77276_a, chunkcoordintpair.field_77275_b));
                    arraylist1.addAll(((WorldServer)field_70170_p).func_73049_a(chunkcoordintpair.field_77276_a * 16, 0, chunkcoordintpair.field_77275_b * 16, chunkcoordintpair.field_77276_a * 16 + 16, 256, chunkcoordintpair.field_77275_b * 16 + 16));
                }
            } while(true);
            if(!arraylist.isEmpty())
            {
                field_71135_a.func_72567_b(new Packet56MapChunks(arraylist));
                TileEntity tileentity;
                for(Iterator iterator2 = arraylist1.iterator(); iterator2.hasNext(); func_71119_a(tileentity))
                {
                    tileentity = (TileEntity)iterator2.next();
                }

            }
        }
        if(!field_71130_g.isEmpty())
        {
            int j = Math.min(field_71130_g.size(), 127);
            int ai[] = new int[j];
            Iterator iterator1 = field_71130_g.iterator();
            for(int k = 0; iterator1.hasNext() && k < j; iterator1.remove())
            {
                ai[k++] = ((Integer)iterator1.next()).intValue();
            }

            field_71135_a.func_72567_b(new Packet29DestroyEntity(ai));
        }
    }

    public void func_71127_g()
    {
        super.func_70071_h_();
        for(int i = 0; i < field_71071_by.func_70302_i_(); i++)
        {
            ItemStack itemstack = field_71071_by.func_70301_a(i);
            if(itemstack == null || !Item.field_77698_e[itemstack.field_77993_c].func_77643_m_() || field_71135_a.func_72568_e() > 2)
            {
                continue;
            }
            Packet packet = ((ItemMapBase)Item.field_77698_e[itemstack.field_77993_c]).func_77871_c(itemstack, field_70170_p, this);
            if(packet != null)
            {
                field_71135_a.func_72567_b(packet);
            }
        }

        if(field_71087_bX)
        {
            if(field_71133_b.func_71255_r())
            {
                if(field_71070_bA != field_71069_bz)
                {
                    func_71053_j();
                }
                if(field_70154_o != null)
                {
                    func_70078_a(field_70154_o);
                } else
                {
                    field_71086_bY += 0.0125F;
                    if(field_71086_bY >= 1.0F)
                    {
                        field_71086_bY = 1.0F;
                        field_71088_bW = 10;
                        byte byte0 = 0;
                        if(field_71093_bK == -1)
                        {
                            byte0 = 0;
                        } else
                        {
                            byte0 = -1;
                        }
                        field_71133_b.func_71203_ab().func_72356_a(this, byte0);
                        field_71144_ck = -1;
                        field_71149_ch = -1;
                        field_71146_ci = -1;
                        func_71029_a(AchievementList.field_76029_x);
                    }
                }
                field_71087_bX = false;
            }
        } else
        {
            if(field_71086_bY > 0.0F)
            {
                field_71086_bY -= 0.05F;
            }
            if(field_71086_bY < 0.0F)
            {
                field_71086_bY = 0.0F;
            }
        }
        if(field_71088_bW > 0)
        {
            field_71088_bW--;
        }
        if(func_70630_aN() != field_71149_ch || field_71146_ci != field_71100_bB.func_75116_a() || (field_71100_bB.func_75115_e() == 0.0F) != field_71147_cj)
        {
            field_71135_a.func_72567_b(new Packet8UpdateHealth(func_70630_aN(), field_71100_bB.func_75116_a(), field_71100_bB.func_75115_e()));
            field_71149_ch = func_70630_aN();
            field_71146_ci = field_71100_bB.func_75116_a();
            field_71147_cj = field_71100_bB.func_75115_e() == 0.0F;
        }
        if(field_71067_cb != field_71144_ck)
        {
            field_71144_ck = field_71067_cb;
            field_71135_a.func_72567_b(new Packet43Experience(field_71106_cc, field_71067_cb, field_71068_ca));
        }
    }

    public ItemStack func_71124_b(int p_71124_1_)
    {
        if(p_71124_1_ == 0)
        {
            return field_71071_by.func_70448_g();
        } else
        {
            return field_71071_by.field_70460_b[p_71124_1_ - 1];
        }
    }

    public void func_70645_a(DamageSource p_70645_1_)
    {
        field_71133_b.func_71203_ab().func_72384_a(new Packet3Chat(p_70645_1_.func_76360_b(this)));
        field_71071_by.func_70436_m();
    }

    public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_)
    {
        if(field_71145_cl > 0)
        {
            return false;
        }
        if(!field_71133_b.func_71219_W() && (p_70097_1_ instanceof EntityDamageSource))
        {
            Entity entity = p_70097_1_.func_76346_g();
            if(entity instanceof EntityPlayer)
            {
                return false;
            }
            if(entity instanceof EntityArrow)
            {
                EntityArrow entityarrow = (EntityArrow)entity;
                if(entityarrow.field_70250_c instanceof EntityPlayer)
                {
                    return false;
                }
            }
        }
        return super.func_70097_a(p_70097_1_, p_70097_2_);
    }

    protected boolean func_71003_h()
    {
        return field_71133_b.func_71219_W();
    }

    public void func_71027_c(int p_71027_1_)
    {
        if(field_71093_bK == 1 && p_71027_1_ == 1)
        {
            func_71029_a(AchievementList.field_76003_C);
            field_70170_p.func_72900_e(this);
            field_71136_j = true;
            field_71135_a.func_72567_b(new Packet70GameEvent(4, 0));
        } else
        {
            func_71029_a(AchievementList.field_76002_B);
            ChunkCoordinates chunkcoordinates = field_71133_b.func_71218_a(p_71027_1_).func_73054_j();
            if(chunkcoordinates != null)
            {
                field_71135_a.func_72569_a(chunkcoordinates.field_71574_a, chunkcoordinates.field_71572_b, chunkcoordinates.field_71573_c, 0.0F, 0.0F);
            }
            field_71133_b.func_71203_ab().func_72356_a(this, 1);
            field_71144_ck = -1;
            field_71149_ch = -1;
            field_71146_ci = -1;
        }
    }

    private void func_71119_a(TileEntity p_71119_1_)
    {
        if(p_71119_1_ != null)
        {
            Packet packet = p_71119_1_.func_70319_e();
            if(packet != null)
            {
                field_71135_a.func_72567_b(packet);
            }
        }
    }

    public void func_71001_a(Entity p_71001_1_, int p_71001_2_)
    {
        if(!p_71001_1_.field_70128_L)
        {
            EntityTracker entitytracker = func_71121_q().func_73039_n();
            if(p_71001_1_ instanceof EntityItem)
            {
                entitytracker.func_72784_a(p_71001_1_, new Packet22Collect(p_71001_1_.field_70157_k, field_70157_k));
            }
            if(p_71001_1_ instanceof EntityArrow)
            {
                entitytracker.func_72784_a(p_71001_1_, new Packet22Collect(p_71001_1_.field_70157_k, field_70157_k));
            }
            if(p_71001_1_ instanceof EntityXPOrb)
            {
                entitytracker.func_72784_a(p_71001_1_, new Packet22Collect(p_71001_1_.field_70157_k, field_70157_k));
            }
        }
        super.func_71001_a(p_71001_1_, p_71001_2_);
        field_71070_bA.func_75142_b();
    }

    public void func_71038_i()
    {
        if(!field_71103_bH)
        {
            field_71105_bI = -1;
            field_71103_bH = true;
            func_71121_q().func_73039_n().func_72784_a(this, new Packet18Animation(this, 1));
        }
    }

    public EnumStatus func_71018_a(int p_71018_1_, int p_71018_2_, int p_71018_3_)
    {
        EnumStatus enumstatus = super.func_71018_a(p_71018_1_, p_71018_2_, p_71018_3_);
        if(enumstatus == EnumStatus.OK)
        {
            Packet17Sleep packet17sleep = new Packet17Sleep(this, 0, p_71018_1_, p_71018_2_, p_71018_3_);
            func_71121_q().func_73039_n().func_72784_a(this, packet17sleep);
            field_71135_a.func_72569_a(field_70165_t, field_70163_u, field_70161_v, field_70177_z, field_70125_A);
            field_71135_a.func_72567_b(packet17sleep);
        }
        return enumstatus;
    }

    public void func_70999_a(boolean p_70999_1_, boolean p_70999_2_, boolean p_70999_3_)
    {
        if(func_70608_bn())
        {
            func_71121_q().func_73039_n().func_72789_b(this, new Packet18Animation(this, 3));
        }
        super.func_70999_a(p_70999_1_, p_70999_2_, p_70999_3_);
        if(field_71135_a != null)
        {
            field_71135_a.func_72569_a(field_70165_t, field_70163_u, field_70161_v, field_70177_z, field_70125_A);
        }
    }

    public void func_70078_a(Entity p_70078_1_)
    {
        super.func_70078_a(p_70078_1_);
        field_71135_a.func_72567_b(new Packet39AttachEntity(this, field_70154_o));
        field_71135_a.func_72569_a(field_70165_t, field_70163_u, field_70161_v, field_70177_z, field_70125_A);
    }

    protected void func_70064_a(double d, boolean flag)
    {
    }

    public void func_71122_b(double p_71122_1_, boolean p_71122_3_)
    {
        super.func_70064_a(p_71122_1_, p_71122_3_);
    }

    private void func_71117_bO()
    {
        field_71139_cq = field_71139_cq % 100 + 1;
    }

    public void func_71058_b(int p_71058_1_, int p_71058_2_, int p_71058_3_)
    {
        func_71117_bO();
        field_71135_a.func_72567_b(new Packet100OpenWindow(field_71139_cq, 1, "Crafting", 9));
        field_71070_bA = new ContainerWorkbench(field_71071_by, field_70170_p, p_71058_1_, p_71058_2_, p_71058_3_);
        field_71070_bA.field_75152_c = field_71139_cq;
        field_71070_bA.func_75132_a(this);
    }

    public void func_71002_c(int p_71002_1_, int p_71002_2_, int p_71002_3_)
    {
        func_71117_bO();
        field_71135_a.func_72567_b(new Packet100OpenWindow(field_71139_cq, 4, "Enchanting", 9));
        field_71070_bA = new ContainerEnchantment(field_71071_by, field_70170_p, p_71002_1_, p_71002_2_, p_71002_3_);
        field_71070_bA.field_75152_c = field_71139_cq;
        field_71070_bA.func_75132_a(this);
    }

    public void func_71007_a(IInventory p_71007_1_)
    {
        if(field_71070_bA != field_71069_bz)
        {
            func_71053_j();
        }
        func_71117_bO();
        field_71135_a.func_72567_b(new Packet100OpenWindow(field_71139_cq, 0, p_71007_1_.func_70303_b(), p_71007_1_.func_70302_i_()));
        field_71070_bA = new ContainerChest(field_71071_by, p_71007_1_);
        field_71070_bA.field_75152_c = field_71139_cq;
        field_71070_bA.func_75132_a(this);
    }

    public void func_71042_a(TileEntityFurnace p_71042_1_)
    {
        func_71117_bO();
        field_71135_a.func_72567_b(new Packet100OpenWindow(field_71139_cq, 2, p_71042_1_.func_70303_b(), p_71042_1_.func_70302_i_()));
        field_71070_bA = new ContainerFurnace(field_71071_by, p_71042_1_);
        field_71070_bA.field_75152_c = field_71139_cq;
        field_71070_bA.func_75132_a(this);
    }

    public void func_71006_a(TileEntityDispenser p_71006_1_)
    {
        func_71117_bO();
        field_71135_a.func_72567_b(new Packet100OpenWindow(field_71139_cq, 3, p_71006_1_.func_70303_b(), p_71006_1_.func_70302_i_()));
        field_71070_bA = new ContainerDispenser(field_71071_by, p_71006_1_);
        field_71070_bA.field_75152_c = field_71139_cq;
        field_71070_bA.func_75132_a(this);
    }

    public void func_71017_a(TileEntityBrewingStand p_71017_1_)
    {
        func_71117_bO();
        field_71135_a.func_72567_b(new Packet100OpenWindow(field_71139_cq, 5, p_71017_1_.func_70303_b(), p_71017_1_.func_70302_i_()));
        field_71070_bA = new ContainerBrewingStand(field_71071_by, p_71017_1_);
        field_71070_bA.field_75152_c = field_71139_cq;
        field_71070_bA.func_75132_a(this);
    }

    public void func_71030_a(IMerchant p_71030_1_)
    {
        func_71117_bO();
        field_71070_bA = new ContainerMerchant(field_71071_by, p_71030_1_, field_70170_p);
        field_71070_bA.field_75152_c = field_71139_cq;
        field_71070_bA.func_75132_a(this);
        InventoryMerchant inventorymerchant = ((ContainerMerchant)field_71070_bA).func_75174_d();
        field_71135_a.func_72567_b(new Packet100OpenWindow(field_71139_cq, 6, inventorymerchant.func_70303_b(), inventorymerchant.func_70302_i_()));
        MerchantRecipeList merchantrecipelist = p_71030_1_.func_70934_b(this);
        if(merchantrecipelist != null)
        {
            try
            {
                ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
                DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);
                dataoutputstream.writeInt(field_71139_cq);
                merchantrecipelist.func_77200_a(dataoutputstream);
                field_71135_a.func_72567_b(new Packet250CustomPayload("MC|TrList", bytearrayoutputstream.toByteArray()));
            }
            catch(IOException ioexception)
            {
                ioexception.printStackTrace();
            }
        }
    }

    public void func_71111_a(Container p_71111_1_, int p_71111_2_, ItemStack p_71111_3_)
    {
        if(p_71111_1_.func_75139_a(p_71111_2_) instanceof SlotCrafting)
        {
            return;
        }
        if(field_71137_h)
        {
            return;
        } else
        {
            field_71135_a.func_72567_b(new Packet103SetSlot(p_71111_1_.field_75152_c, p_71111_2_, p_71111_3_));
            return;
        }
    }

    public void func_71120_a(Container p_71120_1_)
    {
        func_71110_a(p_71120_1_, p_71120_1_.func_75138_a());
    }

    public void func_71110_a(Container p_71110_1_, List p_71110_2_)
    {
        field_71135_a.func_72567_b(new Packet104WindowItems(p_71110_1_.field_75152_c, p_71110_2_));
        field_71135_a.func_72567_b(new Packet103SetSlot(-1, -1, field_71071_by.func_70445_o()));
    }

    public void func_71112_a(Container p_71112_1_, int p_71112_2_, int p_71112_3_)
    {
        field_71135_a.func_72567_b(new Packet105UpdateProgressbar(p_71112_1_.field_75152_c, p_71112_2_, p_71112_3_));
    }

    public void func_71053_j()
    {
        field_71135_a.func_72567_b(new Packet101CloseWindow(field_71070_bA.field_75152_c));
        func_71128_l();
    }

    public void func_71113_k()
    {
        if(field_71137_h)
        {
            return;
        } else
        {
            field_71135_a.func_72567_b(new Packet103SetSlot(-1, -1, field_71071_by.func_70445_o()));
            return;
        }
    }

    public void func_71128_l()
    {
        field_71070_bA.func_75134_a(this);
        field_71070_bA = field_71069_bz;
    }

    public void func_71064_a(StatBase p_71064_1_, int p_71064_2_)
    {
        if(p_71064_1_ == null)
        {
            return;
        }
        if(!p_71064_1_.field_75972_f)
        {
            for(; p_71064_2_ > 100; p_71064_2_ -= 100)
            {
                field_71135_a.func_72567_b(new Packet200Statistic(p_71064_1_.field_75975_e, 100));
            }

            field_71135_a.func_72567_b(new Packet200Statistic(p_71064_1_.field_75975_e, p_71064_2_));
        }
    }

    public void func_71123_m()
    {
        if(field_70154_o != null)
        {
            func_70078_a(field_70154_o);
        }
        if(field_70153_n != null)
        {
            field_70153_n.func_70078_a(this);
        }
        if(field_71083_bS)
        {
            func_70999_a(true, false, false);
        }
    }

    public void func_71118_n()
    {
        field_71149_ch = 0xfa0a1f01;
    }

    public void func_71035_c(String p_71035_1_)
    {
        StringTranslate stringtranslate = StringTranslate.func_74808_a();
        String s = stringtranslate.func_74805_b(p_71035_1_);
        field_71135_a.func_72567_b(new Packet3Chat(s));
    }

    protected void func_71036_o()
    {
        field_71135_a.func_72567_b(new Packet38EntityStatus(field_70157_k, (byte)9));
        super.func_71036_o();
    }

    public void func_71008_a(ItemStack p_71008_1_, int p_71008_2_)
    {
        super.func_71008_a(p_71008_1_, p_71008_2_);
        if(p_71008_1_ != null && p_71008_1_.func_77973_b() != null && p_71008_1_.func_77973_b().func_77661_b(p_71008_1_) == EnumAction.eat)
        {
            func_71121_q().func_73039_n().func_72789_b(this, new Packet18Animation(this, 5));
        }
    }

    protected void func_70670_a(PotionEffect p_70670_1_)
    {
        super.func_70670_a(p_70670_1_);
        field_71135_a.func_72567_b(new Packet41EntityEffect(field_70157_k, p_70670_1_));
    }

    protected void func_70695_b(PotionEffect p_70695_1_)
    {
        super.func_70695_b(p_70695_1_);
        field_71135_a.func_72567_b(new Packet41EntityEffect(field_70157_k, p_70695_1_));
    }

    protected void func_70688_c(PotionEffect p_70688_1_)
    {
        super.func_70688_c(p_70688_1_);
        field_71135_a.func_72567_b(new Packet42RemoveEntityEffect(field_70157_k, p_70688_1_));
    }

    public void func_70634_a(double p_70634_1_, double p_70634_3_, double p_70634_5_)
    {
        field_71135_a.func_72569_a(p_70634_1_, p_70634_3_, p_70634_5_, field_70177_z, field_70125_A);
    }

    public void func_71009_b(Entity p_71009_1_)
    {
        func_71121_q().func_73039_n().func_72789_b(this, new Packet18Animation(p_71009_1_, 6));
    }

    public void func_71047_c(Entity p_71047_1_)
    {
        func_71121_q().func_73039_n().func_72789_b(this, new Packet18Animation(p_71047_1_, 7));
    }

    public void func_71016_p()
    {
        if(field_71135_a == null)
        {
            return;
        } else
        {
            field_71135_a.func_72567_b(new Packet202PlayerAbilities(field_71075_bZ));
            return;
        }
    }

    public WorldServer func_71121_q()
    {
        return (WorldServer)field_70170_p;
    }

    public void func_71033_a(EnumGameType p_71033_1_)
    {
        field_71134_c.func_73076_a(p_71033_1_);
        field_71135_a.func_72567_b(new Packet70GameEvent(3, p_71033_1_.func_77148_a()));
    }

    public void func_70006_a(String p_70006_1_)
    {
        field_71135_a.func_72567_b(new Packet3Chat(p_70006_1_));
    }

    public boolean func_70003_b(String p_70003_1_)
    {
        if("seed".equals(p_70003_1_) && !field_71133_b.func_71262_S())
        {
            return true;
        } else
        {
            return field_71133_b.func_71203_ab().func_72353_e(field_71092_bJ);
        }
    }

    public String func_71114_r()
    {
        String s = field_71135_a.field_72575_b.func_74430_c().toString();
        s = s.substring(s.indexOf("/") + 1);
        s = s.substring(0, s.indexOf(":"));
        return s;
    }

    public void func_71125_a(Packet204ClientInfo p_71125_1_)
    {
        if(field_71148_cg.func_74806_b().containsKey(p_71125_1_.func_73459_d()))
        {
            field_71148_cg.func_74810_a(p_71125_1_.func_73459_d());
        }
        int i = 256 >> p_71125_1_.func_73461_f();
        if(i > 3 && i < 15)
        {
            field_71142_cm = i;
        }
        field_71143_cn = p_71125_1_.func_73463_g();
        field_71140_co = p_71125_1_.func_73460_h();
        if(field_71133_b.func_71264_H() && field_71133_b.func_71214_G().equals(field_71092_bJ))
        {
            field_71133_b.func_71226_c(p_71125_1_.func_73462_i());
        }
    }

    public StringTranslate func_71025_t()
    {
        return field_71148_cg;
    }

    public int func_71126_v()
    {
        return field_71143_cn;
    }

    public void func_71115_a(String p_71115_1_, int p_71115_2_)
    {
        String s = (new StringBuilder()).append(p_71115_1_).append("\0").append(p_71115_2_).toString();
        field_71135_a.func_72567_b(new Packet250CustomPayload("MC|TPack", s.getBytes()));
    }
}
