public class MarsApplication {
    public static void main(String[] arguments) {
        MarsRobot spirit = new MarsRobot();
        spirit.status = "eksploracja";
        spirit.speed = 2;
        spirit.temperature = -60;

        spirit.showAttributes();
        System.out.println("Zwiększenie prędkości do 3");
        spirit.speed = 3;
        spirit.showAttributes();
        System.out.println("Zmiana temperatury do -90");
        spirit.temperature = -90;
        spirit.showAttributes();
        System.out.println("Sprawdzenie temperatury");
        spirit.checkTemperature();
        spirit.showAttributes();

        MarsRobot opportunity = new MarsRobot();
        opportunity.speed = 20;
        opportunity.temperature = -20;
        opportunity.status = "w spoczynku";
        System.out.println("");
        opportunity.checkTemperature();
        opportunity.showAttributes();
    }
}
