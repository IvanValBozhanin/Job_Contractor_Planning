import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Job {
    private int jobNumber;
    private Address location;
    private String description;
    private List<Equipment> requiredEquipment;
    private Date plannedDate;
    private static int jobTotal = 0;

    /**
     * Constructor for the Job object
     * @param location - the address of the job
     * @param description - the description of the job
     * @param requiredEquipment - the required equipment of the job
     * @param plannedDate - the planned date of the job
     */
    public Job(Address location, String description,
               List<Equipment> requiredEquipment, Date plannedDate) {
        this.location = location;
        this.description = description;
        this.requiredEquipment = requiredEquipment;
        this.plannedDate = plannedDate;
        this.jobNumber = ++jobTotal;
    }

    /**
     * Equals method of Job
     * @param o - the object to be compared
     * @return true iff the object is equal in terms of fields and class
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return Objects.equals(location, job.location) &&
                Objects.equals(description, job.description) &&
                Objects.equals(requiredEquipment, job.requiredEquipment)
                && Objects.equals(plannedDate, job.plannedDate);
    }

    /**
     * Hashcode method of the Job object
     * @return integer of the hascode of the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(jobNumber, location, description, requiredEquipment, plannedDate);
    }

    /**
     * ToString method of Job
     * @return a string of info in human-readable format
     */
    @Override
    public String toString() {
        return "Job{" +
                "jobNumber=" + jobNumber +
                ", location=" + location +
                ", description='" + description + '\'' +
                ", requiredEquipment=" + requiredEquipment +
                ", plannedDate=" + plannedDate +
                '}';
    }

    /**
     * Getter of the job number
     * @return the integer of the job number
     */
    public int getJobNumber() {
        return jobNumber;
    }

    /**
     * Getter of the address of the job
     * @return the address of the job
     */
    public Address getLocation() {
        return location;
    }

    /**
     * Getter for the description of the job
     * @return the description of the job
     */
    public String getDescription() {
        return description;
    }

    /**
     * Getter for the required equipment of the job
     * @return the required equipment of the job
     */
    public List<Equipment> getRequiredEquipment() {
        return requiredEquipment;
    }

    /**
     * Getter for the planned date of the job
     * @return the planned date of the job
     */
    public Date getPlannedDate() {
        return plannedDate;
    }
}
