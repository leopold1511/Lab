package Technics.Transport;

import Services.Service;

import java.util.ArrayList;

final public class Car extends Transport {
    boolean transmission;

    public Car(int id, String carBrand, boolean transmission, boolean condition) {
        super(id, carBrand, condition);
        this.transmission = transmission;
    }

    public void printTechnic() {
        System.out.println("id: " + getId() + " Машина " + " Бренд: " + getCarBrand() + " Коробка передач: " + getTransmission() + " Состояние: " + getCondition());
    }

    public String getTransmission() {
        if (transmission == true) return "Механика";
        else return "Автомат";
    }

    public int toKnowService(ArrayList<Service> list) {
        int id=0;
        for (id=0;id< list.size();id++){

        }


        return id;
    }



    public void setTransmission(boolean transmission) {
        this.transmission = transmission;
    }
}
