import java.applet.Applet;
import java.awt.*;

public class AppVsBackground extends Applet implements Runnable {
    public static boolean isStopped = false;
    public static int fps = 60;

    ColorBase redColor = new ColorBase(30);
    ColorBase greenColor = new ColorBase(15);
    ColorBase blueColor = new ColorBase(0);

    Thread app = new Thread(this);
    Thread input = new Thread(new UInput());

    Thread tRed = new Thread(redColor);
    Thread tGreen = new Thread(greenColor);
    Thread tBlue = new Thread(blueColor);

    @Override
    public void init() {
        setBackground(new Color(redColor.getColor(), greenColor.getColor(), blueColor.getColor()));
        app.start();
    }

    @Override
    public void run() {
        tRed.start();
        tGreen.start();
        tBlue.start();
        input.start();
        try {
            while (!Thread.currentThread().isInterrupted()) {
                setBackground(new Color(redColor.getColor(), greenColor.getColor(), blueColor.getColor()));
                repaint();
                app.sleep(fps - 30);

                if (isStopped) app.interrupt();
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }


}

