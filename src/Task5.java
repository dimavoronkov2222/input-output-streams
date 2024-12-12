package src;
import java.io.*;
import java.util.*;
public class Task5 {
    private static final List<Employee> employees = new ArrayList<>();
    private static String filePath;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path to load employees:");
        filePath = scanner.nextLine();
        loadEmployees();
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add employee");
            System.out.println("2. Edit employee");
            System.out.println("3. Delete employee");
            System.out.println("4. Search employee by last name");
            System.out.println("5. Display employees by age or last name initial");
            System.out.println("6. Save employees to file");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    editEmployee(scanner);
                    break;
                case 3:
                    deleteEmployee(scanner);
                    break;
                case 4:
                    searchEmployeeByLastName(scanner);
                    break;
                case 5:
                    displayEmployeesByCriteria(scanner);
                    break;
                case 6:
                    saveEmployees();
                    break;
                case 7:
                    saveEmployees();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void loadEmployees() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String lastName = parts[0].trim();
                    String firstName = parts[1].trim();
                    int age = Integer.parseInt(parts[2].trim());
                    employees.add(new Employee(lastName, firstName, age));
                }
            }
            System.out.println("Employees loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading employees: " + e.getMessage());
        }
    }
    private static void saveEmployees() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Employee employee : employees) {
                writer.write(employee.getLastName() + "," + employee.getFirstName() + "," + employee.getAge());
                writer.newLine();
            }
            System.out.println("Employees saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving employees: " + e.getMessage());
        }
    }
    private static void addEmployee(Scanner scanner) {
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        employees.add(new Employee(lastName, firstName, age));
        System.out.println("Employee added successfully.");
    }
    private static void editEmployee(Scanner scanner) {
        System.out.print("Enter last name of the employee to edit: ");
        String lastName = scanner.nextLine();
        for (Employee employee : employees) {
            if (employee.getLastName().equalsIgnoreCase(lastName)) {
                System.out.print("Enter new last name: ");
                employee.setLastName(scanner.nextLine());
                System.out.print("Enter new first name: ");
                employee.setFirstName(scanner.nextLine());
                System.out.print("Enter new age: ");
                employee.setAge(scanner.nextInt());
                scanner.nextLine(); // Consume the newline
                System.out.println("Employee updated successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }
    private static void deleteEmployee(Scanner scanner) {
        System.out.print("Enter last name of the employee to delete: ");
        String lastName = scanner.nextLine();
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getLastName().equalsIgnoreCase(lastName)) {
                iterator.remove();
                System.out.println("Employee deleted successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }
    private static void searchEmployeeByLastName(Scanner scanner) {
        System.out.print("Enter last name to search: ");
        String lastName = scanner.nextLine();
        for (Employee employee : employees) {
            if (employee.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println(employee);
                return;
            }
        }
        System.out.println("Employee not found.");
    }
    private static void displayEmployeesByCriteria(Scanner scanner) {
        System.out.println("Enter 'age' to filter by age or 'initial' to filter by last name initial:");
        String criteria = scanner.nextLine();
        if ("age".equalsIgnoreCase(criteria)) {
            System.out.print("Enter age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            for (Employee employee : employees) {
                if (employee.getAge() == age) {
                    System.out.println(employee);
                }
            }
        } else if ("initial".equalsIgnoreCase(criteria)) {
            System.out.print("Enter initial letter: ");
            char initial = scanner.nextLine().charAt(0);
            for (Employee employee : employees) {
                if (employee.getLastName().charAt(0) == initial) {
                    System.out.println(employee);
                }
            }
        } else {
            System.out.println("Invalid criteria.");
        }
    }
}