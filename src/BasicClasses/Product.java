package BasicClasses;

import Collection.IDGenerator;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

public class Product {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private float price; //Значение поля должно быть больше 0
    private String partNumber; //Поле может быть null
    private Double manufactureCost; //Поле может быть null
    private UnitOfMeasure unitOfMeasure; //Поле может быть null
    private Organization manufacturer; //Поле может быть null

    public Product(String name, Coordinates coordinates, float price, String partNumber, Double manufactureCost, UnitOfMeasure unitOfMeasure, Organization manufacturer) {
    this.id = IDGenerator.generateID();
    this.name = name;
    this.coordinates = coordinates;
    this.creationDate = java.time.LocalDate.now();
    this.price = price;
    this.partNumber = partNumber;
    this.manufactureCost = manufactureCost;
    this.unitOfMeasure = unitOfMeasure;
    this.manufacturer = manufacturer;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public Double getManufactureCost() {
        return manufactureCost;
    }

    public void setManufactureCost(Double manufactureCost) {
        this.manufactureCost = manufactureCost;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Organization getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Organization manufacturer) {
        this.manufacturer = manufacturer;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id) &&
                Objects.equals(name, product.name) &&
                coordinates.equals(product.coordinates) &&
                creationDate.equals(product.creationDate) &&
                Objects.equals(manufacturer, product.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, manufacturer);
    }

    public int compareTo(Product ProductId) {
        return (this.id - ProductId.getId());
    }


}