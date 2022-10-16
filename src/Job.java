import java.util.List;
import java.util.Objects;

public class Job {
    private int jobNumber;
    private Address location;
    private String description;
    private List<Equipment> requiredEquipment;
    private Date plannedDate;
    private static int jobTotal = 0;

    public Job(Address location, String description, List<Equipment> requiredEquipment, Date plannedDate) {
        this.location = location;
        this.description = description;
        this.requiredEquipment = requiredEquipment;
        this.plannedDate = plannedDate;
        this.jobNumber = ++jobTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return Objects.equals(location, job.location) && Objects.equals(description, job.description) && Objects.equals(requiredEquipment, job.requiredEquipment) && Objects.equals(plannedDate, job.plannedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobNumber, location, description, requiredEquipment, plannedDate);
    }

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

    public int getJobNumber() {
        return jobNumber;
    }

    public Address getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public List<Equipment> getRequiredEquipment() {
        return requiredEquipment;
    }

    public Date getPlannedDate() {
        return plannedDate;
    }

    public static int getJobTotal() {
        return jobTotal;
    }
}
