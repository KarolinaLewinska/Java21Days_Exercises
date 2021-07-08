package java21.com;
import static java21.com.Number.numberConverter;

public class Main {

    public static void main(String[] args) {
	numberConverter("sześć");
    }
}

class Number {
    public static void numberConverter(String numberInWords) {

        switch(numberInWords) {
            case "jeden":
                long one = 1;
                System.out.println(one);
                break;
            case "dwa":
                long two = 2;
                System.out.println(two);
                break;
            case "trzy":
                long three = 3;
                System.out.println(three);
                break;
            case "cztery":
                long four = 4;
                System.out.println(four);
                break;
            case "pięć":
                long five = 5;
                System.out.println(five);
                break;
            case "sześć":
                long six = 6;
                System.out.println(six);
                break;
            case "siedem":
                long seven = 7;
                System.out.println(seven);
                break;
            case "osiem":
                long eight = 8;
                System.out.println(eight);
                break;
            case "dziewięć":
                long nine = 9;
                System.out.println(nine);
                break;
            default:
                long ten = 10;
                System.out.println(ten);
        }
    }
}
