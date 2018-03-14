public class Number7 {
    public static void main (String args[]) {
        for(double x = -4; x <= 4; x+= 0.5) {
            double y = (0.5 * Math.pow(x, 2)) - (7 * x);
            System.out.println("x:" + x + ", y:" + y + "; ");
        }
    }
}
