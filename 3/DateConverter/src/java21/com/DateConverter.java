package java21.com;

import java.util.Scanner;
import java.util.StringTokenizer;

public class DateConverter {
    public void converter() {
        System.out.println("Podaj datę w formacie DD/MM/RRRR");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        StringTokenizer dateConverter = new StringTokenizer(userInput, "/");
        System.out.println("Dzień: " + dateConverter.nextToken());
        System.out.println("Miesiąc: " + dateConverter.nextToken());
        System.out.println("Rok: " + dateConverter.nextToken());
    }
}
