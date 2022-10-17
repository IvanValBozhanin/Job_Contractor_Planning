import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JobCatalog {
    private List<Job> jobs;

    public JobCatalog() {
        this.jobs = new ArrayList<>();
    }

    public void addJob(Job job){
        jobs.add(job);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobCatalog that = (JobCatalog) o;
        return Objects.equals(jobs, that.jobs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobs);
    }

    @Override
    public String toString() {
        return "JobCatalog{" +
                "jobs=" + jobs +
                '}';
    }
}
