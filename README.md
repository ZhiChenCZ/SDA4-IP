Emphasis, aka italics, with *asterisks* or _underscores_.

Strong emphasis, aka bold, with **asterisks** or __underscores__.

Combined emphasis with **asterisks and _underscores_**.

1. First ordered list item
2. Another item
⋅⋅* Unordered sub-list. 
1. Actual numbers don't matter, just that it's a number
⋅⋅1. Ordered sub-list
..2. what sorcery is this
4. And another item.

⋅⋅⋅You can have properly indented paragraphs within list items. Notice the blank line above, and the leading spaces (at least one, but we'll use three here to also align the raw Markdown).

⋅⋅⋅To have a line break without a paragraph, you will need to use two trailing spaces.⋅⋅
⋅⋅⋅Note that this line is separate, but within the same paragraph.⋅⋅
⋅⋅⋅(This is contrary to the typical GFM line break behaviour, where trailing spaces are not required.)

SDA4-IP
=============
To-Do List Application allows user to keep track things(task) that they have to do.
In this program, the main features are as follows:
* Show the list of task.
* Add task to the program.
* Allow changes(updates) to be made to existing task
* Save all these information into a database.

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

####1. Option1
Shows all the tasks in order of input.
.. 1.1 Sorts the tasks in order of ascending deadline.
.. 1.2 Allows the user to filter out tasks under each project. 
#####
####2. Option2
####3. Option3
####4. Option4

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
                