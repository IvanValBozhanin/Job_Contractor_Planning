import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    private Date dt;

    @BeforeEach
    void setUp() {
        dt = new Date(30, 3, 2003);
    }

    @Test
    void testEquals() {
        assertEquals(dt, new Date(30, 03,2003));
    }

    @Test
    void testHashCode() {
        Date dt1 = new Date(30, 03, 2003);
        assertEquals(dt.hashCode(), dt1.hashCode());
    }

    @Test
    void testToString() {
        assertEquals("Date{day=30, month=3, year=2003}", dt.toString());
    }

    @Test
    void getDay() {
        assertEquals(30, dt.getDay());
    }

    @Test
    void getMonthFailure() {
        assertNotEquals(6, dt.getMonth());
    }

    @Test
    void getYear() {
        assertEquals(2003, dt.getYear());
    }
}