/*
 * Evan Robertson
 * PasswordApplication.java
 * October 24 2018
 * Program gets a password from user and stores to use for later
 */

package passwordapplication;

import java.util.Scanner;

/**
 *
 * @author evrob0095
 */
public class PasswordApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userInput;
        String username = "default";
        String password = "admin";
        int menu = 0;
        int passMenu = 0;
        int incorrectPass = 0;
        int accessDenied = 0;
        
        do {
        System.out.println("-----------------");
        System.out.println("Choose an option");
        System.out.println("1.  Sign up");
        System.out.println("2.  Log in");
        System.out.println("-----------------");
        menu = 1;
        userInput = input.nextLine();

        switch (userInput) {
            case "1":
                System.out.println("To sign up, first put in a user name");
                username = input.nextLine();
                System.out.println("Now type in your password");
                password = input.nextLine();
                System.out.println("Now you're ready to log in!");
                menu = 0;
                break;
            case "2":
                System.out.println("Please enter your user name");
                userInput = input.nextLine();
                if (userInput.equalsIgnoreCase(username) && accessDenied != 1) {
                    do {
                    System.out.println("Please enter your password (Case sensitive!)");
                    userInput = input.nextLine();
                    if (userInput.equals(password)) {
                        
                        System.out.println("Welcome!");
                        System.out.println("Would you like to change your password? (Yes / No)");
                        userInput = input.nextLine();
                        switch (userInput) {
                            case "Yes": case "yes":
                                System.out.println("Enter username");
                                userInput = input.nextLine();
                                if (userInput.equalsIgnoreCase(username)) {
                                    System.out.println("Now enter your current password");
                                    userInput = input.nextLine();
                                    if (userInput.equals(password)) {
                                        System.out.println("Now type in your new password");
                                        password = input.nextLine();
                                        System.out.println("Password has been changed");
                                        System.out.println("Signing out....");
                                        menu = 0;
                                    }
                                    else {
                                        System.out.println("Password was incorrect");
                                        System.out.println("Signing out....");
                                        menu = 0;
                                    }
                                }
                                else {
                                    System.out.println("Username incorrect");
                                    System.out.println("Signing out....");
                                    menu = 0;
                                }
                            default:
                                System.out.println("Ok enjoy this very blank account thingy");
                        
                        }
                        passMenu = 1;
                    }
                    else {
                        System.out.println("Password is incorect, please try again");
                        incorrectPass = incorrectPass + 1;
                        if (incorrectPass == 3) {
                            System.out.println("You have entered th eincorrect password 3 times.");
                            System.out.println("This account is now disabled");
                            accessDenied = 1;
                            passMenu = 1;
                            menu = 0;
                            
                        }
                    }
                    
                    } while (passMenu == 0);
                }
                else if (userInput.equalsIgnoreCase(username) && accessDenied == 1) {
                    System.out.println("Account is locked due to too many failed logins");
                    System.out.println("Please restart program");
                
                }
                else {
                    System.out.println("Username is not registered. Please register this user name by signing up");
                    System.out.println("Returning to menu....");
                    menu = 0;
                }
            
        }
        
        
        } while (menu == 0);
        
    }
    
}
