package Duke.storage;

import Duke.task.*;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles loading tasks from disk and saving tasks back to disk.
 * Tasks are stored in a text file where each line represents one task in a pipe-delimited format.
 */
public class Storage {
    private String filePath;

    /**
     * Creates a Storage object that reads from and writes to the given file path.
     *
     * @param filePath Path to the save file.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Loads tasks from the save file.
     * If the folder or file does not exist, it will be created and an empty task list is returned.
     *
     * @return List of loaded tasks.
     * @throws IOException If the file cannot be read or the format is corrupted.
     */
    public ArrayList<Task> load() throws IOException {

        File file = new File(filePath);

        // create folder + file if missing
        file.getParentFile().mkdirs();
        if (!file.exists()) {
            file.createNewFile();
        }

        ArrayList<Task> tasks = new ArrayList<>();

        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            String[] parts = line.split(" \\| ");

            String type = parts[0];
            boolean isDone = parts[1].equals("1");
            String description = parts[2];

            Task task;

            switch (type) {
            case "T":
                task = new ToDo(description);
                break;
            case "D":
                LocalDateTime by = LocalDateTime.parse(parts[3].trim());
                task = new Deadline(description, parts[3]);
                break;
            case "E":
                task = new Events(description, parts[3], parts[4]);
                break;
            default:
                continue;
            }

            if (isDone) {
                task.mark();
            }

            tasks.add(task);
        }

        sc.close();
        return tasks;
    }

    /**
     * Saves the given task list to the default save file.
     * Each task is saved on its own line using
     *
     * @param tasks List of tasks to save.
     * @throws IOException If the file cannot be created or written to.
     */
    public static void save(ArrayList<Task> tasks) throws IOException {
        File file = new File("data/duke.txt");

        // create "data" folder if missing
        file.getParentFile().mkdirs();

        // create file if missing
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter("data/duke.txt");

        for (Task t : tasks) {
            fw.write(t.toFileFormat() + System.lineSeparator());
        }

        fw.close();
    }

}
