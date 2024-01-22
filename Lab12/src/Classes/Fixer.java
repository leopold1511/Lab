package Classes;

import Services.Service;
import Technics.Technic;

import java.util.List;
import java.util.concurrent.Semaphore;

public class Fixer implements Runnable {
    List<Technic> listOfTechnics;
    Semaphore sem;
    Service service;
    public Fixer( List<Technic> listOfTechnics,Semaphore sem,Service service){
        this.listOfTechnics=listOfTechnics;
        this.sem=sem;
        this.service=service;
    }
    @Override
    public void run() {
        while (true) {
            for (int i=0;i<5;i++) {
                if (!listOfTechnics.get(i).getCondition()) {
                    try {
                        this.service.repair(listOfTechnics.get(i), sem);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

}
