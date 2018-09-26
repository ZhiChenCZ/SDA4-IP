import java.util.Iterator;

/**
 * Collation of all information for a Task from User.
 *
 * @author Zhi Chen
 * @version 2018.09.22
 */
public class Create {


    private String title;
    private String dueDate;
    private String description;
    private String projectTitle;
    private boolean done;

    /**
     * Collects information needed for Task.
     * @param title Summary of required task.
     * @param dueDate Deadline of Task.
     * @param description Detailed information of Task.
     */
    public Create(String tile, String dueDate,
                  String description, String projectTitle){

        this.title = tile;
        this.dueDate = dueDate;
        this.description = description;
        this.projectTitle =projectTitle;
        this.done = false;
    }

    /**
     * Accessor for Task title.
     * @return
     */
    public String getTaskTitle(){

        return title;
    }

    public void setTitle(String newTitle){

        this.title = newTitle;
    }

    /**
     * Accessor for Project Title.
     * @return
     */
    public String getProjectTitle(){

        return projectTitle;
    }

    /**
     * Accessor for deadline.
     * @return
     */
    public String getDueDate(){

        return dueDate;
    }

    public void setDueDate(String newDueDate){

        this.dueDate = newDueDate;
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

    public boolean getStatus(){

        return done;
    }

    public boolean taskDone(){

        return done = true;
    }
}
