import java.applet.Applet;
import java.awt.*;

public class BackgroundColorChanger extends Applet {
    Thread changeColor = null;
    int red = 100, green = 100, blue = 100;

    public void start() {
        if (changeColor == null) {
            changeColor = new ColorThread(this);
            changeColor.start();
        }
    }
    public void stop() {
        if (changeColor != null) {
            changeColor = null;
        }
    }
}


class ColorThread extends Thread{
    BackgroundColorChanger a;
    int rChanger = 5;
    int gChanger = 15;
    int bChanger = 10;

    public ColorThread(Applet appl) {
        a = (BackgroundColorChanger) appl;
    }

    public void run() {
        while (true) {

            if (a.red <= 5 || a.red >= 250) {
                rChanger *= -1;
            }
            if (a.green <= 15 || a.green >= 240) {
                gChanger *= -1;
                a.green = 125;
            }
            if (a.blue <= 10 || a.blue >= 245) {
                bChanger *= -1;
                a.blue = 125;
            }

            a.red += rChanger;
            a.green += gChanger;
            a.blue += bChanger;

            a.setBackground(new Color(a.red, a.green, a.blue));
            a.repaint();

            try {
                Thread.sleep(60);
            } catch (InterruptedException ie) {
        }
        }
    }
}
