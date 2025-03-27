package Utilities;

import java.util.Scanner;

public class BaseUtil {
    Scanner scan = new Scanner(System.in);

    public int requestLength() {
        System.out.print("How many characters? ");
        return validateLength();
    }

    public int validateLength() {
        int length;

        while (true) {
            if (scan.hasNextInt()) {
                length = scan.nextInt();

                if (length <= 0)
                    System.out.println("Length must be greater than 0 characters. Try again.\n");
                else
                    return length;
            }
            else {
                System.out.println("Invalid input. Please enter a valid number.\n");
                scan.next();
            }

            System.out.print("How many characters? ");
        }
    }
}
