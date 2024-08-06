// management/TaskManagement.java
package management;

public class TaskManagement {
    private Task head;

    public TaskManagement() {
        this.head = null;
    }

    public void addTask(Task newTask) {
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTask;
        }
    }

    public Task searchTask(int taskId) {
        Task current = head;
        while (current != null) {
            if (current.getTaskId() == taskId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void traverseTasks() {
        Task current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    public void deleteTask(int taskId) {
        if (head == null) return;

        if (head.getTaskId() == taskId) {
            head = head.next;
            return;
        }

        Task current = head;
        Task previous = null;
        while (current != null && current.getTaskId() != taskId) {
            previous = current;
            current = current.next;
        }

        if (current == null) return;

        previous.next = current.next;
    }
}
