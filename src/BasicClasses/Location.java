package BasicClasses;

public class Location {
    private double x;
    private Long y; //Поле не может быть null
    private long z;
    private String name; //Длина строки не должна быть больше 825, Поле не может быть null

    public Location(double x, long y, long z, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public Long getY() {
        return y;
    }

    public long getZ() {
        return z;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return ("Координаты x, y, z:" + getX() + ", " + getY() + ", " + getZ() + ". " + "Название города: " + name);
    }
}
