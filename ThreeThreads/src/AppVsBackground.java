import java.applet.Applet;
import java.awt.*;

public class AppVsBackground extends Applet implements Runnable {

  public static int fps = 120;
  Thread app = new Thread(this);

  /*RedColor redColor = new RedColor(0);
  GreenColor greenColor = new GreenColor(15);
  BlueColor blueColor = new BlueColor(30);*/

  ColorBase redColor = new ColorBase(30);
  ColorBase greenColor = new ColorBase(15);
  ColorBase blueColor = new ColorBase(0);

  Thread tRed = new Thread(redColor);
  Thread tGreen = new Thread(greenColor);
  Thread tBlue = new Thread(blueColor);

  @Override
  public void init() {
    setBackground(new Color(redColor.getColor(), greenColor.getColor(), blueColor.getColor()));
    app.start();
  }

  @Override
  public void run () {
    tRed.start();
    tGreen.start();
    tBlue.start();
    try {
      while (true) {
        setBackground(new Color(redColor.getColor(), greenColor.getColor(), blueColor.getColor()));
        repaint();
        tBlue.sleep(fps - 30);
      }
    } catch (Exception ex) {
      System.out.println(ex.toString());
    }
  }


}

