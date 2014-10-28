package net.minecraft.src;

public interface IProgressUpdate
{
    /**
     * "Saving level", or the loading,or downloading equivelent
     */
    public abstract void displayProgressMessage(String s);

    /**
     * this string, followed by "working..." and then the "% complete" are the 3 lines shown. This resets progress to 0,
     * and the WorkingString to "working...".
     */
    public abstract void resetProgressAndMessage(String s);

    /**
     * This is called with "Working..." by resetProgressAndMessage
     */
    public abstract void resetProgresAndWorkingMessage(String s);

    /**
     * Updates the progress bar on the loading screen to the specified amount. Args: loadProgress
     */
    public abstract void setLoadingProgress(int i);

    /**
     * called when there is no more progress to be had, both on completion and failure
     */
    public abstract void onNoMoreProgress();
}
