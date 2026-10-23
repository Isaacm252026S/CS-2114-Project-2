
package todo;

/**
 * Recommends tasks based on priority and available time.
 *
 * @author Rohan Sampath
 * @version Oct 23, 2026
 */
public class DailyPlanner
{
    private TaskManager manager;

    /**
     * Creates a daily planner.
     *
     * @param taskManager
     *            the current task manager
     */
    public DailyPlanner(TaskManager taskManager)
    {
        manager = taskManager;
    }


    /**
     * Recommends tasks that fit in the available time.
     *
     * @param availableHours
     *            the user's free hours
     * @return the recommended daily plan
     */
    public String recommend(double availableHours)
    {
        if (availableHours <= 0 || Double.isNaN(availableHours)
            || Double.isInfinite(availableHours))
        {
            return "Please enter a positive number of hours.";
        }

        int total = manager.getSchoolTasks().size() + manager.getChores().size()
            + manager.getCustomTasks().size();

        if (total == 0)
        {
            return "No tasks available.";
        }

        String[] names = new String[total];
        double[] hours = new double[total];
        int[] priorities = new int[total];

        int index = 0;

        for (int i = 0; i < manager.getSchoolTasks().size(); i++)
        {
            SchoolAssignment task = manager.getSchoolTasks().get(i);
            names[index] = task.getName();
            hours[index] = task.getEstimatedHours();
            priorities[index] = task.getPriority();
            index++;
        }

        for (int i = 0; i < manager.getChores().size(); i++)
        {
            Chore task = manager.getChores().get(i);
            names[index] = task.getName();
            hours[index] = task.getEstimatedHours();
            priorities[index] = task.getPriority();
            index++;
        }

        for (int i = 0; i < manager.getCustomTasks().size(); i++)
        {
            CustomTask task = manager.getCustomTasks().get(i);
            names[index] = task.getName();
            hours[index] = task.getEstimatedHours();
            priorities[index] = task.getPriority();
            index++;
        }

        // Sort by highest priority, then shortest time.
        for (int i = 0; i < total - 1; i++)
        {
            for (int j = i + 1; j < total; j++)
            {
                if (priorities[j] > priorities[i]
                    || (priorities[j] == priorities[i] && hours[j] < hours[i]))
                {
                    int tempPriority = priorities[i];
                    priorities[i] = priorities[j];
                    priorities[j] = tempPriority;

                    double tempHours = hours[i];
                    hours[i] = hours[j];
                    hours[j] = tempHours;

                    String tempName = names[i];
                    names[i] = names[j];
                    names[j] = tempName;
                }
            }
        }

        String result = "===== DAILY PLAN =====\n";
        double remaining = availableHours;
        int count = 0;

        for (int i = 0; i < total; i++)
        {
            if (hours[i] > 0 && !Double.isNaN(hours[i])
                && !Double.isInfinite(hours[i]) && hours[i] <= remaining)
            {
                result += names[i] + " | Priority: " + priorities[i]
                    + " | Hours: " + hours[i] + "\n";

                remaining -= hours[i];
                count++;
            }
        }

        if (count == 0)
        {
            result += "No tasks fit your available time.\n";
        }

        result += "Total planned hours: " + (availableHours - remaining) + "\n";
        result += "Remaining hours: " + remaining;

        return result;
    }
}
