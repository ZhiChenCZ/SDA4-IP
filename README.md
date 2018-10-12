SDA4-IP
=============
To-Do List Application allows user to keep track things(task) that they have to do.
In this program, the main features are as follows:
* Show the list of task.
* Add task to the program.
* Allow changes(updates) to be made to existing task
* Save all these information into a database, retrievable for later reference.

Getting started
----------------
toDoly is a fuss-free program that can be easily installed on your computer!

Simply 
1. Download the source codes Main.java, Task.java, TaskManager.java and View.java from ZhiChenCZ's repository on Github in one folder.
2. Open your terminal, compile the Main.java by typing 'javac Main.java' to get all the above mentioned java files into .class files.
3. Start toDoly on terminal type 'java Main' on the commandline.
 


Welcome to toDoly
------------------

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
                
User Manual
-------------

### Table of Contents

**1. Show Task List**

Shows all the tasks in order of input.
1. Sorts the tasks in order of ascending deadline.
2. Allows the user to filter out tasks under each project. 

**2. Add New Task**

1. Guides the user throughout the process of inputting a new task.
    + Any errors that might occur in the process of information input should be edited under "Edit Task".
    + Function ensures no repeats of Task Title.
    + Specific deadline format to be followed.

**3. Edit Task**

Selection of specific task to be updated or removed from toDoly.
1. Update parameters in task.
    1. Project title.
    2. Task title.
    3. Deadline.
    4. Description.
2. Update the status of task from 'Pending Action.' to 'Completed.' and vice versa.
3. To remove selected task.   

**4. Save and Quit**

1. Save all changes made to toDoly and quit the program.
2. To quit toDoly without saving any changes.

Built with
-----------            
* IntelliJ
* Lots of help from TAs

Author
------
Zhi Chen

Acknowledgements
-----------------
Lecturers and TA of SDA. ...Thank you for starting me on this journey!                 
                