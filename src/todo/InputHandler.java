package todo;
import java.util.Scanner;
public class InputHandler
{
private Scanner scanner;
public InputHandler(){
    scanner = new Scanner(System.in);
}

public String getStringInput(String message){
    System.out.print(message);
    String input = scanner.nextLine();

    while (input.trim().length() == 0){
        System.out.println("Input cannot be empty.");
        System.out.print(message);
        input = scanner.nextLine();
    }
    return input;
}

public int getUserInput(String message, int min, int max){
    while (true){
        System.out.print(message);
        String input = scanner.nextLine();

        try
        {
            int number = Integer.parseInt(input);
            if (number >= min && number <= max){
                return number;
            }
        }
        catch (NumberFormatException e){
            System.out.println("Please enter a whole number.");
            continue;
        }
        System.out.println("Enter a number from " + min + " to " + max + ".");
    }
}

public double getHoursInput(String message){
    while (true){
        System.out.print(message);
        String input = scanner.nextLine();

        try
        {
            double hours = Double.parseDouble(input);
            if(!Double.isNaN(hours) && !Double.isInfinite(hours) && hours >= 0){
                return hours;
            }
        }
        catch (NumberFormatException e){
            System.out.println("Please enter a valid number.");
            continue;
        }
        System.out.println("Hours must be 0 or greater.");
    }
}

public boolean isValidPriority
}
