package Subpackage;

public class Man {
    private String name;
    private double height;
    private double weight;
    private int age;
    private boolean gender;
    private int activity;
    private double calories;
    private int id;
    public Man( String name, double height,double weight, int age, boolean gender, int activity, double calories) {
        this.name = name;
        this.height=height;
        this.weight=weight;
        this.age=age;
        this.gender=gender;
        if(activity>=0 && activity<=6) this.activity = activity;
        else this.activity=0;
        this.calories=calories;
    }
    public double getActivity() {
        double k;
        switch (this.activity) {
            case 0:
                k= 1.2;
                break;
            case 1:
                k= 1.38;
                break;
            case 2:
                k=1.46;
                break;
            case 3:
                k=1.55;
                break;
            case 4:
                k=1.64;
                break;
            case 5:
                k=1.73;
                break;
            case 6 :
                k=1.9;
                break;
            default:
                k=1.2;
        }
        return k;
    }
    public double DCI(){
        double DCI;
        DCI=(this.weight*10 + this.height*6.25-this.age*5);
        if(this.gender) DCI+=5;
        else DCI-=165;
        DCI*=getActivity();
        return DCI;

    }


    public boolean getGender() {
        return gender;
    }
    public void setGender(boolean gender) {
        this.gender = gender;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) { this.age = age;}
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public boolean isGender() {
        return gender;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }
}
