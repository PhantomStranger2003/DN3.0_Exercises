// Main.java
package management;

public class Main {

    public static void main(String[] args) {
        TaskManagement taskManager = new TaskManagement();

        Task task1 = new Task(1, "Design", "Pending");
        Task task2 = new Task(2, "Development", "In Progress");
        Task task3 = new Task(3, "Testing", "Pending");

        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);

        System.out.println("All tasks:");
        taskManager.traverseTasks();

        System.out.println("Search for task with ID 2:");
        System.out.println(taskManager.searchTask(2));

        System.out.println("Delete task with ID 1:");
        taskManager.deleteTask(1);
        taskManager.traverseTasks();
    }
}
