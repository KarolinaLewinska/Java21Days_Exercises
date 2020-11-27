package java21.com;

public class Wardrobe {
    int height;
    int weight;
    int depth;

    public Wardrobe(int height, int weight, int depth) {
        this.height = height;
        this.weight = weight;
        this.depth = depth;
    }

    public void showParameters() {
        System.out.println("Wysokość szafy: " + height);
        System.out.println("Waga szafy: " + weight);
        System.out.println("Głębokość szafy: " + depth);

    }
}
