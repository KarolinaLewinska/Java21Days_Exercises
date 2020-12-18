package java21.com;

public class PrimeThreads {

    public static void main(String[] arguments) {
        try {
            PrimeFinder[] finder = new PrimeFinder[arguments.length];
            for (int i = 0; i < arguments.length; i++) {
                long count = Long.parseLong(arguments[i]);
                finder[i] = new PrimeFinder(count);
                System.out.println("Szukam liczby pierwszej " + count);
            }
            boolean complete = false;
            while (!complete) {
                complete = true;
                for (int j = 0; j < finder.length; j++) {
                    if (!finder[j].finished)
                        complete = false;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {

                }
            }
            for (int j = 0; j < finder.length; j++) {
                System.out.println("Liczba pierwsza " + finder[j].target
                        + " to " + finder[j].prime);
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Błąd: " + nfe.getMessage());
        } catch (NegativeNumberException nne) {
            System.out.println("Błąd: " + nne.getMessage());
        }
    }

    public PrimeThreads(String[] arguments) {
        PrimeFinder[] finder = new PrimeFinder[arguments.length];
        for (int i = 0; i < arguments.length; i++) {
            try {
                long count = Long.parseLong(arguments[i]);
                finder[i] = new PrimeFinder(count);
                System.out.println("Szukam liczby pierwszej " + count);
            } catch (NumberFormatException | NegativeNumberException nfe) {
                System.out.println("Błąd: " + nfe.getMessage());
            }
        }
        boolean complete = false;
        while (!complete) {
            complete = true;
            for (int j = 0; j < finder.length; j++) {
                if (finder[j] == null) continue;
                if (!finder[j].finished) {
                    complete = false;
                } else {
                    displayResult(finder[j]);
                    finder[j] = null;
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {

            }

        }
    }

    private void displayResult(PrimeFinder finder) {
        System.out.println("Liczba pierwsza " + finder.target
                + " to " + finder.prime);
    }
}
