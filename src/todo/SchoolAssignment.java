package todo;

/**
 * Stores the details for a school assignment.
 *
 * @author Rohan Sampath
 * @version Oct 23, 2026
 */
public class SchoolAssignment
{
    private String name;
    private String assignmentType;
    private String dueDate;
    private double estimatedHours;
    private int priority;

    public SchoolAssignment(
        String name,
        String assignmentType,
        String dueDate,
        double estimatedHours,
        int priority)
    {
        this.name = name;
        this.assignmentType = assignmentType;
        this.dueDate = dueDate;
        this.estimatedHours = estimatedHours;
        this.priority = priority;
    }


    public String getName()
    {
        return name;
    }


    public String getAssignmentType()
    {
        return assignmentType;
    }


    public String getDueDate()
    {
        return dueDate;
    }


    public double getEstimatedHours()
    {
        return estimatedHours;
    }


    public int getPriority()
    {
        return priority;
    }


    public String toString()
    {
        return name + " (" + assignmentType + ")" + " | Due: " + dueDate
            + " | Hours: " + estimatedHours + " | Priority: " + priority;
    }
}
