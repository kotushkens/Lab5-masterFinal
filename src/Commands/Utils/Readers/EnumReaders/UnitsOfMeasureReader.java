package Commands.Utils.Readers.EnumReaders;

import BasicClasses.UnitOfMeasure;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Считыватель единиц измерения.
 */
public class UnitsOfMeasureReader {
    public static boolean checkExist(String toContains) {
        return Arrays.stream(UnitOfMeasure.values()).anyMatch((UnitOfMeasure) -> UnitOfMeasure.name().equals(toContains));
    }

    public static UnitOfMeasure read(String messageForConsole, boolean canBeNull) {
        Scanner in = new Scanner(System.in);
        System.out.print(messageForConsole + " Выберите единицы измерения из представленных(" + Arrays.asList(UnitOfMeasure.values()) + "): ");
        String toContains = in.nextLine().trim();

        if ((!checkExist(toContains)) && !canBeNull && !toContains.equals("") || !canBeNull && toContains.equals("") || canBeNull && !toContains.equals("")) {
            while (!checkExist(toContains)) {
                System.out.print("Вы ввели несуществующее значение из представленных. Попробуйте снова: ");
                toContains = in.nextLine().trim();
                checkExist(toContains);
            }
        }

        if (canBeNull && toContains.equals("")) { return null; }

        return Enum.valueOf(UnitOfMeasure.class, toContains);
    }
}
