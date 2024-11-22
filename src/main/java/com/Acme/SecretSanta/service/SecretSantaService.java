package com.Acme.SecretSanta.service;

import com.Acme.SecretSanta.model.Assignment;
import com.Acme.SecretSanta.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Service class for generating Secret Santa assignments based on provided rules and constraints.
 */
public class SecretSantaService {

    /**
     * Generates Secret Santa assignments for a given list of employees.
     *
     * @param employees           List of employees participating in the Secret Santa.
     * @param previousAssignments Map of previous year's assignments, where the key is the Employee_EmailID
     *                             and the value is the Secret_Child_EmailID.
     * @return A list of assignments where each employee is assigned a unique Secret Santa child.
     * @throws RuntimeException If the constraints cannot be satisfied (e.g., no eligible children remain).
     */
    public List<Assignment> generateAssignments(List<Employee> employees, Map<String, String> previousAssignments) {
        // Create a mutable list of available children to assign
        List<Employee> availableChildren = new ArrayList<>(employees);

        // List to store the resulting assignments
        List<Assignment> assignments = new ArrayList<>();
        Random random = new Random(); // Random generator for assignments

        // Iterate over each employee to assign a Secret Santa child
        for (Employee employee : employees) {
            // Filter eligible children based on constraints
            List<Employee> eligibleChildren = availableChildren.stream()
                    .filter(child -> !child.getEmail().equals(employee.getEmail())) // Cannot assign to self
                    .filter(child -> !child.getEmail().equals(previousAssignments.get(employee.getEmail()))) // Avoid previous year's assignment
                    .collect(Collectors.toList());

            // If no eligible children are found, the assignment process fails
            if (eligibleChildren.isEmpty()) {
                throw new RuntimeException("Unable to assign Secret Santa due to constraints.");
            }

            // Randomly select an eligible child
            Employee chosenChild = eligibleChildren.get(random.nextInt(eligibleChildren.size()));

            // Add the assignment to the list
            assignments.add(new Assignment(employee, chosenChild));

            // Remove the chosen child from the pool of available children
            availableChildren.remove(chosenChild);
        }

        // Return the completed list of assignments
        return assignments;
    }
}
