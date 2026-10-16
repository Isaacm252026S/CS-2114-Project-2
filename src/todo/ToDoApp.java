package todo;
public class ToDoApp
{
private TaskManager taskManager;
private InputHandler inputHandler;
private boolean running;

public ToDoApp(){
    taskManager = new TaskManager();
    inputHandler = new InputHandler();
    running = true;
}

public void run(){
    while (running){
        System.out.println();
        System.out.println("=====TO-DO LIST=====");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Complete Task");
        System.out.println("4. Exit");

        int choice = inputHandler.getUserInput("Choose an option: ", 1, 4);
        if (choice == 1){
            addNewTask();
        }
        else if (choice == 2){
            viewTasks();
        }
        else if (choice == 3){
            markFinished();
        }
        else{
            running = false;
            system.out.println("Goodbye!");
        }
    }
}
public void addNewTask(){
    System.out.println();
    System.out.println("1. School Assignment");
    System.out.println("2. Chore");
    System.out.println("3. Custom Task");

    int type = inputHandler.getUserIntInput("Choose task type: ", 1, 3);
    String name = inputHandler.getStringInput("Task name: ");

    if (type == 1){
        String assignmentType = inputHandler.getStringInput("Assignment type (homework/exam/project): ");
        String dueDate = inputHandler.getStringInput("Due date: ");
        double hours = inputHandler.getHoursInput("Estimated hours to finish: ");
        int priority = inputHandler.getUserIntInput("Priority (1-5): ", 1, 5);
        SchoolAssignment task = new SchoolAssignment(name, assignmentType, dueDate, hours, priority);
        taskManager.addSchoolAssignment(task);
    }
    else if (type == 2){
        double hours == inputHandler.getHoursInput("Estimated hours: "):
        int priority = inputHandler.getUserIntInput("Priority (1-5): ", 1, 5);
        Chore task = new chore(name, hours, priority);
        taskManager.addChore(task);
    }
    else{
        String taskType = inputHandler.getStringInput("Custom task type: ");
        double hours = inputHandler.getHoursInput("Estimated hours: ");
        int priority = inputHandler.getUserIntInput("Priority (1-5): ", 1, 5);
        CustomTask task = new CustomTask(name, taskType, hours, priority);
        taskManager.addCustomTask(task);
    }
    System.out.println("Task added successfully!");
}

public void viewTasks(){
    System.out.println();
    System.out.println("===== SCHOOL ASSIGNMENTS =====");
    taskManager.viewSchoolAssignments();

    System.out.println();
    System.out.println("===== CHORES =====");
    taskManager.viewChores();

    System.out.println();
    System.out.println("===== CUSTOM TASKS =====");
    taskManager.viewCustomTasks();
}

public void markFinished(){
    System.out.println();
    System.out.println("1. School Assignment");
    System.out.println("2. Chore");
    System.out.println("3. Custom Task");

    int type = inputHandler.getUserIntInput("Choose task type: ", 1, 3);
    int count = 0;

    if (type == 1){
        taskManager.viewSchoolAssignments();
        count = taskManager.getSchoolTaskCount();
    }
    else if (type == 2){
        taskManager.viewChores();
        count = taskManager.getChoreCount();
    }
    else{
        taskManager.viewCustomTasks();
        count = taskManager.getCustomTaskCount();
    }

    if (count == 0){
        System.out.println("There are no tasks to complete.");
        return;
    }

    int position = inputHandler.getUserIntInput("Enter task number: ", 1, count);
    int index = position - 1;
    boolean removed = false;

    if (type == 1){
        removed = taskManager.removeSchoolAssignment(index);
    }
    else if (type == 2){
        removed = taskManager.removeChore(index);
    }
    else{
        removed = taskManager.removeCustomTask(index);
    }

    if (removed){
        System.out.println("Task Complete!");
    }
    else{
        System.out.println("Could not complete task.");
    }
}

public static void main(String[] args){
    ToDoApp app = new ToDoApp();
    app.run();
}
}
