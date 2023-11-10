package Services.Auto;

import Technics.Technic;
import Technics.Transport.Transport;
import Technics.Transport.Truck;

public class TruckService extends Autoservice {
    public  TruckService(int id, String name){
        super(id, name);
    }
    public void repair(Technic auto) {
        if(auto instanceof Truck){
            auto.setCondition(true);
        }
        else {
            System.out.println("Error");
            System.exit(0);
        }
    }

}
