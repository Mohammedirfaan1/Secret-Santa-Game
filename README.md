# Secret-Santa
Acme Company is organizing a Secret Santa event among its employees. To streamline the process, a system is being developed to automatically assign secret children (the person an employee will give a gift to) based on employee details. 

Secret Santa 

Overview

The Secret Santa Assignment Generator is a Java-based application designed to automate the process of assigning "Secret Santa" participants. It ensures that:

-> An employee cannot gift themselves.
-> Assignments avoid repeat pairings from the previous year (if applicable).
-> Each participant is assigned exactly one recipient, and vice versa.

The application reads employee information and previous year's assignments from CSV files and generates a new assignment list in CSV format.

Features
-> Input from CSV: Reads employee details and previous year’s assignments.
-> Output to CSV: Generates assignments with proper formatting.
Assignment Rules:
   -> No self-assignment.
   -> No repeat assignments from the previous year.
   -> Each employee has one unique recipient.
-> Error Handling: Manages missing files, malformed input, and assignment conflicts.
-> Extensible Design: Modular structure for future enhancements.

Prerequisites
Java Development Kit (JDK): Version 11 or higher.
Maven: Ensure Maven is installed and configured.
Dependencies:
OpenCSV: Used for CSV parsing and writing.

Installation
1) Clone the repository:
git clone <repository_url>
cd SecretSanta

2) Build the project using Maven:
mvn clean install

3) Check that dependencies (e.g., OpenCSV) are installed properly.

Project Structure

SecretSanta/
├── src/
│   ├── main/
│   │   ├── java/com/SecretSanta/
│   │   │   ├── Main.java                   # Entry point
│   │   │   ├── model/                      # Data models
│   │   │   │   ├── Employee.java           # Employee object
│   │   │   │   ├── Assignment.java         # Assignment object
│   │   │   ├── service/                    # Core services
│   │   │   │   ├── FileHandler.java        # File reading/writing logic
│   │   │   │   ├── SecretSantaService.java # Secret Santa generation logic
│   ├── resources/
│   │   ├── current_year.csv                # Current year's employee details
│   │   ├── previous_year.csv               # Previous year's assignments
│   │   ├── output.csv                      # Generated assignments
├── pom.xml                                 # Maven configuration
└── README.md                               # Project documentation

Configuration

1) Input Files

current_year.csv: Contains details of employees participating this year
Employee_Name,Employee_EmailID
John Doe,john.doe@example.com
Jane Smith,jane.smith@example.com

previous_year.csv: Contains last year's assignments
Employee_Name,Employee_EmailID,Secret_Child_Name,Secret_Child_EmailID
John Doe,john.doe@example.com,Jane Smith,jane.smith@example.com

2) Output File
output.csv: Will be generated after running the program.

Usage

1) Update the input files in the src/main/resources/ directory.
2) Run the application:
      java -cp target/SecretSanta-1.0-SNAPSHOT.jar com.SecretSanta.Main
3) Check the output.csv file in the src/main/resources/ directory for results.

Example Output

Console Output: 
Assignments generated:
John Doe -> Jane Smith
Jane Smith -> David Lee
David Lee -> John Doe
Secret Santa assignments successfully written to: src/main/resources/output.csv

Output CSV:
Employee_Name,Employee_EmailID,Secret_Child_Name,Secret_Child_EmailID
John Doe,john.doe@example.com,Jane Smith,jane.smith@example.com
Jane Smith,jane.smith@example.com,David Lee,david.lee@example.com
David Lee,david.lee@example.com,John Doe,john.doe@example.com

Testing

Unit Tests: JUnit tests are available to validate core functionality.
Run tests: mvn test

Common Issues

File Not Found:
Ensure input files (current_year.csv, previous_year.csv) exist in the src/main/resources/ directory.

Empty Output File:
Verify the logic in SecretSantaService and ensure employees are correctly passed to generateAssignments.


