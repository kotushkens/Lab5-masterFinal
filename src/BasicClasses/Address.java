package BasicClasses;

import java.util.Objects;

public class Address {
    private String street; //Поле не может быть null
    private Location town; //Поле может быть null

    public Address(String street, Location location) {
        this.street = street;
        this.town = location;
    }



    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTown() {
        return town.toString();
    }

    public void setTown(Location town) {
        this.town = town;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return street.equals(address.street) &&
                town.equals(address.town);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, town);
    }
}

