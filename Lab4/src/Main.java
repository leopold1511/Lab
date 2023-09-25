import Classes.Resident;
import Classes.Benefit;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Resident[] arr = new Resident[8];
        arr= task12();
        task3(arr);
        task4(arr);

    }

    public static Resident[] task12() {
        Resident[] arr = new Resident[8];
        double[] en=new double[365];
        arr[0] = new Resident("Stepan",en  );
        arr[1] = new Resident("Elena", en);
        arr[2] = new Resident("Fedor", en);
        arr[3] = new Resident("Natalia", en);
        arr[4] = new Resident("Yuriy", en);
        arr[5] = new Benefit("Gleb", en, true);
        arr[6] = new Benefit("Vladimir", en, true);
        arr[7] = new Benefit("Stanislav", en, true);


        for (int k = 0; k < 8; k++) {
            for (int i = 0; i < 365; i ++) {
                arr[k].energy[i] = Math.random();
            }


        }
        return arr;

    }
    public static void task3(Resident[] arr){
        double sumWaste=0;
        double sumCost=0;
        System.out.println("Общее потребление и сумма оплаты за каждый месяц:"  );
            for(int k=1;k<13;k++){
                for(int i=0;i<8;i++){
                    sumWaste+=arr[i].periodWaste(k);
                    sumCost+=arr[i].payForMonth(k);
                }
                System.out.println("Месяц: "+ k + "  " + sumWaste + "кВт "+ sumCost + "р" );

            }

    }


    public static void task4(Resident[] arr){
        System.out.println("Потребление жильцов и сумма оплаты за каждый месяц отдельно:"  );
        for(int i=0;i<8;i++){
            System.out.println( arr[i].name + ":" );
            for(int k=1;k<13;k++){
                System.out.println("Месяц: "+ k + "  " + arr[i].periodWaste(k)+ "кВт "+ arr[i].payForMonth(k) + "р" );
            }
        }
    }
    






}

