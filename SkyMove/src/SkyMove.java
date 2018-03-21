import java.applet.Applet;
import java.awt.*;


public class SkyMove extends Applet
        implements Runnable
{
    Thread thr = null;
    boolean bImagesLoaded = false;
    int nCurrentImage = 0;
    Image [] im;

    ////////
    //start
    ////////
    public void start()
    {
        if (thr == null)
        {
            thr = new Thread(this);
            thr.start();
        }
    }

    ///////
    //stop
    ///////

    public void stop()
    {
        if(thr != null)
        {
            thr.stop();
            thr = null;
        }
    }

    //////
    //run
    //////

    public void run()
    {
        nCurrentImage = 0;
        if(!bImagesLoaded)
        {
            im = new Image [40];

            MediaTracker mt = new MediaTracker(this);
            String s;

            for (int i = 1; i < 41; i++)
            {
                s = "pic" + ((i < 10) ? "0" : "") + i + ".gif";

                im[i - 1] = getImage(getDocumentBase(), s);

                mt.addImage(im[i-1], 0);
            }
            try
            {
                mt.waitForAll();
                bImagesLoaded = !mt.isErrorAny();
            }
            catch (InterruptedException ie)
            {
                stop();
            }
        }
        Graphics g = getGraphics();
        boolean flip = true;

        while(true)
        {
            if(bImagesLoaded)
            {
                g.drawImage(im[nCurrentImage], 0, 0, null);
                g.drawString("Frame: " + (nCurrentImage + 1 ), 10, 30);

                if(flip)
                {
                    nCurrentImage++;
                    if (nCurrentImage > 38)
                        flip = false;
                }
                else
                {
                    nCurrentImage--;
                    if(nCurrentImage < 1)
                        flip = true;
                }
            }
            try
            {
                thr.sleep(30);
            }
            catch(InterruptedException ie)
            {
                stop();
            }
        }
    }
    /////////
    //paint
    /////////
    public void paint(Graphics g)
    {
        if(!bImagesLoaded)
            g.drawString("Loading...", 10, 30);
    }

    ///////////////
    //getAppletInfo
    ///////////////

    public String getAppletInfo()
    {
        return "Name: SkyMove";
    }
}