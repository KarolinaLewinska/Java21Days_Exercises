package java21.com;

public class Main {

    public static void main(String[] args) {
        ZipCode zip1 = new ZipCode("90-332");
        zip1.validateZipCode();
        ZipCode zip2 = new ZipCode(("33"));
        zip2.validateZipCode();
    }
}
