import java.util.concurrent.TimeUnit;

public class GreenColor implements Runnable {
  private int rateOfChanging;
  private int greenColor = 0;

  public GreenColor(int rateOfChanging) {
    this.rateOfChanging = rateOfChanging;
  }

  public int getGreenColor() {
    return greenColor;
  }

  @Override
  public void run() {
    while (true) {
      int tempColor = greenColor + rateOfChanging;
      if (greenColor > 245) {
        tempColor = 245;
        rateOfChanging *= -1;
      }
      if (greenColor < 10) {
        tempColor = 10;
        rateOfChanging *= -1;
      }
      greenColor = tempColor;
      try {
        TimeUnit.MILLISECONDS.sleep(50);
      } catch (Exception ex) {
      }
    }
  }
}


