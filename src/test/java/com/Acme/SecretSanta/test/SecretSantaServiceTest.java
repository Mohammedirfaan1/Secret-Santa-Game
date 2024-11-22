package com.Acme.SecretSanta.test;

import com.Acme.SecretSanta.model.Assignment;
import com.Acme.SecretSanta.model.Employee;
import com.Acme.SecretSanta.service.SecretSantaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class SecretSantaServiceTest {

    private SecretSantaService secretSantaService;
    private List<Employee> employees;
    private Map<String, String> previousAssignments;

    @BeforeEach
    public void setUp() {
        secretSantaService = new SecretSantaService();

        // Create test employees
        employees = new ArrayList<>();
        employees.add(new Employee("John Doe", "john.doe@example.com"));
        employees.add(new Employee("Jane Smith", "jane.smith@example.com"));
        employees.add(new Employee("David Lee", "david.lee@example.com"));

        // Previous assignments (if any)
        previousAssignments = new HashMap<>();
        previousAssignments.put("john.doe@example.com", "jane.smith@example.com");
        previousAssignments.put("jane.smith@example.com", "david.lee@example.com");
        previousAssignments.put("david.lee@example.com", "john.doe@example.com");
    }

    @Test
    public void testGenerateAssignments() {
        // Generate Secret Santa assignments
        List<Assignment> assignments = secretSantaService.generateAssignments(employees, previousAssignments);

        // Check if all assignments are made correctly
        assertNotNull(assignments);
        assertEquals(employees.size(), assignments.size());

        // Ensure no one has been assigned to themselves
        for (Assignment assignment : assignments) {
            assertNotEquals(assignment.getEmployee().getEmail(), assignment.getSecretChild().getEmail());
        }

        // Ensure no one is assigned to the same person as last year
        for (Assignment assignment : assignments) {
            String previous = previousAssignments.get(assignment.getEmployee().getEmail());
            assertNotEquals(previous, assignment.getSecretChild().getEmail());
        }
    }

    @Test
    public void testCircularDependencyThrowsException() {
        // Add circular dependency by giving same emails
        employees.add(new Employee("Circular Employee", "john.doe@example.com"));
        previousAssignments.put("john.doe@example.com", "john.doe@example.com");

        // This should throw a runtime exception due to circular assignment
        assertThrows(RuntimeException.class, () -> secretSantaService.generateAssignments(employees, previousAssignments));
    }
}
