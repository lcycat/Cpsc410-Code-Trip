// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            World, EntityPlayer, VillageCollection, Village, 
//            ChunkCoordinates, MathHelper, EntityZombie, Vec3, 
//            EntityLiving, EnumCreatureType, SpawnerAnimals, Vec3Pool

public class VillageSiege
{

    private World field_75537_a;
    private boolean field_75535_b;
    private int field_75536_c;
    private int field_75533_d;
    private int field_75534_e;
    private Village field_75531_f;
    private int field_75532_g;
    private int field_75538_h;
    private int field_75539_i;

    public VillageSiege(World p_i3512_1_)
    {
        field_75535_b = false;
        field_75536_c = -1;
        field_75537_a = p_i3512_1_;
    }

    public void func_75528_a()
    {
        boolean flag = false;
        if(flag)
        {
            if(field_75536_c == 2)
            {
                field_75533_d = 100;
                return;
            }
        } else
        {
            if(field_75537_a.func_72935_r())
            {
                field_75536_c = 0;
                return;
            }
            if(field_75536_c == 2)
            {
                return;
            }
            if(field_75536_c == 0)
            {
                float f = field_75537_a.func_72826_c(0.0F);
                if((double)f < 0.5D || (double)f > 0.501D)
                {
                    return;
                }
                field_75536_c = field_75537_a.field_73012_v.nextInt(10) != 0 ? 2 : 1;
                field_75535_b = false;
                if(field_75536_c == 2)
                {
                    return;
                }
            }
        }
        if(!field_75535_b)
        {
            if(func_75529_b())
            {
                field_75535_b = true;
            } else
            {
                return;
            }
        }
        if(field_75534_e > 0)
        {
            field_75534_e--;
            return;
        }
        field_75534_e = 2;
        if(field_75533_d > 0)
        {
            func_75530_c();
            field_75533_d--;
        } else
        {
            field_75536_c = 2;
        }
    }

    private boolean func_75529_b()
    {
        List list = field_75537_a.field_73010_i;
        for(Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            EntityPlayer entityplayer = (EntityPlayer)iterator.next();
            field_75531_f = field_75537_a.field_72982_D.func_75550_a((int)entityplayer.field_70165_t, (int)entityplayer.field_70163_u, (int)entityplayer.field_70161_v, 1);
            if(field_75531_f != null && field_75531_f.func_75567_c() >= 10 && field_75531_f.func_75561_d() >= 20 && field_75531_f.func_75562_e() >= 20)
            {
                ChunkCoordinates chunkcoordinates = field_75531_f.func_75577_a();
                float f = field_75531_f.func_75568_b();
                boolean flag = false;
                int i = 0;
                do
                {
                    if(i >= 10)
                    {
                        break;
                    }
                    field_75532_g = chunkcoordinates.field_71574_a + (int)((double)(MathHelper.func_76134_b(field_75537_a.field_73012_v.nextFloat() * 3.141593F * 2.0F) * f) * 0.90000000000000002D);
                    field_75538_h = chunkcoordinates.field_71572_b;
                    field_75539_i = chunkcoordinates.field_71573_c + (int)((double)(MathHelper.func_76126_a(field_75537_a.field_73012_v.nextFloat() * 3.141593F * 2.0F) * f) * 0.90000000000000002D);
                    flag = false;
                    Iterator iterator1 = field_75537_a.field_72982_D.func_75540_b().iterator();
                    do
                    {
                        if(!iterator1.hasNext())
                        {
                            break;
                        }
                        Village village = (Village)iterator1.next();
                        if(village == field_75531_f || !village.func_75570_a(field_75532_g, field_75538_h, field_75539_i))
                        {
                            continue;
                        }
                        flag = true;
                        break;
                    } while(true);
                    if(!flag)
                    {
                        break;
                    }
                    i++;
                } while(true);
                if(flag)
                {
                    return false;
                }
                Vec3 vec3 = func_75527_a(field_75532_g, field_75538_h, field_75539_i);
                if(vec3 != null)
                {
                    field_75534_e = 0;
                    field_75533_d = 20;
                    return true;
                }
            }
        }

        return false;
    }

    private boolean func_75530_c()
    {
        Vec3 vec3 = func_75527_a(field_75532_g, field_75538_h, field_75539_i);
        if(vec3 == null)
        {
            return false;
        }
        EntityZombie entityzombie;
        try
        {
            entityzombie = new EntityZombie(field_75537_a);
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            return false;
        }
        entityzombie.func_70012_b(vec3.field_72450_a, vec3.field_72448_b, vec3.field_72449_c, field_75537_a.field_73012_v.nextFloat() * 360F, 0.0F);
        field_75537_a.func_72838_d(entityzombie);
        ChunkCoordinates chunkcoordinates = field_75531_f.func_75577_a();
        entityzombie.func_70598_b(chunkcoordinates.field_71574_a, chunkcoordinates.field_71572_b, chunkcoordinates.field_71573_c, field_75531_f.func_75568_b());
        return true;
    }

    private Vec3 func_75527_a(int p_75527_1_, int p_75527_2_, int p_75527_3_)
    {
        for(int i = 0; i < 10; i++)
        {
            int j = (p_75527_1_ + field_75537_a.field_73012_v.nextInt(16)) - 8;
            int k = (p_75527_2_ + field_75537_a.field_73012_v.nextInt(6)) - 3;
            int l = (p_75527_3_ + field_75537_a.field_73012_v.nextInt(16)) - 8;
            if(field_75531_f.func_75570_a(j, k, l) && SpawnerAnimals.func_77190_a(EnumCreatureType.monster, field_75537_a, j, k, l))
            {
                return Vec3.func_72437_a().func_72345_a(j, k, l);
            }
        }

        return null;
    }
}
