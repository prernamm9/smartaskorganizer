import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;
    private static final String FILE_PATH = "tasks.txt";

    public TaskManager() {
        tasks = new ArrayList<>();
        loadTasks();
    }

    // Adds a new task to the list
    public void addTask(String description) {
        Task task = new Task(tasks.size() + 1, description);
        tasks.add(task);
        System.out.println("Task added.");
    }

    // Displays all tasks in the list
    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    // Removes a task by ID
    public void removeTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
        System.out.println("Task removed.");
    }

    // Saves tasks to a file
    public void saveTasks() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Task task : tasks) {
                writer.write(task.toFileString());
                writer.newLine();
            }
            System.out.println("Tasks saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Loads tasks from the file
    private void loadTasks() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                tasks.add(new Task(Integer.parseInt(parts[0]), parts[1]));
            }
        } catch (IOException e) {
            System.out.println("No tasks found.");
        }
    }
}
