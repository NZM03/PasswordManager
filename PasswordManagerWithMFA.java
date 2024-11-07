package PManager;
import java.util.*;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

public class PasswordManagerWithMFA {

    private static final SecureRandom random = new SecureRandom();
    private static final Map<String, String> userPasswords = new HashMap<>();
    private static final Map<String, String> userMFACodes = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username;
        String password;

        while (true) {
            System.out.println("Choose an option: \n1. Register \n2. Login \n3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter a username: ");
                    username = scanner.nextLine();
                    System.out.print("Enter a password: ");
                    password = scanner.nextLine();
                    registerUser(username, password);
                    break;
                case 2:
                    System.out.print("Enter your username: ");
                    username = scanner.nextLine();
                    System.out.print("Enter your password: ");
                    password = scanner.nextLine();
                    loginUser(username, password, scanner);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void registerUser(String username, String password) {
        if (userPasswords.containsKey(username)) {
            System.out.println("Username already exists. Choose a different one.");
            return;
        }
        userPasswords.put(username, password);
        System.out.println("Registration successful! Your account is now secured.");
    }

    private static void loginUser(String username, String password, Scanner scanner) {
        if (!userPasswords.containsKey(username)) {
            System.out.println("Username not found.");
            return;
        }
        if (!userPasswords.get(username).equals(password)) {
            System.out.println("Incorrect password.");
            return;
        }
        System.out.println("Password correct. Proceeding with MFA.");

        // Generate and send MFA code
        String mfaCode = generateMFA();
        userMFACodes.put(username, mfaCode);
        System.out.println("MFA Code (sent via SMS/email simulation): " + mfaCode);

        // Ask for MFA code
        System.out.print("Enter the MFA code: ");
        String inputCode = scanner.nextLine();
        if (validateMFA(username, inputCode)) {
            System.out.println("Login successful! Access granted.");
        } else {
            System.out.println("Invalid MFA code. Access denied.");
        }
    }

    private static String generateMFA() {
        int code = 100000 + random.nextInt(900000);  // 6-digit code
        return String.valueOf(code);
    }

    private static boolean validateMFA(String username, String inputCode) {
        return userMFACodes.containsKey(username) && userMFACodes.get(username).equals(inputCode);
    }
}