package Classes;

import java.util.List;



public class Resident {
   public String name;
    public double[] energy = new double[365];

    public Resident(String name, double[] energy) {
        this.name = name;
        this.energy = energy;
    }

    public int[] monthDetector(int month) {
        int[] k = new int[2];
        switch (month) {
            case 1:
                k[0] = 0;
                k[1] = 30;
                break;
            case 2:
                k[0] = 31;
                k[1] = 58;
                break;
            case 3:
                k[0] = 59;
                k[1] = 89;
                break;
            case 4:
                k[0] = 90;
                k[1] = 119;
                break;
            case 5:
                k[0] = 120;
                k[1] = 150;
                break;
            case 6:
                k[0] = 151;
                k[1] = 180;
                break;
            case 7:
                k[0] = 181;
                k[1] = 211;
                break;
            case 8:
                k[0] = 212;
                k[1] = 242;
                break;
            case 9:
                k[0] = 243;
                k[1] = 272;
                break;
            case 10:
                k[0] = 273;
                k[1] = 303;
                break;
            case 11:
                k[0] = 304;
                k[1] = 333;
                break;
            default:
                k[0] = 334;
                k[1] = 364;
                break;
        }
        return k;
    }


    public double periodWaste() {
        double sum = 0;
        for (int i = 0; i < 365; i++) {
            sum += energy[i];
        }
        return sum;
    }

    public double periodWaste(int month) {
        double sum = 0;
        int[] k = new int[2];
        k = monthDetector(month);
        for (int i = k[0]; i <= k[1]; i++) {
            sum += energy[i];
        }
        return sum;
    }

    public double payForMonth(int month) {
        double sum = periodWaste(month);
        double cost = sum * 2.5;
        return cost;
    }

    public int MaxWaste() {
        double[] wastePerMonth = new double[12];
        int max=0;
        for (int i = 1; i < 12; i++) {
            wastePerMonth[i]=periodWaste(i+1);
        }
        for(int i=0;i<12;i++){
            if(wastePerMonth[max]<wastePerMonth[i]) max=i;
        }
        return max+1;
    }
    public int MinWaste() {
        double[] wastePerMonth = new double[12];
        int min=0;
        for (int i = 0; i < 12; i++) {
            wastePerMonth[i]=periodWaste(i+1);
        }
        for(int i=0;i<12;i++){
            if(wastePerMonth[min]>wastePerMonth[i]) min=i;
        }
        return min+1;
    }
    public int MinMaxDay(boolean maximal){
        int res=0;
        if(maximal){
           for(int i=1;i<365;i++){
              if (energy[res]<energy[i]) res=i;
           }
        }
        else {
            for (int i=1;i<365;i++){
                if(energy[res]>energy[i]) res=i;
            }
        }
        return res;

    }
    public double averageWaste(int month){
        double waste=periodWaste(month);
        int[] k=new int[2];
        k=monthDetector(month);
        double average=waste/(k[1]-k[0]);
        return average;
    }



}