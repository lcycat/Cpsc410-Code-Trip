// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            World, Block, BlockRail, ChunkPosition

class RailLogic
{

    private World field_73657_b;
    private int field_73658_c;
    private int field_73655_d;
    private int field_73656_e;
    private final boolean field_73653_f;
    private List field_73654_g;
    final BlockRail field_73659_a; /* synthetic field */

    public RailLogic(BlockRail p_i3983_1_, World p_i3983_2_, int p_i3983_3_, int p_i3983_4_, int p_i3983_5_)
    {
        field_73659_a = p_i3983_1_;
        super();
        field_73654_g = new ArrayList();
        field_73657_b = p_i3983_2_;
        field_73658_c = p_i3983_3_;
        field_73655_d = p_i3983_4_;
        field_73656_e = p_i3983_5_;
        int i = p_i3983_2_.func_72798_a(p_i3983_3_, p_i3983_4_, p_i3983_5_);
        int j = p_i3983_2_.func_72805_g(p_i3983_3_, p_i3983_4_, p_i3983_5_);
        if(BlockRail.func_72179_a((BlockRail)Block.field_71973_m[i]))
        {
            field_73653_f = true;
            j &= -9;
        } else
        {
            field_73653_f = false;
        }
        func_73645_a(j);
    }

    private void func_73645_a(int p_73645_1_)
    {
        field_73654_g.clear();
        if(p_73645_1_ == 0)
        {
            field_73654_g.add(new ChunkPosition(field_73658_c, field_73655_d, field_73656_e - 1));
            field_73654_g.add(new ChunkPosition(field_73658_c, field_73655_d, field_73656_e + 1));
        } else
        if(p_73645_1_ == 1)
        {
            field_73654_g.add(new ChunkPosition(field_73658_c - 1, field_73655_d, field_73656_e));
            field_73654_g.add(new ChunkPosition(field_73658_c + 1, field_73655_d, field_73656_e));
        } else
        if(p_73645_1_ == 2)
        {
            field_73654_g.add(new ChunkPosition(field_73658_c - 1, field_73655_d, field_73656_e));
            field_73654_g.add(new ChunkPosition(field_73658_c + 1, field_73655_d + 1, field_73656_e));
        } else
        if(p_73645_1_ == 3)
        {
            field_73654_g.add(new ChunkPosition(field_73658_c - 1, field_73655_d + 1, field_73656_e));
            field_73654_g.add(new ChunkPosition(field_73658_c + 1, field_73655_d, field_73656_e));
        } else
        if(p_73645_1_ == 4)
        {
            field_73654_g.add(new ChunkPosition(field_73658_c, field_73655_d + 1, field_73656_e - 1));
            field_73654_g.add(new ChunkPosition(field_73658_c, field_73655_d, field_73656_e + 1));
        } else
        if(p_73645_1_ == 5)
        {
            field_73654_g.add(new ChunkPosition(field_73658_c, field_73655_d, field_73656_e - 1));
            field_73654_g.add(new ChunkPosition(field_73658_c, field_73655_d + 1, field_73656_e + 1));
        } else
        if(p_73645_1_ == 6)
        {
            field_73654_g.add(new ChunkPosition(field_73658_c + 1, field_73655_d, field_73656_e));
            field_73654_g.add(new ChunkPosition(field_73658_c, field_73655_d, field_73656_e + 1));
        } else
        if(p_73645_1_ == 7)
        {
            field_73654_g.add(new ChunkPosition(field_73658_c - 1, field_73655_d, field_73656_e));
            field_73654_g.add(new ChunkPosition(field_73658_c, field_73655_d, field_73656_e + 1));
        } else
        if(p_73645_1_ == 8)
        {
            field_73654_g.add(new ChunkPosition(field_73658_c - 1, field_73655_d, field_73656_e));
            field_73654_g.add(new ChunkPosition(field_73658_c, field_73655_d, field_73656_e - 1));
        } else
        if(p_73645_1_ == 9)
        {
            field_73654_g.add(new ChunkPosition(field_73658_c + 1, field_73655_d, field_73656_e));
            field_73654_g.add(new ChunkPosition(field_73658_c, field_73655_d, field_73656_e - 1));
        }
    }

    private void func_73644_a()
    {
        for(int i = 0; i < field_73654_g.size(); i++)
        {
            RailLogic raillogic = func_73648_a((ChunkPosition)field_73654_g.get(i));
            if(raillogic == null || !raillogic.func_73647_b(this))
            {
                field_73654_g.remove(i--);
            } else
            {
                field_73654_g.set(i, new ChunkPosition(raillogic.field_73658_c, raillogic.field_73655_d, raillogic.field_73656_e));
            }
        }

    }

    private boolean func_73642_a(int p_73642_1_, int p_73642_2_, int p_73642_3_)
    {
        if(BlockRail.func_72180_d_(field_73657_b, p_73642_1_, p_73642_2_, p_73642_3_))
        {
            return true;
        }
        if(BlockRail.func_72180_d_(field_73657_b, p_73642_1_, p_73642_2_ + 1, p_73642_3_))
        {
            return true;
        }
        return BlockRail.func_72180_d_(field_73657_b, p_73642_1_, p_73642_2_ - 1, p_73642_3_);
    }

    private RailLogic func_73648_a(ChunkPosition p_73648_1_)
    {
        if(BlockRail.func_72180_d_(field_73657_b, p_73648_1_.field_76930_a, p_73648_1_.field_76928_b, p_73648_1_.field_76929_c))
        {
            return new RailLogic(field_73659_a, field_73657_b, p_73648_1_.field_76930_a, p_73648_1_.field_76928_b, p_73648_1_.field_76929_c);
        }
        if(BlockRail.func_72180_d_(field_73657_b, p_73648_1_.field_76930_a, p_73648_1_.field_76928_b + 1, p_73648_1_.field_76929_c))
        {
            return new RailLogic(field_73659_a, field_73657_b, p_73648_1_.field_76930_a, p_73648_1_.field_76928_b + 1, p_73648_1_.field_76929_c);
        }
        if(BlockRail.func_72180_d_(field_73657_b, p_73648_1_.field_76930_a, p_73648_1_.field_76928_b - 1, p_73648_1_.field_76929_c))
        {
            return new RailLogic(field_73659_a, field_73657_b, p_73648_1_.field_76930_a, p_73648_1_.field_76928_b - 1, p_73648_1_.field_76929_c);
        } else
        {
            return null;
        }
    }

    private boolean func_73647_b(RailLogic p_73647_1_)
    {
        for(Iterator iterator = field_73654_g.iterator(); iterator.hasNext();)
        {
            ChunkPosition chunkposition = (ChunkPosition)iterator.next();
            if(chunkposition.field_76930_a == p_73647_1_.field_73658_c && chunkposition.field_76929_c == p_73647_1_.field_73656_e)
            {
                return true;
            }
        }

        return false;
    }

    private boolean func_73649_b(int p_73649_1_, int p_73649_2_, int p_73649_3_)
    {
        for(Iterator iterator = field_73654_g.iterator(); iterator.hasNext();)
        {
            ChunkPosition chunkposition = (ChunkPosition)iterator.next();
            if(chunkposition.field_76930_a == p_73649_1_ && chunkposition.field_76929_c == p_73649_3_)
            {
                return true;
            }
        }

        return false;
    }

    private int func_73651_b()
    {
        int i = 0;
        if(func_73642_a(field_73658_c, field_73655_d, field_73656_e - 1))
        {
            i++;
        }
        if(func_73642_a(field_73658_c, field_73655_d, field_73656_e + 1))
        {
            i++;
        }
        if(func_73642_a(field_73658_c - 1, field_73655_d, field_73656_e))
        {
            i++;
        }
        if(func_73642_a(field_73658_c + 1, field_73655_d, field_73656_e))
        {
            i++;
        }
        return i;
    }

    private boolean func_73646_c(RailLogic p_73646_1_)
    {
        if(func_73647_b(p_73646_1_))
        {
            return true;
        }
        if(field_73654_g.size() == 2)
        {
            return false;
        }
        if(field_73654_g.isEmpty())
        {
            return true;
        } else
        {
            ChunkPosition chunkposition = (ChunkPosition)field_73654_g.get(0);
            return true;
        }
    }

    private void func_73641_d(RailLogic p_73641_1_)
    {
        field_73654_g.add(new ChunkPosition(p_73641_1_.field_73658_c, p_73641_1_.field_73655_d, p_73641_1_.field_73656_e));
        boolean flag = func_73649_b(field_73658_c, field_73655_d, field_73656_e - 1);
        boolean flag1 = func_73649_b(field_73658_c, field_73655_d, field_73656_e + 1);
        boolean flag2 = func_73649_b(field_73658_c - 1, field_73655_d, field_73656_e);
        boolean flag3 = func_73649_b(field_73658_c + 1, field_73655_d, field_73656_e);
        byte byte0 = -1;
        if(flag || flag1)
        {
            byte0 = 0;
        }
        if(flag2 || flag3)
        {
            byte0 = 1;
        }
        if(!field_73653_f)
        {
            if(flag1 && flag3 && !flag && !flag2)
            {
                byte0 = 6;
            }
            if(flag1 && flag2 && !flag && !flag3)
            {
                byte0 = 7;
            }
            if(flag && flag2 && !flag1 && !flag3)
            {
                byte0 = 8;
            }
            if(flag && flag3 && !flag1 && !flag2)
            {
                byte0 = 9;
            }
        }
        if(byte0 == 0)
        {
            if(BlockRail.func_72180_d_(field_73657_b, field_73658_c, field_73655_d + 1, field_73656_e - 1))
            {
                byte0 = 4;
            }
            if(BlockRail.func_72180_d_(field_73657_b, field_73658_c, field_73655_d + 1, field_73656_e + 1))
            {
                byte0 = 5;
            }
        }
        if(byte0 == 1)
        {
            if(BlockRail.func_72180_d_(field_73657_b, field_73658_c + 1, field_73655_d + 1, field_73656_e))
            {
                byte0 = 2;
            }
            if(BlockRail.func_72180_d_(field_73657_b, field_73658_c - 1, field_73655_d + 1, field_73656_e))
            {
                byte0 = 3;
            }
        }
        if(byte0 < 0)
        {
            byte0 = 0;
        }
        int i = byte0;
        if(field_73653_f)
        {
            i = field_73657_b.func_72805_g(field_73658_c, field_73655_d, field_73656_e) & 8 | byte0;
        }
        field_73657_b.func_72921_c(field_73658_c, field_73655_d, field_73656_e, i);
    }

    private boolean func_73643_c(int p_73643_1_, int p_73643_2_, int p_73643_3_)
    {
        RailLogic raillogic = func_73648_a(new ChunkPosition(p_73643_1_, p_73643_2_, p_73643_3_));
        if(raillogic == null)
        {
            return false;
        } else
        {
            raillogic.func_73644_a();
            return raillogic.func_73646_c(this);
        }
    }

    public void func_73652_a(boolean p_73652_1_, boolean p_73652_2_)
    {
        boolean flag = func_73643_c(field_73658_c, field_73655_d, field_73656_e - 1);
        boolean flag1 = func_73643_c(field_73658_c, field_73655_d, field_73656_e + 1);
        boolean flag2 = func_73643_c(field_73658_c - 1, field_73655_d, field_73656_e);
        boolean flag3 = func_73643_c(field_73658_c + 1, field_73655_d, field_73656_e);
        byte byte0 = -1;
        if((flag || flag1) && !flag2 && !flag3)
        {
            byte0 = 0;
        }
        if((flag2 || flag3) && !flag && !flag1)
        {
            byte0 = 1;
        }
        if(!field_73653_f)
        {
            if(flag1 && flag3 && !flag && !flag2)
            {
                byte0 = 6;
            }
            if(flag1 && flag2 && !flag && !flag3)
            {
                byte0 = 7;
            }
            if(flag && flag2 && !flag1 && !flag3)
            {
                byte0 = 8;
            }
            if(flag && flag3 && !flag1 && !flag2)
            {
                byte0 = 9;
            }
        }
        if(byte0 == -1)
        {
            if(flag || flag1)
            {
                byte0 = 0;
            }
            if(flag2 || flag3)
            {
                byte0 = 1;
            }
            if(!field_73653_f)
            {
                if(p_73652_1_)
                {
                    if(flag1 && flag3)
                    {
                        byte0 = 6;
                    }
                    if(flag2 && flag1)
                    {
                        byte0 = 7;
                    }
                    if(flag3 && flag)
                    {
                        byte0 = 9;
                    }
                    if(flag && flag2)
                    {
                        byte0 = 8;
                    }
                } else
                {
                    if(flag && flag2)
                    {
                        byte0 = 8;
                    }
                    if(flag3 && flag)
                    {
                        byte0 = 9;
                    }
                    if(flag2 && flag1)
                    {
                        byte0 = 7;
                    }
                    if(flag1 && flag3)
                    {
                        byte0 = 6;
                    }
                }
            }
        }
        if(byte0 == 0)
        {
            if(BlockRail.func_72180_d_(field_73657_b, field_73658_c, field_73655_d + 1, field_73656_e - 1))
            {
                byte0 = 4;
            }
            if(BlockRail.func_72180_d_(field_73657_b, field_73658_c, field_73655_d + 1, field_73656_e + 1))
            {
                byte0 = 5;
            }
        }
        if(byte0 == 1)
        {
            if(BlockRail.func_72180_d_(field_73657_b, field_73658_c + 1, field_73655_d + 1, field_73656_e))
            {
                byte0 = 2;
            }
            if(BlockRail.func_72180_d_(field_73657_b, field_73658_c - 1, field_73655_d + 1, field_73656_e))
            {
                byte0 = 3;
            }
        }
        if(byte0 < 0)
        {
            byte0 = 0;
        }
        func_73645_a(byte0);
        int i = byte0;
        if(field_73653_f)
        {
            i = field_73657_b.func_72805_g(field_73658_c, field_73655_d, field_73656_e) & 8 | byte0;
        }
        if(p_73652_2_ || field_73657_b.func_72805_g(field_73658_c, field_73655_d, field_73656_e) != i)
        {
            field_73657_b.func_72921_c(field_73658_c, field_73655_d, field_73656_e, i);
            Iterator iterator = field_73654_g.iterator();
            do
            {
                if(!iterator.hasNext())
                {
                    break;
                }
                ChunkPosition chunkposition = (ChunkPosition)iterator.next();
                RailLogic raillogic = func_73648_a(chunkposition);
                if(raillogic != null)
                {
                    raillogic.func_73644_a();
                    if(raillogic.func_73646_c(this))
                    {
                        raillogic.func_73641_d(this);
                    }
                }
            } while(true);
        }
    }

    static int func_73650_a(RailLogic p_73650_0_)
    {
        return p_73650_0_.func_73651_b();
    }
}
