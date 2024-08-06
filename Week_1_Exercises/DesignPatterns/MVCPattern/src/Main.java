// Main.java
package mvc;

public class Main {

    public static void main(String[] args) {
        // Create the model
        Student student = new Student();
        student.setName("John Doe");
        student.setId("12345");
        student.setGrade("A");

        // Create the view
        StudentView view = new StudentView();

        // Create the controller
        StudentController controller = new StudentController(student, view);

        // Update view
        controller.updateView();

        // Update model data
        controller.setStudentName("Jane Doe");
        controller.setStudentGrade("B");

        // Update view
        controller.updateView();
    }
}
