package Collection;

import BasicClasses.*;
import oracle.jrockit.jfr.openmbean.ProducerDescriptorType;

import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;


/**
 * Менеджер коллекцией. Описывает логику команд, выполняющих работу с коллекцией.
 */
public class CollectionManager {
    private static LinkedList<Product> linkedList;
    private static ZonedDateTime creationDate;

    public static void initList() {
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            creationDate = ZonedDateTime.now();
        }
    }

    public static LinkedList<Product> getLinkedList() {
        return linkedList;
    }

    public static void add(Product product) {
        linkedList.add(product);
    }

    public static void addJsonObject(Product product) {
        product.setId(IDGenerator.generateID(product.getId()));
        linkedList.add(product);
    }

    public static void getInfo() {
        System.out.println("Тип коллекции – " + linkedList.getClass().getName());
        System.out.println("Дата инициализации коллекции – " + creationDate);
        System.out.println("Количество элементов в коллекции – " + linkedList.size());
        System.out.println("_________________________________________________________\n");
    }

    public static void show() {
        linkedList.forEach(CollectionUtils::display);
    }

    public static void update(Product ProductToUpdate, Integer elementId) {
        linkedList.forEach(Product -> {
            if (Product.getId().equals(elementId)) {
                Product.setName(ProductToUpdate.getName());
                Product.setCoordinates(ProductToUpdate.getCoordinates());
                Product.setPrice(ProductToUpdate.getPrice());
                Product.setPartNumber(ProductToUpdate.getPartNumber());
                Product.setManufactureCost(ProductToUpdate.getManufactureCost());
                Product.setUnitOfMeasure(ProductToUpdate.getUnitOfMeasure());
                Product.setManufacturer(ProductToUpdate.getManufacturer());
            }
        });
    }

    public static void remove_by_id(Integer productId) {
            Iterator<Product> i = linkedList.iterator();
            while (i.hasNext()) {
                Product product = i.next();
                {
                    if (product.getId().equals(productId)) {
                        i.remove();
                        System.out.println("Элемент успешно удален из коллекции.");
                    }
                }
            }
            if (!i.hasNext()){
            System.out.println("Элемента с таким ID нет в коллекции.");
        }
                }


    public static void clear() {
        linkedList.clear();
    }

    public static void head() {
        if (linkedList.size() > 0) {
            CollectionUtils.display(linkedList.getFirst());
        } else {
            System.out.println("Коллекция пуста.");
        }
    }

    public static void filter_greater_than_part_number(String partNumber) {
        for (Product listProduct : linkedList) {
            if (listProduct.getPartNumber().compareTo(partNumber) > 0) {
                CollectionUtils.display(listProduct);
            } else {
                System.out.println("Нет элементов с PartNumber больше заданного");
                break;
            }
        }
    }

    public static void add_if_min(Product product) {
        for (Product listProduct : linkedList) {
            if (listProduct.compareTo(product) > 0) {
                linkedList.add(product);
            } else {
                System.out.println("Невозможно добавить элемент");
                break;
            }
        }
    }


    public static void filter_contains_part_number(String partNumber) {
        linkedList.stream().filter(Product -> Product.getPartNumber().equals(partNumber)).collect(Collectors.toList()).forEach(CollectionUtils::display);
    }
}