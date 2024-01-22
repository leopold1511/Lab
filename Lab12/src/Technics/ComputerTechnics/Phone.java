package Technics.ComputerTechnics;

final public class Phone extends ComputingTechnic{
    String brand;
    public Phone(int id,String brand, int CPUcores, boolean condition){
        super(id, CPUcores, condition);
        this.brand=brand;
    }
    public void printTechnic(){
        System.out.println("id: "+ getId() + " Телефон "  +  " Бренд: " + getBrand() + " Кол-во ядер " + CPUcores + " Состояние: " + getCondition());
    }
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
