import java.applet.Applet;
import java.awt.*;

public class JavaApplet extends Applet {
    String szAppName;

    public void init() {
        szAppName = new String("SimpleApplet");
        setBackground(Color.yellow);
        setForeground(Color.black);
    }

    public String getAppletInfo() {
        return "Name:" + szAppName;
    }

    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.setFont(new Font("Helvetica", Font.BOLD, 24));
        g.drawString("Applet " + szAppName, 10, 30);
    }
}
