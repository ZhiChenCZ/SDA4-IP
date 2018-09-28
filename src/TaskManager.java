import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

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

        int toDoValue = 0;
        int doneValue = 0;

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

        return counter.get("toDO");
    }

    public Integer getDone(){

        return counter.get("done");
    }

    public void showTaskList(){

        for(Task task : taskList){
            System.out.println(task);
        }
    }

    private void sortByDate(){

        Collections.sort(taskList);
    }

    public ArrayList<Task> getTaskListSortedDate(){

        sortByDate();
        return taskList;
    }

    public void filterByProject(String projectTitle){

        taskList.stream()
                .filter(s -> projectTitle.equals(s.getProjectTitle()))
                .forEach(s -> System.out.println(s.toString()));

        /*taskList.forEach(
                (Task task) -> {
                    if(task.getProjectTitle().contains(projectTitle)){
                        System.out.println(toString());
                    }
                }
        );*/
    }

    public void addTask(Task task){

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
