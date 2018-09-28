public class Welcome{

    private int toDO;
    private int done;

    public Welcome(){

        TaskManager taskManager = new TaskManager();
        this.toDO = taskManager.getToDO();
        this.done = taskManager.getDone();
    }

    @Override
    public String toString(){

        return (">> Welcome to ToDoly\n" +
                ">> You have " + toDO + " tasks todo and " +
                done + " tasks are done!\n" +
                ">> Pick an option:\n" +
                ">> (1) Show Task List (by date or project\n" +
                ">> (2) Add New Task\n" +
                ">> (3) Edit Task (update, mark as done,remove)\n" +
                ">> (4) Save and Quit\n" +
                ">>");

    }


}
