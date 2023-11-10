import Services.Auto.CarService;
import Services.Auto.TruckService;
import Services.ComputingTechnics.ComputerService;
import Services.ComputingTechnics.ComputingTechnicsServices;
import Services.ComputingTechnics.PhoneService;
import Services.Service;
import Technics.ComputerTechnics.Computer;
import Technics.ComputerTechnics.Phone;
import Technics.Technic;
import Technics.Transport.Car;
import Technics.Transport.Truck;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      menu();
        }

    public static void menu(){
        List<Technic> listofTechnics= ListOfTechnics();
        List<Service> listService= ListOfServices();
        Scanner scanner=new Scanner(System.in);
        int i=0;
        while(i!=10){
           System.out.println("Главное меню");
           System.out.println("1. Посмотреть список техники");
           System.out.println("2. Посмотреть список сервисов");
           System.out.println("3. Сломать технику");
            System.out.println("4. Починить технику");
           i= scanner.nextInt();
           switch (i){
               case 1 :
                   printTechnics(listofTechnics);
                   break;
               case 2:
                   printServices(listService);
                   break;
               case 3:
                   System.out.println("Введите id техники");
                   int k;
                   k = scanner.nextInt();
                   if (listofTechnics.get(k).getCondition()==false) System.out.println("То что мертво умереть не может");
                   else listofTechnics.get(k).toBreak();
                   break;
               case 4:
                   System.out.println("Введите id техники");
                   k = scanner.nextInt();
                   if(listofTechnics.get(k).getCondition()==true) System.out.println("Всё и так в порядке");
                   else if(listofTechnics.get(k) instanceof Car){
                       System.out.println("Направляем в машинную");
                       for( int count=0;count< listService.size();count++ ){
                           if (listService.get(count) instanceof CarService)  listService.get(count).repair(listofTechnics.get(k));
                       }
                   System.out.println("Успешно починено");
                   }
                   else if(listofTechnics.get(k) instanceof Truck){
                       System.out.println("Направляем в грузовичную");
                       for( int count=0;count< listService.size();count++ ){
                           if (listService.get(count) instanceof TruckService)  listService.get(count).repair(listofTechnics.get(k));
                       }
                       System.out.println("Успешно починено");
                   }
                   else if(listofTechnics.get(k) instanceof Phone){
                       System.out.println("Направляем в телефонную");
                       for( int count=0;count< listService.size();count++ ){
                           if (listService.get(count) instanceof PhoneService)  listService.get(count).repair(listofTechnics.get(k));
                       }
                       System.out.println("Успешно починено");
                   }
                   else if(listofTechnics.get(k) instanceof Computer){
                       System.out.println("Направляем в компьютерную");
                       for( int count=0;count< listService.size();count++ ){
                           if (listService.get(count) instanceof ComputerService)  listService.get(count).repair(listofTechnics.get(k));
                       }
                       System.out.println("Успешно починено");
                   }
                   break;
               default:
                   System.exit(0);
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
        for(int i=0;i<listService.size();i++){
            listService.get(i).printService();
        }
    }






}