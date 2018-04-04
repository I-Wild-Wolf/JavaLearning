package base;

import java.util.concurrent.TimeUnit;

public class BlueColor implements Runnable {
  private int modFps;
  private int blueColor = 150;

  public BlueColor(int modFps) {
    this.modFps = modFps;
  }

  public int getBlueColor() {
    return blueColor;
  }

  @Override
  public void run() {
      byte step = 1;
    while (true) {
      int tempColor = blueColor + step;
      if (tempColor > 255) {
        tempColor = 255;
        step *= -1;
      }
      if (tempColor < 0) {
        tempColor = 0;
        step *= -1;
      }
      blueColor = tempColor;
      try {
        TimeUnit.MILLISECONDS.sleep(AppVsBackground.fps - modFps);
      } catch (Exception ex) {
      }
    }
  }
}
