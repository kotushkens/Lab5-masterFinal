package Collection;

import BasicClasses.Product;



/**
 * Класс, содержащий утилиты для работы с коллекцией.
 */
public class CollectionUtils {
    public static boolean checkExist(Integer ID) {
        for (Product product:CollectionManager.getLinkedList()) {
            return product.getId().equals(ID);
        }
        return false;
    }

    static void display(Product product) {
        System.out.println("ID элемента коллекции – " + product.getId());
        System.out.println("Название продукта – " + product.getName());
        System.out.println("Координата X – " + product.getCoordinates().getX());
        System.out.println("Координата Y – " + product.getCoordinates().getY());
        System.out.println("Дата создания элемента – " + product.getCreationDate());
        System.out.println("Цена продукта – " + product.getPrice());
        System.out.println("Номер продукта – " + product.getPartNumber());
        System.out.println("Стоимость изготовления – " + product.getManufactureCost());
        System.out.println("Единицы измерения – " + product.getUnitOfMeasure());
        System.out.println("ID производства – " + product.getManufacturer().getId());
        System.out.println("Название производства – " + product.getManufacturer().getName());
        System.out.println("Ежегодный оборот производства – " + product.getManufacturer().getAnnualTurnover());
        System.out.println("Тип производства - " + product.getManufacturer().getType());
        System.out.println("Адрес производства  - " + product.getManufacturer().getPostalAddress().getTown() + ", улица " + product.getManufacturer().getPostalAddress().getStreet());
        System.out.println("_________________________________________________________\n");
    }
}
