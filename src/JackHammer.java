public class JackHammer extends Equipment implements PowerSupply{

    /**
     * Constructor of the Jack Hammer object that takes only list of requirements
     * @param requirements - the list of requirements
     */
    public JackHammer(String requirements) {
        super(requirements);
    }

    /**
     * Equals method of Jack Hammer
     * @param o - the object to be compared
     * @return true iff the object is equal in terms of fields and class
     */
    @Override
    public boolean equals(Object o) {
        return super.equals(o) ;//&& this.getClass() == o.getClass();
    }

    /**
     * ToString method of Jack Hammer
     * @return a string of info in human-readable format
     */
    @Override
    public String toString() {
        return "JackHammer{" + super.toString() + " " + getPowerSupply() + "}";
    }

    /**
     * Getter of the type of power supply
     * @return - the power supply needed to use the Jack Hammer
     */
    @Override
    public String getPowerSupply() {
        return "Air Compressor power supply";
    }
}
