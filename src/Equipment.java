import java.util.Objects;

public abstract class Equipment {
    private String requirements;

    public Equipment(String requirements) {
        this.requirements = requirements;
    }

    public String getRequirements() {
        return requirements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        System.out.println(getClass() + " " + o.getClass());
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return Objects.equals(requirements, equipment.requirements);
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "requirements='" + requirements + '\'' +
                '}';
    }


}
