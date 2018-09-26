public class Welcome {

    private int toDO = 0;
    private int done = 0;
    // Add in Counter variable and as parameter for constructor
    //later
    //public Welcome (){}

    public String printWelcome(){

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
