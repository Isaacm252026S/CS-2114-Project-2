package todo;

/**
 * Stores and manages the application's task lists.
 *
 * @author Rohan Sampath
 * @version Oct 23, 2026
 */
public class TaskManager
{
    private LinkedChain<SchoolAssignment> schoolTasks;
    private LinkedChain<Chore> chores;
    private LinkedChain<CustomTask> customTasks;

    public TaskManager()
    {
        schoolTasks = new LinkedChain<SchoolAssignment>();
        chores = new LinkedChain<Chore>();
        customTasks = new LinkedChain<CustomTask>();
    }


    public void addSchoolAssignment(SchoolAssignment task)
    {
        schoolTasks.addToEnd(task);
    }


    public void addChore(Chore task)
    {
        chores.addToEnd(task);
    }


    public void addCustomTask(CustomTask task)
    {
        customTasks.addToEnd(task);
    }


    public int getSchoolTaskCount()
    {
        return schoolTasks.size();
    }


    public int getChoreCount()
    {
        return chores.size();
    }


    public int getCustomTaskCount()
    {
        return customTasks.size();
    }


    public SchoolAssignment getSchoolAssignment(int index)
    {
        return schoolTasks.get(index);
    }


    public Chore getChore(int index)
    {
        return chores.get(index);
    }


    public CustomTask getCustomTask(int index)
    {
        return customTasks.get(index);
    }


    public boolean removeSchoolAssignment(int index)
    {
        if (index < 0 || index >= schoolTasks.size())
        {
            return false;
        }
        SchoolAssignment task = schoolTasks.get(index);
        return schoolTasks.remove(task);
    }


    public boolean removeChore(int index)
    {
        if (index < 0 || index >= chores.size())
        {
            return false;
        }
        Chore task = chores.get(index);
        return chores.remove(task);
    }


    public boolean removeCustomTask(int index)
    {
        if (index < 0 || index >= customTasks.size())
        {
            return false;
        }
        CustomTask task = customTasks.get(index);
        return customTasks.remove(task);
    }


    public void viewSchoolAssignments()
    {
        if (schoolTasks.isEmpty())
        {
            System.out.println("No school Assignments.");
            return;
        }
        for (int i = 0; i < schoolTasks.size(); i++)
        {
            System.out.println((i + 1) + ". " + schoolTasks.get(i));
        }
    }


    public void viewChores()
    {
        if (chores.isEmpty())
        {
            System.out.println("No chores.");
            return;
        }
        for (int i = 0; i < chores.size(); i++)
        {
            System.out.println((i + 1) + ". " + chores.get(i));
        }
    }


    public void viewCustomTasks()
    {
        if (customTasks.isEmpty())
        {
            System.out.println("No custom tasks.");
            return;
        }
        for (int i = 0; i < customTasks.size(); i++)
        {
            System.out.println((i + 1) + ". " + customTasks.get(i));
        }
    }


    public LinkedChain<SchoolAssignment> getSchoolTasks()
    {
        return schoolTasks;
    }


    public LinkedChain<Chore> getChores()
    {
        return chores;
    }


    public LinkedChain<CustomTask> getCustomTasks()
    {
        return customTasks;
    }
}
