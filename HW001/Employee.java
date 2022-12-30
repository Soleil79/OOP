package HW001;

public class Employee {
       
    int id;
    String name;
    int position;
    int birthdate;
    int salary;
    int phone;
    int residence;

    public Employee(int id, String name, int position, int birthdate, int salary, int phone, int residence) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.birthdate = birthdate;
        this.salary = salary;
        this.phone = phone;
        this.residence = residence;
        
    }
   
    public Employee(String name, int position, int birthdate, int salary, int phone, int residence) {
        this(0, name, position, birthdate, salary, phone, residence);

    }
 
    public void setId (int id){
        this.id = id;
    }

 
}