package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class RenderSlime extends RenderLiving
{
    private ModelBase scaleAmount;

    public RenderSlime(ModelBase par1ModelBase, ModelBase par2ModelBase, float par3)
    {
        super(par1ModelBase, par3);
        scaleAmount = par2ModelBase;
    }

    protected int func_77090_a(EntitySlime par1EntitySlime, int par2, float par3)
    {
        if (par2 == 0)
        {
            setRenderPassModel(scaleAmount);
            GL11.glEnable(GL11.GL_NORMALIZE);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            return 1;
        }

        if (par2 == 1)
        {
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        }

        return -1;
    }

    /**
     * sets the scale for the slime based on getSlimeSize in EntitySlime
     */
    protected void scaleSlime(EntitySlime par1EntitySlime, float par2)
    {
        float f = par1EntitySlime.getSlimeSize();
        float f1 = (par1EntitySlime.field_70812_c + (par1EntitySlime.field_70811_b - par1EntitySlime.field_70812_c) * par2) / (f * 0.5F + 1.0F);
        float f2 = 1.0F / (f1 + 1.0F);
        GL11.glScalef(f2 * f, (1.0F / f2) * f, f2 * f);
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLiving par1EntityLiving, float par2)
    {
        scaleSlime((EntitySlime)par1EntityLiving, par2);
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLiving par1EntityLiving, int par2, float par3)
    {
        return func_77090_a((EntitySlime)par1EntityLiving, par2, par3);
    }
}
