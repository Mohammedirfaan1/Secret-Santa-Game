package com.Acme.SecretSanta.test;


import com.Acme.SecretSanta.model.Employee;
import com.Acme.SecretSanta.service.FileHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileHandlerTest {

    private FileHandler fileHandler;
    private String testFilePath;

    @BeforeEach
    public void setUp() {
        fileHandler = new FileHandler();
        testFilePath = "src/test/resources/test_employees.csv"; // Example test CSV path
    }

    @Test
    public void testReadEmployees() throws IOException {
        // Create a temporary test file for employees
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFilePath))) {
            writer.write("Employee Name,Employee Email\n");
            writer.write("John Doe,john.doe@example.com\n");
            writer.write("Jane Smith,jane.smith@example.com\n");
        }

        // Read the employees from the file
        List<Employee> employees = fileHandler.readEmployees(testFilePath);
        assertNotNull(employees);
        assertEquals(2, employees.size());

        // Verify the content
        assertEquals("John Doe", employees.get(0).getName());
        assertEquals("john.doe@example.com", employees.get(0).getEmail());
    }

    @Test
    public void testReadPreviousAssignments() throws IOException {
        // Create a test CSV for previous assignments
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFilePath))) {
            writer.write("Employee Name,Employee Email,Secret Child Name,Secret Child Email\n");
            writer.write("John Doe,john.doe@example.com,Jane Smith,jane.smith@example.com\n");
        }

        // Read previous assignments from file
        var previousAssignments = fileHandler.readPreviousAssignments(testFilePath);
        assertNotNull(previousAssignments);
        assertEquals(1, previousAssignments.size());
        assertEquals("jane.smith@example.com", previousAssignments.get("john.doe@example.com"));
    }

    @Test
    public void testWriteAssignments() throws IOException {
        // Create output test file path
        String outputFile = "src/test/resources/output.csv";
        List<String> outputLines = List.of(
                "Employee_Name,Employee_EmailID,Secret_Child_Name,Secret_Child_EmailID",
                "John Doe,john.doe@example.com,Jane Smith,jane.smith@example.com"
        );

        // Write the assignments to the file
        fileHandler.writeAssignments(outputFile, outputLines);

        // Verify if file was created and contains expected data
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            String firstLine = reader.readLine();
            assertEquals("Employee_Name,Employee_EmailID,Secret_Child_Name,Secret_Child_EmailID", firstLine);

            String secondLine = reader.readLine();
            assertEquals("John Doe,john.doe@example.com,Jane Smith,jane.smith@example.com", secondLine);
        }
    }
}

