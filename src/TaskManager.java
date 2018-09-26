import java.util.ArrayList;
import java.util.HashMap;

public class TaskManager implements Comparable<Task>{

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

    @Override
    public int compareTo(Task task){

        return 0;
    }

    public void sortByDate(){


    }

    public void addTask(Task task){

        taskList.add(task);
    }

}
