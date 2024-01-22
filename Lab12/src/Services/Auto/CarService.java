package Services.Auto;

import Technics.Technic;
import Technics.Transport.Car;

import java.util.concurrent.Semaphore;

final public class CarService extends  Autoservice{
    public  CarService(int id, String name){
        super(id, name);
    }
    public void repair(Technic computer, Semaphore sem) throws InterruptedException {
        sem.acquire();
        synchronized (computer) {
            System.out.println("Автомобиль " + computer.getId() + " В починке "  );
            Thread.sleep(2000);
            computer.setCondition(true);
            System.out.println("Автомобиль " + computer.getId() + " Отремонтирован "  );
            sem.release();
        }

    }

}
