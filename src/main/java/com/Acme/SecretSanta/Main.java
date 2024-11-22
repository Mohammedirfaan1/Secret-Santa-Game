package com.Acme.SecretSanta;

import com.Acme.SecretSanta.model.Assignment;
import com.Acme.SecretSanta.model.Employee;
import com.Acme.SecretSanta.service.FileHandler;
import com.Acme.SecretSanta.service.SecretSantaService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Main entry point for the Secret Santa application.
 * This program generates Secret Santa assignments for employees, considering previous year's assignments.
 */
public class Main {
    public static void main(String[] args) {
        // Define the file paths for the current year and previous year CSV files, and the output file.
        String currentYearFile = "src/main/resources/current_year.csv";
        String previousYearFile = "src/main/resources/previous_year.csv";
        String outputFile = "src/main/resources/output.csv"; // Path for the generated output CSV file

        // Create instances of the FileHandler and SecretSantaService classes
        FileHandler fileHandler = new FileHandler();
        SecretSantaService santaService = new SecretSantaService();

        try {
            // Read the current year employee data from the input CSV file
            List<Employee> employees = fileHandler.readEmployees(currentYearFile);

            // Read previous year's assignments from the input CSV file
            Map<String, String> previousAssignments = fileHandler.readPreviousAssignments(previousYearFile);

            // Generate Secret Santa assignments based on the provided data and constraints
            List<Assignment> assignments = santaService.generateAssignments(employees, previousAssignments);

            // Prepare the output data to be written to the CSV file
            List<String> outputLines = new ArrayList<>();
            outputLines.add("Employee_Name,Employee_EmailID,Secret_Child_Name,Secret_Child_EmailID"); // Add CSV header

            System.out.println("Assignments generated: ");
            // Iterate over the generated assignments and print them to the console and add them to the output list
            for (Assignment assignment : assignments) {
                // Print each assignment to the console (for confirmation)
                System.out.println(assignment.getEmployee().getName() + " -> " + assignment.getSecretChild().getName());

                // Add the assignment details to the list of output lines for CSV
                outputLines.add(
                        assignment.getEmployee().getName() + "," +
                                assignment.getEmployee().getEmail() + "," +
                                assignment.getSecretChild().getName() + "," +
                                assignment.getSecretChild().getEmail()
                );
            }

            // Write the generated assignments to the output CSV file
            fileHandler.writeAssignments(outputFile, outputLines);

            // Confirm the successful writing of assignments to the output file
            System.out.println("Secret Santa assignments successfully written to: " + outputFile);
        } catch (IOException e) {
            // Handle exceptions related to file reading or writing
            System.err.println("Error reading or writing files: " + e.getMessage());
        } catch (RuntimeException e) {
            // Handle exceptions related to the assignment generation (e.g., if no valid assignment can be made)
            System.err.println("Error generating assignments: " + e.getMessage());
        }
    }
}
