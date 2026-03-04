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

    /**
     * Constructs an empty Tasklist.
     */
    public Tasklist()
    {
        this.tasks = new ArrayList<>();
    }

    /**
     * Constructs a Tasklist with an existing list of tasks.
     *
     * @param tasks The initial list of tasks.
     */
    public Tasklist(List<Task> tasks) {

        this.tasks = new ArrayList<>(tasks);
    }

    /**
     * Adds a task to the task list.
     *
     * @param t The task to be added.
     */
    public void add(Task t) {
        tasks.add(t);
    }

    /**
     * Deletes a task at the specified index.
     *
     * @param index The zero-based index of the task to delete.
     * @return The removed task.
     */
    public Task delete(int index) {

        return tasks.remove(index);
    }

    /**
     * Retrieves the task at the specified index.
     *
     * @param index The zero-based index of the task.
     * @return The task at the given index.
     */
    public Task get(int index) {

        return tasks.get(index);
    }

    /**
     * Returns the number of tasks currently stored.
     *
     * @return The size of the task list.
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Returns the underlying list of tasks.
     *
     * @return The internal {@link ArrayList} of tasks.
     */
    public List<Task> getTasks() {
        return tasks;
    }
}