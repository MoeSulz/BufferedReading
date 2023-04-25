package com.learntocode;

import java.io.*;

public class Payroll {
    public static void main(String[] args) throws IOException {
        String fileName = "EmployeeInfo.txt";
        FileWriter fileWriter = new FileWriter("inputInfo.txt");


     try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            BufferedWriter buffWriter = new BufferedWriter(fileWriter);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\\|");
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                Employee employee = new Employee(id, name, hoursWorked, payRate);

                String outputLine = String.format("{ \"id\": %d, \"name\": \"%s\", \"grossPay\": %.2f }%n",
                   employee.getEmployeeId(), employee.getName(), employee.getGrossPay());

                System.out.printf("Employee ID: %d, Name: %s, Gross Pay: $%.2f%n",
                        employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + fileName);
        }
    }

}