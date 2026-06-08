class Shop{
    String Branch_name;
    int Cups_sold;

    //constructor
    public Shop(String bn , int cs){
        System.out.println("This is constructor");
        System.out.println("Branch name: "+bn);
        System.out.println("Cups sold: "+cs);
    }

    // method inside the class
    public void sample_method(){
        System.out.println("This is method inside the ChaiShop class");
    }
}

public class construcor{
    
    public static void main(String[] args){
        //Object creation
        Shop Branch1 = new Shop("Tea Time" , 100);
        Shop Branch2 = new Shop("Tea Fun" , 600);
}   
}

