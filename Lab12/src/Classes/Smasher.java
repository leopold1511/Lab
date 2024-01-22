package Classes;

import Technics.ComputerTechnics.Computer;
import Technics.ComputerTechnics.Phone;
import Technics.Technic;
import Technics.Transport.Truck;
import Technics.Transport.Car;

import java.util.List;
import java.util.Random;

public class Smasher implements Runnable {
    List<Technic> ListOfTechnic;
    Random r = new Random();
    int k;

    public Smasher(List<Technic> ListOfTechnic) {
        this.ListOfTechnic = ListOfTechnic;
    }

    @Override
    public void run() {
        int size = ListOfTechnic.size();
        while (true) {
            for (int i = 0; i < size; i++) {
                k = r.nextInt(10);
                if (ListOfTechnic.get(k).getCondition() && k < 5) {
                    if (ListOfTechnic.get(i).getClass().equals(Computer.class))
                        System.out.println("Компьютер " + ListOfTechnic.get(i).getId() + " Сломан ");
                    if (ListOfTechnic.get(i).getClass().equals(Phone.class))
                        System.out.println("Телефон " + ListOfTechnic.get(i).getId() + " Сломан ");
                    if (ListOfTechnic.get(i).getClass().equals(Car.class))
                        System.out.println("Автомобиль " + ListOfTechnic.get(i).getId() + " Сломан ");
                    if (ListOfTechnic.get(i).getClass().equals(Truck.class))
                        System.out.println("Грузовик" + ListOfTechnic.get(i).getId() + " Сломан ");
                    ListOfTechnic.get(i).toSmash();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
