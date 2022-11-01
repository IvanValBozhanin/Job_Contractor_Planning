import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JobTest {
    private static Address address = new Address("Stieltjesweg", 14, "2628CK", "Delft");;
    private static String des1 = "A job with number 1";
    private static String des2 = "A job with number 2";
    private static Date date1;
    private static List<Equipment> requirements;
    private static Job job1;
    private static Job job2;

    @BeforeEach
    public void init(){
        date1 = new Date(30, 03, 2003);
        requirements = new ArrayList<>();
        requirements.add(new Torch("a torch"));
        job1 = new Job(address, des1, requirements, date1);
        job2 = new Job(address, des1, requirements, date1);
    }

    @Test
    void getJobNumber() {
        assertTrue(job1.getJobNumber() > 0);
    }

    @Test
    void getLocation() {
        assertEquals(address, job1.getLocation());
    }

    @Test
    void getDescription() {
        assertEquals(des1, job1.getDescription());
    }

    @Test
    void getRequiredEquipment() {
        assertEquals(requirements, job1.getRequiredEquipment());
    }

    @Test
    void getPlannedDate() {
        assertEquals(date1, job1.getPlannedDate());
    }

    @Test
    void testEquals() {
        assertEquals(job1, job2);
    }
}