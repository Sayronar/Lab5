package data;

public class Location {
    private int x;
    private Float y; //Поле не может быть null
    private long z;

    public Location(int x, Float y, long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return x + " " + y + " " + z;
    }
}