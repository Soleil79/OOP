package Toys_shop;


import java.util.ArrayList;


public class Db {

    ArrayList<Toy> toys = new ArrayList<>();
    ArrayList<Age> ages = new ArrayList<>();
    ArrayList<Toy> winToys = new ArrayList<>();

    

    public Db (){
        
        ages.add(new Age(1, "Для школьников"));
        ages.add(new Age(2, "Для дошколят"));
       
    }
        
    public String getAllInfo(Toy toy) {

        return String.format(
            "id:%d, Наименование: %s, Целевой возраст: %s, Шанс выигрыша: %d, Количество: %s",
            toy.id,
            toy.name,
            this.ages.get(toy.age-1).age,
            toy.droprate,
            toy.quantity);

        }
    
    public String getMinInfo(Toy toy) {

        return String.format(
            "id:%d, Наименование: %s",
            toy.id,
            toy.name);

        }

        
    }