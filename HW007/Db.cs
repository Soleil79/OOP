using System;
using System.Collections.Generic;



public class Db {

    List<Person> persons = new List<Person>();
    List<Gender> genders = new List<Gender>();
    List<BirthPlace> birthPlaces = new List<BirthPlace>(); 

    

    public Db (){
        
        birthPlaces.Add(new BirthPlace(1, "Москва"));
        birthPlaces.Add(new BirthPlace(2, "Санкт-Петербург"));
        birthPlaces.Add(new BirthPlace(3, "Екатеринбург"));
        birthPlaces.Add(new BirthPlace(4, "Саратов"));
        birthPlaces.Add(new BirthPlace(5, "Воронеж"));

        genders.Add(new Gender(1, "муж"));
        genders.Add(new Gender(2, "жен"));
       
    }
        
    public String getAllInfo(Person per) {

        return String.Format(
            "id:%d, ФИО: %s, Должность: %s, год рождения: %s, зарплата тыс.руб: %s, телефон: %s, место проживания: %s",
            per.getId(),
            per.getName(),
            this.genders[per.getGender()-1],
            per.getBirthdate(),
            per.getMother(),
            per.getFather(),
            this.birthPlaces[per.getBirthPlace() - 1]);

        }


    }