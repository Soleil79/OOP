package HW001;


import java.util.ArrayList;


public class Db {

    ArrayList<Employee> employees = new ArrayList<>();
    ArrayList<Position> positions = new ArrayList<>();
    ArrayList<Residence> residences = new ArrayList<>(); 

    

    public Db (){
        
        residences.add(new Residence(1, "Москва"));
        residences.add(new Residence(2, "Санкт-Петербург"));
        residences.add(new Residence(3, "Екатеринбург"));
        residences.add(new Residence(4, "Саратов"));

        positions.add(new Position(1, "Директор"));
        positions.add(new Position(2, "Бухгалтер"));
        positions.add(new Position(3, "Стилист"));
        positions.add(new Position(4, "Парикмахер"));
        positions.add(new Position(5, "Ресепшионист"));
    }
        
    public String getAllInfo(Employee em) {

        return String.format(
            "id:%d, ФИО: %s, Должность: %s, год рождения: %s, зарплата тыс.руб: %s, телефон: %s, место проживания: %s",
            em.id,
            em.name,
            this.positions.get(em.position-1).post,
            em.birthdate,
            em.salary,
            em.phone,
            this.residences.get(em.residence - 1).city);

        }


    }