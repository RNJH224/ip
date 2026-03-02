package Duke.tasklist;

import Duke.task.Task;

import java.util.ArrayList;
import java.util.List;

public class Tasklist {
    private final ArrayList<Task> tasks;

    public Tasklist() {
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