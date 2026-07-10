package Constructor;
class A{
    public A(){// Method Overloading Because same method name but different parameters
        System.out.println("in A");
    }
    public A(int n){// Method Overloading Because same method name but different parameters
        System.out.println("In Int A");
    }
}
class B extends A{
    public B(){
        System.out.println("in B");
    }

    public B(int n){
        this();
        System.out.println("In Int B");
    }
}
public class Basics {
    public static void main(String[] args){
        B obj = new B(10);
    }
}
