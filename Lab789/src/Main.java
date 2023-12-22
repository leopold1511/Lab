import Services.Auto.CarService;
import Services.Auto.TruckService;
import Services.ComputingTechnics.ComputerService;
import Services.ComputingTechnics.PhoneService;
import Services.Service;
import Technics.ComputerTechnics.Computer;
import Technics.ComputerTechnics.Phone;
import Technics.Technic;
import Technics.Transport.Car;
import Technics.Transport.Truck;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        menuLab();
    }
    public static void menuLab(){
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


    public static void GUI(){
        ServiceGUI simpleServiceGUI = new ServiceGUI();
        simpleServiceGUI.setVisible(true);
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
                   else if(listofTechnics.get(k) instanceof Car){
                       System.out.println("Направляем в машинную");
                       for(  count=0;count< listService.size();count++ ){
                           if (listService.get(count) instanceof CarService){
                               listService.get(count).repair(listofTechnics.get(k));
                               break;
                           }
                       }
                   System.out.println("Успешно починено");
                   }
                   else if(listofTechnics.get(k) instanceof Truck){
                       System.out.println("Направляем в грузовичную");
                       for(  count=0;count< listService.size();count++ ){
                           if (listService.get(count) instanceof TruckService) {
                               listService.get(count).repair(listofTechnics.get(k));
                               break;
                           }
                       }
                       System.out.println("Успешно починено");
                   }
                   else if(listofTechnics.get(k) instanceof Phone){
                       System.out.println("Направляем в телефонную");
                       for(  count=0;count< listService.size();count++ ){
                           if (listService.get(count) instanceof PhoneService){
                               listService.get(count).repair(listofTechnics.get(k));
                                    break;
                           }
                       }
                       System.out.println("Успешно починено");
                   }
                   else if(listofTechnics.get(k) instanceof Computer){
                       System.out.println("Направляем в компьютерную");
                       for(  count=0;count< listService.size();count++ ){
                           if (listService.get(count) instanceof ComputerService) {
                               listService.get(count).repair(listofTechnics.get(k));
                               break;
                           }
                       }
                       System.out.println("Успешно починено");
                   }
                   history.add(listService.get(count).getName() + " Id техники " + listofTechnics.get(k).getId());
                   break;
               case 5:
                   System.out.println("История:");
                   for(count=0;count< history.size();count++){
                       System.out.println(history.get(count));
                   }
                   break;
                case 6:
                    //System.exit(0);
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






}