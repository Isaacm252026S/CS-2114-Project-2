package todo;

/**
 * Stores the details for a user-defined task.
 *
 * @author Rohan Sampath
 * @version Oct 23, 2026
 */
public class CustomTask
{
    private String name;
    private String taskType;
    private double estimatedHours;
    private int priority;

    public CustomTask(
        String name,
        String taskType,
        double estimatedHours,
        int priority)
    {
        this.name = name;
        this.taskType = taskType;
        this.estimatedHours = estimatedHours;
        this.priority = priority;
    }


    public String getName()
    {
        return name;
    }


    public String getTaskType()
    {
        return taskType;
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
        return name + " (" + taskType + ")" + " | Hours: " + estimatedHours
            + " | Priority: " + priority;
    }
}
