public class ConcreteMixer extends Equipment {

    /**
     * Constructor of the Concrete Mixer object that takes only list of requirements
     * @param requirements - the list of requirements
     */
    public ConcreteMixer(String requirements) {
        super(requirements);
    }

    /**
     * ToString method of Concrete Mixer
     * @return a string of info in human-readable format
     */
    @Override
    public String toString() {
        return "ConcreteMixer{ " + super.toString() + " }";
    }

    /**
     * Equals method of Concrete Mixer
     * @param o - the object to be compared
     * @return true iff the object is equal in terms of fields and class
     */
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
