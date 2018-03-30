import java.applet.Applet;
import java.awt.*;

public class AppVsBackground extends Applet implements Runnable {

  Thread app = new Thread(this);

  RedColor redColor = new RedColor(8);
  GreenColor greenColor = new GreenColor(6);
  BlueColor blueColor = new BlueColor(2);

  Thread tRed = new Thread(redColor);
  Thread tGreen = new Thread(greenColor);
  Thread tBlue = new Thread(blueColor);

  @Override
  public void init() {
    app.start();
    setBackground(new Color(redColor.getRedColor(), greenColor.getGreenColor(), blueColor.getBlueColor()));
  }

  @Override
  public void run () {
    tRed.start();
    tGreen.start();
    tBlue.start();
    try {
      while (true) {
        setBackground(new Color(redColor.getRedColor(), greenColor.getGreenColor(), blueColor.getBlueColor()));
        repaint();
        tBlue.sleep(40);
      }
    } catch (Exception ex) {
      System.out.println(ex.toString());
    }
  }


}

