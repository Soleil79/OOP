using System;
using System.Text;
public class Person: Db {
       
    private int id;
    private String name;
    private int gender;
    private int birthdate;   
    private int birthPlace;
    private Person? mother;
    private Person? father;
   
    

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGender() {
        return gender;
    }

    public int getBirthdate() {
        return birthdate;
    }

    public int getBirthPlace() {
        return birthPlace;
    }


    public Person getMother() {
        return mother;
    }    
    
    public Person getFather() {
        return father;
    }

    

    public Person(int id, String name, int gender, int birthdate, int birthPlace, Person mother, Person father) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.birthPlace = birthPlace;
        this.mother = mother;
        this.father = father;
        
    }
   
    public Person(String name, int gender, int birthdate, int birthPlace) {
        this.id = 0;
        this.name = name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.birthPlace = birthPlace;
        this.mother = null;
        this.father = null;
        
        // this(0, name, gender, birthdate, birthPlace);

    }
 
    public void setId (int id){
        this.id = id;
    }
   
    public Person(int id, String name, int gender, int birthdate, int birthPlace) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.birthPlace = birthPlace;
        this.mother = null;
        this.father = null;

        // this(id, name, gender, birthdate, birthPlace);

    }

    

    public override String ToString(){
        StringBuilder sb = new StringBuilder();
        sb.Append("Имя: ");    
        sb.Append(name);
        sb.Append(" Год рождения: ");  
        sb.Append(birthdate);              
        sb.Append("\n");

        if (mother != null){
            sb.Append("\nМать: ");
            sb.Append(mother.toStringParents());
            // sb.Append("\n");
        }
        if (father != null){
            sb.Append("\nОтец: ");
            sb.Append(father.toStringParents());
            sb.Append("\n");
        }
        return sb.ToString();
    }

    public String toStringParents(){
        StringBuilder sb = new StringBuilder();
        sb.Append("Имя: ");    
        sb.Append(name);
        sb.Append(" Год рождения: ");  
        sb.Append(birthdate);
        sb.Append("\n");

        if (mother != null){
            sb.Append("Бабушка: ");
            sb.Append(mother.ToString());
            // sb.Append("\n");
        }
        if (father != null){
            sb.Append("Дедушка: ");
            sb.Append(father.ToString());
            sb.Append("\n");
        }
        return sb.ToString();
    }

}