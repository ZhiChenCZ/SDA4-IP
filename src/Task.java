import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Collation of all information for a Task from User.
 *
 * @author Zhi Chen
 * @version 2018.09.22
 */
public class Task implements Comparable<Task>{


    private String title;
    private Date dueDate;
    private String description;
    private String projectTitle;
    private boolean done;

    /**
     * Collects information needed for Task.
     * @param title Summary of required task.
     * @param dueDate Deadline of Task.
     * @param description Detailed information of Task.
     */
    public Task(String title, String dueDate,
                String description, String projectTitle){

        this.title = title;
        this.dueDate = createDate(dueDate);
        this.description = description;
        this.projectTitle =projectTitle;
        this.done = false;
    }

    /**
     * Accessor method for title of task.
     * @return String title.
     */
    public String getTitle(){

        return title;
    }

    public void setTitle(String newTitle){

        this.title = newTitle;
    }

    private Date createDate(String dueDate) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

        try
        {
            return formatter.parse(dueDate);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Accessor for deadline.
     * @return
     */
    public Date getDueDate(){

        return dueDate;
    }

    public void setDueDate(String newDueDate){

        this.dueDate = createDate(newDueDate);
    }

    /**
     * Acessor for details of Task.
     * @return
     */
    public  String getDescription(){

        return description;
    }

    public void setDescription(String newDescription) {

        this.description = newDescription;
    }

    /**
     * Accessor for Project Title.
     * @return
     */
    public String getProjectTitle(){

        return projectTitle;
    }

    public void setProjectTitle(String newProjectTitle){

        this.projectTitle = newProjectTitle;
    }

    public String getStatus(){
        if (!done){
            return "Pending action.";
        } else {
            return "Completed.";
        }
    }

    public boolean doneStatus(){

        return done;
    }

    public boolean taskDone(){

        return done = true;
    }

    public boolean taskReset(){

        return done = false;
    }

    @Override
    public String toString(){

        String task = "Project Title: " + projectTitle + "\n" +
                "Task title: "+ title + "\n" + "Deadline: "+ dueDate + "\n" +
                "Description: " + description + "\n" + "Status: " + getStatus();

        return task;
    }

    @Override
    public int compareTo(Task task){
        
        return dueDate.compareTo(getDueDate());
    }
}
