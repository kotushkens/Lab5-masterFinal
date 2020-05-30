package Commands.Utils.Creaters;

import BasicClasses.*;
import Commands.Utils.Readers.EnumReaders.TypeofOrganizationReader;
import Commands.Utils.Readers.EnumReaders.UnitsOfMeasureReader;
import Commands.Utils.Readers.PrimitiveAndReferenceReaders.*;

import java.util.ArrayList;

/**
 * Класс, содержащий методы для создания продукта и производства.
 */
public class ElementCreator {
    public static Product createProduct() {
        String name = StringReader.read("Введите название продукта: ", false);
        float x = RefFloatReader.read("Введите Х: ", false);
        double y = PrimitiveDoubleReader.read("Введите Y: ");
        float price = PrimitiveFloatReader.read("Введите цену: ", 0, "MIN");
        String partNumber = StringReader.read("Введите номер продукта: ", true);
        Double manufactureCost = RefDoubleReader.read("Введите стоимость изготовления: ", true);
        UnitOfMeasure unitOfMeasure = UnitsOfMeasureReader.read("Введите единицу измерения", true);

        return new Product(name, new Coordinates(x, y), price, partNumber, manufactureCost, unitOfMeasure, createOrganization());
    }

    public static Address createAddress() {
        String street = StringReader.read("Введите название улицы", false);
        double x = PrimitiveDoubleReader.read("Введите х: ");
        long y = RefLongReader.read("Введите y: ", false);
        long z = RefLongReader.read("Введите z", false);
        String name = StringReader.read("Введите название города: ", false);

        return new Address(street, new Location(x, y, z, name));
    }

    public static Organization createOrganization() {
        String name = StringReader.read("Введите название производства: ", false);
        Long annualTurnover = RefLongReader.read("Введите ежегодный оборот производства: ", true);
        TypeofOrganization type = TypeofOrganizationReader.read(true);

        return new Organization(name, annualTurnover, type, createAddress());

    }


    public static Product createScriptProduct(ArrayList<String> parameters) {
        if (validateArray(parameters)) {
            UnitOfMeasure unitOfMeasure = null;
            TypeofOrganization typeofOrganization = null;
            if (!parameters.get(6).isEmpty()) {
                unitOfMeasure = UnitOfMeasure.valueOf(parameters.get(6));}
            if (!parameters.get(9).isEmpty()) {
                typeofOrganization = TypeofOrganization.valueOf((parameters.get(9)));}
            return new Product(parameters.get(0),
                    new Coordinates(Float.parseFloat(parameters.get(1)), Double.parseDouble(parameters.get(2))),
                    Float.parseFloat(parameters.get(3)),
                    parameters.get(4),
                    Double.parseDouble(parameters.get(5)),
                    unitOfMeasure,
                    new Organization(parameters.get(7), Long.parseLong(parameters.get(8)), typeofOrganization,
                    new Address(parameters.get(10),
                    new Location (Double.parseDouble(parameters.get(11)), Long.parseLong(parameters.get(12)), Long.parseLong(parameters.get(13)), parameters.get(14)))));
        }
        else { System.out.println("Один из параметров не соответствует требованиям."); }

        return null;
    }

    private static boolean validateArray(ArrayList<String> parameters) {
        try {
            return (!parameters.get(0).isEmpty()
                    && !parameters.get(1).isEmpty()
                    && !parameters.get(2).isEmpty()
                    && !parameters.get(3).isEmpty()
                    && !parameters.get(4).isEmpty() || parameters.get(4).isEmpty()
                    && !parameters.get(5).isEmpty()  || parameters.get(5).isEmpty()
                    && (UnitsOfMeasureReader.checkExist(parameters.get(6)) || parameters.get(6).isEmpty())
                    && !parameters.get(7).isEmpty()
                    && !parameters.get(8).isEmpty() || parameters.get(8).isEmpty()
                    && TypeofOrganizationReader.checkExist(parameters.get(9)) || parameters.get(9).isEmpty()
                    && !parameters.get(10).isEmpty() || parameters.get(10).isEmpty()
                    && !parameters.get(11).isEmpty()
                    && !parameters.get(12).isEmpty()
                    && !parameters.get(13).isEmpty()
                    && !parameters.get(14).isEmpty());

        } catch (NumberFormatException ex) { return false; }
    }
}