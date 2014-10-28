package net.minecraft.src;

public class WatchableObject
{
    private final int objectType;

    /** id of max 31 */
    private final int dataValueId;
    private Object watchedObject;
    private boolean watched;

    public WatchableObject(int par1, int par2, Object par3Obj)
    {
        dataValueId = par2;
        watchedObject = par3Obj;
        objectType = par1;
        watched = true;
    }

    public int getDataValueId()
    {
        return dataValueId;
    }

    public void setObject(Object par1Obj)
    {
        watchedObject = par1Obj;
    }

    public Object getObject()
    {
        return watchedObject;
    }

    public int getObjectType()
    {
        return objectType;
    }

    public boolean isWatched()
    {
        return watched;
    }

    public void setWatched(boolean par1)
    {
        watched = par1;
    }
}
