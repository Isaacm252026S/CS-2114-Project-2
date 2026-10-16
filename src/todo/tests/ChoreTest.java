
package todo.tests;

import student.TestCase;
import todo.Chore;

// -------------------------------------------------------------------------
/**
 * Tests the methods in Chore
 * 
 * @author Isaac Morris (Isaacm25@vt.edu)
 * @version Oct 16, 2026
 */
public class ChoreTest
    extends TestCase
{
    
    /**
     * A new Chore method named Clean that will take 1.0 hours to complete and
     * has a priority of 1
     */
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
