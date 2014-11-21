package net.minecraft.src;

import java.io.*;
import java.util.Map;

public class StatsSyncher
{
    private volatile boolean isBusy;
    private volatile Map field_77430_b;
    private volatile Map field_77431_c;

    /**
     * The StatFileWriter object, presumably used to write to the statistics files
     */
    private StatFileWriter statFileWriter;

    /** A file named 'stats_' [lower case username] '_unsent.dat' */
    private File unsentDataFile;

    /** A file named 'stats_' [lower case username] '.dat' */
    private File dataFile;

    /** A file named 'stats_' [lower case username] '_unsent.tmp' */
    private File unsentTempFile;

    /** A file named 'stats_' [lower case username] '.tmp' */
    private File tempFile;

    /** A file named 'stats_' [lower case username] '_unsent.old' */
    private File unsentOldFile;

    /** A file named 'stats_' [lower case username] '.old' */
    private File oldFile;

    /** The Session object */
    private Session theSession;
    private int field_77433_l;
    private int field_77434_m;

    public StatsSyncher(Session par1Session, StatFileWriter par2StatFileWriter, File par3File)
    {
        isBusy = false;
        field_77430_b = null;
        field_77431_c = null;
        field_77433_l = 0;
        field_77434_m = 0;
        unsentDataFile = new File(par3File, (new StringBuilder()).append("stats_").append(par1Session.username.toLowerCase()).append("_unsent.dat").toString());
        dataFile = new File(par3File, (new StringBuilder()).append("stats_").append(par1Session.username.toLowerCase()).append(".dat").toString());
        unsentOldFile = new File(par3File, (new StringBuilder()).append("stats_").append(par1Session.username.toLowerCase()).append("_unsent.old").toString());
        oldFile = new File(par3File, (new StringBuilder()).append("stats_").append(par1Session.username.toLowerCase()).append(".old").toString());
        unsentTempFile = new File(par3File, (new StringBuilder()).append("stats_").append(par1Session.username.toLowerCase()).append("_unsent.tmp").toString());
        tempFile = new File(par3File, (new StringBuilder()).append("stats_").append(par1Session.username.toLowerCase()).append(".tmp").toString());

        if (!par1Session.username.toLowerCase().equals(par1Session.username))
        {
            func_77412_a(par3File, (new StringBuilder()).append("stats_").append(par1Session.username).append("_unsent.dat").toString(), unsentDataFile);
            func_77412_a(par3File, (new StringBuilder()).append("stats_").append(par1Session.username).append(".dat").toString(), dataFile);
            func_77412_a(par3File, (new StringBuilder()).append("stats_").append(par1Session.username).append("_unsent.old").toString(), unsentOldFile);
            func_77412_a(par3File, (new StringBuilder()).append("stats_").append(par1Session.username).append(".old").toString(), oldFile);
            func_77412_a(par3File, (new StringBuilder()).append("stats_").append(par1Session.username).append("_unsent.tmp").toString(), unsentTempFile);
            func_77412_a(par3File, (new StringBuilder()).append("stats_").append(par1Session.username).append(".tmp").toString(), tempFile);
        }

        statFileWriter = par2StatFileWriter;
        theSession = par1Session;

        if (unsentDataFile.exists())
        {
            par2StatFileWriter.writeStats(func_77417_a(unsentDataFile, unsentTempFile, unsentOldFile));
        }

        beginReceiveStats();
    }

    private void func_77412_a(File par1File, String par2Str, File par3File)
    {
        File file = new File(par1File, par2Str);

        if (file.exists() && !file.isDirectory() && !par3File.exists())
        {
            file.renameTo(par3File);
        }
    }

    private Map func_77417_a(File par1File, File par2File, File par3File)
    {
        if (par1File.exists())
        {
            return func_77413_a(par1File);
        }

        if (par3File.exists())
        {
            return func_77413_a(par3File);
        }

        if (par2File.exists())
        {
            return func_77413_a(par2File);
        }
        else
        {
            return null;
        }
    }

    private Map func_77413_a(File par1File)
    {
        BufferedReader bufferedreader = null;

        try
        {
            bufferedreader = new BufferedReader(new FileReader(par1File));
            String s = "";
            StringBuilder stringbuilder = new StringBuilder();

            while ((s = bufferedreader.readLine()) != null)
            {
                stringbuilder.append(s);
            }

            Map map = StatFileWriter.func_77453_b(stringbuilder.toString());
            return map;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            if (bufferedreader != null)
            {
                try
                {
                    bufferedreader.close();
                }
                catch (Exception exception2)
                {
                    exception2.printStackTrace();
                }
            }
        }

        return null;
    }

    private void func_77421_a(Map par1Map, File par2File, File par3File, File par4File) throws IOException
    {
        PrintWriter printwriter = new PrintWriter(new FileWriter(par3File, false));

        try
        {
            printwriter.print(StatFileWriter.func_77441_a(theSession.username, "local", par1Map));
        }
        finally
        {
            printwriter.close();
        }

        if (par4File.exists())
        {
            par4File.delete();
        }

        if (par2File.exists())
        {
            par2File.renameTo(par4File);
        }

        par3File.renameTo(par2File);
    }

    /**
     * Attempts to begin receiving stats from the server. Will throw an IllegalStateException if the syncher is already
     * busy.
     */
    public void beginReceiveStats()
    {
        if (isBusy)
        {
            throw new IllegalStateException("Can't get stats from server while StatsSyncher is busy!");
        }
        else
        {
            field_77433_l = 100;
            isBusy = true;
            (new ThreadStatSyncherReceive(this)).start();
            return;
        }
    }

    /**
     * Attempts to begin sending stats to the server. Will throw an IllegalStateException if the syncher is already
     * busy.
     */
    public void beginSendStats(Map par1Map)
    {
        if (isBusy)
        {
            throw new IllegalStateException("Can't save stats while StatsSyncher is busy!");
        }
        else
        {
            field_77433_l = 100;
            isBusy = true;
            (new ThreadStatSyncherSend(this, par1Map)).start();
            return;
        }
    }

    public void syncStatsFileWithMap(Map par1Map)
    {
        for (int i = 30; isBusy && --i > 0;)
        {
            try
            {
                Thread.sleep(100L);
            }
            catch (InterruptedException interruptedexception)
            {
                interruptedexception.printStackTrace();
            }
        }

        isBusy = true;

        try
        {
            func_77421_a(par1Map, unsentDataFile, unsentTempFile, unsentOldFile);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            isBusy = false;
        }
    }

    public boolean func_77425_c()
    {
        return field_77433_l <= 0 && !isBusy && field_77431_c == null;
    }

    public void func_77422_e()
    {
        if (field_77433_l > 0)
        {
            field_77433_l--;
        }

        if (field_77434_m > 0)
        {
            field_77434_m--;
        }

        if (field_77431_c != null)
        {
            statFileWriter.func_77448_c(field_77431_c);
            field_77431_c = null;
        }

        if (field_77430_b != null)
        {
            statFileWriter.func_77452_b(field_77430_b);
            field_77430_b = null;
        }
    }

    static Map func_77419_a(StatsSyncher par0StatsSyncher)
    {
        return par0StatsSyncher.field_77430_b;
    }

    static File func_77408_b(StatsSyncher par0StatsSyncher)
    {
        return par0StatsSyncher.dataFile;
    }

    static File func_77407_c(StatsSyncher par0StatsSyncher)
    {
        return par0StatsSyncher.tempFile;
    }

    static File func_77411_d(StatsSyncher par0StatsSyncher)
    {
        return par0StatsSyncher.oldFile;
    }

    static void func_77414_a(StatsSyncher par0StatsSyncher, Map par1Map, File par2File, File par3File, File par4File) throws IOException
    {
        par0StatsSyncher.func_77421_a(par1Map, par2File, par3File, par4File);
    }

    static Map func_77416_a(StatsSyncher par0StatsSyncher, Map par1Map)
    {
        return par0StatsSyncher.field_77430_b = par1Map;
    }

    static Map func_77410_a(StatsSyncher par0StatsSyncher, File par1File, File par2File, File par3File)
    {
        return par0StatsSyncher.func_77417_a(par1File, par2File, par3File);
    }

    static boolean setBusy(StatsSyncher par0StatsSyncher, boolean par1)
    {
        return par0StatsSyncher.isBusy = par1;
    }

    static File getUnsentDataFile(StatsSyncher par0StatsSyncher)
    {
        return par0StatsSyncher.unsentDataFile;
    }

    static File getUnsentTempFile(StatsSyncher par0StatsSyncher)
    {
        return par0StatsSyncher.unsentTempFile;
    }

    static File getUnsentOldFile(StatsSyncher par0StatsSyncher)
    {
        return par0StatsSyncher.unsentOldFile;
    }
}
