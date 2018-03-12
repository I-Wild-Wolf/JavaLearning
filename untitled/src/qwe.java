
public class ConsFrame {
    public static void main(String args[]) {
        FrameWindow frame;
        frame = new FrameWindow("Frame window");
        frame.show();
    }
}

class FrameWindow extends Frame {
    public FrameWindow(String szTitle) {
        super(szTitle);
        resize(200, 90);
        setBackground(Color.yellow);
        setForeground(Color.black);
    }

    public void paint(Graphics g) {
        g.setFont(new Font("Helvetica", Font.PLAIN, 12));
        g.drawString("Text in frame window", 10, 50);
        super.paint(g);
    }

    public boolean handleEvent(Event evt) {
        if (evt.id == Event.WINDOW_DESTROY) {
            setVisible(false);
            System.exit(0);
            return true;
        } else return super.handleEvent(evt);
    }
}