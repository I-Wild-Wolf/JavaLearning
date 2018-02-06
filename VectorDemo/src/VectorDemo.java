import java.util.StringTokenizer;
import java.util.Vector;

public class VectorDemo {
    public static void main(String args[]) {
        Vector vPoints = new Vector();
        String szStr;
        byte bKbd[] = new byte[256];
        StringTokenizer st;
        int i, j = 0;

        System.out.println("Enter initial number of elements: ");

        try {
            int iCnt = System.in.read(bKbd);
            szStr = new String(bKbd, 0, iCnt);
            st = new StringTokenizer(szStr, "\r\n");
            szStr = new String((String) st.nextElement());

            Integer intVal = new Integer(szStr);
            j = intVal.intValue();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

        for (i = 0; i < j; i++) {
            vPoints.addElement(new MyPoint(i, i + 10));
        }

        try {
            vPoints.insertElementAt(new MyPoint(2000, 2000), 2);
            vPoints.setElementAt(new MyPoint(3000, 3000), 3);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        for (i = 0; i < vPoints.size(); i++) {
            MyPoint mpt;
            mpt = (MyPoint) vPoints.elementAt(i);
            mpt.printPoint();
        }
    }
}

class MyPoint {
    private int m_x = 0, m_y = 0;

    MyPoint(int ix, int iy) {
        m_x = ix;
        m_y = iy;
    }

    public void setPoint(int ix, int iy) {
        m_x = ix;
        m_y = iy;
    }

    public void printPoint() {
        System.out.println("Point: (" + m_x + "," + m_y + ")");
    }
}
