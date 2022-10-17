public class Torch extends Equipment implements PowerSupply{
    public Torch(String requirements) {
        super(requirements);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);// && getClass() == o.getClass();
    }

    @Override
    public String toString() {
        return "Torch{" + super.toString() + " " + getPowerSupply() + "}";
    }

    @Override
    public String getPowerSupply() {
        return "Butane Gas power supply";
    }
}
