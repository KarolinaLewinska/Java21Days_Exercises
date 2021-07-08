package java21.com;

public class Item implements Comparable {
    private String id, name;
    private double retail, price;
    private int quantity;
    private boolean noDiscount;

    Item(String idIn, String nameIn, String retailIn, String qIn, String discountIn) {
        id = idIn;
        name = nameIn;
        retail = Double.parseDouble(retailIn);
        quantity = Integer.parseInt(qIn);
        noDiscount = discountIn.equals("tak");

        if (quantity > 400)
            price = retail * .5D;
        else if (quantity > 200)
            price = retail * .6D;
        else
            price = retail * .7D;
        
        price = Math.floor(price * 100 + .5) / 100;
        if (noDiscount)
            price = retail;
    }

    public int compareTo(Object obj) {
        Item temp = (Item) obj;
        if (this.price < temp.price) {
            return 1;
        } else if (this.price > temp.price) {
            return -1;
        }
        return 0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getRetail() {
        return retail;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
