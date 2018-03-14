import java.awt.Graphics;
import java.util.*;
import java.text.DateFormat;
import java.applet.Applet;
public class Clock extends Applet implements Runnable {
        private Thread clockThread = null;
        public void start()
if (clockThread == null)
        clockThread = new Thread(this, "Clock"); l
        clockThread.start();

public void run()(
        Thread myThread = Thread.currentThread():
        while (clockThread == myThread){
        repainti}:
        try
        Thread.sleep(1000);
        catch (lnterruptedException e){

public void paint(Graphics g){
        I! get the time and convert it to a date
        Calendar cal = Calendar.getlnstance();
        Date date = calgetTimeO;
        II format it and display it
        DateFormat dateFormatter = DateFormat.getTimeInstance();
        g.drawString(dateFormatter.format(date), 5, 10);

        II overrides Applet's stop method, not Thread's
public void stop()
        clockThread = null;

class ColorThread extends Thread {
    Multi2 a = null;

    public ColorThread(Applet appl) {
        a = (Multi2) appl;
    }

    public void run() {
        while (true) {
            a.rColor = (int) (255 * Math.random());
            a.gColor = (int) (255 * Math.random());
            a.bColor = (int) (255 * Math.random());


            try

            {
                Thread.sleep(100);
            } catch (
                    InterruptedException ie)

            {
                stop();
            }
        }
    }
}

class SizeThread extends Thread {
    Multi2 a = null;

    public SizeThread(Applet appl) {
        a = (Multi2) appl;
    }

    public void run() {
        boolean incr = true;
        while (true)

        {
            if (incr) {
                if (a.size < 200) a.size++;
                else incr = false;
            } else {
                if (a.size > 75) a.size--;
                else incr = true;
            }

            a.repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                stop();
            }
        }
    }
}