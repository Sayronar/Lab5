package data;

public class Address {
    private String street; //Строка не может быть пустой, Поле не может быть null
    private Location town; //Поле может быть null

    public Address(String street, Location town) {
        this.street = street;
        this.town = town;
    }

    @Override
    public String toString() {
        return street + " по координатам " + town;
    }
}