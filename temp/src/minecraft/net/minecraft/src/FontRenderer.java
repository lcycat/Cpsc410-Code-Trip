// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.text.Bidi;
import java.util.Arrays;
import java.util.Random;
import javax.imageio.ImageIO;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderEngine, GameSettings, ChatAllowedCharacters, Tessellator

public class FontRenderer
{

    private int field_78286_d[];
    public int field_78290_a;
    public int field_78288_b;
    public Random field_78289_c;
    private byte field_78287_e[];
    private final int field_78284_f[];
    private int field_78285_g[];
    private int field_78297_h;
    private final RenderEngine field_78298_i;
    private float field_78295_j;
    private float field_78296_k;
    private boolean field_78293_l;
    private boolean field_78294_m;
    private float field_78291_n;
    private float field_78292_o;
    private float field_78306_p;
    private float field_78305_q;
    private int field_78304_r;
    private boolean field_78303_s;
    private boolean field_78302_t;
    private boolean field_78301_u;
    private boolean field_78300_v;
    private boolean field_78299_w;

    FontRenderer()
    {
        field_78286_d = new int[256];
        field_78290_a = 0;
        field_78288_b = 9;
        field_78289_c = new Random();
        field_78287_e = new byte[0x10000];
        field_78284_f = new int[256];
        field_78285_g = new int[32];
        field_78303_s = false;
        field_78302_t = false;
        field_78301_u = false;
        field_78300_v = false;
        field_78299_w = false;
        field_78298_i = null;
    }

    public FontRenderer(GameSettings p_i3067_1_, String p_i3067_2_, RenderEngine p_i3067_3_, boolean p_i3067_4_)
    {
        field_78286_d = new int[256];
        field_78290_a = 0;
        field_78288_b = 9;
        field_78289_c = new Random();
        field_78287_e = new byte[0x10000];
        field_78284_f = new int[256];
        field_78285_g = new int[32];
        field_78303_s = false;
        field_78302_t = false;
        field_78301_u = false;
        field_78300_v = false;
        field_78299_w = false;
        field_78298_i = p_i3067_3_;
        field_78293_l = p_i3067_4_;
        BufferedImage bufferedimage;
        try
        {
            bufferedimage = ImageIO.read((net.minecraft.src.RenderEngine.class).getResourceAsStream(p_i3067_2_));
            InputStream inputstream = (net.minecraft.src.RenderEngine.class).getResourceAsStream("/font/glyph_sizes.bin");
            inputstream.read(field_78287_e);
        }
        catch(IOException ioexception)
        {
            throw new RuntimeException(ioexception);
        }
        int i = bufferedimage.getWidth();
        int j = bufferedimage.getHeight();
        int ai[] = new int[i * j];
        bufferedimage.getRGB(0, 0, i, j, ai, 0, i);
        for(int k = 0; k < 256; k++)
        {
            int i1 = k % 16;
            int k1 = k / 16;
            int i2 = 7;
            do
            {
                if(i2 < 0)
                {
                    break;
                }
                int k2 = i1 * 8 + i2;
                boolean flag = true;
                for(int j3 = 0; j3 < 8 && flag; j3++)
                {
                    int l3 = (k1 * 8 + j3) * i;
                    int j4 = ai[k2 + l3] & 0xff;
                    if(j4 > 0)
                    {
                        flag = false;
                    }
                }

                if(!flag)
                {
                    break;
                }
                i2--;
            } while(true);
            if(k == 32)
            {
                i2 = 2;
            }
            field_78286_d[k] = i2 + 2;
        }

        field_78290_a = p_i3067_3_.func_78353_a(bufferedimage);
        for(int l = 0; l < 32; l++)
        {
            int j1 = (l >> 3 & 1) * 85;
            int l1 = (l >> 2 & 1) * 170 + j1;
            int j2 = (l >> 1 & 1) * 170 + j1;
            int l2 = (l >> 0 & 1) * 170 + j1;
            if(l == 6)
            {
                l1 += 85;
            }
            if(p_i3067_1_.field_74337_g)
            {
                int i3 = (l1 * 30 + j2 * 59 + l2 * 11) / 100;
                int k3 = (l1 * 30 + j2 * 70) / 100;
                int i4 = (l1 * 30 + l2 * 70) / 100;
                l1 = i3;
                j2 = k3;
                l2 = i4;
            }
            if(l >= 16)
            {
                l1 /= 4;
                j2 /= 4;
                l2 /= 4;
            }
            field_78285_g[l] = (l1 & 0xff) << 16 | (j2 & 0xff) << 8 | l2 & 0xff;
        }

    }

    private float func_78278_a(int p_78278_1_, char p_78278_2_, boolean p_78278_3_)
    {
        if(p_78278_2_ == ' ')
        {
            return 4F;
        }
        if(p_78278_1_ > 0 && !field_78293_l)
        {
            return func_78266_a(p_78278_1_ + 32, p_78278_3_);
        } else
        {
            return func_78277_a(p_78278_2_, p_78278_3_);
        }
    }

    private float func_78266_a(int p_78266_1_, boolean p_78266_2_)
    {
        float f = (p_78266_1_ % 16) * 8;
        float f1 = (p_78266_1_ / 16) * 8;
        float f2 = p_78266_2_ ? 1.0F : 0.0F;
        if(field_78297_h != field_78290_a)
        {
            GL11.glBindTexture(3553, field_78290_a);
            field_78297_h = field_78290_a;
        }
        float f3 = (float)field_78286_d[p_78266_1_] - 0.01F;
        GL11.glBegin(5);
        GL11.glTexCoord2f(f / 128F, f1 / 128F);
        GL11.glVertex3f(field_78295_j + f2, field_78296_k, 0.0F);
        GL11.glTexCoord2f(f / 128F, (f1 + 7.99F) / 128F);
        GL11.glVertex3f(field_78295_j - f2, field_78296_k + 7.99F, 0.0F);
        GL11.glTexCoord2f((f + f3) / 128F, f1 / 128F);
        GL11.glVertex3f(field_78295_j + f3 + f2, field_78296_k, 0.0F);
        GL11.glTexCoord2f((f + f3) / 128F, (f1 + 7.99F) / 128F);
        GL11.glVertex3f((field_78295_j + f3) - f2, field_78296_k + 7.99F, 0.0F);
        GL11.glEnd();
        return (float)field_78286_d[p_78266_1_];
    }

    private void func_78257_a(int p_78257_1_)
    {
        String s = String.format("/font/glyph_%02X.png", new Object[] {
            Integer.valueOf(p_78257_1_)
        });
        BufferedImage bufferedimage;
        try
        {
            bufferedimage = ImageIO.read((net.minecraft.src.RenderEngine.class).getResourceAsStream(s));
        }
        catch(IOException ioexception)
        {
            throw new RuntimeException(ioexception);
        }
        field_78284_f[p_78257_1_] = field_78298_i.func_78353_a(bufferedimage);
        field_78297_h = field_78284_f[p_78257_1_];
    }

    private float func_78277_a(char p_78277_1_, boolean p_78277_2_)
    {
        if(field_78287_e[p_78277_1_] == 0)
        {
            return 0.0F;
        }
        int i = p_78277_1_ / 256;
        if(field_78284_f[i] == 0)
        {
            func_78257_a(i);
        }
        if(field_78297_h != field_78284_f[i])
        {
            GL11.glBindTexture(3553, field_78284_f[i]);
            field_78297_h = field_78284_f[i];
        }
        int j = field_78287_e[p_78277_1_] >>> 4;
        int k = field_78287_e[p_78277_1_] & 0xf;
        float f = j;
        float f1 = k + 1;
        float f2 = (float)((p_78277_1_ % 16) * 16) + f;
        float f3 = ((p_78277_1_ & 0xff) / 16) * 16;
        float f4 = f1 - f - 0.02F;
        float f5 = p_78277_2_ ? 1.0F : 0.0F;
        GL11.glBegin(5);
        GL11.glTexCoord2f(f2 / 256F, f3 / 256F);
        GL11.glVertex3f(field_78295_j + f5, field_78296_k, 0.0F);
        GL11.glTexCoord2f(f2 / 256F, (f3 + 15.98F) / 256F);
        GL11.glVertex3f(field_78295_j - f5, field_78296_k + 7.99F, 0.0F);
        GL11.glTexCoord2f((f2 + f4) / 256F, f3 / 256F);
        GL11.glVertex3f(field_78295_j + f4 / 2.0F + f5, field_78296_k, 0.0F);
        GL11.glTexCoord2f((f2 + f4) / 256F, (f3 + 15.98F) / 256F);
        GL11.glVertex3f((field_78295_j + f4 / 2.0F) - f5, field_78296_k + 7.99F, 0.0F);
        GL11.glEnd();
        return (f1 - f) / 2.0F + 1.0F;
    }

    public int func_78261_a(String p_78261_1_, int p_78261_2_, int p_78261_3_, int p_78261_4_)
    {
        func_78265_b();
        if(field_78294_m)
        {
            p_78261_1_ = func_78283_c(p_78261_1_);
        }
        int i = func_78258_a(p_78261_1_, p_78261_2_ + 1, p_78261_3_ + 1, p_78261_4_, true);
        i = Math.max(i, func_78258_a(p_78261_1_, p_78261_2_, p_78261_3_, p_78261_4_, false));
        return i;
    }

    public void func_78276_b(String p_78276_1_, int p_78276_2_, int p_78276_3_, int p_78276_4_)
    {
        func_78265_b();
        if(field_78294_m)
        {
            p_78276_1_ = func_78283_c(p_78276_1_);
        }
        func_78258_a(p_78276_1_, p_78276_2_, p_78276_3_, p_78276_4_, false);
    }

    private String func_78283_c(String p_78283_1_)
    {
        if(p_78283_1_ == null || !Bidi.requiresBidi(p_78283_1_.toCharArray(), 0, p_78283_1_.length()))
        {
            return p_78283_1_;
        }
        Bidi bidi = new Bidi(p_78283_1_, -2);
        byte abyte0[] = new byte[bidi.getRunCount()];
        String as[] = new String[abyte0.length];
        for(int i = 0; i < abyte0.length; i++)
        {
            int j = bidi.getRunStart(i);
            int k = bidi.getRunLimit(i);
            int i1 = bidi.getRunLevel(i);
            String s = p_78283_1_.substring(j, k);
            abyte0[i] = (byte)i1;
            as[i] = s;
        }

        String as1[] = (String[])as.clone();
        Bidi.reorderVisually(abyte0, 0, as, 0, abyte0.length);
        StringBuilder stringbuilder = new StringBuilder();
label0:
        for(int l = 0; l < as.length; l++)
        {
            byte byte0 = abyte0[l];
            int j1 = 0;
            do
            {
                if(j1 >= as1.length)
                {
                    break;
                }
                if(as1[j1].equals(as[l]))
                {
                    byte0 = abyte0[j1];
                    break;
                }
                j1++;
            } while(true);
            if((byte0 & 1) == 0)
            {
                stringbuilder.append(as[l]);
                continue;
            }
            j1 = as[l].length() - 1;
            do
            {
                if(j1 < 0)
                {
                    continue label0;
                }
                char c = as[l].charAt(j1);
                if(c == '(')
                {
                    c = ')';
                } else
                if(c == ')')
                {
                    c = '(';
                }
                stringbuilder.append(c);
                j1--;
            } while(true);
        }

        return stringbuilder.toString();
    }

    private void func_78265_b()
    {
        field_78303_s = false;
        field_78302_t = false;
        field_78301_u = false;
        field_78300_v = false;
        field_78299_w = false;
    }

    private void func_78255_a(String p_78255_1_, boolean p_78255_2_)
    {
        for(int i = 0; i < p_78255_1_.length(); i++)
        {
            char c = p_78255_1_.charAt(i);
            if(c == '\247' && i + 1 < p_78255_1_.length())
            {
                int j = "0123456789abcdefklmnor".indexOf(p_78255_1_.toLowerCase().charAt(i + 1));
                if(j < 16)
                {
                    field_78303_s = false;
                    field_78302_t = false;
                    field_78299_w = false;
                    field_78300_v = false;
                    field_78301_u = false;
                    if(j < 0 || j > 15)
                    {
                        j = 15;
                    }
                    if(p_78255_2_)
                    {
                        j += 16;
                    }
                    int l = field_78285_g[j];
                    field_78304_r = l;
                    GL11.glColor4f((float)(l >> 16) / 255F, (float)(l >> 8 & 0xff) / 255F, (float)(l & 0xff) / 255F, field_78305_q);
                } else
                if(j == 16)
                {
                    field_78303_s = true;
                } else
                if(j == 17)
                {
                    field_78302_t = true;
                } else
                if(j == 18)
                {
                    field_78299_w = true;
                } else
                if(j == 19)
                {
                    field_78300_v = true;
                } else
                if(j == 20)
                {
                    field_78301_u = true;
                } else
                if(j == 21)
                {
                    field_78303_s = false;
                    field_78302_t = false;
                    field_78299_w = false;
                    field_78300_v = false;
                    field_78301_u = false;
                    GL11.glColor4f(field_78291_n, field_78292_o, field_78306_p, field_78305_q);
                }
                i++;
                continue;
            }
            int k = ChatAllowedCharacters.field_71568_a.indexOf(c);
            if(field_78303_s && k > 0)
            {
                int i1;
                do
                {
                    i1 = field_78289_c.nextInt(ChatAllowedCharacters.field_71568_a.length());
                } while(field_78286_d[k + 32] != field_78286_d[i1 + 32]);
                k = i1;
            }
            float f = func_78278_a(k, c, field_78301_u);
            if(field_78302_t)
            {
                field_78295_j++;
                func_78278_a(k, c, field_78301_u);
                field_78295_j--;
                f++;
            }
            if(field_78299_w)
            {
                Tessellator tessellator = Tessellator.field_78398_a;
                GL11.glDisable(3553);
                tessellator.func_78382_b();
                tessellator.func_78377_a(field_78295_j, field_78296_k + (float)(field_78288_b / 2), 0.0D);
                tessellator.func_78377_a(field_78295_j + f, field_78296_k + (float)(field_78288_b / 2), 0.0D);
                tessellator.func_78377_a(field_78295_j + f, (field_78296_k + (float)(field_78288_b / 2)) - 1.0F, 0.0D);
                tessellator.func_78377_a(field_78295_j, (field_78296_k + (float)(field_78288_b / 2)) - 1.0F, 0.0D);
                tessellator.func_78381_a();
                GL11.glEnable(3553);
            }
            if(field_78300_v)
            {
                Tessellator tessellator1 = Tessellator.field_78398_a;
                GL11.glDisable(3553);
                tessellator1.func_78382_b();
                int j1 = field_78300_v ? -1 : 0;
                tessellator1.func_78377_a(field_78295_j + (float)j1, field_78296_k + (float)field_78288_b, 0.0D);
                tessellator1.func_78377_a(field_78295_j + f, field_78296_k + (float)field_78288_b, 0.0D);
                tessellator1.func_78377_a(field_78295_j + f, (field_78296_k + (float)field_78288_b) - 1.0F, 0.0D);
                tessellator1.func_78377_a(field_78295_j + (float)j1, (field_78296_k + (float)field_78288_b) - 1.0F, 0.0D);
                tessellator1.func_78381_a();
                GL11.glEnable(3553);
            }
            field_78295_j += (int)f;
        }

    }

    private int func_78274_b(String p_78274_1_, int p_78274_2_, int p_78274_3_, int p_78274_4_, int p_78274_5_, boolean p_78274_6_)
    {
        if(field_78294_m)
        {
            p_78274_1_ = func_78283_c(p_78274_1_);
            int i = func_78256_a(p_78274_1_);
            p_78274_2_ = (p_78274_2_ + p_78274_4_) - i;
        }
        return func_78258_a(p_78274_1_, p_78274_2_, p_78274_3_, p_78274_5_, p_78274_6_);
    }

    private int func_78258_a(String p_78258_1_, int p_78258_2_, int p_78258_3_, int p_78258_4_, boolean p_78258_5_)
    {
        if(p_78258_1_ != null)
        {
            field_78297_h = 0;
            if((p_78258_4_ & 0xfc000000) == 0)
            {
                p_78258_4_ |= 0xff000000;
            }
            if(p_78258_5_)
            {
                p_78258_4_ = (p_78258_4_ & 0xfcfcfc) >> 2 | p_78258_4_ & 0xff000000;
            }
            field_78291_n = (float)(p_78258_4_ >> 16 & 0xff) / 255F;
            field_78292_o = (float)(p_78258_4_ >> 8 & 0xff) / 255F;
            field_78306_p = (float)(p_78258_4_ & 0xff) / 255F;
            field_78305_q = (float)(p_78258_4_ >> 24 & 0xff) / 255F;
            GL11.glColor4f(field_78291_n, field_78292_o, field_78306_p, field_78305_q);
            field_78295_j = p_78258_2_;
            field_78296_k = p_78258_3_;
            func_78255_a(p_78258_1_, p_78258_5_);
            return (int)field_78295_j;
        } else
        {
            return 0;
        }
    }

    public int func_78256_a(String p_78256_1_)
    {
        if(p_78256_1_ == null)
        {
            return 0;
        }
        int i = 0;
        boolean flag = false;
        for(int j = 0; j < p_78256_1_.length(); j++)
        {
            char c = p_78256_1_.charAt(j);
            int k = func_78263_a(c);
            if(k < 0 && j < p_78256_1_.length() - 1)
            {
                char c1 = p_78256_1_.charAt(++j);
                if(c1 == 'l' || c1 == 'L')
                {
                    flag = true;
                } else
                if(c1 == 'r' || c1 == 'R')
                {
                    flag = false;
                }
                k = func_78263_a(c1);
            }
            i += k;
            if(flag)
            {
                i++;
            }
        }

        return i;
    }

    public int func_78263_a(char p_78263_1_)
    {
        if(p_78263_1_ == '\247')
        {
            return -1;
        }
        if(p_78263_1_ == ' ')
        {
            return 4;
        }
        int i = ChatAllowedCharacters.field_71568_a.indexOf(p_78263_1_);
        if(i >= 0 && !field_78293_l)
        {
            return field_78286_d[i + 32];
        }
        if(field_78287_e[p_78263_1_] != 0)
        {
            int j = field_78287_e[p_78263_1_] >>> 4;
            int k = field_78287_e[p_78263_1_] & 0xf;
            if(k > 7)
            {
                k = 15;
                j = 0;
            }
            return (++k - j) / 2 + 1;
        } else
        {
            return 0;
        }
    }

    public String func_78269_a(String p_78269_1_, int p_78269_2_)
    {
        return func_78262_a(p_78269_1_, p_78269_2_, false);
    }

    public String func_78262_a(String p_78262_1_, int p_78262_2_, boolean p_78262_3_)
    {
        StringBuilder stringbuilder = new StringBuilder();
        int i = 0;
        int j = p_78262_3_ ? p_78262_1_.length() - 1 : 0;
        byte byte0 = ((byte)(p_78262_3_ ? -1 : 1));
        boolean flag = false;
        boolean flag1 = false;
        for(int k = j; k >= 0 && k < p_78262_1_.length() && i < p_78262_2_; k += byte0)
        {
            char c = p_78262_1_.charAt(k);
            int l = func_78263_a(c);
            if(flag)
            {
                flag = false;
                if(c == 'l' || c == 'L')
                {
                    flag1 = true;
                } else
                if(c == 'r' || c == 'R')
                {
                    flag1 = false;
                }
            } else
            if(l < 0)
            {
                flag = true;
            } else
            {
                i += l;
                if(flag1)
                {
                    i++;
                }
            }
            if(i > p_78262_2_)
            {
                break;
            }
            if(p_78262_3_)
            {
                stringbuilder.insert(0, c);
            } else
            {
                stringbuilder.append(c);
            }
        }

        return stringbuilder.toString();
    }

    private String func_78273_d(String p_78273_1_)
    {
        for(; p_78273_1_ != null && p_78273_1_.endsWith("\n"); p_78273_1_ = p_78273_1_.substring(0, p_78273_1_.length() - 1)) { }
        return p_78273_1_;
    }

    public void func_78279_b(String p_78279_1_, int p_78279_2_, int p_78279_3_, int p_78279_4_, int p_78279_5_)
    {
        func_78265_b();
        field_78304_r = p_78279_5_;
        p_78279_1_ = func_78273_d(p_78279_1_);
        func_78281_c(p_78279_1_, p_78279_2_, p_78279_3_, p_78279_4_, p_78279_5_);
    }

    private void func_78281_c(String p_78281_1_, int p_78281_2_, int p_78281_3_, int p_78281_4_, int p_78281_5_)
    {
        field_78304_r = p_78281_5_;
        func_78268_b(p_78281_1_, p_78281_2_, p_78281_3_, p_78281_4_, false);
    }

    private void func_78268_b(String p_78268_1_, int p_78268_2_, int p_78268_3_, int p_78268_4_, boolean p_78268_5_)
    {
        String as[] = p_78268_1_.split("\n");
        if(as.length > 1)
        {
            boolean flag = false;
            String as2[] = as;
            int j = as2.length;
            for(int k = 0; k < j; k++)
            {
                String s2 = as2[k];
                if(flag)
                {
                    s2 = (new StringBuilder()).append("\247").append(s2).toString();
                    flag = false;
                }
                if(s2.endsWith("\247"))
                {
                    flag = true;
                    s2 = s2.substring(0, s2.length() - 1);
                }
                func_78268_b(s2, p_78268_2_, p_78268_3_, p_78268_4_, p_78268_5_);
                p_78268_3_ += func_78267_b(s2, p_78268_4_);
            }

            return;
        }
        String as1[] = p_78268_1_.split(" ");
        int i = 0;
        String s = "";
        for(; i < as1.length; i++)
        {
            String s1 = as1[i];
            if(func_78256_a(s1) >= p_78268_4_)
            {
                if(s.length() > 0)
                {
                    func_78274_b(s, p_78268_2_, p_78268_3_, p_78268_4_, field_78304_r, p_78268_5_);
                    p_78268_3_ += field_78288_b;
                    s = s1;
                }
                do
                {
                    int l;
                    for(l = 1; func_78256_a(s1.substring(0, l)) < p_78268_4_; l++) { }
                    func_78274_b(s1.substring(0, l - 1), p_78268_2_, p_78268_3_, p_78268_4_, field_78304_r, p_78268_5_);
                    p_78268_3_ += field_78288_b;
                    s1 = s1.substring(l - 1);
                } while(func_78256_a(s1) >= p_78268_4_);
                s = s1;
                continue;
            }
            if(func_78256_a((new StringBuilder()).append(s).append(" ").append(s1).toString()) >= p_78268_4_)
            {
                func_78274_b(s, p_78268_2_, p_78268_3_, p_78268_4_, field_78304_r, p_78268_5_);
                p_78268_3_ += field_78288_b;
                s = s1;
                continue;
            }
            if(s.length() > 0)
            {
                s = (new StringBuilder()).append(s).append(" ").toString();
            }
            s = (new StringBuilder()).append(s).append(s1).toString();
        }

        func_78274_b(s, p_78268_2_, p_78268_3_, p_78268_4_, field_78304_r, p_78268_5_);
    }

    public int func_78267_b(String p_78267_1_, int p_78267_2_)
    {
        String as[] = p_78267_1_.split("\n");
        if(as.length > 1)
        {
            int i = 0;
            String as2[] = as;
            int k = as2.length;
            for(int i1 = 0; i1 < k; i1++)
            {
                String s1 = as2[i1];
                i += func_78267_b(s1, p_78267_2_);
            }

            return i;
        }
        String as1[] = p_78267_1_.split(" ");
        int j = 0;
        int l = 0;
        String s = "";
        for(; l < as1.length; l++)
        {
            String s2 = as1[l];
            if(func_78256_a(s2) >= p_78267_2_)
            {
                if(s.length() > 0)
                {
                    j += field_78288_b;
                    s = s2;
                }
                do
                {
                    int j1;
                    for(j1 = 1; func_78256_a(s2.substring(0, j1)) < p_78267_2_; j1++) { }
                    j += field_78288_b;
                    s2 = s2.substring(j1 - 1);
                } while(func_78256_a(s2) >= p_78267_2_);
                s = s2;
                continue;
            }
            if(func_78256_a((new StringBuilder()).append(s).append(" ").append(s2).toString()) >= p_78267_2_)
            {
                j += field_78288_b;
                s = s2;
                continue;
            }
            if(s.length() > 0)
            {
                s = (new StringBuilder()).append(s).append(" ").toString();
            }
            s = (new StringBuilder()).append(s).append(s2).toString();
        }

        if(s.length() > 0)
        {
            j += field_78288_b;
        }
        return j;
    }

    public void func_78264_a(boolean p_78264_1_)
    {
        field_78293_l = p_78264_1_;
    }

    public void func_78275_b(boolean p_78275_1_)
    {
        field_78294_m = p_78275_1_;
    }

    public java.util.List func_78271_c(String p_78271_1_, int p_78271_2_)
    {
        return Arrays.asList(func_78280_d(p_78271_1_, p_78271_2_).split("\n"));
    }

    String func_78280_d(String p_78280_1_, int p_78280_2_)
    {
        int i = func_78259_e(p_78280_1_, p_78280_2_);
        if(p_78280_1_.length() <= i)
        {
            return p_78280_1_;
        } else
        {
            String s = p_78280_1_.substring(0, i);
            String s1 = (new StringBuilder()).append(func_78282_e(s)).append(p_78280_1_.substring(i + (p_78280_1_.charAt(i) != ' ' ? 0 : 1))).toString();
            return (new StringBuilder()).append(s).append("\n").append(func_78280_d(s1, p_78280_2_)).toString();
        }
    }

    private int func_78259_e(String p_78259_1_, int p_78259_2_)
    {
        int i = p_78259_1_.length();
        int j = 0;
        int k = 0;
        int l = -1;
        boolean flag = false;
        do
        {
            if(k >= i)
            {
                break;
            }
            char c = p_78259_1_.charAt(k);
            switch(c)
            {
            case 167: 
                if(k < i - 1)
                {
                    char c1 = p_78259_1_.charAt(++k);
                    if(c1 == 'l' || c1 == 'L')
                    {
                        flag = true;
                    } else
                    if(c1 == 'r' || c1 == 'R')
                    {
                        flag = false;
                    }
                }
                break;

            case 32: // ' '
                l = k;
                // fall through

            default:
                j += func_78263_a(c);
                if(flag)
                {
                    j++;
                }
                break;
            }
            if(c == '\n')
            {
                l = ++k;
                break;
            }
            if(j > p_78259_2_)
            {
                break;
            }
            k++;
        } while(true);
        if(k != i && l != -1 && l < k)
        {
            return l;
        } else
        {
            return k;
        }
    }

    private static boolean func_78272_b(char p_78272_0_)
    {
        return p_78272_0_ >= '0' && p_78272_0_ <= '9' || p_78272_0_ >= 'a' && p_78272_0_ <= 'f' || p_78272_0_ >= 'A' && p_78272_0_ <= 'F';
    }

    private static boolean func_78270_c(char p_78270_0_)
    {
        return p_78270_0_ >= 'k' && p_78270_0_ <= 'o' || p_78270_0_ >= 'K' && p_78270_0_ <= 'O' || p_78270_0_ == 'r' || p_78270_0_ == 'R';
    }

    private static String func_78282_e(String p_78282_0_)
    {
        String s = "";
        int i = -1;
        int j = p_78282_0_.length();
        do
        {
            if((i = p_78282_0_.indexOf('\247', i + 1)) == -1)
            {
                break;
            }
            if(i < j - 1)
            {
                char c = p_78282_0_.charAt(i + 1);
                if(func_78272_b(c))
                {
                    s = (new StringBuilder()).append("\247").append(c).toString();
                } else
                if(func_78270_c(c))
                {
                    s = (new StringBuilder()).append(s).append("\247").append(c).toString();
                }
            }
        } while(true);
        return s;
    }

    public boolean func_78260_a()
    {
        return field_78294_m;
    }
}
