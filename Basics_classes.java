class ChaiShop{
    String Branch_name;
    int Cups_sold;
    
    // method inside the class
    public void sample_method(){
        System.out.println("This is method inside the ChaiShop class");
    }
}

class Basics_classes{
    public static void main(String[] args){
        //Object creation
        ChaiShop Branch1 = new ChaiShop();

        //Calling the method inside the class
        Branch1.sample_method();
        //assigning Branch name
        Branch1.Branch_name="Tea Time";
        //assigning Cups sold
        Branch1.Cups_sold=100;
        //Print Values
        System.out.println("Branch name: "+Branch1.Branch_name);
        System.out.println("Cups sold: "+Branch1.Cups_sold);


        //Creating Another object branch 2
        ChaiShop Branch2 = new ChaiShop();
        Branch2.sample_method();

        Branch2.Branch_name="Chai Time";
        Branch2.Cups_sold=200;

        System.out.println("Branch name: "+Branch2.Branch_name);
        System.out.println("Cups sold: "+Branch2.Cups_sold);
        

}   
}
