package Toys_shop;


public class Toy {
       
    int id;
    String name;
    int age;
    int droprate;
    int quantity;
    
   

    public Toy(int id, String name, int age, int droprate, int quantity) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.droprate = droprate;
        this.quantity = quantity;
               
    }
   
    public Toy(String name, int age, int droprate, int quantity) {
        this(0, name, age, droprate, quantity);

    }

    public Toy(int id, String name) {
        this.id = id;
        this.name = name;
      
    }


    public void setId (int id){
        this.id = id;
    }
    
 

 
}