package com.Acme.SecretSanta.model;

/**
 * Represents an assignment in the Secret Santa event.
 * Each assignment links an employee (the "Santa") to their secret child.
 */
public class Assignment {

    // The employee who is the "Santa" in the assignment
    private Employee employee;

    // The employee who is the secret child of the Santa
    private Employee secretChild;

    /**
     * Constructor to create a new Secret Santa assignment.
     *
     * @param employee    The employee acting as the Santa.
     * @param secretChild The employee assigned as the secret child.
     */
    public Assignment(Employee employee, Employee secretChild) {
        this.employee = employee;
        this.secretChild = secretChild;
    }

    /**
     * Gets the employee acting as the Santa.
     *
     * @return The employee who is the Santa.
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Gets the secret child assigned to the Santa.
     *
     * @return The employee who is the secret child.
     */
    public Employee getSecretChild() {
        return secretChild;
    }
}
