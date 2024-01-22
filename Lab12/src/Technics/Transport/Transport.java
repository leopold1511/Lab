package Technics.Transport;

import Technics.Technic;

public abstract class Transport extends Technic {
    public String carBrand;
    public Transport(int id, String carBrand, boolean condition){
        super(id, condition);
        this.carBrand=carBrand;
    }
    public String getCarBrand() {
        return carBrand;
    }
    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }
}
