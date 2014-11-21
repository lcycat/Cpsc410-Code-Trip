package net.minecraft.src;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class ModTextureStatic extends TextureFX
{
    private boolean oldanaglyph;
    private int pixels[];

    public ModTextureStatic(int i, int j, BufferedImage bufferedimage)
    {
        this(i, 1, j, bufferedimage);
    }

    public ModTextureStatic(int i, int j, int k, BufferedImage bufferedimage)
    {
        super(i);
        pixels = null;
        tileSize = j;
        tileImage = k;
        bindImage(ModLoader.getMinecraftInstance().renderEngine);
        int l = GL11.glGetTexLevelParameteri(GL11.GL_TEXTURE_2D, 0, GL11.GL_TEXTURE_WIDTH) / 16;
        int i1 = GL11.glGetTexLevelParameteri(GL11.GL_TEXTURE_2D, 0, GL11.GL_TEXTURE_HEIGHT) / 16;
        int j1 = bufferedimage.getWidth();
        int k1 = bufferedimage.getHeight();
        pixels = new int[l * i1];
        imageData = new byte[l * i1 * 4];

        if (j1 != k1 || j1 != l)
        {
            BufferedImage bufferedimage1 = new BufferedImage(l, i1, 6);
            Graphics2D graphics2d = bufferedimage1.createGraphics();
            graphics2d.drawImage(bufferedimage, 0, 0, l, i1, 0, 0, j1, k1, null);
            bufferedimage1.getRGB(0, 0, l, i1, pixels, 0, l);
            graphics2d.dispose();
        }
        else
        {
            bufferedimage.getRGB(0, 0, j1, k1, pixels, 0, j1);
        }

        update();
    }

    public void update()
    {
        for (int i = 0; i < pixels.length; i++)
        {
            int j = pixels[i] >> 24 & 0xff;
            int k = pixels[i] >> 16 & 0xff;
            int l = pixels[i] >> 8 & 0xff;
            int i1 = pixels[i] >> 0 & 0xff;

            if (anaglyphEnabled)
            {
                int j1 = (k + l + i1) / 3;
                k = l = i1 = j1;
            }

            imageData[i * 4 + 0] = (byte)k;
            imageData[i * 4 + 1] = (byte)l;
            imageData[i * 4 + 2] = (byte)i1;
            imageData[i * 4 + 3] = (byte)j;
        }

        oldanaglyph = anaglyphEnabled;
    }

    public void onTick()
    {
        if (oldanaglyph != anaglyphEnabled)
        {
            update();
        }
    }

    public static BufferedImage scale2x(BufferedImage bufferedimage)
    {
        int i = bufferedimage.getWidth();
        int j = bufferedimage.getHeight();
        BufferedImage bufferedimage1 = new BufferedImage(i * 2, j * 2, 2);

        for (int k = 0; k < j; k++)
        {
            for (int l = 0; l < i; l++)
            {
                int i1 = bufferedimage.getRGB(l, k);
                int j1;

                if (k == 0)
                {
                    j1 = i1;
                }
                else
                {
                    j1 = bufferedimage.getRGB(l, k - 1);
                }

                int k1;

                if (l == 0)
                {
                    k1 = i1;
                }
                else
                {
                    k1 = bufferedimage.getRGB(l - 1, k);
                }

                int l1;

                if (l >= i - 1)
                {
                    l1 = i1;
                }
                else
                {
                    l1 = bufferedimage.getRGB(l + 1, k);
                }

                int i2;

                if (k >= j - 1)
                {
                    i2 = i1;
                }
                else
                {
                    i2 = bufferedimage.getRGB(l, k + 1);
                }

                int j2;
                int k2;
                int l2;
                int i3;

                if (j1 != i2 && k1 != l1)
                {
                    j2 = k1 == j1 ? k1 : i1;
                    k2 = j1 == l1 ? l1 : i1;
                    l2 = k1 == i2 ? k1 : i1;
                    i3 = i2 == l1 ? l1 : i1;
                }
                else
                {
                    j2 = i1;
                    k2 = i1;
                    l2 = i1;
                    i3 = i1;
                }

                bufferedimage1.setRGB(l * 2, k * 2, j2);
                bufferedimage1.setRGB(l * 2 + 1, k * 2, k2);
                bufferedimage1.setRGB(l * 2, k * 2 + 1, l2);
                bufferedimage1.setRGB(l * 2 + 1, k * 2 + 1, i3);
            }
        }

        return bufferedimage1;
    }
}
