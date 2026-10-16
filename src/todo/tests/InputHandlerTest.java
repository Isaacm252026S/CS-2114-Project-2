package todo.tests;

import student.TestCase;
// import static org.junit.jupiter.api.Assertions.*;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
import todo.InputHandler;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author Isaac Morris (Isaacm25@vt.edu)
 * @version Oct 16, 2026
 */
public class InputHandlerTest
    extends TestCase
{

    private InputHandler inputHandler;

    public void setUp()
    {
        inputHandler = new InputHandler();
    }


    // ===== getStringInput =====


    public void testGetStringInput()
    {
        systemIn().setInput("Task name\n");
        inputHandler = new InputHandler();

        assertEquals("Task name", inputHandler.getStringInput("Name: "));
    }


    public void testGetStringInputRepeatsForBlankInput()
    {
        systemIn().setInput("\n   \nTask name\n");
        inputHandler = new InputHandler();

        assertEquals("Task name", inputHandler.getStringInput("Name: "));
        assertTrue(systemOut().getHistory().contains(
            "Input cannot be empty."));
    }


    // ===== getAssignmentTypeInput =====


    public void testGetAssignmentTypeHomework()
    {
        systemIn().setInput("HOMEWORK\n");
        inputHandler = new InputHandler();

        assertEquals("homework", inputHandler.getAssignmentTypeInput("Type: "));
    }


    public void testGetAssignmentTypeExam()
    {
        systemIn().setInput("exam\n");
        inputHandler = new InputHandler();

        assertEquals("exam", inputHandler.getAssignmentTypeInput("Type: "));
    }


    public void testGetAssignmentTypeProject()
    {
        systemIn().setInput("project\n");
        inputHandler = new InputHandler();

        assertEquals("project", inputHandler.getAssignmentTypeInput("Type: "));
    }


    public void testGetAssignmentTypeRepeatsForInvalidInput()
    {
        systemIn().setInput("quiz\nproject\n");
        inputHandler = new InputHandler();

        assertEquals("project", inputHandler.getAssignmentTypeInput("Type: "));
        assertTrue(systemOut().getHistory().contains(
            "Enter homework, exam, or project."));
    }


    // ===== getDueDateInput =====


    public void testGetDueDateInput()
    {
        systemIn().setInput("2026-10-20\n");
        inputHandler = new InputHandler();

        assertEquals("2026-10-20", inputHandler.getDueDateInput("Date: "));
    }


    public void testGetDueDateInputRepeatsForInvalidDate()
    {
        systemIn().setInput("2026-02-30\n2026-02-28\n");
        inputHandler = new InputHandler();

        assertEquals("2026-02-28", inputHandler.getDueDateInput("Date: "));
        assertTrue(systemOut().getHistory().contains(
            "Enter a valid date in YYYY-MM-DD format."));
    }


    // ===== getUserIntInput =====


    public void testGetUserIntInput()
    {
        systemIn().setInput("3\n");
        inputHandler = new InputHandler();

        assertEquals(3, inputHandler.getUserIntInput("Choice: ", 1, 5));
    }


    public void testGetUserIntInputRepeatsForInvalidInputs()
    {
        systemIn().setInput("text\n6\n0\n2\n");
        inputHandler = new InputHandler();

        assertEquals(2, inputHandler.getUserIntInput("Choice: ", 1, 5));
        assertTrue(systemOut().getHistory().contains(
            "Please enter a whole number."));
        assertTrue(systemOut().getHistory().contains(
            "Enter a number from 1 to 5."));
    }


    // ===== getHoursInput =====


    public void testGetHoursInput()
    {
        systemIn().setInput("2.5\n");
        inputHandler = new InputHandler();

        assertEquals(2.5, inputHandler.getHoursInput("Hours: "), 0.1);
    }


    public void testGetHoursInputRepeatsForInvalidNumber()
    {
        systemIn().setInput("hours\n2.5\n");
        inputHandler = new InputHandler();

        assertEquals(2.5, inputHandler.getHoursInput("Hours: "), 0.1);
        assertTrue(systemOut().getHistory().contains(
            "Please enter a valid number."));
    }


    public void testGetHoursInputRepeatsForNegativeAndNonFiniteNumbers()
    {
        systemIn().setInput("-1\nNaN\nInfinity\n2.5\n");
        inputHandler = new InputHandler();

        assertEquals(2.5, inputHandler.getHoursInput("Hours: "), 0.1);
        assertTrue(systemOut().getHistory().contains(
            "Hours must be 0 or greater."));
    }

    // ===== isValidPriority =====


    public void testValidPriorityLowerBoundary()
    {
        assertTrue(inputHandler.isValidPriority(1));
    }


    public void testValidPriorityUpperBoundary()
    {
        assertTrue(inputHandler.isValidPriority(5));
    }


    public void testValidPriorityMiddleValue()
    {
        assertTrue(inputHandler.isValidPriority(3));
    }


    public void testInvalidPriorityBelowRange()
    {
        assertFalse(inputHandler.isValidPriority(0));
    }


    public void testInvalidPriorityAboveRange()
    {
        assertFalse(inputHandler.isValidPriority(6));
    }

    // ===== isValidHours =====


    public void testValidHoursZero()
    {
        assertTrue(inputHandler.isValidHours(0.0));
    }


    public void testValidHoursPositive()
    {
        assertTrue(inputHandler.isValidHours(4.5));
    }


    public void testInvalidHoursNegative()
    {
        assertFalse(inputHandler.isValidHours(-1.0));
    }


    public void testInvalidHoursNaN()
    {
        assertFalse(inputHandler.isValidHours(Double.NaN));
    }


    public void testInvalidHoursPositiveInfinity()
    {
        assertFalse(inputHandler.isValidHours(Double.POSITIVE_INFINITY));
    }


    public void testInvalidHoursNegativeInfinity()
    {
        assertFalse(inputHandler.isValidHours(Double.NEGATIVE_INFINITY));
    }

    // ===== isValidPosition =====


    public void testValidPositionLowerBoundary()
    {
        assertTrue(inputHandler.isValidPosition(1, 5));
    }


    public void testValidPositionUpperBoundary()
    {
        assertTrue(inputHandler.isValidPosition(5, 5));
    }


    public void testValidPositionMiddleValue()
    {
        assertTrue(inputHandler.isValidPosition(3, 5));
    }


    public void testInvalidPositionBelowRange()
    {
        assertFalse(inputHandler.isValidPosition(0, 5));
    }


    public void testInvalidPositionAboveRange()
    {
        assertFalse(inputHandler.isValidPosition(6, 5));
    }


    public void testInvalidPositionWhenSizeZero()
    {
        assertFalse(inputHandler.isValidPosition(1, 0));
    }
}
