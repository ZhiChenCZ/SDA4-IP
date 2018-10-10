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

    public TaskManager() {

        taskList = new ArrayList<>();
        counter = new HashMap<>(2);
        counter.put("toDo", 0);
        counter.put("done", 0);
    }

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

    public Integer getToDO() {

        return counter.get("toDo");
    }

    public Integer getDone() {

        return counter.get("done");
    }

    public void showTaskList() {

        for (Task task : taskList) {
            System.out.println(task);
        }
    }

    public ArrayList<Task> getTaskList() {

        return taskList;
    }

    public void sortByDate() {

        Collections.sort(taskList);
        for (Task task : taskList) {
            System.out.println(task);
        }
    }

    public HashSet<String> listOfProjectTitle() {

        HashSet<String> projectList = new HashSet<>();
        for (Task task : taskList) {
            projectList.add(task.getProjectTitle());
        }
        return projectList;
    }

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

    public boolean doesProjectExist(String project) {
        for (Task task : taskList) {
            if (task.getProjectTitle().equals(project)) {
                return true;
            }
        }
        return false;
    }

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

    public String getTaskStatus(int indexOfSelected) {

        return taskList.get(indexOfSelected).getStatus();
    }

    public void addTask(Task task) {

        taskList.add(task);// used for testing in Main
    }

    public void changeProject(int indexOfSelected,
                              String newProjectTitle) {
        this.taskList.get(indexOfSelected).setProjectTitle(newProjectTitle);
    }

    public void changeTaskTitle(int indexOfSelected,
                                String newTaskTitle) {
        this.taskList.get(indexOfSelected).setTitle(newTaskTitle);
    }

    public void changeDueDate(int indexOfSelected,
                              String newDueDate) {
        this.taskList.get(indexOfSelected).setDueDate(newDueDate);
    }

    public void changeDescription(int indexOfSelected,
                                  String newDescription) {
        this.taskList.get(indexOfSelected).setDescription(newDescription);
    }

    public void changeStatus(int indexOfSelected) {
        boolean taskIsCompleted = this.taskList.get(indexOfSelected).doneStatus();
        if (taskIsCompleted) {
            taskList.get(indexOfSelected).taskReset();
        } else taskList.get(indexOfSelected).taskDone();
    }
}
