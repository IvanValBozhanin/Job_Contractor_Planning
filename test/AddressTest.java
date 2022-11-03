import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    private static Address address;

    @BeforeAll
    public static void init(){
        address = new Address("Stieltjesweg", 14, "2628CK", "Delft");
    }
    
    @Test
    public void testAddressConstructorSuccess(){
        assertNotNull(address);
    }

    @Test
    void equalsSameAddressSuccess() {
        assertEquals(address, address);
    }

    @Test
    void equalsSameInstancesSuccess() {
        Address address1 = new Address("Stieltjesweg", 14, "2628CK", "Delft");

        assertEquals(address, address1);
    }

    @Test
    void equalsOKDifferentCityStreet() {
        Address address1 = new Address("Bababoyee", 14, "2628CK", "Sofia");

        assertEquals(address, address1);
    }

    @Test
    void equalsHashCodeSuccess() {
        Address address1 = new Address("Stieltjesweg", 14, "2628CK", "Delft");

        assertEquals(address.hashCode(), address1.hashCode());
    }

    @Test
    void getStreetSuccess() {
        assertEquals("Stieltjesweg", address.street());
    }

    @Test
    void getNumberSuccess() {
        assertEquals(14, address.number());
    }

    @Test
    void getZipSuccess() {
        assertEquals("2628CK", address.zipCode());
    }

    @Test
    void getCitySuccess() {
        assertEquals("Delft", address.city());
    }

    @Test
    void testToStringSuccess() {
        assertEquals("Address[street=Stieltjesweg, number=14, zipCode=2628CK, city=Delft]", address.toString());
    }
}