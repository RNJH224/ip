import java.util.Scanner;
import java.util.Arrays;

public class NoNeck {
    public static void main(String[] args) {
        String logo = "NoNeck";
        String line;
        int i = 0;
        String[] storedLine = new String[100];
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
            else if (line.equals("repeat")) {
                for (int j = 0; storedLine[j] != null; j++) {
                    System.out.println(storedLine[j]);
                }
            }
            else {
                storedLine[i] = i+1 + ") " + line;
                System.out.println(line);
                i++;
            }
        }
    }
}
