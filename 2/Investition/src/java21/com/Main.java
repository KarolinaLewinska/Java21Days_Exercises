package java21.com;

public class Main {

    public static void main(String[] args) {
        Investition investition1 = new Investition();
        investition1.sum = 14_000;
        investition1.firstYear = 14_000 + (0.4 * 14_000);
        investition1.secondYear = investition1.firstYear - 1500;
        investition1.thirdYear = investition1.secondYear + (investition1.secondYear * 0.12);
        investition1.showResult();
    }
}
