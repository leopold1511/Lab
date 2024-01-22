package Services.ComputingTechnics;

import Technics.ComputerTechnics.Computer;
import Technics.ComputerTechnics.ComputingTechnic;
import Technics.Technic;

import java.util.concurrent.Semaphore;

final public class ComputerService extends ComputingTechnicsServices {
    public ComputerService(int id, String name) {
        super(id, name);
    }


    public void repair(Technic computer, Semaphore sem) throws InterruptedException {
        sem.acquire();
        synchronized (computer) {
                System.out.println("Компьютер " + computer.getId() + " В починке "  );
                Thread.sleep(2000);
                computer.setCondition(true);
                System.out.println("Компьютер " + computer.getId() + " Отремонтирован "  );
                sem.release();
        }

        }
    }

