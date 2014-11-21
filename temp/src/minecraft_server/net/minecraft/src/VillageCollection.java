// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            ChunkCoordinates, Village, VillageDoorInfo, Block, 
//            BlockDoor, World

public class VillageCollection
{

    private World field_75556_a;
    private final List field_75554_b = new ArrayList();
    private final List field_75555_c = new ArrayList();
    private final List field_75552_d = new ArrayList();
    private int field_75553_e;

    public VillageCollection(World p_i3513_1_)
    {
        field_75553_e = 0;
        field_75556_a = p_i3513_1_;
    }

    public void func_75551_a(int p_75551_1_, int p_75551_2_, int p_75551_3_)
    {
        if(field_75554_b.size() > 64)
        {
            return;
        }
        if(!func_75548_d(p_75551_1_, p_75551_2_, p_75551_3_))
        {
            field_75554_b.add(new ChunkCoordinates(p_75551_1_, p_75551_2_, p_75551_3_));
        }
    }

    public void func_75544_a()
    {
        field_75553_e++;
        Village village;
        for(Iterator iterator = field_75552_d.iterator(); iterator.hasNext(); village.func_75560_a(field_75553_e))
        {
            village = (Village)iterator.next();
        }

        func_75549_c();
        func_75543_d();
        func_75545_e();
    }

    private void func_75549_c()
    {
        Iterator iterator = field_75552_d.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            Village village = (Village)iterator.next();
            if(village.func_75566_g())
            {
                iterator.remove();
            }
        } while(true);
    }

    public List func_75540_b()
    {
        return field_75552_d;
    }

    public Village func_75550_a(int p_75550_1_, int p_75550_2_, int p_75550_3_, int p_75550_4_)
    {
        Village village = null;
        float f = 3.402823E+038F;
        Iterator iterator = field_75552_d.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            Village village1 = (Village)iterator.next();
            float f1 = village1.func_75577_a().func_71569_e(p_75550_1_, p_75550_2_, p_75550_3_);
            if(f1 < f)
            {
                int i = p_75550_4_ + village1.func_75568_b();
                if(f1 <= (float)(i * i))
                {
                    village = village1;
                    f = f1;
                }
            }
        } while(true);
        return village;
    }

    private void func_75543_d()
    {
        if(field_75554_b.isEmpty())
        {
            return;
        } else
        {
            func_75546_a((ChunkCoordinates)field_75554_b.remove(0));
            return;
        }
    }

    private void func_75545_e()
    {
        Iterator iterator = field_75555_c.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            VillageDoorInfo villagedoorinfo = (VillageDoorInfo)iterator.next();
            boolean flag = false;
            Iterator iterator1 = field_75552_d.iterator();
            do
            {
                if(!iterator1.hasNext())
                {
                    break;
                }
                Village village1 = (Village)iterator1.next();
                int i = (int)village1.func_75577_a().func_71569_e(villagedoorinfo.field_75481_a, villagedoorinfo.field_75479_b, villagedoorinfo.field_75480_c);
                int j = 32 + village1.func_75568_b();
                if(i > j * j)
                {
                    continue;
                }
                village1.func_75576_a(villagedoorinfo);
                flag = true;
                break;
            } while(true);
            if(!flag)
            {
                Village village = new Village(field_75556_a);
                village.func_75576_a(villagedoorinfo);
                field_75552_d.add(village);
            }
        } while(true);
        field_75555_c.clear();
    }

    private void func_75546_a(ChunkCoordinates p_75546_1_)
    {
        byte byte0 = 16;
        byte byte1 = 4;
        byte byte2 = 16;
        for(int i = p_75546_1_.field_71574_a - byte0; i < p_75546_1_.field_71574_a + byte0; i++)
        {
            for(int j = p_75546_1_.field_71572_b - byte1; j < p_75546_1_.field_71572_b + byte1; j++)
            {
                for(int k = p_75546_1_.field_71573_c - byte2; k < p_75546_1_.field_71573_c + byte2; k++)
                {
                    if(!func_75541_e(i, j, k))
                    {
                        continue;
                    }
                    VillageDoorInfo villagedoorinfo = func_75547_b(i, j, k);
                    if(villagedoorinfo == null)
                    {
                        func_75542_c(i, j, k);
                    } else
                    {
                        villagedoorinfo.field_75475_f = field_75553_e;
                    }
                }

            }

        }

    }

    private VillageDoorInfo func_75547_b(int p_75547_1_, int p_75547_2_, int p_75547_3_)
    {
        for(Iterator iterator = field_75555_c.iterator(); iterator.hasNext();)
        {
            VillageDoorInfo villagedoorinfo = (VillageDoorInfo)iterator.next();
            if(villagedoorinfo.field_75481_a == p_75547_1_ && villagedoorinfo.field_75480_c == p_75547_3_ && Math.abs(villagedoorinfo.field_75479_b - p_75547_2_) <= 1)
            {
                return villagedoorinfo;
            }
        }

        for(Iterator iterator1 = field_75552_d.iterator(); iterator1.hasNext();)
        {
            Village village = (Village)iterator1.next();
            VillageDoorInfo villagedoorinfo1 = village.func_75578_e(p_75547_1_, p_75547_2_, p_75547_3_);
            if(villagedoorinfo1 != null)
            {
                return villagedoorinfo1;
            }
        }

        return null;
    }

    private void func_75542_c(int p_75542_1_, int p_75542_2_, int p_75542_3_)
    {
        int i = ((BlockDoor)Block.field_72054_aE).func_72235_d(field_75556_a, p_75542_1_, p_75542_2_, p_75542_3_);
        if(i == 0 || i == 2)
        {
            int j = 0;
            for(int l = -5; l < 0; l++)
            {
                if(field_75556_a.func_72937_j(p_75542_1_ + l, p_75542_2_, p_75542_3_))
                {
                    j--;
                }
            }

            for(int i1 = 1; i1 <= 5; i1++)
            {
                if(field_75556_a.func_72937_j(p_75542_1_ + i1, p_75542_2_, p_75542_3_))
                {
                    j++;
                }
            }

            if(j != 0)
            {
                field_75555_c.add(new VillageDoorInfo(p_75542_1_, p_75542_2_, p_75542_3_, j <= 0 ? 2 : -2, 0, field_75553_e));
            }
        } else
        {
            int k = 0;
            for(int j1 = -5; j1 < 0; j1++)
            {
                if(field_75556_a.func_72937_j(p_75542_1_, p_75542_2_, p_75542_3_ + j1))
                {
                    k--;
                }
            }

            for(int k1 = 1; k1 <= 5; k1++)
            {
                if(field_75556_a.func_72937_j(p_75542_1_, p_75542_2_, p_75542_3_ + k1))
                {
                    k++;
                }
            }

            if(k != 0)
            {
                field_75555_c.add(new VillageDoorInfo(p_75542_1_, p_75542_2_, p_75542_3_, 0, k <= 0 ? 2 : -2, field_75553_e));
            }
        }
    }

    private boolean func_75548_d(int p_75548_1_, int p_75548_2_, int p_75548_3_)
    {
        for(Iterator iterator = field_75554_b.iterator(); iterator.hasNext();)
        {
            ChunkCoordinates chunkcoordinates = (ChunkCoordinates)iterator.next();
            if(chunkcoordinates.field_71574_a == p_75548_1_ && chunkcoordinates.field_71572_b == p_75548_2_ && chunkcoordinates.field_71573_c == p_75548_3_)
            {
                return true;
            }
        }

        return false;
    }

    private boolean func_75541_e(int p_75541_1_, int p_75541_2_, int p_75541_3_)
    {
        int i = field_75556_a.func_72798_a(p_75541_1_, p_75541_2_, p_75541_3_);
        return i == Block.field_72054_aE.field_71990_ca;
    }
}
