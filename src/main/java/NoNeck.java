import java.util.Scanner;
import java.util.Arrays;

public class NoNeck {
    public static void main(String[] args) {
        String logo = "NoNeck";
        String line;
        int i = 0;

        System.out.println("Hello i'm " + logo);
        System.out.println("what can i do for you");

        boolean bai = false;
        boolean[] mark = new boolean[100];

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
                System.out.println(Mark.line[num-1]);
                Mark.marked[num-1] = true;
            }
            else if (line.trim().startsWith("unmark")) {
                int pos = line.indexOf("unmark")+6;
                String rest = line.substring(pos).trim();
                int num = Integer.parseInt(rest);
                System.out.println("not done yet");
                System.out.println(Mark.line[num-1]);
                Mark.marked[num-1] = false;
            }
            else if (line.equals("list")) {
                for (int j = 0; Mark.line[j] != null; j++) {
                    System.out.print(Mark.line[j]);
                    if (!Mark.marked[j]) {
                        System.out.println("[ ]");
                    } else {
                        System.out.println("[x]");
                    }
                }
            }
            else {
                Mark.line[i] = i+1 + ") " + line;
                Mark.marked[i] = false;
                System.out.println("added: " + line);
                i++;
            }
        }
    }
}
