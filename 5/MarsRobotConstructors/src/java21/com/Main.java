package java21.com;

public class Main {

    public static void main(String[] args) {
        MarsRobot robot1 = new MarsRobot();
        MarsRobot robot2 = new MarsRobot("w drodze",30,-20);
        MarsRobot robot3 = new MarsRobot("w spoczynku");

        System.out.println("Pierwszy robot: ");
        robot1.showAttributes();
        robot1.checkTemperature();
        System.out.println("Drugi robot: ");
        robot2.showAttributes();
        robot2.checkTemperature();
        System.out.println("Trzeci robot: ");
        robot3.showAttributes();
        robot3.checkTemperature();

    }
}
class MarsRobot {
    public MarsRobot(String status, int speed, float temperature) {
        this.status = status;
        this.speed = speed;
        this.temperature = temperature;
    }
    public MarsRobot(){

    }
    public MarsRobot(String status){
        this.status = status;
    }

    String status = "eksploracja";
    int speed = 12;
    float temperature = -50;

    void checkTemperature() {
        if (temperature < -80) {
            status = "powrót do domu";
            speed = 5;
        }
    }

    void showAttributes() {
        System.out.println("Status: " + status);
        System.out.println("Prędkość: " + speed);
        System.out.println("Temperatura: " + temperature);
    }
}
