import java.io.*;
import java.util.*;

public class FileSynchro
{
    int nBlocks = 0;
    int i;
    fileWriter ioThread;


    public static void main(String args[])
    {
        FileSynchro fs = new FileSynchro();

        System.out.println(
                "*Multithread file writer*\r\n");
        System.out.print(
                "Enter number of blocks: ");
        fs.nBlocks = getKbdInt();

        fs.ioThread = new fileWriter(fs.nBlocks);
        fs.ioThread.start();

        try
        {
            fs.ioThread.join();
        }
        catch(InterruptedException ie)
        {
            System.out.println(ie.toString());
        }

        System.out.print(
                "All done!\r\nPress <Enter>...");
        getKbdByte();
    }


    static public int getKbdInt()
    {
        byte bKbd[] = new byte[256];
        int iCnt = 0;
        String szStr = "";
        StringTokenizer st;

        try
        {
            iCnt = System.in.read(bKbd);
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }

        szStr = new String(bKbd, 0, iCnt);
        st = new StringTokenizer(szStr, "\r\n");
        szStr =
                new String((String)st.nextElement());

        Integer intVal = new Integer(szStr);
        return intVal.intValue();
    }


    static public byte getKbdByte()
    {
        byte bKbd[] = new byte[1];
        int iCnt = 0;

        try
        {
            iCnt = System.in.read(bKbd);
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return bKbd[0];
    }
}


