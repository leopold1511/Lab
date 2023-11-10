package Technics.Transport;

public class Car extends Transport {
    boolean transmission;
    public Car(int id, String carBrand,boolean transmission, boolean condition){
        super(id, carBrand, condition);
        this.transmission=transmission;
    }
    public void printTechnic(){
        System.out.println("id: "+ getId() + " Машина " +  " Бренд: " + getCarBrand() + " Коробка передач: " + getTransmission() + " Состояние: " + getCondition());
    }
    public String getTransmission() {
        if(transmission==true) return "Механика";
        else return "Автомат";
    }

    public void setTransmission(boolean transmission) {
        this.transmission = transmission;
    }
}
