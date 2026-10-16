package todo.tests;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
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
    private InputStream originalInput;
    private PrintStream originalOutput;
    private ByteArrayOutputStream capturedOutput;

    public void setUp()
    {
        originalInput = System.in;
        originalOutput = System.out;
        capturedOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capturedOutput));
    }


    public void tearDown()
    {
        System.setIn(originalInput);
        System.setOut(originalOutput);
    }


    private void setInput(String input)
    {
        System.setIn(new ByteArrayInputStream(
            input.getBytes(StandardCharsets.UTF_8)));
    }


    // ----------------------------------------------------------
    /** Tests that the app exits when the user chooses option 4. */
    public void testExit()
    {
        setInput("4\n");
        ToDoApp.main(new String[0]);

        assertTrue(capturedOutput.toString().contains("Goodbye!"));
    }


    // ----------------------------------------------------------
    /** Tests viewing the task lists when they are empty. */
    public void testViewEmptyTaskLists()
    {
        setInput("2\n4\n");
        ToDoApp app = new ToDoApp();
        app.run();

        String output = capturedOutput.toString();
        assertTrue(output.contains("No school Assignments."));
        assertTrue(output.contains("No chores."));
        assertTrue(output.contains("No custom tasks."));
    }


    // ----------------------------------------------------------
    /** Tests completing a task when its list is empty. */
    public void testCompleteTaskWhenListIsEmpty()
    {
        setInput("3\n1\n4\n");
        ToDoApp app = new ToDoApp();
        app.run();

        assertTrue(capturedOutput.toString().contains(
            "There are no tasks to complete."));
    }


    // ----------------------------------------------------------
    /** Tests adding and completing a chore through the menu. */
    public void testAddAndCompleteChore()
    {
        setInput("1\n2\nLaundry\n1.5\n2\n3\n2\n1\n4\n");
        ToDoApp app = new ToDoApp();
        app.run();

        String output = capturedOutput.toString();
        assertTrue(output.contains("Task added successfully!"));
        assertTrue(output.contains("1. Laundry | Hours: 1.5 | Priority: 2"));
        assertTrue(output.contains("Task Complete!"));
    }


    // ----------------------------------------------------------
    /** Tests adding and completing a school assignment through the menu. */
    public void testAddAndCompleteSchoolAssignment()
    {
        setInput(
            "1\n1\nEssay\nproject\n2026-10-25\n2.5\n3\n3\n1\n1\n4\n");
        ToDoApp app = new ToDoApp();
        app.run();

        String output = capturedOutput.toString();
        assertTrue(output.contains("Task added successfully!"));
        assertTrue(output.contains(
            "1. Essay (project) | Due: 2026-10-25 | Hours: 2.5 | Priority: 3"));
        assertTrue(output.contains("Task Complete!"));
    }


    // ----------------------------------------------------------
    /** Tests adding and completing a custom task through the menu. */
    public void testAddAndCompleteCustomTask()
    {
        setInput(
            "1\n3\nCall home\nPersonal\n0.5\n2\n3\n3\n1\n4\n");
        ToDoApp app = new ToDoApp();
        app.run();

        String output = capturedOutput.toString();
        assertTrue(output.contains("Task added successfully!"));
        assertTrue(output.contains(
            "1. Call home (Personal) | Hours: 0.5 | Priority: 2"));
        assertTrue(output.contains("Task Complete!"));
    }


    // ----------------------------------------------------------
    /** Tests the message shown when removing a selected task fails. */
    public void testCouldNotCompleteTask()
    {
        setInput("3\n2\n1\n4\n");
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

        assertTrue(capturedOutput.toString().contains(
            "Could not complete task."));
    }

}
