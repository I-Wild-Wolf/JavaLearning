import java.applet.Applet;
import java.awt.*;


public class MultiReadingApplet extends Applet {
    ColorChanger red;
    ColorChanger green;
    ColorChanger blue;

    public void start () {
        red = new ColorChanger(19, this);
        green = new ColorChanger(10, this);
        blue = new ColorChanger(1, this);
        red.run();
        green.run();
        blue.run();

    }




}

class ColorChanger extends Thread {

    MultiReadingApplet a;
    int speedOfChanging;
    int capasity = 0;

    public ColorChanger(int speedOfChanging, Applet appl) {
        this.speedOfChanging = speedOfChanging;

        a = (MultiReadingApplet) appl;
    }

    public void run () {
        while (true) {
           /* speedOfChanging *= -1;
            if (capasity <= 20) {
                speedOfChanging *= -1;
            } else if (capasity >= 235)
                speedOfChanging *= -1;
            capasity += speedOfChanging;*/
           capasity = 0;
            a.setBackground(new Color(a.red.capasity, a.green.capasity, a.blue.capasity));
            a.repaint();
            try {
            Thread.sleep(200);
            } catch (InterruptedException ex)
            {}
        }
    }
}

