package java21.com;


public class Main {

    public static void main(String[] args) {
        StoreFront store = new StoreFront();
        store.addItem("C01", "KUBEK", "9.99", "150");
        store.addItem("C02", "DUŻY KUBEK", "12.99", "82");
        store.addItem("C03", "PODKŁADKA", "10.49", "800");
        store.addItem("D01", "KOSZULKA", "16.99", "90");
        store.sort();

        for (int i = 0; i < store.getSize(); i++) {
            Item show = (Item) store.getItem(i);
            System.out.println("\nIdentyfikator elementu: " + show.getId() +
                    "\nNazwa: " + show.getName() +
                    "\nCena sprzedaży: " + show.getRetail() + " zł" +
                    "\nCena: " + show.getPrice() + " zł" +
                    "\nSztuk: " + show.getQuantity());
        }
    }
}
