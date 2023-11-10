package Services.ComputingTechnics;

import Technics.ComputerTechnics.Computer;
import Technics.ComputerTechnics.ComputingTechnic;
import Technics.Technic;

public class ComputerService extends  ComputingTechnicsServices{
    public ComputerService(int id, String name){
        super(id, name);
    }
    public void repair(Technic computingTechnic){
        if(computingTechnic instanceof Computer){
            computingTechnic.setCondition(true);
        }
        else {
            System.out.println("Error");
            System.exit(0);
        }

    }

}
