package Utilities;

import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordUtil {
    private static final String ALLOWED_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_+=<>?/";
    Scanner scan = new Scanner(System.in);

    public int requestPasswordLength() {
        System.out.print("How many characters does your password need to be? ");
        return validatePasswordLength();
    }

    private int validatePasswordLength() {
        int passwordLength;

        while (true) {
            if (scan.hasNextInt()) {
                passwordLength = scan.nextInt();

                if (passwordLength <= 0)
                    System.out.println("Password length must be greater than 0 characters. Try again.\n");
                else
                    return passwordLength;
            }
            else {
                System.out.println("Invalid input. Please enter a valid number.\n");
                scan.next();
            }

            System.out.print("How many characters does your password need to be? ");
        }
    }

    public String generatePassword(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(ALLOWED_CHARACTERS.length());
            password.append(ALLOWED_CHARACTERS.charAt(index));
        }

        return password.toString();
    }
}
