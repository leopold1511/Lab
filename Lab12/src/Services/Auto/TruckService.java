package Services.Auto;

import Technics.Technic;
import Technics.Transport.Transport;
import Technics.Transport.Truck;

import java.util.concurrent.Semaphore;

final public class TruckService extends Autoservice {
    public  TruckService(int id, String name){
        super(id, name);
    }
    public void repair(Technic computer, Semaphore sem) throws InterruptedException {
        sem.acquire();
        synchronized (computer) {
            System.out.println("Грузовик " + computer.getId() + " В починке "  );
            Thread.sleep(2000);
            computer.setCondition(true);
            System.out.println("Грузовик " + computer.getId() + " Отремонтирован "  );
            sem.release();
        }

    }

}
