package todo;

public class Chore
{
    private String name;
    private double estimatedHours;
    private int priority;


    public Chore(String name, double estimatedHours, int priority)
    {
        this.name = name;
        this.estimatedHours = estimatedHours;
        this.priority = priority;
    }


    public String getName()
    {
        return name;
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
        return name + " | Hours: " + estimatedHours + " | Priority: "
            + priority;
    }
}

