import java.util.Scanner;

/**
 * Class that handles all the needed console inputs.
 */
public class ConsoleIO {

    Scanner scanner = new Scanner(System.in);

    public String getFilename() {
        while(true) {
            System.out.println("Input name of file to process: ");
            String filename = this.scanner.nextLine();

            if (filename.length() > 0) {
                return filename;
            }
        }

       
    }

    public String chooseHashFunction() {
        while(true) {
            System.out.println("--- Choose hash function ---");
            System.out.println("First function (F), or improved function (I): ");
            String function = this.scanner.nextLine();

            if (function.length() > 0) {
                return function;
            }
        }

       
    }
}