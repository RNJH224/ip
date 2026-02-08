import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class NoNeck {
    public static void main(String[] args) {
        String logo = "NoNeck";
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
                String rest = line.substring(pos).trim();
                ToDo t = new ToDo(rest);
                tasks[i] = t;
                i++;

                System.out.println("added Todo:");
                System.out.println(rest);
            }
            else if (line.trim().startsWith("deadline")) {
                int pos = line.indexOf("deadline") + 8;
                String rest = line.substring(pos).trim();
                String[] parts = rest.split("/by");

                String description = parts[0].trim();
                String by = parts[1].trim();

                Deadline t = new Deadline(description, by);
                tasks[i] = t;
                i++;

                System.out.println("added deadline:");
                System.out.println(rest);
            }
            else if (line.trim().startsWith("event")) {
                int pos = line.indexOf("event") + 5;
                String rest = line.substring(pos).trim();
                String[] parts = rest.split("/from|/to");

                String description = parts[0].trim();
                String from = parts[1].trim();
                String to = parts[2].trim();

                Events t = new Events(description, from, to);
                tasks[i] = t;
                System.out.println("added Event:");
                System.out.println(rest);

                i++;
            }

            else if (line.equals("list")) {
                for (int j = 0; tasks[j] != null; j++) {
                    System.out.print((j+1) + ")");
                    System.out.println(tasks[j]);
                }
            }
            else {
                    System.out.println(line);
            }
        }
    }
}
