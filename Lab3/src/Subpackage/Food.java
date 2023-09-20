package Subpackage;

public class Food {
   private String name;
    private double proteins;
    private double fats;
    private double carbohydrates;

    public Food(String name, double proteins,double fats ,double carbohydrates ){
        this.name=name;
        this.proteins=proteins;
        this.carbohydrates=carbohydrates;
        this.fats=fats;

    }
    public double calories(){
        double calories= fats*9.29+proteins*4.1+fats*4.1;
        return calories;
    }
    public String getName(){return name;}
    public double getProteins(){
        return proteins;
    }
    public double getCarbohydrates(){
        return carbohydrates;
    }
    public double getFats(){
        return fats;
    }



}
