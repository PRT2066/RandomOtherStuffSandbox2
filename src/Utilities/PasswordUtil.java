package Utilities;

import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordUtil {
    private static final String ALLOWED_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_+=<>?/";

    public int requestPasswordLength() {
        Scanner scan = new Scanner(System.in);
        int passwordLength = -1;

        while (passwordLength <= 0) {
            System.out.print("How many characters does your password need to be? ");

            if (scan.hasNextInt()) {
                passwordLength = scan.nextInt();

                if (passwordLength <= 0)
                    System.out.println("Password length must be greater than 0 characters. Try again.");
            } else {
                System.out.println("Invalid input. Please enter a valid number.\n");
                scan.next();
            }
        }

        return passwordLength;
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
