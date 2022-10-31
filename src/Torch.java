public class Torch extends Equipment implements PowerSupply{
    /**
     * Constructor of the Torch object that takes only list of requirements
     * @param requirements - the list of requirements
     */
    public Torch(String requirements) {
        super(requirements);
    }

    /**
     * Equals method of Torch
     * @param o - the object to be compared
     * @return true iff the object is equal in terms of fields and class
     */
    @Override
    public boolean equals(Object o) {
        return super.equals(o);// && getClass() == o.getClass();
    }

    /**
     * ToString method of Torch
     * @return a string of info in human-readable format
     */
    @Override
    public String toString() {
        return "Torch{" + super.toString() + " " + getPowerSupply() + "}";
    }

    /**
     * Getter of the type of power supply
     * @return - the power supply needed to use the Torch
     */
    @Override
    public String getPowerSupply() {
        return "Butane Gas power supply";
    }
}
