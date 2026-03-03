package Duke.storage;

import Duke.task.*;
import java.io.*;
import java.time.LocalDateTime;
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

        try (Scanner sc = new Scanner(file)) {

            while (sc.hasNextLine()) {
                String line = sc.nextLine();

                String[] parts = line.split(" \\| ");

                if (parts.length != 3 && parts.length != 4 && parts.length != 5) {
                    throw new IOException("Corrupted format: wrong number of fields");
                }

                String type = parts[0];
                boolean isDone = parts[1].equals("1");
                String description = parts[2];

                if (!type.equals("T") && !type.equals("D") && !type.equals("E")) {
                    throw new IOException("Corrupted format: invalid task type");
                }

                if (!parts[1].equals("0") && !parts[1].equals("1")) {
                    throw new IOException("Corrupted format: invalid status");
                }

                if (description.trim().isEmpty()) {
                    throw new IOException("Corrupted format: empty description");
                }

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
        } catch (Exception e) {
            file.delete();
            file.createNewFile();
            return new ArrayList<>();
        }
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
