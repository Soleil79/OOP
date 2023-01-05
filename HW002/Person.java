package HW002;

public class Person {
       
    private int id;
    private String name;
    private int gender;
    private int birthdate;   
    private int birthPlace;
    private Person mother;
    private Person father;
   
    

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
        this(0, name, gender, birthdate, birthPlace, null, null);

    }
 
    public void setId (int id){
        this.id = id;
    }
   
    public Person(int id, String name, int gender, int birthdate, int birthPlace) {
        this(id, name, gender, birthdate, birthPlace, null, null);

    }

    

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ");    
        sb.append(name);
        sb.append(" Год рождения: ");  
        sb.append(birthdate);              
        sb.append("\n");

        if (mother != null){
            sb.append("\nМать: ");
            sb.append(mother.toStringParents());
            // sb.append("\n");
        }
        if (father != null){
            sb.append("\nОтец: ");
            sb.append(father.toStringParents());
            sb.append("\n");
        }
        return sb.toString();
    }

    public String toStringParents(){
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ");    
        sb.append(name);
        sb.append(" Год рождения: ");  
        sb.append(birthdate);
        sb.append("\n");

        if (mother != null){
            sb.append("Бабушка: ");
            sb.append(mother.toString());
            // sb.append("\n");
        }
        if (father != null){
            sb.append("Дедушка: ");
            sb.append(father.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
 
}