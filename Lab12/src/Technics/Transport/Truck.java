package Technics.Transport;

final public class Truck extends Transport{
    float capacity;
    public Truck(int id, String carBrand,float capacity, boolean condition){
        super(id, carBrand, condition);
        this.capacity=capacity;
    }
    public void printTechnic(){
        System.out.println("id: "+ getId()  + " Грузовик "+  " Бренд: " + getCarBrand() + " Вместимость: " + capacity + " Состояние: " + getCondition());
    }



    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }
}
