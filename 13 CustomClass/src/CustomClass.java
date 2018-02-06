public class CustomClass {
    public static void main(String args[]) {
        MyRect rect = new MyRect(0, 0, 10, 20);
        String szStr = rect.toString();
        System.out.println(szStr);

        rect.setMyRect(100, 200, 300, 400);
        szStr = rect.toString();
        System.out.println(szStr);

        MyCircle circle = new MyCircle();
        System.out.println(circle.toString());
        circle.setMyCircle(100, 100, 25, "green");
        System.out.println(circle.toString());
    }
}

class MyRect {
    protected int x1;
    protected int y1;
    protected int x2;
    protected int y2;

    MyRect(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void setMyRect(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public String toString() {
        String sz = "Object MyRect: (" + x1 + ", " + y1 + ", " + x2 + ", " + y2 + ")";
        return sz;
    }
}

class MyCircle {
    private int x1, y1, radius;
    private String fillColor;

    MyCircle () {
        this.x1 = 0;
        this.y1 = 0;
        this.radius = 10;
        this.fillColor = "red";
    }

    MyCircle(int x1, int y1, int radius, String fillColor) {
        this.x1 = x1;
        this.y1 = y1;
        this.radius = radius;
        this.fillColor = fillColor;
    }

    public void setMyCircle(int x1, int y1, int radius, String fillColor) {
        this.x1 = x1;
        this.y1 = y1;
        this.radius = radius;
        this.fillColor = fillColor;
    }

    public String getFillColor() {
        return fillColor;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        String str = "Circle parameters: (x1 = " + this.x1 + ", y1 = " + this.y1 + ", radius = " + this.radius + ", Color = " + this.fillColor + ")";
        return str;
    }
}