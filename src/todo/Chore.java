package todo;

public class Chore
{
    private String name;
    private double estimatedHours;
    private int priority;


// ----------------------------------------------------------
/**
 * Create a new Chore object.
 * @param name
 * @param estimatedHours
 * @param priority
 */
/*
public Chore(String name, double estimatedHours, int priority){
    this.name = name;
    this.estimatedHours = estimatedHours;
    this.priority = priority;
}

// ----------------------------------------------------------
/**
 * Place a description of your method here.
 * @return
 */
/*
public String getName(){
    return name;
}

// ----------------------------------------------------------
/**
 * Place a description of your method here.
 * @return
 */
/*
public double getEstimatedHours(){
    return estimatedHours;
}
 */
// ----------------------------------------------------------
/**
 * Place a description of your method here.
 * @return
 */
/*
public int getPriority(){
    return priority;
}
 */
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

//>>>>>>> 5aa5616b516573e21a032ce88fed4dce43956183

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

