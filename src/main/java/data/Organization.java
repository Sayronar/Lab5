package data;

import java.time.LocalDateTime;
import java.util.Objects;

public class Organization implements Comparable<Organization> {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int annualTurnover; //Значение поля должно быть больше 0
    private String fullName; //Значение этого поля должно быть уникальным, Строка не может быть пустой, Поле может быть null
    private Long employeesCount; //Поле не может быть null, Значение поля должно быть больше 0
    private OrganizationType type; //Поле может быть null
    private Address officialAddress; //Поле не может быть null

    public Organization(Long id, String name, Coordinates coordinates, LocalDateTime creationDate, int annualTurnover,
                        String fullName, Long employeesCount, OrganizationType type, Address officialAddress) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.annualTurnover = annualTurnover;
        this.fullName = fullName;
        this.employeesCount = employeesCount;
        this.type = type;
        this.officialAddress = officialAddress;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public int getAnnualTurnover() {
        return annualTurnover;
    }

    public String getFullName() {
        return fullName;
    }

    public Long getEmployeesCount() {
        return employeesCount;
    }

    public OrganizationType getType() {
        return type;
    }

    public Address getOfficialAddress() {
        return officialAddress;
    }

    @Override
    public int compareTo(Organization organizationObj) {
        return id.compareTo(organizationObj.getId());
    }

    @Override
    public String toString() {
        String info = "";
        info += "Организация №" + id;
        info += " (добавлена " + creationDate.toLocalDate() + " " + creationDate.toLocalTime() + ")";
        info += "\n Название: " + name;
        info += "\n Местоположение: " + coordinates;
        info += "\n Годовой оборот: " + annualTurnover;
        info += "\n Полное название: " + fullName;
        info += "\n Количество работников: " + employeesCount;
        info += "\n Тип организации: " + type;
        info += "\n Адрес: " + officialAddress;
        return info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return id == that.id && Float.compare(that.annualTurnover, annualTurnover) == 0 && employeesCount == that.employeesCount && Objects.equals(name, that.name) && Objects.equals(coordinates, that.coordinates) && Objects.equals(creationDate, that.creationDate) && Objects.equals(fullName, that.fullName) && type == that.type && Objects.equals(officialAddress, that.officialAddress);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, annualTurnover, fullName, employeesCount, type, officialAddress);
    }
}