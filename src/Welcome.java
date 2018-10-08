import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Welcome{

    private boolean finished;
    private TaskManager taskManager;
    private Scanner read;
    private Scanner scanner;

    public Welcome(TaskManager taskManager){

        finished = false;
        this.taskManager = taskManager;
        read = new Scanner(System.in); // reads integer
        scanner = new Scanner(System.in); // reads String
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

    private void retrieveFile(){

        String project = "start";
        String title;
        String dueDate;
        String description;
        String status;

        Charset charset = Charset.forName("US-ASCII");
        Path path = Paths.get("toDoly List");
        try(BufferedReader reader =
                    Files.newBufferedReader(path, charset)) {

            while (project != null) {

                for(int i = 0; i < 5; i++){
                  project = reader.readLine();
                  i++;
                  title = reader.readLine();
                  i++;
                  dueDate = reader.readLine();
                  i++;
                  description = reader.readLine();
                  i++;
                  status = reader.readLine();

                  Task task = new Task(title, dueDate, description, project);
                  taskManager.addTask(task);
                  if(status.equals("Completed.")){
                      task.taskDone();
                  }
                  i++;
                }
            }
        }
        catch (NullPointerException e){

            System.err.println("At ToDoly, we aim to help you keep " +
                    "track of all things,big or small!");
        }
        catch(FileNotFoundException e){

            System.err.println("File not found. Please add task and save your first copy.");
        }
        catch(IOException e){

            System.err.println("Welcome to your first session of toDoly!\n");
        }
    }

    private void createFile(Task task){

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("ToDoly List"))){

            writer.write(task.getProjectTitle());
            writer.write('\n');
            writer.write(task.getTitle());
            writer.write('\n');
            writer.write(task.getDateToPrint());
            writer.write('\n');
            writer.write(task.getDescription());
            writer.write('\n');
            writer.write(task.getStatus());
            writer.write('\n');

        } catch (IOException e){
            System.err.println("There was a problem saving.");
        }
    }

    public void toDoly(){

        retrieveFile();
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
        System.out.println("Thank you for using toDoly! Vi ses snart!");
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
                        if(taskManager.doesProjectExist(projectName)){
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
                    "> (1) To add a new task.\n" +
                    "> (2) To return to Main Menu.\n> ");
            int command;
            command = checkForIntegerValue();

            switch (command){

                case 1:
                    System.out.println("Please enter the information as guided.");
                    System.out.print("Project Title: ");
                    String projectTitle = scanner.nextLine();
                    System.out.print("Task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Format example: 30(dd)-Dec(mm)-2018(yyyy)\n" +
                            "Deadline: ");
                    String dueDate = scanner.nextLine();
                    System.out.print("Description: ");
                    String description = scanner.nextLine();

                    createFile(new Task(title,dueDate,description,projectTitle));
                    int currentNumberOfUndoneTask = taskManager.getToDO();
                    taskManager.addTask(new Task(title,dueDate,description,projectTitle));
                    taskManager.setCounter();
                    if(currentNumberOfUndoneTask < taskManager.getToDO()){
                        System.out.println("Task was successfully added.");
                    } else {
                        System.out.println("Please try again.");
                    }
                    // throw Parse exception to Task for DATE
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

    private void menuOption3(){

        boolean quit = false;
            while(!quit){

                System.out.print("Please enter Project Title, of which," +
                        "you wish to update.\n> ");
                System.out.println(taskManager.listOfProjectTitle());
                String projectName = scanner.nextLine();

                if(!taskManager.doesProjectExist(projectName)){
                    System.out.println("Invalid Project Title.");
                    quit = true;
                }

                System.out.print("Please enter Task Title, of which," +
                        "you wish to update.\n> ");
                taskManager.filterByProject(projectName);
                String taskTitle = scanner.nextLine();
                int indexOfTask = taskManager.selectTask(projectName, taskTitle);

                if(indexOfTask == -1){
                    System.out.println("Invalid Task Title.");
                    quit = true;
                }

                System.out.print("> Pick an option:\n" +
                        "> (1) To update a task.\n" +
                        "> (2) To mark a task as done or undone.\n" +
                        "> (3) To remove a task.\n" +
                        "> (4) To return to Main Menu.\n> ");
                int command;
                command = checkForIntegerValue();

                switch (command){

                    case 1:
                        boolean editChoice = false;
                        while(!editChoice) {

                            System.out.print("> Pick a task specific that you would like to update:\n" +
                                    "> (1) Project Title.\n" + // for selected task
                                    "> (2) Task Title.\n" +
                                    "> (3) Deadline\n" +
                                    "> (4) Description.\n" +
                                    "> (5) To go back to Edit Menu.\n> ");
                            int editChoiceNumber;
                            editChoiceNumber = checkForIntegerValue();

                            switch (editChoiceNumber){

                                case 1:
                                    System.out.print("Please enter the new Project Title for previously" +
                                            "selected task.\n> ");
                                    String newProjectTitle = scanner.nextLine();
                                    taskManager.getTaskList().get(indexOfTask).setProjectTitle(newProjectTitle);
                                    System.out.println(taskManager.getTaskList().get(indexOfTask));
                                    break;

                                case 2:
                                    System.out.print("Please enter the new Task Title for previously" +
                                            "selected task.\n> ");
                                    String newTaskTitle = scanner.nextLine();
                                    taskManager.getTaskList().get(indexOfTask).setTitle(newTaskTitle);
                                    System.out.println(taskManager.getTaskList().get(indexOfTask));
                                    break;

                                case 3:
                                    System.out.print("Please enter the new Deadline in format of" +
                                            "dd-mmm-yyyy (such as 12-Dec-2012).\n> ");
                                    String newDueDate = scanner.nextLine();
                                    taskManager.getTaskList().get(indexOfTask).setDueDate(newDueDate);
                                    System.out.println(taskManager.getTaskList().get(indexOfTask));
                                    break;

                                case 4:
                                    System.out.println(taskManager.getTaskList().get(indexOfTask));
                                    System.out.print("Please enter your new description for selected task.\n> ");
                                    String newDescription = scanner.nextLine();
                                    taskManager.getTaskList().get(indexOfTask).setDescription(newDescription);
                                    System.out.println(taskManager.getTaskList().get(indexOfTask));
                                    break;

                                case 5:
                                    editChoice = true;
                                    break;

                                default:
                                    System.out.println("Please choose an integer corresponding to " +
                                            "the function you need.\n" +
                                            "If you would like to exit this function, please choose option" +
                                            "5 and follow the instructions given.");
                                    break;
                            }
                        }
                        break;

                    case 2:
                        System.out.println("The current status of the project is "
                                + taskManager.getTaskList().get(indexOfTask).getStatus());
                        if(taskManager.getTaskList().get(indexOfTask).doneStatus()){
                            taskManager.getTaskList().get(indexOfTask).taskDone();
                        } else taskManager.getTaskList().get(indexOfTask).taskReset();
                        System.out.println("The status of the project has been changed to: "
                                + taskManager.getTaskList().get(indexOfTask).getStatus());
                        break;

                    case 3:
                        System.out.println("Please confirm that the following task selected is the task" +
                                "you wish to remove from your list.");
                        System.out.println(taskManager.getTaskList().get(indexOfTask));
                        System.out.print("Type '1' to confirm.\n> ");

                        int removeConfirmation = checkForIntegerValue();
                        if(removeConfirmation == 1){

                            taskManager.getTaskList().remove(indexOfTask);
                        } else System.out.println("Task was not removed. Please feel" +
                                "free to select another Task for editing.");
                        break;

                    case 4:
                        quit = true;
                        break;

                    default:
                        System.out.println("Please choose an integer corresponding to " +
                                "the function you need.\n" +
                                "If you would like to return to Main Menu, " +
                                "please choose option 4.");
                        break;
                }
            }
        }

    private void menuOption4(){

        System.out.println(taskManager.getTaskList());
            for (Task task : taskManager.getTaskList()){
                createFile(task);
                finished = true;
            }
        } //Save and Quit

}
