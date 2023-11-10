package Services;

import Technics.Technic;
import Technics.Transport.Transport;

public interface Service {
    void repair(Technic technic);
    void printService();

}
