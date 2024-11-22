# Secret-Santa

Acme Company is organizing a Secret Santa event among its employees. To streamline the process, a system is being developed to automatically assign "secret children" (the person an employee will give a gift to) based on employee details.

## Overview

The Secret Santa Assignment Generator is a Java-based application designed to automate the process of assigning "Secret Santa" participants. It ensures that:

- An employee cannot gift themselves.
- Assignments avoid repeat pairings from the previous year (if applicable).
- Each participant is assigned exactly one recipient, and vice versa.

The application reads employee information and previous year's assignments from CSV files and generates a new assignment list in CSV format.

## Features

- **Input from CSV**: Reads employee details and previous year’s assignments.
- **Output to CSV**: Generates assignments with proper formatting.

### Assignment Rules:
   - No self-assignment.
   - No repeat assignments from the previous year.
   - Each employee has one unique recipient.

- **Error Handling**: Manages missing files, malformed input, and assignment conflicts.
- **Extensible Design**: Modular structure for future enhancements.

## Prerequisites

- **Java Development Kit (JDK)**: Version 11 or higher.
- **Maven**: Ensure Maven is installed and configured.

### Dependencies:
- **OpenCSV**: Used for CSV parsing and writing.

## Installation

1. Clone the repository:
   ```bash
   git https://github.com/Mohammedirfaan1/Secret-Santa-Game.git
   cd SecretSanta
2.Build the project using Maven:
  mvn clean install
3. Check that dependencies (e.g., OpenCSV) are installed properly.

## Project Structure

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

## Configuration Files

Before running the application, ensure that the necessary input files are in place.

1. Input Files:
   - **current_year.csv** - This file should contain the list of employees participating in the 
       Secret Santa event.For example:
     Employee_Name,Employee_EmailID
     John Doe,john.doe@example.com
     Jane Smith,jane.smith@example.com
   - **previous_year.csv** -This file should contain the assignments from the previous year.
      For example:
     Employee_Name,Employee_EmailID,Secret_Child_Name,Secret_Child_EmailID
     John Doe,john.doe@example.com,Jane Smith,jane.smith@example.com

 2.  Output File:
     -  The output file, output.csv, will be generated automatically by the application after 
       you run it. It will contain the new Secret Santa assignments.
  
## Usage
   Now that everything is set up, you can proceed with running the application.

   1. Update Input Files:
        - Place or update your current_year.csv and previous_year.csv files in the 
          src/main/resources/ directory.
   2. Run the Application: After building the project, use the following command to run the 
      program:
      java -cp target/SecretSanta-1.0-SNAPSHOT.jar com.SecretSanta.Main
   3. Check the Output:
          - After running the application, the new assignments will be written to output.csv in 
            the src/main/resources/ directory.

## Example Output

   Console Output:
    Assignments generated:
   John Doe -> Jane Smith
   Jane Smith -> David Lee
   David Lee -> John Doe
   Secret Santa assignments successfully written to: src/main/resources/output.csv
   
## Generated Output CSV (output.csv):

Employee_Name,Employee_EmailID,Secret_Child_Name,Secret_Child_EmailID
John Doe,john.doe@example.com,Jane Smith,jane.smith@example.com
Jane Smith,jane.smith@example.com,David Lee,david.lee@example.com
David Lee,david.lee@example.com,John Doe,john.doe@example.com

## Testing

To ensure everything is working correctly, run the unit tests to validate the core functionality of the application.

Run Unit Tests: You can run the tests with Maven to ensure that everything is working correctly:

mvn test

This will execute the test cases defined in the project. Make sure the tests pass without any issues.

## 
After installing the project dependencies and setting up the project, here's how you would continue with the steps. I'll walk you through the key actions after the installation process, assuming the steps are already followed correctly (e.g., Maven installation, cloning the repository, etc.).

Steps After Installation
Build the Project Using Maven:

To compile and package your project, run the following command from the root directory of the project:

bash
Copy code
mvn clean install
This command will:

Clean any previous build artifacts.
Compile the source code.
Run tests.
Package the application into a JAR file located in the target/ directory.
Check that Dependencies (e.g., OpenCSV) are Installed Properly:

After the build completes successfully, Maven should have downloaded the necessary dependencies (like OpenCSV) automatically. To verify this:

Check the pom.xml file in the root directory to ensure the correct dependencies are listed.
Inspect the target/dependency/ directory or the local Maven repository to ensure that OpenCSV and other dependencies are present.
If there are any missing dependencies or errors, Maven will display messages in the terminal to help you debug the issue.

Project Structure
After the build, your project directory should look like this:

bash
Copy code
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
Configuration Files
Before running the application, ensure that the necessary input files are in place.

Input Files:

current_year.csv: This file should contain the list of employees participating in the Secret Santa event. For example:

csv
Copy code
Employee_Name,Employee_EmailID
John Doe,john.doe@example.com
Jane Smith,jane.smith@example.com
previous_year.csv: This file should contain the assignments from the previous year. For example:

csv
Copy code
Employee_Name,Employee_EmailID,Secret_Child_Name,Secret_Child_EmailID
John Doe,john.doe@example.com,Jane Smith,jane.smith@example.com
Output File:

The output file, output.csv, will be generated automatically by the application after you run it. It will contain the new Secret Santa assignments.
Usage
Now that everything is set up, you can proceed with running the application.

Update Input Files:

Place or update your current_year.csv and previous_year.csv files in the src/main/resources/ directory.
Run the Application: After building the project, use the following command to run the program:

bash
Copy code
java -cp target/SecretSanta-1.0-SNAPSHOT.jar com.SecretSanta.Main
This command will start the application, and the assignments will be generated according to the rules specified in the SecretSantaService.

Check the Output:

After running the application, the new assignments will be written to output.csv in the src/main/resources/ directory.
Example Output
Console Output:
bash
Copy code
Assignments generated:
John Doe -> Jane Smith
Jane Smith -> David Lee
David Lee -> John Doe
Secret Santa assignments successfully written to: src/main/resources/output.csv
Generated Output CSV (output.csv):
csv
Copy code
Employee_Name,Employee_EmailID,Secret_Child_Name,Secret_Child_EmailID
John Doe,john.doe@example.com,Jane Smith,jane.smith@example.com
Jane Smith,jane.smith@example.com,David Lee,david.lee@example.com
David Lee,david.lee@example.com,John Doe,john.doe@example.com
Testing
To ensure everything is working correctly, run the unit tests to validate the core functionality of the application.

Run Unit Tests: You can run the tests with Maven to ensure that everything is working correctly:

bash
Copy code
mvn test
This will execute the test cases defined in the project. Make sure the tests pass without any issues.

## Common Issues
1. File Not Found:

- Ensure that the input files (current_year.csv, previous_year.csv) are present in the 
  src/main/resources/ directory.
- If the files are missing, the application may fail to load or process the data properly.
  
2. Empty Output File:

- If the output.csv file is empty, check the SecretSantaService logic to ensure the assignments 
  are generated correctly.-
- Verify that the logic correctly handles employee details and generates the Secret Santa 
  pairings without issues.

