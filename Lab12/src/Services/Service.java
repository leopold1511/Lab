package Services;

import Technics.Technic;
import Technics.Transport.Transport;

import java.util.concurrent.Semaphore;

public interface Service {
    void repair(Technic technic, Semaphore sem) throws InterruptedException;

    void printService();

    String getName();
}
