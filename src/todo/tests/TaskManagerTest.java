package todo.tests;
import student.TestCase;
import todo.Chore;
import todo.CustomTask;
import todo.SchoolAssignment;
import todo.TaskManager;

// -------------------------------------------------------------------------
/**
 * Tests the methods in TaskManager
 *
 * @author Rohan Sampath (rohan29@vt.edu)
 * @version Oct 16, 2026
 */
public class TaskManagerTest
    extends TestCase
{
    private TaskManager taskManager;

    /** Creates a new TaskManager for each test. */
    public void setUp()
    {
        taskManager = new TaskManager();
    }


    // ----------------------------------------------------------
    /** Tests that all task lists start empty. */
    public void testInitialTaskCounts()
    {
        assertEquals(0, taskManager.getSchoolTaskCount());
        assertEquals(0, taskManager.getChoreCount());
        assertEquals(0, taskManager.getCustomTaskCount());
    }


    // ----------------------------------------------------------
    /** Tests adding and retrieving school assignments. */
    public void testAddAndGetSchoolAssignment()
    {
        SchoolAssignment assignment = new SchoolAssignment(
            "Math Homework",
            "homework",
            "2026-10-20",
            2.5,
            3);
        taskManager.addSchoolAssignment(assignment);

        assertEquals(1, taskManager.getSchoolTaskCount());
        assertEquals(assignment, taskManager.getSchoolAssignment(0));
    }


    // ----------------------------------------------------------
    /** Tests adding and retrieving chores. */
    public void testAddAndGetChore()
    {
        Chore chore = new Chore("Clean", 1.0, 1);
        taskManager.addChore(chore);

        assertEquals(1, taskManager.getChoreCount());
        assertEquals(chore, taskManager.getChore(0));
    }


    // ----------------------------------------------------------
    /** Tests adding and retrieving custom tasks. */
    public void testAddAndGetCustomTask()
    {
        CustomTask customTask = new CustomTask("Call home", "Personal", 0.5, 2);
        taskManager.addCustomTask(customTask);

        assertEquals(1, taskManager.getCustomTaskCount());
        assertEquals(customTask, taskManager.getCustomTask(0));
    }


    // ----------------------------------------------------------
    /** Tests that the planner can access each task chain. */
    public void testGetTaskChains()
    {
        SchoolAssignment assignment = new SchoolAssignment(
            "Math Homework",
            "homework",
            "2026-10-20",
            2.5,
            3);
        Chore chore = new Chore("Clean", 1.0, 1);
        CustomTask customTask = new CustomTask("Call home", "Personal", 0.5, 2);

        taskManager.addSchoolAssignment(assignment);
        taskManager.addChore(chore);
        taskManager.addCustomTask(customTask);

        assertEquals(assignment, taskManager.getSchoolTasks().get(0));
        assertEquals(chore, taskManager.getChores().get(0));
        assertEquals(customTask, taskManager.getCustomTasks().get(0));
    }


    // ----------------------------------------------------------
    /** Tests removing a school assignment. */
    public void testRemoveSchoolAssignment()
    {
        SchoolAssignment first = new SchoolAssignment(
            "Math Homework",
            "homework",
            "2026-10-20",
            2.5,
            3);
        SchoolAssignment second = new SchoolAssignment(
            "History Essay",
            "project",
            "2026-10-22",
            3.0,
            2);
        taskManager.addSchoolAssignment(first);
        taskManager.addSchoolAssignment(second);

        assertTrue(taskManager.removeSchoolAssignment(0));
        assertEquals(1, taskManager.getSchoolTaskCount());
        assertEquals(second, taskManager.getSchoolAssignment(0));
    }


    // ----------------------------------------------------------
    /** Tests removing a chore. */
    public void testRemoveChore()
    {
        Chore first = new Chore("Clean", 1.0, 1);
        Chore second = new Chore("Laundry", 1.5, 2);
        taskManager.addChore(first);
        taskManager.addChore(second);

        assertTrue(taskManager.removeChore(0));
        assertEquals(1, taskManager.getChoreCount());
        assertEquals(second, taskManager.getChore(0));
    }


    // ----------------------------------------------------------
    /** Tests removing a custom task. */
    public void testRemoveCustomTask()
    {
        CustomTask first = new CustomTask("Call home", "Personal", 0.5, 2);
        CustomTask second = new CustomTask("Read", "Personal", 1.0, 1);
        taskManager.addCustomTask(first);
        taskManager.addCustomTask(second);

        assertTrue(taskManager.removeCustomTask(0));
        assertEquals(1, taskManager.getCustomTaskCount());
        assertEquals(second, taskManager.getCustomTask(0));
    }


    // ----------------------------------------------------------
    /** Tests that removing from an empty school assignment list fails. */
    public void testRemoveSchoolAssignmentFromEmptyList()
    {
        assertFalse(taskManager.removeSchoolAssignment(0));
        assertEquals(0, taskManager.getSchoolTaskCount());
    }


    // ----------------------------------------------------------
    /** Tests that removing from an empty chore list fails. */
    public void testRemoveChoreFromEmptyList()
    {
        assertFalse(taskManager.removeChore(0));
        assertEquals(0, taskManager.getChoreCount());
    }


    // ----------------------------------------------------------
    /** Tests that removing from an empty custom task list fails. */
    public void testRemoveCustomTaskFromEmptyList()
    {
        assertFalse(taskManager.removeCustomTask(0));
        assertEquals(0, taskManager.getCustomTaskCount());
    }


    // ----------------------------------------------------------
    /** Tests that invalid school assignment indexes do not remove a task. */
    public void testRemoveSchoolAssignmentAtInvalidIndex()
    {
        SchoolAssignment assignment = new SchoolAssignment(
            "Math Homework",
            "homework",
            "2026-10-20",
            2.5,
            3);
        taskManager.addSchoolAssignment(assignment);

        assertFalse(taskManager.removeSchoolAssignment(1));
        assertFalse(taskManager.removeSchoolAssignment(-1));
        assertEquals(1, taskManager.getSchoolTaskCount());
        assertEquals(assignment, taskManager.getSchoolAssignment(0));
    }


    // ----------------------------------------------------------
    /** Tests that invalid chore indexes do not remove a task. */
    public void testRemoveChoreAtInvalidIndex()
    {
        Chore chore = new Chore("Clean", 1.0, 1);
        taskManager.addChore(chore);

        assertFalse(taskManager.removeChore(1));
        assertFalse(taskManager.removeChore(-1));
        assertEquals(1, taskManager.getChoreCount());
        assertEquals(chore, taskManager.getChore(0));
    }


    // ----------------------------------------------------------
    /** Tests that invalid custom task indexes do not remove a task. */
    public void testRemoveCustomTaskAtInvalidIndex()
    {
        CustomTask customTask = new CustomTask("Call home", "Personal", 0.5, 2);
        taskManager.addCustomTask(customTask);

        assertFalse(taskManager.removeCustomTask(1));
        assertFalse(taskManager.removeCustomTask(-1));
        assertEquals(1, taskManager.getCustomTaskCount());
        assertEquals(customTask, taskManager.getCustomTask(0));
    }

}
