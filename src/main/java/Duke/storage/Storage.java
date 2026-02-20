package Duke.storage;

import Duke.task.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

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
