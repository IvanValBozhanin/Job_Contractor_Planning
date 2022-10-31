import java.util.Objects;

public abstract class Equipment {
    private String requirements;

    /**
     * Constructor for the equipment
     * @param requirements - the requirements for the equipment
     */
    public Equipment(String requirements) {
        this.requirements = requirements;
    }

    /**
     * Getter method of the requirements for the equipment
     * @return the string of the requirements for the equipment
     */
    public String getRequirements() {
        return requirements;
    }

    /**
     * Equals method of Equipment
     * @param o - the object to be compared
     * @return true iff the object is equal in terms of fields and class
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        System.out.println(getClass() + " " + o.getClass());
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return Objects.equals(requirements, equipment.requirements);
    }

    /**
     * ToString method of Equipment
     * @return a string of info in human-readable format
     */
    @Override
    public String toString() {
        return "Equipment{" +
                "requirements='" + requirements + '\'' +
                '}';
    }
}
