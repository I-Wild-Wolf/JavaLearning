import java.applet.Applet;
import java.awt.*;

public class Multi2 extends Applet {
    Thread thrColor = null;
    Thread thrSize = null;
    int rColor, gColor, bColor;
    int nFontSize = 12;

    public void start() {
        if (thrColor == null) {
            thrColor = new SizeThread(this);
            thrColor.start();
        }
        if (thrSize == null) {
            thrSize = new ColorThread(this);
            thrSize.start();
        }
    }

    public void stop() {
        if (thrColor != null) {
            thrColor.stop();
            thrColor = null;
        }
        if (thrSize != null) {
            thrSize.stop();
            thrSize = null;
        }
    }

    public void paint(Graphics g) {
        String s;
        g.setColor(new Color(rColor, gColor, bColor));
        s = "(R, G, B) = (" + rColor + ", " + gColor + ", " + bColor + ")";
        g.setFont(new Font("Courier", Font.PLAIN, nFontSize));
        g.drawString(s, 10, 30);
    }

    public String getAppletInfo() {
        return "Name: Multi2";
    }
}

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

            a.repaint();
            try

            {
                Thread.sleep(1000);
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
                if (a.nFontSize < 30) a.nFontSize++;
                else incr = false;
            } else {
                if (a.nFontSize > 12) a.nFontSize--;
                else incr = true;
            }

            a.repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException ie) {
                stop();
            }
        }
    }
}