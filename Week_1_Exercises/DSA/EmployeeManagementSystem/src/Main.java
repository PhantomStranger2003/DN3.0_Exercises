// Main.java
package management;

public class Main {

    public static void main(String[] args) {
        EmployeeManagement empManager = new EmployeeManagement(5);

        Employee emp1 = new Employee(1, "Alice", "Manager", 80000);
        Employee emp2 = new Employee(2, "Bob", "Developer", 60000);
        Employee emp3 = new Employee(3, "Charlie", "Analyst", 55000);

        empManager.addEmployee(emp1);
        empManager.addEmployee(emp2);
        empManager.addEmployee(emp3);

        System.out.println("All employees:");
        empManager.traverseEmployees();

        System.out.println("Search for employee with ID 2:");
        System.out.println(empManager.searchEmployee(2));

        System.out.println("Delete employee with ID 1:");
        empManager.deleteEmployee(1);
        empManager.traverseEmployees();
    }
}
