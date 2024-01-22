package Services.ComputingTechnics;

import Services.Service;
import Technics.ComputerTechnics.ComputingTechnic;
import Technics.Technic;

public abstract class ComputingTechnicsServices implements Service {
    protected  int id;
    protected String name;
    public ComputingTechnicsServices(int id, String name){
        this.id=id;
        this.name=name;
    }
   final public void printService(){
        System.out.println("id: " + getId() + "  Компьютерный сервис "+ getName() );
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
