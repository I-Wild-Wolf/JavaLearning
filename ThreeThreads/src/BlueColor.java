import java.util.concurrent.TimeUnit;

public class BlueColor implements Runnable {
  private int rateOfChanging;
  private int blueColor = 0;

  public BlueColor(int rateOfChanging) {
    this.rateOfChanging = rateOfChanging;
  }

  public int getBlueColor() {
    return blueColor;
  }

  @Override
  public void run() {
    while (true) {
      int tempColor = blueColor + rateOfChanging;
      if (blueColor > 245) {
        tempColor = 245;
        rateOfChanging *= -1;
      }
      if (blueColor < 10) {
        tempColor = 10;
        rateOfChanging *= -1;
      }
      blueColor = tempColor;
      try {
        TimeUnit.MILLISECONDS.sleep(50);
      } catch (Exception ex) {
      }
    }
  }
}
