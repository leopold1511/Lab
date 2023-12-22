package Technics.ComputerTechnics;

import Technics.Technic;

public abstract class ComputingTechnic extends Technic {
    int CPUcores;
    public ComputingTechnic(int id, int CPUcores, boolean condition ){
        super(id, condition);
        this.CPUcores=CPUcores;
    }

    public int getCPUcores() {
        return CPUcores;
    }

    public void setCPUcores(int CPUcores) {
        this.CPUcores = CPUcores;
    }
}
