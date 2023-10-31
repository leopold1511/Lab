import Subpackage.Food;
import Subpackage.Man;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        String csvFile = "C:\\food.csv";
        String line;
        String csvSplitBy = ";";
        List<Food> products = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile), "WINDOWS-1251"));) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                String name = data[0];
                double proteins = Double.parseDouble(data[1]);
                double fats = Double.parseDouble(data[2]);
                double carbohydrates = Double.parseDouble(data[3]);
                Food product = new Food(name, proteins, fats, carbohydrates);
                products.add(product);
            }
        } catch (IOException e) {
            System.out.println("Ошибка в файле");
            System.exit(0);
        }


        Man[] people = {
                new Man("Наташа", 165, 55, 27, false, 2, 1500),
                new Man("Владлен", 192, 90, 35, true, 6, 2500),
                new Man("Степан", 183, 75, 22, true, 4, 2200),
                new Man("Елена", 170, 45, 19, false, 3, 1750)
        };
        for (int k = 0; k < people.length; k++) {
            System.out.printf("%d. %s, Возраст %d, Рост: %.0f, Вес: %.0f, Коэффициент активности: %.2f \n",
                    k, people[k].getName(), people[k].getAge(),
                    people[k].getHeight(), people[k].getWeight(),
                    people[k].getActivity());
        }
        menu(products, people);
    }


    public static void menu(List<Food> products, Man[] people) {
        Scanner scan = new Scanner(System.in);
        int size = products.size();
        System.out.printf(" Выберите номер опции: \n 1. Узнать Калории и DCI \n" +
                " 2. Очистить калории \n 3. Добавить калории \n 4. Закрыть программу \n");
        int count1 = 0;
        try {
            count1 = scan.nextInt();
        } catch (Exception e) {
            System.out.println("Неправильный выбор");
            menu(products, people);
        }

        int count2 = 0;
        int count3 = 0;
        switch (count1) {
            case 1:
                System.out.println("Введите id Человека");
                try {
                    count2 = scan.nextInt();
                } catch (Exception e) {
                    System.out.println("Неправильный выбор");
                    break;
                }
                if (count2 < 0 || count2 >= people.length) {
                    System.out.println("Неправильный выбор");
                    break;
                }
                System.out.printf("%d. %s, Калории: %.2f, DCI: %.2f ", count2, people[count2].getName(),
                        people[count2].getCalories(), people[count2].DCI());

                break;
            case 2:
                System.out.println("Введите id Человека");
                try {
                    count2 = scan.nextInt();
                } catch (Exception e) {
                    System.out.println("Неправильный выбор");
                    break;
                }
                if (count2 < 0 || count2 >= people.length) {
                    System.out.println("Неправильный выбор");
                    break;
                }
                people[count2].setCalories(0);
                System.out.println("Калории успешено очищены");
                break;
            case 3:
                System.out.println("Введите id Человека");
                try {
                    count2 = scan.nextInt();
                } catch (Exception e) {
                    System.out.println("Неправильный выбор");
                    break;
                }
                if (count2 < 0 || count2 >= people.length) {
                    System.out.println("Неправильный выбор");
                    break;
                }
                printFood(products);

                while (count3 != -1) {
                    int weight;
                    double calories;
                    System.out.println("Введите id блюда , чтобы выйти введите -1");
                    try {
                        count3 = scan.nextInt();
                    } catch (Exception e) {
                        System.out.println("Неправильный выбор");
                        break;
                    }
                    if ((count3 < 0 || count3 >= size) && count3!=-1) {
                        System.out.println("Неправильный выбор");
                    } else if (count3 != -1) {
                        System.out.println("Введите вес порции в граммах ");
                        weight = scan.nextInt();
                        calories = people[count2].getCalories();
                        calories += products.get(count3).calories(weight);
                        people[count2].setCalories(calories);
                    }
                }
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("Неправильный выбор");
                break;
        }
        menu(products, people);


    }

    public static void printFood(List<Food> products) {
        for (int k = 0; k < products.size(); k++) {
            System.out.printf("%d. %s: Белки %.1f , Жиры %.1f , Углеводы %.1f \n",
                    k, products.get(k).getName(), products.get(k).getProteins(),
                    products.get(k).getFats(), products.get(k).getCarbohydrates());

        }
    }


}