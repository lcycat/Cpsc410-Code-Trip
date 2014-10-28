// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Entity, IInventory, ItemStack, DataWatcher, 
//            World, DamageSource, EntityPlayer, PlayerCapabilities, 
//            Item, EntityItem, Block, NBTTagCompound, 
//            MathHelper, BlockRail, Vec3, AxisAlignedBB, 
//            Vec3Pool, NBTTagList, EntityLiving, EntityIronGolem, 
//            InventoryPlayer

public class EntityMinecart extends Entity
    implements IInventory
{

    private ItemStack field_70501_d[];
    private int field_70502_e;
    private boolean field_70499_f;
    public int field_70505_a;
    public double field_70503_b;
    public double field_70504_c;
    private static final int field_70500_g[][][] = {
        {
            {
                0, 0, -1
            }, {
                0, 0, 1
            }
        }, {
            {
                -1, 0, 0
            }, {
                1, 0, 0
            }
        }, {
            {
                -1, -1, 0
            }, {
                1, 0, 0
            }
        }, {
            {
                -1, 0, 0
            }, {
                1, -1, 0
            }
        }, {
            {
                0, 0, -1
            }, {
                0, -1, 1
            }
        }, {
            {
                0, -1, -1
            }, {
                0, 0, 1
            }
        }, {
            {
                0, 0, 1
            }, {
                1, 0, 0
            }
        }, {
            {
                0, 0, 1
            }, {
                -1, 0, 0
            }
        }, {
            {
                0, 0, -1
            }, {
                -1, 0, 0
            }
        }, {
            {
                0, 0, -1
            }, {
                1, 0, 0
            }
        }
    };
    private int field_70510_h;
    private double field_70511_i;
    private double field_70509_j;
    private double field_70514_an;
    private double field_70512_ao;
    private double field_70513_ap;
    private double field_70508_aq;
    private double field_70507_ar;
    private double field_70506_as;

    public EntityMinecart(World p_i3541_1_)
    {
        super(p_i3541_1_);
        field_70501_d = new ItemStack[36];
        field_70502_e = 0;
        field_70499_f = false;
        field_70156_m = true;
        func_70105_a(0.98F, 0.7F);
        field_70129_M = field_70131_O / 2.0F;
    }

    protected boolean func_70041_e_()
    {
        return false;
    }

    protected void func_70088_a()
    {
        field_70180_af.func_75682_a(16, new Byte((byte)0));
        field_70180_af.func_75682_a(17, new Integer(0));
        field_70180_af.func_75682_a(18, new Integer(1));
        field_70180_af.func_75682_a(19, new Integer(0));
    }

    public AxisAlignedBB func_70114_g(Entity p_70114_1_)
    {
        return p_70114_1_.field_70121_D;
    }

    public AxisAlignedBB func_70046_E()
    {
        return null;
    }

    public boolean func_70104_M()
    {
        return true;
    }

    public EntityMinecart(World p_i3542_1_, double p_i3542_2_, double p_i3542_4_, double p_i3542_6_, 
            int p_i3542_8_)
    {
        this(p_i3542_1_);
        func_70107_b(p_i3542_2_, p_i3542_4_ + (double)field_70129_M, p_i3542_6_);
        field_70159_w = 0.0D;
        field_70181_x = 0.0D;
        field_70179_y = 0.0D;
        field_70169_q = p_i3542_2_;
        field_70167_r = p_i3542_4_;
        field_70166_s = p_i3542_6_;
        field_70505_a = p_i3542_8_;
    }

    public double func_70042_X()
    {
        return (double)field_70131_O * 0.0D - 0.30000001192092896D;
    }

    public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_)
    {
        if(field_70170_p.field_72995_K || field_70128_L)
        {
            return true;
        }
        func_70494_i(-func_70493_k());
        func_70497_h(10);
        func_70018_K();
        func_70492_c(func_70491_i() + p_70097_2_ * 10);
        if((p_70097_1_.func_76346_g() instanceof EntityPlayer) && ((EntityPlayer)p_70097_1_.func_76346_g()).field_71075_bZ.field_75098_d)
        {
            func_70492_c(100);
        }
        if(func_70491_i() > 40)
        {
            if(field_70153_n != null)
            {
                field_70153_n.func_70078_a(this);
            }
            func_70106_y();
            func_70054_a(Item.field_77773_az.field_77779_bT, 1, 0.0F);
            if(field_70505_a == 1)
            {
                EntityMinecart entityminecart = this;
label0:
                for(int i = 0; i < entityminecart.func_70302_i_(); i++)
                {
                    ItemStack itemstack = entityminecart.func_70301_a(i);
                    if(itemstack == null)
                    {
                        continue;
                    }
                    float f = field_70146_Z.nextFloat() * 0.8F + 0.1F;
                    float f1 = field_70146_Z.nextFloat() * 0.8F + 0.1F;
                    float f2 = field_70146_Z.nextFloat() * 0.8F + 0.1F;
                    do
                    {
                        if(itemstack.field_77994_a <= 0)
                        {
                            continue label0;
                        }
                        int j = field_70146_Z.nextInt(21) + 10;
                        if(j > itemstack.field_77994_a)
                        {
                            j = itemstack.field_77994_a;
                        }
                        itemstack.field_77994_a -= j;
                        EntityItem entityitem = new EntityItem(field_70170_p, field_70165_t + (double)f, field_70163_u + (double)f1, field_70161_v + (double)f2, new ItemStack(itemstack.field_77993_c, j, itemstack.func_77960_j()));
                        float f3 = 0.05F;
                        entityitem.field_70159_w = (float)field_70146_Z.nextGaussian() * f3;
                        entityitem.field_70181_x = (float)field_70146_Z.nextGaussian() * f3 + 0.2F;
                        entityitem.field_70179_y = (float)field_70146_Z.nextGaussian() * f3;
                        field_70170_p.func_72838_d(entityitem);
                    } while(true);
                }

                func_70054_a(Block.field_72077_au.field_71990_ca, 1, 0.0F);
            } else
            if(field_70505_a == 2)
            {
                func_70054_a(Block.field_72051_aB.field_71990_ca, 1, 0.0F);
            }
        }
        return true;
    }

    public void func_70057_ab()
    {
        func_70494_i(-func_70493_k());
        func_70497_h(10);
        func_70492_c(func_70491_i() + func_70491_i() * 10);
    }

    public boolean func_70067_L()
    {
        return !field_70128_L;
    }

    public void func_70106_y()
    {
label0:
        for(int i = 0; i < func_70302_i_(); i++)
        {
            ItemStack itemstack = func_70301_a(i);
            if(itemstack == null)
            {
                continue;
            }
            float f = field_70146_Z.nextFloat() * 0.8F + 0.1F;
            float f1 = field_70146_Z.nextFloat() * 0.8F + 0.1F;
            float f2 = field_70146_Z.nextFloat() * 0.8F + 0.1F;
            do
            {
                if(itemstack.field_77994_a <= 0)
                {
                    continue label0;
                }
                int j = field_70146_Z.nextInt(21) + 10;
                if(j > itemstack.field_77994_a)
                {
                    j = itemstack.field_77994_a;
                }
                itemstack.field_77994_a -= j;
                EntityItem entityitem = new EntityItem(field_70170_p, field_70165_t + (double)f, field_70163_u + (double)f1, field_70161_v + (double)f2, new ItemStack(itemstack.field_77993_c, j, itemstack.func_77960_j()));
                if(itemstack.func_77942_o())
                {
                    entityitem.field_70294_a.func_77982_d((NBTTagCompound)itemstack.func_77978_p().func_74737_b());
                }
                float f3 = 0.05F;
                entityitem.field_70159_w = (float)field_70146_Z.nextGaussian() * f3;
                entityitem.field_70181_x = (float)field_70146_Z.nextGaussian() * f3 + 0.2F;
                entityitem.field_70179_y = (float)field_70146_Z.nextGaussian() * f3;
                field_70170_p.func_72838_d(entityitem);
            } while(true);
        }

        super.func_70106_y();
    }

    public void func_70071_h_()
    {
        if(func_70496_j() > 0)
        {
            func_70497_h(func_70496_j() - 1);
        }
        if(func_70491_i() > 0)
        {
            func_70492_c(func_70491_i() - 1);
        }
        if(field_70163_u < -64D)
        {
            func_70076_C();
        }
        if(func_70490_h() && field_70146_Z.nextInt(4) == 0)
        {
            field_70170_p.func_72869_a("largesmoke", field_70165_t, field_70163_u + 0.80000000000000004D, field_70161_v, 0.0D, 0.0D, 0.0D);
        }
        if(field_70170_p.field_72995_K)
        {
            if(field_70510_h > 0)
            {
                double d = field_70165_t + (field_70511_i - field_70165_t) / (double)field_70510_h;
                double d1 = field_70163_u + (field_70509_j - field_70163_u) / (double)field_70510_h;
                double d3 = field_70161_v + (field_70514_an - field_70161_v) / (double)field_70510_h;
                double d5 = MathHelper.func_76138_g(field_70512_ao - (double)field_70177_z);
                field_70177_z += d5 / (double)field_70510_h;
                field_70125_A += (field_70513_ap - (double)field_70125_A) / (double)field_70510_h;
                field_70510_h--;
                func_70107_b(d, d1, d3);
                func_70101_b(field_70177_z, field_70125_A);
            } else
            {
                func_70107_b(field_70165_t, field_70163_u, field_70161_v);
                func_70101_b(field_70177_z, field_70125_A);
            }
            return;
        }
        field_70169_q = field_70165_t;
        field_70167_r = field_70163_u;
        field_70166_s = field_70161_v;
        field_70181_x -= 0.039999999105930328D;
        int i = MathHelper.func_76128_c(field_70165_t);
        int j = MathHelper.func_76128_c(field_70163_u);
        int k = MathHelper.func_76128_c(field_70161_v);
        if(BlockRail.func_72180_d_(field_70170_p, i, j - 1, k))
        {
            j--;
        }
        double d2 = 0.40000000000000002D;
        double d4 = 0.0078125D;
        int l = field_70170_p.func_72798_a(i, j, k);
        if(BlockRail.func_72184_d(l))
        {
            Vec3 vec3 = func_70489_a(field_70165_t, field_70163_u, field_70161_v);
            int i1 = field_70170_p.func_72805_g(i, j, k);
            field_70163_u = j;
            boolean flag = false;
            boolean flag1 = false;
            if(l == Block.field_71954_T.field_71990_ca)
            {
                flag = (i1 & 8) != 0;
                flag1 = !flag;
            }
            if(((BlockRail)Block.field_71973_m[l]).func_72183_n())
            {
                i1 &= 7;
            }
            if(i1 >= 2 && i1 <= 5)
            {
                field_70163_u = j + 1;
            }
            if(i1 == 2)
            {
                field_70159_w -= d4;
            }
            if(i1 == 3)
            {
                field_70159_w += d4;
            }
            if(i1 == 4)
            {
                field_70179_y += d4;
            }
            if(i1 == 5)
            {
                field_70179_y -= d4;
            }
            int ai[][] = field_70500_g[i1];
            double d9 = ai[1][0] - ai[0][0];
            double d10 = ai[1][2] - ai[0][2];
            double d11 = Math.sqrt(d9 * d9 + d10 * d10);
            double d12 = field_70159_w * d9 + field_70179_y * d10;
            if(d12 < 0.0D)
            {
                d9 = -d9;
                d10 = -d10;
            }
            double d13 = Math.sqrt(field_70159_w * field_70159_w + field_70179_y * field_70179_y);
            field_70159_w = (d13 * d9) / d11;
            field_70179_y = (d13 * d10) / d11;
            if(field_70153_n != null)
            {
                double d16 = field_70153_n.field_70159_w * field_70153_n.field_70159_w + field_70153_n.field_70179_y * field_70153_n.field_70179_y;
                double d19 = field_70159_w * field_70159_w + field_70179_y * field_70179_y;
                if(d16 > 0.0001D && d19 < 0.01D)
                {
                    field_70159_w += field_70153_n.field_70159_w * 0.10000000000000001D;
                    field_70179_y += field_70153_n.field_70179_y * 0.10000000000000001D;
                    flag1 = false;
                }
            }
            if(flag1)
            {
                double d17 = Math.sqrt(field_70159_w * field_70159_w + field_70179_y * field_70179_y);
                if(d17 < 0.029999999999999999D)
                {
                    field_70159_w *= 0.0D;
                    field_70181_x *= 0.0D;
                    field_70179_y *= 0.0D;
                } else
                {
                    field_70159_w *= 0.5D;
                    field_70181_x *= 0.0D;
                    field_70179_y *= 0.5D;
                }
            }
            double d18 = 0.0D;
            double d20 = (double)i + 0.5D + (double)ai[0][0] * 0.5D;
            double d21 = (double)k + 0.5D + (double)ai[0][2] * 0.5D;
            double d22 = (double)i + 0.5D + (double)ai[1][0] * 0.5D;
            double d23 = (double)k + 0.5D + (double)ai[1][2] * 0.5D;
            d9 = d22 - d20;
            d10 = d23 - d21;
            if(d9 == 0.0D)
            {
                field_70165_t = (double)i + 0.5D;
                d18 = field_70161_v - (double)k;
            } else
            if(d10 == 0.0D)
            {
                field_70161_v = (double)k + 0.5D;
                d18 = field_70165_t - (double)i;
            } else
            {
                double d24 = field_70165_t - d20;
                double d26 = field_70161_v - d21;
                d18 = (d24 * d9 + d26 * d10) * 2D;
            }
            field_70165_t = d20 + d9 * d18;
            field_70161_v = d21 + d10 * d18;
            func_70107_b(field_70165_t, field_70163_u + (double)field_70129_M, field_70161_v);
            double d25 = field_70159_w;
            double d27 = field_70179_y;
            if(field_70153_n != null)
            {
                d25 *= 0.75D;
                d27 *= 0.75D;
            }
            if(d25 < -d2)
            {
                d25 = -d2;
            }
            if(d25 > d2)
            {
                d25 = d2;
            }
            if(d27 < -d2)
            {
                d27 = -d2;
            }
            if(d27 > d2)
            {
                d27 = d2;
            }
            func_70091_d(d25, 0.0D, d27);
            if(ai[0][1] != 0 && MathHelper.func_76128_c(field_70165_t) - i == ai[0][0] && MathHelper.func_76128_c(field_70161_v) - k == ai[0][2])
            {
                func_70107_b(field_70165_t, field_70163_u + (double)ai[0][1], field_70161_v);
            } else
            if(ai[1][1] != 0 && MathHelper.func_76128_c(field_70165_t) - i == ai[1][0] && MathHelper.func_76128_c(field_70161_v) - k == ai[1][2])
            {
                func_70107_b(field_70165_t, field_70163_u + (double)ai[1][1], field_70161_v);
            }
            if(field_70153_n != null)
            {
                field_70159_w *= 0.99699997901916504D;
                field_70181_x *= 0.0D;
                field_70179_y *= 0.99699997901916504D;
            } else
            {
                if(field_70505_a == 2)
                {
                    double d28 = field_70503_b * field_70503_b + field_70504_c * field_70504_c;
                    if(d28 > 0.0001D)
                    {
                        d28 = MathHelper.func_76133_a(d28);
                        field_70503_b /= d28;
                        field_70504_c /= d28;
                        double d30 = 0.040000000000000001D;
                        field_70159_w *= 0.80000001192092896D;
                        field_70181_x *= 0.0D;
                        field_70179_y *= 0.80000001192092896D;
                        field_70159_w += field_70503_b * d30;
                        field_70179_y += field_70504_c * d30;
                    } else
                    {
                        field_70159_w *= 0.89999997615814209D;
                        field_70181_x *= 0.0D;
                        field_70179_y *= 0.89999997615814209D;
                    }
                }
                field_70159_w *= 0.95999997854232788D;
                field_70181_x *= 0.0D;
                field_70179_y *= 0.95999997854232788D;
            }
            Vec3 vec3_1 = func_70489_a(field_70165_t, field_70163_u, field_70161_v);
            if(vec3_1 != null && vec3 != null)
            {
                double d29 = (vec3.field_72448_b - vec3_1.field_72448_b) * 0.050000000000000003D;
                double d14 = Math.sqrt(field_70159_w * field_70159_w + field_70179_y * field_70179_y);
                if(d14 > 0.0D)
                {
                    field_70159_w = (field_70159_w / d14) * (d14 + d29);
                    field_70179_y = (field_70179_y / d14) * (d14 + d29);
                }
                func_70107_b(field_70165_t, vec3_1.field_72448_b, field_70161_v);
            }
            int k1 = MathHelper.func_76128_c(field_70165_t);
            int l1 = MathHelper.func_76128_c(field_70161_v);
            if(k1 != i || l1 != k)
            {
                double d15 = Math.sqrt(field_70159_w * field_70159_w + field_70179_y * field_70179_y);
                field_70159_w = d15 * (double)(k1 - i);
                field_70179_y = d15 * (double)(l1 - k);
            }
            if(field_70505_a == 2)
            {
                double d31 = field_70503_b * field_70503_b + field_70504_c * field_70504_c;
                if(d31 > 0.0001D && field_70159_w * field_70159_w + field_70179_y * field_70179_y > 0.001D)
                {
                    d31 = MathHelper.func_76133_a(d31);
                    field_70503_b /= d31;
                    field_70504_c /= d31;
                    if(field_70503_b * field_70159_w + field_70504_c * field_70179_y < 0.0D)
                    {
                        field_70503_b = 0.0D;
                        field_70504_c = 0.0D;
                    } else
                    {
                        field_70503_b = field_70159_w;
                        field_70504_c = field_70179_y;
                    }
                }
            }
            if(flag)
            {
                double d32 = Math.sqrt(field_70159_w * field_70159_w + field_70179_y * field_70179_y);
                if(d32 > 0.01D)
                {
                    double d33 = 0.059999999999999998D;
                    field_70159_w += (field_70159_w / d32) * d33;
                    field_70179_y += (field_70179_y / d32) * d33;
                } else
                if(i1 == 1)
                {
                    if(field_70170_p.func_72809_s(i - 1, j, k))
                    {
                        field_70159_w = 0.02D;
                    } else
                    if(field_70170_p.func_72809_s(i + 1, j, k))
                    {
                        field_70159_w = -0.02D;
                    }
                } else
                if(i1 == 0)
                {
                    if(field_70170_p.func_72809_s(i, j, k - 1))
                    {
                        field_70179_y = 0.02D;
                    } else
                    if(field_70170_p.func_72809_s(i, j, k + 1))
                    {
                        field_70179_y = -0.02D;
                    }
                }
            }
            func_70017_D();
        } else
        {
            if(field_70159_w < -d2)
            {
                field_70159_w = -d2;
            }
            if(field_70159_w > d2)
            {
                field_70159_w = d2;
            }
            if(field_70179_y < -d2)
            {
                field_70179_y = -d2;
            }
            if(field_70179_y > d2)
            {
                field_70179_y = d2;
            }
            if(field_70122_E)
            {
                field_70159_w *= 0.5D;
                field_70181_x *= 0.5D;
                field_70179_y *= 0.5D;
            }
            func_70091_d(field_70159_w, field_70181_x, field_70179_y);
            if(!field_70122_E)
            {
                field_70159_w *= 0.94999998807907104D;
                field_70181_x *= 0.94999998807907104D;
                field_70179_y *= 0.94999998807907104D;
            }
        }
        field_70125_A = 0.0F;
        double d6 = field_70169_q - field_70165_t;
        double d7 = field_70166_s - field_70161_v;
        if(d6 * d6 + d7 * d7 > 0.001D)
        {
            field_70177_z = (float)((Math.atan2(d7, d6) * 180D) / 3.1415926535897931D);
            if(field_70499_f)
            {
                field_70177_z += 180F;
            }
        }
        double d8 = MathHelper.func_76142_g(field_70177_z - field_70126_B);
        if(d8 < -170D || d8 >= 170D)
        {
            field_70177_z += 180F;
            field_70499_f = !field_70499_f;
        }
        func_70101_b(field_70177_z, field_70125_A);
        List list = field_70170_p.func_72839_b(this, field_70121_D.func_72314_b(0.20000000298023224D, 0.0D, 0.20000000298023224D));
        if(list != null && !list.isEmpty())
        {
            for(int j1 = 0; j1 < list.size(); j1++)
            {
                Entity entity = (Entity)list.get(j1);
                if(entity != field_70153_n && entity.func_70104_M() && (entity instanceof EntityMinecart))
                {
                    entity.func_70108_f(this);
                }
            }

        }
        if(field_70153_n != null && field_70153_n.field_70128_L)
        {
            if(field_70153_n.field_70154_o == this)
            {
                field_70153_n.field_70154_o = null;
            }
            field_70153_n = null;
        }
        if(field_70502_e > 0)
        {
            field_70502_e--;
        }
        if(field_70502_e <= 0)
        {
            field_70503_b = field_70504_c = 0.0D;
        }
        func_70498_d(field_70502_e > 0);
    }

    public Vec3 func_70495_a(double p_70495_1_, double p_70495_3_, double p_70495_5_, double p_70495_7_)
    {
        int i = MathHelper.func_76128_c(p_70495_1_);
        int j = MathHelper.func_76128_c(p_70495_3_);
        int k = MathHelper.func_76128_c(p_70495_5_);
        if(BlockRail.func_72180_d_(field_70170_p, i, j - 1, k))
        {
            j--;
        }
        int l = field_70170_p.func_72798_a(i, j, k);
        if(BlockRail.func_72184_d(l))
        {
            int i1 = field_70170_p.func_72805_g(i, j, k);
            if(((BlockRail)Block.field_71973_m[l]).func_72183_n())
            {
                i1 &= 7;
            }
            p_70495_3_ = j;
            if(i1 >= 2 && i1 <= 5)
            {
                p_70495_3_ = j + 1;
            }
            int ai[][] = field_70500_g[i1];
            double d = ai[1][0] - ai[0][0];
            double d1 = ai[1][2] - ai[0][2];
            double d2 = Math.sqrt(d * d + d1 * d1);
            d /= d2;
            d1 /= d2;
            p_70495_1_ += d * p_70495_7_;
            p_70495_5_ += d1 * p_70495_7_;
            if(ai[0][1] != 0 && MathHelper.func_76128_c(p_70495_1_) - i == ai[0][0] && MathHelper.func_76128_c(p_70495_5_) - k == ai[0][2])
            {
                p_70495_3_ += ai[0][1];
            } else
            if(ai[1][1] != 0 && MathHelper.func_76128_c(p_70495_1_) - i == ai[1][0] && MathHelper.func_76128_c(p_70495_5_) - k == ai[1][2])
            {
                p_70495_3_ += ai[1][1];
            }
            return func_70489_a(p_70495_1_, p_70495_3_, p_70495_5_);
        } else
        {
            return null;
        }
    }

    public Vec3 func_70489_a(double p_70489_1_, double p_70489_3_, double p_70489_5_)
    {
        int i = MathHelper.func_76128_c(p_70489_1_);
        int j = MathHelper.func_76128_c(p_70489_3_);
        int k = MathHelper.func_76128_c(p_70489_5_);
        if(BlockRail.func_72180_d_(field_70170_p, i, j - 1, k))
        {
            j--;
        }
        int l = field_70170_p.func_72798_a(i, j, k);
        if(BlockRail.func_72184_d(l))
        {
            int i1 = field_70170_p.func_72805_g(i, j, k);
            p_70489_3_ = j;
            if(((BlockRail)Block.field_71973_m[l]).func_72183_n())
            {
                i1 &= 7;
            }
            if(i1 >= 2 && i1 <= 5)
            {
                p_70489_3_ = j + 1;
            }
            int ai[][] = field_70500_g[i1];
            double d = 0.0D;
            double d1 = (double)i + 0.5D + (double)ai[0][0] * 0.5D;
            double d2 = (double)j + 0.5D + (double)ai[0][1] * 0.5D;
            double d3 = (double)k + 0.5D + (double)ai[0][2] * 0.5D;
            double d4 = (double)i + 0.5D + (double)ai[1][0] * 0.5D;
            double d5 = (double)j + 0.5D + (double)ai[1][1] * 0.5D;
            double d6 = (double)k + 0.5D + (double)ai[1][2] * 0.5D;
            double d7 = d4 - d1;
            double d8 = (d5 - d2) * 2D;
            double d9 = d6 - d3;
            if(d7 == 0.0D)
            {
                p_70489_1_ = (double)i + 0.5D;
                d = p_70489_5_ - (double)k;
            } else
            if(d9 == 0.0D)
            {
                p_70489_5_ = (double)k + 0.5D;
                d = p_70489_1_ - (double)i;
            } else
            {
                double d10 = p_70489_1_ - d1;
                double d11 = p_70489_5_ - d3;
                d = (d10 * d7 + d11 * d9) * 2D;
            }
            p_70489_1_ = d1 + d7 * d;
            p_70489_3_ = d2 + d8 * d;
            p_70489_5_ = d3 + d9 * d;
            if(d8 < 0.0D)
            {
                p_70489_3_++;
            }
            if(d8 > 0.0D)
            {
                p_70489_3_ += 0.5D;
            }
            return Vec3.func_72437_a().func_72345_a(p_70489_1_, p_70489_3_, p_70489_5_);
        } else
        {
            return null;
        }
    }

    protected void func_70014_b(NBTTagCompound p_70014_1_)
    {
        p_70014_1_.func_74768_a("Type", field_70505_a);
        if(field_70505_a == 2)
        {
            p_70014_1_.func_74780_a("PushX", field_70503_b);
            p_70014_1_.func_74780_a("PushZ", field_70504_c);
            p_70014_1_.func_74777_a("Fuel", (short)field_70502_e);
        } else
        if(field_70505_a == 1)
        {
            NBTTagList nbttaglist = new NBTTagList();
            for(int i = 0; i < field_70501_d.length; i++)
            {
                if(field_70501_d[i] != null)
                {
                    NBTTagCompound nbttagcompound = new NBTTagCompound();
                    nbttagcompound.func_74774_a("Slot", (byte)i);
                    field_70501_d[i].func_77955_b(nbttagcompound);
                    nbttaglist.func_74742_a(nbttagcompound);
                }
            }

            p_70014_1_.func_74782_a("Items", nbttaglist);
        }
    }

    protected void func_70037_a(NBTTagCompound p_70037_1_)
    {
        field_70505_a = p_70037_1_.func_74762_e("Type");
        if(field_70505_a == 2)
        {
            field_70503_b = p_70037_1_.func_74769_h("PushX");
            field_70504_c = p_70037_1_.func_74769_h("PushZ");
            field_70502_e = p_70037_1_.func_74765_d("Fuel");
        } else
        if(field_70505_a == 1)
        {
            NBTTagList nbttaglist = p_70037_1_.func_74761_m("Items");
            field_70501_d = new ItemStack[func_70302_i_()];
            for(int i = 0; i < nbttaglist.func_74745_c(); i++)
            {
                NBTTagCompound nbttagcompound = (NBTTagCompound)nbttaglist.func_74743_b(i);
                int j = nbttagcompound.func_74771_c("Slot") & 0xff;
                if(j >= 0 && j < field_70501_d.length)
                {
                    field_70501_d[j] = ItemStack.func_77949_a(nbttagcompound);
                }
            }

        }
    }

    public float func_70053_R()
    {
        return 0.0F;
    }

    public void func_70108_f(Entity p_70108_1_)
    {
        if(field_70170_p.field_72995_K)
        {
            return;
        }
        if(p_70108_1_ == field_70153_n)
        {
            return;
        }
        if((p_70108_1_ instanceof EntityLiving) && !(p_70108_1_ instanceof EntityPlayer) && !(p_70108_1_ instanceof EntityIronGolem) && field_70505_a == 0 && field_70159_w * field_70159_w + field_70179_y * field_70179_y > 0.01D && field_70153_n == null && p_70108_1_.field_70154_o == null)
        {
            p_70108_1_.func_70078_a(this);
        }
        double d = p_70108_1_.field_70165_t - field_70165_t;
        double d1 = p_70108_1_.field_70161_v - field_70161_v;
        double d2 = d * d + d1 * d1;
        if(d2 >= 9.9999997473787516E-005D)
        {
            d2 = MathHelper.func_76133_a(d2);
            d /= d2;
            d1 /= d2;
            double d3 = 1.0D / d2;
            if(d3 > 1.0D)
            {
                d3 = 1.0D;
            }
            d *= d3;
            d1 *= d3;
            d *= 0.10000000149011612D;
            d1 *= 0.10000000149011612D;
            d *= 1.0F - field_70144_Y;
            d1 *= 1.0F - field_70144_Y;
            d *= 0.5D;
            d1 *= 0.5D;
            if(p_70108_1_ instanceof EntityMinecart)
            {
                double d4 = p_70108_1_.field_70165_t - field_70165_t;
                double d5 = p_70108_1_.field_70161_v - field_70161_v;
                Vec3 vec3 = Vec3.func_72437_a().func_72345_a(d4, 0.0D, d5).func_72432_b();
                Vec3 vec3_1 = Vec3.func_72437_a().func_72345_a(MathHelper.func_76134_b((field_70177_z * 3.141593F) / 180F), 0.0D, MathHelper.func_76126_a((field_70177_z * 3.141593F) / 180F)).func_72432_b();
                double d6 = Math.abs(vec3.func_72430_b(vec3_1));
                if(d6 < 0.80000001192092896D)
                {
                    return;
                }
                double d7 = p_70108_1_.field_70159_w + field_70159_w;
                double d8 = p_70108_1_.field_70179_y + field_70179_y;
                if(((EntityMinecart)p_70108_1_).field_70505_a == 2 && field_70505_a != 2)
                {
                    field_70159_w *= 0.20000000298023224D;
                    field_70179_y *= 0.20000000298023224D;
                    func_70024_g(p_70108_1_.field_70159_w - d, 0.0D, p_70108_1_.field_70179_y - d1);
                    p_70108_1_.field_70159_w *= 0.94999998807907104D;
                    p_70108_1_.field_70179_y *= 0.94999998807907104D;
                } else
                if(((EntityMinecart)p_70108_1_).field_70505_a != 2 && field_70505_a == 2)
                {
                    p_70108_1_.field_70159_w *= 0.20000000298023224D;
                    p_70108_1_.field_70179_y *= 0.20000000298023224D;
                    p_70108_1_.func_70024_g(field_70159_w + d, 0.0D, field_70179_y + d1);
                    field_70159_w *= 0.94999998807907104D;
                    field_70179_y *= 0.94999998807907104D;
                } else
                {
                    d7 /= 2D;
                    d8 /= 2D;
                    field_70159_w *= 0.20000000298023224D;
                    field_70179_y *= 0.20000000298023224D;
                    func_70024_g(d7 - d, 0.0D, d8 - d1);
                    p_70108_1_.field_70159_w *= 0.20000000298023224D;
                    p_70108_1_.field_70179_y *= 0.20000000298023224D;
                    p_70108_1_.func_70024_g(d7 + d, 0.0D, d8 + d1);
                }
            } else
            {
                func_70024_g(-d, 0.0D, -d1);
                p_70108_1_.func_70024_g(d / 4D, 0.0D, d1 / 4D);
            }
        }
    }

    public int func_70302_i_()
    {
        return 27;
    }

    public ItemStack func_70301_a(int p_70301_1_)
    {
        return field_70501_d[p_70301_1_];
    }

    public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_)
    {
        if(field_70501_d[p_70298_1_] != null)
        {
            if(field_70501_d[p_70298_1_].field_77994_a <= p_70298_2_)
            {
                ItemStack itemstack = field_70501_d[p_70298_1_];
                field_70501_d[p_70298_1_] = null;
                return itemstack;
            }
            ItemStack itemstack1 = field_70501_d[p_70298_1_].func_77979_a(p_70298_2_);
            if(field_70501_d[p_70298_1_].field_77994_a == 0)
            {
                field_70501_d[p_70298_1_] = null;
            }
            return itemstack1;
        } else
        {
            return null;
        }
    }

    public ItemStack func_70304_b(int p_70304_1_)
    {
        if(field_70501_d[p_70304_1_] != null)
        {
            ItemStack itemstack = field_70501_d[p_70304_1_];
            field_70501_d[p_70304_1_] = null;
            return itemstack;
        } else
        {
            return null;
        }
    }

    public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_)
    {
        field_70501_d[p_70299_1_] = p_70299_2_;
        if(p_70299_2_ != null && p_70299_2_.field_77994_a > func_70297_j_())
        {
            p_70299_2_.field_77994_a = func_70297_j_();
        }
    }

    public String func_70303_b()
    {
        return "container.minecart";
    }

    public int func_70297_j_()
    {
        return 64;
    }

    public void func_70296_d()
    {
    }

    public boolean func_70085_c(EntityPlayer p_70085_1_)
    {
        if(field_70505_a == 0)
        {
            if(field_70153_n != null && (field_70153_n instanceof EntityPlayer) && field_70153_n != p_70085_1_)
            {
                return true;
            }
            if(!field_70170_p.field_72995_K)
            {
                p_70085_1_.func_70078_a(this);
            }
        } else
        if(field_70505_a == 1)
        {
            if(!field_70170_p.field_72995_K)
            {
                p_70085_1_.func_71007_a(this);
            }
        } else
        if(field_70505_a == 2)
        {
            ItemStack itemstack = p_70085_1_.field_71071_by.func_70448_g();
            if(itemstack != null && itemstack.field_77993_c == Item.field_77705_m.field_77779_bT)
            {
                if(--itemstack.field_77994_a == 0)
                {
                    p_70085_1_.field_71071_by.func_70299_a(p_70085_1_.field_71071_by.field_70461_c, null);
                }
                field_70502_e += 3600;
            }
            field_70503_b = field_70165_t - p_70085_1_.field_70165_t;
            field_70504_c = field_70161_v - p_70085_1_.field_70161_v;
        }
        return true;
    }

    public void func_70056_a(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, 
            float p_70056_8_, int p_70056_9_)
    {
        field_70511_i = p_70056_1_;
        field_70509_j = p_70056_3_;
        field_70514_an = p_70056_5_;
        field_70512_ao = p_70056_7_;
        field_70513_ap = p_70056_8_;
        field_70510_h = p_70056_9_ + 2;
        field_70159_w = field_70508_aq;
        field_70181_x = field_70507_ar;
        field_70179_y = field_70506_as;
    }

    public void func_70016_h(double p_70016_1_, double p_70016_3_, double p_70016_5_)
    {
        field_70508_aq = field_70159_w = p_70016_1_;
        field_70507_ar = field_70181_x = p_70016_3_;
        field_70506_as = field_70179_y = p_70016_5_;
    }

    public boolean func_70300_a(EntityPlayer p_70300_1_)
    {
        if(field_70128_L)
        {
            return false;
        }
        return p_70300_1_.func_70068_e(this) <= 64D;
    }

    protected boolean func_70490_h()
    {
        return (field_70180_af.func_75683_a(16) & 1) != 0;
    }

    protected void func_70498_d(boolean p_70498_1_)
    {
        if(p_70498_1_)
        {
            field_70180_af.func_75692_b(16, Byte.valueOf((byte)(field_70180_af.func_75683_a(16) | 1)));
        } else
        {
            field_70180_af.func_75692_b(16, Byte.valueOf((byte)(field_70180_af.func_75683_a(16) & -2)));
        }
    }

    public void func_70295_k_()
    {
    }

    public void func_70305_f()
    {
    }

    public void func_70492_c(int p_70492_1_)
    {
        field_70180_af.func_75692_b(19, Integer.valueOf(p_70492_1_));
    }

    public int func_70491_i()
    {
        return field_70180_af.func_75679_c(19);
    }

    public void func_70497_h(int p_70497_1_)
    {
        field_70180_af.func_75692_b(17, Integer.valueOf(p_70497_1_));
    }

    public int func_70496_j()
    {
        return field_70180_af.func_75679_c(17);
    }

    public void func_70494_i(int p_70494_1_)
    {
        field_70180_af.func_75692_b(18, Integer.valueOf(p_70494_1_));
    }

    public int func_70493_k()
    {
        return field_70180_af.func_75679_c(18);
    }

}
