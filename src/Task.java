import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This Task class models object task with all its component.
 * It provides a platform to provide the mould of how a task should
 * be created and access to each of the components in a task for
 * any update necessary.
 *
 * @author Zhi Chen
 * @2018.10.12
 */
public class Task implements Comparable<Task> {


    private String title;
    private Date dueDate;
    private String description;
    private String projectTitle;
    private boolean done;

    /**
     * Collects information needed for Task.
     *
     * @param title       Summary of required task.
     * @param dueDate     Deadline of Task.
     * @param description Detailed information of Task.
     */
    public Task(String title, String dueDate,
                String description, String projectTitle) {

        this.title = title;
        this.dueDate = createDate(dueDate);
        this.description = description;
        this.projectTitle = projectTitle;
        this.done = false;
    }

    /**
     * Accessor method for title of task.
     *
     * @return String title.
     */
    public String getTitle() {

        return title;
    }

    /**
     * Mutator method to set new task title.
     *
     * @param newTitle User entry for new task title
     */
    public void setTitle(String newTitle) {

        this.title = newTitle;
    }

    /**
     * Conversion of String dueDate to Date type.
     *
     * @param dueDate User entry in String format: dd-MMM-yyyy
     * @return dueDate of type Date.
     */
    private Date createDate(String dueDate) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

        try {
            return formatter.parse(dueDate);
        } catch (ParseException e) {
            System.err.println("Invalid Deadline. Please update with " +
                    "valid date format under Edit function.");
            return null;
        }
    }

    /**
     * Accessor for deadline.
     *
     * @return dueDate of Date type.
     */
    public Date getDueDate() {

        return dueDate;
    }

    /**
     * Mutator method to set new deadline.
     *
     * @param newDueDate Collects String dueDate from user and converts
     *                   its type to Date.
     */
    public void setDueDate(String newDueDate) {

        this.dueDate = createDate(newDueDate);
    }

    /**
     * Acessor for details of Task.
     *
     * @return Additional information of task.
     */
    public String getDescription() {

        return description;
    }

    /**
     * Mutator method to edit additional information of task.
     *
     * @param newDescription Edition to task description.
     */
    public void setDescription(String newDescription) {

        this.description = newDescription;
    }

    /**
     * Accessor method for Project Title.
     *
     * @return The project task is currently under.
     */
    public String getProjectTitle() {

        return projectTitle;
    }

    /**
     * Mutator method to change task to another project.
     *
     * @param newProjectTitle Project that task is shifted to.
     */
    public void setProjectTitle(String newProjectTitle) {

        this.projectTitle = newProjectTitle;
    }

    /**
     * Accessor method with print line to indicate if task is completed.
     *
     * @return Verification of task status.
     */
    public String getStatus() {
        if (!done) {
            return "Pending action.";
        } else {
            return "Completed.";
        }
    }

    /**
     * Accessor method to get boolean status of task.
     *
     * @return The status of task.
     */
    public boolean doneStatus() {

        return done;
    }

    /**
     * Mutator method to change status of task to completed.
     *
     * @return Task completed.
     */
    public boolean taskDone() {

        return done = true;
    }

    /**
     * Mutator method to change status of task to pending.
     *
     * @return Task pending.
     */
    public boolean taskReset() {

        return done = false;
    }

    /**
     * Accesor method to get String version of dueDate
     *
     * @return String format date
     */
    public String getDateToPrint() {

        try
        {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
            return formatter.format(dueDate);
        }
        catch(NullPointerException e)
        {
            System.err.println("Please update with acceptable information" +
                    " under Edit first.\n");
            return "01-Jan-0001";
        }
    }

    /**
     * Prints entire task details.
     *
     * @return Entire task details.
     */
    @Override
    public String toString() {

        String dateToPrint = getDateToPrint();
        String task = "Project Title: " + projectTitle + "\n" +
                "Task title: " + title + "\n" + "Deadline: " + dateToPrint + "\n" +
                "Description: " + description + "\n" + "Status: " + getStatus() + "\n";

        return task;
    }

    /**
     * Compares dueDate in task.
     *
     * @param task Task details input by user.
     * @return integer value used to compare the dueDates.
     */
    @Override
    public int compareTo(Task task) {

        return this.dueDate.compareTo(task.getDueDate());
    }
}
