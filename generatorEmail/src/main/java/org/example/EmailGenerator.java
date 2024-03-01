package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class EmailGenerator {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя файла с данными: ");
        String fileName = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                String lastName = data[0];
                String firstName = data[1];
                String department = data[2];
                String company = data[3];

                String email = lastName.toLowerCase() + "." + firstName.toLowerCase() + "@" + department.toLowerCase() + "." + company.toLowerCase();
                System.out.println("Email: " + email);

                String password = generatePassword();
                System.out.println("Password: " + password);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла");
        }
    }

    private static String generatePassword() {
        String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int index = (int) (Math.random() * symbols.length());
            password.append(symbols.charAt(index));
        }
        return password.toString();
    }
}


/*package org.example;

import java.util.Random;

public class CorporateEmailGenerator {

    private String lastName;
    private String firstName;
    private String department;
    private String company;

    public CorporateEmailGenerator(String lastName, String firstName, String department, String company) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.department = department;
        this.company = company;
    }

    private String generateRandomPassword() {
        String passwordChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
        StringBuilder password = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(passwordChars.length());
            password.append(passwordChars.charAt(index));
        }
        return password.toString();
    }

    public String generateEmail() {
        String email = lastName.toLowerCase() + "." + firstName.toLowerCase() + "@" + department.toLowerCase() + "." + company.toLowerCase() + " ";
        String password = generateRandomPassword();

        return "Email: " + email + "Password: " + password;
    }

    public static void main(String[] args) {
        CorporateEmailGenerator generator = new CorporateEmailGenerator("Smith", "John", "sales", "salescompany");
        System.out.println(generator.generateEmail());
    }
}*/

