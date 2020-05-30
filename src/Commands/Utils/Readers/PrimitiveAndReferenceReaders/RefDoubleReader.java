package Commands.Utils.Readers.PrimitiveAndReferenceReaders;

import java.util.Scanner;

/**
 * Считыватель класса-оболочки Double.
 */
public class RefDoubleReader {
        public static Double read(String messageForConsole, boolean canBeNull) {
            Scanner in = new Scanner(System.in);
            System.out.print(messageForConsole);
            Double readDouble = null;
            boolean end = false;
            while (!end) {
                try {
                    readDouble = Double.parseDouble(in.nextLine().trim());
                    if (canBeNull && readDouble.equals("")) {
                        {end = true;}
                        return null;
                    }
                    if (!canBeNull && readDouble.equals("")) {
                        {
                            System.out.println("Поле не может быть null. Попробуйте снова: "); }
                    }
                    if (readDouble instanceof Double) {
                        end = true;
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Вы ввели неподходящее значение. Введите число:");
                }
            }
            return readDouble;
        }
}

