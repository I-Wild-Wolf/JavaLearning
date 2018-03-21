import java.applet.Applet;
import java.awt.*;

public class Scroller extends Applet {
    TextAutoScroller tas;
    TextAutoScroller tas1;
    TextAutoScroller tas2;


    public void init() {
        //Dimension dimMinSize;
        setLayout(new GridLayout(0, 1));
        Graphics g = getGraphics();

        String ScrollingText =
                " First scroller component";
        tas =
                new TextAutoScroller(ScrollingText, g);
        add(tas);

        ScrollingText = "";
        tas1 =
                new TextAutoScroller(ScrollingText, g);
        tas1.setFont(
                new Font("TimesRoman", Font.BOLD, 40));
        tas1.setDelay(20);
        add(tas1);
        tas1.setText(" Second scroller component");

        ScrollingText = " Last component";
        tas2 =
                new TextAutoScroller(ScrollingText, g);
        tas2.setDelay(5);
        tas2.setFont(
                new Font("Courier", Font.BOLD, 36));
        add(tas2);
    }

    public void start() {
        tas.start();
        tas1.start();
        tas2.start();
    }

    public void stop() {
        tas.stop();
        tas1.stop();
        tas2.stop();
    }

    public String getAppletInfo() {
        return "Name: Scroller";
    }
}

