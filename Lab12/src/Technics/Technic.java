package Technics;

import Services.Service;

import java.util.ArrayList;
import java.util.List;

public abstract class Technic {
    boolean  condition;
    int id;
    public Technic(int id ,boolean condition){
        this.condition=condition;
        this.id =id;
    }
    public void toSmash(){
        setCondition(false);
    }
    public void seeCondition(){
        System.out.println(getCondition());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getCondition() {
        return condition;
    }

    public void setCondition(boolean condition) {
        this.condition = condition;
    }

    public abstract void printTechnic();
    //public abstract int toKnowService(ArrayList<Service> list);
}
