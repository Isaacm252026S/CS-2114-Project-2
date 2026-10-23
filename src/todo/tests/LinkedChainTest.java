package todo.tests;

import student.TestCase;
import todo.LinkedChain;

// -------------------------------------------------------------------------
/**
 * Tests the operations of the generic LinkedChain.
 *
 * @author Rohan Sampath
 * @version Oct 22, 2026
 */
public class LinkedChainTest
    extends TestCase
{
    // ----------------------------------------------------------
    /** Tests the initial state and adding entries at the front. */
    public void testAddAndInitialState()
    {
        LinkedChain<String> chain = new LinkedChain<String>();

        assertTrue(chain.isEmpty());
        assertEquals(0, chain.size());
        assertTrue(chain.add("first"));
        assertTrue(chain.add("second"));
        assertFalse(chain.isEmpty());
        assertEquals(2, chain.size());
        assertEquals("second", chain.get(0));
        assertEquals("first", chain.get(1));
        assertEquals("[second, first]", chain.toString());
    }


    // ----------------------------------------------------------
    /** Tests adding entries at the end and preserving their order. */
    public void testAddToEnd()
    {
        LinkedChain<String> chain = new LinkedChain<String>();

        assertTrue(chain.addToEnd("first"));
        assertTrue(chain.addToEnd("second"));
        assertTrue(chain.addToEnd("third"));
        assertEquals("[first, second, third]", chain.toString());
    }


    // ----------------------------------------------------------
    /** Tests that null entries cannot be added at either end. */
    public void testAddRejectsNull()
    {
        LinkedChain<String> chain = new LinkedChain<String>();
        boolean addThrewException = false;
        boolean addToEndThrewException = false;

        try
        {
            chain.add(null);
        }
        catch (IllegalArgumentException e)
        {
            addThrewException = true;
        }
        try
        {
            chain.addToEnd(null);
        }
        catch (IllegalArgumentException e)
        {
            addToEndThrewException = true;
        }

        assertTrue(addThrewException);
        assertTrue(addToEndThrewException);
        assertTrue(chain.isEmpty());
    }


    // ----------------------------------------------------------
    /** Tests removing the first item, including from an empty chain. */
    public void testRemoveFirst()
    {
        LinkedChain<String> chain = new LinkedChain<String>();

        assertNull(chain.remove());
        chain.addToEnd("first");
        chain.addToEnd("second");
        assertEquals("first", chain.remove());
        assertEquals(1, chain.size());
        assertEquals("second", chain.get(0));
        assertEquals("second", chain.remove());
        assertTrue(chain.isEmpty());
        assertNull(chain.remove());
    }


    // ----------------------------------------------------------
    /** Tests removing entries by value from the head, middle, and end. */
    public void testRemoveEntry()
    {
        LinkedChain<String> chain = new LinkedChain<String>();
        chain.addToEnd("first");
        chain.addToEnd("middle");
        chain.addToEnd("last");

        assertFalse(chain.remove(null));
        assertTrue(chain.remove("middle"));
        assertEquals("[first, last]", chain.toString());
        assertFalse(chain.remove("missing"));
        assertTrue(chain.remove("first"));
        assertTrue(chain.remove("last"));
        assertFalse(chain.remove(null));
        assertEquals(0, chain.size());
    }


    // ----------------------------------------------------------
    /** Tests removal by value from an empty chain. */
    public void testRemoveFromEmptyChain()
    {
        LinkedChain<String> chain = new LinkedChain<String>();

        assertFalse(chain.remove("missing"));
        assertFalse(chain.remove(null));
    }


    // ----------------------------------------------------------
    /** Tests clear on both a populated chain and an empty chain. */
    public void testClear()
    {
        LinkedChain<String> chain = new LinkedChain<String>();
        chain.add("entry");
        chain.clear();
        assertTrue(chain.isEmpty());
        assertEquals("[]", chain.toString());

        chain.clear();
        assertEquals(0, chain.size());
    }


    // ----------------------------------------------------------
    /** Tests retrieving valid entries and rejecting invalid indexes. */
    public void testGet()
    {
        LinkedChain<String> chain = new LinkedChain<String>();
        chain.addToEnd("first");
        chain.addToEnd("second");
        assertEquals("first", chain.get(0));
        assertEquals("second", chain.get(1));

        boolean negativeThrewException = false;
        boolean pastEndThrewException = false;
        try
        {
            chain.get(-1);
        }
        catch (IndexOutOfBoundsException e)
        {
            negativeThrewException = true;
        }
        try
        {
            chain.get(2);
        }
        catch (IndexOutOfBoundsException e)
        {
            pastEndThrewException = true;
        }

        assertTrue(negativeThrewException);
        assertTrue(pastEndThrewException);
    }


    // ----------------------------------------------------------
    /** Tests contains and count for found, missing, and null entries. */
    public void testContainsAndCount()
    {
        LinkedChain<String> chain = new LinkedChain<String>();
        chain.addToEnd("same");
        chain.addToEnd("other");
        chain.addToEnd("same");

        assertTrue(chain.contains("same"));
        assertFalse(chain.contains("missing"));
        assertFalse(chain.contains(null));
        assertEquals(2, chain.count("same"));
        assertEquals(0, chain.count("missing"));
        assertEquals(0, chain.count(null));
    }


    // ----------------------------------------------------------
    /** Tests copying entries to an array, including invalid arrays. */
    public void testToArray()
    {
        LinkedChain<String> chain = new LinkedChain<String>();
        String[] emptyValues = new String[0];
        assertSame(emptyValues, chain.toArray(emptyValues));

        chain.addToEnd("first");
        chain.addToEnd("second");
        String[] values = new String[3];
        assertSame(values, chain.toArray(values));
        assertEquals("first", values[0]);
        assertEquals("second", values[1]);

        boolean nullThrewException = false;
        boolean smallArrayThrewException = false;
        try
        {
            chain.toArray(null);
        }
        catch (IllegalArgumentException e)
        {
            nullThrewException = true;
        }
        try
        {
            chain.toArray(new String[1]);
        }
        catch (IllegalArgumentException e)
        {
            smallArrayThrewException = true;
        }

        assertTrue(nullThrewException);
        assertTrue(smallArrayThrewException);
    }


    // ----------------------------------------------------------
    /** Tests readable output for empty and populated chains. */
    public void testToString()
    {
        LinkedChain<String> chain = new LinkedChain<String>();
        assertEquals("[]", chain.toString());
        chain.addToEnd("one");
        assertEquals("[one]", chain.toString());
        chain.addToEnd("two");
        assertEquals("[one, two]", chain.toString());
    }
}
