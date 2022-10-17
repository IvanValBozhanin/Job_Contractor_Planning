public class JackHammer extends Equipment implements PowerSupply{

    public JackHammer(String requirements) {
        super(requirements);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o) ;//&& this.getClass() == o.getClass();
    }

    @Override
    public String toString() {
        return "JackHammer{" + super.toString() + " " + getPowerSupply() + "}";
    }

    @Override
    public String getPowerSupply() {
        return "Air Compressor power supply";
    }
}
