// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            EntityAITaskEntry, EntityAIBase, Profiler

public class EntityAITasks
{

    private List field_75782_a;
    private List field_75780_b;
    private final Profiler field_75781_c;
    private int field_75778_d;
    private int field_75779_e;

    public EntityAITasks(Profiler p_i3469_1_)
    {
        field_75782_a = new ArrayList();
        field_75780_b = new ArrayList();
        field_75778_d = 0;
        field_75779_e = 3;
        field_75781_c = p_i3469_1_;
    }

    public void func_75776_a(int p_75776_1_, EntityAIBase p_75776_2_)
    {
        field_75782_a.add(new EntityAITaskEntry(this, p_75776_1_, p_75776_2_));
    }

    public void func_75774_a()
    {
        ArrayList arraylist = new ArrayList();
        if(field_75778_d++ % field_75779_e == 0)
        {
            Iterator iterator = field_75782_a.iterator();
            do
            {
                if(!iterator.hasNext())
                {
                    break;
                }
                EntityAITaskEntry entityaitaskentry = (EntityAITaskEntry)iterator.next();
                boolean flag = field_75780_b.contains(entityaitaskentry);
                if(flag)
                {
                    if(func_75775_b(entityaitaskentry) && func_75773_a(entityaitaskentry))
                    {
                        continue;
                    }
                    entityaitaskentry.field_75733_a.func_75251_c();
                    field_75780_b.remove(entityaitaskentry);
                }
                if(func_75775_b(entityaitaskentry) && entityaitaskentry.field_75733_a.func_75250_a())
                {
                    arraylist.add(entityaitaskentry);
                    field_75780_b.add(entityaitaskentry);
                }
            } while(true);
        } else
        {
            Iterator iterator1 = field_75780_b.iterator();
            do
            {
                if(!iterator1.hasNext())
                {
                    break;
                }
                EntityAITaskEntry entityaitaskentry1 = (EntityAITaskEntry)iterator1.next();
                if(!entityaitaskentry1.field_75733_a.func_75253_b())
                {
                    entityaitaskentry1.field_75733_a.func_75251_c();
                    iterator1.remove();
                }
            } while(true);
        }
        field_75781_c.func_76320_a("goalStart");
        for(Iterator iterator2 = arraylist.iterator(); iterator2.hasNext(); field_75781_c.func_76319_b())
        {
            EntityAITaskEntry entityaitaskentry2 = (EntityAITaskEntry)iterator2.next();
            field_75781_c.func_76320_a(entityaitaskentry2.field_75733_a.getClass().getSimpleName());
            entityaitaskentry2.field_75733_a.func_75249_e();
        }

        field_75781_c.func_76319_b();
        field_75781_c.func_76320_a("goalTick");
        for(Iterator iterator3 = field_75780_b.iterator(); iterator3.hasNext(); field_75781_c.func_76319_b())
        {
            EntityAITaskEntry entityaitaskentry3 = (EntityAITaskEntry)iterator3.next();
            field_75781_c.func_76320_a(entityaitaskentry3.field_75733_a.getClass().getSimpleName());
            entityaitaskentry3.field_75733_a.func_75246_d();
        }

        field_75781_c.func_76319_b();
    }

    private boolean func_75773_a(EntityAITaskEntry p_75773_1_)
    {
        field_75781_c.func_76320_a("canContinue");
        boolean flag = p_75773_1_.field_75733_a.func_75253_b();
        field_75781_c.func_76319_b();
        return flag;
    }

    private boolean func_75775_b(EntityAITaskEntry p_75775_1_)
    {
label0:
        {
            field_75781_c.func_76320_a("canUse");
            Iterator iterator = field_75782_a.iterator();
            EntityAITaskEntry entityaitaskentry;
label1:
            do
            {
                do
                {
                    do
                    {
                        if(!iterator.hasNext())
                        {
                            break label0;
                        }
                        entityaitaskentry = (EntityAITaskEntry)iterator.next();
                    } while(entityaitaskentry == p_75775_1_);
                    if(p_75775_1_.field_75731_b < entityaitaskentry.field_75731_b)
                    {
                        continue label1;
                    }
                } while(!field_75780_b.contains(entityaitaskentry) || func_75777_a(p_75775_1_, entityaitaskentry));
                field_75781_c.func_76319_b();
                return false;
            } while(!field_75780_b.contains(entityaitaskentry) || entityaitaskentry.field_75733_a.func_75252_g());
            field_75781_c.func_76319_b();
            return false;
        }
        field_75781_c.func_76319_b();
        return true;
    }

    private boolean func_75777_a(EntityAITaskEntry p_75777_1_, EntityAITaskEntry p_75777_2_)
    {
        return (p_75777_1_.field_75733_a.func_75247_h() & p_75777_2_.field_75733_a.func_75247_h()) == 0;
    }
}
