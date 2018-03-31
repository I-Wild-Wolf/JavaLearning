import java.util.concurrent.TimeUnit;

public class ColorBase implements Runnable {
  private int modFps;
  private int color = (int) (Math.random() * 255);

  public ColorBase (int modFps) {

    this.modFps = modFps;
  }

  public int getColor() {
    return color;
  }

  @Override
  public void run() {
    System.out.println(color);
    byte step = 1;
    while (true) {
      int tempColor = color + step;
      if (tempColor > 255) {
        tempColor = 255;
        step *= -1;
      }
      if (tempColor < 0) {
        tempColor = 0;
        step *= -1;
      }
      color = tempColor;
      try {
        TimeUnit.MILLISECONDS.sleep(AppVsBackground.fps - modFps);
      } catch (Exception ex) {
      }
    }
  }

}
