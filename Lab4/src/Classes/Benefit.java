package Classes;

public class Benefit extends Resident{
    boolean benefit;
    public Benefit(String name, double[] energy, boolean benefit ){
        super(name,energy);
        this.benefit=benefit;
    }

    @Override
    public double payForMonth(int month) {
        double sum = periodWaste(month);
        double cost = sum * 2.5;
        return cost*0.25;
    }
    }

