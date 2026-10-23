package todo.tests;

import student.TestCase;
import todo.Chore;
import todo.CustomTask;
import todo.DailyPlanner;
import todo.SchoolAssignment;
import todo.TaskManager;

// -------------------------------------------------------------------------
/**
 * Tests the task recommendations made by DailyPlanner.
 *
 * @author Rohan Sampath
 * @version Oct 22, 2026
 */
public class DailyPlannerTest
    extends TestCase
{
    private TaskManager taskManager;
    private DailyPlanner planner;

    /** Creates an empty planner for each test. */
    public void setUp()
    {
        taskManager = new TaskManager();
        planner = new DailyPlanner(taskManager);
    }


    // ----------------------------------------------------------
    /** Tests that non-positive and non-finite time limits are rejected. */
    public void testInvalidAvailableHours()
    {
        assertEquals(
            "Please enter a positive number of hours.",
            planner.recommend(0));
        assertEquals(
            "Please enter a positive number of hours.",
            planner.recommend(-1));
        assertEquals(
            "Please enter a positive number of hours.",
            planner.recommend(Double.NaN));
        assertEquals(
            "Please enter a positive number of hours.",
            planner.recommend(Double.POSITIVE_INFINITY));
        assertEquals(
            "Please enter a positive number of hours.",
            planner.recommend(Double.NEGATIVE_INFINITY));
    }


    // ----------------------------------------------------------
    /** Tests the message shown when there are no tasks. */
    public void testNoTasksAvailable()
    {
        assertEquals("No tasks available.", planner.recommend(2.0));
    }


    // ----------------------------------------------------------
    /** Tests priority, time tie-breaking, and planning across task types. */
    public void testRecommendationsAreSortedAndFitAvailableTime()
    {
        taskManager.addSchoolAssignment(new SchoolAssignment(
            "School project",
            "project",
            "2026-10-30",
            2.0,
            3));
        taskManager.addChore(new Chore("Quick chore", 1.0, 3));
        taskManager.addCustomTask(
            new CustomTask("Important task", "Personal", 1.5, 5));

        String result = planner.recommend(4.5);

        assertTrue(
            result.indexOf("Important task") < result.indexOf("Quick chore"));
        assertTrue(
            result.indexOf("Quick chore") < result.indexOf("School project"));
        assertTrue(result.contains("Important task | Priority: 5 | Hours: 1.5"));
        assertTrue(result.contains("Quick chore | Priority: 3 | Hours: 1.0"));
        assertTrue(result.contains("School project | Priority: 3 | Hours: 2.0"));
        assertTrue(result.contains("Total planned hours: 4.5"));
        assertTrue(result.contains("Remaining hours: 0.0"));
    }


    // ----------------------------------------------------------
    /** Tests that same-priority tasks stay in order when hours do not improve. */
    public void testSamePriorityTasksStayInOrderWhenLaterTaskTakesLonger()
    {
        taskManager.addChore(new Chore("Short chore", 1.0, 3));
        taskManager.addCustomTask(
            new CustomTask("Long task", "Personal", 2.0, 3));

        String result = planner.recommend(4.0);

        assertTrue(result.indexOf("Short chore") < result.indexOf("Long task"));
        assertTrue(result.contains("Short chore | Priority: 3 | Hours: 1.0"));
        assertTrue(result.contains("Long task | Priority: 3 | Hours: 2.0"));
    }


    // ----------------------------------------------------------
    /** Tests that a task is skipped when it does not fit the time left. */
    public void testNoTasksFitAvailableTime()
    {
        taskManager.addChore(new Chore("Long chore", 4.0, 5));

        String result = planner.recommend(2.0);

        assertTrue(result.contains("No tasks fit your available time."));
        assertTrue(result.contains("Total planned hours: 0.0"));
        assertTrue(result.contains("Remaining hours: 2.0"));
    }


    // ----------------------------------------------------------
    /** Tests that a task with NaN hours is skipped. */
    public void testNaNTaskHoursAreSkipped()
    {
        taskManager.addCustomTask(
            new CustomTask("Unknown time", "Personal", Double.NaN, 4));

        String result = planner.recommend(5.0);

        assertTrue(result.contains("No tasks fit your available time."));
        assertFalse(result.contains("Unknown time |"));
    }


    // ----------------------------------------------------------
    /** Tests that lower-priority tasks are considered when others do not fit. */
    public void testPlannerContinuesAfterTaskDoesNotFit()
    {
        taskManager.addChore(new Chore("Long chore", 3.0, 5));
        taskManager.addCustomTask(
            new CustomTask("Short task", "Personal", 1.0, 4));

        String result = planner.recommend(1.5);

        assertFalse(result.contains("Long chore |"));
        assertTrue(result.contains("Short task | Priority: 4 | Hours: 1.0"));
        assertTrue(result.contains("Total planned hours: 1.0"));
        assertTrue(result.contains("Remaining hours: 0.5"));
    }


    // ----------------------------------------------------------
    /** Tests that zero and non-finite task hours are not recommended. */
    public void testInvalidTaskHoursAreSkipped()
    {
        taskManager.addChore(new Chore("No time", 0.0, 5));
        taskManager.addSchoolAssignment(new SchoolAssignment(
            "Infinite time",
            "exam",
            "2026-10-30",
            Double.POSITIVE_INFINITY,
            3));

        String result = planner.recommend(5.0);

        assertTrue(result.contains("No tasks fit your available time."));
        assertFalse(result.contains("No time |"));
        assertFalse(result.contains("Infinite time |"));
    }
}
