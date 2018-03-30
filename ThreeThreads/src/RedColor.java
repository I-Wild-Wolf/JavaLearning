import java.util.concurrent.TimeUnit;

public class RedColor implements Runnable {
  private int rateOfChanging;
  private int redColor = 0;

  public RedColor(int rateOfChanging) {
    this.rateOfChanging = rateOfChanging;
  }

  public int getRedColor() {
    return redColor;
  }

  @Override
  public void run() {
    while (true) {
      int tempColor = redColor + rateOfChanging;
      if (redColor > 245) {
        tempColor = 245;
        rateOfChanging *= -1;
      }
      if (redColor < 10) {
        tempColor = 10;
        rateOfChanging *= -1;
      }
      redColor = tempColor;
      try {
        TimeUnit.MILLISECONDS.sleep(50);
      } catch (Exception ex) {
      }
    }
  }
}
