package HW001;

public class Employee {
    private Db db;
    
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

    public String getAllInfo(Employee em) {

        return String.format(
                "id:%d, ФИО: %s, Должность: %s, год рождения: %s, зарплата тыс.руб: %s, телефон: %s, место проживания: %s",
                em.id,
                em.name,
                db.positions.get(em.position - 1).post,
                em.birthdate,
                em.salary,
                em.phone,
                db.residences.get(em.residence - 1).city);

    }
 
}