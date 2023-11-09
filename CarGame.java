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
        out.println("You have chosen the legendary" + car.modelName);
        out.println("Number of doors: " + car.getNrDoors());
        out.println("Color of Car: " + car.getColor().toString());
        out.println("Engine power: " + car.getEnginePower());
        out.println();
    }

    private void printInstructions(){
        out.println("Enter 'G' to gas");
        out.println("Enter 'B' to break");
        out.println("Enter 'M' to move forwards");
        out.println("Enter 'L' to turn left");
        out.println("Enter 'R' to turn right");
        out.println("Enter 'Off' to turn off engine");
        out.println("Enter 'On' to turn on engine");
        out.println("Enter 'I' to get info on your car");
        if (car.modelName.equals("Saab95")) {
            out.println("Enter 'T' to turn on turbo");
            out.println("Enter 'Toff' to turn on turbo");
        }
        out.println("Enter 'E' to exit game");
        out.println();
    }

    private void printStatus(){
        out.println("Current coordinates: x: " + car.getXPosition() + "  y: " + car.getYPosition());
        out.println("Facing direction: " + car.getDirection());
        out.println("With a current speed of : " + car.getCurrentSpeed());
    }

    private void askForAction(){
        out.println("Enter an action:");
    }

    private void askForValue(double min, double max){
        out.println("Enter a Value between " + min  + " and " + max);
    }

    private String getInput(){
        return sc.nextLine();
    }

    private void executeAction(String input){
        switch (input){
            case "G":
                this.askForValue(0.0, 1.0);
                double gasAmount = Double.parseDouble(this.getInput());
                car.gas(gasAmount);
                out.println("Car successfully accelerated");
                break;
            case "B":
                this.askForValue(0.0, 1.0);
                double breakAmount = Double.parseDouble(this.getInput());
                car.brake(breakAmount);
                out.println("Car successfully braked");
                break;
            case "M":
                car.move();
                break;
            case "L":
                car.turnLeft();
                break;
            case "R":
                car.turnRight();
                break;
            case "Off":
                car.stopEngine();
                break;
            case "On":
                car.startEngine();
                break;
            case "I":
                this.printCarDetails();
                break;
            case "T":
                if (car.modelName.equals("Saab95")) {
                   car.setTurboOn();
                }
                else {
                   out.println("This car has no Turbo!");
                }
                break;
            case "Toff":
                if (car.modelName.equals("Saab95")) {
                    car.setTurboOff();
                }
                else {
                    out.println("This car has no Turbo!");
                }
                break;
            default:
                out.println("Command not recognized!");
                this.printInstructions();
            }
        }


    private void runGameLoop(){
        while (true){
            this.printStatus();
            this.askForAction();
            String input = this.getInput();
            if (input.equals("E")){
                break;
            }
            this.executeAction(input);
        }
    }

    public static void main(String[] args){
        CarGame game = new CarGame();
        game.setUp();
        game.runGameLoop();
    }
}
