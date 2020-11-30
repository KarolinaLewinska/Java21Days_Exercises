package java21.com;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        FourDPoint point = new FourDPoint(2,8,12,20);
        System.out.println("Wartość punktów: ");
        System.out.println("x= " + point.x);
        System.out.println("y= " + point.y);
        System.out.println("x2= " + point.x2);
        System.out.println("y2= " + point.y2);
    }
}

class FourDPoint extends Point {
    int x2;
    int y2;
    public FourDPoint(int x, int y, int x2, int y2 ) {
        super(x,y);
        this.x2 = x2;
        this.y2 = y2;
    }
}
