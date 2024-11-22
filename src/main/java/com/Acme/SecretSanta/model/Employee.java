package com.Acme.SecretSanta.model;

/**
 * Represents an employee participating in the Secret Santa event.
 * Each employee has a name and an email address.
 */
public class Employee {

    // The name of the employee
    private String name;

    // The email address of the employee
    private String email;

    /**
     * Constructor to create an Employee object.
     *
     * @param name  The name of the employee.
     * @param email The email address of the employee.
     */
    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /**
     * Gets the name of the employee.
     *
     * @return The name of the employee.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the email address of the employee.
     *
     * @return The email address of the employee.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Provides a string representation of the Employee object.
     * The format is "Name (Email)".
     *
     * @return A string representation of the employee.
     */
    @Override
    public String toString() {
        return name + " (" + email + ")";
    }
}
