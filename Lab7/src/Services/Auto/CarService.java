package Services.Auto;

import Technics.Technic;
import Technics.Transport.Car;
import Technics.Transport.Transport;

public class CarService extends  Autoservice{
    public  CarService(int id, String name){
        super(id, name);
    }
    public void repair(Technic auto) {
        if(auto instanceof Car){
            auto.setCondition(true);
        }
        else {
            System.out.println("Error");
            System.exit(0);
        }
    }

}
