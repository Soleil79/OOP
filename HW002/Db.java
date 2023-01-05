package HW002;


import java.util.ArrayList;


public class Db {

    ArrayList<Person> persons = new ArrayList<>();
    ArrayList<Gender> gender = new ArrayList<>();
    ArrayList<BirthPlace> birthPlaces = new ArrayList<>(); 

    

    public Db (){
        
        birthPlaces.add(new BirthPlace(1, "Москва"));
        birthPlaces.add(new BirthPlace(2, "Санкт-Петербург"));
        birthPlaces.add(new BirthPlace(3, "Екатеринбург"));
        birthPlaces.add(new BirthPlace(4, "Саратов"));
        birthPlaces.add(new BirthPlace(5, "Воронеж"));

        gender.add(new Gender(1, "муж"));
        gender.add(new Gender(2, "жен"));
       
    }
        
    public String getAllInfo(Person per) {

        return String.format(
            "id:%d, ФИО: %s, Должность: %s, год рождения: %s, зарплата тыс.руб: %s, телефон: %s, место проживания: %s",
            per.getId(),
            per.getName(),
            this.gender.get(per.getGender()-1).gender,
            per.getBirthdate(),
            per.getMother(),
            per.getFather(),
            this.birthPlaces.get(per.getBirthPlace() - 1).city);

        }


    }