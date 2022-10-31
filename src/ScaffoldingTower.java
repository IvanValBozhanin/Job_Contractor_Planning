public class ScaffoldingTower extends Equipment{

    /**
     * Constructor of the Scaffolding Tower object that takes only list of requirements
     * @param requirements - the list of requirements
     */
    public ScaffoldingTower(String requirements) {
        super(requirements);
    }

    /**
     * Equals method of Scaffolding Tower
     * @param o - the object to be compared
     * @return true iff the object is equal in terms of fields and class
     */
    @Override
    public boolean equals(Object o) {
        return super.equals(o);// && getClass() == o.getClass();
    }

    /**
     * ToString method of Scaffolding Tower
     * @return a string of info in human-readable format
     */
    @Override
    public String toString() {
        return "ScaffoldingTower{" + super.toString() + "}";
    }
}
