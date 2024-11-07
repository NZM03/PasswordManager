# PasswordManager


The Password Manager with MFA is a Java program for user registration and secure login with Multi-Factor Authentication (MFA), adding an extra layer of security.

# Features:

- User registration with password storage.

- User login with MFA code verification.

- MFA code generation simulated as being sent via SMS/email.

# How to Run

Prerequisites:

- Java Development Kit (JDK) 8 or higher.

- An IDE or command-line environment.

# Compilation:

bash

Copy code
javac PasswordManagerWithMFA.java

Execution:

bash

Copy code
java PasswordManagerWithMFA

# Code Explanation:

- registerUser: Registers and stores user credentials.

- loginUser: Validates credentials and triggers MFA.

- generateMFA: Creates a 6-digit code.

- validateMFA: Verifies the code entered by the user.

# Customization:

- Integrate actual SMS/email services for sending MFA codes.

- Store user data persistently using files or databases.

# Limitations:

- MFA is simulated by printing the code to the console.

- User data is stored in-memory and not saved after the program ends.
