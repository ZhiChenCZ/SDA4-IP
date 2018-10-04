import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class TaskManager{

    private ArrayList<Task> taskList;
    private HashMap<String, Integer> counter;

    public TaskManager(){

        taskList = new ArrayList<>();
        counter = new HashMap<>(2);
        counter.put("toDo", 0);
        counter.put("done", 0);
    }

    public void setCounter(){

        Integer toDoValue = 0;
        Integer doneValue = 0;

        for (Task task : taskList) {
            if (!task.doneStatus()){
                toDoValue++ ;
            } else {
                doneValue++;
            }
        }
        counter.put("toDo", toDoValue);
        counter.put("done", doneValue);
    }

    public Integer getToDO(){

        return counter.get("toDo");
    }

    public Integer getDone(){

        return counter.get("done");
    }

    public void showTaskList(){

        for(Task task : taskList){
            System.out.println(task);
        }
    }

    public ArrayList<Task> getTaskList(){

        return taskList;
    }

    public void sortByDate(){

        Collections.sort(taskList);
        for(Task task : taskList){
            System.out.println(task);
        }
    }

    public HashSet<String> listOfProjectTitle(){

        HashSet<String> projectList = new HashSet<>();
        for(Task task : taskList){
            projectList.add(task.getProjectTitle());
        }
        return projectList;
    }

    public void filterByProject(String projectTitle){

        taskList.stream()
                .filter(s -> projectTitle.equals(s.getProjectTitle()))
                .forEach(s -> System.out.println(s.toString()));

    }

    public boolean doesTaskExist(String project){
        for (Task task: taskList) {
            if (task.getProjectTitle().equals(project)) {
                return true;
            }
        }
        return false;
    }

    public void addTask(Task task){

        taskList.add(task);// used for testing in Main
    }

    public void taskAddition(String title, String dueDate,
                             String description, String projectTitle){

        Task task = new Task(title,dueDate,description,projectTitle);
        taskList.add(task);
    }

    public void editTask(String projectTitle){

        //To specify Task as there may be multiple tasks sharing the same title.
        ArrayList<Task> narrowedList = new ArrayList<>();
        for(Task task : taskList){
            if (task.getProjectTitle().equals(projectTitle)){
                narrowedList.add(task);
            }
        }
    }

    /*public void updateTitle(String title, String newTitle){

        getNarrowedList();
        for(Task task : narrowedList){
            if (task.getTitle().equals(title)){
                task.setTitle(newTitle);
            }
        }
    }*/



}
