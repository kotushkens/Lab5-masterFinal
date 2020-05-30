package BasicClasses;

import Collection.IDGenerator;

import java.time.ZonedDateTime;

public class Organization implements Comparable<Organization> {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Long annualTurnover; //Поле может быть null, Значение поля должно быть больше 0
    private TypeofOrganization type; //Поле может быть null
    private Address postalAddress; //Поле может быть null


    public Organization(String name, Long annualTurnover, TypeofOrganization type, Address postalAddress) {
        this.id = IDGenerator.generateID();
        this.name = name;
        this.annualTurnover = annualTurnover;
        this.type = type;
        this.postalAddress = postalAddress;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAnnualTurnover() {
        return annualTurnover;
    }

    public void setAnnualTurnover(Long annualTurnover) {
        this.annualTurnover = annualTurnover;
    }

    public TypeofOrganization getType() {
        return type;
    }

    public void setType(TypeofOrganization type) {
        this.type = type;
    }

    public Address getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(Address postalAddress) {
        this.postalAddress = postalAddress;
    }


    @Override
    public int compareTo(Organization Organization) {
        return (this.id - Organization.getId());
    }
}
