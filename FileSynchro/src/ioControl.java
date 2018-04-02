class ioControl extends Thread
{
    int nPosition;
    Thread ioThread;
    static boolean end = false;


    public ioControl(Thread th)
    {
        ioThread = th;
    }


    public void setPosition(int i)
    {
        nPosition = i;
    }


    public void end()
    {
        end = true;
    }


    public synchronized void run()
    {
        while(!end)
        {
            try
            {
                this.wait();
            }
            catch(InterruptedException ie)
            {
                System.out.println(ie.toString());
            }

            System.out.println(
                    "String = " + nPosition);
        }
    }
}
