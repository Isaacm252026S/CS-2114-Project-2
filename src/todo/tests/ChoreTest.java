package todo.tests;

import student.TestCase;
import todo.Chore;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author frogk
 * @version Oct 16, 2026
 */
public class ChoreTest
    extends TestCase
{
    
    Chore clean = new Chore("Clean", 1.0, 1);

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
        assertEquals("Clean | Hours: 1.0 | Priority: 1", clean.toString());

    }
}
