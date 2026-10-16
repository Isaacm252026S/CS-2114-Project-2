package todo.tests;
import student.TestCase;
import todo.SchoolAssignment;

// -------------------------------------------------------------------------
/**
 * Tests the methods in SchoolAssignment
 *
 * @author Rohan Sampath (rohan29@vt.edu)
 * @version Oct 16, 2026
 */
public class SchoolAssignmentTest
    extends TestCase
{
    private SchoolAssignment mathHomework = new SchoolAssignment(
        "Math Homework",
        "homework",
        "2026-10-20",
        2.5,
        3);


    // ----------------------------------------------------------
    /** Tests getName() */
    public void testGetName()
    {
        assertEquals("Math Homework", mathHomework.getName());
    }


    // ----------------------------------------------------------
    /** Tests getAssignmentType() */
    public void testGetAssignmentType()
    {
        assertEquals("homework", mathHomework.getAssignmentType());
    }


    // ----------------------------------------------------------
    /** Tests getDueDate() */
    public void testGetDueDate()
    {
        assertEquals("2026-10-20", mathHomework.getDueDate());
    }


    // ----------------------------------------------------------
    /** Tests getEstimatedHours() */
    public void testGetEstimatedHours()
    {
        assertEquals(2.5, mathHomework.getEstimatedHours(), 0.1);
    }


    // ----------------------------------------------------------
    /** Tests getPriority() */
    public void testGetPriority()
    {
        assertEquals(3, mathHomework.getPriority());
    }


    // ----------------------------------------------------------
    /** Tests toString() */
    public void testToString()
    {
        assertEquals(
            "Math Homework (homework) | Due: 2026-10-20 | Hours: 2.5 | Priority: 3",
            mathHomework.toString());
    }

}
