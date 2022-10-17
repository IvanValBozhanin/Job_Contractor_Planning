public class ConcreteMixer extends Equipment {

    public ConcreteMixer(String requirements) {
        super(requirements);
    }

    @Override
    public String toString() {
        return "ConcreteMixer{ " + super.toString() + " }";
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);// && this.getClass() == o.getClass();
    }
}
