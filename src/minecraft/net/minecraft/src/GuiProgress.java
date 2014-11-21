package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class GuiProgress extends GuiScreen implements IProgressUpdate
{
    private String progressMessage;
    private String workingMessage;
    private int currentProgress;
    private boolean noMoreProgress;

    public GuiProgress()
    {
        progressMessage = "";
        workingMessage = "";
        currentProgress = 0;
    }

    /**
     * "Saving level", or the loading,or downloading equivelent
     */
    public void displayProgressMessage(String par1Str)
    {
        resetProgressAndMessage(par1Str);
    }

    /**
     * this string, followed by "working..." and then the "% complete" are the 3 lines shown. This resets progress to 0,
     * and the WorkingString to "working...".
     */
    public void resetProgressAndMessage(String par1Str)
    {
        progressMessage = par1Str;
        resetProgresAndWorkingMessage("Working...");
    }

    /**
     * This is called with "Working..." by resetProgressAndMessage
     */
    public void resetProgresAndWorkingMessage(String par1Str)
    {
        workingMessage = par1Str;
        setLoadingProgress(0);
    }

    /**
     * Updates the progress bar on the loading screen to the specified amount. Args: loadProgress
     */
    public void setLoadingProgress(int par1)
    {
        currentProgress = par1;
    }

    /**
     * called when there is no more progress to be had, both on completion and failure
     */
    public void onNoMoreProgress()
    {
        noMoreProgress = true;
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int par1, int par2, float par3)
    {
        if (noMoreProgress)
        {
            mc.displayGuiScreen(null);
            return;
        }
        else
        {
            drawDefaultBackground();
            drawCenteredString(fontRenderer, progressMessage, width / 2, 70, 0xffffff);
            drawCenteredString(fontRenderer, (new StringBuilder()).append(workingMessage).append(" ").append(currentProgress).append("%").toString(), width / 2, 90, 0xffffff);
            super.drawScreen(par1, par2, par3);
            return;
        }
    }
}
