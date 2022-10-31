import java.util.Objects;
import java.util.Scanner;

public class Address {
    private String street;
    private int number;
    private String zipCode;
    private String city;

    /**
     * Constructor for the Address object via passing all values
     * @param street - the name of the street
     * @param number - the number of the street
     * @param zipCode - the ZIP code of the address
     * @param city - the city of address
     */
    public Address(String street, int number, String zipCode, String city) {
        this.street = street;
        this.number = number;
        this.zipCode = zipCode;
        this.city = city;
    }

    /**
     * Constructor for the Address object via passing a line with all data.
     * @param data - the string with the data
     */
    public Address(String data) {
        Scanner in = new Scanner(data);
        in.useDelimiter("; ");
        this.street = in.next();
        this.number = in.nextInt();
        this.zipCode = in.next();
        this.city = in.next();
    }

    /**
     * Equals method for Address
     * @param o - the object to be compared to this address
     * @return true iff all the fields are the same in value
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return number == address.number && Objects.equals(zipCode, address.zipCode);
    }

    /**
     * Hashcode method for the Address object
     * @return the integer of the hashcode of the address's instance
     */
    @Override
    public int hashCode() {
        return Objects.hash(street, number, zipCode, city);
    }

    /**
     * ToString method for Address
     * @return a human-readable format of the object
     */
    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", number=" + number +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    /**
     * Getter of street's name
     * @return the street's name
     */
    public String getStreet() {
        return street;
    }

    /**
     * Getter of the street's number
     * @return the street's number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Getter of the ZIP code of the address
     * @return the address's ZIP code
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Getter of the City field
     * @return the name of the address's city
     */
    public String getCity() {
        return city;
    }
}
