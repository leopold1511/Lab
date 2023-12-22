package Services.ComputingTechnics;

import Technics.ComputerTechnics.ComputingTechnic;
import Technics.ComputerTechnics.Phone;
import Technics.Technic;

final public class PhoneService extends ComputingTechnicsServices {
    public PhoneService(int id, String name){
        super(id, name);
    }
    public void repair(Technic computingTechnic){
        if(computingTechnic instanceof Phone){
            computingTechnic.setCondition(true);
        }
        else {
            System.out.println("Error");
            System.exit(0);
        }

    }
}
