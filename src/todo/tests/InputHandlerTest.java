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
