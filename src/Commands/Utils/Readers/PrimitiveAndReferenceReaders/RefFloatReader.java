package Commands.Utils.Readers.PrimitiveAndReferenceReaders;

import java.util.Scanner;

/**
 * Считыватель класса-оболочки float.
 */
public class RefFloatReader {
    public static Float read(String messageForConsole, boolean canBeNull) {
        Scanner in = new Scanner(System.in);
        System.out.print(messageForConsole);
        Float readFloat = null;
        boolean end = false;
        while (!end) {
            try {
                readFloat = Float.parseFloat(in.nextLine().trim());
                if (canBeNull && readFloat.equals("")) {
                    return null;
                }
                if (!canBeNull && readFloat.equals("")) {
                    {end = true; }
                    {
                        System.out.println("Поле не может быть null. Попробуйте снова: ");
                    break;}
                }
                if (readFloat instanceof Float) {
                    end = false;
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели неподходящее значение. Введите число:");
            }
        }
        return readFloat;
    }
}
