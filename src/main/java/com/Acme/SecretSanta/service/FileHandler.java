package com.Acme.SecretSanta.service;

import com.Acme.SecretSanta.model.Employee;

import java.io.*;
import java.util.*;

/**
 * Handles file-related operations such as reading employee data,
 * reading previous assignments, and writing assignments to files.
 */
public class FileHandler {

    /**
     * Reads the employee data from the specified CSV file.
     * The file should contain two columns: Employee_Name and Employee_EmailID.
     *
     * @param filePath The path to the CSV file containing employee information.
     * @return A list of Employee objects parsed from the file.
     * @throws IOException If there is an issue reading the file.
     */
    public List<Employee> readEmployees(String filePath) throws IOException {
        List<Employee> employees = new ArrayList<>();

        // Open the file and read its contents line by line
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // Skip the header row
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(","); // Split the line into name and email
                employees.add(new Employee(data[0].trim(), data[1].trim())); // Create and add Employee object
            }
        }

        return employees;
    }

    /**
     * Reads the previous year's Secret Santa assignments from the specified CSV file.
     * The file should contain the columns: Employee_Name, Employee_EmailID,
     * Secret_Child_Name, and Secret_Child_EmailID.
     *
     * @param filePath The path to the CSV file containing previous assignments.
     * @return A map where the key is the Employee_EmailID, and the value is the Secret_Child_EmailID.
     * @throws IOException If there is an issue reading the file.
     */
    public Map<String, String> readPreviousAssignments(String filePath) throws IOException {
        Map<String, String> previousAssignments = new HashMap<>();

        // Open the file and read its contents line by line
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // Skip the header row
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(","); // Split the line into respective fields
                previousAssignments.put(data[1].trim(), data[3].trim()); // Map Employee_EmailID -> Secret_Child_EmailID
            }
        }

        return previousAssignments;
    }

    /**
     * Writes the Secret Santa assignments to the specified CSV file.
     * Each line of the file corresponds to an assignment.
     *
     * @param filePath The path to the output file where assignments should be written.
     * @param data     A list of strings where each string represents an assignment in CSV format.
     * @throws IOException If there is an issue writing to the file.
     */
    public void writeAssignments(String filePath, List<String> data) throws IOException {
        // Open the file for writing
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : data) {
                bw.write(line);  // Write each line
                bw.newLine();    // Add a newline after each entry
            }
        }
    }
}
