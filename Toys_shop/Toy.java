package Toys_shop;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Calendar;

public class Toy {
       
    int id;
    String name;
    int age;
    int droprate;
    int quantity;
    java.util.Date date;
   

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

    public Toy(int id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.date = date;

    }


    public void setId (int id){
        this.id = id;
    }

 
}