package emailApp;

import java.util.Scanner;

public class email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 15;
    private String alternativeEmail;
    private String companySuffix = "Devway";

    // Constructor

    public email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email Created: " + this.firstName + " " + this.lastName);
        // Call the setDepartment Method
        this.department = setDepartment();
        System.out.println("Department: " + this.department);
        //Call the method randomPassword
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your randon Generated password is: " + this.password);
        // create am email the first name and the last name plus the department
        email = (this.firstName + "." +this.lastName + "@" + this.department + "." + companySuffix + ".com").toLowerCase();
        System.out.println("Your email is the following: " + email);
    }

    private String setDepartment() {
        System.out.print("Enter the department code:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nDepartment Code is: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "Sales";
        } else if (depChoice == 2) {
            return "Development";
        } else if (depChoice == 3) {
            return "Accounting";
        } else {
            return "";
        }
    }
    private String randomPassword(int length){
        String passwordSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%&";
        char[] password = new char[length];
        for (int i=0; i < length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }
    public void setAlternateEmail(String altEmail){
        this.alternativeEmail = altEmail;
    }
    public void changePassword(String password){
        this.password = password;
    }
    public int getMailboxCapacity(){return mailboxCapacity;}
    public String getAlternateEmail(){return alternativeEmail;}
    public String getPassword(){return password;}

    public String showInfo(){
        return  "Please read your your info below:\n " +
                "Your full name is: " + firstName + " " + lastName +
                "\nYour email address is: " + email +
                "\nYour mail capacity is: " + mailboxCapacity + "mb";
    }
}