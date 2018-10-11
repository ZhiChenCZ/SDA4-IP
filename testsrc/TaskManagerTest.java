import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {

    private TaskManager tm;

    @BeforeEach
    void setup() {
        tm = new TaskManager();
    }

    @Test
    void setCounter() {
        tm.addTask(new Task("task1","01-Jan-2012", "hello there!", "P"));
        tm.addTask(new Task("task2","01-Dec-2012", "same date", "P2"));
        tm.addTask(new Task("task1","10-Feb-2012", "same task title!", "P3"));

        tm.setCounter();
        int numberOfYetDone = tm.getToDO();
        int numberDone = tm.getDone();
        assertEquals(3,numberOfYetDone);
        assertEquals(0,numberDone);
    }

    @Test
    void testSetCounterWithZeroAddedTasks() {

        int todo, done;
        todo = tm.getToDO();
        done = tm.getDone();
        assertEquals(0, todo);
        assertEquals(0, done);
    }

    @Test
    void testSetCounterWithAddedTasks() {

        int todo, done;
        todo = tm.getToDO();
        done = tm.getDone();
        assertEquals(0, todo);
        assertEquals(0, done);


        Task t1 = new Task("task1","01-Dec-2012", "hello there!", "P");

        tm.addTask(t1);

        tm.setCounter();

        todo = tm.getToDO();
        done = tm.getDone();
        assertEquals(1, todo);
        assertEquals(0, done);


        t1.taskDone();
        tm.setCounter();

        todo = tm.getToDO();
        done = tm.getDone();
        assertEquals(0, todo );
        assertEquals(1, done);

    }

    @Test
    void getToDO() {

        tm.addTask(new Task("task1","01-Jan-2012", "hello there!", "P"));
        tm.addTask(new Task("task2","01-Feb-2012", "same date", "P2"));
        tm.addTask(new Task("task1","10-Mar-2012", "same task title!", "P3"));
        int check = tm.getToDO();
        assertEquals(3,check);
    }

    @Test
    void getDone() {
        tm.addTask(new Task("task1","01-Sep-2012", "hello there!", "P"));
        tm.addTask(new Task("task2","01-Oct-2012", "same date", "P2"));
        tm.addTask(new Task("task1","10-Nov-2012", "same task title!", "P3"));

        int check = tm.getDone();
        tm.setCounter();
        assertEquals(1,check);
    }

    @Test
    void showTaskList() {

    }

    @Test
    void getTaskList() {
    }

    @Test
    void sortByDate() {

    }

    @Test
    void listOfProjectTitle() {
    }

    @Test
    void filterByProject() {
    }

    @Test
    void doesProjectExist() {
    }

    @Test
    void selectTask() {
    }

    @Test
    void getTaskStatus() {
    }

    @Test
    void addTask() {
    }

    @Test
    void changeProject() {
    }

    @Test
    void changeTaskTitle() {
    }

    @Test
    void changeDueDate() {
    }

    @Test
    void changeDescription() {
    }

    @Test
    void changeStatus() {
    }
}