import java.awt.*;

class TextAutoScroller extends Panel implements Runnable {
    Thread tiktakThread = null;
    String ScrollingText;
    int delay = 10;
    Dimension dimMinSize;
    Font fnt;


    public TextAutoScroller(String s, Graphics g) {
        ScrollingText = s;

        fnt = new Font("Helvetica", Font.BOLD, 24);
        g.setFont(fnt);

        FontMetrics fm = g.getFontMetrics();
        int nTitileWidth =
                fm.stringWidth(ScrollingText);
        int nTitleHeight = fm.getAscent() -
                fm.getLeading() - fm.getDescent();

        int nWindowWidth = nTitileWidth + 20;
        int nWindowHeight = nTitleHeight + 20;

        dimMinSize = new Dimension(
                nWindowWidth, nWindowHeight);
    }


    public void setDelay(int d) {
        delay = d;
    }


    public void setFont(Font f) {
        fnt = f;
    }


    public void setText(String s) {
        ScrollingText = s;
    }


    public void paint(Graphics g) {
        dimMinSize = getSize();
    }


    public void start() {
        if (tiktakThread == null) {
            tiktakThread = new Thread(this);
            tiktakThread.start();
        }
    }


    public void stop() {
        if (tiktakThread != null) {
            tiktakThread.stop();
            tiktakThread = null;
        }
    }

    public void run() {
        int nCurrentChar = 0;

        Graphics g = getGraphics();
        g.setFont(fnt);
        FontMetrics fm = g.getFontMetrics();

        int nMaxCharWidth = fm.charWidth('W') + 5;
        int yPos = fm.getHeight() + 5;
        int nCurrentCharWidth;

        int rColor = (int) (255 * Math.random());
        int gColor = (int) (255 * Math.random());
        int bColor = (int) (255 * Math.random());
        g.setColor(new Color(rColor, gColor, bColor));

        while (true) {
            try {
                try {
                    nCurrentCharWidth =
                            fm.charWidth(ScrollingText.charAt(
                                    nCurrentChar));

                    char[] ch;
                    String s;
                    ch = new char[1];
                    ch[0] =
                            ScrollingText.charAt(nCurrentChar);
                    s = new String(ch);

                    g.drawString(s,
                            dimMinSize.width - nMaxCharWidth,
                            yPos);

                    nCurrentChar++;

                    for (
                            int i = 0; i < nCurrentCharWidth;
                            i++) {
                        g.copyArea(nMaxCharWidth / 2, 0,
                                dimMinSize.width -
                                        nMaxCharWidth +
                                        nCurrentCharWidth - i,
                                dimMinSize.height,
                                -1, 0);

                        g.clearRect(
                                dimMinSize.width -
                                        nMaxCharWidth +
                                        nCurrentCharWidth - i + 1, 0,
                                nMaxCharWidth,
                                dimMinSize.height);

                        Thread.sleep(delay);
                    }
                } catch (
                        StringIndexOutOfBoundsException e) {
                    nCurrentChar = 0;

                    rColor = (int) (255 * Math.random());
                    gColor = (int) (255 * Math.random());
                    bColor = (int) (255 * Math.random());
                    g.setColor(
                            new Color(rColor, gColor, bColor));
                }
            } catch (InterruptedException e) {
                stop();
            }
        }
    }


    public Dimension getPreferredSize() {
        return dimMinSize;
    }

    public Dimension getMinimumSize() {
        return dimMinSize;
    }


    // preferredSize

    public Dimension preferredSize() {
        return dimMinSize;
    }


    public Dimension minimumSize() {
        return dimMinSize;
    }
}