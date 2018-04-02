import java.io.DataOutputStream;
import java.io.FileOutputStream;

class fileWriter extends Thread
{
    int nBlocks;


    public fileWriter(int n)
    {
        nBlocks = n;
    }


    public void run()
    {
        int i;
        DataOutputStream os;

        ioControl ioc = new ioControl(this);
        ioc.start();

        try
        {
            os = new DataOutputStream(
                    new FileOutputStream("testfile.txt"));

            for(i = 0; i < nBlocks; i++)
            {
                os.writeBytes("Test string\r\n");

                if(i%100 == 0)
                {
                    synchronized(ioc)
                    {
                        ioc.setPosition(i);
                        ioc.notify();
                    }
                }
            }

            synchronized(ioc)
            {
                ioc.setPosition(i);
                ioc.notify();
                ioc.end();
                ioc.join();
            }

            os.flush();
            os.close();

        }
        catch(Exception ioe)
        {
            System.out.println(ioe.toString());
        }
    }
}
