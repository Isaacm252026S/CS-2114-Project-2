package todo.tests;
import student.TestCase;
import todo.Chore;
import todo.TaskManager;
import todo.ToDoApp;

// -------------------------------------------------------------------------
/**
 * Tests the menu methods in ToDoApp
 *
 * @author Rohan Sampath (rohan29@vt.edu)
 * @version Oct 16, 2026
 */
public class ToDoAppTest
    extends TestCase
{
    // ----------------------------------------------------------
    /** Tests that the app exits when the user chooses option 4. */
    public void testExit()
    {
        systemIn().setInput("4\n");
        ToDoApp.main(new String[0]);

        assertTrue(systemOut().getHistory().contains("Goodbye!"));
    }


    // ----------------------------------------------------------
    /** Tests viewing the task lists when they are empty. */
    public void testViewEmptyTaskLists()
    {
        systemIn().setInput("2\n4\n");
        ToDoApp app = new ToDoApp();
        app.run();

        String output = systemOut().getHistory();
        assertTrue(output.contains("No school Assignments."));
        assertTrue(output.contains("No chores."));
        assertTrue(output.contains("No custom tasks."));
    }


    // ----------------------------------------------------------
    /** Tests completing a task when its list is empty. */
    public void testCompleteTaskWhenListIsEmpty()
    {
        systemIn().setInput("3\n1\n4\n");
        ToDoApp app = new ToDoApp();
        app.run();

        assertTrue(systemOut().getHistory().contains(
            "There are no tasks to complete."));
    }


    // ----------------------------------------------------------
    /** Tests adding and completing a chore through the menu. */
    public void testAddAndCompleteChore()
    {
        systemIn().setInput("1\n2\nLaundry\n1.5\n2\n3\n2\n1\n4\n");
        ToDoApp app = new ToDoApp();
        app.run();

        String output = systemOut().getHistory();
        assertTrue(output.contains("Task added successfully!"));
        assertTrue(output.contains("1. Laundry | Hours: 1.5 | Priority: 2"));
        assertTrue(output.contains("Task Complete!"));
    }


    // ----------------------------------------------------------
    /** Tests adding and completing a school assignment through the menu. */
    public void testAddAndCompleteSchoolAssignment()
    {
        systemIn().setInput(
            "1\n1\nEssay\nproject\n2026-10-25\n2.5\n3\n3\n1\n1\n4\n");
        ToDoApp app = new ToDoApp();
        app.run();

        String output = systemOut().getHistory();
        assertTrue(output.contains("Task added successfully!"));
        assertTrue(output.contains(
            "1. Essay (project) | Due: 2026-10-25 | Hours: 2.5 | Priority: 3"));
        assertTrue(output.contains("Task Complete!"));
    }


    // ----------------------------------------------------------
    /** Tests adding and completing a custom task through the menu. */
    public void testAddAndCompleteCustomTask()
    {
        systemIn().setInput(
            "1\n3\nCall home\nPersonal\n0.5\n2\n3\n3\n1\n4\n");
        ToDoApp app = new ToDoApp();
        app.run();

        String output = systemOut().getHistory();
        assertTrue(output.contains("Task added successfully!"));
        assertTrue(output.contains(
            "1. Call home (Personal) | Hours: 0.5 | Priority: 2"));
        assertTrue(output.contains("Task Complete!"));
    }


    // ----------------------------------------------------------
    /** Tests the message shown when removing a selected task fails. */
    public void testCouldNotCompleteTask()
    {
        systemIn().setInput("3\n2\n1\n4\n");
        TaskManager taskManager = new TaskManager()
        {
            public boolean removeChore(int index)
            {
                return false;
            }
        };
        taskManager.addChore(new Chore("Clean", 1.0, 1));
        ToDoApp app = new ToDoApp(taskManager);
        app.run();

        assertTrue(systemOut().getHistory().contains(
            "Could not complete task."));
    }

}
