// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            EntityAgeable, INpc, IMerchant, PathNavigate, 
//            EntityAISwimming, EntityAITasks, EntityAIAvoidEntity, EntityZombie, 
//            EntityAITradePlayer, EntityAILookAtTradePlayer, EntityAIMoveIndoors, EntityAIRestrictOpenDoor, 
//            EntityAIOpenDoor, EntityAIMoveTwardsRestriction, EntityAIVillagerMate, EntityAIFollowGolem, 
//            EntityAIPlay, EntityAIWatchClosest2, EntityPlayer, EntityAIWander, 
//            EntityAIWatchClosest, EntityLiving, World, MathHelper, 
//            VillageCollection, Village, ChunkCoordinates, MerchantRecipeList, 
//            PotionEffect, Potion, DataWatcher, NBTTagCompound, 
//            MerchantRecipe, ItemStack, Item, Block, 
//            ItemShears, EnchantmentHelper, ModLoader, TradeEntry, 
//            Tuple

public class EntityVillager extends EntityAgeable
    implements INpc, IMerchant
{

    private int field_70955_e;
    private boolean field_70952_f;
    private boolean field_70953_g;
    Village field_70954_d;
    private EntityPlayer field_70962_h;
    private MerchantRecipeList field_70963_i;
    private int field_70961_j;
    private boolean field_70959_by;
    private int field_70956_bz;
    private MerchantRecipe field_70957_bA;
    private static final Map field_70958_bB;
    private static final Map field_70960_bC;

    public EntityVillager(World p_i3560_1_)
    {
        this(p_i3560_1_, 0);
    }

    public EntityVillager(World p_i3561_1_, int p_i3561_2_)
    {
        super(p_i3561_1_);
        field_70955_e = 0;
        field_70952_f = false;
        field_70953_g = false;
        field_70954_d = null;
        func_70938_b(p_i3561_2_);
        field_70750_az = "/mob/villager/villager.png";
        field_70697_bw = 0.5F;
        func_70661_as().func_75498_b(true);
        func_70661_as().func_75491_a(true);
        field_70714_bg.func_75776_a(0, new EntityAISwimming(this));
        field_70714_bg.func_75776_a(1, new EntityAIAvoidEntity(this, net.minecraft.src.EntityZombie.class, 8F, 0.3F, 0.35F));
        field_70714_bg.func_75776_a(1, new EntityAITradePlayer(this));
        field_70714_bg.func_75776_a(1, new EntityAILookAtTradePlayer(this));
        field_70714_bg.func_75776_a(2, new EntityAIMoveIndoors(this));
        field_70714_bg.func_75776_a(3, new EntityAIRestrictOpenDoor(this));
        field_70714_bg.func_75776_a(4, new EntityAIOpenDoor(this, true));
        field_70714_bg.func_75776_a(5, new EntityAIMoveTwardsRestriction(this, 0.3F));
        field_70714_bg.func_75776_a(6, new EntityAIVillagerMate(this));
        field_70714_bg.func_75776_a(7, new EntityAIFollowGolem(this));
        field_70714_bg.func_75776_a(8, new EntityAIPlay(this, 0.32F));
        field_70714_bg.func_75776_a(9, new EntityAIWatchClosest2(this, net.minecraft.src.EntityPlayer.class, 3F, 1.0F));
        field_70714_bg.func_75776_a(9, new EntityAIWatchClosest2(this, net.minecraft.src.EntityVillager.class, 5F, 0.02F));
        field_70714_bg.func_75776_a(9, new EntityAIWander(this, 0.3F));
        field_70714_bg.func_75776_a(10, new EntityAIWatchClosest(this, net.minecraft.src.EntityLiving.class, 8F));
    }

    public boolean func_70650_aV()
    {
        return true;
    }

    protected void func_70629_bd()
    {
        if(--field_70955_e <= 0)
        {
            field_70170_p.field_72982_D.func_75551_a(MathHelper.func_76128_c(field_70165_t), MathHelper.func_76128_c(field_70163_u), MathHelper.func_76128_c(field_70161_v));
            field_70955_e = 70 + field_70146_Z.nextInt(50);
            field_70954_d = field_70170_p.field_72982_D.func_75550_a(MathHelper.func_76128_c(field_70165_t), MathHelper.func_76128_c(field_70163_u), MathHelper.func_76128_c(field_70161_v), 32);
            if(field_70954_d == null)
            {
                func_70677_aE();
            } else
            {
                ChunkCoordinates chunkcoordinates = field_70954_d.func_75577_a();
                func_70598_b(chunkcoordinates.field_71574_a, chunkcoordinates.field_71572_b, chunkcoordinates.field_71573_c, field_70954_d.func_75568_b());
            }
        }
        if(!func_70940_q() && field_70961_j > 0)
        {
            field_70961_j--;
            if(field_70961_j <= 0)
            {
                if(field_70959_by)
                {
                    func_70950_c(1);
                    field_70959_by = false;
                }
                if(field_70957_bA != null)
                {
                    field_70963_i.remove(field_70957_bA);
                    field_70957_bA = null;
                }
                func_70690_d(new PotionEffect(Potion.field_76428_l.field_76415_H, 200, 0));
            }
        }
        super.func_70629_bd();
    }

    public boolean func_70085_c(EntityPlayer p_70085_1_)
    {
        if(func_70089_S() && !func_70940_q() && !func_70631_g_())
        {
            if(!field_70170_p.field_72995_K)
            {
                func_70932_a_(p_70085_1_);
                p_70085_1_.func_71030_a(this);
            }
            return true;
        } else
        {
            return super.func_70085_c(p_70085_1_);
        }
    }

    protected void func_70088_a()
    {
        super.func_70088_a();
        field_70180_af.func_75682_a(16, Integer.valueOf(0));
    }

    public int func_70667_aM()
    {
        return 20;
    }

    public void func_70014_b(NBTTagCompound p_70014_1_)
    {
        super.func_70014_b(p_70014_1_);
        p_70014_1_.func_74768_a("Profession", func_70946_n());
        p_70014_1_.func_74768_a("Riches", field_70956_bz);
        if(field_70963_i != null)
        {
            p_70014_1_.func_74766_a("Offers", field_70963_i.func_77202_a());
        }
    }

    public void func_70037_a(NBTTagCompound p_70037_1_)
    {
        super.func_70037_a(p_70037_1_);
        func_70938_b(p_70037_1_.func_74762_e("Profession"));
        field_70956_bz = p_70037_1_.func_74762_e("Riches");
        if(p_70037_1_.func_74764_b("Offers"))
        {
            NBTTagCompound nbttagcompound = p_70037_1_.func_74775_l("Offers");
            field_70963_i = new MerchantRecipeList(nbttagcompound);
        }
    }

    public String func_70073_O()
    {
        switch(func_70946_n())
        {
        case 0: // '\0'
            return "/mob/villager/farmer.png";

        case 1: // '\001'
            return "/mob/villager/librarian.png";

        case 2: // '\002'
            return "/mob/villager/priest.png";

        case 3: // '\003'
            return "/mob/villager/smith.png";

        case 4: // '\004'
            return "/mob/villager/butcher.png";
        }
        return super.func_70073_O();
    }

    protected boolean func_70692_ba()
    {
        return false;
    }

    protected String func_70639_aQ()
    {
        return "mob.villager.default";
    }

    protected String func_70621_aR()
    {
        return "mob.villager.defaulthurt";
    }

    protected String func_70673_aS()
    {
        return "mob.villager.defaultdeath";
    }

    public void func_70938_b(int p_70938_1_)
    {
        field_70180_af.func_75692_b(16, Integer.valueOf(p_70938_1_));
    }

    public int func_70946_n()
    {
        return field_70180_af.func_75679_c(16);
    }

    public boolean func_70941_o()
    {
        return field_70952_f;
    }

    public void func_70947_e(boolean p_70947_1_)
    {
        field_70952_f = p_70947_1_;
    }

    public void func_70939_f(boolean p_70939_1_)
    {
        field_70953_g = p_70939_1_;
    }

    public boolean func_70945_p()
    {
        return field_70953_g;
    }

    public void func_70604_c(EntityLiving p_70604_1_)
    {
        super.func_70604_c(p_70604_1_);
        if(field_70954_d != null && p_70604_1_ != null)
        {
            field_70954_d.func_75575_a(p_70604_1_);
        }
    }

    public void func_70932_a_(EntityPlayer p_70932_1_)
    {
        field_70962_h = p_70932_1_;
    }

    public EntityPlayer func_70931_l_()
    {
        return field_70962_h;
    }

    public boolean func_70940_q()
    {
        return field_70962_h != null;
    }

    public void func_70933_a(MerchantRecipe p_70933_1_)
    {
        p_70933_1_.func_77399_f();
        if(p_70933_1_.func_77393_a((MerchantRecipe)field_70963_i.get(field_70963_i.size() - 1)))
        {
            field_70961_j = 60;
            field_70959_by = true;
        } else
        if(field_70963_i.size() > 1)
        {
            int i = field_70146_Z.nextInt(6) + field_70146_Z.nextInt(6) + 3;
            if(i <= p_70933_1_.func_77392_e())
            {
                field_70961_j = 20;
                field_70957_bA = p_70933_1_;
            }
        }
        if(p_70933_1_.func_77394_a().field_77993_c == Item.field_77817_bH.field_77779_bT)
        {
            field_70956_bz += p_70933_1_.func_77394_a().field_77994_a;
        }
    }

    public MerchantRecipeList func_70934_b(EntityPlayer p_70934_1_)
    {
        if(field_70963_i == null)
        {
            func_70950_c(1);
        }
        return field_70963_i;
    }

    private void func_70950_c(int p_70950_1_)
    {
        MerchantRecipeList merchantrecipelist = new MerchantRecipeList();
        switch(func_70946_n())
        {
        default:
            break;

        case 0: // '\0'
            func_70948_a(merchantrecipelist, Item.field_77685_T.field_77779_bT, field_70146_Z, 0.9F);
            func_70948_a(merchantrecipelist, Block.field_72101_ab.field_71990_ca, field_70146_Z, 0.5F);
            func_70948_a(merchantrecipelist, Item.field_77735_bk.field_77779_bT, field_70146_Z, 0.5F);
            func_70948_a(merchantrecipelist, Item.field_77753_aV.field_77779_bT, field_70146_Z, 0.4F);
            func_70949_b(merchantrecipelist, Item.field_77684_U.field_77779_bT, field_70146_Z, 0.9F);
            func_70949_b(merchantrecipelist, Item.field_77738_bf.field_77779_bT, field_70146_Z, 0.3F);
            func_70949_b(merchantrecipelist, Item.field_77706_j.field_77779_bT, field_70146_Z, 0.3F);
            func_70949_b(merchantrecipelist, Item.field_77743_bc.field_77779_bT, field_70146_Z, 0.3F);
            func_70949_b(merchantrecipelist, Item.field_77745_be.field_77779_bT, field_70146_Z, 0.3F);
            func_70949_b(merchantrecipelist, Item.field_77709_i.field_77779_bT, field_70146_Z, 0.3F);
            func_70949_b(merchantrecipelist, Item.field_77736_bl.field_77779_bT, field_70146_Z, 0.3F);
            func_70949_b(merchantrecipelist, Item.field_77704_l.field_77779_bT, field_70146_Z, 0.5F);
            if(field_70146_Z.nextFloat() < 0.5F)
            {
                merchantrecipelist.add(new MerchantRecipe(new ItemStack(Block.field_71940_F, 10), new ItemStack(Item.field_77817_bH), new ItemStack(Item.field_77804_ap.field_77779_bT, 2 + field_70146_Z.nextInt(2), 0)));
            }
            break;

        case 4: // '\004'
            func_70948_a(merchantrecipelist, Item.field_77705_m.field_77779_bT, field_70146_Z, 0.7F);
            func_70948_a(merchantrecipelist, Item.field_77784_aq.field_77779_bT, field_70146_Z, 0.5F);
            func_70948_a(merchantrecipelist, Item.field_77741_bi.field_77779_bT, field_70146_Z, 0.5F);
            func_70949_b(merchantrecipelist, Item.field_77765_aA.field_77779_bT, field_70146_Z, 0.1F);
            func_70949_b(merchantrecipelist, Item.field_77686_W.field_77779_bT, field_70146_Z, 0.3F);
            func_70949_b(merchantrecipelist, Item.field_77692_Y.field_77779_bT, field_70146_Z, 0.3F);
            func_70949_b(merchantrecipelist, Item.field_77687_V.field_77779_bT, field_70146_Z, 0.3F);
            func_70949_b(merchantrecipelist, Item.field_77693_X.field_77779_bT, field_70146_Z, 0.3F);
            func_70949_b(merchantrecipelist, Item.field_77782_ar.field_77779_bT, field_70146_Z, 0.3F);
            func_70949_b(merchantrecipelist, Item.field_77734_bj.field_77779_bT, field_70146_Z, 0.3F);
            break;

        case 3: // '\003'
            func_70948_a(merchantrecipelist, Item.field_77705_m.field_77779_bT, field_70146_Z, 0.7F);
            func_70948_a(merchantrecipelist, Item.field_77703_o.field_77779_bT, field_70146_Z, 0.5F);
            func_70948_a(merchantrecipelist, Item.field_77717_p.field_77779_bT, field_70146_Z, 0.5F);
            func_70948_a(merchantrecipelist, Item.field_77702_n.field_77779_bT, field_70146_Z, 0.5F);
            func_70949_b(merchantrecipelist, Item.field_77716_q.field_77779_bT, field_70146_Z, 0.5F);
            func_70949_b(merchantrecipelist, Item.field_77718_z.field_77779_bT, field_70146_Z, 0.5F);
            func_70949_b(merchantrecipelist, Item.field_77708_h.field_77779_bT, field_70146_Z, 0.3F);
            func_70949_b(merchantrecipelist, Item.field_77675_C.field_77779_bT, field_70146_Z, 0.3F);
            func_70949_b(merchantrecipelist, Item.field_77696_g.field_77779_bT, field_70146_Z, 0.5F);
            func_70949_b(merchantrecipelist, Item.field_77674_B.field_77779_bT, field_70146_Z, 0.5F);
            func_70949_b(merchantrecipelist, Item.field_77695_f.field_77779_bT, field_70146_Z, 0.2F);
            func_70949_b(merchantrecipelist, Item.field_77673_A.field_77779_bT, field_70146_Z, 0.2F);
            func_70949_b(merchantrecipelist, Item.field_77689_P.field_77779_bT, field_70146_Z, 0.2F);
            func_70949_b(merchantrecipelist, Item.field_77688_Q.field_77779_bT, field_70146_Z, 0.2F);
            func_70949_b(merchantrecipelist, Item.field_77818_ag.field_77779_bT, field_70146_Z, 0.2F);
            func_70949_b(merchantrecipelist, Item.field_77794_ak.field_77779_bT, field_70146_Z, 0.2F);
            func_70949_b(merchantrecipelist, Item.field_77812_ad.field_77779_bT, field_70146_Z, 0.2F);
            func_70949_b(merchantrecipelist, Item.field_77820_ah.field_77779_bT, field_70146_Z, 0.2F);
            func_70949_b(merchantrecipelist, Item.field_77822_ae.field_77779_bT, field_70146_Z, 0.2F);
            func_70949_b(merchantrecipelist, Item.field_77798_ai.field_77779_bT, field_70146_Z, 0.2F);
            func_70949_b(merchantrecipelist, Item.field_77824_af.field_77779_bT, field_70146_Z, 0.2F);
            func_70949_b(merchantrecipelist, Item.field_77800_aj.field_77779_bT, field_70146_Z, 0.2F);
            func_70949_b(merchantrecipelist, Item.field_77810_ac.field_77779_bT, field_70146_Z, 0.1F);
            func_70949_b(merchantrecipelist, Item.field_77694_Z.field_77779_bT, field_70146_Z, 0.1F);
            func_70949_b(merchantrecipelist, Item.field_77814_aa.field_77779_bT, field_70146_Z, 0.1F);
            func_70949_b(merchantrecipelist, Item.field_77816_ab.field_77779_bT, field_70146_Z, 0.1F);
            break;

        case 1: // '\001'
            func_70948_a(merchantrecipelist, Item.field_77759_aK.field_77779_bT, field_70146_Z, 0.8F);
            func_70948_a(merchantrecipelist, Item.field_77760_aL.field_77779_bT, field_70146_Z, 0.8F);
            func_70948_a(merchantrecipelist, Item.field_77823_bG.field_77779_bT, field_70146_Z, 0.3F);
            func_70949_b(merchantrecipelist, Block.field_72093_an.field_71990_ca, field_70146_Z, 0.8F);
            func_70949_b(merchantrecipelist, Block.field_71946_M.field_71990_ca, field_70146_Z, 0.2F);
            func_70949_b(merchantrecipelist, Item.field_77750_aQ.field_77779_bT, field_70146_Z, 0.2F);
            func_70949_b(merchantrecipelist, Item.field_77752_aS.field_77779_bT, field_70146_Z, 0.2F);
            break;

        case 2: // '\002'
            func_70949_b(merchantrecipelist, Item.field_77748_bA.field_77779_bT, field_70146_Z, 0.3F);
            func_70949_b(merchantrecipelist, Item.field_77809_bD.field_77779_bT, field_70146_Z, 0.2F);
            func_70949_b(merchantrecipelist, Item.field_77767_aC.field_77779_bT, field_70146_Z, 0.4F);
            func_70949_b(merchantrecipelist, Block.field_72014_bd.field_71990_ca, field_70146_Z, 0.3F);
            int ai[] = {
                Item.field_77716_q.field_77779_bT, Item.field_77718_z.field_77779_bT, Item.field_77822_ae.field_77779_bT, Item.field_77798_ai.field_77779_bT, Item.field_77708_h.field_77779_bT, Item.field_77675_C.field_77779_bT, Item.field_77696_g.field_77779_bT, Item.field_77674_B.field_77779_bT
            };
            int ai1[] = ai;
            int j = ai1.length;
            for(int k = 0; k < j; k++)
            {
                int l = ai1[k];
                if(field_70146_Z.nextFloat() < 0.1F)
                {
                    merchantrecipelist.add(new MerchantRecipe(new ItemStack(l, 1, 0), new ItemStack(Item.field_77817_bH, 2 + field_70146_Z.nextInt(3), 0), EnchantmentHelper.func_77504_a(field_70146_Z, new ItemStack(l, 1, 0), 5 + field_70146_Z.nextInt(15))));
                }
            }

            break;
        }
        addModTrades(merchantrecipelist);
        if(merchantrecipelist.isEmpty())
        {
            func_70948_a(merchantrecipelist, Item.field_77717_p.field_77779_bT, field_70146_Z, 1.0F);
        }
        Collections.shuffle(merchantrecipelist);
        if(field_70963_i == null)
        {
            field_70963_i = new MerchantRecipeList();
        }
        for(int i = 0; i < p_70950_1_ && i < merchantrecipelist.size(); i++)
        {
            field_70963_i.func_77205_a((MerchantRecipe)merchantrecipelist.get(i));
        }

    }

    private void addModTrades(MerchantRecipeList merchantrecipelist)
    {
        List list = ModLoader.getTrades(func_70946_n());
        if(list == null)
        {
            return;
        }
        for(Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            TradeEntry tradeentry = (TradeEntry)iterator.next();
            if(tradeentry.buying)
            {
                func_70948_a(merchantrecipelist, tradeentry.id, field_70146_Z, tradeentry.chance);
            } else
            {
                func_70949_b(merchantrecipelist, tradeentry.id, field_70146_Z, tradeentry.chance);
            }
        }

    }

    public void func_70930_a(MerchantRecipeList merchantrecipelist)
    {
    }

    private static void func_70948_a(MerchantRecipeList p_70948_0_, int p_70948_1_, Random p_70948_2_, float p_70948_3_)
    {
        if(p_70948_2_.nextFloat() < p_70948_3_)
        {
            p_70948_0_.add(new MerchantRecipe(func_70951_a(p_70948_1_, p_70948_2_), Item.field_77817_bH));
        }
    }

    private static ItemStack func_70951_a(int p_70951_0_, Random p_70951_1_)
    {
        return new ItemStack(p_70951_0_, func_70944_b(p_70951_0_, p_70951_1_), 0);
    }

    private static int func_70944_b(int p_70944_0_, Random p_70944_1_)
    {
        Tuple tuple = (Tuple)field_70958_bB.get(Integer.valueOf(p_70944_0_));
        if(tuple == null)
        {
            return 1;
        }
        if(((Integer)tuple.func_76341_a()).intValue() >= ((Integer)tuple.func_76340_b()).intValue())
        {
            return ((Integer)tuple.func_76341_a()).intValue();
        } else
        {
            return ((Integer)tuple.func_76341_a()).intValue() + p_70944_1_.nextInt(((Integer)tuple.func_76340_b()).intValue() - ((Integer)tuple.func_76341_a()).intValue());
        }
    }

    private static void func_70949_b(MerchantRecipeList p_70949_0_, int p_70949_1_, Random p_70949_2_, float p_70949_3_)
    {
        if(p_70949_2_.nextFloat() < p_70949_3_)
        {
            int i = func_70943_c(p_70949_1_, p_70949_2_);
            ItemStack itemstack;
            ItemStack itemstack1;
            if(i < 0)
            {
                itemstack = new ItemStack(Item.field_77817_bH.field_77779_bT, 1, 0);
                itemstack1 = new ItemStack(p_70949_1_, -i, 0);
            } else
            {
                itemstack = new ItemStack(Item.field_77817_bH.field_77779_bT, i, 0);
                itemstack1 = new ItemStack(p_70949_1_, 1, 0);
            }
            p_70949_0_.add(new MerchantRecipe(itemstack, itemstack1));
        }
    }

    private static int func_70943_c(int p_70943_0_, Random p_70943_1_)
    {
        Tuple tuple = (Tuple)field_70960_bC.get(Integer.valueOf(p_70943_0_));
        if(tuple == null)
        {
            return 1;
        }
        if(((Integer)tuple.func_76341_a()).intValue() >= ((Integer)tuple.func_76340_b()).intValue())
        {
            return ((Integer)tuple.func_76341_a()).intValue();
        } else
        {
            return ((Integer)tuple.func_76341_a()).intValue() + p_70943_1_.nextInt(((Integer)tuple.func_76340_b()).intValue() - ((Integer)tuple.func_76341_a()).intValue());
        }
    }

    public void func_70103_a(byte p_70103_1_)
    {
        if(p_70103_1_ == 12)
        {
            func_70942_a("heart");
        } else
        {
            super.func_70103_a(p_70103_1_);
        }
    }

    private void func_70942_a(String p_70942_1_)
    {
        for(int i = 0; i < 5; i++)
        {
            double d = field_70146_Z.nextGaussian() * 0.02D;
            double d1 = field_70146_Z.nextGaussian() * 0.02D;
            double d2 = field_70146_Z.nextGaussian() * 0.02D;
            field_70170_p.func_72869_a(p_70942_1_, (field_70165_t + (double)(field_70146_Z.nextFloat() * field_70130_N * 2.0F)) - (double)field_70130_N, field_70163_u + 1.0D + (double)(field_70146_Z.nextFloat() * field_70131_O), (field_70161_v + (double)(field_70146_Z.nextFloat() * field_70130_N * 2.0F)) - (double)field_70130_N, d, d1, d2);
        }

    }

    static 
    {
        field_70958_bB = new HashMap();
        field_70960_bC = new HashMap();
        field_70958_bB.put(Integer.valueOf(Item.field_77705_m.field_77779_bT), new Tuple(Integer.valueOf(16), Integer.valueOf(24)));
        field_70958_bB.put(Integer.valueOf(Item.field_77703_o.field_77779_bT), new Tuple(Integer.valueOf(8), Integer.valueOf(10)));
        field_70958_bB.put(Integer.valueOf(Item.field_77717_p.field_77779_bT), new Tuple(Integer.valueOf(8), Integer.valueOf(10)));
        field_70958_bB.put(Integer.valueOf(Item.field_77702_n.field_77779_bT), new Tuple(Integer.valueOf(4), Integer.valueOf(6)));
        field_70958_bB.put(Integer.valueOf(Item.field_77759_aK.field_77779_bT), new Tuple(Integer.valueOf(19), Integer.valueOf(30)));
        field_70958_bB.put(Integer.valueOf(Item.field_77760_aL.field_77779_bT), new Tuple(Integer.valueOf(12), Integer.valueOf(15)));
        field_70958_bB.put(Integer.valueOf(Item.field_77823_bG.field_77779_bT), new Tuple(Integer.valueOf(1), Integer.valueOf(1)));
        field_70958_bB.put(Integer.valueOf(Item.field_77730_bn.field_77779_bT), new Tuple(Integer.valueOf(3), Integer.valueOf(4)));
        field_70958_bB.put(Integer.valueOf(Item.field_77748_bA.field_77779_bT), new Tuple(Integer.valueOf(2), Integer.valueOf(3)));
        field_70958_bB.put(Integer.valueOf(Item.field_77784_aq.field_77779_bT), new Tuple(Integer.valueOf(14), Integer.valueOf(18)));
        field_70958_bB.put(Integer.valueOf(Item.field_77741_bi.field_77779_bT), new Tuple(Integer.valueOf(14), Integer.valueOf(18)));
        field_70958_bB.put(Integer.valueOf(Item.field_77735_bk.field_77779_bT), new Tuple(Integer.valueOf(14), Integer.valueOf(18)));
        field_70958_bB.put(Integer.valueOf(Item.field_77753_aV.field_77779_bT), new Tuple(Integer.valueOf(9), Integer.valueOf(13)));
        field_70958_bB.put(Integer.valueOf(Item.field_77690_S.field_77779_bT), new Tuple(Integer.valueOf(34), Integer.valueOf(48)));
        field_70958_bB.put(Integer.valueOf(Item.field_77740_bh.field_77779_bT), new Tuple(Integer.valueOf(30), Integer.valueOf(38)));
        field_70958_bB.put(Integer.valueOf(Item.field_77739_bg.field_77779_bT), new Tuple(Integer.valueOf(30), Integer.valueOf(38)));
        field_70958_bB.put(Integer.valueOf(Item.field_77685_T.field_77779_bT), new Tuple(Integer.valueOf(18), Integer.valueOf(22)));
        field_70958_bB.put(Integer.valueOf(Block.field_72101_ab.field_71990_ca), new Tuple(Integer.valueOf(14), Integer.valueOf(22)));
        field_70958_bB.put(Integer.valueOf(Item.field_77737_bm.field_77779_bT), new Tuple(Integer.valueOf(36), Integer.valueOf(64)));
        field_70960_bC.put(Integer.valueOf(Item.field_77709_i.field_77779_bT), new Tuple(Integer.valueOf(3), Integer.valueOf(4)));
        field_70960_bC.put(Integer.valueOf(Item.field_77745_be.field_77779_bT), new Tuple(Integer.valueOf(3), Integer.valueOf(4)));
        field_70960_bC.put(Integer.valueOf(Item.field_77716_q.field_77779_bT), new Tuple(Integer.valueOf(7), Integer.valueOf(11)));
        field_70960_bC.put(Integer.valueOf(Item.field_77718_z.field_77779_bT), new Tuple(Integer.valueOf(12), Integer.valueOf(14)));
        field_70960_bC.put(Integer.valueOf(Item.field_77708_h.field_77779_bT), new Tuple(Integer.valueOf(6), Integer.valueOf(8)));
        field_70960_bC.put(Integer.valueOf(Item.field_77675_C.field_77779_bT), new Tuple(Integer.valueOf(9), Integer.valueOf(12)));
        field_70960_bC.put(Integer.valueOf(Item.field_77696_g.field_77779_bT), new Tuple(Integer.valueOf(7), Integer.valueOf(9)));
        field_70960_bC.put(Integer.valueOf(Item.field_77674_B.field_77779_bT), new Tuple(Integer.valueOf(10), Integer.valueOf(12)));
        field_70960_bC.put(Integer.valueOf(Item.field_77695_f.field_77779_bT), new Tuple(Integer.valueOf(4), Integer.valueOf(6)));
        field_70960_bC.put(Integer.valueOf(Item.field_77673_A.field_77779_bT), new Tuple(Integer.valueOf(7), Integer.valueOf(8)));
        field_70960_bC.put(Integer.valueOf(Item.field_77689_P.field_77779_bT), new Tuple(Integer.valueOf(4), Integer.valueOf(6)));
        field_70960_bC.put(Integer.valueOf(Item.field_77688_Q.field_77779_bT), new Tuple(Integer.valueOf(7), Integer.valueOf(8)));
        field_70960_bC.put(Integer.valueOf(Item.field_77818_ag.field_77779_bT), new Tuple(Integer.valueOf(4), Integer.valueOf(6)));
        field_70960_bC.put(Integer.valueOf(Item.field_77794_ak.field_77779_bT), new Tuple(Integer.valueOf(7), Integer.valueOf(8)));
        field_70960_bC.put(Integer.valueOf(Item.field_77812_ad.field_77779_bT), new Tuple(Integer.valueOf(4), Integer.valueOf(6)));
        field_70960_bC.put(Integer.valueOf(Item.field_77820_ah.field_77779_bT), new Tuple(Integer.valueOf(7), Integer.valueOf(8)));
        field_70960_bC.put(Integer.valueOf(Item.field_77822_ae.field_77779_bT), new Tuple(Integer.valueOf(10), Integer.valueOf(14)));
        field_70960_bC.put(Integer.valueOf(Item.field_77798_ai.field_77779_bT), new Tuple(Integer.valueOf(16), Integer.valueOf(19)));
        field_70960_bC.put(Integer.valueOf(Item.field_77824_af.field_77779_bT), new Tuple(Integer.valueOf(8), Integer.valueOf(10)));
        field_70960_bC.put(Integer.valueOf(Item.field_77800_aj.field_77779_bT), new Tuple(Integer.valueOf(11), Integer.valueOf(14)));
        field_70960_bC.put(Integer.valueOf(Item.field_77810_ac.field_77779_bT), new Tuple(Integer.valueOf(5), Integer.valueOf(7)));
        field_70960_bC.put(Integer.valueOf(Item.field_77694_Z.field_77779_bT), new Tuple(Integer.valueOf(5), Integer.valueOf(7)));
        field_70960_bC.put(Integer.valueOf(Item.field_77814_aa.field_77779_bT), new Tuple(Integer.valueOf(11), Integer.valueOf(15)));
        field_70960_bC.put(Integer.valueOf(Item.field_77816_ab.field_77779_bT), new Tuple(Integer.valueOf(9), Integer.valueOf(11)));
        field_70960_bC.put(Integer.valueOf(Item.field_77684_U.field_77779_bT), new Tuple(Integer.valueOf(-4), Integer.valueOf(-2)));
        field_70960_bC.put(Integer.valueOf(Item.field_77738_bf.field_77779_bT), new Tuple(Integer.valueOf(-8), Integer.valueOf(-4)));
        field_70960_bC.put(Integer.valueOf(Item.field_77706_j.field_77779_bT), new Tuple(Integer.valueOf(-8), Integer.valueOf(-4)));
        field_70960_bC.put(Integer.valueOf(Item.field_77743_bc.field_77779_bT), new Tuple(Integer.valueOf(-10), Integer.valueOf(-7)));
        field_70960_bC.put(Integer.valueOf(Block.field_71946_M.field_71990_ca), new Tuple(Integer.valueOf(-5), Integer.valueOf(-3)));
        field_70960_bC.put(Integer.valueOf(Block.field_72093_an.field_71990_ca), new Tuple(Integer.valueOf(3), Integer.valueOf(4)));
        field_70960_bC.put(Integer.valueOf(Item.field_77686_W.field_77779_bT), new Tuple(Integer.valueOf(4), Integer.valueOf(5)));
        field_70960_bC.put(Integer.valueOf(Item.field_77692_Y.field_77779_bT), new Tuple(Integer.valueOf(2), Integer.valueOf(4)));
        field_70960_bC.put(Integer.valueOf(Item.field_77687_V.field_77779_bT), new Tuple(Integer.valueOf(2), Integer.valueOf(4)));
        field_70960_bC.put(Integer.valueOf(Item.field_77693_X.field_77779_bT), new Tuple(Integer.valueOf(2), Integer.valueOf(4)));
        field_70960_bC.put(Integer.valueOf(Item.field_77765_aA.field_77779_bT), new Tuple(Integer.valueOf(6), Integer.valueOf(8)));
        field_70960_bC.put(Integer.valueOf(Item.field_77809_bD.field_77779_bT), new Tuple(Integer.valueOf(-4), Integer.valueOf(-1)));
        field_70960_bC.put(Integer.valueOf(Item.field_77767_aC.field_77779_bT), new Tuple(Integer.valueOf(-4), Integer.valueOf(-1)));
        field_70960_bC.put(Integer.valueOf(Item.field_77750_aQ.field_77779_bT), new Tuple(Integer.valueOf(10), Integer.valueOf(12)));
        field_70960_bC.put(Integer.valueOf(Item.field_77752_aS.field_77779_bT), new Tuple(Integer.valueOf(10), Integer.valueOf(12)));
        field_70960_bC.put(Integer.valueOf(Block.field_72014_bd.field_71990_ca), new Tuple(Integer.valueOf(-3), Integer.valueOf(-1)));
        field_70960_bC.put(Integer.valueOf(Item.field_77782_ar.field_77779_bT), new Tuple(Integer.valueOf(-7), Integer.valueOf(-5)));
        field_70960_bC.put(Integer.valueOf(Item.field_77734_bj.field_77779_bT), new Tuple(Integer.valueOf(-7), Integer.valueOf(-5)));
        field_70960_bC.put(Integer.valueOf(Item.field_77736_bl.field_77779_bT), new Tuple(Integer.valueOf(-8), Integer.valueOf(-6)));
        field_70960_bC.put(Integer.valueOf(Item.field_77748_bA.field_77779_bT), new Tuple(Integer.valueOf(7), Integer.valueOf(11)));
        field_70960_bC.put(Integer.valueOf(Item.field_77704_l.field_77779_bT), new Tuple(Integer.valueOf(-5), Integer.valueOf(-19)));
        List list = ModLoader.getTrades(-1);
        Iterator iterator = list.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            TradeEntry tradeentry = (TradeEntry)iterator.next();
            if(tradeentry.buying)
            {
                if(tradeentry.min > 0 && tradeentry.max > 0)
                {
                    field_70958_bB.put(Integer.valueOf(tradeentry.id), new Tuple(Integer.valueOf(tradeentry.min), Integer.valueOf(tradeentry.max)));
                }
            } else
            if(tradeentry.min > 0 && tradeentry.max > 0)
            {
                field_70960_bC.put(Integer.valueOf(tradeentry.id), new Tuple(Integer.valueOf(tradeentry.min), Integer.valueOf(tradeentry.max)));
            }
        } while(true);
    }
}
