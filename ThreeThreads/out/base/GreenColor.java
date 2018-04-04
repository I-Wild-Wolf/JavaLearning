package base;

import java.util.concurrent.TimeUnit;

public class GreenColor implements Runnable {
  private int modFps;
  private int greenColor = 50;

  public GreenColor(int modFps) {
    this.modFps = modFps;
  }

  public int getGreenColor() {
    return greenColor;
  }

  @Override
  public void run() {
    byte step = 1;
    while (true) {
      int tempColor = greenColor + step;
      if (tempColor > 255) {
        tempColor = 255;
        step *= -1;
      }
      if (tempColor < 0) {
        tempColor = 0;
        step *= -1;
      }
      greenColor = tempColor;
      try {
        TimeUnit.MILLISECONDS.sleep(AppVsBackground.fps - modFps);
      } catch (Exception ex) {
      }
    }
  }
}


