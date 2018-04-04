import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UInput implements Runnable {
    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (!Thread.currentThread().isInterrupted()) {
                if (reader.readLine().equalsIgnoreCase("stop")) {
                    AppVsBackground.isStopped = true;
                    Thread.currentThread().interrupt();
                }
            }
            reader.close();
        } catch (IOException ex) {
        }
    }
}
