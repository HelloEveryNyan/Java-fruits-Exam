import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter file name: ");
        String fileName = scanner.nextLine();

        PicnicAnalyzer.main(new String[]{fileName});

        scanner.close();
    }
}
