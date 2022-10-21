import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JobCatalogTest {

    private static Address address = new Address("Stieltjesweg", 14, "2628CK", "Delft");;
    private static String des1 = "A job with number 1";
    private static String des2 = "A job with number 2";
    private static Date date1;
    private static List<Equipment> requirements;
    private static Job job1;

    @BeforeAll
    public static void init(){
        date1 = new Date(30, 03, 2003);
        requirements = new ArrayList<>();
        requirements.add(new Torch("a torch"));
        job1 = new Job(address, des1, requirements, date1);
    }

    @Test
    void testConstructorOk(){
        JobCatalog jobCatalog = new JobCatalog();
        assertNotNull(jobCatalog);
    }

    @Test
    void testEqualsOk() {
        JobCatalog jobCatalog = new JobCatalog();
        jobCatalog.addJob(job1);
        Job job2 = new Job(address, des1, requirements, date1);
        JobCatalog jobCatalog1 = new JobCatalog();
        jobCatalog1.addJob(job2);
        assertEquals(jobCatalog, jobCatalog1);
    }

    @Test
    void testEqualsFail() {
        JobCatalog jobCatalog = new JobCatalog();
        jobCatalog.addJob(job1);
        Job job2 = new Job(address, des2, requirements, date1);
        JobCatalog jobCatalog1 = new JobCatalog();
        jobCatalog1.addJob(job2);
        assertNotEquals(jobCatalog, jobCatalog1);
    }

    @Test
    void testHashCode() {
        JobCatalog jobCatalog = new JobCatalog();
        jobCatalog.addJob(job1);
        JobCatalog jobCatalog1 = new JobCatalog();
        jobCatalog1.addJob(job1);                   // job number should be the same
        assertEquals(jobCatalog.hashCode(), jobCatalog1.hashCode());
    }

    @Test
    void testToString() {
        JobCatalog jobCatalog = new JobCatalog();
        jobCatalog.addJob(job1);
        assertEquals("Job{jobNumber=1, location=Address{street='Stieltjesweg', number=14, zipCode='2628CK', city='Delft'}, description='A job with number 1', requiredEquipment=[Torch{Equipment{requirements='a torch'}}], plannedDate=Date{day=30, month=3, year=2003}}", job1.toString());
    }
}