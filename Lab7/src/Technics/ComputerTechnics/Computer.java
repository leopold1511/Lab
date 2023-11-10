package Technics.ComputerTechnics;

public class Computer extends ComputingTechnic{
    int RAM;
    public Computer(int id,int RAM, int CPUcores, boolean condition){
        super(id, CPUcores, condition);
        this.RAM=RAM;
    }
    public void printTechnic(){
        System.out.println("id: "+ getId() + " Компьютер " +  " Оперативная память: " + getRAM() + " Кол-во ядер " + CPUcores + " Состояние: " + getCondition());
    }
    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }
}
