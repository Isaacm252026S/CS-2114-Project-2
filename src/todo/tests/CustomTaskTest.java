package todo.tests;

import student.TestCase;
import todo.CustomTask;

// -------------------------------------------------------------------------
/**
 * Tests the classes in CustomTask
 * 
 * @author Isaac Morris (Isaacm25@.vt.edu)
 * @version Oct 16, 2026
 */
public class CustomTaskTest
    extends TestCase
{
    /**
     * A new CustomChore method named Clean is a type of Chore that will take
     * 1.0 hours to complete and has a priority of 1
     */
    CustomTask clean = new CustomTask("Clean", "Chore", 1.0, 1);

    // ----------------------------------------------------------
    /**
     * Tests getName()
     */
    public void testGetName()
    {
        assertEquals("Clean", clean.getName());
    }


    // ----------------------------------------------------------
    /**
     * Tests getTaskType()
     */
    public void testGetTaskType()
    {
        assertEquals("Chore", clean.getTaskType());
    }


    // ----------------------------------------------------------
    /**
     * Tests getEstimatedHours()
     */
    public void testGetEstimatedHours()
    {
        assertEquals(1.0, clean.getEstimatedHours(), 0.1);

    }


    // ----------------------------------------------------------
    /**
     * Tests getPriority()
     */
    public void testGetPriority()
    {
        assertEquals(1, clean.getPriority());
    }


    // ----------------------------------------------------------
    /**
     * Tests toString()
     */
    public void testToString()
    {
        assertEquals(
            "Clean (Chore) | Hours: 1.0 | Priority: 1",
            clean.toString());
    }

}
