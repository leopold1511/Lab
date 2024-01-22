package Services.ComputingTechnics;

import Technics.ComputerTechnics.ComputingTechnic;
import Technics.ComputerTechnics.Phone;
import Technics.Technic;

import java.util.concurrent.Semaphore;

final public class PhoneService extends ComputingTechnicsServices {
    public PhoneService(int id, String name){
        super(id, name);
    }
    public void repair(Technic computer, Semaphore sem) throws InterruptedException {
        sem.acquire();
        synchronized (computer) {
            System.out.println("Телефон " + computer.getId() + " В починке "  );
            Thread.sleep(2000);
            computer.setCondition(true);
            System.out.println("Телефон " + computer.getId() + " Отремонтирован "  );
            sem.release();
        }
    }
}
