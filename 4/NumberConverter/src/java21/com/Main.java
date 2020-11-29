package java21.com;
import static java21.com.Number.numberConverter;

public class Main {

    public static void main(String[] args) {
	numberConverter("sześć");
    }
}

class Number{
    public static void numberConverter(String liczbaSłownie) {

        switch(liczbaSłownie) {
            case "jeden":
                long jeden = 1;
                System.out.println(jeden);
                break;
            case "dwa":
                long dwa = 2;
                System.out.println(dwa);
                break;
            case "trzy":
                long trzy = 3;
                System.out.println(trzy);
                break;
            case "cztery":
                long cztery = 4;
                System.out.println(cztery);
                break;
            case "pięć":
                long pięć = 5;
                System.out.println(pięć);
                break;
            case "sześć":
                long sześć = 6;
                System.out.println(sześć);
                break;
            case "siedem":
                long siedem = 7;
                System.out.println(siedem);
                break;
            case "osiem":
                long osiem = 8;
                System.out.println(osiem);
                break;
            case "dziewięć":
                long dziewięć = 9;
                System.out.println(dziewięć);
                break;
            default:
                long dziesięć = 10;
                System.out.println(dziesięć);
        }
    }
}
