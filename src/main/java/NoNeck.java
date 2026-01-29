import java.util.Scanner;

public class NoNeck {
    public static void main(String[] args) {
        String logo = "NoNeck";
        String line;
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
            else {
                System.out.println(line);
            }
        }
    }
}
