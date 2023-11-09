import java.util.Scanner;
import static java.lang.System.*;


public class CarGame {
    private Car car;
    private final Scanner sc = new Scanner(in);

    private void setUp(){
        out.println("Enter 'V' for Volvo240 or 'S' for Saab95");
        String choice = sc.nextLine();

        if (choice.equals("V")){
            car = new Volvo240();
        } else if (choice.equals("S")) {
            car = new Saab95();
        }
        this.printCarDetails();
        this.printInstructions();
    }

    private void printCarDetails(){
        out.println("You have chosen " + car.modelName);
        out.println("Number of doors: " + car.getNrDoors());
        out.println("Color of Car: " + car.getColor().toString());
        out.println("Engine power: " + car.getEnginePower());
        out.println();
    }

    private void printInstructions(){
        out.println("Enter 'G' followed by a space followed by a value between 0 and 1 to gas");
        out.println("Enter 'B' followed by a space followed by a value between 0 and 1 to break");
        out.println("Enter 'M' to move forwards");
        out.println("Enter 'L' to turn left");
        out.println("Enter 'R' to turn right");
        out.println("Enter 'Off' to turn off engine");
        out.println("Enter 'On' to turn on engine");
        if (car.modelName.equals("Saab95")){
            out.println("Enter 'T' to turn on turbo");
            out.println("Enter 'Toff' to turn on turbo");
        }
        out.println();
    }

    private void printStatus(){
        out.println("Current coordinates: x: " + car.getXPosition());
    }

    private void runGameLoop(){

    }

    public static void main(String[] args){
        CarGame game = new CarGame();
        game.setUp();
        game.runGameLoop();
    }
}
