// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            InventoryEffectRenderer, ContainerCreative, EntityPlayer, AchievementList, 
//            PlayerControllerMP, GuiInventory, EntityClientPlayerMP, Container, 
//            CreativeTabs, InventoryPlayer, SlotCreativeInventory, Slot, 
//            ItemStack, GuiTextField, FontRenderer, GameSettings, 
//            KeyBinding, Item, StringTranslate, RenderHelper, 
//            RenderEngine, RenderItem, GuiButton, GuiAchievements, 
//            GuiStats, InventoryBasic

public class GuiContainerCreative extends InventoryEffectRenderer
{

    private static InventoryBasic field_74242_o = new InventoryBasic("tmp", 45);
    private static int field_74241_p;
    private float field_74240_q;
    private boolean field_74239_r;
    private boolean field_74238_s;
    private GuiTextField field_74237_t;
    private List field_74236_u;
    private Slot field_74235_v;
    private boolean field_74234_w;

    public GuiContainerCreative(EntityPlayer p_i3083_1_)
    {
        super(new ContainerCreative(p_i3083_1_));
        field_74240_q = 0.0F;
        field_74239_r = false;
        field_74235_v = null;
        field_74234_w = false;
        p_i3083_1_.field_71070_bA = field_74193_d;
        field_73885_j = true;
        p_i3083_1_.func_71064_a(AchievementList.field_76004_f, 1);
        field_74195_c = 136;
        field_74194_b = 195;
    }

    public void func_73876_c()
    {
        if(!field_73882_e.field_71442_b.func_78758_h())
        {
            field_73882_e.func_71373_a(new GuiInventory(field_73882_e.field_71439_g));
        }
    }

    protected void func_74191_a(Slot p_74191_1_, int p_74191_2_, int p_74191_3_, boolean p_74191_4_)
    {
        field_74234_w = true;
        if(p_74191_1_ != null)
        {
            if(p_74191_1_ == field_74235_v && p_74191_4_)
            {
                for(int i = 0; i < field_73882_e.field_71439_g.field_71069_bz.func_75138_a().size(); i++)
                {
                    field_73882_e.field_71442_b.func_78761_a(null, i);
                }

            } else
            if(field_74241_p == CreativeTabs.field_78036_m.func_78021_a())
            {
                if(p_74191_1_ == field_74235_v)
                {
                    field_73882_e.field_71439_g.field_71071_by.func_70437_b(null);
                } else
                {
                    int j = SlotCreativeInventory.func_75240_a((SlotCreativeInventory)p_74191_1_).field_75222_d;
                    if(p_74191_4_)
                    {
                        field_73882_e.field_71442_b.func_78761_a(null, j);
                    } else
                    {
                        field_73882_e.field_71439_g.field_71069_bz.func_75144_a(j, p_74191_3_, p_74191_4_, field_73882_e.field_71439_g);
                        ItemStack itemstack1 = field_73882_e.field_71439_g.field_71069_bz.func_75139_a(j).func_75211_c();
                        field_73882_e.field_71442_b.func_78761_a(itemstack1, j);
                    }
                }
            } else
            if(p_74191_1_.field_75224_c == field_74242_o)
            {
                InventoryPlayer inventoryplayer = field_73882_e.field_71439_g.field_71071_by;
                ItemStack itemstack2 = inventoryplayer.func_70445_o();
                ItemStack itemstack5 = p_74191_1_.func_75211_c();
                if(itemstack2 != null && itemstack5 != null && itemstack2.func_77969_a(itemstack5))
                {
                    if(p_74191_3_ == 0)
                    {
                        if(p_74191_4_)
                        {
                            itemstack2.field_77994_a = itemstack2.func_77976_d();
                        } else
                        if(itemstack2.field_77994_a < itemstack2.func_77976_d())
                        {
                            itemstack2.field_77994_a++;
                        }
                    } else
                    if(itemstack2.field_77994_a <= 1)
                    {
                        inventoryplayer.func_70437_b(null);
                    } else
                    {
                        itemstack2.field_77994_a--;
                    }
                } else
                if(itemstack5 == null || itemstack2 != null)
                {
                    inventoryplayer.func_70437_b(null);
                } else
                {
                    boolean flag = false;
                    if(!flag)
                    {
                        inventoryplayer.func_70437_b(ItemStack.func_77944_b(itemstack5));
                        ItemStack itemstack3 = inventoryplayer.func_70445_o();
                        if(p_74191_4_)
                        {
                            itemstack3.field_77994_a = itemstack3.func_77976_d();
                        }
                    }
                }
            } else
            {
                field_74193_d.func_75144_a(p_74191_1_.field_75222_d, p_74191_3_, p_74191_4_, field_73882_e.field_71439_g);
                ItemStack itemstack = field_74193_d.func_75139_a(p_74191_1_.field_75222_d).func_75211_c();
                field_73882_e.field_71442_b.func_78761_a(itemstack, (p_74191_1_.field_75222_d - field_74193_d.field_75151_b.size()) + 9 + 36);
            }
        } else
        {
            InventoryPlayer inventoryplayer1 = field_73882_e.field_71439_g.field_71071_by;
            if(inventoryplayer1.func_70445_o() != null)
            {
                if(p_74191_3_ == 0)
                {
                    field_73882_e.field_71439_g.func_71021_b(inventoryplayer1.func_70445_o());
                    field_73882_e.field_71442_b.func_78752_a(inventoryplayer1.func_70445_o());
                    inventoryplayer1.func_70437_b(null);
                }
                if(p_74191_3_ == 1)
                {
                    ItemStack itemstack4 = inventoryplayer1.func_70445_o().func_77979_a(1);
                    field_73882_e.field_71439_g.func_71021_b(itemstack4);
                    field_73882_e.field_71442_b.func_78752_a(itemstack4);
                    if(inventoryplayer1.func_70445_o().field_77994_a == 0)
                    {
                        inventoryplayer1.func_70437_b(null);
                    }
                }
            }
        }
    }

    public void func_73866_w_()
    {
        if(field_73882_e.field_71442_b.func_78758_h())
        {
            super.func_73866_w_();
            field_73887_h.clear();
            Keyboard.enableRepeatEvents(true);
            field_74237_t = new GuiTextField(field_73886_k, field_74198_m + 82, field_74197_n + 6, 89, field_73886_k.field_78288_b);
            field_74237_t.func_73804_f(15);
            field_74237_t.func_73786_a(false);
            field_74237_t.func_73790_e(false);
            field_74237_t.func_73794_g(0xffffff);
            int i = field_74241_p;
            field_74241_p = -1;
            func_74227_b(CreativeTabs.field_78032_a[i]);
        } else
        {
            field_73882_e.func_71373_a(new GuiInventory(field_73882_e.field_71439_g));
        }
    }

    public void func_73874_b()
    {
        super.func_73874_b();
        Keyboard.enableRepeatEvents(false);
    }

    protected void func_73869_a(char p_73869_1_, int p_73869_2_)
    {
        if(field_74241_p != CreativeTabs.field_78027_g.func_78021_a())
        {
            if(Keyboard.isKeyDown(field_73882_e.field_71474_y.field_74310_D.field_74512_d))
            {
                func_74227_b(CreativeTabs.field_78027_g);
            } else
            {
                super.func_73869_a(p_73869_1_, p_73869_2_);
            }
            return;
        }
        if(field_74234_w)
        {
            field_74234_w = false;
            field_74237_t.func_73782_a("");
        }
        if(field_74237_t.func_73802_a(p_73869_1_, p_73869_2_))
        {
            func_74228_j();
        } else
        {
            super.func_73869_a(p_73869_1_, p_73869_2_);
        }
    }

    private void func_74228_j()
    {
        ContainerCreative containercreative = (ContainerCreative)field_74193_d;
        containercreative.field_75185_e.clear();
        Item aitem[] = Item.field_77698_e;
        int i = aitem.length;
        for(int j = 0; j < i; j++)
        {
            Item item = aitem[j];
            if(item != null && item.func_77640_w() != null)
            {
                item.func_77633_a(item.field_77779_bT, null, containercreative.field_75185_e);
            }
        }

        Iterator iterator = containercreative.field_75185_e.iterator();
        String s = field_74237_t.func_73781_b().toLowerCase();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            ItemStack itemstack = (ItemStack)iterator.next();
            boolean flag = false;
            Iterator iterator1 = itemstack.func_77968_r().iterator();
            do
            {
                if(!iterator1.hasNext())
                {
                    break;
                }
                String s1 = (String)iterator1.next();
                if(!s1.toLowerCase().contains(s))
                {
                    continue;
                }
                flag = true;
                break;
            } while(true);
            if(!flag)
            {
                iterator.remove();
            }
        } while(true);
        field_74240_q = 0.0F;
        containercreative.func_75183_a(0.0F);
    }

    protected void func_74189_g()
    {
        CreativeTabs creativetabs = CreativeTabs.field_78032_a[field_74241_p];
        if(creativetabs.func_78019_g())
        {
            field_73886_k.func_78276_b(creativetabs.func_78024_c(), 8, 6, 0x404040);
        }
    }

    protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_)
    {
        if(p_73864_3_ == 0)
        {
            int i = p_73864_1_ - field_74198_m;
            int j = p_73864_2_ - field_74197_n;
            CreativeTabs acreativetabs[] = CreativeTabs.field_78032_a;
            int k = acreativetabs.length;
            for(int l = 0; l < k; l++)
            {
                CreativeTabs creativetabs = acreativetabs[l];
                if(func_74232_a(creativetabs, i, j))
                {
                    func_74227_b(creativetabs);
                    return;
                }
            }

        }
        super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
    }

    private boolean func_74226_k()
    {
        return field_74241_p != CreativeTabs.field_78036_m.func_78021_a() && CreativeTabs.field_78032_a[field_74241_p].func_78017_i() && ((ContainerCreative)field_74193_d).func_75184_d();
    }

    private void func_74227_b(CreativeTabs p_74227_1_)
    {
        int i = field_74241_p;
        field_74241_p = p_74227_1_.func_78021_a();
        ContainerCreative containercreative = (ContainerCreative)field_74193_d;
        containercreative.field_75185_e.clear();
        p_74227_1_.func_78018_a(containercreative.field_75185_e);
        if(p_74227_1_ == CreativeTabs.field_78036_m)
        {
            Container container = field_73882_e.field_71439_g.field_71069_bz;
            if(field_74236_u == null)
            {
                field_74236_u = containercreative.field_75151_b;
            }
            containercreative.field_75151_b = new ArrayList();
            for(int j = 0; j < container.field_75151_b.size(); j++)
            {
                SlotCreativeInventory slotcreativeinventory = new SlotCreativeInventory(this, (Slot)container.field_75151_b.get(j), j);
                containercreative.field_75151_b.add(slotcreativeinventory);
                if(j >= 5 && j < 9)
                {
                    int k = j - 5;
                    int i1 = k / 2;
                    int k1 = k % 2;
                    slotcreativeinventory.field_75223_e = 9 + i1 * 54;
                    slotcreativeinventory.field_75221_f = 6 + k1 * 27;
                    continue;
                }
                if(j >= 0 && j < 5)
                {
                    slotcreativeinventory.field_75221_f = -2000;
                    slotcreativeinventory.field_75223_e = -2000;
                    continue;
                }
                if(j >= container.field_75151_b.size())
                {
                    continue;
                }
                int l = j - 9;
                int j1 = l % 9;
                int l1 = l / 9;
                slotcreativeinventory.field_75223_e = 9 + j1 * 18;
                if(j >= 36)
                {
                    slotcreativeinventory.field_75221_f = 112;
                } else
                {
                    slotcreativeinventory.field_75221_f = 54 + l1 * 18;
                }
            }

            field_74235_v = new Slot(field_74242_o, 0, 173, 112);
            containercreative.field_75151_b.add(field_74235_v);
        } else
        if(i == CreativeTabs.field_78036_m.func_78021_a())
        {
            containercreative.field_75151_b = field_74236_u;
            field_74236_u = null;
        }
        if(field_74237_t != null)
        {
            if(p_74227_1_ == CreativeTabs.field_78027_g)
            {
                field_74237_t.func_73790_e(true);
                field_74237_t.func_73805_d(false);
                field_74237_t.func_73796_b(true);
                field_74237_t.func_73782_a("");
                func_74228_j();
            } else
            {
                field_74237_t.func_73790_e(false);
                field_74237_t.func_73805_d(true);
                field_74237_t.func_73796_b(false);
            }
        }
        field_74240_q = 0.0F;
        containercreative.func_75183_a(0.0F);
    }

    public void func_73867_d()
    {
        super.func_73867_d();
        int i = Mouse.getEventDWheel();
        if(i != 0 && func_74226_k())
        {
            int j = (((ContainerCreative)field_74193_d).field_75185_e.size() / 9 - 5) + 1;
            if(i > 0)
            {
                i = 1;
            }
            if(i < 0)
            {
                i = -1;
            }
            field_74240_q -= (double)i / (double)j;
            if(field_74240_q < 0.0F)
            {
                field_74240_q = 0.0F;
            }
            if(field_74240_q > 1.0F)
            {
                field_74240_q = 1.0F;
            }
            ((ContainerCreative)field_74193_d).func_75183_a(field_74240_q);
        }
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        boolean flag = Mouse.isButtonDown(0);
        int i = field_74198_m;
        int j = field_74197_n;
        int k = i + 175;
        int l = j + 18;
        int i1 = k + 14;
        int j1 = l + 112;
        if(!field_74238_s && flag && p_73863_1_ >= k && p_73863_2_ >= l && p_73863_1_ < i1 && p_73863_2_ < j1)
        {
            field_74239_r = func_74226_k();
        }
        if(!flag)
        {
            field_74239_r = false;
        }
        field_74238_s = flag;
        if(field_74239_r)
        {
            field_74240_q = ((float)(p_73863_2_ - l) - 7.5F) / ((float)(j1 - l) - 15F);
            if(field_74240_q < 0.0F)
            {
                field_74240_q = 0.0F;
            }
            if(field_74240_q > 1.0F)
            {
                field_74240_q = 1.0F;
            }
            ((ContainerCreative)field_74193_d).func_75183_a(field_74240_q);
        }
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
        CreativeTabs acreativetabs[] = CreativeTabs.field_78032_a;
        int k1 = acreativetabs.length;
        int l1 = 0;
        do
        {
            if(l1 >= k1)
            {
                break;
            }
            CreativeTabs creativetabs = acreativetabs[l1];
            if(func_74231_b(creativetabs, p_73863_1_, p_73863_2_))
            {
                break;
            }
            l1++;
        } while(true);
        if(field_74235_v != null && field_74241_p == CreativeTabs.field_78036_m.func_78021_a() && func_74188_c(field_74235_v.field_75223_e, field_74235_v.field_75221_f, 16, 16, p_73863_1_, p_73863_2_))
        {
            func_74190_a(StringTranslate.func_74808_a().func_74805_b("inventory.binSlot"), p_73863_1_, p_73863_2_);
        }
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(2896);
    }

    protected void func_74185_a(float p_74185_1_, int p_74185_2_, int p_74185_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        RenderHelper.func_74520_c();
        int i = field_73882_e.field_71446_o.func_78341_b("/gui/allitems.png");
        CreativeTabs creativetabs = CreativeTabs.field_78032_a[field_74241_p];
        int j = field_73882_e.field_71446_o.func_78341_b((new StringBuilder()).append("/gui/creative_inv/").append(creativetabs.func_78015_f()).toString());
        CreativeTabs acreativetabs[] = CreativeTabs.field_78032_a;
        int l = acreativetabs.length;
        for(int i1 = 0; i1 < l; i1++)
        {
            CreativeTabs creativetabs1 = acreativetabs[i1];
            field_73882_e.field_71446_o.func_78342_b(i);
            if(creativetabs1.func_78021_a() != field_74241_p)
            {
                func_74233_a(creativetabs1);
            }
        }

        field_73882_e.field_71446_o.func_78342_b(j);
        func_73729_b(field_74198_m, field_74197_n, 0, 0, field_74194_b, field_74195_c);
        field_74237_t.func_73795_f();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        int k = field_74198_m + 175;
        l = field_74197_n + 18;
        int j1 = l + 112;
        field_73882_e.field_71446_o.func_78342_b(i);
        if(creativetabs.func_78017_i())
        {
            func_73729_b(k, l + (int)((float)(j1 - l - 17) * field_74240_q), 232 + (func_74226_k() ? 0 : 12), 0, 12, 15);
        }
        func_74233_a(creativetabs);
        if(creativetabs == CreativeTabs.field_78036_m)
        {
            GuiInventory.func_74223_a(field_73882_e, field_74198_m + 43, field_74197_n + 45, 20, (field_74198_m + 43) - p_74185_2_, (field_74197_n + 45) - 30 - p_74185_3_);
        }
    }

    protected boolean func_74232_a(CreativeTabs p_74232_1_, int p_74232_2_, int p_74232_3_)
    {
        int i = p_74232_1_.func_78020_k();
        int j = 28 * i;
        int k = 0;
        if(i == 5)
        {
            j = (field_74194_b - 28) + 2;
        } else
        if(i > 0)
        {
            j += i;
        }
        if(p_74232_1_.func_78023_l())
        {
            k -= 32;
        } else
        {
            k += field_74195_c;
        }
        return p_74232_2_ >= j && p_74232_2_ <= j + 28 && p_74232_3_ >= k && p_74232_3_ <= k + 32;
    }

    protected boolean func_74231_b(CreativeTabs p_74231_1_, int p_74231_2_, int p_74231_3_)
    {
        int i = p_74231_1_.func_78020_k();
        int j = 28 * i;
        int k = 0;
        if(i == 5)
        {
            j = (field_74194_b - 28) + 2;
        } else
        if(i > 0)
        {
            j += i;
        }
        if(p_74231_1_.func_78023_l())
        {
            k -= 32;
        } else
        {
            k += field_74195_c;
        }
        if(func_74188_c(j + 3, k + 3, 23, 27, p_74231_2_, p_74231_3_))
        {
            func_74190_a(p_74231_1_.func_78024_c(), p_74231_2_, p_74231_3_);
            return true;
        } else
        {
            return false;
        }
    }

    protected void func_74233_a(CreativeTabs p_74233_1_)
    {
        boolean flag = p_74233_1_.func_78021_a() == field_74241_p;
        boolean flag1 = p_74233_1_.func_78023_l();
        int i = p_74233_1_.func_78020_k();
        int j = i * 28;
        int k = 0;
        int l = field_74198_m + 28 * i;
        int i1 = field_74197_n;
        byte byte0 = 32;
        if(flag)
        {
            k += 32;
        }
        if(i == 5)
        {
            l = (field_74198_m + field_74194_b) - 28;
        } else
        if(i > 0)
        {
            l += i;
        }
        if(flag1)
        {
            i1 -= 28;
        } else
        {
            k += 64;
            i1 += field_74195_c - 4;
        }
        GL11.glDisable(2896);
        func_73729_b(l, i1, j, k, 28, byte0);
        field_73735_i = 100F;
        field_74196_a.field_77023_b = 100F;
        l += 6;
        i1 += 8 + (flag1 ? 1 : -1);
        GL11.glEnable(2896);
        GL11.glEnable(32826);
        ItemStack itemstack = new ItemStack(p_74233_1_.func_78016_d());
        field_74196_a.func_77015_a(field_73886_k, field_73882_e.field_71446_o, itemstack, l, i1);
        field_74196_a.func_77021_b(field_73886_k, field_73882_e.field_71446_o, itemstack, l, i1);
        GL11.glDisable(2896);
        field_74196_a.field_77023_b = 0.0F;
        field_73735_i = 0.0F;
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        if(p_73875_1_.field_73741_f == 0)
        {
            field_73882_e.func_71373_a(new GuiAchievements(field_73882_e.field_71413_E));
        }
        if(p_73875_1_.field_73741_f == 1)
        {
            field_73882_e.func_71373_a(new GuiStats(this, field_73882_e.field_71413_E));
        }
    }

    public int func_74230_h()
    {
        return field_74241_p;
    }

    static InventoryBasic func_74229_i()
    {
        return field_74242_o;
    }

    static 
    {
        field_74241_p = CreativeTabs.field_78030_b.func_78021_a();
    }
}
