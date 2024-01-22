package Classes;

import Services.Auto.CarService;
import Services.Auto.TruckService;
import Services.ComputingTechnics.ComputerService;
import Services.ComputingTechnics.PhoneService;
import Technics.ComputerTechnics.Computer;
import Technics.ComputerTechnics.Phone;
import Classes.Smasher;
import Technics.Technic;
import Technics.Transport.Car;
import Technics.Transport.Truck;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        task();
    }

    public static void task() {
        List<Technic> listOfCar = new ArrayList<>() {{
            add(new Car(0, "Toyota", true, true));
            add(new Car(1, "Honda", false, true));
            add(new Car(2, "Volkswagen", true, true));
            add(new Car(3, "Lada", false, true));
            add(new Car(4, "Mazda", true, true));
        }};
        List<Technic> listOfTruck = new ArrayList<>() {{
            add(new Truck(5, "KAMAZ", 6, true));
            add(new Truck(6, "MAZ", 9, true));
            add(new Truck(7, "BelAZ", 12, true));
            add(new Truck(8, "GAZ", 8, true));
            add(new Truck(9, "UAZ", 7, true));
        }};
        List<Technic> listOfComputer = new ArrayList<>() {{
            add(new Computer(10, 16, 2, true));
            add(new Computer(11, 8, 3, true));
            add(new Computer(12, 32, 2, true));
            add(new Computer(13, 64, 4, true));
            add(new Computer(14, 16, 2, true));
        }};
        List<Technic> listOfPhone = new ArrayList<>() {{
            add(new Phone(15, "Iphone", 4, true));
            add(new Phone(16, "Samsung", 4, true));
            add(new Phone(17, "Nokia", 2, true));
            add(new Phone(18, "Huawei", 4, true));
            add(new Phone(19, "Motorola", 1, true));
        }};
        List<Technic> listOfTechnic = new ArrayList<>() {{
            addAll(listOfCar);
            addAll(listOfTruck);
            addAll(listOfComputer);
            addAll(listOfPhone);
        }};
        Thread smashThread = new Thread(new Smasher(listOfTechnic));
        smashThread.start();

        PhoneService phoneService = new PhoneService(0, "Телефонная");
        ComputerService computerService = new ComputerService(1, "Компьютерная");
        CarService carService = new CarService(2, "Машинная");
        TruckService truckService = new TruckService(3, "Грузовичная");

        Runnable phoneFixer = new Fixer(listOfPhone, new Semaphore(2), phoneService);
        Runnable ComputerFixer = new Fixer(listOfComputer, new Semaphore(2), computerService);
        Runnable carFixer = new Fixer(listOfCar, new Semaphore(2), carService);
        Runnable truckFixer = new Fixer(listOfTruck, new Semaphore(2), truckService);

        Thread phoneThread = new Thread(phoneFixer);
        phoneThread.start();
        Thread compThread = new Thread(ComputerFixer);
        compThread.start();
        Thread carThread = new Thread(carFixer);
        carThread.start();
        Thread truckThread = new Thread(truckFixer);
        truckThread.start();

        TimerTask shutdownTask = new TimerTask() {
            @Override
            public void run() {
                System.exit(0);
            }
        };
        Timer timer = new Timer();
        timer.schedule(shutdownTask, 1000 * 60);
    }
}
    /*public static void menuLab(){
        while ( true) {
            Scanner in = new Scanner(System.in);
            System.out.println(" Выберите лабораторную");
            System.out.println("1. Лабораторная 7,8");
            System.out.println("2. Лабораторная 9");
            System.out.println("3. Выход");
            int i = 0;
            try {
                i = in.nextInt();
                if (i < 1 || i > 3) System.out.println("Плохой выбор \n Введите число от 1 до 3");
            } catch (InputMismatchException e) {
                System.out.println("Введите число");
                in.next();
            }
            switch (i) {
                case 1:
                    menu();
                    break;
                case 2:
                    GUI();
                    break;
                case 3:
                    System.exit(0);
            }
        }

    }


    public static void menu(){
        List<Technic> listofTechnics= ListOfTechnics();
        List<Service> listService= ListOfServices();
        Scanner in=new Scanner(System.in);
        List<String> history=new ArrayList<>();
        while(true){
            int i=0;
            int count=0;
            boolean c=false;
            int k=0;
           System.out.println("Главное меню");
           System.out.println("1. Посмотреть список техники");
           System.out.println("2. Посмотреть список сервисов");
           System.out.println("3. Сломать технику");
           System.out.println("4. Починить технику");
           System.out.println("5. Посмотреть историю починок");
            System.out.println("6. Выход");
            while(!c) {
                try {
                    i = in.nextInt();
                    if(i>0 && i<=6) c=true;
                    else System.out.println("Плохой выбор \n Введите число от 1 до 6");
                } catch (InputMismatchException e) {
                    System.out.println("Введите число");
                    in.next();
                }
            }
            switch (i){
               case 1 :
                   printTechnics(listofTechnics);
                   break;
               case 2:
                   printServices(listService);
                   break;
               case 3:
                   printTechnics(listofTechnics);
                   System.out.println("Введите id техники, которую желаете сломать");
                   c=false;
                   while(!c) {
                       try {
                           k = in.nextInt();
                           if(k>=0 && k<listofTechnics.size()) c=true;
                           else System.out.println("Плохой выбор \n Выберите технику из базы");
                       } catch (InputMismatchException e) {
                           System.out.println("Введите число");
                           in.next();

                       }
                   }
                   if (!listofTechnics.get(k).getCondition()) System.out.println("То что мертво умереть не может");
                   else listofTechnics.get(k).toSmash();
                   break;
               case 4:
                   printTechnics(listofTechnics);
                   System.out.println("Введите id техники которую желаете починить");
                   c=false;
                   while(!c) {
                       try {
                           k = in.nextInt();
                           if(k>=0 && k<listofTechnics.size()) c=true;
                           else System.out.println("Плохой выбор \n Выберите технику из базы");
                       } catch (InputMismatchException e) {
                           System.out.println("Введите число");
                           in.next();
                       }
                   }
                   if(listofTechnics.get(k).getCondition()){
                       System.out.println("Всё и так в порядке");
                       break;
                   }
                   else {
                      int counter=0;
                       while (!(listService.get(count).repair(listofTechnics.get(k)))){
                           listService.get(k).repair(listofTechnics.get(k));
                           count++;
                       }
                   }
                   System.out.println("Успешно починено");
                   history.add(listService.get(count).getName() + " Id техники " + listofTechnics.get(k).getId());
                   break;
               case 5:
                   System.out.println("История:");
                   for(count=0;count< history.size();count++){
                       System.out.println(history.get(count));
                   }
                   break;
                case 6:
                    menuLab();
                    break;
               default:

           }
        }
    }


    public static List<Technic> ListOfTechnics(){
        List<Technic> listofTechnics= new ArrayList<Technic>();
        listofTechnics.add(new Computer(0, 8,4, true));
        listofTechnics.add(new Computer(1, 16,2, false));
        listofTechnics.add(new Phone(2, "Iphone",4, true));
        listofTechnics.add(new Phone(3, "Samsung",2, false));
        listofTechnics.add(new Car(4,"Toyota", true, false ));
        listofTechnics.add(new Car(5,"Honda", false, true ));
        listofTechnics.add(new Truck(6,"Kamaz", 6, true ));
        listofTechnics.add(new Truck(7,"Scania", 12, false ));

        return listofTechnics;
    }
    public static void  printTechnics(List<Technic> listofTechnics){
        for(int i=0;i< listofTechnics.size();i++){
           listofTechnics.get(i).printTechnic();
        }
    }
    public static List<Service> ListOfServices(){
        List<Service> listService= new ArrayList<Service>();
        listService.add(new PhoneService(0,"Телефонная"));
        listService.add(new ComputerService(1,"Компьютерная"));
        listService.add(new TruckService(2,"Грузовичная" ));
        listService.add(new CarService(3, "Машинная "));
        return listService;
    }

    public static void  printServices(List<Service> listService){
        for (Service service : listService) {
            service.printService();
        }
    }
*/
