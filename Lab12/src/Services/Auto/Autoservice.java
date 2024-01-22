package Services.Auto;

import Services.Service;
import Technics.ComputerTechnics.Computer;
import Technics.Technic;
import Technics.Transport.Transport;

public abstract class Autoservice implements Service {
    protected  int id;
    protected String name;
    public Autoservice(int id, String name){
        this.id=id;
        this.name=name;
    }
    final public void printService(){
        System.out.println("id: " + getId() + "  Автосервис "+ getName() );
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
