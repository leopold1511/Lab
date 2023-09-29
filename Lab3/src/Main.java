import Subpackage.Food;
import Subpackage.Man;

public class Main {
    public static void main(String[] args) {
        Food[] dinner=new Food[4];
        dinner[0]=new Food("Vinegret",1.7*1.5,10.3*1.5,8.2*1.5);
        dinner[1]=new Food("Solyanka",5.2*3,4.6*3,1.7*3);
        dinner[2]=new Food("White rice",2.2*2,0.5*2,24.9*2);
        dinner[3]=new Food("Fried pork",11.4*2,49.3*2,0);
        Food[] supper=new Food[3];
        supper[0]=new Food("Caesar",4.8*1.5,17.2*1.5,24*1.5);
        supper[1]=new Food("Fried potato",3.7*2,10.6*2,24.8*2);
        supper[2]=new Food("Boiled duck",19.7*2,18.8*2,0);
        Man[] people=new Man[2];
        people[0]=new Man("Наташа",165, 55, 27,false, 2 );
        people[1]=new Man("Владлен",192, 90, 35, true,6 );
        double TotalCalories=0;
        for(int count=0; count<4; count++){
            if (count!=3) {
                TotalCalories+=dinner[count].calories();
                TotalCalories+=supper[count].calories();
            }
            else TotalCalories+=dinner[count].calories();
        }
        TotalCalories=Math.ceil(TotalCalories);
        System.out.println("Потреблено калорий :" + TotalCalories );
        for(int count=0;count<2;count++){
            System.out.println("DCI " + people[count].getName() +" " + people[count].DCI());
            if(TotalCalories>=people[count].DCI()) System.out.println(people[count].getName() + " переел(а) на " +
                     (TotalCalories-people[count].DCI()) + " калорий");
            else System.out.println(people[count].getName() + " недоел(а) на " +
                    (-TotalCalories+people[count].DCI()) + " калорий");

        }



    }
}