package Duke.ui;

import Duke.task.Deadline;
import Duke.task.Events;
import Duke.task.Task;
import Duke.task.ToDo;

import java.util.Scanner;

public class NoNeck {
    public static void main(String[] args) {
        String logo = "Duke";
        String line;
        int i = 0;

        Task[] tasks = new Task[100];

        System.out.println("Hello i'm " + logo);
        System.out.println("what can i do for you");

        boolean bai = false;

        while (!bai) {

            Scanner sc = new Scanner(System.in);
            line = sc.nextLine();

            if (line.equals("bye")) {
                bai = true;
                System.out.println("Astalavista baby");
            }
            else if (line.trim().startsWith("mark")) {
                int pos = line.indexOf("mark")+4;
                String rest = line.substring(pos).trim();
                int num = Integer.parseInt(rest);
                System.out.println("marked as done");
                tasks[num - 1].mark();
            }

            else if (line.trim().startsWith("unmark")) {
                int pos = line.indexOf("unmark")+6;
                String rest = line.substring(pos).trim();
                int num = Integer.parseInt(rest);
                System.out.println("not done yet");
                tasks[num - 1].unmark();
            }

            else if (line.trim().startsWith("todo")) {
                int pos = line.indexOf("todo") + 4;
                try {
                    String rest = line.substring(pos).trim();

                    if (rest.isEmpty()) {
                        throw new IllegalArgumentException("The description of a todo cannot be empty.");
                    }

                    ToDo t = new ToDo(rest);
                    tasks[i] = t;
                    i++;

                    System.out.println("added Todo:");
                    System.out.println(rest);
                }
                catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }

            }
            else if (line.trim().startsWith("deadline")) {
                try {
                    int pos = line.indexOf("deadline") + 8;
                    String rest = line.substring(pos).trim();
                    String[] parts = rest.split("/by");

                    String description = parts[0].trim();

                    if (description.isEmpty()) {
                        throw new IllegalArgumentException("The description of a deadline cannot be empty.");
                    }

                    if (parts.length < 2) {
                        throw new IllegalArgumentException("Duke.task.Deadline must have a /by time.");
                    }

                    String by = parts[1].trim();


                    Deadline t = new Deadline(description, by);
                    tasks[i] = t;
                    i++;

                    System.out.println("added deadline:");
                    System.out.println(rest);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            else if (line.trim().startsWith("event")) {
                try {
                    int pos = line.indexOf("event") + 5;
                    String rest = line.substring(pos).trim();
                    String[] parts = rest.split("/from|/to");

                    String description = parts[0].trim();

                    if (description.isEmpty()) {
                        throw new IllegalArgumentException("The description of a deadline cannot be empty.");
                    }

                    if (parts.length < 3) {
                        throw new IllegalArgumentException("Event must have to and/or from time.");
                    }

                    String from = parts[1].trim();
                    String to = parts[2].trim();

                    Events t = new Events(description, from, to);
                    tasks[i] = t;
                    System.out.println("added Event:");
                    System.out.println(rest);

                    i++;
                } catch (IllegalArgumentException e){
                    System.out.println("Error: " + e.getMessage());
                }
            }

            else if (line.equals("list")) {
                for (int j = 0; tasks[j] != null; j++) {
                    System.out.print((j+1) + ")");
                    System.out.println(tasks[j]);
                }
            }
            else if (line.equals("bai")) {
                System.out.println("Astalavista Baby");
                return;

            }
            else {
                System.out.println("Error: I don't understand \"" + line + "\"");
            }
        }
    }
}
