package immutableClass;

/**
 * This is a mutable Address class used in EmployeeImmutableClass to demonstrate
 * immutability.
 * We can make this class immutable as well by following the same steps as in
 * EmployeeImmutableClass.
 * However, for demonstration purposes, we are keeping it mutable.
 */

public class Address {

    private String buildingName;
    private String street;

    private String landMark;

    private String city;
    private String state;
    private String country;
    private int pinCode;

    public Address(String buildingName, String street, String landMark, String city, String state, String country, int pinCode) {
        this.buildingName = buildingName;
        this.street = street;
        this.landMark = landMark;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pinCode = pinCode;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLandMark() {
        return landMark;
    }

    public void setLandMark(String landMark) {
        this.landMark = landMark;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
