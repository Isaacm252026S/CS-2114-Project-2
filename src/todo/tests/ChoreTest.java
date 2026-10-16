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

    Chore clean = new Chore("Clean", 1, 1);

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */

    public void testGetName()
    {
        assertEquals("Clean", clean.getName());
        
    }
    public void testGetEstimatedHours()
    {
        
    }
    public void testGetPriority()
    {
        
    }
    public void testToString()
    {
        
    }
}
