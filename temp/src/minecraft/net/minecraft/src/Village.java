// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            ChunkCoordinates, World, MathHelper, EntityIronGolem, 
//            Vec3, Vec3Pool, AxisAlignedBB, AABBPool, 
//            EntityVillager, VillageDoorInfo, VillageAgressor, EntityLiving, 
//            Block

public class Village
{

    private final World field_75586_a;
    private final List field_75584_b = new ArrayList();
    private final ChunkCoordinates field_75585_c = new ChunkCoordinates(0, 0, 0);
    private final ChunkCoordinates field_75582_d = new ChunkCoordinates(0, 0, 0);
    private int field_75583_e;
    private int field_75580_f;
    private int field_75581_g;
    private int field_75588_h;
    private List field_75589_i;
    private int field_75587_j;

    public Village(World p_i3511_1_)
    {
        field_75583_e = 0;
        field_75580_f = 0;
        field_75581_g = 0;
        field_75588_h = 0;
        field_75589_i = new ArrayList();
        field_75587_j = 0;
        field_75586_a = p_i3511_1_;
    }

    public void func_75560_a(int p_75560_1_)
    {
        field_75581_g = p_75560_1_;
        func_75557_k();
        func_75565_j();
        if(p_75560_1_ % 20 == 0)
        {
            func_75572_i();
        }
        if(p_75560_1_ % 30 == 0)
        {
            func_75579_h();
        }
        int i = field_75588_h / 16;
        if(field_75587_j < i && field_75584_b.size() > 20 && field_75586_a.field_73012_v.nextInt(7000) == 0)
        {
            Vec3 vec3 = func_75559_a(MathHelper.func_76141_d(field_75582_d.field_71574_a), MathHelper.func_76141_d(field_75582_d.field_71572_b), MathHelper.func_76141_d(field_75582_d.field_71573_c), 2, 4, 2);
            if(vec3 != null)
            {
                EntityIronGolem entityirongolem = new EntityIronGolem(field_75586_a);
                entityirongolem.func_70107_b(vec3.field_72450_a, vec3.field_72448_b, vec3.field_72449_c);
                field_75586_a.func_72838_d(entityirongolem);
                field_75587_j++;
            }
        }
    }

    private Vec3 func_75559_a(int p_75559_1_, int p_75559_2_, int p_75559_3_, int p_75559_4_, int p_75559_5_, int p_75559_6_)
    {
        for(int i = 0; i < 10; i++)
        {
            int j = (p_75559_1_ + field_75586_a.field_73012_v.nextInt(16)) - 8;
            int k = (p_75559_2_ + field_75586_a.field_73012_v.nextInt(6)) - 3;
            int l = (p_75559_3_ + field_75586_a.field_73012_v.nextInt(16)) - 8;
            if(func_75570_a(j, k, l) && func_75563_b(j, k, l, p_75559_4_, p_75559_5_, p_75559_6_))
            {
                return Vec3.func_72437_a().func_72345_a(j, k, l);
            }
        }

        return null;
    }

    private boolean func_75563_b(int p_75563_1_, int p_75563_2_, int p_75563_3_, int p_75563_4_, int p_75563_5_, int p_75563_6_)
    {
        if(!field_75586_a.func_72797_t(p_75563_1_, p_75563_2_ - 1, p_75563_3_))
        {
            return false;
        }
        int i = p_75563_1_ - p_75563_4_ / 2;
        int j = p_75563_3_ - p_75563_6_ / 2;
        for(int k = i; k < i + p_75563_4_; k++)
        {
            for(int l = p_75563_2_; l < p_75563_2_ + p_75563_5_; l++)
            {
                for(int i1 = j; i1 < j + p_75563_6_; i1++)
                {
                    if(field_75586_a.func_72809_s(k, l, i1))
                    {
                        return false;
                    }
                }

            }

        }

        return true;
    }

    private void func_75579_h()
    {
        List list = field_75586_a.func_72872_a(net.minecraft.src.EntityIronGolem.class, AxisAlignedBB.func_72332_a().func_72299_a(field_75582_d.field_71574_a - field_75583_e, field_75582_d.field_71572_b - 4, field_75582_d.field_71573_c - field_75583_e, field_75582_d.field_71574_a + field_75583_e, field_75582_d.field_71572_b + 4, field_75582_d.field_71573_c + field_75583_e));
        field_75587_j = list.size();
    }

    private void func_75572_i()
    {
        List list = field_75586_a.func_72872_a(net.minecraft.src.EntityVillager.class, AxisAlignedBB.func_72332_a().func_72299_a(field_75582_d.field_71574_a - field_75583_e, field_75582_d.field_71572_b - 4, field_75582_d.field_71573_c - field_75583_e, field_75582_d.field_71574_a + field_75583_e, field_75582_d.field_71572_b + 4, field_75582_d.field_71573_c + field_75583_e));
        field_75588_h = list.size();
    }

    public ChunkCoordinates func_75577_a()
    {
        return field_75582_d;
    }

    public int func_75568_b()
    {
        return field_75583_e;
    }

    public int func_75567_c()
    {
        return field_75584_b.size();
    }

    public int func_75561_d()
    {
        return field_75581_g - field_75580_f;
    }

    public int func_75562_e()
    {
        return field_75588_h;
    }

    public boolean func_75570_a(int p_75570_1_, int p_75570_2_, int p_75570_3_)
    {
        return field_75582_d.func_71569_e(p_75570_1_, p_75570_2_, p_75570_3_) < (float)(field_75583_e * field_75583_e);
    }

    public List func_75558_f()
    {
        return field_75584_b;
    }

    public VillageDoorInfo func_75564_b(int p_75564_1_, int p_75564_2_, int p_75564_3_)
    {
        VillageDoorInfo villagedoorinfo = null;
        int i = 0x7fffffff;
        Iterator iterator = field_75584_b.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            VillageDoorInfo villagedoorinfo1 = (VillageDoorInfo)iterator.next();
            int j = villagedoorinfo1.func_75474_b(p_75564_1_, p_75564_2_, p_75564_3_);
            if(j < i)
            {
                villagedoorinfo = villagedoorinfo1;
                i = j;
            }
        } while(true);
        return villagedoorinfo;
    }

    public VillageDoorInfo func_75569_c(int p_75569_1_, int p_75569_2_, int p_75569_3_)
    {
        VillageDoorInfo villagedoorinfo = null;
        int i = 0x7fffffff;
        Iterator iterator = field_75584_b.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            VillageDoorInfo villagedoorinfo1 = (VillageDoorInfo)iterator.next();
            int j = villagedoorinfo1.func_75474_b(p_75569_1_, p_75569_2_, p_75569_3_);
            if(j > 256)
            {
                j *= 1000;
            } else
            {
                j = villagedoorinfo1.func_75468_f();
            }
            if(j < i)
            {
                villagedoorinfo = villagedoorinfo1;
                i = j;
            }
        } while(true);
        return villagedoorinfo;
    }

    public VillageDoorInfo func_75578_e(int p_75578_1_, int p_75578_2_, int p_75578_3_)
    {
        if(field_75582_d.func_71569_e(p_75578_1_, p_75578_2_, p_75578_3_) > (float)(field_75583_e * field_75583_e))
        {
            return null;
        }
        for(Iterator iterator = field_75584_b.iterator(); iterator.hasNext();)
        {
            VillageDoorInfo villagedoorinfo = (VillageDoorInfo)iterator.next();
            if(villagedoorinfo.field_75481_a == p_75578_1_ && villagedoorinfo.field_75480_c == p_75578_3_ && Math.abs(villagedoorinfo.field_75479_b - p_75578_2_) <= 1)
            {
                return villagedoorinfo;
            }
        }

        return null;
    }

    public void func_75576_a(VillageDoorInfo p_75576_1_)
    {
        field_75584_b.add(p_75576_1_);
        field_75585_c.field_71574_a += p_75576_1_.field_75481_a;
        field_75585_c.field_71572_b += p_75576_1_.field_75479_b;
        field_75585_c.field_71573_c += p_75576_1_.field_75480_c;
        func_75573_l();
        field_75580_f = p_75576_1_.field_75475_f;
    }

    public boolean func_75566_g()
    {
        return field_75584_b.isEmpty();
    }

    public void func_75575_a(EntityLiving p_75575_1_)
    {
        for(Iterator iterator = field_75589_i.iterator(); iterator.hasNext();)
        {
            VillageAgressor villageagressor = (VillageAgressor)iterator.next();
            if(villageagressor.field_75592_a == p_75575_1_)
            {
                villageagressor.field_75590_b = field_75581_g;
                return;
            }
        }

        field_75589_i.add(new VillageAgressor(this, p_75575_1_, field_75581_g));
    }

    public EntityLiving func_75571_b(EntityLiving p_75571_1_)
    {
        double d = 1.7976931348623157E+308D;
        VillageAgressor villageagressor = null;
        Iterator iterator = field_75589_i.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            VillageAgressor villageagressor1 = (VillageAgressor)iterator.next();
            double d1 = villageagressor1.field_75592_a.func_70068_e(p_75571_1_);
            if(d1 <= d)
            {
                villageagressor = villageagressor1;
                d = d1;
            }
        } while(true);
        return villageagressor == null ? null : villageagressor.field_75592_a;
    }

    private void func_75565_j()
    {
        Iterator iterator = field_75589_i.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            VillageAgressor villageagressor = (VillageAgressor)iterator.next();
            if(!villageagressor.field_75592_a.func_70089_S() || Math.abs(field_75581_g - villageagressor.field_75590_b) > 300)
            {
                iterator.remove();
            }
        } while(true);
    }

    private void func_75557_k()
    {
        boolean flag = false;
        boolean flag1 = field_75586_a.field_73012_v.nextInt(50) == 0;
        Iterator iterator = field_75584_b.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            VillageDoorInfo villagedoorinfo = (VillageDoorInfo)iterator.next();
            if(flag1)
            {
                villagedoorinfo.func_75466_d();
            }
            if(!func_75574_f(villagedoorinfo.field_75481_a, villagedoorinfo.field_75479_b, villagedoorinfo.field_75480_c) || Math.abs(field_75581_g - villagedoorinfo.field_75475_f) > 1200)
            {
                field_75585_c.field_71574_a -= villagedoorinfo.field_75481_a;
                field_75585_c.field_71572_b -= villagedoorinfo.field_75479_b;
                field_75585_c.field_71573_c -= villagedoorinfo.field_75480_c;
                flag = true;
                villagedoorinfo.field_75476_g = true;
                iterator.remove();
            }
        } while(true);
        if(flag)
        {
            func_75573_l();
        }
    }

    private boolean func_75574_f(int p_75574_1_, int p_75574_2_, int p_75574_3_)
    {
        int i = field_75586_a.func_72798_a(p_75574_1_, p_75574_2_, p_75574_3_);
        if(i <= 0)
        {
            return false;
        } else
        {
            return i == Block.field_72054_aE.field_71990_ca;
        }
    }

    private void func_75573_l()
    {
        int i = field_75584_b.size();
        if(i == 0)
        {
            field_75582_d.func_71571_b(0, 0, 0);
            field_75583_e = 0;
            return;
        }
        field_75582_d.func_71571_b(field_75585_c.field_71574_a / i, field_75585_c.field_71572_b / i, field_75585_c.field_71573_c / i);
        int j = 0;
        for(Iterator iterator = field_75584_b.iterator(); iterator.hasNext();)
        {
            VillageDoorInfo villagedoorinfo = (VillageDoorInfo)iterator.next();
            j = Math.max(villagedoorinfo.func_75474_b(field_75582_d.field_71574_a, field_75582_d.field_71572_b, field_75582_d.field_71573_c), j);
        }

        field_75583_e = Math.max(32, (int)Math.sqrt(j) + 1);
    }
}
