package Encapsulation;

class Demo{
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class AdvEnc {
    public static void main(String[] args){
        Demo obj1 = new Demo();
        obj1.setAge(60);
        obj1.setName("Darlz");

        System.out.println(obj1.getName() + " :" + obj1.getAge());
    }
}
