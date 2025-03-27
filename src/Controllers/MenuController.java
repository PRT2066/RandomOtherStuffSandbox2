package Controllers;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuController {

    private static final Scanner scan = new Scanner(System.in);

    // Programs
    private static final Map<Integer, PopulateMenuOption> menuOptions = new LinkedHashMap<>();
    static {
        menuOptions.put(1, new PopulateMenuOption("Password Generator", new PasswordController()));
        menuOptions.put(2, new PopulateMenuOption("Exit Program", new ExitController()));
    }

    private static void outputMenuOptions() {
        for (Map.Entry<Integer, PopulateMenuOption> entry : menuOptions.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().name());
        }
    }

    private record PopulateMenuOption(String name, BaseController action) {
        void execute() {
            action.execute();
        }
    }

    public static void menuSelect() {
        System.out.println();
        while (true) {
            System.out.println("The following utilities are available");
            System.out.println("-------------------------------------");
            outputMenuOptions();
            System.out.print("\nPlease enter your choice: ");

            if (!scan.hasNextInt()) {
                System.out.println("Only numbers are accepted.\n");
                scan.next();
                continue;
            }

            int choice = scan.nextInt();
            if (!menuOptions.containsKey(choice)) {
                System.out.println("Invalid choice. Only 1 thru " + menuOptions.size() + " are accepted.\n");
                continue;
            }

            System.out.println();
            PopulateMenuOption selectedOption = menuOptions.get(choice);
            selectedOption.execute();

            if (selectedOption.action() instanceof ExitController) {
                break;
            }

            System.out.println("\nReturning to main menu...\n");
        }
    }
}
