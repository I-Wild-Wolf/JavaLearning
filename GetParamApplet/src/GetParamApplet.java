import java.applet.Applet;
import java.awt.*;

public class GetParamApplet extends Applet {
    String parmTextString = "Param string";
    String parmTextFont = "Helvetica";
    String parmFontSize = "24";
    int nFontSize = 24;

    public void init() {
        String parm;
        parm = getParameter("TextString");
        if (parm != null) parmTextString = parm;
        parm = getParameter("TextFont");
        if (parm != null) parmTextFont = parm;
        parm = getParameter("FontSize");
        if (parm != null) parmFontSize = parm;
        try {
            Integer intVal = new Integer(parmFontSize);
            nFontSize = intVal.intValue();
        } catch (Exception ex) {
        }
        setBackground(Color.yellow);
        setForeground(Color.black);
    }

    public String getAppletInfo() {
        return "Name: Get Parameter Applet";
    }

    public String[][] getParameterInfo() {
        String[][] paramInfo = {{"TextString", "String", "Param string"}, {"TextFont", "String", "Helvetica"}, {"FontSize", "String", "24"}};
        return paramInfo;
    }

    public void paint(Graphics g) {
        int yStart = 20;
        int yCurrent = yStart;
        g.setColor(Color.red);
        g.setFont(new Font(parmTextFont, Font.PLAIN, nFontSize));
        FontMetrics fm = g.getFontMetrics();
        g.drawString("TextString: " + parmTextString, 10, yCurrent);
        yCurrent += fm.getHeight();
        g.drawString("TextFont: " + parmTextFont, 10, yCurrent);
        yCurrent += fm.getHeight();
        g.drawString("FontSize: " + nFontSize, 10, yCurrent);
    }
}