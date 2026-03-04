package Duke.tasklist;

import Duke.task.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a list of tasks in the NoNeck application.
 * <p>
 * This class acts as a wrapper around an {@link ArrayList} of {@link Task}
 * objects and provides methods to manage tasks such as adding, deleting,
 * retrieving, and checking the size of the list.
 */
public class Tasklist {
    private final ArrayList<Task> tasks;

    public Tasklist()
    {
        this.tasks = new ArrayList<>();
    }

    public Tasklist(List<Task> tasks) {

        this.tasks = new ArrayList<>(tasks);
    }

    public void add(Task t) {
        tasks.add(t);
    }

    public Task delete(int index) {

        return tasks.remove(index);
    }

    public Task get(int index) {

        return tasks.get(index);
    }

    public int size() {
        return tasks.size();
    }

    public List<Task> getTasks() {
        return tasks;
    }
}