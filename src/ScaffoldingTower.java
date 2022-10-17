public class ScaffoldingTower extends Equipment{
    public ScaffoldingTower(String requirements) {
        super(requirements);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);// && getClass() == o.getClass();
    }

    @Override
    public String toString() {
        return "ScaffoldingTower{" + super.toString() + "}";
    }
}
