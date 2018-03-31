import java.util.concurrent.TimeUnit;

public class RedColor implements Runnable {
  private int modFps;
  private int redColor = 100;

  public RedColor(int modFps) {
    this.modFps = modFps;
  }

  public int getRedColor() {
    return redColor;
  }

  @Override
  public void run() {
    byte step = 1;
    while (true) {
      int tempColor = redColor + step;
      if (tempColor > 255) {
        tempColor = 255;
        step *= -1;
      }
      if (tempColor < 0) {
        tempColor = 0;
        step *= -1;
      }
      redColor = tempColor;
      try {
        TimeUnit.MILLISECONDS.sleep(AppVsBackground.fps - modFps);
      } catch (Exception ex) {
      }
    }
  }
}
