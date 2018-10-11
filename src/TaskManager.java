import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/**
 * TaskManager holds the collation of tasks and executes instructions from the user.
 *
 * @author Zhi Chen
 * @2018.10.12
 */
public class TaskManager{

    private ArrayList<Task> taskList;
    private HashMap<String, Integer> counter;

    /**
     * Initialise the collections used.
     */
    public TaskManager() {

        taskList = new ArrayList<>();
        counter = new HashMap<>(2);
        counter.put("toDo", 0);
        counter.put("done", 0);
    }

    /**
     * Mutator method that ensures that user is kept up to date with
     * total tasks done and tasks that pend action, using a HashMap.
     */
    public void setCounter() {

        Integer toDoValue = 0;
        Integer doneValue = 0;

        for (Task task : taskList) {
            if (!task.doneStatus()) {
                toDoValue++;
            } else {
                doneValue++;
            }
        }
        counter.put("toDo", toDoValue);
        counter.put("done", doneValue);
    }

    /**
     * Accessor method to retrieve number of undone tasks.
     *
     * @return Number of undone task from HashMap.
     */
    public Integer getToDO() {

        return counter.get("toDo");
    }

    /**
     * Accessor method to retrieve number of completed tasks.
     *
     * @return Number of completed task from HashMap.
     */
    public Integer getDone() {

        return counter.get("done");
    }

    /**
     * Displays all the successfully added tasks.
     */
    public void showTaskList() {
        for (Task task : taskList) {
            System.out.println(task);
        }
    }

    /**
     * Provides access to the collection of tasks.
     *
     * @return ArrayList of Task
     */
    public ArrayList<Task> getTaskList() {

        return taskList;
    }

    /**
     * Sorts the collection of tasks via their due date.
     * Requires Comparable data type, Date, in this case.
     * Requires function compareTo in Task class.
     */
    public void sortByDate() {

        Collections.sort(taskList);
        for (Task task : taskList) {
            System.out.println(task);
        }

    }

    /**
     * Displays all the project titles to provide visual aid to the user.
     * HashSet is used as it ensure uniqueness.
     *
     * @return A concise list of all project available.
     */
    public HashSet<String> listOfProjectTitle() {

        HashSet<String> projectList = new HashSet<>();
        for (Task task : taskList) {
            projectList.add(task.getProjectTitle());
        }
        return projectList;
    }

    /**
     * Displays all tasks under selected project.
     * Handles NullPointer Exception here.
     *
     * @param projectTitle User input.
     */
    public void filterByProject(String projectTitle) {

        try {
            taskList.stream()
                    .filter(s -> projectTitle.equals(s.getProjectTitle()))
                    .forEach(s -> System.out.println(s.toString()));
        } catch (NullPointerException e) {
            for (Task task : taskList) {
                if (task.getDueDate() == null) {
                    task.setDueDate("01-Jan-0001");
                }
            }
        }
    }

    /**
     * Validation check on user input of project title.
     *
     * @param projectTitle User input.
     * @return Boolean result
     */
    public boolean doesProjectExist(String projectTitle) {
        for (Task task : taskList) {
            if (task.getProjectTitle().equals(projectTitle)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Identification of task's index in collection using its parameters;
     * project title and task title.
     * Notification of a new addition if task title is not found.
     *
     * @param project   User input.
     * @param taskTitle User input.
     * @return any integer value from and including 0 to less than size of collection or
     *         '-1' which indicates a new task.
     */
    public int selectTask(String project, String taskTitle) {

        int indexOfSelected = -1;
        if (doesProjectExist(project)) {
            for (int i = 0; i < taskList.size(); i++) {
                String titleFromList = taskList.get(i).getTitle();
                if (taskTitle.equals(titleFromList)) {
                    indexOfSelected = i;
                }
            }
        }
        return indexOfSelected; // -1 means new task;
    }

    /**
     * Checks the specified task's status.
     *
     * @param indexOfSelected Task identifier.
     * @return String status of task.
     */
    public String getTaskStatus(int indexOfSelected) {

        return taskList.get(indexOfSelected).getStatus();
    }

    /**
     * Logs in the task's parameters as object Task into collection.
     *
     * @param task Task requires all its parameter in order of task title,
     *             due date, description and its project title. It's status is set
     *             "Pending action" when it is first created.
     */
    public void addTask(Task task) {

        taskList.add(task);
    }

    /**
     * Updates project title.
     *
     * @param indexOfSelected Index of specified task.
     * @param newProjectTitle Information to replace the current information.
     */
    public void changeProject(int indexOfSelected,
                              String newProjectTitle) {
        this.taskList.get(indexOfSelected).setProjectTitle(newProjectTitle);
    }

    /**
     * Updates task title.
     *
     * @param indexOfSelected Index of specified task.
     * @param newTaskTitle    Information to replace the current information.
     */
    public void changeTaskTitle(int indexOfSelected,
                                String newTaskTitle) {
        this.taskList.get(indexOfSelected).setTitle(newTaskTitle);
    }

    /**
     * Updates deadline of task.
     *
     * @param indexOfSelected Index of specified task.
     * @param newDueDate      Information to replace the current information.
     */
    public void changeDueDate(int indexOfSelected,
                              String newDueDate) {
        this.taskList.get(indexOfSelected).setDueDate(newDueDate);
    }

    /**
     * Updates task description.
     *
     * @param indexOfSelected Index of specified task.
     * @param newDescription  Information to replace the current information.
     */
    public void changeDescription(int indexOfSelected,
                                  String newDescription) {
        this.taskList.get(indexOfSelected).setDescription(newDescription);
    }

    /**
     * Flip switch style to change task status.
     *
     * @param indexOfSelected Index of specified task.
     */
    public void changeStatus(int indexOfSelected) {
        boolean taskIsCompleted = this.taskList.get(indexOfSelected).doneStatus();
        if (taskIsCompleted) {
            taskList.get(indexOfSelected).taskReset();
        } else taskList.get(indexOfSelected).taskDone();
    }


}
