import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Task\n2. View Tasks\n3. Remove Task\n4. Exit");
            int choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter task description:");
                    String desc = sc.nextLine();
                    taskManager.addTask(desc);
                    break;
                case 2:
                    taskManager.viewTasks();
                    break;
                case 3:
                    System.out.println("Enter task ID to remove:");
                    int taskId = sc.nextInt();
                    taskManager.removeTask(taskId);
                    break;
                case 4:
                    taskManager.saveTasks();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}
