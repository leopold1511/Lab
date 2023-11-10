package Technics;

public abstract class Technic {
    boolean  condition;
    int id;
    public Technic(int id ,boolean condition){
        this.condition=condition;
        this.id =id;
    }
    public void toBreak(){
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
}
