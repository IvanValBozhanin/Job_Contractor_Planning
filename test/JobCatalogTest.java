import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class JobCatalogTest {

    private static Address address = new Address("Stieltjesweg", 14, "2628CK", "Delft");;
    private static String des1 = "A job with number 1";
    private static String des2 = "A job with number 2";
    private static Date date1;
    private static List<Equipment> requirements;
    private static Job job1;

    @BeforeEach
    public void init(){
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
    void testHashCode() {
        JobCatalog jobCatalog = new JobCatalog();
        jobCatalog.addJob(job1);
        JobCatalog jobCatalog1 = new JobCatalog();
        jobCatalog1.addJob(job1);                   // job number should be the same
        assertEquals(jobCatalog.hashCode(), jobCatalog1.hashCode());
    }

    @Test
    void testToString1() {
        JobCatalog jobCatalog = new JobCatalog();
        jobCatalog.addJob(job1);
        assertEquals("JobCatalog{jobs=[Job{jobNumber=23, location=Address{street='Stieltjesweg', number=14, zipCode='2628CK', city='Delft'}, description='A job with number 1', requiredEquipment=[Torch{Equipment{requirements='a torch'} Butane Gas power supply}], plannedDate=Date{day=30, month=3, year=2003}}]}"
                , jobCatalog.toString());
    }

    @Test
    void testDataFromScanner(){
        Address address1 = new Address("Mekelweg; 4; 2628CD; Delft");
        assertNotNull(address1);
    }

    @Test
    void readData() {
        JobCatalog jobs = new JobCatalog();
        jobs.readData();
        assertTrue(JobCatalog.listOfJobs.size()>0);
    }

    @Test
    void saveData() {
        JobCatalog catalog = new JobCatalog();
        catalog.readData();
        try(Scanner in = new Scanner(new File("joblist.txt"))){
            assertTrue(in.hasNext());
        } catch (IOException e) {
            e.getMessage();
        }
    }

    @Test
    void testOption4() {
        JobCatalog catalog = new JobCatalog();
        catalog.readData();
        try(Scanner in = new Scanner(new File("joblist.txt"))){
            assertTrue(in.hasNext());
        } catch (IOException e) {
            e.getMessage();
        }
        catalog.option4(new Scanner("8 21-03-2021"));
        assertEquals(21, catalog.getJobs().get(0).getPlannedDate().getDay());
    }

    @Test
    void testOption2() {
        JobCatalog catalog = new JobCatalog();
        int sizeOld = catalog.getJobs().size();
        catalog.option2(new Scanner("St 2 dffe12 Delft\nVery important\n23-10-2010"));
        assertEquals(sizeOld + 1, catalog.getJobs().size());
    }

    @Test
    void testSaveData() {
        JobCatalog catalog = new JobCatalog();
        catalog.readData();
        try(Scanner in = new Scanner(new File("joblist.txt"))){
            assertTrue(in.hasNext());
        } catch (IOException e) {
            e.getMessage();
        }
        catalog.saveData();
        try(Scanner in = new Scanner(new File("joblist.txt"))){
            assertTrue(in.hasNext());
        } catch (IOException e) {
            e.getMessage();
        }
    }

}