package ru.netology.entity;

public class Location {

    private final String city;

    private final Country country;

    private final String street;

    private final int builing;

    public Location(String city, Country country, String street, int builing) {
        this.city = city;
        this.country = country;
        this.street = street;
        this.builing = builing;
    }

    public String getCity() {
        return city;
    }

    public Country getCountry() {
        return country;
    }

    public String getStreet() {
        return street;
    }

    public int getBuiling() {
        return builing;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) { // проверка на идентичность
            return true;
        }
        if (!(obj instanceof Location)) { // проверка типа объекта
            return false;
        }
        Location other = (Location) obj; // приведение объекта к типу Person
        return this.city == other.city && this.country == other.country
                && this.street == other.street&& this.builing == other.builing; // сравнение содержимого
    }
}
