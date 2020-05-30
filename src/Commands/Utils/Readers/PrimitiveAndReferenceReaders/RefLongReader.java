package Commands.Utils.Readers.PrimitiveAndReferenceReaders;

import java.util.Scanner;

/**
 * Считыватель класса-оболочки Long.
 */

public class RefLongReader {
    public static Long read(String messageForConsole, boolean canBeNull) {
        Scanner in = new Scanner(System.in);
        System.out.print(messageForConsole);
        Long readLong = null;
        boolean end = false;
        while (!end) {
            try {
                readLong = Long.parseLong(in.nextLine().trim());
                if (!canBeNull && readLong.equals("")) {
                    {
                        System.out.println("Поле не может быть null. Попробуйте снова: "); }
                }
                if (readLong instanceof Long) {
                    end = false;
                    break;
                }
            } catch (NumberFormatException e) {
                if (canBeNull && in.nextLine().trim().equals("")) {
                return null;}
                System.out.println("Вы ввели неподходящее значение. Введите число:");
            }
        }
        return readLong;
    }
}
        
