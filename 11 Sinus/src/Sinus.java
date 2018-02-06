import java.applet.*;
import java.awt.*;

public class Sinus extends Applet {

    // write your code here
    DrawSinus m_DrawSinusThread = null;

    public String getAppletInfo () {
        return "Name: Rectangles";
    }

    public void paint (Graphics g){
        Dimension dimAppWndDimension = size();

        g.setColor(Color.yellow);
        g.fillRect(0, 0, dimAppWndDimension.width - 1, dimAppWndDimension.height - 1);

        g.setColor(Color.black);
        g.drawRect(0, 0, dimAppWndDimension.width - 1, dimAppWndDimension.height - 1);
    }

    public void start () {
        if (m_DrawSinusThread == null) {
            m_DrawSinusThread = new DrawSinus(this);
            m_DrawSinusThread.start();
        }
    }

    public void stop () {
        if (m_DrawSinusThread != null) {
            m_DrawSinusThread.stop();
            m_DrawSinusThread = null;
        }
    }

}

class DrawSinus extends Thread {
    Graphics g;
    Dimension dimAppWndDimension;

    public DrawSinus(Applet Appl) {
        g = Appl.getGraphics();
        dimAppWndDimension = Appl.size();
    }

    public void run() {

        while (true) {
            int nPoints = dimAppWndDimension.width;
            int[] xPoints = new int[nPoints];
            int[] yPoints = new int[nPoints];
            int rColor, gColor, bColor;

            int maxAngle = (int) ((30 * Math.PI) * Math.random());

            int Amplitude = (int) (dimAppWndDimension.height * Math.random());

            int Offset = (int) (dimAppWndDimension.height * Math.random());

            double deltaFi = (Math.PI / 2) * Math.random();

            for (int i = 0; i < nPoints; i++) {
                xPoints[i] = i;
                yPoints[i] = Offset + (int) (Amplitude * Math.sin(deltaFi + (double) (maxAngle * i) / nPoints));
            }

            rColor = (int) (255 * Math.random());
            gColor = (int) (255 * Math.random());
            bColor = (int) (255 * Math.random());
            g.setColor(new Color(rColor, gColor, bColor));

            g.fillPolygon(xPoints, yPoints, nPoints);

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                stop();
            }
        }
    }

}
