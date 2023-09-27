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
        task5(arr);
        task6(arr);

    }

    public static Resident[] task12() {
        Resident[] arr = new Resident[8];
        double[] en=new double[365];
        arr[0] = new Resident("Stepan",new double[365] );
        arr[1] = new Resident("Elena", new double[365]);
        arr[2] = new Resident("Fedor", new double[365]);
        arr[3] = new Resident("Natalia", new double[365]);
        arr[4] = new Resident("Yuriy", new double[365]);
        arr[5] = new Benefit("Gleb", new double[365], true);
        arr[6] = new Benefit("Vladimir", new double[365], true);
        arr[7] = new Benefit("Stanislav", new double[365], true);


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
                System.out.println("Месяц: "+ k );
                System.out.printf("%.3fкВт ", sumWaste);
                System.out.printf("%.3fр \n",sumCost);



                sumWaste=0;
                sumCost=0;

            }

    }


    public static void task4(Resident[] arr){
        System.out.println("Потребление жильцов и сумма оплаты за каждый месяц отдельно:"  );
        for(int i=0;i<8;i++){
            System.out.println( arr[i].name + ":" );
            for(int k=1;k<13;k++){
                System.out.println("Месяц: "+ k );
                System.out.printf("    %.3fкВт  ", arr[i].periodWaste(k));
                System.out.printf("%.3fр \n  ", arr[i].payForMonth(k));
            }
        }
    }
    public static void task5(Resident[] arr){
        System.out.println("Максимальное и минимальное потребление за месяц");
        int month=3;
        double min=arr[0].periodWaste(month);
        double max=arr[0].periodWaste(month);
        int k1=0,k2=0;
        for(int i=1;i<8;i++){
            if(arr[i].periodWaste(month)>max) {
                max=arr[i].periodWaste(month);
                k2=i;
            }
            if( arr[i].periodWaste(month)<min){
                min=arr[i].periodWaste(month);
                k1=i;
            }
        }
        System.out.println("Месяц "+ month + "\n" + "Минимальное потребление: "+ arr[k1].name + "\n" + "Максимальное потребление:" + arr[k2].name );
    }
    public static void task6(Resident[] arr){
        double max= arr[0].energy[arr[0].MinMaxDay(true)];
        double min= arr[0].energy[arr[0].MinMaxDay(false)];
        int k1=0,k2=0;
        for(int i=0;i<8;i++){
            if(max< arr[i].energy[arr[i].MinMaxDay(true)]){
                max=arr[i].energy[arr[i].MinMaxDay(true)];
                k2=i;
            }
            if(min> arr[i].energy[arr[i].MinMaxDay(false)]){
                min=arr[i].energy[arr[i].MinMaxDay(false)];
                k1=i;
            }

        }
        System.out.print(("Максимальное потребление за день: " + arr[k2].name ));
        System.out.printf(" %.3fкВт \n", max);
        System.out.print(("Минимальное потребление за день: " + arr[k1].name ));
        System.out.printf(" %.3fкВт", min);

    }



    






}

