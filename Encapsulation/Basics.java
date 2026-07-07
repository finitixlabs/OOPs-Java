package Encapsulation;

class Human{
    //int age
    //String name
    // these are without restrictions so everyone can access so less secure
    private int age = 20; //these are can access inside the class if you want to access they use method for outside the class
    private String name = "john"; //  you can assign values here the 1st way

    public int getAge(){
        return age;
    }
    public String getName(){
        return name;
    }
}

public class Basics {
    public static void main(String[] args){
        Human obj = new Human();
        int a = obj.getAge();
        String b = obj.getName();
        System.out.println(b + ":"+ a);
    }
}
