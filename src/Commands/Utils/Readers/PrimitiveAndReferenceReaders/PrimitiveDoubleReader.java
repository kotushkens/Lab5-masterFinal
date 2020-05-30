package Commands.Utils.Readers.PrimitiveAndReferenceReaders;

import java.util.Scanner;


/**
 * Считыватель примитивного double.
 */
public class PrimitiveDoubleReader {
    private static double result;

    public static double read(String messageForConsole) {
        System.out.print(messageForConsole);
        Scanner sc = new Scanner(System.in);
        boolean end = false;
        while (!end) {
            try {
                result = Double.parseDouble(sc.nextLine().trim());
                    end = true;
                    break;
            }
             catch (NumberFormatException e) {
                System.out.println("Вы должны ввести число, попробуйте снова: ");
            }
        }
        return result;
    }
}
