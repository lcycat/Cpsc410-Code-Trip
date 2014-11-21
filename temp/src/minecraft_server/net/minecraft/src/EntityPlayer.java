// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            EntityLiving, ICommandSender, InventoryPlayer, InventoryEnderChest, 
//            FoodStats, PlayerCapabilities, ContainerPlayer, World, 
//            ChunkCoordinates, DataWatcher, ItemStack, Item, 
//            EnumAction, Container, StatList, Vec3, 
//            Vec3Pool, Potion, PotionEffect, MathHelper, 
//            AxisAlignedBB, Entity, EnchantmentHelper, EntityItem, 
//            Material, NBTTagCompound, NBTTagList, DamageSource, 
//            EntityArrow, EntityCreeper, EntityGhast, EntityWolf, 
//            AABBPool, AchievementList, EnumStatus, WorldProvider, 
//            EntityMob, BlockBed, Block, IChunkProvider, 
//            EntityMinecart, EntityBoat, EntityPig, StringTranslate, 
//            EntityFishHook, IInventory, TileEntityFurnace, TileEntityDispenser, 
//            TileEntitySign, TileEntityBrewingStand, IMerchant, StatBase, 
//            EnumGameType

public abstract class EntityPlayer extends EntityLiving
    implements ICommandSender
{

    public InventoryPlayer field_71071_by;
    private InventoryEnderChest field_71078_a;
    public Container field_71069_bz;
    public Container field_71070_bA;
    protected FoodStats field_71100_bB;
    protected int field_71101_bC;
    public byte field_71098_bD;
    public int field_71099_bE;
    public float field_71107_bF;
    public float field_71109_bG;
    public boolean field_71103_bH;
    public int field_71105_bI;
    public String field_71092_bJ;
    public int field_71093_bK;
    public int field_71090_bL;
    public double field_71091_bM;
    public double field_71096_bN;
    public double field_71097_bO;
    public double field_71094_bP;
    public double field_71095_bQ;
    public double field_71085_bR;
    protected boolean field_71083_bS;
    public ChunkCoordinates field_71081_bT;
    private int field_71076_b;
    public float field_71079_bU;
    public float field_71089_bV;
    private ChunkCoordinates field_71077_c;
    private ChunkCoordinates field_71073_d;
    public int field_71088_bW;
    protected boolean field_71087_bX;
    public float field_71086_bY;
    public PlayerCapabilities field_71075_bZ;
    public int field_71068_ca;
    public int field_71067_cb;
    public float field_71106_cc;
    private ItemStack field_71074_e;
    private int field_71072_f;
    protected float field_71108_cd;
    protected float field_71102_ce;
    public EntityFishHook field_71104_cf;

    public EntityPlayer(World p_i3564_1_)
    {
        super(p_i3564_1_);
        field_71071_by = new InventoryPlayer(this);
        field_71078_a = new InventoryEnderChest();
        field_71100_bB = new FoodStats();
        field_71101_bC = 0;
        field_71098_bD = 0;
        field_71099_bE = 0;
        field_71103_bH = false;
        field_71105_bI = 0;
        field_71090_bL = 0;
        field_71088_bW = 20;
        field_71087_bX = false;
        field_71075_bZ = new PlayerCapabilities();
        field_71108_cd = 0.1F;
        field_71102_ce = 0.02F;
        field_71104_cf = null;
        field_71069_bz = new ContainerPlayer(field_71071_by, !p_i3564_1_.field_72995_K);
        field_71070_bA = field_71069_bz;
        field_70129_M = 1.62F;
        ChunkCoordinates chunkcoordinates = p_i3564_1_.func_72861_E();
        func_70012_b((double)chunkcoordinates.field_71574_a + 0.5D, chunkcoordinates.field_71572_b + 1, (double)chunkcoordinates.field_71573_c + 0.5D, 0.0F, 0.0F);
        field_70742_aC = "humanoid";
        field_70741_aB = 180F;
        field_70174_ab = 20;
        field_70750_az = "/mob/char.png";
    }

    public int func_70667_aM()
    {
        return 20;
    }

    protected void func_70088_a()
    {
        super.func_70088_a();
        field_70180_af.func_75682_a(16, Byte.valueOf((byte)0));
        field_70180_af.func_75682_a(17, Byte.valueOf((byte)0));
    }

    public boolean func_71039_bw()
    {
        return field_71074_e != null;
    }

    public void func_71034_by()
    {
        if(field_71074_e != null)
        {
            field_71074_e.func_77974_b(field_70170_p, this, field_71072_f);
        }
        func_71041_bz();
    }

    public void func_71041_bz()
    {
        field_71074_e = null;
        field_71072_f = 0;
        if(!field_70170_p.field_72995_K)
        {
            func_70019_c(false);
        }
    }

    public boolean func_70632_aY()
    {
        return func_71039_bw() && Item.field_77698_e[field_71074_e.field_77993_c].func_77661_b(field_71074_e) == EnumAction.block;
    }

    public void func_70071_h_()
    {
        if(field_71074_e != null)
        {
            ItemStack itemstack = field_71071_by.func_70448_g();
            if(itemstack == field_71074_e)
            {
                if(field_71072_f <= 25 && field_71072_f % 4 == 0)
                {
                    func_71010_c(itemstack, 5);
                }
                if(--field_71072_f == 0 && !field_70170_p.field_72995_K)
                {
                    func_71036_o();
                }
            } else
            {
                func_71041_bz();
            }
        }
        if(field_71090_bL > 0)
        {
            field_71090_bL--;
        }
        if(func_70608_bn())
        {
            field_71076_b++;
            if(field_71076_b > 100)
            {
                field_71076_b = 100;
            }
            if(!field_70170_p.field_72995_K)
            {
                if(!func_71065_l())
                {
                    func_70999_a(true, true, false);
                } else
                if(field_70170_p.func_72935_r())
                {
                    func_70999_a(false, true, true);
                }
            }
        } else
        if(field_71076_b > 0)
        {
            field_71076_b++;
            if(field_71076_b >= 110)
            {
                field_71076_b = 0;
            }
        }
        super.func_70071_h_();
        if(!field_70170_p.field_72995_K && field_71070_bA != null && !field_71070_bA.func_75145_c(this))
        {
            func_71053_j();
            field_71070_bA = field_71069_bz;
        }
        if(func_70027_ad() && field_71075_bZ.field_75102_a)
        {
            func_70066_B();
        }
        field_71091_bM = field_71094_bP;
        field_71096_bN = field_71095_bQ;
        field_71097_bO = field_71085_bR;
        double d = field_70165_t - field_71094_bP;
        double d1 = field_70163_u - field_71095_bQ;
        double d2 = field_70161_v - field_71085_bR;
        double d3 = 10D;
        if(d > d3)
        {
            field_71091_bM = field_71094_bP = field_70165_t;
        }
        if(d2 > d3)
        {
            field_71097_bO = field_71085_bR = field_70161_v;
        }
        if(d1 > d3)
        {
            field_71096_bN = field_71095_bQ = field_70163_u;
        }
        if(d < -d3)
        {
            field_71091_bM = field_71094_bP = field_70165_t;
        }
        if(d2 < -d3)
        {
            field_71097_bO = field_71085_bR = field_70161_v;
        }
        if(d1 < -d3)
        {
            field_71096_bN = field_71095_bQ = field_70163_u;
        }
        field_71094_bP += d * 0.25D;
        field_71085_bR += d2 * 0.25D;
        field_71095_bQ += d1 * 0.25D;
        func_71064_a(StatList.field_75948_k, 1);
        if(field_70154_o == null)
        {
            field_71073_d = null;
        }
        if(!field_70170_p.field_72995_K)
        {
            field_71100_bB.func_75118_a(this);
        }
    }

    protected void func_71010_c(ItemStack p_71010_1_, int p_71010_2_)
    {
        if(p_71010_1_.func_77975_n() == EnumAction.drink)
        {
            field_70170_p.func_72956_a(this, "random.drink", 0.5F, field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
        }
        if(p_71010_1_.func_77975_n() == EnumAction.eat)
        {
            for(int i = 0; i < p_71010_2_; i++)
            {
                Vec3 vec3 = Vec3.func_72437_a().func_72345_a(((double)field_70146_Z.nextFloat() - 0.5D) * 0.10000000000000001D, Math.random() * 0.10000000000000001D + 0.10000000000000001D, 0.0D);
                vec3.func_72440_a((-field_70125_A * 3.141593F) / 180F);
                vec3.func_72442_b((-field_70177_z * 3.141593F) / 180F);
                Vec3 vec3_1 = Vec3.func_72437_a().func_72345_a(((double)field_70146_Z.nextFloat() - 0.5D) * 0.29999999999999999D, (double)(-field_70146_Z.nextFloat()) * 0.59999999999999998D - 0.29999999999999999D, 0.59999999999999998D);
                vec3_1.func_72440_a((-field_70125_A * 3.141593F) / 180F);
                vec3_1.func_72442_b((-field_70177_z * 3.141593F) / 180F);
                vec3_1 = vec3_1.func_72441_c(field_70165_t, field_70163_u + (double)func_70047_e(), field_70161_v);
                field_70170_p.func_72869_a((new StringBuilder()).append("iconcrack_").append(p_71010_1_.func_77973_b().field_77779_bT).toString(), vec3_1.field_72450_a, vec3_1.field_72448_b, vec3_1.field_72449_c, vec3.field_72450_a, vec3.field_72448_b + 0.050000000000000003D, vec3.field_72449_c);
            }

            field_70170_p.func_72956_a(this, "random.eat", 0.5F + 0.5F * (float)field_70146_Z.nextInt(2), (field_70146_Z.nextFloat() - field_70146_Z.nextFloat()) * 0.2F + 1.0F);
        }
    }

    protected void func_71036_o()
    {
        if(field_71074_e != null)
        {
            func_71010_c(field_71074_e, 16);
            int i = field_71074_e.field_77994_a;
            ItemStack itemstack = field_71074_e.func_77950_b(field_70170_p, this);
            if(itemstack != field_71074_e || itemstack != null && itemstack.field_77994_a != i)
            {
                field_71071_by.field_70462_a[field_71071_by.field_70461_c] = itemstack;
                if(itemstack.field_77994_a == 0)
                {
                    field_71071_by.field_70462_a[field_71071_by.field_70461_c] = null;
                }
            }
            func_71041_bz();
        }
    }

    protected boolean func_70610_aX()
    {
        return func_70630_aN() <= 0 || func_70608_bn();
    }

    protected void func_71053_j()
    {
        field_71070_bA = field_71069_bz;
    }

    public void func_70098_U()
    {
        double d = field_70165_t;
        double d1 = field_70163_u;
        double d2 = field_70161_v;
        super.func_70098_U();
        field_71107_bF = field_71109_bG;
        field_71109_bG = 0.0F;
        func_71015_k(field_70165_t - d, field_70163_u - d1, field_70161_v - d2);
    }

    private int func_71046_k()
    {
        if(func_70644_a(Potion.field_76422_e))
        {
            return 6 - (1 + func_70660_b(Potion.field_76422_e).func_76458_c()) * 1;
        }
        if(func_70644_a(Potion.field_76419_f))
        {
            return 6 + (1 + func_70660_b(Potion.field_76419_f).func_76458_c()) * 2;
        } else
        {
            return 6;
        }
    }

    protected void func_70626_be()
    {
        int i = func_71046_k();
        if(field_71103_bH)
        {
            field_71105_bI++;
            if(field_71105_bI >= i)
            {
                field_71105_bI = 0;
                field_71103_bH = false;
            }
        } else
        {
            field_71105_bI = 0;
        }
        field_70733_aJ = (float)field_71105_bI / (float)i;
    }

    public void func_70636_d()
    {
        if(field_71101_bC > 0)
        {
            field_71101_bC--;
        }
        if(field_70170_p.field_73013_u == 0 && func_70630_aN() < func_70667_aM() && (field_70173_aa % 20) * 12 == 0)
        {
            func_70691_i(1);
        }
        field_71071_by.func_70429_k();
        field_71107_bF = field_71109_bG;
        super.func_70636_d();
        field_70746_aG = field_71075_bZ.func_75094_b();
        field_70747_aH = field_71102_ce;
        if(func_70051_ag())
        {
            field_70746_aG += (double)field_71075_bZ.func_75094_b() * 0.29999999999999999D;
            field_70747_aH += (double)field_71102_ce * 0.29999999999999999D;
        }
        float f = MathHelper.func_76133_a(field_70159_w * field_70159_w + field_70179_y * field_70179_y);
        float f1 = (float)Math.atan(-field_70181_x * 0.20000000298023224D) * 15F;
        if(f > 0.1F)
        {
            f = 0.1F;
        }
        if(!field_70122_E || func_70630_aN() <= 0)
        {
            f = 0.0F;
        }
        if(field_70122_E || func_70630_aN() <= 0)
        {
            f1 = 0.0F;
        }
        field_71109_bG += (f - field_71109_bG) * 0.4F;
        field_70726_aT += (f1 - field_70726_aT) * 0.8F;
        if(func_70630_aN() > 0)
        {
            List list = field_70170_p.func_72839_b(this, field_70121_D.func_72314_b(1.0D, 0.0D, 1.0D));
            if(list != null)
            {
                Iterator iterator = list.iterator();
                do
                {
                    if(!iterator.hasNext())
                    {
                        break;
                    }
                    Entity entity = (Entity)iterator.next();
                    if(!entity.field_70128_L)
                    {
                        func_71044_o(entity);
                    }
                } while(true);
            }
        }
    }

    private void func_71044_o(Entity p_71044_1_)
    {
        p_71044_1_.func_70100_b_(this);
    }

    public void func_70645_a(DamageSource p_70645_1_)
    {
        super.func_70645_a(p_70645_1_);
        func_70105_a(0.2F, 0.2F);
        func_70107_b(field_70165_t, field_70163_u, field_70161_v);
        field_70181_x = 0.10000000149011612D;
        if(field_71092_bJ.equals("Notch"))
        {
            func_71019_a(new ItemStack(Item.field_77706_j, 1), true);
        }
        field_71071_by.func_70436_m();
        if(p_70645_1_ != null)
        {
            field_70159_w = -MathHelper.func_76134_b(((field_70739_aP + field_70177_z) * 3.141593F) / 180F) * 0.1F;
            field_70179_y = -MathHelper.func_76126_a(((field_70739_aP + field_70177_z) * 3.141593F) / 180F) * 0.1F;
        } else
        {
            field_70159_w = field_70179_y = 0.0D;
        }
        field_70129_M = 0.1F;
        func_71064_a(StatList.field_75960_y, 1);
    }

    public void func_70084_c(Entity p_70084_1_, int p_70084_2_)
    {
        field_71099_bE += p_70084_2_;
        if(p_70084_1_ instanceof EntityPlayer)
        {
            func_71064_a(StatList.field_75932_A, 1);
        } else
        {
            func_71064_a(StatList.field_75959_z, 1);
        }
    }

    protected int func_70682_h(int p_70682_1_)
    {
        int i = EnchantmentHelper.func_77501_a(field_71071_by);
        if(i > 0 && field_70146_Z.nextInt(i + 1) > 0)
        {
            return p_70682_1_;
        } else
        {
            return super.func_70682_h(p_70682_1_);
        }
    }

    public EntityItem func_71040_bB()
    {
        return func_71019_a(field_71071_by.func_70298_a(field_71071_by.field_70461_c, 1), false);
    }

    public EntityItem func_71021_b(ItemStack p_71021_1_)
    {
        return func_71019_a(p_71021_1_, false);
    }

    public EntityItem func_71019_a(ItemStack p_71019_1_, boolean p_71019_2_)
    {
        if(p_71019_1_ == null)
        {
            return null;
        }
        EntityItem entityitem = new EntityItem(field_70170_p, field_70165_t, (field_70163_u - 0.30000001192092896D) + (double)func_70047_e(), field_70161_v, p_71019_1_);
        entityitem.field_70293_c = 40;
        float f = 0.1F;
        if(p_71019_2_)
        {
            float f2 = field_70146_Z.nextFloat() * 0.5F;
            float f4 = field_70146_Z.nextFloat() * 3.141593F * 2.0F;
            entityitem.field_70159_w = -MathHelper.func_76126_a(f4) * f2;
            entityitem.field_70179_y = MathHelper.func_76134_b(f4) * f2;
            entityitem.field_70181_x = 0.20000000298023224D;
        } else
        {
            float f1 = 0.3F;
            entityitem.field_70159_w = -MathHelper.func_76126_a((field_70177_z / 180F) * 3.141593F) * MathHelper.func_76134_b((field_70125_A / 180F) * 3.141593F) * f1;
            entityitem.field_70179_y = MathHelper.func_76134_b((field_70177_z / 180F) * 3.141593F) * MathHelper.func_76134_b((field_70125_A / 180F) * 3.141593F) * f1;
            entityitem.field_70181_x = -MathHelper.func_76126_a((field_70125_A / 180F) * 3.141593F) * f1 + 0.1F;
            f1 = 0.02F;
            float f3 = field_70146_Z.nextFloat() * 3.141593F * 2.0F;
            f1 *= field_70146_Z.nextFloat();
            entityitem.field_70159_w += Math.cos(f3) * (double)f1;
            entityitem.field_70181_x += (field_70146_Z.nextFloat() - field_70146_Z.nextFloat()) * 0.1F;
            entityitem.field_70179_y += Math.sin(f3) * (double)f1;
        }
        func_71012_a(entityitem);
        func_71064_a(StatList.field_75952_v, 1);
        return entityitem;
    }

    protected void func_71012_a(EntityItem p_71012_1_)
    {
        field_70170_p.func_72838_d(p_71012_1_);
    }

    public float func_71055_a(Block p_71055_1_)
    {
        float f = field_71071_by.func_70438_a(p_71055_1_);
        int i = EnchantmentHelper.func_77509_b(field_71071_by);
        if(i > 0 && field_71071_by.func_70454_b(p_71055_1_))
        {
            f += i * i + 1;
        }
        if(func_70644_a(Potion.field_76422_e))
        {
            f *= 1.0F + (float)(func_70660_b(Potion.field_76422_e).func_76458_c() + 1) * 0.2F;
        }
        if(func_70644_a(Potion.field_76419_f))
        {
            f *= 1.0F - (float)(func_70660_b(Potion.field_76419_f).func_76458_c() + 1) * 0.2F;
        }
        if(func_70055_a(Material.field_76244_g) && !EnchantmentHelper.func_77510_g(field_71071_by))
        {
            f /= 5F;
        }
        if(!field_70122_E)
        {
            f /= 5F;
        }
        return f;
    }

    public boolean func_71062_b(Block p_71062_1_)
    {
        return field_71071_by.func_70454_b(p_71062_1_);
    }

    public void func_70037_a(NBTTagCompound p_70037_1_)
    {
        super.func_70037_a(p_70037_1_);
        NBTTagList nbttaglist = p_70037_1_.func_74761_m("Inventory");
        field_71071_by.func_70443_b(nbttaglist);
        field_71093_bK = p_70037_1_.func_74762_e("Dimension");
        field_71083_bS = p_70037_1_.func_74767_n("Sleeping");
        field_71076_b = p_70037_1_.func_74765_d("SleepTimer");
        field_71106_cc = p_70037_1_.func_74760_g("XpP");
        field_71068_ca = p_70037_1_.func_74762_e("XpLevel");
        field_71067_cb = p_70037_1_.func_74762_e("XpTotal");
        if(field_71083_bS)
        {
            field_71081_bT = new ChunkCoordinates(MathHelper.func_76128_c(field_70165_t), MathHelper.func_76128_c(field_70163_u), MathHelper.func_76128_c(field_70161_v));
            func_70999_a(true, true, false);
        }
        if(p_70037_1_.func_74764_b("SpawnX") && p_70037_1_.func_74764_b("SpawnY") && p_70037_1_.func_74764_b("SpawnZ"))
        {
            field_71077_c = new ChunkCoordinates(p_70037_1_.func_74762_e("SpawnX"), p_70037_1_.func_74762_e("SpawnY"), p_70037_1_.func_74762_e("SpawnZ"));
        }
        field_71100_bB.func_75112_a(p_70037_1_);
        field_71075_bZ.func_75095_b(p_70037_1_);
        if(p_70037_1_.func_74764_b("EnderItems"))
        {
            NBTTagList nbttaglist1 = p_70037_1_.func_74761_m("EnderItems");
            field_71078_a.func_70486_a(nbttaglist1);
        }
    }

    public void func_70014_b(NBTTagCompound p_70014_1_)
    {
        super.func_70014_b(p_70014_1_);
        p_70014_1_.func_74782_a("Inventory", field_71071_by.func_70442_a(new NBTTagList()));
        p_70014_1_.func_74768_a("Dimension", field_71093_bK);
        p_70014_1_.func_74757_a("Sleeping", field_71083_bS);
        p_70014_1_.func_74777_a("SleepTimer", (short)field_71076_b);
        p_70014_1_.func_74776_a("XpP", field_71106_cc);
        p_70014_1_.func_74768_a("XpLevel", field_71068_ca);
        p_70014_1_.func_74768_a("XpTotal", field_71067_cb);
        if(field_71077_c != null)
        {
            p_70014_1_.func_74768_a("SpawnX", field_71077_c.field_71574_a);
            p_70014_1_.func_74768_a("SpawnY", field_71077_c.field_71572_b);
            p_70014_1_.func_74768_a("SpawnZ", field_71077_c.field_71573_c);
        }
        field_71100_bB.func_75117_b(p_70014_1_);
        field_71075_bZ.func_75091_a(p_70014_1_);
        p_70014_1_.func_74782_a("EnderItems", field_71078_a.func_70487_g());
    }

    public void func_71007_a(IInventory iinventory)
    {
    }

    public void func_71002_c(int i, int j, int k)
    {
    }

    public void func_71058_b(int i, int j, int k)
    {
    }

    public void func_71001_a(Entity entity, int i)
    {
    }

    public float func_70047_e()
    {
        return 0.12F;
    }

    protected void func_71061_d_()
    {
        field_70129_M = 1.62F;
    }

    public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_)
    {
        if(field_71075_bZ.field_75102_a && !p_70097_1_.func_76357_e())
        {
            return false;
        }
        field_70708_bq = 0;
        if(func_70630_aN() <= 0)
        {
            return false;
        }
        if(func_70608_bn() && !field_70170_p.field_72995_K)
        {
            func_70999_a(true, true, false);
        }
        Entity entity = p_70097_1_.func_76346_g();
        if(p_70097_1_.func_76350_n())
        {
            if(field_70170_p.field_73013_u == 0)
            {
                p_70097_2_ = 0;
            }
            if(field_70170_p.field_73013_u == 1)
            {
                p_70097_2_ = p_70097_2_ / 2 + 1;
            }
            if(field_70170_p.field_73013_u == 3)
            {
                p_70097_2_ = (p_70097_2_ * 3) / 2;
            }
        }
        if(p_70097_2_ == 0)
        {
            return false;
        }
        Entity entity1 = p_70097_1_.func_76346_g();
        if((entity1 instanceof EntityArrow) && ((EntityArrow)entity1).field_70250_c != null)
        {
            entity1 = ((EntityArrow)entity1).field_70250_c;
        }
        if(entity1 instanceof EntityLiving)
        {
            func_71022_a((EntityLiving)entity1, false);
        }
        func_71064_a(StatList.field_75961_x, p_70097_2_);
        return super.func_70097_a(p_70097_1_, p_70097_2_);
    }

    protected int func_70672_c(DamageSource p_70672_1_, int p_70672_2_)
    {
        int i = super.func_70672_c(p_70672_1_, p_70672_2_);
        if(i <= 0)
        {
            return 0;
        }
        int j = EnchantmentHelper.func_77508_a(field_71071_by, p_70672_1_);
        if(j > 20)
        {
            j = 20;
        }
        if(j > 0 && j <= 20)
        {
            int k = 25 - j;
            int l = i * k + field_70736_aM;
            i = l / 25;
            field_70736_aM = l % 25;
        }
        return i;
    }

    protected boolean func_71003_h()
    {
        return false;
    }

    protected void func_71022_a(EntityLiving p_71022_1_, boolean p_71022_2_)
    {
        if((p_71022_1_ instanceof EntityCreeper) || (p_71022_1_ instanceof EntityGhast))
        {
            return;
        }
        if(p_71022_1_ instanceof EntityWolf)
        {
            EntityWolf entitywolf = (EntityWolf)p_71022_1_;
            if(entitywolf.func_70909_n() && field_71092_bJ.equals(entitywolf.func_70905_p()))
            {
                return;
            }
        }
        if((p_71022_1_ instanceof EntityPlayer) && !func_71003_h())
        {
            return;
        }
        List list = field_70170_p.func_72872_a(net.minecraft.src.EntityWolf.class, AxisAlignedBB.func_72332_a().func_72299_a(field_70165_t, field_70163_u, field_70161_v, field_70165_t + 1.0D, field_70163_u + 1.0D, field_70161_v + 1.0D).func_72314_b(16D, 4D, 16D));
        Iterator iterator = list.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            EntityWolf entitywolf1 = (EntityWolf)iterator.next();
            if(entitywolf1.func_70909_n() && entitywolf1.func_70777_m() == null && field_71092_bJ.equals(entitywolf1.func_70905_p()) && (!p_71022_2_ || !entitywolf1.func_70906_o()))
            {
                entitywolf1.func_70904_g(false);
                entitywolf1.func_70784_b(p_71022_1_);
            }
        } while(true);
    }

    protected void func_70675_k(int p_70675_1_)
    {
        field_71071_by.func_70449_g(p_70675_1_);
    }

    public int func_70658_aO()
    {
        return field_71071_by.func_70430_l();
    }

    protected void func_70665_d(DamageSource p_70665_1_, int p_70665_2_)
    {
        if(!p_70665_1_.func_76363_c() && func_70632_aY())
        {
            p_70665_2_ = 1 + p_70665_2_ >> 1;
        }
        p_70665_2_ = func_70655_b(p_70665_1_, p_70665_2_);
        p_70665_2_ = func_70672_c(p_70665_1_, p_70665_2_);
        func_71020_j(p_70665_1_.func_76345_d());
        field_70734_aK -= p_70665_2_;
    }

    public void func_71042_a(TileEntityFurnace tileentityfurnace)
    {
    }

    public void func_71006_a(TileEntityDispenser tileentitydispenser)
    {
    }

    public void func_71014_a(TileEntitySign tileentitysign)
    {
    }

    public void func_71017_a(TileEntityBrewingStand tileentitybrewingstand)
    {
    }

    public void func_71030_a(IMerchant imerchant)
    {
    }

    public void func_71048_c(ItemStack itemstack)
    {
    }

    public boolean func_70998_m(Entity p_70998_1_)
    {
        if(p_70998_1_.func_70085_c(this))
        {
            return true;
        }
        ItemStack itemstack = func_71045_bC();
        if(itemstack != null && (p_70998_1_ instanceof EntityLiving))
        {
            if(field_71075_bZ.field_75098_d)
            {
                itemstack = itemstack.func_77946_l();
            }
            if(itemstack.func_77947_a((EntityLiving)p_70998_1_))
            {
                if(itemstack.field_77994_a <= 0 && !field_71075_bZ.field_75098_d)
                {
                    func_71028_bD();
                }
                return true;
            }
        }
        return false;
    }

    public ItemStack func_71045_bC()
    {
        return field_71071_by.func_70448_g();
    }

    public void func_71028_bD()
    {
        field_71071_by.func_70299_a(field_71071_by.field_70461_c, null);
    }

    public double func_70033_W()
    {
        return (double)(field_70129_M - 0.5F);
    }

    public void func_71038_i()
    {
        if(!field_71103_bH || field_71105_bI >= func_71046_k() / 2 || field_71105_bI < 0)
        {
            field_71105_bI = -1;
            field_71103_bH = true;
        }
    }

    public void func_71059_n(Entity p_71059_1_)
    {
        if(!p_71059_1_.func_70075_an())
        {
            return;
        }
        int i = field_71071_by.func_70444_a(p_71059_1_);
        if(func_70644_a(Potion.field_76420_g))
        {
            i += 3 << func_70660_b(Potion.field_76420_g).func_76458_c();
        }
        if(func_70644_a(Potion.field_76437_t))
        {
            i -= 2 << func_70660_b(Potion.field_76437_t).func_76458_c();
        }
        int j = 0;
        int k = 0;
        if(p_71059_1_ instanceof EntityLiving)
        {
            k = EnchantmentHelper.func_77512_a(field_71071_by, (EntityLiving)p_71059_1_);
            j += EnchantmentHelper.func_77507_b(field_71071_by, (EntityLiving)p_71059_1_);
        }
        if(func_70051_ag())
        {
            j++;
        }
        if(i > 0 || k > 0)
        {
            boolean flag = field_70143_R > 0.0F && !field_70122_E && !func_70617_f_() && !func_70090_H() && !func_70644_a(Potion.field_76440_q) && field_70154_o == null && (p_71059_1_ instanceof EntityLiving);
            if(flag)
            {
                i += field_70146_Z.nextInt(i / 2 + 2);
            }
            i += k;
            boolean flag1 = p_71059_1_.func_70097_a(DamageSource.func_76365_a(this), i);
            if(flag1)
            {
                if(j > 0)
                {
                    p_71059_1_.func_70024_g(-MathHelper.func_76126_a((field_70177_z * 3.141593F) / 180F) * (float)j * 0.5F, 0.10000000000000001D, MathHelper.func_76134_b((field_70177_z * 3.141593F) / 180F) * (float)j * 0.5F);
                    field_70159_w *= 0.59999999999999998D;
                    field_70179_y *= 0.59999999999999998D;
                    func_70031_b(false);
                }
                if(flag)
                {
                    func_71009_b(p_71059_1_);
                }
                if(k > 0)
                {
                    func_71047_c(p_71059_1_);
                }
                if(i >= 18)
                {
                    func_71029_a(AchievementList.field_75999_E);
                }
                func_70607_j(p_71059_1_);
            }
            ItemStack itemstack = func_71045_bC();
            if(itemstack != null && (p_71059_1_ instanceof EntityLiving))
            {
                itemstack.func_77961_a((EntityLiving)p_71059_1_, this);
                if(itemstack.field_77994_a <= 0)
                {
                    func_71028_bD();
                }
            }
            if(p_71059_1_ instanceof EntityLiving)
            {
                if(p_71059_1_.func_70089_S())
                {
                    func_71022_a((EntityLiving)p_71059_1_, true);
                }
                func_71064_a(StatList.field_75951_w, i);
                int l = EnchantmentHelper.func_77515_c(field_71071_by, (EntityLiving)p_71059_1_);
                if(l > 0)
                {
                    p_71059_1_.func_70015_d(l * 4);
                }
            }
            func_71020_j(0.3F);
        }
    }

    public void func_71009_b(Entity entity)
    {
    }

    public void func_71047_c(Entity entity)
    {
    }

    public void func_70106_y()
    {
        super.func_70106_y();
        field_71069_bz.func_75134_a(this);
        if(field_71070_bA != null)
        {
            field_71070_bA.func_75134_a(this);
        }
    }

    public boolean func_70094_T()
    {
        return !field_71083_bS && super.func_70094_T();
    }

    public boolean func_71066_bF()
    {
        return false;
    }

    public EnumStatus func_71018_a(int p_71018_1_, int p_71018_2_, int p_71018_3_)
    {
        if(!field_70170_p.field_72995_K)
        {
            if(func_70608_bn() || !func_70089_S())
            {
                return EnumStatus.OTHER_PROBLEM;
            }
            if(!field_70170_p.field_73011_w.func_76569_d())
            {
                return EnumStatus.NOT_POSSIBLE_HERE;
            }
            if(field_70170_p.func_72935_r())
            {
                return EnumStatus.NOT_POSSIBLE_NOW;
            }
            if(Math.abs(field_70165_t - (double)p_71018_1_) > 3D || Math.abs(field_70163_u - (double)p_71018_2_) > 2D || Math.abs(field_70161_v - (double)p_71018_3_) > 3D)
            {
                return EnumStatus.TOO_FAR_AWAY;
            }
            double d = 8D;
            double d1 = 5D;
            List list = field_70170_p.func_72872_a(net.minecraft.src.EntityMob.class, AxisAlignedBB.func_72332_a().func_72299_a((double)p_71018_1_ - d, (double)p_71018_2_ - d1, (double)p_71018_3_ - d, (double)p_71018_1_ + d, (double)p_71018_2_ + d1, (double)p_71018_3_ + d));
            if(!list.isEmpty())
            {
                return EnumStatus.NOT_SAFE;
            }
        }
        func_70105_a(0.2F, 0.2F);
        field_70129_M = 0.2F;
        if(field_70170_p.func_72899_e(p_71018_1_, p_71018_2_, p_71018_3_))
        {
            int i = field_70170_p.func_72805_g(p_71018_1_, p_71018_2_, p_71018_3_);
            int j = BlockBed.func_72217_d(i);
            float f = 0.5F;
            float f1 = 0.5F;
            switch(j)
            {
            case 0: // '\0'
                f1 = 0.9F;
                break;

            case 2: // '\002'
                f1 = 0.1F;
                break;

            case 1: // '\001'
                f = 0.1F;
                break;

            case 3: // '\003'
                f = 0.9F;
                break;
            }
            func_71013_b(j);
            func_70107_b((float)p_71018_1_ + f, (float)p_71018_2_ + 0.9375F, (float)p_71018_3_ + f1);
        } else
        {
            func_70107_b((float)p_71018_1_ + 0.5F, (float)p_71018_2_ + 0.9375F, (float)p_71018_3_ + 0.5F);
        }
        field_71083_bS = true;
        field_71076_b = 0;
        field_71081_bT = new ChunkCoordinates(p_71018_1_, p_71018_2_, p_71018_3_);
        field_70159_w = field_70179_y = field_70181_x = 0.0D;
        if(!field_70170_p.field_72995_K)
        {
            field_70170_p.func_72854_c();
        }
        return EnumStatus.OK;
    }

    private void func_71013_b(int p_71013_1_)
    {
        field_71079_bU = 0.0F;
        field_71089_bV = 0.0F;
        switch(p_71013_1_)
        {
        case 0: // '\0'
            field_71089_bV = -1.8F;
            break;

        case 2: // '\002'
            field_71089_bV = 1.8F;
            break;

        case 1: // '\001'
            field_71079_bU = 1.8F;
            break;

        case 3: // '\003'
            field_71079_bU = -1.8F;
            break;
        }
    }

    public void func_70999_a(boolean p_70999_1_, boolean p_70999_2_, boolean p_70999_3_)
    {
        func_70105_a(0.6F, 1.8F);
        func_71061_d_();
        ChunkCoordinates chunkcoordinates = field_71081_bT;
        ChunkCoordinates chunkcoordinates1 = field_71081_bT;
        if(chunkcoordinates != null && field_70170_p.func_72798_a(chunkcoordinates.field_71574_a, chunkcoordinates.field_71572_b, chunkcoordinates.field_71573_c) == Block.field_71959_S.field_71990_ca)
        {
            BlockBed.func_72228_a(field_70170_p, chunkcoordinates.field_71574_a, chunkcoordinates.field_71572_b, chunkcoordinates.field_71573_c, false);
            ChunkCoordinates chunkcoordinates2 = BlockBed.func_72226_b(field_70170_p, chunkcoordinates.field_71574_a, chunkcoordinates.field_71572_b, chunkcoordinates.field_71573_c, 0);
            if(chunkcoordinates2 == null)
            {
                chunkcoordinates2 = new ChunkCoordinates(chunkcoordinates.field_71574_a, chunkcoordinates.field_71572_b + 1, chunkcoordinates.field_71573_c);
            }
            func_70107_b((float)chunkcoordinates2.field_71574_a + 0.5F, (float)chunkcoordinates2.field_71572_b + field_70129_M + 0.1F, (float)chunkcoordinates2.field_71573_c + 0.5F);
        }
        field_71083_bS = false;
        if(!field_70170_p.field_72995_K && p_70999_2_)
        {
            field_70170_p.func_72854_c();
        }
        if(p_70999_1_)
        {
            field_71076_b = 0;
        } else
        {
            field_71076_b = 100;
        }
        if(p_70999_3_)
        {
            func_71063_a(field_71081_bT);
        }
    }

    private boolean func_71065_l()
    {
        return field_70170_p.func_72798_a(field_71081_bT.field_71574_a, field_71081_bT.field_71572_b, field_71081_bT.field_71573_c) == Block.field_71959_S.field_71990_ca;
    }

    public static ChunkCoordinates func_71056_a(World p_71056_0_, ChunkCoordinates p_71056_1_)
    {
        IChunkProvider ichunkprovider = p_71056_0_.func_72863_F();
        ichunkprovider.func_73158_c(p_71056_1_.field_71574_a - 3 >> 4, p_71056_1_.field_71573_c - 3 >> 4);
        ichunkprovider.func_73158_c(p_71056_1_.field_71574_a + 3 >> 4, p_71056_1_.field_71573_c - 3 >> 4);
        ichunkprovider.func_73158_c(p_71056_1_.field_71574_a - 3 >> 4, p_71056_1_.field_71573_c + 3 >> 4);
        ichunkprovider.func_73158_c(p_71056_1_.field_71574_a + 3 >> 4, p_71056_1_.field_71573_c + 3 >> 4);
        if(p_71056_0_.func_72798_a(p_71056_1_.field_71574_a, p_71056_1_.field_71572_b, p_71056_1_.field_71573_c) != Block.field_71959_S.field_71990_ca)
        {
            return null;
        } else
        {
            ChunkCoordinates chunkcoordinates = BlockBed.func_72226_b(p_71056_0_, p_71056_1_.field_71574_a, p_71056_1_.field_71572_b, p_71056_1_.field_71573_c, 0);
            return chunkcoordinates;
        }
    }

    public boolean func_70608_bn()
    {
        return field_71083_bS;
    }

    public boolean func_71026_bH()
    {
        return field_71083_bS && field_71076_b >= 100;
    }

    public void func_71035_c(String s)
    {
    }

    public ChunkCoordinates func_70997_bJ()
    {
        return field_71077_c;
    }

    public void func_71063_a(ChunkCoordinates p_71063_1_)
    {
        if(p_71063_1_ != null)
        {
            field_71077_c = new ChunkCoordinates(p_71063_1_);
        } else
        {
            field_71077_c = null;
        }
    }

    public void func_71029_a(StatBase p_71029_1_)
    {
        func_71064_a(p_71029_1_, 1);
    }

    public void func_71064_a(StatBase statbase, int i)
    {
    }

    protected void func_70664_aZ()
    {
        super.func_70664_aZ();
        func_71064_a(StatList.field_75953_u, 1);
        if(func_70051_ag())
        {
            func_71020_j(0.8F);
        } else
        {
            func_71020_j(0.2F);
        }
    }

    public void func_70612_e(float p_70612_1_, float p_70612_2_)
    {
        double d = field_70165_t;
        double d1 = field_70163_u;
        double d2 = field_70161_v;
        if(field_71075_bZ.field_75100_b && field_70154_o == null)
        {
            double d3 = field_70181_x;
            float f = field_70747_aH;
            field_70747_aH = field_71075_bZ.func_75093_a();
            super.func_70612_e(p_70612_1_, p_70612_2_);
            field_70181_x = d3 * 0.59999999999999998D;
            field_70747_aH = f;
        } else
        {
            super.func_70612_e(p_70612_1_, p_70612_2_);
        }
        func_71000_j(field_70165_t - d, field_70163_u - d1, field_70161_v - d2);
    }

    public void func_71000_j(double p_71000_1_, double p_71000_3_, double p_71000_5_)
    {
        if(field_70154_o != null)
        {
            return;
        }
        if(func_70055_a(Material.field_76244_g))
        {
            int i = Math.round(MathHelper.func_76133_a(p_71000_1_ * p_71000_1_ + p_71000_3_ * p_71000_3_ + p_71000_5_ * p_71000_5_) * 100F);
            if(i > 0)
            {
                func_71064_a(StatList.field_75957_q, i);
                func_71020_j(0.015F * (float)i * 0.01F);
            }
        } else
        if(func_70090_H())
        {
            int j = Math.round(MathHelper.func_76133_a(p_71000_1_ * p_71000_1_ + p_71000_5_ * p_71000_5_) * 100F);
            if(j > 0)
            {
                func_71064_a(StatList.field_75946_m, j);
                func_71020_j(0.015F * (float)j * 0.01F);
            }
        } else
        if(func_70617_f_())
        {
            if(p_71000_3_ > 0.0D)
            {
                func_71064_a(StatList.field_75944_o, (int)Math.round(p_71000_3_ * 100D));
            }
        } else
        if(field_70122_E)
        {
            int k = Math.round(MathHelper.func_76133_a(p_71000_1_ * p_71000_1_ + p_71000_5_ * p_71000_5_) * 100F);
            if(k > 0)
            {
                func_71064_a(StatList.field_75945_l, k);
                if(func_70051_ag())
                {
                    func_71020_j(0.09999999F * (float)k * 0.01F);
                } else
                {
                    func_71020_j(0.01F * (float)k * 0.01F);
                }
            }
        } else
        {
            int l = Math.round(MathHelper.func_76133_a(p_71000_1_ * p_71000_1_ + p_71000_5_ * p_71000_5_) * 100F);
            if(l > 25)
            {
                func_71064_a(StatList.field_75958_p, l);
            }
        }
    }

    private void func_71015_k(double p_71015_1_, double p_71015_3_, double p_71015_5_)
    {
        if(field_70154_o != null)
        {
            int i = Math.round(MathHelper.func_76133_a(p_71015_1_ * p_71015_1_ + p_71015_3_ * p_71015_3_ + p_71015_5_ * p_71015_5_) * 100F);
            if(i > 0)
            {
                if(field_70154_o instanceof EntityMinecart)
                {
                    func_71064_a(StatList.field_75956_r, i);
                    if(field_71073_d == null)
                    {
                        field_71073_d = new ChunkCoordinates(MathHelper.func_76128_c(field_70165_t), MathHelper.func_76128_c(field_70163_u), MathHelper.func_76128_c(field_70161_v));
                    } else
                    if((double)field_71073_d.func_71569_e(MathHelper.func_76128_c(field_70165_t), MathHelper.func_76128_c(field_70163_u), MathHelper.func_76128_c(field_70161_v)) >= 1000000D)
                    {
                        func_71064_a(AchievementList.field_76025_q, 1);
                    }
                } else
                if(field_70154_o instanceof EntityBoat)
                {
                    func_71064_a(StatList.field_75955_s, i);
                } else
                if(field_70154_o instanceof EntityPig)
                {
                    func_71064_a(StatList.field_75954_t, i);
                }
            }
        }
    }

    protected void func_70069_a(float p_70069_1_)
    {
        if(field_71075_bZ.field_75101_c)
        {
            return;
        }
        if(p_70069_1_ >= 2.0F)
        {
            func_71064_a(StatList.field_75943_n, (int)Math.round((double)p_70069_1_ * 100D));
        }
        super.func_70069_a(p_70069_1_);
    }

    public void func_70074_a(EntityLiving p_70074_1_)
    {
        if(p_70074_1_ instanceof EntityMob)
        {
            func_71029_a(AchievementList.field_76023_s);
        }
    }

    public void func_70063_aa()
    {
        if(field_71088_bW > 0)
        {
            field_71088_bW = 10;
            return;
        } else
        {
            field_71087_bX = true;
            return;
        }
    }

    public void func_71023_q(int p_71023_1_)
    {
        field_71099_bE += p_71023_1_;
        int i = 0x7fffffff - field_71067_cb;
        if(p_71023_1_ > i)
        {
            p_71023_1_ = i;
        }
        field_71106_cc += (float)p_71023_1_ / (float)func_71050_bK();
        field_71067_cb += p_71023_1_;
        for(; field_71106_cc >= 1.0F; field_71106_cc /= func_71050_bK())
        {
            field_71106_cc = (field_71106_cc - 1.0F) * (float)func_71050_bK();
            func_71054_m();
        }

    }

    public void func_71032_a(int p_71032_1_)
    {
        field_71068_ca -= p_71032_1_;
        if(field_71068_ca < 0)
        {
            field_71068_ca = 0;
        }
    }

    public int func_71050_bK()
    {
        if(field_71068_ca >= 30)
        {
            return 62 + (field_71068_ca - 30) * 7;
        }
        if(field_71068_ca >= 15)
        {
            return 17 + (field_71068_ca - 15) * 3;
        } else
        {
            return 17;
        }
    }

    private void func_71054_m()
    {
        field_71068_ca++;
    }

    public void func_71020_j(float p_71020_1_)
    {
        if(field_71075_bZ.field_75102_a)
        {
            return;
        }
        if(!field_70170_p.field_72995_K)
        {
            field_71100_bB.func_75113_a(p_71020_1_);
        }
    }

    public FoodStats func_71024_bL()
    {
        return field_71100_bB;
    }

    public boolean func_71043_e(boolean p_71043_1_)
    {
        return (p_71043_1_ || field_71100_bB.func_75121_c()) && !field_71075_bZ.field_75102_a;
    }

    public boolean func_70996_bM()
    {
        return func_70630_aN() > 0 && func_70630_aN() < func_70667_aM();
    }

    public void func_71008_a(ItemStack p_71008_1_, int p_71008_2_)
    {
        if(p_71008_1_ == field_71074_e)
        {
            return;
        }
        field_71074_e = p_71008_1_;
        field_71072_f = p_71008_2_;
        if(!field_70170_p.field_72995_K)
        {
            func_70019_c(true);
        }
    }

    public boolean func_71031_e(int p_71031_1_, int p_71031_2_, int p_71031_3_)
    {
        return field_71075_bZ.field_75099_e;
    }

    protected int func_70693_a(EntityPlayer p_70693_1_)
    {
        int i = field_71068_ca * 7;
        if(i > 100)
        {
            return 100;
        } else
        {
            return i;
        }
    }

    protected boolean func_70684_aJ()
    {
        return true;
    }

    public String func_70023_ak()
    {
        return field_71092_bJ;
    }

    public void func_71027_c(int i)
    {
    }

    public void func_71049_a(EntityPlayer p_71049_1_, boolean p_71049_2_)
    {
        if(p_71049_2_)
        {
            field_71071_by.func_70455_b(p_71049_1_.field_71071_by);
            field_70734_aK = p_71049_1_.field_70734_aK;
            field_71100_bB = p_71049_1_.field_71100_bB;
            field_71068_ca = p_71049_1_.field_71068_ca;
            field_71067_cb = p_71049_1_.field_71067_cb;
            field_71106_cc = p_71049_1_.field_71106_cc;
            field_71099_bE = p_71049_1_.field_71099_bE;
        }
        field_71078_a = p_71049_1_.field_71078_a;
    }

    protected boolean func_70041_e_()
    {
        return !field_71075_bZ.field_75100_b;
    }

    public void func_71016_p()
    {
    }

    public void func_71033_a(EnumGameType enumgametype)
    {
    }

    public String func_70005_c_()
    {
        return field_71092_bJ;
    }

    public StringTranslate func_71025_t()
    {
        return StringTranslate.func_74808_a();
    }

    public String func_70004_a(String p_70004_1_, Object p_70004_2_[])
    {
        return func_71025_t().func_74803_a(p_70004_1_, p_70004_2_);
    }

    public InventoryEnderChest func_71005_bN()
    {
        return field_71078_a;
    }
}
