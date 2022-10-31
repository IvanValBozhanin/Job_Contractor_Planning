import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class JobCatalog {
    private List<Job> jobs;

    /**
     * Constructor for the Job Catalog that takes no paramteres
     */
    public JobCatalog() {
        this.jobs = new ArrayList<>();
    }

    /**
     * Method to read from file. Fills the List with Jobs that are read from file.\
     */
    public static void readData(){
        try(BufferedReader reader = new BufferedReader(new FileReader("joblist.txt"))){
            String line;
            while((line = reader.readLine()) != null) {
                Address address = new Address(line);
                String description = reader.readLine();
                Scanner instruments = new Scanner(reader.readLine());
                instruments.useDelimiter("; |;");
                ArrayList<Equipment> equipmentArrayList = new ArrayList<>();
                while (instruments.hasNext()) {
                    Scanner instrument = new Scanner(instruments.next());
                    instrument.useDelimiter(", ");
                    String nameInstrument = instrument.next();
                    switch (nameInstrument) {
                        case "JackHammer" -> equipmentArrayList
                                .add(new JackHammer(instrument.next()));
                        case "Scaffolding" -> equipmentArrayList
                                .add(new ScaffoldingTower(instrument.next()));
                        case "ConcreteMixer" -> equipmentArrayList
                                .add(new ConcreteMixer((instrument.next())));
                        case "Torch" -> equipmentArrayList
                                .add(new Torch(instrument.next()));
                    }
                }
                Date date = new Date(reader.readLine());
                Job.listOfJobs.add(new Job(address, description, equipmentArrayList, date));
            }
        } catch (IOException ignored){}
    }

    /**
     * The fourth option of the menu (Change date of existing job)
     * @param in - the scanner we use to read the date and job
     */
    public static void option4(Scanner in){
        System.out.println("Enter job number to have its date changed: ");
        int change = in.nextInt();
        Date date = Date.scanDate(in);
        for (int i = 0; i < Job.listOfJobs.size(); ++i) {
            if (Job.listOfJobs.get(i).getJobNumber() == change) {
                Job.listOfJobs.get(i).getPlannedDate().setDay(date.getDay());
                Job.listOfJobs.get(i).getPlannedDate().setMonth(date.getMonth());
                Job.listOfJobs.get(i).getPlannedDate().setYear(date.getYear());
                break;
            }
        }
    }

    /**
     * The second option of the menu(Adding a new job)
     * @param in - the scanner to read from
     */
    public static void option2(Scanner in) {
        System.out.println("Please enter the following information correctly:");
        Address address;
        Job job;
        System.out.print("Name of street: ");
        String addressName = in.next();
        System.out.print("Number of street: ");
        int addressNumber = in.nextInt();
        System.out.print("Zipcode of street: ");
        String addressZip = in.next();
        System.out.print("City: ");
        String addressCity = in.next();
        address = new Address(addressName, addressNumber, addressZip, addressCity);
        System.out.print("Job description: ");
        in.nextLine();
        String des = in.nextLine();
        Date date = Date.scanDate(in);
        job = new Job(address, des, new ArrayList<>(), date);
        Job.listOfJobs.add(job);
        System.out.println("Job Successfully Added!\n");
    }

    /**
     * Method to write to file with the jobs form the current catalogue.
     */
    public static void saveData() {
        try(PrintWriter writer = new PrintWriter("joblist.txt")){
            for (Job job: Job.listOfJobs) {
                writer.write(job.getLocation().getStreet() + "; ");
                writer.write(job.getLocation().getNumber() + "; ");
                writer.write(job.getLocation().getZipCode() + "; ");
                writer.write(job.getLocation().getCity() + "\n");
                writer.write(job.getDescription() + "\n");
                for (Equipment eq :
                        job.getRequiredEquipment()) {
                    switch (eq.getClass().getSimpleName()) {
                        case "Torch" -> writer.write("Torch, ");
                        case "JackHammer" -> writer.write("JackHammer, ");
                        case "ScaffoldingTower" -> writer.write("Scaffolding, ");
                        case "ConcreteMixer" -> writer.write("ConcreteMixer, ");
                    }
                    writer.write(eq.getRequirements() + "; ");
                }
                writer.write("\n" + job.getPlannedDate().getDay()+"-");
                writer.write(job.getPlannedDate().getMonth()+"-");
                writer.write(job.getPlannedDate().getYear() + "\n");
            }
        } catch (IOException ignored){}
    }

    /**
     * Adds new job to the catalogue
     * @param job - the job to be added to the catalogue
     */
    public void addJob(Job job){
        jobs.add(job);
    }

    /**
     * Equals method of Job Catalogue
     * @param o - the object to be compared
     * @return true iff the object is equal in terms of fields and class
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobCatalog that = (JobCatalog) o;
        return Objects.equals(jobs, that.jobs);
    }

    /**
     * Hashcode method of the Job Catalogue object
     * @return integer of the hascode of the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(jobs);
    }

    /**
     * ToString method of Job Catalogue
     * @return a string of info in human-readable format
     */
    @Override
    public String toString() {
        return "JobCatalog{" +
                "jobs=" + jobs +
                '}';
    }
}
