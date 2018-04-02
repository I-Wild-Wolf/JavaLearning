import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.StringTokenizer;

public class FileWriter
        implements Runnable {
    int nBlocks = 0;


    public static void main(String args[]) {
        FileWriter fw = new FileWriter();

        System.out.println(
                "*Multithread file writer*\r\n");
        System.out.print("Enter number of blocks: ");

        fw.nBlocks = getKbdInt();

        Thread ioThread = new Thread(fw);

        ioThread.start();

        try {
            ioThread.join();
        } catch (InterruptedException ie) {
            System.out.println(ie.toString());
        }

        System.out.print(
                "All done!\r\nPress <Enter>...");
        getKbdByte();
    }


    public void run() {
        DataOutputStream os;

        try {
            os = new DataOutputStream(
                    new FileOutputStream("testfile.txt"));

            for (int i = 0; i < nBlocks; i++) {
                os.writeBytes(i + "\r\n");
            }

            os.flush();
            os.close();
        } catch (Exception ioe) {
            System.out.println(ioe.toString());
        }
    }


    static public int getKbdInt() {
        byte bKbd[] = new byte[256];
        int iCnt = 0;
        String szStr = "";
        StringTokenizer st;

        try {
            iCnt = System.in.read(bKbd);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

        szStr = new String(bKbd, 0, iCnt);
        st = new StringTokenizer(szStr, "\r\n");
        szStr =
                new String((String) st.nextElement());

        Integer intVal = new Integer(szStr);
        return intVal.intValue();
    }

    static public byte getKbdByte() {
        byte bKbd[] = new byte[1];
        int iCnt = 0;

        try {
            iCnt = System.in.read(bKbd);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

        return bKbd[0];
    }
}

