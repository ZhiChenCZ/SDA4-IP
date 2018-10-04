import java.util.InputMismatchException;
import java.util.Scanner;

public class Welcome{

    private boolean finished;
    private TaskManager taskManager;
    private Scanner read;
    private Scanner scanner;

    public Welcome(TaskManager taskManager){

        finished = false;
        this.taskManager = taskManager;
        read = new Scanner(System.in);
        scanner = new Scanner(System.in);
    }

    public String printWelcome(){

        return (">> Welcome to ToDoly\n" +
                ">> You have " + taskManager.getToDO() + " tasks todo and " +
                taskManager.getDone() + " tasks are done!\n" +
                ">> Pick an option:\n" +
                ">> (1) Show Task List (by date or project)\n" +
                ">> (2) Add New Task\n" +
                ">> (3) Edit Task (update, mark as done,remove)\n" +
                ">> (4) Save and Quit\n" +
                ">>\n" +
                "\n" +
                "Please enter number corresponding to function required.");

    }

    private int checkForIntegerValue(){

        int choice;
        while(true){
            if (read.hasNextInt()){
                choice = read.nextInt();
                break;
            } else{
                System.out.print("Please enter integer value as seen in above Menu.\n> ");
                read.next(); // not nextInt else InputMismatchException is thrown.
                continue; //within the loop.
            }
        }
        return choice;
     }

    public void toDoly(){

        while(!finished){

            taskManager.setCounter();
            System.out.println(printWelcome());
            System.out.print("> ");
            int choice;
            choice = checkForIntegerValue();
            //checkIntegerValidity(choice); Not needed as there is default case?

            switch (choice){

                case 1: taskManager.showTaskList();
                menuOption1();
                break;

                case 2: menuOption2();
                break;

                case 3: menuOption3();
                break;

                case 4: menuOption4(); // to quit, finished = true;
                break;

                default:
                    System.out.println("Please choose an integer corresponding to " +
                            "the function you need.\n" +
                            "If you would like to exit, please choose option" +
                            "4 and follow the instructions given.");
                break;
            }
        }
    }

        private void callForValidInput(){

            System.out.println("Please enter valid value as shown in Menu.");
            System.out.print("> ");
        }

        private void menuOption1() {

            boolean quit = false;
            while(!quit){
                System.out.println("> Pick an option:\n" +
                        "> (1)To sort tasks by date.\n" +
                        "> (2)To filter by project.\n" +
                        "> (3)To return to Main Menu.");
                System.out.print("> ");
                int command;
                command = checkForIntegerValue();

                switch (command) {

                    case 1:
                        taskManager.sortByDate();
                        break;

                    case 2:
                        for(String projectTitle : taskManager.listOfProjectTitle()){
                            System.out.println(projectTitle);
                        }
                        System.out.print("Please enter the exact project title that" +
                                " you would like tasks to be filtered out by.\n> ");
                        //Scanner scanner = new Scanner(System.in);
                        String projectName;
                        projectName = scanner.nextLine();
                        if(taskManager.doesTaskExist(projectName)){
                            taskManager.filterByProject(projectName);
                        } else {
                            System.out.println("Project not found.");
                        }
                        break;

                    case 3:
                        quit = true;
                        break;

                    default:
                        System.out.println("Please choose an integer corresponding to " +
                                "the function you need.\n" +
                                "If you would like to return to Main Menu, " +
                                "please choose option 3.");
                        break;
                }
            }
        }

        private void menuOption2(){

        boolean quit = false;
        while(!quit){
            System.out.print("> Pick an option:\n" +
                    "> (1)To add a new task.\n" +
                    "> (2)To return to Main Menu.\n> ");
            int command;
            command = checkForIntegerValue();

            switch (command){

                case 1:
                    System.out.println("Please enter the information as guided.");
                    System.out.print("Project Title: ");
                    String projectTitle = scanner.nextLine();
                    System.out.print("Task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Format example: 30(dd)-12(mm)-2018(yyyy)\n" +
                            "Deadline: ");
                    String dueDate = scanner.nextLine();
                    System.out.print("Description: ");
                    String description = scanner.nextLine();

                    int currentNumberOfUndoneTask = taskManager.getToDO();
                    taskManager.taskAddition(title,dueDate,description,projectTitle);
                    taskManager.setCounter();
                    if(currentNumberOfUndoneTask < taskManager.getToDO()){
                        System.out.println("Task was successfully added.");
                    } else {
                        System.out.println("Please try again.");
                    }
                    // throw Parse exception to Task
                    break;

                case 2:
                    quit = true;
                    break;

                default:
                    System.out.println("Please choose an integer corresponding to " +
                            "the function you need.\n" +
                            "If you would like to return to Main Menu, " +
                            "please choose option 2.");
                    break;
                 }
            }
        }

        private void menuOption3(){} // Edit task

        private void menuOption4(){} //Save and Quit

}
