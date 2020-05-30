package Commands.Utils.Readers.EnumReaders;

import BasicClasses.TypeofOrganization;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Считыватель типа организации.
 */
public class TypeofOrganizationReader {
    public static boolean checkExist(String toContains) {
        return Arrays.stream(TypeofOrganization.values()).anyMatch((TypeofOrganization) -> TypeofOrganization.name().equals(toContains));
    }

    public static TypeofOrganization read(boolean canBeNull) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите тип организации из представленных(" + Arrays.asList(TypeofOrganization.values()) + "): ");
        String toContains = in.nextLine().trim();

        if ((!checkExist(toContains)) && !canBeNull && !toContains.equals("") || !canBeNull && toContains.equals("") || canBeNull && !toContains.equals("")) {
            while (!checkExist(toContains)) {
                System.out.print("Вы ввели несуществующее значение из представленных. Попробуйте снова: ");
                toContains = in.nextLine().trim();
                checkExist(toContains);
            }
        }

        if (canBeNull && toContains.equals("")) { return null; }

        return Enum.valueOf(TypeofOrganization.class, toContains);
    }
}
